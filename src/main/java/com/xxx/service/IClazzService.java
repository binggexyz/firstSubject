package com.xxx.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xxx.po.Clazz;


public interface IClazzService {
	//把班级信息全部查询出来
	public List<com.xxx.vo.Clazz> getClazzAll();
	//增加一个班级
	public int addClazz(Clazz clazz);
	//删除班级通过Id
	public int deleteById(int id);
	//通过name和major查询
	public List<com.xxx.vo.Clazz> getClazzBylike(String key);
}
