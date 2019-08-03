package com.xxx.po;

public class Grade {
	private int id;
	private int stuId;
	private int examinationId;
	private String examinationName;
	private float score;
	private int times;
	
	
	
	
	public Grade() {
		super();
	}


	public Grade(int stuId, int examinationId, String examinationName, float score, int times) {
		super();
		this.stuId = stuId;
		this.examinationId = examinationId;
		this.examinationName = examinationName;
		this.score = score;
		this.times = times;
	}


	public Grade(int id, int stuId, int examinationId, String examinationName, float score, int times) {
		super();
		this.id = id;
		this.stuId = stuId;
		this.examinationId = examinationId;
		this.examinationName = examinationName;
		this.score = score;
		this.times = times;
	}


	@Override
	public String toString() {
		return "Grade [id=" + id + ", stuId=" + stuId + ", examinationId=" + examinationId + ", examinationName="
				+ examinationName + ", score=" + score + ", times=" + times + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getStuId() {
		return stuId;
	}


	public void setStuId(int stuId) {
		this.stuId = stuId;
	}


	public int getExaminationId() {
		return examinationId;
	}


	public void setExaminationId(int examinationId) {
		this.examinationId = examinationId;
	}


	public String getExaminationName() {
		return examinationName;
	}


	public void setExaminationName(String examinationName) {
		this.examinationName = examinationName;
	}


	public float getScore() {
		return score;
	}


	public void setScore(float score) {
		this.score = score;
	}


	public int getTimes() {
		return times;
	}


	public void setTimes(int times) {
		this.times = times;
	}
	
}
