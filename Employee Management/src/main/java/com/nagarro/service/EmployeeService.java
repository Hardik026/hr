package com.nagarro.service;

import com.nagarro.dbo.EmployeeDbo;
import com.nagarro.dboimpl.EmployeeDboImpl;
import com.nagarro.dto.Employee;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    EmployeeDbo employeeDbo = new EmployeeDboImpl();

    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = employeeDbo.getEmployees();
        if (employeeList == null) {
            System.err.println("Empty List found!");
        }
        return employeeList;
    }

    public void addEmployee(Employee employee) {
        employeeDbo.addEmployee(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeDbo.updateEmployee(employee);
    }

    public Employee getEmployee(long empCode) {
        Employee employee = (Employee) employeeDbo.getEmployee(empCode);
        if (employee == null) {
            System.err.println("Employee not found!");
        }
        return employee;
    }


}
