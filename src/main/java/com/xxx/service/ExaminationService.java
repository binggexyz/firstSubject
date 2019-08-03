package com.xxx.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.mapper.ExaminationMapper;
import com.xxx.po.Examination;
@Service //注入IOC
public class ExaminationService implements IExaminationService {

	@Autowired
	private ExaminationMapper mapper;
	@Override
	public List<Examination> getByStateAndClazzId(int state,int clazzId) {
		List<Examination> list=this.mapper.selectExamByclazzId(state,clazzId);
		return list;
	}
	
	@Override
	public Examination getclzzIdBystuId(int stuId) {
		Examination examination=this.mapper.selectclzzIdBystuId(stuId);
		return examination;
	}

	@Override
	public int publishExaminination(int clazzId, String examinationName, int subjectNum, int teacherId,
			String category) {
		Examination examination=new Examination(examinationName, clazzId, teacherId, subjectNum, new Date(), 1, category);
		int r = this.mapper.insertExamination(examination);
		return r;
	}
}
