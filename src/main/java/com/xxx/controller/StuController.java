package com.xxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxx.po.Clazz;
import com.xxx.po.Stu;
import com.xxx.service.IStuService;
import com.xxx.util.PublicData;

@Controller
public class StuController {
	@Autowired
	private IStuService service;

	@RequestMapping("/intoStu.do")
	public String getAllStu(int clazzId, String clazzName, HttpServletRequest req) {
		Clazz clazz = new Clazz();
		clazz.setId(clazzId);
		clazz.setName(clazzName);
		req.setAttribute("clazz", clazz);
		return "/WEB-INF/stu.jsp";//转发到jsp
	}

	@ResponseBody
	@RequestMapping("/getStuByClazzId.do")
	public List<Stu> getStuByClazzId(int clazzId) {
		List<Stu> list = this.service.getsAllStuByclazzId(clazzId);
//		for (Stu stu : list) {
//			System.out.println(stu);
//		}
		return list;
	}

	@ResponseBody
	@RequestMapping("/deleStuById.do")
	public String deleStu(int id) {
		int r = this.service.getdeleteStuId(id);
		if (r == 1) {// 删除成功
			return PublicData.YES;
		} else {
			return PublicData.NO;
		}
	}
	@ResponseBody
	@RequestMapping("/updateStu.do")
	public String updateStu(Stu stu) {
		System.out.println(stu);
		int r=this.service.updateStu(stu);
		System.out.println(r);
		if(r==1) {
			System.out.println(r);
			return PublicData.YES;
		}else {
			return PublicData.NO;
		}
	}
	@ResponseBody
	@RequestMapping("/insertStu.do")
	public String addStu(Stu stu) {
		int r=this.service.addStu(stu);
		if(r==1) {
			return PublicData.YES;
		}else {
			return PublicData.NO;
		}
	}
	@ResponseBody
	@RequestMapping(value="/selectBylike.do",method=RequestMethod.POST)
	public List<Stu> toselectBylike(String key,int clazzId){
		Map<String, Object> map=new HashMap<String, Object>();
		if(key!=null&&key!="") {
			map.put("name", "%"+key+"%");//如果key值为空或者没得%%就会匹配所有的
			map.put("sex", "%"+key+"%");
			map.put("no", "%"+key+"%");
		}
		map.put("clazzId", clazzId);
		List<Stu> list=this.service.getselectBylike(map);
		return list;
	}
		//进入学生主页面
		@RequestMapping("/toStuPage.do")
		public String toStuPage() {
			return "/WEB-INF/stuMain.html";
		}
		
		@RequestMapping("/toStuGrade.do")
		public String toStuGrade() {
			return "/WEB-INF/stuGrade.html";
		}
}








