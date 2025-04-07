package com.Pisquare.Beans;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.LinkedList;
import java.util.List;


public class JL_Master 
{
                                        
	
	public JL_Master()
	{
		
	}
	
	private int Customer_Id;
	private int BranchName;
	
	public int getCustomer_Id()
	{
		return Customer_Id;
	}
    public void setCustomer_Id(int Customer_Id)
    {
    	this.Customer_Id=Customer_Id;
    }
    
    private String Cust_Info;
	
	public String getCust_Info()
	{
		return Cust_Info;
	}
    public void setCust_Info(String Cust_Info)
    {
    	this.Cust_Info=Cust_Info;
    }
    
    private String Scheme;
	
   	public String getScheme()
   	{
   		return Scheme;
   	}
    public void setScheme(String Scheme)
    {
       this.Scheme=Scheme;
    }

    private int Hd_Insurance;
   	
    public int getHd_Insurance()
    {
      return Hd_Insurance;
    }
    public void setHd_Insurance(int Hd_Insurance)
    {
       this.Hd_Insurance=Hd_Insurance;
    }
    
    private int Hd_Service_tax;
	
   	public int getHd_Service_tax()
   	{
   		return Hd_Service_tax;
   	}
    public void setHd_Service_tax(int Hd_Service_tax)
    {
       	this.Hd_Service_tax=Hd_Service_tax;
    }
    
    private int Hd_Min_Amount;
	
   	public int getHd_Min_Amount()
   	{
   		return Hd_Min_Amount;
   	}
    public void setHd_Min_Amount(int Hd_Min_Amount)
    {
       	this.Hd_Min_Amount=Hd_Min_Amount;
    }
    
    private int Hd_Processing_Fee;
	
   	public int getHd_Processing_Fee()
   	{
   		return Hd_Processing_Fee;
   	}
    public void setHd_Processing_Fee(int Hd_Processing_Fee)
    {
       	this.Hd_Processing_Fee=Hd_Processing_Fee;
    }
    
    private String Acc_No;
	
   	public String getAcc_No()
   	{
   		return Acc_No;
   	}
    public void setAcc_No(String Acc_No)
    {
       	this.Acc_No=Acc_No;
    }
    
    private String Acc_Open_Date;
	
   	public String getAcc_Open_Date()
   	{
   		return Acc_Open_Date;
   	}
    public void setAcc_Open_Date(String Acc_Open_Date)
    {
       	this.Acc_Open_Date=Acc_Open_Date;
    }
    
    private String Status;
    
   	public String getStatus()
   	{
   		return Status;
   	}
    public void setStatus(String Status)
    {
       	this.Status=Status;
    }
    
    private float Rate_per_Gram;
    
   	public float getRate_per_Gram()
   	{
   		return Rate_per_Gram;
   	}
    public void setRate_per_Gram(float Rate_per_Gram)
    {
       	this.Rate_per_Gram=Rate_per_Gram;
    }
    
    private float Market_Rate;
    
   	public float getMarket_Rate()
   	{
   		return Market_Rate;
   	}
    public void setMarket_Rate(float Market_Rate)
    {
       	this.Market_Rate=Market_Rate;
    }
    
    private float Interest_Rate;
    
   	public float getInterest_Rate()
   	{
   		return Interest_Rate;
   	}
    public void setInterest_Rate(float Interest_Rate)
    {
       	this.Interest_Rate=Interest_Rate;
    }
    
    private float Penal_Rate;
    
   	public float getPenal_Rate()
   	{
   		return Penal_Rate;
   	}
    public void setPenal_Rate(float Penal_Rate)
    {
       	this.Penal_Rate=Penal_Rate;
    }
    
    private String Ddl_Compounding;
    
   	public String getDdl_Compounding()
   	{
   		return Ddl_Compounding;
   	}
    public void setDdl_Compounding(String Ddl_Compounding)
    {
       	this.Ddl_Compounding=Ddl_Compounding;
    }
    
    private int Hd_Id;
    
   	public int getHd_Id()
   	{
   		return Hd_Id;
   	}
    public void setHd_Id(int Hd_Id)
    {
       	this.Hd_Id=Hd_Id;
    }
    
    private String Ddl_Jewel_Desc;
    
   	public String getDdl_Jewel_Desc()
   	{
   		return Ddl_Jewel_Desc;
   	}
    public void setDdl_Jewel_Desc(String Ddl_Jewel_Desc)
    {
       	this.Ddl_Jewel_Desc=Ddl_Jewel_Desc;
    }
    
    private int No_of_Items;
    
   	public int getNo_of_Items()
   	{
   		return No_of_Items;
   	}
    public void setNo_of_Items(int No_of_Items)
    {
       	this.No_of_Items=No_of_Items;
    }
    
    private float Gross_Wt;
    
   	public float getGross_Wt()
   	{
   		return Gross_Wt;
   	}
    public void setGross_Wt(float Gross_Wt)
    {
       	this.Gross_Wt=Gross_Wt;
    }
    
    private float Deduction;
    
   	public float getDeduction()
   	{
   		return Deduction;
   	}
    public void setDeduction(float Deduction)
    {
       	this.Deduction=Deduction;
    }
    
    private float Net_Wt;
    
   	public float getNet_Wt()
   	{
   		return Net_Wt;
   	}
    public void setNet_Wt(float Net_Wt)
    {
       	this.Net_Wt=Net_Wt;
    }
    
    private float Jewel_Value;
    
   	public float getJewel_Value()
   	{
   		return Jewel_Value;
   	}
    public void setJewel_Value(float Jewel_Value)
    {
       	this.Jewel_Value=Jewel_Value;
    }
    
    private float Lbl_Sanction_Limit;
    
   	public float getLbl_Sanction_Limit()
   	{
   		return Lbl_Sanction_Limit;
   	}
    public void setLbl_Sanction_Limit(float Lbl_Sanction_Limit)
    {
       	this.Lbl_Sanction_Limit=Lbl_Sanction_Limit;
    }
    
