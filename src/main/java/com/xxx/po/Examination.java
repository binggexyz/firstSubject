package com.xxx.po;

import java.util.Date;

public class Examination {
	private int id;
	private String name;
	private int clazzId;
	private int teacherId;
	private int subjectNum;
	private Date beginTime;
	private int state;
	private String category;
	
	public Examination() {
		super();
	}
	public Examination(String name, int clazzId, int teacherId, int subjectNum, Date beginTime, int state,
			String category) {
		super();
		this.name = name;
		this.clazzId = clazzId;
		this.teacherId = teacherId;
		this.subjectNum = subjectNum;
		this.beginTime = beginTime;
		this.state = state;
		this.category = category;
	}

	public Examination(int id, String name, int clazzId, int teacherId, int subjectNum, Date beginTime, int state,
			String category) {
		super();
		this.id = id;
		this.name = name;
		this.clazzId = clazzId;
		this.teacherId = teacherId;
		this.subjectNum = subjectNum;
		this.beginTime = beginTime;
		this.state = state;
		this.category = category;
	}





	@Override
	public String toString() {
		return "Examination [id=" + id + ", name=" + name + ", clazzId=" + clazzId + ", teacherId=" + teacherId
				+ ", subjectNum=" + subjectNum + ", beginTime=" + beginTime + ", state=" + state + ", category="
				+ category + "]";
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getClazzId() {
		return clazzId;
	}


	public void setClazzId(int clazzId) {
		this.clazzId = clazzId;
	}


	public int getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}


	public int getSubjectNum() {
		return subjectNum;
	}


	public void setSubjectNum(int subjectNum) {
		this.subjectNum = subjectNum;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
