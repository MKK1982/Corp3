package com.Pisquare.Controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;





@Component
public class Configuration_Controller_SNNL {
	   @Autowired
	   private DataSource ds1;
	   @Autowired
	   private DataSource ds2;
	   @Autowired
	   private DataSource ds3;
	   @Autowired
	   private DataSource ds4;
	   @Autowired
	   private DataSource ds5;
	   @Autowired
	   private DataSource ds6;
	   @Autowired
	   private DataSource ds7;
	   @Autowired
	   private DataSource ds8;
	   @Autowired
	   private DataSource ds9;
	   @Autowired
	   private DataSource ds10;
	   @Autowired
	   private DataSource ds11;
	   @Autowired
	   private DataSource ds12;
	   @Autowired
	   private DataSource ds13;
	   @Autowired
	   private DataSource ds14;
	   @Autowired
	   private DataSource ds15;
	   @Autowired
	   private DataSource ds16;
	   @Autowired
	   private DataSource ds17;
	   @Autowired
	   private DataSource ds18;
	   @Autowired
	   private DataSource ds19;
	   @Autowired
	   private DataSource ds20;
	   @Autowired
	   private DataSource ds21;
	   @Autowired
	   private DataSource ds22;
	   @Autowired
	   private DataSource ds23;
	   @Autowired
	   private DataSource ds24;
	   @Autowired
	   private DataSource ds26;
	   @Autowired
	   private DataSource ds27;
	   @Autowired
	   private DataSource ds28;
	   @Autowired
	   private DataSource ds29;
	   @Autowired
	   private DataSource ds30;
	   @Autowired
	   private DataSource ds25;
	   @Autowired
	   private DataSource ds31;
	   @Autowired
	   private DataSource ds32;
	   @Autowired
	   private DataSource ds33;
	   @Autowired
	   private DataSource ds34;
	   @Autowired
	   private DataSource ds35;
	   @Autowired
	   private DataSource ds36;
	   @Autowired
	   private DataSource ds37;
	   @Autowired
	   private DataSource ds38;
	   @Autowired
	   private DataSource ds39;
	   @Autowired
	   private DataSource ds40;
	   @Autowired
	   private DataSource ds41;
	   @Autowired
	   private DataSource ds42;
	   @Autowired
	   private DataSource ds43;
	   @Autowired
	   private DataSource ds44;
	   @Autowired
	   private DataSource ds45;
	   @Autowired
	   private DataSource ds46;
	   @Autowired
	   private DataSource ds47;
	   @Autowired
	   private DataSource ds48;
	   @Autowired
	   private DataSource ds49;
	   @Autowired
	   private DataSource ds50;
	   @Autowired
	   private DataSource ds51;
	   @Autowired
	   private DataSource ds52;
	   @Autowired
	   private DataSource ds53;
	   @Autowired
	   private DataSource dsSys;
	   @Autowired
	   private DataSource ds54;
	   @Autowired
	   private DataSource ds55;
	   @Autowired
	   private DataSource ds56;
	   @Autowired
	   private DataSource ds57;
	   @Autowired
	   private DataSource ds58;
	   @Autowired
	   private DataSource ds59;
	   @Autowired
	   private DataSource ds60;
	   @Autowired
	   private DataSource ds61;
	   @Autowired
	   private DataSource ds62;
	   @Autowired
	   private DataSource ds63;
	   @Autowired
	   private DataSource ds64;
	   @Autowired
	   private DataSource ds65;
	   @Autowired
	   private DataSource ds66;
	   @Autowired
	   private DataSource ds67;
	   
