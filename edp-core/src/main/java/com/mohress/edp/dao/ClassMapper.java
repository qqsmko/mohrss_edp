package com.mohress.edp.dao;

import java.util.List;
import com.mohress.edp.model.Class;

public interface ClassMapper {
    int deleteByPrimaryKey(Integer classid);

    int insert(Class record);

    int insertSelective(Class record);

    Class selectByPrimaryKey(Integer classid);

    List<Class> selectAll();
    
    List<Class> selectApplication();
    
    List<Class> selectFinishied();
    
    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);
    
    int updateState(Class record);
}