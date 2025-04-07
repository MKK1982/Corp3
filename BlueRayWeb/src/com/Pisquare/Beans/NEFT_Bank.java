


package com.Pisquare.Beans;

public class NEFT_Bank {
	
	private int Bank_Code;
	private String Bank_Desc;
	
	
	public NEFT_Bank()
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

}
