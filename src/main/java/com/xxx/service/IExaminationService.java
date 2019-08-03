package com.xxx.service;

import java.util.List;

import com.xxx.po.Examination;

public interface IExaminationService {
	public List<Examination> getByStateAndClazzId(int state,int clazzId);
	public Examination getclzzIdBystuId(int stuId);
	/**发布考试*/
	public int publishExaminination(int clazzId, String examinationName, int subjectNum, int teacherId, String category);
}
