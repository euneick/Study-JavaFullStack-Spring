package com.spring.member.vo;

import java.sql.Date;

public class MemberVO {

	private String id;
	private String pass;
	private String name;
	private String email;
	private Date joinDate;

	public MemberVO(String id, String pass, String name, String email) {

		this.id = id;
		this.pass = pass;
		this.name = name;
		this.email = email;
	}

	public MemberVO(String id, String pass, String name, String email, Date joinDate) {

		this(id, pass, name, email);
		this.joinDate = joinDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
}
