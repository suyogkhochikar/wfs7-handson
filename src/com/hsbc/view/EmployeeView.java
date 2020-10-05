package com.hsbc.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.hsbc.dao.EmployeeDao;
import com.hsbc.model.Employee;

public class EmployeeView {

	public static void main( String[] args) {
		EmployeeDao empImplObj = new EmployeeDao();

		Scanner sc = new Scanner(System.in);
		int opt = -1;
		do {
			System.out.println("Select a option:\n1.Enter Employee\n2.Sort and Dispay\n3.Exit");
			opt = sc.nextInt();

			switch (opt) {
			case 1:
				System.out.println("Enter id");
				int id = sc.nextInt();
				System.out.println("Enter name");
				String name = sc.next();
				System.out.println("Enter salary");
				double salary = sc.nextDouble();
				System.out.println("Enter birthdate (yyyy-MM-dd)");
				String dob = sc.next();
				LocalDate dateOfBirth = LocalDate.parse(dob, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				empImplObj.addEmployee(new Employee(id, name, salary, dateOfBirth));
				break;

			case 2:

				System.out.println("Sort by?:\n1.ID\n2.Name\n3.Salary\n4.Date of birth");
				int opt2 = sc.nextInt();
				ArrayList<Employee> tempEmp = null, result = null;

				switch (opt2) {
				case 1:
					tempEmp = empImplObj.getEmployees();
					Collections.sort(tempEmp, (a, b) -> a.getEmployeeID() - b.getEmployeeID());
					System.out.println("Ascending order display:");
					result = empImplObj.getTop3Employees(tempEmp);
					for (Employee e : result) {
						System.out.println(e);
					}

					Collections.sort(tempEmp, (a, b) -> b.getEmployeeID() - a.getEmployeeID());
					System.out.println("Descending order display:");
					result = empImplObj.getTop3Employees(tempEmp);
					for (Employee e : result) {
						System.out.println(e);
					}

					break;
				case 2:
					tempEmp = empImplObj.getEmployees();
					Collections.sort(tempEmp, (a, b) -> a.geteName().compareTo(b.geteName()));
					System.out.println("Ascending order display:");
					result = empImplObj.getTop3Employees(tempEmp);
					for (Employee e : result) {
						System.out.println(e);
					}

					Collections.sort(tempEmp, (a, b) -> b.geteName().compareTo(a.geteName()));
					System.out.println("Descending order display:");
					result = empImplObj.getTop3Employees(tempEmp);
					for (Employee e : result) {
						System.out.println(e);
					}

					break;

				case 3:
					tempEmp = empImplObj.getEmployees();
					Collections.sort(tempEmp, (a, b) -> {
						double res = a.geteSalary() - b.geteSalary();
						if (res > 0)
							return 1;
						else if (res < 0)
							return -1;
						else
							return 0;
					});

					System.out.println("Ascending order display:");
					result = empImplObj.getTop3Employees(tempEmp);
					for (Employee e : result) {
						System.out.println(e);
					}

					Collections.sort(tempEmp, (a, b) -> {
						double res = b.geteSalary() - a.geteSalary();
						if (res > 0)
							return 1;
						else if (res < 0)
							return -1;
						else
							return 0;
					});
					System.out.println("Descending order display:");
					result = empImplObj.getTop3Employees(tempEmp);
					for (Employee e : result) {
						System.out.println(e);
					}

					break;

				case 4:
					tempEmp = empImplObj.getEmployees();
					Collections.sort(tempEmp, (a, b) -> a.geteDOB().compareTo(b.geteDOB()));
					System.out.println("Ascending order display:");
					result = empImplObj.getTop3Employees(tempEmp);
					for (Employee e : result) {
						System.out.println(e);
					}

					Collections.sort(tempEmp, (a, b) -> b.geteDOB().compareTo(a.geteDOB()));
					System.out.println("Descending order display:");
					result = empImplObj.getTop3Employees(tempEmp);
					for (Employee e : result) {
						System.out.println(e);
					}

					break;

				default:
					break;
				}
				break;

			case 3:
				System.exit(0);
				break;
			default:
				break;
			}
		} while (opt != 3);

	}
}