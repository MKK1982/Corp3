package com.Pisquare.Beans;

import java.util.ArrayList;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Search
{
	@NotNull(message="Select Type First")
	@Min(1)
	@Max(4)
	private int st1;
	@NotNull(message="Enter the Search Element")
	private String sv;
	
	private String name;
	private String Account_No;
	private String CusString1;
	private String Customer_Id;
	private String Customer_Name;
	private String Customer_Info;
	private String Certificate_no;
	private String CusString2;
	private String Customer_Name2;
	private String Customer_Info2;
	private String CusString3;
	private String Customer_Name3;
	private String Customer_Info3;
	private int Bcode;
	
	
	

public Search()
{

	
}

public int getSt1()
{
	return st1;
}

public void setSt1(int st1)
{
	this.st1=st1;
	
}
public String getSv()
{
	return sv;
}

public void setSv(String sv)
{
	this.sv=sv;
	
}



private String Radio_All;

public String getRadio_All() 
{
   return Radio_All;
}
public void setRadio_All(String Radio_All) 
{
   this.Radio_All = Radio_All;
}  

private int Loan_Amount;

	public int getLoan_Amount()
	{
		return Loan_Amount;
	}
public void setLoan_Amount(int Loan_Amount)
{
   	this.Loan_Amount=Loan_Amount;
}






private String Scheme_Type;

public String getScheme_Type() 
{
   return Scheme_Type;
}
public void setScheme_Type(String Scheme_Type) 
{
   this.Scheme_Type = Scheme_Type;
}  




private String From_Date;
public String getFrom_Date() {
	return From_Date;
}

public void setFrom_Date(String from_Date) {
	From_Date = from_Date;
}


private String To_Date;
public String getTo_Date() {
	return To_Date;
}

public void setTo_Date(String to_Date) {
	To_Date = to_Date;
}


public ArrayList<String> getCT_Operation_Types() {
	return CT_Operation_Types;
}

public void setCT_Operation_Types(ArrayList<String> cT_Operation_Types) {
	CT_Operation_Types = cT_Operation_Types;
}



private ArrayList<String> CT_Operation_Types=null;


private String Lbl_Status;

	public String getLbl_Status()
	{
		return Lbl_Status;
	}
public void setLbl_Status(String Lbl_Status)
{
   	this.Lbl_Status=Lbl_Status;
}





private boolean checkAll;
public boolean isCheckAll() {
	return checkAll;
}

public void setCheckAll(boolean checkAll) {
	this.checkAll = checkAll;
}


public String getBranch_Type() {
	return Branch_Type;
}

public void setBranch_Type(String branch_Type) {
	Branch_Type = branch_Type;
}



public String getSearch_Type() {
	return Search_Type;
}

public void setSearch_Type(String search_Type) {
	Search_Type = search_Type;
}



public String getReport_Type() {
	return Report_Type;
}

public void setReport_Type(String report_Type) {
	Report_Type = report_Type;
}



public String getTarget_Id() {
	return Target_Id;
}

public void setTarget_Id(String target_Id) {
	Target_Id = target_Id;
}



public String getTarget_Name() {
	return Target_Name;
}

public void setTarget_Name(String target_Name) {
	Target_Name = target_Name;
}



public String getUsername() {
	return Username;
}

public void setUsername(String username) {
	Username = username;
}



public String getAccount_No() {
	return Account_No;
}

public void setAccount_No(String account_No) {
	Account_No = account_No;
}



public String getCusString1() {
	return CusString1;
}

public void setCusString1(String cusString1) {
	CusString1 = cusString1;
}



public String getCustomer_Id() {
	return Customer_Id;
}

public void setCustomer_Id(String customer_Id) {
	Customer_Id = customer_Id;
}



public String getCustomer_Info() {
	return Customer_Info;
}

public void setCustomer_Info(String customer_Info) {
	Customer_Info = customer_Info;
}



public String getCustomer_Name() {
	return Customer_Name;
}

public void setCustomer_Name(String customer_Name) {
	Customer_Name = customer_Name;
}



public String getCertificate_no() {
	return Certificate_no;
}

public void setCertificate_no(String certificate_no) {
	Certificate_no = certificate_no;
}



public int getBcode() {
	return Bcode;
}

public void setBcode(int bcode) {
	Bcode = bcode;
}



public String getCusString2() {
	return CusString2;
}

public void setCusString2(String cusString2) {
	CusString2 = cusString2;
}



public String getCustomer_Info2() {
	return Customer_Info2;
}

public void setCustomer_Info2(String customer_Info2) {
	Customer_Info2 = customer_Info2;
}



public String getCustomer_Name2() {
	return Customer_Name2;
}

public void setCustomer_Name2(String customer_Name2) {
	Customer_Name2 = customer_Name2;
}



public String getCustomer_Name3() {
	return Customer_Name3;
}

public void setCustomer_Name3(String customer_Name3) {
	Customer_Name3 = customer_Name3;
}



public String getCusString3() {
	return CusString3;
}

public void setCusString3(String cusString3) {
	CusString3 = cusString3;
}



public String getCustomer_Info3() {
	return Customer_Info3;
}

public void setCustomer_Info3(String customer_Info3) {
	Customer_Info3 = customer_Info3;
}



public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}



private String Branch_Type;

private String Search_Type;
private String Report_Type;






private String Target_Id;
private String Target_Name;
private String Username;

}
