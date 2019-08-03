package com.xxx.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xxx.po.Stu;
import com.xxx.service.IStuService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class StuServiceTest {
	@Autowired
	IStuService service;
	@Test
	public void updateupdateStuTest() {
		int r=this.service.updateStu(new Stu(2, "fasfdsa", "fds", "d", "123", 2));
		System.out.println(">>>>>>"+r);
	}
	@Test
	public void testService() {
		Stu stu=this.service.StuLogin("00195", "12356");
		System.out.println(stu);
	}
}
