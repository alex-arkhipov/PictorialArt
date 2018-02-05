package com.alexarkhipov.works.pictorialart.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

class SexClass {
	public SexClass(int v, String n) {
		value = (short) v;
		name = n;
	}

	public final short value;
	public final String name;
}

@Entity
@Table(name = "PLAYER")
public class Players {

	static {
		sexes = getSexes();
	}

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

	@NotNull
	@Size(min = 3, max = 20)
	@Column(nullable = false, length = 20)
	private String nickname;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@NotNull
	@Size(min = 10, max = 200)
	@Column(nullable = false, length = 255)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Transient
	@NotNull
	@Size(min = 6, max = 20)
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}

	@Column(nullable = false, length = 100)
	private String hash;

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	@Column
	@NotNull
	private Integer age;

	public Integer getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@NotNull
	@Size(min = 5, max = 100)
	@Column(nullable = false, length = 100)
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column
	private Integer scores;

	@Column
	@Temporal(TemporalType.DATE)
	private Date lastaccess;

	public Date getLastAccess() {
		return lastaccess;
	}

	@NotNull
	@Column(nullable = false)
	private short sex;

	public short getSex() {
		return sex;
	}

	public void getSex(short sex) {
		this.sex = sex;
	}

	public void setSex(short sex) {
		this.sex = sex;
	}

	public static final ArrayList<SexClass> sexes;

	private static ArrayList<SexClass> getSexes() {
		ArrayList<SexClass> sexes = new ArrayList<>();
		SexClass man = new SexClass(1, "Man");
		SexClass woman = new SexClass(2, "Woman");
		sexes.add(man);
		sexes.add(woman);
		return sexes;
	}

	public String toString() {
		return String.format("Player '%s' (Name: %s | Email: %s | Age: %d | Sex: %d", nickname, name, email, age, sex);

	}
}
