package com.alexarkhipov.works.pictorialart.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHOR")
public class Author {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public int getId() {
		return id;
	}

	@Column(nullable = false, length = 255)
	private String fullname;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fn) {
		fullname = fn;
	}
	
	public void setFullname() {
		StringBuilder sb=new StringBuilder().append(fname).append(" ").append(mname).append(" ").append(lname);
		fullname = sb.toString();
	}

	@Column(nullable = false, length = 100)
	private String fname;
	public String getFname() {
		return fname;
	}

	public void setFname(String fn) {
		fname = fn;
	}
	
	@Column(nullable = true, length = 100)
	private String mname;
	public String getMname() {
		return mname;
	}

	public void setMname(String mn) {
		mname = mn;
	}

	@Column(nullable = false, length = 100)
	private String lname;
	public String getLname() {
		return lname;
	}

	public void setLname(String ln) {
		lname = ln;
	}

	@Column
	private Integer byear;

	public Integer getByear() {
		return byear;
	}

	public void setByear(Integer by) {
		byear = by;
	}
	
	@Column
	private Integer dyear;

	public Integer getDyear() {
		return dyear;
	}

	public void setDyear(Integer dy) {
		dyear = dy;
	}

	@Column(nullable = false)
	private short sex;

	public int getSex() {
		return sex;
	}
	
	public void setSex(int s) {
		sex = (short)s;
	}

	public static List<Gender> getSexes() {
		return Gender.getSexes();
	}

	@Override
	public String toString() {
		return fullname;
	}
}
