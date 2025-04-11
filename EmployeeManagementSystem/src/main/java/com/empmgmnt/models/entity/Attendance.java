package com.empmgmnt.models.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.empmgmnt.enums.AttendanceStatus;
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
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
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
