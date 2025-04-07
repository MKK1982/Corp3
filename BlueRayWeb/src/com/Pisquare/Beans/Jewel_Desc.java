package com.Pisquare.Beans;




public class Jewel_Desc {

	
	private int JId;
	private String JDesc;
	
	private String csrfToken;
	public String getCsrfToken() {
		return csrfToken;
	}
	public void setCsrfToken(String csrfToken) {
		this.csrfToken = csrfToken;
	}
	
	
	
	
	public Jewel_Desc()
	{
		
	}
	
	
	
	
	public int getJId()
	{
		return JId;
		
	}
	
	public void setJId(int JId)
	{
		this.JId=JId;
	}
	
	
	
	
	public String getJDesc()
	{
		return JDesc;
		
	}
	
	public void setJDesc(String JDesc)
	{
		this.JDesc=JDesc;
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