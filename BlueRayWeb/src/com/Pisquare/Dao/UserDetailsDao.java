package com.Pisquare.Dao;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.List.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.context.request.RequestContextHolder;

import com.Pisquare.Beans.Login;
import com.Pisquare.Beans.Response.State;
import com.Pisquare.Beans.Search;
import com.Pisquare.Beans.Simple;
import com.Pisquare.Beans.SimpleBranch;
import com.Pisquare.Controllers.Configuration_Controller;

import org.apache.commons.io.IOUtils;

public class UserDetailsDao {
	
	int Binfo=201;
	
	@Autowired
	private Configuration_Controller con;
JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template)
	{
		this.template=template;
		
	}
	
	public static String newline = System.getProperty("line.separator");
	
	
		
		//1. Check_Already_User
		
		//-------------------------------------------------NO OF RECORDS - SBCA_MASTER---------------------------------------------------------------------
				public int Check_Already_User(String User_Id)
				{

					//--Set Connection----------------------------
					int j=Binfo;
					this.template=con.getCon2(j);
					//-----------------------------------------------------
	
	
					int i=0;
					String query = "Select count(*) from Login_Details where Username='"+User_Id+"'";
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
		
		
		
				//2. getUserPassword
		
		public List<SimpleBranch> getUserPassword(String userName) {

			//--Set Connection----------------------------
			int j=Binfo;
			this.template=con.getCon2(j);
			//-----------------------------------------------------
			return template.query("select * from LOGINDETAILS where Username='"+userName+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
			{  
	
				SimpleBranch gl=new SimpleBranch();
				gl.setS3(rs.getString(2));
				
				return gl;
			}
			 }     );
		}
		
			
	
				//4. Get_Current_Date
					public String Get_Current_Date(int Bcode) throws SQLException
							{
				
								//--Set Connection----------------------------
								int j=Bcode;
								this.template=con.getCon2(j);
								//-----------------------------------------------------
								
								String Current_date=null;
								try{
									CallableStatement stmt=template.getDataSource().getConnection().prepareCall("{call Get_Current_Date(?)}");
									//stmt.setString(1,Username);
									//stmt.setString(2,Password);  
									//register the OUT parameter before calling the stored procedure
										stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
									stmt.executeQuery();
									//read the OUT parameter now
									Current_date = stmt.getString(1);
									System.out.println("Current_date from DB"+Current_date);
									//Connection conString=template.getDataSource().getConnection();
									//conString.
								}catch(Exception e)
								 	 {
									System.out.println(e);
								 	 }
								
								return Current_date;
							}
				//5. isValidUser3
				public boolean isValidUser3(String Username, String Password) throws SQLException
					{

					//--Set Connection----------------------------
					int j=Binfo;
					this.template=con.getCon2(j);
					//-----------------------------------------------------
					
					System.out.println("Pasword"+Password);
					
					int i=0;
					String query = "select count(*) from LOGINDETAILS where USERNAME='"+Username+"' and PWD='"+Password+"' and value !='B'";
					System.out.println("query ------"+query);
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
								  System.out.println("From DAo="+i);
							  }
						}
						
						//i=resultSet.getRow();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
		/*
			try{
				CallableStatement stmt=template.getDataSource().getConnection().prepareCall("{call CHECKLOGIN3(?,?,?)}");
				stmt.setString(1,Username);
				stmt.setString(2,Password);  
				//register the OUT parameter before calling the stored procedure
					stmt.registerOutParameter(3, java.sql.Types.INTEGER);
				stmt.executeQuery();
				//read the OUT parameter now
					 flag = stmt.getInt(3);
				
				//Connection conString=template.getDataSource().getConnection();
				//conString.
			}catch(Exception e)
			 	 {
				System.out.println(e);
			 	 }
			*/
			if(i==1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	
	
	
	
	//6.GetPermission
	public String GetPermission_RandC(String user,String page) throws SQLException
					{
					

		//--Set Connection----------------------------
		int j=Binfo;
		this.template=con.getCon2(j);
		//-----------------------------------------------------
		
		String i=null;
		String query = "select TO_VIEW from PERMISSIONDETAILS where USERNAME='"+user+"' and PAGE='"+page+"'";
	
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
			
			
						
			if (resultSet!= null)
			{ 
				 while (resultSet.next())
				 {
					 i=resultSet.getString(1);
				}
			}
			
			
			
			
			//i=resultSet.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return i;
					/*
						System.out.println(" User="+ user);
						System.out.println(" Path="+ page);
						
						String permission=null;
						try{
							CallableStatement stmt=template.getDataSource().getConnection().prepareCall("{call Get_Permission_Set_RandC(?,?,?)}");
							stmt.setString(1,user);
							stmt.setString(2,page);
							
							//register the OUT parameter before calling the stored procedure
							stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
							
							stmt.executeQuery();
						
							//stmt.execute();
							//read the OUT parameter now
							     permission=stmt.getString(3);
							    
							     System.out.println(" permission="+ permission+"- page="+ page);
							   
							    
							     
							    
								// flag = stmt.getInt(3);
								// ResultSet rs = ((OracleCallableStatement)stmt).getCursor(4);
								// ResultSet rs1= (ResultSet) stmt.getObject(4);
	
								// while (rs.next ())
								// {      System.out.println ("method 1="+rs.getInt(1));
								// flag=rs.getInt(1);
								// }
								// while (rs1.next ())
								    //  System.out.println ("method 2="+rs1.getInt(1));
						}catch(Exception e)
						 	 {
							System.out.println(e);
						 	 }
						return permission;
						*/
					
					}
	
	//7. UpdateVerify1
	public int UpdateVerify1(int Transaction_Id,String Transaction_Date,String user,String Current,int Bcode)					{ 
							
							//--Set Connection----------------------------
							int j=Bcode;
							this.template=con.getCon2(j);
				//-----------------------------------------------------
	
			
							//String	upsql1="Update Daily_Transaction set VERIFIED_BY='"+user+"',VERIFIED_DATE=to_date('"+Current+"','dd/MM/yyyy') where Transaction_id="+Transaction_Id+" and Transaction_date=to_date('"+Transaction_Date+"','dd/MM/yyyy')";
								//template.update(upsql1);
								int flag=0;
								try{
									//Verify_Transaction1(Transaction_Id1 in number,Transaction_Date1 in varchar2,Authorized_By1 in varchar2,Authorized_Date1 in varchar2)
									CallableStatement stmt=template.getDataSource().getConnection().prepareCall("{call Verify_Transaction1(?,?,?,?)}");
									stmt.setInt(1,Transaction_Id);
									stmt.setString(2,Transaction_Date);
									stmt.setString(3,user);
									stmt.setString(4,Current);
									
									//register the OUT parameter before calling the stored procedure
										//stmt.registerOutParameter(4, OracleTypes.CURSOR);
									 //ResultSet rs =stmt.executeQuery();
									
									 try{
											ResultSet rs =stmt.executeQuery();
											flag=1;
											}
											catch(Exception e)
										 	 {
											System.out.println(e);
											flag=2;
										 	 }	
									
								}catch(Exception e)
								 	 {
									System.out.println(e);
								 	 }	
								return flag;
						
					   }
				
	//8. UpdateVerify2				
						public int UpdateVerify2(int Transaction_Id,String Transaction_Date,String user,String Current,int Bcode)					{ 
							//--Set Connection----------------------------
							int j=Bcode;
							this.template=con.getCon2(j);
							//-----------------------------------------------------
	
	
							
							//String	upsql1="Update Daily_Transaction set VERIFIED_BY_3='"+user+"',VERIFIED_BY_DATE_3=to_date('"+Current+"','dd/MM/yyyy') where Transaction_id="+Transaction_Id+" and Transaction_date=to_date('"+Transaction_Date+"','dd/MM/yyyy')";
								//template.update(upsql1);
								int flag=0;
								try{
									//Verify_Transaction2(Transaction_Id1 in number,Transaction_Date1 in varchar2,Authorized_By1 in varchar2,Authorized_Date1 in varchar2)
									CallableStatement stmt=template.getDataSource().getConnection().prepareCall("{call Verify_Transaction2(?,?,?,?)}");
									stmt.setInt(1,Transaction_Id);
									stmt.setString(2,Transaction_Date);
									stmt.setString(3,user);
									stmt.setString(4,Current);
									
									//register the OUT parameter before calling the stored procedure
										//stmt.registerOutParameter(4, OracleTypes.CURSOR);
									
									try{
									ResultSet rs =stmt.executeQuery();
									flag=1;
									}
									catch(Exception e)
								 	 {
									System.out.println(e);
									flag=2;
								 	 }	
									
								}catch(Exception e)
								 	 {
									System.out.println(e);
								 	 }	
								return flag;	
								
						
					   }
	
						//9. UpdateVerify3
						public int UpdateVerify3(int Transaction_Id,String Transaction_Date,String user,String Current,int Bcode)					{ 
												
												//--Set Connection----------------------------
												int j=Bcode;
												this.template=con.getCon2(j);
									//-----------------------------------------------------
	
								
												//String	upsql1="Update Daily_Transaction set VERIFIED_BY='"+user+"',VERIFIED_DATE=to_date('"+Current+"','dd/MM/yyyy') where Transaction_id="+Transaction_Id+" and Transaction_date=to_date('"+Transaction_Date+"','dd/MM/yyyy')";
													//template.update(upsql1);
													int flag=0;
													try{
														//Verify_Transaction1(Transaction_Id1 in number,Transaction_Date1 in varchar2,Authorized_By1 in varchar2,Authorized_Date1 in varchar2)
														CallableStatement stmt=template.getDataSource().getConnection().prepareCall("{call Verify_Transaction3(?,?,?,?)}");
														stmt.setInt(1,Transaction_Id);
														stmt.setString(2,Transaction_Date);
														stmt.setString(3,user);
														stmt.setString(4,Current);
														
														//register the OUT parameter before calling the stored procedure
															//stmt.registerOutParameter(4, OracleTypes.CURSOR);
														try{
															ResultSet rs =stmt.executeQuery();
															flag=1;
															}
															catch(Exception e)
														 	 {
															System.out.println(e);
															flag=2;
														 	 }	
														
													}catch(Exception e)
													 	 {
														System.out.println(e);
													 	 }	
													return flag;
											
										   }
									
											
						//10. UpdateVerify4
						public int UpdateVerify4(int Transaction_Id,String Transaction_Date,String user,String Current,int Bcode)					{ 
												
												//--Set Connection----------------------------
												int j=Bcode;
												this.template=con.getCon2(j);
									//-----------------------------------------------------
	
								
												//String	upsql1="Update Daily_Transaction set VERIFIED_BY='"+user+"',VERIFIED_DATE=to_date('"+Current+"','dd/MM/yyyy') where Transaction_id="+Transaction_Id+" and Transaction_date=to_date('"+Transaction_Date+"','dd/MM/yyyy')";
													//template.update(upsql1);
													int flag=0;
													try{
														//Verify_Transaction1(Transaction_Id1 in number,Transaction_Date1 in varchar2,Authorized_By1 in varchar2,Authorized_Date1 in varchar2)
														CallableStatement stmt=template.getDataSource().getConnection().prepareCall("{call Verify_Transaction4(?,?,?,?)}");
														stmt.setInt(1,Transaction_Id);
														stmt.setString(2,Transaction_Date);
														stmt.setString(3,user);
														stmt.setString(4,Current);
														
														//register the OUT parameter before calling the stored procedure
															//stmt.registerOutParameter(4, OracleTypes.CURSOR);
														try{
															ResultSet rs =stmt.executeQuery();
															flag=1;
															}
															catch(Exception e)
														 	 {
															System.out.println(e);
															flag=2;
														 	 }	
														}catch(Exception e)
													 	 {
														System.out.println(e);
													 	 }	
													return flag;
											
										   }
									
						//11.UpdateVerify5
						public int UpdateVerify5(int Transaction_Id,String Transaction_Date,String user,String Current,int Bcode)					{ 
												
												//--Set Connection----------------------------
												int j=Bcode;
												this.template=con.getCon2(j);
									//-----------------------------------------------------
	
								
												//String	upsql1="Update Daily_Transaction set VERIFIED_BY='"+user+"',VERIFIED_DATE=to_date('"+Current+"','dd/MM/yyyy') where Transaction_id="+Transaction_Id+" and Transaction_date=to_date('"+Transaction_Date+"','dd/MM/yyyy')";
													//template.update(upsql1);
													int flag=0;
													try{
														//Verify_Transaction1(Transaction_Id1 in number,Transaction_Date1 in varchar2,Authorized_By1 in varchar2,Authorized_Date1 in varchar2)
														CallableStatement stmt=template.getDataSource().getConnection().prepareCall("{call Verify_Transaction5(?,?,?,?)}");
														stmt.setInt(1,Transaction_Id);
														stmt.setString(2,Transaction_Date);
														stmt.setString(3,user);
														stmt.setString(4,Current);
														
														//register the OUT parameter before calling the stored procedure
															//stmt.registerOutParameter(4, OracleTypes.CURSOR);
														try{
															ResultSet rs =stmt.executeQuery();
															flag=1;
															}
															catch(Exception e)
														 	 {
															System.out.println(e);
															flag=2;
														 	 }	
														
													}catch(Exception e)
													 	 {
														System.out.println(e);
													 	 }	
													return flag;
											
										   }
									
											
	
	
	//12.Transaction List using id And Date GL-----------------------------------------------------------------------------------------
		//.------------------------Flag='GL'  --------------------------------------
			public List<SimpleBranch> getSB_TransListUsingTxnId_Date_GL(int txnId,String txnDate,int Bcode){
				//--Set Connection----------------------------
				int j=Bcode;
				this.template=con.getCon2(j);
	//-----------------------------------------------------
	
	
				return template.query("select Daily_Transaction.TRANSACTION_ID,Daily_Transaction.TRANSACTION_DATE,Daily_Transaction.ACCOUNT_NO,Daily_Transaction.TRANSACTION_TYPE,Daily_Transaction.TRANSACTION_AMOUNT,Daily_Transaction.TRANSACTION_PARTICULARS,Daily_Transaction.FLAG,Daily_Transaction.CREATED_BY,Daily_Transaction.CREATED_DATE,Daily_Transaction.MODIFIED_BY,Daily_Transaction.MODIFIED_DATE,Daily_Transaction.PART_TRAN_ID,Daily_Transaction.AUTHORIZED_BY,Daily_Transaction.AUTHORIZED_DATE,Daily_Transaction.PAGE_SOURCE,Daily_Transaction.ACCOUNT_DESC,Daily_Transaction.VERIFIED_BY,Daily_Transaction.VERIFIED_DATE,Daily_Transaction.VERIFIED_BY_3,Daily_Transaction.VERIFIED_BY_DATE_3,Daily_Transaction.VERIFIED_BY_4,Daily_Transaction.VERIFIED_DATE_4,Daily_Transaction.VERIFIED_BY_5,Daily_Transaction.VERIFIED_DATE_5,GL_Master.GL_Name as Account_Name from daily_transaction left join GL_Master on Daily_Transaction.Account_No= GL_Master.GL_Code where Flag='GL'and transaction_id="+txnId+" and Transaction_Date=to_date('"+txnDate+"','dd/MM/yyyy')  order by Daily_Transaction.Transaction_Type",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
				{  
					 SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
					 SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
					
					SimpleBranch gl=new SimpleBranch(); 
				    gl.setS1(rs.getInt(1));	//TRANSACTION_ID
					gl.setS72(sdf.format(rs.getDate(2)));  //TRANSACTION_DATE
					gl.setS3(rs.getString(6));  //TRANSACTION_PARTICULARS
						gl.setS6(rs.getString(3));  //ACCOUNT_NO
					gl.setS2(rs.getString(4));  //TRANSACTION_TYPE
					//gl.setS13(rs.getFloat(5)); // TRANSACTION_AMOUNT
					gl.setS7(rs.getLong(5));
					
					DecimalFormat df = new DecimalFormat("0.00");
					String TransAmt=df.format(rs.getFloat(5));
					gl.setS71(TransAmt);
					
					gl.setS11(1);	//BALANCE			
					
					gl.setS4(rs.getString(16));	//ACCOUNT_DESC
					gl.setS5(rs.getString(7));	//FLAG		
					
					
					if(rs.getDate(9)!=null)
					gl.setS31(sd.format(rs.getDate(9))); //CREATED_DATE
					else
						gl.setS31(null);
				
				
					
					if(rs.getDate(18)!=null)
					gl.setS33(sd.format(rs.getDate(18)));//VERIFIED_DATE
					else
						gl.setS33(null);
					
					
					
					if(rs.getDate(20)!=null)
					gl.setS35(sd.format(rs.getDate(20)));//VERIFIED_BY_DATE_3
					else
						gl.setS35(null);
					
					
					gl.setS36(rs.getString(8));  //CREATED_BY
					gl.setS37(rs.getString(13)); //AUTHORIZED_BY
					gl.setS32(rs.getString(17)); //VERIFIED_BY
					gl.setS34(rs.getString(19)); //VERIFIED_BY_3
					gl.setS38(rs.getString(21)); //VERIFIED_BY_4
					gl.setS39(rs.getString(23)); //VERIFIED_BY_5
					
					gl.setS40(rs.getString(25)); //Account_Name
					
						
					return gl;
				}
				 }     );
			}
		
		//--------------------------------------------------------------------------------------------------------------------------------------------
	
			
			//13.Transaction List using id And Date GL------Flag=!GL   --------------------------------------
			public List<SimpleBranch> getSB_TransListUsingTxnId_Date_AC(int txnId,String txnDate,int Bcode){
				//--Set Connection----------------------------
				int j=Bcode;
				this.template=con.getCon2(j);
	//-----------------------------------------------------
	
	
				return template.query("select Daily_Transaction.TRANSACTION_ID,Daily_Transaction.TRANSACTION_DATE,Daily_Transaction.ACCOUNT_NO,Daily_Transaction.TRANSACTION_TYPE,Daily_Transaction.TRANSACTION_AMOUNT,Daily_Transaction.TRANSACTION_PARTICULARS,Daily_Transaction.FLAG,Daily_Transaction.CREATED_BY,Daily_Transaction.CREATED_DATE,Daily_Transaction.MODIFIED_BY,Daily_Transaction.MODIFIED_DATE,Daily_Transaction.PART_TRAN_ID,Daily_Transaction.AUTHORIZED_BY,Daily_Transaction.AUTHORIZED_DATE,Daily_Transaction.PAGE_SOURCE,Daily_Transaction.ACCOUNT_DESC,Daily_Transaction.VERIFIED_BY,Daily_Transaction.VERIFIED_DATE,Daily_Transaction.VERIFIED_BY_3,Daily_Transaction.VERIFIED_BY_DATE_3,Daily_Transaction.VERIFIED_BY_4,Daily_Transaction.VERIFIED_DATE_4,Daily_Transaction.VERIFIED_BY_5,Daily_Transaction.VERIFIED_DATE_5,Cust_Acc_Link.Customer_Name as Account_Name from daily_transaction left join Cust_Acc_Link on Daily_Transaction.Account_No=Cust_Acc_Link.Account_No where daily_transaction.Flag!='GL' and transaction_id="+txnId+" and Transaction_Date=to_date('"+txnDate+"','dd/MM/yyyy') order by Daily_Transaction.Account_No,Daily_Transaction.Transaction_Type",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
				{  
					 SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
					  SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
					SimpleBranch gl=new SimpleBranch(); 
				    gl.setS1(rs.getInt(1));	//TRANSACTION_ID
					gl.setS72(sdf.format(rs.getDate(2)));  //TRANSACTION_DATE
					gl.setS3(rs.getString(6));  //TRANSACTION_PARTICULARS
					gl.setS6(rs.getString(3));  //ACCOUNT_NO
					gl.setS2(rs.getString(4));  //TRANSACTION_TYPE
					//gl.setS13(rs.getFloat(5)); // TRANSACTION_AMOUNT
					
					gl.setS7(rs.getLong(5));
					
					DecimalFormat df = new DecimalFormat("0.00");
					String TransAmt=df.format(rs.getFloat(5));
					gl.setS71(TransAmt);
					
					gl.setS11(1);	//BALANCE			
					
					gl.setS4(rs.getString(16));	//ACCOUNT_DESC
					gl.setS5(rs.getString(7));	//FLAG		
					
				
					/*
					 * 1Daily_Transaction.TRANSACTION_ID,
2Daily_Transaction.TRANSACTION_DATE,
3Daily_Transaction.ACCOUNT_NO,
4Daily_Transaction.TRANSACTION_TYPE,
5Daily_Transaction.TRANSACTION_AMOUNT,
6Daily_Transaction.TRANSACTION_PARTICULARS,
7Daily_Transaction.FLAG,
8Daily_Transaction.CREATED_BY,
9Daily_Transaction.CREATED_DATE,
10Daily_Transaction.MODIFIED_BY,
11Daily_Transaction.MODIFIED_DATE,
12Daily_Transaction.PART_TRAN_ID,
13Daily_Transaction.AUTHORIZED_BY,
14Daily_Transaction.AUTHORIZED_DATE,
15Daily_Transaction.PAGE_SOURCE,
16Daily_Transaction.ACCOUNT_DESC,
17Daily_Transaction.VERIFIED_BY,
18Daily_Transaction.VERIFIED_DATE,
19Daily_Transaction.VERIFIED_BY_3,
20Daily_Transaction.VERIFIED_BY_DATE_3,
21Daily_Transaction.VERIFIED_BY_4,
22Daily_Transaction.VERIFIED_DATE_4,
23Daily_Transaction.VERIFIED_BY_5,
24Daily_Transaction.VERIFIED_DATE_5,
25GL_Master.GL_Name as Account_Name
*/
					 
					
					
					if(rs.getDate(9)!=null)
					gl.setS31(sd.format(rs.getDate(9))); //CREATED_DATE
					else
						gl.setS31(null);
				
				
					
					if(rs.getDate(18)!=null)
					gl.setS33(sd.format(rs.getDate(18)));//VERIFIED_DATE
					else
						gl.setS33(null);
					
					
					
					if(rs.getDate(20)!=null)
					gl.setS35(sd.format(rs.getDate(20)));//VERIFIED_BY_DATE_3
					else
						gl.setS35(null);
					
					
					gl.setS36(rs.getString(8));  //CREATED_BY
					gl.setS37(rs.getString(13)); //AUTHORIZED_BY
					gl.setS32(rs.getString(17)); //VERIFIED_BY
					gl.setS34(rs.getString(19)); //VERIFIED_BY_3
					gl.setS38(rs.getString(21)); //VERIFIED_BY_4
					gl.setS39(rs.getString(23)); //VERIFIED_BY_5
					
					gl.setS40(rs.getString(25)); //Account_Name
					
					return gl;
				}
				 }     );
			}
			
			
			
	
	//14. deleteTrans_MasterList_Date
				
			public int deleteTrans_MasterList_Date(int txnId,String txnDate,int Bcode){  
					//--Set Connection----------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
			//-----------------------------------------------------
	
	
				    String sql="delete from DAILY_TRANSACTION where TRANSACTION_ID="+txnId+" and TRANSACTION_DATE=to_date('"+txnDate+"','dd/MM/yyyy')";  
				    return template.update(sql);  
				}
				
				
			//15. getSB_TransList_Search			
				public List<SimpleBranch> getSB_TransList_Search(int Trans_Id,String Open_Date,String Close_Date,int Bcode){
					//--Set Connection----------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
			//-----------------------------------------------------
	
	
					return template.query("select * from daily_transaction where part_tran_id=1 and  Transaction_Date between to_date('"+Open_Date+"','dd/MM/yyyy') and to_date('"+Close_Date+"','dd/MM/yyyy') and transaction_id LIKE '%"+Trans_Id+"%' and Account_No LIKE '%"+Trans_Id+"%'"				+ "order by transaction_date desc,transaction_id desc",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
					{  
			           //select TRANSACTION_ID,TRANSACTION_DATE,ACCOUNT_NO,TRANSACTION_TYPE,TRANSACTION_AMOUNT,TRANSACTION_PARTICULARS from daily_transaction order by rownum desc
						  
			            SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
			            SimpleBranch gl=new SimpleBranch();
					    gl.setS1(rs.getInt(1));  //TRANSACTION_ID
						gl.setS2(sd.format(rs.getDate(2))); //TRANSACTION_DATE
						gl.setS3(rs.getString(3));  //ACCOUNT_NO
						gl.setS4(rs.getString(4));  //TRANSACTION_TYPE
						gl.setS13(rs.getFloat(5));  //TRANSACTION_AMOUNT
						gl.setS5(rs.getString(6));  //TRANSACTION_PARTICULARS
						
						gl.setS6(rs.getString(8));  //CREATED_BY
						
						if(rs.getDate(9)!=null)
						gl.setS31(sd.format(rs.getDate(9))); //CREATED_DATE
						else
							gl.setS31(null);
					
						gl.setS32(rs.getString(17)); //VERIFIED_BY
						
						if(rs.getDate(18)!=null)
						gl.setS33(sd.format(rs.getDate(18)));//VERIFIED_DATE
						else
							gl.setS33(null);
						
						gl.setS34(rs.getString(13)); //AUTHORIZED_BY
						
						if(rs.getDate(14)!=null)
						gl.setS35(sd.format(rs.getDate(14)));//AUTHORIZED_DATE
						else
							gl.setS35(null);
								
						return gl;
					}
					 }     );
				}
				
				
				/*
				 * 
				SELECT 
	cte.Branch,
	cte.Transaction_Id,
	cte.Transaction_Date,
	cte.Account_No,
	cte.Transaction_Particulars,
	
	cte.Page_Source,
	cte.Account_Desc,
	
	cte.Authorized_By,
	cte.Verified_By,
	cte.Verified_By_3,
	cte.Verified_By_4,
	cte.Verified_By_5,
	
	cte.Created_By,
	cte.Created_Date,
	Trans.Amount
	FROM Daily_Transaction_table cte left join 
	(
	Select 
	Branch,
	Transaction_Id as Trans_Id,
	Transaction_Date as Trans_Date,
	sum(Transaction_Amount) as Amount
	from  Daily_Transaction_table where Flag='GL' and Transaction_Type='Credit' group by Branch,Transaction_Id,Transaction_Date) Trans
	on cte.Transaction_Id=Trans.Trans_Id and cte.Transaction_Date=Trans.Trans_Date and cte.Branch = Trans.Branch
	left join Branch_Master on cte.Branch=Branch_Master.Branch_Code
	WHERE Part_Tran_Id = 1 
	and Transaction_Id like '%10002%' and Transaction_Date between TO_DATE('01/07/2017','dd/MM/yyyy') and TO_DATE('31/08/2017','dd/MM/yyyy') order by cte.Transaction_Date,cte.Created_Date desc
	
	<td><c:out value="${jd.s11}" /></td><!-- Branch -->
															
															<td><c:out value="${jd.s1}" /></td>
															<td><c:out value="${jd.s2}" /></td>
															<td><c:out value="${jd.s3}" /></td>
															<td><c:out value="${jd.s5}" /></td>
															<td><c:out value="${jd.s13}" /></td>
															<td><c:out value="${jd.s6}" /></td>
															<td><c:out value="${jd.s34}" /></td><!-- Authorized_By -->
															<td><c:out value="${jd.s32}" /></td><!-- Verified_By -->
															<td><c:out value="${jd.s36}" /></td><!-- Verified_By_3 -->
															<td><c:out value="${jd.s37}" /></td><!-- Verified_By_4 -->
															<td><c:out value="${jd.s38}" /></td><!-- Verified_By_5 -->
															
										<th>Branch</th>
														<th>Tran. Id</th>
														<th>Tran. Date</th>
														<th>Accno</th>
														<th>Particulars</th>
														<th>Amount</th>
														<th>Created By</th>
														<th>Level 1</th><!-- Authorized_By -->
														<th>Level 2</th><!-- Verified_By -->
														<th>Level 3</th><!-- Verified_By_3 -->
														<th>Level 4</th><!-- Verified_By_4	 -->
														<th>Level 5</th><!-- Verified_By_5	 -->
														<th>View</th>					
				 */
		
				
				//16.getTransaction_List
				public List<SimpleBranch> getTransaction_List(int txnId,String FromDate,String ToDate,String Flag,int Branch,int Bcode){
					//--Set Connection----------------------------
					int j=Binfo;
					this.template=con.getCon2(j);
		//-----------------------------------------------------
					if(Flag.equalsIgnoreCase("All"))
					{
						//String qry1="SELECT cte.Branch,cte.Transaction_Id,to_char(cte.Transaction_Date,'dd-MM-yyyy'),cte.Account_No,cte.Transaction_Particulars,cte.Page_Source,cte.Account_Desc,cte.Authorized_By,cte.Verified_By,cte.Verified_By_3,cte.Verified_By_4,cte.Verified_By_5,cte.Created_By,cte.Created_Date,Trans.Amount FROM Daily_Transaction_table cte left join (Select Branch,Transaction_Id as Trans_Id,Transaction_Date as Trans_Date,sum(Transaction_Amount) as Amount from  Daily_Transaction_table where Flag='GL' and Transaction_Type='Credit' group by Branch,Transaction_Id,Transaction_Date) Trans on cte.Transaction_Id=Trans.Trans_Id and cte.Transaction_Date=Trans.Trans_Date and cte.Branch = Trans.Branch left join Branch_Master on cte.Branch=Branch_Master.Branch_Code WHERE Part_Tran_Id = 1 and Transaction_Id like '%"+txnId+"%' and Transaction_Date between TO_DATE('"+FromDate+"','dd/MM/yyyy') and TO_DATE('"+ToDate+"','dd/MM/yyyy') and cte.Branch="+Branch+" order by cte.Transaction_Date desc,cte.Created_Date desc,to_number(substr(to_char(cte.Transaction_Id),-5,5)) desc,cte.Branch desc ";
						String qry1="select main_qry.*,b.FILE_NAME,b.verify_status,b.CUSTOMER_ID from(SELECT cte.Branch,cte.Transaction_Id,to_char(cte.Transaction_Date,'dd-MM-yyyy') as transdate,cte.Account_No,cte.Transaction_Particulars,cte.Page_Source,cte.Account_Desc,cte.Authorized_By,cte.Verified_By,cte.Verified_By_3,cte.Verified_By_4,cte.Verified_By_5,cte.Created_By,cte.Created_Date,Trans.Amount FROM Daily_Transaction_table cte left join (Select Branch,Transaction_Id as Trans_Id,Transaction_Date as Trans_Date,sum(Transaction_Amount) as Amount from  Daily_Transaction_table where Flag='GL' and Transaction_Type='Credit' group by Branch,Transaction_Id,Transaction_Date) Trans on cte.Transaction_Id=Trans.Trans_Id and cte.Transaction_Date=Trans.Trans_Date and cte.Branch = Trans.Branch left join Branch_Master on cte.Branch=Branch_Master.Branch_Code WHERE Part_Tran_Id = 1 and Transaction_Id like '%"+txnId+"%' and Transaction_Date between TO_DATE('"+FromDate+"','dd/MM/yyyy') and TO_DATE('"+ToDate+"','dd/MM/yyyy') and cte.Branch="+Branch+" order by cte.Transaction_Date desc,cte.Created_Date desc,to_number(substr(to_char(cte.Transaction_Id),-5,5)) desc,cte.Branch desc )main_qry left join (select FILE_NAME,to_char(TRANSACTION_DATE,'dd-MM-yyyy') as transdate,TRANSACTION_ID,VERIFY_STATUS,CUSTOMER_ID from savings_attachments)b on main_qry.TRANSACTION_ID=b.TRANSACTION_ID and main_qry.transdate=b.transdate";

						return template.query(qry1,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
					{  
								
										
								
						SimpleBranch gl=new SimpleBranch(); 
						gl.setS11(rs.getInt(1));	//Branch
					    gl.setS1(rs.getInt(2));	//TRANSACTION_ID
					    gl.setS2(rs.getString(3));	//TRANSACTION_DATE
						gl.setS3(rs.getString(4));  // //ACCOUNT_NO
						gl.setS5(rs.getString(5));  //Particulars
						gl.setS13(rs.getFloat(15)); // TRANSACTION_AMOUNT
						
						DecimalFormat df = new DecimalFormat("0.00");
						String TransAmt=df.format(rs.getFloat(15));
						gl.setS39(TransAmt);
						
						gl.setS6(rs.getString(13));  //Created By
						gl.setS34(rs.getString(8));  //Authorized_By
						gl.setS32(rs.getString(9));  //Verified_By
						gl.setS36(rs.getString(10));  //Verified_By_3
						gl.setS37(rs.getString(11));  //Verified_By_4
						gl.setS38(rs.getString(12));  //Verified_By_5
						
						NumberFormat formatter = new DecimalFormat("#0.00");
						String Amt=formatter.format(rs.getFloat(15));
						gl.setS39(Amt);  //Formatted Amt
						
						gl.setS131(rs.getString(16));  //File Name
						gl.setS132(rs.getString(17));  //Status
						gl.setS133(rs.getString(18));  //CustId
							
						return gl;
					}
					 }     );
					}
					else
					{
						String qry2="SELECT cte.Branch,cte.Transaction_Id,to_char(cte.Transaction_Date,'dd-MM-yyyy'),cte.Account_No,cte.Transaction_Particulars,cte.Page_Source,cte.Account_Desc,cte.Authorized_By,cte.Verified_By,cte.Verified_By_3,cte.Verified_By_4,cte.Verified_By_5,cte.Created_By,cte.Created_Date,Trans.Amount FROM Daily_Transaction_table cte left join (Select Branch,Transaction_Id as Trans_Id,Transaction_Date as Trans_Date,sum(Transaction_Amount) as Amount from  Daily_Transaction_table where Flag='GL' and Transaction_Type='Credit' group by Branch,Transaction_Id,Transaction_Date) Trans on cte.Transaction_Id=Trans.Trans_Id and cte.Transaction_Date=Trans.Trans_Date and cte.Branch = Trans.Branch left join Branch_Master on cte.Branch=Branch_Master.Branch_Code WHERE Part_Tran_Id = 1 and Transaction_Id like '%"+txnId+"%' and Transaction_Date between TO_DATE('"+FromDate+"','dd/MM/yyyy') and TO_DATE('"+ToDate+"','dd/MM/yyyy') and (Authorized_By is NULL or Verified_By is NULL or Verified_By_3 is NULL or Verified_By_4 is NULL or Verified_By_5 is NULL) and cte.Branch="+Branch+" order by cte.Transaction_Date desc,cte.Created_Date desc,to_number(substr(to_char(cte.Transaction_Id),-5,5)) desc,cte.Branch desc ";
						return template.query(qry2,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
						{  
	
							SimpleBranch gl=new SimpleBranch(); 
							gl.setS11(rs.getInt(1));	//Branch
						    gl.setS1(rs.getInt(2));	//TRANSACTION_ID
						    gl.setS2(rs.getString(3));	//TRANSACTION_DATE
							gl.setS3(rs.getString(4));  // //ACCOUNT_NO
							gl.setS5(rs.getString(5));  //Particulars
							gl.setS13(rs.getFloat(15)); // TRANSACTION_AMOUNT
							
							DecimalFormat df = new DecimalFormat("0.00");
							String TransAmt=df.format(rs.getFloat(15));
							gl.setS39(TransAmt);
							
							gl.setS6(rs.getString(13));  //Created By
							gl.setS34(rs.getString(8));  //Authorized_By
							gl.setS32(rs.getString(9));  //Verified_By
							gl.setS36(rs.getString(10));  //Verified_By_3
							gl.setS37(rs.getString(11));  //Verified_By_4
							gl.setS38(rs.getString(12));  //Verified_By_5
								
							return gl;
						}
						 }     );
					}
				}
			
				//16.getTransaction_List
				public List<SimpleBranch> getTransaction_List_AllBranch(int txnId,String FromDate,String ToDate,String Flag,int Bcode){
					//--Set Connection----------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
		//-----------------------------------------------------
					if(Flag.equalsIgnoreCase("All"))
					{
					return template.query("	SELECT cte.Branch,cte.Transaction_Id,to_char(cte.Transaction_Date,'dd-MM-yyyy'),cte.Account_No,cte.Transaction_Particulars,cte.Page_Source,cte.Account_Desc,cte.Authorized_By,cte.Verified_By,cte.Verified_By_3,cte.Verified_By_4,cte.Verified_By_5,cte.Created_By,cte.Created_Date,Trans.Amount FROM Daily_Transaction_table cte left join (Select Branch,Transaction_Id as Trans_Id,Transaction_Date as Trans_Date,sum(Transaction_Amount) as Amount from  Daily_Transaction_table where Flag='GL' and Transaction_Type='Credit' group by Branch,Transaction_Id,Transaction_Date) Trans on cte.Transaction_Id=Trans.Trans_Id and cte.Transaction_Date=Trans.Trans_Date and cte.Branch = Trans.Branch left join Branch_Master on cte.Branch=Branch_Master.Branch_Code WHERE Part_Tran_Id = 1 and Transaction_Id like '%"+txnId+"%' and Transaction_Date between TO_DATE('"+
							FromDate+"','dd/MM/yyyy') and TO_DATE('"+ToDate+"','dd/MM/yyyy') order by cte.Transaction_Date desc,cte.Created_Date desc,to_number(substr(to_char(cte.Transaction_Id),-5,5)) desc,cte.Branch desc ",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
					{  
	
						SimpleBranch gl=new SimpleBranch(); 
						gl.setS11(rs.getInt(1));	//Branch
					    gl.setS1(rs.getInt(2));	//TRANSACTION_ID
					    gl.setS2(rs.getString(3));	//TRANSACTION_DATE
						gl.setS3(rs.getString(4));  // //ACCOUNT_NO
						gl.setS5(rs.getString(5));  //Particulars
						gl.setS13(rs.getFloat(15)); // TRANSACTION_AMOUNT
						
						gl.setS6(rs.getString(13));  //Created By
						gl.setS34(rs.getString(8));  //Authorized_By
						gl.setS32(rs.getString(9));  //Verified_By
						gl.setS36(rs.getString(10));  //Verified_By_3
						gl.setS37(rs.getString(11));  //Verified_By_4
						gl.setS38(rs.getString(12));  //Verified_By_5
							
						return gl;
					}
					 }     );
					}
					else
					{
						return template.query("	SELECT cte.Branch,cte.Transaction_Id,to_char(cte.Transaction_Date,'dd-MM-yyyy'),cte.Account_No,cte.Transaction_Particulars,cte.Page_Source,cte.Account_Desc,cte.Authorized_By,cte.Verified_By,cte.Verified_By_3,cte.Verified_By_4,cte.Verified_By_5,cte.Created_By,cte.Created_Date,Trans.Amount FROM Daily_Transaction_table cte left join (Select Branch,Transaction_Id as Trans_Id,Transaction_Date as Trans_Date,sum(Transaction_Amount) as Amount from  Daily_Transaction_table where Flag='GL' and Transaction_Type='Credit' group by Branch,Transaction_Id,Transaction_Date) Trans on cte.Transaction_Id=Trans.Trans_Id and cte.Transaction_Date=Trans.Trans_Date and cte.Branch = Trans.Branch left join Branch_Master on cte.Branch=Branch_Master.Branch_Code WHERE Part_Tran_Id = 1 and Transaction_Id like '%"+txnId+"%' and Transaction_Date between TO_DATE('"+
								FromDate+"','dd/MM/yyyy') and TO_DATE('"+ToDate+"','dd/MM/yyyy') and (Authorized_By is NULL or Verified_By is NULL or Verified_By_3 is NULL or Verified_By_4 is NULL or Verified_By_5 is NULL) order by cte.Transaction_Date desc,cte.Created_Date desc,to_number(substr(to_char(cte.Transaction_Id),-5,5)) desc,cte.Branch desc ",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
						{  
	
							SimpleBranch gl=new SimpleBranch(); 
							gl.setS11(rs.getInt(1));	//Branch
						    gl.setS1(rs.getInt(2));	//TRANSACTION_ID
						    gl.setS2(rs.getString(3));	//TRANSACTION_DATE
							gl.setS3(rs.getString(4));  // //ACCOUNT_NO
							gl.setS5(rs.getString(5));  //Particulars
							gl.setS13(rs.getFloat(15)); // TRANSACTION_AMOUNT
							
							gl.setS6(rs.getString(13));  //Created By
							gl.setS34(rs.getString(8));  //Authorized_By
							gl.setS32(rs.getString(9));  //Verified_By
							gl.setS36(rs.getString(10));  //Verified_By_3
							gl.setS37(rs.getString(11));  //Verified_By_4
							gl.setS38(rs.getString(12));  //Verified_By_5
								
							return gl;
						}
						 }     );
					}
				}
			
			//17.	getUserLogin
				public List<Simple> getUserLogin() {

					//--Set Connection----------------------------
					int j=Binfo;
					this.template=con.getCon2(j);
					//-----------------------------------------------------
					return template.query("select * from LOGINDETAILS where Value !='B'",new RowMapper<Simple>(){   public Simple mapRow(ResultSet rs, int row) throws SQLException
					{  
	
						Simple gl=new Simple();
						gl.setS2(rs.getString(1));
						
						return gl;
					}
					 }     );
				}
				
			//18.savePermissionDetails_RandC	
				
				public int savePermissionDetails_RandC(String username,String page,String view){

					//--Set Connection----------------------------
					int j=Binfo;
					this.template=con.getCon2(j);
					//-----------------------------------------------------
					int i=0;
				    String sql="insert into PERMISSIONDETAILS values('"+username+"','"+page+"','"+view+"')";
				    
				    
				   i=template.update(sql); 
				    
				    return i; 
				} 
				
				
			
			//19.DeletePermissionDetails_RandC	
				public int DeletePermissionDetails_RandC(String username){

					//--Set Connection----------------------------
					int j=Binfo;
					this.template=con.getCon2(j);
					//-----------------------------------------------------
					int i=0;
				    String sql="delete from PERMISSIONDETAILS where username='"+username+"'";
				    
				    
				   i=template.update(sql); 
				    
				    return i; 
				}
	
	
				//20.saveEditChange_Password_RandC
				public int saveEditChange_Password_RandC(String username,
						String newPassword) {

					//--Set Connection----------------------------
					int j=Binfo;
					this.template=con.getCon2(j);
					//-----------------------------------------------------
					// TODO Auto-generated method stub
					String sql="update LOGINDETAILS set PWD='"+newPassword+"' where Username='"+username+"'";  
				    return template.update(sql);  
					
				} 
				
		//-------------------------------------------------------------------------------------------------------------
				//CUSTOMER LIST
				//------------------------------------------------------------------------------------------
		//21.	getCustomerList	
				public List<SimpleBranch> getCustomerList(String Current,int Bcode){
	
					//--Set Connection------------------------------------
								int j=Bcode;
								this.template=con.getCon2(j);
					//-----------------------------------------------------
								return template.query("select * from Customer_View where Create_Date=to_date('"+Current+"','dd/MM/yyyy')  ORDER BY Customer_Id desc",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
								{  
	
									SimpleBranch gl=new SimpleBranch();
									gl.setS11(rs.getInt(1));   //Branch Code
									gl.setS1(rs.getInt(4));   //CUSTOMER_ID
									gl.setS2(rs.getString(6));  //CUSTOMER_NAME
									gl.setS3(rs.getString(8));   //GENDER
									gl.setS4(rs.getString(10));    //FATHER_NAME
									gl.setS5(rs.getString(12));   //ADDRESS
									gl.setS31(rs.getString(13));    //City
									gl.setS32(rs.getString(14));   //Pincode
									
									gl.setS6(rs.getString(25));   //MOBILE_NO
									
									
									gl.setS33(rs.getString(31));   //Verify
									
									
													
									return gl;
					}
					 }     );
				}
				
			//22.	getCustomerList_All
				public List<SimpleBranch> getCustomerList_All(String keyword,String From_Date,String To_Date,int Bcode){
	
					//--Set Connection------------------------------------
								int j=Bcode;
								this.template=con.getCon2(j);
					//-----------------------------------------------------
					return template.query("select * from Customer_View where  (Customer_Id like '%" + keyword + "%' or Customer_Name like '%" + keyword + "%' or Address like '%" + keyword + "%' or City like '%" + keyword + "%' or Mobile_No like '%" + keyword + "%') and create_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') ORDER BY create_date desc",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
					{  
	
						SimpleBranch gl=new SimpleBranch();
						gl.setS11(rs.getInt(1));   //Branch Code
						gl.setS1(rs.getInt(4));   //CUSTOMER_ID
						gl.setS2(rs.getString(6));  //CUSTOMER_NAME
						gl.setS3(rs.getString(8));   //GENDER
						gl.setS4(rs.getString(10));    //FATHER_NAME
						gl.setS5(rs.getString(12));   //ADDRESS
						gl.setS31(rs.getString(13));    //City
						gl.setS32(rs.getString(14));   //Pincode
						
						gl.setS6(rs.getString(25));   //MOBILE_NO
						
						
						gl.setS33(rs.getString(31));   //Verify
						
						
										
						return gl;
					}
					 }     );
				}
			
				
				//23.getCustomerList_NotVerified
				public List<SimpleBranch> getCustomerList_NotVerified(String keyword,String From_Date,String To_Date,int Bcode){
	
					//--Set Connection------------------------------------
								int j=Bcode;
								this.template=con.getCon2(j);
					//-----------------------------------------------------
					return template.query("select * from Customer_View where (Customer_Id like '%" + keyword + "%' or Customer_Name like '%" + keyword + "%' or Address like '%" + keyword + "%' or City like '%" + keyword + "%' or Mobile_No like '%" + keyword + "%') and AUTHORIZED_BY IS NULL and  Create_Date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy')  ORDER BY create_date desc",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
					{  
	
						SimpleBranch gl=new SimpleBranch();
						gl.setS11(rs.getInt(1));   //Branch Code
						gl.setS1(rs.getInt(4));   //CUSTOMER_ID
						gl.setS2(rs.getString(6));  //CUSTOMER_NAME
						gl.setS3(rs.getString(8));   //GENDER
						gl.setS4(rs.getString(10));    //FATHER_NAME
						gl.setS5(rs.getString(12));   //ADDRESS
						gl.setS31(rs.getString(13));    //City
						gl.setS32(rs.getString(14));   //Pincode
						
						gl.setS6(rs.getString(25));   //MOBILE_NO
						
						
						gl.setS33(rs.getString(31));   //Verify
						
						
										
						return gl;
					}
					 }     );
				}
				
							
				
				
				//25. Verify_Customer
				public int Verify_Customer(int Customer_Id,String user,String Current,int Bcode)					{ 
										
										//--Set Connection----------------------------
										int j=Bcode;
										this.template=con.getCon2(j);
							//-----------------------------------------------------
	
						
										//String	upsql1="Update Daily_Transaction set VERIFIED_BY='"+user+"',VERIFIED_DATE=to_date('"+Current+"','dd/MM/yyyy') where Transaction_id="+Transaction_Id+" and Transaction_date=to_date('"+Transaction_Date+"','dd/MM/yyyy')";
											//template.update(upsql1);
											int flag=0;
											try{
												//Verify_Transaction1(Transaction_Id1 in number,Transaction_Date1 in varchar2,Authorized_By1 in varchar2,Authorized_Date1 in varchar2)
												CallableStatement stmt=template.getDataSource().getConnection().prepareCall("{call Verify_Customer(?,?,?)}");
												stmt.setInt(1,Customer_Id);
												stmt.setString(2,user);
												stmt.setString(3,Current);
												
												//register the OUT parameter before calling the stored procedure
													//stmt.registerOutParameter(4, OracleTypes.CURSOR);
												 ResultSet rs =stmt.executeQuery();
												
												 if(rs.rowUpdated())
												 {
													 flag=1;
												 }
												
											}catch(Exception e)
											 	 {
												System.out.println(e);	
											 	 }	
											return flag;
									
								   }
				

				//----------------------------------------------------------FD master List------------------------------------------------------------------------------
				
				
	// 26.getFD_MasterList

	public List<SimpleBranch> getFD_MasterList(String From_Date,
			String To_Date, int Bcode) {

		// --Set Connection------------------------------------
		int j = Bcode;
		this.template = con.getCon2(j);
		// -----------------------------------------------------
		System.out.println("inside get account start");
		// "select * from FD_Master_View where open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy')
		// and renewal_no is null order by OPEN_DATE desc,Scheme_Code,Account_No
		// desc
		String sql = "select a.Branch,a.Account_No,a.Customer_Id,a.Customer_Name,a.Open_Date,a.Scheme_Code,a.Maturity_Date,a.Maturity_Amount,a.ACCOUNT_STATUS,a.Mode_of_Operation,case when cnt>0 then 'Green' else 'Red' End as Delivery_Status from FD_Master_View a left join (select Account_No,count(*) as cnt from Fd_Print_View where Delivery_Status='Ready to Dispatch' group by Account_No) b on a.Account_No=b.Account_No where a.open_date between to_date('"+ From_Date + "','dd/MM/yyyy') and to_date('" + To_Date + "','dd/MM/yyyy') and renewal_no is null  order by a.OPEN_DATE desc,a.Scheme_Code,a.Account_No desc";
		return template.query(sql, new RowMapper<SimpleBranch>() {
			public SimpleBranch mapRow(ResultSet rs, int row)
					throws SQLException

			{

				// System.out.println("inside get account end");
				SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");

				SimpleBranch gl = new SimpleBranch();
				gl.setS1(rs.getInt("Branch"));// branch
				gl.setS4(rs.getString("Account_No")); // ACCOUNT_NO
				gl.setS11(rs.getInt("Customer_Id")); // CUSTOMER_ID
				gl.setS2(rs.getString("Customer_Name")); // CUSTOMER_NAME
				gl.setS15(rs.getDate("Open_Date")); // OPEN_DATE
				gl.setS31(sd.format(rs.getDate("Open_Date")));// OPEN_DATE1
				gl.setS3(rs.getString("Scheme_Code")); // SCHEME_CODE
				gl.setS16(rs.getDate("Maturity_Date")); // MATURITY_DATE
				gl.setS32(sd.format(rs.getDate("Maturity_Date")));// MATURITY_DATE1
				gl.setS12(rs.getInt("Maturity_Amount")); // MATURITY_AMOUNT
				DecimalFormat df = new DecimalFormat("0.00");
				String Maturity = df.format(rs.getInt("Maturity_Amount"));
				gl.setS33(Maturity);
				gl.setS5(rs.getString("ACCOUNT_STATUS")); // ACCOUNT_STATUS
				gl.setS34(rs.getString("Mode_of_Operation")); // ModeOfOperation
				gl.setS39(rs.getString("Delivery_Status")); // Delivery_Status
				return gl;
			}
		});
	}
					
					//27.Search 
					//------------------------------------------------FD Account List---SEARCH----------------------------------------------------------------------------------------------------	
					public List<SimpleBranch>getAccountListSearch_FD(String From_Date,String To_Date,String searchKey,int Bcode)
					{
						
						//--Set Connection------------------------------------
									int j=Bcode;
									this.template=con.getCon2(j);
						//-----------------------------------------------------

					  if(searchKey.matches("-?\\d+(\\.\\d+)?"))
							  {
						  System.out.println("inside get account start search");
						return template.query("select * from FD_Master_View WHERE  (ACCOUNT_NO LIKE '%"+searchKey+"%' or CUSTOMER_ID LIKE '%"+searchKey+"%' or DEPOSIT_AMOUNT LIKE '%"+searchKey+"%' or Maturity_Amount like '%"+searchKey+"%') and open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') and renewal_no is null order by OPEN_DATE desc,Scheme_Code,Account_No desc",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																								{
							System.out.println("inside get account end search");
							SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
																								SimpleBranch gl=new SimpleBranch();
																								gl.setS1(rs.getInt(1));//branch
																								
																								gl.setS4(rs.getString(3));		//ACCOUNT_NO
																								gl.setS11(rs.getInt(4));	//CUSTOMER_ID
																								
																								gl.setS2(rs.getString(5));	//CUSTOMER_NAME
																								
																								gl.setS15(rs.getDate(8));	//OPEN_DATE
																								gl.setS31(sd.format(rs.getDate(8)));//OPEN_DATE1
																								
																								
																								
																								gl.setS3(rs.getString(10));	//SCHEME_CODE
																								
																								
																								gl.setS16(rs.getDate(18));	//MATURITY_DATE
																								gl.setS32(sd.format(rs.getDate(18)));//MATURITY_DATE1
																								
																								gl.setS12(rs.getInt(19));	//MATURITY_AMOUNT
																								DecimalFormat df = new DecimalFormat("0.00");
																								String Maturity=df.format(rs.getInt(19));
																								gl.setS33(Maturity);
																								
																								gl.setS5(rs.getString(26));	//ACCOUNT_STATUS
																								gl.setS34(rs.getString(11));	//ModeOfOperation	
																									return gl;
																								}
					 																		 }     );
							  }
					  
					  else
					  {
						  System.out.println("inside get account start1 search");
						  return template.query("select * from FD_Master_View WHERE (Upper(CUSTOMER_NAME) LIKE '%"+searchKey.toUpperCase()+"%' or SCHEME_CODE LIKE '%"+searchKey+"%') and open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') and renewal_no is null order by OPEN_DATE desc,Scheme_Code,Account_No",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																						{
							  System.out.println("inside get account end1 search");
							  SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
																						SimpleBranch gl=new SimpleBranch();
																						gl.setS1(rs.getInt(1));//branch
																						
																						gl.setS4(rs.getString(3));		//ACCOUNT_NO
																						gl.setS11(rs.getInt(4));	//CUSTOMER_ID
																						
																						gl.setS2(rs.getString(5));	//CUSTOMER_NAME
																						
																						gl.setS15(rs.getDate(8));	//OPEN_DATE
																						gl.setS31(sd.format(rs.getDate(8)));//OPEN_DATE1
																						
																						
																						
																						gl.setS3(rs.getString(10));	//SCHEME_CODE
																						
																						
																						gl.setS16(rs.getDate(18));	//MATURITY_DATE
																						gl.setS32(sd.format(rs.getDate(18)));//MATURITY_DATE1
																						
																						gl.setS12(rs.getInt(19));	//MATURITY_AMOUNT
																						DecimalFormat df = new DecimalFormat("0.00");
																						String Maturity=df.format(rs.getInt(19));
																						gl.setS33(Maturity);
																						
																						gl.setS5(rs.getString(26));	//ACCOUNT_STATUS
																						gl.setS34(rs.getString(11));	//ModeOfOperation
																						
																							return gl;
																						}
			 																		 }     );
					  }
					  
					  
					  
					  
					}
					
					
					//----------------------------------------------------FD Account List --LIKE(Search )----------------------------------------------------------------------------------------------------------------
					
					// Customer Address
					//select Address from Customer where Customer_id=(Select customer_id from cust_Acc_link where account_no='2010400001');
					//26.get Customer Address

					public List<SimpleBranch> getCustomer_Address(String Account_No,int Bcode){

						//--Set Connection------------------------------------
									int j=Bcode;
									this.template=con.getCon2(j);
						//-----------------------------------------------------
						return template.query("select Address,Mobile_No,DOOR_NO,STREET_NAME,City,STATE,PINCODE,PREMISES,NOMINEE_NAME,Area from Customer where Customer_id=(Select customer_id from cust_Acc_link where account_no='"+Account_No+"')",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
						{  

							SimpleBranch gl=new SimpleBranch();
							gl.setS2(rs.getString(1));	//CUSTOMER_Address
							gl.setS3(rs.getString(2));	//Mobile_No
							gl.setS31(rs.getString(3));	//Door No
							gl.setS32(rs.getString(4));	//Street Name
							gl.setS33(rs.getString(5));	//City
							gl.setS34(rs.getString(6));	//State
							gl.setS35(rs.getString(7));	//Pin Code
							gl.setS36(rs.getString(8));	//Premises
							gl.setS4(rs.getString(9));	//Nominee Name
							
							gl.setS37(rs.getString(10));	//Area
							
												
							return gl;
						}
						 }     );
					}
					
					//29. Deposit Amount_Fd
					public int Deposit_Amount_Fd(String Account_No,int Bcode)
					{
						
						//--Set Connection------------------------------------
						int j=Bcode;
						this.template=con.getCon2(j);
						//-----------------------------------------------------
			
		
						int i=0;
						String query = "Select Deposit_Amount from FD_Master where Account_No='"+Account_No+"'";
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
							if(resultSet!=null)
							{
								while(resultSet.next())
								{
									i=resultSet.getInt(1);
								}
							}
							
							
							//i=resultSet.getRow();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("dao-get Dep Amt ");		
						return i;
					}
					
					
					//29.1 Maturity Amount_Fd
					public float Maturity_Amount_Fd(String Account_No,int Bcode)
					{
						
						//--Set Connection------------------------------------
						int j=Bcode;
						this.template=con.getCon2(j);
						//-----------------------------------------------------
			
		
						float i=0;
						String query = "Select Maturity_Amount from FD_Master where Account_No='"+Account_No+"'";
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
							if(resultSet!=null)
							{
								while(resultSet.next())
								{
									i=resultSet.getFloat(1);
								}
							}
							
							
							//i=resultSet.getRow();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					System.out.println("dao-get Mat Amt ");	
						return i;
					}
					
					
					//30.Rupees Converter
					//to_char(to_date(900,'J'), 'JSP') as Rupees
					public String Rupees_Converter(int Amount)
					{

						//--Set Connection----------------------------
						int j=Binfo;
						this.template=con.getCon2(j);
						//-----------------------------------------------------
		
						String i=null;
						String query = "Select to_char(to_date("+Amount+",'J'), 'JSP') as Rupees from dual";
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
							if(resultSet!=null)
							{
								while(resultSet.next())
								{
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
			
					
					//31.Get Branch_Code
					public List<Simple> getBranchCode(){
						//--Set Connection------------------------------------
						int j=Binfo;
						this.template=con.getCon2(j);
			//-----------------------------------------------------
						return template.query("select * from BRANCH_MASTER order by BRANCH_CODE",new RowMapper<Simple>(){   public Simple mapRow(ResultSet rs, int row) throws SQLException
						{  

							Simple gl=new Simple();
							gl.setS1(rs.getInt(1));
							gl.setS2(rs.getString(2));
							
										System.out.println("Branch List from db"+rs.getInt(1));	
							return gl;
						}
						 }     );
					}
					
					
					//
					//32. Share_Amount
					public float Share_Amount_Share(String Account_No,int Bcode)
					{
						
						//--Set Connection------------------------------------
						int j=Bcode;
						this.template=con.getCon2(j);
						//-----------------------------------------------------
			
		
						float i=0;
						String query = "Select Share_Amount from Share_Master where Account_No='"+Account_No+"'";
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
									  i=resultSet.getFloat(1);
								  }
							}
							
							//i=resultSet.getFloat(1);
							
							//i=resultSet.getRow();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						return i;
					}
					
					
					//getLoanAppraisal_List
					public List<SimpleBranch> getLoanAppraisal_List(String txt_Keyword,int Bcode ){
						
						//--Set Connection------------------------------------
						int j=Bcode;
						this.template=con.getCon2(j);
						//-----------------------------------------------------
			
						return template.query("Select *,isnull(f.Application_Status,'Pending in Verification Officer') as App_Status2,convert(varchar(10),a.Date_of_Application,103) as Date_of_App  from Borrower_Details as a left join Borrower_Income_Details b on a.Application_No = b.Application_No left join Loan_Eligiblity_Details d on a.Application_No = d.Application_No left join Verify_Application_3 e on a.Application_No = e.Application_No left join Application_Status f on a.Application_No = f.Application_No where a.Application_No like '%"+txt_Keyword+"%' or a.Customer_Name like '%"+txt_Keyword+"%'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
						{  

							SimpleBranch gl=new SimpleBranch();
							//gl.setS1(rs.getInt(1));
							gl.setS2(rs.getString(1));
							
										
							return gl;
						}
						 }     );
					}
					
					//PERMISSIONDETAILS
					
					
					//getLoanAppraisal_List
					public List<SimpleBranch> getPermissionRandC(String Username){
						
						//--Set Connection------------------------------------
						int j=Binfo;
						this.template=con.getCon2(j);
						//-----------------------------------------------------
			
						return template.query("Select PAGE,TO_VIEW from PermissionDetails where USERNAME='"+Username+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
						{  

							SimpleBranch gl=new SimpleBranch();
							//gl.setS1(rs.getInt(1));
							gl.setS2(rs.getString(1));
							gl.setS3(rs.getString(2));
							
										
							return gl;
						}
						 }     );
					}

					
					
					public List<SimpleBranch> getAccount_Type(String AccNo,int Bcode){

						//--Set Connection------------------------------------
									int j=Bcode;
									this.template=con.getCon2(j);
						//-----------------------------------------------------
						return template.query("Select * from Cust_Acc_Link where Account_No='"+AccNo+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
						{  
				           
							
							SimpleBranch gl=new SimpleBranch();
						
							gl.setS1(rs.getInt(2));//CUSTOMER_ID
							gl.setS2(rs.getString(3));// ACCOUNT_NO
							gl.setS3(rs.getString(4));//CUSTOMER_NAME
							gl.setS11(rs.getInt(10));//CUSTOMER_ID_2
							gl.setS4(rs.getString(11));//CUSTOMER_NAME_2
							gl.setS5(rs.getString(5));//ACCOUNT_TYPE
							
														
							return gl; 
						}
						 }     );
					}
					
					
					//3.//SB_Trans
					public List<SimpleBranch> getAccount_Details_SC(String Account_No1,int Bcode){
						System.out.println("Account no="+Account_No1);
						int j=Bcode;
						this.template=con.getCon2(j);
						
						return template.query("Select  Scheme_Name, Scheme_Category, Share_Master.Customer_Id, Account_No, Customer.Customer_Name, Customer.Address, Customer.City, Customer.Pincode, to_Char(Date1,'dd/MM/yyyy') as Open_Date, to_Char(Share_Master.No_of_Shares || ' Shares @ Rs.' || Share_Master.Share_Value || ' each')as Share_Detail,Share_Amount as Amount,  Closing_Balance,   Share_Master.Nominee_Name	from Share_Master left join Customer on Share_Master.Customer_Id=Customer.Customer_Id left join Scheme_Master on Share_Master.Scheme_Code=Scheme_Master.Scheme_Code where Account_No='"+Account_No1+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
					{  
				    String credit="Credit";
				    String debit="Debit";
				    
				    SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
						
				   // String txnDate=rs.getString(4);
						SimpleBranch gl=new SimpleBranch(); 
					    gl.setS31(rs.getString(1));	//Scheme_Name
						gl.setS32(rs.getString(2));  //Scheme_Category
						
						gl.setS33(rs.getString(3));  //Customer_Id
						gl.setS34(rs.getString(4));  //Account_No
						gl.setS35(rs.getString(5));  //Customer_Name
						gl.setS36(rs.getString(6));  //Address
						gl.setS37(rs.getString(7));  //City
						gl.setS38(rs.getString(8));//Pincode
						gl.setS39(rs.getString(9));	//Open_Date
						gl.setS40(rs.getString(10)); //Share_Detail
						
						gl.setS4(rs.getString(11));  //Amount
						gl.setS5(rs.getString(12));  //Closing_Balance
						gl.setS71(rs.getString(13));  //Nominee_Name
						
						
						
						return gl;
					}
					 }     ); 
				}

					

					public String[] GetAccount_Details(String Account_No,String Account_Type,int Bcode) throws SQLException
					{
						
						int j=Bcode;
						this.template=con.getCon2(j);
						
						String[] Details=new String[18];
						try{
							CallableStatement stmt=template.getDataSource().getConnection().prepareCall("{call ACCOUNT_DETAILS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
							stmt.setString(1,Account_No);
							stmt.setString(2,Account_Type);
							
							//register the OUT parameter before calling the stored procedure
							stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
							stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
							stmt.registerOutParameter(5, java.sql.Types.INTEGER);
							stmt.registerOutParameter(6, java.sql.Types.VARCHAR);
							stmt.registerOutParameter(7, java.sql.Types.VARCHAR);
							stmt.registerOutParameter(8, java.sql.Types.VARCHAR);
							stmt.registerOutParameter(9, java.sql.Types.VARCHAR);
							stmt.registerOutParameter(10, java.sql.Types.VARCHAR);
							stmt.registerOutParameter(11, java.sql.Types.VARCHAR);
							stmt.registerOutParameter(12, java.sql.Types.VARCHAR);
							stmt.registerOutParameter(13, java.sql.Types.FLOAT);
							stmt.registerOutParameter(14, java.sql.Types.VARCHAR);
							stmt.registerOutParameter(15, java.sql.Types.FLOAT);
							stmt.registerOutParameter(16, java.sql.Types.FLOAT);
							stmt.registerOutParameter(17, java.sql.Types.VARCHAR);
							stmt.registerOutParameter(18, java.sql.Types.VARCHAR);
							stmt.registerOutParameter(19, java.sql.Types.FLOAT);
							stmt.registerOutParameter(20, java.sql.Types.VARCHAR);
							stmt.registerOutParameter(21, java.sql.Types.VARCHAR);
							stmt.executeQuery();
						
							//stmt.execute();
							//read the OUT parameter now
							Details[0]=stmt.getString(3);//Scheme_Name1 
							Details[1]=stmt.getString(4);//Scheme_Category1
							Details[2]=""+stmt.getInt(5);//Customer_Id1
							Details[3]=stmt.getString(6);//Customer_Name1
							Details[4]=stmt.getString(7);//Customer_Name_21
							Details[5]=stmt.getString(8);//,Address1 
							Details[6]=stmt.getString(9);//,City1 
							Details[7]=stmt.getString(10);//Pincode1 
							Details[8]=stmt.getString(11);//Open_Date1
							Details[9]=stmt.getString(12);//Period1
							Details[10]=""+stmt.getFloat(13);//Interest_Rate1
							Details[11]=stmt.getString(14);//Share_Detail1 out varchar2,
							Details[12]=""+stmt.getFloat(15);//Amount1 out float
							Details[13]=""+stmt.getFloat(16); //Closing_Balance1 out float,
							Details[14]=stmt.getString(17); //Int_Payment_Freq1 out varchar2,
							Details[15]=stmt.getString(18);//Due_Date1 out varchar2
							Details[16]=""+stmt.getFloat(19);//Maturity_Amount1 out float,
							Details[17]=stmt.getString(20);//Nominee_Name1 out varchar2,
							Details[18]=stmt.getString(21);//Collateral_Detail1 out varchar2
						
							    
							
							System.out.println(Details[0]);
							System.out.println(Details[1]);
							System.out.println(Details[2]);
							System.out.println(Details[3]);
							System.out.println(Details[4]);
							System.out.println(Details[5]);
							System.out.println(Details[6]);
							System.out.println(Details[7]);
							System.out.println(Details[8]);
							System.out.println(Details[9]);
							System.out.println(Details[10]);
							System.out.println(Details[11]);
							System.out.println(Details[12]);
							System.out.println(Details[13]);
							System.out.println(Details[14]);
							System.out.println(Details[15]);
							System.out.println(Details[16]);
							System.out.println(Details[17]);
							System.out.println(Details[18]);
							
								// flag = stmt.getInt(3);
								// ResultSet rs = ((OracleCallableStatement)stmt).getCursor(4);
								// ResultSet rs1= (ResultSet) stmt.getObject(4);

								// while (rs.next ())
								// {      System.out.println ("method 1="+rs.getInt(1));
								// flag=rs.getInt(1);
								// }
								// while (rs1.next ())
								    //  System.out.println ("method 2="+rs1.getInt(1));
						}catch(Exception e)
						 	 {
							System.out.println(e);
						 	 }
						return Details;
					
					}

					
					
					// Select Scheme_Name,Scheme_Category,RD_Master.Customer_Id,RD_Master.Customer_Name, Customer_Name_2, Address, City, Pincode, to_Char(Open_Date,'dd/MM/yyyy') as Open_Date,to_char(Period_Months|| ' months') as Period, to_char(Interest_Rate || ' %') as Interest_Rate ,	'' as Share_Detail,Deposit_Amount as Amount, Closing_Balance,Interest_Repayment as Int_Payment_Freq,to_Char(Maturity_Date,'dd/MM/yyyy') as Due_Date,Maturity_Amount,RD_Master.Nominee_Name,'' as Collateral_Detail from RD_Master left join Customer on RD_Master.Customer_Id=Customer.Customer_Id left join Scheme_Master on RD_Master.Scheme_Code=Scheme_Master.Scheme_Code where Account_No=Account_No1;
					
					public List<SimpleBranch> getAccount_Details_RD(String Account_No1,int Bcode){
						System.out.println("Account no="+Account_No1);
						int j=Bcode;
						this.template=con.getCon2(j);
						
						
						
						
						
						return template.query("Select Scheme_Name,Scheme_Category,RD_Master.Customer_Id,RD_Master.Customer_Name, Customer_Name_2, Customer.Address, City, Pincode, to_Char(Open_Date,'dd/MM/yyyy') as Open_Date,to_char(Period_Months|| ' months') as Period, to_char(Interest_Rate || ' %') as Interest_Rate ,	'' as Share_Detail,Deposit_Amount as Amount, Closing_Balance,Interest_Repayment as Int_Payment_Freq,to_Char(Maturity_Date,'dd/MM/yyyy') as Due_Date,Maturity_Amount,RD_Master.Nominee_Name,'' as Collateral_Detail from RD_Master left join Customer on RD_Master.Customer_Id=Customer.Customer_Id left join Scheme_Master on RD_Master.Scheme_Code=Scheme_Master.Scheme_Code where Account_No='"+Account_No1+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
					{  
							
				    String credit="Credit";
				    String debit="Debit";
				    
				    SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
					
						SimpleBranch gl=new SimpleBranch(); 
						
					    gl.setS31(rs.getString(1));	//Scheme_Name
						gl.setS32(rs.getString(2));  //Scheme_Category
						gl.setS33(rs.getString(3));  //Customer_Id
						gl.setS34(rs.getString(4));  //Customer_Name
						gl.setS35(rs.getString(5));  //Customer_Name2
						gl.setS36(rs.getString(6));  //Address
						gl.setS37(rs.getString(7));  //City
						gl.setS38(rs.getString(8));//Pincode
						gl.setS39(rs.getString(9));	//Open_Date
						gl.setS40(rs.getString(10));	//Period
						
						gl.setS2(rs.getString(11));	//Interest_Rate
						gl.setS3(rs.getString(12));  //Share_Detail
						gl.setS4(rs.getString(13));  //Amount
						gl.setS5(rs.getString(14));  //Closing_Balance
						gl.setS6(rs.getString(15));  //Int_Payment_Freq
						gl.setS9(rs.getString(16));  //Due_Date
						gl.setS10(rs.getString(17));  //Maturity_Amount
						gl.setS71(rs.getString(18));  //Nominee_Name
						gl.setS72(rs.getString(19));  //Collateral_Detail
						
						
						
						return gl;
					}
					 }     ); 
				}
					
					//   Select Scheme_Name,Scheme_Category,SBCA_Master.Customer_Id,SBCA_Master.Customer_Name, Customer_Name_2, Address, City, Pincode,to_Char(Open_Date,'dd/MM/yyyy') as Open_Date, '' as Period, '' as Interest_Rate,'' as Share_Detail,Closing_Balance as Amount, Closing_Balance,'6A' as Int_Payment_Freq,'' as Due_Date,'' as Maturity_Amount,SBCA_Master.Nominee_Name,'' as Collateral_Detail from SBCA_Master left join Customer on SBCA_Master.Customer_Id=Customer.Customer_Id left join Scheme_Master on SBCA_Master.Scheme_Code=Scheme_Master.Scheme_Code where Account_No='"+Account_No+"';

					
						public List<SimpleBranch> getAccount_Details_SD(String Account_No1,int Bcode){
							System.out.println("Account no="+Account_No1);
							int j=Bcode;
							this.template=con.getCon2(j);
							
								return template.query("Select Scheme_Name,Scheme_Category,SBCA_Master.Customer_Id,SBCA_Master.Customer_Name, Customer_Name_2, Customer.Address, City, Pincode,to_Char(Open_Date,'dd/MM/yyyy') as Open_Date, '' as Period, '' as Interest_Rate,'' as Share_Detail,Closing_Balance as Amount, Closing_Balance,'6A' as Int_Payment_Freq,'' as Due_Date,'' as Maturity_Amount,SBCA_Master.Nominee_Name,'' as Collateral_Detail from SBCA_Master left join Customer on SBCA_Master.Customer_Id=Customer.Customer_Id left join Scheme_Master on SBCA_Master.Scheme_Code=Scheme_Master.Scheme_Code where Account_No='"+Account_No1+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
						{  
								
					    String credit="Credit";
					    String debit="Debit";
					    
					    SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
						
							SimpleBranch gl=new SimpleBranch(); 
							
						    gl.setS31(rs.getString(1));	//Scheme_Name
							gl.setS32(rs.getString(2));  //Scheme_Category
							gl.setS33(rs.getString(3));  //Customer_Id
							gl.setS34(rs.getString(4));  //Customer_Name
							gl.setS35(rs.getString(5));  //Customer_Name2
							gl.setS36(rs.getString(6));  //Address
							gl.setS37(rs.getString(7));  //City
							gl.setS38(rs.getString(8));//Pincode
							gl.setS39(rs.getString(9));	//Open_Date
							gl.setS40(rs.getString(10));	//Period
							
							gl.setS2(rs.getString(11));	//Interest_Rate
							gl.setS3(rs.getString(12));  //Share_Detail
							gl.setS4(rs.getString(13));  //Amount
							gl.setS5(rs.getString(14));  //Closing_Balance
							gl.setS6(rs.getString(15));  //Int_Payment_Freq
							gl.setS9(rs.getString(16));  //Due_Date
							gl.setS10(rs.getString(17));  //Maturity_Amount
							gl.setS71(rs.getString(18));  //Nominee_Name
							gl.setS72(rs.getString(19));  //Collateral_Detail
							
							System.out.println("gl.setS31(rs.getString(1));	//Scheme_Name="+gl.getS31());
							System.out.println("gl.setS32(rs.getString(2));  //Scheme_Category="+gl.getS32());
							System.out.println("gl.setS33(rs.getString(3));  //Customer_Id="+gl.getS33());
							System.out.println("gl.setS34(rs.getString(4));  //Customer_Name="+gl.getS34());
							System.out.println("gl.setS35(rs.getString(5));  //Customer_Name2="+gl.getS35());
							System.out.println("gl.setS36(rs.getString(6));  //Address="+gl.getS36());
							System.out.println("gl.setS37(rs.getString(7));  //City="+gl.getS37());
							System.out.println("gl.setS38(rs.getString(8));//Pincode="+gl.getS38());
							System.out.println("gl.setS39(rs.getString(9));	//Open_Date="+gl.getS39());
							System.out.println("gl.setS40(rs.getString(10));	//Period="+gl.getS40());
							
							
							
							System.out.println("gl.setS2(rs.getString(11));	//Interest_Rate="+gl.getS2());
							System.out.println("gl.setS3(rs.getString(12));  //Share_Detail="+gl.getS3());
							System.out.println("gl.setS4(rs.getString(13));  //Amount="+gl.getS4());
							System.out.println("gl.setS5(rs.getString(14));  //Closing_Balance="+gl.getS5());
							System.out.println("gl.setS6(rs.getString(15));  //Int_Payment_Freq="+gl.getS6());
							System.out.println("gl.setS9(rs.getString(16));  //Due_Date="+gl.getS9());
							System.out.println("gl.setS10(rs.getString(17));  //Maturity_Amount="+gl.getS10());
							System.out.println("gl.setS71(rs.getString(18));  //Nominee_Name="+gl.getS71());
							System.out.println("gl.setS72(rs.getString(19));  //Collateral_Detail="+gl.getS72());
							
							
							
							return gl;
						}
						 }     ); 
					}
						
					
					//   Select Scheme_Name,Scheme_Category,FD_Master.Customer_Id,FD_Master.Customer_Name, Customer_Name_2, Address, City, Pincode, to_Char(Open_Date,'dd/MM/yyyy') as Open_Date,to_char(Period_Months|| ' months') as Period, to_char(Interest_Rate || ' %') as Interest_Rate ,'' as Share_Detail,Deposit_Amount as Amount, Closing_Balance,to_char(Interest_Repayment||' / '||Interest_Payment_Mode) as Int_Payment_Freq,to_Char(Maturity_Date,'dd/MM/yyyy') as Due_Date,Maturity_Amount,FD_Master.Nominee_Name,'' as Collateral_Detail from FD_Master left join Customer on FD_Master.Customer_Id=Customer.Customer_Id left join Scheme_Master on FD_Master.Scheme_Code=Scheme_Master.Scheme_Code where Account_No='2010400968';
						  

						
							public List<SimpleBranch> getAccount_Details_FD(String Account_No1,int Bcode){
								System.out.println("Account no="+Account_No1);
								int j=Bcode;
								this.template=con.getCon2(j);
								
									return template.query("Select Scheme_Name,Scheme_Category,FD_Master.Customer_Id,FD_Master.Customer_Name, Customer_Name_2, Customer.Address, City, Pincode, to_Char(Open_Date,'dd/MM/yyyy') as Open_Date, case when Period_Months=0 then to_char(Period_Days|| ' Days') else  to_char(Period_Months || ' Months') end as Period, to_char(Interest_Rate || ' %') as Interest_Rate ,'' as Share_Detail,Deposit_Amount as Amount, Closing_Balance,to_char(Interest_Repayment||' / '||Interest_Payment_Mode) as Int_Payment_Freq,to_Char(Maturity_Date,'dd/MM/yyyy') as Due_Date, Maturity_Amount,FD_Master.Nominee_Name,'' as Collateral_Detail from FD_Master left join Customer on FD_Master.Customer_Id=Customer.Customer_Id left join Scheme_Master on FD_Master.Scheme_Code=Scheme_Master.Scheme_Code where Account_No='"+Account_No1+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
							{  
									
						    String credit="Credit";
						    String debit="Debit";
						    
						    SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
							
								SimpleBranch gl=new SimpleBranch(); 
								
							    gl.setS31(rs.getString(1));	//Scheme_Name
								gl.setS32(rs.getString(2));  //Scheme_Category
								gl.setS33(rs.getString(3));  //Customer_Id
								gl.setS34(rs.getString(4));  //Customer_Name
								gl.setS35(rs.getString(5));  //Customer_Name2
								gl.setS36(rs.getString(6));  //Address
								gl.setS37(rs.getString(7));  //City
								gl.setS38(rs.getString(8));//Pincode
								gl.setS39(rs.getString(9));	//Open_Date
								gl.setS40(rs.getString(10));	//Period
								
								gl.setS2(rs.getString(11));	//Interest_Rate
								gl.setS3(rs.getString(12));  //Share_Detail
								gl.setS4(rs.getString(13));  //Amount
								gl.setS5(rs.getString(14));  //Closing_Balance
								gl.setS6(rs.getString(15));  //Int_Payment_Freq
								gl.setS9(rs.getString(16));  //Due_Date
								gl.setS10(rs.getString(17));  //Maturity_Amount
								gl.setS71(rs.getString(18));  //Nominee_Name
								gl.setS72(rs.getString(19));  //Collateral_Detail
								
								System.out.println("gl.setS31(rs.getString(1));	//Scheme_Name="+gl.getS31());
								System.out.println("gl.setS32(rs.getString(2));  //Scheme_Category="+gl.getS32());
								System.out.println("gl.setS33(rs.getString(3));  //Customer_Id="+gl.getS33());
								System.out.println("gl.setS34(rs.getString(4));  //Customer_Name="+gl.getS34());
								System.out.println("gl.setS35(rs.getString(5));  //Customer_Name2="+gl.getS35());
								System.out.println("gl.setS36(rs.getString(6));  //Address="+gl.getS36());
								System.out.println("gl.setS37(rs.getString(7));  //City="+gl.getS37());
								System.out.println("gl.setS38(rs.getString(8));//Pincode="+gl.getS38());
								System.out.println("gl.setS39(rs.getString(9));	//Open_Date="+gl.getS39());
								System.out.println("gl.setS40(rs.getString(10));	//Period="+gl.getS40());
								
								
								
								System.out.println("gl.setS2(rs.getString(11));	//Interest_Rate="+gl.getS2());
								System.out.println("gl.setS3(rs.getString(12));  //Share_Detail="+gl.getS3());
								System.out.println("gl.setS4(rs.getString(13));  //Amount="+gl.getS4());
								System.out.println("gl.setS5(rs.getString(14));  //Closing_Balance="+gl.getS5());
								System.out.println("gl.setS6(rs.getString(15));  //Int_Payment_Freq="+gl.getS6());
								System.out.println("gl.setS9(rs.getString(16));  //Due_Date="+gl.getS9());
								System.out.println("gl.setS10(rs.getString(17));  //Maturity_Amount="+gl.getS10());
								System.out.println("gl.setS71(rs.getString(18));  //Nominee_Name="+gl.getS71());
								System.out.println("gl.setS72(rs.getString(19));  //Collateral_Detail="+gl.getS72());
								
								return gl;
							}
							 }     ); 
						}
							
							
						//      Select Scheme_Name,Scheme_Category,JL_Master.Customer_Id,JL_Master.Customer_Name,'' as Customer_Name_2, Address, City, Pincode, to_char(Open_Date,'dd/MM/yyyy') as Open_Date, to_char(Period_Months|| ' months') as Period, to_char(Interest_Rate || ' %') as Interest_Rate ,	'' as Share_Detail,Loan_Amount as Amount, Closing_Balance,'1A' as Int_Payment_Freq,to_char(Due_Date,'dd/MM/yyyy') as Due_Date,'' as Maturity_Amount,JL_Master.Nominee_Name,to_char('Gross Wt. ' || Gross_Weight || 'Deduction ' || Deduction ) as Collateral_Detail	from JL_Master left join Customer on JL_Master.Customer_Id=Customer.Customer_Id left join Scheme_Master on JL_Master.Scheme_Code=Scheme_Master.Scheme_Code where Account_No='2011100011';



							
								public List<SimpleBranch> getAccount_Details_JL(String Account_No1,int Bcode){
									System.out.println("Account no="+Account_No1);
									int j=Bcode;
									this.template=con.getCon2(j);
									
										//old return template.query("Select Scheme_Name,Scheme_Category,JL_Master.Customer_Id,JL_Master.Customer_Name,'' as Customer_Name_2, Customer.Address, City, Pincode, to_char(Open_Date,'dd/MM/yyyy') as Open_Date, to_char(Period_Months|| ' months') as Period, to_char(Interest_Rate || ' %') as Interest_Rate ,	'' as Share_Detail,Loan_Amount as Amount, Closing_Balance,'1A' as Int_Payment_Freq,to_char(Due_Date,'dd/MM/yyyy') as Due_Date,'' as Maturity_Amount,JL_Master.Nominee_Name,to_char('Gross Wt. ' || Gross_Weight || 'Deduction ' || Deduction ) as Collateral_Detail	from JL_Master left join Customer on JL_Master.Customer_Id=Customer.Customer_Id left join Scheme_Master on JL_Master.Scheme_Code=Scheme_Master.Scheme_Code where Account_No='"+Account_No1+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
										//15-06-2022
									return template.query("Select Scheme_Name,Scheme_Category,JL_Master.Customer_Id,JL_Master.Customer_Name,'' as Customer_Name_2, Customer.Address, City, Pincode, to_char(Open_Date,'dd/MM/yyyy') as Open_Date, case when JL_Master.scheme_code in ('60026','60028') then to_char(Period_Months|| ' days') else to_char(Period_Months|| ' months') end   as Period, to_char(Interest_Rate || ' %') as Interest_Rate ,	'' as Share_Detail,Loan_Amount as Amount, Closing_Balance,'1A' as Int_Payment_Freq,to_char(Due_Date,'dd/MM/yyyy') as Due_Date,'' as Maturity_Amount,JL_Master.Nominee_Name,to_char('Gross Wt. ' || Gross_Weight || 'Deduction ' || Deduction ) as Collateral_Detail	from JL_Master left join Customer on JL_Master.Customer_Id=Customer.Customer_Id left join Scheme_Master on JL_Master.Scheme_Code=Scheme_Master.Scheme_Code where Account_No='"+Account_No1+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException

										
								{  
										
							    String credit="Credit";
							    String debit="Debit";
							    
							    SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
								
									SimpleBranch gl=new SimpleBranch(); 
									
								    gl.setS31(rs.getString(1));	//Scheme_Name
									gl.setS32(rs.getString(2));  //Scheme_Category
									gl.setS33(rs.getString(3));  //Customer_Id
									gl.setS34(rs.getString(4));  //Customer_Name
									gl.setS35(rs.getString(5));  //Customer_Name2
									gl.setS36(rs.getString(6));  //Address
									gl.setS37(rs.getString(7));  //City
									gl.setS38(rs.getString(8));//Pincode
									gl.setS39(rs.getString(9));	//Open_Date
									gl.setS40(rs.getString(10));	//Period
									
									gl.setS2(rs.getString(11));	//Interest_Rate
									gl.setS3(rs.getString(12));  //Share_Detail
									gl.setS4(rs.getString(13));  //Amount
									gl.setS5(rs.getString(14));  //Closing_Balance
									gl.setS6(rs.getString(15));  //Int_Payment_Freq
									gl.setS9(rs.getString(16));  //Due_Date
									gl.setS10(rs.getString(17));  //Maturity_Amount
									gl.setS71(rs.getString(18));  //Nominee_Name
									gl.setS72(rs.getString(19));  //Collateral_Detail
									
									
									System.out.println("gl.setS31(rs.getString(1));	//Scheme_Name="+gl.getS31());
									System.out.println("gl.setS32(rs.getString(2));  //Scheme_Category="+gl.getS32());
									System.out.println("gl.setS33(rs.getString(3));  //Customer_Id="+gl.getS33());
									System.out.println("gl.setS34(rs.getString(4));  //Customer_Name="+gl.getS34());
									System.out.println("gl.setS35(rs.getString(5));  //Customer_Name2="+gl.getS35());
									System.out.println("gl.setS36(rs.getString(6));  //Address="+gl.getS36());
									System.out.println("gl.setS37(rs.getString(7));  //City="+gl.getS37());
									System.out.println("gl.setS38(rs.getString(8));//Pincode="+gl.getS38());
									System.out.println("gl.setS39(rs.getString(9));	//Open_Date="+gl.getS39());
									System.out.println("gl.setS40(rs.getString(10));	//Period="+gl.getS40());
									
									
									
									System.out.println("gl.setS2(rs.getString(11));	//Interest_Rate="+gl.getS2());
									System.out.println("gl.setS3(rs.getString(12));  //Share_Detail="+gl.getS3());
									System.out.println("gl.setS4(rs.getString(13));  //Amount="+gl.getS4());
									System.out.println("gl.setS5(rs.getString(14));  //Closing_Balance="+gl.getS5());
									System.out.println("gl.setS6(rs.getString(15));  //Int_Payment_Freq="+gl.getS6());
									System.out.println("gl.setS9(rs.getString(16));  //Due_Date="+gl.getS9());
									System.out.println("gl.setS10(rs.getString(17));  //Maturity_Amount="+gl.getS10());
									System.out.println("gl.setS71(rs.getString(18));  //Nominee_Name="+gl.getS71());
									System.out.println("gl.setS72(rs.getString(19));  //Collateral_Detail="+gl.getS72());
									return gl;
								}
								 }     ); 
							}
							
							//      Select Scheme_Name,Scheme_Category,OL_Master.Customer_Id,OL_Master.Customer_Name,'' as Customer_Name_2, Address, City, Pincode, to_char(Open_Date,'dd/MM/yyyy') as Open_Date, to_char(Period_Months ||' months') as Period, to_char(Interest_Rate || ' %') as Interest_Rate,'' as Share_Detail,Loan_Amount as Amount, Closing_Balance,'1A' as Int_Payment_Freq,to_char(Due_Date,'dd/MM/yyyy') as Due_Date,'' as Maturity_Amount ,OL_Master.Nominee_Name,(select Security_Details from(Select Security_Details from Collateral_Certificate_Loan where Account_No='2010900027') where rownum=1)from OL_Master left join Customer on OL_Master.Customer_Id=Customer.Customer_Id left join Scheme_Master on OL_Master.Scheme_Code=Scheme_Master.Scheme_Code where Account_No='2010900027';


								
									public List<SimpleBranch> getAccount_Details_OL(String Account_No1,int Bcode){
										System.out.println("Account no="+Account_No1);
										int j=Bcode;
										this.template=con.getCon2(j);
										
											return template.query("     Select Scheme_Name,Scheme_Category,OL_Master.Customer_Id,OL_Master.Customer_Name,'' as Customer_Name_2,Customer.Address, City, Pincode, to_char(Open_Date,'dd/MM/yyyy') as Open_Date, to_char(Period_Months ||' months') as Period, to_char(Interest_Rate || ' %') as Interest_Rate,'' as Share_Detail,Loan_Amount as Amount, Closing_Balance,'1A' as Int_Payment_Freq,to_char(Due_Date,'dd/MM/yyyy') as Due_Date,'' as Maturity_Amount ,OL_Master.Nominee_Name,(select Security_Details from(Select Security_Details from Collateral_Certificate_Loan where Account_No='"+Account_No1+"') where rownum=1)from OL_Master left join Customer on OL_Master.Customer_Id=Customer.Customer_Id left join Scheme_Master on OL_Master.Scheme_Code=Scheme_Master.Scheme_Code where Account_No='"+Account_No1+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
									{  
											
								    String credit="Credit";
								    String debit="Debit";
								    
								    SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
									
										SimpleBranch gl=new SimpleBranch(); 
										
									    gl.setS31(rs.getString(1));	//Scheme_Name
										gl.setS32(rs.getString(2));  //Scheme_Category
										gl.setS33(rs.getString(3));  //Customer_Id
										gl.setS34(rs.getString(4));  //Customer_Name
										gl.setS35(rs.getString(5));  //Customer_Name2
										gl.setS36(rs.getString(6));  //Address
										gl.setS37(rs.getString(7));  //City
										gl.setS38(rs.getString(8));//Pincode
										gl.setS39(rs.getString(9));	//Open_Date
										gl.setS40(rs.getString(10));	//Period
										
										gl.setS2(rs.getString(11));	//Interest_Rate
										gl.setS3(rs.getString(12));  //Share_Detail
										gl.setS4(rs.getString(13));  //Amount
										gl.setS5(rs.getString(14));  //Closing_Balance
										gl.setS6(rs.getString(15));  //Int_Payment_Freq
										gl.setS9(rs.getString(16));  //Due_Date
										gl.setS10(rs.getString(17));  //Maturity_Amount
										gl.setS71(rs.getString(18));  //Nominee_Name
										gl.setS72(rs.getString(19));  //Collateral_Detail
										
										System.out.println("gl.setS31(rs.getString(1));	//Scheme_Name="+gl.getS31());
										System.out.println("gl.setS32(rs.getString(2));  //Scheme_Category="+gl.getS32());
										System.out.println("gl.setS33(rs.getString(3));  //Customer_Id="+gl.getS33());
										System.out.println("gl.setS34(rs.getString(4));  //Customer_Name="+gl.getS34());
										System.out.println("gl.setS35(rs.getString(5));  //Customer_Name2="+gl.getS35());
										System.out.println("gl.setS36(rs.getString(6));  //Address="+gl.getS36());
										System.out.println("gl.setS37(rs.getString(7));  //City="+gl.getS37());
										System.out.println("gl.setS38(rs.getString(8));//Pincode="+gl.getS38());
										System.out.println("gl.setS39(rs.getString(9));	//Open_Date="+gl.getS39());
										System.out.println("gl.setS40(rs.getString(10));	//Period="+gl.getS40());
										
										
										
										System.out.println("gl.setS2(rs.getString(11));	//Interest_Rate="+gl.getS2());
										System.out.println("gl.setS3(rs.getString(12));  //Share_Detail="+gl.getS3());
										System.out.println("gl.setS4(rs.getString(13));  //Amount="+gl.getS4());
										System.out.println("gl.setS5(rs.getString(14));  //Closing_Balance="+gl.getS5());
										System.out.println("gl.setS6(rs.getString(15));  //Int_Payment_Freq="+gl.getS6());
										System.out.println("gl.setS9(rs.getString(16));  //Due_Date="+gl.getS9());
										System.out.println("gl.setS10(rs.getString(17));  //Maturity_Amount="+gl.getS10());
										System.out.println("gl.setS71(rs.getString(18));  //Nominee_Name="+gl.getS71());
										System.out.println("gl.setS72(rs.getString(19));  //Collateral_Detail="+gl.getS72());
										
										return gl;
									}
									 }     ); 
								}
									
									
									public List<SimpleBranch> getLastFewTrans(String Account_No,int Bcode)
									{
										//--Set Connection----------------------------
										int j=Bcode;
										this.template=con.getCon2(j);
							//-----------------------------------------------------

										return template.query("Select * from (select * from (Select Transaction_Id,Part_Tran_Id,to_char(Transaction_Date,'dd/MM/yyyy') as Transaction_Date,Transaction_Date as TDate,Account_No,Transaction_Amount AS Credit,0 as Debit,Transaction_Particulars,0.0 as CB,Flag from Daily_Transaction where Account_No='"+Account_No+"' and Transaction_Type='Credit' union Select Transaction_Id,Part_Tran_Id,to_char(Transaction_Date,'dd/MM/yyyy') as Transaction_Date,Transaction_Date as TDate,Account_No,0 AS Credit,Transaction_Amount as Debit,Transaction_Particulars,0.0 as CB,Flag from Daily_Transaction where Account_No='"+Account_No+"' and Transaction_Type='Debit')SB_Tran order by TDate desc,to_number(substr(to_char(Transaction_Id),-5,5)) desc,Part_Tran_Id desc)  Trans WHERE rownum <= 7 order by TDate desc,Part_Tran_Id desc ",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																												{  
										
											                                                    SimpleBranch  sm=new SimpleBranch();
																											   
											                                                                     
					           
																								   sm.setS1(rs.getInt(1));
																								   sm.setS4(rs.getString(3));
																								   sm.setS2(rs.getString(8));
																								   sm.setS13(rs.getFloat(6)); //Open_Date
																								   sm.setS14(rs.getFloat(7));
																								   sm.setS17(rs.getFloat(9));
																								   sm.setS3(rs.getString(10));//Flag
																											   
																											   
																											   System.out.println("Account No"+rs.getString(2));

																													return sm;
																												}
									 																		 }     );
						}
									
									public List<SimpleBranch> getSBClosingBalance(String accno,int Bcode){

										//--Set Connection----------------------------
													int j=Bcode;
													this.template=con.getCon2(j);
										//-----------------------------------------------------

										return template.query("select * from ol_master where Account_No='"+accno+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
										{  

											SimpleBranch gl=new SimpleBranch();
										gl.setS13(rs.getFloat(29));
															
											return gl;
										}
										 }     );
									}		
									//3.//OL_Transaction
									public List<SimpleBranch> getTransList(String accno,int Bcode){
										System.out.println("Account no="+accno);

										//--Set Connection----------------------------
													int j=Bcode;
													this.template=con.getCon2(j);
										//-----------------------------------------------------

									return template.query("select * from(select * from(Select Transaction_Id,Part_Tran_Id,To_Char(Transaction_Date,'dd/MM/yyyy') as Transaction_Date,Transaction_Date as TDate,Account_No,(Transaction_Amount)as Credit,0 as Debit,Transaction_Particulars,(0.0)as CB,Flag,Transaction_Type from Daily_Transaction where Account_No='"+accno+"' and Transaction_Type='Credit' Union Select Transaction_Id,Part_Tran_Id,To_Char(Transaction_Date,'dd/MM/yyyy') as Transaction_Date,Transaction_Date as TDate,Account_No,0 as Credit,(Transaction_Amount) as Debit,Transaction_Particulars,(0.0)as CB,Flag,Transaction_Type from Daily_Transaction where Account_No='"+accno+"' and Transaction_Type='Debit')Sb_trans order by TDate desc,Transaction_id desc,part_Tran_id desc)std where ROWNUM<=5",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
									{  
								      String credit="Credit";
								      String debit="Debit";
								      
								      SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
										String txnDate=sd.format(rs.getDate(4));
								     // String txnDate=rs.getString(4);
										SimpleBranch gl=new SimpleBranch(); 
									    gl.setS1(rs.getInt(1));	//TRANSACTION_ID
										gl.setS4((txnDate));  //TRANSACTION_DATE
										
										gl.setS2(rs.getString(8));  //TRANSACTION_PARTICULARS
										gl.setS13(rs.getFloat(6));  //Credit
										gl.setS14(rs.getFloat(7));  //Debit
										gl.setS17(Math.abs(rs.getFloat(9)));  //Closing Balance
										gl.setS3(rs.getString(11));//Transaction_type
										
										
										return gl;
									}
									 }     ); 
								}
									
									//3.//SB_Trans
									public List<SimpleBranch> getSB_TransListIndividual3(String accno,int Bcode){
										//--Set Connection----------------------------
										int j=Bcode;
										this.template=con.getCon2(j);
							//-----------------------------------------------------


										System.out.println("Account no="+accno);
									return template.query("select * from(select * from(Select Transaction_Id,Part_Tran_Id,To_Char(Transaction_Date,'dd/MM/yyyy') as Transaction_Date,Transaction_Date as TDate,Account_No,(Transaction_Amount)as Credit,0 as Debit,Transaction_Particulars,(0.0)as CB,Flag,Transaction_Type from Daily_Transaction where Account_No='"+accno+"' and Transaction_Type='Credit' Union Select Transaction_Id,Part_Tran_Id,To_Char(Transaction_Date,'dd/MM/yyyy') as Transaction_Date,Transaction_Date as TDate,Account_No,0 as Credit,(Transaction_Amount) as Debit,Transaction_Particulars,(0.0)as CB,Flag,Transaction_Type from Daily_Transaction where Account_No='"+accno+"' and Transaction_Type='Debit')Sb_trans order by TDate desc,to_number(substr(to_char(Transaction_Id),-5,5)) desc)std where ROWNUM<=7",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
									{  
								      String credit="Credit";
								      String debit="Debit";
								      
								      SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
										String txnDate=sd.format(rs.getDate(4));
								     // String txnDate=rs.getString(4);
										SimpleBranch gl=new SimpleBranch(); 
									    gl.setS1(rs.getInt(1));	//TRANSACTION_ID
										gl.setS4((txnDate));  //TRANSACTION_DATE
										
										gl.setS2(rs.getString(8));  //TRANSACTION_PARTICULARS
										gl.setS13(rs.getFloat(6));  //Credit
										gl.setS14(rs.getFloat(7));  //Debit
										gl.setS17(rs.getFloat(9));  //Closing Balance
										gl.setS3(rs.getString(11));//Transaction_type
										
										
										return gl;
									}
									 }     ); 
								}
									
									public List<SimpleBranch> getSBClosingBalance2(String accno,int Bcode){
										//--Set Connection----------------------------
										int j=Bcode;
										this.template=con.getCon2(j);
								//-----------------------------------------------------


										return template.query("select * from SBCA_MASTER where Account_No='"+accno+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
										{  

											SimpleBranch gl=new SimpleBranch();
										gl.setS13(rs.getFloat(12));
															
											return gl;
										}
										 }     );
									}
									
									public List<SimpleBranch> getSBClosingBalanceJL(String accno, int Bcode) {
										// --Set Connection------------------------------------
										int j = Bcode;
										this.template = con.getCon2(j);
										// -----------------------------------------------------
										return template.query("select * from JL_Master where Account_No='"
												+ accno + "'", new RowMapper<SimpleBranch>() {
											public SimpleBranch mapRow(ResultSet rs, int row)
													throws SQLException {

												SimpleBranch gl = new SimpleBranch();
												gl.setS13(Math.abs(rs.getFloat(8)));

												return gl;
											}
										});
									}
									
									
									
									//-------------------------------------------------KYC Count List---------------------------------------------------------------------
									public int GetKYC_Count(String Search_query,String FromDate,String To_Date,int BranchCode,String AccStartNo,int Bcode)
									{
										// --Set Connection------------------------------------
										int j = Bcode;
										this.template = con.getCon2(j);
										// -----------------------------------------------------
						
						
										int i=0;
										String query = "select count(*) from customer where customer_id like '"+AccStartNo+"%' and "+Search_query+" and created_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy')";
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
							
									//3.//SB_Trans
									public List<SimpleBranch> GetKYC_Count_Report(String Search_query,String FromDate,String To_Date,int BranchCode,String AccStartNo,int Bcode){
										//--Set Connection----------------------------
										int j=Bcode;
										this.template=con.getCon2(j);
							//-----------------------------------------------------


									return template.query("select to_char(Customer_id),Customer_name,to_char(Created_Date,'dd/MM/yyyy'),to_char(Mobile_No) from customer where customer_id like '"+AccStartNo+"%' and "+Search_query+" and created_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy')",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
									{ 
								     
										SimpleBranch gl=new SimpleBranch(); 
									   
										gl.setS31(rs.getString(1));//Customer_id
										gl.setS32(rs.getString(2));//Customer_name
										gl.setS33(rs.getString(3));//Created_Date
										gl.setS34(rs.getString(4));//Mobile_No
										
										
										
										return gl;
									}
									 }     ); 
								}
									
									



									public List<SimpleBranch> useBranch_Code(int bcode) {//--Set Connection----------------------------
										int j=Binfo;
										this.template=con.getCon2(j);
										//-----------------------------------------------------
										return template.query("select * from Branch_Master where Branch_Code="+bcode+"",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																												{  
										
																													SimpleBranch c=new SimpleBranch();
																													c.setS1(rs.getInt(1));//BRANCH_CODE
																													c.setS2(rs.getString(2));//BRANCH_NAME
																													c.setS3(rs.getString(3));//BRANCH_ADDRESS
																													c.setS4(rs.getString(4));//BRANCH_CITY
																													c.setS5(rs.getString(5));//BRANCH_PINCODE
																													c.setS6(rs.getString(6));//BRANCH_PHONE
																													c.setS7(rs.getLong(7));//
																													c.setS8(rs.getLong(8));//
																													
																													return c;
																												}
									 																		 }     );
									}
									
									
									
									// Fill JL HEAD Description

									public List<SimpleBranch> getTempJLHead(int Bcode, String Account_No) {
										// --Set Connection------------------------------------
										int j = Bcode;
										this.template = con.getCon2(j);
										// -----------------------------------------------------
										return template
												.query("Select ACCOUNT_NO,ACCOUNT_NAME,FLAG,HEAD_AMOUNT,ID,JL_ACC_NO from TEMP_JL_HEAD_AMT where JL_ACC_NO='"
														+ Account_No + "'", new RowMapper<SimpleBranch>() {
													public SimpleBranch mapRow(ResultSet rs, int row)
															throws SQLException {
														SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
														 DecimalFormat df = new DecimalFormat("0.00");
														SimpleBranch jm = new SimpleBranch();
														
														jm.setS31(rs.getString(1)); // Account No
														jm.setS32(rs.getString(2)); // Account_Name
														jm.setS33(rs.getString(3)); // flag
														jm.setS51(rs.getFloat(4)); // head aMOUNT
														jm.setS41(rs.getInt(5));//id
														//new
														jm.setS7(rs.getLong(6));//JL_ACC_NO
														jm.setS135(df.format(rs.getFloat(4)));  //eligible amt
														//old
														
														//jm.setS1(rs.getInt(6));//JL_ACC_NO

														return jm;
													}
												});
									}
									
									
									
									
									

									// Fill Jewel Description Total

