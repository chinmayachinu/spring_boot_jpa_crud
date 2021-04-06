package com.example.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Column(name = "employeeName")
	private String employeeName;
	
	@Column(name = "employeeSalary")
	private int employeeSalary;
	
	@Id
	private long employeeId;
	
	@Column(name = "employeeProject")
	private String employeeProject;
	
	public Employee() {
	}

	public Employee(String employeeName, int employeeSalary, long employeeId, String employeeProject) {
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.employeeId = employeeId;
		this.employeeProject = employeeProject;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeProject() {
		return employeeProject;
	}

	public void setEmployeeProject(String employeeProject) {
		this.employeeProject = employeeProject;
	}

	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeSalary=" + employeeSalary + ", employeeId="
				+ employeeId + ", employeeProject=" + employeeProject + "]";
	}

}
