package com.xxx.test;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xxx.mapper.ClazzMapper;
import com.xxx.po.Clazz;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:spring/spring-dao.xml"})
public class ClazzMapperTest {
	@Autowired
	private ClazzMapper mapper;
	@Test
	public void selectTest() {
		List<Clazz> list=this.mapper.selectAll();
		for (Clazz clazz : list) {
			System.out.println(clazz);
		}
	}
}