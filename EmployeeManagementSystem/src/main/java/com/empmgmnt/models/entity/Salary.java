package com.empmgmnt.models.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.empmgmnt.enums.SalaryCurrency;
import com.empmgmnt.enums.SalaryMonths;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Salary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;

	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	@JsonIgnore
	private Employee employee;
	
	private BigDecimal salaryAmt;

	@Enumerated(EnumType.STRING)
	private SalaryMonths month; // JAN, FEB, MAR....
	
	@Enumerated(EnumType.STRING)
	private SalaryCurrency currency; 
	
	private Integer year;

	private Timestamp creditedDateTime;

}