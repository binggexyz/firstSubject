package com.xxx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.mapper.SubjectMapper;
import com.xxx.po.Subject;
@Service
public class SubjectService implements ISubjectService {

	@Autowired
	private SubjectMapper mapper;
	
	
	/***
	 * categoryIdes:"{ 1, 2, 7 } "
	 * num:多少道题
	 * return: 返回符合条件的随机的num道试题
	 * \s空格 \\s 空格的转译 \{转译{  不认识\, 在加一个\转译\, |是或者的意思
	 */
	@Override
	public List<Subject> selectSubjectByCategoryIdAndNum(String categoryIdes, int subjectNum) {
		categoryIdes=categoryIdes.replaceAll("(\\s|\\{|\\})", "");
		String[] s=categoryIdes.split(",");
		int []b=new  int[s.length];
		for(int i=0;i<s.length;i++) {
			b[i]=Integer.parseInt(s[i]);
		}
		List<Subject> list=this.mapper.selectSubjectByCategoryIdAndNum(b, subjectNum);
		return list;
	}
//测试正则表达式
//	public static void main(String[] args) {
//	String s ="{ 11, 22, 766 } "; 
//	s = s.replaceAll("(\\s|\\{|\\})", "");//"11,22,766"
//	String[] a = s.split(",");
//	for (String str : a) {
//		System.out.println(str);
//	}
//}


	@Override
	public List<Subject> getAllSubject() {
		List<Subject> list=this.mapper.selectAllSubject();
		return list;
	}
}
