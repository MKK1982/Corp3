package com.Pisquare.Dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.List.*;

import org.apache.commons.lang3.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.context.request.RequestContextHolder;

import com.Pisquare.Beans.Change_Password;
import com.Pisquare.Beans.Cus;
import com.Pisquare.Beans.Customer;
import com.Pisquare.Beans.DC_Master;
import com.Pisquare.Beans.GL_Master;
import com.Pisquare.Beans.JL_Master;
import com.Pisquare.Beans.Login;
import com.Pisquare.Beans.Branch_Master;
import com.Pisquare.Beans.Simple;
import com.Pisquare.Beans.SimpleBranch;
import com.Pisquare.Beans.Staff_Master;
import com.Pisquare.Beans.UserDetails;
import com.Pisquare.Controllers.Configuration_Controller;


public class AK_EditDao {
	
	int Binfo=201;
	int RAndC=201;
	
	@Autowired
	private Configuration_Controller con;
JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template)
	{
		this.template=template;
		
	}
						
								
		//Staff Controller ----------------------------------------------------------------------------------------------
								
								public List<SimpleBranch> getDCDetailsList(){
									//--Set Connection----------------------------
											int j=201;
											this.template=con.getCon2(j);
											//-----------------------------------------------------
									return template.query("select * from HH order by id",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
									{  

										SimpleBranch gl=new SimpleBranch();
										//gl.setS1(rs.getInt(12));
										gl.setS2(rs.getString(1));//empid
										
										gl.setS3(rs.getString(2));//empname
										gl.setS4(rs.getString(7));//Designation
										gl.setS5(rs.getString(5));//Level
										gl.setS31(rs.getString(6));//Status
										gl.setS32(rs.getString(3));//Mobile No
										
										
																			
										return gl;
									}
									 }     );
								}
								
								
								
								
								//--------------------------------------------------------------------------------------
								
								public int geDCId_Count(String string) {
									//--Set Connection------------------------------------
									int j=Binfo;
									this.template=con.getCon2(j);
									//-----------------------------------------------------
									int i=0;
									String query = "select Count(*) from HH where ID="+string+"";
						                   System.out.println("Count="+query);
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
										//i=resultSet.getRow();
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
										
									return i;
								} 
								
								
								
								public int saveDC_Master(DC_Master p){  
									//--Set Connection------------------------------------
									int j=Binfo;
									this.template=con.getCon2(j);
							//-----------------------------------------------------
									//String Customer_Name=p.getCustomer_Name();
									//Customer_Name=WordUtils.capitalizeFully(Customer_Name,'.');
									 String sql="insert into HH values("+p.getEmpId()+",'"+p.getEmpName().toUpperCase()+"','"+p.getEmpMobile()+"','201','"+p.getEmpLevel()+"','A','"+p.getEmpDesignation()+"')";
								    
									  System.out.println("in Dao Saved Status= "+sql);
									  int k=template.update(sql);
								  System.out.println("in Dao Saved Status= "+k);
								    return k;  
								} 	
								
								public int updateDC_Master(DC_Master p){  
									//--Set Connection------------------------------------
									int j=Binfo;
									this.template=con.getCon2(j);
							//-----------------------------------------------------
								    String sql="update HH set EMPNAME='"+p.getEmpName().toUpperCase()+"', MOBILE='"+p.getEmpMobile()+"',LEVEL1='"+p.getEmpLevel()+"',STATUS='"+p.getEmpStatus()+"',DESIGNATION='"+p.getEmpDesignation()+"' where EMPID='"+p.getEmpId()+"'";  
								    return template.update(sql);  
								} 
								
								public int deleteDC_Master(String EMPID){  
									//--Set Connection------------------------------------
									int j=Binfo;
									this.template=con.getCon2(j);
							//------------------------------------------------------
								    String sql="delete from HH where ID="+EMPID+" and Status !='A'";  
									
								  
								    return template.update(sql);  
								}  
								
		//End  Staff Controller ----------------------------------------------------------------------------------------------
								
								
								//28-08-2020------------------------------
									public List<SimpleBranch> getFd_IntPaymentModeList(String date1){
										//--Set Connection----------------------------
												int j=Binfo;
												this.template=con.getCon2(j);
												//-----------------------------------------------------
										//select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' ) a order by Status,Branch;
												//new select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' union select '218' as Branch,'Thillai Nagar' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser18.calendar1 where Status='O' ) a order by Status,Branch
												//New with thanjavur  select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' union select '218' as Branch,'Thillai Nagar' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser18.calendar1 where Status='O' union select '219' as Branch,'Thanjavur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser19.calendar1 where Status='O' ) a order by Status,Branch
										return template.query("select * from FD_List_PaymentMode",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
										{  

											SimpleBranch gl=new SimpleBranch();
										
											
											
											
											gl.setS2(rs.getString(1));  //Branch
											gl.setS3(rs.getString(2));  //Int Payment
											gl.setS4(rs.getString(3));  //scode
											
											gl.setS31(rs.getString(4));//count
											gl.setS32(rs.getString(5));  //scheme name
											
											gl.setS33(rs.getString(6));//bname
								
											return gl;
										}
										 }     );
									}
									
									
									
									public String Get_MonthEnd(String Date1) {
										//--Set Connection------------------------------------
										int j=Binfo;
										this.template=con.getCon2(j);
									//-----------------------------------------------------
										// Chnaged query 28-01-2020
										
										/*String i=null;
										String query = "select to_char(last_day(to_date('"+Date1+"','dd/MM/yyyy')),'dd/MM/yyyy') from dual";

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
											i=resultSet.getString(1);
											
											//i=resultSet.getRow();
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
											
										return i;*/
										
										
										String i=null;
										PreparedStatement pstmt = null;
										try {
											pstmt = template.getDataSource().getConnection().prepareStatement("select to_char(last_day(to_date(?,'dd/MM/yyyy')),'dd/MM/yyyy') from dual");
											pstmt.setString(1, Date1);
											
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
											i=resultSet.getString(1);
											
											//i=resultSet.getRow();
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
											
										return i;
										
									} 
									
									//select c.Branch,(select Branch_Name from Branch_Master where to_char(Branch_code)=c.Branch),count(*), c.interest_Payment_Mode from (select a.*,b.to_date,b.interest from (select branch ,account_no, scheme_code,Account_Status, interest_payment_Mode from fd_Master_view where Account_Status='A')a left join (select Account_No,to_date,interest,status from fd_interest_view where status is null)b on a.account_no=b.Account_No where b.to_date<=to_date('31/08/2020','dd/MM/yyyy') and a.interest_payment_mode!='Reinvest' order by a.branch,a.SCheme_code,a.Account_No)c group by c.branch,c.interest_payment_mode order by c.branch,c.interest_payment_mode;
									//28-08-2020------------------------------
									public List<SimpleBranch> getFd_IntPaymentStandingCount(String Current){
										//--Set Connection----------------------------
												int j=Binfo;
												this.template=con.getCon2(j);
												//-----------------------------------------------------
										//select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' ) a order by Status,Branch;
												//new select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' union select '218' as Branch,'Thillai Nagar' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser18.calendar1 where Status='O' ) a order by Status,Branch
												//New with thanjavur  select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' union select '218' as Branch,'Thillai Nagar' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser18.calendar1 where Status='O' union select '219' as Branch,'Thanjavur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser19.calendar1 where Status='O' ) a order by Status,Branch
										
												String sql="select c.Branch,(select Branch_Name from Branch_Master where to_char(Branch_code)=c.Branch),count(*), c.interest_Payment_Mode from (select a.*,b.to_date,b.interest from (select branch ,account_no, scheme_code,Account_Status, interest_payment_Mode from fd_Master_view where Account_Status='A')a left join (select Account_No,to_date,interest,status from fd_interest_view where status is null)b on a.account_no=b.Account_No where b.to_date<=to_date('"+Current+"','dd/MM/yyyy') and a.interest_payment_mode!='Reinvest' order by a.branch,a.SCheme_code,a.Account_No)c where c.interest_payment_mode='Standing Instruction' group by c.branch,c.interest_payment_mode order by c.branch,c.interest_payment_mode";
												
												System.out.println(sql);
												System.out.println(Current);
												
												return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
										{  

											SimpleBranch gl=new SimpleBranch();
										
											
											
											
											gl.setS2(rs.getString(1));  //Branch
											gl.setS31(rs.getString(3));//count
											gl.setS33(rs.getString(2));//bname
								
											return gl;
										}
										 }     );
									}
									


									
									//28-08-2020------------------------------
									public List<SimpleBranch> getEOM_ListCurrent(String Current){
										//--Set Connection----------------------------
												int j=Binfo;
												this.template=con.getCon2(j);
												//-----------------------------------------------------
										//select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' ) a order by Status,Branch;
												//new select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' union select '218' as Branch,'Thillai Nagar' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser18.calendar1 where Status='O' ) a order by Status,Branch
												//New with thanjavur  select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' union select '218' as Branch,'Thillai Nagar' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser18.calendar1 where Status='O' union select '219' as Branch,'Thanjavur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser19.calendar1 where Status='O' ) a order by Status,Branch
										
												String sql="select branch,(select branch_name from branch_master where to_char(branch_code)=branch) as bname,Account_No,(select gl_name from gl_master where to_char(gl_code)=Account_No and rownum=1),to_char(Transaction_date,'dd/MM/yyyy'),TRANSACTION_PARTICULARS, Transaction_Amount from daily_transaction_table where transaction_date=to_date('"+Current+"','dd/MM/yyyy') and page_source='EOM' and Transaction_type='Credit'";
												
												System.out.println(sql);
												System.out.println(Current);
												
												return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
										{  

											SimpleBranch gl=new SimpleBranch();
										
											
											
											
											gl.setS2(rs.getString(2));  //Branch
											gl.setS31(rs.getString(5));//count
											gl.setS33(rs.getString(6));//bname
											gl.setS34(rs.getString(7));//count
											
											return gl;
										}
										 }     );
									}
									

									 public List<SimpleBranch> getRD_CharMonthly(String Month, int Bcode){

											//--Set Connection------------------------------------
														int j=Bcode;
														this.template=con.getCon2(j);
											//-----------------------------------------------------
											return template.query(" SELECT EXTRACT(month FROM open_date) as month, sum(deposit_amount) as TotalAmount from rd_master where EXTRACT(year FROM open_date) = '"+Month+"' group by EXTRACT(month FROM open_date) order by EXTRACT(month FROM open_date)",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
											{  

												SimpleBranch gl=new SimpleBranch();
												gl.setS1(rs.getInt(1));   //Month
												gl.setS14(rs.getFloat(2));   //Dep Amt
												
												
												
																
												return gl;
											}
											 }     );
										}	
									

						public List<SimpleBranch> getMonthly_Growth(String Scheme,String From_Date,String To_date, int Bcode){

							//--Set Connection------------------------------------
										int j=Bcode;
										this.template=con.getCon2(j);
							//-----------------------------------------------------
							String query="select distinct(extract( month from CALENDAR_DATE) -1) as month,to_char(last_day(add_months(CALENDAR_DATE,-1)),'dd/MM/yyyy'),abs(get_gl_cb2('"+Scheme+"',to_char(last_day(add_months(CALENDAR_DATE,-1)),'dd/MM/yyyy'))) from calendar1 where calendar_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_date+"','dd/MM/yyyy') order by month";
								System.out.println(query);		
										return template.query(query,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
							{  

								SimpleBranch gl=new SimpleBranch();
								gl.setS1(rs.getInt(1));   //Month
								gl.setS14(rs.getFloat(3));   //Dep Amt
								
								
								
												
								return gl;
							}
							 }     );
						}	






						public List<SimpleBranch> getFullSchemeList( int Bcode){

								//--Set Connection------------------------------------
											int j=Bcode;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
								return template.query("Select SCHEME_CODE,SCHEME_NAME from Scheme_Master",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
								{  

									SimpleBranch gl=new SimpleBranch();
									gl.setS2(rs.getString(1));   //SCHEME_CODE
									gl.setS3(rs.getString(2));   //SCHEME_NAME
									
									
									
													
									return gl;
								}
								 }     );
							}


						public String getScheme_Category(String Scheme_Code,int DBCode) {
	     					//--Set Connection------------------------------------
	     					int j=DBCode;
	     					this.template=con.getCon2(j);
	     					//-----------------------------------------------------
	     					String i=null;
	     					String query = "select SCHEME_CATEGORY from Scheme_Master where SCHEME_CODE='"+Scheme_Code+"'";

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
	     						} catch (SQLException e) {
	     						// TODO Auto-generated catch block
	     						e.printStackTrace();
	     					}
	     					
	     					try {
	     						if (resultSet!= null) {
	     							  while (resultSet.next()) {
	     								  i=resultSet.getString(1);
	     							  }
	     						}
	     						//i=resultSet.getRow();
	     					} catch (SQLException e) {
	     						// TODO Auto-generated catch block
	     						e.printStackTrace();
	     					}
	     						
	     					return i;
	     				} 
						public String getGL_General(String Scheme_Code,int DBCode) {
	     					//--Set Connection------------------------------------
	     					int j=DBCode;
	     					this.template=con.getCon2(j);
	     					//-----------------------------------------------------
	     					String i=null;
	     					String query = "Select GL_GENERAL from Scheme_Master where SCHEME_CODE="+Scheme_Code+"";

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
	     						} catch (SQLException e) {
	     						// TODO Auto-generated catch block
	     						e.printStackTrace();
	     					}
	     					
	     					try {
	     						if (resultSet!= null) {
	     							  while (resultSet.next()) {
	     								  i=resultSet.getString(1);
	     							  }
	     						}
	     						//i=resultSet.getRow();
	     					} catch (SQLException e) {
	     						// TODO Auto-generated catch block
	     						e.printStackTrace();
	     					}
	     						
	     					return i;
	     				} 
	     				
	     				
	     				
	     				
	     				
	     				
	     				
	     				public String getScheme_Code_UsingGL_General(String Mode,int DBCode) {
	     					//--Set Connection------------------------------------
	     					int j=DBCode;
	     					this.template=con.getCon2(j);
	     					//-----------------------------------------------------
	     					String i=null;
	     					String query = "Select Scheme_Code from Scheme_Master where GL_General='"+Mode+"'";

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
	     						} catch (SQLException e) {
	     						// TODO Auto-generated catch block
	     						e.printStackTrace();
	     					}
	     					
	     					try {
	     						if (resultSet!= null) {
	     							  while (resultSet.next()) {
	     								  i=resultSet.getString(1);
	     							  }
	     						}
	     						//i=resultSet.getRow();
	     					} catch (SQLException e) {
	     						// TODO Auto-generated catch block
	     						e.printStackTrace();
	     					}
	     						
	     					return i;
	     				} 
	     				
	     				public List<SimpleBranch> getMonthly_Growth2(String Scheme,int year, int Bcode){

							//--Set Connection------------------------------------
										int j=Bcode;
										this.template=con.getCon2(j);
							//-----------------------------------------------------
										String query="select id as month,to_date,abs(Get_GL_CB2('"+Scheme+"',to_char(calendar_month.to_date,'dd/MM/yyyy'))) as cb from calendar_month where year="+year+" order by to_date,month";
								System.out.println(query);		
										return template.query(query,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
							{  

								SimpleBranch gl=new SimpleBranch();
								gl.setS1(rs.getInt(1));   //Month
								gl.setS14(rs.getFloat(3));   //Dep Amt
								
								
								
												
								return gl;
							}
							 }     );
						}	


	     				public List<SimpleBranch> getFD_Chart_Scheme(String From_Date,String To_Date, int Bcode){

							//--Set Connection------------------------------------
										int j=Binfo;
										this.template=con.getCon2(j);
							//-----------------------------------------------------
							return template.query("select a.*,(select scheme_name from scheme_Master where scheme_code=a.scheme_code)as scname from (select Scheme_code,sum(deposit_amount)as depAmt from fd_master_view where scheme_code in ('30010','30011','30042','30043','30045','30046') and open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') group by scheme_code)a",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
							{  

								SimpleBranch gl=new SimpleBranch();
								gl.setS31(rs.getString(1));   //SCHEME_CODE
								gl.setS32(rs.getString(3));   //SCHEME_NAME
								gl.setS141(rs.getDouble(2));   //DepAmt
								
								
								
												
								return gl;
							}
							 }     );
						}
	     				
	     				public List<SimpleBranch> getCD_Chart_Scheme(String From_Date,String To_Date, int Bcode){

							//--Set Connection------------------------------------
										int j=Binfo;
										this.template=con.getCon2(j);
							//-----------------------------------------------------
							return template.query("select a.*,(select scheme_name from scheme_Master where scheme_code=a.scheme_code)as scname from (select Scheme_code,sum(deposit_amount)as depAmt from fd_master_view where scheme_code in ('30020','30021','30030','30040','30041','30044','30045') and open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') group by scheme_code)a",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
							{  

								SimpleBranch gl=new SimpleBranch();
								gl.setS31(rs.getString(1));   //SCHEME_CODE
								gl.setS32(rs.getString(3));   //SCHEME_NAME
								gl.setS141(rs.getDouble(2));   //DepAmt
								
								
								
												
								return gl;
							}
							 }     );
						}
	     				
	     				
	     				
	     				public List<SimpleBranch> getFD_Chart_Branch(String From_Date,String To_Date, int Bcode){

							//--Set Connection------------------------------------
										int j=Binfo;
										this.template=con.getCon2(j);
							//-----------------------------------------------------
										String sql="select a.*,(select scheme_name from scheme_Master where scheme_code=a.scheme_code)as scname,(select branch_name from branch_master where to_char(branch_code)=a.branch)as bname from (select Scheme_code,sum(deposit_amount)as depAmt,count(*),branch from fd_master_view where scheme_code in ('30010','30011','30042','30043','30045','30046') and open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') group by scheme_code,branch)a order by branch";										
							return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
							{  

								SimpleBranch gl=new SimpleBranch();
								gl.setS31(rs.getString(1));   //SCHEME_CODE
								gl.setS32(rs.getString(5));   //SCHEME_NAME
								gl.setS141(rs.getDouble(2));   //DepAmt
								
								gl.setS33(rs.getString(3));   //cou nt
								gl.setS34(rs.getString(6));   //bNAME
								
								
								
								
												
								return gl;
							}
							 }     );
						}
	     				
	     				
	     				//27-04-2021------------------------------
						public List<SimpleBranch> getCd_IntPaymentModeList(String date1){
							//--Set Connection----------------------------
									int j=Binfo;
									this.template=con.getCon2(j);
									//-----------------------------------------------------
							//select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' ) a order by Status,Branch;
									//new select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' union select '218' as Branch,'Thillai Nagar' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser18.calendar1 where Status='O' ) a order by Status,Branch
									//New with thanjavur  select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' union select '218' as Branch,'Thillai Nagar' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser18.calendar1 where Status='O' union select '219' as Branch,'Thanjavur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser19.calendar1 where Status='O' ) a order by Status,Branch
							return template.query("select * from CD_List_PaymentMode",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
							{  

								SimpleBranch gl=new SimpleBranch();
							
								
								
								
								gl.setS2(rs.getString(1));  //Branch
								gl.setS3(rs.getString(2));  //Int Payment
								gl.setS4(rs.getString(3));  //scode
								
								gl.setS31(rs.getString(4));//count
								gl.setS32(rs.getString(5));  //scheme name
								
								gl.setS33(rs.getString(6));//bname
					
								return gl;
							}
							 }     );
						}
						

	     				
						
						 //07-05-2022
						 public List<SimpleBranch> getTargetReport_Branchwise_Monthly_all(String FromDate,String ToDate,int Month,int Year)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											//07-05-2022
											//String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount,nvl(b.achieved,0) as acheived,a.target_amount-nvl(b.achieved,0) as targerbalance,to_char(nvl(round((b.achieved*100/a.target_Amount),2),0.00) ||'%') as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('"+FromDate+"','dd/mm/yyyy'),'MON-yyyy'),'0') AS month1 from (select branch ,month , year,amount as target_amount,SUBSTR('0'||month,-2,2) as month1 from target_master where month="+Month+" and year="+Year+")a  left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved from fd_master_view where Account_Status='A' and open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch";
					
											//21-05-2022 //scheme name //fd renewal
											String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount,nvl(b.achieved,0) as acheived,case when (a.target_amount-nvl(b.achieved,0))>0 then (a.target_amount-nvl(b.achieved,0)) else 0 end as targerbalance,to_char(nvl(round((b.achieved*100/a.target_Amount),2),0.00)) as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('"+FromDate+"','dd/mm/yyyy'),'MON-yyyy'),'0') AS month1 from (select branch ,month , year,amount as target_amount,SUBSTR('0'||month,-2,2) as month1 from target_master where month="+Month+" and year="+Year+" and scheme_name='FD')a  left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved from fd_master_view where Account_Status='A' and open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') and Renewal_no is null group by branch)b on a.branch=b.livebranch  order by a.branch";

											System.out.println(sql);


								return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
									
									SimpleBranch gl=new SimpleBranch();
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(3));  //targetAmt
									gl.setS142(rs.getDouble(4));  //Acheived
									gl.setS13(rs.getFloat(5));  //balance
									
									gl.setS32(rs.getString(6));  //percentage
									gl.setS33(rs.getString(7));  //month
								
									
							
									
									
									return gl;
								}
											 }     );
										}

						 
						 //07-05-2022
						 public List<SimpleBranch> getTargetReport_Branchwise_Quarterly_all(String FromDate,String Date2,String Date3,String Date4,String Date5,String ToDate,String PeriodMonth,int year1)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											//07-05-2022
											//String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount,nvl(b.achieved_m1,0) as acheived_m1,nvl(b2.achieved_m2,0) as acheived_m2,nvl(b3.achieved_m3,0) as acheived_m3,a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0) as targerbalance,to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00) ||'%') as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('"+FromDate+"','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year=2022 group by branch)a left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m1 from fd_master_view where Account_Status='A' and open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m2 from fd_master_view where Account_Status='A' and open_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m3 from fd_master_view where Account_Status='A' and open_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch";System.out.println(sql);
											//09-05-2022
											//String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,(a.target_amount/3)-nvl(b.achieved_m1,0) as bal1,to_char(round((b.achieved_m1)*100/(a.target_amount/3),2)||' %') as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,(a.target_amount/3)-nvl(b2.achieved_m2,0) as bal2,to_char(round((b2.achieved_m2)*100/(a.target_amount/3),2)||' %') as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,(a.target_amount/3)-nvl(b3.achieved_m3,0) as bal3,to_char(round((b3.achieved_m3)*100/(a.target_amount/3),2)||' %') as acheived_per3,a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0) as targerbalance,to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00) ||'%') as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" group by branch)a left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m1 from fd_master_view where Account_Status='A' and open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m2 from fd_master_view where Account_Status='A' and open_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m3 from fd_master_view where Account_Status='A' and open_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch order by a.branch";
											//21-05-2022 //all  // and Renewal_no is null
											//String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,case when ((a.target_amount/3)-nvl(b.achieved_m1,0)) > 0 then ((a.target_amount/3)-nvl(b.achieved_m1,0)) else 0 end as bal1,to_char(round((b.achieved_m1)*100/(a.target_amount/3),2)||' %') as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,case when ((a.target_amount/3)-nvl(b2.achieved_m2,0))>0 then ((a.target_amount/3)-nvl(b2.achieved_m2,0)) else 0 end as bal2,to_char(round((b2.achieved_m2)*100/(a.target_amount/3),2)||' %') as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,case when ((a.target_amount/3)-nvl(b3.achieved_m3,0))>0 then ((a.target_amount/3)-nvl(b3.achieved_m3,0)) else 0 end as bal3,to_char(round((b3.achieved_m3)*100/(a.target_amount/3),2)||' %') as acheived_per3,case when (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))>0 then (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)) else 0 end as targerbalance,to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00) ||'%') as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" group by branch)a left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m1 from fd_master_view where Account_Status='A' and open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy') and Renewal_no is null group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m2 from fd_master_view where Account_Status='A' and open_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy') and Renewal_no is null group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m3 from fd_master_view where Account_Status='A' and open_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') and Renewal_no is null group by branch)b3 on a.branch=b3.livebranch order by a.branch";

											//07-06-2022 achieved %
											//String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,case when ((a.target_amount/3)-nvl(b.achieved_m1,0)) > 0 then ((a.target_amount/3)-nvl(b.achieved_m1,0)) else 0 end as bal1,to_char(nvl(round((b.achieved_m1)*100/(a.target_amount/3),2),0)) as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,case when ((a.target_amount/3)-nvl(b2.achieved_m2,0))>0 then ((a.target_amount/3)-nvl(b2.achieved_m2,0)) else 0 end as bal2,to_char(nvl(round((b2.achieved_m2)*100/(a.target_amount/3),2),0)) as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,case when ((a.target_amount/3)-nvl(b3.achieved_m3,0))>0 then ((a.target_amount/3)-nvl(b3.achieved_m3,0)) else 0 end as bal3,to_char(nvl(round((b3.achieved_m3)*100/(a.target_amount/3),2),0)) as acheived_per3,case when (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))>0 then (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)) else 0 end as targerbalance,to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00)) as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" group by branch)a left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m1 from fd_master_view where Account_Status='A' and open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy') and Renewal_no is null group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m2 from fd_master_view where Account_Status='A' and open_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy') and Renewal_no is null group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m3 from fd_master_view where Account_Status='A' and open_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') and Renewal_no is null group by branch)b3 on a.branch=b3.livebranch order by a.branch";
											//03-05-2024 case when main_qry.targetachieved <> 0 and main_qry.yearlydeposits <> 0 then
											String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,case when ((a.target_amount/3)-nvl(b.achieved_m1,0)) > 0 then ((a.target_amount/3)-nvl(b.achieved_m1,0)) else 0 end as bal1,case when b.achieved_m1 <> 0 and a.target_amount <> 0 then to_char(nvl(round((b.achieved_m1)*100/(a.target_amount/3),2),0)) else '0.0' end as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,case when ((a.target_amount/3)-nvl(b2.achieved_m2,0))>0 then ((a.target_amount/3)-nvl(b2.achieved_m2,0)) else 0 end as bal2, case when b2.achieved_m2 <> 0 and a.target_amount <> 0 then to_char(nvl(round((b2.achieved_m2)*100/(a.target_amount/3),2),0)) else '0.0' end as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,case when ((a.target_amount/3)-nvl(b3.achieved_m3,0))>0 then ((a.target_amount/3)-nvl(b3.achieved_m3,0)) else 0 end as bal3,case when b3.achieved_m3 <> 0 and a.target_amount <> 0 then to_char(nvl(round((b3.achieved_m3)*100/(a.target_amount/3),2),0)) else '0.0' end as acheived_per3,case when (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))>0 then (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)) else 0 end as targerbalance,case when (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)) <> 0 then to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00)) else '0.0' end as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" group by branch)a left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m1 from fd_master_view where Account_Status='A' and open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy') and Renewal_no is null group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m2 from fd_master_view where Account_Status='A' and open_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy') and Renewal_no is null group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m3 from fd_master_view where Account_Status='A' and open_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') and Renewal_no is null group by branch)b3 on a.branch=b3.livebranch order by a.branch";
