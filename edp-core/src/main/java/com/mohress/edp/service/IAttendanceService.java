package com.mohress.edp.service;


import com.mohress.edp.model.Attendance;

import java.util.List;

public interface IAttendanceService {

	List<Attendance> list();
	void insertOne(Attendance attendance);
}
