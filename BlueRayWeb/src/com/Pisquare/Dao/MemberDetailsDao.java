package com.Pisquare.Dao;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.Pisquare.Beans.EmployeeDetails;
import com.Pisquare.Beans.MemberDetails;










import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.Date;

import javax.servlet.http.HttpSession;
@Repository
public class MemberDetailsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public boolean recordExists(String id) {
        String sql = "SELECT COUNT(*) FROM Biller WHERE id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{id}, Integer.class);
        return count != null && count > 0;
    }

 
    public void updateRecord(JSONObject jsonObject) {
        String sql = "UPDATE Biller SET name = ?, alias = ?, category = ?, state_short = ?, " +
                "isParent = ?, parentBillerId = ?, status = ?, lastUpdated = ?, logo = ?, city = ? WHERE id = ?";

        jdbcTemplate.update(sql, 
                jsonObject.get("name").toString(), 
                jsonObject.get("alias").toString(),
                jsonObject.get("category").toString(), 
                jsonObject.get("State_short").toString(),
                jsonObject.get("isParent").toString(), 
                jsonObject.get("parentBillerId").toString(),
                jsonObject.get("Status").toString(),
                jsonObject.get("lastUpdated").toString(),
                jsonObject.get("logo").toString(), 
                jsonObject.get("city").toString(), 
                jsonObject.get("Id").toString());
    }


    public void insertRecord(JSONObject jsonObject) {
        String sql = "INSERT INTO Biller (id, name, alias, category, state_short, isParent, " +
                "parentBillerId, status, lastUpdated, logo, city) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, 
                jsonObject.get("Id").toString(), 
                jsonObject.get("name").toString(),
                jsonObject.get("alias").toString(), 
                jsonObject.get("category").toString(),
                jsonObject.get("State_short").toString(), 
                jsonObject.get("isParent").toString(),
                jsonObject.get("parentBillerId").toString(), 
                jsonObject.get("Status").toString(),
                jsonObject.get("lastUpdated").toString(), 
                jsonObject.get("logo").toString(),
                jsonObject.get("city").toString());
    }
    public List<MemberDetails> getElectricity() {
        String sql = "SELECT name, State1, logo FROM Biller"; 
        try {
            List<MemberDetails> electricityList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(MemberDetails.class));
            System.out.println("Fetched Data: " + electricityList);
            return electricityList;
        } catch (Exception e) {
            System.out.println("Error fetching electricity data: " + e.getMessage());
            e.printStackTrace(); 
            System.out.println("Exception: " + e);
            return new ArrayList<>(); 
        }
    }

   
    public List<String> getCategoryNames() {
        String sql = "SELECT categoryName FROM CategoryList"; 
        try {
            List<String> categoryNames = jdbcTemplate.queryForList(sql, String.class);
            
           
            System.out.println("Fetched Category Names: " + categoryNames);
            
            return categoryNames;
        } catch (Exception e) {
           
            System.out.println("Error fetching category names: " + e.getMessage());
            e.printStackTrace(); 
            return new ArrayList<>(); 
        }
    }
    public Map<String, String> getCategoryPages() {
        String sql = "SELECT categoryName, Page FROM CategoryList";
        Map<String, String> categoryPages = new HashMap<>();

        try {
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
            for (Map<String, Object> row : rows) {
                String categoryName = (String) row.get("categoryName");
                String page = (String) row.get("Page");
                categoryPages.put(categoryName, page);
            }
        } catch (Exception e) {
            System.out.println("Error fetching category pages: " + e.getMessage());
            e.printStackTrace();
        }
        return categoryPages;
    }


    public List<MemberDetails> getEmployeesession() {
        String sql = "SELECT Role, Name, Age, Mobile, Address, Login_Pin, Email FROM dbo.Admin_Details";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(MemberDetails.class));
    }
    public boolean AdminUpdateWalletApproved(
            String pin, String bankName, String balance, String amount,
            String referenceNo, String paymentMode, String paymentDate, String remarks, HttpSession session) {

        String loginPin = (String) session.getAttribute("loginPin");
        System.out.println("LoginPin: " + loginPin);

        if (loginPin == null || loginPin.isEmpty()) {
            throw new IllegalArgumentException("Login pin is not available in the session");
        }

      
        String insertQuery = "INSERT INTO [dbo].[Member_Daily_Transaction] (BankName, Balance, Amount, Reference_no, Payment_Mode, Payment_Date, Pin, Remarks, Approved_By) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";


        String updateFundRequestQuery = "UPDATE [dbo].[Fund_Request] SET Status1 = 'Approved' WHERE Pin = ?";

        
        String updateBalanceQuery = "UPDATE [dbo].[Member_Daily_Transaction] SET Balance = CAST(CAST(Balance AS DECIMAL) + ? AS VARCHAR) WHERE Pin = ?";

     
        int insertRows = jdbcTemplate.update(insertQuery, bankName, balance, amount, referenceNo, paymentMode, paymentDate, pin, remarks, loginPin);


        int insertRows1 = jdbcTemplate.update(updateFundRequestQuery, pin);


        int insertRows2 = jdbcTemplate.update(updateBalanceQuery, amount, pin);

        return insertRows > 0 && insertRows1 > 0 && insertRows2 > 0;
    }


    public void saveFundRequest(String bankName, String balance, String amount, 
            String referenceNo, String paymentMode, 
            Date paymentDate, String remarks, String pin) {

String sql1 = "INSERT INTO [dbo].[Fund_Request] (BankName, Balance, Amount, Reference_no, Payment_Mode, Payment_Date, Remarks, Pin , Status1) VALUES (?, ?, ?, ?, ?, ?, ?, ?, 'Not Approved')";



try {

jdbcTemplate.update(sql1, bankName, balance, amount, referenceNo, paymentMode, paymentDate, remarks, pin);

} catch (Exception e) {
System.out.println("Exception: " + e.getMessage());
}
}


    public List<MemberDetails> getMembersession() {
        String sql = "SELECT Reg_Id, Member_Type, Mobile, Name, Email, Pin, Pan_No,Aadhar_No,City,State,Pincode FROM dbo.Member_Details";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(MemberDetails.class));
    }
    public MemberDetails getsessionMemberByRegId(String regId) {
        String sql = "SELECT * FROM dbo.Member_Details WHERE Reg_Id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{regId}, new BeanPropertyRowMapper<>(MemberDetails.class));
        } catch (EmptyResultDataAccessException e) {
            return null;  
        }
    }

    public Map<String, Integer> getRoleCounts() {
        String query = "SELECT Role as role, COUNT(*) AS count FROM dbo.Admin_Details GROUP BY Role";
        try {
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
            System.out.println("Rows: " + rows);
            
            Map<String, Integer> roleCounts = new HashMap<>();
            for (Map<String, Object> row : rows) {
                String role = (String) row.get("role");
                Integer count = ((Number) row.get("count")).intValue();  
                roleCounts.put(role, count);
            }
            
            System.out.println("roleCounts: " + roleCounts); 
            return roleCounts;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catch: " + e);
            return new HashMap<>();
        }
    }


    public List<MemberDetails> getAllEmployees() {
        String query = "SELECT * FROM dbo.Admin_Details";
        System.out.println("Executing query: " + query);
        try {
            return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(MemberDetails.class));
           
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception: " + e);
            return null;
        }
    }
    public List<MemberDetails> showAdminWalletApprovalMember() {
        String query = "Select * From Fund_Request	a Left join Member_Details b on a.Pin = b.Pin";
        System.out.println("Executing query: " + query);
        try {
            return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(MemberDetails.class));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception: " + e);
            return null;
        }
    }

    public List<MemberDetails> getEmployeesByPage(int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        String query = "WITH PaginatedResults AS ( " +
                       "  SELECT *, ROW_NUMBER() OVER (ORDER BY Id) AS RowNum " +
                       "  FROM dbo.Admin_Details " +
                       ") " +
                       "SELECT * FROM PaginatedResults WHERE RowNum BETWEEN ? AND ?";

        System.out.println("Executing query: " + query);

        try {
            int startRow = offset + 1;  
            int endRow = offset + pageSize;  
            return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(MemberDetails.class), startRow, endRow);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception: " + e);
            return null;
        }
    }


    public String generateLoginPin() {
        String query = "SELECT TOP 1 Login_Pin FROM dbo.Admin_Details ORDER BY Login_Pin DESC";
        try {
            String latestLoginPin = jdbcTemplate.queryForObject(query, String.class);
            if (latestLoginPin != null && latestLoginPin.startsWith("EM")) {
                int latestNumber = Integer.parseInt(latestLoginPin.substring(2));
                latestNumber++;
                return "EM" + String.format("%03d", latestNumber); 
            } else {
                return "EM001";  
            }
        } catch (Exception e) {
            return "EM001";  
        }
    }
    public MemberDetails getEmployeeByLoginPin(String loginPin) {
        String query = "SELECT * FROM dbo.Admin_Details WHERE Login_Pin = ?";
        try {
            // Using BeanPropertyRowMapper for mapping the result directly to MemberDetails class
            return jdbcTemplate.queryForObject(query, new Object[]{loginPin}, new BeanPropertyRowMapper<>(MemberDetails.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void updateEmployeeDetails(MemberDetails member) {
        String query = "UPDATE dbo.Admin_Details SET Role = ?, Name = ?, Age = ?, Email = ?, Mobile = ?, Address = ?, Pincode = ?, Password = ?, Status = ? WHERE Login_Pin = ?";
        jdbcTemplate.update(query,
            member.getRole(),
            member.getName(),
            member.getAge(),
            member.getEmail(),
            member.getMobile(),
            member.getAddress(),
            member.getPincode(),
            member.getPassword(),
            member.isActive() ? "Active" : "Inactive",
            member.getLogin_Pin()
        );
    }



    public String saveEmployeeeRegistration(MemberDetails member) {
        String loginPin = generateLoginPin();
        String status = member.isActive() ? "Active" : "Inactive"; 

        String query = "INSERT INTO dbo.Admin_Details (Login_Pin, Role, Name, Age, Email, Mobile, Address, Pincode, Password, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(query, 
                loginPin,
                member.getRole(), 
                member.getName(),
                member.getAge(), 
                member.getEmail(), 
                member.getMobile(), 
                member.getAddress(),
                member.getPincode(),
                member.getPassword(),
                status  
            );
            return loginPin;
        } catch (Exception e) {
            e.printStackTrace();
            return "Registration failed.";
        }
    }


    public List<MemberDetails> getMembersByStatus(String status) {
        String query = "SELECT * FROM dbo.Member_Details WHERE Status = ?";
        System.out.println("Executing query: " + query + " with status = " + status); 
        List<MemberDetails> members = jdbcTemplate.query(query, new Object[]{status}, (rs, rowNum) -> {
            MemberDetails member = new MemberDetails();
            member.setRegId(rs.getString("Reg_Id"));
            member.setMemberType(rs.getString("Member_Type"));
            member.setMobile(rs.getLong("Mobile"));
            member.setName(rs.getString("Name"));
            member.setStatus(rs.getString("Status"));
            member.setEmail(rs.getString("Email"));
            return member;
        });
        System.out.println("Number of members fetched: " + members.size());
        return members;
    }
    public List<MemberDetails> getMembersByStatusAndPage(String status, int offset, int limit) {
        String query = "SELECT * FROM dbo.Member_Details WHERE Status = ? ORDER BY Reg_Id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        return jdbcTemplate.query(query, new Object[]{status, offset, limit}, (rs, rowNum) -> {
            MemberDetails member = new MemberDetails();
            member.setRegId(rs.getString("Reg_Id"));
            member.setMemberType(rs.getString("Member_Type"));
            member.setMobile(rs.getLong("Mobile"));
            member.setName(rs.getString("Name"));
            member.setStatus(rs.getString("Status"));
            member.setEmail(rs.getString("Email"));
            return member;
        });
    }


    public int countMembersByStatus(String status) {
        String query = "SELECT COUNT(*) FROM dbo.Member_Details WHERE Status = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{status}, Integer.class);
    }

    public MemberDetails getMemberByRegId(String regId) {
        String query = "SELECT * FROM dbo.Member_Details WHERE Reg_Id = ?";
        System.out.println("Executing query: " + query + " with Reg_Id = " + regId); 
        return jdbcTemplate.queryForObject(query, new Object[]{regId}, (rs, rowNum) -> {
            MemberDetails member = new MemberDetails();
            member.setRegId(rs.getString("Reg_Id"));
            member.setMemberType(rs.getString("Member_Type"));
            member.setMobile(rs.getLong("Mobile"));
            member.setName(rs.getString("Name"));
            member.setStatus(rs.getString("Status"));
            member.setEmail(rs.getString("Email"));
            member.setShopName(rs.getString("Shop_Name"));
            member.setShopAddress(rs.getString("Shop_Address"));
            member.setHomeAddress(rs.getString("Home_Address"));
            member.setPanNo(rs.getString("Pan_No"));
            member.setAadharNo(rs.getString("Aadhar_No"));
            member.setCity(rs.getString("City"));
            member.setState(rs.getString("State"));
            member.setPincode(Integer.parseInt(rs.getString("Pincode")));
            member.setDocuments(rs.getBytes("Documents"));

        
            return member;
        });
    }


    public boolean updateMemberApproval(String regId, HttpSession session) {

        String updateQuery = "UPDATE dbo.Member_Details SET Status = 'A' WHERE Reg_Id = ? AND Status ='C'";
        int rowsAffected = jdbcTemplate.update(updateQuery, regId);

        if (rowsAffected > 0) {
         
            String role = (String) session.getAttribute("role");
            String name = (String) session.getAttribute("name");
            String loginPin = (String) session.getAttribute("loginPin");

            String insertQuery = "INSERT INTO dbo.AdminApprovedMember (Role, Name, Reg_Id,Authorized_By) VALUES (?, ?, ?,?)";
            int insertRows = jdbcTemplate.update(insertQuery, role, name, regId, loginPin);

     
            return insertRows > 0;
        }
        return false;
    }

    public boolean updatePassword(String regId, String password) {
        String query = "UPDATE dbo.Member_Details SET Password = ? WHERE Reg_Id = ?";
        int rowsAffected = jdbcTemplate.update(query, password, regId);
        return rowsAffected > 0;
    }
    public boolean checkRegIdExistence(String regId) {
        String query = "SELECT COUNT(*) FROM dbo.Member_Details WHERE Reg_Id = ?   OR CAST(Email AS VARCHAR(MAX)) = ?";
        System.out.println("Count" + query);
        try {
            System.out.println("Executing query to check RegId existence: " + regId);
            int count = jdbcTemplate.queryForObject(query, new Object[]{regId, regId}, Integer.class);
            System.out.println("Count from DB: " + count);
     
            if(count>0)
            return true;
            else
            	return false;
            	
           
        } catch (Exception e) {
            e.printStackTrace();  
            System.out.println("Count from DB: " + e);
            return false;
   
        }
    }

 

    public String generateRegId() {
        String query = "SELECT TOP 1 Reg_Id FROM dbo.Member_Details ORDER BY Reg_Id DESC";
        try {
            String latestRegId = jdbcTemplate.queryForObject(query, String.class);
            if (latestRegId != null && latestRegId.startsWith("BF")) {
                int latestNumber = Integer.parseInt(latestRegId.substring(2));
                latestNumber++;
                return "BF" + String.format("%03d", latestNumber); 
            } else {
                return "BF001";  
            }
        } catch (Exception e) {
            return "BF001";  
        }
    }

    public String generatePin() {
        Random rand = new Random();
        int pin = 10000 + rand.nextInt(90000); 
        return String.valueOf(pin); 
    }

    public Map<String, String> saveMemberDetails(MemberDetails member) {
        String regId = generateRegId();
        String pin = generatePin();
        String query = "INSERT INTO dbo.Member_Details (Reg_Id, Member_Type, Mobile, Name, Email, Shop_Name, Shop_Address, Home_Address, Pan_No, Aadhar_No, City, State, Pincode, Documents, Password, Status, Otp,Pin) " +
                "VALUES (?,?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,'C',?,?)";

        try {
            jdbcTemplate.update(query, 
                    regId, 
                    member.getMemberType(), 
                    member.getMobile(),
                    member.getName(), 
                    member.getEmail(), 
                    member.getShopName(), 
                    member.getShopAddress(),
                    member.getHomeAddress(),
                    member.getPanNo(),
                    member.getAadharNo(),
                    member.getCity(),
                    member.getState(),
                    member.getPincode(),
                    member.getDocuments(),
                    member.getPassword(),  
                    member.getOtp(),
                    pin
            );

            Map<String, String> result = new HashMap<>();
            result.put("regId", regId);
            result.put("pin", pin);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Executing query: " + query);
            System.out.println("Error: " + e);
            return null;  
        }
    }

    
    public boolean validateUser(String regId, String password) {
       
        String query = "SELECT COUNT(*) FROM dbo.Member_Details WHERE Reg_Id = ? AND Password = ? AND Status = 'A'";
        
        try {
            int count = jdbcTemplate.queryForObject(query, new Object[]{regId, password}, Integer.class);
            return count > 0; 
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

  
}


