// 
// Decompiled by Procyon v0.5.36
// 

package com.Pisquare.Controllers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.*;

import com.Pisquare.Beans.Login1;
import com.Pisquare.Beans.Response;
import com.Pisquare.Beans.Response.State;
import com.Pisquare.Dao.UserDetailsDao;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mindgate.bbps.biller.dto.BillFetchRequestBean;
import com.mindgate.bbps.biller.dto.BillFetchResponseBean;
import com.mindgate.bbps.biller.dto.BouMasterDto;
import com.mindgate.bbps.biller.dto.EncryptedRequestDto;
import com.mindgate.bbps.biller.dto.EncryptedResponseDto;
import com.mindgate.bbps.biller.util.BbpsSecurityUtil;
import com.mindgate.bbps.biller.util.BbpsValidator;
//import com.mindgate.bbps.biller.util.JsonConverterUtility;
import com.mindgate.bbps.biller.util.KeyStoreUtil;
//import com.Pisquare.Beans.SimpleBranch;
import com.mindgate.bbps.biller.dto.TokenResponseBean;

@SuppressWarnings("unused")
@Controller
@Scope("session")
@SessionAttributes({ "user", "LoginDate", "Branch", "Current_Date", "realPath", "BranchString", "Current", "BranchName", "Level", "UserId", "CreatedTime", "Msg_Count" })
public class CusController<TokenResponseBean>

{
  //@Autowired 
  UserDetailsDao dao10;
	
	 // Database connection URL
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=blueray_new"; // Update accordingly
   //jdbc:sqlserver://DESKTOP-28K1PMR\SQLEXPRESS;databaseName=blueray;encrypt=false;trustServerCertificate=true;loginTimeout=30;
    
    private static final String USER = "";
    private static final String PASSWORD = "";

	
	public static BbpsSecurityUtil securityUtils = new BbpsSecurityUtil();
    
    
    private static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private KeySpec ks;
    private SecretKeyFactory skf;
    private Cipher cipher;
    byte[] arrayBytes;
    private String myEncryptionKey;
    private String myEncryptionScheme;
    SecretKey key;
    
    public CusController() throws Exception {
        this.myEncryptionKey = "ThisIsSpartaThisIsSparta";
        this.myEncryptionScheme = "DESede";
        this.arrayBytes = this.myEncryptionKey.getBytes("UTF8");
        this.ks = new DESedeKeySpec(this.arrayBytes);
        this.skf = SecretKeyFactory.getInstance(this.myEncryptionScheme);
        this.cipher = Cipher.getInstance(this.myEncryptionScheme);
        this.key = this.skf.generateSecret(this.ks);
    }
    
 
  
    
   
    
    @RequestMapping(value = { "/Token" }, method = { RequestMethod.GET })
    public String viewFirstPage(final Map<String, Object> model, final ModelMap mp, HttpSession session, final HttpServletRequest request) throws ParseException, IOException {
       
       
        
        //con.Init_DB();
        /*
        final String user = (String)session.getAttribute("user");
        if (user != null) {
            mp.put("e", "User Already Login ,Try After Some time");
            return "Session2";
        }*/
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        final LocalDateTime now = LocalDateTime.now();
        System.out.println("start------------------------------------------------------" + dtf.format(now));
        final DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        final LocalDateTime now2 = LocalDateTime.now();
        System.out.println("end-----------------------------------------------------------------------------" + dtf.format(now2));
        try {
        	
        	 final Login1 login = new Login1();
            model.clear();
            model.put("loginEntity", login);
           
        }
        catch (Exception ex) {
            System.out.println("Error----" + ex.getCause());
            System.out.println("Error Line Number----" + ex.getStackTrace()[0].getLineNumber());
            mp.put("errMsg", ("Exception :" + ex.toString()));
            mp.put("errMsg2", ("Line :" + ex.getStackTrace()[0].getLineNumber() + " ,Casuse:" + ex.getCause()));
            mp.put("url", request.getRequestURL());
            return "SessionNull";
        }
        final Date d1 = new Date();
        System.out.println("Date " + d1);
        return "login";
    }
    
   
   
    
    @RequestMapping(value = { "/LoginValidate" }, method = { RequestMethod.GET })
    public String LoginValidate_GET(final ModelMap mp, final HttpServletRequest request, HttpSession session, final HttpServletResponse response, final Map<String, Object> model) throws Exception {
    	
    		return "redirect:/error";
    	}
    
   /* @RequestMapping(value = { "/LoginValidate" },params="Send", method = { RequestMethod.POST })
    public String doLogin(@Valid @ModelAttribute("loginEntity") final Login1 loginEntity, final BindingResult result, final ModelMap mp, @RequestParam final String Username, HttpSession session, final HttpServletRequest request, final Map<String, Object> model, final RedirectAttributes attributes) throws SQLException, ParseException, IOException {
       
    	if(!loginEntity.getUsername().equalsIgnoreCase("pisquare") && !loginEntity.getPassword().equalsIgnoreCase("123456"))
            return "encrypt";
    	else
    	{
    		 final Login1 login = new Login1();
            
             model.put("encryptEntity", login);
    		mp.put("errMsg",loginEntity.getUsername()+ " We are in Next Page" );
    		return "encrypt";
    	}
    		
        
    }*/
    
	 //@RequestMapping(value = "/Incentive_ReportDetails", params = "All_Branches_Consolidated_Loan", method = RequestMethod.POST)
		

    
   BbpsSecurityUtil securityUtils1 = new BbpsSecurityUtil();
    
    @RequestMapping(value = { "/LoginValidate" },params="Send", method = { RequestMethod.POST })
    public String doLogin(@Valid @ModelAttribute("loginEntity") final Login1 loginEntity, final BindingResult result, final ModelMap mp, HttpSession session, final HttpServletRequest request, final Map<String, Object> model, final RedirectAttributes attributes) throws SQLException, ParseException, IOException {
    	{
    		String id="SB42";
    		String agentInstid="SB42";
    		String token="6ffbeb77133c15ca241565135e103a78";
    		
    		
		EncryptedRequestDto requestDTO =new EncryptedRequestDto();
		BillFetchRequestBean decryptedRequestDto = null;

		String decryptedResponseMsg = null;
		String encryptedResponseMsg = null;

		String encryptedRequestMsg = null;
		String decryptedRequestMsg = null;
		String encryptedAesKey = null;
		String decryptedAesKey = null;

		String timeStamp = null;
		String digitalSignature = null;
		boolean isVerified = false;
		boolean isValid = false;
		String getBillerPrivate = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgboeBDYUm/hLhirbB0Jb05XJEf/ji5SUC5LuqpQhnKhX3RJ0qxdOIzhG5lv4+FN+Yi/1DvCcDN8I2AsNzLABuuoeva/qYWhrs3808jPl2PiFIPv7EeRkfKzswN40Ov/d/05jdNQ1hg6vdylhD0sig5BJtmp3jimPGhSpQgowqvdPXSYwAuj2juea8pSJSPkU1BfPWM7WJWzeoUrNptaAV3sgZ5sa3yEuYPBTJr7/uP9mCMciu9GAxOzN0+awet1RFHfPXtWgIAi9RxgrOW6jSDYI9NqleC41jQyJR/E2uvUIJ/OlqL3L6bH0/PxkOuzy+biUv0qGB97DqXRh3EUU3AgMBAAECggEAd40GEwhFMiJhZYsd114eL86PkTYf/MyvAPH8WxRyJ5Z4GfQafpY+pRKSqM85FIAvgxjGmWQrWj2BzwfOKBQhGmKL3BBGBKQYrm20HiwbdZ6k5JZ0+WoYa16m066Bwf0RbUL8BdOT7hfVyggQMDJx6Vsr1FtEzxwAcB4pwycVVn8/ZFk+maoIptb7oOrVf/A1OaiwFHrUplQFwL9bOjrnaz6sPmGStpSU6NHVkUVlH/J8V/ag2iYt9QUQiLg6/jroMQegixZAi5g3fQKQ/2oOKy+6JKfxcN982X7Zy36gULhs/VJ+SeD/+YjqfIaNJtqDpeunlSGLGG8W+4f6nUp9IQKBgQDrTc4VG7x1AS6gc9wG7xcjSUWHK0tQow8rl64Y4KAb3iyKismNtgg8qkRERhJ+ZZulr07IUZE/M+doqNmoShtpcuGguUgcKGgfaCBo4351TgVh2fslzwzhrood7O+fScgJmmT+XN3et0luwkvpD60Kol5xD0dEOabH/f1RJNpvcQKBgQCuit+QhdN5d353UAWyPEZnrQmmfDU6yP280ELU0/AmC6nghRD7dz8ZXo+LmRMuekEeNX4l0HU1LNhjmcW4El6112ZfVtt7znI7yqq7m7SYHhewJT2xrDq6m9yhGa8j2TGZNrSb+cEYv8kJcBNZMMQytHVTg6h4vA01S4KUOK97JwKBgEIRIXjZxctQXqgcf73Oqb91ljkCle35KoxB1VcU0r+gXP81QqwwXRWzdOF6jzzACLi3hTZHeLG3QBUpu5s92357DBDVlQKa8clHsjnhDiOfmXFFA/g0r1g6antGiG1ACRNxL0QgDQe4jLy1fxzcEuj2d+/kq0zjpwlmLhb3cwFxAoGAJzS4jR0SaIln1eMatHOHmQgsT8I8rqyxGjVpnabRnaonCXC6ZNHfUZKFCeVjgqAheminolTVzxD4tj63Q+aUcaIls6qt+Hxh+n5GpYePJFA2H/HtjrhSJNKX13QOfC3wTysTnKmYLzf9L2qGXhVvLLiOVikPsbcD/IGunh6xhCcCgYAvtXpHRZN2xy66d1VrMeqhfddj+lDmp0ZkbbeyZHLovk2G4jOjck0CMHffMbYoi5Up2Opi6Gn2G2roO6EvLmPt8zneEDc9NfwdbQLVc7sHk4WaaZIWHl/9kyKLjO6PrjyN+IJ/W8GhDo1aXG+3bARmnqVhHQnARx6dw610JFy34g==";
		String BouPublic = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn9/lE9HbqaS/6GqkysCZgyUkeLkxOQKiosmGt5N3JA3qit4sP0yZh9HEtZk85S9xDVLUJkCEa2SIDEIWExpEVe3CI5TN8chXh/qyH0TqoHbkfrf2xkolYZFGYM/BcGj6I3bOVKFSTkwuxVmncgLrk0q7a6e5mgAwYxy9iMB0aOM56j37oEdOzOLl8giAhxvu2AorsPxfewfwnvnFXDvSQHtcQJhJDBZOl7lW9pl0fdqD2ct9/3lip//klMnj79IOncsFJ8JHwC1dpNdJk2PxWS1nzKgHsDlIKfnWPdqI+C2DYGU1Z71mXLXynBSogQiThfUWrSHgUlRB4WPsdurfawIDAQAB";
		BouMasterDto bouMasterDTO = new BouMasterDto();
		
		//24-01-2025 Step=2 Get ciphertext
		String plainMsg="{\"agentInstitutionId\":\"SB42\",\"token\":\"6ffbeb77133c15ca241565135e103a78\"}";
				PublicKey pkey=BbpsSecurityUtil.getPublicKey(BouPublic);
		String ciphertext=securityUtils.encryptRsaMessage( plainMsg,pkey);
				System.out.println("ciphertext="+ciphertext);
		//24-01-2025 Step=3 Get Timestamp
					ZonedDateTime now2 = ZonedDateTime.now();
					DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
					String formattedTimestamp = now2.format(formatter2);
					System.out.println("Formatted Timestamp: " + formattedTimestamp);
		//24-01-2025 Step=4 Generate DigitalSignature		
					requestDTO.setCipherText(ciphertext);
					requestDTO.setTimeStamp(formattedTimestamp);
					
					//----------------------------------------------------------------------------
					DateTimeFormatter rrnform = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
					String rrnTimestamp = now2.format(rrnform);
					String RRN="SB51"+rrnTimestamp+"ee3b04f1043344f87";
					
					//--------------------------------------------------------------------------
					requestDTO.setRrn(RRN);
					
					PrivateKey privatekey=BbpsSecurityUtil.getPrivateKey(getBillerPrivate);
					 digitalSignature = securityUtils.generateDigitalSignature(requestDTO.getRrn() + requestDTO.getTimeStamp() + requestDTO.getCipherText(), privatekey);
						System.out.println("digitalSignature: " + digitalSignature);

						//24-01-2025 Step=5 Generate EncryptedRequest			

		//encryptedRequestMsg = "{" + "\"rrn\":\"SB5120210212093848ee3b04f1043344f87\"," + "\"cipherText\":\"3412C8F35979A2D92F92B7EA8A6183ECB1EDA5C896276562D80AA83F7C8C033BCCE43E2FAD9EAB5A0334CE8454392DB0DCA969469F3F5917B86335D986EE8275B87241DB1AF4A6499373DD6EA5A711EB634A7CAE352D4D3DA89D9F535A3971E12EB65058D2A001B039CE03FDEABB56C481488CC452FB117EF39D011339FAA09BD992EEA4D456FBCB877D9CA86E2D60613A48F61A99E8C3C88F6FE117ED1B0ADC83B2E406AB4075A882DD207880DDEFBBABD96A2EAEBD57BBD72BC29C1E530C11ECDB4AB1982E419840863D1A3078AF96746D1400D4A3D5AA68431E88676FB52F8B47B8F14C0000B659BA23ED7636D9FC57212922069324B991517A1912EDA7F4FA8641279A94B013F98F3DA950EC001A1E65F8A604849AFB663630BBFAA55C3885F1815EEB6B0AB94D25A00510B76A436F6E076333CD9802F83D9C0F6EE473A468C4633AB1A1F1D5C86E398197D374305CB14251CE0691E1AFBDFBE5783D20FA86D256050DE205DD90AC5CE3\"," + "\"digitalSig\":\"A7dIKgs8l8fndu7p/YNOigM5Gj32IgXiIDoYtZb0mfKW8yfWXPwYQDmMy7LYE1Vrk3c2r1eywWr7Wu1LJkyJ4RCp8H2nSjUpEpHYsaU3qV4vQyhSKWLjhEFOWcn9zqnwLaZAAd8zZCK7uorQFky02t28SOaVfcGU/3UhHxZVGXgOzJGSUVZlO6xFYnq91/GCbE9Bo9uNVENYWKtMXCPHb/8C4tYl9UMpVFurXYmUJq9U5ZJos0+JykjLUt3ly/LvCKegE6gnRuGCuvvnLi22HsDNWj3unW+ytbU9inA0gBkPaELH4fK9f3cs7U3b+A6KmX1VdJeSJVm9JAdkvGdu5A==\"," + "\"timeStamp\":\"2021-02-12T21:38:48+05:30\"" + "}";
		encryptedRequestMsg = "{" + "\"rrn\":\""+requestDTO.getRrn()+"\"," + "\"cipherText\":\""+requestDTO.getCipherText()+"\"," + "\"digitalSig\":\""+digitalSignature+"\"," + "\"ts\":\""+requestDTO.getTimeStamp()+"\"" + "}";

		System.out.println("EncryptedRequest: " + encryptedRequestMsg);
		  StringBuilder response = new StringBuilder();
		  try {
      	    // URL of the API endpoint
      	    URL url = new URL("https://uatsbiunipay.sbi/bbps-cou-switch/getAccessToken/SB42");
      	    //URL url=new URL("https://jaisaissnidhilimited.com/api/values/PostBillDesk");
      	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      	    
      	    // Setting the request method to POST
      	    conn.setRequestMethod("POST");
      	    conn.setRequestProperty("Content-Type", "application/json; utf-8");
      	    conn.setRequestProperty("Accept", "application/json");
      	    conn.setDoOutput(true);

      	    // JSON payload
      	    String jsonInputString = encryptedRequestMsg;
      	    //String jsonInputString="{\"amt\":\"qg8lfycy0Ps=\",\"accNum\":\"QDvcz8lILVw1I6YUpkHHAw==\",\"hname\":\"v+yG16PsTsA=\",\"bal\":\"osN4bh2XAuVefhxwIn3QfQ==\",\"atype\":\"Qzwj51FVXG8=\"}";
      	    // Sending the JSON payload
      	    try (OutputStream os = conn.getOutputStream()) {
      	        byte[] input = jsonInputString.getBytes("utf-8");
      	        os.write(input, 0, input.length);
      	    }
      	// Read the response
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
              
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Response: " + response.toString());
                loginEntity.setOTP(response.toString());
            }
      	    // Reading the response
      	    int responseCode = conn.getResponseCode();
      	    System.out.println("Response Code: " + conn.getResponseMessage());
      	    
      	    // Handle the response (omitted for brevity)

      	} catch (Exception e) {
      	    
      		
      		loginEntity.setOTP(""+e.fillInStackTrace());
      		e.printStackTrace();
      	    
      	 
      	}


	/*	String encryptedResponseMsg="{"+
    "rrn": "SB5120210212093848ee3b04f1043344f87",
    "cipherText": "JoqY4hog8DKO1riZm8tj3lMIqHGphSM7KKaaneiHSiA/1iYYngsrnsO6e1EQBrPaZVViuSxrrtyIsD3As9IJsrQp9Hx3u1AZWFP43ZtQfjY/tCjit8GsKtp5os4AIGXB5Z/7oRqHoLDHirOVdJ0ys15NWUv3M8IbRArw3T/YJH7ge64Orn2nL081bRoe314GL796EmxKII/5V2gxcQ5LeHwNKnByikHBl4ke4qLD836CIyLn6ZzDtzLJXGv12WIV9kkoj9JJvxDEpBxI7zAY83xq01LRF3ySgUT3botzBa+WGF71cnHNMoW8g0HU+qMNI0EhnmFlXm+VSxw9hpWN5A==",
    "digitalSig": "Log4GDn079J+IwGFhDxWJcqR5REdGItyz3SHdFxX/xoqJil2FJXaDrIDvz4WBoxRZiWOJtxZ4I/gcHLjF+SxAymmllKeE4al63f9u3HVL/Gxj0AOv8XaO+GHDWWo+U74A/mf0jhbD6n55JmvTkiYcGFjyZTc4uICH09O8jITmHIygWuMuc4OKwDe/+HMDc2DgxD0Om6x4Q6zWOdnuAwbsIxnbIEZS0ZtuTueHBXBuERjvwI6fxFzdFxWIFSTLavinnEwV9XTN5mEjHOjWCq3IZOiftVMjwLzeZSPtgfrGi43m54RBVD205yuAGywq/szPnxkJOUnVUkmGbWKWEXTaQ==",
    "ts": "2025-01-24T12:54:20+05:30"
}";"
		+ ";"
		+ "
		
		"rrn": "SB5120210212093848ee3b04f1043344f87",
    "cipherText": "mcCGKaQP7is01bbcFR4dHof0KsLxDSM9Ql4GtgrhgGmOlbRieyz8Fct6UqbGJiS8ULjZ1v9VJ7CLz24U0660n3yvXGM+xPz6fJ7TfwZIS1HBJBO7XAh6lumG7EnaJqEYRrQVOgo6LkmdFsJjzy1EH3nifbtDS1sIYH0ogl7lP3cAiAfYAGVM3yRsS1X34cZG4gxzr4SL/KYt5ujd5O8lcmgyGk0CHBIh3vTIVNki18tqH+01W4eQIWnhpkzMgyaiDE9l3akd9D9viZtaoxFj5y+t2cNWfSpKZeSpoDRqYkle7IIV28z7g46+I0atVGhikNwm3McTsPI71zrRtRx6Qg==",
    "digitalSig": "RAzH9bD5xYgCg80RbrEhof4qM9TmnrNoXWWr83ELn3Ro6jsBa/Z7XUrJj7ikzWv28pdBBn0Z/KM81aOTcNis4rL8otA/P/SLXPd1f/UDsHRh6z7xHccqEAdlrIMj/k79FqLgHLTu5V7H/QH1JySlMRwB4hpK3sl9FQmUwG1rkcqqc+NqVZkfEdn5ACqvuAzHWxRFrqYLp9yjdLD/6+zhvDTl5p8ZS+yGV3sry+ixXBICAiVVAjHyxFTd9KNsJ5/M0oiAg2jbK3KLSH20D8v1J7CWt3LKs0nDvCl0Dd4EGoBijFce9SsMExcbkjoqUH2e5J+9N/0+bnjeUMYRVjNoWA==",
    "ts": "2025-02-03T17:10:40+05:30"
}

"rrn": "SB5120210212093848ee3b04f1043344f87",
    "cipherText": "ej0k9kIdbRerSg2syjqtTPptI0jrnAIc89oUe71/0ckgAfu7to7JbSI+F0P+57sgv9XElyZG10wKeXK0slAYHzcmoI/Vs+xtcqxvXD4PopXrni4aclNX+qEAw6iiBpJC9hW6A40sZKTW8g29oqSrG5czU6b+vszD0tbuvQ0cxraNtaHe9n1E1thqgqru0RopqK2hcUumKtnlSv42rAq+9kqEMn99UfHqdqmekUfbi1CMdMBVdrtUyfErYgr7YuULOidPHGPfl7w9X0JU7PpRGWXNGlhCntppiMf50EcP8oGNdrVg8MSZG2BhOOTpR3ZCX2FzrPXTOy7nh/zj8+6aSg==",
    "digitalSig": "DS17e8VohmAEgwnND2aCqS1C8AL7Z8+heGUTqTVIDM2ZT6Xptu2q/qR6Vf5F8ZO4CVLjP3wGqzvw4rxGPEx0XU185fs0lRHDE5HM7hlcXhU9WjLErvmZs+XwHp/lbLbdmqEBio16T8vAMdMI7BCuF2hThPryV1Jrk254j/S7xrSIlD5xltQDcuDVTFS/gLCTEDlyHKX23RGzrzfdVl6vFjFuDKKZW7PEWxjA2hnwMoUlIyfcWwG9XIP9eXdlS8+OV8k62+q3XZV/Ox+QfHTYmdfkWkVwhgPzZoP4wpjKHz0zlz4mZFGkRaWstkwfeQ1OZC055XN5+vWyca4zW7j6cw==",
    "ts": "2025-02-03T17:40:25+05:30"
}
*/		//24-01-2025 Step=5.9 call Api Generate  TokenResponse	  
		//24-01-2025 Step=6 Parse TokenResponse	
	/*	String TokenResponseMsg = "{" + "\"rrn\":\"SB5120210212093848ee3b04f1043344f87\"," + "\"cipherText\":\"mcCGKaQP7is01bbcFR4dHof0KsLxDSM9Ql4GtgrhgGmOlbRieyz8Fct6UqbGJiS8ULjZ1v9VJ7CLz24U0660n3yvXGM+xPz6fJ7TfwZIS1HBJBO7XAh6lumG7EnaJqEYRrQVOgo6LkmdFsJjzy1EH3nifbtDS1sIYH0ogl7lP3cAiAfYAGVM3yRsS1X34cZG4gxzr4SL/KYt5ujd5O8lcmgyGk0CHBIh3vTIVNki18tqH+01W4eQIWnhpkzMgyaiDE9l3akd9D9viZtaoxFj5y+t2cNWfSpKZeSpoDRqYkle7IIV28z7g46+I0atVGhikNwm3McTsPI71zrRtRx6Qg==\"," + "\"digitalSig\":\"RAzH9bD5xYgCg80RbrEhof4qM9TmnrNoXWWr83ELn3Ro6jsBa/Z7XUrJj7ikzWv28pdBBn0Z/KM81aOTcNis4rL8otA/P/SLXPd1f/UDsHRh6z7xHccqEAdlrIMj/k79FqLgHLTu5V7H/QH1JySlMRwB4hpK3sl9FQmUwG1rkcqqc+NqVZkfEdn5ACqvuAzHWxRFrqYLp9yjdLD/6+zhvDTl5p8ZS+yGV3sry+ixXBICAiVVAjHyxFTd9KNsJ5/M0oiAg2jbK3KLSH20D8v1J7CWt3LKs0nDvCl0Dd4EGoBijFce9SsMExcbkjoqUH2e5J+9N/0+bnjeUMYRVjNoWA==\"," + "\"timeStamp\":\"2025-02-03T17:10:40+05:30\"" + "}";
EncryptedRequestDto tokenRespenseDTO =new EncryptedRequestDto();
tokenRespenseDTO = JsonConverterUtilityP.convertStringToJsonObject(TokenResponseMsg, EncryptedRequestDto.class);
String signatureReqStr1 = tokenRespenseDTO.getRrn()+tokenRespenseDTO.getTimeStamp()+tokenRespenseDTO.getCipherText();
System.out.println("signatureReqStr1="+signatureReqStr1 );
//24-01-2025 Step=7 Verify TokenResponse with digital signature
isVerified = securityUtils.verifyDigitalSignature(signatureReqStr1, tokenRespenseDTO.getDigitalSig(), pkey); //give BOU public key here
System.out.println("isVerified="+isVerified );
if (!isVerified)
{
	EncryptedResponseDto responseDTO = new EncryptedResponseDto();
	responseDTO.setCipherText("Invalid Digital Signature");
	encryptedResponseMsg = JsonConverterUtilityP.convertJsonObjectToString(tokenRespenseDTO);
	return "/"; //return failure response here
}
//24-01-2025 Step=8 Get AES Key from Response
try {
	decryptedAesKey = securityUtils.decryptMessage( tokenRespenseDTO.getCipherText(),privatekey);
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}

System.out.println("decryptedAesKey="+decryptedAesKey );
//TokenResponseBean tokenRespenseBean;
//tokenRespenseBean = JsonConverterUtilityP.convertStringToJsonObject(encryptedResponseMsg,TokenResponseBean.class);
//decryptedAesKey={"reason":{"responseCode":"000","responseReason":"Successful"},"accessToken":"face12d4a752773010ecabbc006d6b38","expiryTime":"2025-01-24T13:04:20+05:30"}
TokenResponseBean tokenRespenseBean = (TokenResponseBean) JsonConverterUtilityP.convertStringToJsonObject(encryptedResponseMsg, com.mindgate.bbps.biller.dto.TokenResponseBean.class);
//bouMasterDTO.decryptedAesKey = objTokenResponseBean.accessToken;
bouMasterDTO.setDecryptedAesKey("bab90ab70b9ebfac8e966b040623b0e4");



		encryptedAesKey = "gUe9VDQprP6C9ZKhDBty2kWNjs73D0xrFGC16DF3J18xGyoipRr2WS9sM52r0vaCbJm0/JxnYsJ51NdcxKNh16wP24IIW5XANLi4HfAr8P18UNlYPXOHYxSpntFSaRwkWEZYcKJj6OFIknyqMJKYwxTxxHkLp9Ci9D2QCb5ulh13y75eo8IbQfSsAaCh6zI8czhZPZtT+fCzoD+uNnGKe2FPQ4LtB07ax/P/R+c+9XbVZsB+OGIxjWwp23dLmL368hw/RG53lBu1Ut1A/vphii6gjJJTN7LtmsUPRymUOK7eB4860DXfQT9FXePzp/+qu3R9tkvv9XInf87/SzBdvg==";

		
		bouMasterDTO.setRequestExpiry(1800);//180 seconds
		bouMasterDTO.setEncryptedRequestMsg(encryptedRequestMsg);
		bouMasterDTO.setEncryptedAesKey(encryptedAesKey);
		bouMasterDTO.setBillerId("SB5140000NAT02");
		System.out.println("id2="+id);
		requestDTO = JsonConverterUtilityP.convertStringToJsonObject(bouMasterDTO.getEncryptedRequestMsg(), EncryptedRequestDto.class);
		//JsonConverterUtilityP
		bouMasterDTO.setEncryptedRequestDto(requestDTO);
		System.out.println("id3="+id);
		//String directory = "E:\\BBPS\\resources\\";
		//String keyStore = "SBI_BBPS.jks";
		//String keyStorePass = "abcd@123";
		//String keyStoreAlias = "test";
	
		//KeyPair keypair = KeyStoreUtil.getBillerKeyPair(directory, keyStore, keyStorePass, keyStoreAlias);

		//String getBillerPublic = "";
        
		
       
		//bouMasterDTO.setBillerPublicKey(java.util.Base64.getEncoder().encodeToString(keypair.getPublic().getEncoded()));
		//bouMasterDTO.setBillerPrivateKey(java.util.Base64.getEncoder().encodeToString(keypair.getPrivate().getEncoded()));
		//bouMasterDTO.setBillerPublicKey(getBillerPublic);
		bouMasterDTO.setBillerPrivateKey(getBillerPrivate);

		//bouMasterDTO.setBouPublicKey("MII.BIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAna20pk+66pkXVak8pvsMqZIwnmVNVCR4iWbRKl+QlRnA2HpN8w1RrPLIj48LcBQyjnxdP7d6Des/SIZsz3luChRi0NiECnDTohySRsWxfJ7ByzrE/tQ0C7QoS7eNaOp0Y9pVLz6oc92l6W0vzniPWEbnABHM/9tZ/1XQr2OcA6NN+jIQZPynLKlZp17YWV7QxCoDl/otpzXl2yDk57RN4NK5wgY6PKBYvMh4QAcPrRtzhRPaf8IqqaZiGdnCjT+zTLLFgszFeM2SZzxkERP7uPIrwP0qJ89diyT8Og4QnCP0GQmg0/UkMabZpYzKirdc1PstIeRT+Z0E2SrXvsincwIDAQAB");
		bouMasterDTO.setBouPublicKey(BouPublic);

		String signatureReqStr = requestDTO.getRrn() + requestDTO.getTimeStamp() + requestDTO.getCipherText();
		System.out.println("requestDTO.getRrn() ="+requestDTO.getRrn() );
		System.out.println("requestDTO.getTimeStamp()="+requestDTO.getTimeStamp() );
		
		isVerified = securityUtils.verifyDigitalSignature(signatureReqStr, requestDTO.getDigitalSig(), bouMasterDTO.getBouPublicKey()); //give BOU public key here
		System.out.println("isVerified="+isVerified );
		if (!isVerified)
		{
			EncryptedResponseDto responseDTO = new EncryptedResponseDto();
			responseDTO.setCipherText("Invalid Digital Signature");
			encryptedResponseMsg = JsonConverterUtilityP.convertJsonObjectToString(responseDTO);
			return "redirect:/"; //return failure response here
		}

		try
		{
			decryptedAesKey = securityUtils.decryptMessage(bouMasterDTO.getEncryptedAesKey(), bouMasterDTO.getBillerPrivateKey());
		}
		catch (Exception e)
		{
		}
		bouMasterDTO.setDecryptedAesKey(decryptedAesKey);

		timeStamp = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+05:30'")).format(new Date());
		isValid = BbpsValidator.timeStampRuleValidator(requestDTO.getTimeStamp(), timeStamp, bouMasterDTO.getRequestExpiry());
		
		System.out.println("isValid ="+isValid);
		
		if (!isValid)
		{
			EncryptedResponseDto responseDTO = new EncryptedResponseDto();
			responseDTO.setCipherText("Timestamp cannot be older than " + bouMasterDTO.getRequestExpiry() + " minutes");
			decryptedResponseMsg = JsonConverterUtilityP.convertJsonObjectToString(responseDTO);
			return "redirect:/"; //return failure response here
		}


		decryptedRequestMsg = securityUtils.decryptAesGcm(requestDTO.getCipherText(), bouMasterDTO.getDecryptedAesKey());
		bouMasterDTO.setDecryptedRequestMsg(decryptedRequestMsg);
		decryptedRequestDto = JsonConverterUtilityP.convertStringToJsonObject(bouMasterDTO.getDecryptedRequestMsg(), BillFetchRequestBean.class);
		bouMasterDTO.setFetchRequestDto(decryptedRequestDto);

		BillFetchResponseBean billFetchResponseBean = new BillFetchResponseBean();
		bouMasterDTO.setFetchResponseDto(billFetchResponseBean);
		decryptedResponseMsg = JsonConverterUtilityP.convertJsonObjectToString(bouMasterDTO.getFetchResponseDto());
		bouMasterDTO.setDecryptedResponseMsg(decryptedResponseMsg);
		encryptedResponseMsg = securityUtils.encryptAesGcm(bouMasterDTO.getDecryptedResponseMsg(), bouMasterDTO.getDecryptedAesKey());
		bouMasterDTO.setEncryptedResponseMsg(encryptedResponseMsg);

		EncryptedResponseDto encryptedResponseDto = new EncryptedResponseDto();
		encryptedResponseDto.setRrn(bouMasterDTO.getEncryptedRequestDto().getRrn());
		encryptedResponseDto.setCipherText(bouMasterDTO.getEncryptedResponseMsg());
		encryptedResponseDto.setTimeStamp((new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+05:30'")).format(new Date()));
		bouMasterDTO.setEncryptedResponseDto(encryptedResponseDto);

		digitalSignature = securityUtils.generateDigitalSignature(bouMasterDTO.getEncryptedResponseDto().getRrn() + bouMasterDTO.getEncryptedResponseDto().getTimeStamp() + bouMasterDTO.getEncryptedResponseDto().getCipherText(), bouMasterDTO.getBillerPrivateKey());

		bouMasterDTO.getEncryptedResponseDto().setDigitalSig(digitalSignature);
		encryptedResponseMsg = JsonConverterUtilityP.convertJsonObjectToString(bouMasterDTO.getEncryptedResponseDto());
		bouMasterDTO.setEncryptedResponseMsg(encryptedResponseMsg); //final response to be sent to BOU (bank)
*/		 final Login1 login = new Login1();
        // model.clear();
         model.put("loginEntity", login);
         mp.put("encryptedRequestMsg", encryptedRequestMsg);
         login.setBranch_Type(encryptedRequestMsg);
         System.out.println("response.toString()="+response.toString());
         mp.put("OTP", response.toString());
         mp.put("Rrn_No", RRN);
         login.setRrn_No(RRN);
        // mp.put("OTP1", response.toString());
         login.setOTP(response.toString());
         //login.setOTP1(response.toString());
         
       
    
    	return "login";
    	}

}
    
    
    
    @RequestMapping(value = { "/LoginValidate" },params="GetToken", method = { RequestMethod.POST })
    public String GetToken(@Valid @ModelAttribute("loginEntity") final Login1 loginEntity, final BindingResult result, final ModelMap mp,  HttpSession session, final HttpServletRequest request, final Map<String, Object> model, final RedirectAttributes attributes) throws SQLException, ParseException, IOException {
    	{
    		String id="SB42";
    		String agentInstid="SB42";
    		String token="6ffbeb77133c15ca241565135e103a78";
    		
    	//	String user= loginEntity.getUsername();
    	//	String pass=loginEntity.getPassword();

		EncryptedRequestDto requestDTO =new EncryptedRequestDto();
		BillFetchRequestBean decryptedRequestDto = null;

		String decryptedResponseMsg = null;
		String encryptedResponseMsg = null;

		String encryptedRequestMsg = null;
		String decryptedRequestMsg = null;
		String encryptedAesKey = null;
		String decryptedAesKey = null;

		String timeStamp = null;
		String digitalSignature = null;
		boolean isVerified = false;
		boolean isValid = false;
		String getBillerPrivate = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgboeBDYUm/hLhirbB0Jb05XJEf/ji5SUC5LuqpQhnKhX3RJ0qxdOIzhG5lv4+FN+Yi/1DvCcDN8I2AsNzLABuuoeva/qYWhrs3808jPl2PiFIPv7EeRkfKzswN40Ov/d/05jdNQ1hg6vdylhD0sig5BJtmp3jimPGhSpQgowqvdPXSYwAuj2juea8pSJSPkU1BfPWM7WJWzeoUrNptaAV3sgZ5sa3yEuYPBTJr7/uP9mCMciu9GAxOzN0+awet1RFHfPXtWgIAi9RxgrOW6jSDYI9NqleC41jQyJR/E2uvUIJ/OlqL3L6bH0/PxkOuzy+biUv0qGB97DqXRh3EUU3AgMBAAECggEAd40GEwhFMiJhZYsd114eL86PkTYf/MyvAPH8WxRyJ5Z4GfQafpY+pRKSqM85FIAvgxjGmWQrWj2BzwfOKBQhGmKL3BBGBKQYrm20HiwbdZ6k5JZ0+WoYa16m066Bwf0RbUL8BdOT7hfVyggQMDJx6Vsr1FtEzxwAcB4pwycVVn8/ZFk+maoIptb7oOrVf/A1OaiwFHrUplQFwL9bOjrnaz6sPmGStpSU6NHVkUVlH/J8V/ag2iYt9QUQiLg6/jroMQegixZAi5g3fQKQ/2oOKy+6JKfxcN982X7Zy36gULhs/VJ+SeD/+YjqfIaNJtqDpeunlSGLGG8W+4f6nUp9IQKBgQDrTc4VG7x1AS6gc9wG7xcjSUWHK0tQow8rl64Y4KAb3iyKismNtgg8qkRERhJ+ZZulr07IUZE/M+doqNmoShtpcuGguUgcKGgfaCBo4351TgVh2fslzwzhrood7O+fScgJmmT+XN3et0luwkvpD60Kol5xD0dEOabH/f1RJNpvcQKBgQCuit+QhdN5d353UAWyPEZnrQmmfDU6yP280ELU0/AmC6nghRD7dz8ZXo+LmRMuekEeNX4l0HU1LNhjmcW4El6112ZfVtt7znI7yqq7m7SYHhewJT2xrDq6m9yhGa8j2TGZNrSb+cEYv8kJcBNZMMQytHVTg6h4vA01S4KUOK97JwKBgEIRIXjZxctQXqgcf73Oqb91ljkCle35KoxB1VcU0r+gXP81QqwwXRWzdOF6jzzACLi3hTZHeLG3QBUpu5s92357DBDVlQKa8clHsjnhDiOfmXFFA/g0r1g6antGiG1ACRNxL0QgDQe4jLy1fxzcEuj2d+/kq0zjpwlmLhb3cwFxAoGAJzS4jR0SaIln1eMatHOHmQgsT8I8rqyxGjVpnabRnaonCXC6ZNHfUZKFCeVjgqAheminolTVzxD4tj63Q+aUcaIls6qt+Hxh+n5GpYePJFA2H/HtjrhSJNKX13QOfC3wTysTnKmYLzf9L2qGXhVvLLiOVikPsbcD/IGunh6xhCcCgYAvtXpHRZN2xy66d1VrMeqhfddj+lDmp0ZkbbeyZHLovk2G4jOjck0CMHffMbYoi5Up2Opi6Gn2G2roO6EvLmPt8zneEDc9NfwdbQLVc7sHk4WaaZIWHl/9kyKLjO6PrjyN+IJ/W8GhDo1aXG+3bARmnqVhHQnARx6dw610JFy34g==";
		String BouPublic = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn9/lE9HbqaS/6GqkysCZgyUkeLkxOQKiosmGt5N3JA3qit4sP0yZh9HEtZk85S9xDVLUJkCEa2SIDEIWExpEVe3CI5TN8chXh/qyH0TqoHbkfrf2xkolYZFGYM/BcGj6I3bOVKFSTkwuxVmncgLrk0q7a6e5mgAwYxy9iMB0aOM56j37oEdOzOLl8giAhxvu2AorsPxfewfwnvnFXDvSQHtcQJhJDBZOl7lW9pl0fdqD2ct9/3lip//klMnj79IOncsFJ8JHwC1dpNdJk2PxWS1nzKgHsDlIKfnWPdqI+C2DYGU1Z71mXLXynBSogQiThfUWrSHgUlRB4WPsdurfawIDAQAB";
		BouMasterDto bouMasterDTO = new BouMasterDto();
		PrivateKey privatekey=BbpsSecurityUtil.getPrivateKey(getBillerPrivate);
		
		//24-01-2025 Step=2 Get ciphertext
		String plainMsg="{\"agentInstitutionId\":\"SB42\",\"token\":\"6ffbeb77133c15ca241565135e103a78\"}";
				PublicKey pkey=BbpsSecurityUtil.getPublicKey(BouPublic);
		String ciphertext=securityUtils.encryptRsaMessage( plainMsg,pkey);
				System.out.println("ciphertext="+ciphertext);
		//24-01-2025 Step=3 Get Timestamp
					ZonedDateTime now2 = ZonedDateTime.now();
					//DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
					//String formattedTimestamp = now2.format(formatter2);
					DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'+05:30'");
					String formattedTimestamp = now2.format(formatter2);
					
					System.out.println("Formatted Timestamp: " + formattedTimestamp);
		//24-01-2025 Step=4 Generate DigitalSignature		
			/*		requestDTO.setCipherText(ciphertext);
					requestDTO.setTimeStamp(formattedTimestamp);
					requestDTO.setRrn("SB5120210212093848ee3b04f1043344f87");
					 digitalSignature = securityUtils.generateDigitalSignature(requestDTO.getRrn() + requestDTO.getTimeStamp() + requestDTO.getCipherText(), privatekey);
						System.out.println("digitalSignature: " + digitalSignature);

						//24-01-2025 Step=5 Generate EncryptedRequest			

		//encryptedRequestMsg = "{" + "\"rrn\":\"SB5120210212093848ee3b04f1043344f87\"," + "\"cipherText\":\"3412C8F35979A2D92F92B7EA8A6183ECB1EDA5C896276562D80AA83F7C8C033BCCE43E2FAD9EAB5A0334CE8454392DB0DCA969469F3F5917B86335D986EE8275B87241DB1AF4A6499373DD6EA5A711EB634A7CAE352D4D3DA89D9F535A3971E12EB65058D2A001B039CE03FDEABB56C481488CC452FB117EF39D011339FAA09BD992EEA4D456FBCB877D9CA86E2D60613A48F61A99E8C3C88F6FE117ED1B0ADC83B2E406AB4075A882DD207880DDEFBBABD96A2EAEBD57BBD72BC29C1E530C11ECDB4AB1982E419840863D1A3078AF96746D1400D4A3D5AA68431E88676FB52F8B47B8F14C0000B659BA23ED7636D9FC57212922069324B991517A1912EDA7F4FA8641279A94B013F98F3DA950EC001A1E65F8A604849AFB663630BBFAA55C3885F1815EEB6B0AB94D25A00510B76A436F6E076333CD9802F83D9C0F6EE473A468C4633AB1A1F1D5C86E398197D374305CB14251CE0691E1AFBDFBE5783D20FA86D256050DE205DD90AC5CE3\"," + "\"digitalSig\":\"A7dIKgs8l8fndu7p/YNOigM5Gj32IgXiIDoYtZb0mfKW8yfWXPwYQDmMy7LYE1Vrk3c2r1eywWr7Wu1LJkyJ4RCp8H2nSjUpEpHYsaU3qV4vQyhSKWLjhEFOWcn9zqnwLaZAAd8zZCK7uorQFky02t28SOaVfcGU/3UhHxZVGXgOzJGSUVZlO6xFYnq91/GCbE9Bo9uNVENYWKtMXCPHb/8C4tYl9UMpVFurXYmUJq9U5ZJos0+JykjLUt3ly/LvCKegE6gnRuGCuvvnLi22HsDNWj3unW+ytbU9inA0gBkPaELH4fK9f3cs7U3b+A6KmX1VdJeSJVm9JAdkvGdu5A==\"," + "\"timeStamp\":\"2021-02-12T21:38:48+05:30\"" + "}";
		encryptedRequestMsg = "{" + "\"rrn\":\""+requestDTO.getRrn()+"\"," + "\"cipherText\":\""+requestDTO.getCipherText()+"\"," + "\"digitalSig\":\""+digitalSignature+"\"," + "\"ts\":\""+requestDTO.getTimeStamp()+"\"" + "}";

		System.out.println("EncryptedRequest: " + encryptedRequestMsg);
*/
	/*	String encryptedResponseMsg="{"+
    "rrn": "SB5120210212093848ee3b04f1043344f87",
    "cipherText": "JoqY4hog8DKO1riZm8tj3lMIqHGphSM7KKaaneiHSiA/1iYYngsrnsO6e1EQBrPaZVViuSxrrtyIsD3As9IJsrQp9Hx3u1AZWFP43ZtQfjY/tCjit8GsKtp5os4AIGXB5Z/7oRqHoLDHirOVdJ0ys15NWUv3M8IbRArw3T/YJH7ge64Orn2nL081bRoe314GL796EmxKII/5V2gxcQ5LeHwNKnByikHBl4ke4qLD836CIyLn6ZzDtzLJXGv12WIV9kkoj9JJvxDEpBxI7zAY83xq01LRF3ySgUT3botzBa+WGF71cnHNMoW8g0HU+qMNI0EhnmFlXm+VSxw9hpWN5A==",
    "digitalSig": "Log4GDn079J+IwGFhDxWJcqR5REdGItyz3SHdFxX/xoqJil2FJXaDrIDvz4WBoxRZiWOJtxZ4I/gcHLjF+SxAymmllKeE4al63f9u3HVL/Gxj0AOv8XaO+GHDWWo+U74A/mf0jhbD6n55JmvTkiYcGFjyZTc4uICH09O8jITmHIygWuMuc4OKwDe/+HMDc2DgxD0Om6x4Q6zWOdnuAwbsIxnbIEZS0ZtuTueHBXBuERjvwI6fxFzdFxWIFSTLavinnEwV9XTN5mEjHOjWCq3IZOiftVMjwLzeZSPtgfrGi43m54RBVD205yuAGywq/szPnxkJOUnVUkmGbWKWEXTaQ==",
    "ts": "2025-01-24T12:54:20+05:30"
}";"
		+ ";"
		+ "
		
		"rrn": "SB5120210212093848ee3b04f1043344f87",
    "cipherText": "mcCGKaQP7is01bbcFR4dHof0KsLxDSM9Ql4GtgrhgGmOlbRieyz8Fct6UqbGJiS8ULjZ1v9VJ7CLz24U0660n3yvXGM+xPz6fJ7TfwZIS1HBJBO7XAh6lumG7EnaJqEYRrQVOgo6LkmdFsJjzy1EH3nifbtDS1sIYH0ogl7lP3cAiAfYAGVM3yRsS1X34cZG4gxzr4SL/KYt5ujd5O8lcmgyGk0CHBIh3vTIVNki18tqH+01W4eQIWnhpkzMgyaiDE9l3akd9D9viZtaoxFj5y+t2cNWfSpKZeSpoDRqYkle7IIV28z7g46+I0atVGhikNwm3McTsPI71zrRtRx6Qg==",
    "digitalSig": "RAzH9bD5xYgCg80RbrEhof4qM9TmnrNoXWWr83ELn3Ro6jsBa/Z7XUrJj7ikzWv28pdBBn0Z/KM81aOTcNis4rL8otA/P/SLXPd1f/UDsHRh6z7xHccqEAdlrIMj/k79FqLgHLTu5V7H/QH1JySlMRwB4hpK3sl9FQmUwG1rkcqqc+NqVZkfEdn5ACqvuAzHWxRFrqYLp9yjdLD/6+zhvDTl5p8ZS+yGV3sry+ixXBICAiVVAjHyxFTd9KNsJ5/M0oiAg2jbK3KLSH20D8v1J7CWt3LKs0nDvCl0Dd4EGoBijFce9SsMExcbkjoqUH2e5J+9N/0+bnjeUMYRVjNoWA==",
    "ts": "2025-02-03T17:10:40+05:30"
}

"rrn": "SB5120210212093848ee3b04f1043344f87",
    "cipherText": "ej0k9kIdbRerSg2syjqtTPptI0jrnAIc89oUe71/0ckgAfu7to7JbSI+F0P+57sgv9XElyZG10wKeXK0slAYHzcmoI/Vs+xtcqxvXD4PopXrni4aclNX+qEAw6iiBpJC9hW6A40sZKTW8g29oqSrG5czU6b+vszD0tbuvQ0cxraNtaHe9n1E1thqgqru0RopqK2hcUumKtnlSv42rAq+9kqEMn99UfHqdqmekUfbi1CMdMBVdrtUyfErYgr7YuULOidPHGPfl7w9X0JU7PpRGWXNGlhCntppiMf50EcP8oGNdrVg8MSZG2BhOOTpR3ZCX2FzrPXTOy7nh/zj8+6aSg==",
    "digitalSig": "DS17e8VohmAEgwnND2aCqS1C8AL7Z8+heGUTqTVIDM2ZT6Xptu2q/qR6Vf5F8ZO4CVLjP3wGqzvw4rxGPEx0XU185fs0lRHDE5HM7hlcXhU9WjLErvmZs+XwHp/lbLbdmqEBio16T8vAMdMI7BCuF2hThPryV1Jrk254j/S7xrSIlD5xltQDcuDVTFS/gLCTEDlyHKX23RGzrzfdVl6vFjFuDKKZW7PEWxjA2hnwMoUlIyfcWwG9XIP9eXdlS8+OV8k62+q3XZV/Ox+QfHTYmdfkWkVwhgPzZoP4wpjKHz0zlz4mZFGkRaWstkwfeQ1OZC055XN5+vWyca4zW7j6cw==",
    "ts": "2025-02-03T17:40:25+05:30"
}
*/		//24-01-2025 Step=5.9 call Api Generate  TokenResponse	  
		//24-01-2025 Step=6 Parse TokenResponse	
		//String TokenResponseMsg = "{" + "\"rrn\":\"SB5120210212093848ee3b04f1043344f87\"," + "\"cipherText\":\"mcCGKaQP7is01bbcFR4dHof0KsLxDSM9Ql4GtgrhgGmOlbRieyz8Fct6UqbGJiS8ULjZ1v9VJ7CLz24U0660n3yvXGM+xPz6fJ7TfwZIS1HBJBO7XAh6lumG7EnaJqEYRrQVOgo6LkmdFsJjzy1EH3nifbtDS1sIYH0ogl7lP3cAiAfYAGVM3yRsS1X34cZG4gxzr4SL/KYt5ujd5O8lcmgyGk0CHBIh3vTIVNki18tqH+01W4eQIWnhpkzMgyaiDE9l3akd9D9viZtaoxFj5y+t2cNWfSpKZeSpoDRqYkle7IIV28z7g46+I0atVGhikNwm3McTsPI71zrRtRx6Qg==\"," + "\"digitalSig\":\"RAzH9bD5xYgCg80RbrEhof4qM9TmnrNoXWWr83ELn3Ro6jsBa/Z7XUrJj7ikzWv28pdBBn0Z/KM81aOTcNis4rL8otA/P/SLXPd1f/UDsHRh6z7xHccqEAdlrIMj/k79FqLgHLTu5V7H/QH1JySlMRwB4hpK3sl9FQmUwG1rkcqqc+NqVZkfEdn5ACqvuAzHWxRFrqYLp9yjdLD/6+zhvDTl5p8ZS+yGV3sry+ixXBICAiVVAjHyxFTd9KNsJ5/M0oiAg2jbK3KLSH20D8v1J7CWt3LKs0nDvCl0Dd4EGoBijFce9SsMExcbkjoqUH2e5J+9N/0+bnjeUMYRVjNoWA==\"," + "\"timeStamp\":\"2025-02-03T17:10:40+05:30\"" + "}";
		//String TokenResponseMsg=loginEntity.getBranch_Type();
		String TokenResponseMsg=loginEntity.getOTP().replace("\"ts\"", "\"timeStamp\"");
		System.out.println("TokenResponseMsg="+TokenResponseMsg );

		EncryptedRequestDto tokenRespenseDTO =new EncryptedRequestDto();
tokenRespenseDTO = JsonConverterUtilityP.convertStringToJsonObject(TokenResponseMsg, EncryptedRequestDto.class);
String signatureReqStr1 = tokenRespenseDTO.getRrn()+tokenRespenseDTO.getTimeStamp()+tokenRespenseDTO.getCipherText();
System.out.println("signatureReqStr1="+signatureReqStr1 );

//24-01-2025 Step=7 Verify TokenResponse with digital signature
isVerified = securityUtils.verifyDigitalSignature(signatureReqStr1, tokenRespenseDTO.getDigitalSig(), pkey); //give BOU public key here
System.out.println("isVerified="+isVerified );
/*if (!isVerified)
{
	EncryptedResponseDto responseDTO = new EncryptedResponseDto();
	responseDTO.setCipherText("Invalid Digital Signature");
	encryptedResponseMsg = JsonConverterUtilityP.convertJsonObjectToString(tokenRespenseDTO);
	return "/"; //return failure response here
}*/
//24-01-2025 Step=8 Get AES Key from Response
try {
	decryptedAesKey = securityUtils.decryptMessage( tokenRespenseDTO.getCipherText(),privatekey);
	
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
String accessToken = null;
try {
    // Create an ObjectMapper
    ObjectMapper objectMapper = new ObjectMapper();
    
    // Convert JSON string into JsonNode
    JsonNode jsonNode = objectMapper.readTree(decryptedAesKey);
    
    // Get values
    String responseCode = jsonNode.path("reason").path("responseCode").asText();
    String responseReason = jsonNode.path("reason").path("responseReason").asText();
    accessToken = jsonNode.path("accessToken").asText();
    String expiryTime = jsonNode.path("expiryTime").asText();

    // Output values
    System.out.println("Response Code: " + responseCode);
    System.out.println("Response Reason: " + responseReason);
    System.out.println("Access Token: " + accessToken);
    System.out.println("Expiry Time: " + expiryTime);
} catch (Exception e) {
    e.printStackTrace();
}

mp.put("signatureReqStr1", decryptedAesKey );
//final Login1 login = new Login1();
model.put("loginEntity", loginEntity);
loginEntity.setOTP(decryptedAesKey );
loginEntity.setOTP1(accessToken);
loginEntity.setBranch_Type(encryptedRequestMsg);

loginEntity.setAesToken(accessToken);
mp.put("AesToken", accessToken);
mp.put("Rrn_No", loginEntity.getRrn_No());


//final Login1 login = new Login1();
//model.clear();
//model.put("loginEntity", login);
//mp.put("encryptedRequestMsg", encryptedRequestMsg);
//login.setBranch_Type(encryptedRequestMsg);
//

return "login";


//TokenResponseBean tokenRespenseBean;
//tokenRespenseBean = JsonConverterUtilityP.convertStringToJsonObject(encryptedResponseMsg,TokenResponseBean.class);
//decryptedAesKey={"reason":{"responseCode":"000","responseReason":"Successful"},"accessToken":"face12d4a752773010ecabbc006d6b38","expiryTime":"2025-01-24T13:04:20+05:30"}
//TokenResponseBean tokenRespenseBean = (TokenResponseBean) JsonConverterUtilityP.convertStringToJsonObject(encryptedResponseMsg, com.mindgate.bbps.biller.dto.TokenResponseBean.class);
////bouMasterDTO.decryptedAesKey = objTokenResponseBean.accessToken;
//bouMasterDTO.setDecryptedAesKey("bab90ab70b9ebfac8e966b040623b0e4");
//
//
//
//		encryptedAesKey = "gUe9VDQprP6C9ZKhDBty2kWNjs73D0xrFGC16DF3J18xGyoipRr2WS9sM52r0vaCbJm0/JxnYsJ51NdcxKNh16wP24IIW5XANLi4HfAr8P18UNlYPXOHYxSpntFSaRwkWEZYcKJj6OFIknyqMJKYwxTxxHkLp9Ci9D2QCb5ulh13y75eo8IbQfSsAaCh6zI8czhZPZtT+fCzoD+uNnGKe2FPQ4LtB07ax/P/R+c+9XbVZsB+OGIxjWwp23dLmL368hw/RG53lBu1Ut1A/vphii6gjJJTN7LtmsUPRymUOK7eB4860DXfQT9FXePzp/+qu3R9tkvv9XInf87/SzBdvg==";
//
//		
//		bouMasterDTO.setRequestExpiry(1800);//180 seconds
//		bouMasterDTO.setEncryptedRequestMsg(encryptedRequestMsg);
//		bouMasterDTO.setEncryptedAesKey(encryptedAesKey);
//		bouMasterDTO.setBillerId("SB5140000NAT02");
//		System.out.println("id2="+id);
//		requestDTO = JsonConverterUtilityP.convertStringToJsonObject(bouMasterDTO.getEncryptedRequestMsg(), EncryptedRequestDto.class);
//		//JsonConverterUtilityP
//		bouMasterDTO.setEncryptedRequestDto(requestDTO);
//		System.out.println("id3="+id);
//		//String directory = "E:\\BBPS\\resources\\";
//		//String keyStore = "SBI_BBPS.jks";
//		//String keyStorePass = "abcd@123";
//		//String keyStoreAlias = "test";
//	
//		//KeyPair keypair = KeyStoreUtil.getBillerKeyPair(directory, keyStore, keyStorePass, keyStoreAlias);
//
//		//String getBillerPublic = "";
//        
//		
//       
//		//bouMasterDTO.setBillerPublicKey(java.util.Base64.getEncoder().encodeToString(keypair.getPublic().getEncoded()));
//		//bouMasterDTO.setBillerPrivateKey(java.util.Base64.getEncoder().encodeToString(keypair.getPrivate().getEncoded()));
//		//bouMasterDTO.setBillerPublicKey(getBillerPublic);
//		bouMasterDTO.setBillerPrivateKey(getBillerPrivate);
//
//		//bouMasterDTO.setBouPublicKey("MII.BIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAna20pk+66pkXVak8pvsMqZIwnmVNVCR4iWbRKl+QlRnA2HpN8w1RrPLIj48LcBQyjnxdP7d6Des/SIZsz3luChRi0NiECnDTohySRsWxfJ7ByzrE/tQ0C7QoS7eNaOp0Y9pVLz6oc92l6W0vzniPWEbnABHM/9tZ/1XQr2OcA6NN+jIQZPynLKlZp17YWV7QxCoDl/otpzXl2yDk57RN4NK5wgY6PKBYvMh4QAcPrRtzhRPaf8IqqaZiGdnCjT+zTLLFgszFeM2SZzxkERP7uPIrwP0qJ89diyT8Og4QnCP0GQmg0/UkMabZpYzKirdc1PstIeRT+Z0E2SrXvsincwIDAQAB");
//		bouMasterDTO.setBouPublicKey(BouPublic);
//
//		String signatureReqStr = requestDTO.getRrn() + requestDTO.getTimeStamp() + requestDTO.getCipherText();
//		System.out.println("requestDTO.getRrn() ="+requestDTO.getRrn() );
//		System.out.println("requestDTO.getTimeStamp()="+requestDTO.getTimeStamp() );
//		
//		isVerified = securityUtils.verifyDigitalSignature(signatureReqStr, requestDTO.getDigitalSig(), bouMasterDTO.getBouPublicKey()); //give BOU public key here
//		System.out.println("isVerified="+isVerified );
//		/*if (!isVerified)
//		{
//			EncryptedResponseDto responseDTO = new EncryptedResponseDto();
//			responseDTO.setCipherText("Invalid Digital Signature");
//			encryptedResponseMsg = JsonConverterUtilityP.convertJsonObjectToString(responseDTO);
//			return "redirect:/"; //return failure response here
//		}*/
//
//		try
//		{
//			decryptedAesKey = securityUtils.decryptMessage(bouMasterDTO.getEncryptedAesKey(), bouMasterDTO.getBillerPrivateKey());
//		}
//		catch (Exception e)
//		{
//		}
//		bouMasterDTO.setDecryptedAesKey(decryptedAesKey);
//
//		timeStamp = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+05:30'")).format(new Date());
//		isValid = BbpsValidator.timeStampRuleValidator(requestDTO.getTimeStamp(), timeStamp, bouMasterDTO.getRequestExpiry());
//		
//		System.out.println("isValid ="+isValid);
//		/*
//		if (!isValid)
//		{
//			EncryptedResponseDto responseDTO = new EncryptedResponseDto();
//			responseDTO.setCipherText("Timestamp cannot be older than " + bouMasterDTO.getRequestExpiry() + " minutes");
//			decryptedResponseMsg = JsonConverterUtilityP.convertJsonObjectToString(responseDTO);
//			return "redirect:/"; //return failure response here
//		}*/
//
//
//		decryptedRequestMsg = securityUtils.decryptAesGcm(requestDTO.getCipherText(), bouMasterDTO.getDecryptedAesKey());
//		bouMasterDTO.setDecryptedRequestMsg(decryptedRequestMsg);
//		decryptedRequestDto = JsonConverterUtilityP.convertStringToJsonObject(bouMasterDTO.getDecryptedRequestMsg(), BillFetchRequestBean.class);
//		bouMasterDTO.setFetchRequestDto(decryptedRequestDto);
//
//		BillFetchResponseBean billFetchResponseBean = new BillFetchResponseBean();
//		bouMasterDTO.setFetchResponseDto(billFetchResponseBean);
//		decryptedResponseMsg = JsonConverterUtilityP.convertJsonObjectToString(bouMasterDTO.getFetchResponseDto());
//		bouMasterDTO.setDecryptedResponseMsg(decryptedResponseMsg);
//		encryptedResponseMsg = securityUtils.encryptAesGcm(bouMasterDTO.getDecryptedResponseMsg(), bouMasterDTO.getDecryptedAesKey());
//		bouMasterDTO.setEncryptedResponseMsg(encryptedResponseMsg);
//
//		EncryptedResponseDto encryptedResponseDto = new EncryptedResponseDto();
//		encryptedResponseDto.setRrn(bouMasterDTO.getEncryptedRequestDto().getRrn());
//		encryptedResponseDto.setCipherText(bouMasterDTO.getEncryptedResponseMsg());
//		encryptedResponseDto.setTimeStamp((new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+05:30'")).format(new Date()));
//		bouMasterDTO.setEncryptedResponseDto(encryptedResponseDto);
//
//		digitalSignature = securityUtils.generateDigitalSignature(bouMasterDTO.getEncryptedResponseDto().getRrn() + bouMasterDTO.getEncryptedResponseDto().getTimeStamp() + bouMasterDTO.getEncryptedResponseDto().getCipherText(), bouMasterDTO.getBillerPrivateKey());
//
//		bouMasterDTO.getEncryptedResponseDto().setDigitalSig(digitalSignature);
//		encryptedResponseMsg = JsonConverterUtilityP.convertJsonObjectToString(bouMasterDTO.getEncryptedResponseDto());
//		bouMasterDTO.setEncryptedResponseMsg(encryptedResponseMsg); //final response to be sent to BOU (bank)
//		 //final Login1 login = new Login1();
//         model.clear();
//         model.put("loginEntity", login);
//         mp.put("encryptedRequestMsg", encryptedRequestMsg);
//         login.setBranch_Type(encryptedRequestMsg);
//    
//    	return "login";
    	}
    	
    	
    	
    	
    	
    	

}

    @RequestMapping(value = { "/LoginValidate" },params="CategoryList", method = { RequestMethod.POST })
    public String CategoryList(@Valid @ModelAttribute("loginEntity") final Login1 loginEntity, final BindingResult result, final ModelMap mp,  HttpSession session, final HttpServletRequest request, final Map<String, Object> model, final RedirectAttributes attributes) throws SQLException, ParseException, IOException {
    	{
    		String uniqueID = UUID.randomUUID().toString();

    		String id="SB42";
    		String agentInstid="SB42";
    		String token="6ffbeb77133c15ca241565135e103a78";
    		//String aesToken=loginEntity.getOTP1();
    		
    		String RRN=loginEntity.getRrn_No();
    		String aesToken=loginEntity.getAesToken();
    		
		EncryptedRequestDto requestDTO =new EncryptedRequestDto();
		BillFetchRequestBean decryptedRequestDto = null;

		String decryptedResponseMsg = null;
		String encryptedResponseMsg = null;

		String encryptedRequestMsg = null;
		String decryptedRequestMsg = null;
		String encryptedAesKey = null;
		String decryptedAesKey = null;

		String timeStamp = null;
		String digitalSignature = null;
		boolean isVerified = false;
		boolean isValid = false;
		String getBillerPrivate = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgboeBDYUm/hLhirbB0Jb05XJEf/ji5SUC5LuqpQhnKhX3RJ0qxdOIzhG5lv4+FN+Yi/1DvCcDN8I2AsNzLABuuoeva/qYWhrs3808jPl2PiFIPv7EeRkfKzswN40Ov/d/05jdNQ1hg6vdylhD0sig5BJtmp3jimPGhSpQgowqvdPXSYwAuj2juea8pSJSPkU1BfPWM7WJWzeoUrNptaAV3sgZ5sa3yEuYPBTJr7/uP9mCMciu9GAxOzN0+awet1RFHfPXtWgIAi9RxgrOW6jSDYI9NqleC41jQyJR/E2uvUIJ/OlqL3L6bH0/PxkOuzy+biUv0qGB97DqXRh3EUU3AgMBAAECggEAd40GEwhFMiJhZYsd114eL86PkTYf/MyvAPH8WxRyJ5Z4GfQafpY+pRKSqM85FIAvgxjGmWQrWj2BzwfOKBQhGmKL3BBGBKQYrm20HiwbdZ6k5JZ0+WoYa16m066Bwf0RbUL8BdOT7hfVyggQMDJx6Vsr1FtEzxwAcB4pwycVVn8/ZFk+maoIptb7oOrVf/A1OaiwFHrUplQFwL9bOjrnaz6sPmGStpSU6NHVkUVlH/J8V/ag2iYt9QUQiLg6/jroMQegixZAi5g3fQKQ/2oOKy+6JKfxcN982X7Zy36gULhs/VJ+SeD/+YjqfIaNJtqDpeunlSGLGG8W+4f6nUp9IQKBgQDrTc4VG7x1AS6gc9wG7xcjSUWHK0tQow8rl64Y4KAb3iyKismNtgg8qkRERhJ+ZZulr07IUZE/M+doqNmoShtpcuGguUgcKGgfaCBo4351TgVh2fslzwzhrood7O+fScgJmmT+XN3et0luwkvpD60Kol5xD0dEOabH/f1RJNpvcQKBgQCuit+QhdN5d353UAWyPEZnrQmmfDU6yP280ELU0/AmC6nghRD7dz8ZXo+LmRMuekEeNX4l0HU1LNhjmcW4El6112ZfVtt7znI7yqq7m7SYHhewJT2xrDq6m9yhGa8j2TGZNrSb+cEYv8kJcBNZMMQytHVTg6h4vA01S4KUOK97JwKBgEIRIXjZxctQXqgcf73Oqb91ljkCle35KoxB1VcU0r+gXP81QqwwXRWzdOF6jzzACLi3hTZHeLG3QBUpu5s92357DBDVlQKa8clHsjnhDiOfmXFFA/g0r1g6antGiG1ACRNxL0QgDQe4jLy1fxzcEuj2d+/kq0zjpwlmLhb3cwFxAoGAJzS4jR0SaIln1eMatHOHmQgsT8I8rqyxGjVpnabRnaonCXC6ZNHfUZKFCeVjgqAheminolTVzxD4tj63Q+aUcaIls6qt+Hxh+n5GpYePJFA2H/HtjrhSJNKX13QOfC3wTysTnKmYLzf9L2qGXhVvLLiOVikPsbcD/IGunh6xhCcCgYAvtXpHRZN2xy66d1VrMeqhfddj+lDmp0ZkbbeyZHLovk2G4jOjck0CMHffMbYoi5Up2Opi6Gn2G2roO6EvLmPt8zneEDc9NfwdbQLVc7sHk4WaaZIWHl/9kyKLjO6PrjyN+IJ/W8GhDo1aXG+3bARmnqVhHQnARx6dw610JFy34g==";
		String BouPublic = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn9/lE9HbqaS/6GqkysCZgyUkeLkxOQKiosmGt5N3JA3qit4sP0yZh9HEtZk85S9xDVLUJkCEa2SIDEIWExpEVe3CI5TN8chXh/qyH0TqoHbkfrf2xkolYZFGYM/BcGj6I3bOVKFSTkwuxVmncgLrk0q7a6e5mgAwYxy9iMB0aOM56j37oEdOzOLl8giAhxvu2AorsPxfewfwnvnFXDvSQHtcQJhJDBZOl7lW9pl0fdqD2ct9/3lip//klMnj79IOncsFJ8JHwC1dpNdJk2PxWS1nzKgHsDlIKfnWPdqI+C2DYGU1Z71mXLXynBSogQiThfUWrSHgUlRB4WPsdurfawIDAQAB";
		BouMasterDto bouMasterDTO = new BouMasterDto();
		
		//24-01-2025 Step=2 Get ciphertext
		String plainMsg="{\"agentInstitutionId\":\"SB42\",\"token\":\"6ffbeb77133c15ca241565135e103a78\"}";
				PublicKey pkey=BbpsSecurityUtil.getPublicKey(BouPublic);
				//PublicKey aeskey=BbpsSecurityUtil.getPublicKey(aesToken);
		
				String NBCIID="OU01OU02INT522274495200721ahbcj2123";
				//----------------------------------------------------------------------------
				ZonedDateTime now2 = ZonedDateTime.now();
				DateTimeFormatter rrnform = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
				String rrnTimestamp = now2.format(rrnform);
				 NBCIID="OU01OU02INT"+rrnTimestamp+"1ahbcj2123";
				
				//--------------------------------------------------------------------------
			
		//24-01-2025 Step=3 Get Timestamp
					//DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
					//"yyyy-MM-dd'T'HH:mm:ss'+05:30'"
					DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'+05:30'");
					String formattedTimestamp = now2.format(formatter2);
					System.out.println("Formatted Timestamp: " + formattedTimestamp);
					String requestId="{\"head\":{\"requestId\":\""+NBCIID+"\",\"ts\":\""+formattedTimestamp+"\"},\"search\":{\"status\":\"Active\"}}";
					String ciphertext=securityUtils.encryptAesGcm(requestId, aesToken);
					//String ciphertext=securityUtils.encryptRsaMessage( requestId,aesToken);
					System.out.println("ciphertext="+ciphertext);
		//24-01-2025 Step=4 Generate DigitalSignature		
					requestDTO.setCipherText(ciphertext);
					requestDTO.setTimeStamp(formattedTimestamp);
					requestDTO.setRrn(RRN);
					PrivateKey privatekey=BbpsSecurityUtil.getPrivateKey(getBillerPrivate);
					 digitalSignature = securityUtils.generateDigitalSignature(requestDTO.getRrn() + requestDTO.getTimeStamp() + requestDTO.getCipherText(), privatekey);
						System.out.println("digitalSignature: " + digitalSignature);

						//24-01-2025 Step=5 Generate EncryptedRequest			

		//encryptedRequestMsg = "{" + "\"rrn\":\"SB5120210212093848ee3b04f1043344f87\"," + "\"cipherText\":\"3412C8F35979A2D92F92B7EA8A6183ECB1EDA5C896276562D80AA83F7C8C033BCCE43E2FAD9EAB5A0334CE8454392DB0DCA969469F3F5917B86335D986EE8275B87241DB1AF4A6499373DD6EA5A711EB634A7CAE352D4D3DA89D9F535A3971E12EB65058D2A001B039CE03FDEABB56C481488CC452FB117EF39D011339FAA09BD992EEA4D456FBCB877D9CA86E2D60613A48F61A99E8C3C88F6FE117ED1B0ADC83B2E406AB4075A882DD207880DDEFBBABD96A2EAEBD57BBD72BC29C1E530C11ECDB4AB1982E419840863D1A3078AF96746D1400D4A3D5AA68431E88676FB52F8B47B8F14C0000B659BA23ED7636D9FC57212922069324B991517A1912EDA7F4FA8641279A94B013F98F3DA950EC001A1E65F8A604849AFB663630BBFAA55C3885F1815EEB6B0AB94D25A00510B76A436F6E076333CD9802F83D9C0F6EE473A468C4633AB1A1F1D5C86E398197D374305CB14251CE0691E1AFBDFBE5783D20FA86D256050DE205DD90AC5CE3\"," + "\"digitalSig\":\"A7dIKgs8l8fndu7p/YNOigM5Gj32IgXiIDoYtZb0mfKW8yfWXPwYQDmMy7LYE1Vrk3c2r1eywWr7Wu1LJkyJ4RCp8H2nSjUpEpHYsaU3qV4vQyhSKWLjhEFOWcn9zqnwLaZAAd8zZCK7uorQFky02t28SOaVfcGU/3UhHxZVGXgOzJGSUVZlO6xFYnq91/GCbE9Bo9uNVENYWKtMXCPHb/8C4tYl9UMpVFurXYmUJq9U5ZJos0+JykjLUt3ly/LvCKegE6gnRuGCuvvnLi22HsDNWj3unW+ytbU9inA0gBkPaELH4fK9f3cs7U3b+A6KmX1VdJeSJVm9JAdkvGdu5A==\"," + "\"timeStamp\":\"2021-02-12T21:38:48+05:30\"" + "}";
		encryptedRequestMsg = "{" + "\"rrn\":\""+requestDTO.getRrn()+"\"," + "\"cipherText\":\""+requestDTO.getCipherText()+"\"," + "\"digitalSig\":\""+digitalSignature+"\"," + "\"ts\":\""+requestDTO.getTimeStamp()+"\"" + "}";

		System.out.println("EncryptedRequest: " + encryptedRequestMsg);
		  StringBuilder response = new StringBuilder();
		  try {
      	    // URL of the API endpoint
      	   URL url = new URL("https://uatsbiunipay.sbi/bbps-cou-switch/getCategoryList");
      	   //URL url = new URL("https://uatsbiunipay.sbi/bbps-cou-switch/getAccessToken/SB42");
        	 
      	    //URL url=new URL("https://jaisaissnidhilimited.com/api/values/PostBillDesk");
      	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      	    
      	    // Setting the request method to POST
      	    conn.setRequestMethod("POST");
      	    conn.setRequestProperty("Content-Type", "application/json; utf-8");
      	    conn.setRequestProperty("Accept", "application/json");
      	    conn.setDoOutput(true);

      	    // JSON payload
      	    String jsonInputString = encryptedRequestMsg;
      	    //String jsonInputString="{\"amt\":\"qg8lfycy0Ps=\",\"accNum\":\"QDvcz8lILVw1I6YUpkHHAw==\",\"hname\":\"v+yG16PsTsA=\",\"bal\":\"osN4bh2XAuVefhxwIn3QfQ==\",\"atype\":\"Qzwj51FVXG8=\"}";
      	    // Sending the JSON payload
      	    try (OutputStream os = conn.getOutputStream()) {
      	        byte[] input = jsonInputString.getBytes("utf-8");
      	        os.write(input, 0, input.length);
      	    }
      	// Read the response
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
              
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Response: " + response.toString());
                loginEntity.setOTP(response.toString());
            }
      	    // Reading the response
      	    int responseCode = conn.getResponseCode();
      	    System.out.println("Response Code: " + conn.getResponseMessage());
      	    
      	    // Handle the response (omitted for brevity)

      	} catch (Exception e) {
      	    
      		
      		loginEntity.setOTP(""+e.fillInStackTrace());
      		e.printStackTrace();
      	    
      	 
      	}

		// final Login1 login = new Login1();
        // model.clear();
         model.put("loginEntity2", loginEntity);
         mp.put("encryptedRequestMsg", encryptedRequestMsg);
         loginEntity.setBranch_Type("Request Id \n:"+requestId+"\n  Cipher :"+ciphertext+" \n Encripted Msg :"+encryptedRequestMsg);
         System.out.println("response.toString()="+response.toString());
         mp.put("OTP", response.toString());
        // mp.put("OTP1", response.toString());
         loginEntity.setOTP(response.toString());
         loginEntity.setEncryptedMsg(encryptedRequestMsg);
         //login.setOTP1(response.toString());
         
         mp.put("AesToken", loginEntity.getAesToken());
         mp.put("Rrn_No", loginEntity.getRrn_No());


       
    
    	return "loginCat";
    	}
    	
    	
    	

}
    @RequestMapping(value = { "/LoginValidate2" },params="GetToken", method = { RequestMethod.POST })
    public String CategoryList_Token(@Valid @ModelAttribute("loginEntity2") final Login1 loginEntity, final BindingResult result, final ModelMap mp,  HttpSession session, final HttpServletRequest request, final Map<String, Object> model, final RedirectAttributes attributes) throws SQLException, ParseException, IOException {
    	{
    		String id="SB42";
    		String agentInstid="SB42";
    		String token="6ffbeb77133c15ca241565135e103a78";
    		
    		//String aesToken=loginEntity.getOTP1();
    		
    		String RRN=loginEntity.getRrn_No();
    		String aesToken=loginEntity.getAesToken();
    	
    		
    	//	String user= loginEntity.getUsername();
    	//	String pass=loginEntity.getPassword();

		EncryptedRequestDto requestDTO =new EncryptedRequestDto();
		BillFetchRequestBean decryptedRequestDto = null;

		String decryptedResponseMsg = null;
		String encryptedResponseMsg = null;

		String encryptedRequestMsg = null;
		String decryptedRequestMsg = null;
		String encryptedAesKey = null;
		String decryptedAesKey = null;

		String timeStamp = null;
		String digitalSignature = null;
		boolean isVerified = false;
		boolean isValid = false;
		String getBillerPrivate = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgboeBDYUm/hLhirbB0Jb05XJEf/ji5SUC5LuqpQhnKhX3RJ0qxdOIzhG5lv4+FN+Yi/1DvCcDN8I2AsNzLABuuoeva/qYWhrs3808jPl2PiFIPv7EeRkfKzswN40Ov/d/05jdNQ1hg6vdylhD0sig5BJtmp3jimPGhSpQgowqvdPXSYwAuj2juea8pSJSPkU1BfPWM7WJWzeoUrNptaAV3sgZ5sa3yEuYPBTJr7/uP9mCMciu9GAxOzN0+awet1RFHfPXtWgIAi9RxgrOW6jSDYI9NqleC41jQyJR/E2uvUIJ/OlqL3L6bH0/PxkOuzy+biUv0qGB97DqXRh3EUU3AgMBAAECggEAd40GEwhFMiJhZYsd114eL86PkTYf/MyvAPH8WxRyJ5Z4GfQafpY+pRKSqM85FIAvgxjGmWQrWj2BzwfOKBQhGmKL3BBGBKQYrm20HiwbdZ6k5JZ0+WoYa16m066Bwf0RbUL8BdOT7hfVyggQMDJx6Vsr1FtEzxwAcB4pwycVVn8/ZFk+maoIptb7oOrVf/A1OaiwFHrUplQFwL9bOjrnaz6sPmGStpSU6NHVkUVlH/J8V/ag2iYt9QUQiLg6/jroMQegixZAi5g3fQKQ/2oOKy+6JKfxcN982X7Zy36gULhs/VJ+SeD/+YjqfIaNJtqDpeunlSGLGG8W+4f6nUp9IQKBgQDrTc4VG7x1AS6gc9wG7xcjSUWHK0tQow8rl64Y4KAb3iyKismNtgg8qkRERhJ+ZZulr07IUZE/M+doqNmoShtpcuGguUgcKGgfaCBo4351TgVh2fslzwzhrood7O+fScgJmmT+XN3et0luwkvpD60Kol5xD0dEOabH/f1RJNpvcQKBgQCuit+QhdN5d353UAWyPEZnrQmmfDU6yP280ELU0/AmC6nghRD7dz8ZXo+LmRMuekEeNX4l0HU1LNhjmcW4El6112ZfVtt7znI7yqq7m7SYHhewJT2xrDq6m9yhGa8j2TGZNrSb+cEYv8kJcBNZMMQytHVTg6h4vA01S4KUOK97JwKBgEIRIXjZxctQXqgcf73Oqb91ljkCle35KoxB1VcU0r+gXP81QqwwXRWzdOF6jzzACLi3hTZHeLG3QBUpu5s92357DBDVlQKa8clHsjnhDiOfmXFFA/g0r1g6antGiG1ACRNxL0QgDQe4jLy1fxzcEuj2d+/kq0zjpwlmLhb3cwFxAoGAJzS4jR0SaIln1eMatHOHmQgsT8I8rqyxGjVpnabRnaonCXC6ZNHfUZKFCeVjgqAheminolTVzxD4tj63Q+aUcaIls6qt+Hxh+n5GpYePJFA2H/HtjrhSJNKX13QOfC3wTysTnKmYLzf9L2qGXhVvLLiOVikPsbcD/IGunh6xhCcCgYAvtXpHRZN2xy66d1VrMeqhfddj+lDmp0ZkbbeyZHLovk2G4jOjck0CMHffMbYoi5Up2Opi6Gn2G2roO6EvLmPt8zneEDc9NfwdbQLVc7sHk4WaaZIWHl/9kyKLjO6PrjyN+IJ/W8GhDo1aXG+3bARmnqVhHQnARx6dw610JFy34g==";
		String BouPublic = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn9/lE9HbqaS/6GqkysCZgyUkeLkxOQKiosmGt5N3JA3qit4sP0yZh9HEtZk85S9xDVLUJkCEa2SIDEIWExpEVe3CI5TN8chXh/qyH0TqoHbkfrf2xkolYZFGYM/BcGj6I3bOVKFSTkwuxVmncgLrk0q7a6e5mgAwYxy9iMB0aOM56j37oEdOzOLl8giAhxvu2AorsPxfewfwnvnFXDvSQHtcQJhJDBZOl7lW9pl0fdqD2ct9/3lip//klMnj79IOncsFJ8JHwC1dpNdJk2PxWS1nzKgHsDlIKfnWPdqI+C2DYGU1Z71mXLXynBSogQiThfUWrSHgUlRB4WPsdurfawIDAQAB";
		BouMasterDto bouMasterDTO = new BouMasterDto();
		PrivateKey privatekey=BbpsSecurityUtil.getPrivateKey(getBillerPrivate);
		
		//24-01-2025 Step=2 Get ciphertext
		//String plainMsg="{\"agentInstitutionId\":\"SB42\",\"token\":\"6ffbeb77133c15ca241565135e103a78\"}";
		String plainMsg=loginEntity.getEncryptedMsg();
	    
		PublicKey pkey=BbpsSecurityUtil.getPublicKey(BouPublic);
		String ciphertext=securityUtils.encryptRsaMessage( plainMsg,pkey);
				System.out.println("ciphertext="+ciphertext);
		//24-01-2025 Step=3 Get Timestamp
					ZonedDateTime now2 = ZonedDateTime.now();
					//DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
					DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'+05:30'");

					String formattedTimestamp = now2.format(formatter2);
					System.out.println("Formatted Timestamp: " + formattedTimestamp);
				String TokenResponseMsg=loginEntity.getOTP().replace("\"ts\"", "\"timeStamp\"");
		System.out.println("TokenResponseMsg="+TokenResponseMsg );

		EncryptedRequestDto tokenRespenseDTO =new EncryptedRequestDto();
tokenRespenseDTO = JsonConverterUtilityP.convertStringToJsonObject(TokenResponseMsg, EncryptedRequestDto.class);
String signatureReqStr1 = tokenRespenseDTO.getRrn()+tokenRespenseDTO.getTimeStamp()+tokenRespenseDTO.getCipherText();
System.out.println("signatureReqStr1="+signatureReqStr1 );

//24-01-2025 Step=7 Verify TokenResponse with digital signature
isVerified = securityUtils.verifyDigitalSignature(signatureReqStr1, tokenRespenseDTO.getDigitalSig(), pkey); //give BOU public key here
System.out.println("isVerified="+isVerified );
/*if (!isVerified)
{
	EncryptedResponseDto responseDTO = new EncryptedResponseDto();
	responseDTO.setCipherText("Invalid Digital Signature");
	encryptedResponseMsg = JsonConverterUtilityP.convertJsonObjectToString(tokenRespenseDTO);
	return "/"; //return failure response here
}*/
//24-01-2025 Step=8 Get AES Key from Response
try {
	//aesToken
	decryptedAesKey =securityUtils.decryptAesGcm(tokenRespenseDTO.getCipherText(), aesToken);
	//decryptedAesKey = securityUtils.decryptMessage( tokenRespenseDTO.getCipherText(),privatekey);
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
String accessToken = null;
try {
    ObjectMapper objectMapper = new ObjectMapper();

    // Deserialize the JSON string into the Java object (Response)
    Response response = objectMapper.readValue(decryptedAesKey, Response.class);
     // db.insertResponseData(response);
      
} catch (Exception e) {
    e.printStackTrace();
}



// Now you have the Java object
//System.out.println(response);

mp.put("signatureReqStr1", signatureReqStr1 );
//final Login1 login = new Login1();
model.put("loginEntity", loginEntity);
loginEntity.setEncryptedMsg(plainMsg);
loginEntity.setOTP(decryptedAesKey );
loginEntity.setOTP1(""+isVerified+" op="+decryptedAesKey);
loginEntity.setBranch_Type("CypherTxt :"+ciphertext+" \n signatureReqStr1 : "+signatureReqStr1);

mp.put("AesToken", loginEntity.getAesToken());
mp.put("Rrn_No", loginEntity.getRrn_No());

return "login";


    	}
    	
    	
    	
    	
    	
    	

}

   /* 
   @RequestMapping(value = { "/LoginValidate" },params="Send2", method = { RequestMethod.POST })
    public String doLogin2(@Valid @ModelAttribute("loginEntity") final Login1 loginEntity, final BindingResult result, final ModelMap mp, @RequestParam final String Username, HttpSession session, final HttpServletRequest request, final Map<String, Object> model, final RedirectAttributes attributes) throws SQLException, ParseException, IOException {
    	{
    		
    		String id="SB42";
    		String to="6ffbeb77133c15ca241565135e103a78";
    		
    		String user= loginEntity.getUsername();
    		String pass=loginEntity.getPassword();

		EncryptedRequestDto requestDTO = null;
		BillFetchRequestBean decryptedRequestDto = null;

		String decryptedResponseMsg = null;
		String encryptedResponseMsg = null;

		String encryptedRequestMsg = null;
		String decryptedRequestMsg = null;
		String encryptedAesKey = null;
		String decryptedAesKey = null;

		String timeStamp = null;
		String digitalSignature = null;
		boolean isVerified = false;
		boolean isValid = false;

		BouMasterDto bouMasterDTO = new BouMasterDto();

		encryptedRequestMsg = "{" + "\"rrn\":\"SB5120210212093848ee3b04f1043344f87\"," + "\"cipherText\":\"3412C8F35979A2D92F92B7EA8A6183ECB1EDA5C896276562D80AA83F7C8C033BCCE43E2FAD9EAB5A0334CE8454392DB0DCA969469F3F5917B86335D986EE8275B87241DB1AF4A6499373DD6EA5A711EB634A7CAE352D4D3DA89D9F535A3971E12EB65058D2A001B039CE03FDEABB56C481488CC452FB117EF39D011339FAA09BD992EEA4D456FBCB877D9CA86E2D60613A48F61A99E8C3C88F6FE117ED1B0ADC83B2E406AB4075A882DD207880DDEFBBABD96A2EAEBD57BBD72BC29C1E530C11ECDB4AB1982E419840863D1A3078AF96746D1400D4A3D5AA68431E88676FB52F8B47B8F14C0000B659BA23ED7636D9FC57212922069324B991517A1912EDA7F4FA8641279A94B013F98F3DA950EC001A1E65F8A604849AFB663630BBFAA55C3885F1815EEB6B0AB94D25A00510B76A436F6E076333CD9802F83D9C0F6EE473A468C4633AB1A1F1D5C86E398197D374305CB14251CE0691E1AFBDFBE5783D20FA86D256050DE205DD90AC5CE3\"," + "\"digitalSig\":\"A7dIKgs8l8fndu7p/YNOigM5Gj32IgXiIDoYtZb0mfKW8yfWXPwYQDmMy7LYE1Vrk3c2r1eywWr7Wu1LJkyJ4RCp8H2nSjUpEpHYsaU3qV4vQyhSKWLjhEFOWcn9zqnwLaZAAd8zZCK7uorQFky02t28SOaVfcGU/3UhHxZVGXgOzJGSUVZlO6xFYnq91/GCbE9Bo9uNVENYWKtMXCPHb/8C4tYl9UMpVFurXYmUJq9U5ZJos0+JykjLUt3ly/LvCKegE6gnRuGCuvvnLi22HsDNWj3unW+ytbU9inA0gBkPaELH4fK9f3cs7U3b+A6KmX1VdJeSJVm9JAdkvGdu5A==\"," + "\"timeStamp\":\"2021-02-12T21:38:48+05:30\"" + "}";

		encryptedAesKey = "gUe9VDQprP6C9ZKhDBty2kWNjs73D0xrFGC16DF3J18xGyoipRr2WS9sM52r0vaCbJm0/JxnYsJ51NdcxKNh16wP24IIW5XANLi4HfAr8P18UNlYPXOHYxSpntFSaRwkWEZYcKJj6OFIknyqMJKYwxTxxHkLp9Ci9D2QCb5ulh13y75eo8IbQfSsAaCh6zI8czhZPZtT+fCzoD+uNnGKe2FPQ4LtB07ax/P/R+c+9XbVZsB+OGIxjWwp23dLmL368hw/RG53lBu1Ut1A/vphii6gjJJTN7LtmsUPRymUOK7eB4860DXfQT9FXePzp/+qu3R9tkvv9XInf87/SzBdvg==";

		
		bouMasterDTO.setRequestExpiry(180);//180 seconds
		bouMasterDTO.setEncryptedRequestMsg(encryptedRequestMsg);
		bouMasterDTO.setEncryptedAesKey(encryptedAesKey);
		bouMasterDTO.setBillerId("SB5140000NAT02");
		System.out.println("id2="+id);
		requestDTO = JsonConverterUtilityP.convertStringToJsonObject(bouMasterDTO.getEncryptedRequestMsg(), EncryptedRequestDto.class);
		bouMasterDTO.setEncryptedRequestDto(requestDTO);
		System.out.println("id3="+id);
		String directory = "E:\\BBPS\\resources\\";
		String keyStore = "SBI_BBPS.jks";
		String keyStorePass = "abcd@123";
		String keyStoreAlias = "test";
	
		KeyPair keypair = KeyStoreUtil.getBillerKeyPair(directory, keyStore, keyStorePass, keyStoreAlias);

		bouMasterDTO.setBillerPublicKey(java.util.Base64.getEncoder().encodeToString(keypair.getPublic().getEncoded()));
		bouMasterDTO.setBillerPrivateKey(java.util.Base64.getEncoder().encodeToString(keypair.getPrivate().getEncoded()));

		bouMasterDTO.setBouPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAna20pk+66pkXVak8pvsMqZIwnmVNVCR4iWbRKl+QlRnA2HpN8w1RrPLIj48LcBQyjnxdP7d6Des/SIZsz3luChRi0NiECnDTohySRsWxfJ7ByzrE/tQ0C7QoS7eNaOp0Y9pVLz6oc92l6W0vzniPWEbnABHM/9tZ/1XQr2OcA6NN+jIQZPynLKlZp17YWV7QxCoDl/otpzXl2yDk57RN4NK5wgY6PKBYvMh4QAcPrRtzhRPaf8IqqaZiGdnCjT+zTLLFgszFeM2SZzxkERP7uPIrwP0qJ89diyT8Og4QnCP0GQmg0/UkMabZpYzKirdc1PstIeRT+Z0E2SrXvsincwIDAQAB");

		String signatureReqStr = requestDTO.getRrn() + requestDTO.getTimeStamp() + requestDTO.getCipherText();

		isVerified = securityUtils.verifyDigitalSignature(signatureReqStr, requestDTO.getDigitalSig(), bouMasterDTO.getBouPublicKey()); //give BOU public key here
		if (!isVerified)
		{
			EncryptedResponseDto responseDTO = new EncryptedResponseDto();
			responseDTO.setCipherText("Invalid Digital Signature");
			encryptedResponseMsg = JsonConverterUtilityP.convertJsonObjectToString(responseDTO);
			return "/"; //return failure response here
		}

		try
		{
			decryptedAesKey = securityUtils.decryptMessage(bouMasterDTO.getEncryptedAesKey(), bouMasterDTO.getBillerPrivateKey());
		}
		catch (Exception e)
		{
		}
		bouMasterDTO.setDecryptedAesKey(decryptedAesKey);

		timeStamp = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+05:30'")).format(new Date());
		isValid = BbpsValidator.timeStampRuleValidator(requestDTO.getTimeStamp(), timeStamp, bouMasterDTO.getRequestExpiry());
		if (!isValid)
		{
			EncryptedResponseDto responseDTO = new EncryptedResponseDto();
			responseDTO.setCipherText("Timestamp cannot be older than " + bouMasterDTO.getRequestExpiry() + " minutes");
			decryptedResponseMsg = JsonConverterUtilityP.convertJsonObjectToString(responseDTO);
			return "/"; //return failure response here
		}


		decryptedRequestMsg = securityUtils.decryptAesGcm(requestDTO.getCipherText(), bouMasterDTO.getDecryptedAesKey());
		bouMasterDTO.setDecryptedRequestMsg(decryptedRequestMsg);
		decryptedRequestDto = JsonConverterUtilityP.convertStringToJsonObject(bouMasterDTO.getDecryptedRequestMsg(), BillFetchRequestBean.class);
		bouMasterDTO.setFetchRequestDto(decryptedRequestDto);

		BillFetchResponseBean billFetchResponseBean = new BillFetchResponseBean();
		bouMasterDTO.setFetchResponseDto(billFetchResponseBean);
		decryptedResponseMsg = JsonConverterUtilityP.convertJsonObjectToString(bouMasterDTO.getFetchResponseDto());
		bouMasterDTO.setDecryptedResponseMsg(decryptedResponseMsg);
		encryptedResponseMsg = securityUtils.encryptAesGcm(bouMasterDTO.getDecryptedResponseMsg(), bouMasterDTO.getDecryptedAesKey());
		bouMasterDTO.setEncryptedResponseMsg(encryptedResponseMsg);

		EncryptedResponseDto encryptedResponseDto = new EncryptedResponseDto();
		encryptedResponseDto.setRrn(bouMasterDTO.getEncryptedRequestDto().getRrn());
		encryptedResponseDto.setCipherText(bouMasterDTO.getEncryptedResponseMsg());
		encryptedResponseDto.setTimeStamp((new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+05:30'")).format(new Date()));
		bouMasterDTO.setEncryptedResponseDto(encryptedResponseDto);

		digitalSignature = securityUtils.generateDigitalSignature(bouMasterDTO.getEncryptedResponseDto().getRrn() + bouMasterDTO.getEncryptedResponseDto().getTimeStamp() + bouMasterDTO.getEncryptedResponseDto().getCipherText(), bouMasterDTO.getBillerPrivateKey());

		bouMasterDTO.getEncryptedResponseDto().setDigitalSig(digitalSignature);
		encryptedResponseMsg = JsonConverterUtilityP.convertJsonObjectToString(bouMasterDTO.getEncryptedResponseDto());
		bouMasterDTO.setEncryptedResponseMsg(encryptedResponseMsg); //final response to be sent to BOU (bank)
	
		final Login1 login = new Login1();
        model.clear();
        model.put("loginEntity", login);
   	return "redirect:/";
    	}

}
*/   
   /* @RequestMapping(value = { "/LoginValidate" },params="Send2", method = { RequestMethod.POST })
    public String doLogin2(@Valid @ModelAttribute("loginEntity") final Login1 loginEntity, final BindingResult result, final ModelMap mp, @RequestParam final String Username, HttpSession session, final HttpServletRequest request, final Map<String, Object> model, final RedirectAttributes attributes) throws SQLException, ParseException, IOException {
    	{
        Cipher objCipherTest = new Cipher();
        BouMasterDto bouMasterDTO = new BouMasterDto();
        TokenResponseBean objTokenResponseBean = new TokenResponseBean();
        EncryptedRequestDto requestDTO = null;
        String plainMsg = null;
        String BouJksPath = null;
        String BouJksPassword = null;
        String encryptedResponseMsg = null;
        bool isVerified = false;

        //objCipherTest.agentInstitutionId = string.IsNullOrEmpty(objCipherTest.agentInstitutionId) ? "inputField" : objCipherTest.agentInstitutionId;
        //bjCipherTest.token = string.IsNullOrEmpty(objCipherTest.token) ? "inputField" : objCipherTest.token;

        objCipherTest.agentInstitutionId = "SB42";
        objCipherTest.token = "6ffbeb77133c15ca241565135e103a78";
        plainMsg = JsonConvert.SerializeObject(objCipherTest);  //"{\"agentInstitutionId\":\"SB42\",\"token\":\"6ffbeb77133c15ca241565135e103a78\"}"

        /*
        BouJksPath = "D:\\SBIUNIPAY\\UATSBIUNIPAY.SBI.jks";
        BouJksPassword = "Sbi@1234";
        JavaKeyStore boujks = new JavaKeyStore();
        boujks.LoadFile(BouJksPassword, BouJksPath);
        PrivateKey BouPrivateKey = boujks.GetPrivateKey(BouJksPassword, 0);
        PublicKey BouPublicKey = BouPrivateKey.GetPublicKey();
        bouMasterDTO.bouPublicKey = BouPublicKey.GetEncoded(true, "base64");
        */

        /*
        string directory = "D:\\SBIUNIPAY\\";
        string keyStore = "BBPS_BILLER_TEST.jks";
        string keyStorePass = "XYZBillerBbps@123#";
        string JKSFilePath = directory + keyStore;
        JavaKeyStore jks = new JavaKeyStore();
        jks.LoadFile(keyStorePass, JKSFilePath);
        PrivateKey billerPrivateKey = jks.GetPrivateKey(keyStorePass, 0);
        //PublicKey billerPublicKey = billerPrivateKey.GetPublicKey();
        KeyPair keypair = new KeyPair();
        keypair.PublicKey = billerPublicKey.GetEncoded(true, "base64");
        keypair.PrivateKey = billerPrivateKey.GetPkcs8ENC("base64");
        bouMasterDTO.billerPrivateKey = keypair.PrivateKey;
        bouMasterDTO.billerPublicKey = keypair.PublicKey;
        */
/*
         string Public_Key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn9/lE9HbqaS/6GqkysCZgyUkeLkxOQKiosmGt5N3JA3qit4sP0yZh9HEtZk85S9xDVLUJkCEa2SIDEIWExpEVe3CI5TN8chXh/qyH0TqoHbkfrf2xkolYZFGYM/BcGj6I3bOVKFSTkwuxVmncgLrk0q7a6e5mgAwYxy9iMB0aOM56j37oEdOzOLl8giAhxvu2AorsPxfewfwnvnFXDvSQHtcQJhJDBZOl7lW9pl0fdqD2ct9/3lip//klMnj79IOncsFJ8JHwC1dpNdJk2PxWS1nzKgHsDlIKfnWPdqI+C2DYGU1Z71mXLXynBSogQiThfUWrSHgUlRB4WPsdurfawIDAQAB";

         string Biller_Private_Key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgboeBDYUm/hLhirbB0Jb05XJEf/ji5SUC5LuqpQhnKhX3RJ0qxdOIzhG5lv4+FN+Yi/1DvCcDN8I2AsNzLABuuoeva/qYWhrs3808jPl2PiFIPv7EeRkfKzswN40Ov/d/05jdNQ1hg6vdylhD0sig5BJtmp3jimPGhSpQgowqvdPXSYwAuj2juea8pSJSPkU1BfPWM7WJWzeoUrNptaAV3sgZ5sa3yEuYPBTJr7/uP9mCMciu9GAxOzN0+awet1RFHfPXtWgIAi9RxgrOW6jSDYI9NqleC41jQyJR/E2uvUIJ/OlqL3L6bH0/PxkOuzy+biUv0qGB97DqXRh3EUU3AgMBAAECggEAd40GEwhFMiJhZYsd114eL86PkTYf/MyvAPH8WxRyJ5Z4GfQafpY+pRKSqM85FIAvgxjGmWQrWj2BzwfOKBQhGmKL3BBGBKQYrm20HiwbdZ6k5JZ0+WoYa16m066Bwf0RbUL8BdOT7hfVyggQMDJx6Vsr1FtEzxwAcB4pwycVVn8/ZFk+maoIptb7oOrVf/A1OaiwFHrUplQFwL9bOjrnaz6sPmGStpSU6NHVkUVlH/J8V/ag2iYt9QUQiLg6/jroMQegixZAi5g3fQKQ/2oOKy+6JKfxcN982X7Zy36gULhs/VJ+SeD/+YjqfIaNJtqDpeunlSGLGG8W+4f6nUp9IQKBgQDrTc4VG7x1AS6gc9wG7xcjSUWHK0tQow8rl64Y4KAb3iyKismNtgg8qkRERhJ+ZZulr07IUZE/M+doqNmoShtpcuGguUgcKGgfaCBo4351TgVh2fslzwzhrood7O+fScgJmmT+XN3et0luwkvpD60Kol5xD0dEOabH/f1RJNpvcQKBgQCuit+QhdN5d353UAWyPEZnrQmmfDU6yP280ELU0/AmC6nghRD7dz8ZXo+LmRMuekEeNX4l0HU1LNhjmcW4El6112ZfVtt7znI7yqq7m7SYHhewJT2xrDq6m9yhGa8j2TGZNrSb+cEYv8kJcBNZMMQytHVTg6h4vA01S4KUOK97JwKBgEIRIXjZxctQXqgcf73Oqb91ljkCle35KoxB1VcU0r+gXP81QqwwXRWzdOF6jzzACLi3hTZHeLG3QBUpu5s92357DBDVlQKa8clHsjnhDiOfmXFFA/g0r1g6antGiG1ACRNxL0QgDQe4jLy1fxzcEuj2d+/kq0zjpwlmLhb3cwFxAoGAJzS4jR0SaIln1eMatHOHmQgsT8I8rqyxGjVpnabRnaonCXC6ZNHfUZKFCeVjgqAheminolTVzxD4tj63Q+aUcaIls6qt+Hxh+n5GpYePJFA2H/HtjrhSJNKX13QOfC3wTysTnKmYLzf9L2qGXhVvLLiOVikPsbcD/IGunh6xhCcCgYAvtXpHRZN2xy66d1VrMeqhfddj+lDmp0ZkbbeyZHLovk2G4jOjck0CMHffMbYoi5Up2Opi6Gn2G2roO6EvLmPt8zneEDc9NfwdbQLVc7sHk4WaaZIWHl/9kyKLjO6PrjyN+IJ/W8GhDo1aXG+3bARmnqVhHQnARx6dw610JFy34g==";
         string EncryptedText = securityUtils.encryptMessage(Public_Key, plainMsg);
        EncryptedResponseDto encryptedResponseDto = new EncryptedResponseDto();
        encryptedResponseDto.cipherText = EncryptedText;
        encryptedResponseDto.rrn = "68de2ab99aba4a1f90d232b28050e7b6y6y";
        encryptedResponseDto.timeStamp = "2024-12-23T16:46:44+00:00";
        string tt = encryptedResponseDto.rrn + encryptedResponseDto.timeStamp + encryptedResponseDto.cipherText;
        string digitalSignature = securityUtils.generateDigitalSignature(encryptedResponseDto.rrn + encryptedResponseDto.timeStamp + encryptedResponseDto.cipherText, Biller_Private_Key);
        encryptedResponseDto.digitalSig = digitalSignature;
        encryptedResponseMsg = JsonConvert.SerializeObject(encryptedResponseDto);

        string encryptedRequestMsg = "{" + "\"rrn\":\"68de2ab99aba4a1f90d232b28050e7b6y6y\"," + "\"cipherText\":\"Xo50jTIe6oS8hUPfsHDVhLsF6PaWYsBwamtkBFnV8X4grorpDGjW70ZL9ONq4rZsFhx9iQPg1y3FU9phfbhHg80VFj5Kt3klJOBWkols+iQqz0TG72/1yKQqn5mIq3CGAYKqEq6FLS1+z17oxugk8OqgxWaETI8ZuE3BIW8iM1XS2qk81fjlSp1NmMDmoTFz5iNqg2eaUpnWVu2QMUPcBnuTnWswTqSjTXtB5M6emx5P43ktQT24yB+n046z6MVc52KGTQiPGfpg+3FolZJF95MWL8XdkaOHf9sqEl4nKDyLnioFa6S8H/Rp1EtJmtiOv/g9N8ewbF9aNTjp0JoTkg==\"," + "\"digitalSig\":\"e3lTrgtrqLKGTKpfyAUoy4OZYo+DcaKwxbQyE5ZplPLrCIiI7VoKm8KmwurjyTw3CzILducxpLK7BRbd+BBMVyBFPBVc+zH+jOIlSsKqnXyfQo3LD//0rJb+VLagVlf26R5VBzlZJQWxakshKzegMns9wWUdIZmMVmcpzRPOPFTI7xTRv9EH9eCGQdDmFdS5owID7i1WQWcR7Pra6o9dSpQG3VD9qNf4UukIhpI4etdN7bkqoaTCsISbbZj8ktM7s+Rs4WKh41N3e9RnfHkvfZyK/pZFEnxtw7bc9/wN1+nyJynLVgz+TQQBUHfv26em7tfJ4x3SFEiCG2BBCgyVMg==\"," + "\"timeStamp\":\"2025-01-06T15:21:19+05:30\"" + "}";
        //string encryptedRequestMsg = "https://uatsbiunipay.sbi/bbps-cou-switch/getAccessToken/SB42";

        //string encryptedRequestMsg = JsonConvert.SerializeObject(encryptedResponseDto);
        bouMasterDTO.encryptedRequestMsg = encryptedRequestMsg;

        requestDTO = JsonConvert.DeserializeObject<EncryptedRequestDto>(bouMasterDTO.encryptedRequestMsg);
        string signatureReqStr = requestDTO.rrn + requestDTO.timeStamp + requestDTO.cipherText;
        isVerified = securityUtils.verifyDigitalSignature(signatureReqStr, requestDTO.digitalSig, Public_Key); //give BOU public key here

        if (!isVerified)
        {
            EncryptedResponseDto responseDTO = new EncryptedResponseDto();
            responseDTO.cipherText = "Invalid Digital Signature";
            encryptedResponseMsg = JsonConvert.SerializeObject(responseDTO);
            return;
        }

        //string decryptedAesKey = securityUtils.decryptMessage(bouMasterDTO.billerPrivateKey, requestDTO.cipherText);
        string decryptedAesKey = securityUtils.decryptMessage(Biller_Private_Key, requestDTO.cipherText);

        objTokenResponseBean = JsonConvert.DeserializeObject<TokenResponseBean>(decryptedAesKey);
        bouMasterDTO.decryptedAesKey = objTokenResponseBean.accessToken;

        //string plainText = "{\"agentInstitutionId\":\"OU01OU02INT522274495200721ahbcj2123\",\"token\":\"6ffbeb77133c15ca241565135e103a78\"}";
        string plainText = "{ \"head\": { \"requestId\": \"OU01OU02INT522274495200721ahbcj2123\", \"ts\": \"2020-07-21T22:02:35+05:30\" }, \"search\": { \"status\": \"\" } }";
        string aesEncryptedMsg = AESGCMNoPadding.encrypt(plainText, bouMasterDTO.decryptedAesKey);

        EncryptedResponseDto encryptedResponseDto1 = new EncryptedResponseDto();
        encryptedResponseDto1.cipherText = aesEncryptedMsg;
        encryptedResponseDto1.rrn = "68de2ab99aba4a1f90d232b28050e7b6";
        encryptedResponseDto1.timeStamp = "2021-08-31T11:46:44+05:30";

        digitalSignature = securityUtils.generateDigitalSignature(encryptedResponseDto1.rrn + encryptedResponseDto1.timeStamp + encryptedResponseDto1.cipherText, Biller_Private_Key);
        encryptedResponseDto1.digitalSig = digitalSignature;

        string encryptedResponseDto1JsonData = JsonConvert.SerializeObject(encryptedResponseDto1);

        string encryptedRequestMsg1 = "{" + "\"rrn\":\"68de2ab99aba4a1f90d232b28050e7b6\"," + "\"cipherText\":\"BZO5yatNqQZJYnQvtodB8SaancwlZosKEPCg4rHW8R8sA2ko4C4hUlVV4I45f6NsQq7zHkuCn7uQ/lie+yyQC7WB0pOu6KKuoimu8puKEZHXY/0TjKq3TJ+zvicY72EtWpVvCMr5p7I+d+hSjX1Pi9O/ZweE5KeQAnCkV4ZwzTgBTk1UG7rPUilFhfmzTAOfXvkYHH6Wx8uKpZBdFIuNUZLSB4iazpqH4clTsBj0Vizq0ytQPQYPtTHLYgxbte6Eq6VbnaogaAUDHe1UcFyYBdErb0uAxdlNuUA9I/N92wBM523PyS+iDXnhlWtMWuPRAVY9w+eLE7HnwQWmLu1vPQ==\"," + "\"digitalSig\":\"d6RypvZv5+X/lD6D57PdH3PunUuYf7AToBnsk60TVBR42WZp+TVJ9VEngXO8N/4vhdb6GGGwoTN/8QtLK0y5SbpzO+yhcFvAmmyS2FhzGupHmkloJ9s53EAx8xDJh/IT83X+ir2HbqGXvPuSwDGMh1SrmYDkA1kpQGNIygn2bllOynvAnk9odsO2q7vIsi3f1dKYtJvA+TCVfMXNab+LVhqZcFcAvjG+pNJdpB/XhTB2eupLPJX5UXFccJNjNDn/6lF9nigqpjZPAlrsUrQyRjtlQ3EM/y45ZM4sbjjpvEpvp8VZXPw87wKYbbYUyPM9LX3DoqKjQhxpFxawSyklUA==\"," + "\"timeStamp\":\"2021-08-31T11:46:44+05:30\"" + "}";
        requestDTO = JsonConvert.DeserializeObject<EncryptedRequestDto>(encryptedRequestMsg1);
        string signatureReqStr1 = requestDTO.rrn + requestDTO.timeStamp + requestDTO.cipherText;
        isVerified = securityUtils.verifyDigitalSignature(signatureReqStr1, requestDTO.digitalSig, bouMasterDTO.bouPublicKey); //give BOU public key here

        if (!isVerified)
        {
            EncryptedResponseDto responseDTO = new EncryptedResponseDto();
            responseDTO.cipherText = "Invalid Digital Signature";
            encryptedResponseMsg = JsonConvert.SerializeObject(responseDTO);
            return;
        }

        string decryptedCipherText = AESGCMNoPadding.decrypt(requestDTO.cipherText, bouMasterDTO.decryptedAesKey);

    }

}*/
    
    
    
    
    @RequestMapping(value = { "/LoginValidate" },params="StateList", method = { RequestMethod.POST })
    public String StateList(@Valid @ModelAttribute("loginEntity") final Login1 loginEntity, final BindingResult result, final ModelMap mp,  HttpSession session, final HttpServletRequest request, final Map<String, Object> model, final RedirectAttributes attributes) throws SQLException, ParseException, IOException {
    	{
    		String uniqueID = UUID.randomUUID().toString();

    		String id="SB42";
    		String agentInstid="SB42";
    		String token="6ffbeb77133c15ca241565135e103a78";
    		//String aesToken=loginEntity.getOTP1();
    		
    		String RRN=loginEntity.getRrn_No();
    		String aesToken=loginEntity.getAesToken();
    		
		EncryptedRequestDto requestDTO =new EncryptedRequestDto();
		BillFetchRequestBean decryptedRequestDto = null;

		String decryptedResponseMsg = null;
		String encryptedResponseMsg = null;

		String encryptedRequestMsg = null;
		String decryptedRequestMsg = null;
		String encryptedAesKey = null;
		String decryptedAesKey = null;

		String timeStamp = null;
		String digitalSignature = null;
		boolean isVerified = false;
		boolean isValid = false;
		String getBillerPrivate = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgboeBDYUm/hLhirbB0Jb05XJEf/ji5SUC5LuqpQhnKhX3RJ0qxdOIzhG5lv4+FN+Yi/1DvCcDN8I2AsNzLABuuoeva/qYWhrs3808jPl2PiFIPv7EeRkfKzswN40Ov/d/05jdNQ1hg6vdylhD0sig5BJtmp3jimPGhSpQgowqvdPXSYwAuj2juea8pSJSPkU1BfPWM7WJWzeoUrNptaAV3sgZ5sa3yEuYPBTJr7/uP9mCMciu9GAxOzN0+awet1RFHfPXtWgIAi9RxgrOW6jSDYI9NqleC41jQyJR/E2uvUIJ/OlqL3L6bH0/PxkOuzy+biUv0qGB97DqXRh3EUU3AgMBAAECggEAd40GEwhFMiJhZYsd114eL86PkTYf/MyvAPH8WxRyJ5Z4GfQafpY+pRKSqM85FIAvgxjGmWQrWj2BzwfOKBQhGmKL3BBGBKQYrm20HiwbdZ6k5JZ0+WoYa16m066Bwf0RbUL8BdOT7hfVyggQMDJx6Vsr1FtEzxwAcB4pwycVVn8/ZFk+maoIptb7oOrVf/A1OaiwFHrUplQFwL9bOjrnaz6sPmGStpSU6NHVkUVlH/J8V/ag2iYt9QUQiLg6/jroMQegixZAi5g3fQKQ/2oOKy+6JKfxcN982X7Zy36gULhs/VJ+SeD/+YjqfIaNJtqDpeunlSGLGG8W+4f6nUp9IQKBgQDrTc4VG7x1AS6gc9wG7xcjSUWHK0tQow8rl64Y4KAb3iyKismNtgg8qkRERhJ+ZZulr07IUZE/M+doqNmoShtpcuGguUgcKGgfaCBo4351TgVh2fslzwzhrood7O+fScgJmmT+XN3et0luwkvpD60Kol5xD0dEOabH/f1RJNpvcQKBgQCuit+QhdN5d353UAWyPEZnrQmmfDU6yP280ELU0/AmC6nghRD7dz8ZXo+LmRMuekEeNX4l0HU1LNhjmcW4El6112ZfVtt7znI7yqq7m7SYHhewJT2xrDq6m9yhGa8j2TGZNrSb+cEYv8kJcBNZMMQytHVTg6h4vA01S4KUOK97JwKBgEIRIXjZxctQXqgcf73Oqb91ljkCle35KoxB1VcU0r+gXP81QqwwXRWzdOF6jzzACLi3hTZHeLG3QBUpu5s92357DBDVlQKa8clHsjnhDiOfmXFFA/g0r1g6antGiG1ACRNxL0QgDQe4jLy1fxzcEuj2d+/kq0zjpwlmLhb3cwFxAoGAJzS4jR0SaIln1eMatHOHmQgsT8I8rqyxGjVpnabRnaonCXC6ZNHfUZKFCeVjgqAheminolTVzxD4tj63Q+aUcaIls6qt+Hxh+n5GpYePJFA2H/HtjrhSJNKX13QOfC3wTysTnKmYLzf9L2qGXhVvLLiOVikPsbcD/IGunh6xhCcCgYAvtXpHRZN2xy66d1VrMeqhfddj+lDmp0ZkbbeyZHLovk2G4jOjck0CMHffMbYoi5Up2Opi6Gn2G2roO6EvLmPt8zneEDc9NfwdbQLVc7sHk4WaaZIWHl/9kyKLjO6PrjyN+IJ/W8GhDo1aXG+3bARmnqVhHQnARx6dw610JFy34g==";
		String BouPublic = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn9/lE9HbqaS/6GqkysCZgyUkeLkxOQKiosmGt5N3JA3qit4sP0yZh9HEtZk85S9xDVLUJkCEa2SIDEIWExpEVe3CI5TN8chXh/qyH0TqoHbkfrf2xkolYZFGYM/BcGj6I3bOVKFSTkwuxVmncgLrk0q7a6e5mgAwYxy9iMB0aOM56j37oEdOzOLl8giAhxvu2AorsPxfewfwnvnFXDvSQHtcQJhJDBZOl7lW9pl0fdqD2ct9/3lip//klMnj79IOncsFJ8JHwC1dpNdJk2PxWS1nzKgHsDlIKfnWPdqI+C2DYGU1Z71mXLXynBSogQiThfUWrSHgUlRB4WPsdurfawIDAQAB";
		BouMasterDto bouMasterDTO = new BouMasterDto();
		
		//24-01-2025 Step=2 Get ciphertext
		String plainMsg="{\"agentInstitutionId\":\"SB42\",\"token\":\"6ffbeb77133c15ca241565135e103a78\"}";
				PublicKey pkey=BbpsSecurityUtil.getPublicKey(BouPublic);
				//PublicKey aeskey=BbpsSecurityUtil.getPublicKey(aesToken);
		
				String NBCIID="OU01OU02INT522274495200721ahbcj2123";
				//----------------------------------------------------------------------------
				ZonedDateTime now2 = ZonedDateTime.now();
				DateTimeFormatter rrnform = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
				String rrnTimestamp = now2.format(rrnform);
				 NBCIID="OU01OU02INT"+rrnTimestamp+"1ahbcj2123";
				
				//--------------------------------------------------------------------------
			
		//24-01-2025 Step=3 Get Timestamp
					//ZonedDateTime now2 = ZonedDateTime.now();
					//DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
					//"yyyy-MM-dd'T'HH:mm:ss'+05:30'"
					DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'+05:30'");
					String formattedTimestamp = now2.format(formatter2);
					System.out.println("Formatted Timestamp: " + formattedTimestamp);
					String requestId="{\"head\":{\"requestId\":\""+NBCIID+"\",\"ts\":\""+formattedTimestamp+"\"},\"search\":{\"status\":\"Active\"}}";
					String ciphertext=securityUtils.encryptAesGcm(requestId, aesToken);
					//String ciphertext=securityUtils.encryptRsaMessage( requestId,aesToken);
					System.out.println("ciphertext="+ciphertext);
		//24-01-2025 Step=4 Generate DigitalSignature		
					requestDTO.setCipherText(ciphertext);
					requestDTO.setTimeStamp(formattedTimestamp);
					requestDTO.setRrn(RRN);
					PrivateKey privatekey=BbpsSecurityUtil.getPrivateKey(getBillerPrivate);
					 digitalSignature = securityUtils.generateDigitalSignature(requestDTO.getRrn() + requestDTO.getTimeStamp() + requestDTO.getCipherText(), privatekey);
						System.out.println("digitalSignature: " + digitalSignature);

						//24-01-2025 Step=5 Generate EncryptedRequest			

		//encryptedRequestMsg = "{" + "\"rrn\":\"SB5120210212093848ee3b04f1043344f87\"," + "\"cipherText\":\"3412C8F35979A2D92F92B7EA8A6183ECB1EDA5C896276562D80AA83F7C8C033BCCE43E2FAD9EAB5A0334CE8454392DB0DCA969469F3F5917B86335D986EE8275B87241DB1AF4A6499373DD6EA5A711EB634A7CAE352D4D3DA89D9F535A3971E12EB65058D2A001B039CE03FDEABB56C481488CC452FB117EF39D011339FAA09BD992EEA4D456FBCB877D9CA86E2D60613A48F61A99E8C3C88F6FE117ED1B0ADC83B2E406AB4075A882DD207880DDEFBBABD96A2EAEBD57BBD72BC29C1E530C11ECDB4AB1982E419840863D1A3078AF96746D1400D4A3D5AA68431E88676FB52F8B47B8F14C0000B659BA23ED7636D9FC57212922069324B991517A1912EDA7F4FA8641279A94B013F98F3DA950EC001A1E65F8A604849AFB663630BBFAA55C3885F1815EEB6B0AB94D25A00510B76A436F6E076333CD9802F83D9C0F6EE473A468C4633AB1A1F1D5C86E398197D374305CB14251CE0691E1AFBDFBE5783D20FA86D256050DE205DD90AC5CE3\"," + "\"digitalSig\":\"A7dIKgs8l8fndu7p/YNOigM5Gj32IgXiIDoYtZb0mfKW8yfWXPwYQDmMy7LYE1Vrk3c2r1eywWr7Wu1LJkyJ4RCp8H2nSjUpEpHYsaU3qV4vQyhSKWLjhEFOWcn9zqnwLaZAAd8zZCK7uorQFky02t28SOaVfcGU/3UhHxZVGXgOzJGSUVZlO6xFYnq91/GCbE9Bo9uNVENYWKtMXCPHb/8C4tYl9UMpVFurXYmUJq9U5ZJos0+JykjLUt3ly/LvCKegE6gnRuGCuvvnLi22HsDNWj3unW+ytbU9inA0gBkPaELH4fK9f3cs7U3b+A6KmX1VdJeSJVm9JAdkvGdu5A==\"," + "\"timeStamp\":\"2021-02-12T21:38:48+05:30\"" + "}";
		encryptedRequestMsg = "{" + "\"rrn\":\""+requestDTO.getRrn()+"\"," + "\"cipherText\":\""+requestDTO.getCipherText()+"\"," + "\"digitalSig\":\""+digitalSignature+"\"," + "\"ts\":\""+requestDTO.getTimeStamp()+"\"" + "}";

		System.out.println("EncryptedRequest: " + encryptedRequestMsg);
		  StringBuilder response = new StringBuilder();
		  try {
      	    // URL of the API endpoint
      	   URL url = new URL("https://uatsbiunipay.sbi/bbps-cou-switch/getStateList");
      	   //URL url = new URL("https://uatsbiunipay.sbi/bbps-cou-switch/getAccessToken/SB42");
        	 
      	    //URL url=new URL("https://jaisaissnidhilimited.com/api/values/PostBillDesk");
      	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      	    
      	    // Setting the request method to POST
      	    conn.setRequestMethod("POST");
      	    conn.setRequestProperty("Content-Type", "application/json; utf-8");
      	    conn.setRequestProperty("Accept", "application/json");
      	    conn.setDoOutput(true);

      	    // JSON payload
      	    String jsonInputString = encryptedRequestMsg;
      	    //String jsonInputString="{\"amt\":\"qg8lfycy0Ps=\",\"accNum\":\"QDvcz8lILVw1I6YUpkHHAw==\",\"hname\":\"v+yG16PsTsA=\",\"bal\":\"osN4bh2XAuVefhxwIn3QfQ==\",\"atype\":\"Qzwj51FVXG8=\"}";
      	    // Sending the JSON payload
      	    try (OutputStream os = conn.getOutputStream()) {
      	        byte[] input = jsonInputString.getBytes("utf-8");
      	        os.write(input, 0, input.length);
      	    }
      	// Read the response
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
              
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Response: " + response.toString());
                loginEntity.setOTP(response.toString());
            }
      	    // Reading the response
      	    int responseCode = conn.getResponseCode();
      	    System.out.println("Response Code: " + conn.getResponseMessage());
      	    
      	    // Handle the response (omitted for brevity)

      	} catch (Exception e) {
      	    
      		
      		loginEntity.setOTP(""+e.fillInStackTrace());
      		e.printStackTrace();
      	    
      	 
      	}

		// final Login1 login = new Login1();
        // model.clear();
         model.put("loginEntity3", loginEntity);
         mp.put("encryptedRequestMsg", encryptedRequestMsg);
         loginEntity.setBranch_Type("Request Id \n:"+requestId+"\n  Cipher :"+ciphertext+" \n Encripted Msg :"+encryptedRequestMsg);
         System.out.println("response.toString()="+response.toString());
         
         System.out.println("response.toString()="+response.toString());

         mp.put("OTP", response.toString());
        // mp.put("OTP1", response.toString());
         loginEntity.setOTP(response.toString());
         loginEntity.setEncryptedMsg(encryptedRequestMsg);
         //login.setOTP1(response.toString());
         
         mp.put("AesToken", loginEntity.getAesToken());
         mp.put("Rrn_No", loginEntity.getRrn_No());


       
    
    	return "loginState";
    	}
    	
    	
    	

}
    @RequestMapping(value = { "/LoginValidate3" },params="GetTokenStateList", method = { RequestMethod.POST })
    public String StateList_Token(@Valid @ModelAttribute("loginEntity3") final Login1 loginEntity, final BindingResult result, final ModelMap mp,  HttpSession session, final HttpServletRequest request, final Map<String, Object> model, final RedirectAttributes attributes) throws SQLException, ParseException, IOException {
    	{
    		String id="SB42";
    		String agentInstid="SB42";
    		String token="6ffbeb77133c15ca241565135e103a78";
    		
    		//String aesToken=loginEntity.getOTP1();
    		
    		String RRN=loginEntity.getRrn_No();
    		String aesToken=loginEntity.getAesToken();
    	
    		
    	//	String user= loginEntity.getUsername();
    	//	String pass=loginEntity.getPassword();

		EncryptedRequestDto requestDTO =new EncryptedRequestDto();
		BillFetchRequestBean decryptedRequestDto = null;

		String decryptedResponseMsg = null;
		String encryptedResponseMsg = null;

		String encryptedRequestMsg = null;
		String decryptedRequestMsg = null;
		String encryptedAesKey = null;
		String decryptedAesKey = null;

		String timeStamp = null;
		String digitalSignature = null;
		boolean isVerified = false;
		boolean isValid = false;
		String getBillerPrivate = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgboeBDYUm/hLhirbB0Jb05XJEf/ji5SUC5LuqpQhnKhX3RJ0qxdOIzhG5lv4+FN+Yi/1DvCcDN8I2AsNzLABuuoeva/qYWhrs3808jPl2PiFIPv7EeRkfKzswN40Ov/d/05jdNQ1hg6vdylhD0sig5BJtmp3jimPGhSpQgowqvdPXSYwAuj2juea8pSJSPkU1BfPWM7WJWzeoUrNptaAV3sgZ5sa3yEuYPBTJr7/uP9mCMciu9GAxOzN0+awet1RFHfPXtWgIAi9RxgrOW6jSDYI9NqleC41jQyJR/E2uvUIJ/OlqL3L6bH0/PxkOuzy+biUv0qGB97DqXRh3EUU3AgMBAAECggEAd40GEwhFMiJhZYsd114eL86PkTYf/MyvAPH8WxRyJ5Z4GfQafpY+pRKSqM85FIAvgxjGmWQrWj2BzwfOKBQhGmKL3BBGBKQYrm20HiwbdZ6k5JZ0+WoYa16m066Bwf0RbUL8BdOT7hfVyggQMDJx6Vsr1FtEzxwAcB4pwycVVn8/ZFk+maoIptb7oOrVf/A1OaiwFHrUplQFwL9bOjrnaz6sPmGStpSU6NHVkUVlH/J8V/ag2iYt9QUQiLg6/jroMQegixZAi5g3fQKQ/2oOKy+6JKfxcN982X7Zy36gULhs/VJ+SeD/+YjqfIaNJtqDpeunlSGLGG8W+4f6nUp9IQKBgQDrTc4VG7x1AS6gc9wG7xcjSUWHK0tQow8rl64Y4KAb3iyKismNtgg8qkRERhJ+ZZulr07IUZE/M+doqNmoShtpcuGguUgcKGgfaCBo4351TgVh2fslzwzhrood7O+fScgJmmT+XN3et0luwkvpD60Kol5xD0dEOabH/f1RJNpvcQKBgQCuit+QhdN5d353UAWyPEZnrQmmfDU6yP280ELU0/AmC6nghRD7dz8ZXo+LmRMuekEeNX4l0HU1LNhjmcW4El6112ZfVtt7znI7yqq7m7SYHhewJT2xrDq6m9yhGa8j2TGZNrSb+cEYv8kJcBNZMMQytHVTg6h4vA01S4KUOK97JwKBgEIRIXjZxctQXqgcf73Oqb91ljkCle35KoxB1VcU0r+gXP81QqwwXRWzdOF6jzzACLi3hTZHeLG3QBUpu5s92357DBDVlQKa8clHsjnhDiOfmXFFA/g0r1g6antGiG1ACRNxL0QgDQe4jLy1fxzcEuj2d+/kq0zjpwlmLhb3cwFxAoGAJzS4jR0SaIln1eMatHOHmQgsT8I8rqyxGjVpnabRnaonCXC6ZNHfUZKFCeVjgqAheminolTVzxD4tj63Q+aUcaIls6qt+Hxh+n5GpYePJFA2H/HtjrhSJNKX13QOfC3wTysTnKmYLzf9L2qGXhVvLLiOVikPsbcD/IGunh6xhCcCgYAvtXpHRZN2xy66d1VrMeqhfddj+lDmp0ZkbbeyZHLovk2G4jOjck0CMHffMbYoi5Up2Opi6Gn2G2roO6EvLmPt8zneEDc9NfwdbQLVc7sHk4WaaZIWHl/9kyKLjO6PrjyN+IJ/W8GhDo1aXG+3bARmnqVhHQnARx6dw610JFy34g==";
		String BouPublic = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn9/lE9HbqaS/6GqkysCZgyUkeLkxOQKiosmGt5N3JA3qit4sP0yZh9HEtZk85S9xDVLUJkCEa2SIDEIWExpEVe3CI5TN8chXh/qyH0TqoHbkfrf2xkolYZFGYM/BcGj6I3bOVKFSTkwuxVmncgLrk0q7a6e5mgAwYxy9iMB0aOM56j37oEdOzOLl8giAhxvu2AorsPxfewfwnvnFXDvSQHtcQJhJDBZOl7lW9pl0fdqD2ct9/3lip//klMnj79IOncsFJ8JHwC1dpNdJk2PxWS1nzKgHsDlIKfnWPdqI+C2DYGU1Z71mXLXynBSogQiThfUWrSHgUlRB4WPsdurfawIDAQAB";
		BouMasterDto bouMasterDTO = new BouMasterDto();
		PrivateKey privatekey=BbpsSecurityUtil.getPrivateKey(getBillerPrivate);
		
		//24-01-2025 Step=2 Get ciphertext
		//String plainMsg="{\"agentInstitutionId\":\"SB42\",\"token\":\"6ffbeb77133c15ca241565135e103a78\"}";
		String plainMsg=loginEntity.getEncryptedMsg();
	    
		PublicKey pkey=BbpsSecurityUtil.getPublicKey(BouPublic);
		String ciphertext=securityUtils.encryptRsaMessage( plainMsg,pkey);
				System.out.println("ciphertext="+ciphertext);
		//24-01-2025 Step=3 Get Timestamp
					ZonedDateTime now2 = ZonedDateTime.now();
					//DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
					DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'+05:30'");

					String formattedTimestamp = now2.format(formatter2);
					System.out.println("Formatted Timestamp: " + formattedTimestamp);
				String TokenResponseMsg=loginEntity.getOTP().replace("\"ts\"", "\"timeStamp\"");
		System.out.println("TokenResponseMsg="+TokenResponseMsg );

		EncryptedRequestDto tokenRespenseDTO =new EncryptedRequestDto();
tokenRespenseDTO = JsonConverterUtilityP.convertStringToJsonObject(TokenResponseMsg, EncryptedRequestDto.class);
String signatureReqStr1 = tokenRespenseDTO.getRrn()+tokenRespenseDTO.getTimeStamp()+tokenRespenseDTO.getCipherText();
System.out.println("signatureReqStr1="+signatureReqStr1 );

//24-01-2025 Step=7 Verify TokenResponse with digital signature
isVerified = securityUtils.verifyDigitalSignature(signatureReqStr1, tokenRespenseDTO.getDigitalSig(), pkey); //give BOU public key here
System.out.println("isVerified="+isVerified );
/*if (!isVerified)
{
	EncryptedResponseDto responseDTO = new EncryptedResponseDto();
	responseDTO.setCipherText("Invalid Digital Signature");
	encryptedResponseMsg = JsonConverterUtilityP.convertJsonObjectToString(tokenRespenseDTO);
	return "/"; //return failure response here
}*/
//24-01-2025 Step=8 Get AES Key from Response
try {
	//aesToken
	decryptedAesKey =securityUtils.decryptAesGcm(tokenRespenseDTO.getCipherText(), aesToken);
	//decryptedAesKey = securityUtils.decryptMessage( tokenRespenseDTO.getCipherText(),privatekey);
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
String accessToken = null;
try {
    ObjectMapper objectMapper = new ObjectMapper();

    // Deserialize the JSON string into the Java object (Response)
    Response response = objectMapper.readValue(decryptedAesKey, Response.class);
     // db.insertResponseData(response);
    
    insertStates(response.getStateList());
      
} catch (Exception e) {
    e.printStackTrace();
}



// Now you have the Java object
//System.out.println(response);

mp.put("signatureReqStr1", signatureReqStr1 );
//final Login1 login = new Login1();
model.put("loginEntity", loginEntity);
loginEntity.setEncryptedMsg(plainMsg);
loginEntity.setOTP(decryptedAesKey );
loginEntity.setOTP1(""+isVerified+" op="+decryptedAesKey);
loginEntity.setBranch_Type("CypherTxt :"+ciphertext+" \n signatureReqStr1 : "+signatureReqStr1);

mp.put("AesToken", loginEntity.getAesToken());
mp.put("Rrn_No", loginEntity.getRrn_No());

return "login";


    	}
    	
    	
    	
    	
    	
    	

}
    
    @RequestMapping(value = { "/LoginValidate3" },params="UpdateStateList", method = { RequestMethod.POST })
    public String UpdateStateList_Token(@Valid @ModelAttribute("loginEntity3") final Login1 loginEntity, final BindingResult result, final ModelMap mp,  HttpSession session, final HttpServletRequest request, final Map<String, Object> model, final RedirectAttributes attributes) throws SQLException, ParseException, IOException {
    	{
    		String id="SB42";
    		String agentInstid="SB42";
    		String token="6ffbeb77133c15ca241565135e103a78";
    		
    		//String aesToken=loginEntity.getOTP1();
    		
    		String RRN=loginEntity.getRrn_No();
    		String aesToken=loginEntity.getAesToken();
    	
    			String decryptedAesKey =loginEntity.getOTP();
    			
    			System.out.println(decryptedAesKey);
	
String accessToken = null;
try {
    ObjectMapper objectMapper = new ObjectMapper();

    // Deserialize the JSON string into the Java object (Response)
    Response response = objectMapper.readValue(decryptedAesKey, Response.class);
     // db.insertResponseData(response);
    List<State> stateList=response.getStateList();
    for (State state : stateList) {

        System.out.println("States ="+state.getStateName());
       
    }
    dao10.insertStates(stateList);
      
} catch (Exception e) {
    e.printStackTrace();
}



// Now you have the Java object
//System.out.println(response);


//final Login1 login = new Login1();
model.put("loginEntity", loginEntity);

loginEntity.setOTP(decryptedAesKey );

mp.put("AesToken", loginEntity.getAesToken());
mp.put("Rrn_No", loginEntity.getRrn_No());

return "login";


    	}
    	
    	
    	
    	
    	
    	

}

    
    
    
    @RequestMapping(value = { "/LoginValidate" },params="BillerList", method = { RequestMethod.POST })
    public String BillerList(@Valid @ModelAttribute("loginEntity") final Login1 loginEntity, final BindingResult result, final ModelMap mp,  HttpSession session, final HttpServletRequest request, final Map<String, Object> model, final RedirectAttributes attributes) throws SQLException, ParseException, IOException {
    	{
    		String uniqueID = UUID.randomUUID().toString();

    		String id="SB42";
    		String agentInstid="SB42";
    		String token="6ffbeb77133c15ca241565135e103a78";
    		//String aesToken=loginEntity.getOTP1();
    		
    		String RRN=loginEntity.getRrn_No();
    		String aesToken=loginEntity.getAesToken();
    		
    		String user= loginEntity.getUsername();
        		String pass=loginEntity.getPassword();

    		
		EncryptedRequestDto requestDTO =new EncryptedRequestDto();
		BillFetchRequestBean decryptedRequestDto = null;

		String decryptedResponseMsg = null;
		String encryptedResponseMsg = null;

		String encryptedRequestMsg = null;
		String decryptedRequestMsg = null;
		String encryptedAesKey = null;
		String decryptedAesKey = null;

		String timeStamp = null;
		String digitalSignature = null;
		boolean isVerified = false;
		boolean isValid = false;
		String getBillerPrivate = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgboeBDYUm/hLhirbB0Jb05XJEf/ji5SUC5LuqpQhnKhX3RJ0qxdOIzhG5lv4+FN+Yi/1DvCcDN8I2AsNzLABuuoeva/qYWhrs3808jPl2PiFIPv7EeRkfKzswN40Ov/d/05jdNQ1hg6vdylhD0sig5BJtmp3jimPGhSpQgowqvdPXSYwAuj2juea8pSJSPkU1BfPWM7WJWzeoUrNptaAV3sgZ5sa3yEuYPBTJr7/uP9mCMciu9GAxOzN0+awet1RFHfPXtWgIAi9RxgrOW6jSDYI9NqleC41jQyJR/E2uvUIJ/OlqL3L6bH0/PxkOuzy+biUv0qGB97DqXRh3EUU3AgMBAAECggEAd40GEwhFMiJhZYsd114eL86PkTYf/MyvAPH8WxRyJ5Z4GfQafpY+pRKSqM85FIAvgxjGmWQrWj2BzwfOKBQhGmKL3BBGBKQYrm20HiwbdZ6k5JZ0+WoYa16m066Bwf0RbUL8BdOT7hfVyggQMDJx6Vsr1FtEzxwAcB4pwycVVn8/ZFk+maoIptb7oOrVf/A1OaiwFHrUplQFwL9bOjrnaz6sPmGStpSU6NHVkUVlH/J8V/ag2iYt9QUQiLg6/jroMQegixZAi5g3fQKQ/2oOKy+6JKfxcN982X7Zy36gULhs/VJ+SeD/+YjqfIaNJtqDpeunlSGLGG8W+4f6nUp9IQKBgQDrTc4VG7x1AS6gc9wG7xcjSUWHK0tQow8rl64Y4KAb3iyKismNtgg8qkRERhJ+ZZulr07IUZE/M+doqNmoShtpcuGguUgcKGgfaCBo4351TgVh2fslzwzhrood7O+fScgJmmT+XN3et0luwkvpD60Kol5xD0dEOabH/f1RJNpvcQKBgQCuit+QhdN5d353UAWyPEZnrQmmfDU6yP280ELU0/AmC6nghRD7dz8ZXo+LmRMuekEeNX4l0HU1LNhjmcW4El6112ZfVtt7znI7yqq7m7SYHhewJT2xrDq6m9yhGa8j2TGZNrSb+cEYv8kJcBNZMMQytHVTg6h4vA01S4KUOK97JwKBgEIRIXjZxctQXqgcf73Oqb91ljkCle35KoxB1VcU0r+gXP81QqwwXRWzdOF6jzzACLi3hTZHeLG3QBUpu5s92357DBDVlQKa8clHsjnhDiOfmXFFA/g0r1g6antGiG1ACRNxL0QgDQe4jLy1fxzcEuj2d+/kq0zjpwlmLhb3cwFxAoGAJzS4jR0SaIln1eMatHOHmQgsT8I8rqyxGjVpnabRnaonCXC6ZNHfUZKFCeVjgqAheminolTVzxD4tj63Q+aUcaIls6qt+Hxh+n5GpYePJFA2H/HtjrhSJNKX13QOfC3wTysTnKmYLzf9L2qGXhVvLLiOVikPsbcD/IGunh6xhCcCgYAvtXpHRZN2xy66d1VrMeqhfddj+lDmp0ZkbbeyZHLovk2G4jOjck0CMHffMbYoi5Up2Opi6Gn2G2roO6EvLmPt8zneEDc9NfwdbQLVc7sHk4WaaZIWHl/9kyKLjO6PrjyN+IJ/W8GhDo1aXG+3bARmnqVhHQnARx6dw610JFy34g==";
		String BouPublic = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn9/lE9HbqaS/6GqkysCZgyUkeLkxOQKiosmGt5N3JA3qit4sP0yZh9HEtZk85S9xDVLUJkCEa2SIDEIWExpEVe3CI5TN8chXh/qyH0TqoHbkfrf2xkolYZFGYM/BcGj6I3bOVKFSTkwuxVmncgLrk0q7a6e5mgAwYxy9iMB0aOM56j37oEdOzOLl8giAhxvu2AorsPxfewfwnvnFXDvSQHtcQJhJDBZOl7lW9pl0fdqD2ct9/3lip//klMnj79IOncsFJ8JHwC1dpNdJk2PxWS1nzKgHsDlIKfnWPdqI+C2DYGU1Z71mXLXynBSogQiThfUWrSHgUlRB4WPsdurfawIDAQAB";
		BouMasterDto bouMasterDTO = new BouMasterDto();
		
		//24-01-2025 Step=2 Get ciphertext
		String plainMsg="{\"agentInstitutionId\":\"SB42\",\"token\":\"6ffbeb77133c15ca241565135e103a78\"}";
				PublicKey pkey=BbpsSecurityUtil.getPublicKey(BouPublic);
				//PublicKey aeskey=BbpsSecurityUtil.getPublicKey(aesToken);
		
				String NBCIID="OU01OU02INT522274495200721ahbcj2123";
				//----------------------------------------------------------------------------
				ZonedDateTime now2 = ZonedDateTime.now();
				DateTimeFormatter rrnform = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
				String rrnTimestamp = now2.format(rrnform);
				 NBCIID="OU01OU02INT"+rrnTimestamp+"1ahbcj2123";
				
				//--------------------------------------------------------------------------
			
		//24-01-2025 Step=3 Get Timestamp
					//ZonedDateTime now2 = ZonedDateTime.now();
					//DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
					//"yyyy-MM-dd'T'HH:mm:ss'+05:30'"
					DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'+05:30'");
					String formattedTimestamp = now2.format(formatter2);
					System.out.println("Formatted Timestamp: " + formattedTimestamp);
					//String requestId="{\"head\":{\"requestId\":\""+NBCIID+"\",\"ts\":\""+formattedTimestamp+"\"},\"search\":{\"status\":\"Active\"}}";
    	            String requestId = "{\"head\": {\"requestId\": \"" + NBCIID + "\",\"ts\":\"" + formattedTimestamp + "\"},\"search\": {\"category\": \""+user+"\",\"state\": \""+pass+"\"}}";

    	String ciphertext=securityUtils.encryptAesGcm(requestId, aesToken);
					//String ciphertext=securityUtils.encryptRsaMessage( requestId,aesToken);
					System.out.println("ciphertext="+ciphertext);
		//24-01-2025 Step=4 Generate DigitalSignature		
					requestDTO.setCipherText(ciphertext);
					requestDTO.setTimeStamp(formattedTimestamp);
					requestDTO.setRrn(RRN);
					PrivateKey privatekey=BbpsSecurityUtil.getPrivateKey(getBillerPrivate);
					 digitalSignature = securityUtils.generateDigitalSignature(requestDTO.getRrn() + requestDTO.getTimeStamp() + requestDTO.getCipherText(), privatekey);
						System.out.println("digitalSignature: " + digitalSignature);

						//24-01-2025 Step=5 Generate EncryptedRequest			

		//encryptedRequestMsg = "{" + "\"rrn\":\"SB5120210212093848ee3b04f1043344f87\"," + "\"cipherText\":\"3412C8F35979A2D92F92B7EA8A6183ECB1EDA5C896276562D80AA83F7C8C033BCCE43E2FAD9EAB5A0334CE8454392DB0DCA969469F3F5917B86335D986EE8275B87241DB1AF4A6499373DD6EA5A711EB634A7CAE352D4D3DA89D9F535A3971E12EB65058D2A001B039CE03FDEABB56C481488CC452FB117EF39D011339FAA09BD992EEA4D456FBCB877D9CA86E2D60613A48F61A99E8C3C88F6FE117ED1B0ADC83B2E406AB4075A882DD207880DDEFBBABD96A2EAEBD57BBD72BC29C1E530C11ECDB4AB1982E419840863D1A3078AF96746D1400D4A3D5AA68431E88676FB52F8B47B8F14C0000B659BA23ED7636D9FC57212922069324B991517A1912EDA7F4FA8641279A94B013F98F3DA950EC001A1E65F8A604849AFB663630BBFAA55C3885F1815EEB6B0AB94D25A00510B76A436F6E076333CD9802F83D9C0F6EE473A468C4633AB1A1F1D5C86E398197D374305CB14251CE0691E1AFBDFBE5783D20FA86D256050DE205DD90AC5CE3\"," + "\"digitalSig\":\"A7dIKgs8l8fndu7p/YNOigM5Gj32IgXiIDoYtZb0mfKW8yfWXPwYQDmMy7LYE1Vrk3c2r1eywWr7Wu1LJkyJ4RCp8H2nSjUpEpHYsaU3qV4vQyhSKWLjhEFOWcn9zqnwLaZAAd8zZCK7uorQFky02t28SOaVfcGU/3UhHxZVGXgOzJGSUVZlO6xFYnq91/GCbE9Bo9uNVENYWKtMXCPHb/8C4tYl9UMpVFurXYmUJq9U5ZJos0+JykjLUt3ly/LvCKegE6gnRuGCuvvnLi22HsDNWj3unW+ytbU9inA0gBkPaELH4fK9f3cs7U3b+A6KmX1VdJeSJVm9JAdkvGdu5A==\"," + "\"timeStamp\":\"2021-02-12T21:38:48+05:30\"" + "}";
		encryptedRequestMsg = "{" + "\"rrn\":\""+requestDTO.getRrn()+"\"," + "\"cipherText\":\""+requestDTO.getCipherText()+"\"," + "\"digitalSig\":\""+digitalSignature+"\"," + "\"ts\":\""+requestDTO.getTimeStamp()+"\"" + "}";

		System.out.println("EncryptedRequest: " + encryptedRequestMsg);
		  StringBuilder response = new StringBuilder();
		  try {
      	    // URL of the API endpoint
      	   URL url = new URL("https://uatsbiunipay.sbi/bbps-cou-switch/getBillerList");
      	   //URL url = new URL("https://uatsbiunipay.sbi/bbps-cou-switch/getAccessToken/SB42");
        	 
      	    //URL url=new URL("https://jaisaissnidhilimited.com/api/values/PostBillDesk");
      	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      	    
      	    // Setting the request method to POST
      	    conn.setRequestMethod("POST");
      	    conn.setRequestProperty("Content-Type", "application/json; utf-8");
      	    conn.setRequestProperty("Accept", "application/json");
      	    conn.setDoOutput(true);

      	    // JSON payload
      	    String jsonInputString = encryptedRequestMsg;
      	    //String jsonInputString="{\"amt\":\"qg8lfycy0Ps=\",\"accNum\":\"QDvcz8lILVw1I6YUpkHHAw==\",\"hname\":\"v+yG16PsTsA=\",\"bal\":\"osN4bh2XAuVefhxwIn3QfQ==\",\"atype\":\"Qzwj51FVXG8=\"}";
      	    // Sending the JSON payload
      	    try (OutputStream os = conn.getOutputStream()) {
      	        byte[] input = jsonInputString.getBytes("utf-8");
      	        os.write(input, 0, input.length);
      	    }
      	// Read the response
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
              
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Response: " + response.toString());
                loginEntity.setOTP(response.toString());
            }
      	    // Reading the response
      	    int responseCode = conn.getResponseCode();
      	    System.out.println("Response Code: " + conn.getResponseMessage());
      	    
      	    // Handle the response (omitted for brevity)

      	} catch (Exception e) {
      	    
      		
      		loginEntity.setOTP(""+e.fillInStackTrace());
      		e.printStackTrace();
      	    
      	 
      	}

		// final Login1 login = new Login1();
        // model.clear();
         model.put("loginEntity4", loginEntity);
         mp.put("encryptedRequestMsg", encryptedRequestMsg);
         loginEntity.setBranch_Type("Request Id \n:"+requestId+"\n  Cipher :"+ciphertext+" \n Encripted Msg :"+encryptedRequestMsg);
         System.out.println("response.toString()="+response.toString());
         
         System.out.println("response.toString()="+response.toString());

         mp.put("OTP", response.toString());
        // mp.put("OTP1", response.toString());
         loginEntity.setOTP(response.toString());
         loginEntity.setEncryptedMsg(encryptedRequestMsg);
         //login.setOTP1(response.toString());
         
         mp.put("AesToken", loginEntity.getAesToken());
         mp.put("Rrn_No", loginEntity.getRrn_No());


       
    
    	return "loginBillerList";
    	}
    	
    	
    	

}
    @RequestMapping(value = { "/LoginValidate4" },params="GetTokenBillerList", method = { RequestMethod.POST })
    public String BillerList_Token(@Valid @ModelAttribute("loginEntity4") final Login1 loginEntity, final BindingResult result, final ModelMap mp,  HttpSession session, final HttpServletRequest request, final Map<String, Object> model, final RedirectAttributes attributes) throws SQLException, ParseException, IOException {
    	{
    		String id="SB42";
    		String agentInstid="SB42";
    		String token="6ffbeb77133c15ca241565135e103a78";
    		
    		//String aesToken=loginEntity.getOTP1();
    		
    		String RRN=loginEntity.getRrn_No();
    		String aesToken=loginEntity.getAesToken();
    	
    		
    	//	String user= loginEntity.getUsername();
    	//	String pass=loginEntity.getPassword();

		EncryptedRequestDto requestDTO =new EncryptedRequestDto();
		BillFetchRequestBean decryptedRequestDto = null;

		String decryptedResponseMsg = null;
		String encryptedResponseMsg = null;

		String encryptedRequestMsg = null;
		String decryptedRequestMsg = null;
		String encryptedAesKey = null;
		String decryptedAesKey = null;

		String timeStamp = null;
		String digitalSignature = null;
		boolean isVerified = false;
		boolean isValid = false;
		String getBillerPrivate = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgboeBDYUm/hLhirbB0Jb05XJEf/ji5SUC5LuqpQhnKhX3RJ0qxdOIzhG5lv4+FN+Yi/1DvCcDN8I2AsNzLABuuoeva/qYWhrs3808jPl2PiFIPv7EeRkfKzswN40Ov/d/05jdNQ1hg6vdylhD0sig5BJtmp3jimPGhSpQgowqvdPXSYwAuj2juea8pSJSPkU1BfPWM7WJWzeoUrNptaAV3sgZ5sa3yEuYPBTJr7/uP9mCMciu9GAxOzN0+awet1RFHfPXtWgIAi9RxgrOW6jSDYI9NqleC41jQyJR/E2uvUIJ/OlqL3L6bH0/PxkOuzy+biUv0qGB97DqXRh3EUU3AgMBAAECggEAd40GEwhFMiJhZYsd114eL86PkTYf/MyvAPH8WxRyJ5Z4GfQafpY+pRKSqM85FIAvgxjGmWQrWj2BzwfOKBQhGmKL3BBGBKQYrm20HiwbdZ6k5JZ0+WoYa16m066Bwf0RbUL8BdOT7hfVyggQMDJx6Vsr1FtEzxwAcB4pwycVVn8/ZFk+maoIptb7oOrVf/A1OaiwFHrUplQFwL9bOjrnaz6sPmGStpSU6NHVkUVlH/J8V/ag2iYt9QUQiLg6/jroMQegixZAi5g3fQKQ/2oOKy+6JKfxcN982X7Zy36gULhs/VJ+SeD/+YjqfIaNJtqDpeunlSGLGG8W+4f6nUp9IQKBgQDrTc4VG7x1AS6gc9wG7xcjSUWHK0tQow8rl64Y4KAb3iyKismNtgg8qkRERhJ+ZZulr07IUZE/M+doqNmoShtpcuGguUgcKGgfaCBo4351TgVh2fslzwzhrood7O+fScgJmmT+XN3et0luwkvpD60Kol5xD0dEOabH/f1RJNpvcQKBgQCuit+QhdN5d353UAWyPEZnrQmmfDU6yP280ELU0/AmC6nghRD7dz8ZXo+LmRMuekEeNX4l0HU1LNhjmcW4El6112ZfVtt7znI7yqq7m7SYHhewJT2xrDq6m9yhGa8j2TGZNrSb+cEYv8kJcBNZMMQytHVTg6h4vA01S4KUOK97JwKBgEIRIXjZxctQXqgcf73Oqb91ljkCle35KoxB1VcU0r+gXP81QqwwXRWzdOF6jzzACLi3hTZHeLG3QBUpu5s92357DBDVlQKa8clHsjnhDiOfmXFFA/g0r1g6antGiG1ACRNxL0QgDQe4jLy1fxzcEuj2d+/kq0zjpwlmLhb3cwFxAoGAJzS4jR0SaIln1eMatHOHmQgsT8I8rqyxGjVpnabRnaonCXC6ZNHfUZKFCeVjgqAheminolTVzxD4tj63Q+aUcaIls6qt+Hxh+n5GpYePJFA2H/HtjrhSJNKX13QOfC3wTysTnKmYLzf9L2qGXhVvLLiOVikPsbcD/IGunh6xhCcCgYAvtXpHRZN2xy66d1VrMeqhfddj+lDmp0ZkbbeyZHLovk2G4jOjck0CMHffMbYoi5Up2Opi6Gn2G2roO6EvLmPt8zneEDc9NfwdbQLVc7sHk4WaaZIWHl/9kyKLjO6PrjyN+IJ/W8GhDo1aXG+3bARmnqVhHQnARx6dw610JFy34g==";
		String BouPublic = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn9/lE9HbqaS/6GqkysCZgyUkeLkxOQKiosmGt5N3JA3qit4sP0yZh9HEtZk85S9xDVLUJkCEa2SIDEIWExpEVe3CI5TN8chXh/qyH0TqoHbkfrf2xkolYZFGYM/BcGj6I3bOVKFSTkwuxVmncgLrk0q7a6e5mgAwYxy9iMB0aOM56j37oEdOzOLl8giAhxvu2AorsPxfewfwnvnFXDvSQHtcQJhJDBZOl7lW9pl0fdqD2ct9/3lip//klMnj79IOncsFJ8JHwC1dpNdJk2PxWS1nzKgHsDlIKfnWPdqI+C2DYGU1Z71mXLXynBSogQiThfUWrSHgUlRB4WPsdurfawIDAQAB";
		BouMasterDto bouMasterDTO = new BouMasterDto();
		PrivateKey privatekey=BbpsSecurityUtil.getPrivateKey(getBillerPrivate);
		
		//24-01-2025 Step=2 Get ciphertext
		//String plainMsg="{\"agentInstitutionId\":\"SB42\",\"token\":\"6ffbeb77133c15ca241565135e103a78\"}";
		String plainMsg=loginEntity.getEncryptedMsg();
	    
		PublicKey pkey=BbpsSecurityUtil.getPublicKey(BouPublic);
		String ciphertext=securityUtils.encryptRsaMessage( plainMsg,pkey);
				System.out.println("ciphertext="+ciphertext);
		//24-01-2025 Step=3 Get Timestamp
					ZonedDateTime now2 = ZonedDateTime.now();
					//DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
					DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'+05:30'");

					String formattedTimestamp = now2.format(formatter2);
					System.out.println("Formatted Timestamp: " + formattedTimestamp);
				String TokenResponseMsg=loginEntity.getOTP().replace("\"ts\"", "\"timeStamp\"");
		System.out.println("TokenResponseMsg="+TokenResponseMsg );

		EncryptedRequestDto tokenRespenseDTO =new EncryptedRequestDto();
tokenRespenseDTO = JsonConverterUtilityP.convertStringToJsonObject(TokenResponseMsg, EncryptedRequestDto.class);
String signatureReqStr1 = tokenRespenseDTO.getRrn()+tokenRespenseDTO.getTimeStamp()+tokenRespenseDTO.getCipherText();
System.out.println("signatureReqStr1="+signatureReqStr1 );

//24-01-2025 Step=7 Verify TokenResponse with digital signature
isVerified = securityUtils.verifyDigitalSignature(signatureReqStr1, tokenRespenseDTO.getDigitalSig(), pkey); //give BOU public key here
System.out.println("isVerified="+isVerified );
/*if (!isVerified)
{
	EncryptedResponseDto responseDTO = new EncryptedResponseDto();
	responseDTO.setCipherText("Invalid Digital Signature");
	encryptedResponseMsg = JsonConverterUtilityP.convertJsonObjectToString(tokenRespenseDTO);
	return "/"; //return failure response here
}*/
//24-01-2025 Step=8 Get AES Key from Response
try {
	//aesToken
	decryptedAesKey =securityUtils.decryptAesGcm(tokenRespenseDTO.getCipherText(), aesToken);
	//decryptedAesKey = securityUtils.decryptMessage( tokenRespenseDTO.getCipherText(),privatekey);
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
String accessToken = null;
try {
    ObjectMapper objectMapper = new ObjectMapper();

    // Deserialize the JSON string into the Java object (Response)
    Response response = objectMapper.readValue(decryptedAesKey, Response.class);
     // db.insertResponseData(response);
    
   // insertStates(response.getStateList());
      
} catch (Exception e) {
    e.printStackTrace();
}



// Now you have the Java object
//System.out.println(response);

mp.put("signatureReqStr1", signatureReqStr1 );
//final Login1 login = new Login1();
model.put("loginEntity", loginEntity);
loginEntity.setEncryptedMsg(plainMsg);
loginEntity.setOTP(decryptedAesKey );
loginEntity.setOTP1(""+isVerified+" op="+decryptedAesKey);
loginEntity.setBranch_Type("CypherTxt :"+ciphertext+" \n signatureReqStr1 : "+signatureReqStr1);

mp.put("AesToken", loginEntity.getAesToken());
mp.put("Rrn_No", loginEntity.getRrn_No());

return "login";


    	}
    	
    	
    	
    	
    	
    	

}
    
    
    
    @RequestMapping(value = { "/LoginValidate" },params="BillerDetails", method = { RequestMethod.POST })
    public String BillerDetails(@Valid @ModelAttribute("loginEntity") final Login1 loginEntity, final BindingResult result, final ModelMap mp,  HttpSession session, final HttpServletRequest request, final Map<String, Object> model, final RedirectAttributes attributes) throws SQLException, ParseException, IOException {
    	{
    		String uniqueID = UUID.randomUUID().toString();

    		String id="SB42";
    		String agentInstid="SB42";
    		String token="6ffbeb77133c15ca241565135e103a78";
    		//String aesToken=loginEntity.getOTP1();
    		
    		String RRN=loginEntity.getRrn_No();
    		String aesToken=loginEntity.getAesToken();
    		
    		//String user= loginEntity.getUsername();
        	//	String pass=loginEntity.getPassword();
        		
        		String billerId=loginEntity.getAgentId();


    		
		EncryptedRequestDto requestDTO =new EncryptedRequestDto();
		BillFetchRequestBean decryptedRequestDto = null;

		String decryptedResponseMsg = null;
		String encryptedResponseMsg = null;

		String encryptedRequestMsg = null;
		String decryptedRequestMsg = null;
		String encryptedAesKey = null;
		String decryptedAesKey = null;

		String timeStamp = null;
		String digitalSignature = null;
		boolean isVerified = false;
		boolean isValid = false;
		String getBillerPrivate = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgboeBDYUm/hLhirbB0Jb05XJEf/ji5SUC5LuqpQhnKhX3RJ0qxdOIzhG5lv4+FN+Yi/1DvCcDN8I2AsNzLABuuoeva/qYWhrs3808jPl2PiFIPv7EeRkfKzswN40Ov/d/05jdNQ1hg6vdylhD0sig5BJtmp3jimPGhSpQgowqvdPXSYwAuj2juea8pSJSPkU1BfPWM7WJWzeoUrNptaAV3sgZ5sa3yEuYPBTJr7/uP9mCMciu9GAxOzN0+awet1RFHfPXtWgIAi9RxgrOW6jSDYI9NqleC41jQyJR/E2uvUIJ/OlqL3L6bH0/PxkOuzy+biUv0qGB97DqXRh3EUU3AgMBAAECggEAd40GEwhFMiJhZYsd114eL86PkTYf/MyvAPH8WxRyJ5Z4GfQafpY+pRKSqM85FIAvgxjGmWQrWj2BzwfOKBQhGmKL3BBGBKQYrm20HiwbdZ6k5JZ0+WoYa16m066Bwf0RbUL8BdOT7hfVyggQMDJx6Vsr1FtEzxwAcB4pwycVVn8/ZFk+maoIptb7oOrVf/A1OaiwFHrUplQFwL9bOjrnaz6sPmGStpSU6NHVkUVlH/J8V/ag2iYt9QUQiLg6/jroMQegixZAi5g3fQKQ/2oOKy+6JKfxcN982X7Zy36gULhs/VJ+SeD/+YjqfIaNJtqDpeunlSGLGG8W+4f6nUp9IQKBgQDrTc4VG7x1AS6gc9wG7xcjSUWHK0tQow8rl64Y4KAb3iyKismNtgg8qkRERhJ+ZZulr07IUZE/M+doqNmoShtpcuGguUgcKGgfaCBo4351TgVh2fslzwzhrood7O+fScgJmmT+XN3et0luwkvpD60Kol5xD0dEOabH/f1RJNpvcQKBgQCuit+QhdN5d353UAWyPEZnrQmmfDU6yP280ELU0/AmC6nghRD7dz8ZXo+LmRMuekEeNX4l0HU1LNhjmcW4El6112ZfVtt7znI7yqq7m7SYHhewJT2xrDq6m9yhGa8j2TGZNrSb+cEYv8kJcBNZMMQytHVTg6h4vA01S4KUOK97JwKBgEIRIXjZxctQXqgcf73Oqb91ljkCle35KoxB1VcU0r+gXP81QqwwXRWzdOF6jzzACLi3hTZHeLG3QBUpu5s92357DBDVlQKa8clHsjnhDiOfmXFFA/g0r1g6antGiG1ACRNxL0QgDQe4jLy1fxzcEuj2d+/kq0zjpwlmLhb3cwFxAoGAJzS4jR0SaIln1eMatHOHmQgsT8I8rqyxGjVpnabRnaonCXC6ZNHfUZKFCeVjgqAheminolTVzxD4tj63Q+aUcaIls6qt+Hxh+n5GpYePJFA2H/HtjrhSJNKX13QOfC3wTysTnKmYLzf9L2qGXhVvLLiOVikPsbcD/IGunh6xhCcCgYAvtXpHRZN2xy66d1VrMeqhfddj+lDmp0ZkbbeyZHLovk2G4jOjck0CMHffMbYoi5Up2Opi6Gn2G2roO6EvLmPt8zneEDc9NfwdbQLVc7sHk4WaaZIWHl/9kyKLjO6PrjyN+IJ/W8GhDo1aXG+3bARmnqVhHQnARx6dw610JFy34g==";
		String BouPublic = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn9/lE9HbqaS/6GqkysCZgyUkeLkxOQKiosmGt5N3JA3qit4sP0yZh9HEtZk85S9xDVLUJkCEa2SIDEIWExpEVe3CI5TN8chXh/qyH0TqoHbkfrf2xkolYZFGYM/BcGj6I3bOVKFSTkwuxVmncgLrk0q7a6e5mgAwYxy9iMB0aOM56j37oEdOzOLl8giAhxvu2AorsPxfewfwnvnFXDvSQHtcQJhJDBZOl7lW9pl0fdqD2ct9/3lip//klMnj79IOncsFJ8JHwC1dpNdJk2PxWS1nzKgHsDlIKfnWPdqI+C2DYGU1Z71mXLXynBSogQiThfUWrSHgUlRB4WPsdurfawIDAQAB";
		BouMasterDto bouMasterDTO = new BouMasterDto();
		
		//24-01-2025 Step=2 Get ciphertext
		String plainMsg="{\"agentInstitutionId\":\"SB42\",\"token\":\"6ffbeb77133c15ca241565135e103a78\"}";
				PublicKey pkey=BbpsSecurityUtil.getPublicKey(BouPublic);
				//PublicKey aeskey=BbpsSecurityUtil.getPublicKey(aesToken);
		
				String NBCIID="OU01OU02INT522274495200721ahbcj2123";
				//----------------------------------------------------------------------------
				ZonedDateTime now2 = ZonedDateTime.now();
				DateTimeFormatter rrnform = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
				String rrnTimestamp = now2.format(rrnform);
				 NBCIID="OU01OU02INT"+rrnTimestamp+"1ahbcj2123";
				
				//--------------------------------------------------------------------------
			
		//24-01-2025 Step=3 Get Timestamp
					//ZonedDateTime now2 = ZonedDateTime.now();
					//DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
					//"yyyy-MM-dd'T'HH:mm:ss'+05:30'"
					DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'+05:30'");
					String formattedTimestamp = now2.format(formatter2);
					System.out.println("Formatted Timestamp: " + formattedTimestamp);
					//String requestId="{\"head\":{\"requestId\":\""+NBCIID+"\",\"ts\":\""+formattedTimestamp+"\"},\"search\":{\"status\":\"Active\"}}";
					String requestId="{\"head\":{\"requestId\":\""+NBCIID+"\",\"ts\":\""+formattedTimestamp+"\"},\"billerId\":\""+billerId+"\"}";

    	String ciphertext=securityUtils.encryptAesGcm(requestId, aesToken);
					//String ciphertext=securityUtils.encryptRsaMessage( requestId,aesToken);
					System.out.println("ciphertext="+ciphertext);
		//24-01-2025 Step=4 Generate DigitalSignature		
					requestDTO.setCipherText(ciphertext);
					requestDTO.setTimeStamp(formattedTimestamp);
					requestDTO.setRrn(RRN);
					PrivateKey privatekey=BbpsSecurityUtil.getPrivateKey(getBillerPrivate);
					 digitalSignature = securityUtils.generateDigitalSignature(requestDTO.getRrn() + requestDTO.getTimeStamp() + requestDTO.getCipherText(), privatekey);
						System.out.println("digitalSignature: " + digitalSignature);

						//24-01-2025 Step=5 Generate EncryptedRequest			

		//encryptedRequestMsg = "{" + "\"rrn\":\"SB5120210212093848ee3b04f1043344f87\"," + "\"cipherText\":\"3412C8F35979A2D92F92B7EA8A6183ECB1EDA5C896276562D80AA83F7C8C033BCCE43E2FAD9EAB5A0334CE8454392DB0DCA969469F3F5917B86335D986EE8275B87241DB1AF4A6499373DD6EA5A711EB634A7CAE352D4D3DA89D9F535A3971E12EB65058D2A001B039CE03FDEABB56C481488CC452FB117EF39D011339FAA09BD992EEA4D456FBCB877D9CA86E2D60613A48F61A99E8C3C88F6FE117ED1B0ADC83B2E406AB4075A882DD207880DDEFBBABD96A2EAEBD57BBD72BC29C1E530C11ECDB4AB1982E419840863D1A3078AF96746D1400D4A3D5AA68431E88676FB52F8B47B8F14C0000B659BA23ED7636D9FC57212922069324B991517A1912EDA7F4FA8641279A94B013F98F3DA950EC001A1E65F8A604849AFB663630BBFAA55C3885F1815EEB6B0AB94D25A00510B76A436F6E076333CD9802F83D9C0F6EE473A468C4633AB1A1F1D5C86E398197D374305CB14251CE0691E1AFBDFBE5783D20FA86D256050DE205DD90AC5CE3\"," + "\"digitalSig\":\"A7dIKgs8l8fndu7p/YNOigM5Gj32IgXiIDoYtZb0mfKW8yfWXPwYQDmMy7LYE1Vrk3c2r1eywWr7Wu1LJkyJ4RCp8H2nSjUpEpHYsaU3qV4vQyhSKWLjhEFOWcn9zqnwLaZAAd8zZCK7uorQFky02t28SOaVfcGU/3UhHxZVGXgOzJGSUVZlO6xFYnq91/GCbE9Bo9uNVENYWKtMXCPHb/8C4tYl9UMpVFurXYmUJq9U5ZJos0+JykjLUt3ly/LvCKegE6gnRuGCuvvnLi22HsDNWj3unW+ytbU9inA0gBkPaELH4fK9f3cs7U3b+A6KmX1VdJeSJVm9JAdkvGdu5A==\"," + "\"timeStamp\":\"2021-02-12T21:38:48+05:30\"" + "}";
		encryptedRequestMsg = "{" + "\"rrn\":\""+requestDTO.getRrn()+"\"," + "\"cipherText\":\""+requestDTO.getCipherText()+"\"," + "\"digitalSig\":\""+digitalSignature+"\"," + "\"ts\":\""+requestDTO.getTimeStamp()+"\"" + "}";

		System.out.println("EncryptedRequest: " + encryptedRequestMsg);
		  StringBuilder response = new StringBuilder();
		  try {
      	    // URL of the API endpoint
			  URL url = new URL("https://uatsbiunipay.sbi/bbps-cou-switch/getBillerDetails");
      	   //URL url = new URL("https://uatsbiunipay.sbi/bbps-cou-switch/getAccessToken/SB42");
        	 
      	    //URL url=new URL("https://jaisaissnidhilimited.com/api/values/PostBillDesk");
      	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      	    
      	    // Setting the request method to POST
      	    conn.setRequestMethod("POST");
      	    conn.setRequestProperty("Content-Type", "application/json; utf-8");
      	    conn.setRequestProperty("Accept", "application/json");
      	    conn.setDoOutput(true);

      	    // JSON payload
      	    String jsonInputString = encryptedRequestMsg;
      	    //String jsonInputString="{\"amt\":\"qg8lfycy0Ps=\",\"accNum\":\"QDvcz8lILVw1I6YUpkHHAw==\",\"hname\":\"v+yG16PsTsA=\",\"bal\":\"osN4bh2XAuVefhxwIn3QfQ==\",\"atype\":\"Qzwj51FVXG8=\"}";
      	    // Sending the JSON payload
      	    try (OutputStream os = conn.getOutputStream()) {
      	        byte[] input = jsonInputString.getBytes("utf-8");
      	        os.write(input, 0, input.length);
      	    }
      	// Read the response
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
              
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Response: " + response.toString());
                loginEntity.setOTP(response.toString());
            }
      	    // Reading the response
      	    int responseCode = conn.getResponseCode();
      	    System.out.println("Response Code: " + conn.getResponseMessage());
      	    
      	    // Handle the response (omitted for brevity)

      	} catch (Exception e) {
      	    
      		
      		loginEntity.setOTP(""+e.fillInStackTrace());
      		e.printStackTrace();
      	    
      	 
      	}

		// final Login1 login = new Login1();
        // model.clear();
         model.put("loginEntity5", loginEntity);
         mp.put("encryptedRequestMsg", encryptedRequestMsg);
         loginEntity.setBranch_Type("Request Id \n:"+requestId+"\n  Cipher :"+ciphertext+" \n Encripted Msg :"+encryptedRequestMsg);
         System.out.println("response.toString()="+response.toString());
         
         System.out.println("response.toString()="+response.toString());

         mp.put("OTP", response.toString());
        // mp.put("OTP1", response.toString());
         loginEntity.setOTP(response.toString());
         loginEntity.setEncryptedMsg(encryptedRequestMsg);
         //login.setOTP1(response.toString());
         
         mp.put("AesToken", loginEntity.getAesToken());
         mp.put("Rrn_No", loginEntity.getRrn_No());


       
    
    	return "loginBillerDetails";
    	}
    	
    	
    	

}
    @RequestMapping(value = { "/LoginValidate5" },params="GetTokenBillerDetails", method = { RequestMethod.POST })
    public String BillerDetails_Token(@Valid @ModelAttribute("loginEntity5") final Login1 loginEntity, final BindingResult result, final ModelMap mp,  HttpSession session, final HttpServletRequest request, final Map<String, Object> model, final RedirectAttributes attributes) throws SQLException, ParseException, IOException {
    	{
    		

    		String id="SB42";
    		String agentInstid="SB42";
    		String token="6ffbeb77133c15ca241565135e103a78";
    		
    		//String aesToken=loginEntity.getOTP1();
    		
    		String RRN=loginEntity.getRrn_No();
    		String aesToken=loginEntity.getAesToken();
    	
    		
    	//	String user= loginEntity.getUsername();
    	//	String pass=loginEntity.getPassword();

		EncryptedRequestDto requestDTO =new EncryptedRequestDto();
		BillFetchRequestBean decryptedRequestDto = null;

		String decryptedResponseMsg = null;
		String encryptedResponseMsg = null;

		String encryptedRequestMsg = null;
		String decryptedRequestMsg = null;
		String encryptedAesKey = null;
		String decryptedAesKey = null;

		String timeStamp = null;
		String digitalSignature = null;
		boolean isVerified = false;
		boolean isValid = false;
		String getBillerPrivate = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgboeBDYUm/hLhirbB0Jb05XJEf/ji5SUC5LuqpQhnKhX3RJ0qxdOIzhG5lv4+FN+Yi/1DvCcDN8I2AsNzLABuuoeva/qYWhrs3808jPl2PiFIPv7EeRkfKzswN40Ov/d/05jdNQ1hg6vdylhD0sig5BJtmp3jimPGhSpQgowqvdPXSYwAuj2juea8pSJSPkU1BfPWM7WJWzeoUrNptaAV3sgZ5sa3yEuYPBTJr7/uP9mCMciu9GAxOzN0+awet1RFHfPXtWgIAi9RxgrOW6jSDYI9NqleC41jQyJR/E2uvUIJ/OlqL3L6bH0/PxkOuzy+biUv0qGB97DqXRh3EUU3AgMBAAECggEAd40GEwhFMiJhZYsd114eL86PkTYf/MyvAPH8WxRyJ5Z4GfQafpY+pRKSqM85FIAvgxjGmWQrWj2BzwfOKBQhGmKL3BBGBKQYrm20HiwbdZ6k5JZ0+WoYa16m066Bwf0RbUL8BdOT7hfVyggQMDJx6Vsr1FtEzxwAcB4pwycVVn8/ZFk+maoIptb7oOrVf/A1OaiwFHrUplQFwL9bOjrnaz6sPmGStpSU6NHVkUVlH/J8V/ag2iYt9QUQiLg6/jroMQegixZAi5g3fQKQ/2oOKy+6JKfxcN982X7Zy36gULhs/VJ+SeD/+YjqfIaNJtqDpeunlSGLGG8W+4f6nUp9IQKBgQDrTc4VG7x1AS6gc9wG7xcjSUWHK0tQow8rl64Y4KAb3iyKismNtgg8qkRERhJ+ZZulr07IUZE/M+doqNmoShtpcuGguUgcKGgfaCBo4351TgVh2fslzwzhrood7O+fScgJmmT+XN3et0luwkvpD60Kol5xD0dEOabH/f1RJNpvcQKBgQCuit+QhdN5d353UAWyPEZnrQmmfDU6yP280ELU0/AmC6nghRD7dz8ZXo+LmRMuekEeNX4l0HU1LNhjmcW4El6112ZfVtt7znI7yqq7m7SYHhewJT2xrDq6m9yhGa8j2TGZNrSb+cEYv8kJcBNZMMQytHVTg6h4vA01S4KUOK97JwKBgEIRIXjZxctQXqgcf73Oqb91ljkCle35KoxB1VcU0r+gXP81QqwwXRWzdOF6jzzACLi3hTZHeLG3QBUpu5s92357DBDVlQKa8clHsjnhDiOfmXFFA/g0r1g6antGiG1ACRNxL0QgDQe4jLy1fxzcEuj2d+/kq0zjpwlmLhb3cwFxAoGAJzS4jR0SaIln1eMatHOHmQgsT8I8rqyxGjVpnabRnaonCXC6ZNHfUZKFCeVjgqAheminolTVzxD4tj63Q+aUcaIls6qt+Hxh+n5GpYePJFA2H/HtjrhSJNKX13QOfC3wTysTnKmYLzf9L2qGXhVvLLiOVikPsbcD/IGunh6xhCcCgYAvtXpHRZN2xy66d1VrMeqhfddj+lDmp0ZkbbeyZHLovk2G4jOjck0CMHffMbYoi5Up2Opi6Gn2G2roO6EvLmPt8zneEDc9NfwdbQLVc7sHk4WaaZIWHl/9kyKLjO6PrjyN+IJ/W8GhDo1aXG+3bARmnqVhHQnARx6dw610JFy34g==";
		String BouPublic = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn9/lE9HbqaS/6GqkysCZgyUkeLkxOQKiosmGt5N3JA3qit4sP0yZh9HEtZk85S9xDVLUJkCEa2SIDEIWExpEVe3CI5TN8chXh/qyH0TqoHbkfrf2xkolYZFGYM/BcGj6I3bOVKFSTkwuxVmncgLrk0q7a6e5mgAwYxy9iMB0aOM56j37oEdOzOLl8giAhxvu2AorsPxfewfwnvnFXDvSQHtcQJhJDBZOl7lW9pl0fdqD2ct9/3lip//klMnj79IOncsFJ8JHwC1dpNdJk2PxWS1nzKgHsDlIKfnWPdqI+C2DYGU1Z71mXLXynBSogQiThfUWrSHgUlRB4WPsdurfawIDAQAB";
		BouMasterDto bouMasterDTO = new BouMasterDto();
		PrivateKey privatekey=BbpsSecurityUtil.getPrivateKey(getBillerPrivate);
		
		//24-01-2025 Step=2 Get ciphertext
		//String plainMsg="{\"agentInstitutionId\":\"SB42\",\"token\":\"6ffbeb77133c15ca241565135e103a78\"}";
		String plainMsg=loginEntity.getEncryptedMsg();
	    
		PublicKey pkey=BbpsSecurityUtil.getPublicKey(BouPublic);
		String ciphertext=securityUtils.encryptRsaMessage( plainMsg,pkey);
				System.out.println("ciphertext="+ciphertext);
		//24-01-2025 Step=3 Get Timestamp
					ZonedDateTime now2 = ZonedDateTime.now();
					//DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
					DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'+05:30'");

					String formattedTimestamp = now2.format(formatter2);
					System.out.println("Formatted Timestamp: " + formattedTimestamp);
				String TokenResponseMsg=loginEntity.getOTP().replace("\"ts\"", "\"timeStamp\"");
		System.out.println("TokenResponseMsg="+TokenResponseMsg );

		EncryptedRequestDto tokenRespenseDTO =new EncryptedRequestDto();
tokenRespenseDTO = JsonConverterUtilityP.convertStringToJsonObject(TokenResponseMsg, EncryptedRequestDto.class);
String signatureReqStr1 = tokenRespenseDTO.getRrn()+tokenRespenseDTO.getTimeStamp()+tokenRespenseDTO.getCipherText();
System.out.println("signatureReqStr1="+signatureReqStr1 );

//24-01-2025 Step=7 Verify TokenResponse with digital signature
isVerified = securityUtils.verifyDigitalSignature(signatureReqStr1, tokenRespenseDTO.getDigitalSig(), pkey); //give BOU public key here
System.out.println("isVerified="+isVerified );
/*if (!isVerified)
{
	EncryptedResponseDto responseDTO = new EncryptedResponseDto();
	responseDTO.setCipherText("Invalid Digital Signature");
	encryptedResponseMsg = JsonConverterUtilityP.convertJsonObjectToString(tokenRespenseDTO);
	return "/"; //return failure response here
}*/
//24-01-2025 Step=8 Get AES Key from Response
try {
	//aesToken
	decryptedAesKey =securityUtils.decryptAesGcm(tokenRespenseDTO.getCipherText(), aesToken);
	//decryptedAesKey = securityUtils.decryptMessage( tokenRespenseDTO.getCipherText(),privatekey);
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
String accessToken = null;
try {
    ObjectMapper objectMapper = new ObjectMapper();

    // Deserialize the JSON string into the Java object (Response)
    Response response = objectMapper.readValue(decryptedAesKey, Response.class);
     // db.insertResponseData(response);
    
   // insertStates(response.getStateList());
      
} catch (Exception e) {
    e.printStackTrace();
}



// Now you have the Java object
//System.out.println(response);

mp.put("signatureReqStr1", signatureReqStr1 );
//final Login1 login = new Login1();
model.put("loginEntity", loginEntity);
loginEntity.setEncryptedMsg(plainMsg);
loginEntity.setOTP(decryptedAesKey );
loginEntity.setOTP1(""+isVerified+" op="+decryptedAesKey);
loginEntity.setBranch_Type("CypherTxt :"+ciphertext+" \n signatureReqStr1 : "+signatureReqStr1);

mp.put("AesToken", loginEntity.getAesToken());
mp.put("Rrn_No", loginEntity.getRrn_No());

return "login";


    	
    	}
    	
    	
    	
    	
    	
    	

}



    public static void insertStates(List<State> stateList) {
        String insertQuery = "INSERT INTO states2 (state_name) VALUES (?)";
        
        
        for (State state : stateList) {

            System.out.println("States inserted successfully!"+state.getStateName());
           
        }
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(insertQuery)) {

            // Disable auto-commit for batch processing
            conn.setAutoCommit(false);

            // Add each state to the batch
            for (State state : stateList) {
                stmt.setString(1, state.getStateName());

                System.out.println("States inserted successfully!"+state.getStateName());
                stmt.addBatch();  // Add to batch
            }

            // Execute batch insert
            stmt.executeBatch();

            // Commit the transaction
            conn.commit();

            System.out.println("States inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    
    @RequestMapping(value = { "/ServiceList" }, method = { RequestMethod.GET })
    public String ServiceList(@Valid @ModelAttribute("loginEntity") final Login1 loginEntity, final BindingResult result, final ModelMap mp, HttpSession session, final HttpServletRequest request, final Map<String, Object> model, final RedirectAttributes attributes) throws SQLException, ParseException, IOException {
    	{
    		String id="SB42";
    		String agentInstid="SB42";
    		String token="6ffbeb77133c15ca241565135e103a78";
    		
    		
		EncryptedRequestDto requestDTO =new EncryptedRequestDto();
		BillFetchRequestBean decryptedRequestDto = null;

		String decryptedResponseMsg = null;
		String encryptedResponseMsg = null;

		String encryptedRequestMsg = null;
		String decryptedRequestMsg = null;
		String encryptedAesKey = null;
		String decryptedAesKey = null;

		String timeStamp = null;
		String digitalSignature = null;
		boolean isVerified = false;
		boolean isValid = false;
		String getBillerPrivate = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgboeBDYUm/hLhirbB0Jb05XJEf/ji5SUC5LuqpQhnKhX3RJ0qxdOIzhG5lv4+FN+Yi/1DvCcDN8I2AsNzLABuuoeva/qYWhrs3808jPl2PiFIPv7EeRkfKzswN40Ov/d/05jdNQ1hg6vdylhD0sig5BJtmp3jimPGhSpQgowqvdPXSYwAuj2juea8pSJSPkU1BfPWM7WJWzeoUrNptaAV3sgZ5sa3yEuYPBTJr7/uP9mCMciu9GAxOzN0+awet1RFHfPXtWgIAi9RxgrOW6jSDYI9NqleC41jQyJR/E2uvUIJ/OlqL3L6bH0/PxkOuzy+biUv0qGB97DqXRh3EUU3AgMBAAECggEAd40GEwhFMiJhZYsd114eL86PkTYf/MyvAPH8WxRyJ5Z4GfQafpY+pRKSqM85FIAvgxjGmWQrWj2BzwfOKBQhGmKL3BBGBKQYrm20HiwbdZ6k5JZ0+WoYa16m066Bwf0RbUL8BdOT7hfVyggQMDJx6Vsr1FtEzxwAcB4pwycVVn8/ZFk+maoIptb7oOrVf/A1OaiwFHrUplQFwL9bOjrnaz6sPmGStpSU6NHVkUVlH/J8V/ag2iYt9QUQiLg6/jroMQegixZAi5g3fQKQ/2oOKy+6JKfxcN982X7Zy36gULhs/VJ+SeD/+YjqfIaNJtqDpeunlSGLGG8W+4f6nUp9IQKBgQDrTc4VG7x1AS6gc9wG7xcjSUWHK0tQow8rl64Y4KAb3iyKismNtgg8qkRERhJ+ZZulr07IUZE/M+doqNmoShtpcuGguUgcKGgfaCBo4351TgVh2fslzwzhrood7O+fScgJmmT+XN3et0luwkvpD60Kol5xD0dEOabH/f1RJNpvcQKBgQCuit+QhdN5d353UAWyPEZnrQmmfDU6yP280ELU0/AmC6nghRD7dz8ZXo+LmRMuekEeNX4l0HU1LNhjmcW4El6112ZfVtt7znI7yqq7m7SYHhewJT2xrDq6m9yhGa8j2TGZNrSb+cEYv8kJcBNZMMQytHVTg6h4vA01S4KUOK97JwKBgEIRIXjZxctQXqgcf73Oqb91ljkCle35KoxB1VcU0r+gXP81QqwwXRWzdOF6jzzACLi3hTZHeLG3QBUpu5s92357DBDVlQKa8clHsjnhDiOfmXFFA/g0r1g6antGiG1ACRNxL0QgDQe4jLy1fxzcEuj2d+/kq0zjpwlmLhb3cwFxAoGAJzS4jR0SaIln1eMatHOHmQgsT8I8rqyxGjVpnabRnaonCXC6ZNHfUZKFCeVjgqAheminolTVzxD4tj63Q+aUcaIls6qt+Hxh+n5GpYePJFA2H/HtjrhSJNKX13QOfC3wTysTnKmYLzf9L2qGXhVvLLiOVikPsbcD/IGunh6xhCcCgYAvtXpHRZN2xy66d1VrMeqhfddj+lDmp0ZkbbeyZHLovk2G4jOjck0CMHffMbYoi5Up2Opi6Gn2G2roO6EvLmPt8zneEDc9NfwdbQLVc7sHk4WaaZIWHl/9kyKLjO6PrjyN+IJ/W8GhDo1aXG+3bARmnqVhHQnARx6dw610JFy34g==";
		String BouPublic = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn9/lE9HbqaS/6GqkysCZgyUkeLkxOQKiosmGt5N3JA3qit4sP0yZh9HEtZk85S9xDVLUJkCEa2SIDEIWExpEVe3CI5TN8chXh/qyH0TqoHbkfrf2xkolYZFGYM/BcGj6I3bOVKFSTkwuxVmncgLrk0q7a6e5mgAwYxy9iMB0aOM56j37oEdOzOLl8giAhxvu2AorsPxfewfwnvnFXDvSQHtcQJhJDBZOl7lW9pl0fdqD2ct9/3lip//klMnj79IOncsFJ8JHwC1dpNdJk2PxWS1nzKgHsDlIKfnWPdqI+C2DYGU1Z71mXLXynBSogQiThfUWrSHgUlRB4WPsdurfawIDAQAB";
		BouMasterDto bouMasterDTO = new BouMasterDto();
		
		//24-01-2025 Step=2 Get ciphertext
		String plainMsg="{\"agentInstitutionId\":\"SB42\",\"token\":\"6ffbeb77133c15ca241565135e103a78\"}";
				PublicKey pkey=BbpsSecurityUtil.getPublicKey(BouPublic);
		String ciphertext=securityUtils.encryptRsaMessage( plainMsg,pkey);
				System.out.println("ciphertext="+ciphertext);
		//24-01-2025 Step=3 Get Timestamp
					ZonedDateTime now2 = ZonedDateTime.now();
					DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
					String formattedTimestamp = now2.format(formatter2);
					System.out.println("Formatted Timestamp: " + formattedTimestamp);
		//24-01-2025 Step=4 Generate DigitalSignature		
					requestDTO.setCipherText(ciphertext);
					requestDTO.setTimeStamp(formattedTimestamp);
					
					//----------------------------------------------------------------------------
					DateTimeFormatter rrnform = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
					String rrnTimestamp = now2.format(rrnform);
					String RRN="SB51"+rrnTimestamp+"ee3b04f1043344f87";
					
					//--------------------------------------------------------------------------
					requestDTO.setRrn(RRN);
					
					PrivateKey privatekey=BbpsSecurityUtil.getPrivateKey(getBillerPrivate);
					 digitalSignature = securityUtils.generateDigitalSignature(requestDTO.getRrn() + requestDTO.getTimeStamp() + requestDTO.getCipherText(), privatekey);
						System.out.println("digitalSignature: " + digitalSignature);
  	encryptedRequestMsg = "{" + "\"rrn\":\""+requestDTO.getRrn()+"\"," + "\"cipherText\":\""+requestDTO.getCipherText()+"\"," + "\"digitalSig\":\""+digitalSignature+"\"," + "\"ts\":\""+requestDTO.getTimeStamp()+"\"" + "}";

		System.out.println("EncryptedRequest: " + encryptedRequestMsg);
		  StringBuilder response = new StringBuilder();
		  try {
      	    // URL of the API endpoint
      	    URL url = new URL("https://uatsbiunipay.sbi/bbps-cou-switch/getAccessToken/SB42");
      	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      	    
      	    // Setting the request method to POST
      	    conn.setRequestMethod("POST");
      	    conn.setRequestProperty("Content-Type", "application/json; utf-8");
      	    conn.setRequestProperty("Accept", "application/json");
      	    conn.setDoOutput(true);

      	    // JSON payload
      	    String jsonInputString = encryptedRequestMsg;
      	      try (OutputStream os = conn.getOutputStream()) {
      	        byte[] input = jsonInputString.getBytes("utf-8");
      	        os.write(input, 0, input.length);
      	    }
      	// Read the response
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
              
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Response: " + response.toString());
                loginEntity.setOTP(response.toString());
            }
      	    // Reading the response
      	    int responseCode = conn.getResponseCode();
      	    System.out.println("Response Code: " + conn.getResponseMessage());
      	    
      	    // Handle the response (omitted for brevity)

      	} catch (Exception e) {
      	    
      		
      		loginEntity.setOTP(""+e.fillInStackTrace());
      		e.printStackTrace();
      	    
      	 
      	}

		 final Login1 login = new Login1();
        // model.clear();
         model.put("loginEntity", login);
         mp.put("encryptedRequestMsg", encryptedRequestMsg);
         login.setBranch_Type(encryptedRequestMsg);
         System.out.println("response.toString()="+response.toString());
         mp.put("OTP", response.toString());
         mp.put("Rrn_No", RRN);
         login.setRrn_No(RRN);
        // mp.put("OTP1", response.toString());
         login.setOTP(response.toString());
         //login.setOTP1(response.toString());
         
      
       //----------------------------------------------------------------------------------------

	
	
       String TokenResponseMsg=response.toString().replace("\"ts\"", "\"timeStamp\"");
	System.out.println("TokenResponseMsg="+TokenResponseMsg );

	EncryptedRequestDto tokenRespenseDTO =new EncryptedRequestDto();
tokenRespenseDTO = JsonConverterUtilityP.convertStringToJsonObject(TokenResponseMsg, EncryptedRequestDto.class);
String signatureReqStr1 = tokenRespenseDTO.getRrn()+tokenRespenseDTO.getTimeStamp()+tokenRespenseDTO.getCipherText();
System.out.println("signatureReqStr1="+signatureReqStr1 );

//24-01-2025 Step=7 Verify TokenResponse with digital signature
isVerified = securityUtils.verifyDigitalSignature(signatureReqStr1, tokenRespenseDTO.getDigitalSig(), pkey); //give BOU public key here
System.out.println("isVerified="+isVerified );

//24-01-2025 Step=8 Get AES Key from Response
try {
decryptedAesKey = securityUtils.decryptMessage( tokenRespenseDTO.getCipherText(),privatekey);

} catch (Exception e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
String accessToken = null;
try {
// Create an ObjectMapper
ObjectMapper objectMapper = new ObjectMapper();

// Convert JSON string into JsonNode
JsonNode jsonNode = objectMapper.readTree(decryptedAesKey);

// Get values
String responseCode = jsonNode.path("reason").path("responseCode").asText();
String responseReason = jsonNode.path("reason").path("responseReason").asText();
accessToken = jsonNode.path("accessToken").asText();
String expiryTime = jsonNode.path("expiryTime").asText();

// Output values
System.out.println("Response Code: " + responseCode);
System.out.println("Response Reason: " + responseReason);
System.out.println("Access Token: " + accessToken);
System.out.println("Expiry Time: " + expiryTime);
} catch (Exception e) {
e.printStackTrace();
}

mp.put("signatureReqStr1", decryptedAesKey );
//final Login1 login = new Login1();
model.put("loginEntity", loginEntity);
loginEntity.setOTP(decryptedAesKey );
loginEntity.setOTP1(accessToken);
loginEntity.setBranch_Type(encryptedRequestMsg);

loginEntity.setAesToken(accessToken);
mp.put("AesToken", accessToken);
mp.put("Rrn_No", RRN);




return "ServiceList";


	
       
       
       //------------------------------------------------------------------------------------------
    
    	
    	}

}

    
    
    @RequestMapping(value = { "/LoginValidate" },params="CategoryListView", method = { RequestMethod.POST })
    public String CategoryListView(@Valid @ModelAttribute("loginEntity") final Login1 loginEntity, final BindingResult result, final ModelMap mp,  HttpSession session, final HttpServletRequest request, final Map<String, Object> model, final RedirectAttributes attributes) throws SQLException, ParseException, IOException {
    	{
    		String uniqueID = UUID.randomUUID().toString();

    		String id="SB42";
    		String agentInstid="SB42";
    		String token="6ffbeb77133c15ca241565135e103a78";
    		//String aesToken=loginEntity.getOTP1();
    		
    		String RRN=loginEntity.getRrn_No();
    		String aesToken=loginEntity.getAesToken();
    		
		EncryptedRequestDto requestDTO =new EncryptedRequestDto();
		BillFetchRequestBean decryptedRequestDto = null;

		String decryptedResponseMsg = null;
		String encryptedResponseMsg = null;

		String encryptedRequestMsg = null;
		String decryptedRequestMsg = null;
		String encryptedAesKey = null;
		String decryptedAesKey = null;

		String timeStamp = null;
		String digitalSignature = null;
		boolean isVerified = false;
		boolean isValid = false;
		String getBillerPrivate = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgboeBDYUm/hLhirbB0Jb05XJEf/ji5SUC5LuqpQhnKhX3RJ0qxdOIzhG5lv4+FN+Yi/1DvCcDN8I2AsNzLABuuoeva/qYWhrs3808jPl2PiFIPv7EeRkfKzswN40Ov/d/05jdNQ1hg6vdylhD0sig5BJtmp3jimPGhSpQgowqvdPXSYwAuj2juea8pSJSPkU1BfPWM7WJWzeoUrNptaAV3sgZ5sa3yEuYPBTJr7/uP9mCMciu9GAxOzN0+awet1RFHfPXtWgIAi9RxgrOW6jSDYI9NqleC41jQyJR/E2uvUIJ/OlqL3L6bH0/PxkOuzy+biUv0qGB97DqXRh3EUU3AgMBAAECggEAd40GEwhFMiJhZYsd114eL86PkTYf/MyvAPH8WxRyJ5Z4GfQafpY+pRKSqM85FIAvgxjGmWQrWj2BzwfOKBQhGmKL3BBGBKQYrm20HiwbdZ6k5JZ0+WoYa16m066Bwf0RbUL8BdOT7hfVyggQMDJx6Vsr1FtEzxwAcB4pwycVVn8/ZFk+maoIptb7oOrVf/A1OaiwFHrUplQFwL9bOjrnaz6sPmGStpSU6NHVkUVlH/J8V/ag2iYt9QUQiLg6/jroMQegixZAi5g3fQKQ/2oOKy+6JKfxcN982X7Zy36gULhs/VJ+SeD/+YjqfIaNJtqDpeunlSGLGG8W+4f6nUp9IQKBgQDrTc4VG7x1AS6gc9wG7xcjSUWHK0tQow8rl64Y4KAb3iyKismNtgg8qkRERhJ+ZZulr07IUZE/M+doqNmoShtpcuGguUgcKGgfaCBo4351TgVh2fslzwzhrood7O+fScgJmmT+XN3et0luwkvpD60Kol5xD0dEOabH/f1RJNpvcQKBgQCuit+QhdN5d353UAWyPEZnrQmmfDU6yP280ELU0/AmC6nghRD7dz8ZXo+LmRMuekEeNX4l0HU1LNhjmcW4El6112ZfVtt7znI7yqq7m7SYHhewJT2xrDq6m9yhGa8j2TGZNrSb+cEYv8kJcBNZMMQytHVTg6h4vA01S4KUOK97JwKBgEIRIXjZxctQXqgcf73Oqb91ljkCle35KoxB1VcU0r+gXP81QqwwXRWzdOF6jzzACLi3hTZHeLG3QBUpu5s92357DBDVlQKa8clHsjnhDiOfmXFFA/g0r1g6antGiG1ACRNxL0QgDQe4jLy1fxzcEuj2d+/kq0zjpwlmLhb3cwFxAoGAJzS4jR0SaIln1eMatHOHmQgsT8I8rqyxGjVpnabRnaonCXC6ZNHfUZKFCeVjgqAheminolTVzxD4tj63Q+aUcaIls6qt+Hxh+n5GpYePJFA2H/HtjrhSJNKX13QOfC3wTysTnKmYLzf9L2qGXhVvLLiOVikPsbcD/IGunh6xhCcCgYAvtXpHRZN2xy66d1VrMeqhfddj+lDmp0ZkbbeyZHLovk2G4jOjck0CMHffMbYoi5Up2Opi6Gn2G2roO6EvLmPt8zneEDc9NfwdbQLVc7sHk4WaaZIWHl/9kyKLjO6PrjyN+IJ/W8GhDo1aXG+3bARmnqVhHQnARx6dw610JFy34g==";
		String BouPublic = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn9/lE9HbqaS/6GqkysCZgyUkeLkxOQKiosmGt5N3JA3qit4sP0yZh9HEtZk85S9xDVLUJkCEa2SIDEIWExpEVe3CI5TN8chXh/qyH0TqoHbkfrf2xkolYZFGYM/BcGj6I3bOVKFSTkwuxVmncgLrk0q7a6e5mgAwYxy9iMB0aOM56j37oEdOzOLl8giAhxvu2AorsPxfewfwnvnFXDvSQHtcQJhJDBZOl7lW9pl0fdqD2ct9/3lip//klMnj79IOncsFJ8JHwC1dpNdJk2PxWS1nzKgHsDlIKfnWPdqI+C2DYGU1Z71mXLXynBSogQiThfUWrSHgUlRB4WPsdurfawIDAQAB";
		BouMasterDto bouMasterDTO = new BouMasterDto();
		
		//24-01-2025 Step=2 Get ciphertext
		String plainMsg="{\"agentInstitutionId\":\"SB42\",\"token\":\"6ffbeb77133c15ca241565135e103a78\"}";
				PublicKey pkey=BbpsSecurityUtil.getPublicKey(BouPublic);
				//PublicKey aeskey=BbpsSecurityUtil.getPublicKey(aesToken);
		
				String NBCIID="OU01OU02INT522274495200721ahbcj2123";
				//----------------------------------------------------------------------------
				ZonedDateTime now2 = ZonedDateTime.now();
				DateTimeFormatter rrnform = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
				String rrnTimestamp = now2.format(rrnform);
				 NBCIID="OU01OU02INT"+rrnTimestamp+"1ahbcj2123";
				
				//--------------------------------------------------------------------------
			
		//24-01-2025 Step=3 Get Timestamp
					//DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
					//"yyyy-MM-dd'T'HH:mm:ss'+05:30'"
					DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'+05:30'");
					String formattedTimestamp = now2.format(formatter2);
					System.out.println("Formatted Timestamp: " + formattedTimestamp);
					String requestId="{\"head\":{\"requestId\":\""+NBCIID+"\",\"ts\":\""+formattedTimestamp+"\"},\"search\":{\"status\":\"Active\"}}";
					String ciphertext=securityUtils.encryptAesGcm(requestId, aesToken);
					//String ciphertext=securityUtils.encryptRsaMessage( requestId,aesToken);
					System.out.println("ciphertext="+ciphertext);
		//24-01-2025 Step=4 Generate DigitalSignature		
					requestDTO.setCipherText(ciphertext);
					requestDTO.setTimeStamp(formattedTimestamp);
					requestDTO.setRrn(RRN);
					PrivateKey privatekey=BbpsSecurityUtil.getPrivateKey(getBillerPrivate);
					 digitalSignature = securityUtils.generateDigitalSignature(requestDTO.getRrn() + requestDTO.getTimeStamp() + requestDTO.getCipherText(), privatekey);
						System.out.println("digitalSignature: " + digitalSignature);

						//24-01-2025 Step=5 Generate EncryptedRequest			

		//encryptedRequestMsg = "{" + "\"rrn\":\"SB5120210212093848ee3b04f1043344f87\"," + "\"cipherText\":\"3412C8F35979A2D92F92B7EA8A6183ECB1EDA5C896276562D80AA83F7C8C033BCCE43E2FAD9EAB5A0334CE8454392DB0DCA969469F3F5917B86335D986EE8275B87241DB1AF4A6499373DD6EA5A711EB634A7CAE352D4D3DA89D9F535A3971E12EB65058D2A001B039CE03FDEABB56C481488CC452FB117EF39D011339FAA09BD992EEA4D456FBCB877D9CA86E2D60613A48F61A99E8C3C88F6FE117ED1B0ADC83B2E406AB4075A882DD207880DDEFBBABD96A2EAEBD57BBD72BC29C1E530C11ECDB4AB1982E419840863D1A3078AF96746D1400D4A3D5AA68431E88676FB52F8B47B8F14C0000B659BA23ED7636D9FC57212922069324B991517A1912EDA7F4FA8641279A94B013F98F3DA950EC001A1E65F8A604849AFB663630BBFAA55C3885F1815EEB6B0AB94D25A00510B76A436F6E076333CD9802F83D9C0F6EE473A468C4633AB1A1F1D5C86E398197D374305CB14251CE0691E1AFBDFBE5783D20FA86D256050DE205DD90AC5CE3\"," + "\"digitalSig\":\"A7dIKgs8l8fndu7p/YNOigM5Gj32IgXiIDoYtZb0mfKW8yfWXPwYQDmMy7LYE1Vrk3c2r1eywWr7Wu1LJkyJ4RCp8H2nSjUpEpHYsaU3qV4vQyhSKWLjhEFOWcn9zqnwLaZAAd8zZCK7uorQFky02t28SOaVfcGU/3UhHxZVGXgOzJGSUVZlO6xFYnq91/GCbE9Bo9uNVENYWKtMXCPHb/8C4tYl9UMpVFurXYmUJq9U5ZJos0+JykjLUt3ly/LvCKegE6gnRuGCuvvnLi22HsDNWj3unW+ytbU9inA0gBkPaELH4fK9f3cs7U3b+A6KmX1VdJeSJVm9JAdkvGdu5A==\"," + "\"timeStamp\":\"2021-02-12T21:38:48+05:30\"" + "}";
		encryptedRequestMsg = "{" + "\"rrn\":\""+requestDTO.getRrn()+"\"," + "\"cipherText\":\""+requestDTO.getCipherText()+"\"," + "\"digitalSig\":\""+digitalSignature+"\"," + "\"ts\":\""+requestDTO.getTimeStamp()+"\"" + "}";

		System.out.println("EncryptedRequest: " + encryptedRequestMsg);
		  StringBuilder response = new StringBuilder();
		  try {
      	    // URL of the API endpoint
      	   URL url = new URL("https://uatsbiunipay.sbi/bbps-cou-switch/getCategoryList");
      	   //URL url = new URL("https://uatsbiunipay.sbi/bbps-cou-switch/getAccessToken/SB42");
        	 
      	    //URL url=new URL("https://jaisaissnidhilimited.com/api/values/PostBillDesk");
      	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      	    
      	    // Setting the request method to POST
      	    conn.setRequestMethod("POST");
      	    conn.setRequestProperty("Content-Type", "application/json; utf-8");
      	    conn.setRequestProperty("Accept", "application/json");
      	    conn.setDoOutput(true);

      	    // JSON payload
      	    String jsonInputString = encryptedRequestMsg;
      	    //String jsonInputString="{\"amt\":\"qg8lfycy0Ps=\",\"accNum\":\"QDvcz8lILVw1I6YUpkHHAw==\",\"hname\":\"v+yG16PsTsA=\",\"bal\":\"osN4bh2XAuVefhxwIn3QfQ==\",\"atype\":\"Qzwj51FVXG8=\"}";
      	    // Sending the JSON payload
      	    try (OutputStream os = conn.getOutputStream()) {
      	        byte[] input = jsonInputString.getBytes("utf-8");
      	        os.write(input, 0, input.length);
      	    }
      	// Read the response
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
              
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Response: " + response.toString());
                loginEntity.setOTP(response.toString());
            }
      	    // Reading the response
      	    int responseCode = conn.getResponseCode();
      	    System.out.println("Response Code: " + conn.getResponseMessage());
      	    
      	    // Handle the response (omitted for brevity)

      	} catch (Exception e) {
      	    
      		
      		loginEntity.setOTP(""+e.fillInStackTrace());
      		e.printStackTrace();
      	    
      	 
      	}

		// final Login1 login = new Login1();
        // model.clear();
         model.put("loginEntity2", loginEntity);
         mp.put("encryptedRequestMsg", encryptedRequestMsg);
         loginEntity.setBranch_Type("Request Id \n:"+requestId+"\n  Cipher :"+ciphertext+" \n Encripted Msg :"+encryptedRequestMsg);
         System.out.println("response.toString()="+response.toString());
         mp.put("OTP", response.toString());
        // mp.put("OTP1", response.toString());
         loginEntity.setOTP(response.toString());
         loginEntity.setEncryptedMsg(encryptedRequestMsg);
         //login.setOTP1(response.toString());
         
         mp.put("AesToken", loginEntity.getAesToken());
         mp.put("Rrn_No", loginEntity.getRrn_No());


       
    
    
    	
    	
	
			String plainMsg_Cat=loginEntity.getEncryptedMsg();
	    	String ciphertext_Cat=securityUtils.encryptRsaMessage( plainMsg_Cat,pkey);
				System.out.println("ciphertext="+ciphertext);
					String TokenResponseMsg=loginEntity.getOTP().replace("\"ts\"", "\"timeStamp\"");
		System.out.println("TokenResponseMsg="+TokenResponseMsg );

		EncryptedRequestDto tokenRespenseDTO =new EncryptedRequestDto();
tokenRespenseDTO = JsonConverterUtilityP.convertStringToJsonObject(TokenResponseMsg, EncryptedRequestDto.class);
String signatureReqStr1 = tokenRespenseDTO.getRrn()+tokenRespenseDTO.getTimeStamp()+tokenRespenseDTO.getCipherText();
System.out.println("signatureReqStr1="+signatureReqStr1 );

//24-01-2025 Step=7 Verify TokenResponse with digital signature
isVerified = securityUtils.verifyDigitalSignature(signatureReqStr1, tokenRespenseDTO.getDigitalSig(), pkey); //give BOU public key here
System.out.println("isVerified="+isVerified );
/*if (!isVerified)
{
	EncryptedResponseDto responseDTO = new EncryptedResponseDto();
	responseDTO.setCipherText("Invalid Digital Signature");
	encryptedResponseMsg = JsonConverterUtilityP.convertJsonObjectToString(tokenRespenseDTO);
	return "/"; //return failure response here
}*/
//24-01-2025 Step=8 Get AES Key from Response
try {
	//aesToken
	decryptedAesKey =securityUtils.decryptAesGcm(tokenRespenseDTO.getCipherText(), aesToken);
	//decryptedAesKey = securityUtils.decryptMessage( tokenRespenseDTO.getCipherText(),privatekey);
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
String accessToken = null;
try {
    ObjectMapper objectMapper = new ObjectMapper();

    // Deserialize the JSON string into the Java object (Response)
    Response response_Cat = objectMapper.readValue(decryptedAesKey, Response.class);
     // db.insertResponseData(response);
      
} catch (Exception e) {
    e.printStackTrace();
}



// Now you have the Java object
//System.out.println(response);

mp.put("signatureReqStr1", signatureReqStr1 );
//final Login1 login = new Login1();
model.put("loginEntity", loginEntity);
loginEntity.setEncryptedMsg(plainMsg);
loginEntity.setOTP(decryptedAesKey );
loginEntity.setOTP1(""+isVerified+" op="+decryptedAesKey);
loginEntity.setBranch_Type("CypherTxt :"+ciphertext+" \n signatureReqStr1 : "+signatureReqStr1);

mp.put("AesToken", loginEntity.getAesToken());
mp.put("Rrn_No", loginEntity.getRrn_No());

return "ServiceList";


    	}
    	
    	
    }	
    	
    	
    	

    
    @RequestMapping(value = { "/LoginValidate" },params="StateListView", method = { RequestMethod.POST })
    public String StateListView(@Valid @ModelAttribute("loginEntity") final Login1 loginEntity, final BindingResult result, final ModelMap mp,  HttpSession session, final HttpServletRequest request, final Map<String, Object> model, final RedirectAttributes attributes) throws SQLException, ParseException, IOException {
    	{
    		String uniqueID = UUID.randomUUID().toString();

    		String id="SB42";
    		String agentInstid="SB42";
    		String token="6ffbeb77133c15ca241565135e103a78";
    		//String aesToken=loginEntity.getOTP1();
    		
    		String RRN=loginEntity.getRrn_No();
    		String aesToken=loginEntity.getAesToken();
    		
		EncryptedRequestDto requestDTO =new EncryptedRequestDto();
		BillFetchRequestBean decryptedRequestDto = null;

		String decryptedResponseMsg = null;
		String encryptedResponseMsg = null;

		String encryptedRequestMsg = null;
		String decryptedRequestMsg = null;
		String encryptedAesKey = null;
		String decryptedAesKey = null;

		String timeStamp = null;
		String digitalSignature = null;
		boolean isVerified = false;
		boolean isValid = false;
		String getBillerPrivate = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgboeBDYUm/hLhirbB0Jb05XJEf/ji5SUC5LuqpQhnKhX3RJ0qxdOIzhG5lv4+FN+Yi/1DvCcDN8I2AsNzLABuuoeva/qYWhrs3808jPl2PiFIPv7EeRkfKzswN40Ov/d/05jdNQ1hg6vdylhD0sig5BJtmp3jimPGhSpQgowqvdPXSYwAuj2juea8pSJSPkU1BfPWM7WJWzeoUrNptaAV3sgZ5sa3yEuYPBTJr7/uP9mCMciu9GAxOzN0+awet1RFHfPXtWgIAi9RxgrOW6jSDYI9NqleC41jQyJR/E2uvUIJ/OlqL3L6bH0/PxkOuzy+biUv0qGB97DqXRh3EUU3AgMBAAECggEAd40GEwhFMiJhZYsd114eL86PkTYf/MyvAPH8WxRyJ5Z4GfQafpY+pRKSqM85FIAvgxjGmWQrWj2BzwfOKBQhGmKL3BBGBKQYrm20HiwbdZ6k5JZ0+WoYa16m066Bwf0RbUL8BdOT7hfVyggQMDJx6Vsr1FtEzxwAcB4pwycVVn8/ZFk+maoIptb7oOrVf/A1OaiwFHrUplQFwL9bOjrnaz6sPmGStpSU6NHVkUVlH/J8V/ag2iYt9QUQiLg6/jroMQegixZAi5g3fQKQ/2oOKy+6JKfxcN982X7Zy36gULhs/VJ+SeD/+YjqfIaNJtqDpeunlSGLGG8W+4f6nUp9IQKBgQDrTc4VG7x1AS6gc9wG7xcjSUWHK0tQow8rl64Y4KAb3iyKismNtgg8qkRERhJ+ZZulr07IUZE/M+doqNmoShtpcuGguUgcKGgfaCBo4351TgVh2fslzwzhrood7O+fScgJmmT+XN3et0luwkvpD60Kol5xD0dEOabH/f1RJNpvcQKBgQCuit+QhdN5d353UAWyPEZnrQmmfDU6yP280ELU0/AmC6nghRD7dz8ZXo+LmRMuekEeNX4l0HU1LNhjmcW4El6112ZfVtt7znI7yqq7m7SYHhewJT2xrDq6m9yhGa8j2TGZNrSb+cEYv8kJcBNZMMQytHVTg6h4vA01S4KUOK97JwKBgEIRIXjZxctQXqgcf73Oqb91ljkCle35KoxB1VcU0r+gXP81QqwwXRWzdOF6jzzACLi3hTZHeLG3QBUpu5s92357DBDVlQKa8clHsjnhDiOfmXFFA/g0r1g6antGiG1ACRNxL0QgDQe4jLy1fxzcEuj2d+/kq0zjpwlmLhb3cwFxAoGAJzS4jR0SaIln1eMatHOHmQgsT8I8rqyxGjVpnabRnaonCXC6ZNHfUZKFCeVjgqAheminolTVzxD4tj63Q+aUcaIls6qt+Hxh+n5GpYePJFA2H/HtjrhSJNKX13QOfC3wTysTnKmYLzf9L2qGXhVvLLiOVikPsbcD/IGunh6xhCcCgYAvtXpHRZN2xy66d1VrMeqhfddj+lDmp0ZkbbeyZHLovk2G4jOjck0CMHffMbYoi5Up2Opi6Gn2G2roO6EvLmPt8zneEDc9NfwdbQLVc7sHk4WaaZIWHl/9kyKLjO6PrjyN+IJ/W8GhDo1aXG+3bARmnqVhHQnARx6dw610JFy34g==";
		String BouPublic = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn9/lE9HbqaS/6GqkysCZgyUkeLkxOQKiosmGt5N3JA3qit4sP0yZh9HEtZk85S9xDVLUJkCEa2SIDEIWExpEVe3CI5TN8chXh/qyH0TqoHbkfrf2xkolYZFGYM/BcGj6I3bOVKFSTkwuxVmncgLrk0q7a6e5mgAwYxy9iMB0aOM56j37oEdOzOLl8giAhxvu2AorsPxfewfwnvnFXDvSQHtcQJhJDBZOl7lW9pl0fdqD2ct9/3lip//klMnj79IOncsFJ8JHwC1dpNdJk2PxWS1nzKgHsDlIKfnWPdqI+C2DYGU1Z71mXLXynBSogQiThfUWrSHgUlRB4WPsdurfawIDAQAB";
		BouMasterDto bouMasterDTO = new BouMasterDto();
		
		//24-01-2025 Step=2 Get ciphertext
		String plainMsg="{\"agentInstitutionId\":\"SB42\",\"token\":\"6ffbeb77133c15ca241565135e103a78\"}";
				PublicKey pkey=BbpsSecurityUtil.getPublicKey(BouPublic);
				//PublicKey aeskey=BbpsSecurityUtil.getPublicKey(aesToken);
		
				String NBCIID="OU01OU02INT522274495200721ahbcj2123";
				//----------------------------------------------------------------------------
				ZonedDateTime now2 = ZonedDateTime.now();
				DateTimeFormatter rrnform = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
				String rrnTimestamp = now2.format(rrnform);
				 NBCIID="OU01OU02INT"+rrnTimestamp+"1ahbcj2123";
				
				//--------------------------------------------------------------------------
			
		//24-01-2025 Step=3 Get Timestamp
					//ZonedDateTime now2 = ZonedDateTime.now();
					//DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
					//"yyyy-MM-dd'T'HH:mm:ss'+05:30'"
					DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'+05:30'");
					String formattedTimestamp = now2.format(formatter2);
					System.out.println("Formatted Timestamp: " + formattedTimestamp);
					String requestId="{\"head\":{\"requestId\":\""+NBCIID+"\",\"ts\":\""+formattedTimestamp+"\"},\"search\":{\"status\":\"Active\"}}";
					String ciphertext=securityUtils.encryptAesGcm(requestId, aesToken);
					//String ciphertext=securityUtils.encryptRsaMessage( requestId,aesToken);
					System.out.println("ciphertext="+ciphertext);
		//24-01-2025 Step=4 Generate DigitalSignature		
					requestDTO.setCipherText(ciphertext);
					requestDTO.setTimeStamp(formattedTimestamp);
					requestDTO.setRrn(RRN);
					PrivateKey privatekey=BbpsSecurityUtil.getPrivateKey(getBillerPrivate);
					 digitalSignature = securityUtils.generateDigitalSignature(requestDTO.getRrn() + requestDTO.getTimeStamp() + requestDTO.getCipherText(), privatekey);
						System.out.println("digitalSignature: " + digitalSignature);

						//24-01-2025 Step=5 Generate EncryptedRequest			

		//encryptedRequestMsg = "{" + "\"rrn\":\"SB5120210212093848ee3b04f1043344f87\"," + "\"cipherText\":\"3412C8F35979A2D92F92B7EA8A6183ECB1EDA5C896276562D80AA83F7C8C033BCCE43E2FAD9EAB5A0334CE8454392DB0DCA969469F3F5917B86335D986EE8275B87241DB1AF4A6499373DD6EA5A711EB634A7CAE352D4D3DA89D9F535A3971E12EB65058D2A001B039CE03FDEABB56C481488CC452FB117EF39D011339FAA09BD992EEA4D456FBCB877D9CA86E2D60613A48F61A99E8C3C88F6FE117ED1B0ADC83B2E406AB4075A882DD207880DDEFBBABD96A2EAEBD57BBD72BC29C1E530C11ECDB4AB1982E419840863D1A3078AF96746D1400D4A3D5AA68431E88676FB52F8B47B8F14C0000B659BA23ED7636D9FC57212922069324B991517A1912EDA7F4FA8641279A94B013F98F3DA950EC001A1E65F8A604849AFB663630BBFAA55C3885F1815EEB6B0AB94D25A00510B76A436F6E076333CD9802F83D9C0F6EE473A468C4633AB1A1F1D5C86E398197D374305CB14251CE0691E1AFBDFBE5783D20FA86D256050DE205DD90AC5CE3\"," + "\"digitalSig\":\"A7dIKgs8l8fndu7p/YNOigM5Gj32IgXiIDoYtZb0mfKW8yfWXPwYQDmMy7LYE1Vrk3c2r1eywWr7Wu1LJkyJ4RCp8H2nSjUpEpHYsaU3qV4vQyhSKWLjhEFOWcn9zqnwLaZAAd8zZCK7uorQFky02t28SOaVfcGU/3UhHxZVGXgOzJGSUVZlO6xFYnq91/GCbE9Bo9uNVENYWKtMXCPHb/8C4tYl9UMpVFurXYmUJq9U5ZJos0+JykjLUt3ly/LvCKegE6gnRuGCuvvnLi22HsDNWj3unW+ytbU9inA0gBkPaELH4fK9f3cs7U3b+A6KmX1VdJeSJVm9JAdkvGdu5A==\"," + "\"timeStamp\":\"2021-02-12T21:38:48+05:30\"" + "}";
		encryptedRequestMsg = "{" + "\"rrn\":\""+requestDTO.getRrn()+"\"," + "\"cipherText\":\""+requestDTO.getCipherText()+"\"," + "\"digitalSig\":\""+digitalSignature+"\"," + "\"ts\":\""+requestDTO.getTimeStamp()+"\"" + "}";

		System.out.println("EncryptedRequest: " + encryptedRequestMsg);
		  StringBuilder response = new StringBuilder();
		  try {
      	    // URL of the API endpoint
      	   URL url = new URL("https://uatsbiunipay.sbi/bbps-cou-switch/getStateList");
      	   //URL url = new URL("https://uatsbiunipay.sbi/bbps-cou-switch/getAccessToken/SB42");
        	 
      	    //URL url=new URL("https://jaisaissnidhilimited.com/api/values/PostBillDesk");
      	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      	    
      	    // Setting the request method to POST
      	    conn.setRequestMethod("POST");
      	    conn.setRequestProperty("Content-Type", "application/json; utf-8");
      	    conn.setRequestProperty("Accept", "application/json");
      	    conn.setDoOutput(true);

      	    // JSON payload
      	    String jsonInputString = encryptedRequestMsg;
      	    //String jsonInputString="{\"amt\":\"qg8lfycy0Ps=\",\"accNum\":\"QDvcz8lILVw1I6YUpkHHAw==\",\"hname\":\"v+yG16PsTsA=\",\"bal\":\"osN4bh2XAuVefhxwIn3QfQ==\",\"atype\":\"Qzwj51FVXG8=\"}";
      	    // Sending the JSON payload
      	    try (OutputStream os = conn.getOutputStream()) {
      	        byte[] input = jsonInputString.getBytes("utf-8");
      	        os.write(input, 0, input.length);
      	    }
      	// Read the response
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
              
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Response: " + response.toString());
                loginEntity.setOTP(response.toString());
            }
      	    // Reading the response
      	    int responseCode = conn.getResponseCode();
      	    System.out.println("Response Code: " + conn.getResponseMessage());
      	    
      	    // Handle the response (omitted for brevity)

      	} catch (Exception e) {
      	    
      		
      		loginEntity.setOTP(""+e.fillInStackTrace());
      		e.printStackTrace();
      	    
      	 
      	}

		// final Login1 login = new Login1();
        // model.clear();
         model.put("loginEntity3", loginEntity);
         mp.put("encryptedRequestMsg", encryptedRequestMsg);
         loginEntity.setBranch_Type("Request Id \n:"+requestId+"\n  Cipher :"+ciphertext+" \n Encripted Msg :"+encryptedRequestMsg);
         System.out.println("response.toString()="+response.toString());
         
         System.out.println("response.toString()="+response.toString());

         mp.put("OTP", response.toString());
        // mp.put("OTP1", response.toString());
         loginEntity.setOTP(response.toString());
         loginEntity.setEncryptedMsg(encryptedRequestMsg);
         //login.setOTP1(response.toString());
         
         mp.put("AesToken", loginEntity.getAesToken());
         mp.put("Rrn_No", loginEntity.getRrn_No());

		
		String plainMsg_State=loginEntity.getEncryptedMsg();
	    	String ciphertext_State=securityUtils.encryptRsaMessage( plainMsg,pkey);
				System.out.println("ciphertext="+ciphertext);
		//24-01-2025 Step=3 Get Timestamp
						String TokenResponseMsg=loginEntity.getOTP().replace("\"ts\"", "\"timeStamp\"");
		System.out.println("TokenResponseMsg="+TokenResponseMsg );

		EncryptedRequestDto tokenRespenseDTO =new EncryptedRequestDto();
tokenRespenseDTO = JsonConverterUtilityP.convertStringToJsonObject(TokenResponseMsg, EncryptedRequestDto.class);
String signatureReqStr1 = tokenRespenseDTO.getRrn()+tokenRespenseDTO.getTimeStamp()+tokenRespenseDTO.getCipherText();
System.out.println("signatureReqStr1="+signatureReqStr1 );

//24-01-2025 Step=7 Verify TokenResponse with digital signature
isVerified = securityUtils.verifyDigitalSignature(signatureReqStr1, tokenRespenseDTO.getDigitalSig(), pkey); //give BOU public key here
System.out.println("isVerified="+isVerified );
/*if (!isVerified)
{
	EncryptedResponseDto responseDTO = new EncryptedResponseDto();
	responseDTO.setCipherText("Invalid Digital Signature");
	encryptedResponseMsg = JsonConverterUtilityP.convertJsonObjectToString(tokenRespenseDTO);
	return "/"; //return failure response here
}*/
//24-01-2025 Step=8 Get AES Key from Response
try {
	//aesToken
	decryptedAesKey =securityUtils.decryptAesGcm(tokenRespenseDTO.getCipherText(), aesToken);
	//decryptedAesKey = securityUtils.decryptMessage( tokenRespenseDTO.getCipherText(),privatekey);
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
String accessToken = null;
try {
    ObjectMapper objectMapper = new ObjectMapper();

    // Deserialize the JSON string into the Java object (Response)
    Response response_State = objectMapper.readValue(decryptedAesKey, Response.class);
     // db.insertResponseData(response);
    
    //insertStates(response_State.getStateList());
      
} catch (Exception e) {
    e.printStackTrace();
}



// Now you have the Java object
//System.out.println(response);

mp.put("signatureReqStr1", signatureReqStr1 );
//final Login1 login = new Login1();
model.put("loginEntity", loginEntity);
loginEntity.setEncryptedMsg(plainMsg);
loginEntity.setOTP(decryptedAesKey );
loginEntity.setOTP1(""+isVerified+" op="+decryptedAesKey);
loginEntity.setBranch_Type("CypherTxt :"+ciphertext+" \n signatureReqStr1 : "+signatureReqStr1);

mp.put("AesToken", loginEntity.getAesToken());
mp.put("Rrn_No", loginEntity.getRrn_No());

return "ServiceList";


    	}
    	
    	
    	
    	
    	
    	

}

    
    @RequestMapping(value = { "/LoginValidate" },params="BillerListView", method = { RequestMethod.POST })
    public String BillerListView(@Valid @ModelAttribute("loginEntity") final Login1 loginEntity, final BindingResult result, final ModelMap mp,  HttpSession session, final HttpServletRequest request, final Map<String, Object> model, final RedirectAttributes attributes) throws SQLException, ParseException, IOException {
    	{
    		String uniqueID = UUID.randomUUID().toString();

    		String id="SB42";
    		String agentInstid="SB42";
    		String token="6ffbeb77133c15ca241565135e103a78";
    		//String aesToken=loginEntity.getOTP1();
    		
    		String RRN=loginEntity.getRrn_No();
    		String aesToken=loginEntity.getAesToken();
    		
    		String user= loginEntity.getUsername();
        		String pass=loginEntity.getPassword();
        		
        		if(user.equalsIgnoreCase(null) || pass.equalsIgnoreCase(null))
        		{
        			attributes.addFlashAttribute("message", "Must Enter Category and State Name ! Minimum 5 Chars");
        			return "redirect:/ServiceList";
        		}

    		
		EncryptedRequestDto requestDTO =new EncryptedRequestDto();
		BillFetchRequestBean decryptedRequestDto = null;

		String decryptedResponseMsg = null;
		String encryptedResponseMsg = null;

		String encryptedRequestMsg = null;
		String decryptedRequestMsg = null;
		String encryptedAesKey = null;
		String decryptedAesKey = null;

		String timeStamp = null;
		String digitalSignature = null;
		boolean isVerified = false;
		boolean isValid = false;
		String getBillerPrivate = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgboeBDYUm/hLhirbB0Jb05XJEf/ji5SUC5LuqpQhnKhX3RJ0qxdOIzhG5lv4+FN+Yi/1DvCcDN8I2AsNzLABuuoeva/qYWhrs3808jPl2PiFIPv7EeRkfKzswN40Ov/d/05jdNQ1hg6vdylhD0sig5BJtmp3jimPGhSpQgowqvdPXSYwAuj2juea8pSJSPkU1BfPWM7WJWzeoUrNptaAV3sgZ5sa3yEuYPBTJr7/uP9mCMciu9GAxOzN0+awet1RFHfPXtWgIAi9RxgrOW6jSDYI9NqleC41jQyJR/E2uvUIJ/OlqL3L6bH0/PxkOuzy+biUv0qGB97DqXRh3EUU3AgMBAAECggEAd40GEwhFMiJhZYsd114eL86PkTYf/MyvAPH8WxRyJ5Z4GfQafpY+pRKSqM85FIAvgxjGmWQrWj2BzwfOKBQhGmKL3BBGBKQYrm20HiwbdZ6k5JZ0+WoYa16m066Bwf0RbUL8BdOT7hfVyggQMDJx6Vsr1FtEzxwAcB4pwycVVn8/ZFk+maoIptb7oOrVf/A1OaiwFHrUplQFwL9bOjrnaz6sPmGStpSU6NHVkUVlH/J8V/ag2iYt9QUQiLg6/jroMQegixZAi5g3fQKQ/2oOKy+6JKfxcN982X7Zy36gULhs/VJ+SeD/+YjqfIaNJtqDpeunlSGLGG8W+4f6nUp9IQKBgQDrTc4VG7x1AS6gc9wG7xcjSUWHK0tQow8rl64Y4KAb3iyKismNtgg8qkRERhJ+ZZulr07IUZE/M+doqNmoShtpcuGguUgcKGgfaCBo4351TgVh2fslzwzhrood7O+fScgJmmT+XN3et0luwkvpD60Kol5xD0dEOabH/f1RJNpvcQKBgQCuit+QhdN5d353UAWyPEZnrQmmfDU6yP280ELU0/AmC6nghRD7dz8ZXo+LmRMuekEeNX4l0HU1LNhjmcW4El6112ZfVtt7znI7yqq7m7SYHhewJT2xrDq6m9yhGa8j2TGZNrSb+cEYv8kJcBNZMMQytHVTg6h4vA01S4KUOK97JwKBgEIRIXjZxctQXqgcf73Oqb91ljkCle35KoxB1VcU0r+gXP81QqwwXRWzdOF6jzzACLi3hTZHeLG3QBUpu5s92357DBDVlQKa8clHsjnhDiOfmXFFA/g0r1g6antGiG1ACRNxL0QgDQe4jLy1fxzcEuj2d+/kq0zjpwlmLhb3cwFxAoGAJzS4jR0SaIln1eMatHOHmQgsT8I8rqyxGjVpnabRnaonCXC6ZNHfUZKFCeVjgqAheminolTVzxD4tj63Q+aUcaIls6qt+Hxh+n5GpYePJFA2H/HtjrhSJNKX13QOfC3wTysTnKmYLzf9L2qGXhVvLLiOVikPsbcD/IGunh6xhCcCgYAvtXpHRZN2xy66d1VrMeqhfddj+lDmp0ZkbbeyZHLovk2G4jOjck0CMHffMbYoi5Up2Opi6Gn2G2roO6EvLmPt8zneEDc9NfwdbQLVc7sHk4WaaZIWHl/9kyKLjO6PrjyN+IJ/W8GhDo1aXG+3bARmnqVhHQnARx6dw610JFy34g==";
		String BouPublic = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn9/lE9HbqaS/6GqkysCZgyUkeLkxOQKiosmGt5N3JA3qit4sP0yZh9HEtZk85S9xDVLUJkCEa2SIDEIWExpEVe3CI5TN8chXh/qyH0TqoHbkfrf2xkolYZFGYM/BcGj6I3bOVKFSTkwuxVmncgLrk0q7a6e5mgAwYxy9iMB0aOM56j37oEdOzOLl8giAhxvu2AorsPxfewfwnvnFXDvSQHtcQJhJDBZOl7lW9pl0fdqD2ct9/3lip//klMnj79IOncsFJ8JHwC1dpNdJk2PxWS1nzKgHsDlIKfnWPdqI+C2DYGU1Z71mXLXynBSogQiThfUWrSHgUlRB4WPsdurfawIDAQAB";
		BouMasterDto bouMasterDTO = new BouMasterDto();
		
		//24-01-2025 Step=2 Get ciphertext
		String plainMsg="{\"agentInstitutionId\":\"SB42\",\"token\":\"6ffbeb77133c15ca241565135e103a78\"}";
				PublicKey pkey=BbpsSecurityUtil.getPublicKey(BouPublic);
				//PublicKey aeskey=BbpsSecurityUtil.getPublicKey(aesToken);
		
				String NBCIID="OU01OU02INT522274495200721ahbcj2123";
				//----------------------------------------------------------------------------
				ZonedDateTime now2 = ZonedDateTime.now();
				DateTimeFormatter rrnform = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
				String rrnTimestamp = now2.format(rrnform);
				 NBCIID="OU01OU02INT"+rrnTimestamp+"1ahbcj2123";
				
				//--------------------------------------------------------------------------
			
		//24-01-2025 Step=3 Get Timestamp
					//ZonedDateTime now2 = ZonedDateTime.now();
					//DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
					//"yyyy-MM-dd'T'HH:mm:ss'+05:30'"
					DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'+05:30'");
					String formattedTimestamp = now2.format(formatter2);
					System.out.println("Formatted Timestamp: " + formattedTimestamp);
					//String requestId="{\"head\":{\"requestId\":\""+NBCIID+"\",\"ts\":\""+formattedTimestamp+"\"},\"search\":{\"status\":\"Active\"}}";
    	            String requestId = "{\"head\": {\"requestId\": \"" + NBCIID + "\",\"ts\":\"" + formattedTimestamp + "\"},\"search\": {\"category\": \""+user+"\",\"state\": \""+pass+"\"}}";

    	String ciphertext=securityUtils.encryptAesGcm(requestId, aesToken);
					//String ciphertext=securityUtils.encryptRsaMessage( requestId,aesToken);
					System.out.println("ciphertext="+ciphertext);
		//24-01-2025 Step=4 Generate DigitalSignature		
					requestDTO.setCipherText(ciphertext);
					requestDTO.setTimeStamp(formattedTimestamp);
					requestDTO.setRrn(RRN);
					PrivateKey privatekey=BbpsSecurityUtil.getPrivateKey(getBillerPrivate);
					 digitalSignature = securityUtils.generateDigitalSignature(requestDTO.getRrn() + requestDTO.getTimeStamp() + requestDTO.getCipherText(), privatekey);
						System.out.println("digitalSignature: " + digitalSignature);

						//24-01-2025 Step=5 Generate EncryptedRequest			

		//encryptedRequestMsg = "{" + "\"rrn\":\"SB5120210212093848ee3b04f1043344f87\"," + "\"cipherText\":\"3412C8F35979A2D92F92B7EA8A6183ECB1EDA5C896276562D80AA83F7C8C033BCCE43E2FAD9EAB5A0334CE8454392DB0DCA969469F3F5917B86335D986EE8275B87241DB1AF4A6499373DD6EA5A711EB634A7CAE352D4D3DA89D9F535A3971E12EB65058D2A001B039CE03FDEABB56C481488CC452FB117EF39D011339FAA09BD992EEA4D456FBCB877D9CA86E2D60613A48F61A99E8C3C88F6FE117ED1B0ADC83B2E406AB4075A882DD207880DDEFBBABD96A2EAEBD57BBD72BC29C1E530C11ECDB4AB1982E419840863D1A3078AF96746D1400D4A3D5AA68431E88676FB52F8B47B8F14C0000B659BA23ED7636D9FC57212922069324B991517A1912EDA7F4FA8641279A94B013F98F3DA950EC001A1E65F8A604849AFB663630BBFAA55C3885F1815EEB6B0AB94D25A00510B76A436F6E076333CD9802F83D9C0F6EE473A468C4633AB1A1F1D5C86E398197D374305CB14251CE0691E1AFBDFBE5783D20FA86D256050DE205DD90AC5CE3\"," + "\"digitalSig\":\"A7dIKgs8l8fndu7p/YNOigM5Gj32IgXiIDoYtZb0mfKW8yfWXPwYQDmMy7LYE1Vrk3c2r1eywWr7Wu1LJkyJ4RCp8H2nSjUpEpHYsaU3qV4vQyhSKWLjhEFOWcn9zqnwLaZAAd8zZCK7uorQFky02t28SOaVfcGU/3UhHxZVGXgOzJGSUVZlO6xFYnq91/GCbE9Bo9uNVENYWKtMXCPHb/8C4tYl9UMpVFurXYmUJq9U5ZJos0+JykjLUt3ly/LvCKegE6gnRuGCuvvnLi22HsDNWj3unW+ytbU9inA0gBkPaELH4fK9f3cs7U3b+A6KmX1VdJeSJVm9JAdkvGdu5A==\"," + "\"timeStamp\":\"2021-02-12T21:38:48+05:30\"" + "}";
		encryptedRequestMsg = "{" + "\"rrn\":\""+requestDTO.getRrn()+"\"," + "\"cipherText\":\""+requestDTO.getCipherText()+"\"," + "\"digitalSig\":\""+digitalSignature+"\"," + "\"ts\":\""+requestDTO.getTimeStamp()+"\"" + "}";

		System.out.println("EncryptedRequest: " + encryptedRequestMsg);
		  StringBuilder response = new StringBuilder();
		  try {
      	    // URL of the API endpoint
      	   URL url = new URL("https://uatsbiunipay.sbi/bbps-cou-switch/getBillerList");
      	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      	    
      	    // Setting the request method to POST
      	    conn.setRequestMethod("POST");
      	    conn.setRequestProperty("Content-Type", "application/json; utf-8");
      	    conn.setRequestProperty("Accept", "application/json");
      	    conn.setDoOutput(true);

      	    // JSON payload
      	    String jsonInputString = encryptedRequestMsg;
      	    //String jsonInputString="{\"amt\":\"qg8lfycy0Ps=\",\"accNum\":\"QDvcz8lILVw1I6YUpkHHAw==\",\"hname\":\"v+yG16PsTsA=\",\"bal\":\"osN4bh2XAuVefhxwIn3QfQ==\",\"atype\":\"Qzwj51FVXG8=\"}";
      	    // Sending the JSON payload
      	    try (OutputStream os = conn.getOutputStream()) {
      	        byte[] input = jsonInputString.getBytes("utf-8");
      	        os.write(input, 0, input.length);
      	    }
      	// Read the response
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
              
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Response: " + response.toString());
                loginEntity.setOTP(response.toString());
            }
      	    // Reading the response
      	    int responseCode = conn.getResponseCode();
      	    System.out.println("Response Code: " + conn.getResponseMessage());
      	    
      	    // Handle the response (omitted for brevity)

      	} catch (Exception e) {
      	    
      		
      		loginEntity.setOTP(""+e.fillInStackTrace());
      		e.printStackTrace();
      	    
      	 
      	}

		// final Login1 login = new Login1();
        // model.clear();
         model.put("loginEntity4", loginEntity);
         mp.put("encryptedRequestMsg", encryptedRequestMsg);
         loginEntity.setBranch_Type("Request Id \n:"+requestId+"\n  Cipher :"+ciphertext+" \n Encripted Msg :"+encryptedRequestMsg);
         System.out.println("response.toString()="+response.toString());
         
         System.out.println("response.toString()="+response.toString());

         mp.put("OTP", response.toString());
        // mp.put("OTP1", response.toString());
         loginEntity.setOTP(response.toString());
         loginEntity.setEncryptedMsg(encryptedRequestMsg);
         //login.setOTP1(response.toString());
         
         mp.put("AesToken", loginEntity.getAesToken());
         mp.put("Rrn_No", loginEntity.getRrn_No());


       
    
    	//-----------------------------------------------------    	
    		
    		
    	
			
		//24-01-2025 Step=2 Get ciphertext
		//String plainMsg="{\"agentInstitutionId\":\"SB42\",\"token\":\"6ffbeb77133c15ca241565135e103a78\"}";
		String plainMsg_BillList=loginEntity.getEncryptedMsg();
	  	String ciphertext_BillerList=securityUtils.encryptRsaMessage( plainMsg_BillList,pkey);
				System.out.println("ciphertext="+ciphertext_BillerList);
					String TokenResponseMsg=loginEntity.getOTP().replace("\"ts\"", "\"timeStamp\"");
		System.out.println("TokenResponseMsg="+TokenResponseMsg );

		EncryptedRequestDto tokenRespenseDTO =new EncryptedRequestDto();
tokenRespenseDTO = JsonConverterUtilityP.convertStringToJsonObject(TokenResponseMsg, EncryptedRequestDto.class);
String signatureReqStr1 = tokenRespenseDTO.getRrn()+tokenRespenseDTO.getTimeStamp()+tokenRespenseDTO.getCipherText();
System.out.println("signatureReqStr1="+signatureReqStr1 );

//24-01-2025 Step=7 Verify TokenResponse with digital signature
isVerified = securityUtils.verifyDigitalSignature(signatureReqStr1, tokenRespenseDTO.getDigitalSig(), pkey); //give BOU public key here
System.out.println("isVerified="+isVerified );
/*if (!isVerified)
{
	EncryptedResponseDto responseDTO = new EncryptedResponseDto();
	responseDTO.setCipherText("Invalid Digital Signature");
	encryptedResponseMsg = JsonConverterUtilityP.convertJsonObjectToString(tokenRespenseDTO);
	return "/"; //return failure response here
}*/
//24-01-2025 Step=8 Get AES Key from Response
try {
	//aesToken
	decryptedAesKey =securityUtils.decryptAesGcm(tokenRespenseDTO.getCipherText(), aesToken);
	//decryptedAesKey = securityUtils.decryptMessage( tokenRespenseDTO.getCipherText(),privatekey);
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
String accessToken = null;
try {
    ObjectMapper objectMapper = new ObjectMapper();

    // Deserialize the JSON string into the Java object (Response)
    Response response_BillerList = objectMapper.readValue(decryptedAesKey, Response.class);
     // db.insertResponseData(response);
    
   // insertStates(response.getStateList());
      
} catch (Exception e) {
    e.printStackTrace();
}



// Now you have the Java object
//System.out.println(response);

mp.put("signatureReqStr1", signatureReqStr1 );
//final Login1 login = new Login1();
model.put("loginEntity", loginEntity);
loginEntity.setEncryptedMsg(plainMsg);
loginEntity.setOTP(decryptedAesKey );
loginEntity.setOTP1(""+isVerified+" op="+decryptedAesKey);
loginEntity.setBranch_Type("CypherTxt :"+ciphertext+" \n signatureReqStr1 : "+signatureReqStr1);

mp.put("AesToken", loginEntity.getAesToken());
mp.put("Rrn_No", loginEntity.getRrn_No());

return "ServiceList";


    	}
    	
    	
    	
    	
    	
    	

}


    
    @RequestMapping(value = { "/LoginValidate" },params="BillerDetailsView", method = { RequestMethod.POST })
    public String BillerDetailsView(@Valid @ModelAttribute("loginEntity") final Login1 loginEntity, final BindingResult result, final ModelMap mp,  HttpSession session, final HttpServletRequest request, final Map<String, Object> model, final RedirectAttributes attributes) throws SQLException, ParseException, IOException {
    	{
    		String uniqueID = UUID.randomUUID().toString();

    		String id="SB42";
    		String agentInstid="SB42";
    		String token="6ffbeb77133c15ca241565135e103a78";
    		//String aesToken=loginEntity.getOTP1();
    		
    		String RRN=loginEntity.getRrn_No();
    		String aesToken=loginEntity.getAesToken();
    		
    		//String user= loginEntity.getUsername();
        	//	String pass=loginEntity.getPassword();
        		
        		String billerId=loginEntity.getAgentId();


    		
		EncryptedRequestDto requestDTO =new EncryptedRequestDto();
		BillFetchRequestBean decryptedRequestDto = null;

		String decryptedResponseMsg = null;
		String encryptedResponseMsg = null;

		String encryptedRequestMsg = null;
		String decryptedRequestMsg = null;
		String encryptedAesKey = null;
		String decryptedAesKey = null;

		String timeStamp = null;
		String digitalSignature = null;
		boolean isVerified = false;
		boolean isValid = false;
		String getBillerPrivate = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgboeBDYUm/hLhirbB0Jb05XJEf/ji5SUC5LuqpQhnKhX3RJ0qxdOIzhG5lv4+FN+Yi/1DvCcDN8I2AsNzLABuuoeva/qYWhrs3808jPl2PiFIPv7EeRkfKzswN40Ov/d/05jdNQ1hg6vdylhD0sig5BJtmp3jimPGhSpQgowqvdPXSYwAuj2juea8pSJSPkU1BfPWM7WJWzeoUrNptaAV3sgZ5sa3yEuYPBTJr7/uP9mCMciu9GAxOzN0+awet1RFHfPXtWgIAi9RxgrOW6jSDYI9NqleC41jQyJR/E2uvUIJ/OlqL3L6bH0/PxkOuzy+biUv0qGB97DqXRh3EUU3AgMBAAECggEAd40GEwhFMiJhZYsd114eL86PkTYf/MyvAPH8WxRyJ5Z4GfQafpY+pRKSqM85FIAvgxjGmWQrWj2BzwfOKBQhGmKL3BBGBKQYrm20HiwbdZ6k5JZ0+WoYa16m066Bwf0RbUL8BdOT7hfVyggQMDJx6Vsr1FtEzxwAcB4pwycVVn8/ZFk+maoIptb7oOrVf/A1OaiwFHrUplQFwL9bOjrnaz6sPmGStpSU6NHVkUVlH/J8V/ag2iYt9QUQiLg6/jroMQegixZAi5g3fQKQ/2oOKy+6JKfxcN982X7Zy36gULhs/VJ+SeD/+YjqfIaNJtqDpeunlSGLGG8W+4f6nUp9IQKBgQDrTc4VG7x1AS6gc9wG7xcjSUWHK0tQow8rl64Y4KAb3iyKismNtgg8qkRERhJ+ZZulr07IUZE/M+doqNmoShtpcuGguUgcKGgfaCBo4351TgVh2fslzwzhrood7O+fScgJmmT+XN3et0luwkvpD60Kol5xD0dEOabH/f1RJNpvcQKBgQCuit+QhdN5d353UAWyPEZnrQmmfDU6yP280ELU0/AmC6nghRD7dz8ZXo+LmRMuekEeNX4l0HU1LNhjmcW4El6112ZfVtt7znI7yqq7m7SYHhewJT2xrDq6m9yhGa8j2TGZNrSb+cEYv8kJcBNZMMQytHVTg6h4vA01S4KUOK97JwKBgEIRIXjZxctQXqgcf73Oqb91ljkCle35KoxB1VcU0r+gXP81QqwwXRWzdOF6jzzACLi3hTZHeLG3QBUpu5s92357DBDVlQKa8clHsjnhDiOfmXFFA/g0r1g6antGiG1ACRNxL0QgDQe4jLy1fxzcEuj2d+/kq0zjpwlmLhb3cwFxAoGAJzS4jR0SaIln1eMatHOHmQgsT8I8rqyxGjVpnabRnaonCXC6ZNHfUZKFCeVjgqAheminolTVzxD4tj63Q+aUcaIls6qt+Hxh+n5GpYePJFA2H/HtjrhSJNKX13QOfC3wTysTnKmYLzf9L2qGXhVvLLiOVikPsbcD/IGunh6xhCcCgYAvtXpHRZN2xy66d1VrMeqhfddj+lDmp0ZkbbeyZHLovk2G4jOjck0CMHffMbYoi5Up2Opi6Gn2G2roO6EvLmPt8zneEDc9NfwdbQLVc7sHk4WaaZIWHl/9kyKLjO6PrjyN+IJ/W8GhDo1aXG+3bARmnqVhHQnARx6dw610JFy34g==";
		String BouPublic = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn9/lE9HbqaS/6GqkysCZgyUkeLkxOQKiosmGt5N3JA3qit4sP0yZh9HEtZk85S9xDVLUJkCEa2SIDEIWExpEVe3CI5TN8chXh/qyH0TqoHbkfrf2xkolYZFGYM/BcGj6I3bOVKFSTkwuxVmncgLrk0q7a6e5mgAwYxy9iMB0aOM56j37oEdOzOLl8giAhxvu2AorsPxfewfwnvnFXDvSQHtcQJhJDBZOl7lW9pl0fdqD2ct9/3lip//klMnj79IOncsFJ8JHwC1dpNdJk2PxWS1nzKgHsDlIKfnWPdqI+C2DYGU1Z71mXLXynBSogQiThfUWrSHgUlRB4WPsdurfawIDAQAB";
		BouMasterDto bouMasterDTO = new BouMasterDto();
		
		//24-01-2025 Step=2 Get ciphertext
		String plainMsg="{\"agentInstitutionId\":\"SB42\",\"token\":\"6ffbeb77133c15ca241565135e103a78\"}";
				PublicKey pkey=BbpsSecurityUtil.getPublicKey(BouPublic);
				//PublicKey aeskey=BbpsSecurityUtil.getPublicKey(aesToken);
		
				String NBCIID="OU01OU02INT522274495200721ahbcj2123";
				//----------------------------------------------------------------------------
				ZonedDateTime now2 = ZonedDateTime.now();
				DateTimeFormatter rrnform = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
				String rrnTimestamp = now2.format(rrnform);
				 NBCIID="OU01OU02INT"+rrnTimestamp+"1ahbcj2123";
				
				//--------------------------------------------------------------------------
			
		//24-01-2025 Step=3 Get Timestamp
						DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'+05:30'");
					String formattedTimestamp = now2.format(formatter2);
					System.out.println("Formatted Timestamp: " + formattedTimestamp);
					//String requestId="{\"head\":{\"requestId\":\""+NBCIID+"\",\"ts\":\""+formattedTimestamp+"\"},\"search\":{\"status\":\"Active\"}}";
					String requestId="{\"head\":{\"requestId\":\""+NBCIID+"\",\"ts\":\""+formattedTimestamp+"\"},\"billerId\":\""+billerId+"\"}";

    	String ciphertext=securityUtils.encryptAesGcm(requestId, aesToken);
					//String ciphertext=securityUtils.encryptRsaMessage( requestId,aesToken);
					System.out.println("ciphertext="+ciphertext);
		//24-01-2025 Step=4 Generate DigitalSignature		
					requestDTO.setCipherText(ciphertext);
					requestDTO.setTimeStamp(formattedTimestamp);
					requestDTO.setRrn(RRN);
					PrivateKey privatekey=BbpsSecurityUtil.getPrivateKey(getBillerPrivate);
					 digitalSignature = securityUtils.generateDigitalSignature(requestDTO.getRrn() + requestDTO.getTimeStamp() + requestDTO.getCipherText(), privatekey);
						System.out.println("digitalSignature: " + digitalSignature);

						//24-01-2025 Step=5 Generate EncryptedRequest			

		//encryptedRequestMsg = "{" + "\"rrn\":\"SB5120210212093848ee3b04f1043344f87\"," + "\"cipherText\":\"3412C8F35979A2D92F92B7EA8A6183ECB1EDA5C896276562D80AA83F7C8C033BCCE43E2FAD9EAB5A0334CE8454392DB0DCA969469F3F5917B86335D986EE8275B87241DB1AF4A6499373DD6EA5A711EB634A7CAE352D4D3DA89D9F535A3971E12EB65058D2A001B039CE03FDEABB56C481488CC452FB117EF39D011339FAA09BD992EEA4D456FBCB877D9CA86E2D60613A48F61A99E8C3C88F6FE117ED1B0ADC83B2E406AB4075A882DD207880DDEFBBABD96A2EAEBD57BBD72BC29C1E530C11ECDB4AB1982E419840863D1A3078AF96746D1400D4A3D5AA68431E88676FB52F8B47B8F14C0000B659BA23ED7636D9FC57212922069324B991517A1912EDA7F4FA8641279A94B013F98F3DA950EC001A1E65F8A604849AFB663630BBFAA55C3885F1815EEB6B0AB94D25A00510B76A436F6E076333CD9802F83D9C0F6EE473A468C4633AB1A1F1D5C86E398197D374305CB14251CE0691E1AFBDFBE5783D20FA86D256050DE205DD90AC5CE3\"," + "\"digitalSig\":\"A7dIKgs8l8fndu7p/YNOigM5Gj32IgXiIDoYtZb0mfKW8yfWXPwYQDmMy7LYE1Vrk3c2r1eywWr7Wu1LJkyJ4RCp8H2nSjUpEpHYsaU3qV4vQyhSKWLjhEFOWcn9zqnwLaZAAd8zZCK7uorQFky02t28SOaVfcGU/3UhHxZVGXgOzJGSUVZlO6xFYnq91/GCbE9Bo9uNVENYWKtMXCPHb/8C4tYl9UMpVFurXYmUJq9U5ZJos0+JykjLUt3ly/LvCKegE6gnRuGCuvvnLi22HsDNWj3unW+ytbU9inA0gBkPaELH4fK9f3cs7U3b+A6KmX1VdJeSJVm9JAdkvGdu5A==\"," + "\"timeStamp\":\"2021-02-12T21:38:48+05:30\"" + "}";
		encryptedRequestMsg = "{" + "\"rrn\":\""+requestDTO.getRrn()+"\"," + "\"cipherText\":\""+requestDTO.getCipherText()+"\"," + "\"digitalSig\":\""+digitalSignature+"\"," + "\"ts\":\""+requestDTO.getTimeStamp()+"\"" + "}";

		System.out.println("EncryptedRequest: " + encryptedRequestMsg);
		  StringBuilder response = new StringBuilder();
		  try {
      	    // URL of the API endpoint
			  URL url = new URL("https://uatsbiunipay.sbi/bbps-cou-switch/getBillerDetails");
      	   //URL url = new URL("https://uatsbiunipay.sbi/bbps-cou-switch/getAccessToken/SB42");
        	 
      	    //URL url=new URL("https://jaisaissnidhilimited.com/api/values/PostBillDesk");
      	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      	    
      	    // Setting the request method to POST
      	    conn.setRequestMethod("POST");
      	    conn.setRequestProperty("Content-Type", "application/json; utf-8");
      	    conn.setRequestProperty("Accept", "application/json");
      	    conn.setDoOutput(true);

      	    // JSON payload
      	    String jsonInputString = encryptedRequestMsg;
      	    //String jsonInputString="{\"amt\":\"qg8lfycy0Ps=\",\"accNum\":\"QDvcz8lILVw1I6YUpkHHAw==\",\"hname\":\"v+yG16PsTsA=\",\"bal\":\"osN4bh2XAuVefhxwIn3QfQ==\",\"atype\":\"Qzwj51FVXG8=\"}";
      	    // Sending the JSON payload
      	    try (OutputStream os = conn.getOutputStream()) {
      	        byte[] input = jsonInputString.getBytes("utf-8");
      	        os.write(input, 0, input.length);
      	    }
      	// Read the response
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
              
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Response: " + response.toString());
                loginEntity.setOTP(response.toString());
            }
      	    // Reading the response
      	    int responseCode = conn.getResponseCode();
      	    System.out.println("Response Code: " + conn.getResponseMessage());
      	    
      	    // Handle the response (omitted for brevity)

      	} catch (Exception e) {
      	    
      		
      		loginEntity.setOTP(""+e.fillInStackTrace());
      		e.printStackTrace();
      	    
      	 
      	}

		// final Login1 login = new Login1();
        // model.clear();
         model.put("loginEntity5", loginEntity);
         mp.put("encryptedRequestMsg", encryptedRequestMsg);
         loginEntity.setBranch_Type("Request Id \n:"+requestId+"\n  Cipher :"+ciphertext+" \n Encripted Msg :"+encryptedRequestMsg);
         System.out.println("response.toString()="+response.toString());
         
         System.out.println("response.toString()="+response.toString());

         mp.put("OTP", response.toString());
        // mp.put("OTP1", response.toString());
         loginEntity.setOTP(response.toString());
         loginEntity.setEncryptedMsg(encryptedRequestMsg);
         //login.setOTP1(response.toString());
         
         mp.put("AesToken", loginEntity.getAesToken());
         mp.put("Rrn_No", loginEntity.getRrn_No());


       
    //----------------------------------------------------------------------------------		

			String plainMsgBillerDetails=loginEntity.getEncryptedMsg();
	    	String ciphertextBillerDetails=securityUtils.encryptRsaMessage( plainMsgBillerDetails,pkey);
				System.out.println("ciphertext="+ciphertext);
				String TokenResponseMsg=loginEntity.getOTP().replace("\"ts\"", "\"timeStamp\"");
		
				System.out.println("TokenResponseMsg="+TokenResponseMsg );

		EncryptedRequestDto tokenRespenseDTO =new EncryptedRequestDto();
tokenRespenseDTO = JsonConverterUtilityP.convertStringToJsonObject(TokenResponseMsg, EncryptedRequestDto.class);
String signatureReqStr1 = tokenRespenseDTO.getRrn()+tokenRespenseDTO.getTimeStamp()+tokenRespenseDTO.getCipherText();
System.out.println("signatureReqStr1="+signatureReqStr1 );

//24-01-2025 Step=7 Verify TokenResponse with digital signature
isVerified = securityUtils.verifyDigitalSignature(signatureReqStr1, tokenRespenseDTO.getDigitalSig(), pkey); //give BOU public key here
System.out.println("isVerified="+isVerified );
/*if (!isVerified)
{
	EncryptedResponseDto responseDTO = new EncryptedResponseDto();
	responseDTO.setCipherText("Invalid Digital Signature");
	encryptedResponseMsg = JsonConverterUtilityP.convertJsonObjectToString(tokenRespenseDTO);
	return "/"; //return failure response here
}*/
//24-01-2025 Step=8 Get AES Key from Response
try {
	//aesToken
	decryptedAesKey =securityUtils.decryptAesGcm(tokenRespenseDTO.getCipherText(), aesToken);
	//decryptedAesKey = securityUtils.decryptMessage( tokenRespenseDTO.getCipherText(),privatekey);
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
String accessToken = null;
try {
    ObjectMapper objectMapper = new ObjectMapper();

    // Deserialize the JSON string into the Java object (Response)
    Response responseBillerDetails = objectMapper.readValue(decryptedAesKey, Response.class);
     // db.insertResponseData(response);
    
   // insertStates(response.getStateList());
      
} catch (Exception e) {
    e.printStackTrace();
}



// Now you have the Java object
//System.out.println(response);

mp.put("signatureReqStr1", signatureReqStr1 );
//final Login1 login = new Login1();
model.put("loginEntity", loginEntity);
loginEntity.setEncryptedMsg(plainMsg);
loginEntity.setOTP(decryptedAesKey );
loginEntity.setOTP1(""+isVerified+" op="+decryptedAesKey);
loginEntity.setBranch_Type("CypherTxt :"+ciphertext+" \n signatureReqStr1 : "+signatureReqStr1);

mp.put("AesToken", loginEntity.getAesToken());
mp.put("Rrn_No", loginEntity.getRrn_No());

return "ServiceList";


    	
    	}
    	
    	
    	
    	
    	
    	

}

    @RequestMapping(value = { "/LoginValidate" },params="BillerFetchView", method = { RequestMethod.POST })
    public String BillerFetchView(@Valid @ModelAttribute("loginEntity") final Login1 loginEntity, final BindingResult result, final ModelMap mp,  HttpSession session, final HttpServletRequest request, final Map<String, Object> model, final RedirectAttributes attributes) throws SQLException, ParseException, IOException {
    	{
    		String uniqueID = UUID.randomUUID().toString();

    		String id="SB42";
    		String agentInstid="SB42";
    		String token="6ffbeb77133c15ca241565135e103a78";
    		//String aesToken=loginEntity.getOTP1();
    		
    		String RRN=loginEntity.getRrn_No();
    		String aesToken=loginEntity.getAesToken();
    		
    		//String user= loginEntity.getUsername();
        	//	String pass=loginEntity.getPassword();
        		
        		String billerId=loginEntity.getAgentId();
                
        		String paramName=loginEntity.getParamName1();
        		String paramValue=loginEntity.getParamValue1();

    		
		EncryptedRequestDto requestDTO =new EncryptedRequestDto();
		BillFetchRequestBean decryptedRequestDto = null;

		String decryptedResponseMsg = null;
		String encryptedResponseMsg = null;

		String encryptedRequestMsg = null;
		String decryptedRequestMsg = null;
		String encryptedAesKey = null;
		String decryptedAesKey = null;

		String timeStamp = null;
		String digitalSignature = null;
		boolean isVerified = false;
		boolean isValid = false;
		String getBillerPrivate = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgboeBDYUm/hLhirbB0Jb05XJEf/ji5SUC5LuqpQhnKhX3RJ0qxdOIzhG5lv4+FN+Yi/1DvCcDN8I2AsNzLABuuoeva/qYWhrs3808jPl2PiFIPv7EeRkfKzswN40Ov/d/05jdNQ1hg6vdylhD0sig5BJtmp3jimPGhSpQgowqvdPXSYwAuj2juea8pSJSPkU1BfPWM7WJWzeoUrNptaAV3sgZ5sa3yEuYPBTJr7/uP9mCMciu9GAxOzN0+awet1RFHfPXtWgIAi9RxgrOW6jSDYI9NqleC41jQyJR/E2uvUIJ/OlqL3L6bH0/PxkOuzy+biUv0qGB97DqXRh3EUU3AgMBAAECggEAd40GEwhFMiJhZYsd114eL86PkTYf/MyvAPH8WxRyJ5Z4GfQafpY+pRKSqM85FIAvgxjGmWQrWj2BzwfOKBQhGmKL3BBGBKQYrm20HiwbdZ6k5JZ0+WoYa16m066Bwf0RbUL8BdOT7hfVyggQMDJx6Vsr1FtEzxwAcB4pwycVVn8/ZFk+maoIptb7oOrVf/A1OaiwFHrUplQFwL9bOjrnaz6sPmGStpSU6NHVkUVlH/J8V/ag2iYt9QUQiLg6/jroMQegixZAi5g3fQKQ/2oOKy+6JKfxcN982X7Zy36gULhs/VJ+SeD/+YjqfIaNJtqDpeunlSGLGG8W+4f6nUp9IQKBgQDrTc4VG7x1AS6gc9wG7xcjSUWHK0tQow8rl64Y4KAb3iyKismNtgg8qkRERhJ+ZZulr07IUZE/M+doqNmoShtpcuGguUgcKGgfaCBo4351TgVh2fslzwzhrood7O+fScgJmmT+XN3et0luwkvpD60Kol5xD0dEOabH/f1RJNpvcQKBgQCuit+QhdN5d353UAWyPEZnrQmmfDU6yP280ELU0/AmC6nghRD7dz8ZXo+LmRMuekEeNX4l0HU1LNhjmcW4El6112ZfVtt7znI7yqq7m7SYHhewJT2xrDq6m9yhGa8j2TGZNrSb+cEYv8kJcBNZMMQytHVTg6h4vA01S4KUOK97JwKBgEIRIXjZxctQXqgcf73Oqb91ljkCle35KoxB1VcU0r+gXP81QqwwXRWzdOF6jzzACLi3hTZHeLG3QBUpu5s92357DBDVlQKa8clHsjnhDiOfmXFFA/g0r1g6antGiG1ACRNxL0QgDQe4jLy1fxzcEuj2d+/kq0zjpwlmLhb3cwFxAoGAJzS4jR0SaIln1eMatHOHmQgsT8I8rqyxGjVpnabRnaonCXC6ZNHfUZKFCeVjgqAheminolTVzxD4tj63Q+aUcaIls6qt+Hxh+n5GpYePJFA2H/HtjrhSJNKX13QOfC3wTysTnKmYLzf9L2qGXhVvLLiOVikPsbcD/IGunh6xhCcCgYAvtXpHRZN2xy66d1VrMeqhfddj+lDmp0ZkbbeyZHLovk2G4jOjck0CMHffMbYoi5Up2Opi6Gn2G2roO6EvLmPt8zneEDc9NfwdbQLVc7sHk4WaaZIWHl/9kyKLjO6PrjyN+IJ/W8GhDo1aXG+3bARmnqVhHQnARx6dw610JFy34g==";
		String BouPublic = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn9/lE9HbqaS/6GqkysCZgyUkeLkxOQKiosmGt5N3JA3qit4sP0yZh9HEtZk85S9xDVLUJkCEa2SIDEIWExpEVe3CI5TN8chXh/qyH0TqoHbkfrf2xkolYZFGYM/BcGj6I3bOVKFSTkwuxVmncgLrk0q7a6e5mgAwYxy9iMB0aOM56j37oEdOzOLl8giAhxvu2AorsPxfewfwnvnFXDvSQHtcQJhJDBZOl7lW9pl0fdqD2ct9/3lip//klMnj79IOncsFJ8JHwC1dpNdJk2PxWS1nzKgHsDlIKfnWPdqI+C2DYGU1Z71mXLXynBSogQiThfUWrSHgUlRB4WPsdurfawIDAQAB";
		BouMasterDto bouMasterDTO = new BouMasterDto();
		
		//24-01-2025 Step=2 Get ciphertext
		String plainMsg="{\"agentInstitutionId\":\"SB42\",\"token\":\"6ffbeb77133c15ca241565135e103a78\"}";
				PublicKey pkey=BbpsSecurityUtil.getPublicKey(BouPublic);
				//PublicKey aeskey=BbpsSecurityUtil.getPublicKey(aesToken);
		
				String NBCIID="OU01OU02INT522274495200721ahbcj2123";
				//----------------------------------------------------------------------------
				ZonedDateTime now2 = ZonedDateTime.now();
				DateTimeFormatter rrnform = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
				String rrnTimestamp = now2.format(rrnform);
				 NBCIID="OU01OU02INT"+rrnTimestamp+"1ahbcj2123";
				
				//--------------------------------------------------------------------------
			
		//24-01-2025 Step=3 Get Timestamp
						DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'+05:30'");
					String formattedTimestamp = now2.format(formatter2);
					System.out.println("Formatted Timestamp: " + formattedTimestamp);
					//String requestId="{\"head\":{\"requestId\":\""+NBCIID+"\",\"ts\":\""+formattedTimestamp+"\"},\"search\":{\"status\":\"Active\"}}";
					//String requestId="{\"head\":{\"requestId\":\""+NBCIID+"\",\"ts\":\""+formattedTimestamp+"\"},\"billerId\":\""+billerId+"\"}";
					String jsonRequest = "{\"head\":{\"requestId\":\"OU01OU02INT522274495200721sx3cj2ab6\",\"ts\":\"2020-07-21T22:02:35+05:30\"},\"customer\":{\"mobile\":\"7466598081\",\"email\":\"\",\"aadhaar\":\"\",\"pan\":\"\"},\"agent\":{\"id\":\"OU01OU21MOB527011179\",\"initiatingChannel\":\"INTB\",\"ip\":\"124.170.23.28\",\"mac\":\"01-23-45-67-89-ab\",\"ifsc\":\"\",\"deviceId\":\"\",\"os\":\"\",\"app\":\"\",\"terminalId\":\"\"},\"billDetails\":{\"billerId\":\"OTOE00005XXZ43\",\"customerParams\":[{\"name\":\"Consumer Number\",\"value\":\"10150181\"},{\"name\":\"Mobile Number\",\"value\":\"9699381878\"}]}}";
				    //Working   
					//String requestId = "{\"head\":{\"requestId\":\""+NBCIID+"\",\"ts\":\""+formattedTimestamp+"\"},\"customer\":{\"mobile\":\"7466598081\",\"email\":\"\",\"aadhaar\":\"\",\"pan\":\"\"},\"agent\":{\"id\":\"SB41SB42INB519046223\",\"initiatingChannel\":\"INTB\",\"ip\":\"124.170.23.28\",\"mac\":\"01-23-45-67-89-ab\",\"ifsc\":\"\",\"deviceId\":\"\",\"os\":\"\",\"app\":\"\",\"terminalId\":\"\"},\"billDetails\":{\"billerId\":\""+billerId+"\",\"customerParams\":[{\"name\":\"Consumer Number\",\"value\":\"10150181\"},{\"name\":\"Mobile Number\",\"value\":\"9699381878\"}]}}";
				       String requestId = "{\"head\":{\"requestId\":\""+NBCIID+"\",\"ts\":\""+formattedTimestamp+"\"},\"customer\":{\"mobile\":\"7466598081\",\"email\":\"\",\"aadhaar\":\"\",\"pan\":\"\"},\"agent\":{\"id\":\"SB41SB42INB519046223\",\"initiatingChannel\":\"INTB\",\"ip\":\"124.170.23.28\",\"mac\":\"01-23-45-67-89-ab\",\"ifsc\":\"\",\"deviceId\":\"\",\"os\":\"\",\"app\":\"\",\"terminalId\":\"\"},\"billDetails\":{\"billerId\":\""+billerId+"\",\"customerParams\":[{\"name\":\""+paramName+"\",\"value\":\""+paramValue+"\"}]}}";

				       
				       String json = "{\"head\": {\"ver\": \"1.0\",\"origInst\": \"SB41\",\"requestId\": \"SB41BD363BF4MB66FM4862M987F50651333\",\"ts\": \"2025-03-06T13:33:38+05:30\"},\"customer\": {\"mobile\": \"9012345751\",\"email\": \"test@sbi.com\"},\"agent\": {\"id\": \"SB41SB42INB519046223\",\"initiatingChannel\": \"INT\",\"ip\": \"124.170.23.24\",\"mac\": \"01-23-45-67-89-ab\"},\"billDetails\": {\"billerId\": \"OU1201000MEE17\",\"customerParams\": [{\"name\": \"Roll No\",\"value\": \"501\"}]}}";
					//String requestId = "{\"head\": {\"ver\": \"1.0\",\"origInst\": \"SB41\",\"requestId\": \"requestId\":\""+NBCIID+"\",\"ts\":\""+formattedTimestamp+"\"},\"customer\": {\"mobile\": \"9012345751\",\"email\": \"test@sbi.com\"},\"agent\": {\"id\": \"SB41SB42INB519046223\",\"initiatingChannel\": \"INT\",\"ip\": \"124.170.23.24\",\"mac\": \"01-23-45-67-89-ab\"},\"billDetails\": {\"billerId\": \""+billerId+"\",\"customerParams\": [{\"name\": \"Roll No\",\"value\": \"501\"}]}}";

    	String ciphertext=securityUtils.encryptAesGcm(requestId, aesToken);
					//String ciphertext=securityUtils.encryptRsaMessage( requestId,aesToken);
					System.out.println("ciphertext="+ciphertext);
		//24-01-2025 Step=4 Generate DigitalSignature		
					requestDTO.setCipherText(ciphertext);
					requestDTO.setTimeStamp(formattedTimestamp);
					requestDTO.setRrn(RRN);
					PrivateKey privatekey=BbpsSecurityUtil.getPrivateKey(getBillerPrivate);
					 digitalSignature = securityUtils.generateDigitalSignature(requestDTO.getRrn() + requestDTO.getTimeStamp() + requestDTO.getCipherText(), privatekey);
						System.out.println("digitalSignature: " + digitalSignature);

						//24-01-2025 Step=5 Generate EncryptedRequest			

		//encryptedRequestMsg = "{" + "\"rrn\":\"SB5120210212093848ee3b04f1043344f87\"," + "\"cipherText\":\"3412C8F35979A2D92F92B7EA8A6183ECB1EDA5C896276562D80AA83F7C8C033BCCE43E2FAD9EAB5A0334CE8454392DB0DCA969469F3F5917B86335D986EE8275B87241DB1AF4A6499373DD6EA5A711EB634A7CAE352D4D3DA89D9F535A3971E12EB65058D2A001B039CE03FDEABB56C481488CC452FB117EF39D011339FAA09BD992EEA4D456FBCB877D9CA86E2D60613A48F61A99E8C3C88F6FE117ED1B0ADC83B2E406AB4075A882DD207880DDEFBBABD96A2EAEBD57BBD72BC29C1E530C11ECDB4AB1982E419840863D1A3078AF96746D1400D4A3D5AA68431E88676FB52F8B47B8F14C0000B659BA23ED7636D9FC57212922069324B991517A1912EDA7F4FA8641279A94B013F98F3DA950EC001A1E65F8A604849AFB663630BBFAA55C3885F1815EEB6B0AB94D25A00510B76A436F6E076333CD9802F83D9C0F6EE473A468C4633AB1A1F1D5C86E398197D374305CB14251CE0691E1AFBDFBE5783D20FA86D256050DE205DD90AC5CE3\"," + "\"digitalSig\":\"A7dIKgs8l8fndu7p/YNOigM5Gj32IgXiIDoYtZb0mfKW8yfWXPwYQDmMy7LYE1Vrk3c2r1eywWr7Wu1LJkyJ4RCp8H2nSjUpEpHYsaU3qV4vQyhSKWLjhEFOWcn9zqnwLaZAAd8zZCK7uorQFky02t28SOaVfcGU/3UhHxZVGXgOzJGSUVZlO6xFYnq91/GCbE9Bo9uNVENYWKtMXCPHb/8C4tYl9UMpVFurXYmUJq9U5ZJos0+JykjLUt3ly/LvCKegE6gnRuGCuvvnLi22HsDNWj3unW+ytbU9inA0gBkPaELH4fK9f3cs7U3b+A6KmX1VdJeSJVm9JAdkvGdu5A==\"," + "\"timeStamp\":\"2021-02-12T21:38:48+05:30\"" + "}";
		encryptedRequestMsg = "{" + "\"rrn\":\""+requestDTO.getRrn()+"\"," + "\"cipherText\":\""+requestDTO.getCipherText()+"\"," + "\"digitalSig\":\""+digitalSignature+"\"," + "\"ts\":\""+requestDTO.getTimeStamp()+"\"" + "}";

		System.out.println("EncryptedRequest: " + encryptedRequestMsg);
		 String ResponseMsg="";
		 int responseCode=0;
		  StringBuilder response = new StringBuilder();
		  try {
      	    // URL of the API endpoint
			  URL url = new URL("https://uatsbiunipay.sbi/bbps-cou-switch/billFetch");
      	       HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      	    
      	    // Setting the request method to POST
      	    conn.setRequestMethod("POST");
      	    conn.setRequestProperty("Content-Type", "application/json; utf-8");
      	    conn.setRequestProperty("Accept", "application/json");
      	    conn.setDoOutput(true);

      	    // JSON payload
      	   
      	    String jsonInputString = encryptedRequestMsg;
      	    //String jsonInputString="{\"amt\":\"qg8lfycy0Ps=\",\"accNum\":\"QDvcz8lILVw1I6YUpkHHAw==\",\"hname\":\"v+yG16PsTsA=\",\"bal\":\"osN4bh2XAuVefhxwIn3QfQ==\",\"atype\":\"Qzwj51FVXG8=\"}";
      	    // Sending the JSON payload
      	    try (OutputStream os = conn.getOutputStream()) {
      	        byte[] input = jsonInputString.getBytes("utf-8");
      	        os.write(input, 0, input.length);
      	    }
      	// Read the response
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
              
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Response: " + response.toString());
                loginEntity.setOTP(response.toString());
            }
      	    // Reading the response
      	     responseCode = conn.getResponseCode();
      	    System.out.println("Response Code: " + conn.getResponseMessage());
      	  ResponseMsg=responseCode+": "+conn.getResponseMessage();
      	    // Handle the response (omitted for brevity)

      	} catch (Exception e) {
      	    
      		
      		loginEntity.setOTP(""+e.fillInStackTrace());
      		e.printStackTrace();
      	    
      	 
      	}

		// final Login1 login = new Login1();
        // model.clear();
         model.put("loginEntity5", loginEntity);
         mp.put("encryptedRequestMsg", encryptedRequestMsg);
         loginEntity.setBranch_Type("Request Id \n:"+requestId+"\n  Cipher :"+ciphertext+" \n Encripted Msg :"+encryptedRequestMsg+"\nResponse Code: " + ResponseMsg);
         System.out.println("response.toString()="+response.toString());
         
         System.out.println("response.toString()="+response.toString());

         mp.put("OTP", response.toString());
        // mp.put("OTP1", response.toString());
         loginEntity.setOTP(response.toString());
         loginEntity.setEncryptedMsg(encryptedRequestMsg);
         //login.setOTP1(response.toString());
         
        // loginEntity.setOTP("Request Id \n:"+requestId+"\n  Cipher :"+ciphertext+" \n Encripted Msg :"+encryptedRequestMsg+"\nResponse Code: " + ResponseMsg);

         mp.put("AesToken", loginEntity.getAesToken());
         mp.put("Rrn_No", loginEntity.getRrn_No());


       
    //----------------------------------------------------------------------------------		

			String plainMsgBillerDetails=loginEntity.getEncryptedMsg();
	    	String ciphertextBillerDetails=securityUtils.encryptRsaMessage( plainMsgBillerDetails,pkey);
				System.out.println("ciphertext="+ciphertext);
				String TokenResponseMsg=loginEntity.getOTP().replace("\"ts\"", "\"timeStamp\"");
		
				System.out.println("TokenResponseMsg="+TokenResponseMsg );

		EncryptedRequestDto tokenRespenseDTO =new EncryptedRequestDto();
tokenRespenseDTO = JsonConverterUtilityP.convertStringToJsonObject(TokenResponseMsg, EncryptedRequestDto.class);
String signatureReqStr1 = tokenRespenseDTO.getRrn()+tokenRespenseDTO.getTimeStamp()+tokenRespenseDTO.getCipherText();
System.out.println("signatureReqStr1="+signatureReqStr1 );

//24-01-2025 Step=7 Verify TokenResponse with digital signature
isVerified = securityUtils.verifyDigitalSignature(signatureReqStr1, tokenRespenseDTO.getDigitalSig(), pkey); //give BOU public key here
System.out.println("isVerified="+isVerified );
/*if (!isVerified)
{
	EncryptedResponseDto responseDTO = new EncryptedResponseDto();
	responseDTO.setCipherText("Invalid Digital Signature");
	encryptedResponseMsg = JsonConverterUtilityP.convertJsonObjectToString(tokenRespenseDTO);
	return "/"; //return failure response here
}*/
//24-01-2025 Step=8 Get AES Key from Response
try {
	//aesToken
	decryptedAesKey =securityUtils.decryptAesGcm(tokenRespenseDTO.getCipherText(), aesToken);
	//decryptedAesKey = securityUtils.decryptMessage( tokenRespenseDTO.getCipherText(),privatekey);
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
String accessToken = null;
String requestId2 ="";
String refId = "";
String msgId = "";

try {
    ObjectMapper objectMapper = new ObjectMapper();

    // Deserialize the JSON string into the Java object (Response)
    Response responseBillerDetails = objectMapper.readValue(decryptedAesKey, Response.class);
     // db.insertResponseData(response);
    JsonNode rootNode = objectMapper.readTree(decryptedAesKey);

    // Extract values from the JSON using JsonNode
    JsonNode headNode = rootNode.path("head");
    requestId2 = headNode.path("requestId").asText();
    refId = headNode.path("refId").asText();
    msgId = headNode.path("msgId").asText();

   // insertStates(response.getStateList());
      
} catch (Exception e) {
    e.printStackTrace();
}



// Now you have the Java object
//System.out.println(response);

mp.put("signatureReqStr1", signatureReqStr1 );
//final Login1 login = new Login1();
model.put("loginEntity", loginEntity);
loginEntity.setEncryptedMsg(plainMsg);
loginEntity.setOTP(decryptedAesKey );
loginEntity.setOTP1(""+isVerified+" op="+decryptedAesKey);
loginEntity.setBranch_Type("CypherTxt :"+ciphertext+" \n signatureReqStr1 : "+signatureReqStr1);

mp.put("AesToken", loginEntity.getAesToken());
mp.put("Rrn_No", loginEntity.getRrn_No());
mp.put("billJson", decryptedAesKey);

mp.put("requestId", NBCIID);
mp.put("refId", refId);
mp.put("msgId", msgId);



return "ServiceList";


    	
    	}
    	
    	
    	
    	
    	
    	

}
    
    
    @RequestMapping(value = { "/LoginValidate" },params="BillerValidateView", method = { RequestMethod.POST })
    public String BillerValidateView(@Valid @ModelAttribute("loginEntity") final Login1 loginEntity, final BindingResult result, final ModelMap mp,  HttpSession session, final HttpServletRequest request, final Map<String, Object> model, final RedirectAttributes attributes) throws SQLException, ParseException, IOException {
    	{
    		String uniqueID = UUID.randomUUID().toString();

    		String id="SB42";
    		String agentInstid="SB42";
    		String token="6ffbeb77133c15ca241565135e103a78";
    		//String aesToken=loginEntity.getOTP1();
    		
    		String RRN=loginEntity.getRrn_No();
    		String aesToken=loginEntity.getAesToken();
    		
    		//String user= loginEntity.getUsername();
        	//	String pass=loginEntity.getPassword();
        		
        		String billerId=loginEntity.getAgentId();
                
        		String paramName=loginEntity.getParamName1();
        		String paramValue=loginEntity.getParamValue1();
        		
        		String paramName2=loginEntity.getParamName2();
        		String paramValue2=loginEntity.getParamValue2();
        		
        		
        		String agentId="6ffbeb77133c15ca241565135e103a78";

    		
		EncryptedRequestDto requestDTO =new EncryptedRequestDto();
		BillFetchRequestBean decryptedRequestDto = null;

		String decryptedResponseMsg = null;
		String encryptedResponseMsg = null;

		String encryptedRequestMsg = null;
		String decryptedRequestMsg = null;
		String encryptedAesKey = null;
		String decryptedAesKey = null;

		String timeStamp = null;
		String digitalSignature = null;
		boolean isVerified = false;
		boolean isValid = false;
		String getBillerPrivate = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgboeBDYUm/hLhirbB0Jb05XJEf/ji5SUC5LuqpQhnKhX3RJ0qxdOIzhG5lv4+FN+Yi/1DvCcDN8I2AsNzLABuuoeva/qYWhrs3808jPl2PiFIPv7EeRkfKzswN40Ov/d/05jdNQ1hg6vdylhD0sig5BJtmp3jimPGhSpQgowqvdPXSYwAuj2juea8pSJSPkU1BfPWM7WJWzeoUrNptaAV3sgZ5sa3yEuYPBTJr7/uP9mCMciu9GAxOzN0+awet1RFHfPXtWgIAi9RxgrOW6jSDYI9NqleC41jQyJR/E2uvUIJ/OlqL3L6bH0/PxkOuzy+biUv0qGB97DqXRh3EUU3AgMBAAECggEAd40GEwhFMiJhZYsd114eL86PkTYf/MyvAPH8WxRyJ5Z4GfQafpY+pRKSqM85FIAvgxjGmWQrWj2BzwfOKBQhGmKL3BBGBKQYrm20HiwbdZ6k5JZ0+WoYa16m066Bwf0RbUL8BdOT7hfVyggQMDJx6Vsr1FtEzxwAcB4pwycVVn8/ZFk+maoIptb7oOrVf/A1OaiwFHrUplQFwL9bOjrnaz6sPmGStpSU6NHVkUVlH/J8V/ag2iYt9QUQiLg6/jroMQegixZAi5g3fQKQ/2oOKy+6JKfxcN982X7Zy36gULhs/VJ+SeD/+YjqfIaNJtqDpeunlSGLGG8W+4f6nUp9IQKBgQDrTc4VG7x1AS6gc9wG7xcjSUWHK0tQow8rl64Y4KAb3iyKismNtgg8qkRERhJ+ZZulr07IUZE/M+doqNmoShtpcuGguUgcKGgfaCBo4351TgVh2fslzwzhrood7O+fScgJmmT+XN3et0luwkvpD60Kol5xD0dEOabH/f1RJNpvcQKBgQCuit+QhdN5d353UAWyPEZnrQmmfDU6yP280ELU0/AmC6nghRD7dz8ZXo+LmRMuekEeNX4l0HU1LNhjmcW4El6112ZfVtt7znI7yqq7m7SYHhewJT2xrDq6m9yhGa8j2TGZNrSb+cEYv8kJcBNZMMQytHVTg6h4vA01S4KUOK97JwKBgEIRIXjZxctQXqgcf73Oqb91ljkCle35KoxB1VcU0r+gXP81QqwwXRWzdOF6jzzACLi3hTZHeLG3QBUpu5s92357DBDVlQKa8clHsjnhDiOfmXFFA/g0r1g6antGiG1ACRNxL0QgDQe4jLy1fxzcEuj2d+/kq0zjpwlmLhb3cwFxAoGAJzS4jR0SaIln1eMatHOHmQgsT8I8rqyxGjVpnabRnaonCXC6ZNHfUZKFCeVjgqAheminolTVzxD4tj63Q+aUcaIls6qt+Hxh+n5GpYePJFA2H/HtjrhSJNKX13QOfC3wTysTnKmYLzf9L2qGXhVvLLiOVikPsbcD/IGunh6xhCcCgYAvtXpHRZN2xy66d1VrMeqhfddj+lDmp0ZkbbeyZHLovk2G4jOjck0CMHffMbYoi5Up2Opi6Gn2G2roO6EvLmPt8zneEDc9NfwdbQLVc7sHk4WaaZIWHl/9kyKLjO6PrjyN+IJ/W8GhDo1aXG+3bARmnqVhHQnARx6dw610JFy34g==";
		String BouPublic = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn9/lE9HbqaS/6GqkysCZgyUkeLkxOQKiosmGt5N3JA3qit4sP0yZh9HEtZk85S9xDVLUJkCEa2SIDEIWExpEVe3CI5TN8chXh/qyH0TqoHbkfrf2xkolYZFGYM/BcGj6I3bOVKFSTkwuxVmncgLrk0q7a6e5mgAwYxy9iMB0aOM56j37oEdOzOLl8giAhxvu2AorsPxfewfwnvnFXDvSQHtcQJhJDBZOl7lW9pl0fdqD2ct9/3lip//klMnj79IOncsFJ8JHwC1dpNdJk2PxWS1nzKgHsDlIKfnWPdqI+C2DYGU1Z71mXLXynBSogQiThfUWrSHgUlRB4WPsdurfawIDAQAB";
		BouMasterDto bouMasterDTO = new BouMasterDto();
		
		//24-01-2025 Step=2 Get ciphertext
		String plainMsg="{\"agentInstitutionId\":\"SB42\",\"token\":\"6ffbeb77133c15ca241565135e103a78\"}";
				PublicKey pkey=BbpsSecurityUtil.getPublicKey(BouPublic);
				//PublicKey aeskey=BbpsSecurityUtil.getPublicKey(aesToken);
		
				String NBCIID="OU01OU02INT522274495200721ahbcj2123";
				//----------------------------------------------------------------------------
				ZonedDateTime now2 = ZonedDateTime.now();
				DateTimeFormatter rrnform = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
				String rrnTimestamp = now2.format(rrnform);
				 NBCIID="OU01OU02INT"+rrnTimestamp+"1ahbcj2123";
				
				//--------------------------------------------------------------------------
			
		//24-01-2025 Step=3 Get Timestamp
						DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'+05:30'");
					String formattedTimestamp = now2.format(formatter2);
					System.out.println("Formatted Timestamp: " + formattedTimestamp);
					String jsonString = "{\"head\": {\"requestId\": \"OU01OU02INT522274495200721sx3cj2ab6\", \"ts\": \"2020-07-21T22:02:35+05:30\"}, \"agent\": {\"id\": \"OU01OU21MOB527011179\"}, \"billDetails\": {\"billerId\": \"OTOE00005XXZ43\", \"customerParams\": [{\"name\": \"Consumer Number\", \"value\": \"10150181\"}, {\"name\": \"Mobile Number\", \"value\": \"9699381878\"}]}, \"amountDetails\": {\"txnAmount\": \"101000\", \"splitPayAmount\": \"0\", \"custConvFee\": \"100\", \"custConvFeeDesc\": \"BOU to COU Fees\", \"couCustConvFee\": \"500\", \"couCustConvFeeDesc\": \"Agent Convenience Fees\"}}";
					//String requestId = "{\"head\":{\"requestId\":\""+NBCIID+"\",\"ts\":\""+formattedTimestamp+"\"}, \"agent\": {\"id\": \""+agentInstid+"\"}, \"billDetails\": {\"billerId\": \""+billerId+"\", \"customerParams\": [{\"name\": \""+paramName+"\", \"value\": \""+paramValue+"\"}, {\"name\": \""+paramName2+"\", \"value\": \""+paramValues2+"\"}]}, \"amountDetails\": {\"txnAmount\": \"101000\", \"splitPayAmount\": \"0\", \"custConvFee\": \"100\", \"custConvFeeDesc\": \"BOU to COU Fees\", \"couCustConvFee\": \"500\", \"couCustConvFeeDesc\": \"Agent Convenience Fees\"}}";
					String requestId = "{\"head\":{\"ver\": \"1.0\",\"origInst\": \"SB41\",\"requestId\":\""+NBCIID+"\",\"ts\":\""+formattedTimestamp+"\"}, \"agent\": {\"id\": \"SB41SB42INB519046223\"}, \"billDetails\": {\"billerId\": \""+billerId+"\", \"customerParams\": [{\"name\": \""+paramName+"\", \"value\": \""+paramValue+"\"}, {\"name\": \""+paramName2+"\", \"value\": \""+paramValue2+"\"}]}}";

				       
				       String json = "{\"head\": {\"ver\": \"1.0\",\"origInst\": \"SB41\",\"requestId\": \"SB41BD363BF4MB66FM4862M987F50651333\",\"ts\": \"2025-03-06T13:33:38+05:30\"},\"customer\": {\"mobile\": \"9012345751\",\"email\": \"test@sbi.com\"},\"agent\": {\"id\": \"SB41SB42INB519046223\",\"initiatingChannel\": \"INT\",\"ip\": \"124.170.23.24\",\"mac\": \"01-23-45-67-89-ab\"},\"billDetails\": {\"billerId\": \"OU1201000MEE17\",\"customerParams\": [{\"name\": \"Roll No\",\"value\": \"501\"}]}}";
					//String requestId = "{\"head\": {\"ver\": \"1.0\",\"origInst\": \"SB41\",\"requestId\": \"requestId\":\""+NBCIID+"\",\"ts\":\""+formattedTimestamp+"\"},\"customer\": {\"mobile\": \"9012345751\",\"email\": \"test@sbi.com\"},\"agent\": {\"id\": \"SB41SB42INB519046223\",\"initiatingChannel\": \"INT\",\"ip\": \"124.170.23.24\",\"mac\": \"01-23-45-67-89-ab\"},\"billDetails\": {\"billerId\": \""+billerId+"\",\"customerParams\": [{\"name\": \"Roll No\",\"value\": \"501\"}]}}";

    	String ciphertext=securityUtils.encryptAesGcm(requestId, aesToken);
					//String ciphertext=securityUtils.encryptRsaMessage( requestId,aesToken);
					System.out.println("ciphertext="+ciphertext);
		//24-01-2025 Step=4 Generate DigitalSignature		
					requestDTO.setCipherText(ciphertext);
					requestDTO.setTimeStamp(formattedTimestamp);
					requestDTO.setRrn(RRN);
					PrivateKey privatekey=BbpsSecurityUtil.getPrivateKey(getBillerPrivate);
					 digitalSignature = securityUtils.generateDigitalSignature(requestDTO.getRrn() + requestDTO.getTimeStamp() + requestDTO.getCipherText(), privatekey);
						System.out.println("digitalSignature: " + digitalSignature);

						//24-01-2025 Step=5 Generate EncryptedRequest			

		//encryptedRequestMsg = "{" + "\"rrn\":\"SB5120210212093848ee3b04f1043344f87\"," + "\"cipherText\":\"3412C8F35979A2D92F92B7EA8A6183ECB1EDA5C896276562D80AA83F7C8C033BCCE43E2FAD9EAB5A0334CE8454392DB0DCA969469F3F5917B86335D986EE8275B87241DB1AF4A6499373DD6EA5A711EB634A7CAE352D4D3DA89D9F535A3971E12EB65058D2A001B039CE03FDEABB56C481488CC452FB117EF39D011339FAA09BD992EEA4D456FBCB877D9CA86E2D60613A48F61A99E8C3C88F6FE117ED1B0ADC83B2E406AB4075A882DD207880DDEFBBABD96A2EAEBD57BBD72BC29C1E530C11ECDB4AB1982E419840863D1A3078AF96746D1400D4A3D5AA68431E88676FB52F8B47B8F14C0000B659BA23ED7636D9FC57212922069324B991517A1912EDA7F4FA8641279A94B013F98F3DA950EC001A1E65F8A604849AFB663630BBFAA55C3885F1815EEB6B0AB94D25A00510B76A436F6E076333CD9802F83D9C0F6EE473A468C4633AB1A1F1D5C86E398197D374305CB14251CE0691E1AFBDFBE5783D20FA86D256050DE205DD90AC5CE3\"," + "\"digitalSig\":\"A7dIKgs8l8fndu7p/YNOigM5Gj32IgXiIDoYtZb0mfKW8yfWXPwYQDmMy7LYE1Vrk3c2r1eywWr7Wu1LJkyJ4RCp8H2nSjUpEpHYsaU3qV4vQyhSKWLjhEFOWcn9zqnwLaZAAd8zZCK7uorQFky02t28SOaVfcGU/3UhHxZVGXgOzJGSUVZlO6xFYnq91/GCbE9Bo9uNVENYWKtMXCPHb/8C4tYl9UMpVFurXYmUJq9U5ZJos0+JykjLUt3ly/LvCKegE6gnRuGCuvvnLi22HsDNWj3unW+ytbU9inA0gBkPaELH4fK9f3cs7U3b+A6KmX1VdJeSJVm9JAdkvGdu5A==\"," + "\"timeStamp\":\"2021-02-12T21:38:48+05:30\"" + "}";
		encryptedRequestMsg = "{" + "\"rrn\":\""+requestDTO.getRrn()+"\"," + "\"cipherText\":\""+requestDTO.getCipherText()+"\"," + "\"digitalSig\":\""+digitalSignature+"\"," + "\"ts\":\""+requestDTO.getTimeStamp()+"\"" + "}";

		System.out.println("EncryptedRequest: " + encryptedRequestMsg);
		 String ResponseMsg="";
		 int responseCode=0;
		  StringBuilder response = new StringBuilder();
		  try {
      	    // URL of the API endpoint
			  URL url = new URL("https://uatsbiunipay.sbi/bbps-cou-switch/billValidate");
      	       HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      	    
      	    // Setting the request method to POST
      	    conn.setRequestMethod("POST");
      	    conn.setRequestProperty("Content-Type", "application/json; utf-8");
      	    conn.setRequestProperty("Accept", "application/json");
      	    conn.setDoOutput(true);

      	    // JSON payload
      	   
      	    String jsonInputString = encryptedRequestMsg;
      	    //String jsonInputString="{\"amt\":\"qg8lfycy0Ps=\",\"accNum\":\"QDvcz8lILVw1I6YUpkHHAw==\",\"hname\":\"v+yG16PsTsA=\",\"bal\":\"osN4bh2XAuVefhxwIn3QfQ==\",\"atype\":\"Qzwj51FVXG8=\"}";
      	    // Sending the JSON payload
      	    try (OutputStream os = conn.getOutputStream()) {
      	        byte[] input = jsonInputString.getBytes("utf-8");
      	        os.write(input, 0, input.length);
      	    }
      	// Read the response
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
              
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Response: " + response.toString());
                loginEntity.setOTP(response.toString());
            }
      	    // Reading the response
      	     responseCode = conn.getResponseCode();
      	    System.out.println("Response Code: " + conn.getResponseMessage());
      	  ResponseMsg=responseCode+": "+conn.getResponseMessage();
      	    // Handle the response (omitted for brevity)

      	} catch (Exception e) {
      	    
      		
      		loginEntity.setOTP(""+e.fillInStackTrace());
      		e.printStackTrace();
      	    
      	 
      	}

		// final Login1 login = new Login1();
        // model.clear();
         model.put("loginEntity", loginEntity);
         mp.put("encryptedRequestMsg", encryptedRequestMsg);
         loginEntity.setBranch_Type("Request Id \n:"+requestId+"\n  Cipher :"+ciphertext+" \n Encripted Msg :"+encryptedRequestMsg+"\nResponse Code: " + ResponseMsg);
         System.out.println("response.toString()="+response.toString());

         System.out.println("response.toString()="+response.toString());

         mp.put("OTP", response.toString());
         loginEntity.setOTP("Request Id \n:"+requestId+"\n  Cipher :"+ciphertext+" \n Encripted Msg :"+encryptedRequestMsg+"\nResponse Code: " + ResponseMsg);

         loginEntity.setOTP(response.toString());
         loginEntity.setEncryptedMsg(encryptedRequestMsg);
         //login.setOTP1(response.toString());
         
         //loginEntity.setOTP("Request Id \n:"+requestId+"\n  Cipher :"+ciphertext+" \n Encripted Msg :"+encryptedRequestMsg+"\nResponse Code: " + ResponseMsg);

         mp.put("AesToken", loginEntity.getAesToken());
         mp.put("Rrn_No", loginEntity.getRrn_No());


       
    //----------------------------------------------------------------------------------		

			String plainMsgBillerDetails=loginEntity.getEncryptedMsg();
	    	String ciphertextBillerDetails=securityUtils.encryptRsaMessage( plainMsgBillerDetails,pkey);
				System.out.println("ciphertext="+ciphertext);
				String TokenResponseMsg=loginEntity.getOTP().replace("\"ts\"", "\"timeStamp\"");
		
				System.out.println("TokenResponseMsg="+TokenResponseMsg );

		EncryptedRequestDto tokenRespenseDTO =new EncryptedRequestDto();
tokenRespenseDTO = JsonConverterUtilityP.convertStringToJsonObject(TokenResponseMsg, EncryptedRequestDto.class);
String signatureReqStr1 = tokenRespenseDTO.getRrn()+tokenRespenseDTO.getTimeStamp()+tokenRespenseDTO.getCipherText();
System.out.println("signatureReqStr1="+signatureReqStr1 );

//24-01-2025 Step=7 Verify TokenResponse with digital signature
isVerified = securityUtils.verifyDigitalSignature(signatureReqStr1, tokenRespenseDTO.getDigitalSig(), pkey); //give BOU public key here
System.out.println("isVerified="+isVerified );

//24-01-2025 Step=8 Get AES Key from Response
try {
	//aesToken
	decryptedAesKey =securityUtils.decryptAesGcm(tokenRespenseDTO.getCipherText(), aesToken);
	//decryptedAesKey = securityUtils.decryptMessage( tokenRespenseDTO.getCipherText(),privatekey);
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
String accessToken = null;
try {
    ObjectMapper objectMapper = new ObjectMapper();

    // Deserialize the JSON string into the Java object (Response)
    Response responseBillerDetails = objectMapper.readValue(decryptedAesKey, Response.class);
     // db.insertResponseData(response);
    
   // insertStates(response.getStateList());
      
} catch (Exception e) {
    e.printStackTrace();
}



// Now you have the Java object
//System.out.println(response);

mp.put("signatureReqStr1", signatureReqStr1 );
//final Login1 login = new Login1();
model.put("loginEntity", loginEntity);
loginEntity.setEncryptedMsg(plainMsg);
loginEntity.setOTP(decryptedAesKey );
loginEntity.setOTP1(""+isVerified+" op="+decryptedAesKey);
loginEntity.setBranch_Type("CypherTxt :"+ciphertext+" \n signatureReqStr1 : "+signatureReqStr1);
loginEntity.setOTP("Request Id \n:"+requestId+"\n  Cipher :"+ciphertext+" \n Encripted Msg :"+encryptedRequestMsg+"\ndecryptedAesKey: " + decryptedAesKey);


mp.put("AesToken", loginEntity.getAesToken());
mp.put("Rrn_No", loginEntity.getRrn_No());
mp.put("billJson", decryptedAesKey);
model.put("loginEntity", loginEntity);

return "ServiceList";


    	
    	}
    	
    	
    	
    	
    	
    	

}

    @RequestMapping(value = { "/LoginValidate" },params="BillerPayView", method = { RequestMethod.POST })
    public String BillerPayView(@Valid @ModelAttribute("loginEntity") final Login1 loginEntity, final BindingResult result, final ModelMap mp,  HttpSession session, final HttpServletRequest request, final Map<String, Object> model, final RedirectAttributes attributes) throws SQLException, ParseException, IOException 
    	{
    		String uniqueID = UUID.randomUUID().toString();

    		String id="SB42";
    		String agentInstid="SB42";
    		String token="6ffbeb77133c15ca241565135e103a78";
    		//String aesToken=loginEntity.getOTP1();
    		
    		String RRN=loginEntity.getRrn_No();
    		String aesToken=loginEntity.getAesToken();
    		
    		//String user= loginEntity.getUsername();
        	//	String pass=loginEntity.getPassword();
        		
        		String billerId=loginEntity.getAgentId();
                
        		String paramName=loginEntity.getParamName1();
        		String paramValue=loginEntity.getParamValue1();

    		
		EncryptedRequestDto requestDTO =new EncryptedRequestDto();
		BillFetchRequestBean decryptedRequestDto = null;

		String decryptedResponseMsg = null;
		String encryptedResponseMsg = null;

		String encryptedRequestMsg = null;
		String decryptedRequestMsg = null;
		String encryptedAesKey = null;
		String decryptedAesKey = null;

		String timeStamp = null;
		String digitalSignature = null;
		boolean isVerified = false;
		boolean isValid = false;
		String getBillerPrivate = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgboeBDYUm/hLhirbB0Jb05XJEf/ji5SUC5LuqpQhnKhX3RJ0qxdOIzhG5lv4+FN+Yi/1DvCcDN8I2AsNzLABuuoeva/qYWhrs3808jPl2PiFIPv7EeRkfKzswN40Ov/d/05jdNQ1hg6vdylhD0sig5BJtmp3jimPGhSpQgowqvdPXSYwAuj2juea8pSJSPkU1BfPWM7WJWzeoUrNptaAV3sgZ5sa3yEuYPBTJr7/uP9mCMciu9GAxOzN0+awet1RFHfPXtWgIAi9RxgrOW6jSDYI9NqleC41jQyJR/E2uvUIJ/OlqL3L6bH0/PxkOuzy+biUv0qGB97DqXRh3EUU3AgMBAAECggEAd40GEwhFMiJhZYsd114eL86PkTYf/MyvAPH8WxRyJ5Z4GfQafpY+pRKSqM85FIAvgxjGmWQrWj2BzwfOKBQhGmKL3BBGBKQYrm20HiwbdZ6k5JZ0+WoYa16m066Bwf0RbUL8BdOT7hfVyggQMDJx6Vsr1FtEzxwAcB4pwycVVn8/ZFk+maoIptb7oOrVf/A1OaiwFHrUplQFwL9bOjrnaz6sPmGStpSU6NHVkUVlH/J8V/ag2iYt9QUQiLg6/jroMQegixZAi5g3fQKQ/2oOKy+6JKfxcN982X7Zy36gULhs/VJ+SeD/+YjqfIaNJtqDpeunlSGLGG8W+4f6nUp9IQKBgQDrTc4VG7x1AS6gc9wG7xcjSUWHK0tQow8rl64Y4KAb3iyKismNtgg8qkRERhJ+ZZulr07IUZE/M+doqNmoShtpcuGguUgcKGgfaCBo4351TgVh2fslzwzhrood7O+fScgJmmT+XN3et0luwkvpD60Kol5xD0dEOabH/f1RJNpvcQKBgQCuit+QhdN5d353UAWyPEZnrQmmfDU6yP280ELU0/AmC6nghRD7dz8ZXo+LmRMuekEeNX4l0HU1LNhjmcW4El6112ZfVtt7znI7yqq7m7SYHhewJT2xrDq6m9yhGa8j2TGZNrSb+cEYv8kJcBNZMMQytHVTg6h4vA01S4KUOK97JwKBgEIRIXjZxctQXqgcf73Oqb91ljkCle35KoxB1VcU0r+gXP81QqwwXRWzdOF6jzzACLi3hTZHeLG3QBUpu5s92357DBDVlQKa8clHsjnhDiOfmXFFA/g0r1g6antGiG1ACRNxL0QgDQe4jLy1fxzcEuj2d+/kq0zjpwlmLhb3cwFxAoGAJzS4jR0SaIln1eMatHOHmQgsT8I8rqyxGjVpnabRnaonCXC6ZNHfUZKFCeVjgqAheminolTVzxD4tj63Q+aUcaIls6qt+Hxh+n5GpYePJFA2H/HtjrhSJNKX13QOfC3wTysTnKmYLzf9L2qGXhVvLLiOVikPsbcD/IGunh6xhCcCgYAvtXpHRZN2xy66d1VrMeqhfddj+lDmp0ZkbbeyZHLovk2G4jOjck0CMHffMbYoi5Up2Opi6Gn2G2roO6EvLmPt8zneEDc9NfwdbQLVc7sHk4WaaZIWHl/9kyKLjO6PrjyN+IJ/W8GhDo1aXG+3bARmnqVhHQnARx6dw610JFy34g==";
		String BouPublic = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn9/lE9HbqaS/6GqkysCZgyUkeLkxOQKiosmGt5N3JA3qit4sP0yZh9HEtZk85S9xDVLUJkCEa2SIDEIWExpEVe3CI5TN8chXh/qyH0TqoHbkfrf2xkolYZFGYM/BcGj6I3bOVKFSTkwuxVmncgLrk0q7a6e5mgAwYxy9iMB0aOM56j37oEdOzOLl8giAhxvu2AorsPxfewfwnvnFXDvSQHtcQJhJDBZOl7lW9pl0fdqD2ct9/3lip//klMnj79IOncsFJ8JHwC1dpNdJk2PxWS1nzKgHsDlIKfnWPdqI+C2DYGU1Z71mXLXynBSogQiThfUWrSHgUlRB4WPsdurfawIDAQAB";
		BouMasterDto bouMasterDTO = new BouMasterDto();
		
		//24-01-2025 Step=2 Get ciphertext
		String plainMsg="{\"agentInstitutionId\":\"SB42\",\"token\":\"6ffbeb77133c15ca241565135e103a78\"}";
				PublicKey pkey=BbpsSecurityUtil.getPublicKey(BouPublic);
				//PublicKey aeskey=BbpsSecurityUtil.getPublicKey(aesToken);
		
				String NBCIID="OU01OU02INT522274495200721ahbcj2123";
				//----------------------------------------------------------------------------
				ZonedDateTime now2 = ZonedDateTime.now();
				DateTimeFormatter rrnform = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
				String rrnTimestamp = now2.format(rrnform);
				 NBCIID="OU01OU02INT"+rrnTimestamp+"1ahbcj2123";
				 NBCIID=loginEntity.getRequestId();
				 
				  String randomString = generateRandomString(12);
				  
				  // Get current date
			        LocalDate currentDate = LocalDate.now();
			        
			        // Get the last two digits of the year
			        int lastTwoDigitsOfYear = currentDate.getYear() % 10;
			        
			        // Get the day of the year (1 to 366)
			        int dayOfYear = currentDate.getDayOfYear();
			        
			        // Format Julian date as 'YDDD' (4 characters)
			        String julianDate = String.format("%d%03d", lastTwoDigitsOfYear, dayOfYear);
			        
			        
				 String ReferenceId="SB41"+julianDate+randomString;
				
				//--------------------------------------------------------------------------
			
		//24-01-2025 Step=3 Get Timestamp
						DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'+05:30'");
					String formattedTimestamp = now2.format(formatter2);
					System.out.println("Formatted Timestamp: " + formattedTimestamp);
					  String jsonString = "{\"head\":{\"requestId\":\"OU01OU02INT522274495200721sx3cj2ab6\",\"ts\":\"2020-07-21T22:02:35+05:30\",\"txnReferenceId\":\"OU0109140201\",\"sourceTxnId\":\"ABC9876543210\",\"subSystemTxnId\":\"ABC9876543210\"},\"customer\":{\"mobile\":\"7466598081\",\"email\":\"\",\"aadhaar\":\"\",\"pan\":\"\"},\"agent\":{\"id\":\"OU01OU21MOB527011179\",\"initiatingChannel\":\"INTB\",\"ip\":\"124.170.23.28\",\"mac\":\"01-23-45-67-89-ab\",\"ifsc\":\"\",\"deviceId\":\"\",\"os\":\"\",\"app\":\"\",\"terminalId\":\"\"},\"billDetails\":{\"billerId\":\"OTOE00005XXZ43\",\"customerParams\":[{\"name\":\"Consumer Number\",\"value\":\"10150181\"},{\"name\":\"Mobile Number\",\"value\":\"9699381878\"}]},\"amountDetails\":{\"txnAmount\":\"101000\",\"splitPayAmount\":\"0\",\"custConvFee\":\"100\",\"custConvFeeDesc\":\"BOU to COU Fees\",\"couCustConvFee\":\"500\",\"couCustConvFeeDesc\":\"Agent Convenience Fees\"},\"paymentMethod\":{\"quickPay\":\"No\",\"splitPay\":\"No\",\"offusPay\":\"Yes\"},\"paymentInformation\":{\"paymentMode\":\"Credit Card\",\"cardNum\":\"4336620020624963\",\"authCode\":\"123456\",\"ifsc\":\"\",\"accountNo\":\"\",\"vpa\":\"\",\"mmid\":\"\",\"walletName\":\"\",\"mobileNo\":\"\",\"aadhaar\":\"\",\"iin\":\"\",\"remarks\":\"\"},\"debitAccountNo\":\"01732090003112\"}";
                     // String requestId = "{\"head\":{\"ver\": \"1.0\",\"origInst\": \"SB41\",\"requestId\":\""+NBCIID+"\",\"ts\":\""+formattedTimestamp+"\",\"txnReferenceId\":\""+ReferenceId+"\",\"sourceTxnId\":\"ABC9876543210\",\"subSystemTxnId\":\"ABC9876543210\"},\"customer\":{\"mobile\":\"7466598081\",\"email\":\"\",\"aadhaar\":\"\",\"pan\":\"\"},\"agent\":{\"id\":\"SB41SB42INB519046223\",\"initiatingChannel\":\"INTB\",\"ip\":\"124.170.23.28\",\"mac\":\"01-23-45-67-89-ab\",\"ifsc\":\"\",\"deviceId\":\"\",\"os\":\"\",\"app\":\"\",\"terminalId\":\"\"},\"billDetails\":{\"billerId\":\"OTOE00005XXZ43\",\"customerParams\":[{\"name\":\"Consumer Number\",\"value\":\"10150181\"},{\"name\":\"Mobile Number\",\"value\":\"9699381878\"}]},\"amountDetails\":{\"txnAmount\":\"101000\",\"splitPayAmount\":\"0\",\"custConvFee\":\"100\",\"custConvFeeDesc\":\"BOU to COU Fees\",\"couCustConvFee\":\"500\",\"couCustConvFeeDesc\":\"Agent Convenience Fees\"},\"paymentMethod\":{\"quickPay\":\"No\",\"splitPay\":\"No\",\"offusPay\":\"Yes\"},\"paymentInformation\":{\"paymentMode\":\"Credit Card\",\"cardNum\":\"4336620020624963\",\"authCode\":\"123456\",\"ifsc\":\"\",\"accountNo\":\"\",\"vpa\":\"\",\"mmid\":\"\",\"walletName\":\"\",\"mobileNo\":\"\",\"aadhaar\":\"\",\"iin\":\"\",\"remarks\":\"\"},\"debitAccountNo\":\"01732090003112\"}";

                     // String requestId = "{\"head\":{\"ver\": \"1.0\",\"origInst\": \"SB41\",\"requestId\":\""+NBCIID+"\",\"ts\":\""+formattedTimestamp+"\"}, \"agent\": {\"id\": \"SB41SB42INB519046223\"}, \"billDetails\": {\"billerId\": \""+billerId+"\", \"customerParams\": [{\"name\": \""+paramName+"\", \"value\": \""+paramValue+"\"}, {\"name\": \""+paramName2+"\", \"value\": \""+paramValue2+"\"}]}}";
                      String jsonSample2 = "{\"head\":{\"requestId\":\"SB41FAA8552EM5750M48AEM8EEB50791258\",\"ts\":\"2025-03-20T12:59:35+05:30\",\"txnReferenceId\":\"SB4150796D6E41FBM904\",\"sourceTxnId\":\"ABC9876543210\",\"subSystemTxnId\":\"ABC9876543210\"},\"customer\":{\"customerName\":\"\",\"mobile\":\"9012345751\",\"email\":\"test@sbi.com\",\"aadhaar\":\"\",\"senderName\":\"\",\"senderCategory\":\"\",\"senderDOB\":\"\",\"senderNationality\":\"\",\"receiverName\":\"\",\"receiverCategory \":\"\",\"receiverNationality\":\"\"},\"agent\":{\"id\":\"SB41SB42INB519046223\",\"initiatingChannel\":\"INT\",\"ip\":\"124.170.23.24\",\"mac\":\"01-23-45-67-89-ab\",\"ifsc\":\"\",\"deviceId\":\"\",\"os\":\"\",\"app\":\"\",\"terminalId\":\"\"},\"billDetails\":{\"billerId\":\"OU1201000MEE17\",\"customerParams\":[{\"name\":\"Roll No\",\"value\":\"501\"}]},\"amountDetails\":{\"txnAmount\":\"20000\",\"splitPayAmount\":\"0\",\"custConvFee\":\"0\",\"custConvFeeDesc\":\"BOU to COU Fees\",\"couCustConvFee\":\"0\",\"couCustConvFeeDesc\":\"Agent Convenience Fees\"},\"paymentMethod\":{\"quickPay\":\"No\",\"splitPay\":\"No\",\"offusPay\":\"Yes\"},\"paymentInformation\":{\"paymentMode\":\"Internet Banking\",\"ifsc\":\"SBIN0070001\",\"accountNo\":\"9912345123456\"},\"debitAccountNo\":\"\"}";
                      String requestId = "{\"head\":{\"requestId\":\""+NBCIID+"\",\"ts\":\""+formattedTimestamp+"\",\"txnReferenceId\":\""+ReferenceId+"\",\"sourceTxnId\":\"ABC9876543210\",\"subSystemTxnId\":\"ABC9876543210\"},\"customer\":{\"customerName\":\"\",\"mobile\":\"9012345751\",\"email\":\"test@sbi.com\",\"aadhaar\":\"\",\"senderName\":\"\",\"senderCategory\":\"\",\"senderDOB\":\"\",\"senderNationality\":\"\",\"receiverName\":\"\",\"receiverCategory \":\"\",\"receiverNationality\":\"\"},\"agent\":{\"id\":\"SB41SB42INB519046223\",\"initiatingChannel\":\"INT\",\"ip\":\"124.170.23.24\",\"mac\":\"01-23-45-67-89-ab\",\"ifsc\":\"\",\"deviceId\":\"\",\"os\":\"\",\"app\":\"\",\"terminalId\":\"\"},\"billDetails\":{\"billerId\":\"OU1201000MEE17\",\"customerParams\":[{\"name\":\"Roll No\",\"value\":\"501\"}]},\"amountDetails\":{\"txnAmount\":\"20000\",\"splitPayAmount\":\"0\",\"custConvFee\":\"0\",\"custConvFeeDesc\":\"BOU to COU Fees\",\"couCustConvFee\":\"0\",\"couCustConvFeeDesc\":\"Agent Convenience Fees\"},\"paymentMethod\":{\"quickPay\":\"No\",\"splitPay\":\"No\",\"offusPay\":\"Yes\"},\"paymentInformation\":{\"paymentMode\":\"Internet Banking\",\"ifsc\":\"SBIN0070001\",\"accountNo\":\"9912345123456\"},\"debitAccountNo\":\"\"}";

				      
    	String ciphertext=securityUtils.encryptAesGcm(requestId, aesToken);
					//String ciphertext=securityUtils.encryptRsaMessage( requestId,aesToken);
					System.out.println("ciphertext="+ciphertext);
		//24-01-2025 Step=4 Generate DigitalSignature		
					requestDTO.setCipherText(ciphertext);
					requestDTO.setTimeStamp(formattedTimestamp);
					requestDTO.setRrn(RRN);
					PrivateKey privatekey=BbpsSecurityUtil.getPrivateKey(getBillerPrivate);
					 digitalSignature = securityUtils.generateDigitalSignature(requestDTO.getRrn() + requestDTO.getTimeStamp() + requestDTO.getCipherText(), privatekey);
						System.out.println("digitalSignature: " + digitalSignature);

						//24-01-2025 Step=5 Generate EncryptedRequest			

		//encryptedRequestMsg = "{" + "\"rrn\":\"SB5120210212093848ee3b04f1043344f87\"," + "\"cipherText\":\"3412C8F35979A2D92F92B7EA8A6183ECB1EDA5C896276562D80AA83F7C8C033BCCE43E2FAD9EAB5A0334CE8454392DB0DCA969469F3F5917B86335D986EE8275B87241DB1AF4A6499373DD6EA5A711EB634A7CAE352D4D3DA89D9F535A3971E12EB65058D2A001B039CE03FDEABB56C481488CC452FB117EF39D011339FAA09BD992EEA4D456FBCB877D9CA86E2D60613A48F61A99E8C3C88F6FE117ED1B0ADC83B2E406AB4075A882DD207880DDEFBBABD96A2EAEBD57BBD72BC29C1E530C11ECDB4AB1982E419840863D1A3078AF96746D1400D4A3D5AA68431E88676FB52F8B47B8F14C0000B659BA23ED7636D9FC57212922069324B991517A1912EDA7F4FA8641279A94B013F98F3DA950EC001A1E65F8A604849AFB663630BBFAA55C3885F1815EEB6B0AB94D25A00510B76A436F6E076333CD9802F83D9C0F6EE473A468C4633AB1A1F1D5C86E398197D374305CB14251CE0691E1AFBDFBE5783D20FA86D256050DE205DD90AC5CE3\"," + "\"digitalSig\":\"A7dIKgs8l8fndu7p/YNOigM5Gj32IgXiIDoYtZb0mfKW8yfWXPwYQDmMy7LYE1Vrk3c2r1eywWr7Wu1LJkyJ4RCp8H2nSjUpEpHYsaU3qV4vQyhSKWLjhEFOWcn9zqnwLaZAAd8zZCK7uorQFky02t28SOaVfcGU/3UhHxZVGXgOzJGSUVZlO6xFYnq91/GCbE9Bo9uNVENYWKtMXCPHb/8C4tYl9UMpVFurXYmUJq9U5ZJos0+JykjLUt3ly/LvCKegE6gnRuGCuvvnLi22HsDNWj3unW+ytbU9inA0gBkPaELH4fK9f3cs7U3b+A6KmX1VdJeSJVm9JAdkvGdu5A==\"," + "\"timeStamp\":\"2021-02-12T21:38:48+05:30\"" + "}";
		encryptedRequestMsg = "{" + "\"rrn\":\""+requestDTO.getRrn()+"\"," + "\"cipherText\":\""+requestDTO.getCipherText()+"\"," + "\"digitalSig\":\""+digitalSignature+"\"," + "\"ts\":\""+requestDTO.getTimeStamp()+"\"" + "}";

		System.out.println("EncryptedRequest: " + encryptedRequestMsg);
		 String ResponseMsg="";
		 int responseCode=0;
		  StringBuilder response = new StringBuilder();
		  try {
      	    // URL of the API endpoint
			  URL url = new URL("https://uatsbiunipay.sbi/bbps-cou-switch/billPayment");
      	       HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      	    
      	    // Setting the request method to POST
      	    conn.setRequestMethod("POST");
      	    conn.setRequestProperty("Content-Type", "application/json; utf-8");
      	    conn.setRequestProperty("Accept", "application/json");
      	    conn.setDoOutput(true);

      	    // JSON payload
      	   
      	    String jsonInputString = encryptedRequestMsg;
      	    //String jsonInputString="{\"amt\":\"qg8lfycy0Ps=\",\"accNum\":\"QDvcz8lILVw1I6YUpkHHAw==\",\"hname\":\"v+yG16PsTsA=\",\"bal\":\"osN4bh2XAuVefhxwIn3QfQ==\",\"atype\":\"Qzwj51FVXG8=\"}";
      	    // Sending the JSON payload
      	    try (OutputStream os = conn.getOutputStream()) {
      	        byte[] input = jsonInputString.getBytes("utf-8");
      	        os.write(input, 0, input.length);
      	    }
      	// Read the response
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
              
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Response: " + response.toString());
                loginEntity.setOTP(response.toString());
            }
      	    // Reading the response
      	     responseCode = conn.getResponseCode();
      	    System.out.println("Response Code: " + conn.getResponseMessage());
      	  ResponseMsg=responseCode+": "+conn.getResponseMessage();
      	    // Handle the response (omitted for brevity)

      	} catch (Exception e) {
      	    
      		
      		loginEntity.setOTP(""+e.fillInStackTrace());
      		e.printStackTrace();
      	    
      	 
      	}

		// final Login1 login = new Login1();
        // model.clear();
         model.put("loginEntity5", loginEntity);
         mp.put("encryptedRequestMsg", encryptedRequestMsg);
         loginEntity.setBranch_Type("Request Id \n:"+requestId+"\n  Cipher :"+ciphertext+" \n Encripted Msg :"+encryptedRequestMsg+"\nResponse Code: " + ResponseMsg);
         System.out.println("response.toString()="+response.toString());
         
         System.out.println("response.toString()="+response.toString());

         model.put("loginEntity", loginEntity);
         mp.put("encryptedRequestMsg", encryptedRequestMsg);
         loginEntity.setBranch_Type("Request Id \n:"+requestId+"\n  Cipher :"+ciphertext+" \n Encripted Msg :"+encryptedRequestMsg+"\nResponse Code: " + ResponseMsg);
         System.out.println("response.toString()="+response.toString());

         System.out.println("response.toString()="+response.toString());

         mp.put("OTP", response.toString());
        // loginEntity.setOTP("Request Id \n:"+requestId+"\n  Cipher :"+ciphertext+" \n Encripted Msg :"+encryptedRequestMsg+"\nResponse Code: " + ResponseMsg);

         loginEntity.setOTP(response.toString());
         loginEntity.setEncryptedMsg(encryptedRequestMsg);
         //login.setOTP1(response.toString());
         
       //  loginEntity.setOTP("Request Id \n:"+requestId+"\n  Cipher :"+ciphertext+" \n Encripted Msg :"+encryptedRequestMsg+"\nResponse Code: " + ResponseMsg);

         mp.put("AesToken", loginEntity.getAesToken());
         mp.put("Rrn_No", loginEntity.getRrn_No());


       
    //----------------------------------------------------------------------------------		

			String plainMsgBillerDetails=loginEntity.getEncryptedMsg();
	    	String ciphertextBillerDetails=securityUtils.encryptRsaMessage( plainMsgBillerDetails,pkey);
				System.out.println("ciphertext="+ciphertext);
				String TokenResponseMsg=loginEntity.getOTP().replace("\"ts\"", "\"timeStamp\"");
		
				System.out.println("TokenResponseMsg="+TokenResponseMsg );

		EncryptedRequestDto tokenRespenseDTO =new EncryptedRequestDto();
tokenRespenseDTO = JsonConverterUtilityP.convertStringToJsonObject(TokenResponseMsg, EncryptedRequestDto.class);
String signatureReqStr1 = tokenRespenseDTO.getRrn()+tokenRespenseDTO.getTimeStamp()+tokenRespenseDTO.getCipherText();
System.out.println("signatureReqStr1="+signatureReqStr1 );

//24-01-2025 Step=7 Verify TokenResponse with digital signature
isVerified = securityUtils.verifyDigitalSignature(signatureReqStr1, tokenRespenseDTO.getDigitalSig(), pkey); //give BOU public key here
System.out.println("isVerified="+isVerified );

//24-01-2025 Step=8 Get AES Key from Response
try {
	//aesToken
	decryptedAesKey =securityUtils.decryptAesGcm(tokenRespenseDTO.getCipherText(), aesToken);
	//decryptedAesKey = securityUtils.decryptMessage( tokenRespenseDTO.getCipherText(),privatekey);
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
String accessToken = null;
try {
    ObjectMapper objectMapper = new ObjectMapper();

    // Deserialize the JSON string into the Java object (Response)
    Response responseBillerDetails = objectMapper.readValue(decryptedAesKey, Response.class);
     // db.insertResponseData(response);
    
   // insertStates(response.getStateList());
      
} catch (Exception e) {
    e.printStackTrace();
}



// Now you have the Java object
//System.out.println(response);

mp.put("signatureReqStr1", signatureReqStr1 );
//final Login1 login = new Login1();
model.put("loginEntity", loginEntity);
loginEntity.setEncryptedMsg(plainMsg);
loginEntity.setOTP(decryptedAesKey );
loginEntity.setOTP1(""+isVerified+" op="+decryptedAesKey);
loginEntity.setBranch_Type("CypherTxt :"+ciphertext+" \n signatureReqStr1 : "+signatureReqStr1);
loginEntity.setOTP("Request Id \n:"+requestId+"\n  Cipher :"+ciphertext+" \n Encripted Msg :"+encryptedRequestMsg+"\ndecryptedAesKey: " + decryptedAesKey);


mp.put("AesToken", loginEntity.getAesToken());
mp.put("Rrn_No", loginEntity.getRrn_No());
mp.put("billJson", decryptedAesKey);
model.put("loginEntity", loginEntity);

return "ServiceList";


    	
    	}
    	
    	
    public static String generateRandomString(int digit) {
        // Define the characters that will be used for the string (uppercase letters and digits)
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        
        // Create a Random object to generate random numbers
        Random random = new Random();
        
        // Use a StringBuilder to efficiently append characters
        StringBuilder randomString = new StringBuilder(digit);
        
        // Generate an 8-character string
        for (int i = 0; i < digit; i++) {
            int randomIndex = random.nextInt(characters.length());
            randomString.append(characters.charAt(randomIndex));
        }
        
        // Return the generated string
        return randomString.toString();
    }
    	
    	
    	
    
    
    @RequestMapping(value = { "/ServiceList2" }, method = { RequestMethod.GET })
    public String ServiceList2(@Valid @ModelAttribute("loginEntity") final Login1 loginEntity, final BindingResult result, final ModelMap mp, HttpSession session, final HttpServletRequest request, final Map<String, Object> model, final RedirectAttributes attributes) throws SQLException, ParseException, IOException {
    	{
    		String id="SB42";
    		String agentInstid="SB42";
    		String token="6ffbeb77133c15ca241565135e103a78";
    		
    		
		EncryptedRequestDto requestDTO =new EncryptedRequestDto();
		BillFetchRequestBean decryptedRequestDto = null;

		String decryptedResponseMsg = null;
		String encryptedResponseMsg = null;

		String encryptedRequestMsg = null;
		String decryptedRequestMsg = null;
		String encryptedAesKey = null;
		String decryptedAesKey = null;

		String timeStamp = null;
		String digitalSignature = null;
		boolean isVerified = false;
		boolean isValid = false;
		String getBillerPrivate = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgboeBDYUm/hLhirbB0Jb05XJEf/ji5SUC5LuqpQhnKhX3RJ0qxdOIzhG5lv4+FN+Yi/1DvCcDN8I2AsNzLABuuoeva/qYWhrs3808jPl2PiFIPv7EeRkfKzswN40Ov/d/05jdNQ1hg6vdylhD0sig5BJtmp3jimPGhSpQgowqvdPXSYwAuj2juea8pSJSPkU1BfPWM7WJWzeoUrNptaAV3sgZ5sa3yEuYPBTJr7/uP9mCMciu9GAxOzN0+awet1RFHfPXtWgIAi9RxgrOW6jSDYI9NqleC41jQyJR/E2uvUIJ/OlqL3L6bH0/PxkOuzy+biUv0qGB97DqXRh3EUU3AgMBAAECggEAd40GEwhFMiJhZYsd114eL86PkTYf/MyvAPH8WxRyJ5Z4GfQafpY+pRKSqM85FIAvgxjGmWQrWj2BzwfOKBQhGmKL3BBGBKQYrm20HiwbdZ6k5JZ0+WoYa16m066Bwf0RbUL8BdOT7hfVyggQMDJx6Vsr1FtEzxwAcB4pwycVVn8/ZFk+maoIptb7oOrVf/A1OaiwFHrUplQFwL9bOjrnaz6sPmGStpSU6NHVkUVlH/J8V/ag2iYt9QUQiLg6/jroMQegixZAi5g3fQKQ/2oOKy+6JKfxcN982X7Zy36gULhs/VJ+SeD/+YjqfIaNJtqDpeunlSGLGG8W+4f6nUp9IQKBgQDrTc4VG7x1AS6gc9wG7xcjSUWHK0tQow8rl64Y4KAb3iyKismNtgg8qkRERhJ+ZZulr07IUZE/M+doqNmoShtpcuGguUgcKGgfaCBo4351TgVh2fslzwzhrood7O+fScgJmmT+XN3et0luwkvpD60Kol5xD0dEOabH/f1RJNpvcQKBgQCuit+QhdN5d353UAWyPEZnrQmmfDU6yP280ELU0/AmC6nghRD7dz8ZXo+LmRMuekEeNX4l0HU1LNhjmcW4El6112ZfVtt7znI7yqq7m7SYHhewJT2xrDq6m9yhGa8j2TGZNrSb+cEYv8kJcBNZMMQytHVTg6h4vA01S4KUOK97JwKBgEIRIXjZxctQXqgcf73Oqb91ljkCle35KoxB1VcU0r+gXP81QqwwXRWzdOF6jzzACLi3hTZHeLG3QBUpu5s92357DBDVlQKa8clHsjnhDiOfmXFFA/g0r1g6antGiG1ACRNxL0QgDQe4jLy1fxzcEuj2d+/kq0zjpwlmLhb3cwFxAoGAJzS4jR0SaIln1eMatHOHmQgsT8I8rqyxGjVpnabRnaonCXC6ZNHfUZKFCeVjgqAheminolTVzxD4tj63Q+aUcaIls6qt+Hxh+n5GpYePJFA2H/HtjrhSJNKX13QOfC3wTysTnKmYLzf9L2qGXhVvLLiOVikPsbcD/IGunh6xhCcCgYAvtXpHRZN2xy66d1VrMeqhfddj+lDmp0ZkbbeyZHLovk2G4jOjck0CMHffMbYoi5Up2Opi6Gn2G2roO6EvLmPt8zneEDc9NfwdbQLVc7sHk4WaaZIWHl/9kyKLjO6PrjyN+IJ/W8GhDo1aXG+3bARmnqVhHQnARx6dw610JFy34g==";
		String BouPublic = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn9/lE9HbqaS/6GqkysCZgyUkeLkxOQKiosmGt5N3JA3qit4sP0yZh9HEtZk85S9xDVLUJkCEa2SIDEIWExpEVe3CI5TN8chXh/qyH0TqoHbkfrf2xkolYZFGYM/BcGj6I3bOVKFSTkwuxVmncgLrk0q7a6e5mgAwYxy9iMB0aOM56j37oEdOzOLl8giAhxvu2AorsPxfewfwnvnFXDvSQHtcQJhJDBZOl7lW9pl0fdqD2ct9/3lip//klMnj79IOncsFJ8JHwC1dpNdJk2PxWS1nzKgHsDlIKfnWPdqI+C2DYGU1Z71mXLXynBSogQiThfUWrSHgUlRB4WPsdurfawIDAQAB";
		BouMasterDto bouMasterDTO = new BouMasterDto();
		
		//24-01-2025 Step=2 Get ciphertext
		String plainMsg="{\"agentInstitutionId\":\"SB42\",\"token\":\"6ffbeb77133c15ca241565135e103a78\"}";
				PublicKey pkey=BbpsSecurityUtil.getPublicKey(BouPublic);
		String ciphertext=securityUtils.encryptRsaMessage( plainMsg,pkey);
				System.out.println("ciphertext="+ciphertext);
		//24-01-2025 Step=3 Get Timestamp
					ZonedDateTime now2 = ZonedDateTime.now();
					DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
					String formattedTimestamp = now2.format(formatter2);
					System.out.println("Formatted Timestamp: " + formattedTimestamp);
		//24-01-2025 Step=4 Generate DigitalSignature		
					requestDTO.setCipherText(ciphertext);
					requestDTO.setTimeStamp(formattedTimestamp);
					
					//----------------------------------------------------------------------------
					DateTimeFormatter rrnform = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
					String rrnTimestamp = now2.format(rrnform);
					String RRN="SB51"+rrnTimestamp+"ee3b04f1043344f87";
					
					//--------------------------------------------------------------------------
					requestDTO.setRrn(RRN);
					
					PrivateKey privatekey=BbpsSecurityUtil.getPrivateKey(getBillerPrivate);
					 digitalSignature = securityUtils.generateDigitalSignature(requestDTO.getRrn() + requestDTO.getTimeStamp() + requestDTO.getCipherText(), privatekey);
						System.out.println("digitalSignature: " + digitalSignature);
  	encryptedRequestMsg = "{" + "\"rrn\":\""+requestDTO.getRrn()+"\"," + "\"cipherText\":\""+requestDTO.getCipherText()+"\"," + "\"digitalSig\":\""+digitalSignature+"\"," + "\"ts\":\""+requestDTO.getTimeStamp()+"\"" + "}";

		System.out.println("EncryptedRequest: " + encryptedRequestMsg);
		  StringBuilder response = new StringBuilder();
		  try {
      	    // URL of the API endpoint
      	    URL url = new URL("https://uatsbiunipay.sbi/bbps-cou-switch/getAccessToken/SB42");
      	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      	    
      	    // Setting the request method to POST
      	    conn.setRequestMethod("POST");
      	    conn.setRequestProperty("Content-Type", "application/json; utf-8");
      	    conn.setRequestProperty("Accept", "application/json");
      	    conn.setDoOutput(true);

      	    // JSON payload
      	    String jsonInputString = encryptedRequestMsg;
      	      try (OutputStream os = conn.getOutputStream()) {
      	        byte[] input = jsonInputString.getBytes("utf-8");
      	        os.write(input, 0, input.length);
      	    }
      	// Read the response
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
              
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Response: " + response.toString());
                loginEntity.setOTP(response.toString());
            }
      	    // Reading the response
      	    int responseCode = conn.getResponseCode();
      	    System.out.println("Response Code: " + conn.getResponseMessage());
      	    
      	    // Handle the response (omitted for brevity)

      	} catch (Exception e) {
      	    
      		
      		loginEntity.setOTP(""+e.fillInStackTrace());
      		e.printStackTrace();
      	    
      	 
      	}

		 final Login1 login = new Login1();
        // model.clear();
         model.put("loginEntity", login);
         mp.put("encryptedRequestMsg", encryptedRequestMsg);
         login.setBranch_Type(encryptedRequestMsg);
         System.out.println("response.toString()="+response.toString());
         mp.put("OTP", response.toString());
         mp.put("Rrn_No", RRN);
         login.setRrn_No(RRN);
        // mp.put("OTP1", response.toString());
         login.setOTP(response.toString());
         //login.setOTP1(response.toString());
         
      
       //----------------------------------------------------------------------------------------

	
	
       String TokenResponseMsg=response.toString().replace("\"ts\"", "\"timeStamp\"");
	System.out.println("TokenResponseMsg="+TokenResponseMsg );

	EncryptedRequestDto tokenRespenseDTO =new EncryptedRequestDto();
tokenRespenseDTO = JsonConverterUtilityP.convertStringToJsonObject(TokenResponseMsg, EncryptedRequestDto.class);
String signatureReqStr1 = tokenRespenseDTO.getRrn()+tokenRespenseDTO.getTimeStamp()+tokenRespenseDTO.getCipherText();
System.out.println("signatureReqStr1="+signatureReqStr1 );

//24-01-2025 Step=7 Verify TokenResponse with digital signature
isVerified = securityUtils.verifyDigitalSignature(signatureReqStr1, tokenRespenseDTO.getDigitalSig(), pkey); //give BOU public key here
System.out.println("isVerified="+isVerified );

//24-01-2025 Step=8 Get AES Key from Response
try {
decryptedAesKey = securityUtils.decryptMessage( tokenRespenseDTO.getCipherText(),privatekey);

} catch (Exception e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
String accessToken = null;
try {
// Create an ObjectMapper
ObjectMapper objectMapper = new ObjectMapper();

// Convert JSON string into JsonNode
JsonNode jsonNode = objectMapper.readTree(decryptedAesKey);

// Get values
String responseCode = jsonNode.path("reason").path("responseCode").asText();
String responseReason = jsonNode.path("reason").path("responseReason").asText();
accessToken = jsonNode.path("accessToken").asText();
String expiryTime = jsonNode.path("expiryTime").asText();

// Output values
System.out.println("Response Code: " + responseCode);
System.out.println("Response Reason: " + responseReason);
System.out.println("Access Token: " + accessToken);
System.out.println("Expiry Time: " + expiryTime);
} catch (Exception e) {
e.printStackTrace();
}

mp.put("signatureReqStr1", decryptedAesKey );
//final Login1 login = new Login1();
model.put("loginEntity", loginEntity);
loginEntity.setOTP(decryptedAesKey );
loginEntity.setOTP1(accessToken);
loginEntity.setBranch_Type(encryptedRequestMsg);

loginEntity.setAesToken(accessToken);
mp.put("AesToken", accessToken);
mp.put("Rrn_No", RRN);




return "ServiceList";


	
       
       
       //------------------------------------------------------------------------------------------
    
    	
    	}

}


}



    
