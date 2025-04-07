
package com.Pisquare.Controllers;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Pisquare.Beans.MemberDetails;
import com.Pisquare.Service.MemberDetailsService;
import com.Pisquare.Dao.MemberDetailsDao;
import com.Pisquare.Beans.EncryptedRequestDto;
import com.Pisquare.Service.BbpsSecurityUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.http.HttpSession;



@SuppressWarnings("unused")
@Controller

public class MemberController {
	  
    @Autowired
    private MemberDetailsService memberDetailsService; 
    @Autowired
    private MemberDetailsDao MemberDetailsDao;
  
    public static BbpsSecurityUtil securityUtils = new BbpsSecurityUtil();

    @RequestMapping(value = "/CheckingId/{regId}", method = RequestMethod.GET)
    @ResponseBody
    public String checkId(@PathVariable("regId") String regId) {
        String id = "SB42";
        String agentInstid = "SB42";
        String token = "6ffbeb77133c15ca241565135e103a78";
        String privateKeyStr = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgboeBDYUm/hLhirbB0Jb05XJEf/ji5SUC5LuqpQhnKhX3RJ0qxdOIzhG5lv4+FN+Yi/1DvCcDN8I2AsNzLABuuoeva/qYWhrs3808jPl2PiFIPv7EeRkfKzswN40Ov/d/05jdNQ1hg6vdylhD0sig5BJtmp3jimPGhSpQgowqvdPXSYwAuj2juea8pSJSPkU1BfPWM7WJWzeoUrNptaAV3sgZ5sa3yEuYPBTJr7/uP9mCMciu9GAxOzN0+awet1RFHfPXtWgIAi9RxgrOW6jSDYI9NqleC41jQyJR/E2uvUIJ/OlqL3L6bH0/PxkOuzy+biUv0qGB97DqXRh3EUU3AgMBAAECggEAd40GEwhFMiJhZYsd114eL86PkTYf/MyvAPH8WxRyJ5Z4GfQafpY+pRKSqM85FIAvgxjGmWQrWj2BzwfOKBQhGmKL3BBGBKQYrm20HiwbdZ6k5JZ0+WoYa16m066Bwf0RbUL8BdOT7hfVyggQMDJx6Vsr1FtEzxwAcB4pwycVVn8/ZFk+maoIptb7oOrVf/A1OaiwFHrUplQFwL9bOjrnaz6sPmGStpSU6NHVkUVlH/J8V/ag2iYt9QUQiLg6/jroMQegixZAi5g3fQKQ/2oOKy+6JKfxcN982X7Zy36gULhs/VJ+SeD/+YjqfIaNJtqDpeunlSGLGG8W+4f6nUp9IQKBgQDrTc4VG7x1AS6gc9wG7xcjSUWHK0tQow8rl64Y4KAb3iyKismNtgg8qkRERhJ+ZZulr07IUZE/M+doqNmoShtpcuGguUgcKGgfaCBo4351TgVh2fslzwzhrood7O+fScgJmmT+XN3et0luwkvpD60Kol5xD0dEOabH/f1RJNpvcQKBgQCuit+QhdN5d353UAWyPEZnrQmmfDU6yP280ELU0/AmC6nghRD7dz8ZXo+LmRMuekEeNX4l0HU1LNhjmcW4El6112ZfVtt7znI7yqq7m7SYHhewJT2xrDq6m9yhGa8j2TGZNrSb+cEYv8kJcBNZMMQytHVTg6h4vA01S4KUOK97JwKBgEIRIXjZxctQXqgcf73Oqb91ljkCle35KoxB1VcU0r+gXP81QqwwXRWzdOF6jzzACLi3hTZHeLG3QBUpu5s92357DBDVlQKa8clHsjnhDiOfmXFFA/g0r1g6antGiG1ACRNxL0QgDQe4jLy1fxzcEuj2d+/kq0zjpwlmLhb3cwFxAoGAJzS4jR0SaIln1eMatHOHmQgsT8I8rqyxGjVpnabRnaonCXC6ZNHfUZKFCeVjgqAheminolTVzxD4tj63Q+aUcaIls6qt+Hxh+n5GpYePJFA2H/HtjrhSJNKX13QOfC3wTysTnKmYLzf9L2qGXhVvLLiOVikPsbcD/IGunh6xhCcCgYAvtXpHRZN2xy66d1VrMeqhfddj+lDmp0ZkbbeyZHLovk2G4jOjck0CMHffMbYoi5Up2Opi6Gn2G2roO6EvLmPt8zneEDc9NfwdbQLVc7sHk4WaaZIWHl/9kyKLjO6PrjyN+IJ/W8GhDo1aXG+3bARmnqVhHQnARx6dw610JFy34g==";

        

        // Generate timestamp and other necessary information
        String timeStamp = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX"));
        String rrnTimestamp = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String RRN = "SB51" + rrnTimestamp + "ee3b04f1043344f87";

        String plainMsg = "{\"agentInstitutionId\":\"" + agentInstid + "\",\"token\":\"" + token + "\"}";
        PublicKey pkey = BbpsSecurityUtil.getPublicKey(privateKeyStr);
        String ciphertext = securityUtils.encryptRsaMessage(plainMsg, pkey);

        EncryptedRequestDto requestDTO = new EncryptedRequestDto();
        requestDTO.setCipherText(ciphertext);
        requestDTO.setTimeStamp(timeStamp);
        requestDTO.setRrn(RRN);

        PrivateKey privateKey = BbpsSecurityUtil.getPrivateKey(privateKeyStr);
        String digitalSignature = securityUtils.generateDigitalSignature(requestDTO.getRrn() + requestDTO.getTimeStamp() + requestDTO.getCipherText(), privateKey);

        String encryptedRequestMsg = String.format("{\"rrn\":\"%s\",\"cipherText\":\"%s\",\"digitalSig\":\"%s\",\"ts\":\"%s\"}",
                requestDTO.getRrn(), requestDTO.getCipherText(), digitalSignature, requestDTO.getTimeStamp());

        String apiUrl = "https://uatsbiunipay.sbi/bbps-cou-switch/getAccessToken/SB42";
        String response = makeApiCall(apiUrl, encryptedRequestMsg);

        // Check response and return appropriate message
        if (response != null) {
            return "{\"status\":\"success\",\"message\":\"ID verified successfully!\"}";
        } else {
            return "{\"status\":\"error\",\"message\":\"ID verification failed!\"}";
        }
    }

