package com.xxx.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xxx.po.Subject;
import com.xxx.service.ISubjectService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class SubjectServiceTest {
	@Autowired
	private ISubjectService service;
	@Test
	public void selectSubjectByCategoryIdAndNum() {
		List<Subject> list =this.service.selectSubjectByCategoryIdAndNum("{1,2,3}", 20);
		for (Subject subject : list) {
			System.out.println(subject);
		}
	}
}
