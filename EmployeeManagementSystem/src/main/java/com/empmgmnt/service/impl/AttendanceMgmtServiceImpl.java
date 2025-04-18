package com.empmgmnt.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.empmgmnt.models.beans.GenericErrorResponse;
import com.empmgmnt.models.entity.Attendance;
import com.empmgmnt.models.entity.Employee;
import com.empmgmnt.repository.AttendanceRepository;
import com.empmgmnt.repository.EmployeeRepository;
import com.empmgmnt.service.AttendanceMgmtService;

@Service
public class AttendanceMgmtServiceImpl implements AttendanceMgmtService {

	private final AttendanceRepository attRepo;
	private final EmployeeRepository empRepo;

	public AttendanceMgmtServiceImpl(AttendanceRepository attRepo, EmployeeRepository empRepo) {
		this.attRepo = attRepo;
		this.empRepo = empRepo;
	}

	@Override
	public ResponseEntity<Object> addAttendanceRecord(Attendance attendance, Long employeeId) {

		try {

			Employee emp = empRepo.findById(employeeId).orElseThrow(() -> new RuntimeException("Entity not found"));
			attendance.setEmployee(emp);

			return new ResponseEntity<>(attRepo.save(attendance), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(
					GenericErrorResponse.builder().errorCode(1).errorDescription(e.toString()).build(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<Object> getByEmployeeId(Long employeeId) {
		try {

			return new ResponseEntity<>(attRepo.findByEmployeeId(employeeId), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(
					GenericErrorResponse.builder().errorCode(1).errorDescription(e.toString()).build(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> deleteByAttendanceId(Long attendanceId) {
		try {

			attRepo.deleteById(attendanceId);
			return new ResponseEntity<>("Deleted", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(
					GenericErrorResponse.builder().errorCode(1).errorDescription(e.toString()).build(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
