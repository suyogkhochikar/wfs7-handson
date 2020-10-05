package com.hsbc.dao;

import java.util.ArrayList;
import com.hsbc.model.Employee;

public class EmployeeDao {
	
	ArrayList<Employee> emp = new ArrayList<>();
	
	
	public void addEmployee(Employee e) {
		emp.add(e);
		System.out.println("Employee added");
	}


	public ArrayList<Employee> getEmployees() {
		return emp;
	}


	public ArrayList<Employee> getTop3Employees(ArrayList<Employee> empList) {
		ArrayList<Employee> result = new ArrayList<>();
		
		if (empList.size() > 2) {
			for (int i = 0; i < 3; i++) {
				result.add(empList.get(i));
			}
		} else {
			for (Employee e : empList) {
				result.add(e);
			}
		}
		return result;
	}

}
