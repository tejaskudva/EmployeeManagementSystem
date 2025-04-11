package com.empmgmnt.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empmgmnt.models.entity.Employee;
import com.empmgmnt.service.EmpMgmtService;

@RestController
@RequestMapping("/emp")
public class EmpManagementController {

	private final EmpMgmtService empMgmtService;

	public EmpManagementController(EmpMgmtService empMgmtService) {
		this.empMgmtService = empMgmtService;
	}

	@PostMapping("/add")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee emp) {
		return empMgmtService.addEmployee(emp);
	}

	@PostMapping("/addAll")
	public ResponseEntity<Object> addEmployee(@RequestBody List<Employee> emps) {
		return empMgmtService.addEmployee(emps);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getById(@PathVariable Long id) {
		return empMgmtService.getById(id);
	}

	@GetMapping("/get")
	public ResponseEntity<Object> get() {
		return empMgmtService.get();
	}
	
	@PostMapping("/validateEmployees")
	public ResponseEntity<Object> validateEmployees() {
		return empMgmtService.validateEmployees();
	}

}
