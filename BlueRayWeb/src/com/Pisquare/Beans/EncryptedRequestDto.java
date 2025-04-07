package com.Pisquare.Beans;

public class EncryptedRequestDto 
{
	private String rrn;
	private String cipherText;
	private String digitalSig;
	private String timeStamp;
	
	public String getRrn() {
		return rrn;
	}
	public void setRrn(String rrn) {
		this.rrn = rrn;
	}
	public String getCipherText() {
		return cipherText;
	}
	public void setCipherText(String cipherText) {
		this.cipherText = cipherText;
	}
	public String getDigitalSig() {
		return digitalSig;
	}
	public void setDigitalSig(String digitalSig) {
		this.digitalSig = digitalSig;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "EncryptedRequestDto [rrn=" + rrn + ", cipherText=" + cipherText + ", digitalSig=" + digitalSig
				+ ", timeStamp=" + timeStamp + "]";
	}
}
