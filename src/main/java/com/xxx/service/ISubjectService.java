package com.xxx.service;

import java.util.List;

import com.xxx.po.Subject;

public interface ISubjectService {
	public List<Subject> selectSubjectByCategoryIdAndNum(String categoryIdes,int subjectNum);
	/**
	 * 查询所有的考试题目
	 * */
	public List<Subject> getAllSubject();
}
