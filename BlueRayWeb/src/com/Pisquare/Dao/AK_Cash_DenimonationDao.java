package com.Pisquare.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.List.*;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.Pisquare.Beans.Cus;
import com.Pisquare.Beans.Login;
import com.Pisquare.Beans.Branch_Master;
import com.Pisquare.Beans.Simple;
import com.Pisquare.Beans.SimpleBranch;
import com.Pisquare.Controllers.Configuration_Controller;


public class AK_Cash_DenimonationDao {

int RAndC=201;
	
	public static String newline = System.getProperty("line.separator");

	
	JdbcTemplate template;

@Autowired
private Configuration_Controller con;
	
	public void setTemplate(JdbcTemplate template)
	{ 
		this.template=template;
	}
	
	
	public List<SimpleBranch> Day_End_Cash_Poorana(String Transaction_Date1,int Bcode){

		//--Set Connection----------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
		//-----------------------------------------------------

	return template.query("select * from CASH_DENOMINATION_POORANA where Transaction_Date=to_date('"+Transaction_Date1+"','dd/MM/yyyy')",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
	{  
		
	
		SimpleBranch gl=new SimpleBranch();
		
		gl.setS41(rs.getInt(2));  //2000
	
		gl.setS43(rs.getInt(4));  //500
		gl.setS44(rs.getInt(17));  //200
		
		gl.setS45(rs.getInt(5));  //100
		gl.setS46(rs.getInt(6));  //50
		gl.setS47(rs.getInt(7));  //20
		gl.setS48(rs.getInt(8));  //10
		gl.setS49(rs.getInt(9));  //5
		int x=(int) (rs.getInt(10));
		int y=(int) (rs.getInt(11));
		gl.setS11(y);  //coins
		gl.setS42(x);  //Ajust
		gl.setS2(rs.getString(18));//Status
		
		return gl;
	}
				 }     );
			}
	
	
	public List<SimpleBranch> getCashBookOB_Poorana(String From_Date,int Bcode){

		//--Set Connection----------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
		//-----------------------------------------------------
		return template.query("Select a.OB+b.Credit-c.Debit as CB from (Select case when Opening_Balance is NULL Then 0 else Opening_Balance End as OB  from GL_Opening_Balance where OB_Date<=to_date('"+From_Date+"','dd/MM/yyyy') and Account_Code=29006 order by OB_Date desc) a,(Select case when sum(Transaction_Amount) is NULL Then 0 else sum(Transaction_Amount) End as Credit from Daily_Transaction where Transaction_Type='Credit' and Account_No=29006 and Transaction_Date<=to_date('"+From_Date+"','dd/MM/yyyy') and Transaction_Date>=(Select OB_Date from GL_Opening_Balance where Account_Code=29006 and OB_Date<=to_date('"+From_Date+"','dd/MM/yyyy'))) b,(Select case when sum(Transaction_Amount) is NULL Then 0 else sum(Transaction_Amount) End as Debit from Daily_Transaction where Transaction_Type='Debit' and Account_No=29006 and Transaction_Date<=to_date('"+From_Date+"','dd/MM/yyyy') and Transaction_Date>=(Select OB_Date from GL_Opening_Balance where Account_Code=29006 and OB_Date<=to_date('"+From_Date+"','dd/MM/yyyy'))) c",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException{  
			
			SimpleBranch gl=new SimpleBranch();
			
			gl.setS51(Math.abs(rs.getFloat(1))); // Opening Balance
		
			return gl;
		}
					 }     );
				}
	
	

	
	public int UpdateCash_DenominationStatus_hub(String Date1,int Bcode){  

		//--Set Connection------------------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
		//-----------------------------------------------------
	    String sql="update CASH_DENOMINATION_HUB set STATUS='Y' where TRANSACTION_DATE=to_date('"+Date1+"','dd/MM/yyyy')";
	    
	  
	    	System.out.println("day end denomination saved");
	    	template.update(sql);
	    	System.out.println("day end denomination updated.....");
	    
	    
	    return 1;  
	}  
	
	
	public int Check_CashDenomiationRecord_hub(String Date1,int Bcode)
	{
		
		//--Set Connection------------------------------------
		int j=Bcode;
		this.template=con.getCon2(j);
		//-----------------------------------------------------



		int i=0;
		String query = "Select count(*) from CASH_DENOMINATION_HUB where TRANSACTION_DATE=to_date('"+Date1+"','dd/MM/yyyy')";
		PreparedStatement pstmt = null;
		try {
			pstmt = template.getDataSource().getConnection().prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet resultSet = null;
		try {
			resultSet = pstmt.executeQuery();
			//resultSet.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if (resultSet!= null) {
				  while (resultSet.next()) {
					  i=resultSet.getInt(1);
				  }
			}
			
			
			//i=resultSet.getInt(1);
			
			//i=resultSet.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	
	
	public int UpdateCash_DenominationStatus_SK(String Date1,int Bcode){  

		//--Set Connection------------------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
		//-----------------------------------------------------
	    String sql="update CASH_DENOMINATION_POORANA set STATUS='Y' where TRANSACTION_DATE=to_date('"+Date1+"','dd/MM/yyyy')";
	    
	  
	    	System.out.println("day end denomination saved");
	    	template.update(sql);
	    	System.out.println("day end denomination updated.....");
	    
	    
	    return 1;  
	}  
	
	
	public int Check_CashDenomiationRecord_SK(String Date1,int Bcode)
	{
		
		//--Set Connection------------------------------------
		int j=Bcode;
		this.template=con.getCon2(j);
		//-----------------------------------------------------



		int i=0;
		String query = "Select count(*) from CASH_DENOMINATION_POORANA where TRANSACTION_DATE=to_date('"+Date1+"','dd/MM/yyyy')";
		PreparedStatement pstmt = null;
		try {
			pstmt = template.getDataSource().getConnection().prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet resultSet = null;
		try {
			resultSet = pstmt.executeQuery();
			//resultSet.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if (resultSet!= null) {
				  while (resultSet.next()) {
					  i=resultSet.getInt(1);
				  }
			}
			
			
			//i=resultSet.getInt(1);
			
			//i=resultSet.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}


	public List<SimpleBranch> Day_End_Cash_SK(String Transaction_Date1,int Bcode){

		//--Set Connection----------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
		//-----------------------------------------------------

	return template.query("select * from Cash_Denomination_poorana where Transaction_Date=to_date('"+Transaction_Date1+"','dd/MM/yyyy')",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
	{  
		
	
		SimpleBranch gl=new SimpleBranch();
		
		gl.setS41(rs.getInt(2));  //2000
	
		gl.setS43(rs.getInt(4));  //500
		gl.setS44(rs.getInt(17));  //200
		
		gl.setS45(rs.getInt(5));  //100
		gl.setS46(rs.getInt(6));  //50
		gl.setS47(rs.getInt(7));  //20
		gl.setS48(rs.getInt(8));  //10
		gl.setS49(rs.getInt(9));  //5
		int x=(int) (rs.getInt(10));
		int y=(int) (rs.getInt(11));
		gl.setS11(y);  //coins
		gl.setS42(x);  //Ajust
		gl.setS2(rs.getString(18));//Status
		
		return gl;
	}
				 }     );
			}

	
	public List<SimpleBranch> Day_End_Cash_Hub(String Transaction_Date1,int Bcode){

		//--Set Connection----------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
		//-----------------------------------------------------

	return template.query("select * from Cash_Denomination_Hub where Transaction_Date=to_date('"+Transaction_Date1+"','dd/MM/yyyy')",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
	{  
		
	
		SimpleBranch gl=new SimpleBranch();
		
		gl.setS41(rs.getInt(2));  //2000
	
		gl.setS43(rs.getInt(4));  //500
		gl.setS44(rs.getInt(17));  //200
		
		gl.setS45(rs.getInt(5));  //100
		gl.setS46(rs.getInt(6));  //50
		gl.setS47(rs.getInt(7));  //20
		gl.setS48(rs.getInt(8));  //10
		gl.setS49(rs.getInt(9));  //5
		int x=(int) (rs.getInt(10));
		int y=(int) (rs.getInt(11));
		gl.setS11(y);  //coins
		gl.setS42(x);  //Ajust
		gl.setS2(rs.getString(18));//Status
		
		return gl;
	}
				 }     );
			}

	
	
	
	public List<SimpleBranch> getDay_SK_Details(String date1){
		//--Set Connection----------------------------
				int j=RAndC;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
		//select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' ) a order by Status,Branch;
				//new select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' union select '218' as Branch,'Thillai Nagar' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser18.calendar1 where Status='O' ) a order by Status,Branch
				//New with thanjavur  select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' union select '218' as Branch,'Thillai Nagar' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser18.calendar1 where Status='O' union select '219' as Branch,'Thanjavur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser19.calendar1 where Status='O' ) a order by Status,Branch
		return template.query("select (select branch_name from branch_master where branch_code=day_sk_cashview.branch_code) as branch_name,to_char(transaction_date,'dd/MM/yyyy'),case when status is null then 'No' else 'Yes' end as status ,branch_code,cash_balance from day_sk_cashview order by branch_code",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
		{  

			SimpleBranch gl=new SimpleBranch();
		
			
			
			
			gl.setS2(rs.getString(1));  //Bname
			gl.setS3(rs.getString(2));  //Current1
			gl.setS4(rs.getString(3));  //Status
			gl.setS5(rs.getString(5));  //Cash balance
			

			return gl;
		}
		 }     );
	}
	
	
	public List<SimpleBranch> getDay_Hub_Details(String date1){
		//--Set Connection----------------------------
				int j=RAndC;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
		//select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' ) a order by Status,Branch;
				//new select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' union select '218' as Branch,'Thillai Nagar' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser18.calendar1 where Status='O' ) a order by Status,Branch
				//New with thanjavur  select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' union select '218' as Branch,'Thillai Nagar' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser18.calendar1 where Status='O' union select '219' as Branch,'Thanjavur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser19.calendar1 where Status='O' ) a order by Status,Branch
		return template.query("select (select branch_name from branch_master where branch_code=day_hub_cashview.branch_code) as branch_name,to_char(transaction_date,'dd/MM/yyyy'),case when status is null then 'No' else 'Yes' end as status ,branch_code,cash_balance from day_hub_cashview order by branch_code",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
		{  

			SimpleBranch gl=new SimpleBranch();
		
			
			
			
			gl.setS2(rs.getString(1));  //Bname
			gl.setS3(rs.getString(2));  //Current1
			gl.setS4(rs.getString(3));  //Status
			gl.setS5(rs.getString(5));  //Cash balance
			
			

			return gl;
		}
		 }     );
	}
	
	

	public List<SimpleBranch> getCashBookOB_CashHub(String GL_Code,String From_Date,int Bcode){

		//--Set Connection----------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
		//-----------------------------------------------------
		return template.query("Select a.OB+b.Credit-c.Debit as CB from (Select case when Opening_Balance is NULL Then 0 else Opening_Balance End as OB  from GL_Opening_Balance where OB_Date<=to_date('"+From_Date+"','dd/MM/yyyy') and Account_Code='"+GL_Code+"' order by OB_Date desc) a,(Select case when sum(Transaction_Amount) is NULL Then 0 else sum(Transaction_Amount) End as Credit from Daily_Transaction where Transaction_Type='Credit' and Account_No='"+GL_Code+"' and Transaction_Date<=to_date('"+From_Date+"','dd/MM/yyyy') and Transaction_Date>=(Select OB_Date from GL_Opening_Balance where Account_Code='"+GL_Code+"' and OB_Date<=to_date('"+From_Date+"','dd/MM/yyyy'))) b,(Select case when sum(Transaction_Amount) is NULL Then 0 else sum(Transaction_Amount) End as Debit from Daily_Transaction where Transaction_Type='Debit' and Account_No='"+GL_Code+"' and Transaction_Date<=to_date('"+From_Date+"','dd/MM/yyyy') and Transaction_Date>=(Select OB_Date from GL_Opening_Balance where Account_Code='"+GL_Code+"' and OB_Date<=to_date('"+From_Date+"','dd/MM/yyyy'))) c",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException{  
			
			SimpleBranch gl=new SimpleBranch();
			
			gl.setS51(Math.abs(rs.getFloat(1))); // Opening Balance
		
			return gl;
		}
					 }     );
				}

	
	
	public String getGL_Code(int Bcode) {
		//--Set Connection----------------------------
		int j=RAndC;
		this.template=con.getCon2(j);
		//-----------------------------------------------------
		
		String f=null;
		String query = "Select GL_Code from cash_hub_detail where Bcode='"+Bcode+"'";
		PreparedStatement pstmt = null;
		try {
			pstmt = template.getDataSource().getConnection().prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet resultSet = null;
		try {
			resultSet = pstmt.executeQuery();
			resultSet.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			f=resultSet.getString(1);
			
			//i=resultSet.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			//System.out.println("AccNoFrom db="+i);
		return f;
	} 		


}
	