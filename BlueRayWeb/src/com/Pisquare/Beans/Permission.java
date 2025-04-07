package com.Pisquare.Beans;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Permission {
	
	
	//@NotEmpty(message = "Please enter the UserId.")
	//@Size(min = 3, max = 15, message = "User Id must between 3 and 15 characters")
	private String Username;
	private List<String> Branch_Code;
	private String Page_Type;
	private List<String> Operation_Types;

	
	private ArrayList<String> CT_Operation_Types=null;
	
	private List<String> SM_Operation_Types=null;
	private List<String> SD_Operation_Types=null;
	private List<String> FD_Operation_Types=null;
	private List<String> RD_Operation_Types=null;
	private List<String> JL_Operation_Types=null;
	private List<String> OL_Operation_Types=null;
	private List<String> JO_Operation_Types=null;
	private List<String> ST_Operation_Types=null;
	private List<String> TR_Operation_Types=null;
	private List<String> IB_Operation_Types=null;
	
	
	
	
	
	
	
	
	private ArrayList<String> Master_Operation_Types=null;
	
	private List<String> CustomerList_Operation_Types=null;
	private List<String> ViewTrans_Operation_Types=null;
	private List<String> Certificates_Operation_Types=null;
	private List<String> LoanApproval_Operation_Types=null;
	private List<String> ApprovalList_Operation_Types=null;
	private List<String> TDSReport_Operation_Types=null;
	private List<String> AuditReport_Operation_Types=null;
	private List<String> PermissionSettings_Operation_Types=null;
	
	private List<Cus> UsernameList;
	
	private ArrayList<String> nameList;
	
	
	
	private String To_View;
	private String To_Save;
	private String To_Update;
	private String To_Delete;
	private String To_Verify1;
	private String To_Verify2;
	private String To_Reports;

	
	public Permission()
	{
		
	}
	
		
	
	public Permission(String Username,List<String> branch,String Page_Type,List<String> Operation_Types)
	{
		super();
		this.Username=Username;
		this.Branch_Code=branch;
		this.Page_Type=Page_Type;
		this.Operation_Types=Operation_Types;
		
	}
	
	
	public Permission(List<Cus> un)
	{
		this.UsernameList=un;
	}
	
	public String getUsername()
	{
		return Username;
	}
	public void setUsername(String Username)
	{
		this.Username=Username;
	}

	public List<String> getBranch_Code()
	{
		return Branch_Code;
	}
	public void setBranch_Code(List<String> Branch_Code)
	{
		this.Branch_Code=Branch_Code;
	}


	
	
	public String getPage_Type()
	{
		return Page_Type;
	}
	public void setPage_Type(String Page_Type)
	{
		this.Page_Type=Page_Type;
	}
	
	
	public List<String> getOperation_Types()
	{
		return Operation_Types;
	}
	public void setOperation_Types(List<String> Operation_Types)
	{
		this.Operation_Types=Operation_Types;
	}
	
	
	public List<Cus> getUsernameList()
	{
		return UsernameList;
	}
	public void setUsernameList(List<Cus> UsernameList)
	{
		this.UsernameList=UsernameList;
	}
	
	
	public ArrayList<String> getNameList()
	{
		return nameList;
	}
	public void setNameList(ArrayList<String> nameList)
	{
		this.nameList=nameList;
	}
	
	
	public ArrayList<String> getCT_Operation_Types()
	{
		return CT_Operation_Types;
	}
	public void setCT_Operation_Types(ArrayList<String> CT_Operation_Types)
	{
		this.CT_Operation_Types=CT_Operation_Types;
	}
	
	
	public List<String> getSM_Operation_Types()
	{
		return SM_Operation_Types;
	}
	public void setSM_Operation_Types(List<String> SM_Operation_Types)
	{
		this.SM_Operation_Types=SM_Operation_Types;
	}
	
	
	public List<String> getSD_Operation_Types()
	{
		return SD_Operation_Types;
	}
	public void setSD_Operation_Types(List<String> SD_Operation_Types)
	{
		this.SD_Operation_Types=SD_Operation_Types;
	}
	
	
	public List<String> getFD_Operation_Types()
	{
		return FD_Operation_Types;
	}
	public void setFD_Operation_Types(List<String> FD_Operation_Types)
	{
		this.FD_Operation_Types=FD_Operation_Types;
	}
	
	public List<String> getRD_Operation_Types()
	{
		return RD_Operation_Types;
	}
	public void setRD_Operation_Types(List<String> RD_Operation_Types)
	{
		this.RD_Operation_Types=RD_Operation_Types;
	}
	
	public List<String> getJL_Operation_Types()
	{
		return JL_Operation_Types;
	}
	public void setJL_Operation_Types(List<String> JL_Operation_Types)
	{
		this.JL_Operation_Types=JL_Operation_Types;
	}
	
	
	public List<String> getOL_Operation_Types()
	{
		return OL_Operation_Types;
	}
	public void setOL_Operation_Types(List<String> OL_Operation_Types)
	{
		this.OL_Operation_Types=OL_Operation_Types;
	}
	
	
	public List<String> getJO_Operation_Types()
	{
		return JO_Operation_Types;
	}
	public void setJO_Operation_Types(List<String> JO_Operation_Types)
	{
		this.JO_Operation_Types=JO_Operation_Types;
	}
	
	
	
	public List<String> getST_Operation_Types()
	{
		return ST_Operation_Types;
	}
	public void setST_Operation_Types(List<String> ST_Operation_Types)
	{
		this.ST_Operation_Types=ST_Operation_Types;
	}
	
	
	public List<String> getTR_Operation_Types()
	{
		return TR_Operation_Types;
	}
	public void setTR_Operation_Types(List<String> TR_Operation_Types)
	{
		this.TR_Operation_Types=TR_Operation_Types;
	}
	
	
	
	
	public List<String> getIB_Operation_Types()
	{
		return IB_Operation_Types;
	}
	public void setIB_Operation_Types(List<String> IB_Operation_Types)
	{
		this.IB_Operation_Types=IB_Operation_Types;
	}
	
	
	
	
	
	public String getTo_View()
	{
		return To_View;
	}
	public void setTo_View(String To_View)
	{
		this.To_View=To_View;
	}
	
	public String getTo_Save()
	{
		return To_Save;
	}
	public void setTo_Save(String To_Save)
	{
		this.To_Save=To_Save;
	}
	
	
	
	
	public String getTo_Delete()
	{
		return To_Delete;
	}
	public void setTo_Delete(String To_Delete)
	{
		this.To_Delete=To_Delete;
	}
	
	
	public String getTo_Update()
	{
		return To_Update;
	}
	public void setTo_Update(String To_Update)
	{
		this.To_Update=To_Update;
	}
	
	
	public String getTo_Verify1()
	{
		return To_Verify1;
	}
	public void setTo_Verify1(String To_Verify1)
	{
		this.To_Verify1=To_Verify1;
	}
	
	
	public String getTo_Verify2()
	{
		return To_Verify2;
	}
	public void setTo_Verify2(String To_Verify2)
	{
		this.To_Verify2=To_Verify2;
	}
	
	
	
	public String getTo_Reports()
	{
		return To_Reports;
	}
	public void setTo_Reports(String To_Reports)
	{
		this.To_Reports=To_Reports;
	}
	
	
	public int getViewFlag() {
		return ViewFlag;
	}



	public void setViewFlag(int viewFlag) {
		ViewFlag = viewFlag;
	}


	



	


	public List<String> getCustomerList_Operation_Types() {
		return CustomerList_Operation_Types;
	}



	public void setCustomerList_Operation_Types(
			List<String> customerList_Operation_Types) {
		CustomerList_Operation_Types = customerList_Operation_Types;
	}


	public List<String> getViewTrans_Operation_Types() {
		return ViewTrans_Operation_Types;
	}



	public void setViewTrans_Operation_Types(
			List<String> viewTrans_Operation_Types) {
		ViewTrans_Operation_Types = viewTrans_Operation_Types;
	}


	public List<String> getCertificates_Operation_Types() {
		return Certificates_Operation_Types;
	}



	public void setCertificates_Operation_Types(
			List<String> certificates_Operation_Types) {
		Certificates_Operation_Types = certificates_Operation_Types;
	}


	public List<String> getLoanApproval_Operation_Types() {
		return LoanApproval_Operation_Types;
	}



	public void setLoanApproval_Operation_Types(
			List<String> loanApproval_Operation_Types) {
		LoanApproval_Operation_Types = loanApproval_Operation_Types;
	}


	public List<String> getApprovalList_Operation_Types() {
		return ApprovalList_Operation_Types;
	}



	public void setApprovalList_Operation_Types(
			List<String> approvalList_Operation_Types) {
		ApprovalList_Operation_Types = approvalList_Operation_Types;
	}


	public List<String> getTDSReport_Operation_Types() {
		return TDSReport_Operation_Types;
	}



	public void setTDSReport_Operation_Types(
			List<String> tDSReport_Operation_Types) {
		TDSReport_Operation_Types = tDSReport_Operation_Types;
	}


	public List<String> getAuditReport_Operation_Types() {
		return AuditReport_Operation_Types;
	}



	public void setAuditReport_Operation_Types(
			List<String> auditReport_Operation_Types) {
		AuditReport_Operation_Types = auditReport_Operation_Types;
	}


	public List<String> getPermissionSettings_Operation_Types() {
		return PermissionSettings_Operation_Types;
	}



	public void setPermissionSettings_Operation_Types(
			List<String> permissionSettings_Operation_Types) {
		PermissionSettings_Operation_Types = permissionSettings_Operation_Types;
	}


	public ArrayList<String> getMaster_Operation_Types() {
		return Master_Operation_Types;
	}



	public void setMaster_Operation_Types(ArrayList<String> master_Operation_Types) {
		Master_Operation_Types = master_Operation_Types;
	}


	public List<String> getKYC_Operation_Types() {
		return KYC_Operation_Types;
	}



	public void setKYC_Operation_Types(List<String> kYC_Operation_Types) {
		KYC_Operation_Types = kYC_Operation_Types;
	}


	public List<String> getTrans_App_Operation_Types() {
		return Trans_App_Operation_Types;
	}



	public void setTrans_App_Operation_Types(
			List<String> trans_App_Operation_Types) {
		Trans_App_Operation_Types = trans_App_Operation_Types;
	}


	public List<String> getLoan_App_Operation_Types() {
		return Loan_App_Operation_Types;
	}



	public void setLoan_App_Operation_Types(List<String> loan_App_Operation_Types) {
		Loan_App_Operation_Types = loan_App_Operation_Types;
	}


	public List<String> getDay_End_Operation_Types() {
		return Day_End_Operation_Types;
	}



	public void setDay_End_Operation_Types(List<String> day_End_Operation_Types) {
		Day_End_Operation_Types = day_End_Operation_Types;
	}


	public List<String> getStaff_Attendance_Operation_Types() {
		return Staff_Attendance_Operation_Types;
	}



	public void setStaff_Attendance_Operation_Types(
			List<String> staff_Attendance_Operation_Types) {
		Staff_Attendance_Operation_Types = staff_Attendance_Operation_Types;
	}


	public String getSBT_OTP() {
		return SBT_OTP;
	}



	public void setSBT_OTP(String sBT_OTP) {
		SBT_OTP = sBT_OTP;
	}

	public String getSBT_Limit() {
		return SBT_Limit;
	}



	public void setSBT_Limit(String sBT_Limit) {
		SBT_Limit = sBT_Limit;
	}

	public String getFDC_Limit() {
		return FDC_Limit;
	}



	public void setFDC_Limit(String fDC_Limit) {
		FDC_Limit = fDC_Limit;
	}

	public String getFDC_OTP() {
		return FDC_OTP;
	}

	public void setFDC_OTP(String fDC_OTP) {
		FDC_OTP = fDC_OTP;
	}

	public String getLAD_OTP() {
		return LAD_OTP;
	}



	public void setLAD_OTP(String lAD_OTP) {
		LAD_OTP = lAD_OTP;
	}

	public String getLAD_Limit() {
		return LAD_Limit;
	}



	public void setLAD_Limit(String lAD_Limit) {
		LAD_Limit = lAD_Limit;
	}

	public String getCCT_OTP() {
		return CCT_OTP;
	}



	public void setCCT_OTP(String cCT_OTP) {
		CCT_OTP = cCT_OTP;
	}

	public String getCCT_Limit() {
		return CCT_Limit;
	}



	public void setCCT_Limit(String cCT_Limit) {
		CCT_Limit = cCT_Limit;
	}

	public String getRDC_OTP() {
		return RDC_OTP;
	}



	public void setRDC_OTP(String rDC_OTP) {
		RDC_OTP = rDC_OTP;
	}

	public String getRDC_Limit() {
		return RDC_Limit;
	}



	public void setRDC_Limit(String rDC_Limit) {
		RDC_Limit = rDC_Limit;
	}

	public String getJLM_OTP() {
		return JLM_OTP;
	}



	public void setJLM_OTP(String jLM_OTP) {
		JLM_OTP = jLM_OTP;
	}

	public String getJLM_Limit() {
		return JLM_Limit;
	}



	public void setJLM_Limit(String jLM_Limit) {
		JLM_Limit = jLM_Limit;
	}

	public String getJLR_OTP() {
		return JLR_OTP;
	}



	public void setJLR_OTP(String jLR_OTP) {
		JLR_OTP = jLR_OTP;
	}

	public String getJLR_Limit() {
		return JLR_Limit;
	}



	public void setJLR_Limit(String jLR_Limit) {
		JLR_Limit = jLR_Limit;
	}

	public String getKYC_OTP() {
		return KYC_OTP;
	}



	public void setKYC_OTP(String kYC_OTP) {
		KYC_OTP = kYC_OTP;
	}

	public String getKYC_Limit() {
		return KYC_Limit;
	}



	public void setKYC_Limit(String kYC_Limit) {
		KYC_Limit = kYC_Limit;
	}

	public String getRDM_OTP() {
		return RDM_OTP;
	}



	public void setRDM_OTP(String rDM_OTP) {
		RDM_OTP = rDM_OTP;
	}

	public String getRDM_Limit() {
		return RDM_Limit;
	}



	public void setRDM_Limit(String rDM_Limit) {
		RDM_Limit = rDM_Limit;
	}

	public String getFDM_Limit() {
		return FDM_Limit;
	}



	public void setFDM_Limit(String fDM_Limit) {
		FDM_Limit = fDM_Limit;
	}

	public String getFDM_OTP() {
		return FDM_OTP;
	}



	public void setFDM_OTP(String fDM_OTP) {
		FDM_OTP = fDM_OTP;
	}

	public String getFDMSK_OTP() {
		return FDMSK_OTP;
	}



	public void setFDMSK_OTP(String fDMSK_OTP) {
		FDMSK_OTP = fDMSK_OTP;
	}

	public String getFDMSK_Limit() {
		return FDMSK_Limit;
	}



	public void setFDMSK_Limit(String fDMSK_Limit) {
		FDMSK_Limit = fDMSK_Limit;
	}

	public String getFDINT_OTP() {
		return FDINT_OTP;
	}



	public void setFDINT_OTP(String fDINT_OTP) {
		FDINT_OTP = fDINT_OTP;
	}

	public String getFDINT_Limit() {
		return FDINT_Limit;
	}



	public void setFDINT_Limit(String fDINT_Limit) {
		FDINT_Limit = fDINT_Limit;
	}

	public String getSDINOPERATIVE_OTP() {
		return SDINOPERATIVE_OTP;
	}



	public void setSDINOPERATIVE_OTP(String sDINOPERATIVE_OTP) {
		SDINOPERATIVE_OTP = sDINOPERATIVE_OTP;
	}

	public String getSDINOPERATIVE_Limit() {
		return SDINOPERATIVE_Limit;
	}



	public void setSDINOPERATIVE_Limit(String sDINOPERATIVE_Limit) {
		SDINOPERATIVE_Limit = sDINOPERATIVE_Limit;
	}

	public String getTarget_Id() {
		return Target_Id;
	}



	public void setTarget_Id(String target_Id) {
		Target_Id = target_Id;
	}

	/**
	 * @return the target_Name
	 */
	public String getTarget_Name() {
		return Target_Name;
	}



	/**
	 * @param target_Name the target_Name to set
	 */
	public void setTarget_Name(String target_Name) {
		Target_Name = target_Name;
	}

	/**
	 * @return the saveFlag
	 */
	public int getSaveFlag() {
		return SaveFlag;
	}



	/**
	 * @param saveFlag the saveFlag to set
	 */
	public void setSaveFlag(int saveFlag) {
		SaveFlag = saveFlag;
	}

	/**
	 * @return the updateFlag
	 */
	public int getUpdateFlag() {
		return UpdateFlag;
	}



	/**
	 * @param updateFlag the updateFlag to set
	 */
	public void setUpdateFlag(int updateFlag) {
		UpdateFlag = updateFlag;
	}

	/**
	 * @return the deleteFlag
	 */
	public int getDeleteFlag() {
		return DeleteFlag;
	}



	/**
	 * @param deleteFlag the deleteFlag to set
	 */
	public void setDeleteFlag(int deleteFlag) {
		DeleteFlag = deleteFlag;
	}

	public String getPermissionLevel() {
		return PermissionLevel;
	}



	public void setPermissionLevel(String permissionLevel) {
		PermissionLevel = permissionLevel;
	}

	public List<String> getUP300_Operation_Types() {
		return UP300_Operation_Types;
	}



	public void setUP300_Operation_Types(List<String> uP300_Operation_Types) {
		UP300_Operation_Types = uP300_Operation_Types;
	}

	public List<String> getBranch_Operation_Types() {
		return Branch_Operation_Types;
	}



	public void setBranch_Operation_Types(List<String> branch_Operation_Types) {
		Branch_Operation_Types = branch_Operation_Types;
	}

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

	public String getMobile_number() {
		return Mobile_number;
	}



	public void setMobile_number(String mobile_number) {
		Mobile_number = mobile_number;
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

	public String getSubakalyan() {
		return Subakalyan;
	}



	public void setSubakalyan(String subakalyan) {
		Subakalyan = subakalyan;
	}

	public String getMuli_branch() {
		return Muli_branch;
	}



	public void setMuli_branch(String muli_branch) {
		Muli_branch = muli_branch;
	}

	public String getTransaction_Edit() {
		return Transaction_Edit;
	}



	public void setTransaction_Edit(String transaction_Edit) {
		Transaction_Edit = transaction_Edit;
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

	public String getBranch_Type() {
		return Branch_Type;
	}



	public void setBranch_Type(String branch_Type) {
		Branch_Type = branch_Type;
	}

	public String getMessage1() {
		return message1;
	}



	public void setMessage1(String message1) {
		this.message1 = message1;
	}

	public List<String> getBranch_List() {
		return Branch_List;
	}



	public void setBranch_List(List<String> branch_List) {
		Branch_List = branch_List;
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

	public String getCurrent_Branch() {
		return Current_Branch;
	}



	public void setCurrent_Branch(String current_Branch) {
		Current_Branch = current_Branch;
	}

	public String getJoining_Date() {
		return Joining_Date;
	}



	public void setJoining_Date(String joining_Date) {
		Joining_Date = joining_Date;
	}

	public List<String> getCash_Transaction_Operation_Types() {
		return Cash_Transaction_Operation_Types;
	}



	public void setCash_Transaction_Operation_Types(
			List<String> cash_Transaction_Operation_Types) {
		Cash_Transaction_Operation_Types = cash_Transaction_Operation_Types;
	}

	public List<String> getExpenses_Transaction_Operation_Types() {
		return Expenses_Transaction_Operation_Types;
	}



	public void setExpenses_Transaction_Operation_Types(
			List<String> expenses_Transaction_Operation_Types) {
		Expenses_Transaction_Operation_Types = expenses_Transaction_Operation_Types;
	}

	public String getBranch_Verify() {
		return Branch_Verify;
	}



	public void setBranch_Verify(String branch_Verify) {
		Branch_Verify = branch_Verify;
	}

	public String getEOM_Report() {
		return EOM_Report;
	}



	public void setEOM_Report(String eOM_Report) {
		EOM_Report = eOM_Report;
	}

	public String getRecovery_Report() {
		return Recovery_Report;
	}



	public void setRecovery_Report(String recovery_Report) {
		Recovery_Report = recovery_Report;
	}

	public String getAudit_Report() {
		return Audit_Report;
	}



	public void setAudit_Report(String audit_Report) {
		Audit_Report = audit_Report;
	}

	public String getOperations_Report() {
		return Operations_Report;
	}



	public void setOperations_Report(String operations_Report) {
		Operations_Report = operations_Report;
	}

	public String getAdminLog_Report() {
		return AdminLog_Report;
	}



	public void setAdminLog_Report(String adminLog_Report) {
		AdminLog_Report = adminLog_Report;
	}

	private String SBT_OTP;
	private String SBT_Limit;

	private String FDC_OTP;
	private String FDC_Limit;

	private String LAD_OTP;
	private String LAD_Limit;
	
	
	private int ViewFlag=1;
	
	private List<String> KYC_Operation_Types=null;
	private List<String> Trans_App_Operation_Types=null;
	private List<String> Loan_App_Operation_Types=null;
	private List<String> Day_End_Operation_Types=null;
	
	private List<String> Staff_Attendance_Operation_Types=null;
	
	
	//11-04-2023
	private String CCT_OTP;
	private String CCT_Limit;
	
	private String RDC_OTP;
	private String RDC_Limit;
	
	private String JLM_OTP;
	private String JLM_Limit;
	
	private String JLR_OTP;
	private String JLR_Limit;
	
	
	private String KYC_OTP;
	private String KYC_Limit;
	
	private String RDM_OTP;
	private String RDM_Limit;
	
	private String FDM_OTP;
	private String FDM_Limit;
	
	private String FDMSK_OTP;
	private String FDMSK_Limit;
	
	private String FDINT_OTP;
	private String FDINT_Limit;
	
	private String SDINOPERATIVE_OTP;
	private String SDINOPERATIVE_Limit;
	
	
	
	//10-02-2024
			private String Target_Id;
			private String Target_Name;
			private int SaveFlag=1;
			
			private int UpdateFlag=1;
			private int DeleteFlag=1;
			
			private String PermissionLevel;
			
			
			//28-02-2024
			private List<String> UP300_Operation_Types=null;
			private List<String> Branch_Operation_Types=null;
			private List<String> Branch_List=null;
			private String Emp_Id;
			private String Emp_Name;
			private String Mobile_number;
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
			private String Attendance_Level;
				private String Attendance_Status;
			private String LockStatus;
			private String CorpTransaction;
			
			private String Branch_Type;
			private String message1;
			
			private String Super_Admin="N";
			
			
			private String Last_Name;
			
			private String Corp_Login="P";
			private String Current_Branch;
			private String Joining_Date;
			
			
			//14-05-2024
			private List<String> Cash_Transaction_Operation_Types=null;
			private List<String> Expenses_Transaction_Operation_Types=null;
			
			

			//28-10-2024
			private String Branch_Verify;
			
			//26-12-2024
			private String EOM_Report;
			
			private String Recovery_Report;
			private String Audit_Report;
			private String Operations_Report;
			private String AdminLog_Report;
			
			
			
}


