package com.xxx.service;

import java.util.List;
import java.util.Map;

import com.xxx.po.Stu;

public interface IStuService {
	public List<Stu> getsAllStuByclazzId(int clazzId);

	public int getdeleteStuId(int id);

	public int updateStu(Stu stu);

	// 增加一个学生记录
	public int addStu(Stu stu);

	// 获取模糊查询的值
	public List<Stu> getselectBylike(Map<String, Object> map);

	public Stu StuLogin(String no, String pwd);
}
