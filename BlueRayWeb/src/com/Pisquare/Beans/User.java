package com.Pisquare.Beans;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;



public class User {
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty(message = "Please enter your password.")
	@Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
	private String password;

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

	public String getFrom_Date() {
		return From_Date;
	}

	public void setFrom_Date(String from_Date) {
		From_Date = from_Date;
	}


	public String getTo_Date() {
		return To_Date;
	}

	public void setTo_Date(String to_Date) {
		To_Date = to_Date;
	}


	public String getBranch_Type() {
		return Branch_Type;
	}

	public void setBranch_Type(String branch_Type) {
		Branch_Type = branch_Type;
	}


	public String getFrom_Date1() {
		return From_Date1;
	}

	public void setFrom_Date1(String from_Date1) {
		From_Date1 = from_Date1;
	}


	public String getTo_Date1() {
		return To_Date1;
	}

	public void setTo_Date1(String to_Date1) {
		To_Date1 = to_Date1;
	}


	private String From_Date;
	private String To_Date;
	
	private String Branch_Type;
	
	
	private String From_Date1;
	private String To_Date1;
}
