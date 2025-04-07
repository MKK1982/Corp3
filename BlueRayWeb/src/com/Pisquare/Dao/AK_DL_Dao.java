package com.Pisquare.Dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;





import com.Pisquare.Beans.FD_Master;
import com.Pisquare.Beans.RD_Master;
import com.Pisquare.Beans.SBCA_Master;
import com.Pisquare.Beans.SimpleBranch;
import com.Pisquare.Controllers.Configuration_Controller;

public class AK_DL_Dao {
	
int Binfo=201;
	
	@Autowired
	private Configuration_Controller con;
JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template)
	{
		this.template=template;
		
	}
	
	

	
	//Get SchemeCode List
			
			//Deposit Loan
			   //Select [Scheme Name] as Name,[Scheme Code] from Scheme_Master where [Scheme Category]='DL'"
			public List<SimpleBranch> getSchemeCodeName_DL(int Bcode){
				//--Set Connection------------------------------------
				int j=Bcode;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				return template.query("select * from SCHEME_MASTER where SCHEME_CATEGORY='DL'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
				{  

					SimpleBranch gl=new SimpleBranch();
				
					gl.setS2(rs.getString(1));
					gl.setS3(rs.getString(2));
					gl.setS4(rs.getString(3));
					
									
					return gl;
				}
				 }     );
			}
					
			
			
		//Get GL_Code_Name DL	
			public List<SimpleBranch> getGLCodeName_DL(int Bcode){
				//--Set Connection------------------------------------
				int j=Bcode;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				return template.query("select * from GL_MASTER where GL_CODE in(select GL_CODE from TRANSACTION_GL_CODE where SCHEME_CODE In (select SCHEME_CODE from SCHEME_MASTER where SCHEME_CATEGORY='DL'))",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
				{  

					SimpleBranch gl=new SimpleBranch();
				    gl.setS1(rs.getInt(1));
					gl.setS2(rs.getString(2));
				return gl;
				}
				 }     );
			}
			
			
			
			//select Customer_Id as Customer_Id,Customer_Name,Account_No as Account_No,Account_Type from Cust_Acc_Link where Account_Status='A' and (Account_Type in ('FD','RD') or Scheme_Code='20011') and Account_No not in (Select Deposit_No from Lien_Accounts where Loan_Status='A') and (Cust_Acc_Link.ACCOUNT_NO) like '%" + searchVal + "%' or Customer_Name like '%" + searchVal + "%' ORDER BY Account_No desc;
			public List<SimpleBranch> getDep_AccountList(String searchVal,int Bcode){
				//--Set Connection------------------------------------
				int j=Bcode;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				return template.query("select Customer_Id as Customer_Id,Customer_Name,Account_No as Account_No,Account_Type from Cust_Acc_Link where Account_Status='A' and (Account_Type in ('FD','RD')) and Account_No not in (Select Deposit_No from Lien_Accounts where Loan_Status='A') and (Cust_Acc_Link.ACCOUNT_NO) like '%" + searchVal + "%' ORDER BY Account_No desc",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
				{  

					SimpleBranch gl=new SimpleBranch();
				    gl.setS1(rs.getInt(1)); //Customer_Id
					gl.setS2(rs.getString(2)); //Customer_Name
					gl.setS3(rs.getString(3)); //Account_No
					gl.setS4(rs.getString(4)); //Account_Type
				return gl;
				}
				 }     );
			}
			//select Customer_Id as Customer_Id,Customer_Name,Account_No as Account_No,Account_Type from Cust_Acc_Link where Account_Status='A' and (Account_Type in ('FD','RD') or Scheme_Code='20011') and Account_No not in (Select Deposit_No from Lien_Accounts where Loan_Status='A') and (Cust_Acc_Link.ACCOUNT_NO) like '%" + searchVal + "%' or Customer_Name like '%" + searchVal + "%' ORDER BY Account_No desc;
			public List<SimpleBranch> getDep_AccountList(int Bcode){
				//--Set Connection------------------------------------
				int j=Bcode;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				return template.query("select Customer_Id as Customer_Id,Customer_Name,Account_No as Account_No,Account_Type from Cust_Acc_Link where Account_Status='A' and (Account_Type in ('FD','RD')) and Account_No not in (Select Deposit_No from Lien_Accounts where Loan_Status='A') ORDER BY Account_No desc",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
				{  

					SimpleBranch gl=new SimpleBranch();
				    gl.setS1(rs.getInt(1)); //Customer_Id
					gl.setS2(rs.getString(2)); //Customer_Name
					gl.setS3(rs.getString(3)); //Account_No
					gl.setS4(rs.getString(4)); //Account_Type
					
				return gl;
				}
				 }     );
			}

			//select * from(select Cust_Acc_Link.Customer_Id as Customer_Id,Cust_Acc_Link.Customer_Name,Cust_Acc_Link.Account_No as Account_No,Cust_Acc_Link.Account_Type from(SELECT * FROM(select (DAILY_TRANSACTION.account_no)AS Acc_No,count(*)AS NO_OF_TRANS from sbca_master,DAILY_TRANSACTION where sbca_master.account_status='A' AND sbca_master.scheme_code='20011' and daily_transaction.TRANSACTION_TYPE !='Debit' and sbca_master.Account_No not in (Select Deposit_No from Lien_Accounts where Loan_Status='A') and DAILY_TRANSACTION.account_no=sbca_master.account_no group by DAILY_TRANSACTION.account_no) where  NO_OF_TRANS>=50) a,Cust_Acc_Link where a.Acc_no=Cust_Acc_Link.account_no)b where (b.ACCOUNT_NO) like '%%' order by b.ACCOUNT_NO desc 
			 
			public List<SimpleBranch> getDep_AccountList_DSS(String searchVal,String Current,int Bcode){
				//--Set Connection------------------------------------
				int j=Bcode;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				//old "select * from(select customer_id,customer_name,Account_no,'SD' from SBCA_Master where Scheme_Code='20011' and account_status='A' and (open_date+101)>=to_date('"+Current+"','dd/MM/yyyy')and Account_No not in (Select Deposit_No from Lien_Accounts where Loan_Status='A'))b where (b.ACCOUNT_NO) like '%"+searchVal+"%' order by b.ACCOUNT_NO desc"
				
				//New 
				String sql="select b.* from (select a.*,(Select count(*) from daily_transaction where Transaction_type='Credit' and Account_No=a.Account_No) as c1 from (select customer_id,customer_name,Account_no,'SD' from SBCA_Master where Scheme_Code in ('20011') and account_status='A' and Account_No not in (Select Deposit_No from Lien_Accounts where Loan_Status='A')and ACCOUNT_NO like '%"+searchVal+"%' order by account_no desc)a )b  union select b.* from (select a.*,(Select count(*) from daily_transaction where Transaction_type='Credit' and Account_No=a.Account_No) as c1 from (select customer_id,customer_name,Account_no,'SD' from SBCA_Master where Scheme_Code in ('20014') and account_status='A' and Account_No not in (Select Deposit_No from Lien_Accounts where Loan_Status='A')and ACCOUNT_NO like '%"+searchVal+"%' order by account_no desc)a )b where  b.c1>99";
				return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
				{  

					SimpleBranch gl=new SimpleBranch();
				    gl.setS1(rs.getInt(1)); //Customer_Id
					gl.setS2(rs.getString(2)); //Customer_Name
					gl.setS3(rs.getString(3)); //Account_No
					gl.setS4(rs.getString(4)); //Account_Type
					System.out.println("db-Customer_Id="+rs.getInt(1));
				return gl;
				}
				 }     );
			}
			
			
			//--Save Lien Account------------------------------------------------------------------------------------------------------------------------------------------
			
			public void Save_Lien_Accounts(String Loan_No1,String Deposit_No1,String Loan_Status1,String Deposit_Status1,String Deposit_Type1,int Bcode) throws SQLException
			{

				
				//--Set Connection------------------------------------
				int j=Bcode;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				
				
				try{
					CallableStatement stmt=template.getDataSource().getConnection().prepareCall("{call Save_Lien_Accounts(?,?,?,?,?)}");
					
					stmt.setString(1,Loan_No1);  
					stmt.setString(2,Deposit_No1);
					stmt.setString(3,Loan_Status1);  
					stmt.setString(4,Deposit_Status1);
					stmt.setString(5,Deposit_Type1);  
					
					
					
					
					//register the OUT parameter before calling the stored procedure
						//stmt.registerOutParameter(3, java.sql.Types.INTEGER);
					stmt.executeQuery();
					//read the OUT parameter now
						
					
					
				}catch(Exception e)
				 	 {
					System.out.println(e);
				 	 }
				
				
			}
			
			//Update_Lien_Accounts
			
			public void Update_Lien_Accounts(String Loan_No1,int Bcode) throws SQLException
			{
				//--Set Connection------------------------------------
				int j=Bcode;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				
				
				
				
				try{
					CallableStatement stmt=template.getDataSource().getConnection().prepareCall("{call Update_Lien_Accounts(?)}");
					
					stmt.setString(1,Loan_No1);  
										
					
					
					//register the OUT parameter before calling the stored procedure
						//stmt.registerOutParameter(3, java.sql.Types.INTEGER);
					stmt.executeQuery();
					//read the OUT parameter now
						
					
					
				}catch(Exception e)
				 	 {
					System.out.println(e);
				 	 }
				
				
			}
			

	//-----------------------------------------------------------------------------------------------------------------------------------------
			
			 public List<SimpleBranch> getDL_List(int Bcode){
				 
				//--Set Connection------------------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
					//-----------------------------------------------------
					return template.query("select Customer_Id,Customer_Name,Account_No,To_Char(Open_Date,'dd/MM/yyyy'),Loan_Amount,Period_Days,Interest_Rate,Account_Status from OL_Master where Scheme_Code in (Select Scheme_Code from Scheme_Master where Scheme_Category='DL') ORDER BY OPEN_DATE desc,Account_No desc",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
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
						
					return gl;
					}
					 }     );
				}

			 
			 
			 
			 
			 
			 public List<SimpleBranch> getDL_Info(long Account_No,int Bcode){
				//--Set Connection------------------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
					//-----------------------------------------------------
					return template.query("select * from OL_Master where Account_No="+Account_No+"",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
					{  
							SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
						SimpleBranch gl=new SimpleBranch();
					   
						gl.setS2(rs.getString(6)); //SCHEME_CODE
						gl.setS1(rs.getInt(10)); //PERIOD_DAYS
						
						gl.setS11(rs.getInt(30));//TRANSACTION_ID
						gl.setS3(sd.format(rs.getDate(31)));//TRANSACTION_DATE
						gl.setS4(sd.format(rs.getDate(11)));//due_DATE
						
					return gl;
					}
					 }     );
				}
			 
				
				//------------------------------------------------FD Account List---SEARCH----------------------------------------------------------------------------------------------------	
				public List<SimpleBranch>getAccountListSearch_DL(String searchKey,int Bcode)
				{
					//--Set Connection------------------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
					//-----------------------------------------------------

				
					return template.query("select Customer_Id,Customer_Name,Account_No,To_Char(Open_Date,'dd/MM/yyyy'),Loan_Amount,Period_Days,Interest_Rate,Account_Status from OL_Master where Scheme_Code in (Select Scheme_Code from Scheme_Master where Scheme_Category='DL') and (ACCOUNT_NO LIKE '%"+searchKey+"%' or CUSTOMER_ID LIKE '%"+searchKey+"%' or upper(CUSTOMER_NAME) like '%"+searchKey.toUpperCase()+"%') order by Account_No desc",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
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
						
					return gl;
																							}
				 																		 }     );
	 }
				
				
				
				 
				 public List<SimpleBranch> getDepAcc_Type(long Account_No,int Bcode){
					//--Set Connection------------------------------------
						int j=Bcode;
						this.template=con.getCon2(j);
						//-----------------------------------------------------
						return template.query("select DEPOSIT_NO,DEPOSIT_TYPE from Lien_Accounts where Loan_No="+Account_No+"",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
						{  
								SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
							SimpleBranch gl=new SimpleBranch();
						   
							//old gl.setS1(rs.getInt(1)); //DEPOSIT_NO
							
							//new
							gl.setS7(rs.getLong(1)); //DEPOSIT_NO
							
							gl.setS2(rs.getString(2)); //DEPOSIT_TYPE
									return gl;
						}
						 }     );
					}
				 
				 
				 
				 
					
					public List<SBCA_Master> getSBCA_MasterDetails_DepLoan(String cid,int Bcode){
						//--Set Connection----------------------------
						int j=Bcode;
						this.template=con.getCon2(j);
			//-----------------------------------------------------
						return template.query("select * from SBCA_Master where ACCOUNT_NO='"+cid+"'",new RowMapper<SBCA_Master>(){   public SBCA_Master mapRow(ResultSet rs, int row) throws SQLException
{  
							
							 
								SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
								
								
								
							SBCA_Master gl=new SBCA_Master();
						gl.setAccount_No(rs.getString(2));
						gl.setOpen_Date1(sd.format(rs.getDate(5)));//date
						gl.setCustomer_Id(rs.getInt(3));
						gl.setCustomer_Name(rs.getString(4));;
						gl.setScheme_Code(rs.getString(6));//string
						gl.setNominee_Name(rs.getString(8));
						gl.setMode_Of_Operation(rs.getString(7));
						gl.setAccount_Status(rs.getString(15));
						gl.setTransaction_Id(rs.getInt(31));
						
						gl.setCustomer_Id_2(rs.getInt(27));
						gl.setCustomer_Name_2(rs.getString(28));
						gl.setNominee_Age(rs.getString(10));
						gl.setNominee_Relationship(rs.getString(9));
						gl.setNominee_DOB(rs.getString(24));
						gl.setCustomer_Id_2(rs.getInt(27));
						gl.setCustomer_Name_2(rs.getString(28));
						gl.setClosing_Balance(rs.getFloat(12));
						
												//gl.setShare_Type(Share_Type);
						
						//gl.setTransaction_Date(Transaction_Date);
						//gl.setTransaction_Amount(Transaction_Amount);
						//gl.setMode_Of_Receipt(Mode_Of_Receipt);
						//gl.setGL_Info(GL_Info);
						//gl.setTransfer_Acc_No(Transfer_Acc_No);
						//gl.setTransfer_Acc_Name(Transfer_Acc_Name);
						//gl.setTransaction_Particulars(Transaction_Particulars);
						
							
											
							return gl;
						}
						 }     );
					}
			
					
					//-----------------------------------------------------------------------------------------------------------------------------------------
					 public int InsertTemp_DepLoan_Details(String Account_No,String DepAccount_No,String Effect_Date,int Customer_Id,String Customer_Name,float Deposit_Amt,float Interest_Rate,float Maturity_Amt,String MATURITY_DATE,float SANCTION_AMOUNT,String Account_Type,int Bcode)
					{
						//--Set Connection------------------------------------
							int j=Bcode;
							this.template=con.getCon2(j);
							//-----------------------------------------------------
						
						String sql="insert into TEMP_DEPLOAN_DETAILS(ACCOUNT_NO,DEPACCOUNT_NO,EFFECT_DATE,CUSTOMER_ID,CUSTOMERNAME,DEPOSIT_AMOUNT,INTEREST_RATE,MATURITY_AMOUNT,MATURITY_DATE,SANCTION_AMOUNT,Account_Type)values('"+Account_No+"','"+DepAccount_No+"',to_date('"+Effect_Date+"','dd/MM/yyyy'),"+Customer_Id+",'"+Customer_Name+"',"+Deposit_Amt+","+Interest_Rate+","+Maturity_Amt+",to_date('"+MATURITY_DATE+"','dd/MM/yyyy'),"+SANCTION_AMOUNT+",'"+Account_Type+"')";
																															
		                try
		                                {
						template.update(sql);
		                }
		                catch(Exception e)
		                {
		                	System.out.println(e);
		                }
						
						
						
						return 1;
					}
					 
					 
					 
					 public List<SimpleBranch> getDepAcc_DetailsTemp(String Account_No,int Bcode){
							//--Set Connection------------------------------------
								int j=Bcode;
								this.template=con.getCon2(j);
								//-----------------------------------------------------
								return template.query("select ACCOUNT_NO,DEPACCOUNT_NO,to_char(EFFECT_DATE,'dd/MM/yyyy'),CUSTOMER_ID,CUSTOMERNAME,DEPOSIT_AMOUNT,INTEREST_RATE,MATURITY_AMOUNT,to_char(MATURITY_DATE,'dd/MM/yyyy'),SANCTION_AMOUNT,Account_Type from TEMP_DEPLOAN_DETAILS where Account_No="+Account_No+"",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
								{  
									//String s31,String s32,String s33,int s1,String s34,int s41,float s51,float s52,String s35,int s42,String s36
										SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									SimpleBranch gl=new SimpleBranch();
								   gl.setS31(rs.getString(1));//ACCOUNT_NO
								   gl.setS32(rs.getString(2));//DEPACCOUNT_NO
								   gl.setS33(rs.getString(3));//effect date
								   gl.setS1(rs.getInt(4));//customer id
								   gl.setS34(rs.getString(5));//Customer name
								   gl.setS41(rs.getInt(6));//Deposit Amt
								   gl.setS51(rs.getFloat(7));//Interest Rate
								   gl.setS52(rs.getFloat(8));//Maturity Amt
								   gl.setS35(rs.getString(9));//Maturity Date
								   
								   gl.setS42(rs.getInt(10));//SanctionAmt
								   
								   gl.setS36(rs.getString(11));//Account_Type
								   
									
											return gl;
								}
								 }     );
							}
					
					 public List<SimpleBranch> getMaturityDate_Int(String Account_No,int Bcode){
							//--Set Connection------------------------------------
								int j=Bcode;
								this.template=con.getCon2(j);
								//-----------------------------------------------------
								return template.query("select to_char(Min(MATURITY_DATE),'dd/MM/yyyy'),Max(INTEREST_RATE),sum(SANCTION_AMOUNT) from( select ACCOUNT_NO,DEPACCOUNT_NO,to_char(EFFECT_DATE,'dd/MM/yyyy'),CUSTOMER_ID,CUSTOMERNAME,DEPOSIT_AMOUNT,to_char(INTEREST_RATE,'99.99'),to_char(MATURITY_AMOUNT,'9,999.99'),MATURITY_DATE,SANCTION_AMOUNT,INTEREST_RATE from TEMP_DEPLOAN_DETAILS where Account_No='"+Account_No+"')b",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
								{  
										SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
									SimpleBranch gl=new SimpleBranch();
								   gl.setS31(rs.getString(1));//MATURITY_DATE
								   gl.setS13(rs.getFloat(2));//INTEREST_RATE
								   gl.setS1(rs.getInt(3));//Saction Amt;
								  
									
											return gl;
								}
								 }     );
							}
					 
					// Delete_TempDepLoan_Details
						public int Delete_TempDepLoan_Details(String Account_No,String DepAccount_No,int Bcode) {
							// --Set Connection----------------------------
							int j = Bcode;
							this.template = con.getCon2(j);
							// -----------------------------------------------------

							int i = 0;
							String query = "Delete from TEMP_DEPLOAN_DETAILS where Account_No='"+ Account_No + "' and DEPACCOUNT_NO='" + DepAccount_No + "'";
							PreparedStatement pstmt = null;
							try {
								pstmt = template.getDataSource().getConnection()
										.prepareStatement(query);
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

							
							return 1;
						}
						
						// Delete_All_TempDepLoan_Details
						public int Delete_All_TempDepLoan_Details(int Bcode) {
							// --Set Connection----------------------------
							int j = Bcode;
							this.template = con.getCon2(j);
							// -----------------------------------------------------

							int i = 0;
							String query = "Delete from TEMP_DEPLOAN_DETAILS";
							PreparedStatement pstmt = null;
							try {
								pstmt = template.getDataSource().getConnection()
										.prepareStatement(query);
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

							
							return 1;
						}
						
						
						
						
						
						public String Get_Account_No_FD2(String Account_No,int Bcode) {
							//--Set Connection----------------------------
									int j=Bcode;
									this.template=con.getCon2(j);
									//-----------------------------------------------------
										String i="";
							String query = "select case when to_char(to_number(substr('"+Account_No+"',11))) is null then to_char(to_number(substr('"+Account_No+"',1,10)) || '1') else to_char(to_number('"+Account_No+"')+1 ) end as Acc_no from dual";

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
						
						
										
						
						
						
						
						
						

						//-----------------------------------------------------------------------------------------------------------------------------------------
						 public int Update_Dl_Master(String Account_No,double Int_Rate,double pen_int,String NOMINEE_NAME,String NOMINEE_RELATIONSHIP,String NOMINEE_AGE,int Bcode)
						{
							//--Set Connection------------------------------------
								int j=Bcode;
								this.template=con.getCon2(j);
								//-----------------------------------------------------
							
							String sql="update ol_master set INTEREST_RATE="+Int_Rate+",PENAL_RATE="+pen_int+",NOMINEE_NAME='"+NOMINEE_NAME+"',NOMINEE_RELATIONSHIP='"+NOMINEE_RELATIONSHIP+"',NOMINEE_AGE='"+NOMINEE_AGE+"' where to_char(Account_no)='"+Account_No+"'";
																																
			                try
			                                {
							template.update(sql);
			                }
			                catch(Exception e)
			                {
			                	System.out.println(e);
			                }
							
							
							
							return 1;
						}
						 		
						
						 public List<SimpleBranch> getTransDetails_DL(int Trans_Id,String TransDate,int Partid,int Bcode){
								//--Set Connection------------------------------------
								int j=Bcode;
								this.template=con.getCon2(j);
								//-----------------------------------------------------
								return template.query("select * from Daily_Transaction where Transaction_id="+Trans_Id+" and Transaction_date=to_date('"+TransDate+"','dd/MM/yyyy') and PART_TRAN_ID="+Partid+"",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
								{  

									SimpleBranch gl=new SimpleBranch();
								   
									gl.setS2(rs.getString(3)); //Account_No 
									gl.setS3(rs.getString(6)); //Transaction_Details
								
									
								return gl;
								}
								 }     );
							}
							
						
						
						
						
						//Delete DL Account
							

							public int deleteDL_Account(String account_No,int Bcode) {

								//--Set Connection------------------------------------
											int j=Bcode;
											this.template=con.getCon2(j);
								//-----------------------------------------------------
								 String sql="delete from OL_Master where to_char(Account_No)='"+account_No+"'";  
								 String sql2="delete from CUST_ACC_LINK where Account_No="+account_No+"";
								 
								 String sql3="delete from Lien_Accounts where LOAN_NO='"+account_No+"'";
								 template.update(sql);
								 template.update(sql2);
								    return template.update(sql3);  
							}
							//Get Interest Rate	
							//"Select top 1 [Interest Rate],[Penal Rate] from Interest_Rate_Master where [Effect Date]<='" + DateTime.Parse(txt_Acc_Open_Date.Text).ToString("yyyy/MM/dd") + "' and [Scheme Code]='" + ddl_Scheme.SelectedItem.Value + "' order by [Effect Date] desc")
						//----------------------------------------------Get Interest Rate --------------------------------------------------------------------------------
						
								public List<SimpleBranch> getInterestRate(String scode,String effectDate,int Bcode){
									//--Set Connection------------------------------------
									int j=Bcode;
									this.template=con.getCon2(j);
									//-----------------------------------------------------
									return template.query("select a.* from (select * from INTEREST_RATE_MASTER where SCHEME_CODE='"+scode+"' and effect_date<=to_date('"+effectDate+"','dd/MM/yyyy') order by effect_date desc)a where rownum=1" ,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
									{  

										SimpleBranch gl=new SimpleBranch();
										gl.setS13(rs.getFloat(3));		//INTEREST_RATE
										
										
										gl.setS14(rs.getFloat(4));  //Penal_Rate
										
										
										return gl;
									}
									 }     );
								}
								
								
								
								//----------------------------------------------------------FD master Individual Details-----------------------------------------------------------------------------
								
								public List<FD_Master> getFD_MasterDetailsIndividuals(String Accno,int Bcode){

									//--Set Connection------------------------------------
												int j=Bcode;
												this.template=con.getCon2(j);

									//-----------------------------------------------------
									return template.query("select * from FD_Master where Account_No='"+Accno+"'",new RowMapper<FD_Master>(){   public FD_Master mapRow(ResultSet rs, int row) throws SQLException
									{  
					                    SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
					                    boolean tds = false;
					                    boolean senior = false;
					                    boolean Super_Senior = false;
					                    String period = null;
					                    
										FD_Master fm=new FD_Master();
										fm.setAccount_No(rs.getString(2));
										fm.setEffect_Date(sd.format(rs.getDate(8)));
										fm.setCustomer_Id1(rs.getInt(3));
										fm.setCustomer_Name1(rs.getString(4));
										
										fm.setCustomer_Id2(rs.getInt(5));
										fm.setCustomer_Name2(rs.getString(6));
										
										fm.setDeposit_Amount(rs.getInt(12));
										System.out.println("setCustomer_Id2="+rs.getInt(5));
										System.out.println("Customer_Name2="+rs.getString(6));
										String s1=null;
										String s2=null;
										String Super_Sr=null;
										
										s1=rs.getString(50);//tds
										s2=rs.getString(48);//sr_Ctz
										Super_Sr=rs.getString(55);//SUPER_SENIOR_CITIZEN
										
										if(s1==null)
										{
											s1="No";
										}
										if(s2==null)
										{
											s2="No";
										}
										if(Super_Sr==null)
										{
											Super_Sr="No";
										}
										
									
										
										
										if(!s1.isEmpty() && s1!=null)
										if(s1.equalsIgnoreCase("Y"))
										{
											tds=true;
										}
										else
										{
											tds=false;
										}
										
										fm.setTDS(tds);
									fm.setChk_TDS(tds);
										
										if(!s2.isEmpty() && s1!=null)
										if(s2.equalsIgnoreCase("Yes"))
										if(s2.equalsIgnoreCase("Yes"))
										{
											senior=true;
										}
										else
										{
											senior=false;
										}
										
										fm.setSenior(senior);
									
										
										if(!Super_Sr.isEmpty() && Super_Sr!=null)
											if(Super_Sr.equalsIgnoreCase("Yes"))
										if(Super_Sr.equalsIgnoreCase("Yes"))
										{
											Super_Senior=true;
										}
										else
										{
											Super_Senior=false;
										}
										
										fm.setSuper_Sr_Ctzn(Super_Senior);
										fm.setSuper_Senior(Super_Sr);
										
										int months=rs.getInt(13);
										int days=rs.getInt(14);
										if(months==0 && days!=0)
										{
											
												period=days+"D";
										
										}
										else
										{
											
												period=months+"M";
											
										}
									
										fm.setPeriod(period);
										fm.setInterest_Rate(rs.getFloat(11));
										fm.setMaturity_Date(sd.format(rs.getDate(17)));
										fm.setMaturity_Amount(rs.getFloat(18));
										fm.setInt_Interest_Repayment(rs.getString(15));
										fm.setInt_Paid(rs.getInt(37));
										fm.setAccount_Status(rs.getString(25));
										fm.setScheme_Code(rs.getString(9));
										fm.setLien_Acc_no(rs.getString(20));
										
										fm.setOpen_Date(sd.format(rs.getDate(7)));
										fm.setMOP(rs.getString(10));
										fm.setInt_Interest_Repayment(rs.getString(15));
										fm.setCompounding(rs.getString(16));
										//23 38
										fm.setNominee_Name(rs.getString(21));
										fm.setNominee_Relationship(rs.getString(22));
										fm.setNominee_Age(rs.getString(23));
										fm.setNominee_DOB(rs.getString(38));
										fm.setInt_Payment_Mode(rs.getString(34));
										fm.setInt_Proj(rs.getFloat(40));
										fm.setStanding_Scheme(rs.getString(42));
										fm.setStanding_Acc_No(rs.getString(43));
										fm.setReferred_By(rs.getInt(39));
									
										
										fm.setBranch(rs.getString(45));
										fm.setIFSC_Code(rs.getString(42));		
										fm.setNEFT_Acc_No(rs.getString(43));
										fm.setBank_Name(rs.getString(44));
										
										
										fm.setTransaction_Id(rs.getInt(32));
										fm.setTransaction_Date(sd.format(rs.getDate(7)));
									
										fm.setCustomer_Name3(rs.getString(57));
										fm.setCustomer_Id3(rs.getInt(56));
										System.out.println("dao-Super_Senior="+Super_Senior);
										
														
										return fm;
									}
									 }     );
								}
								
								
								public List<RD_Master>viewRDcustomerList2(String accno1,int Bcode)
								{
									//--Set Connection----------------------------
									int j=Bcode;
									this.template=con.getCon2(j);
						//-----------------------------------------------------


									return template.query("select * from RD_Master where Account_No='"+accno1+"'",new RowMapper<RD_Master>(){   public RD_Master mapRow(ResultSet rs, int row) throws SQLException
																											{  
									
										                                                                     RD_Master sm=new RD_Master();
										                                                                     SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
										                                                                    sm.setCustomer_Id1(rs.getInt(3)); //Customer_Id
										                                                                    sm.setCustomer_Id2(rs.getInt(5));//Customer_Id2
										                                                                    sm.setScheme_Type(rs.getString(9)); //Scheme_Type
										                                                                    sm.setAccount_No(rs.getString(2)); //Account_No
										                                                                    sm.setPeriod(rs.getString(13)); //Period
										                                                                    sm.setOpen_Date(sd.format(rs.getDate(7))); //Open_Date
										                                                                    sm.setInterest_Rate(rs.getFloat(11)); //Interest_Rate
										                                                                    sm.setMop(rs.getString(10)); //MOP
										                                                                    sm.setEffect_Date(sd.format(rs.getDate(8)));//Effect_Date
										                                                                    sm.setInterest_Repayment(rs.getString(16));//Interest_Repayment
										                                                                    sm.setCompounding(rs.getString(17));//Compounding
										                                                                    sm.setInt_Payment_Mode(rs.getString(16));//Int_Payment_Mode
										                                                                    sm.setMaturity_Date(sd.format(rs.getDate(19))); //MATURITY_DATE
										                                                                    sm.setMaturity_Amount(rs.getFloat(20));//Maturity_Amount
										                                                                    sm.setNominee_Name(rs.getString(25));//Nominee_Name
										                                                                    sm.setNominee_Relationship(rs.getString(26));//Nominee_Relationship
										                                                                    sm.setNominee_Age(rs.getString(27));//Nominee_Age
										                                                                    sm.setDeposit_Amount(rs.getFloat(12));//Deposit_Amount
										                                                                    sm.setCustomer_Name1(rs.getString(4));//Customer_Name1
										                                                                    sm.setCustomer_Name2(rs.getString(6));//Customer_Name2
										                                                                    sm.setStanding_Scheme(rs.getString(42)); //Standing_Scheme
										                                                                    //old
										                                                                    //sm.setStanding_Acc_No(rs.getLong(43));  //Standing_Account_No
										                                                                    //New
										                                                                    sm.setStanding_Acc_No(rs.getLong(43));  //Standing_Account_No
										                                                                    sm.setSr_Ctzn1(rs.getString(46));
										                                                                    sm.setStaff2(rs.getString(48));
										                                                                    sm.setCustomer_Id3(rs.getInt(49)); //Customer_Id3
										                                                                    sm.setCustomer_Name3(rs.getString(50)); //Customer_Name3
										                                                                    sm.setNo_of_Inst_Paid(rs.getInt(36));
										                                                                    
										                                                                     
										                                                                      
										                                                                     
																							 		
																												
																												return sm;
																											}
								 																		 }     );


}
								
								
								public String AddDays_ToDate(String Date1,int n) {
									//--Set Connection------------------------------------
									int j=Binfo;
									this.template=con.getCon2(j);
									//-----------------------------------------------------
									
									//Chnaged query 28-01-2020
								/*	String i=null;
									
									String qry="select to_char((to_date('"+Date1+"','dd/MM/yyyy')+"+n+"),'dd/MM/yyyy') from dual";
									PreparedStatement pstmt = null;
									try {
										pstmt = template.getDataSource().getConnection().prepareStatement(qry);
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
										pstmt = template.getDataSource().getConnection().prepareStatement("select to_char((to_date(?,'dd/MM/yyyy')+?),'dd/MM/yyyy') from dual");
										pstmt.setString(1, Date1);
										pstmt.setInt(2, n);
										
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
								
								
								
								 public List<SimpleBranch> getScheme_MasterInfo(String Scheme_Code,int Bcode) {
										//--Set Connection----------------------------
										int j=Bcode;
										this.template=con.getCon2(j);
										//-----------------------------------------------------


										return template.query("select * from Scheme_MASTER where Scheme_Code='"+Scheme_Code+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
										{  

											SimpleBranch gl=new SimpleBranch();
											gl.setS1(rs.getInt(4));//GL_GENERAL
											gl.setS11(rs.getInt(5));//GL_INT_PAID
											gl.setS12(rs.getInt(6));//GL_INT_PAYABLE
											gl.setS41(rs.getInt(7));//GL_INT_RECEIVED
											gl.setS42(rs.getInt(8));//GL_INT_RECEIVABLE
											gl.setS43(rs.getInt(9));//GL_PENALTY
											gl.setS44(rs.getInt(11));//GL_ENTRANCE_FEE
											gl.setS45(rs.getInt(12));//GL_APPRAISER_FEE
											gl.setS46(rs.getInt(13));//GL_POSTAGE
											gl.setS47(rs.getInt(14));//GL_INSURANCE
											gl.setS48(rs.getInt(15));//GL_FORMS
											gl.setS49(rs.getInt(18));//GL_CLOSURE_CHARGES
											gl.setS19(rs.getInt(22));//GL_DEFAULT_INT_RECEIVED
											gl.setS21(rs.getInt(23));//GL_DEFAULT_INT_RECEIVABLE
											gl.setS22(rs.getInt(33));//GL_SERVICE_TAX
											gl.setS2(rs.getString(39));//COMPOUND
											gl.setS13(rs.getFloat(28)); //Lien Percentage
											gl.setS23(rs.getInt(19));//Account Code
											return gl;
										}
										 }     );
									}

								 public String getGL_Name(String GL_Code,int Bcode) {
										//--Set Connection----------------------------
												int j=Bcode;
												this.template=con.getCon2(j);
												//-----------------------------------------------------
													String i=null;
										String query = "select GL_Name  from GL_Master where to_char(GL_Code)='"+GL_Code+"'";

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
								 
								 public String getuser_level(String user, int Bcode)
									{
										//--Set Connection------------------------------------
										int j=Binfo;
										this.template=con.getCon2(j);
										//-----------------------------------------------------
										String i="";
										String query = "select user_level from LoginDetails where username='"+user+"'";
										System.out.println("query---------------------"+query);
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
										
										return i;
									}
								
								 public String getStatus(String Account_No, int Bcode)
									{
										//--Set Connection------------------------------------
										int j=Bcode;
										this.template=con.getCon2(j);
										//-----------------------------------------------------
										String i=null;
										String query = "select Status from OL_Master where Account_No='"+Account_No+"'";
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
										
										return i;
									}
									
								 
								 public int update_status1(String Acc_No,int Bcode)
									{
										//--Set Connection------------------------------------
											int j=Bcode;
											this.template=con.getCon2(j);
											//-----------------------------------------------------
											System.out.println("Bcoe----------------------"+Bcode);
										long Account_No=Long.parseLong(Acc_No);
									
										 String update_status="update OL_Master set Status='Pending' where Account_No='"+Account_No+"' and Branch_Code='"+Bcode+"'";
										  template.update(update_status);
										System.out.println("update_status----------------"+update_status);
										return 1;
									}
								 
								 public int update_manager(String Account_No,String user,String Current, int Bcode)
									{
										//--Set Connection------------------------------------
											int j=Binfo;
											this.template=con.getCon2(j);
											//-----------------------------------------------------
										
										String sql="update LOAN_APPROVAL_STATUS set CORP_APPROVED_BY='"+user+"',CORP_APPROVED_DATE='"+Current+"' where ACCOUNT_NO='"+Account_No+"' and BCODE='"+Bcode+"'";
																																			
						          try
						                          {
										template.update(sql);
						          }
						          catch(Exception e)
						          {
						          	System.out.println(e);
						          }
										
										
										
										return 1;
									}
								 
								 public int update_status_final(String Acc_No,int Bcode)
									{
										//--Set Connection------------------------------------
											int j=Bcode;
											this.template=con.getCon2(j);
											//-----------------------------------------------------
										long Account_No=Long.parseLong(Acc_No);
									
										 String update_status="update OL_Master set Status='Approved' where Account_No='"+Account_No+"' and Branch_Code='"+Bcode+"'";
										  template.update(update_status);
										
										return 1;
									}
								 
								 public int update_manager_Final(String Account_No,String user,String Current, int Bcode)
									{
										//--Set Connection------------------------------------
											int j=Binfo;
											this.template=con.getCon2(j);
											//-----------------------------------------------------
										
										String sql="update LOAN_APPROVAL_STATUS set FINAL_APPROVED_BY='"+user+"',FINAL_APPROVED_DATE='"+Current+"' where ACCOUNT_NO='"+Account_No+"' and BCODE='"+Bcode+"'";
																																			
						          try
						                          {
										template.update(sql);
						          }
						          catch(Exception e)
						          {
						          	System.out.println(e);
						          }
										
										
										
										return 1;
									}

								 public List<SimpleBranch> getApprovalInfo(long Account_No,int Bcode){
										//--Set Connection------------------------------------
										int j=Binfo;;
											this.template=con.getCon2(j);
											//-----------------------------------------------------
											return template.query("select CREATED_BY,MODIFIED_BY,CORP_APPROVED_BY,FINAL_APPROVED_BY from LOAN_APPROVAL_STATUS where Account_No='"+Account_No+"' and Bcode='"+Bcode+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
											{  
													SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
												SimpleBranch gl=new SimpleBranch();
											   
												gl.setS2(rs.getString(1)); 
												gl.setS3(rs.getString(2)); 
												gl.setS4(rs.getString(3)); 
												gl.setS5(rs.getString(4)); 
												
												
												
												
												
											return gl;
											}
											 }     );
										}		
								 
								 
								 
								 public List<SimpleBranch> getDL_Attachement(String Account_No) {
										// --Set Connection------------------------------------
										int j = Binfo;
										this.template = con.getCon2(j);
										// -----------------------------------------------------
										String sql="Select id,branch,Account_No,File_Name from  DL_Attachments where Account_No='"+ Account_No + "' order by id";
										System.out.println(sql);
										return template.query(sql, new RowMapper<SimpleBranch>() {
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
								 
								 public String getAttachement_FilesName1_DL(int id) {
										//--Set Connection------------------------------------
										int j=Binfo;
										this.template=con.getCon2(j);
										//-----------------------------------------------------
										String i=null;
										String query = "select file_Name from DL_Attachments where id="+id+" and rownum=1";
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
													  System.out.println(i);
												  }
											}
											//i=resultSet.getRow();
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
											
										return i;
									} 
								 
								 
									public List<SimpleBranch> getSB_LienInfo(String accno,int Bcode){
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
									
									
									public List<SimpleBranch>getEOM_Entry_Log(String From_Date,int Bcode)
									{
										//--Set Connection------------------------------------
										int j=Bcode;
										this.template=con.getCon2(j);
										//-----------------------------------------------------

									 	//String sql="Select a.*,case when b.c1 is null then 'NO' else 'YES' end as status from (select scheme_code,scheme_name,scheme_category,to_char(GL_INT_PAID) as glacc from scheme_master where SCHEME_CATEGORY in ('SD','FD','RD')and scheme_code in (select distinct scheme_code from sbca_Master where account_status='A' union select distinct scheme_code from fd_Master where account_status='A' union select distinct scheme_code from rd_Master where account_status='A' ) union select scheme_code,scheme_name,scheme_category,to_char(GL_INT_RECEIVED) as glacc from scheme_master where SCHEME_CATEGORY in ('DL','JL','RL','CL','CC')and scheme_code in (select distinct scheme_code from ol_Master where account_status='A' union select distinct scheme_code from jl_Master where account_status='A' union select distinct scheme_code from rl_Master where account_status='A' union select distinct scheme_code from cc_Master where account_status='A') )a left join (select Account_no,count(*)as c1 from daily_transaction where account_no in (select GL_INT_PAID from scheme_master where SCHEME_CATEGORY in ('SD','FD','RD') union select GL_INT_RECEIVED from scheme_master where SCHEME_CATEGORY in ('DL','JL','RL','CL','CC') ) and transaction_date=to_date('"+From_Date+"','dd/MM/yyyy')AND PAGE_SOURCE='EOM' group by account_no)b on a.glacc=b.account_no where a.glacc not in ('60010','60011','60012','60013','60014','60015','60016','60017','60020','80002')  order by a.scheme_code";
									 	//30-08-2021
										//String sql="select main_qry.*,(select count(*) from cust_acc_link where scheme_code=main_qry.scheme_code and account_status='A')as records1 from ( Select a.*,case when b.c1 is null then 'NO' else 'YES' end as status from (select scheme_code,scheme_name,scheme_category,to_char(GL_INT_PAID) as glacc from scheme_master where SCHEME_CATEGORY in ('SD','FD','RD')and scheme_code in (select distinct scheme_code from sbca_Master where account_status='A' union select distinct scheme_code from fd_Master where account_status='A' union select distinct scheme_code from rd_Master where account_status='A' ) union select scheme_code,scheme_name,scheme_category,to_char(GL_INT_RECEIVED) as glacc from scheme_master where SCHEME_CATEGORY in ('DL','JL','RL','CL','CC')and scheme_code in (select distinct scheme_code from ol_Master where account_status='A' union select distinct scheme_code from jl_Master where account_status='A' union select distinct scheme_code from rl_Master where account_status='A' union select distinct scheme_code from cc_Master where account_status='A') )a left join (select Account_no,count(*)as c1 from daily_transaction where account_no in (select GL_INT_PAID from scheme_master where SCHEME_CATEGORY in ('SD','FD','RD') union select GL_INT_RECEIVED from scheme_master where SCHEME_CATEGORY in ('DL','JL','RL','CL','CC') ) and transaction_date=to_date('"+From_Date+"','dd/MM/yyyy') AND PAGE_SOURCE='EOM' group by account_no)b on a.glacc=b.account_no where a.glacc not in ('60010','60011','60012','60013','60014','60015','60016','60017','60020','80002')  order by a.scheme_code)main_qry";

										//31-10-2022
										//String sql="select main_qry.*,(select count(*) from cust_acc_link where scheme_code=main_qry.scheme_code and account_status='A')as records1 from ( Select a.*,case when b.c1 is null then 'NO' else 'YES' end as status from (select scheme_code,scheme_name,scheme_category,to_char(GL_INT_PAID) as glacc from scheme_master where SCHEME_CATEGORY in ('SD','FD','RD')and scheme_code in (select distinct scheme_code from sbca_Master where account_status='A' union select distinct scheme_code from fd_Master where account_status='A' union select distinct scheme_code from rd_Master where account_status='A' ) union select scheme_code,scheme_name,scheme_category,to_char(GL_INT_RECEIVED) as glacc from scheme_master where SCHEME_CATEGORY in ('DL','JL','RL','CL','CC','ML','PL')and scheme_code in (select distinct scheme_code from ol_Master where account_status='A' union select distinct scheme_code from jl_Master where account_status='A' union select distinct scheme_code from rl_Master where account_status='A' union select distinct scheme_code from cc_Master where account_status='A') )a left join (select Account_no,count(*)as c1 from daily_transaction where account_no in (select GL_INT_PAID from scheme_master where SCHEME_CATEGORY in ('SD','FD','RD') union select GL_INT_RECEIVED from scheme_master where SCHEME_CATEGORY in ('DL','JL','RL','CL','CC','ML','PL') ) and transaction_date=to_date('"+From_Date+"','dd/MM/yyyy') AND PAGE_SOURCE='EOM' group by account_no)b on a.glacc=b.account_no where a.glacc not in ('60010','60011','60012','60013','60014','60015','60016','60017','60020','80002')  order by a.scheme_code)main_qry";
										
										//23-01-2023
										//String sql="Select a.Scheme_Code,c.Scheme_Name,Scheme_Category,0 as GLACC,case when NVL(Prov_Acc,0)>=NVL(Tot_Acc,0) then 'YES' else 'NO' End as STATUS,Tot_Acc,NVL(case when Prov_Acc>Tot_Acc then Tot_Acc else Prov_Acc End,0) as Prov_Acc,round(NVL(case when Prov_Acc>Tot_Acc then Tot_Acc else Prov_Acc End,0)/NVL(Tot_Acc,0) * 100,0) as Progress from (Select Scheme_Code,count(*) as Tot_Acc from SBCA_Master where Scheme_Code!=20019 and Open_Date<to_date( '"+From_Date+"','dd/MM/yyyy') and (Account_Status!='C' or NVL(Closed_Date,'31/12/2099')>to_date( '"+From_Date+"','dd/MM/yyyy')) group by Scheme_Code union Select Scheme_Code,count(*) as Tot_Acc from FD_Master where Open_Date<=to_date('"+From_Date+"','dd/MM/yyyy') and  (Account_Status='A' or NVL(Closed_Date,'31/12/2099')>=to_date( '"+From_Date+"','dd/MM/yyyy')) group by Scheme_Code union Select Scheme_Code,count(*) as Tot_Acc from RD_Master where Open_Date<=to_date( '"+From_Date+"','dd/MM/yyyy') and Maturity_Date>=to_date('"+From_Date+"','dd/MM/yyyy') and (Account_Status='A' or NVL(Closed_Date,'31/12/2099')>to_date( '"+From_Date+"','dd/MM/yyyy')) group by Scheme_Code union Select Scheme_Code,count(*) as Tot_Acc from JL_Master where Open_Date<=to_date( '"+From_Date+"','dd/MM/yyyy') and Account_Status!='R' and (Account_Status='A' or NVL(Closed_Date,'31/12/2099')>to_date( '"+From_Date+"','dd/MM/yyyy')) group by Scheme_Code union Select Scheme_Code,count(*) as Tot_Acc from OL_Master where Open_Date<=to_date( '"+From_Date+"','dd/MM/yyyy') and Account_Status!='R' and (Account_Status='A' or NVL(Closed_Date,'31/12/2099')>to_date( '"+From_Date+"','dd/MM/yyyy')) group by Scheme_Code) a left join (Select Scheme_Code,count(*) as Prov_Acc from Int_Payable left join Cust_Acc_Link on Int_Payable.Account_No=Cust_Acc_Link.Account_No where To_Date=to_date( '"+From_Date+"','dd/MM/yyyy') group by Scheme_Code union Select Scheme_Code,count(*) as Prov_Acc from Int_Receivable left join Cust_Acc_Link on Int_Receivable.Account_No=Cust_Acc_Link.Account_No where Flag='INT' and To_Date=to_date( '"+From_Date+"','dd/MM/yyyy') group by Scheme_Code) b on a.Scheme_Code=b.Scheme_Code left join Scheme_Master c on a.Scheme_Code=c.Scheme_Code order by a.Scheme_Code";

										//28-09-2023 scheme_code not like '800%' and
										//String sql="Select c.Scheme_Code,c.Scheme_Name,Scheme_Category,Abs(NVL(Opening_Balance,0)+NVL(Tran_Amt,0)) as GL_CB,0 as GLACC,case when NVL(Prov_Acc,0)>=NVL(Tot_Acc,0) and NVL(Tot_Acc,0)>0 then 'YES' else 'NO' End as STATUS,NVL(Tot_Acc,0)+NVL(Matured_not_paid,0) as Tot_Acc,NVL(case when NVL(Prov_Acc,0)+NVL(Matured_not_paid,0)>Tot_Acc then Tot_Acc else NVL(Prov_Acc,0)+NVL(Matured_not_paid,0) End,0) as Prov_Acc,case when NVL(Tot_Acc,0)=0 then 0 else round(NVL(case when Prov_Acc>Tot_Acc then Tot_Acc else Prov_Acc End,0)/NVL(Tot_Acc,0) * 100,0) End as Progress,time_info from (Select Scheme_Code,count(*) as Tot_Acc from SBCA_Master where Scheme_Code!=20019 and Open_Date<to_date( '"+From_Date+"','dd/MM/yyyy') and (Account_Status!='C' or NVL(Closed_Date,'31/12/2099')>to_date( '"+From_Date+"','dd/MM/yyyy')) group by Scheme_Code union Select Scheme_Code,count(*) as Tot_Acc from FD_Master where Open_Date<=to_date('"+From_Date+"','dd/MM/yyyy') and  (Account_Status='A' or NVL(Closed_Date,'31/12/2099')>=to_date( '"+From_Date+"','dd/MM/yyyy')) group by Scheme_Code union Select Scheme_Code,count(*) as Tot_Acc from RD_Master where Open_Date<=to_date( '"+From_Date+"','dd/MM/yyyy') and Maturity_Date>=to_date('"+From_Date+"','dd/MM/yyyy') and (Account_Status='A' or NVL(Closed_Date,'31/12/2099')>to_date( '"+From_Date+"','dd/MM/yyyy')) group by Scheme_Code union Select Scheme_Code,count(*) as Tot_Acc from JL_Master where Open_Date<=to_date( '"+From_Date+"','dd/MM/yyyy') and Account_Status!='R' and (Account_Status='A' or NVL(Closed_Date,'31/12/2099')>to_date( '"+From_Date+"','dd/MM/yyyy')) group by Scheme_Code union Select Scheme_Code,count(*) as Tot_Acc from OL_Master where scheme_code not like '800%' and Open_Date<=to_date( '"+From_Date+"','dd/MM/yyyy') and Account_Status!='R' and (Account_Status='A' or NVL(Closed_Date,'31/12/2099')>to_date( '"+From_Date+"','dd/MM/yyyy')) group by Scheme_Code) a left join (Select Scheme_Code,count(*) as Prov_Acc from Int_Payable left join Cust_Acc_Link on Int_Payable.Account_No=Cust_Acc_Link.Account_No where To_Date=to_date( '"+From_Date+"','dd/MM/yyyy') group by Scheme_Code union Select Scheme_Code,count(*) as Prov_Acc from Int_Receivable left join Cust_Acc_Link on Int_Receivable.Account_No=Cust_Acc_Link.Account_No where Flag='INT' and To_Date=to_date('"+From_Date+"','dd/MM/yyyy') group by Scheme_Code) b on a.Scheme_Code=b.Scheme_Code full join Scheme_Master c on a.Scheme_Code=c.Scheme_Code left join (Select Scheme_Code,count(*) as Matured_not_paid from RD_Master where Open_Date<=to_date( '"+From_Date+"','dd/MM/yyyy') and Maturity_Date<to_date('"+From_Date+"','dd/MM/yyyy') and (Account_Status='A' or NVL(Closed_Date,'31/12/2099')>to_date('"+From_Date+"','dd/MM/yyyy')) group by Scheme_Code) e on c.Scheme_Code=e.Scheme_Code   left join (Select Account_No,sum(case when Transaction_Type='Credit' then Transaction_Amount else -1*Transaction_Amount End) as Tran_Amt from Daily_Transaction where Transaction_Date<=to_date('"+From_Date+"','dd/MM/yyyy') group by Account_No) Daily_Transaction on (c.GL_Int_Payable+c.GL_Int_Receivable)=Daily_Transaction.Account_no left join (Select Account_Code,sum(Opening_Balance) as Opening_Balance from GL_Opening_Balance group by Account_Code) GL_Opening_Balance on (c.GL_Int_Payable+c.GL_Int_Receivable)=GL_Opening_Balance.Account_Code left join (select max(time_info) as time_info,Account_no from daily_transaction where page_source='EOM' and flag='GL' and transaction_date=to_date('"+From_Date+"','dd/MM/yyyy') group by Account_no) tr on (c.GL_Int_Payable+c.GL_Int_Receivable)=tr.Account_no where (NVL(Opening_Balance,0)+NVL(Tran_Amt,0) != 0 and c.GL_INT_RECEIVABLE!=20062) or a.Scheme_Code is not null order by time_info,a.Scheme_Code";
										//28-09-2024
										String sql="Select c.Scheme_Code,c.Scheme_Name,Scheme_Category,Abs(NVL(Opening_Balance,0)+NVL(Tran_Amt,0)) as GL_CB,0 as GLACC,case when NVL(Prov_Acc,0)+NVL(Matured_not_paid,0)>=NVL(Tot_Acc,0)+NVL(Matured_not_paid,0) and NVL(Tot_Acc,0)+NVL(Matured_not_paid,0)>0 then 'YES' else 'NO' End as STATUS,NVL(Tot_Acc,0)+NVL(Matured_not_paid,0) as Tot_Acc,NVL(case when NVL(Prov_Acc,0)+NVL(Matured_not_paid,0)>Tot_Acc then Tot_Acc else NVL(Prov_Acc,0)+NVL(Matured_not_paid,0) End,0) as Prov_Acc,case when NVL(Tot_Acc,0)+NVL(Matured_not_paid,0)=0 then 0 else round(NVL(case when Prov_Acc>Tot_Acc then Tot_Acc else NVL(Prov_Acc,0)+NVL(Matured_not_paid,0) End,0)/(NVL(Tot_Acc,0)+NVL(Matured_not_paid,0)) * 100,0) End as Progress,time_info from (Select Scheme_Code,count(*) as Tot_Acc from SBCA_Master where Scheme_Code!=20019 and Open_Date<to_date( '"+From_Date+"','dd/MM/yyyy') and (Account_Status!='C' or NVL(Closed_Date,'31/12/2099')>to_date( '"+From_Date+"','dd/MM/yyyy')) group by Scheme_Code union Select Scheme_Code,count(*) as Tot_Acc from FD_Master where Open_Date<=to_date('"+From_Date+"','dd/MM/yyyy') and  (Account_Status='A' or NVL(Closed_Date,'31/12/2099')>=to_date( '"+From_Date+"','dd/MM/yyyy')) group by Scheme_Code union Select Scheme_Code,count(*) as Tot_Acc from RD_Master where Open_Date<=to_date( '"+From_Date+"','dd/MM/yyyy') and Maturity_Date>=to_date('"+From_Date+"','dd/MM/yyyy') and (Account_Status='A' or NVL(Closed_Date,'31/12/2099')>to_date( '"+From_Date+"','dd/MM/yyyy')) group by Scheme_Code union Select Scheme_Code,count(*) as Tot_Acc from JL_Master where Open_Date<=to_date( '"+From_Date+"','dd/MM/yyyy') and Account_Status!='R' and (Account_Status='A' or NVL(Closed_Date,'31/12/2099')>to_date( '"+From_Date+"','dd/MM/yyyy')) group by Scheme_Code union Select Scheme_Code,count(*) as Tot_Acc from OL_Master where scheme_code not like '800%' and Open_Date<=to_date( '"+From_Date+"','dd/MM/yyyy') and Account_Status!='R' and (Account_Status='A' or NVL(Closed_Date,'31/12/2099')>to_date( '"+From_Date+"','dd/MM/yyyy')) group by Scheme_Code) a left join (Select Scheme_Code,count(*) as Prov_Acc from Int_Payable left join Cust_Acc_Link on Int_Payable.Account_No=Cust_Acc_Link.Account_No where To_Date=to_date( '"+From_Date+"','dd/MM/yyyy') group by Scheme_Code union Select Scheme_Code,count(*) as Prov_Acc from Int_Receivable left join Cust_Acc_Link on Int_Receivable.Account_No=Cust_Acc_Link.Account_No where Flag='INT' and To_Date=to_date('"+From_Date+"','dd/MM/yyyy') group by Scheme_Code) b on a.Scheme_Code=b.Scheme_Code full join Scheme_Master c on a.Scheme_Code=c.Scheme_Code left join (Select Scheme_Code,count(*) as Matured_not_paid from RD_Master where Open_Date<=to_date( '"+From_Date+"','dd/MM/yyyy') and Maturity_Date<to_date('"+From_Date+"','dd/MM/yyyy') and (Account_Status='A' or NVL(Closed_Date,'31/12/2099')>to_date('"+From_Date+"','dd/MM/yyyy')) group by Scheme_Code) e on c.Scheme_Code=e.Scheme_Code   left join (Select Account_No,sum(case when Transaction_Type='Credit' then Transaction_Amount else -1*Transaction_Amount End) as Tran_Amt from Daily_Transaction where Transaction_Date<=to_date('"+From_Date+"','dd/MM/yyyy') group by Account_No) Daily_Transaction on (c.GL_Int_Payable+c.GL_Int_Receivable)=Daily_Transaction.Account_no left join (Select Account_Code,sum(Opening_Balance) as Opening_Balance from GL_Opening_Balance group by Account_Code) GL_Opening_Balance on (c.GL_Int_Payable+c.GL_Int_Receivable)=GL_Opening_Balance.Account_Code left join (select max(time_info) as time_info,Account_no from daily_transaction where page_source='EOM' and flag='GL' and transaction_date=to_date('"+From_Date+"','dd/MM/yyyy') group by Account_no) tr on (c.GL_Int_Payable+c.GL_Int_Receivable)=tr.Account_no where (NVL(Opening_Balance,0)+NVL(Tran_Amt,0) != 0 and c.GL_INT_RECEIVABLE!=20062) or a.Scheme_Code is not null order by time_info,a.Scheme_Code";

										/*
										Select c.Scheme_Code,c.Scheme_Name,Scheme_Category,Abs(NVL(Opening_Balance,0)+NVL(Tran_Amt,0)) as GL_CB,0 as GLACC,case when NVL(Prov_Acc,0)>=NVL(Tot_Acc,0) then 'YES' else 'NO' End as STATUS,
												NVL(Tot_Acc,0)+NVL(Matured_not_paid,0) as Tot_Acc,NVL(case when NVL(Prov_Acc,0)+NVL(Matured_not_paid,0)>Tot_Acc then Tot_Acc else NVL(Prov_Acc,0)+NVL(Matured_not_paid,0) End,0) as Prov_Acc,
												case when NVL(Tot_Acc,0)=0 then 0 else round(NVL(case when Prov_Acc>Tot_Acc then Tot_Acc else Prov_Acc End,0)/NVL(Tot_Acc,0) * 100,0) End as Progress from 
												(Select Scheme_Code,count(*) as Tot_Acc from SBCA_Master where Scheme_Code!=20019 and Open_Date<to_date( '29/02/2024','dd/MM/yyyy') 
												and (Account_Status!='C' or NVL(Closed_Date,'31/12/2099')>to_date( '29/02/2024','dd/MM/yyyy')) group by Scheme_Code 
												union 
												Select Scheme_Code,count(*) as Tot_Acc from FD_Master where Open_Date<=to_date('29/02/2024','dd/MM/yyyy') and  
												(Account_Status='A' or NVL(Closed_Date,'31/12/2099')>=to_date( '29/02/2024','dd/MM/yyyy')) group by Scheme_Code 
												union 
												Select Scheme_Code,count(*) as Tot_Acc from RD_Master where Open_Date<=to_date( '29/02/2024','dd/MM/yyyy') and 
												Maturity_Date>=to_date('29/02/2024','dd/MM/yyyy') and (Account_Status='A' or NVL(Closed_Date,'31/12/2099')>to_date( '29/02/2024','dd/MM/yyyy')) group by Scheme_Code 
												union 
												Select Scheme_Code,count(*) as Tot_Acc from JL_Master where Open_Date<=to_date( '29/02/2024','dd/MM/yyyy') and Account_Status!='R'
												and (Account_Status='A' or NVL(Closed_Date,'31/12/2099')>to_date( '29/02/2024','dd/MM/yyyy')) group by Scheme_Code 
												union 
												Select Scheme_Code,count(*) as Tot_Acc from OL_Master where scheme_code not like '800%' and Open_Date<=to_date( '29/02/2024','dd/MM/yyyy') 
												and Account_Status!='R' and (Account_Status='A' or NVL(Closed_Date,'31/12/2099')>to_date( '29/02/2024','dd/MM/yyyy')) group by Scheme_Code) a 
												left join 
												(Select Scheme_Code,count(*) as Prov_Acc from Int_Payable left join Cust_Acc_Link on Int_Payable.Account_No=Cust_Acc_Link.Account_No 
												where To_Date=to_date( '29/02/2024','dd/MM/yyyy') group by Scheme_Code 
												union 
												Select Scheme_Code,count(*) as Prov_Acc from Int_Receivable left join Cust_Acc_Link on Int_Receivable.Account_No=Cust_Acc_Link.Account_No 
												where Flag='INT' and To_Date=to_date( '29/02/2024','dd/MM/yyyy') group by Scheme_Code) b on a.Scheme_Code=b.Scheme_Code 
												full join Scheme_Master c on a.Scheme_Code=c.Scheme_Code 

							left join
                        (Select Scheme_Code,count(*) as Matured_not_paid from RD_Master where Open_Date<=to_date( '31/05/2024','dd/MM/yyyy') and 
												Maturity_Date<to_date('31/05/2024','dd/MM/yyyy') and (Account_Status='A' or NVL(Closed_Date,'31/12/2099')>to_date( '31/05/2024','dd/MM/yyyy')) group by Scheme_Code) e
												on c.Scheme_Code=e.Scheme_Code 
												
												left join 
												(Select Account_No,sum(case when Transaction_Type='Credit' then Transaction_Amount else -1*Transaction_Amount End) as Tran_Amt 
												from Daily_Transaction where Transaction_Date<='29/02/2024' group by Account_No) Daily_Transaction 
												on (c.GL_Int_Payable+c.GL_Int_Receivable)=Daily_Transaction.Account_no 
												left join 
												(Select Account_Code,sum(Opening_Balance) as Opening_Balance from GL_Opening_Balance group by Account_Code) GL_Opening_Balance 
												on (c.GL_Int_Payable+c.GL_Int_Receivable)=GL_Opening_Balance.Account_Code 
												where NVL(Opening_Balance,0)+NVL(Tran_Amt,0) != 0 or a.Scheme_Code is not null
												order by a.Scheme_Code;
*/
										
									 	System.out.println(sql);
									 	System.out.println("---------bcode:"+j);
										return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																												{  
											System.out.println("after qry run");
											
											SimpleBranch gl=new SimpleBranch();
										   	gl.setS31(rs.getString(1));//Scheme_Code
											gl.setS32(rs.getString(2));//Scheme_Name
											gl.setS33(rs.getString(3));//Scheme_Category
											gl.setS143(rs.getDouble(4));//Scheme_Category
											gl.setS34(rs.getString(5));//GLACC
											gl.setS35(rs.getString(6));//Status
											gl.setS37(rs.getString(7));//Total
											gl.setS38(rs.getString(8));//Completed -- newly added --
											gl.setS39(rs.getString(9));//Progress -- newly added --
											gl.setS3(""+(rs.getInt(7)-rs.getInt(8)));//Pending
											gl.setS75(rs.getString(10));//timeinfo
										
										return gl;
																												}
																											 }     );
									}

									
									public List<SimpleBranch>EOM_Log(String From_Date,int Bcode)
									{
										//--Set Connection------------------------------------
										int j=Bcode;
										this.template=con.getCon2(j);
										//-----------------------------------------------------

									 	
										String sql="Select br.Branch_Code,Branch_Name,NVL(SD,0) as SD,NVL(SSD,0) as SSD,NVL(FD,0) as FD,NVL(FD_IBA,0) as FD_IBA,NVL(SL,0) as SL,NVL(EOM,0) as EOM,nvl(Pending,0) as IBA_Ready,nvl(IBA_IN,0) as IBA_IN  from Branch_Master br left join (Select FD_Master.Branch,sum(case when substr(FD_Master.NEFT_Account_Number,1,3)=FD_Master.Branch then 1 else 0 End) as FD,sum(case when substr(FD_Master.NEFT_Account_Number,1,3)!=FD_Master.Branch then 1 else 0 End) as FD_IBA from FD_Master_View FD_Master left join (Select Account_No,sum(Interest) as Int_Prov from FD_Interest_View where To_Date <= to_date('"+From_Date+"','dd/MM/yyyy') group by Account_No) FD_Interest on FD_Master.Account_No = FD_Interest.Account_No left join (Select Account_No,sum(Transaction_Amount) as Int_Paid from Daily_Transaction_Table where Flag='INT' and Transaction_Type='Credit' group by Account_No) FD_Int_Paid on FD_Master.Account_No=FD_Int_Paid.Account_No where FD_Master.Account_Status='A' and Compounding!='Y' and Interest_Payment_Mode='Standing Instruction' and NVL(Int_Prov,0) - NVL(Int_Paid,0) > 0 group by FD_Master.Branch) fd on br.Branch_code=fd.Branch left join (select Branch,count(*) as SL from cc_master_view where ACCOUNT_STATUS='A' and last_int_applied_date<to_date('"+From_Date+"','dd/MM/yyyy') group by Branch) sl on br.Branch_code=sl.Branch left join (select Branch,sum(case when substr('"+From_Date+"',1,5)!='31/03' and substr('"+From_Date+"',1,5)!='30/09' then 0 else case when scheme_code not in ('20011','20017','20014','20015','20016') then 1 else 0 End End) as SD,sum(case when scheme_code in ('20019') then 1 else 0 End) as SSD from sbca_master_view_c2 where Account_status !='C' and LAST_INT_APPLIED_DATE<to_date('"+From_Date+"','dd/MM/yyyy') group by Branch) sd on br.Branch_code=sd.Branch left join (Select Branch,count(*) as EOM from Daily_Transaction_table where Flag='GL' and Transaction_Date='"+From_Date+"' and Page_Source='EOM' group by Branch) eom on br.Branch_code=eom.Branch left join (Select Branch_Code,sum(SD+SSD) as Pending from (Select distinct(substr(FD_Master.NEFT_Account_Number,1,3)) as IB_Branch,Branch_Code from FD_Master_View FD_Master left join (Select Account_No,sum(Interest) as Int_Prov from FD_Interest_View where To_Date <= to_date('"+From_Date+"','dd/MM/yyyy') group by Account_No) FD_Interest on FD_Master.Account_No = FD_Interest.Account_No left join (Select Account_No,sum(Transaction_Amount) as Int_Paid from Daily_Transaction_Table where Flag='INT' and Transaction_Type='Credit' group by Account_No) FD_Int_Paid on FD_Master.Account_No=FD_Int_Paid.Account_No where FD_Master.Account_Status='A' and Compounding!='Y' and substr(FD_Master.NEFT_Account_Number,1,3)!=FD_Master.BRANCH_CODE and Interest_Payment_Mode='Standing Instruction' and NVL(Int_Prov,0) - NVL(Int_Paid,0) > 0) a left join (select Branch,sum(case when substr('"+From_Date+"',1,5)!='31/03' and substr('"+From_Date+"',1,5)!='30/09' then 0 else case when scheme_code not in ('20011','20017','20014','20015','20016') then 1 else 0 End End) as SD,sum(case when scheme_code in ('20019') then 1 else 0 End) as SSD from sbca_master_view_c2 where Account_status !='C' and LAST_INT_APPLIED_DATE<to_date('"+From_Date+"','dd/MM/yyyy') group by Branch) b on a.IB_Branch=b.Branch group by Branch_Code) fd_iba on br.Branch_code=fd_iba.Branch_Code left join (Select substr(FD_Master.NEFT_Account_Number,1,3) as IBA_Branch,sum(case when substr(FD_Master.NEFT_Account_Number,1,3)!=FD_Master.Branch then 1 else 0 End) as IBA_IN from FD_Master_View FD_Master  left join (Select Account_No,sum(Interest) as Int_Prov from FD_Interest_View where To_Date <= to_date('"+From_Date+"','dd/MM/yyyy') group by Account_No) FD_Interest on FD_Master.Account_No = FD_Interest.Account_No  left join (Select Account_No,sum(Transaction_Amount) as Int_Paid from Daily_Transaction_Table where Flag='INT' and Transaction_Type='Credit' group by Account_No) FD_Int_Paid on FD_Master.Account_No=FD_Int_Paid.Account_No where FD_Master.Account_Status='A' and Compounding!='Y' and Interest_Payment_Mode='Standing Instruction' and NVL(Int_Prov,0) - NVL(Int_Paid,0) > 0 group by substr(FD_Master.NEFT_Account_Number,1,3)) ib_inward on br.Branch_code=ib_inward.IBA_Branch order by br.Branch_Code";

										
									 	System.out.println(sql);
									 	System.out.println("---------bcode:"+j);
										return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																												{  
											System.out.println("after qry run");
											
											SimpleBranch gl=new SimpleBranch();
										   	gl.setS31(rs.getString(1));//Branch Code
											gl.setS32(rs.getString(2));//Branch Name
											gl.setS41(rs.getInt(3));//SD
											gl.setS42(rs.getInt(4));//SSD
											gl.setS43(rs.getInt(5));//FD
											gl.setS44(rs.getInt(6));//FD_IBA
											gl.setS45(rs.getInt(7));//SL
											gl.setS46(rs.getInt(8));//EOM
											gl.setS47(rs.getInt(9));//IBA ready
											gl.setS48(rs.getInt(10));//IBA inward
											
										return gl;
																												}
																											 }     );
									}


									public List<SimpleBranch>Scheduler_Log(String Date,int Bcode)
									{
										//--Set Connection------------------------------------
										int j=Bcode;
										this.template=con.getCon2(j);
										//-----------------------------------------------------

									 	
										String sql="select log_id,to_char(log_date,'dd/mm/yyyy hh24:mi:ss') log_date,job_name,status,to_char(ACTUAL_START_DATE,'dd/mm/yyyy hh24:mi:ss') Start_Date,RUN_DURATION,additional_info from ALL_SCHEDULER_JOB_RUN_DETAILS where Owner='DBUSER1' and Log_date between to_date('"+ Date +" 00:01:01','dd/MM/yyyy hh24:mi:ss') and to_date('"+ Date +" 23:59:59','dd/MM/yyyy hh24:mi:ss') order by Status,log_date desc";

										
									 	System.out.println(sql);
									 	System.out.println("---------bcode:"+j);
										return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																												{  
											System.out.println("after qry run");
											
											SimpleBranch gl=new SimpleBranch();
										   	gl.setS31(rs.getString(1));//Log Id
											gl.setS32(rs.getString(2));//Log Date
											gl.setS33(rs.getString(3));//Job name
											gl.setS34(rs.getString(4));//Status
											gl.setS35(rs.getString(5));//Start Date
											gl.setS36(rs.getString(6));//Run Duration
											gl.setS37(rs.getString(7));//Additional info
											
										return gl;
																												}
																											 }     );
									}

									public List<SimpleBranch> Checklist(String Date,int Bcode)
									{
										//--Set Connection------------------------------------
										int j=Bcode;
										this.template=con.getCon2(j);
										//-----------------------------------------------------

									 	
										//String sql="Select FD_Master.Customer_Id,FD_Master.Customer_Name,FD_Master.Account_No,NVL(Int_Prov,0) - NVL(Int_Paid,0) as Amount,'Excess Interest' as Particulars from FD_Master_View FD_Master left join (Select Account_No,sum(Interest) as Int_Prov from FD_Interest_View where To_Date <= to_date('"+ Date +"','dd/MM/yyyy') group by Account_No) FD_Interest on FD_Master.Account_No = FD_Interest.Account_No left join (Select Account_No,sum(Transaction_Amount) as Int_Paid from Daily_Transaction_Table where Flag='INT' and Transaction_Type='Credit' and Transaction_Date<=to_date('"+ Date +"','dd/MM/yyyy') group by Account_No) FD_Int_Paid on FD_Master.Account_No=FD_Int_Paid.Account_No where FD_Master.Account_Status='A' and Compounding!='Y' and NVL(Int_Prov,0) - NVL(Int_Paid,0) < 0 order by Fd_Master.Account_No";
										
										CallableStatement stmt;
										try {
											stmt = template.getDataSource().getConnection().prepareCall("{call Checklist(?,?)}");
										
										stmt.setString(1,Date);
										
										//register the OUT parameter before calling the stored procedure
										//stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
										//stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
										//stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
										//stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
										//stmt.registerOutParameter(5, java.sql.Types.VARCHAR);
										
										//stmt.execute();
										//ResultSet rs = null;
										//rs = (ResultSet) stmt;
										stmt.registerOutParameter(2, OracleTypes.CURSOR);
										
										stmt.execute();
										
										//read the OUT parameter now
										ResultSet rs = (ResultSet) stmt.getObject(2);
										
										
										List<SimpleBranch> list1=new ArrayList<SimpleBranch>();
										
										while(rs.next()){
											SimpleBranch gl=new SimpleBranch();
											System.out.println("cus is="+rs.getString(2));
										   	gl.setS31(rs.getString(1));//Cust Id
											gl.setS32(rs.getString(2));//Cust name
											gl.setS33(rs.getString(3));//Account No
											gl.setS34(rs.getString(4));//Amount
											gl.setS35(rs.getString(5));//Particulars
											list1.add(gl);
										}
										return list1;
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
											return null;
										}	
																								
									}


}
