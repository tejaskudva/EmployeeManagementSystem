package com.empmgmnt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empmgmnt.models.entity.Attendance;
import com.empmgmnt.service.AttendanceMgmtService;

@RestController
@RequestMapping("/attendance")
public class AttendanceMgmtController {

	private final AttendanceMgmtService attendanceMgmtService;

	public AttendanceMgmtController(AttendanceMgmtService attendanceMgmtService) {
		this.attendanceMgmtService = attendanceMgmtService;
	}

	@PostMapping("/add/{employeeId}")
	public ResponseEntity<Object> addAttendanceRecord(@RequestBody Attendance attendance,
			@PathVariable Long employeeId) {
		return attendanceMgmtService.addAttendanceRecord(attendance, employeeId);
	}

	@GetMapping("/get/{employeeId}")
	public ResponseEntity<Object> getByEmployeeId(@PathVariable Long employeeId) {
		return attendanceMgmtService.getByEmployeeId(employeeId);
	}

	@DeleteMapping("/delete/{attendanceId}")
	public ResponseEntity<Object> deleteByAttendanceId(@PathVariable Long attendanceId) {
		return attendanceMgmtService.deleteByAttendanceId(attendanceId);
	}

}
