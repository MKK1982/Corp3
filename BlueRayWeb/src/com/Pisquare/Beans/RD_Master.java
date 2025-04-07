package com.Pisquare.Beans;

import java.util.List;

public class RD_Master {

	public RD_Master() 
	{
		
	}
	private int Branch_Code;
	private String Account_No;
	private int No_of_Inst_Paying;
	private int No_of_Inst_Paying2;
	private String Transaction_Date;
    private String Account_Status;
	private float Transaction_Amount;
	private int Transaction_Id;
    private String Transaction_Type;
    private int Customer_Id;
    private int Customer_Id1;
	private int Customer_Id2;
	private int Customer_Id3;

	private String Scheme_Type;
	private String Scheme_Type2;
    private String Period;
	private String Period2;
	private String Open_Date;
	private float Interest_Rate;
    private String Mop;
    private String Mop2;
    private String Effect_Date;
	private float Deposit_Amount;
	private String Interest_Repayment;
	private String Interest_Repayment2;
    private String Compounding;
	private String Compounding2;
	private String Int_Payment_Mode;
	private String Standing_Scheme;
	private String Standing_Scheme2;
   
	//old private int Standing_Acc_No;
	//new
	private long Standing_Acc_No;
	private String Maturity_Date;
	private float Maturity_Amount;
	private String Nominee_Name;
    private String Nominee_Relationship;
	private String Nominee_Age;
	private String Customer_Name1;
	private String Customer_Name2;
	private String Customer_Name3;

	private float Closing_Balance;
	private String Customer_Info;
	private float Instalment_Amount;
	private float Lien_Interest;
	private int Instalment_Count;
	private int No_of_Inst_Paid;
	private String Scheme_Code;
	private int GL_Code;
	private float Penalty_Interest;
	private String Mode_of_Receipt;
	private String Mode_of_Receipt2;
	//old private int Transfer_Acc_No;
	//new
	private long Transfer_Acc_No;
	
	private String Transfer_ACC_Name;
	public String Narration;
	private String GL_Info;
	private String Bank_Name;	  
	private String Ifsc_Code;
	 private long Neft_Account_Number;
	   private int Lien_No;
	   private float Principle_Payable;
	   private float Interest_Payable;
	   private float Lien_Amount;
	   private String Mode_of_Payment;
	   private String Mode_of_Payment2;
	   private String Account_Status2;
	   private int Interest_Credit_Account;
	   private String Financial_Year;
	  

    private int Flag=1;
	    
    public int getInterest_Credit_Account()
	{
		return Interest_Credit_Account;
	}
	public void setInterest_Credit_Account(int Interest_Credit_Account)
	{
		this.Interest_Credit_Account=Interest_Credit_Account;
	}
    
	private String csrfToken;
	public String getCsrfToken() {
		return csrfToken;
	}
	public void setCsrfToken(String csrfToken) {
		this.csrfToken = csrfToken;
	}
    public int getBranch_Code()
	{
		return Branch_Code;
	}
	public void setBranch_Code(int Branch_Code)
	{
		this.Branch_Code=Branch_Code;
	}
    
	
	    public int getCustomer_Id()
		{
			return Customer_Id;
		}
		public void setCustomer_Id(int Customer_Id)
		{
			this.Customer_Id=Customer_Id;
		}
	
	

	    public int getCustomer_Id2()
		{
			return Customer_Id2;
		}
		public void setCustomer_Id2(int Customer_Id2)
		{
			this.Customer_Id2=Customer_Id2;
		}
		
		  public int getCustomer_Id3()
			{
				return Customer_Id3;
			}
			public void setCustomer_Id3(int Customer_Id3)
			{
				this.Customer_Id3=Customer_Id3;
			}
	
		public String getScheme_Type()
		{
			return Scheme_Type;
		}
		public void setScheme_Type(String Scheme_Type)
		{
			this.Scheme_Type=Scheme_Type;
		}
		
		public String getScheme_Type2()
		{
			return Scheme_Type2;
		}
		public void setScheme_Type2(String Scheme_Type2)
		{
			this.Scheme_Type2=Scheme_Type2;
		}
	
		
		public String getPeriod()
		{
			return Period;
		}
		public void setPeriod(String Period)
		{
			this.Period=Period;
		}
		
