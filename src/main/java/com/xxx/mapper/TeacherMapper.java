package com.xxx.mapper;

import org.apache.ibatis.annotations.Param;
import com.xxx.po.Teacher;

public interface TeacherMapper {
	public Teacher selectByNoAndPwd(@Param("no") String no, @Param("pwd") String pwd);
}
