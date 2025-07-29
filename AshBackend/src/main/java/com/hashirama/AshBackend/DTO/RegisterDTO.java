package com.hashirama.AshBackend.DTO;

public class RegisterDTO {
    private String user;
    private String email;
    private String pass;

    public String getUser() { return user; }
    public String getEmail() { return email; }
    public String getPass() { return pass; }

    public void setUser(String user) { this.user = user; }
    public void setEmail(String email) { this.email = email; }  
    public void setPass(String pass) { this.pass = pass; } 
}


