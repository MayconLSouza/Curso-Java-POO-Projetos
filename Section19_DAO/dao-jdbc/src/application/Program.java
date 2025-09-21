package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = 0;
		
		while ( (n != 1) && (n != 2)) {
			System.out.println("1 - Seller");
			System.out.println("2 - Department");
			System.out.print("Perform Test Execution: ");
			n = sc.nextInt();
		}
		
		if (n == 1) {
			sellerTestExecution();
		} else if (n == 2) {
			departmentTestExecution();
		} 
		
		sc.close();
		
	}

	private static void sellerTestExecution() {
		
		SellerDaoJDBC sellerDao = DaoFactory.createSellerDao();
		Seller s = null;
		List<Seller> sellers = new ArrayList<>();
		
		System.out.println("\n*** TEST CASE 1 - seller(s) findByDepartment ***");
		Department department = new Department(1, null);
		sellers = sellerDao.findByDepartment(department.getId()); 
		for(Seller seller : sellers) {
			System.out.println(seller);
		}
		
		System.out.println("\n*** TEST CASE 2 - seller insert and findById ***");
		s = new Seller(null, "John Doe", "john.doe@email.com", LocalDate.of(1990, 05, 29), 4000.00, department);
		sellerDao.insert(s);
		int id = s.getId();
		System.out.println("Inserted! New id = " + id);
		s = sellerDao.findById(id); 
		System.out.println(s);
		
		System.out.println("\n*** TEST CASE 3 - seller update and findById ***");
		s = sellerDao.findById(id);
		s.setBaseSalary(s.getBaseSalary() * 1.1);
		sellerDao.update(s);
		System.out.println("Update completed!");
		s = sellerDao.findById(id); 
		System.out.println(s);
		
		System.out.println("\n*** TEST CASE 4 - seller delete and findAll ***");
		sellerDao.deleteById(id);
		System.out.println("Delete completed!");
		sellers = sellerDao.findAll(); 
		for(Seller seller : sellers) {
			System.out.println(seller);
		}
		
	}
	
	private static void departmentTestExecution() {
		
		DepartmentDaoJDBC departmentDao = DaoFactory.createDepartmentDao();
		Department dep = null;
		List<Department> departments = new ArrayList<>();
		
		System.out.println("\n*** TEST CASE 1 - department insert and findById ***");
		dep = new Department(null, "Development");
		departmentDao.insert(dep);
		int id = dep.getId();
		System.out.println("Inserted! New id = " + id);
		dep = departmentDao.findById(id); 
		System.out.println(dep);
		
		System.out.println("\n*** TEST CASE 3 - department update and findById ***");
		dep.setName("Software Quality Assurance");
		departmentDao.update(dep);
		System.out.println("Update completed!");
		dep = departmentDao.findById(id); 
		System.out.println(dep);
		
		System.out.println("\n*** TEST CASE 5 - department delete and findAll ***");
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		departments = departmentDao.findAll(); 
		for(Department department : departments) {
			System.out.println(department);
		}
		
	}

}
