package com.xxx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xxx.po.Examination;

public interface ExaminationMapper {
	public List<Examination> selectExamByclazzId(@Param("state")int state,@Param("clazzId")int clazzId);
	public Examination selectclzzIdBystuId(int stuId);
	//增加一个考试记录
	public int insertExamination(Examination examination);
}
