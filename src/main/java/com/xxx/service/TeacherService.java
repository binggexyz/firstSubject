package com.xxx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xxx.mapper.TeacherMapper;
import com.xxx.po.Teacher;

@Service
public class TeacherService implements ITeacherService {
	@Autowired
	private TeacherMapper mapper;

	@Override
	public Teacher login(String no, String pwd) {
		Teacher teacher = this.mapper.selectByNoAndPwd(no, pwd);
		return teacher;
	}
}
