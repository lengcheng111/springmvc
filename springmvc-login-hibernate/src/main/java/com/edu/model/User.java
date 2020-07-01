package com.edu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {
	@Id
	@Column(name = "user_name")
	private String userName;
	@Column(name = "pwd")
	private String pwd;

	public User() {
		super();
	}

	public User(String userName, String pwd) {
		this.userName = userName;
		this.pwd = pwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Login [userName=" + userName + ", pwd=" + pwd + "]";
	}
}
