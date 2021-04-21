package com.nagarro.apiclient;

import com.nagarro.constant.Constants;
import com.nagarro.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class EmployeeClientImpl implements EmployeeClient {

    @Autowired
    RestTemplate restTemplate;

    /**
     * get all employees via rest template
     *
     * @return
     */
    public List<Employee> getAllEmployees() {
        List<Employee> employees;
        String url = Constants.REST_API_URI + Constants.GET_ALL_EMPLOYEES;
        ResponseEntity<List<Employee>> response = restTemplate.exchange(
				                url,
				                HttpMethod.GET,
				                null,
				                new ParameterizedTypeReference<List<Employee>>() {});
        employees = response.getBody();
        return employees;
    }

    /**
     * to add employee
     *
     * @param employee
     */
    public void addEmployee(Employee employee) {
        String url = Constants.REST_API_URI + Constants.POST_EMPLOYEE;
        restTemplate.postForObject(url, employee, Employee.class);
    }

    /**
     * to add all employees from CSV file
     *
     * @param employees
     */
    public void addAllEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            this.addEmployee(employee);
        }
    }

    /**
     * Rest template to call update end point to update employee
     * @param employee
     */
    public void updateEmployee(Employee employee) {
        String url = Constants.REST_API_URI + Constants.PUT_EMPLOYEE;
        restTemplate.put(url, employee);
    }

}