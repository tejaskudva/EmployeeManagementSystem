package com.empmgmnt.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.empmgmnt.models.entity.Employee;

@Component
public interface EmpMgmtService {

	public ResponseEntity<Object> addEmployee(Employee emp);

	public ResponseEntity<Object> getById(Long id);

	public ResponseEntity<Object> get();

	public ResponseEntity<Object> addEmployee(List<Employee> emps);

	public ResponseEntity<Object> validateEmployees();

}
