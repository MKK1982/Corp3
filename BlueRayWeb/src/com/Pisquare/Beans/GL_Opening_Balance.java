package com.Pisquare.Beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class GL_Opening_Balance {
	
	private int Account_Code;
	private String OB_Date;
	private float Opening_Balance;
	private int id;
	private float Sanction_Amount;
	private String BalanceType;
	private String csrfToken;
	public String getCsrfToken() {
		return csrfToken;
	}
	public void setCsrfToken(String csrfToken) {
		this.csrfToken = csrfToken;
	}
	private String GL_Name;
	private int BudgetLtd;
	private int BudgetBalance;
	
	

public GL_Opening_Balance()
	{
		
	}
	
	
	
	
	public int getAccount_Code()
	{
		return Account_Code;
	}
	
	public void setAccount_Code(int Account_Code)
	{
		this.Account_Code=Account_Code;
	}
	
	
	
	public String getOB_Date()
	{
		return OB_Date;
	}
	
	public void setOB_Date(String OB_Date)
	{
		this.OB_Date=OB_Date;
	}
	
	
	
	public float getOpening_Balance()
	{
		return Opening_Balance;
	}
	
	public void setOpening_Balance(float Opening_Balance)
	{
		this.Opening_Balance=Opening_Balance;
	}
	
	
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	
	public float getSanction_Amount()
	{
		return Sanction_Amount;
	}
	
	public void setSanction_Amount(float Sanction_Amount)
	{
		this.Sanction_Amount=Sanction_Amount;
	}




	public String getBalanceType() {
		return BalanceType;
	}




	public void setBalanceType(String balanceType) {
		BalanceType = balanceType;
	}
	
	
	
	//Permission Flag Settings-----------
	
		private int UpdateFlag=1;
		public int getUpdateFlag() {
			return UpdateFlag;
		}
		public void setUpdateFlag(int updateFlag) {
			UpdateFlag = updateFlag;
		}
		
		
		
		private int SaveFlag=1;
		public int getSaveFlag() {
			return SaveFlag;
		}

		public void setSaveFlag(int saveFlag) {
			SaveFlag = saveFlag;
		}

		private int DeleteFlag=1;
		public int getDeleteFlag() {
			return DeleteFlag;
		}
		public void setDeleteFlag(int deleteFlag) {
			DeleteFlag = deleteFlag;
		}




		public String getGL_Name() {
			return GL_Name;
		}




		public void setGL_Name(String gL_Name) {
			GL_Name = gL_Name;
		}




		public int getBudgetLtd() {
			return BudgetLtd;
		}




		public void setBudgetLtd(int budgetLtd) {
			BudgetLtd = budgetLtd;
		}




		public int getBudgetBalance() {
			return BudgetBalance;
		}




		public void setBudgetBalance(int budgetBalance) {
			BudgetBalance = budgetBalance;
		}

		
		/*public int getBudgetYear() {
			return BudgetYear;
		}




		public void setBudgetYear(int budgetYear) {
			BudgetYear = budgetYear;
		}
*/


		public String getBranch_Type1() {
			return Branch_Type1;
		}
		public void setBranch_Type1(String branch_Type1) {
			Branch_Type1 = branch_Type1;
		}
		public String getReport_Month1() {
			return Report_Month1;
		}
		public void setReport_Month1(String report_Month1) {
			Report_Month1 = report_Month1;
		}
		public int getMonthly_Amount() {
			return Monthly_Amount;
		}
		public void setMonthly_Amount(int monthly_Amount) {
			Monthly_Amount = monthly_Amount;
		}
		public String getSubject() {
			return Subject;
		}
		public void setSubject(String subject) {
			Subject = subject;
		}
		public String getMessage() {
			return Message;
		}
		public void setMessage(String message) {
			Message = message;
		}
		public String getTo_receiver() {
			return to_receiver;
		}
		public void setTo_receiver(String to_receiver) {
			this.to_receiver = to_receiver;
		}
		public String getBranch_Type2() {
			return Branch_Type2;
		}
		public void setBranch_Type2(String branch_Type2) {
			Branch_Type2 = branch_Type2;
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
		//private int BudgetYear;
		
		public String getFyear() {
			return Fyear;
		}
		public void setFyear(String fyear) {
			Fyear = fyear;
		}
		private String Branch_Type1;
		private String Report_Month1;
		
		private int Monthly_Amount;
		
		
		
		
		 private String Subject;
			private String Message;
			 private String to_receiver;
			 
				private String Branch_Type2;
				
				private String From_Date;
				private String To_Date;
				
				private String Fyear;
}
