package com.xxx.po;

public class Teacher {
	private int id;
	private String no;
	private String name;
	private String sex;
	private String pwd;
	public Teacher() {
	}
	@Override
	public String toString() {
		return "{\"id\":"+this.id+", \"name\": "+this.name+"}";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
