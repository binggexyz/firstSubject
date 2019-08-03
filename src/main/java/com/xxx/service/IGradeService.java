package com.xxx.service;

import java.util.List;

import com.xxx.po.Grade;

public interface IGradeService {
	public List<Grade> getAllGradeBystuId(int stuId);
	public int getTimesByExamination(int stuId,int examinationId,String examinationName,float score);
}
