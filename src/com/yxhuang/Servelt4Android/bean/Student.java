package com.yxhuang.Servelt4Android.bean;

public class Student {
	
	private String mName;
	private String mSex;
	private String mAge;
	private String mID;
	
	public Student(){
		
	}
	
	public Student(String name, String sex, String age, String iD) {
		super();
		mName = name;
		mSex = sex;
		mAge = age;
		mID = iD;
	}
	public String getID() {
		return mID;
	}
	public void setID(String iD) {
		mID = iD;
	}
	public String getName() {
		return mName;
	}
	public void setName(String name) {
		mName = name;
	}
	public String getSex() {
		return mSex;
	}
	public void setSex(String sex) {
		mSex = sex;
	}
	public String getAge() {
		return mAge;
	}
	public void setAge(String age) {
		mAge = age;
	}
	

}