    private String makeApiCall(String apiUrl, String requestData) {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = requestData.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    return response.toString(); // Return the response as a string
                }
            } else {
                System.out.println("Error in API call.");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/WalletAdd", method = RequestMethod.POST)
    public String WalletAdd(@ModelAttribute("MemberEntity") MemberDetails member, 
                            Model model, 
                            RedirectAttributes redirectAttributes, 
                            HttpSession session1) {
        

        String pin = (String) session1.getAttribute("pin");


        if (pin == null) {
            model.addAttribute("error", "Pin not found in session1.");
            return "redirect:/MemberWallet"; 
        }
        
        String bankName = member.getBankName();
        String balance = member.getBalance();
        String amount = member.getAmount();
        String referenceNo = member.getReferenceNo();
        String paymentMode = member.getPaymentMode();
        Date paymentDate = member.getPaymentDate();
        String remarks = member.getRemarks();
        
        Map<String, String> result = memberDetailsService.saveFundRequest(bankName, balance, amount, referenceNo, paymentMode, paymentDate, remarks, pin);
        
        if(result.containsKey("success")) {
            redirectAttributes.addFlashAttribute("message", "Fund Request Added Successfully!");
            return "redirect:/MemberWallet"; 
        } else {
            model.addAttribute("error", result.get("error"));
            return "redirect:/walletForm"; 
        }
    }

    @RequestMapping(value = "MemberWallet", method = RequestMethod.GET)
    public String viewMemberWallet(Map<String, Object> model) {
    	  
        //----------Header--------------------------------------------------------------
        
        List<String> categoryNames2 = memberDetailsService.getCategoryNames();
        Map<String, String> categoryPages = memberDetailsService.getCategoryPages(); 
        Map<String, String> categoryIcons = new HashMap<>();
        categoryIcons.put("Hospital and Pathology", "fa fa-hospital");
        categoryIcons.put("Broadband Prepaid", "fa fa-wifi");
        categoryIcons.put("Cable TV", "fa fa-tv");
        categoryIcons.put("Credit Card", "fa fa-credit-card");
        categoryIcons.put("DTH", "fa fa-tv");
        categoryIcons.put("Education Fees", "fa fa-graduation-cap");
        categoryIcons.put("Electricity", "fa fa-bolt");
        categoryIcons.put("Fastag", "fa fa-car");
        categoryIcons.put("Gas", "fa fa-fire");
        categoryIcons.put("Health Insurance", "fa fa-heartbeat");
        categoryIcons.put("Hospital", "fa fa-hospital");
        categoryIcons.put("Housing Society", "fa fa-building");
        categoryIcons.put("Insurance", "fa fa-shield-alt");
        categoryIcons.put("Landline Postpaid", "fa fa-phone-alt");
        categoryIcons.put("Life Insurance", "fa fa-shield-alt");
        categoryIcons.put("Loan Repayment", "fa fa-money-bill");
        categoryIcons.put("LPG Gas", "fa fa-fire");
        categoryIcons.put("Mobile Postpaid", "fa fa-mobile-alt");
        categoryIcons.put("Municipal Services", "fa fa-city");
        categoryIcons.put("Municipal Taxes", "fa fa-money-bill-wave");
        categoryIcons.put("Subscription", "fa fa-cogs");
        categoryIcons.put("Water", "fa fa-tint");
        categoryIcons.put("Clubs and Associations", "fa fa-users");
        categoryIcons.put("Mobile Prepaid", "fa fa-mobile-alt");
        categoryIcons.put("Recurring Deposit", "fa fa-piggy-bank");
        categoryIcons.put("Metro", "fa fa-subway");
        categoryIcons.put("Rental", "fa fa-home");
        categoryIcons.put("Broadband Postpaid", "fa fa-wifi");
        categoryIcons.put("Gift Card", "fa fa-gift");
        categoryIcons.put("NCMC Recharge", "fa fa-credit-card");
        categoryIcons.put("Mutual Fund", "fa fa-chart-line");
        categoryIcons.put("Donation", "fa fa-hand-holding-heart");
        categoryIcons.put("National Pension System", "fa fa-piggy-bank");
        categoryIcons.put("Mobile", "fa fa-mobile-alt");
        categoryIcons.put("Prepaid Meter", "fa fa-plug");
        categoryIcons.put("eChallan", "fa fa-file-alt");
        categoryIcons.put("Landline Prepaid", "fa fa-phone-alt");


        ((Model) model).addAttribute("categoryNames", categoryNames2);
        ((Model) model).addAttribute("categoryIcons", categoryIcons);  
        ((Model) model).addAttribute("categoryPages", categoryPages);
         //----------------------------Header End---------------------------------------------------
        return "MemberWallet";
    }
    @RequestMapping(value = "/getEmployeesession", method = RequestMethod.GET)
    public String getEmployeesessionDetails(HttpSession session) {
       
        List<MemberDetails> members = memberDetailsService.getEmployeesession();

       
        session.setAttribute("members", members);


        return "membersView";
    }
    @RequestMapping(value = "/getMembersession", method = RequestMethod.GET)
    public String getMemberDetails(HttpSession session) {
       
        List<MemberDetails> member = memberDetailsService.getMembersession();

       
        session.setAttribute("member", member);


        return "membersView";
    }
    @RequestMapping(value = "AdminDashboard", method = RequestMethod.GET)
    public String viewAdminDashboard(Map<String, Object> model) {
        Map<String, Integer> roleCounts = memberDetailsService.getRoleCounts();
        System.out.println("roleCounts in controller: " + roleCounts);
        model.put("roleCounts", roleCounts);
        return "AdminDashboard"; 
    }
      @RequestMapping(value = "SessionAdminExpire", method = RequestMethod.GET)
    public String SessionAdminExpire(Map<String, Object> model) {
        return "SessionAdminExpire";
    }
      
      @RequestMapping(value = "Automaticupdation", method = RequestMethod.GET)
      public String Automaticupdation(Map<String, Object> model) {
          return "Automaticupdation";
      }
      @RequestMapping(value = "/Automaticupdation", method = RequestMethod.POST)
      public String processJsonForm(@RequestParam("jsonformat") String jsonData, Model model) {


          String response = memberDetailsService.processJsonData(jsonData);

         
          model.addAttribute("response", response);

      
          System.out.println("Response: " + response);

          return "Automaticupdation";  
      }

      @RequestMapping(value = "SessionMemberExpire", method = RequestMethod.GET)
      public String SessionMemberExpire(Map<String, Object> model) {
          return "SessionMemberExpire";
      }  
    @RequestMapping(value = "AdminHeader", method = RequestMethod.GET)
    public String viewAdminHeader(HttpSession session, Model model) {
        
        String role = (String) session.getAttribute("role");
        String name = (String) session.getAttribute("name");
        String loginPin = (String) session.getAttribute("loginPin");

     
        if (role == null || name == null || loginPin == null) {
            return "redirect:/SessionAdminExpire";  
        }

        model.addAttribute("role", role);
        model.addAttribute("name", name);
        model.addAttribute("loginPin", loginPin);

        return "AdminHeader";
    }
   /* @RequestMapping(value = "Electricity", method = RequestMethod.GET)
    public String viewElectricity(Map<String, Object> model) {
        List<MemberDetails> electricityList = memberDetailsService.getElectricity(); 
        model.put("electricityList", electricityList);
 //----------Header--------------------------------------------------------------
        
        List<String> categoryNames2 = memberDetailsService.getCategoryNames();
        Map<String, String> categoryPages = memberDetailsService.getCategoryPages(); 
        Map<String, String> categoryIcons = new HashMap<>();
        categoryIcons.put("Hospital and Pathology", "fa fa-hospital");
        categoryIcons.put("Broadband Prepaid", "fa fa-wifi");
        categoryIcons.put("Cable TV", "fa fa-tv");
        categoryIcons.put("Credit Card", "fa fa-credit-card");
        categoryIcons.put("DTH", "fa fa-tv");
        categoryIcons.put("Education Fees", "fa fa-graduation-cap");
        categoryIcons.put("Electricity", "fa fa-bolt");
        categoryIcons.put("Fastag", "fa fa-car");
        categoryIcons.put("Gas", "fa fa-fire");
        categoryIcons.put("Health Insurance", "fa fa-heartbeat");
        categoryIcons.put("Hospital", "fa fa-hospital");
        categoryIcons.put("Housing Society", "fa fa-building");
        categoryIcons.put("Insurance", "fa fa-shield-alt");
        categoryIcons.put("Landline Postpaid", "fa fa-phone-alt");
        categoryIcons.put("Life Insurance", "fa fa-shield-alt");
        categoryIcons.put("Loan Repayment", "fa fa-money-bill");
        categoryIcons.put("LPG Gas", "fa fa-fire");
        categoryIcons.put("Mobile Postpaid", "fa fa-mobile-alt");
        categoryIcons.put("Municipal Services", "fa fa-city");
        categoryIcons.put("Municipal Taxes", "fa fa-money-bill-wave");
        categoryIcons.put("Subscription", "fa fa-cogs");
        categoryIcons.put("Water", "fa fa-tint");
        categoryIcons.put("Clubs and Associations", "fa fa-users");
        categoryIcons.put("Mobile Prepaid", "fa fa-mobile-alt");
        categoryIcons.put("Recurring Deposit", "fa fa-piggy-bank");
        categoryIcons.put("Metro", "fa fa-subway");
        categoryIcons.put("Rental", "fa fa-home");
        categoryIcons.put("Broadband Postpaid", "fa fa-wifi");
        categoryIcons.put("Gift Card", "fa fa-gift");
        categoryIcons.put("NCMC Recharge", "fa fa-credit-card");
        categoryIcons.put("Mutual Fund", "fa fa-chart-line");
        categoryIcons.put("Donation", "fa fa-hand-holding-heart");
        categoryIcons.put("National Pension System", "fa fa-piggy-bank");
        categoryIcons.put("Mobile", "fa fa-mobile-alt");
        categoryIcons.put("Prepaid Meter", "fa fa-plug");
        categoryIcons.put("eChallan", "fa fa-file-alt");
        categoryIcons.put("Landline Prepaid", "fa fa-phone-alt");


        ((Model) model).addAttribute("categoryNames", categoryNames2);
        ((Model) model).addAttribute("categoryIcons", categoryIcons);  
        ((Model) model).addAttribute("categoryPages", categoryPages);
         //----------------------------Header End---------------------------------------------------
        
        return "Electricity"; 
    }
*/
    @RequestMapping(value = "MemberDashboard", method = RequestMethod.GET)
    public String viewMemberDashboard(Map<String, Object> model) {
        List<String> categoryNames = memberDetailsService.getCategoryNames();
      
        ((Model) model).addAttribute("categoryNames", categoryNames);
        
        
        
        //----------Header--------------------------------------------------------------
        
        List<String> categoryNames2 = memberDetailsService.getCategoryNames();
        Map<String, String> categoryPages = memberDetailsService.getCategoryPages(); 
        Map<String, String> categoryIcons = new HashMap<>();
        categoryIcons.put("Hospital and Pathology", "fa fa-hospital");
        categoryIcons.put("Broadband Prepaid", "fa fa-wifi");
        categoryIcons.put("Cable TV", "fa fa-tv");
        categoryIcons.put("Credit Card", "fa fa-credit-card");
        categoryIcons.put("DTH", "fa fa-tv");
        categoryIcons.put("Education Fees", "fa fa-graduation-cap");
        categoryIcons.put("Electricity", "fa fa-bolt");
        categoryIcons.put("Fastag", "fa fa-car");
        categoryIcons.put("Gas", "fa fa-fire");
        categoryIcons.put("Health Insurance", "fa fa-heartbeat");
        categoryIcons.put("Hospital", "fa fa-hospital");
        categoryIcons.put("Housing Society", "fa fa-building");
        categoryIcons.put("Insurance", "fa fa-shield-alt");
        categoryIcons.put("Landline Postpaid", "fa fa-phone-alt");
        categoryIcons.put("Life Insurance", "fa fa-shield-alt");
        categoryIcons.put("Loan Repayment", "fa fa-money-bill");
        categoryIcons.put("LPG Gas", "fa fa-fire");
        categoryIcons.put("Mobile Postpaid", "fa fa-mobile-alt");
        categoryIcons.put("Municipal Services", "fa fa-city");
        categoryIcons.put("Municipal Taxes", "fa fa-money-bill-wave");
        categoryIcons.put("Subscription", "fa fa-cogs");
        categoryIcons.put("Water", "fa fa-tint");
        categoryIcons.put("Clubs and Associations", "fa fa-users");
        categoryIcons.put("Mobile Prepaid", "fa fa-mobile-alt");
        categoryIcons.put("Recurring Deposit", "fa fa-piggy-bank");
        categoryIcons.put("Metro", "fa fa-subway");
        categoryIcons.put("Rental", "fa fa-home");
        categoryIcons.put("Broadband Postpaid", "fa fa-wifi");
        categoryIcons.put("Gift Card", "fa fa-gift");
        categoryIcons.put("NCMC Recharge", "fa fa-credit-card");
        categoryIcons.put("Mutual Fund", "fa fa-chart-line");
        categoryIcons.put("Donation", "fa fa-hand-holding-heart");
        categoryIcons.put("National Pension System", "fa fa-piggy-bank");
        categoryIcons.put("Mobile", "fa fa-mobile-alt");
        categoryIcons.put("Prepaid Meter", "fa fa-plug");
        categoryIcons.put("eChallan", "fa fa-file-alt");
        categoryIcons.put("Landline Prepaid", "fa fa-phone-alt");


        ((Model) model).addAttribute("categoryNames", categoryNames2);
        ((Model) model).addAttribute("categoryIcons", categoryIcons);  
        ((Model) model).addAttribute("categoryPages", categoryPages);
         //----------------------------Header End---------------------------------------------------
        return "MemberDashboard";
    }
    
    @RequestMapping(value = "Header", method = RequestMethod.GET)
    public String viewHeader(HttpSession session1, Model model) {
        String name = (String) session1.getAttribute("name");
        String pin = (String) session1.getAttribute("pin");
        String memberType = (String) session1.getAttribute("memberType");
        String regId = (String) session1.getAttribute("regId");

        List<String> categoryNames = memberDetailsService.getCategoryNames();
        Map<String, String> categoryPages = memberDetailsService.getCategoryPages(); 
        Map<String, String> categoryIcons = new HashMap<>();
        categoryIcons.put("Hospital and Pathology", "fa fa-hospital");
        categoryIcons.put("Broadband Prepaid", "fa fa-wifi");
        categoryIcons.put("Cable TV", "fa fa-tv");
        categoryIcons.put("Credit Card", "fa fa-credit-card");
        categoryIcons.put("DTH", "fa fa-tv");
        categoryIcons.put("Education Fees", "fa fa-graduation-cap");
        categoryIcons.put("Electricity", "fa fa-bolt");
        categoryIcons.put("Fastag", "fa fa-car");
        categoryIcons.put("Gas", "fa fa-fire");
        categoryIcons.put("Health Insurance", "fa fa-heartbeat");
        categoryIcons.put("Hospital", "fa fa-hospital");
        categoryIcons.put("Housing Society", "fa fa-building");
        categoryIcons.put("Insurance", "fa fa-shield-alt");
        categoryIcons.put("Landline Postpaid", "fa fa-phone-alt");
        categoryIcons.put("Life Insurance", "fa fa-shield-alt");
        categoryIcons.put("Loan Repayment", "fa fa-money-bill");
        categoryIcons.put("LPG Gas", "fa fa-fire");
        categoryIcons.put("Mobile Postpaid", "fa fa-mobile-alt");
        categoryIcons.put("Municipal Services", "fa fa-city");
        categoryIcons.put("Municipal Taxes", "fa fa-money-bill-wave");
        categoryIcons.put("Subscription", "fa fa-cogs");
        categoryIcons.put("Water", "fa fa-tint");
        categoryIcons.put("Clubs and Associations", "fa fa-users");
        categoryIcons.put("Mobile Prepaid", "fa fa-mobile-alt");
        categoryIcons.put("Recurring Deposit", "fa fa-piggy-bank");
        categoryIcons.put("Metro", "fa fa-subway");
        categoryIcons.put("Rental", "fa fa-home");
        categoryIcons.put("Broadband Postpaid", "fa fa-wifi");
        categoryIcons.put("Gift Card", "fa fa-gift");
        categoryIcons.put("NCMC Recharge", "fa fa-credit-card");
        categoryIcons.put("Mutual Fund", "fa fa-chart-line");
        categoryIcons.put("Donation", "fa fa-hand-holding-heart");
        categoryIcons.put("National Pension System", "fa fa-piggy-bank");
        categoryIcons.put("Mobile", "fa fa-mobile-alt");
        categoryIcons.put("Prepaid Meter", "fa fa-plug");
        categoryIcons.put("eChallan", "fa fa-file-alt");
        categoryIcons.put("Landline Prepaid", "fa fa-phone-alt");


        model.addAttribute("categoryNames", categoryNames);
        model.addAttribute("categoryIcons", categoryIcons);  
        model.addAttribute("categoryPages", categoryPages);
        model.addAttribute("name", name);
        model.addAttribute("pin", pin);
        model.addAttribute("memberType", memberType);
        model.addAttribute("regId", regId);

        return "Header";
    }




    @RequestMapping(value = "/AdminLogin", method = RequestMethod.POST)
    public String loginAdmin(@ModelAttribute("MemberEntity") MemberDetails member, Model model, RedirectAttributes redirectAttributes, HttpSession session) {

        MemberDetails existingMember = memberDetailsService.getEmployeeByLoginPin(member.getLogin_Pin());

        if (existingMember != null && existingMember.getPassword().equals(member.getPassword())) {
            
            session.setAttribute("role", existingMember.getRole());
            session.setAttribute("name", existingMember.getName());
            session.setAttribute("loginPin", existingMember.getLogin_Pin());
            redirectAttributes.addFlashAttribute("success", "Login successful! Redirecting...");
            return "redirect:/AdminDashboard";
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid login pin or password.");
            return "redirect:/AdminLogin"; 
        }
    }

    @RequestMapping(value = "/AdminEmployeeList", method = RequestMethod.GET)
    public String getAllEmployees(@RequestParam(defaultValue = "1") int page, Model model) {
        int pageSize = 10; 
        List<MemberDetails> members = memberDetailsService.getEmployeesByPage(page, pageSize);
        model.addAttribute("members", members);
       
        return "AdminEmployeeList";  
    }

    @RequestMapping(value = "AdminEmployeeRegistration", method = RequestMethod.GET)
    public String viewAdminEmployeeRegistration(@RequestParam(value = "login_Pin", required = false) String loginPin, Map<String, Object> model) {
        if (loginPin != null) {
            MemberDetails member = memberDetailsService.getEmployeeByLoginPin(loginPin);
            model.put("member", member);
        } else {
            model.put("member", new MemberDetails());
        }
        return "AdminEmployeeRegistration";
    }


    @RequestMapping(value = "/EmployeeRegistration", method = RequestMethod.POST)
    public String saveOrUpdateEmployee(@ModelAttribute("MemberEntity") MemberDetails member, Model model) {
        try {
            if (member.getLogin_Pin() != null && !member.getLogin_Pin().isEmpty()) {
     
                memberDetailsService.updateEmployeeDetails(member);
                model.addAttribute("successMessage", "Employee updated successfully!");
         
            } else {
              
                String loginPin = memberDetailsService.saveEmployeeeRegistration(member);
                model.addAttribute("successMessage", "Registration Successful! Your LoginPin: " + loginPin);
            }
            return "AdminEmployeeRegistration"; 
        } catch (Exception e) {
            model.addAttribute("errorMessage", "An error occurred: " + e.getMessage());
            return "AdminEmployeeRegistration";
        }
    }


    @RequestMapping(value = "/showDocument", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> showDocument(@RequestParam("regId") String regId) {
      
        MemberDetails member = memberDetailsService.getMemberByRegId(regId);
        
        byte[] documentData = member.getDocuments(); 
        
        HttpHeaders headers = new HttpHeaders();
        
    
        if (documentData != null && documentData.length > 0 && isImage(documentData)) {
            headers.setContentType(MediaType.IMAGE_JPEG);  
        }
  
        else if (documentData != null && documentData.length > 0) {
            headers.setContentType(MediaType.valueOf("application/pdf"));  
        }

        return new ResponseEntity<>(documentData, headers, HttpStatus.OK);
    }

 
    private boolean isImage(byte[] documentData) {
      
        if (documentData[0] == (byte) 0xFF && documentData[1] == (byte) 0xD8) {
            return true;
        }
     
        if (documentData[0] == (byte) 0x89 && documentData[1] == (byte) 0x50 &&
            documentData[2] == (byte) 0x4E && documentData[3] == (byte) 0x47) {
            return true;
        }
       
        if (documentData[0] == (byte) 0x47 && documentData[1] == (byte) 0x49 &&
            documentData[2] == (byte) 0x46 && documentData[3] == (byte) 0x38) {
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/AdminApprovalMember1", method = RequestMethod.GET)
    public String showMemberDetails1(@RequestParam("regId") String regId, Model model) {
        System.out.println("Fetched members: " + regId);
        MemberDetails member = memberDetailsService.getMemberByRegId(regId);
        
        boolean isImage = false;
        if (member.getDocuments() != null && member.getDocuments().length > 0) {
            isImage = isImage(member.getDocuments()); 
        }

        model.addAttribute("member", member);
        model.addAttribute("isImage", isImage); 
        return "AdminApprovalMember1";
    }

    @RequestMapping(value = "/AdminApprovalMember", method = RequestMethod.GET)
    public String showMemberDetails(@RequestParam(defaultValue = "1") int page, Model model) {
        int pageSize = 5;  // Limit to 5 members per page
        List<MemberDetails> members = memberDetailsService.getMembersByStatusAndPage("C", page, pageSize);
        int totalMembers = memberDetailsService.countMembersByStatus("C");
        int totalPages = (int) Math.ceil(totalMembers * 1.0 / pageSize);

        model.addAttribute("members", members);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "AdminApprovalMember";  
    }

    @RequestMapping(value = "/AdminWalletApprovalMember", method = RequestMethod.GET)
    public String showAdminWalletApprovalMember(@RequestParam(defaultValue = "1") int page, Model model) {
        List<MemberDetails> members = memberDetailsService.showAdminWalletApprovalMember();
        model.addAttribute("members", members);  
        model.addAttribute("currentPage", page);
        return "AdminWalletApprovalMember";
    }

   

  


    @RequestMapping(value = "/CheckingRegid/{regId}", method = RequestMethod.GET)
    @ResponseBody
    public String checkRegId(@PathVariable("regId") String regId) {
        try {
            System.out.println("Checking RegId: " + regId);
            boolean exists = memberDetailsService.validateRegId(regId);
            Map<String, Boolean> response = new HashMap<>();
            response.put("exists", exists);
            return ""+exists;
        } catch (Exception e) {
            e.printStackTrace();  // Log the error
            Map<String, Boolean> errorResponse = new HashMap<>();
            errorResponse.put("exists", false);  
            return "0";
        }
    }
    @RequestMapping(value = "/AdminUpdateWalletApproved", method = RequestMethod.POST)
    public String AdminUpdateWalletApproved(
            @RequestParam("pin") String pin,
            @RequestParam("bankName") String bankName,
            @RequestParam("balance") String balance,
            @RequestParam("amount") String amount,
            @RequestParam("referenceNo") String referenceNo,
            @RequestParam("paymentMode") String paymentMode,
            @RequestParam("paymentDate") String paymentDate,
            @RequestParam("remarks") String remarks,
            HttpSession session, 
            Model model) {

        boolean updated = false;

        try {
      
            updated = memberDetailsService.AdminUpdateWalletApproved(pin, bankName, balance, amount, referenceNo, paymentMode, paymentDate,remarks, session);

            if (updated) {
            	  System.out.println("updated: " + updated);
                return "redirect:/SuccessApprovalMember1";  
            } else {
                model.addAttribute("errorMessage", "Failed to update.");
          	  System.out.println("errorMessage: " + model);
                return "errorPage";  
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error occurred: " + e.getMessage());
            System.out.println("Exception: " + e);
            return "errorPage";  
        }
    }


    @RequestMapping(value = "/updateApprovalMember", method = RequestMethod.POST)
    public String updateApprovalMember(@RequestParam("regId") String regId, 
                                       HttpSession session, Model model) {
        boolean updated = false;

        try {
        
            updated = memberDetailsService.updateMemberApproval(regId, session);  

            if (updated) {
                return "redirect:/SuccessApprovalMember1";  
            } else {
                model.addAttribute("errorMessage", "Failed to update.");
                return "errorPage";  
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error occurred: " + e.getMessage());
            return "errorPage";  
        }
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public String updatePassword(@RequestParam("regId") String regId, 
                                 @RequestParam("password") String password,
                                 Model model) {
        try {
          
            if (password == null || password.isEmpty()) {
                model.addAttribute("errorMessage", "Password cannot be empty.");
                return "errorPage";
            }
        
            boolean updated = memberDetailsService.updatePassword(regId, password);
            if (updated) {
               
                return "redirect:/Memberlogin";  
            } else {
                model.addAttribute("errorMessage", "Failed to update password.");
                return "errorPage";
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error occurred: " + e.getMessage());
            return "errorPage";
        }
    }

    @RequestMapping(value = "/MemberDetails", method = RequestMethod.POST)
    public String saveMemberDetails(@ModelAttribute("MemberEntity") MemberDetails member, Model model) {
        try {
          
            Map<String, String> result = memberDetailsService.saveMemberDetails(member);
            
            String regId = result.get("regId");
            String pin = result.get("pin");

            if (regId != null) {
                model.addAttribute("successMessage", "Registration Successful! Your Registration ID: " + regId + ". Kindly Note Your Pin: " + pin);
                return "register"; 
            } else {
                model.addAttribute("errorMessage", "Registration failed. Please try again.");
                return "register";
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", "An error occurred: " + e.getMessage());
            return "register";
        }
    }

 
    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public String login(@ModelAttribute("MemberEntity") MemberDetails member, Model model, RedirectAttributes redirectAttributes, HttpSession session1) {
        String regId = member.getRegId();
        String password = member.getPassword();

        System.out.println("RegId from form: " + regId);
        System.out.println("Password from form: " + password);

        if (regId != null && password != null) {
            boolean isValidUser = memberDetailsService.validateUser(regId, password);
            MemberDetails currentMember = memberDetailsService.getsessionMemberByRegId(regId);
            if (isValidUser) {
                String status = memberDetailsService.checkMemberStatus(regId);
                if ("A".equals(status)) {
                    System.out.println("Login successful for RegId: " + regId);
                    session1.setAttribute("currentMember", currentMember);
                    session1.setAttribute("name", currentMember.getName());
                    session1.setAttribute("regId", currentMember.getRegId());
                    session1.setAttribute("pin", currentMember.getPin());
                    session1.setAttribute("memberType", currentMember.getMemberType());
                    System.out.println("name: " +  currentMember.getName());
                    System.out.println("getRegId: " +  currentMember.getRegId());
                    System.out.println("name: " +  currentMember.getPin());
                    return "redirect:/MemberDashboard"; 
                } else {
                    redirectAttributes.addFlashAttribute("errorMessage", "Your account is pending approval. Please contact admin.");
                    return "redirect:/Memberlogin";
                }
            } else {
                System.out.println("Invalid password attempt for RegId: " + regId);
                redirectAttributes.addFlashAttribute("errorMessage", "Password is incorrect.");
                return "redirect:/Memberlogin";
            }
        } else {
            // Missing regId or password
            System.out.println("Invalid login attempt for RegId: null or Password: null");
            redirectAttributes.addFlashAttribute("errorMessage", "Please provide both RegId and Password.");
            return "redirect:/BlueRayApp/Memberlogin";
        }
    }


}