System.out.println(sql);
								return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
									
									SimpleBranch gl=new SimpleBranch();
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(3));  //targetAmt
									gl.setS142(rs.getDouble(4));  //Acheived1
									gl.setS143(rs.getDouble(5));  //bal1
									
									gl.setS144(rs.getDouble(7));  //Acheived2
									gl.setS145(rs.getDouble(8));  //bal2
									gl.setS146(rs.getDouble(10));  //Acheived3
									gl.setS147(rs.getDouble(11));  //bal3
									
									gl.setS32(rs.getString(6));  //m1 %
									gl.setS33(rs.getString(9));  //m2 %
									gl.setS34(rs.getString(12));  //m3 %
								
									
							
									
									
									return gl;
								}
											 }     );
										}

						 
						 //10-05-2022
						 public List<SimpleBranch> getTargetReport_Branchwise_Consolidated_all(String FromDate,String Date1,String Date2,String Date3,String Date4,String Date5,String Date6,String ToDate,int year1)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											//10-05-2022
											//String sql="select main_qry.*,to_char(nvl(round((main_qry.targetachieved*100/main_qry.yearlydeposits),2),0)|| ' %') as Achcheived_Percent from (select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0)) as yearlyDeposits,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetAchieved,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetnotAchieved,nvl(b.achieved_m1,0) as Q1_Acheived,nvl(b2.achieved_m2,0)as  Q2_Acheived,nvl(b3.achieved_m3,0) as Q3_Acheived,nvl(b4.achieved_m4,0) Q4_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4,5,6) and year="+year1+" group by branch)a left join (select branch ,sum(amount) as target_amount2 from target_master where month in (7,8,9) and year="+year1+" group by branch)a2 on a.branch=a2.branch left join (select branch ,sum(amount) as target_amount3 from target_master where month in (10,11,12) and year="+year1+" group by branch)a3 on a.branch=a3.branch left join (select branch ,sum(amount) as target_amount4 from target_master where month in (1,2,3) and year="+(year1+1)+" group by branch)a4 on a.branch=a4.branch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m1 from fd_master_view where Account_Status='A' and open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date1+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m2 from fd_master_view where Account_Status='A' and open_date between to_date('"+Date2+"','dd/MM/yyyy') and to_date('"+Date3+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m3 from fd_master_view where Account_Status='A' and open_date between to_date('"+Date4+"','dd/MM/yyyy') and to_date('"+Date5+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m4 from fd_master_view where Account_Status='A' and open_date between to_date('"+Date6+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b4 on a.branch=b4.livebranch)main_qry order by main_qry.branch";
											
											//21-05-2022 //all  // and Renewal_no is null
											//String sql="select main_qry.*,to_char(nvl(round((main_qry.targetachieved*100/main_qry.yearlydeposits),2),0)|| ' %') as Achcheived_Percent from (select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0)) as yearlyDeposits,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetAchieved,case when (nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)) > 0 then (nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)) else 0 end as targetnotAchieved,nvl(b.achieved_m1,0) as Q1_Acheived,nvl(b2.achieved_m2,0)as  Q2_Acheived,nvl(b3.achieved_m3,0) as Q3_Acheived,nvl(b4.achieved_m4,0) Q4_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4,5,6) and year="+year1+" group by branch)a left join (select branch ,sum(amount) as target_amount2 from target_master where month in (7,8,9) and year="+year1+" group by branch)a2 on a.branch=a2.branch left join (select branch ,sum(amount) as target_amount3 from target_master where month in (10,11,12) and year="+year1+" group by branch)a3 on a.branch=a3.branch left join (select branch ,sum(amount) as target_amount4 from target_master where month in (1,2,3) and year="+(year1+1)+" group by branch)a4 on a.branch=a4.branch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m1 from fd_master_view where Account_Status='A' and open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date1+"','dd/MM/yyyy')and Renewal_no is null group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m2 from fd_master_view where Account_Status='A' and open_date between to_date('"+Date2+"','dd/MM/yyyy') and to_date('"+Date3+"','dd/MM/yyyy') and Renewal_no is null group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m3 from fd_master_view where Account_Status='A' and open_date between to_date('"+Date4+"','dd/MM/yyyy') and to_date('"+Date5+"','dd/MM/yyyy') and Renewal_no is null group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m4 from fd_master_view where Account_Status='A' and open_date between to_date('"+Date6+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') and Renewal_no is null group by branch)b4 on a.branch=b4.livebranch)main_qry order by main_qry.branch";

											//30-04-2024 divisor is equal to zero
											String sql="select main_qry.*,case when main_qry.targetachieved <> 0 and main_qry.yearlydeposits <> 0 then ( to_char(nvl(round((main_qry.targetachieved*100/main_qry.yearlydeposits),2),0))) else '0.0' end  as Achcheived_Percent from (select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0)) as yearlyDeposits,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetAchieved,case when (nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)) > 0 then (nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)) else 0 end as targetnotAchieved,nvl(b.achieved_m1,0) as Q1_Acheived,nvl(b2.achieved_m2,0)as  Q2_Acheived,nvl(b3.achieved_m3,0) as Q3_Acheived,nvl(b4.achieved_m4,0) Q4_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4,5,6) and year="+year1+" group by branch)a left join (select branch ,sum(amount) as target_amount2 from target_master where month in (7,8,9) and year="+year1+" group by branch)a2 on a.branch=a2.branch left join (select branch ,sum(amount) as target_amount3 from target_master where month in (10,11,12) and year="+year1+" group by branch)a3 on a.branch=a3.branch left join (select branch ,sum(amount) as target_amount4 from target_master where month in (1,2,3) and year="+(year1+1)+" group by branch)a4 on a.branch=a4.branch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m1 from fd_master_view where Account_Status='A' and open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date1+"','dd/MM/yyyy')and Renewal_no is null group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m2 from fd_master_view where Account_Status='A' and open_date between to_date('"+Date2+"','dd/MM/yyyy') and to_date('"+Date3+"','dd/MM/yyyy') and Renewal_no is null group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m3 from fd_master_view where Account_Status='A' and open_date between to_date('"+Date4+"','dd/MM/yyyy') and to_date('"+Date5+"','dd/MM/yyyy') and Renewal_no is null group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m4 from fd_master_view where Account_Status='A' and open_date between to_date('"+Date6+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') and Renewal_no is null group by branch)b4 on a.branch=b4.livebranch)main_qry order by main_qry.branch";


								return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
									
									SimpleBranch gl=new SimpleBranch();
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(3));  //targetAmt
									gl.setS142(rs.getDouble(4));  //targetAcheived
									gl.setS143(rs.getDouble(5));  //targetNotAcheived
									
									gl.setS144(rs.getDouble(6));  //q1
									gl.setS145(rs.getDouble(7));  //q2
									gl.setS146(rs.getDouble(8));  //q3
									gl.setS147(rs.getDouble(9));  //q4
									gl.setS32(rs.getString(10));  //percent %
									
									
							
									
									
									return gl;
								}
											 }     );
										}


						 //12-05-2022
						 //10-05-2022
						 public List<SimpleBranch> getTargetReport_Branchwise_Yearly(int year1,int year2)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											//12-05-2022
	//										String sql="select main_qry.* from (select a.branch,(select branch_name from branch_master where branch_code=branch)as Bname,(nvl(a.target_amount1,0))*12 as Target_Amount,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)+nvl(b5.achieved_m5,0)+nvl(b6.achieved_m6,0)+nvl(b7.achieved_m7,0)+nvl(b8.achieved_m8,0)+nvl(b9.achieved_m9,0)+nvl(b10.achieved_m10,0)+nvl(b11.achieved_m11,0)+nvl(b12.achieved_m12,0))as targetAchieved,nvl(b.achieved_m1,0) as m1_Acheived,nvl(b2.achieved_m2,0)as  m2_Acheived,nvl(b3.achieved_m3,0) as m3_Acheived,nvl(b4.achieved_m4,0) m4_Acheived,nvl(b5.achieved_m5,0) as m5_Acheived,nvl(b6.achieved_m6,0)as  m6_Acheived,nvl(b7.achieved_m7,0) as m7_Acheived,nvl(b8.achieved_m8,0) m8_Acheived,nvl(b9.achieved_m9,0) as m9_Acheived,nvl(b10.achieved_m10,0)as  m10_Acheived,nvl(b11.achieved_m11,0) as m11_Acheived,nvl(b12.achieved_m12,0) m12_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4) and year="+year1+" group by branch)a left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m1 from fd_master_view where Account_Status='A' and open_date between to_date('01/04/"+year1+"','dd/MM/yyyy') and to_date('30/04/"+year1+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m2 from fd_master_view where Account_Status='A' and open_date between to_date('01/05/"+year1+"','dd/MM/yyyy') and to_date('31/05/"+year1+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m3 from fd_master_view where Account_Status='A' and open_date between to_date('01/06/"+year1+"','dd/MM/yyyy') and to_date('30/06/"+year1+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m4 from fd_master_view where Account_Status='A' and open_date between to_date('01/07/"+year1+"','dd/MM/yyyy') and to_date('31/07/"+year1+"','dd/MM/yyyy') group by branch)b4 on a.branch=b4.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m5 from fd_master_view where Account_Status='A' and open_date between to_date('01/08/"+year1+"','dd/MM/yyyy') and to_date('31/08/"+year1+"','dd/MM/yyyy') group by branch)b5 on a.branch=b5.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m6 from fd_master_view where Account_Status='A' and open_date between to_date('01/09/"+year1+"','dd/MM/yyyy') and to_date('30/09/"+year1+"','dd/MM/yyyy') group by branch)b6 on a.branch=b6.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m7 from fd_master_view where Account_Status='A' and open_date between to_date('01/10/"+year1+"','dd/MM/yyyy') and to_date('31/10/"+year1+"','dd/MM/yyyy') group by branch)b7 on a.branch=b7.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m8 from fd_master_view where Account_Status='A' and open_date between to_date('01/11/"+year1+"','dd/MM/yyyy') and to_date('30/11/"+year1+"','dd/MM/yyyy') group by branch)b8 on a.branch=b8.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m9 from fd_master_view where Account_Status='A' and open_date between to_date('01/12/"+year1+"','dd/MM/yyyy') and to_date('31/12/"+year1+"','dd/MM/yyyy') group by branch)b9 on a.branch=b9.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m10 from fd_master_view where Account_Status='A' and open_date between to_date('01/01/"+year2+"','dd/MM/yyyy') and to_date('31/01/"+year2+"','dd/MM/yyyy') group by branch)b10 on a.branch=b10.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m11 from fd_master_view where Account_Status='A' and open_date between to_date('01/02/"+year2+"','dd/MM/yyyy') and to_date('28/02/"+year2+"','dd/MM/yyyy') group by branch)b11 on a.branch=b11.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m12 from fd_master_view where Account_Status='A' and open_date between to_date('01/03/"+year2+"','dd/MM/yyyy') and to_date('31/03/"+year2+"','dd/MM/yyyy') group by branch)b12 on a.branch=b12.livebranch)main_qry order by main_qry.branch";

											//18-05-2022
	//										String sql="select k.*,case when (k.Target_Amount-k.targetAchieved)>0 then (k.Target_Amount-k.targetAchieved) else 0 end as balance,to_char (round(nvl((k.targetAchieved*100)/k.Target_Amount,0),2) || ' %') as percen1 from (select main_qry.* from (select a.branch,(select branch_name from branch_master where branch_code=branch)as Bname,(nvl(a.target_amount1,0))*12 as Target_Amount,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)+nvl(b5.achieved_m5,0)+nvl(b6.achieved_m6,0)+nvl(b7.achieved_m7,0)+nvl(b8.achieved_m8,0)+nvl(b9.achieved_m9,0)+nvl(b10.achieved_m10,0)+nvl(b11.achieved_m11,0)+nvl(b12.achieved_m12,0))as targetAchieved,nvl(b.achieved_m1,0) as m1_Acheived,nvl(b2.achieved_m2,0)as  m2_Acheived,nvl(b3.achieved_m3,0) as m3_Acheived,nvl(b4.achieved_m4,0) m4_Acheived,nvl(b5.achieved_m5,0) as m5_Acheived,nvl(b6.achieved_m6,0)as  m6_Acheived,nvl(b7.achieved_m7,0) as m7_Acheived,nvl(b8.achieved_m8,0) m8_Acheived,nvl(b9.achieved_m9,0) as m9_Acheived,nvl(b10.achieved_m10,0)as  m10_Acheived,nvl(b11.achieved_m11,0) as m11_Acheived,nvl(b12.achieved_m12,0) m12_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4) and year="+year1+" group by branch)a left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m1 from fd_master_view where Account_Status='A' and open_date between to_date('01/04/"+year1+"','dd/MM/yyyy') and to_date('30/04/"+year1+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m2 from fd_master_view where Account_Status='A' and open_date between to_date('01/05/"+year1+"','dd/MM/yyyy') and to_date('31/05/"+year1+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m3 from fd_master_view where Account_Status='A' and open_date between to_date('01/06/"+year1+"','dd/MM/yyyy') and to_date('30/06/"+year1+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m4 from fd_master_view where Account_Status='A' and open_date between to_date('01/07/"+year1+"','dd/MM/yyyy') and to_date('31/07/"+year1+"','dd/MM/yyyy') group by branch)b4 on a.branch=b4.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m5 from fd_master_view where Account_Status='A' and open_date between to_date('01/08/"+year1+"','dd/MM/yyyy') and to_date('31/08/"+year1+"','dd/MM/yyyy') group by branch)b5 on a.branch=b5.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m6 from fd_master_view where Account_Status='A' and open_date between to_date('01/09/"+year1+"','dd/MM/yyyy') and to_date('30/09/"+year1+"','dd/MM/yyyy') group by branch)b6 on a.branch=b6.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m7 from fd_master_view where Account_Status='A' and open_date between to_date('01/10/"+year1+"','dd/MM/yyyy') and to_date('31/10/"+year1+"','dd/MM/yyyy') group by branch)b7 on a.branch=b7.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m8 from fd_master_view where Account_Status='A' and open_date between to_date('01/11/"+year1+"','dd/MM/yyyy') and to_date('30/11/"+year1+"','dd/MM/yyyy') group by branch)b8 on a.branch=b8.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m9 from fd_master_view where Account_Status='A' and open_date between to_date('01/12/"+year1+"','dd/MM/yyyy') and to_date('31/12/"+year1+"','dd/MM/yyyy') group by branch)b9 on a.branch=b9.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m10 from fd_master_view where Account_Status='A' and open_date between to_date('01/01/"+year2+"','dd/MM/yyyy') and to_date('31/01/"+year2+"','dd/MM/yyyy') group by branch)b10 on a.branch=b10.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m11 from fd_master_view where Account_Status='A' and open_date between to_date('01/02/"+year2+"','dd/MM/yyyy') and to_date('28/02/"+year2+"','dd/MM/yyyy') group by branch)b11 on a.branch=b11.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m12 from fd_master_view where Account_Status='A' and open_date between to_date('01/03/"+year2+"','dd/MM/yyyy') and to_date('31/03/"+year2+"','dd/MM/yyyy') group by branch)b12 on a.branch=b12.livebranch)main_qry order by main_qry.branch)k";

											//21-05-2022 //all  // and Renewal_no is null
	//										String sql="select k.*,case when (k.Target_Amount-k.targetAchieved)>0 then (k.Target_Amount-k.targetAchieved) else 0 end as balance,to_char (round(nvl((k.targetAchieved*100)/k.Target_Amount,0),2) || ' %') as percen1 from (select main_qry.* from (select a.branch,(select branch_name from branch_master where branch_code=branch)as Bname,(nvl(a.target_amount1,0))*12 as Target_Amount,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)+nvl(b5.achieved_m5,0)+nvl(b6.achieved_m6,0)+nvl(b7.achieved_m7,0)+nvl(b8.achieved_m8,0)+nvl(b9.achieved_m9,0)+nvl(b10.achieved_m10,0)+nvl(b11.achieved_m11,0)+nvl(b12.achieved_m12,0))as targetAchieved,nvl(b.achieved_m1,0) as m1_Acheived,nvl(b2.achieved_m2,0)as  m2_Acheived,nvl(b3.achieved_m3,0) as m3_Acheived,nvl(b4.achieved_m4,0) m4_Acheived,nvl(b5.achieved_m5,0) as m5_Acheived,nvl(b6.achieved_m6,0)as  m6_Acheived,nvl(b7.achieved_m7,0) as m7_Acheived,nvl(b8.achieved_m8,0) m8_Acheived,nvl(b9.achieved_m9,0) as m9_Acheived,nvl(b10.achieved_m10,0)as  m10_Acheived,nvl(b11.achieved_m11,0) as m11_Acheived,nvl(b12.achieved_m12,0) m12_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4) and year="+year1+" group by branch)a left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m1 from fd_master_view where Account_Status='A' and open_date between to_date('01/04/"+year1+"','dd/MM/yyyy') and to_date('30/04/"+year1+"','dd/MM/yyyy')  and Renewal_no is null group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m2 from fd_master_view where Account_Status='A' and open_date between to_date('01/05/"+year1+"','dd/MM/yyyy') and to_date('31/05/"+year1+"','dd/MM/yyyy')  and Renewal_no is null group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m3 from fd_master_view where Account_Status='A' and open_date between to_date('01/06/"+year1+"','dd/MM/yyyy') and to_date('30/06/"+year1+"','dd/MM/yyyy')  and Renewal_no is null group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m4 from fd_master_view where Account_Status='A' and open_date between to_date('01/07/"+year1+"','dd/MM/yyyy') and to_date('31/07/"+year1+"','dd/MM/yyyy')  and Renewal_no is null group by branch)b4 on a.branch=b4.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m5 from fd_master_view where Account_Status='A' and open_date between to_date('01/08/"+year1+"','dd/MM/yyyy') and to_date('31/08/"+year1+"','dd/MM/yyyy')  and Renewal_no is null group by branch)b5 on a.branch=b5.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m6 from fd_master_view where Account_Status='A' and open_date between to_date('01/09/"+year1+"','dd/MM/yyyy') and to_date('30/09/"+year1+"','dd/MM/yyyy')  and Renewal_no is null group by branch)b6 on a.branch=b6.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m7 from fd_master_view where Account_Status='A' and open_date between to_date('01/10/"+year1+"','dd/MM/yyyy') and to_date('31/10/"+year1+"','dd/MM/yyyy')  and Renewal_no is null group by branch)b7 on a.branch=b7.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m8 from fd_master_view where Account_Status='A' and open_date between to_date('01/11/"+year1+"','dd/MM/yyyy') and to_date('30/11/"+year1+"','dd/MM/yyyy')  and Renewal_no is null group by branch)b8 on a.branch=b8.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m9 from fd_master_view where Account_Status='A' and open_date between to_date('01/12/"+year1+"','dd/MM/yyyy') and to_date('31/12/"+year1+"','dd/MM/yyyy')  and Renewal_no is null group by branch)b9 on a.branch=b9.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m10 from fd_master_view where Account_Status='A' and open_date between to_date('01/01/"+year2+"','dd/MM/yyyy') and to_date('31/01/"+year2+"','dd/MM/yyyy')  and Renewal_no is null group by branch)b10 on a.branch=b10.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m11 from fd_master_view where Account_Status='A' and open_date between to_date('01/02/"+year2+"','dd/MM/yyyy') and to_date('28/02/"+year2+"','dd/MM/yyyy')  and Renewal_no is null group by branch)b11 on a.branch=b11.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m12 from fd_master_view where Account_Status='A' and open_date between to_date('01/03/"+year2+"','dd/MM/yyyy') and to_date('31/03/"+year2+"','dd/MM/yyyy')  and Renewal_no is null group by branch)b12 on a.branch=b12.livebranch)main_qry order by main_qry.branch)k ";
											//30-04-2024 zero divice error
											String sql="select k.*,case when (k.Target_Amount-k.targetAchieved)>0 then (k.Target_Amount-k.targetAchieved) else 0 end as balance,case when k.targetAchieved<> 0 and k.Target_Amount<>0 then (to_char (round(nvl((k.targetAchieved*100)/k.Target_Amount,0),2))) else '0.0' end as percen1 from (select main_qry.* from (select a.branch,(select branch_name from branch_master where branch_code=branch)as Bname,(nvl(a.target_amount1,0))*12 as Target_Amount,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)+nvl(b5.achieved_m5,0)+nvl(b6.achieved_m6,0)+nvl(b7.achieved_m7,0)+nvl(b8.achieved_m8,0)+nvl(b9.achieved_m9,0)+nvl(b10.achieved_m10,0)+nvl(b11.achieved_m11,0)+nvl(b12.achieved_m12,0))as targetAchieved,nvl(b.achieved_m1,0) as m1_Acheived,nvl(b2.achieved_m2,0)as  m2_Acheived,nvl(b3.achieved_m3,0) as m3_Acheived,nvl(b4.achieved_m4,0) m4_Acheived,nvl(b5.achieved_m5,0) as m5_Acheived,nvl(b6.achieved_m6,0)as  m6_Acheived,nvl(b7.achieved_m7,0) as m7_Acheived,nvl(b8.achieved_m8,0) m8_Acheived,nvl(b9.achieved_m9,0) as m9_Acheived,nvl(b10.achieved_m10,0)as  m10_Acheived,nvl(b11.achieved_m11,0) as m11_Acheived,nvl(b12.achieved_m12,0) m12_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4) and year="+year1+" group by branch)a left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m1 from fd_master_view where Account_Status='A' and open_date between to_date('01/04/"+year1+"','dd/MM/yyyy') and to_date('30/04/"+year1+"','dd/MM/yyyy')  and Renewal_no is null group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m2 from fd_master_view where Account_Status='A' and open_date between to_date('01/05/"+year1+"','dd/MM/yyyy') and to_date('31/05/"+year1+"','dd/MM/yyyy')  and Renewal_no is null group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m3 from fd_master_view where Account_Status='A' and open_date between to_date('01/06/"+year1+"','dd/MM/yyyy') and to_date('30/06/"+year1+"','dd/MM/yyyy')  and Renewal_no is null group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m4 from fd_master_view where Account_Status='A' and open_date between to_date('01/07/"+year1+"','dd/MM/yyyy') and to_date('31/07/"+year1+"','dd/MM/yyyy')  and Renewal_no is null group by branch)b4 on a.branch=b4.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m5 from fd_master_view where Account_Status='A' and open_date between to_date('01/08/"+year1+"','dd/MM/yyyy') and to_date('31/08/"+year1+"','dd/MM/yyyy')  and Renewal_no is null group by branch)b5 on a.branch=b5.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m6 from fd_master_view where Account_Status='A' and open_date between to_date('01/09/"+year1+"','dd/MM/yyyy') and to_date('30/09/"+year1+"','dd/MM/yyyy')  and Renewal_no is null group by branch)b6 on a.branch=b6.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m7 from fd_master_view where Account_Status='A' and open_date between to_date('01/10/"+year1+"','dd/MM/yyyy') and to_date('31/10/"+year1+"','dd/MM/yyyy')  and Renewal_no is null group by branch)b7 on a.branch=b7.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m8 from fd_master_view where Account_Status='A' and open_date between to_date('01/11/"+year1+"','dd/MM/yyyy') and to_date('30/11/"+year1+"','dd/MM/yyyy')  and Renewal_no is null group by branch)b8 on a.branch=b8.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m9 from fd_master_view where Account_Status='A' and open_date between to_date('01/12/"+year1+"','dd/MM/yyyy') and to_date('31/12/"+year1+"','dd/MM/yyyy')  and Renewal_no is null group by branch)b9 on a.branch=b9.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m10 from fd_master_view where Account_Status='A' and open_date between to_date('01/01/"+year2+"','dd/MM/yyyy') and to_date('31/01/"+year2+"','dd/MM/yyyy')  and Renewal_no is null group by branch)b10 on a.branch=b10.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m11 from fd_master_view where Account_Status='A' and open_date between to_date('01/02/"+year2+"','dd/MM/yyyy') and to_date('28/02/"+year2+"','dd/MM/yyyy')  and Renewal_no is null group by branch)b11 on a.branch=b11.livebranch left join (select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m12 from fd_master_view where Account_Status='A' and open_date between to_date('01/03/"+year2+"','dd/MM/yyyy') and to_date('31/03/"+year2+"','dd/MM/yyyy')  and Renewal_no is null group by branch)b12 on a.branch=b12.livebranch)main_qry order by main_qry.branch)k ";

					System.out.println(sql);

								return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
									
									SimpleBranch gl=new SimpleBranch();
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(3));  //targetAmt
									gl.setS142(rs.getDouble(4));  //targetAcheived
									
									gl.setS143(rs.getDouble(5));  //m1
									
									gl.setS144(rs.getDouble(6));  //m2
									gl.setS145(rs.getDouble(7));  //m3
									gl.setS146(rs.getDouble(8));  //m4
									gl.setS147(rs.getDouble(9));  //m5
									gl.setS148(rs.getDouble(10));  //m6
									gl.setS149(rs.getDouble(11));  //m7
									
									gl.setS150(rs.getDouble(12));  //m8
									gl.setS151(rs.getDouble(13));  //m9
									gl.setS152(rs.getDouble(14));  //m10
									gl.setS153(rs.getDouble(15));  //m11
									gl.setS154(rs.getDouble(16));  //m12
									
									
									//gl.setS32(rs.getString(10));  //percent %
									
									//18-05-2022
									gl.setS155(rs.getDouble(17));  //balance
									gl.setS32(rs.getString(18));  //percent %
									
									
							
									
									
									return gl;
								}
											 }     );
										}

						 public List<SimpleBranch> getTargetReport_Branchwise_Monthly_all_JL(String FromDate,String ToDate,int Month,int Year)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											//14-05-2022 //All JL (SK included)[60028,60024)
											String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount,nvl(b.achieved,0) as acheived,a.target_amount-nvl(b.achieved,0) as targerbalance,to_char(nvl(round((b.achieved*100/a.target_Amount),2),0.00)) as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('"+FromDate+"','dd/mm/yyyy'),'MON-yyyy'),'0') AS month1 from (select branch ,month , year,amount as target_amount,SUBSTR('0'||month,-2,2) as month1 from target_master where month="+Month+" and year="+Year+" and Scheme_Name='JL')a  left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved from JL_master_view where open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') and account_status !='R' group by branch)b on a.branch=b.livebranch order by a.branch";
											
											
											System.out.println(sql);


								return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
									
									SimpleBranch gl=new SimpleBranch();
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									//gl.setS13(rs.getFloat(rs.getString(6)));  ////percentage
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(3));  //targetAmt
									gl.setS142(rs.getDouble(4));  //Acheived
									gl.setS13(rs.getFloat(5));  //balance
									
									gl.setS32(rs.getString(6));  //percentage
									gl.setS33(rs.getString(7));  //month
								
									
							
									
									
									return gl;
								}
											 }     );
										}
						 
						 
						 
						 
						 public List<SimpleBranch> getTargetReport_Branchwise_Monthly_all_DL(String FromDate,String ToDate,int Month,int Year)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											//14-05-2022
											//String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount,nvl(b.achieved,0) as acheived,a.target_amount-nvl(b.achieved,0) as targerbalance,to_char(nvl(round((b.achieved*100/a.target_Amount),2),0.00)) as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('"+FromDate+"','dd/mm/yyyy'),'MON-yyyy'),'0') AS month1 from (select branch ,month , year,amount as target_amount,SUBSTR('0'||month,-2,2) as month1 from target_master where month="+Month+" and year="+Year+" and scheme_name='DL')a  left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved from OL_master_view3 where Scheme_code !='80001' and open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch order by a.branch";
					
											//06-05-2024  // SK included 70030
											String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount,nvl(b.achieved,0) as acheived,a.target_amount-nvl(b.achieved,0) as targerbalance,to_char(nvl(round((b.achieved*100/a.target_Amount),2),0.00)) as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('"+FromDate+"','dd/mm/yyyy'),'MON-yyyy'),'0') AS month1 from (select branch ,month , year,amount as target_amount,SUBSTR('0'||month,-2,2) as month1 from target_master where month="+Month+" and year="+Year+" and scheme_name='DL')a  left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved from OL_master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch order by a.branch";

											
											System.out.println(sql);



					return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
									
									SimpleBranch gl=new SimpleBranch();
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									gl.setS1(rs.getInt(1));  //Branch
									//gl.setS13(rs.getFloat(rs.getString(6)));  ////percentage
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(3));  //targetAmt
									gl.setS142(rs.getDouble(4));  //Acheived
									gl.setS13(rs.getFloat(5));  //balance
									
									gl.setS32(rs.getString(6));  //percentage
									gl.setS33(rs.getString(7));  //month
								
									
							
									
									
									return gl;
								}
											 }     );
										}


						 
						 public List<SimpleBranch> getTargetReport_Branchwise_Monthly_all_ML(String FromDate,String ToDate,int Month,int Year)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											//14-05-2022
											String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount,nvl(b.achieved,0) as acheived,a.target_amount-nvl(b.achieved,0) as targerbalance,to_char(nvl(round((b.achieved*100/a.target_Amount),2),0.00)) as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('"+FromDate+"','dd/mm/yyyy'),'MON-yyyy'),'0') AS month1 from (select branch ,month , year,amount as target_amount,SUBSTR('0'||month,-2,2) as month1 from target_master where month="+Month+" and year="+Year+" and scheme_name='ML')a  left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved from OL_master_view3 where Scheme_code='80001' and open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch order by a.branch";
					System.out.println(sql);


								return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
									
									SimpleBranch gl=new SimpleBranch();
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									gl.setS13(rs.getFloat(rs.getString(6)));  ////percentage
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(3));  //targetAmt
									gl.setS142(rs.getDouble(4));  //Acheived
									gl.setS13(rs.getFloat(5));  //balance
									
									gl.setS32(rs.getString(6));  //percentage
									gl.setS33(rs.getString(7));  //month
								
									
							
									
									
									return gl;
								}
											 }     );
										}
						 
						 
						 
						 public List<SimpleBranch> getTargetReport_Branchwise_Quarterly_all_JL(String FromDate,String Date2,String Date3,String Date4,String Date5,String ToDate,String PeriodMonth,int year1)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											//14-05-2022
											//String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,(a.target_amount/3)-nvl(b.achieved_m1,0) as bal1,to_char(round((b.achieved_m1)*100/(a.target_amount/3),2)||' %') as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,(a.target_amount/3)-nvl(b2.achieved_m2,0) as bal2,to_char(round((b2.achieved_m2)*100/(a.target_amount/3),2)||' %') as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,(a.target_amount/3)-nvl(b3.achieved_m3,0) as bal3,to_char(round((b3.achieved_m3)*100/(a.target_amount/3),2)||' %') as acheived_per3,a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0) as targerbalance,to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00) ||'%') as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" and Scheme_Name='JL' group by branch)a left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from JL_master_view where  open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m2 from JL_master_view where  open_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m3 from JL_master_view where  open_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch order by a.branch";

											//07-06-2022 achieved %
											//String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,(a.target_amount/3)-nvl(b.achieved_m1,0) as bal1,to_char(nvl(round((b.achieved_m1)*100/(a.target_amount/3),2),0)) as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,(a.target_amount/3)-nvl(b2.achieved_m2,0) as bal2,to_char(nvl(round((b2.achieved_m2)*100/(a.target_amount/3),2),0)) as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,(a.target_amount/3)-nvl(b3.achieved_m3,0) as bal3,to_char(nvl(round((b3.achieved_m3)*100/(a.target_amount/3),2),0)) as acheived_per3,a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0) as targerbalance,to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00)) as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" and Scheme_Name='JL' group by branch)a left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from JL_master_view where  open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m2 from JL_master_view where  open_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m3 from JL_master_view where  open_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch order by a.branch";

											//03-05-2024
											//String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,(a.target_amount/3)-nvl(b.achieved_m1,0) as bal1,case when a.target_amount<> 0 and b.achieved_m1<>0 then to_char(nvl(round((b.achieved_m1)*100/(a.target_amount/3),2),0)) else '0.0' end as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,(a.target_amount/3)-nvl(b2.achieved_m2,0) as bal2,case when a.target_amount<> 0 and b2.achieved_m2<>0 then to_char(nvl(round((b2.achieved_m2)*100/(a.target_amount/3),2),0)) else '0.0' end as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,(a.target_amount/3)-nvl(b3.achieved_m3,0) as bal3,case when a.target_amount<> 0 and b3.achieved_m3<>0 then to_char(nvl(round((b3.achieved_m3)*100/(a.target_amount/3),2),0)) else '0.0' end as acheived_per3,a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0) as targerbalance,case when a.target_amount<> 0 and b.achieved_m1<>0 then to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00)) else '0.0' end as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" and Scheme_Name='JL' group by branch)a left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from JL_master_view where  open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m2 from JL_master_view where  open_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m3 from JL_master_view where  open_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') and account_status !='R' group by branch)b3 on a.branch=b3.livebranch order by a.branch";

											//06-05-2024 ////All JL (SK included)[60028,60024)
											String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,(a.target_amount/3)-nvl(b.achieved_m1,0) as bal1,case when a.target_amount<> 0 and b.achieved_m1<>0 then to_char(nvl(round((b.achieved_m1)*100/(a.target_amount/3),2),0)) else '0.0' end as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,(a.target_amount/3)-nvl(b2.achieved_m2,0) as bal2,case when a.target_amount<> 0 and b2.achieved_m2<>0 then to_char(nvl(round((b2.achieved_m2)*100/(a.target_amount/3),2),0)) else '0.0' end as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,(a.target_amount/3)-nvl(b3.achieved_m3,0) as bal3,case when a.target_amount<> 0 and b3.achieved_m3<>0 then to_char(nvl(round((b3.achieved_m3)*100/(a.target_amount/3),2),0)) else '0.0' end as acheived_per3,a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0) as targerbalance,case when a.target_amount<> 0 and b.achieved_m1<>0 then to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00)) else '0.0' end as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" and Scheme_Name='JL' group by branch)a left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from JL_master_view where  open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy') and account_status !='R' group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m2 from JL_master_view where  open_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy') and account_status !='R' group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m3 from JL_master_view where  open_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') and account_status !='R' group by branch)b3 on a.branch=b3.livebranch order by a.branch";

											System.out.println(sql);
								return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
									
									SimpleBranch gl=new SimpleBranch();
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(3));  //targetAmt
									gl.setS142(rs.getDouble(4));  //Acheived1
									gl.setS143(rs.getDouble(5));  //bal1
									
									gl.setS144(rs.getDouble(7));  //Acheived2
									gl.setS145(rs.getDouble(8));  //bal2
									gl.setS146(rs.getDouble(10));  //Acheived3
									gl.setS147(rs.getDouble(11));  //bal3
									
									gl.setS32(rs.getString(6));  //m1 %
									gl.setS33(rs.getString(9));  //m2 %
									gl.setS34(rs.getString(12));  //m3 %
								
									
							
									
									
									return gl;
								}
											 }     );
										}

						 public List<SimpleBranch> getTargetReport_Branchwise_Quarterly_all_ML(String FromDate,String Date2,String Date3,String Date4,String Date5,String ToDate,String PeriodMonth,int year1)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											//14-05-2022
											//String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,(a.target_amount/3)-nvl(b.achieved_m1,0) as bal1,to_char(round((b.achieved_m1)*100/(a.target_amount/3),2)||' %') as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,(a.target_amount/3)-nvl(b2.achieved_m2,0) as bal2,to_char(round((b2.achieved_m2)*100/(a.target_amount/3),2)||' %') as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,(a.target_amount/3)-nvl(b3.achieved_m3,0) as bal3,to_char(round((b3.achieved_m3)*100/(a.target_amount/3),2)||' %') as acheived_per3,a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0) as targerbalance,to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00) ||'%') as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" and Scheme_Name='ML' group by branch)a left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from OL_master_view3 where  Scheme_code='80001' and open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m2 from OL_master_view3 where  Scheme_code='80001' and open_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m3 from OL_master_view3 where  Scheme_code='80001' and open_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch order by a.branch";

											//07-06-2022 acheived %
											String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,(a.target_amount/3)-nvl(b.achieved_m1,0) as bal1,to_char(nvl(round((b.achieved_m1)*100/(a.target_amount/3),2),0)) as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,(a.target_amount/3)-nvl(b2.achieved_m2,0) as bal2,to_char(nvl(round((b2.achieved_m2)*100/(a.target_amount/3),2),0)) as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,(a.target_amount/3)-nvl(b3.achieved_m3,0) as bal3,to_char(nvl(round((b3.achieved_m3)*100/(a.target_amount/3),2),0)) as acheived_per3,a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0) as targerbalance,to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00)) as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" and Scheme_Name='ML' group by branch)a left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from OL_master_view3 where  Scheme_code='80001' and open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m2 from OL_master_view3 where  Scheme_code='80001' and open_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m3 from OL_master_view3 where  Scheme_code='80001' and open_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch order by a.branch";


								return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
									
									SimpleBranch gl=new SimpleBranch();
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(3));  //targetAmt
									gl.setS142(rs.getDouble(4));  //Acheived1
									gl.setS143(rs.getDouble(5));  //bal1
									
									gl.setS144(rs.getDouble(7));  //Acheived2
									gl.setS145(rs.getDouble(8));  //bal2
									gl.setS146(rs.getDouble(10));  //Acheived3
									gl.setS147(rs.getDouble(11));  //bal3
									
									gl.setS32(rs.getString(6));  //m1 %
									gl.setS33(rs.getString(9));  //m2 %
									gl.setS34(rs.getString(12));  //m3 %
								
									
							
									
									
									return gl;
								}
											 }     );
										}

						 
						 
						 
						 
						 public List<SimpleBranch> getTargetReport_Branchwise_Quarterly_all_DL(String FromDate,String Date2,String Date3,String Date4,String Date5,String ToDate,String PeriodMonth,int year1)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											//14-05-2022
											//String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,(a.target_amount/3)-nvl(b.achieved_m1,0) as bal1,to_char(round((b.achieved_m1)*100/(a.target_amount/3),2)||' %') as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,(a.target_amount/3)-nvl(b2.achieved_m2,0) as bal2,to_char(round((b2.achieved_m2)*100/(a.target_amount/3),2)||' %') as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,(a.target_amount/3)-nvl(b3.achieved_m3,0) as bal3,to_char(round((b3.achieved_m3)*100/(a.target_amount/3),2)||' %') as acheived_per3,a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0) as targerbalance,to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00) ||'%') as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" and Scheme_Name='ML' group by branch)a left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from OL_master_view3 where  Scheme_code='70010' and open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m2 from OL_master_view3 where  Scheme_code='70010' and open_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m3 from OL_master_view3 where  Scheme_code='70010' and open_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch order by a.branch";

											//07-06-2022 achieved %
										//	String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,(a.target_amount/3)-nvl(b.achieved_m1,0) as bal1,to_char(nvl(round((b.achieved_m1)*100/(a.target_amount/3),2),0)) as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,(a.target_amount/3)-nvl(b2.achieved_m2,0) as bal2,to_char(nvl(round((b2.achieved_m2)*100/(a.target_amount/3),2),0)) as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,(a.target_amount/3)-nvl(b3.achieved_m3,0) as bal3,to_char(nvl(round((b3.achieved_m3)*100/(a.target_amount/3),2),0)) as acheived_per3,a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0) as targerbalance,to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00) ||'%') as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" and Scheme_Name='ML' group by branch)a left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from OL_master_view3 where  Scheme_code='70010' and open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m2 from OL_master_view3 where  Scheme_code='70010' and open_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m3 from OL_master_view3 where  Scheme_code='70010' and open_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch order by a.branch";

											//06-05-2024
											//String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,(a.target_amount/3)-nvl(b.achieved_m1,0) as bal1,to_char(nvl(round((b.achieved_m1)*100/(a.target_amount/3),2),0)) as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,(a.target_amount/3)-nvl(b2.achieved_m2,0) as bal2,to_char(nvl(round((b2.achieved_m2)*100/(a.target_amount/3),2),0)) as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,(a.target_amount/3)-nvl(b3.achieved_m3,0) as bal3,to_char(nvl(round((b3.achieved_m3)*100/(a.target_amount/3),2),0)) as acheived_per3,a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0) as targerbalance,to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00) ||'%') as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" and Scheme_Name='ML' group by branch)a left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from OL_master_view3 where  Scheme_code !='80001' and open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m2 from OL_master_view3 where  Scheme_code !='80001' and open_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m3 from OL_master_view3 where  Scheme_code !='80001' and open_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch order by a.branch";

											//06-05-2024
											//String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,(a.target_amount/3)-nvl(b.achieved_m1,0) as bal1,to_char(nvl(round((b.achieved_m1)*100/(a.target_amount/3),2),0)) as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,(a.target_amount/3)-nvl(b2.achieved_m2,0) as bal2,to_char(nvl(round((b2.achieved_m2)*100/(a.target_amount/3),2),0)) as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,(a.target_amount/3)-nvl(b3.achieved_m3,0) as bal3,to_char(nvl(round((b3.achieved_m3)*100/(a.target_amount/3),2),0)) as acheived_per3,a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0) as targerbalance,to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00) ||'%') as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" and Scheme_Name='ML' group by branch)a left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from OL_master_view3 where  Scheme_code in ('70010','70030') and open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m2 from OL_master_view3 where  Scheme_code in ('70010','70030') and open_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m3 from OL_master_view3 where  Scheme_code in ('70010','70030') and open_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch order by a.branch";
											//String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,(a.target_amount/3)-nvl(b.achieved_m1,0) as bal1,to_char(nvl(round((b.achieved_m1)*100/(a.target_amount/3),2),0)) as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,(a.target_amount/3)-nvl(b2.achieved_m2,0) as bal2,to_char(nvl(round((b2.achieved_m2)*100/(a.target_amount/3),2),0)) as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,(a.target_amount/3)-nvl(b3.achieved_m3,0) as bal3,to_char(nvl(round((b3.achieved_m3)*100/(a.target_amount/3),2),0)) as acheived_per3,a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0) as targerbalance,to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00) ||'%') as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" and Scheme_Name='ML' group by branch)a left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from OL_master_view3 where  Scheme_code in ('70010', '70030')   and account_status !='R' and open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m2 from OL_master_view3 where  Scheme_code in ('70010', '70030')   and account_status !='R' and open_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m3 from OL_master_view3 where  Scheme_code in ('70010', '70030')   and account_status !='R' and open_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch order by a.branch";
											//String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,(a.target_amount/3)-nvl(b.achieved_m1,0) as bal1,to_char(nvl(round((b.achieved_m1)*100/(a.target_amount/3),2),0)) as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,(a.target_amount/3)-nvl(b2.achieved_m2,0) as bal2,to_char(nvl(round((b2.achieved_m2)*100/(a.target_amount/3),2),0)) as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,(a.target_amount/3)-nvl(b3.achieved_m3,0) as bal3,to_char(nvl(round((b3.achieved_m3)*100/(a.target_amount/3),2),0)) as acheived_per3,a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0) as targerbalance,to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00) ||'%') as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" and Scheme_Name='DL' group by branch)a left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from OL_master_view3 where  Scheme_code in ('70010', '70030')   and account_status !='R' and open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m2 from OL_master_view3 where  Scheme_code in ('70010', '70030')   and account_status !='R' and open_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m3 from OL_master_view3 where  Scheme_code in ('70010', '70030')   and account_status !='R' and open_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch order by a.branch";
											String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,(a.target_amount/3)-nvl(b.achieved_m1,0) as bal1,case when b.achieved_m1 <>0 and a.target_amount <> 0 then to_char(nvl(round((b.achieved_m1)*100/(a.target_amount/3),2),0)) else '0.0' end as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,(a.target_amount/3)-nvl(b2.achieved_m2,0) as bal2,case when b2.achieved_m2 <>0 and a.target_amount <> 0 then to_char(nvl(round((b2.achieved_m2)*100/(a.target_amount/3),2),0)) else '0.0' end as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,(a.target_amount/3)-nvl(b3.achieved_m3,0) as bal3,case when b3.achieved_m3 <>0 and a.target_amount <> 0 then to_char(nvl(round((b3.achieved_m3)*100/(a.target_amount/3),2),0)) else '0.0' end as acheived_per3,a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0) as targerbalance,case when nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0) <> 0 then to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00)) else '0.0' end as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" and Scheme_Name='DL' group by branch)a left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from OL_master_view3 where  Scheme_code in ('70010', '70030')   and account_status !='R' and open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m2 from OL_master_view3 where  Scheme_code in ('70010', '70030')   and account_status !='R' and open_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m3 from OL_master_view3 where  Scheme_code in ('70010', '70030')   and account_status !='R' and open_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch order by a.branch";

