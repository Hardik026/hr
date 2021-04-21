package com.nagarro.controllers;

import com.nagarro.dto.Employee;
import com.nagarro.service.EmployeeService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class EmployeeController {

    private EmployeeService employeeService = new EmployeeService();

    @GET
    @Path("/employees")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees;
    }

    @GET
    @Path("/employees/{employeeCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployee(@PathParam("employeeCode") long employeeCode) {
        Employee employee = employeeService.getEmployee(employeeCode);
        return employee;
    }

    @POST
    @Path("/employees")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public void addEmployee(Employee employee) {
        employeeService.addEmployee(employee);
    }

    @PUT
    @Path("/employees")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public void updateEmployee(Employee employee) {
        employeeService.updateEmployee(employee);
    }

}
