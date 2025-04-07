

	
	
	package com.Pisquare.Beans;

	import java.util.Date;

	public class Savings_Reports 
	{
		
		private int Account_No=0;	
		public int getAccount_No()
		{
			return Account_No;
			}
	    public void setAccount_No(int Account_No)
	    {
	    	this.Account_No=Account_No;
	    }
		
	    
	    
	    private int Account_From=0;	
		public int getAccount_From()
		{
			return Account_From;
			}
	    public void setAccount_From(int Account_From)
	    {
	    	this.Account_From=Account_From;
	    }
	    
	    
	    private int Account_To=0;	
		public int getAccount_To()
		{
			return Account_To;
			}
	    public void setAccount_To(int Account_To)
	    {
	    	this.Account_To=Account_To;
	    }
	    
		
		//2.
	    private Date Open_Date=null;
	    public Date getOpen_Date()
	     {
	    	 return Open_Date;
	     }
	     public void setOpen_Date(Date date)
	     {
	    	 this.Open_Date=date;
	    	 }
	     
		
	     //3.
	     private float Closing_Balance=0;	
	     public float getClosing_Balance()
	     {
	    	 return Closing_Balance;
	     }
	      public void setClosing_Balance(float Closing_Balance)
	      {
	    	  this.Closing_Balance=Closing_Balance;
	      }
	     
	      
	      //4.
	      private String Account_Status=null;	
	      
	      public String getAccount_Status()
	      {
	    	  return Account_Status;
	      }
	      public void setAccount_Status(String Account_Status)
	      {
	    	  this.Account_Status=Account_Status;
	      }
	      
	      
	      
		//5.
	      String OpenFrom_Date=null;
			public String getOpenFrom_Date()
				{
					return OpenFrom_Date;
					
				}
				
				public void setOpenFrom_Date(String OpenFrom_Date)
				{
					this.OpenFrom_Date=OpenFrom_Date;
				}
				
				
		
		
		//6.
		String OpenTo_Date=null;
		public String getOpenTo_Date()
			{
				return OpenTo_Date;
				
			}
			
			public void setOpenTo_Date(String OpenTo_Date)
			{
				this.OpenTo_Date=OpenTo_Date;
			}
	
	
			
			
			//7.
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
			
			
					
					private String Scheme_Type=null;
					public String getScheme_Type()
					{
						return Scheme_Type;
					}
					public void setScheme_Type(String Scheme_Type)
					{
						this.Scheme_Type=Scheme_Type;
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
	}


