package com.alexarkhipov.works.pictorialart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHORS")
public class Author {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 255)
	private String fullname;

	public String getFullname() {
		return fullname;
	}

	@Column(nullable = false, length = 100)
	private String fname;
	@Column(nullable = false, length = 100)
	private String mname;
	@Column(nullable = false, length = 100)
	private String lname;

	@Column
	private Integer byear;

	public Integer byear() {
		return byear;
	}

	@Column
	private Integer dyear;

	public Integer dyear() {
		return dyear;
	}

	@Column(nullable = false)
	private short sex;

	public short getSex() {
		return sex;
	}

	@Override
	public String toString() {
		return fullname;
	}
}
