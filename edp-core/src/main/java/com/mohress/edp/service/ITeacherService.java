package com.mohress.edp.service;


import com.mohress.edp.model.Teacher;

import java.util.List;
import java.util.Map;

public interface ITeacherService {

	Teacher getOne(int num);
	
	List<Teacher> list();
	
	Map<String,Object> getData(int draw, int start, int length);
    
	void deleteOne(int num);
	
	void updateOne(String teacherid, String name);
	
	void insertOne(String name);
}
