package com.mohress.edp.service.impl;


import com.mohress.edp.dao.AttendanceMapper;
import com.mohress.edp.model.Attendance;
import com.mohress.edp.service.IAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService implements IAttendanceService {
	@Autowired
    AttendanceMapper t;
	
    public List<Attendance> list(){
        return t.selectAll();
    };
    
    public void insertOne(Attendance attendance){
    	t.insertSelective(attendance);
    }
}
