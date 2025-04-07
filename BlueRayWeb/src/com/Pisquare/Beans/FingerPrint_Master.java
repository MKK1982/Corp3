package com.Pisquare.Beans;

import java.util.List;

public class FingerPrint_Master {

	public FingerPrint_Master() {
		// TODO Auto-generated constructor stub
	}

	public String getAnsiImage() {
		return AnsiImage;
	}

	public void setAnsiImage(String ansiImage) {
		AnsiImage = ansiImage;
	}

	public String getCustomer_Id() {
		return Customer_Id;
	}

	public void setCustomer_Id(String customer_Id) {
		Customer_Id = customer_Id;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public List<Cus> getUsernameList() {
		return UsernameList;
	}

	public void setUsernameList(List<Cus> usernameList) {
		UsernameList = usernameList;
	}

	private String AnsiImage;
	private String Customer_Id;
	private String Username;
	private List<Cus> UsernameList;
	
	
	public String getSerialNo() {
		return SerialNo;
	}

	public void setSerialNo(String serialNo) {
		SerialNo = serialNo;
	}

	public String getLocalMac() {
		return LocalMac;
	}

	public void setLocalMac(String localMac) {
		LocalMac = localMac;
	}

	public String getLocalIP() {
		return LocalIP;
	}

	public void setLocalIP(String localIP) {
		LocalIP = localIP;
	}

	public String getPublicIP() {
		return PublicIP;
	}

	public void setPublicIP(String publicIP) {
		PublicIP = publicIP;
	}

	public String getSystemID() {
		return SystemID;
	}

	public void setSystemID(String systemID) {
		SystemID = systemID;
	}

	
	public String getFingerInfo() {
		return FingerInfo;
	}

	public void setFingerInfo(String fingerInfo) {
		FingerInfo = fingerInfo;
	}

	private String SerialNo;
	private String LocalMac;
	private String LocalIP;
	private String SystemID;
	private String PublicIP;
	
	private String FingerInfo;
	
}