/*
                                     public List<SimpleBranch> getJewel_Details_Total(int Bcode, String Account_No) {
											// --Set Connection------------------------------------
											int j = Bcode;
											this.template = con.getCon2(j);
											// -----------------------------------------------------
											return template
													.query("Select SUM(No_of_Items) as No_of_Items,SUM(Gross_Weight) as Gross_Weight,SUM(DEDUCTION) as DEDUCTION,SUM(NET_WEIGHT) as NET_WEIGHT,SUM(ELIGIBLE_AMT) as ELIGIBLE_AMT,SUM(Rate_Per_Gram) as Rate_Per_Gram,SUM(Purity) as Purity from Jewel_Details where Account_No='"
															+ Account_No + "'", new RowMapper<SimpleBranch>() {
														public SimpleBranch mapRow(ResultSet rs, int row)
																throws SQLException {
															SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");

															SimpleBranch jm = new SimpleBranch();
															
															jm.setS41(rs.getInt(1));
															jm.setS51(rs.getFloat(2));
															jm.setS52(rs.getFloat(3));
															jm.setS53(rs.getFloat(4));
															jm.setS54(rs.getFloat(5));
															jm.setS13(rs.getFloat(6));
															jm.setS1(rs.getInt(7));
															//jm.setS17(rs.getFloat(7));
															return jm;
														}
													});
										}
										
								*/		
										
										//----------------------------------------------------------FD master Individual Details-----------------------------------------------------------------------------
										
										public List<SimpleBranch> getFD_MasterDetailsIndividuals(String Accno,int Bcode){

											//--Set Connection------------------------------------
														int j=Bcode;
														this.template=con.getCon2(j);
											//-----------------------------------------------------
											return template.query("select * from FD_Master where Account_No='"+Accno+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
											{  
												SimpleBranch jm = new SimpleBranch();
												
											
												
											
												jm.setS2(rs.getString(10));//ModeOfOperation
												jm.setS3(rs.getString(6));//Cus_Name2
												jm.setS4(rs.getString(57));//Cus_Name3
												jm.setS11(rs.getInt("CUSTOMER_ID"));
												
													
												return jm;
											}
											 }     );
										}				
										
										public String convert(float i) {
											
											final String[] units = {"","One","Two","Three","Four",
												"Five","Six","Seven","Eight","Nine","Ten",
												"Eleven","Twelve","Thirteen","Fourteen","Fifteen",
												"Sixteen","Seventeen","Eighteen","Nineteen"};
											final String[] tens = {"","","Twenty","Thirty","Forty","Fifty",
												"Sixty","Seventy","Eighty","Ninety"};

											//
											if (i < 0) return "Minus " + convert(-i);

											if( i < 20)  return units[(int) i];
											if( i < 100) return tens[(int) (i/10)] + ((i % 10 > 0)? " " + convert(i % 10):"");
											if( i < 1000) return units[(int) (i/100)] + " Hundred" + ((i % 100 > 0)?" and " + convert(i % 100):"");
											if( i < 100000) return convert(i / 1000) + " Thousand " + ((i % 10000 > 0)? " " + convert(i % 1000):"") ;
											if( i < 10000000) return convert(i / 100000) + " Lakh " + ((i % 100000 > 0)? " " + convert(i % 100000):"") ;

											return convert(i / 10000000) + " Crore " + ((i % 10000000 > 0)? " " + convert(i % 10000000):"") ;
										}
										
										public List<SimpleBranch> getAccount_Details_CC(String Account_No1,int Bcode){
											System.out.println("Account no="+Account_No1);
											int j=Bcode;
											this.template=con.getCon2(j);
											
											
											
											
											
											return template.query("Select Scheme_Name,Scheme_Category,CC_Master.Customer_Id,CC_Master.Customer_Name, Customer_Name_2, Customer.Address, City, Pincode, to_Char(Open_Date,'dd/MM/yyyy') as Open_Date,to_char(Period_Months|| ' months') as Period, to_char(Interest_Rate || ' %') as Interest_Rate ,	'' as Share_Detail,Closing_Balance,CC_Master.Nominee_Name,'' as Collateral_Detail,to_char(DUE_DATE,'dd/MM/yyyy') from CC_Master left join Customer on CC_Master.Customer_Id=Customer.Customer_Id left join Scheme_Master on CC_Master.Scheme_Code=Scheme_Master.Scheme_Code where Account_No='"+Account_No1+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
										{  
												
									    String credit="Credit";
									    String debit="Debit";
									    
									    SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
										
											SimpleBranch gl=new SimpleBranch(); 
											
										    gl.setS31(rs.getString(1));	//Scheme_Name
											gl.setS32(rs.getString(2));  //Scheme_Category
											gl.setS33(rs.getString(3));  //Customer_Id
											gl.setS34(rs.getString(4));  //Customer_Name
											gl.setS35(rs.getString(5));  //Customer_Name2
											gl.setS36(rs.getString(6));  //Address
											gl.setS37(rs.getString(7));  //City
											gl.setS38(rs.getString(8));//Pincode
											gl.setS39(rs.getString(9));	//Open_Date
											gl.setS40(rs.getString(10));	//Period
											
											gl.setS2(rs.getString(11));	//Interest_Rate
											gl.setS3(rs.getString(12));  //Share_Detail
										//	gl.setS4(rs.getString(13));  //Amount
											gl.setS5(rs.getString(13));  //Closing_Balance
										//	gl.setS6(rs.getString(15));  //Int_Payment_Freq
											gl.setS9(rs.getString(16));  //Due_Date
										//	gl.setS10(rs.getString(17));  //Maturity_Amount
											gl.setS71(rs.getString(14));  //Nominee_Name
											gl.setS72(rs.getString(15));  //Collateral_Detail
											
											
											
											return gl;
										}
										 }     ); 
									}
								
								
								
								
								public float Get_Closing_Balance2(String Accno,String Date1,int Bcode) {
									

									//--Set Connection----------------------------
									int j=Bcode;
									this.template=con.getCon2(j);
									//-----------------------------------------------------
									
										float i=0;
									
										try{
											CallableStatement stmt=template.getDataSource().getConnection().prepareCall("{call Get_Closing_Balance(?,?,?)}");
											stmt.setString(1,Accno);
											stmt.setString(2,Date1);  
											//register the OUT parameter before calling the stored procedure
												stmt.registerOutParameter(3, java.sql.Types.FLOAT);
											stmt.executeQuery();
											//read the OUT parameter now
											i = stmt.getFloat(3);
											//System.out.println("Current_date from DB"+Current_date);
											//Connection conString=template.getDataSource().getConnection();
											//conString.
										}catch(Exception e)
										 	 {
											System.out.println(e);
										 	 }
										
										
										return i;
									} 			
									
										
										
								
								public List<SimpleBranch> Customer_For_FD_TDS_Report(String From_Date,String To_Date,int Bcode){
			     					//--Set Connection----------------------------
			     					int j=Binfo;
			     					this.template=con.getCon2(j);
			     		//-----------------------------------------------------


			     					/*return template.query("Select a.Account_No,b.Customer_Id,b.Customer_Name,sum(Transaction_Amount) as Amount from Daily_transaction_Table a left join FD_Master_view b on a.Account_No=b.Account_No where Flag='TDS' and Transaction_Date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') group by a.Account_No,b.Customer_Name,b.Customer_Id order by b.Customer_Id,a.Account_No",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException*/
			     						return template.query("Select b.branch_code,e.branch_name ,a.Account_No,b.Customer_Id,b.Customer_Name,(Select Pan_No from Customer where customer_Id=b.Customer_Id) AS Pan_No,(Select Address from Customer where customer_Id=b.Customer_Id) as Address,a.TRANSACTION_DATE,sum(Transaction_Amount) as Amount,(Select sum(interest) from  fd_interest_view where account_no=a.account_no and to_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') group by account_no) as  Total_Amount from Daily_transaction_Table a  left join FD_Master_view b on a.Account_No=b.Account_No  left join branch_master e on b.branch_code=e.branch_code where Flag='TDS' and Transaction_Date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') group by b.branch_code,e.branch_name, a.Account_No,b.Customer_Name,b.Customer_Id,a.Transaction_Date order by b.Customer_Id,a.Account_No",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
					     					
			     						
			     					{  

			     						SimpleBranch gl=new SimpleBranch();
			     						gl.setS2(rs.getString(3));		// Account No
			     						gl.setS1(rs.getInt(4));		//Customer Id
			     						gl.setS3(rs.getString(5));		//Name
	                                    gl.setS17(rs.getFloat(9));		//AMOUNT
	                                  //  gl.setS4(rs.getString(5));		//Pan No

			     					    
			     					    return gl;
			     					}
			     					 }     );
			     				}			
										
										

								public List<SimpleBranch> Customer_For_FD_TDS_Report_Overall(String From_Date,String To_Date,int Bcode){
			     					//--Set Connection----------------------------
			     					int j=Binfo;
			     					this.template=con.getCon2(j);
			     		//-----------------------------------------------------


			     					/*return template.query("Select a.Account_No,b.Customer_Id,b.Customer_Name,sum(Transaction_Amount) as Amount from Daily_transaction_Table a left join FD_Master_view b on a.Account_No=b.Account_No where Flag='TDS' and Transaction_Date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') group by a.Account_No,b.Customer_Name,b.Customer_Id order by b.Customer_Id,a.Account_No",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException*/
			     						return template.query("Select b.branch_code,e.branch_name ,a.Account_No,b.Customer_Id,b.Customer_Name,(Select Pan_No from Customer_View where customer_Id=b.Customer_Id and branch=b.branch_code) AS Pan_No,(Select Address from Customer_View where customer_Id=b.Customer_Id  and branch=b.branch_code) as Address,a.TRANSACTION_DATE,sum(Transaction_Amount) as Amount,(Select sum(interest) from  fd_interest_view where account_no=a.account_no and to_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') group by account_no) as  Total_Amount from Daily_transaction_Table a  left join FD_Master_view b on a.Account_No=b.Account_No  left join branch_master e on b.branch_code=e.branch_code where Flag='TDS' and Transaction_Date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') group by b.branch_code,e.branch_name, a.Account_No,b.Customer_Name,b.Customer_Id,a.Transaction_Date order by b.Customer_Id,a.Account_No",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
					     					
			     						
			     					{  

			     						SimpleBranch gl=new SimpleBranch();
			     						gl.setS11(rs.getInt(1));    // branch code
			     						gl.setS111(rs.getString(2));		// branch name
			     						gl.setS2(rs.getString(3));		// Account No
			     						gl.setS1(rs.getInt(4));		//Customer Id
			     						gl.setS3(rs.getString(5));		//Name
			     						gl.setS112(rs.getString(6));		//panno
			     						gl.setS131(rs.getString(7));		//address
			     						gl.setS125((rs.getDate(8)));  //tran date
	                                    gl.setS17(rs.getFloat(9));		//Interest
	                                    gl.setS100(rs.getFloat(10));		//total AMOUNT
	                                  //  gl.setS4(rs.getString(5));		//Pan No

			     					    
			     					    return gl;
			     					}
			     					 }     );
			     				}			
										
										

								
								public List<SimpleBranch> Customer_For_FD_TDS_Report_Ind_Branch(String From_Date,String To_Date,int Bcode){
			     					//--Set Connection----------------------------
			     					int j=Binfo;
			     					this.template=con.getCon2(j);
			     		//-----------------------------------------------------


			     					/*return template.query("Select a.Account_No,b.Customer_Id,b.Customer_Name,sum(Transaction_Amount) as Amount from Daily_transaction_Table a left join FD_Master_view b on a.Account_No=b.Account_No where Flag='TDS' and Transaction_Date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') group by a.Account_No,b.Customer_Name,b.Customer_Id order by b.Customer_Id,a.Account_No",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException*/
			     						return template.query("Select b.branch_code,e.branch_name ,a.Account_No,b.Customer_Id,b.Customer_Name,(Select Pan_No from Customer_View where customer_Id=b.Customer_Id and branch=b.branch_code) AS Pan_No,(Select Address from Customer_View where customer_Id=b.Customer_Id  and branch=b.branch_code) as Address,a.TRANSACTION_DATE,sum(Transaction_Amount) as Amount,(Select sum(interest) from  fd_interest_view where account_no=a.account_no and to_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') group by account_no) as  Total_Amount from Daily_transaction_Table a  left join FD_Master_view b on a.Account_No=b.Account_No  left join branch_master e on b.branch_code=e.branch_code where Flag='TDS' and Transaction_Date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') and b.branch_code='"+Bcode+"' group by b.branch_code,e.branch_name, a.Account_No,b.Customer_Name,b.Customer_Id,a.Transaction_Date order by b.Customer_Id,a.Account_No",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
					     					
			     						
			     					{  

			     							SimpleBranch gl=new SimpleBranch();
				     						gl.setS11(rs.getInt(1));    // branch code
				     						gl.setS111(rs.getString(2));		// branch name
				     						gl.setS2(rs.getString(3));		// Account No
				     						gl.setS1(rs.getInt(4));		//Customer Id
				     						gl.setS3(rs.getString(5));		//Name
				     						gl.setS112(rs.getString(6));		//panno
				     						gl.setS131(rs.getString(7));		//address
				     						gl.setS125((rs.getDate(8)));  //tran date
		                                    gl.setS17(rs.getFloat(9));		//AMOUNT
		                                    gl.setS100(rs.getFloat(10));		//total AMOUNT
		                                  //  gl.setS4(rs.getString(5));		//Pan No

				     					    
			     					    
			     					    return gl;
			     					}
			     					 }     );
			     				}			
										
									
										
									
										

					
										
	// Day End Process
								
								
								public List<SimpleBranch> getDayEndProcess(String Select_Date,int Bcode){

									//--Set Connection----------------------------
												int j=Bcode;
												this.template=con.getCon2(j);
									//-----------------------------------------------------
									
								return template.query("Select case when Receipt is NULL Then 0 else Receipt End as Receipt,case when Payment is NULL Then 0 else Payment End as Payment,case when Total is NULL Then 0 else Total End as Total,case when Pending is NULL Then 0 else Pending End as Pending,Abs(case when Receipt is NULL Then 0 else Receipt End-case when Payment is NULL Then 0 else Payment End)+case when Pending is NULL Then 0 else Pending End as Result from(Select sum(Transaction_Amount) as Receipt from Daily_Transaction where Flag='GL' and Transaction_Date=to_date('"+Select_Date+"','dd/MM/yyyy') and Transaction_Type='Credit') a,(Select sum(Transaction_Amount) as Payment from Daily_Transaction where Flag='GL' and Transaction_Date=to_date('"+Select_Date+"','dd/MM/yyyy')and Transaction_Type='Debit') b, (Select COUNT(distinct(Transaction_Id)) as Total from Daily_Transaction where Transaction_Date=to_date('"+Select_Date+"','dd/MM/yyyy')) c,(Select COUNT(distinct(Transaction_Id)) as Pending from Daily_Transaction where Transaction_Date=to_date('"+Select_Date+"','dd/MM/yyyy') and (Authorized_By is NULL or Verified_By is NULL or Verified_By_3 is NULL or Verified_By_4 is NULL or Verified_By_5 is NULL)) d",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException{  
														
								SimpleBranch gl=new SimpleBranch();
														
								gl.setS41(rs.getInt(1));  // Receipt
								gl.setS42(rs.getInt(2));  // Payment
								gl.setS43(rs.getInt(3));  // Total
								gl.setS44(rs.getInt(4));  // Pending
								gl.setS45(rs.getInt(5));  // Result
								
								System.out.println(rs.getInt(1));
								System.out.println(rs.getInt(2));
								System.out.println(rs.getInt(3));
								System.out.println(rs.getInt(4));
								System.out.println(rs.getInt(5));
														
								return gl;
								
								}
								});
								}
															


								// Cash Book Opening Balance & Opening Balance Dao
								
								public List<SimpleBranch> getCashBookOB(String From_Date,int Bcode){

									//--Set Connection----------------------------
												int j=Bcode;
												this.template=con.getCon2(j);
									//-----------------------------------------------------
									return template.query("Select a.OB+b.Credit-c.Debit as CB from (Select case when Opening_Balance is NULL Then 0 else Opening_Balance End as OB  from GL_Opening_Balance where OB_Date<=to_date('"+From_Date+"','dd/MM/yyyy') and Account_Code=29000 order by OB_Date desc) a,(Select case when sum(Transaction_Amount) is NULL Then 0 else sum(Transaction_Amount) End as Credit from Daily_Transaction where Transaction_Type='Credit' and Account_No=29000 and Transaction_Date<=to_date('"+From_Date+"','dd/MM/yyyy') and Transaction_Date>=(Select OB_Date from GL_Opening_Balance where Account_Code=29000 and OB_Date<=to_date('"+From_Date+"','dd/MM/yyyy'))) b,(Select case when sum(Transaction_Amount) is NULL Then 0 else sum(Transaction_Amount) End as Debit from Daily_Transaction where Transaction_Type='Debit' and Account_No=29000 and Transaction_Date<=to_date('"+From_Date+"','dd/MM/yyyy') and Transaction_Date>=(Select OB_Date from GL_Opening_Balance where Account_Code=29000 and OB_Date<=to_date('"+From_Date+"','dd/MM/yyyy'))) c",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException{  
										
										SimpleBranch gl=new SimpleBranch();
										
										gl.setS51(Math.abs(rs.getFloat(1))); // Opening Balance
									
										return gl;
									}
												 }     );
											}
								
								
								
								// Day_End_Cash
								
								public List<SimpleBranch> Day_End_Cash(String Transaction_Date1,int Bcode){

									//--Set Connection----------------------------
												int j=Bcode;
												this.template=con.getCon2(j);
									//-----------------------------------------------------

								return template.query("select * from Cash_Denomination where Transaction_Date=to_date('"+Transaction_Date1+"','dd/MM/yyyy')",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
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
								
								
								
								public String getPeriod(String Account_No, int BCode) {
									//--Set Connection------------------------------------
									int j=BCode;
									this.template=con.getCon2(j);
									//-----------------------------------------------------
									String i="";
									String query = "select Case when PERIOD_MONTHS=0 then PERIOD_DAYS || ' Days' else PERIOD_MONTHS ||' Months' end as period1 from FD_Master where Account_No='"+Account_No+"'";

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
								
								
								public String getIdProof1_Name(int Cust_Id,int Bcode) {
									//--Set Connection------------------------------------
									int j=Bcode;
									this.template=con.getCon2(j);
									//-----------------------------------------------------
									String i=null;
									String query = "select Proof1 from Customer where Customer_Id="+Cust_Id+"";

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
								
								
								public String getIdProof2_Name(int Cust_Id,int Bcode) {
									//--Set Connection------------------------------------
									int j=Bcode;
									this.template=con.getCon2(j);
									//-----------------------------------------------------
									String i=null;
									String query = "select Proof2 from Customer where Customer_Id="+Cust_Id+"";

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
								
								
								public String getPanId_Name(int Cust_Id,int Bcode) {
									//--Set Connection------------------------------------
									int j=Bcode;
									this.template=con.getCon2(j);
									//-----------------------------------------------------
									String i=null;
									String query = "select Proof3 from Customer where Customer_Id="+Cust_Id+"";

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
								
								
								public List<SimpleBranch> getSB_TransListIndividual3_desc(String accno, int Bcode) {
									System.out.println("Account no=" + accno);
									// --Set Connection------------------------------------
									int j = Bcode;
									this.template = con.getCon2(j);
									// -----------------------------------------------------

									return template
											.query("Select * from(Select Transaction_Id,Part_Tran_Id,To_Char(Transaction_Date,'dd/MM/yyyy') as Transaction_Date,Transaction_Date as TDate,Account_No,(Transaction_Amount)as Credit,0 as Debit,Transaction_Particulars,(0.0)as CB,Flag,Transaction_Type from Daily_Transaction where Account_No='"
													+ accno
													+ "' and Transaction_Type='Credit' Union Select Transaction_Id,Part_Tran_Id,To_Char(Transaction_Date,'dd/MM/yyyy') as Transaction_Date,Transaction_Date as TDate,Account_No,0 as Credit,(Transaction_Amount) as Debit,Transaction_Particulars,(0.0)as CB,Flag,Transaction_Type from Daily_Transaction where Account_No='"
													+ accno
													+ "' and Transaction_Type='Debit' order by TDATE desc)Sb_trans",
													new RowMapper<SimpleBranch>() {
														public SimpleBranch mapRow(ResultSet rs, int row)
																throws SQLException {
															String credit = "Credit";
															String debit = "Debit";

															SimpleDateFormat sd = new SimpleDateFormat(
																	"dd/MM/yyyy");
							                    		      DecimalFormat df = new DecimalFormat("0.00");

															
															String txnDate = sd.format(rs.getDate(4));
															SimpleBranch gl = new SimpleBranch();
															gl.setS1(rs.getInt(1)); // TRANSACTION_ID
															gl.setS4((txnDate)); // TRANSACTION_DATE
															gl.setS2(rs.getString(8)); // TRANSACTION_PARTICULARS
															gl.setS13(rs.getFloat(6)); // Credit
															gl.setS14(rs.getFloat(7)); // Debit
															gl.setS17(rs.getFloat(9)); // Closing Balance
															gl.setS10(rs.getString(10)); // FLAG
															System.out.println("Debit=" + rs.getFloat(9));
															gl.setS3(rs.getString(11));// Transaction_type
															
															
															   
															gl.setS31(df.format(rs.getFloat(6)));  //Credit
															gl.setS32(df.format(rs.getFloat(7)));  //Debit

															return gl;
														}
													});
								}
							
								public String Get_Scheme_Name(String Scheme_Code,int DBCode) {
			     					//--Set Connection------------------------------------
			     					int j=DBCode;
			     					this.template=con.getCon2(j);
			     					//-----------------------------------------------------
			     					String i=null;
			     					String query = "select SCHEME_NAME from Scheme_Master where SCHEME_CODE='"+Scheme_Code+"'";

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
								
								
								//Duration List
								public List<SimpleBranch> getDurationList(String Scheme_Code,int Bcode) {
									// --Set Connection------------------------------------
									int j = Bcode;
									this.template = con.getCon2(j);
									// -----------------------------------------------------
									return template.query("Select Min_Days,Max_Days,INTEREST from Jewel_Interest_Pattern where Scheme_Code='"+Scheme_Code+"'",
											new RowMapper<SimpleBranch>() {
												public SimpleBranch mapRow(ResultSet rs, int row)
														throws SQLException {
													SimpleBranch gl = new SimpleBranch();

													gl.setS1(rs.getInt(1));
													gl.setS11(rs.getInt(2));
													gl.setS13(rs.getFloat(3));

													return gl;
												}
											});
								}
								
								public String getMobile_No(int Customer_Id,int DBCode) {
			     					//--Set Connection------------------------------------
			     					int j=DBCode;
			     					this.template=con.getCon2(j);
			     					//-----------------------------------------------------
			     					String i=null;
			     					String query = "Select case when MOBILE_NO is null then '0' else MOBILE_NO end from Customer where CUSTOMER_ID="+Customer_Id+"";

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
								
								public int ResetPassword(String username, String newPassword) {

									//--Set Connection----------------------------
									int j=Binfo;
									this.template=con.getCon2(j);
									//-----------------------------------------------------
									// TODO Auto-generated method stub
									String sql="update LOGINDETAILS set PWD='"+newPassword+"' where Username='"+username+"'";  
								    return template.update(sql);  
									
								} 
								
								public int getusername_Count(String User_Name,int DBCode) {
									//--Set Connection------------------------------------
									int j=DBCode;
									this.template=con.getCon2(j);
									//-----------------------------------------------------
									int i=0;
									String query = "select Count(*) from LOGINDETAILS where Username='"+User_Name+"'";
						                   System.out.println("Count_111111111"+query);
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
								
								
								
								
								//20-01-2020 
								//28-03-2020
								public List<SimpleBranch> getLienAccount_Details_OL(String Account_No1,int Bcode){
									System.out.println("Account no="+Account_No1);
									int j=Bcode;
									this.template=con.getCon2(j);
									//New select c.* ,(c.CB*0.80) as SanctionAmt from (select a.Deposit_No,a.Deposit_Status,a.Deposit_Type,get_Acc_Balance(a.deposit_No,to_char(b.Open_Date,'dd/MM/yyyy')) as cb from (Select Loan_no,DEPOSIT_NO,LOAN_STATUS,DEPOSIT_STATUS,DEPOSIT_TYPE from Lien_Accounts where LOAN_NO='2010700092')a left join (select Account_No,Open_Date,Loan_Amount from OL_Master)b on a.Loan_no=b.Account_No)c;
									//
										return template.query(" select b.*,get_Acc_Balance(b.deposit_No,b.Open_Date1) as cb from (select a.*,(select to_char(open_date,'dd/MM/yyyy') as open_date1 from ol_master where Account_no='"+Account_No1+"')as open_date1 from (Select DEPOSIT_NO,LOAN_STATUS,DEPOSIT_STATUS,DEPOSIT_TYPE from Lien_Accounts where LOAN_NO='"+Account_No1+"')a)b",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
								{  
										
											
									SimpleBranch gl=new SimpleBranch(); 
									
								    gl.setS131(rs.getString(1));	//DEPOSIT_NO
									gl.setS132(rs.getString(2));  //LOAN_STATUS
									gl.setS133(rs.getString(3));  //DEPOSIT_STATUS
									gl.setS134(rs.getString(4));  //DEPOSIT_TYPE
									gl.setS135(rs.getString(5));  //opendate
									gl.setS136(rs.getString(6));  //amount
									
									System.out.println("rs.getString(5)="+rs.getString(5));
									System.out.println("rs.getString(6)="+rs.getString(6));
									
								
									return gl;
								}
								 }     ); 
							}
								
								
								
								//09/03/2020
								public List<SimpleBranch> getSecond_CustomerInfo1(String cusId,int Bcode){
									
									int j=Bcode;
									this.template=con.getCon2(j);
									return template.query("select CUSTOMER_ID_2,CUSTOMER_NAME_2 from Cust_Acc_Link where Account_No='"+cusId+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
									{  

										SimpleBranch gl=new SimpleBranch();
									
										gl.setS1(rs.getInt(1));  //CUSTOMER_ID_2
										gl.setS2(rs.getString(2));  //CUSTOMER_NAME_2
									
										
										
														
										return gl;
									}
									 }     );
								}
								
								public String getSecond_CustomerInfo(String Table,String Account_No_Key,int DBCode) {
									//--Set Connection------------------------------------
									int j=DBCode;
									this.template=con.getCon2(j);
									//-----------------------------------------------------
									String i=null;
									String query = "select MODE_OF_OPERATION from "+Table+" where ACCOUNT_NO='"+Account_No_Key+"'";

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
								
					
							public int getsessionusername_Count(String User_Name,int DBCode) {
																//--Set Connection------------------------------------
																int j=DBCode;
																this.template=con.getCon2(j);
																//-----------------------------------------------------
																int i=0;
																String query = "select Count(*) from LOGINDETAILS where Username='"+User_Name+"' and USER_LEVEL='A' and Value='admin'";
													                   System.out.println("Count_111111111"+query);
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
															
							public int Check_CashDenomiationRecord_Sms(String Date1,int Bcode)
							{
								
								//--Set Connection------------------------------------
								int j=Bcode;
								this.template=con.getCon2(j);
								//-----------------------------------------------------
				  
				
				
								int i=0;
								String query = "select count(*) from sms where MSG_STATUS in ('F','R') and TRANSACTION_DATE=to_date('"+Date1+"','dd/MM/yyyy')";
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
				
							public int UpdateCash_DenominationStatus_Sms(String Date1,int Bcode){  

								//--Set Connection------------------------------------
											int j=Bcode;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
							    String sql="update sms set transaction_date=transaction_date+1 where  MSG_STATUS in ('F','R') and TRANSACTION_DATE=to_date('"+Date1+"','dd/MM/yyyy')";

							    
							  
							    	System.out.println("day end denomination saved");
							    	template.update(sql);
							    	System.out.println("day end denomination updated.....");
							    
							    
							    return 1;  
							}  


public String Get_MonthEnd(String Date1) {
	//--Set Connection------------------------------------
	int j=Binfo;
	this.template=con.getCon2(j);
//-----------------------------------------------------
	
	
	
	
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








//3.//SB_Trans
public String GetKYC_Count_Report_General(String Search_query,int Bcode){
	//--Set Connection----------------------------
	int j=Bcode;
	this.template=con.getCon2(j);
//-----------------------------------------------------
	int i=0;
	String message=null;
	// List data = new ArrayList();
	
	//String query = "Select count(*) from LoginDetails where Username='"+User_Id+"'";
	PreparedStatement pstmt = null;
	try {
		pstmt = template.getDataSource().getConnection().prepareStatement(Search_query);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ResultSet resultSet = null;
	try {
		resultSet = pstmt.executeQuery();
		 ResultSetMetaData rsmd = resultSet.getMetaData();
	      //getting the column type
	      i = rsmd.getColumnCount();
	      
	      while(resultSet.next())
	      {
	    		 if(i>=10)
	    		   {
	    			message=message+resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5)+" "+resultSet.getString(6)+" "+resultSet.getString(7)+" "+resultSet.getString(8)+" "+resultSet.getString(9)+" "+resultSet.getString(10)+newline;
	    		   }
	    		 else  if(i==9)
	    		   {
	    			message=message+resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5)+" "+resultSet.getString(6)+" "+resultSet.getString(7)+" "+resultSet.getString(8)+" "+resultSet.getString(9)+newline;
	    		   }
	    		 else  if(i==8)
	    		   {
	    			message=message+resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5)+" "+resultSet.getString(6)+" "+resultSet.getString(7)+" "+resultSet.getString(8)+newline;
	    		   }
	    		 else  if(i==7)
	    		   {
	    			message=message+resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5)+" "+resultSet.getString(6)+" "+resultSet.getString(7)+newline;
	    		   }
	    		 else  if(i==6)
	    		   {
	    			message=message+resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5)+" "+resultSet.getString(6)+newline;
	    		   }
	    		 else  if(i==5)
	    		   {
	    			message=message+resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5)+newline;
	    		   }
	    		 else  if(i==4)
	    		   {
	    			message=message+resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+newline;
	    		   }
	    		 else  if(i==3)
	    		   {
	    			message=message+resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+newline;
	    		   }
	    		 else  if(i==2)
	    		   {
	    			message=message+resultSet.getString(1)+" "+resultSet.getString(2)+newline;
	    		   }
	    		 else  if(i==1)
	    		   {
	    			message=message+resultSet.getString(1)+newline;
	    		   }
	    		 else 
	    		 {
	    			 message=message+"No records";
	    		 }
	    		 //data.add(message);
	      }
	      
	     // writeToFile(message, File_Path+"Employee.txt");
		//resultSet.next();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
   
 return message;
}



public List<SimpleBranch> GetKYC_Count_Report_General2(String Search_query,int Bcode) throws SQLException{
	//--Set Connection----------------------------
	int j=Bcode;
	this.template=con.getCon2(j);
//-----------------------------------------------------
	int i=0;
	String message=null;
	// List data = new ArrayList();
	
	//String query = "Select count(*) from LoginDetails where Username='"+User_Id+"'";
	PreparedStatement pstmt = null;
	try {
		pstmt = template.getDataSource().getConnection().prepareStatement(Search_query);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ResultSet resultSet = null;
	resultSet = pstmt.executeQuery();
		 ResultSetMetaData rsmd = resultSet.getMetaData();
	      //getting the column type
	      i = rsmd.getColumnCount();
	
final int k=i;
return template.query(Search_query,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
{ 
 
	SimpleBranch gl=new SimpleBranch(); 
   if(k>=10)
   {
	gl.setS31(rs.getString(1));//Customer_id
	gl.setS32(rs.getString(2));//Customer_name
	gl.setS33(rs.getString(3));//Created_Date
	gl.setS34(rs.getString(4));//Mobile_No
	gl.setS35(rs.getString(5));//Customer_id
	gl.setS36(rs.getString(6));//Customer_name
	gl.setS37(rs.getString(7));//Created_Date
	gl.setS38(rs.getString(8));//Mobile_No
	gl.setS39(rs.getString(9));//Created_Date
	gl.setS40(rs.getString(10));//Mobile_No
	
   }
   else  if(k==9)
   {
	gl.setS31(rs.getString(1));//Customer_id
	gl.setS32(rs.getString(2));//Customer_name
	gl.setS33(rs.getString(3));//Created_Date
	gl.setS34(rs.getString(4));//Mobile_No
	gl.setS35(rs.getString(5));//Customer_id
	gl.setS36(rs.getString(6));//Customer_name
	gl.setS37(rs.getString(7));//Created_Date
	gl.setS38(rs.getString(8));//Mobile_No
	gl.setS39(rs.getString(9));//Created_Date
	
   }
   else  if(k==8)
   {
	gl.setS31(rs.getString(1));//Customer_id
	gl.setS32(rs.getString(2));//Customer_name
	gl.setS33(rs.getString(3));//Created_Date
	gl.setS34(rs.getString(4));//Mobile_No
	gl.setS35(rs.getString(5));//Customer_id
	gl.setS36(rs.getString(6));//Customer_name
	gl.setS37(rs.getString(7));//Created_Date
	gl.setS38(rs.getString(8));//Mobile_No
	
   }
   else  if(k==7)
   {
	gl.setS31(rs.getString(1));//Customer_id
	gl.setS32(rs.getString(2));//Customer_name
	gl.setS33(rs.getString(3));//Created_Date
	gl.setS34(rs.getString(4));//Mobile_No
	gl.setS35(rs.getString(5));//Customer_id
	gl.setS36(rs.getString(6));//Customer_name
	gl.setS37(rs.getString(7));//Created_Date
	
   }
   else  if(k==6)
   {
	gl.setS31(rs.getString(1));//Customer_id
	gl.setS32(rs.getString(2));//Customer_name
	gl.setS33(rs.getString(3));//Created_Date
	gl.setS34(rs.getString(4));//Mobile_No
	gl.setS35(rs.getString(5));//Customer_id
	gl.setS36(rs.getString(6));//Customer_name
	
   }
   else  if(k==5)
   {
	gl.setS31(rs.getString(1));//Customer_id
	gl.setS32(rs.getString(2));//Customer_name
	gl.setS33(rs.getString(3));//Created_Date
	gl.setS34(rs.getString(4));//Mobile_No
	gl.setS35(rs.getString(5));//Customer_id
	
   }
   else  if(k==4)
   {
	gl.setS31(rs.getString(1));//Customer_id
	gl.setS32(rs.getString(2));//Customer_name
	gl.setS33(rs.getString(3));//Created_Date
	gl.setS34(rs.getString(4));//Mobile_No
	
   }
   else  if(k==3)
   {
	gl.setS31(rs.getString(1));//Customer_id
	gl.setS32(rs.getString(2));//Customer_name
	gl.setS33(rs.getString(3));//Created_Date
	
   }
   else  if(k==2)
   {
	gl.setS31(rs.getString(1));//Customer_id
	gl.setS32(rs.getString(2));//Customer_name
	
   }
   else  if(k==1)
   {
	gl.setS31(rs.getString(1));//Customer_id
	
   }
   else
   {
	   
   }
	
	return gl;
}
 }     ); 
}






public static String File_Path="e:/Backup/";

/*private static void writeToFile(String list, String path) {
    BufferedWriter out = null;
    try {
            java.io.File file = new java.io.File(path);
            out = new BufferedWriter(new FileWriter(file, true));
                  out.write(list);            out.close();

                   
                             
    } catch (IOException e) {
    }
}*/


//06/06/2020
public List<SimpleBranch> getThirdCustomerInfo(String table,String Account_No,int Bcode){
	
	int j=Bcode;
	this.template=con.getCon2(j);
	return template.query("select CUSTOMER_ID_3,CUSTOMER_NAME_3 from "+table+" where Account_No='"+Account_No+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
	{  

		SimpleBranch gl=new SimpleBranch();
	
		gl.setS1(rs.getInt(1));  //CUSTOMER_ID_2
		gl.setS2(rs.getString(2));  //CUSTOMER_NAME_2
	
		
		
						
		return gl;
	}
	 }     );
}





//09-06-2020

public List<SimpleBranch> getJewel_Details_Total(int Bcode, String Account_No) {
	// --Set Connection------------------------------------
	int j = Bcode;
	this.template = con.getCon2(j);
	// -----------------------------------------------------
	return template
			.query("Select SUM(No_of_Items) as No_of_Items,SUM(Gross_Weight) as Gross_Weight,SUM(DEDUCTION) as DEDUCTION,SUM(NET_WEIGHT) as NET_WEIGHT,SUM(ELIGIBLE_AMT) as ELIGIBLE_AMT,SUM(Rate_Per_Gram) as Rate_Per_Gram,SUM(Purity) as Purity,Sum(sdeduction) as Sdeduction from Jewel_Details where Account_No='"
					+ Account_No + "'", new RowMapper<SimpleBranch>() {
				public SimpleBranch mapRow(ResultSet rs, int row)
						throws SQLException {
					SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
					 DecimalFormat df = new DecimalFormat("0.00");
					 DecimalFormat df1 = new DecimalFormat("0.000");
					SimpleBranch jm = new SimpleBranch();
					
					jm.setS41(rs.getInt(1));
					jm.setS51(rs.getFloat(2));
					jm.setS52(rs.getFloat(3));
					jm.setS53(rs.getFloat(4));
					jm.setS54(rs.getFloat(5));
					jm.setS13(rs.getFloat(6));
					jm.setS1(rs.getInt(7));
					jm.setS32(df.format(rs.getFloat(5)));  //eligible amt
					//jm.setS17(rs.getFloat(7));
					jm.setS55(rs.getFloat(8));//sdeduct
					
					jm.setS32(df.format(rs.getFloat(5)));  //eligible amt
					jm.setS2(df.format(rs.getFloat(6)));    // rate per gram
					jm.setS3(df1.format(rs.getFloat(8)));    // sdeduction
					jm.setS31(df1.format(rs.getFloat(3)));   // deduction
					jm.setS33(df1.format(rs.getFloat(4)));   // net weight
					jm.setS34(df1.format(rs.getFloat(2)));   // gross weight
					return jm;
				}
			});
}


public String getAttachement_Name1(String Account_no,String Attachment) {
	//--Set Connection------------------------------------
	int j=Binfo;
	this.template=con.getCon2(j);
	//-----------------------------------------------------
	String i=null;
	String query = "select "+Attachment+" from JL_APPROVAL_STATUS where Account_No='"+Account_no+"'";

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

public String getAttachement_FilesName1(int id) {
	//--Set Connection------------------------------------
	int j=Binfo;
	this.template=con.getCon2(j);
	//-----------------------------------------------------
	String i=null;
	String query = "select file_Name from JL_Attachments where id="+id+"";

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


public List<SimpleBranch> getJewel_Attachement(String Account_No) {
	// --Set Connection------------------------------------
	int j = Binfo;
	this.template = con.getCon2(j);
	// -----------------------------------------------------
	return template
			.query("Select id,branch,Account_No,File_Name from  JL_Attachments where Account_No='"+ Account_No + "' order by id", new RowMapper<SimpleBranch>() {
				public SimpleBranch mapRow(ResultSet rs, int row)
						throws SQLException {
					SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");

					SimpleBranch jm = new SimpleBranch();

				jm.setS41(rs.getInt(1));//ID
				jm.setS31(rs.getString(2));   	// Branch
				jm.setS32(rs.getString(3));   	// Account No
				jm.setS33(rs.getString(4));   	// FileNAme
					
					return jm;
				}
			});
}


public int Delete_Transaction(int txnId,String txnDate,String User,int Bcode){  
	//--Set Connection----------------------------
	int j=Bcode;
	this.template=con.getCon2(j);
//-----------------------------------------------------

    System.out.println("Save_Deleted Transaction");
	int flag=0;
					
	
	try{
		CallableStatement stmt=template.getDataSource().getConnection().prepareCall("{call Delete_Transaction(?,?,?)}");
		stmt.setInt(1,txnId);
		stmt.setString(2,txnDate);
		stmt.setString(3,User);
		
		
		System.out.println("-- Saved_Deleted Transaction");
		
		//register the OUT parameter before calling the stored procedure
			//stmt.registerOutParameter(3, java.sql.Types.INTEGER);
		
		//ResultSet rs=stmt.executeQuery();
		//read the OUT parameter now
		 try{
				ResultSet rs =stmt.executeQuery();
				flag=1;
				}
				catch(Exception e)
			 	 {
				System.out.println(e);
				flag=2;
			 	 }	
	}catch(Exception e)
	 	 {
		System.out.println(e);
	 	 }
	
	return flag;

}

public String[] GetPermission(String user,String path) throws SQLException
{
	//--Set Connection----------------------------
	int j=201;
	this.template=con.getCon2(j);
	//-----------------------------------------------------

	System.out.println(" User="+ user);
	System.out.println(" Path="+ path);
	
	String[] permission=new String[7];
	try{
		CallableStatement stmt=template.getDataSource().getConnection().prepareCall("{call Get_Permission_Set(?,?,?,?,?,?,?,?,?)}");
		stmt.setString(1,user);
		stmt.setString(2,path);
		
		//register the OUT parameter before calling the stored procedure
		stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
		stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
		stmt.registerOutParameter(5, java.sql.Types.VARCHAR);
		stmt.registerOutParameter(6, java.sql.Types.VARCHAR);
		stmt.registerOutParameter(7, java.sql.Types.VARCHAR);
		stmt.registerOutParameter(8, java.sql.Types.VARCHAR);
		stmt.registerOutParameter(9, java.sql.Types.VARCHAR);
		stmt.executeQuery();
	
		//stmt.execute();
		//read the OUT parameter now
		     permission[0]=stmt.getString(3);
		     permission[1]=stmt.getString(4);
		     permission[2]=stmt.getString(5);
		     permission[3]=stmt.getString(6);
		     permission[4]=stmt.getString(7);
		     permission[5]=stmt.getString(8);
		     permission[6]=stmt.getString(9);
		     System.out.println(" permission[0]="+ permission[0]);
		     System.out.println(" permission[0]="+ permission[1]);
		     System.out.println(" permission[0]="+ permission[2]);
		     System.out.println(" permission[0]="+ permission[3]);
		     System.out.println(" permission[0]= "+ permission[4]);
		     System.out.println(" permission[0]="+ permission[5]);
		     System.out.println(" permission[0]="+ permission[6]);
		     
		     stmt.getConnection().commit();
			 stmt.getConnection().close();
			
			// flag = stmt.getInt(3);
			// ResultSet rs = ((OracleCallableStatement)stmt).getCursor(4);
			// ResultSet rs1= (ResultSet) stmt.getObject(4);

			// while (rs.next ())
			// {      System.out.println ("method 1="+rs.getInt(1));
			// flag=rs.getInt(1);
			// }
			// while (rs1.next ())
			    //  System.out.println ("method 2="+rs1.getInt(1));
	}catch(Exception e)
	 	 {
		System.out.println(e);
	 	 }
	return permission;

}


//DL List
//------------------------------------------------FD Account List---SEARCH----------------------------------------------------------------------------------------------------	
public List<SimpleBranch>getAccountListSearch_DL(String From_Date,String To_Date,String searchKey,int Bcode)
{
	//--Set Connection------------------------------------
	int j=201;
	this.template=con.getCon2(j);
	//-----------------------------------------------------

   String sql="select Customer_Id,Customer_Name,Account_No,To_Char(Open_Date,'dd/MM/yyyy'),Loan_Amount,Period_Days,Interest_Rate,Account_Status,branch,Status from OL_Master_view_C2 where open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') and Scheme_Code in (Select Scheme_Code from Scheme_Master where Scheme_Category='DL')and (ACCOUNT_NO LIKE '%"+searchKey+"%' or CUSTOMER_ID LIKE '%"+searchKey+"%' or upper(CUSTOMER_NAME) like '%"+searchKey.toUpperCase()+"%') order by Account_No desc";
   System.out.println(sql);
	return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																			{  
	
		SimpleBranch gl=new SimpleBranch();
	    gl.setS1(rs.getInt(1)); //Customer_Id
		gl.setS2(rs.getString(2)); //Customer_Name
		//old gl.setS19(rs.getInt(3)); //Account_No
		
		//new
		gl.setS7(rs.getLong(3)); //Account_No
		
		gl.setS4(rs.getString(4)); //Open_Date
		gl.setS11(rs.getInt(5));//Loan_Amount
		gl.setS12(rs.getInt(6));//Period_Days
		gl.setS13(rs.getFloat(7));//Interest_Rate
		gl.setS5(rs.getString(8));//Account_Status
		gl.setS31(rs.getString(9));//branch
		gl.setS132(rs.getString(10)); // Approval staus
		
	return gl;
																			}
 																		 }     );
}





public List<SimpleBranch> getCusInfo(int cusId,int Bcode){
	//--Set Connection----------------------------
			int j=Bcode;
			this.template=con.getCon2(j);
			//-----------------------------------------------------

	return template.query("select * from CUSTOMER where CUSTOMER_ID='"+cusId+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
	{  

		SimpleBranch gl=new SimpleBranch();
	
		gl.setS2(rs.getString(33));  //nominee name
		gl.setS3(rs.getString(34));  //nominee relation
		gl.setS4(rs.getString(35));  //nominee age
		gl.setS5(rs.getString(36));  //nominee dob
		gl.setS9(rs.getString(5));   // cus name
		gl.setS10(rs.getString(11));  //cus address
		
		gl.setS31(rs.getString(41));//PAN_NO
		gl.setS6(rs.getString(6));//DOB
		gl.setS32(rs.getString(25)); //Mobile No
		
		gl.setS35(rs.getString(12));   //City
		gl.setS36(rs.getString(13));   //Pincode
		//System.out.println(rs.getString(41));
						
		return gl;
	}
	 }     );
}		



public int getYear_Between_TwoDates(String Current_Date,String DOB) {
	//--Set Connection------------------------------------
	int j=Binfo;
	this.template=con.getCon2(j);
	
	//Changed query
//-----------------------------------------------------
	/*int i=0;
	String query = "select floor(Months_Between(to_date('"+Current_Date+"','dd/MM/yyyy'),to_date('"+DOB+"','dd/MM/yyyy'))/12) from dual";

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
		i=resultSet.getInt(1);
		
		//i=resultSet.getRow();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	return i;*/
	
	int i=0;
	PreparedStatement pstmt = null;
	try {
		pstmt = template.getDataSource().getConnection().prepareStatement("select floor(Months_Between(to_date(?,'dd/MM/yyyy'),to_date(?,'dd/MM/yyyy'))/12) from dual");
		pstmt.setString(1, Current_Date);
		pstmt.setString(2, DOB);
		
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
		i=resultSet.getInt(1);
		
		//i=resultSet.getRow();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	return i;
} 


//JL List
//------------------------------------------------FD Account List---SEARCH----------------------------------------------------------------------------------------------------	
public List<SimpleBranch>getAccountListSearch_JL(String From_Date,String To_Date,String searchKey,int Bcode)
{
	//--Set Connection------------------------------------
	int j=201;
	this.template=con.getCon2(j);
	//-----------------------------------------------------

 String sql="select Customer_Id,Customer_Name,Account_No,To_Char(Open_Date,'dd/MM/yyyy'),Loan_Amount,Period_Days,Interest_Rate,Account_Status,branch from JL_Master_view where open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') and Scheme_Code in (Select Scheme_Code from Scheme_Master where Scheme_Category='JL')and (ACCOUNT_NO LIKE '%"+searchKey+"%' or CUSTOMER_ID LIKE '%"+searchKey+"%' or upper(CUSTOMER_NAME) like '%"+searchKey.toUpperCase()+"%') order by Account_No desc";
 System.out.println(sql);
	return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																			{  
	
		SimpleBranch gl=new SimpleBranch();
	    gl.setS1(rs.getInt(1)); //Customer_Id
		gl.setS2(rs.getString(2)); //Customer_Name
		gl.setS7(rs.getLong(3)); //Account_No
		
		gl.setS4(rs.getString(4)); //Open_Date
		gl.setS11(rs.getInt(5));//Loan_Amount
		gl.setS12(rs.getInt(6));//Period_Days
		gl.setS13(rs.getFloat(7));//Interest_Rate
		gl.setS5(rs.getString(8));//Account_Status
		gl.setS31(rs.getString(9));//branch
	
	return gl;
																			}
																		 }     );
}

public String getBranchName_ccode(String cuscode) {
	//--Set Connection------------------------------------
	int j=Binfo;
	this.template=con.getCon2(j);
	//-----------------------------------------------------
	String i=null;
	String query = "select branch_name from branch_master where substr(BRANCH_CUSIDFROM,0,3)='"+cuscode+"'";

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


public String getBranchName_bcode(String bcode) {
	//--Set Connection------------------------------------
	int j=Binfo;
	this.template=con.getCon2(j);
	//-----------------------------------------------------
	String i=null;
	String query = "select branch_name from branch_master where to_char(branch_code)='"+bcode+"'";

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

//------------------------------------------------FD Account List---SEARCH----------------------------------------------------------------------------------------------------	
public List<SimpleBranch>getAccountListSearch_FD_All(String From_Date,String To_Date,String searchKey,int Bcode)
{
	
	//--Set Connection------------------------------------
				int j=Bcode;
				this.template=con.getCon2(j);
	//-----------------------------------------------------

  if(searchKey.matches("-?\\d+(\\.\\d+)?"))
		  {
	return template.query("select * from FD_Master_View WHERE  (ACCOUNT_NO LIKE '%"+searchKey+"%' or CUSTOMER_ID LIKE '%"+searchKey+"%' or DEPOSIT_AMOUNT LIKE '%"+searchKey+"%' or Maturity_Amount like '%"+searchKey+"%') and open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') order by OPEN_DATE desc,Scheme_Code,Account_No desc",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																			{  
		SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
																			SimpleBranch gl=new SimpleBranch();
																			gl.setS1(rs.getInt(1));//branch
																			
																			gl.setS4(rs.getString(3));		//ACCOUNT_NO
																			gl.setS11(rs.getInt(4));	//CUSTOMER_ID
																			
																			gl.setS2(rs.getString(5));	//CUSTOMER_NAME
																			
																			gl.setS15(rs.getDate(8));	//OPEN_DATE
																			gl.setS31(sd.format(rs.getDate(8)));//OPEN_DATE1
																			
																			
																			
																			gl.setS3(rs.getString(10));	//SCHEME_CODE
																			
																			
																			gl.setS16(rs.getDate(18));	//MATURITY_DATE
																			gl.setS32(sd.format(rs.getDate(18)));//MATURITY_DATE1
																			
																			gl.setS12(rs.getInt(19));	//MATURITY_AMOUNT
																			DecimalFormat df = new DecimalFormat("0.00");
																			String Maturity=df.format(rs.getInt(19));
																			gl.setS33(Maturity);
																			
																			gl.setS5(rs.getString(26));	//ACCOUNT_STATUS
																			gl.setS34(rs.getString(11));	//ModeOfOperation	
																				return gl;
																			}
 																		 }     );
		  }
  
  else
  {
	  return template.query("select * from FD_Master_View WHERE (Upper(CUSTOMER_NAME) LIKE '%"+searchKey.toUpperCase()+"%' or SCHEME_CODE LIKE '%"+searchKey+"%') and open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy')  order by OPEN_DATE desc,Scheme_Code,Account_No",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																	{  
		  SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
																	SimpleBranch gl=new SimpleBranch();
																	gl.setS1(rs.getInt(1));//branch
																	
																	gl.setS4(rs.getString(3));		//ACCOUNT_NO
																	gl.setS11(rs.getInt(4));	//CUSTOMER_ID
																	
																	gl.setS2(rs.getString(5));	//CUSTOMER_NAME
																	
																	gl.setS15(rs.getDate(8));	//OPEN_DATE
																	gl.setS31(sd.format(rs.getDate(8)));//OPEN_DATE1
																	
																	
																	
																	gl.setS3(rs.getString(10));	//SCHEME_CODE
																	
																	
																	gl.setS16(rs.getDate(18));	//MATURITY_DATE
																	gl.setS32(sd.format(rs.getDate(18)));//MATURITY_DATE1
																	
																	gl.setS12(rs.getInt(19));	//MATURITY_AMOUNT
																	DecimalFormat df = new DecimalFormat("0.00");
																	String Maturity=df.format(rs.getInt(19));
																	gl.setS33(Maturity);
																	
																	gl.setS5(rs.getString(26));	//ACCOUNT_STATUS
																	gl.setS34(rs.getString(11));	//ModeOfOperation
																	
																		return gl;
																	}
																	 }     );
  }
  
  
  
  
}



public List<SimpleBranch> getUserDetailsList(){
	//--Set Connection----------------------------
			int j=201;
			this.template=con.getCon2(j);
			//-----------------------------------------------------
	return template.query("select USERNAME,USER_LEVEL, case when vALUE !='B' then 'Active' else 'Blocked' end as v1 from LOGINDETAILS order by username",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
	{  

		SimpleBranch gl=new SimpleBranch();
		
		gl.setS2(rs.getString(1));
		
		gl.setS3(rs.getString(2));
		gl.setS4(rs.getString(3));
		
		
						
		return gl;
	}
	 }     );
}



//Lock individual User

		public int Lock_Individual_User_Corp(String user_name)
		{  
			//--Set Connection----------------------------
			int j=Binfo;
			this.template=con.getCon2(j);
			//-----------------------------------------------------
			
			String sql="Update LoginDetails Set value='B' Where Username not in ('200001') and Username='"+user_name+"'";
			 template.update(sql);
			
			return 1;
		}
	
		
//Lock individual User
		
		public int UnLock_Individual_User_Corp(String user_name)
		{  
			//--Set Connection----------------------------
			int j=Binfo;
			this.template=con.getCon2(j);
			//-----------------------------------------------------
			
			String sql="Update LoginDetails Set value='B' Where Username!='200001' and Username='"+user_name+"'";
			 template.update(sql);
			
			return 1;
		}
		
		
		// Reset Password individual User
		
		public int Resetpassword_Individual_User_Corp(String user_name)
		{  
			//--Set Connection----------------------------
			int j=Binfo;
			this.template=con.getCon2(j);
			//-----------------------------------------------------
			
			String sql="Update Login_Details Set PASSWORD='b4WE4bXVBj0=' Where Username!='200001' and Username='"+user_name+"'";
			 template.update(sql);
			// 123456     cypher => b4WE4bXVBj0=
			//  asdfgh      cypher => jQk3UopmCqY=
			 
			return 1;
		}

		 public int getJLCount(String Current) {
				//--Set Connection----------------------------
						int j=Binfo;
						this.template=con.getCon2(j);
						//-----------------------------------------------------
							int i=0;
				//Old select COUNT(*) from MESSAGE_NOTIFICATION left outer join user_message_notification on user_message_notification.subject=MESSAGE_NOTIFICATION.subject   WHERE TO1='"+Bcode+"' and user_name='"+User+"' and View_Status='N'
				//New select a.*,b.* from  (select subject,branch_code,user_name,VIEW_STATUS from user_message_notification where VIEW_STATUS='N' order by user_message_notification.BRANCH_CODE)a left join (select Message_id,to1,subject,flag from Message_Notification where flag='N')b on a.branch_code=b.to1 WHERE a.branch_code='"+Bcode+"' and a.user_name='"+User+"';
				
							String query="select count(*) from (select a.*,b.Branch_Name from (Select * from JL_Master_View  order By branch ,open_date desc,account_no)a left join (select Branch_Code,Branch_Name from Branch_Master)b on a.Branch=b.Branch_Code)c WHERE  c.open_date= to_date('"+Current+"','dd/MM/yyyy') ";

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

		 
		 //07-11-2022
			public String getOldNo(String Account_No,int BCode) {
				//--Set Connection------------------------------------
				int j=BCode;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				String i=null;
				String query = "select Renewal_No from FD_Master where Account_No='"+Account_No+"'";

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
			
			public String Get_ScalarFun(String query,int BCode) {
				//--Set Connection------------------------------------
				int j=BCode;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				String i=null;
				System.out.println(query);
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


			//10-11-2022
			public int saveException_Info(String Branch,String Current,String Type,String Cause,String Line,String Details,String user,String url){  

				//--Set Connection------------------------------------
							int j=Binfo;
							this.template=con.getCon2(j);
				//-----------------------------------------------------
							String type1=Type.substring(0, Math.min(Type.length(), 1500)).replaceAll("'", " ");
				System.out.println("--- inside save exception ------------");
			  String sql="insert into Ex_Details(BRANCH,EX_DATE,EX_TYPE,EX_CLAUSE,EX_LINE,EX_DETAILS,CREATED_USER,TIME_INFO,url)values('"+Branch+"',to_char(sysdate,'dd/MM/yyyy'),'"+Type.substring(0, Math.min(Type.length(), 1500)).replaceAll("'", " ")+"','"+Cause.substring(0, Math.min(Cause.length(), 1500)).replaceAll("'", " ")+"','"+Line.substring(0, Math.min(Line.length(), 1500)).replaceAll("'", " ")+"','"+Details.substring(0, Math.min(Details.length(), 1500)).replaceAll("'", " ")+"','"+user+"',TO_CHAR(SYSDATE,'dd/mm/yyyy HH12:MI:SS AM'),'"+url.substring(0, Math.min(url.length(), 1500)).replaceAll("'", " ")+"')";
			  System.out.println(sql);
			  return template.update(sql);  
			}  
			
			public String getUser_Level(String User,int Bcode)
			{
				
				//--Set Connection------------------------------------
				int j=Bcode;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
	

				String i="";
				String query = "select User_Level from LoginDetails where username='"+User+"'";
				System.out.println(query);
				
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
					if(resultSet!=null)
					{
						while(resultSet.next())
						{
							i=resultSet.getString(1);
						}
					}
					
					
					//i=resultSet.getRow();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println("dao-get Mat Amt ");	
				return i;
			}

			
			public int getTransactionVerify_Count(String Tran_Id,String Tran_Date,int Bcode)
			{
				
				//--Set Connection------------------------------------
				int j=Bcode;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
	

				int i=0;
				String query = "select Count(*) from Daily_Transaction where Transaction_Id='"+Tran_Id+"' and Transaction_Date='"+Tran_Date+"' and Authorized_by is not null and Verified_by is not null and Verified_by_3 is not null";
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
					if(resultSet!=null)
					{
						while(resultSet.next())
						{
							i=resultSet.getInt(1);
						}
					}
					
					
					//i=resultSet.getRow();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("dao-get Dep Amt ");		
				return i;
			}

			public int getTransactionVerify_Count(String Account_No,int Bcode)
			{
				
				//--Set Connection------------------------------------
				int j=Bcode;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
	

				int i=0;
				String query = "select nvl(count(*),0) from(select * from Daily_Transaction where Account_No='"+Account_No+"' and Authorized_by is not null and Verified_by is not null and Verified_by_3 is not null order by Transaction_date asc) a where rownum=1";
			System.out.println(query);
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
					if(resultSet!=null)
					{
						while(resultSet.next())
						{
							i=resultSet.getInt(1);
						}
					}
					
					
					//i=resultSet.getRow();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("dao-get Dep Amt ");		
				return i;
			}

			
			public String getPrint_Status(String Account_No,int Bcode)
			{
				
				//--Set Connection------------------------------------
				int j=Bcode;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
	

				String i="";
				String query = "select nvl(Print_Status,'0') as Print_Status from FD_Master where Account_No='"+Account_No+"'";
			
				System.out.println(query);
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
					if(resultSet!=null)
					{
						while(resultSet.next())
						{
							i=resultSet.getString(1);
						}
					}
					
					
					//i=resultSet.getRow();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("dao-get Dep Amt ");		
				return i;
			}
			
			public List<SimpleBranch> GetKYC_Count_Report_all(String Search_query,String FromDate,String To_Date,int BranchCode,String AccStartNo,int Bcode){
				//--Set Connection----------------------------
				int j=201;
				this.template=con.getCon2(j);
	//-----------------------------------------------------


			return template.query("select to_char(Customer_id),Customer_name,to_char(Created_Date,'dd/MM/yyyy'),to_char(Mobile_No) from customer_View where created_date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy')",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
			{ 
		     
				SimpleBranch gl=new SimpleBranch(); 
			   
				gl.setS31(rs.getString(1));//Customer_id
				gl.setS32(rs.getString(2));//Customer_name
				gl.setS33(rs.getString(3));//Created_Date
				gl.setS34(rs.getString(4));//Mobile_No
				
				
				
				return gl;
			}
			 }     ); 
		}

			public List<SimpleBranch> GetOnlineMember_Count_Report(String Search_query,String FromDate,String To_Date,int BranchCode,String AccStartNo,int Bcode){
				//--Set Connection----------------------------
				int j=Bcode;
				this.template=con.getCon2(j);
			//-----------------------------------------------------

				//String sql="select main_qry.Customer_id,(select customer_name from customer_view where customer_id=main_qry.customer_id and rownum=1) as Customer_Name,main_qry.appstatus as Dhanam_App,main_qry.memstatus as Member_Online from (select distinct cus.customer_id,Replace(Replace(nvl(app.status,'No'),'Y','Yes'),'C','No') as appstatus,Replace(Replace(nvl(mem.Status,'No'),'A','Yes'),'C','No') as memstatus from customer_view cus left join app_registration app on cus.customer_id=app.CUSTOMER_ID left join member_login1 mem on cus.customer_id=mem.customer_id where customer_status='A' order by customer_id)main_qry where main_qry.appstatus !='N' or main_qry.memstatus !='N'";

				String sql="select main_qry.Customer_id,main_qry.Customer_Name,main_qry.appstatus as Dhanam_App,main_qry.memstatus as Member_Online from (select  cus.customer_id,cus.Customer_Name,Replace(Replace(nvl(app.status,'No'),'Y','Yes'),'C','No') as appstatus,Replace(Replace(nvl(mem.Status,'No'),'A','Yes'),'C','No') as memstatus from customer_view cus left join app_registration app on cus.customer_id=app.CUSTOMER_ID left join member_login1 mem on cus.customer_id=mem.customer_id where customer_status='A' and mig_flag='N' order by customer_id)main_qry where main_qry.appstatus !='No' or main_qry.memstatus !='No'";
				
				System.out.println(sql);
				
				return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
			{ 
			 
				SimpleBranch gl=new SimpleBranch(); 
			   
				gl.setS31(rs.getString(1));//Customer_id
				gl.setS32(rs.getString(2));//Customer_name
				gl.setS33(rs.getString(3));//Created_Date
				gl.setS34(rs.getString(4));//Mobile_No
				
				
				
				return gl;
			}
			 }     ); 
			}

			public List<SimpleBranch> GetOnlineMember_Count_Report_Branch(String Search_query,String FromDate,String To_Date,String BranchCode,String AccStartNo,int Bcode){
				//--Set Connection----------------------------
				int j=Bcode;
				this.template=con.getCon2(j);
			//-----------------------------------------------------

				//String sql="select main_qry.Customer_id,(select customer_name from customer_view where customer_id=main_qry.customer_id and rownum=1) as Customer_Name,main_qry.appstatus as Dhanam_App,main_qry.memstatus as Member_Online from (select distinct cus.customer_id,Replace(Replace(nvl(app.status,'No'),'Y','Yes'),'C','No') as appstatus,Replace(Replace(nvl(mem.Status,'No'),'A','Yes'),'C','No') as memstatus from customer_view cus left join app_registration app on cus.customer_id=app.CUSTOMER_ID left join member_login1 mem on cus.customer_id=mem.customer_id where customer_status='A' order by customer_id)main_qry where main_qry.appstatus !='N' or main_qry.memstatus !='N'";

				String sql="select main_qry.Customer_id,main_qry.Customer_Name,main_qry.appstatus as Dhanam_App,main_qry.memstatus as Member_Online from (select  cus.customer_id,cus.Customer_Name,Replace(Replace(nvl(app.status,'No'),'Y','Yes'),'C','No') as appstatus,Replace(Replace(nvl(mem.Status,'No'),'A','Yes'),'C','No') as memstatus,cus.Branch  from customer_view cus left join app_registration app on cus.customer_id=app.CUSTOMER_ID left join member_login1 mem on cus.customer_id=mem.customer_id where customer_status='A' and mig_flag='N' and cus.Branch='"+BranchCode+"' order by customer_id)main_qry where main_qry.appstatus !='No' or main_qry.memstatus !='No'";
				
				System.out.println("sql--------------"+sql);
				
				return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
			{ 
			 
				SimpleBranch gl=new SimpleBranch(); 
			   
				gl.setS31(rs.getString(1));//Customer_id
				gl.setS32(rs.getString(2));//Customer_name
				gl.setS33(rs.getString(3));//Created_Date
				gl.setS34(rs.getString(4));//Mobile_No
				
				
				
				return gl;
			}
			 }     ); 
			}



			public List<SimpleBranch> getFD_TranId(String Account_No,int Bcode){

				//--Set Connection------------------------------------
							int j=Bcode;
							this.template=con.getCon2(j);
				//-----------------------------------------------------
				return template.query("select Transaction_Id,Open_Date from FD_master where Account_No='"+Account_No+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
				{  
SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");


					
					SimpleBranch gl=new SimpleBranch();
					
					gl.setS4(rs.getString(1));		//Tran_Id
					
					gl.setS15(rs.getDate(2));	//OPEN_DATE
					gl.setS31(sd.format(rs.getDate(2)));//OPEN_DATE1
					
					
					
									
					return gl;
				}
				 }     );
			}

			
			
			

					

			
			public int Save_FD_Print_Status(String Account_No,String cnt, int DBCode) throws SQLException
			{

				//--Set Connection------------------------------------
				            int j=DBCode;
				            this.template=con.getCon2(j);


						    String sql1="update FD_Master set Print_Status='"+cnt+"' where Account_No='"+Account_No+"'";
						    System.out.println("sql----------"+sql1);
						    return template.update(sql1);  
				            
			}
			
			public int updatePrint_Details(Search se,String User, String curr_date, int Bcode){  

				//--Set Connection----------------------------
				int j=Bcode;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
					String sessionId;
					sessionId=RequestContextHolder.currentRequestAttributes().getSessionId();
					
				    String sql="Update FD_PRINT set Certificate_No = '"+se.getCertificate_no()+"', Created_By='"+User+"', Created_Date='"+curr_date+"' where Account_No='"+se.getAccount_No()+"'";  
				   	try
				    	{template.update(sql);  
				    	}
				    	catch(Exception e)
				    	{
				    		System.out.println(e);
				    	}
				    		
				    		 return 1; 
				} 


			public int getFD_Printcount(String Acc_No,String Cer, int Bcode)
			{

				//--Set Connection----------------------------
				int j=Bcode;
				this.template=con.getCon2(j);
				//-----------------------------------------------------


				int i=0;
				String query = "Select count(*) from FD_PRINT where Account_No='"+Acc_No+"' and Certificate_No='"+Cer+"'";
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

			public String getFDCertificate(String Acc_No, int Bcode)
			{

				//--Set Connection----------------------------
				int j=Bcode;
				this.template=con.getCon2(j);
				//-----------------------------------------------------


				String i="";
				String query = "Select Certificate_No from FD_PRINT where Account_No='"+Acc_No+"'";
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
							  i=resultSet.getString(1);
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


			public int savePrint_Details(Search se,String User,String curr_date, int Bcode){  

				//--Set Connection----------------------------
				int j=Bcode;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
					String sessionId;
					sessionId=RequestContextHolder.currentRequestAttributes().getSessionId();
					
				    String sql="insert into FD_PRINT (Account_No, Member_Id, Member_Name,Certificate_No,Created_By,Created_Date,DELIVERY_STATUS,DELIVERY_Date) values('"+se.getAccount_No()+"','"+se.getCusString1()+"','"+se.getName()+"','"+se.getCertificate_no()+"','"+User+"','"+curr_date+"','Ready to Dispatch','"+curr_date+"')";  
				   	try
				    	{template.update(sql);  
				    	}
				    	catch(Exception e)
				    	{
				    		System.out.println(e);
				    	}
				    		
				    		 return 1; 
				} 

	



public int getcertificate_count(String Cer, int Bcode)
			{

				//--Set Connection----------------------------
				int j=Bcode;
				this.template=con.getCon2(j);
				//-----------------------------------------------------


				int i=0;
				String query = "select Count(*) from FD_Print_VIEW where CERTIFICATE_NO ='"+Cer+"'";
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
			public List<SimpleBranch> getMemberDetails(String Acc_No,int Bcode){
				//--Set Connection----------------------------
						int j=Bcode;
						this.template=con.getCon2(j);
						//-----------------------------------------------------

				return template.query("select * from FD_Master_View where Account_NO='"+Acc_No+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
				{  

					SimpleBranch gl=new SimpleBranch();
				
					gl.setS10(rs.getString(4));  //nominee name
					gl.setS35(rs.getString(5));  //nominee relation
					
										
					return gl;
				}
				 }     );
			}
	


public List<SimpleBranch> getFDDetails(String Acc_No,int Bcode){
	//--Set Connection----------------------------
			int j=Bcode;
			this.template=con.getCon2(j);
			//-----------------------------------------------------

	return template.query("select * from FD_Master where Account_NO='"+Acc_No+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
	{  

		SimpleBranch gl=new SimpleBranch();
	
		gl.setS2(rs.getString(5));  //nominee name
		gl.setS3(rs.getString(6));  //nominee relation
		gl.setS4(rs.getString(56));  //nominee age
		gl.setS5(rs.getString(57));  //nominee dob
		gl.setS6(rs.getString(10));  //nominee dob
							
		return gl;
	}
	 }     );
}



public int DeleteFD_Print(String ID,int Bcode){  
	//--Set Connection----------------------------
	int j=Bcode;
	this.template=con.getCon2(j);
//-----------------------------------------------------


    String sql="delete from FD_Print where Id='"+ID+"'";  
    return template.update(sql);  
}

public List<SimpleBranch> getFD_Print(String Acc_No,int Bcode){
	//--Set Connection----------------------------
			int j=Bcode;
			this.template=con.getCon2(j);
			//-----------------------------------------------------

	return template.query("select * from FD_Print where Account_NO='"+Acc_No+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
	{  

		SimpleBranch gl=new SimpleBranch();
	
		gl.setS2(rs.getString(4));  //nominee name
		gl.setS3(rs.getString(5));  //nominee relation
		gl.setS4(rs.getString(6));  //nominee age
		gl.setS5(rs.getString(7));  //nominee dob
		gl.setS6(rs.getString(1));  //nominee dob
		gl.setS31(rs.getString(8));  //nominee dob
							
		return gl;
	}
	 }     );
}

