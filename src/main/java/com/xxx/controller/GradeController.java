package com.xxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxx.po.Grade;
import com.xxx.service.IGradeService;
import com.xxx.util.PublicData;

@Controller
public class GradeController {
	
	@Autowired
	private IGradeService service;
	@ResponseBody
	@RequestMapping("/getAllGrade.do")
	public List<Grade> getAllGrade(int stuId){
		List<Grade> list=this.service.getAllGradeBystuId(stuId);
		return list;
	}
	@ResponseBody
	@RequestMapping("/getExamination.do")
	public String getExamination(int stuId, int examinationId, String examinationName, float score) {
		int r = this.service.getTimesByExamination(stuId, examinationId, examinationName, score);
		if(r==1) {
			return PublicData.YES;
		}else {
			return PublicData.NO;
		}
	}
}
