package com.nagarro.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.supercsv.io.ICsvBeanWriter;

import com.nagarro.apiclient.EmployeeClient;
import com.nagarro.constant.Constants;
import com.nagarro.dto.Employee;
import com.nagarro.utils.CSVUtil;

public class EmployeeService {
	
	@Autowired
    private EmployeeClient employeeClient;

    public List<Employee> getAllEmployees() {
        return employeeClient.getAllEmployees();
    }

    public void addAllEmployees(MultipartFile file) {
        List<Employee> employees = CSVUtil.getParsedData(file);
        if (employees != null) {
            employeeClient.addAllEmployees(employees);
        }
    }

    public void updateEmployee(Employee employee) {
        employeeClient.updateEmployee(employee);
    }

    public void addEmployeeDetailsToFile(ICsvBeanWriter csvBeanWriter) throws IOException {
        List<Employee> employees = this.getAllEmployees();
//        for(Employee employee: employees){
//        	System.out.println(employee.getId());
//        }
        csvBeanWriter.writeHeader(Constants.DISPLAY_HEADER);
        for (Employee employee : employees) {
            csvBeanWriter.write(employee, Constants.BEAN_HEADER);
        }
    }
    
}
