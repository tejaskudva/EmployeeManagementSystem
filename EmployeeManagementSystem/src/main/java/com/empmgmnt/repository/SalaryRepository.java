package com.empmgmnt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empmgmnt.models.entity.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {

	List<Salary> findByEmployeeId(Long employeeId);
	
	List<Salary> findByEmployeeIdAndYear(Long employeeId, Integer year);

}
