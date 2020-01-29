package com.blog.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.webapp.entity.Employee;
import com.blog.webapp.service.EmployeeService;

@RestController
@RequestMapping("/home")
public class DemoController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/authenticateTheUser")
	public String showHome(Model model) {
		
		employeeService.findAll();
		
	return "list-employees";
	}
	
	@GetMapping("/save")
	public String showEmployees(Model model) {
		
		Employee employee = new Employee();
		model.addAttribute("employee1", employee);
		
		return "show-save";
	}
	
	@PostMapping("/save")
	public String addEmployee(Model model, Employee employee) {
		
		employeeService.save(employee);
		model.addAttribute("employee1", employee);
		
		return "redirect:/";
	}
}

