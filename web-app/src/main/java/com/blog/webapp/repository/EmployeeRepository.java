package com.blog.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.webapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public List<Employee> findAllByOrderByIdAsc();

}
