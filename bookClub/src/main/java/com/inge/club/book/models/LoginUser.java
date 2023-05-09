package com.inge.club.book.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUser {
	
	@NotEmpty(message="Email required.")
	@Email(message="Must enter valid email.")
	private String loginEmail;
	
	@NotEmpty(message="Password required.")
	@Size(min=8, max=128, message="Password must be at least 8 characters long.")
	private String loginPassword;

	public LoginUser() {}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	
}