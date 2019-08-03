package com.xxx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.mapper.GradeMapper;
import com.xxx.po.Grade;
@Service //注入IOC
public class GradeService implements IGradeService {

	@Autowired
	private GradeMapper mapper;
	@Override
	public List<Grade> getAllGradeBystuId(int stuId) {
		List<Grade> list=this.mapper.selectGradeByStuId(stuId);
		return list;
	}
	@Override
	public int getTimesByExamination(int stuId, int examinationId, String examinationName, float score) {
		Integer times =this.mapper.selectTimesByExamination(examinationId, stuId);
		Grade grade = new Grade();
		grade.setStuId(stuId);
		grade.setExaminationId(examinationId);
		grade.setExaminationName(examinationName);
		grade.setScore(score);
		grade.setTimes(times==null ? 1 : (times+1));
		int r=this.mapper.insertGrade(grade);
		return r;
	}
}
