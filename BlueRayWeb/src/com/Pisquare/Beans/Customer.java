package com.Pisquare.Beans;

import java.util.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Customer {
	
	private int Id;	   
	public int getId()
	{
		return Id;
	}
	public void setId(int Id)
	{
		this.Id=Id;
	}
	
	
	private int Branch_Code;
	public int getBranch_Code()
	{
		return Branch_Code;
	}
	public void setBranch_Code(int Branch_Code)
	{
		this.Branch_Code=Branch_Code;
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
	
	
	private int Customer_Id2;
	public int getCustomer_Id2()
	{
		return Customer_Id2;
	}
	public void setCustomer_Id2(int Customer_Id2)
	{
		this.Customer_Id2=Customer_Id2;
	}
	
	
	private String Create_Date;
	public String getCreate_Date()
	{
		return Create_Date;
	}
	public void setCreate_Date(String Create_Date)
	{
		this.Create_Date=Create_Date;
	}
	
	private String Customer_Name;
	public String getCustomer_Name()
	{
		return Customer_Name;
	}
	public void setCustomer_Name(String Customer_Name)
	{
		this.Customer_Name=Customer_Name;
	}
	
		
	private String Date_of_Birth;	
	public String getDate_of_Birth()
	{
		return Date_of_Birth;
	}
	public void setDate_of_Birth(String Date_of_Birth)
	{
		this.Date_of_Birth=Date_of_Birth;
	}
	
	private String Gender;
	public String getGender()
	{
		return Gender;
	}
	public void setGender(String Gender)
	{
		this.Gender=Gender;
	}
	
	private String Marital_Status;	
	public String getMarital_Status()
	{
		return Marital_Status;
	}
	public void setMarital_Status(String Marital_Status)
	{
		this.Marital_Status=Marital_Status;
	}
	
	private String Father_Name;
	public String getFather_Name()
	{
		return Father_Name;
	}
	public void setFather_Name(String Father_Name)
	{
		this.Father_Name=Father_Name;
	}
	
	private String Occupation;
	public String getOccupation()
	{
		return Occupation;
	}
	public void setOccupation(String Occupation)
	{
		this.Occupation=Occupation;
	}	
	
	
	
	
	
	private String Address;
	public String getAddress()
	{
		return Address;
	}
	public void setAddress(String Address)
	{
		this.Address=Address;
	}
	
	private String City;
	public String getCity()
	{
		return City;
	}
	public void setCity(String City)
	{
		this.City=City;
	}
	
	private String Pincode;
	public String getPincode()
	{
		return Pincode;
	}
	public void setPincode(String Pincode)
	{
		this.Pincode=Pincode;
	}
	
	private String Customer_Type;
	public String getCustomer_Type()
	{
		return Customer_Type;
	}
	public void setCustomer_Type(String Customer_Type)
	{
		this.Customer_Type=Customer_Type;
	}
	
	private String Id_Type;
	public String getId_Type()
	{
		return Id_Type;
	}
	public void setId_Type(String Id_Type)
	{
		this.Id_Type=Id_Type;
	}

	private String Id_No;
	public String getId_No()
	{
		return Id_No;
	}
	public void setId_No(String Id_No)
	{
		this.Id_No=Id_No;
	}
	
	private String Issue_Date;
	public String getIssue_Date()
	{
		return Issue_Date;
	}
	public void setIssue_Date(String Issue_Date)
	{
		this.Issue_Date=Issue_Date;
	}
	
	private String Issue_Place;
	public String getIssue_Place()
	{
		return Issue_Place;
	}
	public void setIssue_Place(String Issue_Place)
	{
		this.Issue_Place=Issue_Place;
	}
	
	private String Phone_No;
	public String getPhone_No()
	{
		return Phone_No;
	}
	public void setPhone_No(String Phone_No)
	{
		this.Phone_No=Phone_No;
	}
	
	private String Mail;
	public String getMail()
	{
		return Mail;
	}
	public void setMail(String Mail)
	{
		this.Mail=Mail;
	}

	private String Introducer_Id;
	public String getIntroducer_Id()
	{
		return Introducer_Id;
	}
	public void setIntroducer_Id(String Introducer_Id)
	{
		this.Introducer_Id=Introducer_Id;
	}
	
	private String Introducer_Name;
	public String getIntroducer_Name()
	{
		return Introducer_Name;
	}
	public void setIntroducer_Name(String Introducer_Name)
	{
		this.Introducer_Name=Introducer_Name;
	}
	
	private String Remarks;
	public String getRemarks()
	{
		return Remarks;
	}
	public void setRemarks(String Remarks)
	{
		this.Remarks=Remarks;
	}
	
	private byte[] Photo;	
	public byte[] getPhoto()
	{
		return Photo;
	}
	public void setPhoto(byte[] Photo)
	{
		this.Photo=Photo;
	}
	
	private String Mobile_No;
	public String getMobile_No()
	{
		return Mobile_No;
	}
	public void setMobile_No(String Mobile_No)
	{
		this.Mobile_No=Mobile_No;
	}	
	
	private String Anniversary_Date;
	public String getAnniversary_Date()
	{
		return Anniversary_Date;
	}
	public void setAnniversary_Date(String Anniversary_Date)
	{
		this.Anniversary_Date=Anniversary_Date;
	}
	
	private String Created_By;
	public String getCreated_By()
	{
		return Created_By;
	}
	public void setCreated_By(String Created_By)
	{
		this.Created_By=Created_By;
	}
	
	private Date Created_Date;
	public Date getCreated_Date()
	{
		return Created_Date;
	}
	public void setCreated_Date(Date Created_Date)
	{
		this.Created_Date=Created_Date;
	}
	
	private String Modified_By;	
	public String getModified_By()
	{
		return Modified_By;
	}
	public void setModified_By(String Modified_By)
	{
		this.Modified_By=Modified_By;
	}
	
	private String Modified_Date;	
	public String getModified_Date()
	{
		return Modified_Date;
	}
	public void setModified_Date(String Modified_Date)
	{
		this.Modified_Date=Modified_Date;
	}

	private String Authorized_By;
	public String getAuthorized_By()
	{
		return Authorized_By;
	}
	public void setAuthorized_By(String Authorized_By)
	{
		this.Authorized_By=Authorized_By;
	}
	
	private Date Authorized_Date;
	public Date getAuthorized_Date()
	{
		return Authorized_Date;
	}
	public void setAuthorized_Date(Date Authorized_Date)
	{
		this.Authorized_Date=Authorized_Date;
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
	

	private String Nominee_DOB;	
	public String getNominee_DOB()
	{
		return Nominee_DOB;
	}
	public void setNominee_DOB(String Nominee_DOB)
	{
		this.Nominee_DOB=Nominee_DOB;
	}
	
	private String Old_Cus_Id;	
	public String getOld_Cus_Id()
	{
		return Old_Cus_Id;
	}
	public void setOld_Cus_Id(String Old_Cus_Id)
	{
		this.Old_Cus_Id=Old_Cus_Id;
	}
	
	private String Customer_Status;	
	public String getCustomer_Status()
	{
		return Customer_Status;
	}
	public void setCustomer_Status(String Customer_Status)
	{
		this.Customer_Status=Customer_Status;
	}
	
	private String Id_Type_2;
	public String getId_Type_2()
	{
		return Id_Type_2;
	}
	public void setId_Type_2(String Id_Type_2)
	{
		this.Id_Type_2=Id_Type_2;
	}
	
	private String Id_No_2;
	public String getId_No_2()
	{
		return Id_No_2;
	}
	public void setId_No_2(String Id_No_2)
	{
		this.Id_No_2=Id_No_2;
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
	
	private String SMS_Feature;	
	public String getSMS_Feature()
	{
		return SMS_Feature;
	}
	public void setSMS_Feature(String SMS_Feature)
	{
		this.SMS_Feature=SMS_Feature;
	}
	
	private String Mig_Flag;	
	public String getMig_Flag()
	{
		return Mig_Flag;
	}
	public void setMig_Flag(String Mig_Flag)
	{
		this.Mig_Flag=Mig_Flag;
	}
	
	private String Permanent_Address;
	public String getPermanent_Address()
	{
		return Permanent_Address;
	}
	public void setPermanent_Address(String Permanent_Address)
	{
		this.Permanent_Address=Permanent_Address;
	}
	
	private String Permanent_City;	
	public String getPermanent_City()
	{
		return Permanent_City;
	}
	public void setPermanent_City(String Permanent_City)
	{
		this.Permanent_City=Permanent_City;
	}

	private String Permanent_Pincode;	
	public String getPermanent_Pincode()
	{
		return Permanent_Pincode;
	}
	public void setPermanent_Pincode(String Permanent_Pincode)
	{
		this.Permanent_Pincode=Permanent_Pincode;
	}
	
	private byte[] Signature;	
	public byte[] getSignature()
	{
		return Signature;
	}
	public void setSignature(byte[] Signature)
	{
		this.Signature=Signature;
	}
	
	
	//------------------------------------------------Customer Reports-----------------------------------------------------------
	
	private String Customer_Info;	
	public String getCustomer_Info()
	{
		return Customer_Info;
	}
	public void setCustomer_Info(String Customer_Info)
	{
		this.Customer_Info=Customer_Info;
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
	//-------------------------------------------------------------------------------------------------------------
	public Customer() 
	{
		
	}

	
	private String Door_No;
	public String getDoor_No()
	{
		return Door_No;
	}
	public void setDoor_No(String Door_No)
	{
		this.Door_No=Door_No;
	}
	
	
	private String Street_Name;
	public String getStreet_Name()
	{
		return Street_Name;
	}
	public void setStreet_Name(String Street_Name)
	{
		this.Street_Name=Street_Name;
	}
	
	private String Premises;
	public String getPremises()
	{
		return Premises;
	}
	public void setPremises(String Premises)
	{
		this.Premises=Premises;
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
	
	private String State;
	public String getState()
	{
		return State;
	}
	public void setState(String State)
	{
		this.State=State;
	}
	
	
	
	private int Std;
	public int getStd()
	{
		return Std;
	}
	public void setStd(int Std)
	{
		this.Std=Std;
	}
	
	private String Permanent_Door_No;
	public String getPermanent_Door_No()
	{
		return Permanent_Door_No;
	}
	public void setPermanent_Door_No(String Permanent_Door_No)
	{
		this.Permanent_Door_No=Permanent_Door_No;
	}
	
	
	private String Permanent_Street_Name;
	public String getPermanent_Street_Name()
	{
		return Permanent_Street_Name;
	}
	public void setPermanent_Street_Name(String Permanent_Street_Name)
	{
		this.Permanent_Street_Name=Permanent_Street_Name;
	}
	
	private String Permanent_Premises;
	public String getPermanent_Premises()
	{
		return Permanent_Premises;
	}
	public void setPermanent_Premises(String Permanent_Premises)
	{
		this.Permanent_Premises=Permanent_Premises;
	}
	
	private String Permanent_Area;
	public String getPermanent_Area()
	{
		return Permanent_Area;
	}
	public void setPermanent_Area(String Permanent_Area)
	{
		this.Permanent_Area=Permanent_Area;
	}
	
	private String Permanent_State;
	public String getPermanent_State()
	{
		return Permanent_State;
	}
	public void setPermanent_State(String Permanent_State)
	{
		this.Permanent_State=Permanent_State;
	}

	
	
	private String Fillter_By;	
	public String getFillter_By()
	{
		return Fillter_By;
	}
	public void setFillter_By(String Fillter_By)
	{
		this.Fillter_By=Fillter_By;
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
	
	
	private String Account_No;
	public String getAccount_No()
	{
		return Account_No;
	}
	public void setAccount_No(String Account_No)
	{
		this.Account_No=Account_No;
	}
	
	private String Nationality;	
	public String getNationality()
	{
		return Nationality;
	}
	public void setNationality(String Nationality)
	{
		this.Nationality=Nationality;
	}
	
	//Nationality_Others
	private String Nationality_Others;	
	public String getNationality_Others()
	{
		return Nationality_Others;
	}
	public void setNationality_Others(String Nationality_Others)
	{
		this.Nationality_Others=Nationality_Others;
	}
	
	
	
	//Per_Nationality
	
	private String Per_Nationality;	
	public String getPer_Nationality()
	{
		return Per_Nationality;
	}
	public void setPer_Nationality(String Per_Nationality)
	{
		this.Per_Nationality=Per_Nationality;
	}
	
	
	
	//Per_Nationality_Others
	
	private String Per_Nationality_Others;	
	public String getPer_Nationality_Others()
	{
		return Per_Nationality_Others;
	}
	public void setPer_Nationality_Others(String Per_Nationality_Others)
	{
		this.Per_Nationality_Others=Per_Nationality_Others;
	}
	
	
	private CommonsMultipartFile fileData;

	

	 public CommonsMultipartFile getFileData() {
	  return fileData;
	 }

	 public void setFileData(CommonsMultipartFile fileData) {
	  this.fileData = fileData;
	 }
	
	
	 private String Branch_Type;
	public String getBranch_Type() {
		return Branch_Type;
	}
	public void setBranch_Type(String branch_Type) {
		Branch_Type = branch_Type;
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
	
	
	

	private String CusString1;
	public String getCusString1() {
		return CusString1;
	}
	public void setCusString1(String cusString1) {
		CusString1 = cusString1;
	}
	
	public String getSv() {
		return sv;
	}
	public void setSv(String sv) {
		this.sv = sv;
	}


	private String sv;
	
	
	private boolean checkAll;
	public boolean isCheckAll() {
		return checkAll;
	}

	public void setCheckAll(boolean checkAll) {
		this.checkAll = checkAll;
	}
	
	
	
	public String getScheme_Type() {
		return Scheme_Type;
	}
	public void setScheme_Type(String scheme_Type) {
		Scheme_Type = scheme_Type;
	}


	private String Scheme_Type;
}
