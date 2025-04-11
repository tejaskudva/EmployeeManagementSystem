package com.empmgmnt.models.beans;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import com.empmgmnt.enums.AttendanceStatus;
import com.empmgmnt.models.entity.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttendanceDTO {

	private Long id;

	@JsonIgnore
	private Employee employee;

	private LocalDate date; // Date of attendance

	@Enumerated(EnumType.STRING)
	private AttendanceStatus status; // PRESENT, ABSENT, ON_LEAVE

	private LocalTime checkInTime;
	private LocalTime checkOutTime;

	private Integer hoursWorked;

	private Timestamp createdAt;
	private Timestamp updatedAt;

}