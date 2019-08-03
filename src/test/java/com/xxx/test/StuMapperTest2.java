package com.xxx.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xxx.mapper.StuMapper;
import com.xxx.po.Stu;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:spring/spring-dao.xml"})
public class StuMapperTest2 {
	@Autowired
	StuMapper mapper;
	@Test
	public void updateupdateStuTest() {
		int r=this.mapper.updateByStuId(new Stu(1, "fasfdsa", "fds", "d", "123", 2));
		System.out.println(">>>>>>"+r);
	}
	@Test
	public void testStumapper() {
		Stu stu=this.mapper.selectStuByNoAndPwd("00195", "12356");
		System.out.println(stu);
	}
}
