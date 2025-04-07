package com.Pisquare.Beans;

import java.util.ArrayList;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class DC_Master
{
	@NotNull(message="Select Type First")
	@Min(1)
	@Max(4)
	private int st1;
	@NotNull(message="Enter the Search Element")
	private String sv;
	
	

public DC_Master()
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



public String getEmpId() {
	return EmpId;
}

public void setEmpId(String empId) {
	EmpId = empId;
}



public String getEmpName() {
	return EmpName;
}

public void setEmpName(String empName) {
	EmpName = empName;
}



public String getEmpDesignation() {
	return EmpDesignation;
}

public void setEmpDesignation(String empDesignation) {
	EmpDesignation = empDesignation;
}



public String getEmpStatus() {
	return EmpStatus;
}

public void setEmpStatus(String empStatus) {
	EmpStatus = empStatus;
}



public String getEmpLevel() {
	return EmpLevel;
}

public void setEmpLevel(String empLevel) {
	EmpLevel = empLevel;
}



public String getEmpMobile() {
	return EmpMobile;
}

public void setEmpMobile(String empMobile) {
	EmpMobile = empMobile;
}



private String Branch_Type;

private String Search_Type;
private String Report_Type;



private String EmpId;
private String EmpName;
private String EmpDesignation;
private String EmpLevel;
private String EmpStatus;
private String EmpMobile;

}
