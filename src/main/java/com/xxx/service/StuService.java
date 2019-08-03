package com.xxx.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.mapper.StuMapper;
import com.xxx.po.Stu;
@Service
public class StuService  implements IStuService{

	@Autowired
	private StuMapper mapper;
	@Override
	public List<Stu> getsAllStuByclazzId(int clazzId) {
		return this.mapper.selectStuByclzzId( clazzId);
	}
	@Override
	public int getdeleteStuId(int id) {
		int r=this.mapper.deleteStuById(id);
		return r;
	}
	@Override
	public int updateStu(Stu stu) {
		int r=this.mapper.updateByStuId(stu);
		return r;
	}
	@Override
	public int addStu(Stu stu) {
		int r=this.mapper.insertStu(stu);
		return r;
	}
	@Override
	public List<Stu> getselectBylike(Map<String, Object> map) {
		List<Stu> list=this.mapper.selectBylike(map);
		return list;
	}
	@Override
	public Stu StuLogin(String no, String pwd) {
		Stu stu=this.mapper.selectStuByNoAndPwd(no, pwd);
		return stu;
	}
}
