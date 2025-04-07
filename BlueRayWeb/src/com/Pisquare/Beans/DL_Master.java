package com.Pisquare.Beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DL_Master {

	private String csrfToken;
	public String getCsrfToken() {
		return csrfToken;
	}
	public void setCsrfToken(String csrfToken) {
		this.csrfToken = csrfToken;
	}
	//Dep_Acc_No
		private String Dep_Acc_No;
		public String getDep_Acc_No()
		{
			return Dep_Acc_No;
		}
		public void setDep_Acc_No(String Dep_Acc_No)
		{
			this.Dep_Acc_No=Dep_Acc_No;
		}
	
	
	
		//Sanction_Limit
		
		private int Sanction_Limit;
		public int getSanction_Limit()
		{
			return Sanction_Limit;
		}
		public void setSanction_Limit(int Sanction_Limit)
		{
			this.Sanction_Limit=Sanction_Limit;
		}

	
	private int Customer_Id;
	public int getCustomer_Id()
	{
		return Customer_Id;
	}
	public void setCustomer_Id(int Customer_Id)
	{
		this.Customer_Id=Customer_Id;
	}
	
	
	

	private String Account_No;
	public String getAccount_No()
	{
		return Account_No;
	}
	public void setAccount_No(String Account_No)
	{
		this.Account_No=Account_No;
	}
	
	
	
	private String Open_Date;
	public String getOpen_Date()
	{
		return Open_Date;
	}
	public void setOpen_Date(String Open_Date)
	{
		this.Open_Date=Open_Date;
	}

	
	
	
	private int TransFlag1=1;
	public int getTransFlag1()
	{
		return TransFlag1;
	}
	public void setTransFlag1(int TransFlag1)
	{
		this.TransFlag1=TransFlag1;
	}
	
	
	
	
	
	//Account_Status
    private String Account_Status;
	public String getAccount_Status()
	{
		return Account_Status;
	}

	public void setAccount_Status(String Account_Status)
	{
		this.Account_Status=Account_Status;
	}
	
	private String Scheme_Type;
	public String getScheme_Type()
	{
		return Scheme_Type;
	}
	public void setScheme_Type(String Scheme_Type)
	{
		this.Scheme_Type=Scheme_Type;
	}
	
	
	private boolean Staff=false;

	public boolean getStaff()
	{
		return Staff;
	}
	public void setStaff(boolean Staff)
	{
		this.Staff=Staff;
	}
	
	
	
	//----------------------------------------------------
		private double Interest_Rate;
		public double getInterest_Rate()
		{
			return Interest_Rate;
		}
		public void setInterest_Rate(double Interest_Rate)
		{
			this.Interest_Rate=Interest_Rate;
		}
		
		
		
		
		// Penal_Interest
		 private double Penal_Rate;
		 public double getPenal_Rate()
		 {
		 	return Penal_Rate;
		 }
		 public void setPenal_Rate(double Penal_Rate)
		 {
		 	this.Penal_Rate=Penal_Rate;
		 }
		 
		 
		 
		//Loan_Amount
		 private int Loan_Amount;
		 public int getLoan_Amount()
		 {
		 	return Loan_Amount;
		 }
		 public void setLoan_Amount(int Loan_Amount)
		 {
		 	this.Loan_Amount=Loan_Amount;
		 }
	//-------------------------
	private int Period;
	public int getPeriod()
	{
		return Period;
	}
	public void setPeriod(int Period)
	{
		this.Period=Period;
	}
	
	
	
	
	
	private String Nominee_Name;
	public String getNominee_Name()
	{
		return Nominee_Name;
	}
	public void setNominee_Name(String Nominee_Name)
	{
		this.Nominee_Name=Nominee_Name;
	}
	
	private String Nominee_Relationship;
	public String getNominee_Relationship()
	{
		return Nominee_Relationship;
	}
	public void setNominee_Relationship(String Nominee_Relationship)
	{
		this.Nominee_Relationship=Nominee_Relationship;
	}
	
	private String Nominee_Age;
	public String getNominee_Age()
	{
		return Nominee_Age;
	}
	public void setNominee_Age(String Nominee_Age)
	{
		this.Nominee_Age=Nominee_Age;
	}
	

	
	private int Flag=1;
	public int getFlag()
	{
		return Flag;
	}
	public void setFlag(int Flag)
	{
		this.Flag=Flag;
	}
	
	
	
	
	private int Transaction_Id;
	public int getTransaction_Id()
	{
		return Transaction_Id;
	}
	public void setTransaction_Id(int Transaction_Id)
	{
		this.Transaction_Id=Transaction_Id;
	}
	
	private String Transaction_Date;
	public String getTransaction_Date()
	{
		return Transaction_Date;
	}
	
	public void setTransaction_Date(String Transaction_Date)
	{
		this.Transaction_Date=Transaction_Date;
	}
	
	private String Mode_Of_Receipt;
	public String getMode_Of_Receipt()
	{
		return Mode_Of_Receipt;
	}
	
	public void setMode_Of_Receipt(String Mode_Of_Receipt)
	{
		this.Mode_Of_Receipt=Mode_Of_Receipt;
	}
	
	
	
	private int TransFlag=1;
	public int getTransFlag()
	{
		return TransFlag1;
	}
	public void setTransFlag(int TransFlag)
	{
		this.TransFlag1=TransFlag;
	}  
	
	
	
	
 	
	private String Transfer_Acc_Name;   
public String getTransfer_Acc_Name()
{
return Transfer_Acc_Name;
}

public void setTransfer_Acc_Name(String Transfer_Acc_Name)
{
this.Transfer_Acc_Name=Transfer_Acc_Name;
}
    
    


private String Transfer_Acc_No;
public String getTransfer_Acc_No()
{
return Transfer_Acc_No;
}

public void setTransfer_Acc_No(String Transfer_Acc_No)
{
this.Transfer_Acc_No=Transfer_Acc_No;
}
  



private String Narration;

public String getNarration()
{
	return Narration;
}
public void setNarration(String Narration)
{
	this.Narration=Narration;
}












	//Dep_Interest_Rate
	private float Dep_Interest_Rate;
	public float getDep_Interest_Rate()
	{
		return Dep_Interest_Rate;
	}
	public void setDep_Interest_Rate(float Dep_Interest_Rate)
	{
		this.Dep_Interest_Rate=Dep_Interest_Rate;
	}
	

	private int Deposit_Amount;
	public int getDeposit_Amount()
	{
		return Deposit_Amount;
	}
	public void setDeposit_Amount(int Deposit_Amount)
	{
		this.Deposit_Amount=Deposit_Amount;
	}

	private String Effect_Date;
	public String getEffect_Date()
	{
		return Effect_Date;
	}
	public void setEffect_Date(String Effect_Date)
	{
		this.Effect_Date=Effect_Date;
	}

	//Account_Type
	private String Account_Type;
	public String getAccount_Type()
	{
		return Account_Type;
	}
	public void setAccount_Type(String Account_Type)
	{
		this.Account_Type=Account_Type;
	}

	
	//Dep_Account_Type
		private String Dep_Account_Type;
		public String getDep_Account_Type()
		{
			return Dep_Account_Type;
		}
		public void setDep_Account_Type(String Dep_Account_Type)
		{
			this.Dep_Account_Type=Dep_Account_Type;
		}
	
	private String Maturity_Date;
	public String getMaturity_Date()
	{
		return Maturity_Date;
	}
	public void setMaturity_Date(String Maturity_Date)
	{
		this.Maturity_Date=Maturity_Date;
	}

	private float Maturity_Amount;
	public float getMaturity_Amount()
	{
		return Maturity_Amount;
	}
	public void setMaturity_Amount(float Maturity_Amount)
	{
		this.Maturity_Amount=Maturity_Amount;
	}
	
	
	private String Customer_Name1;

	
	
	
	

	
	
	

	
	
	
	private String Customer_Name;

	public String getCustomer_Name()
	{
		return Customer_Name;
	}
	public void setCustomer_Name(String Customer_Name)
	{
		this.Customer_Name=Customer_Name;
	}

	
	
	
	
	
	
	
	
	
	   
	 
		 
	      
		private int BankFlag=1;
		public int getBankFlag()
		{
			return BankFlag;
		}
		public void setBankFlag(int BankFlag)
		{
			this.BankFlag=BankFlag;
		}   
		
		
		
		
		private int BankCode;
		public int getBankCode()
		{
			return BankCode;
		}
		public void setBankCode(int BankCode)
		{
			this.BankCode=BankCode;
		} 
		
		
		
		
		
		private int SaveFlag=1;
		public int getSaveFlag()
		{
			return SaveFlag;
		}
		public void setSaveFlag(int SaveFlag)
		{
			this.SaveFlag=SaveFlag;
		}
		
		
		
		private int DeleteFlag=1;
		public int getDeleteFlag()
		{
			return DeleteFlag;
		}
		public void setDeleteFlag(int DeleteFlag)
		{
			this.DeleteFlag=DeleteFlag;
		}
	public DL_Master(){}
	
	
	
	private String User;
	public String getUser()
	{
		return User;
	}

	public void setUser(String User)
	{
		this.User=User;
	}

	private int Bcode;
	public int getBcode()
	{
		return Bcode;
	}
	public void setBcode(int Bcode)
	{
		this.Bcode=Bcode;
	}
	
	
	private String CurrentDate;
	public String getCurrentDate()
	{
		return CurrentDate;
	}

	public void setCurrentDate(String CurrentDate)
	{
		this.CurrentDate=CurrentDate;
	}
	
	
	
	
	
	//
	//Scheme_code
	
	private String Scheme_Code;
	public String getScheme_Code()
	{
		return Scheme_Code;
	}

	public void setScheme_Code(String Scheme_Code)
	{
		this.Scheme_Code=Scheme_Code;
	}
	
	
	
	
	
	
	//FirstCusInfo
	public DL_Master(String User,int Bcode,String CurrentDate)
	{
		this.CurrentDate=CurrentDate;
		this.Bcode=Bcode;
		this.User=User;
	}
	



 
 //Transaction_Amount
 private float Transaction_Amount;
 public float getTransaction_Amount()
 {
 	return Transaction_Amount;
 }
 public void setTransaction_Amount(float Transaction_Amount)
 {
 	this.Transaction_Amount=Transaction_Amount;
 }
 
 private String PAN_No;	
 public String getPAN_No()
 {
 	return PAN_No;
 }
 public void setPAN_No(String PAN_No)
 {
 	this.PAN_No=PAN_No;
 }
	public String getCusString1() {
	return CusString1;
}
public void setCusString1(String cusString1) {
	CusString1 = cusString1;
}








	public List<ArrayList> getDL_MasterAcc_list() {
	return DL_MasterAcc_list;
}
public void setDL_MasterAcc_list(List<ArrayList> dL_MasterAcc_list) {
	DL_MasterAcc_list = dL_MasterAcc_list;
}



	public String getOTP() {
	return OTP;
}
public void setOTP(String oTP) {
	OTP = oTP;
}



	public String getCheck_Otp() {
	return Check_Otp;
}
public void setCheck_Otp(String check_Otp) {
	Check_Otp = check_Otp;
}



	public String getMode_of_Receipt2() {
	return Mode_of_Receipt2;
}
public void setMode_of_Receipt2(String mode_of_Receipt2) {
	Mode_of_Receipt2 = mode_of_Receipt2;
}



	private String CusString1;
	
	
	
	
	private List<ArrayList> DL_MasterAcc_list;
	
	private String OTP;
	
	
	private String Check_Otp;
	
	
	private String Mode_of_Receipt2;
	
}
