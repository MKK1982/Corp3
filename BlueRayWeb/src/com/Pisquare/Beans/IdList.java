package com.Pisquare.Beans;

public class IdList {
	
	
	private int Idno;
	private String Desc;
	
	
	public IdList()
	{
		
	}
	
	private String csrfToken;
	public String getCsrfToken() {
		return csrfToken;
	}
	public void setCsrfToken(String csrfToken) {
		this.csrfToken = csrfToken;
	}
	
	public int getIdno()
	{
		return Idno;
	}
	
	public void setIdno(int Idno)
	{
		this.Idno=Idno;
	}
	
	
	public String getDesc()
	{
		return Desc;
	}
	
	public void setDesc(String Desc)
	{
		this.Desc=Desc;
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
