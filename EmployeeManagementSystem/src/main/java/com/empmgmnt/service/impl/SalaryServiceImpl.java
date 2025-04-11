package com.empmgmnt.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.empmgmnt.models.beans.GenericErrorResponse;
import com.empmgmnt.models.entity.Employee;
import com.empmgmnt.models.entity.Salary;
import com.empmgmnt.repository.EmployeeRepository;
import com.empmgmnt.repository.SalaryRepository;
import com.empmgmnt.service.SalaryService;

@Service
public class SalaryServiceImpl implements SalaryService {

	private final EmployeeRepository empRepo;
	private final SalaryRepository salRepo;

	public SalaryServiceImpl(SalaryRepository salRepo, EmployeeRepository empRepo) {
		this.salRepo = salRepo;
		this.empRepo = empRepo;
	}

	@Override
	public ResponseEntity<Object> addSalaryRecord(Salary sal, Long employeeId) {
		try {

			Employee emp = empRepo.findById(employeeId).orElseThrow();
			sal.setEmployee(emp);

			return new ResponseEntity<>(salRepo.save(sal), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(
					GenericErrorResponse.builder().errorCode(1).errorDescription(e.toString()).build(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getByEmployeeId(Long employeeId) {
		try {

			return new ResponseEntity<>(salRepo.findByEmployeeId(employeeId), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(
					GenericErrorResponse.builder().errorCode(1).errorDescription(e.toString()).build(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getByEmployeeIdAndYear(Long employeeId, Integer year) {
		try {

			return new ResponseEntity<>(salRepo.findByEmployeeIdAndYear(employeeId, year), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(
					GenericErrorResponse.builder().errorCode(1).errorDescription(e.toString()).build(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
