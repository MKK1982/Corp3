package com.Pisquare.Beans;

public class Audit_Report 
{
	public Audit_Report()
	{
		
	}
	
	public String getBranch_Type() {
		return Branch_Type;
	}
	public void setBranch_Type(String branch_Type) {
		Branch_Type = branch_Type;
	}

	public String getFrom_Date() {
		return From_Date;
	}

	public void setFrom_Date(String from_Date) {
		From_Date = from_Date;
	}

	public String getFile_Type() {
		return File_Type;
	}

	public void setFile_Type(String file_Type) {
		File_Type = file_Type;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTo_Date() {
		return To_Date;
	}

	public void setTo_Date(String to_Date) {
		To_Date = to_Date;
	}

	public String getFN_End_Time() {
		return FN_End_Time;
	}

	public void setFN_End_Time(String fN_End_Time) {
		FN_End_Time = fN_End_Time;
	}

	public String getAN_Start_Time() {
		return AN_Start_Time;
	}

	public void setAN_Start_Time(String aN_Start_Time) {
		AN_Start_Time = aN_Start_Time;
	}

	private String Branch_Type;
	private String From_Date;
	private String File_Type;
	
	private int month=1;
	private int year=2020;
	
	private String To_Date;
	
	private String FN_End_Time;
	private String AN_Start_Time;

}
