package com.empmgmnt.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.empmgmnt.service.EmpMgmtService;

@Component
public class EmployeeScheduler {

	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;

	@Autowired
	EmpMgmtService empService;

	//@Scheduled(fixedDelay = 10000)
	public void validateEmployeesScheduler() {

		empService.validateEmployees();
	}

}
