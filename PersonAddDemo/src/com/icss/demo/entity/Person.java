package com.icss.demo.entity;

import java.util.Date;

public class Person {
	private String pid;
	private String name;
	private Date birthday;
	private String address;
	private String sex;	

	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Person [address=" + address + ", birthday=" + birthday
				+ ", name=" + name + ", pid=" + pid + ", sex=" + sex + "]";
	}
	
	
}
