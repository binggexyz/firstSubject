package com.xxx.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xxx.po.Examination;
import com.xxx.service.IExaminationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class TestExaminationService {
	
	@Autowired
	private IExaminationService service;
	@Test
	public void test1() {
		List<Examination> list=this.service.getByStateAndClazzId(1, 3);
		for (Examination examination : list) {
			System.out.println(examination);
		}
	}
}
