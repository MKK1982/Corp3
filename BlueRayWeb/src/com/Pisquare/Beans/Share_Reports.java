package com.Pisquare.Beans;

public class Share_Reports {

	private int Account_No;
	private String Share_From_Date;
	private String Share_To_Date;
	private String Certificate_Date;
	private String Report_Type;
	
	public Share_Reports(){	}
	
	
	public int getAccount_No()
	{
		return Account_No;
	}
	public void setAccount_No(int Account_No)
	{
		this.Account_No=Account_No;
	}
	
	
	
	
	
	public String getShare_From_Date()
	{
		return Share_From_Date;
	}
	
	public void setShare_From_Date(String Share_From_Date)
	{
		this.Share_From_Date=Share_From_Date;
	}
	
	
	
	public String getShare_To_Date()
	{
		return Share_To_Date;
	}
	
	public void setShare_To_Date(String Share_To_Date)
	{
		this.Share_To_Date=Share_To_Date;
	}
	
	
	
	
	public String getCertificate_Date()
	{
		return Certificate_Date;
	}
	
	public void setCertificate_Date(String Certificate_Date)
	{
		this.Certificate_Date=Certificate_Date;
	}
	
	
	
	
	public String getReport_Type()
	{
		return Report_Type;
	}
	
	public void setReport_Type(String Report_Type)
	{
		this.Report_Type=Report_Type;
	}
	
	
	
private String Branch_Type;
	
	public String getBranch_Type()
	{
		return Branch_Type;
	}

	public void setBranch_Type(String Branch_Type)
	{
		this.Branch_Type=Branch_Type;
		
	}
}
