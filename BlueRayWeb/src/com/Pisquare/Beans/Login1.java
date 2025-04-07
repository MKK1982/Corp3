package com.Pisquare.Beans;

import javax.validation.constraints.Size;


//import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.jdbc.core.JdbcTemplate;

public class Login1 {
	
	
		private String Username="";
	
	private String Password="";
	
	
	public Login1()
	{
		super();
		this.Username="";
		this.Password="";
		
	}
	
	/*
	public Login1(String Username,String Password)
	{
		super();
		this.Username=Username;
		this.Password=Password;
		
	}
	*/
	

	
	public String getUsername()
	{
		return Username;
	}

	public void setUsername(String Username)
	{
		this.Username=Username;
		
	}

	public String getPassword()
	{
		return Password;
	}

	public void setPassword(String Password)
	{
		this.Password=Password;
		
	}

	private String Branch_Type;
	
	public String getBranch_Type()
	{
		return Branch_Type;
	}

	public void setBranch_Type(String Branch_Type)
	{
		this.Branch_Type=Branch_Type;
		
	}
	
	
	
	
	public String getOTP() {
		return OTP;
	}

	public void setOTP(String oTP) {
		OTP = oTP;
	}

	private String OTP;
	
	public String getOTP1() {
		return OTP1;
	}

	public void setOTP1(String oTP1) {
		OTP1 = oTP1;
	}

	

	public String getCsrfToken() {
		return csrfToken;
	}

	public void setCsrfToken(String csrfToken) {
		this.csrfToken = csrfToken;
	}

	

	private String OTP1;
	
	
	private String csrfToken;
	
	
	public int getFlag1() {
		return flag1;
	}

	public void setFlag1(int flag1) {
		this.flag1 = flag1;
	}

	public int getFlag2() {
		return flag2;
	}

	public void setFlag2(int flag2) {
		this.flag2 = flag2;
	}

	public String getAgentId() {
		return AgentId;
	}

	public void setAgentId(String agentId) {
		AgentId = agentId;
	}

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

	public String getEncryptedMsg() {
		return EncryptedMsg;
	}

	public void setEncryptedMsg(String encryptedMsg) {
		EncryptedMsg = encryptedMsg;
	}

	public String getRrn_No() {
		return Rrn_No;
	}

	public void setRrn_No(String rrn_No) {
		Rrn_No = rrn_No;
	}

	public String getAesToken() {
		return AesToken;
	}

	public void setAesToken(String aesToken) {
		AesToken = aesToken;
	}

	public String getParamName1() {
		return ParamName1;
	}

	public void setParamName1(String paramName1) {
		ParamName1 = paramName1;
	}

	public String getParamValue1() {
		return ParamValue1;
	}

	public void setParamValue1(String paramValue1) {
		ParamValue1 = paramValue1;
	}

	public String getAgent_Id() {
		return Agent_Id;
	}

	public void setAgent_Id(String agent_Id) {
		Agent_Id = agent_Id;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}

	public String getParamName2() {
		return ParamName2;
	}

	public void setParamName2(String paramName2) {
		ParamName2 = paramName2;
	}

	public String getParamValue2() {
		return ParamValue2;
	}

	public void setParamValue2(String paramValue2) {
		ParamValue2 = paramValue2;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	private int flag1=0;
	private int flag2=1;
	
	private String AgentId;
	private String Token;
	
	private String EncryptedMsg;
	private String Rrn_No;
	private String AesToken;
	
	private String ParamName1;
	private String ParamValue1;
	
	private String ParamName2;
	private String ParamValue2;
	
	private String Agent_Id;
	private String Amount;
	
	private String requestId;
	private String refId;
	private String msgId;
	
	
	
}
