package com.example.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})

public class EmployeeProjectApplication implements CommandLineRunner {
	@Autowired
	EmployeeRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(EmployeeProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Employee("Chinmaya",5000,1805707,"Iron Mountain"));
		repository.save(new Employee("Sohan",4000,1805706,"Iron Mountain"));
		repository.save(new Employee("Sipra",3000,1805705,"Iron Mountain"));
		repository.save(new Employee("Amit",2000,1805704,"Iron Mountain"));
		repository.save(new Employee("Abhijeet",1000,1805702,"Iron Mountain"));
		repository.save(new Employee("Upaj",1500,1805701,"Iron Mountain"));		
	}

}
