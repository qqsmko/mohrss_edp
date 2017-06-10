package com.mohress.edp.service.impl;


import com.mohress.edp.dao.TeacherMapper;
import com.mohress.edp.model.Teacher;
import com.mohress.edp.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherService implements ITeacherService {
	@Autowired
	TeacherMapper t;
	
	public Teacher getOne(int teacherid){
		return t.selectByPrimaryKey(teacherid);
	}
	
    public List<Teacher> list(){
        return t.selectAll();
    };
    
    public void deleteOne(int num){
    	t.softDelete(num);
    }
    
    public void updateOne(String teacherid,String name){
    	Teacher temp = new Teacher();
    	Integer id = Integer.parseInt(teacherid);
    	temp.setTeacherid(id);
    	if(name==""){
    		temp.setName(null);
    	}else{
    		temp.setName(name);
    	}
    	t.updateByPrimaryKeySelective(temp);
    }
    
	public void insertOne(String name){
		Teacher temp = new Teacher();
    	
    	temp.setTeacherid(null);
    	temp.setName(name);
    	t.insertSelective(temp);
	}
	
	public Map<String,Object> getData(int draw,int start,int length){
    	int totalNum = t.selectCount();
    	List<Teacher> dataSet = t.selectByPage(start,length);
    	Map<String,Object> ansMap = new HashMap<String,Object>();
    	ansMap.put("draw",draw);
    	ansMap.put("recordsTotal",totalNum);
		ansMap.put("recordsFiltered",totalNum);
		ansMap.put("data",dataSet);
    	return ansMap;
    }
}
