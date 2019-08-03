package com.xxx.test;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xxx.service.ExaminationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class ExaminationServiceTest {
	
	@Autowired
	private ExaminationService service;
	@Test
	public void publishExaminination() {
		int r=this.service.publishExaminination(1, "spring", 20, 2, "123");
		System.out.println(r);
	}
	
}





