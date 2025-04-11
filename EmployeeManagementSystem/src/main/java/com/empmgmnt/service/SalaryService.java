package com.empmgmnt.service;

import org.springframework.http.ResponseEntity;

import com.empmgmnt.models.entity.Salary;

public interface SalaryService {

	ResponseEntity<Object> addSalaryRecord(Salary sal, Long employeeId);

	ResponseEntity<Object> getByEmployeeId(Long employeeId);

	ResponseEntity<Object> getByEmployeeIdAndYear(Long employeeId, Integer year);

}
