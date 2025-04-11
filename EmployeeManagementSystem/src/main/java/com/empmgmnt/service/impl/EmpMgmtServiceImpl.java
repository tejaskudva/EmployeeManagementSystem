package com.empmgmnt.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.empmgmnt.executors.TaskExecutorConfig;
import com.empmgmnt.models.beans.GenericErrorResponse;
import com.empmgmnt.models.entity.Employee;
import com.empmgmnt.repository.EmployeeRepository;
import com.empmgmnt.service.EmpMgmtService;

@Service
public class EmpMgmtServiceImpl implements EmpMgmtService {

	@Autowired
	EmployeeRepository empRepo;

	@Autowired
	ThreadPoolTaskExecutor taskExecutor;

	@Override
	public ResponseEntity<Object> addEmployee(Employee emp) {

		try {
			return new ResponseEntity<>(empRepo.save(emp), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(
					GenericErrorResponse.builder().errorCode(1).errorDescription(e.toString()).build(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> addEmployee(List<Employee> emps) {
		try {

			return new ResponseEntity<>(empRepo.saveAll(emps), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(
					GenericErrorResponse.builder().errorCode(1).errorDescription(e.toString()).build(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getById(Long id) {
		try {
			return new ResponseEntity<>(empRepo.findById(id), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(
					GenericErrorResponse.builder().errorCode(1).errorDescription(e.toString()).build(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> get() {
		try {
			return new ResponseEntity<>(empRepo.findAll(), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(
					GenericErrorResponse.builder().errorCode(1).errorDescription(e.toString()).build(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> validateEmployees() {
		try {

			List<Employee> emps = empRepo.findAll();

			List<Future<?>> futures = new ArrayList<>();

			// ForkJoinPool customThreadPool = new ForkJoinPool(10);
			// customThreadPool.submit(() ->
			// emps.parallelStream().forEach(this::validateEachEmployee)).get();

			emps.forEach(emp -> futures.add(taskExecutor.submit(() -> validateEachEmployee(emp))));

			futures.forEach(future -> {
				try {
					future.get();
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			});

			// emps.forEach(this::validateEachEmployee);

			System.out.println("BATCH COMPLETE");

			return new ResponseEntity<>("ALL EMPLOYEES CHECKED", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(
					GenericErrorResponse.builder().errorCode(1).errorDescription(e.toString()).build(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private void validateEachEmployee(Employee emp) {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Employee Name: " + emp.getFirstName() + ", Check: OK");
	}

}
