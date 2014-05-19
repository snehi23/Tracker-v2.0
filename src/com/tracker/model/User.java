package com.tracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name="user_registration_data")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class User {
	 
	@Id
	@GeneratedValue
	@Column(name="user_registration_data_id")
	private Integer id;
	
	@Column(name="user_name")
    private String user;
	
	@Column(name="user_id")
	private String username;
	
	@Column(name="user_email")
	private String email;
	
	@Column(name="user_password")
    private String password;
    

	
	public User() {
		super();
		
	}


	public User(Integer id, String user, String username, String email,
			String password) {
		super();
		this.id = id;
		this.user = user;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
     
 
}