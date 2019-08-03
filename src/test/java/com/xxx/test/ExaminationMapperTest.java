package com.xxx.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xxx.mapper.ExaminationMapper;
import com.xxx.po.Examination;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:spring/spring-dao.xml"})
public class ExaminationMapperTest {
	@Autowired
	private ExaminationMapper mapper;
	@Test
	public void insertExaminationTest() {
		Examination examination=new Examination("11", 2, 1, 20, new Date(), 1, "123");
		int r=this.mapper.insertExamination(examination);
		System.out.println(r);
	}
}
