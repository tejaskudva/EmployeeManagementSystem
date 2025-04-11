package com.empmgmnt.service;

import org.springframework.http.ResponseEntity;

import com.empmgmnt.models.entity.Attendance;

public interface AttendanceMgmtService {

	ResponseEntity<Object> addAttendanceRecord(Attendance attendance, Long employeeId);

	ResponseEntity<Object> getByEmployeeId(Long employeeId);

}