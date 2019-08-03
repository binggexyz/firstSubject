package com.xxx.mapper;


import java.util.List;

import com.xxx.po.Clazz;

public interface ClazzMapper {
	//查询所有的班级
	public List<Clazz> selectAll();
	//增加一个班级
	public int insertClazz(Clazz clzz);
	//通过Id删除clazz deleteById
	public int deleteById(int id);
	//根据name和major查询
	public List<Clazz> selectByLike(Clazz clazz);
	
}
