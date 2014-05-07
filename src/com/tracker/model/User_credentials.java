package com.tracker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user_credentials")
public class User_credentials {
	
	@Id @GeneratedValue
	private int id;
    private String userid;
    private String pass;
     
	public User_credentials() {
		super();
		
	}
	
	public User_credentials(int id, String userid, String pass) {
		super();
		this.id = id;
		this.userid = userid;
		this.pass = pass;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

}