package com.jskj.course.domain;

import org.codehaus.jackson.annotate.JsonIgnore;

public class User {

	private int id;
	private int status;
	private String username;
	private String password;
	private String msg;

	public User() {
		super();
	}

	public User(int status, String username, String password, String msg) {
		super();
		this.status = status;
		this.username = username;
		this.password = password;
		this.msg = msg;
	}

	public User(int id, int status, String username, String password, String msg) {
		super();
		this.id = id;
		this.status = status;
		this.username = username;
		this.password = password;
		this.msg = msg;
	}

	@JsonIgnore
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	@JsonIgnore
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
