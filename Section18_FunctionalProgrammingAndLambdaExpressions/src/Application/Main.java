package Application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Entities.Employee;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full file path: ");
        String path = sc.next();
        System.out.print("Enter salary: ");
        Double salaryInput = sc.nextDouble(); 

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            
            String line = br.readLine();
            List<Employee> staff = new ArrayList<>();

            while(line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                String email = fields[1];
                Double salary = Double.parseDouble(fields[2]);

                staff.add(new Employee(name, email, salary));
                line = br.readLine();
            }

            System.out.printf("Email of people whose salary is more than %.2f:\n", salaryInput);
            List<String> emails = staff.stream()
                                    .filter(e -> e.getSalary() > salaryInput)
                                    .sorted(Comparator.comparing(Employee::getName))
                                    .map(Employee::getEmail)
                                    .collect(Collectors.toList());

            emails.forEach(System.out::println);

            double sum = staff.stream()
                            .filter(e -> e.getName().charAt(0) == 'M')
                            .map(e -> e.getSalary())
                            .reduce(0.0, (x, y) -> x + y);

            System.out.println("Sum of salary of people whose name starts with 'M': " + sum);

        } catch (Exception e) {
            e.getMessage();
        }

        sc.close();

    }
}