public String getCus_MobileNo(String Mem_Id, int Bcode)
{

	//--Set Connection----------------------------
	int j=Bcode;
	this.template=con.getCon2(j);
	//-----------------------------------------------------


	String i="";
	String query = "select Mobile_No from Customer where Customer_Id='"+Mem_Id+"'";
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
				  i=resultSet.getString(1);
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

public int Send_SMS(String Msg,String Phone_Num,int Bcode) throws IOException
{	

//	String Msg1=Msg.replaceAll(" ", "%20");
	
	String Cname=con.GetCompName();
	String SMSTemplate=con.GetSMSTemplate();
	System.out.println("name="+Cname);
	System.out.println("name="+Cname);
	System.out.println("SMSTemplate="+SMSTemplate);
	String orig_msg = Msg; 
	 String Msg1=Msg.replaceAll(" ", "%20");
	 System.out.println("Msg1="+Msg1);
	 if(SMSTemplate.equalsIgnoreCase("SNIDHI"))
	 {
		 String myStr = "Narayani%20Nidhi" ;
		 Msg1=Msg1.replaceAll("Narayani%20(K)%20Nidhi",myStr);
		 System.out.println("afterSnnl="+Msg1);
	 }
	 if(SMSTemplate.equalsIgnoreCase("SNNLKM"))
	 {
		 String myStr = "Narayani%20(K)%20Nidhi" ;
		 if(Msg1.contains("Your%20OTP%20is%20"))//Your%20OTP%20is%20
		 {
			 myStr = "Narayani%20(Kumbakonam)%20Nidhi";
		 }
		 
		 Msg1= Msg1.replaceAll("Narayani%20Nidhi",myStr);
		 System.out.println("afterSnknl="+Msg1);
	 }

String Phone_Num1=Phone_Num;

//String Msg1=Msg;
//String Phone_Num1=Phone_Num;
//String requestUrl  = "http://adithya.me/adithya/Api?username=sangari&password=sangarikarthik&senderid=SNIDHI&message="+Msg+"&route=T&msgtype=normal&mobileno="+Phone_Num+"";
	 
//feb 2018
//URL url = new URL("http://pay4sms.in/sendsms/?token=37c3ba65cf890e100c6de94e19e86889&credit=2&sender=%20SNIDHI&message="+Msg1+"&number="+Phone_Num1);



//24-MAR2018
//http://adithya.me/adithya/Api/?username=SNNLKMTRANS&password=phenomenon&senderid=SNNLKM&message=HAI&route=T&msgtype=normal&mobileno=
//URL url = new URL("http://adithya.me/adithya/Api/?username=SNNLKMTRANS&password=phenomenon&senderid=SNNLKM&message="+Msg1+"&route=T&msgtype=normal&mobileno="+Phone_Num1);


//15-10-2018
//https://sms.nettyfish.com/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn=1111111111&sid=SNIDHI&msg=test%20message&fl=0&gwid=2
//URL url = new URL("https://sms.nettyfish.com/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn="+Phone_Num1+"&sid=SNIDHI&msg="+Msg1+"&fl=0&gwid=2");
//String urlMsg="http://45.127.101.185/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn="+Phone_Num1+"&sid=SNIDHI&msg="+Msg1+"&fl=0&gwid=2";
//System.out.println("OTPurl= "+urlMsg);
//URL url = new URL("http://45.127.101.185/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn="+Phone_Num1+"&sid=SNIDHI&msg="+Msg1+"&fl=0&gwid=2");

//27-09-2021
//http://139.99.131.165:6005/api/v2/SendSMS?ApiKey=f65e33e4e4b71544d8d9e6f5a4175ea3&ClientId=SNNLPROMO&SenderId=SNIDHI&Message=Dear%20Customer,%20Your%20Savings%20a/c%20no.%20XXXXXX1147%20Credited%20with%20Rs.%205000.00%20on%2027/09/2021%20transacted%20at%20Shri%20Narayani%20Nidhi%20Ltd.,%20SNNL.MO-001.%20Available%20balance%20Rs.83750.00&MobileNumbers=9790138395&Is_Unicode=false&Is_Flash=false
//URL url = new URL("http://139.99.131.165:6005/api/v2/SendSMS?ApiKey=f65e33e4e4b71544d8d9e6f5a4175ea3&ClientId=SNNLPROMO&SenderId=SNIDHI&Message="+Msg1+"&MobileNumbers="+Phone_Num1+"&Is_Unicode=true&Is_Flash=false");

///https://sms.nettyfish.com/api/v2/SendSMS?SenderId=SNIDHI&Message=Shri%20Narayani%20%3A%20Missed%20Call%20Alert%20%3ADDS%20Account%20No%3A%7B%23var%23%7D%20Balance%20is%20Rs.%20%7B%23var%23%7D&MobileNumbers=9790138395&ApiKey=10f295cf-ac88-4cfc-a245-31713df36a44&ClientId=3c870543-480b-4491-832b-e71a23db1f4a
//04-10-2021 01
//URL url = new URL("https://sms.nettyfish.com/api/v2/SendSMS?SenderId=SNIDHI&Message="+Msg1+"&MobileNumbers="+Phone_Num1+"&ApiKey=10f295cf-ac88-4cfc-a245-31713df36a44&ClientId=3c870543-480b-4491-832b-e71a23db1f4a");

//04-10-2021 02
//https://sms.nettyfish.com/api/v2/SendSMS?ApiKey=10f295cf-ac88-4cfc-a245-31713df36a44&ClientId=3c870543-480b-4491-832b-e71a23db1f4a&SenderId=SNIDHI&Message="+Msg1+"&MobileNumbers="+Mobile1+"
//URL url = new URL("https://sms.nettyfish.com/api/v2/SendSMS?ApiKey=10f295cf-ac88-4cfc-a245-31713df36a44&ClientId=3c870543-480b-4491-832b-e71a23db1f4a&SenderId=SNIDHI&Message="+Msg1+"&MobileNumbers="+Phone_Num1+"");

//Final before 22-09-2023
//String sql="http://139.99.131.165:6005/api/v2/SendSMS?ApiKey=10f295cf-ac88-4cfc-a245-31713df36a44&ClientId=3c870543-480b-4491-832b-e71a23db1f4a&SenderId=SNIDHI&Message="+Msg1+"&MobileNumbers="+Phone_Num1+"";
//System.out.println(sql);

//22-09-2023
//String sql = "http://apin.onex-aura.com/api/sms?entityid=1701159179346008981&key=X9nZL1dB&to="+Phone_Num1+"&body=" + Msg + "&from=SNIDHI";
//203.112.151.144
//String sql = "http://203.112.151.144/api/sms?entityid=1701159179346008981&key=X9nZL1dB&to="+Phone_Num1+"&body=" + Msg1 + "&from=SNIDHI";
//16-05-2024
// old String sql = "http://203.112.151.144/api/sms?entityid=1701159179346008981&key=X9nZL1dB&to="+Phone_Num1+"&body=" + Msg1 + "&from="+SMSTemplate+"";
//05-09-2024
//String sql = "http://203.112.151.144/api/sms?entityid=1701159179346008981&key=X9nZL1dB&to="+Phone_Num1+"&body=" + Msg1 + "&from="+SMSTemplate+"";

//05-09-2024
String sql = "http://www.agilecomm.co.in/aglcsms/sendsms?username=SNNLTXN&password=SnN24Lkm03&to="+Phone_Num1+"&message="+Msg1+"&from="+SMSTemplate+"";


//String sql="http://139.99.131.165:6005/api/v2/SendSMS?ApiKey=10f295cf-ac88-4cfc-a245-31713df36a44&ClientId=3c870543-480b-4491-832b-e71a23db1f4a&SenderId=SNIDHI&Message="+Msg1+"&MobileNumbers="+Phone_Num1+"";

try{
//05-10-2021
URL url = new URL(sql);

HttpURLConnection uc = (HttpURLConnection)url.openConnection();
//------ SMS Response ------- 
InputStream in = uc.getInputStream();
String encoding = uc.getContentEncoding();
encoding = encoding == null ? "UTF-8" : encoding;
String body = IOUtils.toString(in, encoding);
System.out.println("res_body="+body);

this.template=con.getCon2(Bcode);
String resp_sql="update Sms set Msg_err_Desc='"+body+"' where replace(MSG,'%20',' ')='"+ orig_msg.replaceAll("%20"," ")+"' and PHONE_NO='"+Phone_Num+"' and Msg_err_Desc is NULL";
template.update(resp_sql);

System.out.println("uc.getResponseMessage()="+uc.getResponseMessage());
//SMS_Response(uc, (Msg1).replaceAll("%20", " "), Phone_Num,Bcode);
System.out.println("Message has been sent--");
System.out.println(Phone_Num);  

uc.disconnect();

}
catch(Exception e)
{
	
}
finally
{
	
}
return 1;
}





public String getDeliveryStatus(String Acc_no, int Bcode)
{

	//--Set Connection----------------------------
	int j=201;
	this.template=con.getCon2(j);
	//-----------------------------------------------------


	String i="N";
	String query = "select case when Delivery_Status = 'Ready to Dispatch' then 'y' else 'N' end as Delivery_Status from Fd_Print_View where id in ( select MAx(Id) as id from Fd_Print_View  group by Account_No) and Account_No='"+Acc_no+"'";
	 System.out.println("query---"+query);
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
				  i=resultSet.getString(1);
				  System.out.println("i---"+i);
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



public int deleteJewel_Desc(String desc,int Bcode){  
	//--Set Connection------------------------------------
	this.template=con.getCon3();
//-----------------------------------------------------
    String sql="delete from JEWEL_DESCRIPTION where JDESC='"+desc+"'";  
    return template.update(sql);  
}



public void insertStates(List<State> stateList) {
	// TODO Auto-generated method stub
	
} 



			
}
