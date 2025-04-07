

	
	
	package com.Pisquare.Beans;

	import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

	public class SBCA_Master 
	{
		private int Branch_Code;
		private String Account_No;	
		
		@NotNull(message = "Please enter Customer Id.")
		private int Customer_Id;	
		private String Customer_Name;	
		private Date Open_Date;
		private String Scheme_Code;
		private String Mode_Of_Operation;	
		
		private String Nominee_Name;	
		private String Nominee_Relationship;	
		private String Nominee_Age;	
		private int Opening_Balance;	
		private float Closing_Balance;	
		private String Last_Transaction_Date;
		private String Last_Int_Applied_Date;
		private String Account_Status;	
		private String Closed_Date;	
		private String Remarks;	
		private String Created_By;	
		private String Created_Date; 	
		private String Modified_By;	
		private String Modified_Date;	
		private String Authorized_By;	
		private String Authorized_Date;
		private String Nominee_DOB;	
		private String Old_Cus_Id;	
		private String Old_Acc_No;	
		
		private int Customer_Id_2;	
		private String Customer_Name_2;	
		private int Customer_Id_3;	
		private String Customer_Name_3;
		
		
		public int getBranch_Code()
		{
			return Branch_Code;
		}
		public void setBranch_Code(int Branch_Code)
		{
			this.Branch_Code= Branch_Code;
		}
		
		
		public String getAccount_No()
		{
			return Account_No;
			}
	    public void setAccount_No(String Account_No)
	    {
	    	this.Account_No=Account_No;
	    }

	    
	    
	    public int getCustomer_Id()
	    {
	    	return Customer_Id;
	    }
	    public void setCustomer_Id(int Customer_Id)
	    {
	    	this.Customer_Id=Customer_Id;
	    }
	    
	    
	    
	    public String getCustomer_Name()
	     {
	    	 return Customer_Name;
	    	 }
	     public void setCustomer_Name(String i)
	     {
	    	 this.Customer_Name=i;
	     }
	    
	     
	     
	     public Date getOpen_Date()
	     {
	    	 return Open_Date;
	     }
	     public void setOpen_Date(Date Open_Date)
	     {
	    	 this.Open_Date=Open_Date;
	    	 }
	     
	     
	     
	     public String getScheme_Code()
	     {
	    	 return Scheme_Code;
	     }
	     public void setScheme_Code(String Scheme_Code)
	     {
	    	 this.Scheme_Code=Scheme_Code;
	     }
	     
	     
	     
	     public String getMode_Of_Operation()
	     {
	    	 return  Mode_Of_Operation;
	     }
	     public void setMode_Of_Operation(String  Mode_Of_Operation)
	     {
	    	 this.Mode_Of_Operation=Mode_Of_Operation;
	     }


	     
	     public String getNominee_Name()
	     {
	    	 return Nominee_Name;
	     }
	     public void setNominee_Name(String Nominee_Name)
	     {
	    	 this.Nominee_Name=Nominee_Name;
	     }
	    
	     
	     
	     public String getNominee_Relationship()
	     {
	    	 return Nominee_Relationship;
	    	 }
	     public void setNominee_Relationship(String Nominee_Relationship)
	     {
	    	 this.Nominee_Relationship=Nominee_Relationship;
	     }
	  
	     
	     
	     public String getNominee_Age()
	     {
	    	 return Nominee_Age;
	     }
	     public void setNominee_Age(String Nominee_Age)
	     {
	    	 this.Nominee_Age=Nominee_Age;
	     }
	    
	     
	     
	     public int getOpening_Balance()
	     {
	    	 return Opening_Balance;
	     }
	     public void setOpening_Balance(int Opening_Balance)
	     {
	    	 this.Opening_Balance=Opening_Balance;
	     }
	    
	     
	     
	     public float getClosing_Balance()
	     {
	    	 return Closing_Balance;
	     }
	      public void setClosing_Balance(float Closing_Balance)
	      {
	    	  this.Closing_Balance=Closing_Balance;
	      }
	    
	      
	      
	      public String getLast_Transaction_Date()
	      {
	    	  return Last_Transaction_Date;
	      }
	      public void setLast_Transaction_Date(String Last_Transaction_Date)
	      {
	    	  this.Last_Transaction_Date=Last_Transaction_Date;
	      }
	      
	      
	      
	      public String getLast_Int_Applied_Date()
	      {
	    	  return Last_Int_Applied_Date;
	       }
	      public void setLast_Int_Applied_Date(String Last_Int_Applied_Date)
	      {
	    	  this.Last_Int_Applied_Date=Last_Int_Applied_Date;
	      }
	     
	      
	      
	      public String getAccount_Status()
	      {
	    	  return Account_Status;
	      }
	      public void setAccount_Status(String Account_Status)
	      {
	    	  this.Account_Status=Account_Status;
	      }
	    
	      
	      
	      public String getClosed_Date()
	      {
	    	  return Closed_Date;
	      }
	      public void setClosed_Date(String Closed_Date )
	      {
	    	  this.Closed_Date=Closed_Date;
	      }
	     
	      
	      public String getRemarks()
	      {
	    	  return Remarks;
	      }
	      public void setRemarks(String Remarks)
	      {
	    	  this.Remarks=Remarks;
	      }
	      
	      
	      
	      public String getCreated_By()
	      {
	    	  return Created_By;
	      }
	      public void setCreated_By(String Created_By)
	      {
	    	  this.Created_By=Created_By;
	      }
	     
	      
	      
	      public String getCreated_Date()
	      {
	    	  return Created_Date;
	      }
	      public void setCreated_Date(String Created_Date)
	      {
	    	  this.Created_Date=Created_Date;
	      }
	      
	      
	      
	      public String getModified_By()
	      {
	    	  return Modified_By;
	    	  }
	      public void setModified_By(String Modified_By)
	      {
	    	  this.Modified_By=Modified_By;
	      }
	    
	      
	      
	      public String getModified_Date()
	      {
	    	  return Modified_Date;
	      }
	      public void setModified_Date(String Modified_Date)
	      {
	    	  this.Modified_Date=Modified_Date;
	    	 }
	     
	      
	      public String getAuthorized_By()
	      {
	    	  return Authorized_By;
	      }
	      public void setAuthorized_By(String Authorized_By)
	      {
	    	  this.Authorized_By=Authorized_By;
	      }
	      
	      public String getAuthorized_Date()
	      {
	    	  return Authorized_Date;
	      }
	      public void setAuthorized_Date(String Authorized_Date)
	      {
	    	  this.Authorized_Date=Authorized_Date;
	      }
	      
	      
	      
	      public String getNominee_DOB()
	      {
	    	  return Nominee_DOB;
	      }
	      public void setNominee_DOB(String Nominee_DOB)
	      {
	    	  this.Nominee_DOB=Nominee_DOB;
	      }
	      
	      
	      
	      public String getOld_Cus_Id()
	      {
	    	  return Old_Cus_Id;
	      }
	      public void setOld_Cus_Id(String Old_Cus_Id)
	      {
	    	  this.Old_Cus_Id=Old_Cus_Id;
	      }
	     
	      
	      
	      public String getOld_Acc_No()
	      {
	    	  return Old_Acc_No;
	      }
	      public void setOld_Acc_No(String Old_Acc_No)
	      {
	    	  this.Old_Acc_No=Old_Acc_No;
	      }
	      
	      
	      
	      public int  getCustomer_Id_2()
	      {
	    	  return Customer_Id_2;
	      }
	      public void setCustomer_Id_2(int  Customer_Id_2)
	      {
	    	  this. Customer_Id_2= Customer_Id_2;
	      }
	     
	      
	      
	      public String getCustomer_Name_2()
	      {
	    	  return Customer_Name_2;
	      }
	      public void setCustomer_Name_2(String Customer_Name_2)
	      {
	    	  this.Customer_Name_2=Customer_Name_2;
	      }
	      
	      
	      
	      public int getCustomer_Id_3()
	      {
	    	  return Customer_Id_3;
	      }
	      public void setCustomer_Id_3(int  Customer_Id_3)
	      {
	    	  this.Customer_Id_3= Customer_Id_3;
	      }
	     
	      
	      
	      public String getCustomer_Name_3()
	      {
	    	  return Customer_Name_3;
	      }
	      public void setCustomer_Name_3(String Customer_Name_3)
	      {
	    	  this.Customer_Name_3=Customer_Name_3;
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
	  	
	  	
	  	
	  	private String Transaction_Type;
	  	public String getTransaction_Type()
	  	{
	  		return Transaction_Type;
	  	}
	  	
	  	public void setTransaction_Type(String Transaction_Type)
	  	{
	  		this.Transaction_Type=Transaction_Type;
	  	}
	  	
	  	private float Transaction_Amount;
	  	public float getTransaction_Amount()
	  	{
	  		return Transaction_Amount;
	  	}
	  	
	  	public void setTransaction_Amount(float Transaction_Amount)
	  	{
	  		this.Transaction_Amount=Transaction_Amount;
	  	}
	  	
	  	private String Transaction_Particulars;
	  	public String getTransaction_Particulars()
	  	{
	  		return Transaction_Particulars;
	  	}
	  	
	  	public void setTransaction_Particulars(String Transaction_Particulars)
	  	{
	  		this.Transaction_Particulars=Transaction_Particulars;
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

	      
	private String Share_Type;
	public String getShare_Type()
	{
		return Share_Type;
	}
	public void setShare_Type(String Share_Type)
	{
		this.Share_Type=Share_Type;
	}
	
	
	private String Customer_Info;
	public String getCustomer_Info()
	{
		return Customer_Info;
	}
	public void setCustomer_Info(String Customer_Info)
	{
		this.Customer_Info=Customer_Info;
	}
	
	//-------------------------------------------------------For SD_Closure----------------------
	
	private String GL_General;
	public String getGL_General()
	{
		return GL_General;
	}
	public void setGL_General(String GL_General)
	{
		this.GL_General=GL_General;
	}
	
	
	
	//InterestRate
	
	private float InterestRate;
	public float getInterestRate()
	{
		return InterestRate;
	}
	public void setInterestRate(float InterestRate)
	{
		this.InterestRate=InterestRate;
	}
	
	
	
	//Closure_Charges
	
	private float Closure_Charges;
	public float getClosure_Charges()
	{
		return Closure_Charges;
	}
	public void setClosure_Charges(float Closure_Charges)
	{
		this.Closure_Charges=Closure_Charges;
	}
	
	
	
	//--------------------------SB_Account_Statement--------------------------------------------
	
	String From_Date;
	public String getFrom_Date()
		{
			return From_Date;
			
		}
		
		public void setFrom_Date(String From_Date)
		{
			this.From_Date=From_Date;
		}
		
		
		
		String To_Date;
		public String getTo_Date()
			{
				return To_Date;
				
			}
			
			public void setTo_Date(String To_Date)
			{
				this.To_Date=To_Date;
			}
	
			
			
			private String GL_Info;
			public String getGL_Info()
			{
				return GL_Info;
			}
			
			public void setGL_Info(String GL_Info)
			{
				this.GL_Info=GL_Info;
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
			
			
			
			
			
			
			//---------------------------------------
			
			private float SB_ClosingBalance;
			 public float getSB_ClosingBalance()
		     {
		    	 return SB_ClosingBalance;
		     }
		      public void setSB_ClosingBalance(float SB_ClosingBalance)
		      {
		    	  this.SB_ClosingBalance=SB_ClosingBalance;
		      }
		    
			
			
		      private float Transfer_ClosingBalance;
				 public float getTransfer_ClosingBalance()
			     {
			    	 return Transfer_ClosingBalance;
			     }
			      public void setTransfer_ClosingBalance(float Transfer_ClosingBalance)
			      {
			    	  this.Transfer_ClosingBalance=Transfer_ClosingBalance;
			      }
			    
			
			      private String Open_Date1;
					 public String getOpen_Date1()
				     {
				    	 return Open_Date1;
				     }
				      public void setOpen_Date1(String Open_Date1)
				      {
				    	  this.Open_Date1=Open_Date1;
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
				  	
				  	//-----------------Inter Branch---------------------------------
				  	private String Branch_Type;
					
					public String getBranch_Type()
					{
						return Branch_Type;
					}

					public void setBranch_Type(String Branch_Type)
					{
						this.Branch_Type=Branch_Type;
						
					}
					
					private float Interest_Rate;
					public float getInterest_Rate() {
						return Interest_Rate;
					}
					public void setInterest_Rate(float interest_Rate) {
						Interest_Rate = interest_Rate;
					}

	}


