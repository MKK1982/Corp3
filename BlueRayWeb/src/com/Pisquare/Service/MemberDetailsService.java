package com.Pisquare.Service;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import com.Pisquare.Beans.MemberDetails;
import com.Pisquare.Dao.MemberDetailsDao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List; 

import javax.servlet.http.HttpSession;
@Service
public class MemberDetailsService {

    @Autowired
    private MemberDetailsDao memberDetailsDao;

    @Autowired
    private JdbcTemplate jdbcTemplate; 
    public List<MemberDetails> getElectricity() {
        return memberDetailsDao.getElectricity();
    }

    public List<String> getCategoryNames() {
        return memberDetailsDao.getCategoryNames();
    }
    public String processJsonData(String jsonData) {
        try {
            System.out.println("Received JSON Data: " + jsonData);  // Log the received JSON

         
            JSONObject jsonObject = (JSONObject) org.json.simple.JSONValue.parse(jsonData);

        
            System.out.println("Parsed JSON Object: " + jsonObject);


            String id = jsonObject.get("Id").toString();
            System.out.println("Extracted ID: " + id);

 
            if (memberDetailsDao.recordExists(id)) {
               
                System.out.println("Record exists. Updating...");
                memberDetailsDao.updateRecord(jsonObject);
                return "Record updated successfully";
            } else {
           
                System.out.println("Record does not exist. Inserting...");
                memberDetailsDao.insertRecord(jsonObject);
                return "Record inserted successfully";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error processing data: " + e.getMessage();
        }
    }

  
    public Map<String, String> getCategoryPages()  {
        return memberDetailsDao.getCategoryPages();
    }
    public Map<String, String> saveMemberDetails(MemberDetails member) {
        return memberDetailsDao.saveMemberDetails(member);
    }
   
    public MemberDetails getsessionMemberByRegId(String regId) {
        return memberDetailsDao.getsessionMemberByRegId(regId);
    }

    public Map<String, String> saveFundRequest(String bankName, String balance, String amount, 
            String referenceNo, String paymentMode, 
            Date paymentDate, String remarks, String pin) {
Map<String, String> result = new HashMap<>();
try {
memberDetailsDao.saveFundRequest(bankName, balance, amount, referenceNo, paymentMode, paymentDate, remarks, pin);
result.put("success", "Fund request saved successfully.");
} catch (Exception e) {
result.put("error", "Error saving fund request: " + e.getMessage());
}
return result;
}

    
    public List<MemberDetails>getEmployeesession() {
        return memberDetailsDao.getEmployeesession();
    }
    public List<MemberDetails>getMembersession() {
        return memberDetailsDao.getMembersession();
    }
    public Map<String, Integer> getRoleCounts() {
        return memberDetailsDao.getRoleCounts();
    }
    public MemberDetails getEmployeeByLoginPin(String loginPin) {
        return memberDetailsDao.getEmployeeByLoginPin(loginPin);
    }
    public void updateEmployeeDetails(MemberDetails member) {
        memberDetailsDao.updateEmployeeDetails(member);
    }

    public String saveEmployeeeRegistration(MemberDetails member) {
        return memberDetailsDao.saveEmployeeeRegistration(member);
    }    
    public List<MemberDetails> getAllEmployees() {
        return memberDetailsDao.getAllEmployees();
    }
    public List<MemberDetails> showAdminWalletApprovalMember() {
        return memberDetailsDao.showAdminWalletApprovalMember();
    }
    public List<MemberDetails> getEmployeesByPage(int page, int pageSize) {
        return memberDetailsDao.getEmployeesByPage(page, pageSize);
    }

   
    public List<MemberDetails> getMembersByStatus(String status) {
        return memberDetailsDao.getMembersByStatus(status);
    }
    public MemberDetails getMemberByRegId(String regId) {
        return memberDetailsDao.getMemberByRegId(regId);
    }
    public List<MemberDetails> getMembersByStatusAndPage(String status, int page, int pageSize) {
        int offset = (page - 1) * pageSize; 
        return memberDetailsDao.getMembersByStatusAndPage(status, offset, pageSize);
    }

    public int countMembersByStatus(String status) {
        return memberDetailsDao.countMembersByStatus(status);
    }

    public boolean validateUser(String regId, String password) {
        return memberDetailsDao.validateUser(regId, password);
    }
    public boolean validateRegId(String regId) {
        System.out.println("Validating RegId: " + regId);
        try {
            return memberDetailsDao.checkRegIdExistence(regId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;  
        }
    }
    public boolean updateMemberApproval(String regId, HttpSession session) {
        return memberDetailsDao.updateMemberApproval(regId,session);
    }

    public boolean AdminUpdateWalletApproved(
    	    String pin, String bankName, String balance, String amount,
    	    String referenceNo, String paymentMode, String paymentDate, String remarks,
    	    HttpSession session) {
    	    
    	    return memberDetailsDao.AdminUpdateWalletApproved(pin, bankName, balance, amount, referenceNo, paymentMode, paymentDate,remarks, session);
    	}


    public boolean updatePassword(String regId, String password) {
        return memberDetailsDao.updatePassword(regId, password);
    }
    public String checkMemberStatus(String regId) {
   
        String query = "SELECT Status FROM dbo.Member_Details WHERE Reg_Id = ?";
        try {
            return jdbcTemplate.queryForObject(query, new Object[]{regId}, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }
}
