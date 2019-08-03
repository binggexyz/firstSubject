package com.xxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxx.po.Examination;
import com.xxx.service.IExaminationService;
import com.xxx.util.PublicData;

@Controller
public class ExaminationController {

		@Autowired
		private IExaminationService service;
		@ResponseBody//加上这个注解就不是转发 就是ajax请求返回一个字符串
		@RequestMapping("/getExaminationName.do")
		public String getExaminationName(int clazzId){
			List<Examination> list=this.service.getByStateAndClazzId(1, clazzId);
			String examinationName =PublicData.NO;
			if(list.size()==1) {
				Examination examination = list.get(0);
				examinationName = examination.getName();
			}
			return examinationName;
		}
		
		@ResponseBody
		@RequestMapping(value="publishExamination.do", produces={"application/json;charset=UTF-8"})
		public String publishExamination(int clazzId, String examinationName, int subjectNum, int teacherId, String category) {
			int r = this.service.publishExaminination(clazzId, examinationName, subjectNum, teacherId, category);
			if(r==1) {
				System.out.println(r);
				return PublicData.YES;
			}else {
				System.out.println(r);
				return PublicData.NO;
			}
		}
		
		@ResponseBody
		@RequestMapping("/getCurrentExaminationByStuId.do")
		public Examination getclazzIdBystuId(int stuId) {
			//Examination examination=this.service.
			Examination examination=this.service.getclzzIdBystuId(stuId);
			return examination;
		}
		@RequestMapping("toCurrentExamination.do")
		public String toCurrentExamination() {
			return "/WEB-INF/currentExamination.html";
		}
}
