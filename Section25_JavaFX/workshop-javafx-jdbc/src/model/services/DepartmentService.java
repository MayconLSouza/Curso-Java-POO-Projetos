package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Department;

public class DepartmentService {
	
	public List<Department> findAll() {
		List<Department> list = new ArrayList<>();
		list.add(new Department(1, "HR"));
		list.add(new Department(2, "IT"));
		list.add(new Department(3, "R&D"));
		list.add(new Department(4, "Accounting"));
		
		return list;
	}
}
