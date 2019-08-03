package com.xxx.po;

import java.util.Date;

public class Clazz {
	private int id;
	private String name;
	private String major;
	private Date beginDate;
	
	public String strBeginDate() {
		int year = this.beginDate.getYear()+1900;
		int month = this.beginDate.getMonth()+1;
		int date = this.beginDate.getDate();
		return year+"-"+month+"-"+date;
	}
	public Clazz() {
		super();
	}

	
	public Clazz(String name, String major) {
		super();
		this.name = name;
		this.major = major;
	}
	public Clazz(String name, String major, Date beginDate) {
		super();
		this.name = name;
		this.major = major;
		this.beginDate = beginDate;
	}

	@Override
	public String toString() {
		return "Clazz [id=" + id + ", name=" + name + ", major=" + major + ", beginDate=" + beginDate + "]";
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

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
}
