package com.mohress.edp.service;


import com.mohress.edp.model.Region;

import java.util.List;

public interface IRegionService {

	List<Region> list();
	void deleteOne(int num);
	void updateOne(String regionid, String regionname, String parentregion);
	void insertOne(String regionname, String parentregion);
	void insertRegion(Region r);
}
