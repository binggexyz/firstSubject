package com.xxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxx.po.Subject;
import com.xxx.service.ISubjectService;

@Controller
public class SubjectController {

		@Autowired
		private ISubjectService service;
		@ResponseBody
		@RequestMapping("/getSubjectByCategoryIdAndNum.do")
		public List<Subject> getSubjectByCategoryIdAndNum(String categoryIdes,int subjectNum){
			List<Subject> list=this.service.selectSubjectByCategoryIdAndNum(categoryIdes, subjectNum);
			System.out.println(categoryIdes+"----"+subjectNum);
			return list;
	}
		@ResponseBody //ajax请求的时响应返回一个字符串
		@RequestMapping("/getAllSubjects.do")
		public List<Subject> getAllSubjects(){
			List<Subject> list=this.service.getAllSubject();
			return list;
		}
}
