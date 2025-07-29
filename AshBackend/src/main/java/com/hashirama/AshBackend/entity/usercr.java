package com.hashirama.AshBackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usercr")
public class usercr {
	
	
	@Id
	@Column(unique = true, nullable = false)
	private String email;
	private String pass;
	private String username;
	
	public  void setMail(String email) { this.email=email; }
	public String getMail() { return email; }
	public  void setPass(String pass) { this.pass=pass; }
	public String getPass() { return pass; }
	public void setUser(String user) { this.username=user; }
	public String getUser() { return username; }
	
	
}
