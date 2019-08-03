package com.xxx.vo;

import java.util.Date;

public class Clazz {
	private int id;
	private String name;
	private String major;
	private String beginDate;
	
	
	public Clazz() {
		super();
	}

	public Clazz(String name, String major) {
		super();
		this.name = name;
		this.major = major;
	}

	@Override
	public String toString() {
		return "Clazz [id=" + id + ", name=" + name + ", major=" + major + ", beginDate=" + beginDate + "]";
	}


	public Clazz(int id,String name, String major, String beginDate) {
		super();
		this.id=id;
		this.name = name;
		this.major = major;
		this.beginDate = beginDate;
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


	public String getBeginDate() {
		return beginDate;
	}


	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	
}
