package com.nagarro.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.nagarro.apiclient.EmployeeClient;
import com.nagarro.apiclient.EmployeeClientImpl;
import com.nagarro.dao.UserDao;
import com.nagarro.dao.UserDaoImpl;
import com.nagarro.services.EmployeeService;
import com.nagarro.services.UserService;

@Configuration
public class AppConfig {
	
	@Bean
	public UserDao getUserDao() {
		return new UserDaoImpl();
	}
	
	@Bean
	public UserService getUser(){
		return new UserService();
	}
	
	@Bean 
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	
	@Bean
	public EmployeeClient getEmployeeClient(){
		return new EmployeeClientImpl();
	}
	
	@Bean
	public EmployeeService getEmployee(){
		return new EmployeeService();
	}
}
