package com.jsp.college.sample.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentDto {
@Id
private String email;
private String name;
private long phone;
private String degree;
private String stream;
private int yop;
private String sslc_per;
private String puc_per;
private String degree_per;
private String java_mock;
private String sql_mock;
private String web_mock;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public String getDegree() {
	return degree;
}
public void setDegree(String degree) {
	this.degree = degree;
}
public String getStream() {
	return stream;
}
public void setStream(String stream) {
	this.stream = stream;
}
public int getYop() {
	return yop;
}
public void setYop(int yop) {
	this.yop = yop;
}
public String getSslc_per() {
	return sslc_per;
}
public void setSslc_per(String sslc_per) {
	this.sslc_per = sslc_per;
}
public String getPuc_per() {
	return puc_per;
}
public void setPuc_per(String puc_per) {
	this.puc_per = puc_per;
}
public String getDegree_per() {
	return degree_per;
}
public void setDegree_per(String degree_per) {
	this.degree_per = degree_per;
}
public String getJava_mock() {
	return java_mock;
}
public void setJava_mock(String java_mock) {
	this.java_mock = java_mock;
}
public String getSql_mock() {
	return sql_mock;
}
public void setSql_mock(String sql_mock) {
	this.sql_mock = sql_mock;
}
public String getWeb_mock() {
	return web_mock;
}
public void setWeb_mock(String web_mock) {
	this.web_mock = web_mock;
}



}