		public String getPeriod2()
		{
			return Period2;
		}
		public void setPeriod2(String Period2)
		{
			this.Period2=Period2;
		}
		
		public String getOpen_Date()
		{
			return Open_Date;
		}
		public void setOpen_Date(String Open_Date)
		{
			this.Open_Date=Open_Date;
		}

		public float getInterest_Rate()
		{
			return Interest_Rate;
		}
		public void setInterest_Rate(float Interest_Rate)
		{
			this.Interest_Rate=Interest_Rate;
		}
		
	
		

		public String getMop()
		{
			return Mop;
		}
		public void setMop(String Mop)
		{
			this.Mop=Mop;
		}
		
		public String getMop2()
		{
			return Mop2;
		}
		public void setMop2(String Mop2)
		{
			this.Mop2=Mop2;
		}
		
		

		public String getEffect_Date()
		{
			return Effect_Date;
		}
		public void setEffect_Date(String Effect_Date)
		{
			this.Effect_Date=Effect_Date;
		}

		
		public float getDeposit_Amount()
		{
			return Deposit_Amount;
		}
		public void setDeposit_Amount(float Deposit_Amount)
		{
			this.Deposit_Amount=Deposit_Amount;
		}
		
		
		public String getInterest_Repayment()
		{
			return Interest_Repayment;
		}
		public void setInterest_Repayment(String Interest_Repayment)
		{
			this.Interest_Repayment=Interest_Repayment;
		}


		public String getInterest_Repayment2()
		{
			return Interest_Repayment2;
		}
		public void setInterest_Repayment2(String Interest_Repayment2)
		{
			this.Interest_Repayment2=Interest_Repayment2;
		}
		
		
		
		public String getCompounding()
		{
			return Compounding;
		}
		public void setCompounding(String Compounding)
		{
			this.Compounding=Compounding;
		}
		
		public String getCompounding2()
		{
			return Compounding2;
		}
		public void setCompounding2(String Compounding2)
		{
			this.Compounding2=Compounding2;
		}
		
		

		public String getInt_Payment_Mode()
		{
			return Int_Payment_Mode;
		}
		public void setInt_Payment_Mode(String Int_Payment_Mode)
		{
			this.Int_Payment_Mode=Int_Payment_Mode;
		}
		
		public String getStanding_Scheme()
		{
			return Standing_Scheme;
		}
		public void setStanding_Scheme(String Standing_Scheme)
		{
			this.Standing_Scheme=Standing_Scheme;
		}
		
		public String getStanding_Scheme2()
		{
			return Standing_Scheme2;
		}
		public void setStanding_Scheme2(String Standing_Scheme2)
		{
			this.Standing_Scheme2=Standing_Scheme2;
		}
		
		
		
		
		public long getStanding_Acc_No()
		{
			return Standing_Acc_No;
		}
		public void setStanding_Acc_No(long Standing_Acc_No)
		{
			this.Standing_Acc_No=Standing_Acc_No;

	}
		
