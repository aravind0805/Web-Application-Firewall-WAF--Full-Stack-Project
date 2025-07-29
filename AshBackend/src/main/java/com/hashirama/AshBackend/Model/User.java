package com.hashirama.AshBackend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
	@JsonIgnore
	private String userpass;
	
	private String username;
	private String email;
	public User(String userpass,String name,String mail) {
		this.email=mail;
		this.userpass=userpass;
		this.username=name;
	}

	public void namePut(String name) { this.username=name; }
	public String NameGet() {return username; }
	public void mailPut(String mail) { this.email=mail; }
	public String mailGet() {return email; }
	
	
}
