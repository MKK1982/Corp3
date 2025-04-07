package com.Pisquare.Beans;

import javax.validation.constraints.Size;

//import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


public class Login {
	
	@NotEmpty(message = "Please enter your Username.")
	@Size(min = 6, max = 15, message = "Your username must between 6 and 15 characters")
	private String Username="";
	
	//@NotEmpty(message = "Please enter your Username.")
	//@Size(min = 6, max = 15, message = "Your username must between 6 and 15 characters")
	private String Password="";
	private String fname="";
	private String designation="";

	
	public Login()
	{
		super();
		this.Username="Username";
		this.Password="Password";
		this.fname="fname";
		this.designation="designation";
	}
	
	public Login(String Username,String Password,String fname,String designation)
	{
		super();
		this.Username=Username;
		this.Password=Password;
		this.fname=fname;
		this.designation=designation;
	}
	

	
	public String getUsername()
	{
		return Username;
	}

	public void setUsername(String Username)
	{
		this.Username=Username;
		
	}

	public String getPassword()
	{
		return Password;
	}

	public void setPassword(String Password)
	{
		this.Password=Password;
		
	}

	public String getFname()
	{
		return fname;
	}

	public void setFname(String fname)
	{
		this.fname=fname;
		
	}
	public String getDesignation()
	{
		return designation;
	}

	public void setDesignation(String designation)
	{
		this.designation=designation;
		
	}
	
	public int getFlag1() {
		return flag1;
	}

	public void setFlag1(int flag1) {
		this.flag1 = flag1;
	}

	private int flag1=0;

}
