package com.xxx.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xxx.mapper.SubjectMapper;
import com.xxx.po.Subject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:spring/spring-dao.xml"})
public class SubjectMapperTest {
	
	@Autowired
	private SubjectMapper mapper;
	@Test
	public void selectSubjectByCategoryIdAndNum() {
		List<Subject> list=this.mapper.selectSubjectByCategoryIdAndNum(new int[] {1,2,3},20);
		for (Subject subject : list) {
			System.out.println(subject);
		}
	}
}
