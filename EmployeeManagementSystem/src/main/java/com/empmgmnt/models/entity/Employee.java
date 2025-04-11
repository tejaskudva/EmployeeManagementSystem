package com.empmgmnt.models.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private LocalDate dateOfBirth;
	private String gender;
	private String address;
	private String city;
	private String state;
	private String country;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "employee", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Attendance> attendanceRecords = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "employee", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Salary> salaryHistory = new ArrayList<>();

}