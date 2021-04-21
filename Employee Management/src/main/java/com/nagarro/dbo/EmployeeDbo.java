package com.nagarro.dbo;

import java.util.List;

import com.nagarro.dto.Employee;

public interface EmployeeDbo {
	
	public List<Employee> getEmployees();
	
	public Employee getEmployee(long empCode);
	
	public void addEmployee(Employee employee);
	
	public void updateEmployee(Employee employee);
}
