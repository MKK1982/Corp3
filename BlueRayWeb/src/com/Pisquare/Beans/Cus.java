package com.Pisquare.Beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Cus 
{
	//@NotEmpty(message = "Please enter your Id.")
	@Min(101)
	@Max(10000)
	
	private int cid;
	
	@Pattern(regexp="[^0-9]*",message="Enter Alphabets Only")
	@NotEmpty(message = "Please enter your Name.")
	@Size(min = 6, max = 15, message = "Your Name must between 6 and 15 characters")
	private String cname;
	
	@NotEmpty(message = "Please enter your Gender.")
	@Size(min = 4, max = 10, message = "Your gender must between 4 and 10 characters")
	private String gender;
	
	//@NotEmpty(message = "Please enter your BalanceAmt.")
	@Min(1)
	private float balance;


public Cus()
{

	
}

public int getCid()
{
	return cid;
}

public void setCid(int cid)
{
	this.cid=cid;
	
}

public String getCname()
{
	return cname;
}

public void setCname(String cname)
{
	this.cname=cname;
	
}

public String getGender()
{
	return gender;
}

public void setGender(String gender)
{
	this.gender=gender;
	
}

public float getBalance()
{
	return balance;
}

public void setBalance(float balance)
{
	this.balance=balance;
	
}


public String getYear() {
	return Year;
}

public void setYear(String year) {
	Year = year;
}


public String getFlag() {
	return Flag;
}

public void setFlag(String flag) {
	Flag = flag;
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
private String csrfToken;
public String getCsrfToken() {
	return csrfToken;
}
public void setCsrfToken(String csrfToken) {
	this.csrfToken = csrfToken;
}

public String getScheme_Type() {
	return Scheme_Type;
}

public void setScheme_Type(String scheme_Type) {
	Scheme_Type = scheme_Type;
}


private String Year;

private String Flag;

private String From_Date;
private String To_Date;

private String Scheme_Type;


}