	   @Autowired
		private DataSource dbRandc;
	   
	   
	   private JdbcTemplate template;
	   private JdbcTemplate[] jdtmp = new JdbcTemplate[]{new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate(), new JdbcTemplate()};
	   private static String XComp_Name = "Shri Narayani Nidhi Limited";
	   private static String XComp_SName = "SNNL";
	   private static String XCIN_NO = "CIN NO:- U74120TN2012PLN086751";
	   private static String XTITLE = "Approved by Central Government of India & Accorded “NIDHI” Status (NDH4)";
	   private static String XComp_CName = "SHRI NARAYANI NIDHI LIMITED";
	   private static String XADDRESS = "Registered Office : No.83, South Street, Thiruvarur, Tamil Nadu, India – 610001";
	   private static String XSUBTITLE = "Since 2012";
	   private static String XADDRESS2 = "Ph.04366-240855 (Incorporated Under the Companies Act, 1956)";
	   private static String XComp_City = "Tiruvarur 610001.";
	   private static String XSESSIONUSER = "Y";
	   private static String XSMSTemp = "SNIDHI";
	   public static String JL_IMAGE = "/SNNLJLIMAGE/";
	   public static String JL_PURITY = "e:/JL_Purity/";
	   public static String DL_IMAGE = "/SNNLDLIMAGE/";
	   public static String MEM_IMAGE = "/SNNLSIGCOPY/";
	   public static String MEM_INFO = "/resources/images/Upload_Files/";
	   public static String MEM_ID = "/image/";
	   public static String BANK_INFO = "/Snnl_Bank_Passbook/";

