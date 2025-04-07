package com.Pisquare.Beans;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Employee 
{
	public Employee()
	{
		
	}
	private String Cashier;
	
	private CommonsMultipartFile fileData1;
	private String Commun_Address;
	private String Father_Occupation;
	private String Mother_Name;
	private String Mother_Occupation;
	private String Place_birth;
	private String Religion;
	private String caste;
	private String Home_Town;
	private String Driving_Licence;
	private String Passport_No;
	private String Cibil_Score;
	private String Cibil_Date;
	private boolean CheckBox;
	
	private String GL_Code;
	
	
	public String getEmp_Id() {
		return Emp_Id;
	}
	public void setEmp_Id(String emp_Id) {
		Emp_Id = emp_Id;
	}

	public String getEmp_Name() {
		return Emp_Name;
	}

	public void setEmp_Name(String emp_Name) {
		Emp_Name = emp_Name;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getDob() {
		return Dob;
	}

	public void setDob(String dob) {
		Dob = dob;
	}

	public String getFather_Name() {
		return Father_Name;
	}

	public void setFather_Name(String father_Name) {
		Father_Name = father_Name;
	}

	public String getMarital_Status() {
		return Marital_Status;
	}

	public void setMarital_Status(String marital_Status) {
		Marital_Status = marital_Status;
	}

	public String getEmail_id() {
		return Email_id;
	}

	public void setEmail_id(String email_id) {
		Email_id = email_id;
	}

	public String getMobile_number() {
		return Mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		Mobile_number = mobile_number;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getEdu_qualifi() {
		return Edu_qualifi;
	}

	public void setEdu_qualifi(String edu_qualifi) {
		Edu_qualifi = edu_qualifi;
	}

	public String getUser_name() {
		return User_name;
	}

	public void setUser_name(String user_name) {
		User_name = user_name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getAccess_Level() {
		return Access_Level;
	}

	public void setAccess_Level(String access_Level) {
		Access_Level = access_Level;
	}

	public String getLogin_type() {
		return Login_type;
	}

	public void setLogin_type(String login_type) {
		Login_type = login_type;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getUser_Level() {
		return User_Level;
	}

	public void setUser_Level(String user_Level) {
		User_Level = user_Level;
	}

	public String getMuli_branch() {
		return Muli_branch;
	}

	public void setMuli_branch(String muli_branch) {
		Muli_branch = muli_branch;
	}

	public String getSubakalyan() {
		return Subakalyan;
	}

	public void setSubakalyan(String subakalyan) {
		Subakalyan = subakalyan;
	}

	public String getTransaction_Edit() {
		return Transaction_Edit;
	}

	public void setTransaction_Edit(String transaction_Edit) {
		Transaction_Edit = transaction_Edit;
	}

	private String Emp_Id;
	private String Emp_Name;
	private String Gender;
	private String Dob;
	private String Father_Name;
	private String Marital_Status;
	private String Email_id;
	private String Mobile_number;
	private String Address;
	private String Edu_qualifi;
	
	private String User_name;
	private String Password;
	private String Access_Level;
	private String Login_type;
	private String Status;
	private String Designation;
	private String User_Level;
	private String Muli_branch;
	private String Subakalyan;
	private String Transaction_Edit;
	private String txt_from_date;
	private String txt_to_date;
	
	
	
	
	private String Joining_Date;
	
	private CommonsMultipartFile fileData;
	
	
	private String Branch_Type;
private String FD_Type;


public String getTxt_to_date() {
			return txt_to_date;
		}

		public void setTxt_to_date(String txt_to_date) {
			this.txt_to_date = txt_to_date;
		}

		public String getTxt_from_date() {
			return txt_from_date;
		}

		public void setTxt_from_date(String txt_from_date) {
			this.txt_from_date = txt_from_date;
		}
	

	 public CommonsMultipartFile getFileData() {
	  return fileData;
	 }

	 public void setFileData(CommonsMultipartFile fileData) {
	  this.fileData = fileData;
	 }
	 
	 private CommonsMultipartFile signData;
		public CommonsMultipartFile getSignData() {
			return signData;
		}
		public void setSignData(CommonsMultipartFile signData) {
			this.signData = signData;
		}

		public String getJoining_Date() {
			return Joining_Date;
		}

		public void setJoining_Date(String joining_Date) {
			Joining_Date = joining_Date;
		}

		public String getBranch_Type() {
			return Branch_Type;
		}

		public void setBranch_Type(String branch_Type) {
			Branch_Type = branch_Type;
		}
		
		
		public String getFile_Type() {
			return File_Type;
		}

		public void setFile_Type(String file_Type) {
			File_Type = file_Type;
		}

		public int getDays() {
			return Days;
		}

		public void setDays(int days) {
			Days = days;
		}

		public String getMessage1() {
			return message1;
		}

		public void setMessage1(String message1) {
			this.message1 = message1;
		}

		public String getAttendance_Level() {
			return Attendance_Level;
		}

		public void setAttendance_Level(String attendance_Level) {
			Attendance_Level = attendance_Level;
		}

		public String getAttendance_Status() {
			return Attendance_Status;
		}

		public void setAttendance_Status(String attendance_Status) {
			Attendance_Status = attendance_Status;
		}

		public String getResign_Date() {
			return Resign_Date;
		}

		public void setResign_Date(String resign_Date) {
			Resign_Date = resign_Date;
		}

		public String getSus_From_Date() {
			return Sus_From_Date;
		}

		public void setSus_From_Date(String sus_From_Date) {
			Sus_From_Date = sus_From_Date;
		}

		public String getSus_To_Date() {
			return Sus_To_Date;
		}

		public void setSus_To_Date(String sus_To_Date) {
			Sus_To_Date = sus_To_Date;
		}

		public int getBank_Code() {
			return Bank_Code;
		}

		public void setBank_Code(int bank_Code) {
			Bank_Code = bank_Code;
		}

		public String getBank_Desc() {
			return Bank_Desc;
		}

		public void setBank_Desc(String bank_Desc) {
			Bank_Desc = bank_Desc;
		}

		public String getFD_Type() {
			return FD_Type;
		}

		public void setFD_Type(String fD_Type) {
			FD_Type = fD_Type;
		}

		public String getRemarks() {
			return Remarks;
		}

		public void setRemarks(String remarks) {
			Remarks = remarks;
		}

		public String getGL_Code() {
			return GL_Code;
		}
		public void setGL_Code(String gL_Code) {
			GL_Code = gL_Code;
		}

		public String getCategory() {
			return Category;
		}
		public void setCategory(String category) {
			Category = category;
		}

		public int getEmpmasterflag() {
			return empmasterflag;
		}
		public void setEmpmasterflag(int empmasterflag) {
			this.empmasterflag = empmasterflag;
		}

		public String getLockStatus() {
			return LockStatus;
		}
		public void setLockStatus(String lockStatus) {
			LockStatus = lockStatus;
		}

		public String getCorpTransaction() {
			return CorpTransaction;
		}
		public void setCorpTransaction(String corpTransaction) {
			CorpTransaction = corpTransaction;
		}

		public String getPermissionLevel() {
			return PermissionLevel;
		}
		public void setPermissionLevel(String permissionLevel) {
			PermissionLevel = permissionLevel;
		}

		public String getMaternity_From_Date() {
			return Maternity_From_Date;
		}
		public void setMaternity_From_Date(String maternity_From_Date) {
			Maternity_From_Date = maternity_From_Date;
		}

		public String getMaternity_To_Date() {
			return Maternity_To_Date;
		}
		public void setMaternity_To_Date(String maternity_To_Date) {
			Maternity_To_Date = maternity_To_Date;
		}

		public String getSuper_Admin() {
			return Super_Admin;
		}
		public void setSuper_Admin(String super_Admin) {
			Super_Admin = super_Admin;
		}

		public String getLast_Name() {
			return Last_Name;
		}
		public void setLast_Name(String last_Name) {
			Last_Name = last_Name;
		}

		public String getCorp_Login() {
			return Corp_Login;
		}
		public void setCorp_Login(String corp_Login) {
			Corp_Login = corp_Login;
		}

		public CommonsMultipartFile getResignData() {
			return ResignData;
		}
		public void setResignData(CommonsMultipartFile resignData) {
			ResignData = resignData;
		}

		public CommonsMultipartFile getSuspention() {
			return Suspention;
		}
		public void setSuspention(CommonsMultipartFile suspention) {
			Suspention = suspention;
		}

		public CommonsMultipartFile getMaternity() {
			return Maternity;
		}
		public void setMaternity(CommonsMultipartFile maternity) {
			Maternity = maternity;
		}

		

		public String getWorking_Status() {
			return Working_Status;
		}
		public void setWorking_Status(String working_Status) {
			Working_Status = working_Status;
		}

		public String getWorking_Details() {
			return Working_Details;
		}
		public void setWorking_Details(String working_Details) {
			Working_Details = working_Details;
		}

		public String getCurrent_Branch() {
			return Current_Branch;
		}
		public void setCurrent_Branch(String current_Branch) {
			Current_Branch = current_Branch;
		}

		public CommonsMultipartFile getResumeData() {
			return ResumeData;
		}
		public void setResumeData(CommonsMultipartFile resumeData) {
			ResumeData = resumeData;
		}

		public String getPromotion_Date() {
			return Promotion_Date;
		}
		public void setPromotion_Date(String promotion_Date) {
			Promotion_Date = promotion_Date;
		}

		public String getPromotion_Details() {
			return Promotion_Details;
		}
		public void setPromotion_Details(String promotion_Details) {
			Promotion_Details = promotion_Details;
		}

		public String getAdditional_Mobile() {
			return Additional_Mobile;
		}
		public void setAdditional_Mobile(String additional_Mobile) {
			Additional_Mobile = additional_Mobile;
		}

		public String getAadhar_No() {
			return Aadhar_No;
		}
		public void setAadhar_No(String aadhar_No) {
			Aadhar_No = aadhar_No;
		}

		public String getPan_No() {
			return Pan_No;
		}
		public void setPan_No(String pan_No) {
			Pan_No = pan_No;
		}

		public String getBank_Acc_No() {
			return Bank_Acc_No;
		}
		public void setBank_Acc_No(String bank_Acc_No) {
			Bank_Acc_No = bank_Acc_No;
		}

		public String getBank_Acc_Name() {
			return Bank_Acc_Name;
		}
		public void setBank_Acc_Name(String bank_Acc_Name) {
			Bank_Acc_Name = bank_Acc_Name;
		}

		public String getIFSC_Code() {
			return IFSC_Code;
		}
		public void setIFSC_Code(String iFSC_Code) {
			IFSC_Code = iFSC_Code;
		}

		public String getBank_Name() {
			return Bank_Name;
		}
		public void setBank_Name(String bank_Name) {
			Bank_Name = bank_Name;
		}

		public String getCurrent_Status() {
			return Current_Status;
		}
		public void setCurrent_Status(String current_Status) {
			Current_Status = current_Status;
		}

		public String getGL_Code2() {
			return GL_Code2;
		}
		public void setGL_Code2(String gL_Code2) {
			GL_Code2 = gL_Code2;
		}

		public CommonsMultipartFile getFileData1() {
			return fileData1;
		}
		public void setFileData1(CommonsMultipartFile fileData1) {
			this.fileData1 = fileData1;
		}
		public String getCommun_Address() {
			return Commun_Address;
		}
		public void setCommun_Address(String commun_Address) {
			Commun_Address = commun_Address;
		}
		public String getFather_Occupation() {
			return Father_Occupation;
		}
		public void setFather_Occupation(String father_Occupation) {
			Father_Occupation = father_Occupation;
		}
		public String getMother_Name() {
			return Mother_Name;
		}
		public void setMother_Name(String mother_Name) {
			Mother_Name = mother_Name;
		}
		public String getMother_Occupation() {
			return Mother_Occupation;
		}
		public void setMother_Occupation(String mother_Occupation) {
			Mother_Occupation = mother_Occupation;
		}
		public String getPlace_birth() {
			return Place_birth;
		}
		public void setPlace_birth(String place_birth) {
			Place_birth = place_birth;
		}
		public String getReligion() {
			return Religion;
		}
		public void setReligion(String religion) {
			Religion = religion;
		}
		public String getCaste() {
			return caste;
		}
		public void setCaste(String caste) {
			this.caste = caste;
		}
		public String getHome_Town() {
			return Home_Town;
		}
		public void setHome_Town(String home_Town) {
			Home_Town = home_Town;
		}
		public String getDriving_Licence() {
			return Driving_Licence;
		}
		public void setDriving_Licence(String driving_Licence) {
			Driving_Licence = driving_Licence;
		}
		public String getPassport_No() {
			return Passport_No;
		}
		public void setPassport_No(String passport_No) {
			Passport_No = passport_No;
		}
		public String getCibil_Score() {
			return Cibil_Score;
		}
		public void setCibil_Score(String cibil_Score) {
			Cibil_Score = cibil_Score;
		}
		public String getCibil_Date() {
			return Cibil_Date;
		}
		public void setCibil_Date(String cibil_Date) {
			Cibil_Date = cibil_Date;
		}
		public boolean isCheckBox() {
			return CheckBox;
		}
		public void setCheckBox(boolean checkBox) {
			CheckBox = checkBox;
		}
		public String getCashier() {
			return Cashier;
		}
		public void setCashier(String cashier) {
			Cashier = cashier;
		}
		private String File_Type;
		private int Days;
		
		
		private String message1;
		
		
		private String Attendance_Level;
		private String Attendance_Status;
		
		
		private String Resign_Date;
		private String Sus_From_Date;
		private String Sus_To_Date;
		
		
		
		//Designation
		private int Bank_Code;
		private String Bank_Desc;
		

	
	private String Remarks;
	
	private String Category;
	
	private int empmasterflag=1;
	
	private String LockStatus;
	
	
	private String CorpTransaction;
	private String PermissionLevel;
	
	
	private String Maternity_From_Date;
	private String Maternity_To_Date;
	
	private String Super_Admin="N";
	private String Last_Name;
	
	private String Corp_Login="P";
	
	
	 private CommonsMultipartFile ResignData;//Suspention
	 private CommonsMultipartFile Suspention;//Maternity
	 private CommonsMultipartFile Maternity;//Maternity
	 
	 private CommonsMultipartFile ResumeData;//Resume
	 private String Working_Status;
	 private String Working_Details;
	 private String Current_Branch;
		
	 private String Promotion_Date;
	 private String Promotion_Details;
	 
	 private String Additional_Mobile;
	 private String Aadhar_No;
	 private String Pan_No;
	 private String Bank_Acc_No;
	 private String Bank_Acc_Name;
	 private String IFSC_Code;
	 private String Bank_Name;
	 
	 
	 private String Current_Status;
	 
		private String GL_Code2;
	
	}
