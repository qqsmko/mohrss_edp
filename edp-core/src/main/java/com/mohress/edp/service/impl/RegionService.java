package com.mohress.edp.service.impl;


import com.mohress.edp.dao.RegionMapper;
import com.mohress.edp.model.Region;
import com.mohress.edp.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService implements IRegionService {
	@Autowired
	RegionMapper t;
	
    public List<Region> list(){
        return t.selectAll();
    };
    
    public void deleteOne(int num){
    	t.deleteByPrimaryKey(num);
    }
    
    public void updateOne(String regionid,String regionname,String parentregion){
    	Region temp = new Region();
    	Integer id = Integer.parseInt(regionid);
    	temp.setRegionid(id);
    	if(regionname==""){
    		temp.setRegionname(null);
    	}else{
    		temp.setRegionname(regionname);
    	}
    	if(parentregion==""){
    		temp.setParentregion(null);
    	}else{
    		Integer parentregionb = Integer.parseInt(parentregion);
    		temp.setParentregion(parentregionb);
    	}
    	t.updateByPrimaryKeySelective(temp);
    }
    
	public void insertOne(String regionname,String parentregion){
Region temp = new Region();
    	
    	temp.setRegionid(null);
    	temp.setRegionname(regionname);
    	Integer parentregionb = Integer.parseInt(parentregion);
    	temp.setParentregion(parentregionb);
    	t.insertSelective(temp);
	}
	
	public void insertRegion(Region r){
		t.insertSelective(r);
	}
}
