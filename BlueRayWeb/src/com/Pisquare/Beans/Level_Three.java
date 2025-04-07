


package com.Pisquare.Beans;

public class Level_Three {
	
	private int Bank_Code;
	private String Bank_Desc="";
	private String Bank_Desc2="";
	private String Bank_Desc_Attendance="";
	
	
	public Level_Three()
	{
		
	}
	
	private String csrfToken;
	public String getCsrfToken() {
		return csrfToken;
	}
	public void setCsrfToken(String csrfToken) {
		this.csrfToken = csrfToken;
	}
	
	public int getBank_Code()
	{
		return Bank_Code;
	}
	
	public void setBank_Code(int Bank_Code)
	{
		this.Bank_Code=Bank_Code;
	}
	
	
	public String getBank_Desc()
	{
		return Bank_Desc;
	}
	
	public void setBank_Desc(String Bank_Desc)
	{
		this.Bank_Desc=Bank_Desc;
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
		
		public String getEscroMail() {
			return EscroMail;
		}
		public void setEscroMail(String escroMail) {
			EscroMail = escroMail;
		}

		public String getBank_Desc2() {
			return Bank_Desc2;
		}
		public void setBank_Desc2(String bank_Desc2) {
			Bank_Desc2 = bank_Desc2;
		}

		public String getUserName2() {
			return UserName2;
		}
		public void setUserName2(String userName2) {
			UserName2 = userName2;
		}

		public String getAuditMail() {
			return AuditMail;
		}
		public void setAuditMail(String auditMail) {
			AuditMail = auditMail;
		}

		public String getBank_Desc_Attendance() {
			return Bank_Desc_Attendance;
		}
		public void setBank_Desc_Attendance(String bank_Desc_Attendance) {
			Bank_Desc_Attendance = bank_Desc_Attendance;
		}

		public String getLevel() {
			return Level;
		}
		public void setLevel(String level) {
			Level = level;
		}

		private String EscroMail;
		
		private String UserName2;

		private String AuditMail;
		
		private String Level;

}