		public String getMaturity_Date()
		{
			return Maturity_Date;
		}
		public void setMaturity_Date(String Maturity_Date)
		{
			this.Maturity_Date=Maturity_Date;
		}

		
		public float getMaturity_Amount()
		{
			return Maturity_Amount;
		}
		public void setMaturity_Amount(float Maturity_Amount)
		{
			this.Maturity_Amount=Maturity_Amount;
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
	

		public String getCustomer_Name1()
		{
			return Customer_Name1;
		}
		public void setCustomer_Name1(String Customer_Name1)
		{
			this.Customer_Name1=Customer_Name1;
		}



		public String getCustomer_Name2()
		{
			return Customer_Name2;
		}
		public void setCustomer_Name2(String Customer_Name2)
		{
			this.Customer_Name2=Customer_Name2;
		}
			
		public String getCustomer_Name3()
		{
			return Customer_Name3;
		}
		public void setCustomer_Name3(String Customer_Name3)
		{
			this.Customer_Name3=Customer_Name3;
		}
	
		   public int getFlag()
			{
				return Flag;
			}
			public void setFlag(int Flag)
			{
				this.Flag=Flag;
			}
		
		
			public float getClosing_Balance()
			{
				return Closing_Balance;
			}
			public void setClosing_Balance(float Closing_Balance)
			{
				this.Closing_Balance=Closing_Balance;
			}
			   
			   
			
		
			
				 public String getCustomer_Info()
					{
						return Customer_Info;
					}
					public void setCustomer_Info(String Customer_Info)
					{
						this.Customer_Info=Customer_Info;
					}
				
					public float getInstalment_Amount()
					{
						return Instalment_Amount;
					}
					public void setInstalment_Amount(float Instalment_Amount)
					{
						this.Instalment_Amount=Instalment_Amount;
					}
			
					
					  public int getInstalment_Count()
						{
							return Instalment_Count;
							}
					   public void setInstalment_Count(int Instalment_Count)
					   {
					   	this.Instalment_Count=Instalment_Count;
					   }
			
					   public int getNo_of_Inst_Paid()
						{
							return No_of_Inst_Paid;
							}
					   public void setNo_of_Inst_Paid(int No_of_Inst_Paid)
					   {
					   	this.No_of_Inst_Paid=No_of_Inst_Paid;
					   }
					  
					   
					   public String getScheme_Code()
					   {
					  	 return Scheme_Code;
					   }
					   public void setScheme_Code(String Scheme_Code)
					   {
					  	 this.Scheme_Code=Scheme_Code;
					   }
					   
					   

					   public int getGL_Code()
					   {
					  	 return GL_Code;
					   }
					   public void setGL_Code(int GL_Code)
					   {
					  	 this.GL_Code=GL_Code;
					   }
					   
					
					   
					   public float getPenalty_Interest()
						{
							return Penalty_Interest;
						}
						public void setPenalty_Interest(float Penalty_Interest)
						{
							this.Penalty_Interest=Penalty_Interest;
						}
					   
					
						public String getMode_of_Receipt()
						   {
						  	 return Mode_of_Receipt;
						   }
						   public void setMode_of_Receipt(String Mode_of_Receipt)
						   {
						  	 this.Mode_of_Receipt=Mode_of_Receipt;
						   }
					   
						   
						   public String getMode_of_Receipt2()
						   {
						  	 return Mode_of_Receipt2;
						   }
						   public void setMode_of_Receipt2(String Mode_of_Receipt2)
						   {
						  	 this.Mode_of_Receipt2=Mode_of_Receipt2;
						   }
						   
						   public long getTransfer_Acc_No()
							{
								return Transfer_Acc_No;
								}
						   public void setTransfer_Acc_No(long Transfer_Acc_No)
						   {
						   	this.Transfer_Acc_No=Transfer_Acc_No;
						   }   
						   
						   

							public String getTransfer_ACC_Name()
							   {
							  	 return Transfer_ACC_Name;
							   }
							   public void setTransfer_ACC_Name(String Transfer_ACC_Name)
							   {
							  	 this.Transfer_ACC_Name=Transfer_ACC_Name;
							   }
						   
							   

								public String getNarration()
								   {
								  	 return Narration;
								   }
								   public void setNarration(String Narration)
								   {
								  	 this.Narration=Narration;
								   }
							   
								   	
								   
								   public String getGL_Info()
								   {
								  	 return GL_Info;
								   }
								   public void setGL_Info(String GL_Info)
								   {
								  	 this.GL_Info=GL_Info;
								   }
					   
								 
									
									public String getAccount_No()
									{
										return Account_No;
									}
									public void setAccount_No(String Account_No)
									{
										this.Account_No=Account_No;
									}
									
									  public int getNo_of_Inst_Paying()
										{
											return No_of_Inst_Paying;
											}
									   public void setNo_of_Inst_Paying(int No_of_Inst_Paying)
									   {
									   	this.No_of_Inst_Paying=No_of_Inst_Paying;
									   }

									

									   public int getNo_of_Inst_Paying2()
										{
											return No_of_Inst_Paying2;
											}
									   public void setNo_of_Inst_Paying2(int No_of_Inst_Paying2)
									   {
									   	this.No_of_Inst_Paying2=No_of_Inst_Paying2;
									   }
									
									   public String getTransaction_Date()
										{
											return Transaction_Date;
										}
										public void setTransaction_Date(String Transaction_Date)
										{
											this.Transaction_Date=Transaction_Date;
										} 
									   
										   public String getAccount_Status()
										   {
										  	 return Account_Status;
										   }
										   public void setAccount_Status(String Account_Status)
										   {
										  	 this.Account_Status=Account_Status;
										   }
										   
											public float getTransaction_Amount()
											{
												return Transaction_Amount;
											}
											public void setTransaction_Amount(float Transaction_Amount)
											{
												this.Transaction_Amount=Transaction_Amount;
											}
											
											 public int getTransaction_Id()
												{
													return Transaction_Id;
													}
											   public void setTransaction_Id(int Transaction_Id)
											   {
											   	this.Transaction_Id=Transaction_Id;
											   }
											   
											   
											   public String getTransaction_Type()
											   {
											  	 return Transaction_Type;
											   }
											   public void setTransaction_Type(String Transaction_Type)
											   {
											  	 this.Transaction_Type=Transaction_Type;
											   }  
											   
											   public String getBank_Name()
											   {
											  	 return Bank_Name;
											   }
											   public void setBank_Name(String Bank_Name)
											   {
											  	 this.Bank_Name=Bank_Name;
											   } 
											   
											   
											   

											   public String getIfsc_Code()
											   {
											  	 return Ifsc_Code;
											   }
											   public void setIfsc_Code(String Ifsc_Code)
											   {
											  	 this.Ifsc_Code=Ifsc_Code;
											   } 
											   
											   
											   
											   public long getNeft_Account_Number()
											   {
												 return Neft_Account_Number;  
											   }
											   public void setNeft_Account_Number(long Neft_Account_Number)
											   {
												   this.Neft_Account_Number=Neft_Account_Number;
											   }
											   
											   
											   
											   public int getLien_No()
											   {
												 return Lien_No;  
											   }
											   public void setLien_No(int Lien_No)
											   {
												   this.Lien_No=Lien_No;
											   } 
											   
											   
											   
											   
											   public float getPrinciple_Payable()
											   {
											  	 return Principle_Payable;
											   }
											   public void setPrinciple_Payable(float Principle_Payable)
											   {
											  	 this.Principle_Payable=Principle_Payable;
											   } 
											   
											   
											   public float getInterest_Payable()
											   {
											  	 return Interest_Payable;
											   }
											   public void setInterest_Payable(float Interest_Payable)
											   {
											  	 this.Interest_Payable=Interest_Payable;
											   }
											   
											   
											   
											   public float getLien_Amount()
											   {
											  	 return Lien_Amount;
											   }
											   public void setLien_Amount(float Lien_Amount)
											   {
											  	 this.Lien_Amount=Lien_Amount;
											   }
											   
											   
									 		   
												public String getMode_of_Payment()
												   {
												  	 return Mode_of_Payment;
												   }
												   public void setMode_of_Payment(String Mode_of_Payment)
												   {
												  	 this.Mode_of_Payment=Mode_of_Payment;
												   }
											   
													public String getMode_of_Payment2()
													   {
													  	 return Mode_of_Payment2;
													   }
													   public void setMode_of_Payment2(String Mode_of_Payment2)
													   {
													  	 this.Mode_of_Payment2=Mode_of_Payment2;
													   }

														public String getAccount_Status2()
														   {
														  	 return Account_Status2;
														   }
														   public void setAccount_Status2(String Account_Status2)
														   {
														  	 this.Account_Status2=Account_Status2;
														   }							   
													   
												   
											   
															private boolean Sr_Ctzn=false;

															public boolean getSr_Ctzn()
															{
																return Sr_Ctzn;
															}
															public void setSr_Ctzn(boolean Sr_Ctzn)
															{
																this.Sr_Ctzn=Sr_Ctzn;
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
															
															
															
															private String From_Date;
															public String getFrom_Date()
															   {
															  	 return From_Date;
															   }
															   public void setFrom_Date(String From_Date)
															   {
															  	 this.From_Date=From_Date;
															   }	
															
															   private String To_Date;
																public String getTo_Date()
																   {
																  	 return To_Date;
																   }
																   public void setTo_Date(String To_Date)
																   {
																  	 this.To_Date=To_Date;
																   }
															
															
															
																   private String Account_From=null;	
																	public String getAccount_From()
																	{
																		return Account_From;
																		}
																    public void setAccount_From(String Account_From)
																    {
																    	this.Account_From=Account_From;
																    }
																    
																    
																    private String Account_To=null;	
																	public String getAccount_To()
																	{
																		return Account_To;
																		}
																    public void setAccount_To(String Account_To)
																    {
																    	this.Account_To=Account_To;
																    }
															
															
																    String OpenFrom_Date=null;
																	public String getOpenFrom_Date()
																		{
																			return OpenFrom_Date;
																			
																		}
																		
																		public void setOpenFrom_Date(String OpenFrom_Date)
																		{
																			this.OpenFrom_Date=OpenFrom_Date;
																		}
																		
																
																String OpenTo_Date=null;
																public String getOpenTo_Date()
																	{
																		return OpenTo_Date;
																		
																	}
																	
																	public void setOpenTo_Date(String OpenTo_Date)
																	{
																		this.OpenTo_Date=OpenTo_Date;
																	}
															
															
																	 private int Value1=0;	
																		public int getValue1()
																		{
																			return Value1;
																			}
																	    public void setValue1(int Value1)
																	    {
																	    	this.Value1=Value1;
																	    }
																	    
																	    private int Value2=0;	
																		public int getValue2()
																		{
																			return Value2;
																			}
																	    public void setValue2(int Value2)
																	    {
																	    	this.Value2=Value2;
																	    }
													
																	    private String File_Type=null;
																		public String getFile_Type()
																		{
																			return File_Type;
																		}
																		public void setFile_Type(String File_Type)
																		{
																			this.File_Type=File_Type;
																		}
															
																		String ReportFrom_Date=null;
																		public String getReportFrom_Date()
																			{
																				return ReportFrom_Date;
																				
																			}
																			
																			public void setReportFrom_Date(String ReportFrom_Date)
																			{
																				this.ReportFrom_Date=ReportFrom_Date;
																			}
																		
																		
																			//8.
																			String ReportTo_Date=null;
																			public String getReportTo_Date()
																				{
																					return ReportTo_Date;
																					
																				}
																				
																				public void setReportTo_Date(String ReportTo_Date)
																				{
																					this.ReportTo_Date=ReportTo_Date;
																				}
																				
																				
																				int Closing_BalanceInfo=0;
																				public int getClosing_BalanceInfo()
																				{
																					return Closing_BalanceInfo;
																					
																				}
																				
																				public void setClosing_BalanceInfo(int Closing_BalanceInfo)
																				{
																					this.Closing_BalanceInfo=Closing_BalanceInfo;
																				}
																				
																				
																				private int GL_Int_Payable;
																				public int getGL_Int_Payable()
																				{
																					return GL_Int_Payable;
																				}
																				public void setGL_Int_Payable(int GL_Int_Payable)
																				{
																					this.GL_Int_Payable=GL_Int_Payable;
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
																				
																				private int Verify1=1;
																				public int getVerify1()
																				{
																					return Verify1;
																				}
																				public void setVerify1(int Verify1)
																				{
																					this.Verify1=Verify1;
																				}
																				
																				

																		
																				
																				private String Sr_Ctzn1=null;
					                                                              public String getSr_Ctzn1()
																				{
																					return Sr_Ctzn1;
																				}
																				public void setSr_Ctzn1(String Sr_Ctzn1)
																				{
																					this.Sr_Ctzn1=Sr_Ctzn1;
																				}
																				
																				private String Staff2=null;
					                                                            public String getStaff2()
																				{
																					return Staff2;
																				}
																				public void setStaff2(String Staff2)
																				{
																					this.Staff2=Staff2;
																				}
																				
																				
																				private int Verify2=1;
																				public int getVerify2()
																				{
																					return Verify2;
																				}
																				public void setVerify2(int Verify2)
																				{
																					this.Verify2=Verify2;
																				}
																				
																				  private int View=1;
																			         public int getView()
																				{
																				return View;
																				}
																				public void setView(int View)
																				{
																				this.View=View;
																			         }
																																	
																			   private int Save=1;
																			         public int getSave()
																				{
																				return Save;
																				}
																				public void setSave(int Save)
																				{
																				this.Save=Save;
																			         }
																			    
																			     private int Update=1;
																			      public int getUpdate()
																			      {
																			      return Update;
																			        }
																			    public void setUpdate(int Update)
																			      {
																				this.Update=Update;

																				}												    
																																	
																				 private int Delete=1;
																			      public int getDelete()
																			      {
																			      return Delete;
																			        }
																			    public void setDelete(int Delete)
																			      {
																				this.Delete=Delete;

																				}														
																																	
																																	
																				 private int Verify=1;
																			      public int getVerify()
																			      {
																			      return Verify;
																			        }
																			    public void setVerify(int Verify)
																			      {
																				this.Verify=Verify;

																				}													
																																	
																						
																			 private int Reports=1;
																			      public int getReports()
																			      {
																			      return Reports;
																			        }
																			    public void setReports(int Reports)
																			      {
																				this.Reports=Reports;

																				}	

																			 private int Verify_2=1;
																			      public int getVerify_2()
																			      {
																			      return Verify_2;
																			        }
																			    public void setVerify_2(int Verify_2)
																			      {
																				this.Verify_2=Verify_2;

																				}
																					

															


																				                                                                                  private String sv=null;
																																									public String getsv()
																																									{
																																										return sv;
																																									}
																																									public void setsv(String sv)
																																									{
																																										this.sv=sv;
																																									}
					
																				
																				
																				
					   
																																									
																																									   
																																									public RD_Master(String acno,String mor,int instantpayind,float transamt,float penalty)	
																																									{
																																										this.Account_No=acno;
																																										this.Mode_of_Receipt=mor;
																																									this.No_of_Inst_Paying=instantpayind;
																																										this.Transaction_Amount=transamt;
																																										this.Penalty_Interest=penalty;
																																									}
																																										
																																									
																																									public RD_Master(int cusid,int cusid2,int cusid3,String cusname,String cusname2,String cusname3,String schemetype,String accno,String period,String opendate,float interest,String mop,String effectdate,float depositamt,String insrepayment,String compounding,String paymentmode,String standingscheme,String matdate,float matamt,String nn,String nr,String na,String sctzn,String panno)
																																									{
																																										this.Customer_Id=cusid;
																																										this.Customer_Id2=cusid2;
																																										this.Customer_Id3=cusid3;
																																										this.Customer_Name1=cusname;
																																										this.Customer_Name2=cusname2;
																																										this.Customer_Name3=cusname3;
																																										this.Scheme_Type=schemetype;
																																										this.Account_No=accno;
																																										this.Period=period;
																																										this.Open_Date=opendate;
																																										this.Interest_Rate=interest;
																																										this.Mop=mop;
																																										this.Effect_Date=effectdate;
																																										this.Deposit_Amount=depositamt;
																																										this.Interest_Repayment=insrepayment;
																																										this.Compounding=compounding;
																																										this.Int_Payment_Mode=paymentmode;
																																										this.Standing_Scheme=standingscheme;
																																										this.Maturity_Date=matdate;
																																										this.Maturity_Amount=matamt;
																																										this.Nominee_Name=nn;
																																										this.Nominee_Relationship=nr;
																																                                        this.Nominee_Age=na;
																																										this.Sr_Ctzn1=sctzn;
																																										this.Pan_No=panno;
																																										
																																									}
																																									
																																								

																																									public RD_Master(String accno,float interestpayable,float lienamt,float transamt,String mop,int Lien_No)
																																																	{
																																																		this.Account_No=accno;
																																																		this.Interest_Payable=interestpayable;
																																																		this.Lien_Amount=lienamt;
																																																		this.Transaction_Amount=transamt;
																																																		this.Mode_of_Payment=mop;
																																																		this.Lien_No=Lien_No;
																																																	}																	
										
									
									
									//SelectedCheckBox
									List<Integer> SelectedCheckBox;
									
									public List<Integer> getSelectedCheckBox()
									{
										return SelectedCheckBox;
									}
									public void setSelectedCheckBox(List<Integer> SelectedCheckBox)
									{
										this.SelectedCheckBox=SelectedCheckBox;
									}
									
									

									//AccountList
									
									List<String> AccountList;
									
									public List<String> getAccountList()
									{
										return AccountList;
									}
									public void setAccountList(List<String> AccountList)
									{
										this.AccountList=AccountList;
									}
								
									//SelcetedIndex
									
							List<Integer> SelcetedIndex;
									
									public List<Integer> getSelcetedIndex()
									{
										return SelcetedIndex;
									}
									public void setSelcetedIndex(List<Integer> SelcetedIndex)
									{
										this.SelcetedIndex=SelcetedIndex;
									}
									
									
									
									List<Float> PenaltyList;
									
									public List<Float> getPenaltyList()
									{
										return PenaltyList;
									}
									public void setPenaltyList(List<Float> PenaltyList)
									{
										this.PenaltyList=PenaltyList;
									}
									
									
									private float Penalty;
									public float getPenalty()
									{
										return Penalty;
									}
									public void setPenalty(float Penalty)
									{
										this.Penalty=Penalty;
									}
									
											
									private String Pan_No=null;
                                    public String getPan_No()
									{
										return Pan_No;
									}
									public void setPan_No(String Pan_No)
									{
										this.Pan_No=Pan_No;
									}
									public int getCustomer_Id1() {
										return Customer_Id1;
									}
									public void setCustomer_Id1(int customer_Id1) {
										Customer_Id1 = customer_Id1;
									}
									
									public String getCusString1() {
										return CusString1;
									}
									public void setCusString1(String cusString1) {
										CusString1 = cusString1;
									}
									public String getCusString2() {
										return CusString2;
									}
									public void setCusString2(String cusString2) {
										CusString2 = cusString2;
									}
									public String getCusString3() {
										return CusString3;
									}
									public void setCusString3(String cusString3) {
										CusString3 = cusString3;
									}
									public String getCusString4() {
										return CusString4;
									}
									public void setCusString4(String cusString4) {
										CusString4 = cusString4;
									}
									private String CusString1;
									private String CusString2;
									private String CusString3;
									private String CusString4;
									
									
									
									
									//Super Senior


									
									
									
									private String Super_Senior;
									public String getSuper_Senior() {
										return Super_Senior;
									}
									public void setSuper_Senior(String super_Senior) {
										Super_Senior = super_Senior;
									}
									public float getLien_Interest() {
										return Lien_Interest;
									}
									public void setLien_Interest(
											float lien_Interest) {
										Lien_Interest = lien_Interest;
									}
									
									
									//Ajax
									//------------------------------
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
								//-----------------------------------------------
										public String getFinancial_Year() {
											return Financial_Year;
										}
										public void setFinancial_Year(
												String financial_Year) {
											Financial_Year = financial_Year;
										}

										
										public String getBranch_Type() {
											return Branch_Type;
										}
										public void setBranch_Type(
												String branch_Type) {
											Branch_Type = branch_Type;
										}
										public int getIBcode() {
											return IBcode;
										}
										public void setIBcode(int iBcode) {
											IBcode = iBcode;
										}
										public String getReport_Type() {
											return Report_Type;
										}
										public void setReport_Type(
												String report_Type) {
											Report_Type = report_Type;
										}
										public String getUIN_From() {
											return UIN_From;
										}
										public void setUIN_From(String uIN_From) {
											UIN_From = uIN_From;
										}
										public String getUIN_To() {
											return UIN_To;
										}
										public void setUIN_To(String uIN_To) {
											UIN_To = uIN_To;
										}
										public float getTemp_Amt() {
											return Temp_Amt;
										}
										public void setTemp_Amt(float temp_Amt) {
											Temp_Amt = temp_Amt;
										}
										public float getTemp_Amt1() {
											return Temp_Amt1;
										}
										public void setTemp_Amt1(float temp_Amt1) {
											Temp_Amt1 = temp_Amt1;
										}
										public String getDOB() {
											return DOB;
										}
										public void setDOB(String dOB) {
											DOB = dOB;
										}
										public String getFormG() {
											return FormG;
										}
										public void setFormG(String formG) {
											FormG = formG;
										}
										public String getScheme_Cat() {
											return Scheme_Cat;
										}
										public void setScheme_Cat(
												String scheme_Cat) {
											Scheme_Cat = scheme_Cat;
										}
										public String getRD_Digi_AccountNo() {
											return RD_Digi_AccountNo;
										}
										public void setRD_Digi_AccountNo(
												String rD_Digi_AccountNo) {
											RD_Digi_AccountNo = rD_Digi_AccountNo;
										}
										//For Inter Branch
										private String Branch_Type;
										 
										 private int IBcode;
										 
										 private String Report_Type;
										 private String UIN_From;
										 private String UIN_To;
										 
										 
										 private float Temp_Amt;
										 private float Temp_Amt1;
										 private String DOB;
										 private String FormG;
										 
										 private String Scheme_Cat;
										 
										 
										 private String RD_Digi_AccountNo;
										
}
		

