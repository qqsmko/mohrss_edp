package com.mohress.edp.service;

import com.mohress.edp.model.Class;

import java.util.List;

public interface IClassService {

	List<Class> list();
	List<Class> listApplication();
	List<Class> listFinishied();
	void deleteOne(int num);
	void updateOne(String classid, String classname, String applynumber, String startdate, String enddate, String remark, String applyperson);
	void insertOne(String classname, String applynumber, String startdate, String enddate, String remark, String applyperson);
	void updateOnesState(int id, int num);
}