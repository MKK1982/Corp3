package com.Pisquare.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
import com.Pisquare.Beans.GL_Master;
import com.Pisquare.Beans.JL_Master;
import com.Pisquare.Beans.Login;
import com.Pisquare.Beans.Branch_Master;
import com.Pisquare.Beans.Simple;
import com.Pisquare.Beans.SimpleBranch;
import com.Pisquare.Beans.Staff_Master;
import com.Pisquare.Beans.UserDetails;
import com.Pisquare.Controllers.Configuration_Controller;


public class ApprovalDao {
	
	int Binfo=201;
	
	@Autowired
	private Configuration_Controller con;
JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template)
	{
		this.template=template;
		
	}
	
	//getJL_List

	// Fill JL List
			
			public List<SimpleBranch> getJL_List(int Bcode) 
			{
				//--Set Connection------------------------------------
				int j=Binfo;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				return template.query("Select * from JL_Master_View order by OPEN_DATE desc,Branch desc,Account_No desc",new RowMapper<SimpleBranch>(){  public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
				{  
					SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
					
					SimpleBranch jm=new SimpleBranch();
					jm.setS41(rs.getInt(1));//branch
					jm.setS1(rs.getInt(4));//cus id
					jm.setS3(rs.getString(5)); //cus name
					jm.setS2(rs.getString(3)); //acc no
					jm.setS9(sd.format(rs.getDate(6))); //open
					jm.setS5(sd.format(rs.getDate(12))); //due
					jm.setS6(rs.getString(9)); //loan
					jm.setS11(rs.getInt(10)); //mon
					jm.setS12(rs.getInt(13)); //int
					jm.setS10(rs.getString(24));//acc status
					jm.setS31(rs.getString(51));//CoOp Status
					
					return jm;
				}
			});
			}

	//getAccountListSearch2
  	// Search JL List with Type
			
					public List<SimpleBranch>getAccountListSearch2(String searchKey,int Search_Type,String Radio_Type,String From_Date,String To_Date,int Bcode)
					{
						//--Set Connection------------------------------------
						int j=Binfo;
						this.template=con.getCon2(j);
						//-----------------------------------------------------
						if(searchKey.equalsIgnoreCase(null) && searchKey.isEmpty())
						{
							searchKey="2";
						}
						//select a.*,b.Branch_Name from (Select * from JL_Master_View WHERE  (to_char(Branch) like '%"+searchKey+"%' or Account_No like '%"+searchKey+"%') and open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') order By OPEN_DATE desc,Account_No desc,Branch)a left join (select Branch_Code,Branch_Name from Branch_Master)b on a.Branch=b.Branch_Code
						//new select c.* from (select a.*,b.Branch_Name from (Select * from JL_Master_View  order By branch ,open_date desc,account_no)a left join (select Branch_Code,Branch_Name from Branch_Master)b on a.Branch=b.Branch_Code)c WHERE  (to_char(c.Branch) like '%"+searchKey+"%' or c.Account_No like '%"+searchKey+"%' or upper(c.branch_name) like '%"+searchKey+"%') and c.open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy');
						String Sqlquery="select c.* from (select a.*,b.Branch_Name from (Select * from JL_Master_View  order By branch ,open_date desc,account_no)a left join (select Branch_Code,Branch_Name from Branch_Master)b on a.Branch=b.Branch_Code)c WHERE  (to_char(c.Branch) like '%"+searchKey+"%' or c.Account_No like '%"+searchKey+"%' or upper(c.branch_name) like '%"+searchKey.toUpperCase()+"%') and c.open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy')";
						System.out.println(Sqlquery);
						
						return template.query(Sqlquery,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
						//return template.query("Select * from JL_Master WHERE ACCOUNT_NO LIKE '%"+searchKey+"%' and SCHEME_CODE like '%"+Radio_Type+"%'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																								{  
							
							SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
						
							SimpleBranch jm=new SimpleBranch();
																								
							
							jm.setS41(rs.getInt(1));//branch
							jm.setS1(rs.getInt(4));//cus id
							jm.setS3(rs.getString(5)); //cus name
							jm.setS2(rs.getString(3)); //acc no
							jm.setS9(sd.format(rs.getDate(6))); //open
							jm.setS5(sd.format(rs.getDate(12))); //due
							jm.setS6(rs.getString(9)); //loan
							jm.setS11(rs.getInt(10)); //mon
							jm.setS12(rs.getInt(13)); //int
							jm.setS10(rs.getString(24));//acc status
							jm.setS31(rs.getString(51));//CoOp Status
							jm.setS32(rs.getString(53));//Branch Name
							
																									
							return jm;
																								}
					 																		 }     );
							
					
					}
					

					
					
					//getJL_Master_List
					//getNarration

						// Fetch JL Master
							
							public List<JL_Master> getJL_Master_List(String Account_No,int Bcode) 
							{
								//--Set Connection------------------------------------
								int j=Bcode;
								this.template=con.getCon2(j);
								//-----------------------------------------------------
								return template.query("Select * from JL_Master where Account_No='"+Account_No+"'",new RowMapper<JL_Master>(){  public JL_Master mapRow(ResultSet rs, int row) throws SQLException
								{  
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									JL_Master jm=new JL_Master();
									
									jm.setCust_Id(rs.getInt(3));
									jm.setAcc_No(rs.getString(2));
									jm.setCust_Info(rs.getString(4));
									jm.setAcc_Open_Date(sd.format(rs.getDate(5)));
									jm.setRate_per_Gram(rs.getFloat(41));
									jm.setMarket_Rate(rs.getFloat(15));
									jm.setInterest_Rate(rs.getFloat(12));
									jm.setPenal_Rate(rs.getFloat(13));
									jm.setGross_Wt(rs.getInt(44));
									jm.setDeduction(rs.getInt(45));
									jm.setNet_Wt(rs.getInt(46));	
									jm.setLoan_Amount(rs.getInt(8));
									jm.setPeriod_Months(rs.getInt(9));
									jm.setDue_Date(sd.format(rs.getDate(11)));
									jm.setNominee_Name(rs.getString(18));
									jm.setNominee_Relation(rs.getString(19));
									jm.setNominee_Age(rs.getString(20));
									jm.setReferred_By(rs.getInt(43));
									jm.setScheme_Code(rs.getString(6));									
									jm.setTrans_Id(rs.getInt(31));
									jm.setTrans_Date(sd.format(rs.getDate(32)));
									jm.setAppraiser_Fee(rs.getInt(16));
									jm.setInsurance(rs.getInt(17));
									jm.setForms(rs.getInt(36));
									jm.setPostage(rs.getInt(35));
									
									jm.setStatus(rs.getString(23));
									jm.setCOOP_STATUS(rs.getString(53));
									
									jm.setPurity(rs.getInt(54));
					                jm.setDuration(rs.getString(55));
									//System.out.println("rs.getFloat(41)="+rs.getFloat(41));
									
									return jm;
								}
							});
							}
							
							// Fetch Narration
							
							public List<JL_Master> getNarration(int Transaction_Id,String Transaction_Date,String Account_No,int Bcode) 
							{
								//--Set Connection------------------------------------
								int j=Bcode;
								this.template=con.getCon2(j);
								//-----------------------------------------------------
								return template.query("Select Transaction_Particulars from DAILY_TRANSACTION where Transaction_Id='"+Transaction_Id+"' and Transaction_Date=to_date('"+Transaction_Date+"','dd/MM/yyyy') and Account_No='"+Account_No+"'",new RowMapper<JL_Master>(){  public JL_Master mapRow(ResultSet rs, int row) throws SQLException
								{  
									SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									
									JL_Master jm=new JL_Master();
									
									jm.setNarration(rs.getString(1));
									
									return jm;
								}
							});
							}
					//getSchemeCodeName_Jewel
					//getGL_Head
					//getJewel_Desc
					//getJewel_Details

						// Fill Scheme

						public List<JL_Master> getSchemeCodeName_Jewel(int Bcode){
							//--Set Connection------------------------------------
							int j=Bcode;
							this.template=con.getCon2(j);
							//-----------------------------------------------------
							return template.query("Select Scheme_Name as Name,Scheme_Code from Scheme_Master where Scheme_Category='JL' and Scheme_Master.Status='A'",new RowMapper<JL_Master>(){   public JL_Master mapRow(ResultSet rs, int row) throws SQLException
							{  

								JL_Master gl=new JL_Master();
							
								gl.setScheme(rs.getString(1));
								gl.setHd_Scheme_Code(rs.getString(2));

								return gl;
							}
							 }     );
						}
						
						
						// Fill Jewel Description

							public List<SimpleBranch> getJewelDescription(int Bcode){
								//--Set Connection------------------------------------
								int j=Bcode;
								this.template=con.getCon2(j);
								//-----------------------------------------------------
								return template.query("Select DESCRIPTION,NO_OF_ITEMS from Jewel_Details",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
								{  

									SimpleBranch gl=new SimpleBranch();
								
									gl.setS2(rs.getString(1));
									gl.setS1(rs.getInt(2));

									return gl;
								}
								 }     );
							}

						// Fill GL Code
						
						public List<JL_Master> getGL_Head(int Bcode){
							//--Set Connection------------------------------------
							int j=Bcode;
							this.template=con.getCon2(j);
					//-----------------------------------------------------
							return template.query("Select GL_Master.GL_CODE,GL_Master.GL_NAME from GL_Master right join Transaction_GL_Code on Transaction_GL_Code.GL_Code=GL_Master.GL_Code where Scheme_Code=60010 and Transaction_Type='Credit' order by Id",new RowMapper<JL_Master>(){   public JL_Master mapRow(ResultSet rs, int row) throws SQLException
							{  

								JL_Master gl=new JL_Master();
								
								gl.setGL_Code(rs.getInt(1));
								gl.setGL_Head(rs.getString(2));

								return gl;
							}
							 }     );
						}
						
						
						// Fill Jewel Description
						
							public List<JL_Master> getJewel_Desc(int Bcode){
							//--Set Connection------------------------------------
								int j=Bcode;
								this.template=con.getCon2(j);
							//-----------------------------------------------------
								return template.query("Select JDESC from Jewel_Description",new RowMapper<JL_Master>(){   public JL_Master mapRow(ResultSet rs, int row) throws SQLException
								{  
									JL_Master gl=new JL_Master();
									
									gl.setDdl_Jewel_Desc(rs.getString(1));

									return gl;
								}
								 });
							}
							
							// Delete Jewel Details
							
							public int Delete_Jewel_Details(String Account_No,int Id,int Bcode) {
								//--Set Connection----------------------------
								int j=Bcode;
								this.template=con.getCon2(j);
								//-----------------------------------------------------
								
								int i=0;
								String query = "Delete from Jewel_Details where Account_No='"+Account_No+"' and Id="+Id+"";
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
							
								System.out.println("AccNoFrom db="+i);
								return 1;
							} 
							
						

					//getCusInfo

						
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
								
								//System.out.println(rs.getString(41));
												
								return gl;
							}
							 }     );
						}


						// Fill Jewel Description
						
					/*	public List<SimpleBranch> getJewel_Details(int Bcode,String Account_No) 
						{
							//--Set Connection------------------------------------
							int j=Bcode;
							this.template=con.getCon2(j);
							//-----------------------------------------------------
							return template.query("Select DESCRIPTION,NO_OF_ITEMS,GROSS_WEIGHT,DEDUCTION,NET_WEIGHT,Id,Rate_Per_Gram,Stone,Eligible_Amt,Purity from Jewel_Details where Account_No='"+Account_No+"'",new RowMapper<SimpleBranch>(){  public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
							{  
								SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
								
								SimpleBranch jm=new SimpleBranch();
								
								jm.setS31(rs.getString(1));
								jm.setS41(rs.getInt(2));
								jm.setS51(rs.getFloat(3));
								jm.setS52(rs.getFloat(4));
								jm.setS53(rs.getFloat(5));
								jm.setS42(rs.getInt(6));
								jm.setS17(rs.getFloat(7));   // Rate per gram
								jm.setS10(rs.getString(8));  // stone
								jm.setS13(rs.getFloat(9));   //eligible amt
								jm.setS11(rs.getInt(10));    // purity
								
								return jm;
							}
						});
						}
*/




						
						public int UpdateJL_Details(String Account_No,int Bcode){  

							//--Set Connection------------------------------------
										int j=Bcode;
										this.template=con.getCon2(j);
							//-----------------------------------------------------
						    String sql="update JL_Master set COOP_STATUS='Approved' where Account_No='"+Account_No+"'";  
						    return template.update(sql);  
						}
						
						
						public int UpdateCash_DenominationStatus(String Date1,int Bcode){  

							//--Set Connection------------------------------------
										int j=Bcode;
										this.template=con.getCon2(j);
							//-----------------------------------------------------
						    String sql="update Cash_Denomination set STATUS='Y' where TRANSACTION_DATE=to_date('"+Date1+"','dd/MM/yyyy')";
						    
						  
						    	System.out.println("day end denomination saved");
						    	template.update(sql);
						    	System.out.println("day end denomination updated.....");
						    
						    
						    return 1;  
						}  
						
						
						public int Check_CashDenomiationRecord(String Date1,int Bcode)
						{
							
							//--Set Connection------------------------------------
							int j=Bcode;
							this.template=con.getCon2(j);
							//-----------------------------------------------------
			  
			
			
							int i=0;
							String query = "Select count(*) from Cash_Denomination where TRANSACTION_DATE=to_date('"+Date1+"','dd/MM/yyyy')";
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
						public List<SimpleBranch> getPurity(String Scheme_Code,float Interest,float Rate_Per_Gram, int Bcode) {
							// --Set Connection------------------------------------
							int j = Bcode;
							this.template = con.getCon2(j);
							// -----------------------------------------------------
							return template
									.query("Select PURITY from interest_rate_master where SCHEME_CODE='"+Scheme_Code+"' and INTEREST_RATE="+Interest+" and LOAN_AMOUNT="+Rate_Per_Gram+"",
											new RowMapper<SimpleBranch>() {
												public SimpleBranch mapRow(ResultSet rs, int row)
														throws SQLException {
													SimpleDateFormat sd = new SimpleDateFormat(
															"dd/MM/yyyy");

													SimpleBranch gl = new SimpleBranch();
					                                gl.setS1(rs.getInt(1)); // PURITY
												
												
													return gl;
												}
											});
						}
						
				
						
						
//getCusInfo

						
						public List<SimpleBranch> getPreClosureDocDetails_NotApproved(){
							//--Set Connection----------------------------
									int j=Binfo;
									this.template=con.getCon2(j);
									//-----------------------------------------------------

							return template.query("select BRANCH_CODE,ACCOUNT_NO,to_char(CURRENT_DATE,'dd/MM/yyyy'),REMARKS,APPROVE_STATUS,FILENAME,ACCOUNT_NAME from PRECLOSUREDOCS where APPROVE_STATUS='N' order by CURRENT_DATE desc",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
							{  

								SimpleBranch gl=new SimpleBranch();
							
								
								
								gl.setS1(rs.getInt(1));  //BRANCH_CODE
								gl.setS2(rs.getString(2));  //ACCOUNT_NO
								gl.setS3(rs.getString(3));  //CURRENT_DATE
								gl.setS4(rs.getString(4));  //REMARKS
								gl.setS5(rs.getString(5));  //APPROVE_STATUS
								gl.setS31(rs.getString(6));   // FILENAME
								gl.setS32(rs.getString(7));  //ACCOUNT_NAME
								
								
												
								return gl;
							}
							 }     );
						}
						
						
						
						public List<SimpleBranch> getPreClosureDocDetails_Search(String key,String status,int bcode){
							//--Set Connection----------------------------
									int j=Binfo;
									this.template=con.getCon2(j);
									//-----------------------------------------------------

							return template.query("select BRANCH_CODE,ACCOUNT_NO,to_char(CURRENT_DATE,'dd/MM/yyyy'),REMARKS,APPROVE_STATUS,FILENAME,ACCOUNT_NAME from PRECLOSUREDOCS where APPROVE_STATUS like '%"+status+"%' and BRANCH_CODE="+bcode+" and (ACCOUNT_NO like '%"+key+"%' or ACCOUNT_NAME like '"+key+"') order by CURRENT_DATE desc",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
							{  

								SimpleBranch gl=new SimpleBranch();
							
								
								
								gl.setS1(rs.getInt(1));  //BRANCH_CODE
								gl.setS2(rs.getString(2));  //ACCOUNT_NO
								gl.setS3(rs.getString(3));  //CURRENT_DATE
								gl.setS4(rs.getString(4));  //REMARKS
								gl.setS5(rs.getString(5));  //APPROVE_STATUS
								gl.setS31(rs.getString(6));   // FILENAME
								gl.setS32(rs.getString(7));  //ACCOUNT_NAME
								
								
												
								return gl;
							}
							 }     );
						}
						
						public List<SimpleBranch> getPreClosureDocDetails_Search_All(String key,String status){
							//--Set Connection----------------------------
									int j=Binfo;
									this.template=con.getCon2(j);
									//-----------------------------------------------------

							return template.query("select BRANCH_CODE,ACCOUNT_NO,to_char(CURRENT_DATE,'dd/MM/yyyy'),REMARKS,APPROVE_STATUS,FILENAME,ACCOUNT_NAME from PRECLOSUREDOCS where APPROVE_STATUS like '%"+status+"%' and (ACCOUNT_NO like '%"+key+"%' or ACCOUNT_NAME like '"+key+"') order by CURRENT_DATE desc",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
							{  

								SimpleBranch gl=new SimpleBranch();
							
								
								
								gl.setS1(rs.getInt(1));  //BRANCH_CODE
								gl.setS2(rs.getString(2));  //ACCOUNT_NO
								gl.setS3(rs.getString(3));  //CURRENT_DATE
								gl.setS4(rs.getString(4));  //REMARKS
								gl.setS5(rs.getString(5));  //APPROVE_STATUS
								gl.setS31(rs.getString(6));   // FILENAME
								gl.setS32(rs.getString(7));  //ACCOUNT_NAME
								
								
												
								return gl;
							}
							 }     );
						}

						public int Update_PreclosureDocs(String Account_No,int Bcode){  

							//--Set Connection------------------------------------
										int j=Binfo;
										this.template=con.getCon2(j);
							//-----------------------------------------------------
						    String sql="update Preclosuredocs set APPROVE_STATUS='Y' where Account_No='"+Account_No+"' and BRANCH_CODE="+Bcode+"";  
						    return template.update(sql);  
						}	
						
						
						public List<SimpleBranch> getPendingDetails(String date1){
							//--Set Connection----------------------------
									int j=Binfo;
									this.template=con.getCon2(j);
									//-----------------------------------------------------

							return template.query("select a.*,(select Branch_name from dbuser1.Branch_master where to_char(Branch_code)=a.Branch)as branch_name from(Select Branch,COUNT(distinct(Transaction_Id)) as Pending from Daily_Transaction_table where Transaction_Date=to_date('"+date1+"','dd/MM/yyyy') and (Authorized_By is NULL or Verified_By is NULL or Verified_By_3 is NULL or Verified_By_4 is NULL or Verified_By_5 is NULL ) group by Branch)a",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
							{  

								SimpleBranch gl=new SimpleBranch();
							
								
								
								
								gl.setS2(rs.getString(1));  //ACCOUNT_NO
								gl.setS3(rs.getString(2));  //CURRENT_DATE
								gl.setS4(rs.getString(3));  //REMARKS
								
								
								
												
								return gl;
							}
							 }     );
						}
						
						public List<SimpleBranch> getDay_End_PendingDetails(String date1){
							//--Set Connection----------------------------
									int j=Binfo;
									this.template=con.getCon2(j);
									//-----------------------------------------------------
							//select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' ) a order by Status,Branch;
									//new select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' union select '218' as Branch,'Thillai Nagar' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser18.calendar1 where Status='O' ) a order by Status,Branch
									//New with thanjavur  select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' union select '218' as Branch,'Thillai Nagar' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser18.calendar1 where Status='O' union select '219' as Branch,'Thanjavur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser19.calendar1 where Status='O' ) a order by Status,Branch
	//String sql="select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' union select '218' as Branch,'Thillai Nagar' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser18.calendar1 where Status='O' union select '219' as Branch,'Thanjavur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser19.calendar1 where Status='O' union select '220' as Branch,'Chidambaram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser20.calendar1 where Status='O'   union select '221' as Branch,'Mylapore' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser21.calendar1 where Status='O' union select '222' as Branch,'Thirubuvanam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser22.calendar1 where Status='O' union select '223' as Branch,'Tambaram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser23.calendar1 where Status='O' union select '224' as Branch,'Karur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser24.calendar1 where Status='O') a order by Status,Branch";
	//16/10/2020
    //									String sql="select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' union select '218' as Branch,'Thillai Nagar' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser18.calendar1 where Status='O' union select '219' as Branch,'Thanjavur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser19.calendar1 where Status='O' union select '220' as Branch,'Chidambaram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser20.calendar1 where Status='O'   union select '221' as Branch,'Mylapore' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser21.calendar1 where Status='O' union select '222' as Branch,'Thirubuvanam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser22.calendar1 where Status='O' union select '223' as Branch,'Tambaram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser23.calendar1 where Status='O'  union   select '224' as Branch,'Karur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser24.calendar1 where Status='O'  union    select '225' as Branch,'Cantonment' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser25.calendar1 where Status='O'  union    select '226' as Branch,'Srirangam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser26.calendar1 where Status='O'  union    select '227' as Branch,'Thiruverumbur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser27.calendar1 where Status='O'  union    select '228' as Branch,'Comibatore' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser28.calendar1 where Status='O'  union    select '229' as Branch,'Pattukkottai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser29.calendar1 where Status='O'   ) a order by Status,Branch";
   //24/10/2020
									String sql="select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' union select '218' as Branch,'Thillai Nagar' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser18.calendar1 where Status='O' union select '219' as Branch,'Thanjavur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser19.calendar1 where Status='O' union select '220' as Branch,'Chidambaram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser20.calendar1 where Status='O'   union select '221' as Branch,'Mylapore' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser21.calendar1 where Status='O' union select '222' as Branch,'Thirubuvanam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser22.calendar1 where Status='O' union select '223' as Branch,'Tambaram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser23.calendar1 where Status='O'  union   select '224' as Branch,'Srirangam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser24.calendar1 where Status='O'  union    select '225' as Branch,'Cantonment' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser25.calendar1 where Status='O'  union    select '226' as Branch,'Kattur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser26.calendar1 where Status='O'  union    select '227' as Branch,'Thiruverumbur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser27.calendar1 where Status='O'  union    select '228' as Branch,'Manapparai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser28.calendar1 where Status='O'   union                      select '229' as Branch,'Karur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser29.calendar1 where Status='O'                  union                     select '230' as Branch,'Tiruppur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser30.calendar1 where Status='O'       union                      select '231' as Branch,'Coimbatore' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser31.calendar1 where Status='O'       union                      select '232' as Branch,'Pattukkottai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser32.calendar1 where Status='O'       union                      select '233' as Branch,'Chengalpattu' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser33.calendar1 where Status='O'  ) a order by Status,Branch";

	return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
							{  

								SimpleBranch gl=new SimpleBranch();
							
								
								
								
								gl.setS2(rs.getString(1));  //ACCOUNT_NO
								gl.setS3(rs.getString(2));  //CURRENT_DATE
								gl.setS4(rs.getString(3));  //REMARKS
								
								gl.setS12(rs.getInt(5));
					
								return gl;
							}
							 }     );
						}
						
						public List<SimpleBranch> getMonth_End_PendingDetails(String date1){
							//--Set Connection----------------------------
									int j=Binfo;
									this.template=con.getCon2(j);
									//-----------------------------------------------------

							return template.query("select c.*,b.User_Name from (select count(*),201 as Branch_Code from(select to_date('date1','dd/MM/yyyy') as To_day1,FD_Master.Customer_Id,FD_Master.Customer_Name,FD_Interest.Account_No,Reference_Id,FD_Interest.Interest,Interest_Payment_Mode,Interest_Credit_Account,case when Interest_Payment_Mode='Standing Instruction' then IFSC_Code else NEFT_Bank.Bank_Name End as Bank_Name,case when Interest_Payment_Mode='Standing Instruction' then NEFT_Account_Number else NEFT_Branch End as NEFT_Branch,Deduct_TDS,Scheme_Master.GL_GENERAL,(Select MOBILE_NO from dbuser1.customer where CUSTOMER_ID=Fd_Master.Customer_Id) as MobileNo from dbuser1.FD_Interest join dbuser1.FD_Master on FD_Interest.Account_No=FD_Master.Account_No left join dbuser1.NEFT_Bank on FD_Master.Bank_Code=NEFT_Bank.Bank_Code left join dbuser1.Scheme_Master on Scheme_Master.SCHEME_CODE=FD_Master.IFSC_Code where FD_Master.Account_Status='A' and Interest_Payment_Mode like 'Standing Instruction%' and FD_Interest.STATUS is  null and FD_Interest.To_Date =to_date('28/02/2019','dd/MM/yyyy'))a union select count(*), 202 as Branch_Code from(select to_date('date1','dd/MM/yyyy') as To_day1,FD_Master.Customer_Id,FD_Master.Customer_Name,FD_Interest.Account_No,Reference_Id,FD_Interest.Interest,Interest_Payment_Mode,Interest_Credit_Account,case when Interest_Payment_Mode='Standing Instruction' then IFSC_Code else NEFT_Bank.Bank_Name End as Bank_Name,case when Interest_Payment_Mode='Standing Instruction' then NEFT_Account_Number else NEFT_Branch End as NEFT_Branch,Deduct_TDS,Scheme_Master.GL_GENERAL,(Select MOBILE_NO from dbuser2.customer where CUSTOMER_ID=Fd_Master.Customer_Id) as MobileNo from dbuser2.FD_Interest join dbuser2.FD_Master on FD_Interest.Account_No=FD_Master.Account_No left join dbuser2.NEFT_Bank on FD_Master.Bank_Code=NEFT_Bank.Bank_Code left join dbuser2.Scheme_Master on Scheme_Master.SCHEME_CODE=FD_Master.IFSC_Code where FD_Master.Account_Status='A' and Interest_Payment_Mode like 'Standing Instruction%' and FD_Interest.STATUS is  null and FD_Interest.To_Date =to_date('28/02/2019','dd/MM/yyyy'))a union select count(*), 203 as Branch_Code from(select to_date('date1','dd/MM/yyyy') as To_day1,FD_Master.Customer_Id,FD_Master.Customer_Name,FD_Interest.Account_No,Reference_Id,FD_Interest.Interest,Interest_Payment_Mode,Interest_Credit_Account,case when Interest_Payment_Mode='Standing Instruction' then IFSC_Code else NEFT_Bank.Bank_Name End as Bank_Name,case when Interest_Payment_Mode='Standing Instruction' then NEFT_Account_Number else NEFT_Branch End as NEFT_Branch,Deduct_TDS,Scheme_Master.GL_GENERAL,(Select MOBILE_NO from dbuser3.customer where CUSTOMER_ID=Fd_Master.Customer_Id) as MobileNo from dbuser3.FD_Interest join dbuser3.FD_Master on FD_Interest.Account_No=FD_Master.Account_No left join dbuser2.NEFT_Bank on FD_Master.Bank_Code=NEFT_Bank.Bank_Code left join dbuser3.Scheme_Master on Scheme_Master.SCHEME_CODE=FD_Master.IFSC_Code where FD_Master.Account_Status='A' and Interest_Payment_Mode like 'Standing Instruction%' and FD_Interest.STATUS is  null and FD_Interest.To_Date =to_date('28/02/2019','dd/MM/yyyy'))a union select count(*), 204 as Branch_Code from(select to_date('date1','dd/MM/yyyy') as To_day1,FD_Master.Customer_Id,FD_Master.Customer_Name,FD_Interest.Account_No,Reference_Id,FD_Interest.Interest,Interest_Payment_Mode,Interest_Credit_Account,case when Interest_Payment_Mode='Standing Instruction' then IFSC_Code else NEFT_Bank.Bank_Name End as Bank_Name,case when Interest_Payment_Mode='Standing Instruction' then NEFT_Account_Number else NEFT_Branch End as NEFT_Branch,Deduct_TDS,Scheme_Master.GL_GENERAL,(Select MOBILE_NO from dbuser4.customer where CUSTOMER_ID=Fd_Master.Customer_Id) as MobileNo from dbuser4.FD_Interest join dbuser4.FD_Master on FD_Interest.Account_No=FD_Master.Account_No left join dbuser2.NEFT_Bank on FD_Master.Bank_Code=NEFT_Bank.Bank_Code left join dbuser4.Scheme_Master on Scheme_Master.SCHEME_CODE=FD_Master.IFSC_Code where FD_Master.Account_Status='A' and Interest_Payment_Mode like 'Standing Instruction%' and FD_Interest.STATUS is  null and FD_Interest.To_Date =to_date('28/02/2019','dd/MM/yyyy'))a union select count(*), 205 as Branch_Code from(select to_date('date1','dd/MM/yyyy') as To_day1,FD_Master.Customer_Id,FD_Master.Customer_Name,FD_Interest.Account_No,Reference_Id,FD_Interest.Interest,Interest_Payment_Mode,Interest_Credit_Account,case when Interest_Payment_Mode='Standing Instruction' then IFSC_Code else NEFT_Bank.Bank_Name End as Bank_Name,case when Interest_Payment_Mode='Standing Instruction' then NEFT_Account_Number else NEFT_Branch End as NEFT_Branch,Deduct_TDS,Scheme_Master.GL_GENERAL,(Select MOBILE_NO from dbuser5.customer where CUSTOMER_ID=Fd_Master.Customer_Id) as MobileNo from dbuser5.FD_Interest join dbuser5.FD_Master on FD_Interest.Account_No=FD_Master.Account_No left join dbuser2.NEFT_Bank on FD_Master.Bank_Code=NEFT_Bank.Bank_Code left join dbuser5.Scheme_Master on Scheme_Master.SCHEME_CODE=FD_Master.IFSC_Code where FD_Master.Account_Status='A' and Interest_Payment_Mode like 'Standing Instruction%' and FD_Interest.STATUS is  null and FD_Interest.To_Date =to_date('28/02/2019','dd/MM/yyyy'))a union select count(*), 206 as Branch_Code from(select to_date('date1','dd/MM/yyyy') as To_day1,FD_Master.Customer_Id,FD_Master.Customer_Name,FD_Interest.Account_No,Reference_Id,FD_Interest.Interest,Interest_Payment_Mode,Interest_Credit_Account,case when Interest_Payment_Mode='Standing Instruction' then IFSC_Code else NEFT_Bank.Bank_Name End as Bank_Name,case when Interest_Payment_Mode='Standing Instruction' then NEFT_Account_Number else NEFT_Branch End as NEFT_Branch,Deduct_TDS,Scheme_Master.GL_GENERAL,(Select MOBILE_NO from dbuser6.customer where CUSTOMER_ID=Fd_Master.Customer_Id) as MobileNo from dbuser6.FD_Interest join dbuser6.FD_Master on FD_Interest.Account_No=FD_Master.Account_No left join dbuser2.NEFT_Bank on FD_Master.Bank_Code=NEFT_Bank.Bank_Code left join dbuser6.Scheme_Master on Scheme_Master.SCHEME_CODE=FD_Master.IFSC_Code where FD_Master.Account_Status='A' and Interest_Payment_Mode like 'Standing Instruction%' and FD_Interest.STATUS is  null and FD_Interest.To_Date =to_date('28/02/2019','dd/MM/yyyy'))a union select count(*), 207 as Branch_Code from(select to_date('date1','dd/MM/yyyy') as To_day1,FD_Master.Customer_Id,FD_Master.Customer_Name,FD_Interest.Account_No,Reference_Id,FD_Interest.Interest,Interest_Payment_Mode,Interest_Credit_Account,case when Interest_Payment_Mode='Standing Instruction' then IFSC_Code else NEFT_Bank.Bank_Name End as Bank_Name,case when Interest_Payment_Mode='Standing Instruction' then NEFT_Account_Number else NEFT_Branch End as NEFT_Branch,Deduct_TDS,Scheme_Master.GL_GENERAL,(Select MOBILE_NO from dbuser7.customer where CUSTOMER_ID=Fd_Master.Customer_Id) as MobileNo from dbuser7.FD_Interest join dbuser7.FD_Master on FD_Interest.Account_No=FD_Master.Account_No left join dbuser2.NEFT_Bank on FD_Master.Bank_Code=NEFT_Bank.Bank_Code left join dbuser7.Scheme_Master on Scheme_Master.SCHEME_CODE=FD_Master.IFSC_Code where FD_Master.Account_Status='A' and Interest_Payment_Mode like 'Standing Instruction%' and FD_Interest.STATUS is  null and FD_Interest.To_Date =to_date('28/02/2019','dd/MM/yyyy'))a union select count(*), 208 as Branch_Code from(select to_date('date1','dd/MM/yyyy') as To_day1,FD_Master.Customer_Id,FD_Master.Customer_Name,FD_Interest.Account_No,Reference_Id,FD_Interest.Interest,Interest_Payment_Mode,Interest_Credit_Account,case when Interest_Payment_Mode='Standing Instruction' then IFSC_Code else NEFT_Bank.Bank_Name End as Bank_Name,case when Interest_Payment_Mode='Standing Instruction' then NEFT_Account_Number else NEFT_Branch End as NEFT_Branch,Deduct_TDS,Scheme_Master.GL_GENERAL,(Select MOBILE_NO from dbuser8.customer where CUSTOMER_ID=Fd_Master.Customer_Id) as MobileNo from dbuser8.FD_Interest join dbuser8.FD_Master on FD_Interest.Account_No=FD_Master.Account_No left join dbuser2.NEFT_Bank on FD_Master.Bank_Code=NEFT_Bank.Bank_Code left join dbuser8.Scheme_Master on Scheme_Master.SCHEME_CODE=FD_Master.IFSC_Code where FD_Master.Account_Status='A' and Interest_Payment_Mode like 'Standing Instruction%' and FD_Interest.STATUS is  null and FD_Interest.To_Date =to_date('28/02/2019','dd/MM/yyyy'))a union select count(*), 209 as Branch_Code from(select to_date('date1','dd/MM/yyyy') as To_day1,FD_Master.Customer_Id,FD_Master.Customer_Name,FD_Interest.Account_No,Reference_Id,FD_Interest.Interest,Interest_Payment_Mode,Interest_Credit_Account,case when Interest_Payment_Mode='Standing Instruction' then IFSC_Code else NEFT_Bank.Bank_Name End as Bank_Name,case when Interest_Payment_Mode='Standing Instruction' then NEFT_Account_Number else NEFT_Branch End as NEFT_Branch,Deduct_TDS,Scheme_Master.GL_GENERAL,(Select MOBILE_NO from dbuser9.customer where CUSTOMER_ID=Fd_Master.Customer_Id) as MobileNo from dbuser9.FD_Interest join dbuser9.FD_Master on FD_Interest.Account_No=FD_Master.Account_No left join dbuser2.NEFT_Bank on FD_Master.Bank_Code=NEFT_Bank.Bank_Code left join dbuser9.Scheme_Master on Scheme_Master.SCHEME_CODE=FD_Master.IFSC_Code where FD_Master.Account_Status='A' and Interest_Payment_Mode like 'Standing Instruction%' and FD_Interest.STATUS is  null and FD_Interest.To_Date =to_date('28/02/2019','dd/MM/yyyy'))a union select count(*), 210 as Branch_Code from(select to_date('date1','dd/MM/yyyy') as To_day1,FD_Master.Customer_Id,FD_Master.Customer_Name,FD_Interest.Account_No,Reference_Id,FD_Interest.Interest,Interest_Payment_Mode,Interest_Credit_Account,case when Interest_Payment_Mode='Standing Instruction' then IFSC_Code else NEFT_Bank.Bank_Name End as Bank_Name,case when Interest_Payment_Mode='Standing Instruction' then NEFT_Account_Number else NEFT_Branch End as NEFT_Branch,Deduct_TDS,Scheme_Master.GL_GENERAL,(Select MOBILE_NO from dbuser10.customer where CUSTOMER_ID=Fd_Master.Customer_Id) as MobileNo from dbuser10.FD_Interest join dbuser10.FD_Master on FD_Interest.Account_No=FD_Master.Account_No left join dbuser2.NEFT_Bank on FD_Master.Bank_Code=NEFT_Bank.Bank_Code left join dbuser10.Scheme_Master on Scheme_Master.SCHEME_CODE=FD_Master.IFSC_Code where FD_Master.Account_Status='A' and Interest_Payment_Mode like 'Standing Instruction%' and FD_Interest.STATUS is  null and FD_Interest.To_Date =to_date('28/02/2019','dd/MM/yyyy'))a union select count(*), 211 as Branch_Code from(select to_date('date1','dd/MM/yyyy') as To_day1,FD_Master.Customer_Id,FD_Master.Customer_Name,FD_Interest.Account_No,Reference_Id,FD_Interest.Interest,Interest_Payment_Mode,Interest_Credit_Account,case when Interest_Payment_Mode='Standing Instruction' then IFSC_Code else NEFT_Bank.Bank_Name End as Bank_Name,case when Interest_Payment_Mode='Standing Instruction' then NEFT_Account_Number else NEFT_Branch End as NEFT_Branch,Deduct_TDS,Scheme_Master.GL_GENERAL,(Select MOBILE_NO from dbuser11.customer where CUSTOMER_ID=Fd_Master.Customer_Id) as MobileNo from dbuser11.FD_Interest join dbuser11.FD_Master on FD_Interest.Account_No=FD_Master.Account_No left join dbuser2.NEFT_Bank on FD_Master.Bank_Code=NEFT_Bank.Bank_Code left join dbuser11.Scheme_Master on Scheme_Master.SCHEME_CODE=FD_Master.IFSC_Code where FD_Master.Account_Status='A' and Interest_Payment_Mode like 'Standing Instruction%' and FD_Interest.STATUS is  null and FD_Interest.To_Date =to_date('28/02/2019','dd/MM/yyyy'))a union select count(*), 212 as Branch_Code from(select to_date('date1','dd/MM/yyyy') as To_day1,FD_Master.Customer_Id,FD_Master.Customer_Name,FD_Interest.Account_No,Reference_Id,FD_Interest.Interest,Interest_Payment_Mode,Interest_Credit_Account,case when Interest_Payment_Mode='Standing Instruction' then IFSC_Code else NEFT_Bank.Bank_Name End as Bank_Name,case when Interest_Payment_Mode='Standing Instruction' then NEFT_Account_Number else NEFT_Branch End as NEFT_Branch,Deduct_TDS,Scheme_Master.GL_GENERAL,(Select MOBILE_NO from dbuser12.customer where CUSTOMER_ID=Fd_Master.Customer_Id) as MobileNo from dbuser12.FD_Interest join dbuser12.FD_Master on FD_Interest.Account_No=FD_Master.Account_No left join dbuser2.NEFT_Bank on FD_Master.Bank_Code=NEFT_Bank.Bank_Code left join dbuser12.Scheme_Master on Scheme_Master.SCHEME_CODE=FD_Master.IFSC_Code where FD_Master.Account_Status='A' and Interest_Payment_Mode like 'Standing Instruction%' and FD_Interest.STATUS is  null and FD_Interest.To_Date =to_date('28/02/2019','dd/MM/yyyy'))a union select count(*), 213 as Branch_Code from(select to_date('date1','dd/MM/yyyy') as To_day1,FD_Master.Customer_Id,FD_Master.Customer_Name,FD_Interest.Account_No,Reference_Id,FD_Interest.Interest,Interest_Payment_Mode,Interest_Credit_Account,case when Interest_Payment_Mode='Standing Instruction' then IFSC_Code else NEFT_Bank.Bank_Name End as Bank_Name,case when Interest_Payment_Mode='Standing Instruction' then NEFT_Account_Number else NEFT_Branch End as NEFT_Branch,Deduct_TDS,Scheme_Master.GL_GENERAL,(Select MOBILE_NO from dbuser13.customer where CUSTOMER_ID=Fd_Master.Customer_Id) as MobileNo from dbuser13.FD_Interest join dbuser13.FD_Master on FD_Interest.Account_No=FD_Master.Account_No left join dbuser2.NEFT_Bank on FD_Master.Bank_Code=NEFT_Bank.Bank_Code left join dbuser13.Scheme_Master on Scheme_Master.SCHEME_CODE=FD_Master.IFSC_Code where FD_Master.Account_Status='A' and Interest_Payment_Mode like 'Standing Instruction%' and FD_Interest.STATUS is  null and FD_Interest.To_Date =to_date('28/02/2019','dd/MM/yyyy'))a union select count(*), 214 as Branch_Code from(select to_date('date1','dd/MM/yyyy') as To_day1,FD_Master.Customer_Id,FD_Master.Customer_Name,FD_Interest.Account_No,Reference_Id,FD_Interest.Interest,Interest_Payment_Mode,Interest_Credit_Account,case when Interest_Payment_Mode='Standing Instruction' then IFSC_Code else NEFT_Bank.Bank_Name End as Bank_Name,case when Interest_Payment_Mode='Standing Instruction' then NEFT_Account_Number else NEFT_Branch End as NEFT_Branch,Deduct_TDS,Scheme_Master.GL_GENERAL,(Select MOBILE_NO from user14.customer where CUSTOMER_ID=Fd_Master.Customer_Id) as MobileNo from user14.FD_Interest join user14.FD_Master on FD_Interest.Account_No=FD_Master.Account_No left join dbuser2.NEFT_Bank on FD_Master.Bank_Code=NEFT_Bank.Bank_Code left join user14.Scheme_Master on Scheme_Master.SCHEME_CODE=FD_Master.IFSC_Code where FD_Master.Account_Status='A' and Interest_Payment_Mode like 'Standing Instruction%' and FD_Interest.STATUS is  null and FD_Interest.To_Date =to_date('28/02/2019','dd/MM/yyyy'))a) c left join Month_End_Log b on c.Branch_Code=b.Branch_Code order by c.Branch_Code",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
							{  

								SimpleBranch gl=new SimpleBranch();
							
								
								
								
								gl.setS2(rs.getString(1));  //ACCOUNT_NO
								gl.setS3(rs.getString(2));  //CURRENT_DATE
								gl.setS4(rs.getString(3));  //REMARKS
								gl.setS12(rs.getInt(5));
								
								System.out.println("aaaaaaaaaaaaaaaaa"+rs.getInt(5));
								
								
								
												
								return gl;
							}
							 }     );
						}
						
						
						
						//-------------------------------------------------Get Permission--------------------------------------------------------------------
						public String Get_Permission_Corp(String userName)
						{
							
							//--Set Connection----------------------------
							int j=Binfo;
							this.template=con.getCon2(j);
							//-----------------------------------------------------
							
			
							String i="No";
							String query = "Select User_Level from logindetails where username='"+userName+"'";
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
						
						
						public List<SimpleBranch> getUserDetailsList(){
							//--Set Connection----------------------------
									int j=201;
									this.template=con.getCon2(j);
									//-----------------------------------------------------
							return template.query("select USERNAME,PWD,USER_LEVEL,case when VALUE is null then 'B' else VALUE end as value1,MTYPE from LOGINDETAILS order by username",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
							{  

								SimpleBranch gl=new SimpleBranch();
								//gl.setS1(rs.getInt(12));
								gl.setS2(rs.getString(1));//userName
								
								gl.setS3(rs.getString(3));//getUserDetailsList
								gl.setS4(rs.getString(4));//Level
								//gl.setS5(rs.getString(4));//value
								
								
								if(rs.getString(4).equalsIgnoreCase("B"))
								{
									gl.setS4("Blocked");//userlevel
								}
								else
								{
									gl.setS4("Active");
								}
								
							  
								
								
								System.out.println("11111111111"+rs.getString(1));
								System.out.println("22222222222"+rs.getString(2));
								System.out.println("33333333333"+rs.getString(3));
								System.out.println("44444444444"+rs.getString(4));
								
								return gl;
							}
							 }     );
						}
						
						
						
						public int DeleteUserDetails_Corp(String username){  
							//--Set Connection----------------------------
									int j=201;
									this.template=con.getCon2(j);
									//-----------------------------------------------------
						    String sql1="Delete from LoginDetails where USERNAME='"+username+"'  AND USERNAME NOT IN ('200001','pisquare')"; 
						    String sql2="Delete from Permissiondetails where USERNAME='"+username+"' AND USERNAME NOT IN ('200001','pisquare')";
						    String sql3="Delete from CORP_PERMISSION where USER_NAME='"+username+"' AND USER_NAME NOT IN ('200001','pisquare')";

						    //CORP_PERMISSION
						    template.update(sql1);
						    template.update(sql2);
						    template.update(sql3);

						    return 1;  
						} 



						// Lock individual User

								public int Lock_Individual_User_Corp(String user_name)
								{  
									//--Set Connection----------------------------
									int j=Binfo;
									this.template=con.getCon2(j);
									//-----------------------------------------------------
									
									String sql="Update LoginDetails Set Value='B' Where Username not in ('200001','pisquare') and Username='"+user_name+"' ";
									 template.update(sql);
									
									return 1;
								}
							
								
						// Lock individual User
								
								public int UnLock_Individual_User_Corp(String user_name)
								{  
									//--Set Connection----------------------------
									int j=Binfo;
									this.template=con.getCon2(j);
									//-----------------------------------------------------
									
									String sql="Update LoginDetails Set Value='N' Where Username='"+user_name+"'";
									 template.update(sql);
									
									return 1;
								}
								
								
								// Reset Password individual User
								
								public int Resetpassword_Individual_User(String user_name)
								{  
									//--Set Connection----------------------------
									int j=Binfo;
									this.template=con.getCon2(j);
									//-----------------------------------------------------
									
									String sql="Update LoginDetails Set PWD='RuN4fvQVZU2JJSpQl9fUJg==' Where Username='"+user_name+"'";
									 template.update(sql);
									// 123456     cypher => b4WE4bXVBj0=
									//  asdfgh      cypher => jQk3UopmCqY=
									 //Empl2012			RuN4fvQVZU2JJSpQl9fUJg==
										 
									return 1;
								}
								
								
								
								// Fill Jewel Purity Files List
								
								public List<SimpleBranch> getJewel_PurityFiles_List(int Bcode,String Account_No) 
								{
									//--Set Connection------------------------------------
									int j=Binfo;
									this.template=con.getCon2(j);
									//-----------------------------------------------------
									return template.query("Select File_Name from Jl_Purity_Check_files where Account_No='"+Account_No+"' and Bcode="+Bcode+"",new RowMapper<SimpleBranch>(){  public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
									{  
										SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
										
										SimpleBranch jm=new SimpleBranch();
										
										jm.setS31(rs.getString(1));
																				
										return jm;
									}
								});
								}
								
								
								
		//Staff Controller ----------------------------------------------------------------------------------------------
								
								public List<SimpleBranch> getStaffDetailsList(){
									//--Set Connection----------------------------
											int j=201;
											this.template=con.getCon2(j);
											//-----------------------------------------------------
									return template.query("select * from employee order by empid",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
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
								
								public int getEmpId_Count(String Emp_Id) {
									//--Set Connection------------------------------------
									int j=Binfo;
									this.template=con.getCon2(j);
									//-----------------------------------------------------
									int i=0;
									String query = "select Count(*) from Employee where upper(EMPID)='"+Emp_Id.toUpperCase()+"'";
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
								
								
								
								public int saveStaff_Master(Staff_Master p){  
									//--Set Connection------------------------------------
									int j=Binfo;
									this.template=con.getCon2(j);
							//-----------------------------------------------------
									//String Customer_Name=p.getCustomer_Name();
									//Customer_Name=WordUtils.capitalizeFully(Customer_Name,'.');
									 String sql="insert into Employee values('"+p.getEmpId().toUpperCase()+"','"+p.getEmpName().toUpperCase()+"','"+p.getEmpMobile()+"','201','"+p.getEmpLevel()+"','A','"+p.getEmpDesignation()+"')";
								    
									  System.out.println("in Dao Saved Status= "+sql);
									  int k=template.update(sql);
								  System.out.println("in Dao Saved Status= "+k);
								    return k;  
								} 	
								
								public int updateStaff_Master(Staff_Master p){  
									//--Set Connection------------------------------------
									int j=Binfo;
									this.template=con.getCon2(j);
							//-----------------------------------------------------
								    String sql="update Employee set EMPNAME='"+p.getEmpName().toUpperCase()+"', MOBILE='"+p.getEmpMobile()+"',LEVEL1='"+p.getEmpLevel()+"',STATUS='"+p.getEmpStatus()+"',DESIGNATION='"+p.getEmpDesignation()+"' where EMPID='"+p.getEmpId()+"'";  
								    return template.update(sql);  
								} 
								
								public int deleteStaff_Master(String EMPID){  
									//--Set Connection------------------------------------
									int j=Binfo;
									this.template=con.getCon2(j);
							//------------------------------------------------------
								    String sql="delete from Employee where EMPID='"+EMPID+"' and Status !='A'";  
									
								  
								    return template.update(sql);  
								}  
								
		//End  Staff Controller ----------------------------------------------------------------------------------------------
								
								
								
								 public List<SimpleBranch> getAccount_Details_RL(String Account_No1,int Bcode){
 									System.out.println("Account no="+Account_No1);
 									int j=Bcode;
 									this.template=con.getCon2(j);
 									
 										return template.query(" Select Scheme_Name,Scheme_Category,RL_Master.Customer_Id,RL_Master.Customer_Name,'' as Customer_Name_2,Customer.Address, City, Pincode, to_char(Open_Date,'dd/MM/yyyy') as Open_Date, to_char(Period_Days ||' Days') as Period, to_char(Interest_Rate || ' %') as Interest_Rate,'' as Share_Detail,Loan_Amount as Amount, Closing_Balance,'NA' as Int_Payment_Freq,to_char(Due_Date,'dd/MM/yyyy') as Due_Date,'' as Maturity_Amount ,RL_Master.Nominee_Name,(select Security_Details from(Select Security_Details from COLLATERAL_CERTIFICATE_RL_LOAN where Account_No='"+Account_No1+"') where rownum=1),RL_Master.LOAN_TYPE from RL_Master left join Customer on RL_Master.Customer_Id=Customer.Customer_Id left join Scheme_Master on RL_Master.Scheme_Code=Scheme_Master.Scheme_Code where Account_No='"+Account_No1+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
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
 									//gl.setS111(rs.getString(20));  //Loan_Type
 									
 									
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
 								
							//28-02-2020------------------------------
								// select k.Branch_Code,k.Branch_Name,k.Current1,Case when k.transaction_date is null then k.Current1 else k.transaction_date end as TransactionDay ,Case when k.Cash_approval is null then 'NO' else k.Cash_approval end as CA_Status from ( select b.*,a.Transaction_date,a.Cash_approval from (select Branch_code,Branch_Name,to_date('27/02/2020','dd/MM/yyyy') as Current1 from dbuser1.Branch_Master)b left join (select Branch_code,Transaction_date,Status as Cash_approval from DAYCASHVIEW where TRANSACTION_DATE=to_date('27/02/2020','dd/MM/yyyy'))a on b.Branch_code=a.Branch_code)k order by k.Branch_Code;
								 
								 
									public List<SimpleBranch> getDay_ApprovalDetails(String date1){
										//--Set Connection----------------------------
												int j=Binfo;
												this.template=con.getCon2(j);
												//-----------------------------------------------------
										//select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' ) a order by Status,Branch;
												//new select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' union select '218' as Branch,'Thillai Nagar' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser18.calendar1 where Status='O' ) a order by Status,Branch
												//New with thanjavur  select a.* from (select '201' as Branch,'MainBranch' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser1.calendar1 where Status='O' union select '202' as Branch,'Vijayapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser2.calendar1 where Status='O' union select '203' as Branch,'Senthamangalam' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser3.calendar1 where Status='O' union select '204' as Branch,'Nagai Bye Pass' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser4.calendar1 where Status='O' union select '205' as Branch,'Thippirajapuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser5.calendar1 where Status='O' union select '206' as Branch,'Jl Hub' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser6.calendar1 where Status='O' union select '207' as Branch,'Kanchipuram' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser7.calendar1 where Status='O' union select '208' as Branch,'Nachiyar Kovil' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser8.calendar1 where Status='O' union select '209' as Branch,'Salem' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser9.calendar1 where Status='O' union select '210' as Branch,'Madippakkam' as Bname,to_char(Calendar_date,'dd/MM/yyyy') ,Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser10.calendar1 where Status='O' union select '211' as Branch,'Kumbakonam 2' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser11.calendar1 where Status='O' union select '212' as Branch,'Sakkotai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser12.calendar1 where Status='O' union select '213' as Branch,'Mayiladuthurai' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser13.calendar1 where Status='O' union select '214' as Branch,'Erode' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from user14.calendar1 where Status='O' union select '215' as Branch,'Kamakshi Josier St' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser15.calendar1 where Status='O' union select '216' as Branch,'Thirukadaiyur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser16.calendar1 where Status='O' union select '217' as Branch,'Thiruthuraipoondi' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser17.calendar1 where Status='O' union select '218' as Branch,'Thillai Nagar' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser18.calendar1 where Status='O' union select '219' as Branch,'Thanjavur' as Bname,to_char(Calendar_date,'dd/MM/yyyy'),Calendar_date,case when Calendar_date>to_date('"+date1+"','dd/MM/yyyy') then 1 else 0 end as Status from dbuser19.calendar1 where Status='O' ) a order by Status,Branch
										
												String sql="select k.Branch_Code,k.Branch_Name,to_char(k.Current1,'dd/MM/yyyy'),Case when k.transaction_date is null then k.Current1 else k.transaction_date end as TransactionDay ,Case when k.Cash_approval is null then 'No' else k.Cash_approval end as CA_Status from ( select b.*,a.Transaction_date,a.Cash_approval from (select Branch_code,Branch_Name,to_date('"+date1+"','dd/MM/yyyy') as Current1 from dbuser1.Branch_Master)b left join (select Branch_code,Transaction_date,Status as Cash_approval from DAYCASHVIEW where TRANSACTION_DATE=to_date('"+date1+"','dd/MM/yyyy'))a on b.Branch_code=a.Branch_code)k order by k.Branch_Code";
												return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
										{  

											SimpleBranch gl=new SimpleBranch();
										
											
											
											
											gl.setS2(rs.getString(2));  //Bname
											gl.setS3(rs.getString(3));  //Current1
											gl.setS4(rs.getString(5));  //Status
											
											gl.setS31(rs.getString(5));
								
											return gl;
										}
										 }     );
									}
									
									
									
									public int UpdateJL_Details_Mgr(String Account_No,int Bcode){  

										//--Set Connection------------------------------------
													int j=Bcode;
													this.template=con.getCon2(j);
										//-----------------------------------------------------
									    String sql="update JL_Master set COOP_STATUS='CorpPending' where Account_No='"+Account_No+"'";  
									    return template.update(sql);  
									}
									
									public int UpdateJL_Details_Corp(String Account_No,int Bcode){  

										//--Set Connection------------------------------------
													int j=Bcode;
													this.template=con.getCon2(j);
										//-----------------------------------------------------
									    String sql="update JL_Master set COOP_STATUS='Pending' where Account_No='"+Account_No+"'";  
									    return template.update(sql);  
									}
									
									public int Update_Jl_approval_Corp(String Account_No,String Mgr_App_By,String Mgr_AppDate,int Bcode){  


										//--Set Connection------------------------------------
													int j=201;
													this.template=con.getCon2(j);
										//-----------------------------------------------------
													 System.out.println("----------------------Dao Loan Approval updation mgr");
													   
									    String sql="update Jl_Approval_status set CORP_APPROVED_BY='"+Mgr_App_By+"',MODIFIED_DATE=to_date('"+Mgr_AppDate+"','dd/MM/yyyy') where Account_No='"+Account_No+"'";  
									    return template.update(sql);
									}

									
									public int Update_Jl_approval_Final(String Account_No,String Mgr_App_By,String Mgr_AppDate,int Bcode){  


										//--Set Connection------------------------------------
													int j=201;
													this.template=con.getCon2(j);
										//-----------------------------------------------------
													 System.out.println("----------------------Dao Loan Approval updation mgr");
													   
									    String sql="update Jl_Approval_status set FINAL_APPROVED_BY='"+Mgr_App_By+"',FINAL_APPROVED_Date=to_date('"+Mgr_AppDate+"','dd/MM/yyyy') where Account_No='"+Account_No+"'";  
									    return template.update(sql);
									}
									
									
									
									public List<SimpleBranch> getApproval_details(String Account_No){
										//--Set Connection------------------------------------
										int j=201;
										this.template=con.getCon2(j);
										//-----------------------------------------------------
										return template.query("Select CREATED_BY,MODIFIED_BY,CORP_APPROVED_BY,FINAL_APPROVED_BY,Modified_date from JL_APPROVAL_STATUS where Account_no='"+Account_No+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
										{  

											SimpleBranch gl=new SimpleBranch();
										
											gl.setS31(rs.getString(1));
											gl.setS32(rs.getString(2));
											gl.setS33(rs.getString(3));
											gl.setS34(rs.getString(4));
											gl.setS35(rs.getString(5));
											return gl;
										}
										 }     );
									}

									
									public String getUserStatus(String user) throws SQLException {
										//--Set Connection------------------------------------
										int j=201;
										this.template=con.getCon2(j);
										//-----------------------------------------------------
										Connection dbConnection = null;
										dbConnection = template.getDataSource().getConnection();
										String i=null;
										String query = "Select user_level  from logindetails where username='"+user+"'";

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
										finally {

											
												pstmt.close();
											

										
												dbConnection.close();
											

										}

											
										return i;
									} 

									
									
									public String getApprovalStatus(String Account_no) throws SQLException {
										//--Set Connection------------------------------------
										int j=201;
										this.template=con.getCon2(j);
										//-----------------------------------------------------
										Connection dbConnection = null;
										dbConnection = template.getDataSource().getConnection();
										String i=null;
										String query = "Select coop_status  from jl_mASTER_vIEW where ACCOUNT_NO='"+Account_no+"'";

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
										finally {

											
												pstmt.close();
											

										
												dbConnection.close();
											

										}

											
										return i;
									} 

						//09-06-2020			
									public List<SimpleBranch> getJewel_Details(int Bcode,String Account_No) 
									{
										//--Set Connection------------------------------------
										int j=Bcode;
										this.template=con.getCon2(j);
										//-----------------------------------------------------
										return template.query("Select DESCRIPTION,NO_OF_ITEMS,GROSS_WEIGHT,DEDUCTION,NET_WEIGHT,Id,Rate_Per_Gram,Stone,Eligible_Amt,Purity,Round(Eligible_Amt/Net_Weight) as Sanction_Gram,CASE WHEN SDEDUCTION IS NULL THEN 0 ELSE SDEDUCTION END as SDeduction  from Jewel_Details where Account_No='"+Account_No+"'",new RowMapper<SimpleBranch>(){  public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
										{  
											SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
											 DecimalFormat df = new DecimalFormat("0.00");
											 DecimalFormat df1 = new DecimalFormat("0.000");
											
											SimpleBranch jm=new SimpleBranch();
											
											jm.setS31(rs.getString(1));
											jm.setS41(rs.getInt(2));
											jm.setS51(rs.getFloat(3));
											jm.setS52(rs.getFloat(4));
											jm.setS53(rs.getFloat(5));
											jm.setS42(rs.getInt(6));
											jm.setS17(rs.getFloat(7));   // Rate per gram
											jm.setS10(rs.getString(8));  // stone
											jm.setS13(rs.getFloat(9));   //eligible amt
											jm.setS11(rs.getInt(10));    // purity
											jm.setS17(rs.getFloat(11));   // Rate per gram new
											
											jm.setS33(df.format(rs.getFloat(9)));  //eligible amt

											jm.setS131(df1.format(rs.getFloat(3))); // gross weight
											jm.setS132(df1.format(rs.getFloat(4)));  // deduction
											jm.setS133(df1.format(rs.getFloat(12)));   // stone
											jm.setS134(df1.format(rs.getFloat(5))); // net weight
											jm.setS135(df.format(rs.getFloat(11)));   // Rate per gram new
											jm.setS55(rs.getFloat(12));
											return jm;
										}
									});
									}
									
									
									
								
									 public int UpdateDATA(String sql,int BCode)
										{  
											//--Set Connection----------------------------
											int j=BCode;
											this.template=con.getCon2(j);
											//-----------------------------------------------------
											System.out.println("Update Data :"+sql);
											 template.update(sql);
											 
											return 1;
										}	
									 
									 
								
									 
									 //07-12-2022
									 public int Get_ScalarINT(String query,int Bcode) {
											//--Set Connection----------------------------
													int j=Bcode;
													this.template=con.getCon2(j);
													//-----------------------------------------------------
														int i=0;
														System.out.println(query);
												PreparedStatement pstmt = null;
											try {
												
												pstmt = template.getDataSource().getConnection().prepareStatement(query);
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
												i=0;
											}
											ResultSet resultSet = null;
											try {
												resultSet = pstmt.executeQuery();
												} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
												i=0;
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
												i=0;
											}
												
											return i;
										} 	 
									 

									 //30-12-2022
									 public float Get_ScalarFLOAT(String query,int Bcode) {
											//--Set Connection----------------------------
													int j=Bcode;
													this.template=con.getCon2(j);
													//-----------------------------------------------------
														float i=0;
														System.out.println(query);
												PreparedStatement pstmt = null;
											try {
												
												pstmt = template.getDataSource().getConnection().prepareStatement(query);
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
												i=0;
											}
											ResultSet resultSet = null;
											try {
												resultSet = pstmt.executeQuery();
												} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
												i=0;
											}
											
											try {
												if (resultSet!= null) {
													  while (resultSet.next()) {
														  i=resultSet.getFloat(1);
													  }
												}
												//i=resultSet.getRow();
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
												i=0;
											}
												
											return i;
										} 	

									 public List<SimpleBranch> get_APIList() {
											// --Set Connection----------------------------
											int j = 201;
											this.template = con.getCon2(j);
											// -----------------------------------------------------
											System.out.println("------API LIST-------");
											return template.query("select * from SMS_API where Status='A'",
													new RowMapper<SimpleBranch>() {
														public SimpleBranch mapRow(ResultSet rs, int row)
																throws SQLException {

															SimpleBranch gl = new SimpleBranch();
															gl.setS2(rs.getString("Prov_Name"));
															gl.setS3(rs.getString("Selected"));
															System.out.println(rs.getString("Prov_Name"));
															return gl;
														}
													});
										}

}
