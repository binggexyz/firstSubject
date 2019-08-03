package com.xxx.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xxx.po.Stu;

public interface StuMapper {
	public List<Stu> selectStuByclzzId(@Param("clazzId")int clazzId);
	public int deleteStuById(int id);
	public int updateByStuId(Stu stu);
	//增加学生
	public int insertStu(Stu stu);
	//模糊查询
	public List<Stu> selectBylike(Map<String, Object> map);
	//通过no和pwd 查询stu记录
	public Stu selectStuByNoAndPwd(@Param("no")String no,@Param("pwd")String pwd);
}