    private float Loan_Amount;
    
   	public float getLoan_Amount()
   	{
   		return Loan_Amount;
   	}
    public void setLoan_Amount(float Loan_Amount)
    {
       	this.Loan_Amount=Loan_Amount;
    }
    
    private int Period_Months;
    
   	public int getPeriod_Months()
   	{
   		return Period_Months;
   	}
    public void setPeriod_Months(int Period_Months)
    {
       	this.Period_Months=Period_Months;
    }
    
    private String Due_Date;
    
   	public String getDue_Date()
   	{
   		return Due_Date;
   	}
    public void setDue_Date(String Due_Date)
    {
       	this.Due_Date=Due_Date;
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
    
    private String Nominee_Relation;
    
   	public String getNominee_Relation()
   	{
   		return Nominee_Relation;
   	}
    public void setNominee_Relation(String Nominee_Relation)
    {
       	this.Nominee_Relation=Nominee_Relation;
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
   
    
    private int Referred_By;
    
   	public int getReferred_By()
   	{
   		return Referred_By;
   	}
    public void setReferred_By(int Referred_By)
    {
       	this.Referred_By=Referred_By;
    }
    
    private String Lbl_Status;
    
   	public String getLbl_Status()
   	{
   		return Lbl_Status;
   	}
    public void setLbl_Status(String Lbl_Status)
    {
       	this.Lbl_Status=Lbl_Status;
    }
    
    private int Trans_Id;
    
   	public int getTrans_Id()
   	{
   		return Trans_Id;
   	}
    public void setTrans_Id(int Trans_Id)
    {
       	this.Trans_Id=Trans_Id;
    }
    
    private String Trans_Date;
    
   	public String getTrans_Date()
   	{
   		return Trans_Date;
   	}
    public void setTrans_Date(String Trans_Date)
    {
       	this.Trans_Date=Trans_Date;
    }
    
    private int Appraiser_Fee;
    
   	public int getAppraiser_Fee()
   	{
   		return Appraiser_Fee;
   	}
    public void setAppraiser_Fee(int Appraiser_Fee)
    {
       	this.Appraiser_Fee=Appraiser_Fee;
    }
    
    private int Insurance;
    
   	public int getInsurance()
   	{
   		return Insurance;
   	}
    public void setInsurance(int Insurance)
    {
       	this.Insurance=Insurance;
    }
    
    private int Forms;
    
   	public int getForms()
   	{
   		return Forms;
   	}
    public void setForms(int Forms)
    {
       	this.Forms=Forms;
    }
    
    private int Postage;
    
   	public int getPostage()
   	{
   		return Postage;
   	}
    public void setPostage(int Postage)
    {
       	this.Postage=Postage;
    }
    
    private float Loan_payable;
    
   	public float getLoan_payable()
   	{
   		return Loan_payable;
   	}
    public void setLoan_payable(float Loan_payable)
    {
       	this.Loan_payable=Loan_payable;
    }
    
    private String GL_Head;
    
   	public String getGL_Head()
   	{
   		return GL_Head;
   	}
    public void setGL_Head(String GL_Head)
    {
       	this.GL_Head=GL_Head;
    }
    
	private int GL_Code;

   	public int getGL_Code()
   	{
   		return GL_Code;
   	}
    public void setGL_Code(int GL_Code)
    {
       	this.GL_Code=GL_Code;
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
    
    private String Transfer_Acc_Name;
    
   	public String getTransfer_Acc_Name()
   	{
   		return Transfer_Acc_Name;
   	}
    public void setTransfer_Acc_Name(String Transfer_Acc_Name)
    {
       	this.Transfer_Acc_Name=Transfer_Acc_Name;
    }
    
    private String Hd_Scheme_Code;
    
   	public String getHd_Scheme_Code()
   	{
   		return Hd_Scheme_Code;
   	}
    public void setHd_Scheme_Code(String Hd_Scheme_Code)
    {
       	this.Hd_Scheme_Code=Hd_Scheme_Code;
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
    
    private int Closing_Balance;
 
   	public int getClosing_Balance()
   	{
   		return Closing_Balance;
   	}
    public void setClosing_Balance(int Closing_Balance)
    {
       	this.Closing_Balance=Closing_Balance;
    }
    
    private String Int_Recd_Upto;
    
   	public String getInt_Recd_Upto()
   	{
   		return Int_Recd_Upto;
   	}
    public void setInt_Recd_Upto(String Int_Recd_Upto)
    {
       	this.Int_Recd_Upto=Int_Recd_Upto;
    }
    
    private String Insurance_Recd_Upto;
    
   	public String getInsurance_Recd_Upto()
   	{
   		return Insurance_Recd_Upto;
   	}
    public void setInsurance_Recd_Upto(String Insurance_Recd_Upto)
    {
       	this.Insurance_Recd_Upto=Insurance_Recd_Upto;
    }
    
    private float JL_Market_Rate;
    
   	public float getJL_Market_Rate()
   	{
   		return JL_Market_Rate;
   	}
    public void setJL_Market_Rate(float JL_Market_Rate)
    {
       	this.JL_Market_Rate=JL_Market_Rate;
    }
    
    private int Principal_Due;
    
   	public int getPrincipal_Due()
   	{
   		return Principal_Due;
   	}
    public void setPrincipal_Due(int Principal_Due)
    {
       	this.Principal_Due=Principal_Due;
    }
    
    private float Interest_Due;
    
   	public float getInterest_Due()
   	{
   		return Interest_Due;
   	}
    public void setInterest_Due(float Interest_Due)
    {
       	this.Interest_Due=Interest_Due;
    }
    
    private int Penal_Interest_Due;
    
   	public int getPenal_Interest_Due()
   	{
   		return Penal_Interest_Due;
   	}
    public void setPenal_Interest_Due(int Penal_Interest_Due)
    {
       	this.Penal_Interest_Due=Penal_Interest_Due;
    }
    
    private int Ddl_Insurance_Due;
    
   	public int getDdl_Insurance_Due()
   	{
   		return Ddl_Insurance_Due;
   	}
    public void setDdl_Insurance_Due(int Ddl_Insurance_Due)
    {
       	this.Ddl_Insurance_Due=Ddl_Insurance_Due;
    }
    
    private int Insurance_Dues;
    
   	public int getInsurance_Dues()
   	{
   		return Insurance_Dues;
   	}
    public void setInsurance_Dues(int Insurance_Dues)
    {
       	this.Insurance_Dues=Insurance_Dues;
    }
    
    private String Int_Upto;
    
   	public String getInt_Upto()
   	{
   		return Int_Upto;
   	}
    public void setInt_Upto(String Int_Upto)
    {
       	this.Int_Upto=Int_Upto;
    }
    
    private String Lbl_Tot_Int;
    
   	public String getLbl_Tot_Int()
   	{
   		return Lbl_Tot_Int;
   	}
    public void setLbl_Tot_Int(String Lbl_Tot_Int)
    {
       	this.Lbl_Tot_Int=Lbl_Tot_Int;
    }
    
    private int Pending_Dues;
    
   	public int getPending_Dues()
   	{
   		return Pending_Dues;
   	}
    public void setPending_Dues(int Pending_Dues)
    {
       	this.Pending_Dues=Pending_Dues;
    }
    
    private int Notice_Dues;
 
   	public int getNotice_Dues()
   	{
   		return Notice_Dues;
   	}
    public void setNotice_Dues(int Notice_Dues)
    {
       	this.Pending_Dues=Notice_Dues;
    }
    
    private float Lbl_Tot_Charges;
    
   	public float getLbl_Tot_Charges()
   	{
   		return Lbl_Tot_Charges;
   	}
    public void setLbl_Tot_Charges(float Lbl_Tot_Charges)
    {
       	this.Lbl_Tot_Charges=Lbl_Tot_Charges;
    }
    
    private int Lbl_Days;
    
   	public int getLbl_Days()
   	{
   		return Lbl_Days;
   	}
    public void setLbl_Days(int Lbl_Days)
    {
       	this.Lbl_Days=Lbl_Days;
    }
    
    private float Lbl_Total_Pending;
    
   	public float getLbl_Total_Pending()
   	{
   		return Lbl_Total_Pending;
   	}
    public void setLbl_Total_Pending(float Lbl_Total_Pending)
    {
       	this.Lbl_Total_Pending=Lbl_Total_Pending;
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
    
    private int Trans_Amt;
    
   	public int getTrans_Amt()
   	{
   		return Trans_Amt;
   	}
    public void setTrans_Amt(int Trans_Amt)
    {
       	this.Trans_Amt=Trans_Amt;
    }
    
    private int Principal;
    
   	public int getPrincipal()
   	{
   		return Principal;
   	}
    public void setPrincipal(int Principal)
    {
       	this.Principal=Principal;
    }
    
    private int Interest;
    
   	public int getInterest()
   	{
   		return Interest;
   	}
    public void setInterest(int Interest)
    {
       	this.Interest=Interest;
    }
    
    private int Penal;
    
   	public int getPenal()
   	{
   		return Penal;
   	}
    public void setPenal(int Penal)
    {
       	this.Penal=Penal;
    }
    
    private int Notice;
    
   	public int getNotice()
   	{
   		return Notice;
   	}
    public void setNotice(int Notice)
    {
       	this.Notice=Notice;
    }
    
    private int Pending_Int;
    
   	public int getPending_Int()
   	{
   		return Pending_Int;
   	}
    public void setPending_Int(int Pending_Int)
    {
       	this.Pending_Int=Pending_Int;
    }
    
    private String Lbl_SB_CB;
    
   	public String getLbl_SB_CB()
   	{
   		return Lbl_SB_CB;
   	}
    public void setLbl_SB_CB(String Lbl_SB_CB)
    {
       	this.Lbl_SB_CB=Lbl_SB_CB;
    }
    
    private String Report_Type;
    
   	public String getReport_Type()
   	{
   		return Report_Type;
   	}
    public void setReport_Type(String Report_Type)
    {
       	this.Report_Type=Report_Type;
    }
    
    private int Old_Acc_No;
    
   	public int getOld_Acc_No()
   	{
   		return Old_Acc_No;
   	}
    public void setOld_Acc_No(int Old_Acc_No)
    {
       	this.Old_Acc_No=Old_Acc_No;
    }
    
    private int Cust_Id;
    
   	public int getCust_Id()
   	{
   		return Cust_Id;
   	}
    public void setCust_Id(int Cust_Id)
    {
       	this.Cust_Id=Cust_Id;
    }
    
    private String Lbl_OD_Status;
    
   	public String getLbl_OD_Status()
   	{
   		return Lbl_OD_Status;
   	}
    public void setLbl_OD_Status(String Lbl_OD_Status)
    {
       	this.Lbl_OD_Status=Lbl_OD_Status;
    }
    
    private int Hd_Pending_Interest;
 
   	public int getHd_Pending_Interest()
   	{
   		return Hd_Pending_Interest;
   	}
    public void setHd_Pending_Interest(int Hd_Pending_Interest)
    {
       	this.Hd_Pending_Interest=Hd_Pending_Interest;
    }
    
    private int Hd_Pending_Penal;
    
   	public int getHd_Pending_Penal()
   	{
   		return Hd_Pending_Penal;
   	}
    public void setHd_Pending_Penal(int Hd_Pending_Penal)
    {
       	this.Hd_Pending_Penal=Hd_Pending_Penal;
    }
    
    private int Loan_Payable2;
    
   	public int getLoan_Payable2()
   	{
   		return Loan_Payable2;
   	}
    public void setLoan_Payable2(int Loan_Payable2)
    {
       	this.Loan_Payable2=Loan_Payable2;
    }
    
    private int Lbl_Tot_Adj;
    
   	public int getLbl_Tot_Adj()
   	{
   		return Lbl_Tot_Adj;
   	}
    public void setLbl_Tot_Adj(int Lbl_Tot_Adj)
    {
       	this.Lbl_Tot_Adj=Lbl_Tot_Adj;
    }
    
    private int Balance;
    
   	public int getBalance()
   	{
   		return Balance;
   	}
    public void setBalance(int Balance)
    {
       	this.Balance=Balance;
    }
    
    private String Executants;
    
   	public String getExecutants()
   	{
   		return Executants;
   	}
    public void setExecutants(String Executants)
    {
       	this.Executants=Executants;
    }
    
    private String Security_Details;
    
   	public String getSecurity_Details()
   	{
   		return Security_Details;
   	}
    public void setSecurity_Details(String Security_Details)
    {
       	this.Security_Details=Security_Details;
    }
    
    private int Dep_Acc_no;
    
   	public int getDep_Acc_no()
   	{
   		return Dep_Acc_no;
   	}
    public void setDep_Acc_no(int Dep_Acc_no)
    {
       	this.Dep_Acc_no=Dep_Acc_no;
    }
    
    private int Sanction_Limit;
    
   	public int getSanction_Limit()
   	{
   		return Sanction_Limit;
   	}
    public void setSanction_Limit(int Sanction_Limit)
    {
       	this.Sanction_Limit=Sanction_Limit;
    }
    
    private String Period;
    
   	public String getPeriod()
   	{
   		return Period;
   	}
    public void setPeriod(String Period)
    {
       	this.Period=Period;
    }
    
    private int Customer_Id2;
    
   	public int getCustomer_Id2()
   	{
   		return Customer_Id2;
   	}
    public void setCustomer_Id2(int Customer_Id2)
    {
       	this.Customer_Id2=Customer_Id2;
    }
    
    private int Customer_Id3;
    
   	public int getCustomer_Id3()
   	{
   		return Customer_Id3;
   	}
    public void setCustomer_Id3(int Customer_Id3)
    {
       	this.Customer_Id3=Customer_Id3;
    }
    
    private String Loan_Type;
    
   	public String getLoan_Type()
   	{
   		return Loan_Type;
   	}
    public void setLoan_Type(String Loan_Type)
    {
       	this.Loan_Type=Loan_Type;
    }
    
    private String Plot_No;
    
   	public String getPlot_No()
   	{
   		return Plot_No;
   	}
    public void setPlot_No(String Plot_No)
    {
       	this.Plot_No=Plot_No;
    }
    
    private String Area;
    
   	public String getArea()
   	{
   		return Area;
   	}
    public void setArea(String Area)
    {
       	this.Area=Area;
    }
    
    private String Place;
    
   	public String getPlace()
   	{
   		return Place;
   	}
    public void setPlace(String Place)
    {
       	this.Place=Place;
    }
    
    private String Postal_Address;
    
   	public String getPostal_Address()
   	{
   		return Postal_Address;
   	}
    public void setPostal_Address(String Postal_Address)
    {
       	this.Postal_Address=Postal_Address;
    }
    
    private String Surveyor;
    
   	public String getSurveyor()
   	{
   		return Surveyor;
   	}
    public void setSurveyor(String Surveyor)
    {
       	this.Surveyor=Surveyor;
    }
    
    private String Market_Value;
    
   	public String getMarket_Value()
   	{
   		return Market_Value;
   	}
    public void setMarket_Value(String Market_Value)
    {
       	this.Market_Value=Market_Value;
    }
    
    private String Registered_Value;
    
   	public String getRegistered_Value()
   	{
   		return Registered_Value;
   	}
    public void setRegistered_Value(String Registered_Value)
    {
       	this.Registered_Value=Registered_Value;
    }
    
    private String Standing_Scheme;
    
   	public String getStanding_Scheme()
   	{
   		return Standing_Scheme;
   	}
    public void setStanding_Scheme(String Standing_Scheme)
    {
       	this.Standing_Scheme=Standing_Scheme;
    }
    
    private String Standing_Acc_No;
    
   	public String getStanding_Acc_No()
   	{
   		return Standing_Acc_No;
   	}
    public void setStanding_Acc_No(String Standing_Acc_No)
    {
       	this.Standing_Acc_No=Standing_Acc_No;
    }
    
    private int Hd_passed;
    
   	public int getHd_passed()
   	{
   		return Hd_passed;
   	}
    public void setHd_passed(int Hd_passed)
    {
       	this.Hd_passed=Hd_passed;
    }
    
    private String Branch_Code;
    
   	public String getBranch_Code()
   	{
   		return Branch_Code;
   	}
    public void setBranch_Code(String Branch_Code)
    {
       	this.Branch_Code=Branch_Code;
    }
    
    private String Scheme_Code;
    
   	public String getScheme_Code()
   	{
   		return Scheme_Code;
   	}
    public void setScheme_Code(String Scheme_Code)
    {
       	this.Scheme_Code=Scheme_Code;
    }
    
    private String Scheme_Code_Cd;
    
   	public String getScheme_Code_Cd()
   	{
   		return Scheme_Code_Cd;
   	}
    public void setScheme_Code_Cd(String Scheme_Code_Cd)
    {
       	this.Scheme_Code_Cd=Scheme_Code_Cd;
    }
    
    private int Acc_From;
    
   	public int getAcc_From()
   	{
   		return Acc_From;
   	}
    public void setAcc_From(int Acc_From)
    {
       	this.Acc_From=Acc_From;
    }
    
    private int Acc_To;
    
   	public int getAcc_To()
   	{
   		return Acc_To;
   	}
    public void setAcc_To(int Acc_To)
    {
       	this.Acc_To=Acc_To;
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
    
    private String Due_Date_From;
    
   	public String getDue_Date_From()
   	{
   		return Due_Date_From;
   	}
    public void setDue_Date_From(String Due_Date_From)
    {
       	this.Due_Date_From=Due_Date_From;
    }
    
    private String Due_Date_To;
    
   	public String getDue_Date_To()
   	{
   		return Due_Date_To;
   	}
    public void setDue_Date_To(String Due_Date_To)
    {
       	this.Due_Date_To=Due_Date_To;
    }
    
    private String Condition;
    
   	public String getCondition()
   	{
   		return Condition;
   	}
    public void setCondition(String Condition)
    {
       	this.Condition=Condition;
    }
    
    private int Value1;
    
   	public int getValue1()
   	{
   		return Value1;
   	}
    public void setValue1(int Value1)
    {
       	this.Value1=Value1;
    }
    
    private int Value2;
    
   	public int getValue2()
   	{
   		return Value2;
   	}
    public void setValue2(int Value2)
    {
       	this.Value2=Value2;
    }
    
    private String Condition2;
    
    public String getCondition2() {
		return Condition2;
	}
	public void setCondition2(String Condition2) {
		this.Condition2 = Condition2;
	}
	
	private int OD_Days;
	
	public int getOD_Days() {
		return OD_Days;
	}
	public void setOD_Days(int oD_Days) {
		OD_Days = oD_Days;
	}
	
	
	private int Group_By;

	public int getGroup_By() {
		return Group_By;
	}
	public void setGroup_By(int group_By) {
		Group_By = group_By;
	}
	
	private int Acc_Type;
	
	public int getAcc_Type() {
		return Acc_Type;
	}
	public void setAcc_Type(int acc_Type) {
		Acc_Type = acc_Type;
	}
	
	private String Cust_Name;
	
	public String getCust_Name() {
		return Cust_Name;
	}
	public void setCust_Name(String cust_Name) {
		Cust_Name = cust_Name;
	}
	
private String Cust_Add;
	

	
	
	private int Line_No;
	
	public int getLine_No() {
		return Line_No;
	}
	public void setLine_No(int line_No) {
		Line_No = line_No;
	}
	
	private int Account_Type;

	public int getAccount_Type() {
		return Account_Type;
	}
	public void setAccount_Type(int account_Type) {
		Account_Type = account_Type;
	}  
	
	private int GL_General;

	public int getGL_General() 
	{
		return GL_General;
	}
	public void setGL_General(int GL_General) 
	{
		this.GL_General = GL_General;
	}  
	
	private int GL_Int_Receivable;

	public int getGL_Int_Receivable() 
	{
		return GL_Int_Receivable;
	}
	public void setGL_Int_Receivable(int GL_Int_Receivable) 
	{
		this.GL_Int_Receivable = GL_Int_Receivable;
	}  
	
	private int GL_Default_Int_Receivable;

	public int getGL_Default_Int_Receivable() 
	{
		return GL_Default_Int_Receivable;
	}
	public void setGL_Default_Int_Receivable(int GL_Default_Int_Receivable) 
	{
		this.GL_Default_Int_Receivable = GL_Default_Int_Receivable;
	}
	
	private int GL_Insurance;

	public int getGL_Insurance() 
	{
		return GL_Insurance;
	}
	public void setGL_Insurance(int GL_Insurance) 
	{
		this.GL_Insurance = GL_Insurance;
	} 
	
	private int GL_Service_Tax;

	public int getGL_Service_Tax() 
	{
		return GL_Service_Tax;
	}
	public void setGL_Service_Tax(int GL_Service_Tax) 
	{
		this.GL_Service_Tax = GL_Service_Tax;
	}  
	
	
	private int GL_Postage;

	public int getGL_Postage() 
	{
		return GL_Postage;
	}
	public void setGL_Postage(int GL_Postage) 
	{
		this.GL_Postage = GL_Postage;
	}  
	
	private int GL_Appraiser_Fee;

	public int getGL_Appraiser_Fee() 
	{
		return GL_Appraiser_Fee;
	}
	public void setGL_Appraiser_Fee(int GL_Appraiser_Fee) 
	{
		this.GL_Appraiser_Fee = GL_Appraiser_Fee;
	} 
	
	private int GL_Forms;

	public int getGL_Forms() 
	{
		return GL_Forms;
	}
	public void setGL_Forms(int GL_Forms) 
	{
		this.GL_Forms = GL_Forms;
	}  
	
	 
	 private String Hd_Int_Rate;
	    
	   	public String getHd_Int_Rate()
	   	{
	   		return Hd_Int_Rate;
	   	}
	    public void setHd_Int_Rate(String Hd_Int_Rate)
	    {
	       	this.Hd_Int_Rate=Hd_Int_Rate;
	    }
	    
	    private int TransFlag=1;
	    
	   	public int getTransFlag()
	   	{
	   		return TransFlag;
	   	}
	    public void setTransFlag(int TransFlag)
	    {
	       	this.TransFlag=TransFlag;
	    }
	    
	    private String Due_From_Date;
	    
	   	public String getDue_From_Date()
	   	{
	   		return Due_From_Date;
	   	}
	    public void setDue_From_Date(String Due_From_Date)
	    {
	       	this.Due_From_Date=Due_From_Date;
	    }
	    
	    private String Due_To_Date;
	    
	   	public String getDue_To_Date()
	   	{
	   		return Due_To_Date;
	   	}
	    public void setDue_To_Date(String Due_To_Date)
	    {
	       	this.Due_To_Date=Due_To_Date;
	    }
	    
	    private String Ddl_Group_By;
	    
	   	public String getDdl_Group_By()
	   	{
	   		return Ddl_Group_By;
	   	}
	    public void setDdl_Group_By(String Ddl_Group_By)
	    {
	       	this.Ddl_Group_By=Ddl_Group_By;
	    }
	    
	    private String Ddl_Report_Type;
	    
	   	public String getDdl_Report_Type()
	   	{
	   		return Ddl_Report_Type;
	   	}
	    public void setDdl_Report_Type(String Ddl_Report_Type)
	    {
	       	this.Ddl_Report_Type=Ddl_Report_Type;
	    }
	    
	    private int Rate_Per_Gram2;
	    
	   	public int getRate_Per_Gram2()
	   	{
	   		return Rate_Per_Gram2;
	   	}
	    public void setRate_Per_Gram2(int Rate_Per_Gram2)
	    {
	       	this.Rate_Per_Gram2=Rate_Per_Gram2;
	    }
	    
	    private String NPA_Date;
	    
	   	public String getNPA_Date()
	   	{
	   		return NPA_Date;
	   	}
	    public void setNPA_Date(String NPA_Date)
	    {
	       	this.NPA_Date=NPA_Date;
	    }
	    
	    private String OL_NPA_Date2;
	    
	   	public String getOL_NPA_Date2()
	   	{
	   		return OL_NPA_Date2;
	   	}
	    public void setOL_NPA_Date2(String OL_NPA_Date2)
	    {
	       	this.OL_NPA_Date2=OL_NPA_Date2;
	    }
	    
	    private String Outstanding_Date;
	    
	   	public String getOutstanding_Date()
	   	{
	   		return Outstanding_Date;
	   	}
	    public void setOutstanding_Date(String Outstanding_Date)
	    {
	       	this.Outstanding_Date=Outstanding_Date;
	    }
	    
	    private String Acc_No_From;
	    
	   	public String getAcc_No_From()
	   	{
	   		return Acc_No_From;
	   	}
	    public void setAcc_No_From(String Acc_No_From)
	    {
	       	this.Acc_No_From=Acc_No_From;
	    }
	    
	    private String Acc_No_To;
	    
	   	public String getAcc_No_To()
	   	{
	   		return Acc_No_To;
	   	}
	    public void setAcc_No_To(String Acc_No_To)
	    {
	       	this.Acc_No_To=Acc_No_To;
	    }
	    
	    private String Open_Date_From;
	    
	   	public String getOpen_Date_From()
	   	{
	   		return Open_Date_From;
	   	}
	    public void setOpen_Date_From(String Open_Date_From)
	    {
	       	this.Open_Date_From=Open_Date_From;
	    }
	    
	    private String Open_Date_To;
	    
	   	public String getOpen_Date_To()
	   	{
	   		return Open_Date_To;
	   	}
	    public void setOpen_Date_To(String Open_Date_To)
	    {
	       	this.Open_Date_To=Open_Date_To;
	    }
	    
	    private String Ddl_Closing_Balance;
	    
	   	public String getDdl_Closing_Balance()
	   	{
	   		return Ddl_Closing_Balance;
	   	}
	    public void setDdl_Closing_Balance(String Ddl_Closing_Balance)
	    {
	       	this.Ddl_Closing_Balance=Ddl_Closing_Balance;
	    }
	    
	    private int CB_Value_From;
	    
	   	public int getCB_Value_From()
	   	{
	   		return CB_Value_From;
	   	}
	    public void setCB_Value_From(int CB_Value_From)
	    {
	       	this.CB_Value_From=CB_Value_From;
	    }
	    
	    private int CB_Value_To;
	    
	   	public int getCB_Value_To()
	   	{
	   		return CB_Value_To;
	   	}
	    public void setCB_Value_To(int CB_Value_To)
	    {
	       	this.CB_Value_To=CB_Value_To;
	    }
	    
	    private String Ddl_Last_Int_Payment;
	    
	   	public String getDdl_Last_Int_Payment()
	   	{
	   		return Ddl_Last_Int_Payment;
	   	}
	    public void setDdl_Last_Int_Payment(String Ddl_Last_Int_Payment)
	    {
	       	this.Ddl_Last_Int_Payment=Ddl_Last_Int_Payment;
	    }
	    
	    private int Last_Int_Payment;
	    
	   	public int getLast_Int_Payment()
	   	{
	   		return Last_Int_Payment;
	   	}
	    public void setLast_Int_Payment(int Last_Int_Payment)
	    {
	       	this.Last_Int_Payment=Last_Int_Payment;
	    }
	    
	    private boolean Active=true;
	    
	   	public boolean getActive()
	   	{
	   		return Active;
	   	}
	    public void setActive(boolean Active)
	    {
	       	this.Active=Active;
	    }
	    
	    private boolean Close;
	    
	   	public boolean getClose()
	   	{
	   		return Close;
	   	}
	    public void setClose(boolean Close)
	    {
	       	this.Close=Close;
	    }
	    
	    private String Monthly_Date_From;
	    
	   	public String getMonthly_Date_From()
	   	{
	   		return Monthly_Date_From;
	   	}
	    public void setMonthly_Date_From(String Monthly_Date_From)
	    {
	       	this.Monthly_Date_From=Monthly_Date_From;
	    }
	    
	    private String Monthly_Date_To;
	    
	   	public String getMonthly_Date_To()
	   	{
	   		return Monthly_Date_To;
	   	}
	    public void setMonthly_Date_To(String Monthly_Date_To)
	    {
	       	this.Monthly_Date_To=Monthly_Date_To;
	    }
	    
	    
	    
	    
 private float Rebate_Amt;
	    
	   	public float getRebate_Amt()
	   	{
	   		return Rebate_Amt;
	   	}
	    public void setRebate_Amt(float Rebate_Amt)
	    {
	       	this.Rebate_Amt=Rebate_Amt;
	    }
	
	    
	    
 private String Closing_Date;
	    
	   	public String getClosing_Date()
	   	{
	   		return Closing_Date;
	   	}
	    public void setClosing_Date(String Closing_Date)
	    {
	       	this.Closing_Date=Closing_Date;
	    }
	    
	    public String getCusString1() {
			return CusString1;
		}
		public void setCusString1(String cusString1) {
			CusString1 = cusString1;
		}

		private String CusString1;
		
		//for storing values
		
		public JL_Master(float f1,float f2,float f3,float f4,float f5,float f6,float f7)
		{
			this.Gross_Wt=f1;
			this.Deduction=f2;
			this.Net_Wt=f3;
			this.Jewel_Value=f4;
			this.Lbl_Sanction_Limit=f5;
			this.Loan_Amount=f6;		
			this.Loan_payable=f7;
		}
		public String getCust_Add() {
			return Cust_Add;
		}
		public void setCust_Add(String cust_Add) {
			Cust_Add = cust_Add;
		}
		
		
	   private CommonsMultipartFile fileData;

	   public CommonsMultipartFile getFileData() 
	   {
		  return fileData;
	   }

	   public void setFileData(CommonsMultipartFile fileData) 
	   {
		   this.fileData = fileData;
	   }
	   
	   private String COOP_STATUS;
		
		public String getCOOP_STATUS()
		{
			return COOP_STATUS;
		}
	    public void setCOOP_STATUS(String COOP_STATUS)
	    {
	    	this.COOP_STATUS=COOP_STATUS;
	    }
	    
	    private float Head_Amount;
		
		public float getHead_Amount()
		{
			return Head_Amount;
		}
	    public void setHead_Amount(float Head_Amount)
	    {
	    	this.Head_Amount=Head_Amount;
	    }
	    
	    private float Rebate_Interest_Rate;
		
		public float getRebate_Interest_Rate()
		{
			return Rebate_Interest_Rate;
		}
	    public void setRebate_Interest_Rate(float Rebate_Interest_Rate)
	    {
	    	this.Rebate_Interest_Rate=Rebate_Interest_Rate;
	    }
	    
	    private float Total_Interest_Recd;
		
		public float getTotal_Interest_Recd()
		{
			return Total_Interest_Recd;
		}
	    public void setTotal_Interest_Recd(float Total_Interest_Recd)
	    {
	    	this.Total_Interest_Recd=Total_Interest_Recd;
	    }	
	    
	    private float Rebate_Balance;
		
		public float getRebate_Balance()
		{
			return Rebate_Balance;
		}
	    public void setRebate_Balance(float Rebate_Balance)
	    {
	    	this.Rebate_Balance=Rebate_Balance;
	    }	
	    
	    private float Sanction_Limit_Tot;
		
		public float getSanction_Limit_Tot()
		{
			return Sanction_Limit_Tot;
		}
	    public void setSanction_Limit_Tot(float Sanction_Limit_Tot)
	    {
	    	this.Sanction_Limit_Tot=Sanction_Limit_Tot;
	    }	
	    
	    private float Gross_Wt_Tot;
		
		public float getGross_Wt_Tot()
		{
			return Gross_Wt_Tot;
		}
	    public void setGross_Wt_Tot(float Gross_Wt_Tot)
	    {
	    	this.Gross_Wt_Tot=Gross_Wt_Tot;
	    }	
	    
	    private float Net_Wt_Tot;
		
		public float getNet_Wt_Tot()
		{
			return Net_Wt_Tot;
		}
	    public void setNet_Wt_Tot(float Net_Wt_Tot)
	    {
	    	this.Net_Wt_Tot=Net_Wt_Tot;
	    }	
	    
	    private float Deduction_Wt_Tot;
		
		public float getDeduction_Wt_Tot()
		{
			return Deduction_Wt_Tot;
		}
	    public void setDeduction_Wt_Tot(float Deduction_Wt_Tot)
	    {
	    	this.Deduction_Wt_Tot=Deduction_Wt_Tot;
	    }	
	    
	    private String Temp_Jewel_Desc;
		
		public String getTemp_Jewel_Desc()
		{
			return Temp_Jewel_Desc;
		}
	    public void setTemp_Jewel_Desc(String Temp_Jewel_Desc)
	    {
	    	this.Temp_Jewel_Desc=Temp_Jewel_Desc;
	    }	
	    
	    private String s31;
		
		public String getS31()
		{
			return s31;
		}
		public void setS31(String s31)
		{
			this.s31=s31;
		}
		
		private String s32;
		
		public String getS32()
		{
			return s32;
		}
		public void setS32(String s32)
		{
			this.s32=s32;
		}
		
		private String s33;
		
		public String getS33()
		{
			return s33;
		}
		public void setS33(String s33)
		{
			this.s33=s33;
		}
		
		private String s34;
		
		public String getS34()
		{
			return s34;
		}
		public void setS34(String s34)
		{
			this.s34=s34;
		}
		
		private String s35;
		
		public String getS35()
		{
			return s35;
		}
		public void setS35(String s35)
		{
			this.s35=s35;
		}
		
	private String s36;
		
		public String getS36()
		{
			return s36;
		}
		public void setS36(String s36)
		{
			this.s36=s36;
		}
		
		private String s37;
		
		public String getS37()
		{
			return s37;
		}
		public void setS37(String s37)
		{
			this.s37=s37;
		}
		
		private String s38;
		
		public String getS38()
		{
			return s38;
		}
		public void setS38(String s38)
		{
			this.s38=s38;
		}
		
		private String s39;
		
		public String getS39()
		{
			return s39;
		}
		public void setS39(String s39)
		{
			this.s39=s39;
		}
		
		private String s40;
		
		public String getS40()
		{
			return s40;
		}
		public void setS40(String s40)
		{
			this.s40=s40;
		}
		
	private int s41;
		
		public int getS41()
		{
			return s41;
		}
		public void setS41(int s41)
		{
			this.s41=s41;
		}
		
		private int s42;
		
		public int getS42()
		{
			return s42;
		}
		public void setS42(int s42)
		{
			this.s42=s42;
		}
		
	private int s43;
		
		public int getS43()
		{
			return s43;
		}
		public void setS43(int s43)
		{
			this.s43=s43;
		}
		
		
		private int s44;
		
		public int getS44()
		{
			return s44;
		}
		public void setS44(int s44)
		{
			this.s44=s44;
		}
		
		private int s45;
		
		public int getS45()
		{
			return s45;
		}
		public void setS45(int s45)
		{
			this.s45=s45;
		}
		
	private int s46;
		
		public int getS46()
		{
			return s46;
		}
		public void setS46(int s46)
		{
			this.s46=s46;
		}
		
		private int s47;
		
		public int getS47()
		{
			return s47;
		}
		public void setS47(int s47)
		{
			this.s47=s47;
		}
		
		private int s48;
		
		public int getS48()
		{
			return s48;
		}
		public void setS48(int s48)
		{
			this.s48=s48;
		}
		
		private int s49;
		
		public int getS49()
		{
			return s49;
		}
		public void setS49(int s49)
		{
			this.s49=s49;
		}
		
		private int s50;
		
		public int getS50()
		{
			return s50;
		}
		public void setS40(int s50)
		{
			this.s50=s50;
		}
		
	private float s51;
		
		public float getS51()
		{
			return s51;
		}
		public void setS51(float s51)
		{
			this.s51=s51;
		}
		
		private float s52;
		
		public float getS52()
		{
			return s52;
		}
		public void setS52(float s52)
		{
			this.s52=s52;
		}
		
	private float s53;
		
		public float getS53()
		{
			return s53;
		}
		public void setS53(float s53)
		{
			this.s53=s53;
		}
		
		private float s54;
		
		public float getS54()
		{
			return s54;
		}
		public void setS54(float s54)
		{
			this.s54=s54;
		}
		
	private float s55;
		
		public float getS55()
		{
			return s55;
		}
		public void setS55(float s55)
		{
			this.s55=s55;
		}
		
	private float s56;
		
		public float getS56()
		{
			return s56;
		}
		public void setS56(float s56)
		{
			this.s56=s56;
		}
		
		private float s57;
		
		public float getS57()
		{
			return s57;
		}
		public void setS57(float s57)
		{
			this.s57=s57;
		}
		
		private float s58;
		
		public float getS58()
		{
			return s58;
		}
		public void setS58(float s58)
		{
			this.s58=s58;
		}
		
		private float s59;
		
		public float getS59()
		{
			return s59;
		}
		public void setS59(float s59)
		{
			this.s59=s59;
		}
		
		private float s60;
		
		public float getS60()
		{
			return s60;
		}
		public void setS60(float s60)
		{
			this.s60=s60;
		}
		
		List<JL_Master> List_Array;
		
		public List<JL_Master> getList_Array()
		{
			return List_Array;
		}
		public void setList_Array(List<JL_Master> List_Array)
		{
			this.List_Array=List_Array;
		}
		
		private List<JL_Master> contacts = new LinkedList<JL_Master>();;

		public List<JL_Master> getContacts() {
			return contacts;
		}

		public void setContacts(List<JL_Master> contacts) {
			this.contacts = contacts;
		}
		
		
		private List<JL_Master> personList = new LinkedList<JL_Master>();
		 
	    public JL_Master(List<JL_Master> personList) {
	        this.personList = personList;
	    }
	 
	    public List<JL_Master> getPersonList() {
	        return personList;
	    }
	 
	    public void setPersonList(List<JL_Master> personList) {
	        this.personList = personList;
	    }
	    
	    
	    private float Head_Amt_Tot;
		
		public float getHead_Amt_Tot()
		{
			return Head_Amt_Tot;
		}
		public void setHead_Amt_Tot(float Head_Amt_Tot)
		{
			this.Head_Amt_Tot=Head_Amt_Tot;
		}
	    
	   
	    public int getUpdateGL_Head_Flag() {
			return UpdateGL_Head_Flag;
		}
		public void setUpdateGL_Head_Flag(int updateGL_Head_Flag) {
			UpdateGL_Head_Flag = updateGL_Head_Flag;
		}

		public int getPurity() {
			return purity;
		}
		public void setPurity(int purity) {
			this.purity = purity;
		}

		public String getFile_Type() {
			return File_Type;
		}
		public void setFile_Type(String file_Type) {
			File_Type = file_Type;
		}

		public String getPan_No() {
			return Pan_No;
		}
		public void setPan_No(String pan_No) {
			Pan_No = pan_No;
		}

		public int getBranchCode() {
			return BranchCode;
		}
		public void setBranchCode(int branchCode) {
			BranchCode = branchCode;
		}

		public String getDuration() {
			return Duration;
		}
		public void setDuration(String duration) {
			Duration = duration;
		}

		public int getPurity_Check() {
			return Purity_Check;
		}
		public void setPurity_Check(int purity_Check) {
			Purity_Check = purity_Check;
		}

		public String getPaid_Status() {
			return Paid_Status;
		}
		public void setPaid_Status(String paid_Status) {
			Paid_Status = paid_Status;
		}

		public String getOver_Due_Interest_Rate() {
			return Over_Due_Interest_Rate;
		}
		public void setOver_Due_Interest_Rate(String over_Due_Interest_Rate) {
			Over_Due_Interest_Rate = over_Due_Interest_Rate;
		}

		public float getTill_Date_Due() {
			return Till_Date_Due;
		}
		public void setTill_Date_Due(float till_Date_Due) {
			Till_Date_Due = till_Date_Due;
		}

		public String getFlag() {
			return Flag;
		}
		public void setFlag(String flag) {
			Flag = flag;
		}

		public int getBranchName() {
			return BranchName;
		}
		public void setBranchName(int branchName) {
			BranchName = branchName;
		}

		private int UpdateGL_Head_Flag=1;
		
		
		
		
		private String File_Type;
		
		private String Pan_No;
	    
private int purity;

private int BranchCode;




private String Duration;
private int Purity_Check;


private String Paid_Status;
private String Over_Due_Interest_Rate;

private float Till_Date_Due;
private String Flag;	




				
}
