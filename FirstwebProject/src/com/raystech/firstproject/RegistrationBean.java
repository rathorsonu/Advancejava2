package com.raystech.firstproject;

import java.util.Date;

public class RegistrationBean {
private String Name;
private String Surname;
private String Gender;
private Date Date_of_birth;
private long Mobile_no;
private String Email;
private String pwd;
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public RegistrationBean() {
	
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getSurname() {
	return Surname;
}
public void setSurname(String surname) {
	Surname = surname;
}
public String getGender() {
	return Gender;
}
public void setGender(String gender) {
	Gender = gender;
}
public Date getDate_of_birth() {
	return Date_of_birth;
}
public void setDate_of_birth(Date date_of_birth) {
	Date_of_birth = date_of_birth;
}
public long getMobile_no() {
	return Mobile_no;
}
public void setMobile_no(long mobile_no) {
	Mobile_no = mobile_no;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
}