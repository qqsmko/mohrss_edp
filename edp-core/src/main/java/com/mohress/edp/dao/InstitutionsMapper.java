package com.mohress.edp.dao;

import com.mohress.edp.model.Institutions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InstitutionsMapper {
    int deleteByPrimaryKey(Integer institutionsid);

    int insert(Institutions record);

    int insertSelective(Institutions record);

    Institutions selectByPrimaryKey(Integer institutionsid);

    List<Institutions> selectAll();

    List<Institutions> selectByPage(@Param("start") int start, @Param("length") int length);
    
    int selectCount();
    
    int updateByPrimaryKeySelective(Institutions record);

    int updateByPrimaryKey(Institutions record);
    
    int softDelete(Integer institutionsid);
}