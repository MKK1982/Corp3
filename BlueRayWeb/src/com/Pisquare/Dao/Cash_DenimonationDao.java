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

import com.Pisquare.Beans.Admin_Master;
import com.Pisquare.Beans.Cus;
import com.Pisquare.Beans.Customer;
import com.Pisquare.Beans.GL_Master;
import com.Pisquare.Beans.JL_Master;
import com.Pisquare.Beans.Login;
import com.Pisquare.Beans.Branch_Master;
import com.Pisquare.Beans.Simple;
import com.Pisquare.Beans.SimpleBranch;
import com.Pisquare.Controllers.Configuration_Controller;


public class Cash_DenimonationDao {

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
	
	public void savePoorana_Cash(Admin_Master am,int CB,String user,int Bcode) throws SQLException
	{

		//--Set Connection----------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
		//-----------------------------------------------------
					System.out.println("dao cash---------------------------------");
		String TRANSACTION_DATE1  = null;
		int RS_20001 = 0;
		int RS_10001 = 0;
		int RS_5001 = 0;
		int RS_2001 = 0;
		int RS_1001 = 0;
		int RS_501 = 0;
		int RS_201 = 0;
		int RS_101 = 0;
		int RS_51 = 0;
		int ADJUSTMENTS1 = 0;
		int COINS1 = 0;
		int CASH_BALANCE1 = 0;
		String CREATED_BY1 = null;
		String CREATED_DATE1 = null;
		String MODIFIED_BY1 = null;
		String MODIFIED_DATE1 = null;
		
		
	    TRANSACTION_DATE1 = am.getFrom_Date();
	    RS_20001 = am.getTxt_2000_No();
		RS_10001 = am.getTxt_1000_No();
		RS_5001 = am.getTxt_500_No();
		RS_2001 = am.getTxt_200_No();
		RS_1001 = am.getTxt_100_No();
		RS_501 = am.getTxt_50_No();
		RS_201 = am.getTxt_20_No();
		RS_101 = am.getTxt_10_No();
		RS_51 = am.getTxt_5_No();
		ADJUSTMENTS1 = am.getTxt_Adj_No();
		COINS1 = am.getTxt_Coins_No();
		CASH_BALANCE1 = CB;
		CREATED_BY1 = user;
		CREATED_DATE1 = am.getFrom_Date();
		MODIFIED_BY1 = user;
		MODIFIED_DATE1 = am.getFrom_Date();
			
		try
		{
			CallableStatement stmt=template.getDataSource().getConnection().prepareCall("{call Save_Poorana_cash(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			System.out.println("inside---------------------------------");
			stmt.setString(1,TRANSACTION_DATE1);
			stmt.setInt(2,RS_20001);
			stmt.setInt(3,RS_10001);
			stmt.setInt(4,RS_5001);
			stmt.setInt(5,RS_2001);
			stmt.setInt(6,RS_1001);
			stmt.setInt(7,RS_501);
			stmt.setInt(8,RS_201);
			stmt.setInt(9,RS_101);
			stmt.setInt(10,RS_51);
			stmt.setInt(11,ADJUSTMENTS1);
			stmt.setInt(12,COINS1);
			stmt.setInt(13,CASH_BALANCE1);
			stmt.setString(14,CREATED_BY1);
			stmt.setString(15,CREATED_DATE1);
			stmt.setString(16,MODIFIED_BY1);
			stmt.setString(17,MODIFIED_DATE1);
			System.out.println("in---------------------------------");
		
			
			stmt.executeQuery();
			
		}
		
		catch(Exception e)
		{
			System.out.println("exceiption--------------"+e); 
		}	
	}
	


	

}
	