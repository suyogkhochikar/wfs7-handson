package com.hsbc.model;

import java.time.LocalDate;

public class Employee {
	
	private int employeeID;
	private String eName;
	private double eSalary;
	private LocalDate eDOB;
	
	public Employee(int employeeID, String eName, double eSalary, LocalDate eDOB) {
		super();
		this.employeeID = employeeID;
		this.eName = eName;
		this.eSalary = eSalary;
		this.eDOB = eDOB;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public double geteSalary() {
		return eSalary;
	}

	public void seteSalary(double eSalary) {
		this.eSalary = eSalary;
	}

	public LocalDate geteDOB() {
		return eDOB;
	}

	public void seteDOB(LocalDate eDOB) {
		this.eDOB = eDOB;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", eName=" + eName + ", eSalary=" + eSalary + ", eDOB=" + eDOB
				+ "]";
	}
	
}