	   public void Init_DB() {
	      System.out.println("--------connection Initialize begin-----");
	      if (this.jdtmp[1].getDataSource() == null) {
	         this.jdtmp[1].setDataSource(this.ds1);
	         this.jdtmp[2].setDataSource(this.ds2);
	         this.jdtmp[3].setDataSource(this.ds3);
	         this.jdtmp[4].setDataSource(this.ds4);
	         this.jdtmp[5].setDataSource(this.ds5);
	         this.jdtmp[6].setDataSource(this.ds6);
	         this.jdtmp[7].setDataSource(this.ds7);
	         this.jdtmp[8].setDataSource(this.ds8);
	         this.jdtmp[9].setDataSource(this.ds9);
	         this.jdtmp[10].setDataSource(this.ds10);
	         this.jdtmp[11].setDataSource(this.ds11);
	         this.jdtmp[12].setDataSource(this.ds12);
	         this.jdtmp[13].setDataSource(this.ds13);
	         this.jdtmp[14].setDataSource(this.ds14);
	         this.jdtmp[15].setDataSource(this.ds15);
	         this.jdtmp[16].setDataSource(this.ds16);
	         this.jdtmp[17].setDataSource(this.ds17);
	         this.jdtmp[18].setDataSource(this.ds18);
	         this.jdtmp[19].setDataSource(this.ds19);
	         this.jdtmp[20].setDataSource(this.ds20);
	         this.jdtmp[21].setDataSource(this.ds21);
	         this.jdtmp[22].setDataSource(this.ds22);
	         this.jdtmp[23].setDataSource(this.ds23);
	         this.jdtmp[24].setDataSource(this.ds24);
	         this.jdtmp[25].setDataSource(this.ds25);
	         this.jdtmp[26].setDataSource(this.ds26);
	         this.jdtmp[27].setDataSource(this.ds27);
	         this.jdtmp[28].setDataSource(this.ds28);
	         this.jdtmp[29].setDataSource(this.ds29);
	         this.jdtmp[30].setDataSource(this.ds30);
	         this.jdtmp[31].setDataSource(this.ds31);
	         this.jdtmp[32].setDataSource(this.ds32);
	         this.jdtmp[33].setDataSource(this.ds33);
	         this.jdtmp[34].setDataSource(this.ds34);
	         this.jdtmp[35].setDataSource(this.ds35);
	         this.jdtmp[36].setDataSource(this.ds36);
	         this.jdtmp[37].setDataSource(this.ds37);
	         this.jdtmp[38].setDataSource(this.ds38);
	         this.jdtmp[39].setDataSource(this.ds39);
	         this.jdtmp[40].setDataSource(this.ds40);
	         this.jdtmp[41].setDataSource(this.ds41);
	         this.jdtmp[42].setDataSource(this.ds42);
	         this.jdtmp[43].setDataSource(this.ds43);
	         this.jdtmp[44].setDataSource(this.ds44);
	         this.jdtmp[45].setDataSource(this.ds45);
	         this.jdtmp[46].setDataSource(this.ds46);
	         this.jdtmp[47].setDataSource(this.ds47);
	         this.jdtmp[48].setDataSource(this.ds48);
	         this.jdtmp[49].setDataSource(this.ds49);
	         this.jdtmp[50].setDataSource(this.ds50);
	         this.jdtmp[51].setDataSource(this.ds51);
	         this.jdtmp[52].setDataSource(this.ds52);
	         this.jdtmp[53].setDataSource(this.ds53);
	         this.jdtmp[54].setDataSource(this.ds54);
	         this.jdtmp[55].setDataSource(this.ds55);
	         this.jdtmp[56].setDataSource(this.ds56);
	         this.jdtmp[57].setDataSource(this.ds57);
	         this.jdtmp[58].setDataSource(this.ds58);
	         this.jdtmp[59].setDataSource(this.ds59);
	         this.jdtmp[60].setDataSource(this.ds60);
	         this.jdtmp[61].setDataSource(this.ds61);
	         this.jdtmp[62].setDataSource(this.ds62);
	         this.jdtmp[63].setDataSource(this.ds63);
	         this.jdtmp[64].setDataSource(this.ds64);
	         this.jdtmp[65].setDataSource(this.ds65);
	         this.jdtmp[66].setDataSource(this.ds66);
	         this.jdtmp[67].setDataSource(this.ds67);
	         this.jdtmp[0].setDataSource(dbRandc); 
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
	      if (Bcode == 201) {
	         jt = new JdbcTemplate(this.ds1);
	      } else if (Bcode == 202) {
	         jt = new JdbcTemplate(this.ds2);
	      } else if (Bcode == 203) {
	         jt = new JdbcTemplate(this.ds3);
	      } else if (Bcode == 204) {
	         jt = new JdbcTemplate(this.ds4);
	      } else if (Bcode == 205) {
	         jt = new JdbcTemplate(this.ds5);
	      } else if (Bcode == 206) {
	         jt = new JdbcTemplate(this.ds6);
	      } else if (Bcode == 207) {
	         jt = new JdbcTemplate(this.ds7);
	      } else if (Bcode == 208) {
	         jt = new JdbcTemplate(this.ds8);
	      } else if (Bcode == 209) {
	         jt = new JdbcTemplate(this.ds9);
	      } else if (Bcode == 210) {
	         jt = new JdbcTemplate(this.ds10);
	      } else if (Bcode == 211) {
	         jt = new JdbcTemplate(this.ds11);
	      } else if (Bcode == 212) {
	         jt = new JdbcTemplate(this.ds12);
	      } else if (Bcode == 213) {
	         jt = new JdbcTemplate(this.ds13);
	      } else if (Bcode == 214) {
	         jt = new JdbcTemplate(this.ds14);
	      } else if (Bcode == 215) {
	         jt = new JdbcTemplate(this.ds15);
	      } else if (Bcode == 216) {
	         jt = new JdbcTemplate(this.ds16);
	      } else if (Bcode == 217) {
	         jt = new JdbcTemplate(this.ds17);
	      } else if (Bcode == 218) {
	         jt = new JdbcTemplate(this.ds18);
	      } else if (Bcode == 219) {
	         jt = new JdbcTemplate(this.ds19);
	      } else if (Bcode == 220) {
	         jt = new JdbcTemplate(this.ds20);
	      } else if (Bcode == 221) {
	         jt = new JdbcTemplate(this.ds21);
	      } else if (Bcode == 222) {
	         jt = new JdbcTemplate(this.ds22);
	      } else if (Bcode == 223) {
	         jt = new JdbcTemplate(this.ds23);
	      } else if (Bcode == 224) {
	         jt = new JdbcTemplate(this.ds24);
	      } else if (Bcode == 226) {
	         jt = new JdbcTemplate(this.ds26);
	      } else if (Bcode == 227) {
	         jt = new JdbcTemplate(this.ds27);
	      } else if (Bcode == 228) {
	         jt = new JdbcTemplate(this.ds28);
	      } else if (Bcode == 229) {
	         jt = new JdbcTemplate(this.ds29);
	      } else if (Bcode == 230) {
	         jt = new JdbcTemplate(this.ds30);
	      } else if (Bcode == 225) {
	         jt = new JdbcTemplate(this.ds25);
	      } else if (Bcode == 231) {
	         jt = new JdbcTemplate(this.ds31);
	      } else if (Bcode == 232) {
	         jt = new JdbcTemplate(this.ds32);
	      } else if (Bcode == 233) {
	         jt = new JdbcTemplate(this.ds33);
	      } else if (Bcode == 234) {
	         jt = new JdbcTemplate(this.ds34);
	      } else if (Bcode == 235) {
	         jt = new JdbcTemplate(this.ds35);
	      } else if (Bcode == 236) {
	         jt = new JdbcTemplate(this.ds36);
	      } else if (Bcode == 237) {
	         jt = new JdbcTemplate(this.ds37);
	      } else if (Bcode == 238) {
	         jt = new JdbcTemplate(this.ds38);
	      } else if (Bcode == 239) {
	         jt = new JdbcTemplate(this.ds39);
	      } else if (Bcode == 240) {
	         jt = new JdbcTemplate(this.ds40);
	      } else if (Bcode == 241) {
	         jt = new JdbcTemplate(this.ds41);
	      } else if (Bcode == 242) {
	         jt = new JdbcTemplate(this.ds42);
	      } else if (Bcode == 243) {
	         jt = new JdbcTemplate(this.ds43);
	      } else if (Bcode == 244) {
	         jt = new JdbcTemplate(this.ds44);
	      } else if (Bcode == 245) {
	         jt = new JdbcTemplate(this.ds45);
	      } else if (Bcode == 246) {
	         jt = new JdbcTemplate(this.ds46);
	      } else if (Bcode == 247) {
	         jt = new JdbcTemplate(this.ds47);
	      } else if (Bcode == 248) {
	         jt = new JdbcTemplate(this.ds48);
	      } else if (Bcode == 249) {
	         jt = new JdbcTemplate(this.ds49);
	      } else if (Bcode == 250) {
	         jt = new JdbcTemplate(this.ds50);
	      } else if (Bcode == 251) {
	         jt = new JdbcTemplate(this.ds51);
	      } else if (Bcode == 252) {
	         jt = new JdbcTemplate(this.ds52);
	      } else if (Bcode == 253) {
	         jt = new JdbcTemplate(this.ds53);
	      } else if (Bcode == 254) {
	         jt = new JdbcTemplate(this.ds54);
	      } else if (Bcode == 255) {
	         jt = new JdbcTemplate(this.ds55);
	      } else if (Bcode == 256) {
	         jt = new JdbcTemplate(this.ds56);
	      } else if (Bcode == 257) {
	         jt = new JdbcTemplate(this.ds57);
	      } else if (Bcode == 258) {
	         jt = new JdbcTemplate(this.ds58);
	      } else if (Bcode == 259) {
	         jt = new JdbcTemplate(this.ds59);
	      } else if (Bcode == 260) {
	         jt = new JdbcTemplate(this.ds60);
	      } else if (Bcode == 261) {
	         jt = new JdbcTemplate(this.ds61);
	      } else if (Bcode == 999) {
	         jt = new JdbcTemplate(this.dsSys);
	      } else {
	         jt = new JdbcTemplate(this.ds5);
	      }

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
	// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				// conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Bank1","sa","pisquare123");
		

}
