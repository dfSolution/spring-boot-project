package com.blog.webapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.blog.webapp.entity.Employee;
import com.blog.webapp.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repo;
	
	@Override
	public List<Employee> findAll() {
		
		return repo.findAll();
	}

	@Override
	public Employee findById(int id) {
		
		Optional<Employee> result = repo.findById(id);
		Employee tempEmployee = null;
		
		if(result.isPresent()) {
			tempEmployee = result.get();
		} else {
		 throw new RuntimeException();	
		}
		
		return tempEmployee;
	}

	@Override
	public void save(Employee employee) {

		repo.save(employee);
	}

	@Override
	public void deleteById(int id) {
		
		repo.deleteById(id);
	}

}
