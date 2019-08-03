package com.xxx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xxx.po.Examination;

public interface selectExamById {
	public List<Examination> selectExamStateAndclazzId(@Param("state")int state,@Param("clazzId")int clazzId);
}
