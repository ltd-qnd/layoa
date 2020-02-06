package com.situ.layoa.student.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	private String stuName;// 姓名
	private Long stuAge;// 年龄
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date stuBirthday;// 生日
	private Integer stuSex;// 性别

	@Override
	public String toString() {
		return "Student [stuName=" + stuName + ", stuAge=" + stuAge + ", stuBirthday=" + stuBirthday + ", stuSex="
				+ stuSex + "]";
	}

	public Integer getStuSex() {
		return stuSex;
	}

	public void setStuSex(Integer stuSex) {
		this.stuSex = stuSex;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Long getStuAge() {
		return stuAge;
	}

	public void setStuAge(Long stuAge) {
		this.stuAge = stuAge;
	}

	public Date getStuBirthday() {
		return stuBirthday;
	}

	public void setStuBirthday(Date stuBirthday) {
		this.stuBirthday = stuBirthday;
	}

}
