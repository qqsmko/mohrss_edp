package com.mohress.edp.service;


import com.mohress.edp.model.Institutions;

import java.util.List;
import java.util.Map;

public interface IInstitutionsService {

	List<Institutions> list();
	Map<String,Object> getData(int draw, int start, int length);
	void deleteOne(int num);
	void updateOne(Institutions institutions);
	void insertOne(Institutions institutions);
	void setOnesState(int id, int num);
}
