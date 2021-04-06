package com.example.employee.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

@RestController


public class EmployeeController {
	@Autowired
    private EmployeeService service;
	  @GetMapping("/employee")
	    public ResponseEntity<List<Employee>> findAll() {
	        return ResponseEntity.ok(service.findAll());
	    }
	  @PostMapping("/employee")
	    public ResponseEntity<Employee> create(@Valid @RequestBody Employee employee) {
	        return ResponseEntity.ok(service.save(employee));
	    }
	  @GetMapping("/{id}")
	    public ResponseEntity<Employee> findById(@PathVariable Long id) {
	        Optional<Employee> employee = service.findById(id);

	        return ResponseEntity.ok(employee.get());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Employee> update(@PathVariable Long id, @Valid @RequestBody Employee employee) {
	        Optional<Employee> employeeData = service.findById(id);

	        if (employeeData.isPresent()) {
	        	Employee _employee = employeeData.get();
	        	_employee.setEmployeeName(employee.getEmployeeName());
	        	_employee.setEmployeeProject(employee.getEmployeeProject());
	        	_employee.setEmployeeSalary(employee.getEmployeeSalary());
	          return new ResponseEntity<>(service.save(_employee), HttpStatus.OK);
	        } else {
	          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }

	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id) {
	      try {
	        service.deleteById(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	      }
	    }
	    @DeleteMapping("/employees")
	    public ResponseEntity<HttpStatus> deleteAllEmployees() {
	      try {
	        service.deleteAll();
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	      }

	    }
}
