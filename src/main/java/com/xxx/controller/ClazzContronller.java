package com.xxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxx.service.IClazzService;
import com.xxx.util.PublicData;
import com.xxx.vo.Clazz;

@Controller
public class ClazzContronller {
	
	@Autowired
	private IClazzService service;
	@ResponseBody
	@RequestMapping("/getAllclazz.do")
	public List<Clazz> getAllClazz(){
		List<Clazz> list=this.service.getClazzAll();
		return list;
	}
	@ResponseBody
	@RequestMapping(value="/addClazz.do", method=RequestMethod.POST)
	public String addClazz(String name,String major) {
		com.xxx.po.Clazz clazz=new com.xxx.po.Clazz();
		clazz.setName(name);
		clazz.setMajor(major);
		int r=this.service.addClazz(clazz);
		if(r==1) {//增加成功
			return PublicData.YES;
		}else {//增加失败
			return PublicData.NO;
		}
	}
	@ResponseBody
	@RequestMapping(value="/deleteById.do", method=RequestMethod.POST)
	public String deleteById(int id) {
		
		int r=this.service.deleteById(id);
		if(r==1) {//成功过删除
			return PublicData.YES;
		}else {
			return PublicData.NO;
		}
	}
	  @ResponseBody
	  @RequestMapping(value="/getClazzBylike.do")
	  public List<Clazz> getClazzNameOrmajor(String key){ 
		  List<Clazz> list=this.service.getClazzBylike(key); 
		  return list;
	  }
}
