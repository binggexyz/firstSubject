package com.xxx.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.mapper.ClazzMapper;
import com.xxx.po.Clazz;

@Service
public class ClazzService implements IClazzService {

	@Autowired
	private ClazzMapper mapper;

	@Override
	public List<com.xxx.vo.Clazz> getClazzAll() {
		List<com.xxx.po.Clazz> list1 = this.mapper.selectAll();
		List<com.xxx.vo.Clazz> list2 = new ArrayList<>();
		for (int i = 0; i < list1.size(); i++) {
			com.xxx.po.Clazz clazz = list1.get(i);
			list2.add(new com.xxx.vo.Clazz(clazz.getId(), clazz.getName(), clazz.getMajor(), clazz.strBeginDate()));
		}
		return list2;
	}

	@Override
	public int addClazz(Clazz clazz) {
		//增加班级没输入日期
		//在service业务层添加
		clazz.setBeginDate(new Date());
		//因为返回值事int 返回增加了几个班级
		int r=this.mapper.insertClazz(clazz);
		return r;
	}

	@Override
	public int deleteById(int id) {
		int r=this.mapper.deleteById(id);
		return r;
	}


	@Override
	public List<com.xxx.vo.Clazz> getClazzBylike(String key) {
		Clazz clazz= new Clazz();
		clazz.setMajor("%"+key+"%");
		clazz.setName("%"+key+"%");
		List<Clazz> list1=this.mapper.selectByLike(clazz);
		List<com.xxx.vo.Clazz> list2 = new ArrayList<>();
		for (int i = 0; i < list1.size(); i++) {
			com.xxx.po.Clazz clazz1 = list1.get(i);
			list2.add(new com.xxx.vo.Clazz(clazz1.getId(), clazz1.getName(), clazz1.getMajor(),clazz1.strBeginDate()));
		}
		return list2;
	}
}
