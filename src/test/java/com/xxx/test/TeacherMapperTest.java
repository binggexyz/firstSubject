package com.xxx.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xxx.mapper.TeacherMapper;
import com.xxx.po.Teacher;

;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class TeacherMapperTest {
	@Autowired
	private TeacherMapper mapper;
	@Test
	public void selectTest() {
		Teacher teacher=this.mapper.selectByNoAndPwd("9968","123456");
		System.out.println(teacher);
	}
}