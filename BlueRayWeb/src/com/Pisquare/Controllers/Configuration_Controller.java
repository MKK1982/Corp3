  package com.Pisquare.Controllers;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Configuration_Controller {
	   @Autowired
	   private DataSource ds1;
	   @Autowired
	   private DataSource ds2;
	   
	   @Autowired
		private DataSource dbRandc;
	   
	   
	   @Autowired
	   private DataSource dsSys;
	   private JdbcTemplate template;
	   private JdbcTemplate[] jdtmp = new JdbcTemplate[]{new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate()};
	   private static String XComp_Name = "Shri Narayani (K) Nidhi Limited";
	   private static String XComp_SName = "SNKNL";
	   private static String XCIN_NO = "CIN NO:- U74999TN2017PLC120244";
	   private static String XTITLE = "Approved by Central Government of India & Accorded “NIDHI” Status (NDH4)";
	   private static String XComp_CName = "SHRI NARAYANI(KUMBAKONAM)NIDHI LIMITED";
	   private static String XADDRESS = "Regd.Office:No. 41/41A , Gandhi Park North, Kumbakonam- 612 001";
	   private static String XSUBTITLE = "Since 2017";
	   private static String XADDRESS2 = "Ph.0435-2433855 (Incorporated Under the Companies Act, 1956)";
	   private static String XComp_City = "Kumbakonam - 612001.";
	   private static String XSESSIONUSER = "Y";
	   private static String XSMSTemp = "SNNLKM";
	   public static String JL_IMAGE = "/SNKNLJLIMAGE/";
	   public static String JL_PURITY = "e:/JL_Purity/";
	   public static String DL_IMAGE = "/SNKNLDLIMAGE/";
	   public static String MEM_IMAGE = "/SNNLSIGCOPY/";
	   public static String MEM_INFO = "/resources/images/Upload_Files/";
	   public static String MEM_ID = "/image/";

	   public void Init_DB() {
	      System.out.println("--------connection Initialize begin-----");
	      if (this.jdtmp[1].getDataSource() == null) {
	         this.jdtmp[1].setDataSource(this.ds1);
	        // this.jdtmp[2].setDataSource(this.ds2);
	        // this.jdtmp[0].setDataSource(dbRandc); 
	      }

	      System.out.println("--------connection Initialize end2-----");
	   }

	   public JdbcTemplate getCon2(int Bcode) {
	      Bcode -= 200;
	      return this.jdtmp[Bcode];
	   }
	   
	   public JdbcTemplate getCon3()
		{	   
				return jdtmp[0];
		}

	   public JdbcTemplate getCon2_Old(int Bcode) {
	      System.out.println("--------------------------------" + Bcode);
	      JdbcTemplate jt;
	     
	         jt = new JdbcTemplate(this.ds1);
	      

	      return jt;
	   }

	   public String GetCompName() {
	      return XComp_Name;
	   }

	   public String GetCompSName() {
	      return XComp_SName;
	   }

	   public String GetCINNO() {
	      return XCIN_NO;
	   }

	   public String GetTitle() {
	      return XTITLE;
	   }

	   public String GetComp_CName() {
	      return XComp_CName;
	   }

	   public String GetCompAddress() {
	      return XADDRESS;
	   }

	   public String GetCompAddress2() {
	      return XADDRESS2;
	   }

	   public String GetCompCity() {
	      return XComp_City;
	   }

	   public String GetComp_SubTitle() {
	      return XSUBTITLE;
	   }

	   public String GetSESSIONUSER() {
	      return XSESSIONUSER;
	   }

	   public String GetSMSTemplate() {
	      return XSMSTemp;
	   }
	   
}