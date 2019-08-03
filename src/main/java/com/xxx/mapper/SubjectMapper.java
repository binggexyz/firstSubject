package com.xxx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xxx.po.Subject;

public interface SubjectMapper {
	public List<Subject> selectSubjectByCategoryIdAndNum(@Param("categoryIdes")int[] categoryId,@Param("num")int SubjectNum);
	public List<Subject> selectAllSubject();
	
}
