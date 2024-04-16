package com.project.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.www.Model.Employee;
import com.project.www.exception.ResourceNotFoundException;
import com.project.www.repo.EmployeeRepository;

@Service
public class EmployeeService 
{
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees()
	{

		return employeeRepository.findAll();
	}
	
	
	public Employee createEmployee( Employee employee)
	{
		return employeeRepository.save (employee);
	}


	public Employee getEmployeeById(Long id) 
	{
		
		return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ID Not Found"));
				
	}


	public ResponseEntity<Employee> updateEmployee(Long id, Employee employee)
	{
		Employee emp=employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id Doesn't Exsist"));
		emp.setFirstname(employee.getFirstname());
		emp.setLastname(employee.getLastname());
		emp.setEmail(employee.getEmail());
		
		Employee updateEmp=employeeRepository.save(emp);
		return ResponseEntity.ok(updateEmp);
	}


	public ResponseEntity<HttpStatus> deleteEmployee(Long id) 
	{
	Employee employee= employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id Not Found"));
		employeeRepository.delete(employee);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}














