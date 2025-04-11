package com.empmgmnt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empmgmnt.models.entity.Salary;
import com.empmgmnt.service.SalaryService;

@RestController
@RequestMapping("/salary")
public class SalaryController {

	private final SalaryService salaryService;

	public SalaryController(SalaryService salaryService) {
		this.salaryService = salaryService;
	}

	@PostMapping("/add/{employeeId}")
	public ResponseEntity<Object> addSalaryRecord(@RequestBody Salary sal,
			@PathVariable Long employeeId) {
		return salaryService.addSalaryRecord(sal, employeeId);
	}

	@GetMapping("/get/{employeeId}")
	public ResponseEntity<Object> getByEmployeeId(@PathVariable Long employeeId) {
		return salaryService.getByEmployeeId(employeeId);
	}
	
	@GetMapping("/getByYear")
	public ResponseEntity<Object> getByEmployeeIdAndYear(@RequestParam Long employeeId, @RequestParam Integer year) {
		return salaryService.getByEmployeeIdAndYear(employeeId, year);
	}

}