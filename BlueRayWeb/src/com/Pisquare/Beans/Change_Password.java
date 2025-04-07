
package com.Pisquare.Beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Change_Password 
{
	@NotEmpty(message = "Please enter Branch Code.")
	@Size(min = 3, max = 10, message = "Branch code must between 3 and 10 characters")
	private String Branch_Code;
	
	@NotEmpty(message = "Please enter the UserName.")
	@Size(min = 3, max = 15, message = "User Name must between 3 and 15 characters")
	private String Username;
	private String Password;
	
	private String NewPassword;
	private String Re_Password;
	


	
	

public Change_Password ()
{

	
}


public Change_Password (String userName,String passWord)
{
	super();
  this.Username=userName;
  this.Password=passWord;
	
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

public String getNewPassword()
{
	return NewPassword;
}

public void setNewPassword(String NewPassword)
{
	this.NewPassword=NewPassword;
	

}
}