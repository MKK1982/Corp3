

	
	
	package com.Pisquare.Beans;

	import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

	public class Verify_Transaction 
	{
		
		private String Account_No;	
		
		
		public String getAccount_No()
		{
			return Account_No;
			}
	    public void setAccount_No(String Account_No)
	    {
	    	this.Account_No=Account_No;
	    }

	    
	 
	      
	   //--------------------------------For Transaction--------------------------------------------------------///   

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
	  	
	  	
	  	
			private int Flag=1;
			public int getFlag()
			{
				return Flag;
			}
			public void setFlag(int Flag)
			{
				this.Flag=Flag;
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
			
			
			
			private int UpdateFlag=1;
			public int getUpdateFlag()
			{
				return UpdateFlag;
			}
			public void setUpdateFlag(int UpdateFlag)
			{
				this.UpdateFlag=UpdateFlag;
			}
			
			
			
			
			private int Verify1Flag=1;
			public int getVerify1Flag()
			{
				return Verify1Flag;
			}
			public void setVerify1Flag(int Verify1Flag)
			{
				this.Verify1Flag=Verify1Flag;
			}
			
			
			private int Verify2Flag=1;
			public int getVerify2Flag()
			{
				return Verify2Flag;
			}
			public void setVerify2Flag(int Verify2Flag)
			{
				this.Verify2Flag=Verify2Flag;
			}
			
			private int Verify3Flag=1;
			public int getVerify3Flag()
			{
				return Verify3Flag;
			}
			public void setVerify3Flag(int Verify3Flag)
			{
				this.Verify3Flag=Verify3Flag;
			}
			
			
			private int Verify4Flag=1;
			public int getVerify4Flag()
			{
				return Verify4Flag;
			}
			public void setVerify4Flag(int Verify4Flag)
			{
				this.Verify4Flag=Verify4Flag;
			}
			
			private int Verify5Flag=1;
			public int getVerify5Flag()
			{
				return Verify5Flag;
			}
			public void setVerify5Flag(int Verify5Flag)
			{
				this.Verify5Flag=Verify5Flag;
			}
		
			



			private int Bcode;
			public int getBcode() {
				return Bcode;
			}
			public void setBcode(int bcode) {
				Bcode = bcode;
			}

			
			private String TDate1;	
			public String getTDate1() {
				return TDate1;
			}
			public void setTDate1(String tDate1) {
				TDate1 = tDate1;
			}

			private int page=1;
			public int getPage() {
				return page;
			}
			public void setPage(int page) {
				this.page = page;
			}

			
//FingerPrint

public String getUserName() {
				return UserName;
			}
			public void setUserName(String userName) {
				UserName = userName;
			}




public int getFingerVerify1Flag1() {
				return FingerVerify1Flag1;
			}
			public void setFingerVerify1Flag1(int fingerVerify1Flag1) {
				FingerVerify1Flag1 = fingerVerify1Flag1;
			}




public int getFingerVerify1Flag2() {
				return FingerVerify1Flag2;
			}
			public void setFingerVerify1Flag2(int fingerVerify1Flag2) {
				FingerVerify1Flag2 = fingerVerify1Flag2;
			}




public int getFingerVerify1Flag3() {
				return FingerVerify1Flag3;
			}
			public void setFingerVerify1Flag3(int fingerVerify1Flag3) {
				FingerVerify1Flag3 = fingerVerify1Flag3;
			}




public int getFingerVerify1Flag4() {
				return FingerVerify1Flag4;
			}
			public void setFingerVerify1Flag4(int fingerVerify1Flag4) {
				FingerVerify1Flag4 = fingerVerify1Flag4;
			}




public int getFingerVerify1Flag5() {
				return FingerVerify1Flag5;
			}
			public void setFingerVerify1Flag5(int fingerVerify1Flag5) {
				FingerVerify1Flag5 = fingerVerify1Flag5;
			}




private String UserName;
			
			private int FingerVerify1Flag1=1;
			private int FingerVerify1Flag2=1;
			private int FingerVerify1Flag3=1;
			private int FingerVerify1Flag4=1;
			private int FingerVerify1Flag5=1;
	}