System.out.println(sql);
								return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
									
									SimpleBranch gl=new SimpleBranch();
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(3));  //targetAmt
									gl.setS142(rs.getDouble(4));  //Acheived1
									gl.setS143(rs.getDouble(5));  //bal1
									
									gl.setS144(rs.getDouble(7));  //Acheived2
									gl.setS145(rs.getDouble(8));  //bal2
									gl.setS146(rs.getDouble(10));  //Acheived3
									gl.setS147(rs.getDouble(11));  //bal3
									
									gl.setS32(rs.getString(6));  //m1 %
									gl.setS33(rs.getString(9));  //m2 %
									gl.setS34(rs.getString(12));  //m3 %
								
									
							
									
									
									return gl;
								}
											 }     );
										}

						 
						 public List<SimpleBranch> getTargetReport_Branchwise_Consolidated_all_JL(String FromDate,String Date1,String Date2,String Date3,String Date4,String Date5,String Date6,String ToDate,int year1)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											//14-05-2022
											//String sql="select main_qry.*,case when main_qry.targetachieved <> 0 and main_qry.yearlydeposits <>0 then to_char(nvl(round((main_qry.targetachieved*100/main_qry.yearlydeposits),2),0)) else '0.0' end as Achcheived_Percent from (select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0)) as yearlyDeposits,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetAchieved,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetnotAchieved,nvl(b.achieved_m1,0) as Q1_Acheived,nvl(b2.achieved_m2,0)as  Q2_Acheived,nvl(b3.achieved_m3,0) as Q3_Acheived,nvl(b4.achieved_m4,0) Q4_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4,5,6) and year="+year1+" and scheme_name='JL' group by branch)a left join (select branch ,sum(amount) as target_amount2 from target_master where month in (7,8,9) and year="+year1+" and scheme_name='JL' group by branch)a2 on a.branch=a2.branch left join (select branch ,sum(amount) as target_amount3 from target_master where month in (10,11,12) and year="+year1+" and scheme_name='JL' group by branch)a3 on a.branch=a3.branch left join (select branch ,sum(amount) as target_amount4 from target_master where month in (1,2,3) and year="+(year1+1)+" and scheme_name='JL' group by branch)a4 on a.branch=a4.branch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from JL_master_view where   open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date1+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m2 from JL_master_view where open_date between to_date('"+Date2+"','dd/MM/yyyy') and to_date('"+Date3+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m3 from JL_master_view where open_date between to_date('"+Date4+"','dd/MM/yyyy') and to_date('"+Date5+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m4 from JL_master_view where  open_date between to_date('"+Date6+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b4 on a.branch=b4.livebranch)main_qry order by main_qry.branch";
											//06-05-2024 //All JL (SK included)[60028,60024)
											String sql="select main_qry.*,case when main_qry.targetachieved <> 0 and main_qry.yearlydeposits <>0 then to_char(nvl(round((main_qry.targetachieved*100/main_qry.yearlydeposits),2),0)) else '0.0' end as Achcheived_Percent from (select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0)) as yearlyDeposits,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetAchieved,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetnotAchieved,nvl(b.achieved_m1,0) as Q1_Acheived,nvl(b2.achieved_m2,0)as  Q2_Acheived,nvl(b3.achieved_m3,0) as Q3_Acheived,nvl(b4.achieved_m4,0) Q4_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4,5,6) and year="+year1+" and scheme_name='JL' group by branch)a left join (select branch ,sum(amount) as target_amount2 from target_master where month in (7,8,9) and year="+year1+" and scheme_name='JL' group by branch)a2 on a.branch=a2.branch left join (select branch ,sum(amount) as target_amount3 from target_master where month in (10,11,12) and year="+year1+" and scheme_name='JL' group by branch)a3 on a.branch=a3.branch left join (select branch ,sum(amount) as target_amount4 from target_master where month in (1,2,3) and year="+(year1+1)+" and scheme_name='JL' group by branch)a4 on a.branch=a4.branch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from JL_master_view where   open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date1+"','dd/MM/yyyy') and account_status !='R' group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m2 from JL_master_view where open_date between to_date('"+Date2+"','dd/MM/yyyy') and to_date('"+Date3+"','dd/MM/yyyy') and account_status !='R' group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m3 from JL_master_view where open_date between to_date('"+Date4+"','dd/MM/yyyy') and to_date('"+Date5+"','dd/MM/yyyy') and account_status !='R' group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m4 from JL_master_view where  open_date between to_date('"+Date6+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') and account_status !='R' group by branch)b4 on a.branch=b4.livebranch)main_qry order by main_qry.branch";


								return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
									
									SimpleBranch gl=new SimpleBranch();
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
								
									gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(3));  //targetAmt
									gl.setS142(rs.getDouble(4));  //targetAcheived
									gl.setS143(rs.getDouble(5));  //targetNotAcheived
									
									gl.setS144(rs.getDouble(6));  //q1
									gl.setS145(rs.getDouble(7));  //q2
									gl.setS146(rs.getDouble(8));  //q3
									gl.setS147(rs.getDouble(9));  //q4
									gl.setS32(rs.getString(10));  //percent %
									
									
							
									
									
									return gl;
								}
											 }     );
										}


						 
						 public List<SimpleBranch> getTargetReport_Branchwise_Consolidated_all_ML(String FromDate,String Date1,String Date2,String Date3,String Date4,String Date5,String Date6,String ToDate,int year1)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											//14-05-2022
											//String sql="select main_qry.*,to_char(nvl(round((main_qry.targetachieved*100/main_qry.yearlydeposits),2),0)|| ' %') as Achcheived_Percent from (select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0)) as yearlyDeposits,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetAchieved,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetnotAchieved,nvl(b.achieved_m1,0) as Q1_Acheived,nvl(b2.achieved_m2,0)as  Q2_Acheived,nvl(b3.achieved_m3,0) as Q3_Acheived,nvl(b4.achieved_m4,0) Q4_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4,5,6) and year="+year1+" and scheme_name='ML' group by branch)a left join (select branch ,sum(amount) as target_amount2 from target_master where month in (7,8,9) and year="+year1+" and scheme_name='ML' group by branch)a2 on a.branch=a2.branch left join (select branch ,sum(amount) as target_amount3 from target_master where month in (10,11,12) and year="+year1+" and scheme_name='ML' group by branch)a3 on a.branch=a3.branch left join (select branch ,sum(amount) as target_amount4 from target_master where month in (1,2,3) and year="+(year1+1)+" and scheme_name='ML' group by branch)a4 on a.branch=a4.branch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from OL_master_view3 where scheme_code='80001'  and    open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date1+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m2 from OL_master_view3 where scheme_code='80001'  and  open_date between to_date('"+Date2+"','dd/MM/yyyy') and to_date('"+Date3+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m3 from OL_master_view3 where scheme_code='80001'  and  open_date between to_date('"+Date4+"','dd/MM/yyyy') and to_date('"+Date5+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m4 from OL_master_view3 where scheme_code='80001'  and   open_date between to_date('"+Date6+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b4 on a.branch=b4.livebranch)main_qry order by main_qry.branch";
											//30-04-2024 case when main_qry.targetachieved <> 0 and main_qry.yearlydeposits <>0 then to_char(nvl(round((main_qry.targetachieved*100/main_qry.yearlydeposits),2),0)|| ' %') else '0.0 %' end
											String sql="select main_qry.*,case when main_qry.targetachieved <> 0 and main_qry.yearlydeposits <>0 then to_char(nvl(round((main_qry.targetachieved*100/main_qry.yearlydeposits),2),0)) else '0.0' end as Achcheived_Percent from (select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0)) as yearlyDeposits,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetAchieved,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetnotAchieved,nvl(b.achieved_m1,0) as Q1_Acheived,nvl(b2.achieved_m2,0)as  Q2_Acheived,nvl(b3.achieved_m3,0) as Q3_Acheived,nvl(b4.achieved_m4,0) Q4_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4,5,6) and year="+year1+" and scheme_name='ML' group by branch)a left join (select branch ,sum(amount) as target_amount2 from target_master where month in (7,8,9) and year="+year1+" and scheme_name='ML' group by branch)a2 on a.branch=a2.branch left join (select branch ,sum(amount) as target_amount3 from target_master where month in (10,11,12) and year="+year1+" and scheme_name='ML' group by branch)a3 on a.branch=a3.branch left join (select branch ,sum(amount) as target_amount4 from target_master where month in (1,2,3) and year="+(year1+1)+" and scheme_name='ML' group by branch)a4 on a.branch=a4.branch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from OL_master_view3 where scheme_code='80001'  and    open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date1+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m2 from OL_master_view3 where scheme_code='80001'  and  open_date between to_date('"+Date2+"','dd/MM/yyyy') and to_date('"+Date3+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m3 from OL_master_view3 where scheme_code='80001'  and  open_date between to_date('"+Date4+"','dd/MM/yyyy') and to_date('"+Date5+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m4 from OL_master_view3 where scheme_code='80001'  and   open_date between to_date('"+Date6+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b4 on a.branch=b4.livebranch)main_qry order by main_qry.branch";


								return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
									
									SimpleBranch gl=new SimpleBranch();
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(3));  //targetAmt
									gl.setS142(rs.getDouble(4));  //targetAcheived
									gl.setS143(rs.getDouble(5));  //targetNotAcheived
									
									gl.setS144(rs.getDouble(6));  //q1
									gl.setS145(rs.getDouble(7));  //q2
									gl.setS146(rs.getDouble(8));  //q3
									gl.setS147(rs.getDouble(9));  //q4
									gl.setS32(rs.getString(10));  //percent %
									
									
							
									
									
									return gl;
								}
											 }     );
										}

						 
						 public List<SimpleBranch> getTargetReport_Branchwise_Consolidated_all_DL(String FromDate,String Date1,String Date2,String Date3,String Date4,String Date5,String Date6,String ToDate,int year1)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											//14-05-2022
											//String sql="select main_qry.*,case when main_qry.targetachieved <> 0 and main_qry.yearlydeposits <>0 then to_char(nvl(round((main_qry.targetachieved*100/main_qry.yearlydeposits),2),0)) else '0.0' end as Achcheived_Percent from (select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0)) as yearlyDeposits,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetAchieved,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetnotAchieved,nvl(b.achieved_m1,0) as Q1_Acheived,nvl(b2.achieved_m2,0)as  Q2_Acheived,nvl(b3.achieved_m3,0) as Q3_Acheived,nvl(b4.achieved_m4,0) Q4_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4,5,6) and year="+year1+" and scheme_name='ML' group by branch)a left join (select branch ,sum(amount) as target_amount2 from target_master where month in (7,8,9) and year="+year1+" and scheme_name='ML' group by branch)a2 on a.branch=a2.branch left join (select branch ,sum(amount) as target_amount3 from target_master where month in (10,11,12) and year="+year1+" and scheme_name='ML' group by branch)a3 on a.branch=a3.branch left join (select branch ,sum(amount) as target_amount4 from target_master where month in (1,2,3) and year="+(year1+1)+" and scheme_name='ML' group by branch)a4 on a.branch=a4.branch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from OL_master_view3 where scheme_code='70010' and    open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date1+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m2 from OL_master_view3 where scheme_code='70010' and  open_date between to_date('"+Date2+"','dd/MM/yyyy') and to_date('"+Date3+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m3 from OL_master_view3 where scheme_code='70010' and  open_date between to_date('"+Date4+"','dd/MM/yyyy') and to_date('"+Date5+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m4 from OL_master_view3 where scheme_code='70010' and   open_date between to_date('"+Date6+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b4 on a.branch=b4.livebranch)main_qry order by main_qry.branch";

											//06-05-2024
											//String sql="select main_qry.*,case when main_qry.targetachieved <> 0 and main_qry.yearlydeposits <>0 then to_char(nvl(round((main_qry.targetachieved*100/main_qry.yearlydeposits),2),0)) else '0.0' end as Achcheived_Percent from (select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0)) as yearlyDeposits,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetAchieved,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetnotAchieved,nvl(b.achieved_m1,0) as Q1_Acheived,nvl(b2.achieved_m2,0)as  Q2_Acheived,nvl(b3.achieved_m3,0) as Q3_Acheived,nvl(b4.achieved_m4,0) Q4_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4,5,6) and year="+year1+" and scheme_name='ML' group by branch)a left join (select branch ,sum(amount) as target_amount2 from target_master where month in (7,8,9) and year="+year1+" and scheme_name='ML' group by branch)a2 on a.branch=a2.branch left join (select branch ,sum(amount) as target_amount3 from target_master where month in (10,11,12) and year="+year1+" and scheme_name='ML' group by branch)a3 on a.branch=a3.branch left join (select branch ,sum(amount) as target_amount4 from target_master where month in (1,2,3) and year="+(year1+1)+" and scheme_name='ML' group by branch)a4 on a.branch=a4.branch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from OL_master_view3 where Scheme_code !='80001' and    open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date1+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m2 from OL_master_view3 where Scheme_code !='80001' and  open_date between to_date('"+Date2+"','dd/MM/yyyy') and to_date('"+Date3+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m3 from OL_master_view3 where Scheme_code !='80001' and  open_date between to_date('"+Date4+"','dd/MM/yyyy') and to_date('"+Date5+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m4 from OL_master_view3 where Scheme_code !='80001' and   open_date between to_date('"+Date6+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b4 on a.branch=b4.livebranch)main_qry order by main_qry.branch";
											//String sql="select main_qry.*,case when main_qry.targetachieved <> 0 and main_qry.yearlydeposits <>0 then to_char(nvl(round((main_qry.targetachieved*100/main_qry.yearlydeposits),2),0)) else '0.0' end as Achcheived_Percent from (select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0)) as yearlyDeposits,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetAchieved,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetnotAchieved,nvl(b.achieved_m1,0) as Q1_Acheived,nvl(b2.achieved_m2,0)as  Q2_Acheived,nvl(b3.achieved_m3,0) as Q3_Acheived,nvl(b4.achieved_m4,0) Q4_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4,5,6) and year="+year1+" and scheme_name='ML' group by branch)a left join (select branch ,sum(amount) as target_amount2 from target_master where month in (7,8,9) and year="+year1+" and scheme_name='ML' group by branch)a2 on a.branch=a2.branch left join (select branch ,sum(amount) as target_amount3 from target_master where month in (10,11,12) and year="+year1+" and scheme_name='ML' group by branch)a3 on a.branch=a3.branch left join (select branch ,sum(amount) as target_amount4 from target_master where month in (1,2,3) and year="+(year1+1)+" and scheme_name='ML' group by branch)a4 on a.branch=a4.branch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from OL_master_view3 where Scheme_code in ('70010', '70030') and account_status !='R' and    open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date1+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m2 from OL_master_view3 where Scheme_code in ('70010',  '70030') and account_status !='R' and  open_date between to_date('"+Date2+"','dd/MM/yyyy') and to_date('"+Date3+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m3 from OL_master_view3 where Scheme_code in ('70010',  '70030') and account_status !='R' and  open_date between to_date('"+Date4+"','dd/MM/yyyy') and to_date('"+Date5+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m4 from OL_master_view3 where Scheme_code in ('70010',  '70030') and account_status !='R' and   open_date between to_date('"+Date6+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b4 on a.branch=b4.livebranch)main_qry order by main_qry.branch";
											String sql="select main_qry.*,case when main_qry.targetachieved <> 0 and main_qry.yearlydeposits <>0 then to_char(nvl(round((main_qry.targetachieved*100/main_qry.yearlydeposits),2),0)) else '0.0' end as Achcheived_Percent from (select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0)) as yearlyDeposits,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetAchieved,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetnotAchieved,nvl(b.achieved_m1,0) as Q1_Acheived,nvl(b2.achieved_m2,0)as  Q2_Acheived,nvl(b3.achieved_m3,0) as Q3_Acheived,nvl(b4.achieved_m4,0) Q4_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4,5,6) and year="+year1+" and scheme_name='DL' group by branch)a left join (select branch ,sum(amount) as target_amount2 from target_master where month in (7,8,9) and year="+year1+" and scheme_name='DL' group by branch)a2 on a.branch=a2.branch left join (select branch ,sum(amount) as target_amount3 from target_master where month in (10,11,12) and year="+year1+" and scheme_name='DL' group by branch)a3 on a.branch=a3.branch left join (select branch ,sum(amount) as target_amount4 from target_master where month in (1,2,3) and year="+(year1+1)+" and scheme_name='DL' group by branch)a4 on a.branch=a4.branch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from OL_master_view3 where Scheme_code in ('70010', '70030') and account_status !='R' and    open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date1+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m2 from OL_master_view3 where Scheme_code in ('70010',  '70030') and account_status !='R' and  open_date between to_date('"+Date2+"','dd/MM/yyyy') and to_date('"+Date3+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m3 from OL_master_view3 where Scheme_code in ('70010',  '70030') and account_status !='R' and  open_date between to_date('"+Date4+"','dd/MM/yyyy') and to_date('"+Date5+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m4 from OL_master_view3 where Scheme_code in ('70010',  '70030') and account_status !='R' and   open_date between to_date('"+Date6+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch)b4 on a.branch=b4.livebranch)main_qry order by main_qry.branch";


								return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
									
									SimpleBranch gl=new SimpleBranch();
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(3));  //targetAmt
									gl.setS142(rs.getDouble(4));  //targetAcheived
									gl.setS143(rs.getDouble(5));  //targetNotAcheived
									
									gl.setS144(rs.getDouble(6));  //q1
									gl.setS145(rs.getDouble(7));  //q2
									gl.setS146(rs.getDouble(8));  //q3
									gl.setS147(rs.getDouble(9));  //q4
									gl.setS32(rs.getString(10));  //percent %
									
									
							
									
									
									return gl;
								}
											 }     );
										}

						 
						 //14-05-2022
						 public List<SimpleBranch> getTargetReport_Branchwise_Yearly_JL(int year1,int year2)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											//14-05-2022
	//										String sql="select main_qry.* from (select a.branch,(select branch_name from branch_master where branch_code=branch)as Bname,(nvl(a.target_amount1,0))*12 as Target_Amount,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)+nvl(b5.achieved_m5,0)+nvl(b6.achieved_m6,0)+nvl(b7.achieved_m7,0)+nvl(b8.achieved_m8,0)+nvl(b9.achieved_m9,0)+nvl(b10.achieved_m10,0)+nvl(b11.achieved_m11,0)+nvl(b12.achieved_m12,0))as targetAchieved,nvl(b.achieved_m1,0) as m1_Acheived,nvl(b2.achieved_m2,0)as  m2_Acheived,nvl(b3.achieved_m3,0) as m3_Acheived,nvl(b4.achieved_m4,0) m4_Acheived,nvl(b5.achieved_m5,0) as m5_Acheived,nvl(b6.achieved_m6,0)as  m6_Acheived,nvl(b7.achieved_m7,0) as m7_Acheived,nvl(b8.achieved_m8,0) m8_Acheived,nvl(b9.achieved_m9,0) as m9_Acheived,nvl(b10.achieved_m10,0)as  m10_Acheived,nvl(b11.achieved_m11,0) as m11_Acheived,nvl(b12.achieved_m12,0) m12_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4) and year="+year1+" and Scheme_name='JL' group by branch)a left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from JL_master_view where open_date between to_date('01/04/"+year1+"','dd/MM/yyyy') and to_date('30/04/"+year1+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m2 from JL_master_view where  open_date between to_date('01/05/"+year1+"','dd/MM/yyyy') and to_date('31/05/"+year1+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m3 from JL_master_view where  open_date between to_date('01/06/"+year1+"','dd/MM/yyyy') and to_date('30/06/"+year1+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m4 from JL_master_view where  open_date between to_date('01/07/"+year1+"','dd/MM/yyyy') and to_date('31/07/"+year1+"','dd/MM/yyyy') group by branch)b4 on a.branch=b4.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m5 from JL_master_view where  open_date between to_date('01/08/"+year1+"','dd/MM/yyyy') and to_date('31/08/"+year1+"','dd/MM/yyyy') group by branch)b5 on a.branch=b5.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m6 from JL_master_view where  open_date between to_date('01/09/"+year1+"','dd/MM/yyyy') and to_date('30/09/"+year1+"','dd/MM/yyyy') group by branch)b6 on a.branch=b6.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m7 from JL_master_view where  open_date between to_date('01/10/"+year1+"','dd/MM/yyyy') and to_date('31/10/"+year1+"','dd/MM/yyyy') group by branch)b7 on a.branch=b7.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m8 from JL_master_view where  open_date between to_date('01/11/"+year1+"','dd/MM/yyyy') and to_date('30/11/"+year1+"','dd/MM/yyyy') group by branch)b8 on a.branch=b8.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m9 from JL_master_view where  open_date between to_date('01/12/"+year1+"','dd/MM/yyyy') and to_date('31/12/"+year1+"','dd/MM/yyyy') group by branch)b9 on a.branch=b9.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m10 from JL_master_view where  open_date between to_date('01/01/"+year2+"','dd/MM/yyyy') and to_date('31/01/"+year2+"','dd/MM/yyyy') group by branch)b10 on a.branch=b10.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m11 from JL_master_view where  open_date between to_date('01/02/"+year2+"','dd/MM/yyyy') and to_date('28/02/"+year2+"','dd/MM/yyyy') group by branch)b11 on a.branch=b11.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m12 from JL_master_view where  open_date between to_date('01/03/"+year2+"','dd/MM/yyyy') and to_date('31/03/"+year2+"','dd/MM/yyyy') group by branch)b12 on a.branch=b12.livebranch)main_qry order by main_qry.branch";

											//18-05-2022
	//										String sql="select k.*,case when (k.Target_Amount-k.targetAchieved)>0 then (k.Target_Amount-k.targetAchieved) else 0 end as balance,case when k.targetAchieved<> 0 and k.Target_Amount<>0 then (to_char (round(nvl((k.targetAchieved*100)/k.Target_Amount,0),2))) else '0.0' end as percen1 from (select main_qry.* from (select a.branch,(select branch_name from branch_master where branch_code=branch)as Bname,(nvl(a.target_amount1,0))*12 as Target_Amount,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)+nvl(b5.achieved_m5,0)+nvl(b6.achieved_m6,0)+nvl(b7.achieved_m7,0)+nvl(b8.achieved_m8,0)+nvl(b9.achieved_m9,0)+nvl(b10.achieved_m10,0)+nvl(b11.achieved_m11,0)+nvl(b12.achieved_m12,0))as targetAchieved,nvl(b.achieved_m1,0) as m1_Acheived,nvl(b2.achieved_m2,0)as  m2_Acheived,nvl(b3.achieved_m3,0) as m3_Acheived,nvl(b4.achieved_m4,0) m4_Acheived,nvl(b5.achieved_m5,0) as m5_Acheived,nvl(b6.achieved_m6,0)as  m6_Acheived,nvl(b7.achieved_m7,0) as m7_Acheived,nvl(b8.achieved_m8,0) m8_Acheived,nvl(b9.achieved_m9,0) as m9_Acheived,nvl(b10.achieved_m10,0)as  m10_Acheived,nvl(b11.achieved_m11,0) as m11_Acheived,nvl(b12.achieved_m12,0) m12_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4) and year="+year1+" and Scheme_name='JL' group by branch)a left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from JL_master_view where open_date between to_date('01/04/"+year1+"','dd/MM/yyyy') and to_date('30/04/"+year1+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m2 from JL_master_view where  open_date between to_date('01/05/"+year1+"','dd/MM/yyyy') and to_date('31/05/"+year1+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m3 from JL_master_view where  open_date between to_date('01/06/"+year1+"','dd/MM/yyyy') and to_date('30/06/"+year1+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m4 from JL_master_view where  open_date between to_date('01/07/"+year1+"','dd/MM/yyyy') and to_date('31/07/"+year1+"','dd/MM/yyyy') group by branch)b4 on a.branch=b4.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m5 from JL_master_view where  open_date between to_date('01/08/"+year1+"','dd/MM/yyyy') and to_date('31/08/"+year1+"','dd/MM/yyyy') group by branch)b5 on a.branch=b5.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m6 from JL_master_view where  open_date between to_date('01/09/"+year1+"','dd/MM/yyyy') and to_date('30/09/"+year1+"','dd/MM/yyyy') group by branch)b6 on a.branch=b6.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m7 from JL_master_view where  open_date between to_date('01/10/"+year1+"','dd/MM/yyyy') and to_date('31/10/"+year1+"','dd/MM/yyyy') group by branch)b7 on a.branch=b7.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m8 from JL_master_view where  open_date between to_date('01/11/"+year1+"','dd/MM/yyyy') and to_date('30/11/"+year1+"','dd/MM/yyyy') group by branch)b8 on a.branch=b8.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m9 from JL_master_view where  open_date between to_date('01/12/"+year1+"','dd/MM/yyyy') and to_date('31/12/"+year1+"','dd/MM/yyyy') group by branch)b9 on a.branch=b9.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m10 from JL_master_view where  open_date between to_date('01/01/"+year2+"','dd/MM/yyyy') and to_date('31/01/"+year2+"','dd/MM/yyyy') group by branch)b10 on a.branch=b10.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m11 from JL_master_view where  open_date between to_date('01/02/"+year2+"','dd/MM/yyyy') and to_date('28/02/"+year2+"','dd/MM/yyyy') group by branch)b11 on a.branch=b11.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m12 from JL_master_view where  open_date between to_date('01/03/"+year2+"','dd/MM/yyyy') and to_date('31/03/"+year2+"','dd/MM/yyyy') group by branch)b12 on a.branch=b12.livebranch)main_qry order by main_qry.branch)k ";

											//06-05-2024 //All JL (SK included)[60028,60024)
											String sql="select k.*,case when (k.Target_Amount-k.targetAchieved)>0 then (k.Target_Amount-k.targetAchieved) else 0 end as balance,case when k.targetAchieved<> 0 and k.Target_Amount<>0 then (to_char (round(nvl((k.targetAchieved*100)/k.Target_Amount,0),2))) else '0.0' end as percen1 from (select main_qry.* from (select a.branch,(select branch_name from branch_master where branch_code=branch)as Bname,(nvl(a.target_amount1,0))*12 as Target_Amount,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)+nvl(b5.achieved_m5,0)+nvl(b6.achieved_m6,0)+nvl(b7.achieved_m7,0)+nvl(b8.achieved_m8,0)+nvl(b9.achieved_m9,0)+nvl(b10.achieved_m10,0)+nvl(b11.achieved_m11,0)+nvl(b12.achieved_m12,0))as targetAchieved,nvl(b.achieved_m1,0) as m1_Acheived,nvl(b2.achieved_m2,0)as  m2_Acheived,nvl(b3.achieved_m3,0) as m3_Acheived,nvl(b4.achieved_m4,0) m4_Acheived,nvl(b5.achieved_m5,0) as m5_Acheived,nvl(b6.achieved_m6,0)as  m6_Acheived,nvl(b7.achieved_m7,0) as m7_Acheived,nvl(b8.achieved_m8,0) m8_Acheived,nvl(b9.achieved_m9,0) as m9_Acheived,nvl(b10.achieved_m10,0)as  m10_Acheived,nvl(b11.achieved_m11,0) as m11_Acheived,nvl(b12.achieved_m12,0) m12_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4) and year="+year1+" and Scheme_name='JL' group by branch)a left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from JL_master_view where open_date between to_date('01/04/"+year1+"','dd/MM/yyyy') and to_date('30/04/"+year1+"','dd/MM/yyyy') and account_status !='R' group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m2 from JL_master_view where  open_date between to_date('01/05/"+year1+"','dd/MM/yyyy') and to_date('31/05/"+year1+"','dd/MM/yyyy') and account_status !='R' group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m3 from JL_master_view where  open_date between to_date('01/06/"+year1+"','dd/MM/yyyy') and to_date('30/06/"+year1+"','dd/MM/yyyy') and account_status !='R' group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m4 from JL_master_view where  open_date between to_date('01/07/"+year1+"','dd/MM/yyyy') and to_date('31/07/"+year1+"','dd/MM/yyyy') and account_status !='R' group by branch)b4 on a.branch=b4.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m5 from JL_master_view where  open_date between to_date('01/08/"+year1+"','dd/MM/yyyy') and to_date('31/08/"+year1+"','dd/MM/yyyy') and account_status !='R' group by branch)b5 on a.branch=b5.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m6 from JL_master_view where  open_date between to_date('01/09/"+year1+"','dd/MM/yyyy') and to_date('30/09/"+year1+"','dd/MM/yyyy') and account_status !='R' group by branch)b6 on a.branch=b6.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m7 from JL_master_view where  open_date between to_date('01/10/"+year1+"','dd/MM/yyyy') and to_date('31/10/"+year1+"','dd/MM/yyyy') and account_status !='R' group by branch)b7 on a.branch=b7.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m8 from JL_master_view where  open_date between to_date('01/11/"+year1+"','dd/MM/yyyy') and to_date('30/11/"+year1+"','dd/MM/yyyy') and account_status !='R' group by branch)b8 on a.branch=b8.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m9 from JL_master_view where  open_date between to_date('01/12/"+year1+"','dd/MM/yyyy') and to_date('31/12/"+year1+"','dd/MM/yyyy') and account_status !='R' group by branch)b9 on a.branch=b9.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m10 from JL_master_view where  open_date between to_date('01/01/"+year2+"','dd/MM/yyyy') and to_date('31/01/"+year2+"','dd/MM/yyyy') and account_status !='R' group by branch)b10 on a.branch=b10.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m11 from JL_master_view where  open_date between to_date('01/02/"+year2+"','dd/MM/yyyy') and to_date('28/02/"+year2+"','dd/MM/yyyy') and account_status !='R' group by branch)b11 on a.branch=b11.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m12 from JL_master_view where  open_date between to_date('01/03/"+year2+"','dd/MM/yyyy') and to_date('31/03/"+year2+"','dd/MM/yyyy') and account_status !='R' group by branch)b12 on a.branch=b12.livebranch)main_qry order by main_qry.branch)k ";

											System.out.println(sql);

								return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
									
									SimpleBranch gl=new SimpleBranch();
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(3));  //targetAmt
									gl.setS142(rs.getDouble(4));  //targetAcheived
									
									gl.setS143(rs.getDouble(5));  //m1
									
									gl.setS144(rs.getDouble(6));  //m2
									gl.setS145(rs.getDouble(7));  //m3
									gl.setS146(rs.getDouble(8));  //m4
									gl.setS147(rs.getDouble(9));  //m5
									gl.setS148(rs.getDouble(10));  //m6
									gl.setS149(rs.getDouble(11));  //m7
									
									gl.setS150(rs.getDouble(12));  //m8
									gl.setS151(rs.getDouble(13));  //m9
									gl.setS152(rs.getDouble(14));  //m10
									gl.setS153(rs.getDouble(15));  //m11
									gl.setS154(rs.getDouble(16));  //m12
									
									
									//gl.setS32(rs.getString(10));  //percent %
									
									
									//18-05-2022
									gl.setS155(rs.getDouble(17));  //balance
									gl.setS32(rs.getString(18));  //percent %

									
									
									return gl;
								}
											 }     );
										}

						 
						 //14-05-2022
						 public List<SimpleBranch> getTargetReport_Branchwise_Yearly_ML(int year1,int year2)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											//14-05-2022
	//										String sql="select main_qry.* from (select a.branch,(select branch_name from branch_master where branch_code=branch)as Bname,(nvl(a.target_amount1,0))*12 as Target_Amount,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)+nvl(b5.achieved_m5,0)+nvl(b6.achieved_m6,0)+nvl(b7.achieved_m7,0)+nvl(b8.achieved_m8,0)+nvl(b9.achieved_m9,0)+nvl(b10.achieved_m10,0)+nvl(b11.achieved_m11,0)+nvl(b12.achieved_m12,0))as targetAchieved,nvl(b.achieved_m1,0) as m1_Acheived,nvl(b2.achieved_m2,0)as  m2_Acheived,nvl(b3.achieved_m3,0) as m3_Acheived,nvl(b4.achieved_m4,0) m4_Acheived,nvl(b5.achieved_m5,0) as m5_Acheived,nvl(b6.achieved_m6,0)as  m6_Acheived,nvl(b7.achieved_m7,0) as m7_Acheived,nvl(b8.achieved_m8,0) m8_Acheived,nvl(b9.achieved_m9,0) as m9_Acheived,nvl(b10.achieved_m10,0)as  m10_Acheived,nvl(b11.achieved_m11,0) as m11_Acheived,nvl(b12.achieved_m12,0) m12_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4) and year="+year1+" and Scheme_name='ML' group by branch)a left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from OL_Master_view3 where scheme_code='80001' and open_date between to_date('01/04/"+year1+"','dd/MM/yyyy') and to_date('30/04/"+year1+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m2 from OL_Master_view3 where scheme_code='80001' and  open_date between to_date('01/05/"+year1+"','dd/MM/yyyy') and to_date('31/05/"+year1+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m3 from OL_Master_view3 where scheme_code='80001' and  open_date between to_date('01/06/"+year1+"','dd/MM/yyyy') and to_date('30/06/"+year1+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m4 from OL_Master_view3 where scheme_code='80001' and  open_date between to_date('01/07/"+year1+"','dd/MM/yyyy') and to_date('31/07/"+year1+"','dd/MM/yyyy') group by branch)b4 on a.branch=b4.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m5 from OL_Master_view3 where scheme_code='80001' and  open_date between to_date('01/08/"+year1+"','dd/MM/yyyy') and to_date('31/08/"+year1+"','dd/MM/yyyy') group by branch)b5 on a.branch=b5.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m6 from OL_Master_view3 where scheme_code='80001' and  open_date between to_date('01/09/"+year1+"','dd/MM/yyyy') and to_date('30/09/"+year1+"','dd/MM/yyyy') group by branch)b6 on a.branch=b6.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m7 from OL_Master_view3 where scheme_code='80001' and  open_date between to_date('01/10/"+year1+"','dd/MM/yyyy') and to_date('31/10/"+year1+"','dd/MM/yyyy') group by branch)b7 on a.branch=b7.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m8 from OL_Master_view3 where scheme_code='80001' and  open_date between to_date('01/11/"+year1+"','dd/MM/yyyy') and to_date('30/11/"+year1+"','dd/MM/yyyy') group by branch)b8 on a.branch=b8.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m9 from OL_Master_view3 where scheme_code='80001' and  open_date between to_date('01/12/"+year1+"','dd/MM/yyyy') and to_date('31/12/"+year1+"','dd/MM/yyyy') group by branch)b9 on a.branch=b9.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m10 from OL_Master_view3 where scheme_code='80001' and  open_date between to_date('01/01/"+year2+"','dd/MM/yyyy') and to_date('31/01/"+year2+"','dd/MM/yyyy') group by branch)b10 on a.branch=b10.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m11 from OL_Master_view3 where scheme_code='80001' and  open_date between to_date('01/02/"+year2+"','dd/MM/yyyy') and to_date('28/02/"+year2+"','dd/MM/yyyy') group by branch)b11 on a.branch=b11.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m12 from OL_Master_view3 where scheme_code='80001' and  open_date between to_date('01/03/"+year2+"','dd/MM/yyyy') and to_date('31/03/"+year2+"','dd/MM/yyyy') group by branch)b12 on a.branch=b12.livebranch)main_qry order by main_qry.branch";

											//18-05-2022
											String sql="select k.*,case when (k.Target_Amount-k.targetAchieved)>0 then (k.Target_Amount-k.targetAchieved) else 0 end as balance,case when k.targetAchieved<> 0 and k.Target_Amount<>0 then (to_char (round(nvl((k.targetAchieved*100)/k.Target_Amount,0),2))) else '0.0' end as percen1 from (select main_qry.* from (select a.branch,(select branch_name from branch_master where branch_code=branch)as Bname,(nvl(a.target_amount1,0))*12 as Target_Amount,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)+nvl(b5.achieved_m5,0)+nvl(b6.achieved_m6,0)+nvl(b7.achieved_m7,0)+nvl(b8.achieved_m8,0)+nvl(b9.achieved_m9,0)+nvl(b10.achieved_m10,0)+nvl(b11.achieved_m11,0)+nvl(b12.achieved_m12,0))as targetAchieved,nvl(b.achieved_m1,0) as m1_Acheived,nvl(b2.achieved_m2,0)as  m2_Acheived,nvl(b3.achieved_m3,0) as m3_Acheived,nvl(b4.achieved_m4,0) m4_Acheived,nvl(b5.achieved_m5,0) as m5_Acheived,nvl(b6.achieved_m6,0)as  m6_Acheived,nvl(b7.achieved_m7,0) as m7_Acheived,nvl(b8.achieved_m8,0) m8_Acheived,nvl(b9.achieved_m9,0) as m9_Acheived,nvl(b10.achieved_m10,0)as  m10_Acheived,nvl(b11.achieved_m11,0) as m11_Acheived,nvl(b12.achieved_m12,0) m12_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4) and year="+year1+" and Scheme_name='ML' group by branch)a left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from OL_Master_view3 where scheme_code='80001' and open_date between to_date('01/04/"+year1+"','dd/MM/yyyy') and to_date('30/04/"+year1+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m2 from OL_Master_view3 where scheme_code='80001' and  open_date between to_date('01/05/"+year1+"','dd/MM/yyyy') and to_date('31/05/"+year1+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m3 from OL_Master_view3 where scheme_code='80001' and  open_date between to_date('01/06/"+year1+"','dd/MM/yyyy') and to_date('30/06/"+year1+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m4 from OL_Master_view3 where scheme_code='80001' and  open_date between to_date('01/07/"+year1+"','dd/MM/yyyy') and to_date('31/07/"+year1+"','dd/MM/yyyy') group by branch)b4 on a.branch=b4.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m5 from OL_Master_view3 where scheme_code='80001' and  open_date between to_date('01/08/"+year1+"','dd/MM/yyyy') and to_date('31/08/"+year1+"','dd/MM/yyyy') group by branch)b5 on a.branch=b5.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m6 from OL_Master_view3 where scheme_code='80001' and  open_date between to_date('01/09/"+year1+"','dd/MM/yyyy') and to_date('30/09/"+year1+"','dd/MM/yyyy') group by branch)b6 on a.branch=b6.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m7 from OL_Master_view3 where scheme_code='80001' and  open_date between to_date('01/10/"+year1+"','dd/MM/yyyy') and to_date('31/10/"+year1+"','dd/MM/yyyy') group by branch)b7 on a.branch=b7.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m8 from OL_Master_view3 where scheme_code='80001' and  open_date between to_date('01/11/"+year1+"','dd/MM/yyyy') and to_date('30/11/"+year1+"','dd/MM/yyyy') group by branch)b8 on a.branch=b8.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m9 from OL_Master_view3 where scheme_code='80001' and  open_date between to_date('01/12/"+year1+"','dd/MM/yyyy') and to_date('31/12/"+year1+"','dd/MM/yyyy') group by branch)b9 on a.branch=b9.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m10 from OL_Master_view3 where scheme_code='80001' and  open_date between to_date('01/01/"+year2+"','dd/MM/yyyy') and to_date('31/01/"+year2+"','dd/MM/yyyy') group by branch)b10 on a.branch=b10.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m11 from OL_Master_view3 where scheme_code='80001' and  open_date between to_date('01/02/"+year2+"','dd/MM/yyyy') and to_date('28/02/"+year2+"','dd/MM/yyyy') group by branch)b11 on a.branch=b11.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m12 from OL_Master_view3 where scheme_code='80001' and  open_date between to_date('01/03/"+year2+"','dd/MM/yyyy') and to_date('31/03/"+year2+"','dd/MM/yyyy') group by branch)b12 on a.branch=b12.livebranch)main_qry order by main_qry.branch)k";
											System.out.println(sql);


								return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
									
									SimpleBranch gl=new SimpleBranch();
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(3));  //targetAmt
									gl.setS142(rs.getDouble(4));  //targetAcheived
									
									gl.setS143(rs.getDouble(5));  //m1
									
									gl.setS144(rs.getDouble(6));  //m2
									gl.setS145(rs.getDouble(7));  //m3
									gl.setS146(rs.getDouble(8));  //m4
									gl.setS147(rs.getDouble(9));  //m5
									gl.setS148(rs.getDouble(10));  //m6
									gl.setS149(rs.getDouble(11));  //m7
									
									gl.setS150(rs.getDouble(12));  //m8
									gl.setS151(rs.getDouble(13));  //m9
									gl.setS152(rs.getDouble(14));  //m10
									gl.setS153(rs.getDouble(15));  //m11
									gl.setS154(rs.getDouble(16));  //m12
									
									
									//gl.setS32(rs.getString(10));  //percent %
									
									//17-05-2022
									gl.setS155(rs.getDouble(17));  //balance
									gl.setS32(rs.getString(18));  //percent %

							
									
									
									return gl;
								}
											 }     );
										}

						 
						 //14-05-2022
						 public List<SimpleBranch> getTargetReport_Branchwise_Yearly_DL(int year1,int year2)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											//14-05-2022
	//										String sql="select main_qry.* from (select a.branch,(select branch_name from branch_master where branch_code=branch)as Bname,(nvl(a.target_amount1,0))*12 as Target_Amount,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)+nvl(b5.achieved_m5,0)+nvl(b6.achieved_m6,0)+nvl(b7.achieved_m7,0)+nvl(b8.achieved_m8,0)+nvl(b9.achieved_m9,0)+nvl(b10.achieved_m10,0)+nvl(b11.achieved_m11,0)+nvl(b12.achieved_m12,0))as targetAchieved,nvl(b.achieved_m1,0) as m1_Acheived,nvl(b2.achieved_m2,0)as  m2_Acheived,nvl(b3.achieved_m3,0) as m3_Acheived,nvl(b4.achieved_m4,0) m4_Acheived,nvl(b5.achieved_m5,0) as m5_Acheived,nvl(b6.achieved_m6,0)as  m6_Acheived,nvl(b7.achieved_m7,0) as m7_Acheived,nvl(b8.achieved_m8,0) m8_Acheived,nvl(b9.achieved_m9,0) as m9_Acheived,nvl(b10.achieved_m10,0)as  m10_Acheived,nvl(b11.achieved_m11,0) as m11_Acheived,nvl(b12.achieved_m12,0) m12_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4) and year="+year1+" and Scheme_name='ML' group by branch)a left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from OL_Master_view3 where scheme_code='70010' and open_date between to_date('01/04/"+year1+"','dd/MM/yyyy') and to_date('30/04/"+year1+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m2 from OL_Master_view3 where scheme_code='70010' and  open_date between to_date('01/05/"+year1+"','dd/MM/yyyy') and to_date('31/05/"+year1+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m3 from OL_Master_view3 where scheme_code='70010' and  open_date between to_date('01/06/"+year1+"','dd/MM/yyyy') and to_date('30/06/"+year1+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m4 from OL_Master_view3 where scheme_code='70010' and  open_date between to_date('01/07/"+year1+"','dd/MM/yyyy') and to_date('31/07/"+year1+"','dd/MM/yyyy') group by branch)b4 on a.branch=b4.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m5 from OL_Master_view3 where scheme_code='70010' and  open_date between to_date('01/08/"+year1+"','dd/MM/yyyy') and to_date('31/08/"+year1+"','dd/MM/yyyy') group by branch)b5 on a.branch=b5.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m6 from OL_Master_view3 where scheme_code='70010' and  open_date between to_date('01/09/"+year1+"','dd/MM/yyyy') and to_date('30/09/"+year1+"','dd/MM/yyyy') group by branch)b6 on a.branch=b6.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m7 from OL_Master_view3 where scheme_code='70010' and  open_date between to_date('01/10/"+year1+"','dd/MM/yyyy') and to_date('31/10/"+year1+"','dd/MM/yyyy') group by branch)b7 on a.branch=b7.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m8 from OL_Master_view3 where scheme_code='70010' and  open_date between to_date('01/11/"+year1+"','dd/MM/yyyy') and to_date('30/11/"+year1+"','dd/MM/yyyy') group by branch)b8 on a.branch=b8.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m9 from OL_Master_view3 where scheme_code='70010' and  open_date between to_date('01/12/"+year1+"','dd/MM/yyyy') and to_date('31/12/"+year1+"','dd/MM/yyyy') group by branch)b9 on a.branch=b9.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m10 from OL_Master_view3 where scheme_code='70010' and  open_date between to_date('01/01/"+year2+"','dd/MM/yyyy') and to_date('31/01/"+year2+"','dd/MM/yyyy') group by branch)b10 on a.branch=b10.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m11 from OL_Master_view3 where scheme_code='70010' and  open_date between to_date('01/02/"+year2+"','dd/MM/yyyy') and to_date('28/02/"+year2+"','dd/MM/yyyy') group by branch)b11 on a.branch=b11.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m12 from OL_Master_view3 where scheme_code='70010' and  open_date between to_date('01/03/"+year2+"','dd/MM/yyyy') and to_date('31/03/"+year2+"','dd/MM/yyyy') group by branch)b12 on a.branch=b12.livebranch)main_qry order by main_qry.branch";

											//18-05-2022
	//										String sql="select k.*,case when (k.Target_Amount-k.targetAchieved)>0 then (k.Target_Amount-k.targetAchieved) else 0 end as balance,case when k.targetAchieved<> 0 and k.Target_Amount<>0 then (to_char (round(nvl((k.targetAchieved*100)/k.Target_Amount,0),2))) else '0.0' end as percen1 from (select main_qry.* from (select a.branch,(select branch_name from branch_master where branch_code=branch)as Bname,(nvl(a.target_amount1,0))*12 as Target_Amount,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)+nvl(b5.achieved_m5,0)+nvl(b6.achieved_m6,0)+nvl(b7.achieved_m7,0)+nvl(b8.achieved_m8,0)+nvl(b9.achieved_m9,0)+nvl(b10.achieved_m10,0)+nvl(b11.achieved_m11,0)+nvl(b12.achieved_m12,0))as targetAchieved,nvl(b.achieved_m1,0) as m1_Acheived,nvl(b2.achieved_m2,0)as  m2_Acheived,nvl(b3.achieved_m3,0) as m3_Acheived,nvl(b4.achieved_m4,0) m4_Acheived,nvl(b5.achieved_m5,0) as m5_Acheived,nvl(b6.achieved_m6,0)as  m6_Acheived,nvl(b7.achieved_m7,0) as m7_Acheived,nvl(b8.achieved_m8,0) m8_Acheived,nvl(b9.achieved_m9,0) as m9_Acheived,nvl(b10.achieved_m10,0)as  m10_Acheived,nvl(b11.achieved_m11,0) as m11_Acheived,nvl(b12.achieved_m12,0) m12_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4) and year="+year1+" and Scheme_name='ML' group by branch)a left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from OL_Master_view3 where scheme_code='70010' and open_date between to_date('01/04/"+year1+"','dd/MM/yyyy') and to_date('30/04/"+year1+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m2 from OL_Master_view3 where scheme_code='70010' and  open_date between to_date('01/05/"+year1+"','dd/MM/yyyy') and to_date('31/05/"+year1+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m3 from OL_Master_view3 where scheme_code='70010' and  open_date between to_date('01/06/"+year1+"','dd/MM/yyyy') and to_date('30/06/"+year1+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m4 from OL_Master_view3 where scheme_code='70010' and  open_date between to_date('01/07/"+year1+"','dd/MM/yyyy') and to_date('31/07/"+year1+"','dd/MM/yyyy') group by branch)b4 on a.branch=b4.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m5 from OL_Master_view3 where scheme_code='70010' and  open_date between to_date('01/08/"+year1+"','dd/MM/yyyy') and to_date('31/08/"+year1+"','dd/MM/yyyy') group by branch)b5 on a.branch=b5.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m6 from OL_Master_view3 where scheme_code='70010' and  open_date between to_date('01/09/"+year1+"','dd/MM/yyyy') and to_date('30/09/"+year1+"','dd/MM/yyyy') group by branch)b6 on a.branch=b6.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m7 from OL_Master_view3 where scheme_code='70010' and  open_date between to_date('01/10/"+year1+"','dd/MM/yyyy') and to_date('31/10/"+year1+"','dd/MM/yyyy') group by branch)b7 on a.branch=b7.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m8 from OL_Master_view3 where scheme_code='70010' and  open_date between to_date('01/11/"+year1+"','dd/MM/yyyy') and to_date('30/11/"+year1+"','dd/MM/yyyy') group by branch)b8 on a.branch=b8.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m9 from OL_Master_view3 where scheme_code='70010' and  open_date between to_date('01/12/"+year1+"','dd/MM/yyyy') and to_date('31/12/"+year1+"','dd/MM/yyyy') group by branch)b9 on a.branch=b9.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m10 from OL_Master_view3 where scheme_code='70010' and  open_date between to_date('01/01/"+year2+"','dd/MM/yyyy') and to_date('31/01/"+year2+"','dd/MM/yyyy') group by branch)b10 on a.branch=b10.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m11 from OL_Master_view3 where scheme_code='70010' and  open_date between to_date('01/02/"+year2+"','dd/MM/yyyy') and to_date('28/02/"+year2+"','dd/MM/yyyy') group by branch)b11 on a.branch=b11.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m12 from OL_Master_view3 where scheme_code='70010' and  open_date between to_date('01/03/"+year2+"','dd/MM/yyyy') and to_date('31/03/"+year2+"','dd/MM/yyyy') group by branch)b12 on a.branch=b12.livebranch)main_qry order by main_qry.branch)k";
											
											//06-05-2024
	//										String sql="select k.*,case when (k.Target_Amount-k.targetAchieved)>0 then (k.Target_Amount-k.targetAchieved) else 0 end as balance,case when k.targetAchieved<> 0 and k.Target_Amount<>0 then (to_char (round(nvl((k.targetAchieved*100)/k.Target_Amount,0),2))) else '0.0' end as percen1 from (select main_qry.* from (select a.branch,(select branch_name from branch_master where branch_code=branch)as Bname,(nvl(a.target_amount1,0))*12 as Target_Amount,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)+nvl(b5.achieved_m5,0)+nvl(b6.achieved_m6,0)+nvl(b7.achieved_m7,0)+nvl(b8.achieved_m8,0)+nvl(b9.achieved_m9,0)+nvl(b10.achieved_m10,0)+nvl(b11.achieved_m11,0)+nvl(b12.achieved_m12,0))as targetAchieved,nvl(b.achieved_m1,0) as m1_Acheived,nvl(b2.achieved_m2,0)as  m2_Acheived,nvl(b3.achieved_m3,0) as m3_Acheived,nvl(b4.achieved_m4,0) m4_Acheived,nvl(b5.achieved_m5,0) as m5_Acheived,nvl(b6.achieved_m6,0)as  m6_Acheived,nvl(b7.achieved_m7,0) as m7_Acheived,nvl(b8.achieved_m8,0) m8_Acheived,nvl(b9.achieved_m9,0) as m9_Acheived,nvl(b10.achieved_m10,0)as  m10_Acheived,nvl(b11.achieved_m11,0) as m11_Acheived,nvl(b12.achieved_m12,0) m12_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4) and year="+year1+" and Scheme_name='ML' group by branch)a left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from OL_Master_view3 where Scheme_code !='80001' and open_date between to_date('01/04/"+year1+"','dd/MM/yyyy') and to_date('30/04/"+year1+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m2 from OL_Master_view3 where Scheme_code !='80001' and  open_date between to_date('01/05/"+year1+"','dd/MM/yyyy') and to_date('31/05/"+year1+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m3 from OL_Master_view3 where Scheme_code !='80001' and  open_date between to_date('01/06/"+year1+"','dd/MM/yyyy') and to_date('30/06/"+year1+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m4 from OL_Master_view3 where Scheme_code !='80001' and  open_date between to_date('01/07/"+year1+"','dd/MM/yyyy') and to_date('31/07/"+year1+"','dd/MM/yyyy') group by branch)b4 on a.branch=b4.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m5 from OL_Master_view3 where Scheme_code !='80001' and  open_date between to_date('01/08/"+year1+"','dd/MM/yyyy') and to_date('31/08/"+year1+"','dd/MM/yyyy') group by branch)b5 on a.branch=b5.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m6 from OL_Master_view3 where Scheme_code !='80001' and  open_date between to_date('01/09/"+year1+"','dd/MM/yyyy') and to_date('30/09/"+year1+"','dd/MM/yyyy') group by branch)b6 on a.branch=b6.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m7 from OL_Master_view3 where Scheme_code !='80001' and  open_date between to_date('01/10/"+year1+"','dd/MM/yyyy') and to_date('31/10/"+year1+"','dd/MM/yyyy') group by branch)b7 on a.branch=b7.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m8 from OL_Master_view3 where Scheme_code !='80001' and  open_date between to_date('01/11/"+year1+"','dd/MM/yyyy') and to_date('30/11/"+year1+"','dd/MM/yyyy') group by branch)b8 on a.branch=b8.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m9 from OL_Master_view3 where Scheme_code !='80001' and  open_date between to_date('01/12/"+year1+"','dd/MM/yyyy') and to_date('31/12/"+year1+"','dd/MM/yyyy') group by branch)b9 on a.branch=b9.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m10 from OL_Master_view3 where Scheme_code !='80001' and  open_date between to_date('01/01/"+year2+"','dd/MM/yyyy') and to_date('31/01/"+year2+"','dd/MM/yyyy') group by branch)b10 on a.branch=b10.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m11 from OL_Master_view3 where Scheme_code !='80001' and  open_date between to_date('01/02/"+year2+"','dd/MM/yyyy') and to_date('28/02/"+year2+"','dd/MM/yyyy') group by branch)b11 on a.branch=b11.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m12 from OL_Master_view3 where Scheme_code !='80001' and  open_date between to_date('01/03/"+year2+"','dd/MM/yyyy') and to_date('31/03/"+year2+"','dd/MM/yyyy') group by branch)b12 on a.branch=b12.livebranch)main_qry order by main_qry.branch)k";
	//										String sql="select k.*,case when (k.Target_Amount-k.targetAchieved)>0 then (k.Target_Amount-k.targetAchieved) else 0 end as balance,case when k.targetAchieved<> 0 and k.Target_Amount<>0 then (to_char (round(nvl((k.targetAchieved*100)/k.Target_Amount,0),2))) else '0.0' end as percen1 from (select main_qry.* from (select a.branch,(select branch_name from branch_master where branch_code=branch)as Bname,(nvl(a.target_amount1,0))*12 as Target_Amount,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)+nvl(b5.achieved_m5,0)+nvl(b6.achieved_m6,0)+nvl(b7.achieved_m7,0)+nvl(b8.achieved_m8,0)+nvl(b9.achieved_m9,0)+nvl(b10.achieved_m10,0)+nvl(b11.achieved_m11,0)+nvl(b12.achieved_m12,0))as targetAchieved,nvl(b.achieved_m1,0) as m1_Acheived,nvl(b2.achieved_m2,0)as  m2_Acheived,nvl(b3.achieved_m3,0) as m3_Acheived,nvl(b4.achieved_m4,0) m4_Acheived,nvl(b5.achieved_m5,0) as m5_Acheived,nvl(b6.achieved_m6,0)as  m6_Acheived,nvl(b7.achieved_m7,0) as m7_Acheived,nvl(b8.achieved_m8,0) m8_Acheived,nvl(b9.achieved_m9,0) as m9_Acheived,nvl(b10.achieved_m10,0)as  m10_Acheived,nvl(b11.achieved_m11,0) as m11_Acheived,nvl(b12.achieved_m12,0) m12_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4) and year="+year1+" and Scheme_name='ML' group by branch)a left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from OL_Master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and open_date between to_date('01/04/"+year1+"','dd/MM/yyyy') and to_date('30/04/"+year1+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m2 from OL_Master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and  open_date between to_date('01/05/"+year1+"','dd/MM/yyyy') and to_date('31/05/"+year1+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m3 from OL_Master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and  open_date between to_date('01/06/"+year1+"','dd/MM/yyyy') and to_date('30/06/"+year1+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m4 from OL_Master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and  open_date between to_date('01/07/"+year1+"','dd/MM/yyyy') and to_date('31/07/"+year1+"','dd/MM/yyyy') group by branch)b4 on a.branch=b4.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m5 from OL_Master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and  open_date between to_date('01/08/"+year1+"','dd/MM/yyyy') and to_date('31/08/"+year1+"','dd/MM/yyyy') group by branch)b5 on a.branch=b5.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m6 from OL_Master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and  open_date between to_date('01/09/"+year1+"','dd/MM/yyyy') and to_date('30/09/"+year1+"','dd/MM/yyyy') group by branch)b6 on a.branch=b6.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m7 from OL_Master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and  open_date between to_date('01/10/"+year1+"','dd/MM/yyyy') and to_date('31/10/"+year1+"','dd/MM/yyyy') group by branch)b7 on a.branch=b7.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m8 from OL_Master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and  open_date between to_date('01/11/"+year1+"','dd/MM/yyyy') and to_date('30/11/"+year1+"','dd/MM/yyyy') group by branch)b8 on a.branch=b8.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m9 from OL_Master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and  open_date between to_date('01/12/"+year1+"','dd/MM/yyyy') and to_date('31/12/"+year1+"','dd/MM/yyyy') group by branch)b9 on a.branch=b9.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m10 from OL_Master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and  open_date between to_date('01/01/"+year2+"','dd/MM/yyyy') and to_date('31/01/"+year2+"','dd/MM/yyyy') group by branch)b10 on a.branch=b10.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m11 from OL_Master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and  open_date between to_date('01/02/"+year2+"','dd/MM/yyyy') and to_date('28/02/"+year2+"','dd/MM/yyyy') group by branch)b11 on a.branch=b11.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m12 from OL_Master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and  open_date between to_date('01/03/"+year2+"','dd/MM/yyyy') and to_date('31/03/"+year2+"','dd/MM/yyyy') group by branch)b12 on a.branch=b12.livebranch)main_qry order by main_qry.branch)k";
											String sql="select k.*,case when (k.Target_Amount-k.targetAchieved)>0 then (k.Target_Amount-k.targetAchieved) else 0 end as balance,case when k.targetAchieved<> 0 and k.Target_Amount<>0 then (to_char (round(nvl((k.targetAchieved*100)/k.Target_Amount,0),2))) else '0.0' end as percen1 from (select main_qry.* from (select a.branch,(select branch_name from branch_master where branch_code=branch)as Bname,(nvl(a.target_amount1,0))*12 as Target_Amount,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)+nvl(b5.achieved_m5,0)+nvl(b6.achieved_m6,0)+nvl(b7.achieved_m7,0)+nvl(b8.achieved_m8,0)+nvl(b9.achieved_m9,0)+nvl(b10.achieved_m10,0)+nvl(b11.achieved_m11,0)+nvl(b12.achieved_m12,0))as targetAchieved,nvl(b.achieved_m1,0) as m1_Acheived,nvl(b2.achieved_m2,0)as  m2_Acheived,nvl(b3.achieved_m3,0) as m3_Acheived,nvl(b4.achieved_m4,0) m4_Acheived,nvl(b5.achieved_m5,0) as m5_Acheived,nvl(b6.achieved_m6,0)as  m6_Acheived,nvl(b7.achieved_m7,0) as m7_Acheived,nvl(b8.achieved_m8,0) m8_Acheived,nvl(b9.achieved_m9,0) as m9_Acheived,nvl(b10.achieved_m10,0)as  m10_Acheived,nvl(b11.achieved_m11,0) as m11_Acheived,nvl(b12.achieved_m12,0) m12_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4) and year="+year1+" and Scheme_name='DL' group by branch)a left join (select branch as livebranch,nvl(sum(Loan_amount),0) as achieved_m1 from OL_Master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and open_date between to_date('01/04/"+year1+"','dd/MM/yyyy') and to_date('30/04/"+year1+"','dd/MM/yyyy') group by branch)b on a.branch=b.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m2 from OL_Master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and  open_date between to_date('01/05/"+year1+"','dd/MM/yyyy') and to_date('31/05/"+year1+"','dd/MM/yyyy') group by branch)b2 on a.branch=b2.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m3 from OL_Master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and  open_date between to_date('01/06/"+year1+"','dd/MM/yyyy') and to_date('30/06/"+year1+"','dd/MM/yyyy') group by branch)b3 on a.branch=b3.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m4 from OL_Master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and  open_date between to_date('01/07/"+year1+"','dd/MM/yyyy') and to_date('31/07/"+year1+"','dd/MM/yyyy') group by branch)b4 on a.branch=b4.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m5 from OL_Master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and  open_date between to_date('01/08/"+year1+"','dd/MM/yyyy') and to_date('31/08/"+year1+"','dd/MM/yyyy') group by branch)b5 on a.branch=b5.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m6 from OL_Master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and  open_date between to_date('01/09/"+year1+"','dd/MM/yyyy') and to_date('30/09/"+year1+"','dd/MM/yyyy') group by branch)b6 on a.branch=b6.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m7 from OL_Master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and  open_date between to_date('01/10/"+year1+"','dd/MM/yyyy') and to_date('31/10/"+year1+"','dd/MM/yyyy') group by branch)b7 on a.branch=b7.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m8 from OL_Master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and  open_date between to_date('01/11/"+year1+"','dd/MM/yyyy') and to_date('30/11/"+year1+"','dd/MM/yyyy') group by branch)b8 on a.branch=b8.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m9 from OL_Master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and  open_date between to_date('01/12/"+year1+"','dd/MM/yyyy') and to_date('31/12/"+year1+"','dd/MM/yyyy') group by branch)b9 on a.branch=b9.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m10 from OL_Master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and  open_date between to_date('01/01/"+year2+"','dd/MM/yyyy') and to_date('31/01/"+year2+"','dd/MM/yyyy') group by branch)b10 on a.branch=b10.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m11 from OL_Master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and  open_date between to_date('01/02/"+year2+"','dd/MM/yyyy') and to_date('28/02/"+year2+"','dd/MM/yyyy') group by branch)b11 on a.branch=b11.livebranch left join (select branch as livebranch,nvl(sum(Loan_Amount),0) as achieved_m12 from OL_Master_view3 where Scheme_code in ('70010','70030') and account_status !='R' and  open_date between to_date('01/03/"+year2+"','dd/MM/yyyy') and to_date('31/03/"+year2+"','dd/MM/yyyy') group by branch)b12 on a.branch=b12.livebranch)main_qry order by main_qry.branch)k";

											System.out.println(sql);
					
								return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
									
									SimpleBranch gl=new SimpleBranch();
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(3));  //targetAmt
									gl.setS142(rs.getDouble(4));  //targetAcheived
									
									gl.setS143(rs.getDouble(5));  //m1
									
									gl.setS144(rs.getDouble(6));  //m2
									gl.setS145(rs.getDouble(7));  //m3
									gl.setS146(rs.getDouble(8));  //m4
									gl.setS147(rs.getDouble(9));  //m5
									gl.setS148(rs.getDouble(10));  //m6
									gl.setS149(rs.getDouble(11));  //m7
									
									gl.setS150(rs.getDouble(12));  //m8
									gl.setS151(rs.getDouble(13));  //m9
									gl.setS152(rs.getDouble(14));  //m10
									gl.setS153(rs.getDouble(15));  //m11
									gl.setS154(rs.getDouble(16));  //m12
									
									
									//gl.setS32(rs.getString(10));  //percent %
									
									
									//18-05-2022
									gl.setS155(rs.getDouble(17));  //balance
									gl.setS32(rs.getString(18));  //percent %

									
									
									return gl;
								}
											 }     );
										}

						 
						 
						 //Low Cost  //20-05-2022 
						 public List<SimpleBranch> getTargetReport_Branchwise_Monthly_all_Lowcost(String FromDate,String ToDate,int Month,int Year,int BCode)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											//20-05-2022 all branches
											//String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount,nvl(b.achieved,0) as acheived,case when (a.target_amount-nvl(b.achieved,0))>0 then (a.target_amount-nvl(b.achieved,0)) else 0 end as targerbalance,to_char(nvl(round((b.achieved*100/a.target_Amount),2),0.00)) as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('"+FromDate+"','dd/mm/yyyy'),'MON-yyyy'),'0') AS month1 from ( select branch ,month , year,amount as target_amount,SUBSTR('0'||month,-2,2) as month1 from target_master where month="+Month+" and year="+Year+" and scheme_name='LOWCOST')a  left join (select main_qry2.branch,sum(main_qry2.achieved)as achieved from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b on a.branch=b.branch order by a.branch" ;

											//03-05-2024
											//select main_qry2.branch,sum(main_qry2.achieved)as achieved from (select a.branch,nvl(b.achieved,0) as Achieved from (select Account_no,substr(Account_no,0,3) as branch from RD_view )a left join (select Account_no,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_notgl_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy')   group by account_no)b  on a.Account_no=b.Account_no )main_qry2 group by main_qry2.branch order by main_qry2.branch
											String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount,nvl(b.achieved,0) as acheived,case when (a.target_amount-nvl(b.achieved,0))>0 then (a.target_amount-nvl(b.achieved,0)) else 0 end as targerbalance,to_char(nvl(round((b.achieved*100/a.target_Amount),2),0.00)) as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('"+FromDate+"','dd/mm/yyyy'),'MON-yyyy'),'0') AS month1 from ( select branch ,month , year,amount as target_amount,SUBSTR('0'||month,-2,2) as month1 from target_master where month="+Month+" and year="+Year+" and scheme_name='LOWCOST')a  left join (select main_qry2.branch,sum(main_qry2.achieved)as achieved from (select a.branch,nvl(b.achieved,0) as Achieved from (select Account_no,substr(Account_no,0,3) as branch from SBCA_view )a left join (select Account_no,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_notgl_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy')   group by account_no)b  on a.Account_no=b.Account_no )main_qry2 group by main_qry2.branch order by main_qry2.branch )b on a.branch=b.branch order by a.branch" ;

											System.out.println(sql);


								return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
									
									SimpleBranch gl=new SimpleBranch();
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(3));  //targetAmt
									gl.setS142(rs.getDouble(4));  //Acheived
									gl.setS13(rs.getFloat(5));  //balance
									
									gl.setS32(rs.getString(6));  //percentage
									gl.setS33(rs.getString(7));  //month
								
									
							
									
									
									return gl;
								}
											 }     );
										}


						 
						 //RD 02-05-2024
						 public List<SimpleBranch> getTargetReport_Branchwise_Monthly_all_RD(String FromDate,String ToDate,int Month,int Year,int BCode)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											//20-05-2022 all branches
											//String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount,nvl(b.achieved,0) as acheived,case when (a.target_amount-nvl(b.achieved,0))>0 then (a.target_amount-nvl(b.achieved,0)) else 0 end as targerbalance,to_char(nvl(round((b.achieved*100/a.target_Amount),2),0.00)) as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('"+FromDate+"','dd/mm/yyyy'),'MON-yyyy'),'0') AS month1 from ( select branch ,month , year,amount as target_amount,SUBSTR('0'||month,-2,2) as month1 from target_master where month="+Month+" and year="+Year+" and scheme_name='RD')a  left join (select main_qry2.branch,sum(main_qry2.achieved)as achieved from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b on a.branch=b.branch order by a.branch" ;

											
											//03-05-2024 new logic all branches
											//String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount,nvl(b.achieved,0) as acheived,case when (a.target_amount-nvl(b.achieved,0))>0 then (a.target_amount-nvl(b.achieved,0)) else 0 end as targerbalance,to_char(nvl(round((b.achieved*100/a.target_Amount),2),0.00)) as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('"+FromDate+"','dd/mm/yyyy'),'MON-yyyy'),'0') AS month1 from ( select branch ,month , year,amount as target_amount,SUBSTR('0'||month,-2,2) as month1 from target_master where month="+Month+" and year="+Year+" and scheme_name='RD')a  left join (select main_qry2.branch,sum(main_qry2.achieved)as achieved from (select a.branch,nvl(b.achieved,0) as Achieved from (select Account_no,substr(Account_no,0,3) as branch from RD_view )a left join (select Account_no,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_notgl_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy')   group by account_no)b  on a.Account_no=b.Account_no )main_qry2 group by main_qry2.branch order by main_qry2.branch)b on a.branch=b.branch order by a.branch" ;

											//03-05-2024 new logic all branches
											String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount,nvl(b.achieved,0) as acheived,case when (a.target_amount-nvl(b.achieved,0))>0 then (a.target_amount-nvl(b.achieved,0)) else 0 end as targerbalance,to_char(nvl(round((b.achieved*100/a.target_Amount),2),0.00)) as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('"+FromDate+"','dd/mm/yyyy'),'MON-yyyy'),'0') AS month1 from ( select branch ,month , year,amount as target_amount,SUBSTR('0'||month,-2,2) as month1 from target_master where month="+Month+" and year="+Year+" and scheme_name='RD')a  left join (Select Branch,sum(Deposit_Amount) as achieved from RD_Master_View_C where open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by Branch)b on a.branch=b.branch order by a.branch" ;

											
											System.out.println(sql);


								return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
						
									SimpleBranch gl=new SimpleBranch();
												SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(3));  //targetAmt
									gl.setS142(rs.getDouble(4));  //Acheived
									gl.setS13(rs.getFloat(5));  //balance
									
									gl.setS32(rs.getString(6));  //percentage
									gl.setS33(rs.getString(7));  //month
								
									
							
									
									
									return gl;
								}
											 }     );
										}


						 
						 
						 //20-05-2022 LOWCOST
						 public List<SimpleBranch> getTargetReport_Branchwise_Quarterly_all_LOWCOST(String FromDate,String Date2,String Date3,String Date4,String Date5,String ToDate,String PeriodMonth,int year1,int BCode)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											//20-05-2022 //particular branch
											//String sql="	select k.* from ( select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,case when ((a.target_amount/3)-nvl(b.achieved_m1,0)) > 0 then ((a.target_amount/3)-nvl(b.achieved_m1,0)) else 0 end as bal1,to_char(round((b.achieved_m1)*100/(a.target_amount/3),2)||' %') as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,case when ((a.target_amount/3)-nvl(b2.achieved_m2,0))>0 then ((a.target_amount/3)-nvl(b2.achieved_m2,0)) else 0 end as bal2,to_char(round((b2.achieved_m2)*100/(a.target_amount/3),2)||' %') as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,case when ((a.target_amount/3)-nvl(b3.achieved_m3,0))>0 then ((a.target_amount/3)-nvl(b3.achieved_m3,0)) else 0 end as bal3,to_char(round((b3.achieved_m3)*100/(a.target_amount/3),2)||' %') as acheived_per3,case when (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))>0 then (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)) else 0 end as targerbalance,to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00) ||'%') as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" and scheme_name='LOWCOST' group by branch)a left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m1 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch     )b on a.branch=b.branch   left join (   select main_qry2.branch,sum(main_qry2.achieved)as achieved_m2 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b2 on a.branch=b2.branch  left join   (     select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m3 from fd_master_view where Account_Status='A' and open_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch     select main_qry2.branch,sum(main_qry2.achieved)as achieved_m3 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b3 on a.branch=b3.livebranch  )k where  k.branch="+BCode+" order by k.branch";
										    //21-05-2022
											//String sql="select k.* from (select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,case when ((a.target_amount/3)-nvl(b.achieved_m1,0)) > 0 then ((a.target_amount/3)-nvl(b.achieved_m1,0)) else 0 end as bal1,to_char(round((b.achieved_m1)*100/(a.target_amount/3),2)||' %') as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,case when ((a.target_amount/3)-nvl(b2.achieved_m2,0))>0 then ((a.target_amount/3)-nvl(b2.achieved_m2,0)) else 0 end as bal2,to_char(round((b2.achieved_m2)*100/(a.target_amount/3),2)||' %') as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,case when ((a.target_amount/3)-nvl(b3.achieved_m3,0))>0 then ((a.target_amount/3)-nvl(b3.achieved_m3,0)) else 0 end as bal3,to_char(round((b3.achieved_m3)*100/(a.target_amount/3),2)||' %') as acheived_per3,case when (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))>0 then (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)) else 0 end as targerbalance,to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00) ||'%') as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" and scheme_name='LOWCOST' group by branch)a left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m1 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch  )b on a.branch=b.branch  left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m2 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b2 on a.branch=b2.branch left join (      select main_qry2.branch,sum(main_qry2.achieved)as achieved_m3 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b3 on a.branch=b3.branch )k where  k.branch="+BCode+" order by k.branch";

										    
										    //21-05-2022 //all
											//String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,case when ((a.target_amount/3)-nvl(b.achieved_m1,0)) > 0 then ((a.target_amount/3)-nvl(b.achieved_m1,0)) else 0 end as bal1,to_char(round((b.achieved_m1)*100/(a.target_amount/3),2)||' %') as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,case when ((a.target_amount/3)-nvl(b2.achieved_m2,0))>0 then ((a.target_amount/3)-nvl(b2.achieved_m2,0)) else 0 end as bal2,to_char(round((b2.achieved_m2)*100/(a.target_amount/3),2)||' %') as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,case when ((a.target_amount/3)-nvl(b3.achieved_m3,0))>0 then ((a.target_amount/3)-nvl(b3.achieved_m3,0)) else 0 end as bal3,to_char(round((b3.achieved_m3)*100/(a.target_amount/3),2)||' %') as acheived_per3,case when (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))>0 then (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)) else 0 end as targerbalance,to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00) ||'%') as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" and scheme_name='LOWCOST' group by branch)a left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m1 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch  )b on a.branch=b.branch  left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m2 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b2 on a.branch=b2.branch left join (      select main_qry2.branch,sum(main_qry2.achieved)as achieved_m3 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b3 on a.branch=b3.branch";
										   
											//07-06-2022 acheived %
											String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,case when ((a.target_amount/3)-nvl(b.achieved_m1,0)) > 0 then ((a.target_amount/3)-nvl(b.achieved_m1,0)) else 0 end as bal1,to_char(nvl(round((b.achieved_m1)*100/(a.target_amount/3),2),0)) as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,case when ((a.target_amount/3)-nvl(b2.achieved_m2,0))>0 then ((a.target_amount/3)-nvl(b2.achieved_m2,0)) else 0 end as bal2,to_char(nvl(round((b2.achieved_m2)*100/(a.target_amount/3),2),0)) as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,case when ((a.target_amount/3)-nvl(b3.achieved_m3,0))>0 then ((a.target_amount/3)-nvl(b3.achieved_m3,0)) else 0 end as bal3,to_char(nvl(round((b3.achieved_m3)*100/(a.target_amount/3),2),0)) as acheived_per3,case when (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))>0 then (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)) else 0 end as targerbalance,to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00)) as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" and scheme_name='LOWCOST' group by branch)a left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m1 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch  )b on a.branch=b.branch  left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m2 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b2 on a.branch=b2.branch left join (      select main_qry2.branch,sum(main_qry2.achieved)as achieved_m3 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b3 on a.branch=b3.branch order by b";

				System.out.println(sql);
								return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
									
									SimpleBranch gl=new SimpleBranch();
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(3));  //targetAmt
									gl.setS142(rs.getDouble(4));  //Acheived1
									gl.setS143(rs.getDouble(5));  //bal1
									
									gl.setS144(rs.getDouble(7));  //Acheived2
									gl.setS145(rs.getDouble(8));  //bal2
									gl.setS146(rs.getDouble(10));  //Acheived3
									gl.setS147(rs.getDouble(11));  //bal3
									
									gl.setS32(rs.getString(6));  //m1 %
									gl.setS33(rs.getString(9));  //m2 %
									gl.setS34(rs.getString(12));  //m3 %
								
									
							
									
									
									return gl;
								}
											 }     );
										}
						 
						 
						 
						 //02-05-2024 RD
						 public List<SimpleBranch> getTargetReport_Branchwise_Quarterly_all_RD(String FromDate,String Date2,String Date3,String Date4,String Date5,String ToDate,String PeriodMonth,int year1,int BCode)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											//20-05-2022 //particular branch
											//String sql="	select k.* from ( select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,case when ((a.target_amount/3)-nvl(b.achieved_m1,0)) > 0 then ((a.target_amount/3)-nvl(b.achieved_m1,0)) else 0 end as bal1,to_char(round((b.achieved_m1)*100/(a.target_amount/3),2)||' %') as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,case when ((a.target_amount/3)-nvl(b2.achieved_m2,0))>0 then ((a.target_amount/3)-nvl(b2.achieved_m2,0)) else 0 end as bal2,to_char(round((b2.achieved_m2)*100/(a.target_amount/3),2)||' %') as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,case when ((a.target_amount/3)-nvl(b3.achieved_m3,0))>0 then ((a.target_amount/3)-nvl(b3.achieved_m3,0)) else 0 end as bal3,to_char(round((b3.achieved_m3)*100/(a.target_amount/3),2)||' %') as acheived_per3,case when (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))>0 then (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)) else 0 end as targerbalance,to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00) ||'%') as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" and scheme_name='LOWCOST' group by branch)a left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m1 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch     )b on a.branch=b.branch   left join (   select main_qry2.branch,sum(main_qry2.achieved)as achieved_m2 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b2 on a.branch=b2.branch  left join   (     select branch as livebranch,nvl(sum(Deposit_amount),0) as achieved_m3 from fd_master_view where Account_Status='A' and open_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by branch     select main_qry2.branch,sum(main_qry2.achieved)as achieved_m3 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b3 on a.branch=b3.livebranch  )k where  k.branch="+BCode+" order by k.branch";
										    //21-05-2022
											//String sql="select k.* from (select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,case when ((a.target_amount/3)-nvl(b.achieved_m1,0)) > 0 then ((a.target_amount/3)-nvl(b.achieved_m1,0)) else 0 end as bal1,to_char(round((b.achieved_m1)*100/(a.target_amount/3),2)||' %') as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,case when ((a.target_amount/3)-nvl(b2.achieved_m2,0))>0 then ((a.target_amount/3)-nvl(b2.achieved_m2,0)) else 0 end as bal2,to_char(round((b2.achieved_m2)*100/(a.target_amount/3),2)||' %') as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,case when ((a.target_amount/3)-nvl(b3.achieved_m3,0))>0 then ((a.target_amount/3)-nvl(b3.achieved_m3,0)) else 0 end as bal3,to_char(round((b3.achieved_m3)*100/(a.target_amount/3),2)||' %') as acheived_per3,case when (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))>0 then (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)) else 0 end as targerbalance,to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00) ||'%') as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" and scheme_name='LOWCOST' group by branch)a left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m1 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch  )b on a.branch=b.branch  left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m2 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b2 on a.branch=b2.branch left join (      select main_qry2.branch,sum(main_qry2.achieved)as achieved_m3 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b3 on a.branch=b3.branch )k where  k.branch="+BCode+" order by k.branch";

										    
										    //21-05-2022 //all
											//String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,case when ((a.target_amount/3)-nvl(b.achieved_m1,0)) > 0 then ((a.target_amount/3)-nvl(b.achieved_m1,0)) else 0 end as bal1,to_char(round((b.achieved_m1)*100/(a.target_amount/3),2)||' %') as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,case when ((a.target_amount/3)-nvl(b2.achieved_m2,0))>0 then ((a.target_amount/3)-nvl(b2.achieved_m2,0)) else 0 end as bal2,to_char(round((b2.achieved_m2)*100/(a.target_amount/3),2)||' %') as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,case when ((a.target_amount/3)-nvl(b3.achieved_m3,0))>0 then ((a.target_amount/3)-nvl(b3.achieved_m3,0)) else 0 end as bal3,to_char(round((b3.achieved_m3)*100/(a.target_amount/3),2)||' %') as acheived_per3,case when (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))>0 then (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)) else 0 end as targerbalance,to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00) ||'%') as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" and scheme_name='LOWCOST' group by branch)a left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m1 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch  )b on a.branch=b.branch  left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m2 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b2 on a.branch=b2.branch left join (      select main_qry2.branch,sum(main_qry2.achieved)as achieved_m3 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b3 on a.branch=b3.branch";
										   
											//07-06-2022 acheived %
											//String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,case when ((a.target_amount/3)-nvl(b.achieved_m1,0)) > 0 then ((a.target_amount/3)-nvl(b.achieved_m1,0)) else 0 end as bal1,to_char(nvl(round((b.achieved_m1)*100/(a.target_amount/3),2),0)) as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,case when ((a.target_amount/3)-nvl(b2.achieved_m2,0))>0 then ((a.target_amount/3)-nvl(b2.achieved_m2,0)) else 0 end as bal2,to_char(nvl(round((b2.achieved_m2)*100/(a.target_amount/3),2),0)) as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,case when ((a.target_amount/3)-nvl(b3.achieved_m3,0))>0 then ((a.target_amount/3)-nvl(b3.achieved_m3,0)) else 0 end as bal3,to_char(nvl(round((b3.achieved_m3)*100/(a.target_amount/3),2),0)) as acheived_per3,case when (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))>0 then (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)) else 0 end as targerbalance,to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00)) as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" and scheme_name='RD' group by branch)a left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m1 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch  )b on a.branch=b.branch  left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m2 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b2 on a.branch=b2.branch left join (      select main_qry2.branch,sum(main_qry2.achieved)as achieved_m3 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b3 on a.branch=b3.branch order by b";

											//03-05-2024 logic updation
											//String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,case when ((a.target_amount/3)-nvl(b.achieved_m1,0)) > 0 then ((a.target_amount/3)-nvl(b.achieved_m1,0)) else 0 end as bal1,to_char(nvl(round((b.achieved_m1)*100/(a.target_amount/3),2),0)) as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,case when ((a.target_amount/3)-nvl(b2.achieved_m2,0))>0 then ((a.target_amount/3)-nvl(b2.achieved_m2,0)) else 0 end as bal2,to_char(nvl(round((b2.achieved_m2)*100/(a.target_amount/3),2),0)) as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,case when ((a.target_amount/3)-nvl(b3.achieved_m3,0))>0 then ((a.target_amount/3)-nvl(b3.achieved_m3,0)) else 0 end as bal3,to_char(nvl(round((b3.achieved_m3)*100/(a.target_amount/3),2),0)) as acheived_per3,case when (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))>0 then (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)) else 0 end as targerbalance,to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00)) as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" and scheme_name='RD' group by branch)a left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m1 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch  )b on a.branch=b.branch  left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m2 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b2 on a.branch=b2.branch left join (      select main_qry2.branch,sum(main_qry2.achieved)as achieved_m3 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b3 on a.branch=b3.branch order by a.branch";

											String sql="select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,a.target_amount/3 as target_amount,nvl(b.achieved_m1,0) as acheived_m1,case when ((a.target_amount/3)-nvl(b.achieved_m1,0)) > 0 then ((a.target_amount/3)-nvl(b.achieved_m1,0)) else 0 end as bal1,case when a.target_amount <>0 and b.achieved_m1<>0 then to_char(nvl(round((b.achieved_m1)*100/(a.target_amount/3),2),0)) else '0.0' end as acheived_per1,nvl(b2.achieved_m2,0) as acheived_m2,case when ((a.target_amount/3)-nvl(b2.achieved_m2,0))>0 then ((a.target_amount/3)-nvl(b2.achieved_m2,0)) else 0 end as bal2,case when a.target_amount <>0 and b2.achieved_m2<>0 then to_char(nvl(round((b2.achieved_m2)*100/(a.target_amount/3),2),0)) else '0.0' end as acheived_per2,nvl(b3.achieved_m3,0) as acheived_m3,case when ((a.target_amount/3)-nvl(b3.achieved_m3,0))>0 then ((a.target_amount/3)-nvl(b3.achieved_m3,0)) else 0 end as bal3,case when a.target_amount <>0 and b3.achieved_m3<>0 then to_char(nvl(round((b3.achieved_m3)*100/(a.target_amount/3),2),0)) else '0.0' end as acheived_per3,case when (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))>0 then (a.target_amount-nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)) else 0 end as targerbalance,case when (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))<>0 then to_char(nvl(round(((nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0))*100/a.target_Amount),2),0.00)) else '0.0' end  as target_acheived_percen,ltrim(TO_CHAR(TO_DATE('01/04/2022','dd/mm/yyyy'),'mm-yyyy'),'0') AS month1 from (select branch ,sum(amount) as target_amount from target_master where month in ("+PeriodMonth+") and year="+year1+" and scheme_name='RD' group by branch)a left join ( Select Branch,sum(Deposit_Amount) as achieved_m1 from RD_Master_View_C where open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date2+"','dd/MM/yyyy') group by Branch )b on a.branch=b.branch  left join ( Select Branch,sum(Deposit_Amount) as achieved_m2 from RD_Master_View_C where open_date between to_date('"+Date3+"','dd/MM/yyyy') and to_date('"+Date4+"','dd/MM/yyyy') group by Branch )b2 on a.branch=b2.branch left join (     Select Branch,sum(Deposit_Amount) as achieved_m3 from RD_Master_View_C where open_date between to_date('"+Date5+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by Branch )b3 on a.branch=b3.branch order by a.branch";

				System.out.println(sql);
								return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
									
									SimpleBranch gl=new SimpleBranch();
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(3));  //targetAmt
									gl.setS142(rs.getDouble(4));  //Acheived1
									gl.setS143(rs.getDouble(5));  //bal1
									
									gl.setS144(rs.getDouble(7));  //Acheived2
									gl.setS145(rs.getDouble(8));  //bal2
									gl.setS146(rs.getDouble(10));  //Acheived3
									gl.setS147(rs.getDouble(11));  //bal3
									
									gl.setS32(rs.getString(6));  //m1 %
									gl.setS33(rs.getString(9));  //m2 %
									gl.setS34(rs.getString(12));  //m3 %
								
									
							
									
									
									return gl;
								}
											 }     );
										}
						 
						 
						 //20-05-2022
						 public List<SimpleBranch> getTargetReport_Branchwise_Consolidated_all_LOWCOST(String FromDate,String Date1,String Date2,String Date3,String Date4,String Date5,String Date6,String ToDate,int year1,int BCode)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											
											//20-05-2022  //particular branch 
					//						String sql="select super_qry.*,to_char(nvl(round((main_qry.targetachieved*100/main_qry.yearlydeposits),2),0)|| ' %') as Achcheived_Percent from (  select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0)) as yearlyDeposits,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetAchieved,case when (nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)) > 0 then (nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)) else 0 end as targetnotAchieved,nvl(b.achieved_m1,0) as Q1_Acheived,nvl(b2.achieved_m2,0)as  Q2_Acheived,nvl(b3.achieved_m3,0) as Q3_Acheived,nvl(b4.achieved_m4,0) Q4_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4,5,6) and year="+year1+" and Scheme_Name='LOWCOST' group by branch)a left join ( select branch ,sum(amount) as target_amount2 from target_master where month in (7,8,9) and year="+year1+" and scheme_name='LOWCOST' group by branch)a2 on a.branch=a2.branch left join (  select branch ,sum(amount) as target_amount3 from target_master where month in (10,11,12) and year="+year1+" and scheme_name='LOWCOST' group by branch)a3 on a.branch=a3.branch left join ( select branch ,sum(amount) as target_amount4 from target_master where month in (1,2,3) and year="+(year1+1)+" and scheme_name='LOWCOST' group by branch)a4 on a.branch=a4.branch left join  ( select main_qry2.branch,sum(main_qry2.achieved)as achieved from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch  )b on a.branch=b.livebranch left join  ( select main_qry2.branch,sum(main_qry2.achieved)as achieved from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date2+"','dd/MM/yyyy') and to_date('"+Date3+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b2 on a.branch=b2.livebranch left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date4+"','dd/MM/yyyy') and to_date('"+Date5+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b3 on a.branch=b3.livebranch left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date6+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b4 on a.branch=b4.livebranch)super_qry where super_qry.branch="+BCode+" order by super_qry.branch";
					//21-05-2022
											//						String sql="select super_qry.*,to_char(nvl(round((super_qry.targetachieved*100/super_qry.yearlydeposits),2),0)|| ' %') as Achcheived_Percent from (select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0)) as yearlyDeposits,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetAchieved,case when (nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)) > 0 then (nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)) else 0 end as targetnotAchieved,nvl(b.achieved_m1,0) as Q1_Acheived,nvl(b2.achieved_m2,0)as Q2_Acheived,nvl(b3.achieved_m3,0) as Q3_Acheived,nvl(b4.achieved_m4,0) Q4_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4,5,6) and year="+year1+"and Scheme_Name='LOWCOST' group by branch)a left join (select branch ,sum(amount) as target_amount2 from target_master where month in (7,8,9) and year="+year1+" and scheme_name='LOWCOST' group by branch)a2 on a.branch=a2.branch left join ( select branch ,sum(amount) as target_amount3 from target_master where month in (10,11,12) and year="+year1+" and scheme_name='LOWCOST' group by branch)a3 on a.branch=a3.branch left join (select branch ,sum(amount) as target_amount4 from target_master where month in (1,2,3) and year="+(year1+1)+" and scheme_name='LOWCOST' group by branch)a4 on a.branch=a4.branch left join (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m1 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date1+"','dd/MM/yyyy') group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b on a.branch=b.branch left join (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m2 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date2+"','dd/MM/yyyy') and to_date('"+Date3+"','dd/MM/yyyy') group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b2 on a.branch=b2.branch left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m3 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date4+"','dd/MM/yyyy') and to_date('"+Date5+"','dd/MM/yyyy') group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b3 on a.branch=b3.branch left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m4 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date6+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b4 on a.branch=b4.branch )super_qry where super_qry.branch="+BCode+" order by super_qry.branch";

											//20-05-2022  //all
											 	//	String sql="select super_qry.*,to_char(nvl(round((main_qry.targetachieved*100/main_qry.yearlydeposits),2),0)|| ' %') as Achcheived_Percent from (select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0)) as yearlyDeposits,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetAchieved,case when (nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)) > 0 then (nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)) else 0 end as targetnotAchieved,nvl(b.achieved_m1,0) as Q1_Acheived,nvl(b2.achieved_m2,0)as  Q2_Acheived,nvl(b3.achieved_m3,0) as Q3_Acheived,nvl(b4.achieved_m4,0) Q4_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4,5,6) and year="+year1+" and Scheme_Name='LOWCOST' group by branch)a left join (select branch ,sum(amount) as target_amount2 from target_master where month in (7,8,9) and year="+year1+" and scheme_name='LOWCOST' group by branch)a2 on a.branch=a2.branch left join ( select branch ,sum(amount) as target_amount3 from target_master where month in (10,11,12) and year="+year1+" and scheme_name='LOWCOST' group by branch)a3 on a.branch=a3.branch left join (select branch ,sum(amount) as target_amount4 from target_master where month in (1,2,3) and year="+(year1+1)+" and scheme_name='LOWCOST' group by branch)a4 on a.branch=a4.branch left join  (select main_qry2.branch,sum(main_qry2.achieved)as achieved from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch  )b on a.branch=b.livebranch left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date2+"','dd/MM/yyyy') and to_date('"+Date3+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b2 on a.branch=b2.livebranch left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date4+"','dd/MM/yyyy') and to_date('"+Date5+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b3 on a.branch=b3.livebranch left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date6+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b4 on a.branch=b4.livebranch)super_qry  order by super_qry.branch";
											//21-05-2022 	all
											String sql="select super_qry.*,case when super_qry.targetachieved <> 0 and super_qry.yearlydeposits <> 0 then (to_char(nvl(round((super_qry.targetachieved*100/super_qry.yearlydeposits),2),0))) else '0.0' end as Achcheived_Percent from (select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0)) as yearlyDeposits,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetAchieved,case when (nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)) > 0 then (nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)) else 0 end as targetnotAchieved,nvl(b.achieved_m1,0) as Q1_Acheived,nvl(b2.achieved_m2,0)as Q2_Acheived,nvl(b3.achieved_m3,0) as Q3_Acheived,nvl(b4.achieved_m4,0) Q4_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4,5,6) and year="+year1+"and Scheme_Name='LOWCOST' group by branch)a left join (select branch ,sum(amount) as target_amount2 from target_master where month in (7,8,9) and year="+year1+" and scheme_name='LOWCOST' group by branch)a2 on a.branch=a2.branch left join ( select branch ,sum(amount) as target_amount3 from target_master where month in (10,11,12) and year="+year1+" and scheme_name='LOWCOST' group by branch)a3 on a.branch=a3.branch left join (select branch ,sum(amount) as target_amount4 from target_master where month in (1,2,3) and year="+(year1+1)+" and scheme_name='LOWCOST' group by branch)a4 on a.branch=a4.branch left join (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m1 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date1+"','dd/MM/yyyy') group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b on a.branch=b.branch left join (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m2 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date2+"','dd/MM/yyyy') and to_date('"+Date3+"','dd/MM/yyyy') group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b2 on a.branch=b2.branch left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m3 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date4+"','dd/MM/yyyy') and to_date('"+Date5+"','dd/MM/yyyy') group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b3 on a.branch=b3.branch left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m4 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date6+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b4 on a.branch=b4.branch )super_qry order by super_qry.branch";
											
											
											
											
								return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
									
									SimpleBranch gl=new SimpleBranch();
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(3));  //targetAmt
									gl.setS142(rs.getDouble(4));  //targetAcheived
									gl.setS143(rs.getDouble(5));  //targetNotAcheived
									
									gl.setS144(rs.getDouble(6));  //q1
									gl.setS145(rs.getDouble(7));  //q2
									gl.setS146(rs.getDouble(8));  //q3
									gl.setS147(rs.getDouble(9));  //q4
									gl.setS32(rs.getString(10));  //percent %
									
									
							
									
									
									return gl;
								}
											 }     );
										}

						 
						 
						 
						 //02-05-2024
						 public List<SimpleBranch> getTargetReport_Branchwise_Consolidated_all_RD(String FromDate,String Date1,String Date2,String Date3,String Date4,String Date5,String Date6,String ToDate,int year1,int BCode)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											
											//20-05-2022  //particular branch 
					//						String sql="select super_qry.*,to_char(nvl(round((main_qry.targetachieved*100/main_qry.yearlydeposits),2),0)|| ' %') as Achcheived_Percent from (  select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0)) as yearlyDeposits,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetAchieved,case when (nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)) > 0 then (nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)) else 0 end as targetnotAchieved,nvl(b.achieved_m1,0) as Q1_Acheived,nvl(b2.achieved_m2,0)as  Q2_Acheived,nvl(b3.achieved_m3,0) as Q3_Acheived,nvl(b4.achieved_m4,0) Q4_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4,5,6) and year="+year1+" and Scheme_Name='LOWCOST' group by branch)a left join ( select branch ,sum(amount) as target_amount2 from target_master where month in (7,8,9) and year="+year1+" and scheme_name='LOWCOST' group by branch)a2 on a.branch=a2.branch left join (  select branch ,sum(amount) as target_amount3 from target_master where month in (10,11,12) and year="+year1+" and scheme_name='LOWCOST' group by branch)a3 on a.branch=a3.branch left join ( select branch ,sum(amount) as target_amount4 from target_master where month in (1,2,3) and year="+(year1+1)+" and scheme_name='LOWCOST' group by branch)a4 on a.branch=a4.branch left join  ( select main_qry2.branch,sum(main_qry2.achieved)as achieved from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch  )b on a.branch=b.livebranch left join  ( select main_qry2.branch,sum(main_qry2.achieved)as achieved from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date2+"','dd/MM/yyyy') and to_date('"+Date3+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b2 on a.branch=b2.livebranch left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date4+"','dd/MM/yyyy') and to_date('"+Date5+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b3 on a.branch=b3.livebranch left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date6+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b4 on a.branch=b4.livebranch)super_qry where super_qry.branch="+BCode+" order by super_qry.branch";
					//21-05-2022
											//						String sql="select super_qry.*,to_char(nvl(round((super_qry.targetachieved*100/super_qry.yearlydeposits),2),0)|| ' %') as Achcheived_Percent from (select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0)) as yearlyDeposits,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetAchieved,case when (nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)) > 0 then (nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)) else 0 end as targetnotAchieved,nvl(b.achieved_m1,0) as Q1_Acheived,nvl(b2.achieved_m2,0)as Q2_Acheived,nvl(b3.achieved_m3,0) as Q3_Acheived,nvl(b4.achieved_m4,0) Q4_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4,5,6) and year="+year1+"and Scheme_Name='LOWCOST' group by branch)a left join (select branch ,sum(amount) as target_amount2 from target_master where month in (7,8,9) and year="+year1+" and scheme_name='LOWCOST' group by branch)a2 on a.branch=a2.branch left join ( select branch ,sum(amount) as target_amount3 from target_master where month in (10,11,12) and year="+year1+" and scheme_name='LOWCOST' group by branch)a3 on a.branch=a3.branch left join (select branch ,sum(amount) as target_amount4 from target_master where month in (1,2,3) and year="+(year1+1)+" and scheme_name='LOWCOST' group by branch)a4 on a.branch=a4.branch left join (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m1 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date1+"','dd/MM/yyyy') group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b on a.branch=b.branch left join (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m2 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date2+"','dd/MM/yyyy') and to_date('"+Date3+"','dd/MM/yyyy') group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b2 on a.branch=b2.branch left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m3 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date4+"','dd/MM/yyyy') and to_date('"+Date5+"','dd/MM/yyyy') group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b3 on a.branch=b3.branch left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m4 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date6+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b4 on a.branch=b4.branch )super_qry where super_qry.branch="+BCode+" order by super_qry.branch";

											//20-05-2022  //all
											 	//	String sql="select super_qry.*,to_char(nvl(round((main_qry.targetachieved*100/main_qry.yearlydeposits),2),0)|| ' %') as Achcheived_Percent from (select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0)) as yearlyDeposits,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetAchieved,case when (nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)) > 0 then (nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)) else 0 end as targetnotAchieved,nvl(b.achieved_m1,0) as Q1_Acheived,nvl(b2.achieved_m2,0)as  Q2_Acheived,nvl(b3.achieved_m3,0) as Q3_Acheived,nvl(b4.achieved_m4,0) Q4_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4,5,6) and year="+year1+" and Scheme_Name='LOWCOST' group by branch)a left join (select branch ,sum(amount) as target_amount2 from target_master where month in (7,8,9) and year="+year1+" and scheme_name='LOWCOST' group by branch)a2 on a.branch=a2.branch left join ( select branch ,sum(amount) as target_amount3 from target_master where month in (10,11,12) and year="+year1+" and scheme_name='LOWCOST' group by branch)a3 on a.branch=a3.branch left join (select branch ,sum(amount) as target_amount4 from target_master where month in (1,2,3) and year="+(year1+1)+" and scheme_name='LOWCOST' group by branch)a4 on a.branch=a4.branch left join  (select main_qry2.branch,sum(main_qry2.achieved)as achieved from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch  )b on a.branch=b.livebranch left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date2+"','dd/MM/yyyy') and to_date('"+Date3+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b2 on a.branch=b2.livebranch left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date4+"','dd/MM/yyyy') and to_date('"+Date5+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b3 on a.branch=b3.livebranch left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date6+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b4 on a.branch=b4.livebranch)super_qry  order by super_qry.branch";
											//21-05-2022 	all
	//										String sql="select super_qry.*,case when super_qry.targetachieved <> 0 and super_qry.yearlydeposits <> 0 then (to_char(nvl(round((super_qry.targetachieved*100/super_qry.yearlydeposits),2),0))) else '0.0' end as Achcheived_Percent from (select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0)) as yearlyDeposits,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetAchieved,case when (nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)) > 0 then (nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)) else 0 end as targetnotAchieved,nvl(b.achieved_m1,0) as Q1_Acheived,nvl(b2.achieved_m2,0)as Q2_Acheived,nvl(b3.achieved_m3,0) as Q3_Acheived,nvl(b4.achieved_m4,0) Q4_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4,5,6) and year="+year1+"and Scheme_Name='RD' group by branch)a left join (select branch ,sum(amount) as target_amount2 from target_master where month in (7,8,9) and year="+year1+" and scheme_name='RD' group by branch)a2 on a.branch=a2.branch left join ( select branch ,sum(amount) as target_amount3 from target_master where month in (10,11,12) and year="+year1+" and scheme_name='RD' group by branch)a3 on a.branch=a3.branch left join (select branch ,sum(amount) as target_amount4 from target_master where month in (1,2,3) and year="+(year1+1)+" and scheme_name='RD' group by branch)a4 on a.branch=a4.branch left join (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m1 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date1+"','dd/MM/yyyy') group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b on a.branch=b.branch left join (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m2 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date2+"','dd/MM/yyyy') and to_date('"+Date3+"','dd/MM/yyyy') group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b2 on a.branch=b2.branch left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m3 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date4+"','dd/MM/yyyy') and to_date('"+Date5+"','dd/MM/yyyy') group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b3 on a.branch=b3.branch left join ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m4 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('"+Date6+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch )b4 on a.branch=b4.branch )super_qry order by super_qry.branch";
											
											//03-05-2024 Updated Logic
											 String sql="select super_qry.*,case when super_qry.targetachieved <> 0 and super_qry.yearlydeposits <> 0 then (to_char(nvl(round((super_qry.targetachieved*100/super_qry.yearlydeposits),2),0))) else '0.0' end as Achcheived_Percent from (select a.branch,(Select branch_name from branch_master where branch_code=a.branch) as bname,(nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0)) as yearlyDeposits,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0))as targetAchieved,case when (nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)) > 0 then (nvl(a.target_amount1,0)+nvl(a2.target_amount2,0)+nvl(a3.target_amount3,0)+nvl(a4.target_amount4,0))- (nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)) else 0 end as targetnotAchieved,nvl(b.achieved_m1,0) as Q1_Acheived,nvl(b2.achieved_m2,0)as Q2_Acheived,nvl(b3.achieved_m3,0) as Q3_Acheived,nvl(b4.achieved_m4,0) Q4_Acheived from (select branch ,sum(amount) as target_amount1 from target_master where month in (4,5,6) and year="+year1+"and Scheme_Name='RD' group by branch)a left join (select branch ,sum(amount) as target_amount2 from target_master where month in (7,8,9) and year="+year1+" and scheme_name='RD' group by branch)a2 on a.branch=a2.branch left join ( select branch ,sum(amount) as target_amount3 from target_master where month in (10,11,12) and year="+year1+" and scheme_name='RD' group by branch)a3 on a.branch=a3.branch left join (select branch ,sum(amount) as target_amount4 from target_master where month in (1,2,3) and year="+(year1+1)+" and scheme_name='RD' group by branch)a4 on a.branch=a4.branch left join (Select Branch,sum(Deposit_Amount) as achieved_m1 from RD_Master_View_C where open_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+Date1+"','dd/MM/yyyy') group by Branch )b on a.branch=b.branch left join (Select Branch,sum(Deposit_Amount) as achieved_m2 from RD_Master_View_C where open_date between to_date('"+Date2+"','dd/MM/yyyy') and to_date('"+Date3+"','dd/MM/yyyy') group by Branch )b2 on a.branch=b2.branch left join ( Select Branch,sum(Deposit_Amount) as achieved_m3 from RD_Master_View_C where open_date between to_date('"+Date4+"','dd/MM/yyyy') and to_date('"+Date5+"','dd/MM/yyyy') group by Branch )b3 on a.branch=b3.branch left join ( Select Branch,sum(Deposit_Amount) as achieved_m4 from RD_Master_View_C where open_date between to_date('"+Date6+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy') group by Branch )b4 on a.branch=b4.branch )super_qry order by super_qry.branch";

											
											
											
								return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
									
									SimpleBranch gl=new SimpleBranch();
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(3));  //targetAmt
									gl.setS142(rs.getDouble(4));  //targetAcheived
									gl.setS143(rs.getDouble(5));  //targetNotAcheived
									
									gl.setS144(rs.getDouble(6));  //q1
									gl.setS145(rs.getDouble(7));  //q2
									gl.setS146(rs.getDouble(8));  //q3
									gl.setS147(rs.getDouble(9));  //q4
									gl.setS32(rs.getString(10));  //percent %
									
									
							
									
									
									return gl;
								}
											 }     );
										}

						 
						 //--------------------
						
						 //20-05-2022
						 public List<SimpleBranch> getTargetReport_Branchwise_Yearly_LOWCOST(int year1,int year2,int BCode)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											//20-05-2022 //particular branch
					//						String sql="select k.*,case when (k.Target_Amount-k.targetAchieved)>0 then (k.Target_Amount-k.targetAchieved) else 0 end as balance,to_char (round(nvl((k.targetAchieved*100)/k.Target_Amount,0),2) || ' %') as percen1 from (select main_qry.* from (select a.branch,(select branch_name from branch_master where branch_code=branch)as Bname,(nvl(a.target_amount1,0))*12 as Target_Amount,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)+nvl(b5.achieved_m5,0)+nvl(b6.achieved_m6,0)+nvl(b7.achieved_m7,0)+nvl(b8.achieved_m8,0)+nvl(b9.achieved_m9,0)+nvl(b10.achieved_m10,0)+nvl(b11.achieved_m11,0)+nvl(b12.achieved_m12,0))as targetAchieved,nvl(b.achieved_m1,0) as m1_Acheived,nvl(b2.achieved_m2,0)as  m2_Acheived,nvl(b3.achieved_m3,0) as m3_Acheived,nvl(b4.achieved_m4,0) m4_Acheived,nvl(b5.achieved_m5,0) as m5_Acheived,nvl(b6.achieved_m6,0)as  m6_Acheived,nvl(b7.achieved_m7,0) as m7_Acheived,nvl(b8.achieved_m8,0) m8_Acheived,nvl(b9.achieved_m9,0) as m9_Acheived,nvl(b10.achieved_m10,0)as  m10_Acheived,nvl(b11.achieved_m11,0) as m11_Acheived,nvl(b12.achieved_m12,0) m12_Acheived from ( select branch ,sum(amount) as target_amount1 from target_master where month in (4) and year="+year1+" and scheme_name='LOWCOST' group by branch)a left join               ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m1 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/04/"+year1+"','dd/MM/yyyy') and to_date('30/04/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch             )b on a.branch=b.livebranch left join          (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m2 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/05/"+year1+"','dd/MM/yyyy') and to_date('31/05/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch            )b2 on a.branch=b2.livebranch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m3 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/06/"+year1+"','dd/MM/yyyy') and to_date('30/06/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch          )b3 on a.branch=b3.livebranch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m4 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/07/"+year1+"','dd/MM/yyyy') and to_date('31/07/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch            )b4 on a.branch=b4.livebranch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m5 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/08/"+year1+"','dd/MM/yyyy') and to_date('31/08/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b5 on a.branch=b5.livebranch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m6 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/09/"+year1+"','dd/MM/yyyy') and to_date('30/09/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b6 on a.branch=b6.livebranch left join               (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m7 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/10/"+year1+"','dd/MM/yyyy') and to_date('31/10/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch             )b7 on a.branch=b7.livebranch left join               (               select main_qry2.branch,sum(main_qry2.achieved)as achieved_m8 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/11/"+year1+"','dd/MM/yyyy') and to_date('30/11/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b8 on a.branch=b8.livebranch left join (              select main_qry2.branch,sum(main_qry2.achieved)as achieved_m9 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/12/"+year1+"','dd/MM/yyyy') and to_date('31/12/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b9 on a.branch=b9.livebranch left join (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m10 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/01/"+year2+"','dd/MM/yyyy') and to_date('31/01/"+year2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b10 on a.branch=b10.livebranch left join      (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m11 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/02/"+year2+"','dd/MM/yyyy') and to_date('28/02/"+year2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch             )b11 on a.branch=b11.livebranch left join     (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m12 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/03/"+year2+"','dd/MM/yyyy') and to_date('31/03/"+year2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch         )b12 on a.branch=b12.livebranch)main_qry order by main_qry.branch)k where k.branch="+BCode+"";

				//20-05-2022 //all
					//						String sql="select k.*,case when (k.Target_Amount-k.targetAchieved)>0 then (k.Target_Amount-k.targetAchieved) else 0 end as balance,to_char (round(nvl((k.targetAchieved*100)/k.Target_Amount,0),2) || ' %') as percen1 from (select main_qry.* from (select a.branch,(select branch_name from branch_master where branch_code=branch)as Bname,(nvl(a.target_amount1,0))*12 as Target_Amount,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)+nvl(b5.achieved_m5,0)+nvl(b6.achieved_m6,0)+nvl(b7.achieved_m7,0)+nvl(b8.achieved_m8,0)+nvl(b9.achieved_m9,0)+nvl(b10.achieved_m10,0)+nvl(b11.achieved_m11,0)+nvl(b12.achieved_m12,0))as targetAchieved,nvl(b.achieved_m1,0) as m1_Acheived,nvl(b2.achieved_m2,0)as  m2_Acheived,nvl(b3.achieved_m3,0) as m3_Acheived,nvl(b4.achieved_m4,0) m4_Acheived,nvl(b5.achieved_m5,0) as m5_Acheived,nvl(b6.achieved_m6,0)as  m6_Acheived,nvl(b7.achieved_m7,0) as m7_Acheived,nvl(b8.achieved_m8,0) m8_Acheived,nvl(b9.achieved_m9,0) as m9_Acheived,nvl(b10.achieved_m10,0)as  m10_Acheived,nvl(b11.achieved_m11,0) as m11_Acheived,nvl(b12.achieved_m12,0) m12_Acheived from ( select branch ,sum(amount) as target_amount1 from target_master where month in (4) and year="+year1+" and scheme_name='LOWCOST' group by branch)a left join               ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m1 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/04/"+year1+"','dd/MM/yyyy') and to_date('30/04/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch             )b on a.branch=b.livebranch left join          (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m2 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/05/"+year1+"','dd/MM/yyyy') and to_date('31/05/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch            )b2 on a.branch=b2.livebranch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m3 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/06/"+year1+"','dd/MM/yyyy') and to_date('30/06/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch          )b3 on a.branch=b3.livebranch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m4 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/07/"+year1+"','dd/MM/yyyy') and to_date('31/07/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch            )b4 on a.branch=b4.livebranch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m5 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/08/"+year1+"','dd/MM/yyyy') and to_date('31/08/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b5 on a.branch=b5.livebranch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m6 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/09/"+year1+"','dd/MM/yyyy') and to_date('30/09/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b6 on a.branch=b6.livebranch left join               (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m7 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/10/"+year1+"','dd/MM/yyyy') and to_date('31/10/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch             )b7 on a.branch=b7.livebranch left join               (               select main_qry2.branch,sum(main_qry2.achieved)as achieved_m8 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/11/"+year1+"','dd/MM/yyyy') and to_date('30/11/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b8 on a.branch=b8.livebranch left join (              select main_qry2.branch,sum(main_qry2.achieved)as achieved_m9 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/12/"+year1+"','dd/MM/yyyy') and to_date('31/12/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b9 on a.branch=b9.livebranch left join (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m10 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/01/"+year2+"','dd/MM/yyyy') and to_date('31/01/"+year2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b10 on a.branch=b10.livebranch left join      (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m11 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/02/"+year2+"','dd/MM/yyyy') and to_date('28/02/"+year2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch             )b11 on a.branch=b11.livebranch left join     (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m12 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/03/"+year2+"','dd/MM/yyyy') and to_date('31/03/"+year2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch         )b12 on a.branch=b12.livebranch)main_qry order by main_qry.branch)k ";

											//21-05-2022 all
										String sql="select k.*,case when (k.Target_Amount-k.targetAchieved)>0 then (k.Target_Amount-k.targetAchieved) else 0 end as balance,case when k.targetAchieved<> 0 and k.Target_Amount<>0 then (to_char (round(nvl((k.targetAchieved*100)/k.Target_Amount,0),2) || ' %')) else '0.0 %' end as percen1 from (select main_qry.* from (select a.branch,(select branch_name from branch_master where branch_code=a.branch)as Bname,(nvl(a.target_amount1,0))*12 as Target_Amount,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)+nvl(b5.achieved_m5,0)+nvl(b6.achieved_m6,0)+nvl(b7.achieved_m7,0)+nvl(b8.achieved_m8,0)+nvl(b9.achieved_m9,0)+nvl(b10.achieved_m10,0)+nvl(b11.achieved_m11,0)+nvl(b12.achieved_m12,0))as targetAchieved,nvl(b.achieved_m1,0) as m1_Acheived,nvl(b2.achieved_m2,0)as  m2_Acheived,nvl(b3.achieved_m3,0) as m3_Acheived,nvl(b4.achieved_m4,0) m4_Acheived,nvl(b5.achieved_m5,0) as m5_Acheived,nvl(b6.achieved_m6,0)as  m6_Acheived,nvl(b7.achieved_m7,0) as m7_Acheived,nvl(b8.achieved_m8,0) m8_Acheived,nvl(b9.achieved_m9,0) as m9_Acheived,nvl(b10.achieved_m10,0)as  m10_Acheived,nvl(b11.achieved_m11,0) as m11_Acheived,nvl(b12.achieved_m12,0) m12_Acheived from ( select branch ,sum(amount) as target_amount1 from target_master where month in (4) and year="+year1+" and scheme_name='LOWCOST' group by branch)a left join               ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m1 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/04/"+year1+"','dd/MM/yyyy') and to_date('30/04/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch             )b on a.branch=b.branch left join          (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m2 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/05/"+year1+"','dd/MM/yyyy') and to_date('31/05/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch            )b2 on a.branch=b2.branch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m3 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/06/"+year1+"','dd/MM/yyyy') and to_date('30/06/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch          )b3 on a.branch=b3.branch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m4 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/07/"+year1+"','dd/MM/yyyy') and to_date('31/07/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch            )b4 on a.branch=b4.branch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m5 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/08/"+year1+"','dd/MM/yyyy') and to_date('31/08/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b5 on a.branch=b5.branch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m6 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/09/"+year1+"','dd/MM/yyyy') and to_date('30/09/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b6 on a.branch=b6.branch left join               (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m7 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/10/"+year1+"','dd/MM/yyyy') and to_date('31/10/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch             )b7 on a.branch=b7.branch left join               (               select main_qry2.branch,sum(main_qry2.achieved)as achieved_m8 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/11/"+year1+"','dd/MM/yyyy') and to_date('30/11/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b8 on a.branch=b8.branch left join (              select main_qry2.branch,sum(main_qry2.achieved)as achieved_m9 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/12/"+year1+"','dd/MM/yyyy') and to_date('31/12/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b9 on a.branch=b9.branch left join (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m10 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/01/"+year2+"','dd/MM/yyyy') and to_date('31/01/"+year2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b10 on a.branch=b10.branch left join      (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m11 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/02/"+year2+"','dd/MM/yyyy') and to_date('28/02/"+year2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch             )b11 on a.branch=b11.branch left join     (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m12 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/03/"+year2+"','dd/MM/yyyy') and to_date('31/03/"+year2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch         )b12 on a.branch=b12.branch)main_qry order by main_qry.branch)k ";

											//21-05-2022 particular
	//										String sql="select k.*,case when (k.Target_Amount-k.targetAchieved)>0 then (k.Target_Amount-k.targetAchieved) else 0 end as balance,to_char (round(nvl((k.targetAchieved*100)/k.Target_Amount,0),2) || ' %') as percen1 from (select main_qry.* from (select a.branch,(select branch_name from branch_master where branch_code=a.branch)as Bname,(nvl(a.target_amount1,0))*12 as Target_Amount,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)+nvl(b5.achieved_m5,0)+nvl(b6.achieved_m6,0)+nvl(b7.achieved_m7,0)+nvl(b8.achieved_m8,0)+nvl(b9.achieved_m9,0)+nvl(b10.achieved_m10,0)+nvl(b11.achieved_m11,0)+nvl(b12.achieved_m12,0))as targetAchieved,nvl(b.achieved_m1,0) as m1_Acheived,nvl(b2.achieved_m2,0)as  m2_Acheived,nvl(b3.achieved_m3,0) as m3_Acheived,nvl(b4.achieved_m4,0) m4_Acheived,nvl(b5.achieved_m5,0) as m5_Acheived,nvl(b6.achieved_m6,0)as  m6_Acheived,nvl(b7.achieved_m7,0) as m7_Acheived,nvl(b8.achieved_m8,0) m8_Acheived,nvl(b9.achieved_m9,0) as m9_Acheived,nvl(b10.achieved_m10,0)as  m10_Acheived,nvl(b11.achieved_m11,0) as m11_Acheived,nvl(b12.achieved_m12,0) m12_Acheived from ( select branch ,sum(amount) as target_amount1 from target_master where month in (4) and year="+year1+" and scheme_name='LOWCOST' group by branch)a left join               ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m1 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/04/"+year1+"','dd/MM/yyyy') and to_date('30/04/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch             )b on a.branch=b.branch left join          (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m2 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/05/"+year1+"','dd/MM/yyyy') and to_date('31/05/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch            )b2 on a.branch=b2.branch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m3 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/06/"+year1+"','dd/MM/yyyy') and to_date('30/06/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch          )b3 on a.branch=b3.branch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m4 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/07/"+year1+"','dd/MM/yyyy') and to_date('31/07/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch            )b4 on a.branch=b4.branch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m5 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/08/"+year1+"','dd/MM/yyyy') and to_date('31/08/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b5 on a.branch=b5.branch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m6 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/09/"+year1+"','dd/MM/yyyy') and to_date('30/09/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b6 on a.branch=b6.branch left join               (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m7 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/10/"+year1+"','dd/MM/yyyy') and to_date('31/10/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch             )b7 on a.branch=b7.branch left join               (               select main_qry2.branch,sum(main_qry2.achieved)as achieved_m8 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/11/"+year1+"','dd/MM/yyyy') and to_date('30/11/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b8 on a.branch=b8.branch left join (              select main_qry2.branch,sum(main_qry2.achieved)as achieved_m9 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/12/"+year1+"','dd/MM/yyyy') and to_date('31/12/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b9 on a.branch=b9.branch left join (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m10 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/01/"+year2+"','dd/MM/yyyy') and to_date('31/01/"+year2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b10 on a.branch=b10.branch left join      (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m11 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/02/"+year2+"','dd/MM/yyyy') and to_date('28/02/"+year2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch             )b11 on a.branch=b11.branch left join     (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m12 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/03/"+year2+"','dd/MM/yyyy') and to_date('31/03/"+year2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch         )b12 on a.branch=b12.branch)main_qry order by main_qry.branch)k where k.branch="+BCode+"";

											
					
					System.out.println(sql);
								return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
									
									SimpleBranch gl=new SimpleBranch();
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(3));  //targetAmt
									gl.setS142(rs.getDouble(4));  //targetAcheived
									
									gl.setS143(rs.getDouble(5));  //m1
									
									gl.setS144(rs.getDouble(6));  //m2
									gl.setS145(rs.getDouble(7));  //m3
									gl.setS146(rs.getDouble(8));  //m4
									gl.setS147(rs.getDouble(9));  //m5
									gl.setS148(rs.getDouble(10));  //m6
									gl.setS149(rs.getDouble(11));  //m7
									
									gl.setS150(rs.getDouble(12));  //m8
									gl.setS151(rs.getDouble(13));  //m9
									gl.setS152(rs.getDouble(14));  //m10
									gl.setS153(rs.getDouble(15));  //m11
									gl.setS154(rs.getDouble(16));  //m12
									
									//17-05-2022
									gl.setS155(rs.getDouble(17));  //balance
									gl.setS32(rs.getString(18));  //percent %
									
									
									
									
									
									return gl;
								}
											 }     );
										}


						 
						 
						 
						 
						 //02-05-2022
						 public List<SimpleBranch> getTargetReport_Branchwise_Yearly_RD(int year1,int year2,int BCode)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											//20-05-2022 //particular branch
					//						String sql="select k.*,case when (k.Target_Amount-k.targetAchieved)>0 then (k.Target_Amount-k.targetAchieved) else 0 end as balance,to_char (round(nvl((k.targetAchieved*100)/k.Target_Amount,0),2) || ' %') as percen1 from (select main_qry.* from (select a.branch,(select branch_name from branch_master where branch_code=branch)as Bname,(nvl(a.target_amount1,0))*12 as Target_Amount,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)+nvl(b5.achieved_m5,0)+nvl(b6.achieved_m6,0)+nvl(b7.achieved_m7,0)+nvl(b8.achieved_m8,0)+nvl(b9.achieved_m9,0)+nvl(b10.achieved_m10,0)+nvl(b11.achieved_m11,0)+nvl(b12.achieved_m12,0))as targetAchieved,nvl(b.achieved_m1,0) as m1_Acheived,nvl(b2.achieved_m2,0)as  m2_Acheived,nvl(b3.achieved_m3,0) as m3_Acheived,nvl(b4.achieved_m4,0) m4_Acheived,nvl(b5.achieved_m5,0) as m5_Acheived,nvl(b6.achieved_m6,0)as  m6_Acheived,nvl(b7.achieved_m7,0) as m7_Acheived,nvl(b8.achieved_m8,0) m8_Acheived,nvl(b9.achieved_m9,0) as m9_Acheived,nvl(b10.achieved_m10,0)as  m10_Acheived,nvl(b11.achieved_m11,0) as m11_Acheived,nvl(b12.achieved_m12,0) m12_Acheived from ( select branch ,sum(amount) as target_amount1 from target_master where month in (4) and year="+year1+" and scheme_name='LOWCOST' group by branch)a left join               ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m1 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/04/"+year1+"','dd/MM/yyyy') and to_date('30/04/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch             )b on a.branch=b.livebranch left join          (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m2 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/05/"+year1+"','dd/MM/yyyy') and to_date('31/05/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch            )b2 on a.branch=b2.livebranch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m3 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/06/"+year1+"','dd/MM/yyyy') and to_date('30/06/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch          )b3 on a.branch=b3.livebranch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m4 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/07/"+year1+"','dd/MM/yyyy') and to_date('31/07/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch            )b4 on a.branch=b4.livebranch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m5 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/08/"+year1+"','dd/MM/yyyy') and to_date('31/08/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b5 on a.branch=b5.livebranch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m6 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/09/"+year1+"','dd/MM/yyyy') and to_date('30/09/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b6 on a.branch=b6.livebranch left join               (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m7 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/10/"+year1+"','dd/MM/yyyy') and to_date('31/10/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch             )b7 on a.branch=b7.livebranch left join               (               select main_qry2.branch,sum(main_qry2.achieved)as achieved_m8 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/11/"+year1+"','dd/MM/yyyy') and to_date('30/11/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b8 on a.branch=b8.livebranch left join (              select main_qry2.branch,sum(main_qry2.achieved)as achieved_m9 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/12/"+year1+"','dd/MM/yyyy') and to_date('31/12/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b9 on a.branch=b9.livebranch left join (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m10 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/01/"+year2+"','dd/MM/yyyy') and to_date('31/01/"+year2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b10 on a.branch=b10.livebranch left join      (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m11 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/02/"+year2+"','dd/MM/yyyy') and to_date('28/02/"+year2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch             )b11 on a.branch=b11.livebranch left join     (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m12 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/03/"+year2+"','dd/MM/yyyy') and to_date('31/03/"+year2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch         )b12 on a.branch=b12.livebranch)main_qry order by main_qry.branch)k where k.branch="+BCode+"";

				//20-05-2022 //all
					//						String sql="select k.*,case when (k.Target_Amount-k.targetAchieved)>0 then (k.Target_Amount-k.targetAchieved) else 0 end as balance,to_char (round(nvl((k.targetAchieved*100)/k.Target_Amount,0),2) || ' %') as percen1 from (select main_qry.* from (select a.branch,(select branch_name from branch_master where branch_code=branch)as Bname,(nvl(a.target_amount1,0))*12 as Target_Amount,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)+nvl(b5.achieved_m5,0)+nvl(b6.achieved_m6,0)+nvl(b7.achieved_m7,0)+nvl(b8.achieved_m8,0)+nvl(b9.achieved_m9,0)+nvl(b10.achieved_m10,0)+nvl(b11.achieved_m11,0)+nvl(b12.achieved_m12,0))as targetAchieved,nvl(b.achieved_m1,0) as m1_Acheived,nvl(b2.achieved_m2,0)as  m2_Acheived,nvl(b3.achieved_m3,0) as m3_Acheived,nvl(b4.achieved_m4,0) m4_Acheived,nvl(b5.achieved_m5,0) as m5_Acheived,nvl(b6.achieved_m6,0)as  m6_Acheived,nvl(b7.achieved_m7,0) as m7_Acheived,nvl(b8.achieved_m8,0) m8_Acheived,nvl(b9.achieved_m9,0) as m9_Acheived,nvl(b10.achieved_m10,0)as  m10_Acheived,nvl(b11.achieved_m11,0) as m11_Acheived,nvl(b12.achieved_m12,0) m12_Acheived from ( select branch ,sum(amount) as target_amount1 from target_master where month in (4) and year="+year1+" and scheme_name='LOWCOST' group by branch)a left join               ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m1 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/04/"+year1+"','dd/MM/yyyy') and to_date('30/04/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch             )b on a.branch=b.livebranch left join          (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m2 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/05/"+year1+"','dd/MM/yyyy') and to_date('31/05/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch            )b2 on a.branch=b2.livebranch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m3 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/06/"+year1+"','dd/MM/yyyy') and to_date('30/06/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch          )b3 on a.branch=b3.livebranch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m4 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/07/"+year1+"','dd/MM/yyyy') and to_date('31/07/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch            )b4 on a.branch=b4.livebranch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m5 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/08/"+year1+"','dd/MM/yyyy') and to_date('31/08/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b5 on a.branch=b5.livebranch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m6 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/09/"+year1+"','dd/MM/yyyy') and to_date('30/09/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b6 on a.branch=b6.livebranch left join               (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m7 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/10/"+year1+"','dd/MM/yyyy') and to_date('31/10/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch             )b7 on a.branch=b7.livebranch left join               (               select main_qry2.branch,sum(main_qry2.achieved)as achieved_m8 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/11/"+year1+"','dd/MM/yyyy') and to_date('30/11/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b8 on a.branch=b8.livebranch left join (              select main_qry2.branch,sum(main_qry2.achieved)as achieved_m9 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/12/"+year1+"','dd/MM/yyyy') and to_date('31/12/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b9 on a.branch=b9.livebranch left join (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m10 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/01/"+year2+"','dd/MM/yyyy') and to_date('31/01/"+year2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b10 on a.branch=b10.livebranch left join      (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m11 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/02/"+year2+"','dd/MM/yyyy') and to_date('28/02/"+year2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch             )b11 on a.branch=b11.livebranch left join     (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m12 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/03/"+year2+"','dd/MM/yyyy') and to_date('31/03/"+year2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch         )b12 on a.branch=b12.livebranch)main_qry order by main_qry.branch)k ";

											//21-05-2022 particular
											//										String sql="select k.*,case when (k.Target_Amount-k.targetAchieved)>0 then (k.Target_Amount-k.targetAchieved) else 0 end as balance,to_char (round(nvl((k.targetAchieved*100)/k.Target_Amount,0),2) || ' %') as percen1 from (select main_qry.* from (select a.branch,(select branch_name from branch_master where branch_code=a.branch)as Bname,(nvl(a.target_amount1,0))*12 as Target_Amount,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)+nvl(b5.achieved_m5,0)+nvl(b6.achieved_m6,0)+nvl(b7.achieved_m7,0)+nvl(b8.achieved_m8,0)+nvl(b9.achieved_m9,0)+nvl(b10.achieved_m10,0)+nvl(b11.achieved_m11,0)+nvl(b12.achieved_m12,0))as targetAchieved,nvl(b.achieved_m1,0) as m1_Acheived,nvl(b2.achieved_m2,0)as  m2_Acheived,nvl(b3.achieved_m3,0) as m3_Acheived,nvl(b4.achieved_m4,0) m4_Acheived,nvl(b5.achieved_m5,0) as m5_Acheived,nvl(b6.achieved_m6,0)as  m6_Acheived,nvl(b7.achieved_m7,0) as m7_Acheived,nvl(b8.achieved_m8,0) m8_Acheived,nvl(b9.achieved_m9,0) as m9_Acheived,nvl(b10.achieved_m10,0)as  m10_Acheived,nvl(b11.achieved_m11,0) as m11_Acheived,nvl(b12.achieved_m12,0) m12_Acheived from ( select branch ,sum(amount) as target_amount1 from target_master where month in (4) and year="+year1+" and scheme_name='LOWCOST' group by branch)a left join               ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m1 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/04/"+year1+"','dd/MM/yyyy') and to_date('30/04/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch             )b on a.branch=b.branch left join          (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m2 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/05/"+year1+"','dd/MM/yyyy') and to_date('31/05/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch            )b2 on a.branch=b2.branch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m3 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/06/"+year1+"','dd/MM/yyyy') and to_date('30/06/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch          )b3 on a.branch=b3.branch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m4 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/07/"+year1+"','dd/MM/yyyy') and to_date('31/07/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch            )b4 on a.branch=b4.branch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m5 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/08/"+year1+"','dd/MM/yyyy') and to_date('31/08/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b5 on a.branch=b5.branch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m6 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/09/"+year1+"','dd/MM/yyyy') and to_date('30/09/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b6 on a.branch=b6.branch left join               (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m7 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/10/"+year1+"','dd/MM/yyyy') and to_date('31/10/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch             )b7 on a.branch=b7.branch left join               (               select main_qry2.branch,sum(main_qry2.achieved)as achieved_m8 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/11/"+year1+"','dd/MM/yyyy') and to_date('30/11/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b8 on a.branch=b8.branch left join (              select main_qry2.branch,sum(main_qry2.achieved)as achieved_m9 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/12/"+year1+"','dd/MM/yyyy') and to_date('31/12/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b9 on a.branch=b9.branch left join (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m10 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/01/"+year2+"','dd/MM/yyyy') and to_date('31/01/"+year2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b10 on a.branch=b10.branch left join      (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m11 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/02/"+year2+"','dd/MM/yyyy') and to_date('28/02/"+year2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch             )b11 on a.branch=b11.branch left join     (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m12 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/03/"+year2+"','dd/MM/yyyy') and to_date('31/03/"+year2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch         )b12 on a.branch=b12.branch)main_qry order by main_qry.branch)k where k.branch="+BCode+"";

											//21-05-2022 all
										//String sql="select k.*,case when (k.Target_Amount-k.targetAchieved)>0 then (k.Target_Amount-k.targetAchieved) else 0 end as balance,case when k.targetAchieved<> 0 and k.Target_Amount<>0 then (to_char (round(nvl((k.targetAchieved*100)/k.Target_Amount,0),2) || ' %')) else '0.0 %' end as percen1 from (select main_qry.* from (select a.branch,(select branch_name from branch_master where branch_code=a.branch)as Bname,(nvl(a.target_amount1,0))*12 as Target_Amount,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)+nvl(b5.achieved_m5,0)+nvl(b6.achieved_m6,0)+nvl(b7.achieved_m7,0)+nvl(b8.achieved_m8,0)+nvl(b9.achieved_m9,0)+nvl(b10.achieved_m10,0)+nvl(b11.achieved_m11,0)+nvl(b12.achieved_m12,0))as targetAchieved,nvl(b.achieved_m1,0) as m1_Acheived,nvl(b2.achieved_m2,0)as  m2_Acheived,nvl(b3.achieved_m3,0) as m3_Acheived,nvl(b4.achieved_m4,0) m4_Acheived,nvl(b5.achieved_m5,0) as m5_Acheived,nvl(b6.achieved_m6,0)as  m6_Acheived,nvl(b7.achieved_m7,0) as m7_Acheived,nvl(b8.achieved_m8,0) m8_Acheived,nvl(b9.achieved_m9,0) as m9_Acheived,nvl(b10.achieved_m10,0)as  m10_Acheived,nvl(b11.achieved_m11,0) as m11_Acheived,nvl(b12.achieved_m12,0) m12_Acheived from ( select branch ,sum(amount) as target_amount1 from target_master where month in (4) and year="+year1+" and scheme_name='RD' group by branch)a left join               ( select main_qry2.branch,sum(main_qry2.achieved)as achieved_m1 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/04/"+year1+"','dd/MM/yyyy') and to_date('30/04/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch             )b on a.branch=b.branch left join          (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m2 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/05/"+year1+"','dd/MM/yyyy') and to_date('31/05/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch            )b2 on a.branch=b2.branch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m3 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/06/"+year1+"','dd/MM/yyyy') and to_date('30/06/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch          )b3 on a.branch=b3.branch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m4 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/07/"+year1+"','dd/MM/yyyy') and to_date('31/07/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch            )b4 on a.branch=b4.branch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m5 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/08/"+year1+"','dd/MM/yyyy') and to_date('31/08/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b5 on a.branch=b5.branch left join               (select main_qry2.branch,sum(main_qry2.achieved)as achieved_m6 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/09/"+year1+"','dd/MM/yyyy') and to_date('30/09/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b6 on a.branch=b6.branch left join               (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m7 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/10/"+year1+"','dd/MM/yyyy') and to_date('31/10/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch             )b7 on a.branch=b7.branch left join               (               select main_qry2.branch,sum(main_qry2.achieved)as achieved_m8 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/11/"+year1+"','dd/MM/yyyy') and to_date('30/11/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b8 on a.branch=b8.branch left join (              select main_qry2.branch,sum(main_qry2.achieved)as achieved_m9 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/12/"+year1+"','dd/MM/yyyy') and to_date('31/12/"+year1+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b9 on a.branch=b9.branch left join (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m10 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/01/"+year2+"','dd/MM/yyyy') and to_date('31/01/"+year2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch              )b10 on a.branch=b10.branch left join      (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m11 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/02/"+year2+"','dd/MM/yyyy') and to_date('28/02/"+year2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch             )b11 on a.branch=b11.branch left join     (             select main_qry2.branch,sum(main_qry2.achieved)as achieved_m12 from (select substr(Account_no,0,3) as branch,nvl(sum(Transaction_amount),0) as achieved from DAily_transaction_table where flag='AC' and transaction_type='Credit' and transaction_date between to_date('01/03/"+year2+"','dd/MM/yyyy') and to_date('31/03/"+year2+"','dd/MM/yyyy')   group by account_no)main_qry2 group by main_qry2.branch order by main_qry2.branch         )b12 on a.branch=b12.branch)main_qry order by main_qry.branch)k ";

										//03-05-2024 New Logic
 										String sql="select k.*,case when (k.Target_Amount-k.targetAchieved)>0 then (k.Target_Amount-k.targetAchieved) else 0 end as balance,case when k.targetAchieved<> 0 and k.Target_Amount<>0 then (to_char (round(nvl((k.targetAchieved*100)/k.Target_Amount,0),2) || ' %')) else '0.0 %' end as percen1 from (select main_qry.* from (select a.branch,(select branch_name from branch_master where branch_code=a.branch)as Bname,(nvl(a.target_amount1,0))*12 as Target_Amount,(nvl(b.achieved_m1,0)+nvl(b2.achieved_m2,0)+nvl(b3.achieved_m3,0)+nvl(b4.achieved_m4,0)+nvl(b5.achieved_m5,0)+nvl(b6.achieved_m6,0)+nvl(b7.achieved_m7,0)+nvl(b8.achieved_m8,0)+nvl(b9.achieved_m9,0)+nvl(b10.achieved_m10,0)+nvl(b11.achieved_m11,0)+nvl(b12.achieved_m12,0))as targetAchieved,nvl(b.achieved_m1,0) as m1_Acheived,nvl(b2.achieved_m2,0)as  m2_Acheived,nvl(b3.achieved_m3,0) as m3_Acheived,nvl(b4.achieved_m4,0) m4_Acheived,nvl(b5.achieved_m5,0) as m5_Acheived,nvl(b6.achieved_m6,0)as  m6_Acheived,nvl(b7.achieved_m7,0) as m7_Acheived,nvl(b8.achieved_m8,0) m8_Acheived,nvl(b9.achieved_m9,0) as m9_Acheived,nvl(b10.achieved_m10,0)as  m10_Acheived,nvl(b11.achieved_m11,0) as m11_Acheived,nvl(b12.achieved_m12,0) m12_Acheived from ( select branch ,sum(amount) as target_amount1 from target_master where month in (4) and year="+year1+" and scheme_name='RD' group by branch)a left join                      ( Select Branch,sum(Deposit_Amount) as achieved_m1 from RD_Master_View_C where open_date between to_date('01/04/"+year1+"','dd/MM/yyyy') and to_date('30/04/"+year1+"','dd/MM/yyyy') group by Branch)b on a.branch=b.branch left join                    ( Select Branch,sum(Deposit_Amount) as achieved_m2 from RD_Master_View_C where open_date between to_date('01/05/"+year1+"','dd/MM/yyyy') and to_date('31/05/"+year1+"','dd/MM/yyyy') group by Branch )b2 on a.branch=b2.branch left join                      (Select Branch,sum(Deposit_Amount) as achieved_m3 from RD_Master_View_C where open_date between to_date('01/06/"+year1+"','dd/MM/yyyy') and to_date('30/06/"+year1+"','dd/MM/yyyy') group by Branch)b3 on a.branch=b3.branch left join                       (Select Branch,sum(Deposit_Amount) as achieved_m4 from RD_Master_View_C where open_date between to_date('01/07/"+year1+"','dd/MM/yyyy') and to_date('31/07/"+year1+"','dd/MM/yyyy') group by Branch)b4 on a.branch=b4.branch left join                      (Select Branch,sum(Deposit_Amount) as achieved_m5 from RD_Master_View_C where open_date between to_date('01/08/"+year1+"','dd/MM/yyyy') and to_date('31/08/"+year1+"','dd/MM/yyyy') group by Branch)b5 on a.branch=b5.branch left join                        (Select Branch,sum(Deposit_Amount) as achieved_m6 from RD_Master_View_C where open_date between to_date('01/09/"+year1+"','dd/MM/yyyy') and to_date('30/09/"+year1+"','dd/MM/yyyy') group by Branch )b6 on a.branch=b6.branch left join                        (Select Branch,sum(Deposit_Amount) as achieved_m7 from RD_Master_View_C where open_date between to_date('01/10/"+year1+"','dd/MM/yyyy') and to_date('31/10/"+year1+"','dd/MM/yyyy') group by Branch )b7 on a.branch=b7.branch left join                     (Select Branch,sum(Deposit_Amount) as achieved_m8 from RD_Master_View_C where open_date between to_date('01/11/"+year1+"','dd/MM/yyyy') and to_date('30/11/"+year1+"','dd/MM/yyyy') group by Branch)b8 on a.branch=b8.branch left join                     (Select Branch,sum(Deposit_Amount) as achieved_m9 from RD_Master_View_C where open_date between to_date('01/12/"+year1+"','dd/MM/yyyy') and to_date('31/12/"+year1+"','dd/MM/yyyy') group by Branch )b9 on a.branch=b9.branch left join                     (Select Branch,sum(Deposit_Amount) as achieved_m10 from RD_Master_View_C where open_date between to_date('01/01/"+year2+"','dd/MM/yyyy') and to_date('31/01/"+year2+"','dd/MM/yyyy') group by Branch)b10 on a.branch=b10.branch left join                      ( Select Branch,sum(Deposit_Amount) as achieved_m11 from RD_Master_View_C where open_date between to_date('01/02/"+year2+"','dd/MM/yyyy') and to_date('28/02/"+year2+"','dd/MM/yyyy') group by Branch)b11 on a.branch=b11.branch left join                       ( Select Branch,sum(Deposit_Amount) as achieved_m12 from RD_Master_View_C where open_date between to_date('01/03/"+year2+"','dd/MM/yyyy') and to_date('31/03/"+year2+"','dd/MM/yyyy') group by Branch)b12   on a.branch=b12.branch)main_qry order by main_qry.branch)k ";

											
											
					
					System.out.println(sql);
								return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
									
									SimpleBranch gl=new SimpleBranch();
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(3));  //targetAmt
									gl.setS142(rs.getDouble(4));  //targetAcheived
									
									gl.setS143(rs.getDouble(5));  //m1
									
									gl.setS144(rs.getDouble(6));  //m2
									gl.setS145(rs.getDouble(7));  //m3
									gl.setS146(rs.getDouble(8));  //m4
									gl.setS147(rs.getDouble(9));  //m5
									gl.setS148(rs.getDouble(10));  //m6
									gl.setS149(rs.getDouble(11));  //m7
									
									gl.setS150(rs.getDouble(12));  //m8
									gl.setS151(rs.getDouble(13));  //m9
									gl.setS152(rs.getDouble(14));  //m10
									gl.setS153(rs.getDouble(15));  //m11
									gl.setS154(rs.getDouble(16));  //m12
									
									//17-05-2022
									gl.setS155(rs.getDouble(17));  //balance
									gl.setS32(rs.getString(18));  //percent %
									
									
									
									
									
									return gl;
								}
											 }     );
										}


						 //10-05-2024
						 public List<SimpleBranch> getExpensesReport_GL_Monthly(String From_Date,String To_Date,String FinDate,int Branch)
						 {

								//--Set Connection----------------------------
											int j=RAndC;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
											//String sql="select a.Branch,(select Branch_Name from Branch_Master where branch_code=a.Branch) as BName,a.Gl_code,a.gl_name,a.yearly_Amount,a.monthly_limit,(select nvl(sum(transaction_amount),0) from Daily_Transaction_table where transaction_type='Debit' and flag='GL' and account_no=a.gl_code and branch=a.branch and transaction_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy')) as monthly_Expenses from (select branch,Gl_code,gl_name,yearly_Amount,sum(Amount) as monthly_limit from expense_master_new where  to_char(branch) like '%"+Branch+"%' and from_date>=to_date('"+From_Date+"','dd/MM/yyyy') and to_date<=to_date('"+To_Date+"','dd/MM/yyyy') group by gl_code,gl_name,YEARLY_AMOUNT,branch order by  gl_code)a  order by a.Branch,a.GL_Code";
											//21-05-2024
											//String sql="select a.Branch,(select Branch_Name from Branch_Master where branch_code=a.Branch) as BName,a.Gl_code,a.gl_name,a.yearly_Amount,a.monthly_limit,(select nvl(sum(transaction_amount),0) from Daily_Transaction_table where transaction_type='Debit' and flag='GL' and account_no=a.gl_code and branch=a.branch and transaction_date between to_date('"+From_Date+"','dd/MM/yyyy') and LAST_DAY(to_date('"+To_Date+"','dd/MM/yyyy'))) as monthly_Expenses from (select branch,Gl_code,gl_name,yearly_Amount,sum(Amount) as monthly_limit from expense_master_new where  to_char(branch) like '%"+Branch+"%' and from_date>=to_date('"+From_Date+"','dd/MM/yyyy') and to_date<=LAST_DAY(to_date('"+To_Date+"','dd/MM/yyyy')) group by gl_code,gl_name,YEARLY_AMOUNT,branch order by  gl_code)a  order by a.Branch,a.GL_Code";

											//22-05-2024
											//String sql="select a.Branch,(select Branch_Name from Branch_Master where branch_code=a.Branch) as BName,a.Gl_code,a.gl_name,a.yearly_Amount,a.monthly_limit as Period_Limit,a.noofmonths,a.monthly_limit/a.noofmonths as monthly_limit,mon_exe.monthly_Expenses,a.monthly_limit-mon_exe.monthly_Expenses as monthly_balance,a.yearly_Amount-mon_exe.monthly_Expenses as yearly_balance from (select branch,Gl_code,gl_name,yearly_Amount,sum(Amount) as monthly_limit,count(*) as noofmonths from expense_master_new where  to_char(branch) like '%"+Branch+"%' and from_date>=to_date('"+From_Date+"','dd/MM/yyyy') and to_date<=LAST_DAY(to_date('"+To_Date+"','dd/MM/yyyy')) group by gl_code,gl_name,YEARLY_AMOUNT,branch order by  gl_code)a left join (select Branch,Account_no,nvl(sum(transaction_amount),0) as monthly_Expenses from Daily_Transaction_GL_table where transaction_type='Debit' and flag='GL'  and transaction_date between to_date('"+From_Date+"','dd/MM/yyyy') and LAST_DAY(to_date('"+To_Date+"','dd/MM/yyyy')) group by Account_no,Branch) mon_exe on  a.gl_code=mon_exe.account_no and a.branch=mon_exe.branch order by  a.Branch";	
											
											//18-06-2024
											String sql="select a.Branch,(select Branch_Name from Branch_Master where branch_code=a.Branch) as BName,a.Gl_code,a.gl_name,a.yearly_Amount,a.monthly_limit as Period_Limit,a.noofmonths,a.monthly_limit/a.noofmonths as monthly_limit,mon_exe.monthly_Expenses,a.monthly_limit-mon_exe.monthly_Expenses as monthly_balance,a.yearly_Amount-yr_exe.yearly_Expenses2 as yearly_balance from (select branch,Gl_code,gl_name,yearly_Amount,sum(Amount) as monthly_limit,count(*) as noofmonths from expense_master_new where  to_char(branch) like '%"+Branch+"%' and from_date>=to_date('"+From_Date+"','dd/MM/yyyy') and to_date<=LAST_DAY(to_date('"+To_Date+"','dd/MM/yyyy')) group by gl_code,gl_name,YEARLY_AMOUNT,branch order by  gl_code)a left join (select Branch,Account_no,nvl(sum(transaction_amount),0) as monthly_Expenses from Daily_Transaction_GL_table where transaction_type='Debit' and flag='GL'  and transaction_date between to_date('"+From_Date+"','dd/MM/yyyy') and LAST_DAY(to_date('"+To_Date+"','dd/MM/yyyy')) group by Account_no,Branch) mon_exe on  a.gl_code=mon_exe.account_no and a.branch=mon_exe.branch left join (select Branch,Account_no,nvl(sum(transaction_amount),0) as yearly_Expenses2 from Daily_Transaction_GL_table where transaction_type='Debit' and flag='GL'  and transaction_date between to_date('"+FinDate+"','dd/MM/yyyy') and LAST_DAY(to_date('"+To_Date+"','dd/MM/yyyy')) group by Account_no,Branch) yr_exe on  a.gl_code=yr_exe.account_no and a.branch=yr_exe.branch order by  a.Branch";

											//System.out.println(sql);
											System.out.println("new="+sql);

								return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  
									
									SimpleBranch gl=new SimpleBranch();
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									/*gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(5));  //targetAmt
									gl.setS142(rs.getDouble(6));  //Acheived
									gl.setS13(rs.getFloat(7));  //balance
									
									gl.setS32(rs.getString(3));  //GL_Code
									gl.setS33(rs.getString(4));  //GL_Name
*/								
									
									gl.setS1(Integer.parseInt(rs.getString(1)));  //Branch
									
									
									gl.setS2(rs.getString(1));  //Branch
									gl.setS3(rs.getString(2));  //Branch Name
									gl.setS141(rs.getDouble(5));  //Yearly Amt
									gl.setS142(rs.getDouble(8));  //Monthly Limit
									gl.setS143(rs.getDouble(9));  //Recuuurrring Expenses
									gl.setS144(rs.getDouble(10));  //Monthly Balance
									gl.setS145(rs.getDouble(11));  //Yearly Balance
									gl.setS13(rs.getFloat(11));  //balance
									
									gl.setS32(rs.getString(3));  //GL_Code
									gl.setS33(rs.getString(4));  //GL_Name
									
									
									return gl;
								}
											 }     );
										}

}
