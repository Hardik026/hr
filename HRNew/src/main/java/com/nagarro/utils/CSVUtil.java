package com.nagarro.utils;

import com.nagarro.constant.Constants;
import com.nagarro.dto.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sanchitdwivedi
 */
public class CSVUtil {

    public static List<Employee> getParsedData(MultipartFile file) {

        List<Employee> employees = new ArrayList<Employee>();
        try {
        	BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            String row = null;
            String[] data = null;
            Employee employee;
            boolean firstRow = true;
            while ((row = reader.readLine()) != null) {
                if (firstRow) {
                    firstRow = false;
                } else {
                    data = row.split(Constants.CSV_SEPERATOR);
                    employee = new Employee();
                    employee.setEmployeeCode(Long.valueOf(data[0]));
                    employee.setEmployeeName(data[1]);
                    employee.setLocation(data[2]);
                    employee.setEmail(data[3]);
                    employee.setDateOfBirth(data[4]);
                    employees.add(employee);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

}