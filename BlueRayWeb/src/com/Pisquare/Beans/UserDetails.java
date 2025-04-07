package com.Pisquare.Beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserDetails 
{
	@NotEmpty(message = "Please enter Branch Code.")
	@Size(min = 3, max = 10, message = "Branch code must between 3 and 10 characters")
	private String Branch_Code;
	
	@NotEmpty(message = "Please enter the UserName.")
	@Size(min = 3, max = 15, message = "User Name must between 3 and 15 characters")
	private String Username;
	private String Password;
	
	
	private String Re_Password;
	private String Emp_Id;
	private String Emp_Name;
	private String Emp_Designation;
	
	
	private String level1;
	private int uid;
	private String status;

	private int pass_status;
	private String Session_Id;
	private long Mobile_No;


	
	

public UserDetails()
{

	
}


public UserDetails(String userName,String passWord)
{
	super();
  this.Username=userName;
  this.Password=passWord;
	
}



public String getBranch_Code()
{
	return Branch_Code;
}

public void setBranch_Code(String Branch_Code)
{
	this.Branch_Code=Branch_Code;
	
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





public String getRe_Password()
{
	return Re_Password;
}

public void setRe_Password(String Re_Password)
{
	this.Re_Password=Re_Password;
	
}

public String getEmp_Id()
{
	return Emp_Id;
}

public void setEmp_Id(String Emp_Id)
{
	this.Emp_Id=Emp_Id;
	
}

public String getEmp_Name()
{
	return Emp_Name;
}

public void setEmp_Name(String Emp_Name)
{
	this.Emp_Name=Emp_Name;
	
}


public String getEmp_Designation()
{
	return Emp_Designation;
}

public void setEmp_Designation(String Emp_Designation)
{
	this.Emp_Designation=Emp_Designation;
	
}



public int getUid()
{
	return uid;
}

public void setUid(int uid)
{
	this.uid=uid;
	
}



public String getLevel1()
{
	return level1;
}

public void setLevel1(String level1)
{
	this.level1=level1;
	
}

public String getStatus()
{
	return status;
}

public void setStatus(String status)
{
	this.status=status;
	
}



public int getPass_status()
{
	return pass_status;
}

public void setPass_status(int pass_status)
{
	this.pass_status=pass_status;
	
}


public String getSession_Id()
{
	return Session_Id;
}

public void setSession_Id(String Session_Id)
{
	this.Session_Id=Session_Id;
	
}



public long getMobile_No()
{
	return Mobile_No;
}

public void setId(long Mobile_No)
{
	this.Mobile_No=Mobile_No;
	
}





}
