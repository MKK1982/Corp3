package com.Pisquare.Dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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


public class AK_TCDao {
	
	int Binfo=201;
	
	@Autowired
	private Configuration_Controller con;
JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template)
	{
		this.template=template;
		
	}
	
	
	
	
	
	//getJL_List

	public List<SimpleBranch> getTally_Transaction_List(String FromDate,String ToDate,String Flag,int Branch,int Bcode){
		//--Set Connection----------------------------
		int j=Branch;
		this.template=con.getCon2(j);
//-----------------------------------------------------
		//select k8.Account_No ,k8.Voucher_Type,k8.Transaction_id,to_char(k8.Transaction_date,'dd/MM/yyyy'),k8.Account_No2,case when k8.credithead is null then case when k8.cashcount=1 then 'Cash on hand' end else creditHead end as Credit_Head,case when k8.debithead is null then case when k8.cashcount=1 then 'Cash on hand' end else debitHead end as Debit_Head,GET_TRANS_TYPE(k8.Page_Source),k8.Transaction_Particulars,k8.Transaction_Amount from (select k7.Account_No,k7.Voucher_Type,k7.Transaction_id,k7.Transaction_date,k7.Account_No2,Case when k7.Credit!=0 then k7.GL_Name2 else null end as CreditHead,Case when k7.Debit!=0 then k7.GL_Name2 else null end as DebitHead,k7.Page_Source,k7.Transaction_Particulars,k7.Transaction_Amount,(select count(*) from Daily_Transaction where Transaction_id=k7.Transaction_id and Transaction_date=k7.Transaction_date and Account_No='29000') as cashcount  from ( select k5.*,k6.Voucher_Type  from (select k4.*,(Select gl_Name from gl_master where to_char(gl_master.GL_CODE)=k4.Account_No)as gl_Name2 from (select p.*,k3.Acc_GL,case when k3.Account_No1 is null  then p.Account_No else k3.Account_No1 end as Account_No2,case when k3.GL_Name is null and p.Account_No='29000' then 'Cash On Hand' else k3.GL_Name end as gl_name1 from (select Transaction_id,Transaction_date,Account_No,transaction_Type,case when transaction_type ='Credit' then Transaction_Amount else 0 end as Credit,case when transaction_type ='Debit' then Transaction_Amount else 0 end as Debit,page_source,Transaction_particulars,Transaction_Amount from daily_transaction where Flag='GL' and Transaction_Date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy'))p left join (select k2.Transaction_id,k2.Transaction_date,k2.Account_No as Account_No1,k2.Acc_GL,k2.GL_Name from(select k1.*,(select gl_Name from gl_master where gl_code=k1.Acc_GL)as gl_name  from (select k.*, case when k.flag='AC' then k.gl_general  else case when k.flag='INT' then k.gl_Int_Payable else case when k.flag='PEN' then k.gl_default_int_receivable else 10270 end end  end as Acc_GL from (select b.*,c.* from(select a.* ,(select scheme_code as sc from cust_acc_link where Account_No =a.Account_no)as sc  from (select Transaction_id,Transaction_date,Account_No,transaction_Type,case when transaction_type ='Credit' then Transaction_Amount else 0 end as Credit,case when transaction_type ='Debit' then Transaction_Amount else 0 end as Debit,page_source,Transaction_particulars,flag from daily_transaction where Flag!='GL' and Transaction_Date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy'))a)b left join (select gl_general, gl_Int_Payable,gl_default_int_receivable ,scheme_master.SCHEME_CODE from scheme_master)c on b.sc=c.scheme_code)k)k1)k2)k3 on p.Transaction_id=k3.Transaction_id and p.Transaction_date=k3.transaction_date and p.Account_No=k3.Acc_GL)k4)k5 left join (select Voucher_Type,Transaction_Id,Transaction_Date from Voucher_Print where Transaction_Date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy'))k6 on k5.Transaction_id=k6.Transaction_id and k5.Transaction_date=k6.Transaction_date)k7 where k7.Account_No !='29000')k8 order by k8.Transaction_date,k8.Transaction_id;
	//new select k10.Account_No as GL_Code,k10.Voucher_Type, k10.Transaction_id,k10.trans_date,k10.Debit_Acc_No,k10.Credit_Acc_No,k10.Debit_Head as Debit,k10.Credit_Head as Credit,k10.type1,k10.Transaction_particulars,k10.Transaction_Amount from (select k9.*,case when (k9.Credit_head is not null and k9.Debit_head is null )or k9.Debit_head='Cash on hand' then k9.Account_No2 else (case when k9.Credit_head='Cash on hand' then '29000' else case when  k9.Debit_head is null and k9.Credit_head is not null then k9.Account_No end  end) end as Credit_Acc_No ,case when (k9.Debit_head is not null and k9.Credit_head is null) or k9.Credit_head='Cash on hand' then k9.Account_No2 else (case when k9.Debit_head='Cash on hand' then '29000' else case when  k9.Credit_head is null and k9.Debit_head is not null then k9.Account_No end  end) end as Debit_Acc_No from (select k8.Account_No ,k8.Voucher_Type,k8.Transaction_id,to_char(k8.Transaction_date,'dd/MM/yyyy') as trans_date,k8.Account_No2,case when k8.credithead is null then case when k8.cashcount=1 then 'Cash on hand' end else creditHead end as Credit_Head,case when k8.debithead is null then case when k8.cashcount=1 then 'Cash on hand' end else debitHead end as Debit_Head,GET_TRANS_TYPE(k8.Page_Source) as type1,k8.Transaction_Particulars,k8.Transaction_Amount from (select k7.Account_No,k7.Voucher_Type,k7.Transaction_id,k7.Transaction_date,k7.Account_No2,Case when k7.Credit!=0 then k7.GL_Name2 else null end as CreditHead,Case when k7.Debit!=0 then k7.GL_Name2 else null end as DebitHead,k7.Page_Source,k7.Transaction_Particulars,k7.Transaction_Amount,(select count(*) from Daily_Transaction where Transaction_id=k7.Transaction_id and Transaction_date=k7.Transaction_date and Account_No='29000') as cashcount from (select k5.*,k6.Voucher_Type  from (select k4.*,(Select gl_Name from gl_master where to_char(gl_master.GL_CODE)=k4.Account_No)as gl_Name2 from (select p.*,k3.Acc_GL,case when k3.Account_No1 is null  then p.Account_No else k3.Account_No1 end as Account_No2,case when k3.GL_Name is null and p.Account_No='29000' then 'Cash On Hand' else k3.GL_Name end as gl_name1 from (select Transaction_id,Transaction_date,Account_No,transaction_Type,case when transaction_type ='Credit' then Transaction_Amount else 0 end as Credit,case when transaction_type ='Debit' then Transaction_Amount else 0 end as Debit,page_source,Transaction_particulars,Transaction_Amount from daily_transaction where Flag='GL' and Transaction_Date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy'))p left join (select k2.Transaction_id,k2.Transaction_date,k2.Account_No as Account_No1,k2.Acc_GL,k2.GL_Name from(select k1.*,(select gl_Name from gl_master where gl_code=k1.Acc_GL)as gl_name  from (select k.*, case when k.flag='AC' then k.gl_general  else case when k.flag='INT' then k.gl_Int_Payable else case when k.flag='PEN' then k.gl_default_int_receivable else 10270 end end  end as Acc_GL from (select b.*,c.* from(select a.* ,(select scheme_code as sc from cust_acc_link where Account_No =a.Account_no)as sc  from (select Transaction_id,Transaction_date,Account_No,transaction_Type,case when transaction_type ='Credit' then Transaction_Amount else 0 end as Credit,case when transaction_type ='Debit' then Transaction_Amount else 0 end as Debit,page_source,Transaction_particulars,flag from daily_transaction where Flag!='GL' and Transaction_Date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy'))a)b left join (select gl_general, gl_Int_Payable,gl_default_int_receivable ,scheme_master.SCHEME_CODE from scheme_master)c on b.sc=c.scheme_code)k)k1)k2)k3 on p.Transaction_id=k3.Transaction_id and p.Transaction_date=k3.transaction_date and p.Account_No=k3.Acc_GL)k4)k5 left join (select Voucher_Type,Transaction_Id,Transaction_Date from Voucher_Print where Transaction_Date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy'))k6 on k5.Transaction_id=k6.Transaction_id and k5.Transaction_date=k6.Transaction_date)k7 where k7.Account_No !='29000')k8 order by k8.Transaction_date,k8.Transaction_id)k9)k10; 
		return template.query("select k10.Account_No as GL_Code,k10.Voucher_Type, k10.Transaction_id,k10.trans_date,k10.Debit_Acc_No,k10.Credit_Acc_No,k10.Debit_Head as Debit,k10.Credit_Head as Credit,k10.type1,k10.Transaction_particulars,k10.Transaction_Amount from (select k9.*,case when (k9.Credit_head is not null and k9.Debit_head is null )or k9.Debit_head='Cash on hand' then k9.Account_No2 else (case when k9.Credit_head='Cash on hand' then '29000' else case when  k9.Debit_head is null and k9.Credit_head is not null then k9.Account_No end  end) end as Credit_Acc_No ,case when (k9.Debit_head is not null and k9.Credit_head is null) or k9.Credit_head='Cash on hand' then k9.Account_No2 else (case when k9.Debit_head='Cash on hand' then '29000' else case when  k9.Credit_head is null and k9.Debit_head is not null then k9.Account_No end  end) end as Debit_Acc_No from (select k8.Account_No ,k8.Voucher_Type,k8.Transaction_id,to_char(k8.Transaction_date,'dd/MM/yyyy') as trans_date,k8.Account_No2,case when k8.credithead is null then case when k8.cashcount=1 then 'Cash on hand' end else creditHead end as Credit_Head,case when k8.debithead is null then case when k8.cashcount=1 then 'Cash on hand' end else debitHead end as Debit_Head,GET_TRANS_TYPE(k8.Page_Source) as type1,k8.Transaction_Particulars,k8.Transaction_Amount from (select k7.Account_No,k7.Voucher_Type,k7.Transaction_id,k7.Transaction_date,k7.Account_No2,Case when k7.Credit!=0 then k7.GL_Name2 else null end as CreditHead,Case when k7.Debit!=0 then k7.GL_Name2 else null end as DebitHead,k7.Page_Source,k7.Transaction_Particulars,k7.Transaction_Amount,(select count(*) from Daily_Transaction where Transaction_id=k7.Transaction_id and Transaction_date=k7.Transaction_date and Account_No='29000') as cashcount from (select k5.*,k6.Voucher_Type  from (select k4.*,(Select gl_Name from gl_master where to_char(gl_master.GL_CODE)=k4.Account_No)as gl_Name2 from (select p.*,k3.Acc_GL,case when k3.Account_No1 is null  then p.Account_No else k3.Account_No1 end as Account_No2,case when k3.GL_Name is null and p.Account_No='29000' then 'Cash On Hand' else k3.GL_Name end as gl_name1 from (select Transaction_id,Transaction_date,Account_No,transaction_Type,case when transaction_type ='Credit' then Transaction_Amount else 0 end as Credit,case when transaction_type ='Debit' then Transaction_Amount else 0 end as Debit,page_source,Transaction_particulars,Transaction_Amount from daily_transaction where Flag='GL' and Transaction_Date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy'))p left join (select k2.Transaction_id,k2.Transaction_date,k2.Account_No as Account_No1,k2.Acc_GL,k2.GL_Name from(select k1.*,(select gl_Name from gl_master where gl_code=k1.Acc_GL)as gl_name  from (select k.*, case when k.flag='AC' then k.gl_general  else case when k.flag='INT' then k.gl_Int_Payable else case when k.flag='PEN' then k.gl_default_int_receivable else 10270 end end  end as Acc_GL from (select b.*,c.* from(select a.* ,(select scheme_code as sc from cust_acc_link where Account_No =a.Account_no)as sc  from (select Transaction_id,Transaction_date,Account_No,transaction_Type,case when transaction_type ='Credit' then Transaction_Amount else 0 end as Credit,case when transaction_type ='Debit' then Transaction_Amount else 0 end as Debit,page_source,Transaction_particulars,flag from daily_transaction where Flag!='GL' and Transaction_Date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy'))a)b left join (select gl_general, gl_Int_Payable,gl_default_int_receivable ,scheme_master.SCHEME_CODE from scheme_master)c on b.sc=c.scheme_code)k)k1)k2)k3 on p.Transaction_id=k3.Transaction_id and p.Transaction_date=k3.transaction_date and p.Account_No=k3.Acc_GL)k4)k5 left join (select Voucher_Type,Transaction_Id,Transaction_Date from Voucher_Print where Transaction_Date between to_date('"+FromDate+"','dd/MM/yyyy') and to_date('"+ToDate+"','dd/MM/yyyy'))k6 on k5.Transaction_id=k6.Transaction_id and k5.Transaction_date=k6.Transaction_date)k7 where k7.Account_No !='29000')k8 order by k8.Transaction_date,k8.Transaction_id)k9)k10",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
		{  
					
							
					
			SimpleBranch gl=new SimpleBranch(); 
			
		
			gl.setS31(rs.getString(1));  //Authorized_By
			gl.setS32(rs.getString(2));  //Verified_By
			gl.setS33(rs.getString(3));  //Verified_By_3
			gl.setS34(rs.getString(4));  //Verified_By_4
			gl.setS2(rs.getString(5));  //Verified_By_5
			gl.setS35(rs.getString(6));  //Verified_By_5
						
			gl.setS36(rs.getString(7));  //Authorized_By
			gl.setS37(rs.getString(8));  //Verified_By
			
			gl.setS38(rs.getString(9));  //Verified_By_3
			gl.setS39(rs.getString(10));  //Verified_By_4
			gl.setS40(rs.getString(11));  //Verified_By_5
			
				
			return gl;
		}
		 }     );
	}
	
	
	
	
	
	public List<SimpleBranch> getGLCB(String Select_Date,int Account_Code,int Bcode){

		//--Set Connection----------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
		//-----------------------------------------------------
		return template.query("Select a.OB+b.Credit-c.Debit as CB from	(Select  case when Opening_Balance is NULL Then 0 else Opening_Balance End as OB from GL_Opening_Balance where OB_Date<=to_date('"+Select_Date+"','dd/MM/yyyy') and Account_Code='"+Account_Code+"' order by OB_Date desc) a,(Select case when sum(Transaction_Amount) is NULL Then 0 else sum(Transaction_Amount) End as Credit from Daily_Transaction where Transaction_Type='Credit' and Account_No='"+Account_Code+"' and Transaction_Date<=to_date('"+Select_Date+"','dd/MM/yyyy') and Transaction_Date>=(Select OB_Date from GL_Opening_Balance where Account_Code='"+Account_Code+"' and OB_Date<=to_date('"+Select_Date+"','dd/MM/yyyy'))) b,(Select case when sum(Transaction_Amount) is NULL Then 0 else sum(Transaction_Amount) End as Debit from Daily_Transaction where Transaction_Type='Debit' and Account_No='"+Account_Code+"' and Transaction_Date<=to_date('"+Select_Date+"','dd/MM/yyyy')  and Transaction_Date>=(Select OB_Date from GL_Opening_Balance where Account_Code='"+Account_Code+"' and OB_Date<=to_date('"+Select_Date+"','dd/MM/yyyy'))) c",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException{  
			
			SimpleBranch gl=new SimpleBranch();
			
			gl.setS151(rs.getDouble(1));   // Opening Balance
			
			return gl;
		}
					 }     );
				}
	
// 	General Ledger - GL Last few transactions
	
	public List<SimpleBranch> getGLLastFewTransactions(String From_Date,String To_Date,int Account_Code,int Bcode){

		//--Set Connection----------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
		//-----------------------------------------------------
		return template.query("Select * from(Select Transaction_Id,Transaction_Date,Transaction_Date as TDate,Account_No,Transaction_Amount as Credit,0 as Debit,Account_Desc as Transaction_Particulars,0.0 as CB,'' as CB2,Flag from Daily_Transaction where Transaction_Date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') and Account_No='"+Account_Code+"' and Transaction_Type='Credit' union Select Transaction_Id,Transaction_Date,Transaction_Date as TDate,Account_No,0 as Credit,Transaction_Amount as Debit,Account_Desc as Transaction_Particulars,0.0 as CB,'' as CB2,Flag from Daily_Transaction where Transaction_Date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') and Account_No='"+Account_Code+"' and Transaction_Type='Debit') GL_Tran order by TDate asc,to_number(substr(to_char(Transaction_Id),-5,5)) asc",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException{  
			
			SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
			
			SimpleBranch gl=new SimpleBranch();
			
			gl.setS41(rs.getInt(1));  	  // Transaction Id
			
			gl.setS31(sd.format(rs.getDate(2))); // Transaction Date
			gl.setS32(sd.format(rs.getDate(3))); // TDate
			
			gl.setS42(rs.getInt(4));   // Account No
			gl.setS51(rs.getFloat(5));   // Credit
			
			gl.setS52(rs.getFloat(6));   // Debit
			gl.setS33(rs.getString(7));   // Transaction Particulars
			gl.setS53(rs.getFloat(8));   // CB
			gl.setS54(rs.getFloat(9));   // CB2
			gl.setS34(rs.getString(10));   // Flag
			
					gl.setS161(rs.getDouble(5));   // Credit
				gl.setS162(rs.getDouble(6));   // Debit
			
		 	
			return gl;
		}
					 }     );
				}
	
	public String SubtractDays_ToDate(String Date1,int n) 
	{
		//--Set Connection------------------------------------
		int j=Binfo;
		this.template=con.getCon2(j);
		//-----------------------------------------------------
		//Changed query 28-01-2020
		
		/*String i=null;
		String qry="select to_char((to_date('"+Date1+"','dd/MM/yyyy')-"+n+"),'dd/MM/yyyy') from dual";
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
			pstmt = template.getDataSource().getConnection().prepareStatement("select to_char((to_date(?,'dd/MM/yyyy')-?),'dd/MM/yyyy') from dual");
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
	
	
	public List<SimpleBranch> getConsolidated_GST_Report(String From_Date,String To_Date,int Account_Code,int Bcode){

		//--Set Connection----------------------------
					int j=Binfo;
					this.template=con.getCon2(j);
		//-----------------------------------------------------
		return template.query("select rownum,(select branch_name from branch_master where to_char(branch_code)=a.branch) as bname,round(a.total_gst*100/2)/100 as cgst,round(a.total_gst*100/2)/100 as sgst ,a.total_gst from (select branch,sum(transaction_amount) as total_gst from daily_transaction_table where transaction_type='Credit' and Account_No='10271' and transaction_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') group by branch order by branch)a",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException{  
			
			SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
			
			SimpleBranch gl=new SimpleBranch();
			gl.setS1(rs.getInt(1));
			gl.setS31(rs.getString(2)); // branch
			gl.setS161(rs.getDouble(3));   // Cgst
		    gl.setS162(rs.getDouble(4));   // Sgst
		    gl.setS163(rs.getDouble(5));   // total
				
			
		 	
			return gl;
		}
					 }     );
				}
	
	
	public List<SimpleBranch>getAccountListSearch_Transaction_Log(String From_Date,String To_Date,String searchKey,String bname,int Bcode)
	{
		//--Set Connection------------------------------------
		int j=Bcode;
		this.template=con.getCon2(j);
		//-----------------------------------------------------

	 //String sql="select Customer_Id,Customer_Name,Account_No,To_Char(Open_Date,'dd/MM/yyyy'),Loan_Amount,Period_Days,Interest_Rate,Account_Status,branch,jltype from JL_Master_view where open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') and Scheme_Code in (Select Scheme_Code from Scheme_Master where Scheme_Category='JL')and (ACCOUNT_NO LIKE '%"+searchKey+"%' or CUSTOMER_ID LIKE '%"+searchKey+"%' or upper(CUSTOMER_NAME) like '%"+searchKey.toUpperCase()+"%') order by Account_No desc";
	 //String sql="select a.*,(select branch_name from branch_master where to_char(branch_code)=a.Branch)as branch2 from(select Customer_Id,Customer_Name,Account_No,To_Char(Open_Date,'dd/MM/yyyy'),Loan_Amount,Period_Days,Interest_Rate,Account_Status,branch,jltype from JL_Master_view where open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') and Scheme_Code in (Select Scheme_Code from Scheme_Master where Scheme_Category='JL')and (ACCOUNT_NO LIKE '%"+searchKey+"%' or CUSTOMER_ID LIKE '%"+searchKey+"%' or upper(CUSTOMER_NAME) like '%"+searchKey.toUpperCase()+"%') order by Account_No desc)a";
	// String sql="Select Transaction_Id,to_char(Transaction_Date,'dd/MM/yyyy') ,Created_By,Time_Info,Authorized_By,Authorized_Time,Verified_By,Verified_Time,Verified_By_3,Verified_3_Time,Verified_By_4,Verified_4_Time,Verified_By_5 ,Verified_5_Time From Daily_Transaction Where Part_Tran_Id=1 and Transaction_Date Between To_Date('"+From_Date+"','dd/MM/yyyy') And To_Date('"+To_Date+"','dd/MM/yyyy')";
		//String sql="Select Transaction_Id,to_char(Transaction_Date,'dd/MM/yyyy') ,Created_By,Time_Info,Authorized_By,Authorized_Time,Verified_By,Verified_Time,Verified_By_3,Verified_3_Time,Verified_By_4,Verified_4_Time,Verified_By_5 ,Verified_5_Time,'"+bname+"' From Daily_Transaction Where Part_Tran_Id=1 and Transaction_Date Between To_Date('"+From_Date+"','dd/MM/yyyy') And To_Date('"+To_Date+"','dd/MM/yyyy')";

		//23-07-2021 modified log
		String sql="Select Transaction_Id,to_char(Transaction_Date,'dd/MM/yyyy') ,Created_By,Time_Info,Authorized_By,Authorized_Time,Verified_By,Verified_Time,Verified_By_3,Verified_3_Time,Verified_By_4,Verified_4_Time,Verified_By_5 ,Verified_5_Time,'"+bname+"',modified_by,Time_Info,transaction_date,Account_Desc,transaction_amount From Daily_Transaction Where Part_Tran_Id=1 and Transaction_Date Between To_Date('"+From_Date+"','dd/MM/yyyy') And To_Date('"+To_Date+"','dd/MM/yyyy')";

	 System.out.println(sql);
		return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																				{  
		
			SimpleBranch gl=new SimpleBranch();
		   	gl.setS31(rs.getString(1));//ttransid
			gl.setS32(rs.getString(2));//date
			gl.setS33(rs.getString(3));//created
			gl.setS34(rs.getString(4));//time
			gl.setS35(rs.getString(5));//jltype
			gl.setS36(rs.getString(6));//jltype
			gl.setS37(rs.getString(7));//jltype
			gl.setS38(rs.getString(8));//jltype
			gl.setS39(rs.getString(9));//jltype
			gl.setS40(rs.getString(10));//jltype
			
			gl.setS2(rs.getString(11));//ttransid
			gl.setS3(rs.getString(12));//date
			gl.setS4(rs.getString(13));//created
			gl.setS5(rs.getString(14));//time
			gl.setS10(rs.getString(15));//bname
			
			//23-07-2021s
			gl.setS131(rs.getString(16));//bname
			gl.setS132(rs.getString(17));//bname
			
			//03-03-2022
			gl.setS16(rs.getDate(18));
			gl.setS133(rs.getString(19));//Particulars
			gl.setS141(rs.getDouble(20));//amount 
		return gl;
																				}
																			 }     );
	}

	public List<SimpleBranch>getAllAccountListSearch_Transaction_Log(String From_Date,String To_Date,String searchKey,int Bcode)
	{
		//--Set Connection------------------------------------
		
		
		int j=Binfo;
		this.template=con.getCon2(j);
		//-----------------------------------------------------

	 //String sql="select Customer_Id,Customer_Name,Account_No,To_Char(Open_Date,'dd/MM/yyyy'),Loan_Amount,Period_Days,Interest_Rate,Account_Status,branch,jltype from JL_Master_view where open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') and Scheme_Code in (Select Scheme_Code from Scheme_Master where Scheme_Category='JL')and (ACCOUNT_NO LIKE '%"+searchKey+"%' or CUSTOMER_ID LIKE '%"+searchKey+"%' or upper(CUSTOMER_NAME) like '%"+searchKey.toUpperCase()+"%') order by Account_No desc";
	 //String sql="select a.*,(select branch_name from branch_master where to_char(branch_code)=a.Branch)as branch2 from(select Customer_Id,Customer_Name,Account_No,To_Char(Open_Date,'dd/MM/yyyy'),Loan_Amount,Period_Days,Interest_Rate,Account_Status,branch,jltype from JL_Master_view where open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') and Scheme_Code in (Select Scheme_Code from Scheme_Master where Scheme_Category='JL')and (ACCOUNT_NO LIKE '%"+searchKey+"%' or CUSTOMER_ID LIKE '%"+searchKey+"%' or upper(CUSTOMER_NAME) like '%"+searchKey.toUpperCase()+"%') order by Account_No desc)a";
	 //String sql="select a.Transaction_Id,to_Date(a.Transaction_Date,'dd/MM/yyyy'),a.Created_By,a.Time_Info,a.Authorized_By,a.Authorized_Time,a.Verified_By,a.Verified_Time,a.Verified_By_3,a.Verified_3_Time,a.Verified_By_4,a.Verified_4_Time,a.Verified_By_5 ,a.Verified_5_Time,(select Branch_Name from Branch_Master where Branch_Code=a.Branch) as Branch,a.Account_Desc,a.transaction_Amount from (Select Transaction_Id,to_char(Transaction_Date,'dd/MM/yyyy') as Transaction_Date ,Created_By,Time_Info,Authorized_By,Authorized_Time,Verified_By,Verified_Time,Verified_By_3,Verified_3_Time,Verified_By_4,Verified_4_Time,Verified_By_5 ,Verified_5_Time,Branch,transaction_date as tdate,transaction_particulars,transaction_amount,Account_Desc From DAILY_TRANSACTION_LOG Where Part_Tran_Id=1 and Transaction_Date Between To_Date('"+From_Date+"','dd/MM/yyyy') And To_Date('"+To_Date+"','dd/MM/yyyy'))a";

	 //20/10/2022
	 String sql="select a.Transaction_Id,to_Date(a.Transaction_Date,'dd/MM/yyyy'),a.Created_By,a.Time_Info,a.Authorized_By,a.Authorized_Time,a.Verified_By,a.Verified_Time,a.Verified_By_3,a.Verified_3_Time,a.Verified_By_4,a.Verified_4_Time,a.Verified_By_5 ,a.Verified_5_Time,(select Branch_Name from Branch_Master where Branch_Code=a.Branch) as Branch,a.Account_Desc,a.transaction_Amount,case when (a.page_source='EOM' or b.voucher_type is null) THEN 'Adjustment' ELSE  case when a.page_source='SBP' then 'Payment' else b.voucher_type end end as voucher_type,case when a.page_source='EOM' THEN 'EOM Transacrion' else case when a.page_source='SBP' then 'SD Int Posting' else Case when b.mode1 is null then a.page_source else b.trfr_acc_type end end end as Mode1,b.trfr_acc_no,b.trfr_acc_type from (Select Transaction_Id,to_char(Transaction_Date,'dd/MM/yyyy') as Transaction_Date ,Created_By,Time_Info,Authorized_By,Authorized_Time,Verified_By,Verified_Time,Verified_By_3,Verified_3_Time,Verified_By_4,Verified_4_Time,Verified_By_5 ,Verified_5_Time,Branch,transaction_date as tdate,transaction_particulars,transaction_amount,Account_Desc,page_source From DAILY_TRANSACTION_LOG Where Part_Tran_Id=1 and Transaction_Date Between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') and to_char(Branch) like '"+Bcode+"%' order by branch,Transaction_Date desc,to_number(substr(to_char(Transaction_Id),-5,5)) desc)a   left join (select transaction_id,transaction_date,voucher_type,mode1,trfr_acc_no,trfr_acc_type from voucher_print_view )b on a.transaction_id=b.transaction_id and a.transaction_date=b.transaction_date ";

	 System.out.println(sql);
		return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																				{  
		
			SimpleBranch gl=new SimpleBranch();
		   	gl.setS31(rs.getString(1));//ttransid
		//	gl.setS32(rs.getString(2));//date
			gl.setS33(rs.getString(3));//created
			gl.setS34(rs.getString(4));//time
			gl.setS35(rs.getString(5));//jltype
			gl.setS36(rs.getString(6));//jltype
			gl.setS37(rs.getString(7));//jltype
			gl.setS38(rs.getString(8));//jltype
			gl.setS39(rs.getString(9));//jltype
			gl.setS40(rs.getString(10));//jltype
			
			gl.setS2(rs.getString(11));//ttransid
			gl.setS3(rs.getString(12));//date
			gl.setS4(rs.getString(13));//created
			gl.setS5(rs.getString(14));//time
			gl.setS10(rs.getString(15));//bname
			
			
			//03-03-2022
			gl.setS16(rs.getDate(2));
			gl.setS133(rs.getString(16));//Particulars
			gl.setS141(rs.getDouble(17));//amount 
			
			//17-10-2022
			gl.setS134(rs.getString(18));//Type
			gl.setS135(rs.getString(19));//Mode
		
			
		
		return gl;
																				}
																			 }     );
	}
	public List<SimpleBranch>getAccountListSearch_JLApproval_Log(String From_Date,String To_Date,String searchKey,int branch,int Bcode)
	{
		//--Set Connection------------------------------------
		int j=Bcode;
		this.template=con.getCon2(j);
		//-----------------------------------------------------

	 //String sql="select Customer_Id,Customer_Name,Account_No,To_Char(Open_Date,'dd/MM/yyyy'),Loan_Amount,Period_Days,Interest_Rate,Account_Status,branch,jltype from JL_Master_view where open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') and Scheme_Code in (Select Scheme_Code from Scheme_Master where Scheme_Category='JL')and (ACCOUNT_NO LIKE '%"+searchKey+"%' or CUSTOMER_ID LIKE '%"+searchKey+"%' or upper(CUSTOMER_NAME) like '%"+searchKey.toUpperCase()+"%') order by Account_No desc";
	 //String sql="select a.*,(select branch_name from branch_master where to_char(branch_code)=a.Branch)as branch2 from(select Customer_Id,Customer_Name,Account_No,To_Char(Open_Date,'dd/MM/yyyy'),Loan_Amount,Period_Days,Interest_Rate,Account_Status,branch,jltype from JL_Master_view where open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') and Scheme_Code in (Select Scheme_Code from Scheme_Master where Scheme_Category='JL')and (ACCOUNT_NO LIKE '%"+searchKey+"%' or CUSTOMER_ID LIKE '%"+searchKey+"%' or upper(CUSTOMER_NAME) like '%"+searchKey.toUpperCase()+"%') order by Account_No desc)a";
	 //String sql="Select Transaction_Id,to_char(Transaction_Date,'dd/MM/yyyy') ,Created_By,Time_Info,Authorized_By,Authorized_Time,Verified_By,Verified_Time,Verified_By_3,Verified_3_Time,Verified_By_4,Verified_4_Time,Verified_By_5 ,Verified_5_Time From Daily_Transaction Where Part_Tran_Id=1 and Transaction_Date Between To_Date('"+From_Date+"','dd/MM/yyyy') And To_Date('"+To_Date+"','dd/MM/yyyy')";
	String sql="select (select Branch_Name from Branch_Master where Branch_Code=bcode) as bname,Account_no,created_by,CREATED_TIME,MODIFIED_BY,MANAGER_TIME,CORP_APPROVED_BY,CORP_TIME,FINAL_APPROVED_BY,FINAL_TIME,bcode,CORP_APPROVED2_BY,CORP2_Time  from jl_approval_status where modified_date Between To_Date('"+From_Date+"','dd/MM/yyyy') And To_Date('"+To_Date+"','dd/MM/yyyy') and bcode='"+branch+"' ORDER BY bcode,modified_date";
	 System.out.println(sql);
		return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																				{  
		
			SimpleBranch gl=new SimpleBranch();
		   	gl.setS31(rs.getString(1));//ttransid
			gl.setS32(rs.getString(2));//date
			gl.setS33(rs.getString(3));//created
			gl.setS34(rs.getString(4));//time
			gl.setS35(rs.getString(5));//jltype
			gl.setS36(rs.getString(6));//jltype
			gl.setS37(rs.getString(7));//jltype
			gl.setS38(rs.getString(8));//jltype
			gl.setS39(rs.getString(9));//jltype
			gl.setS40(rs.getString(10));//jltype
			gl.setS10(rs.getString(12));//jltype
			gl.setS111(rs.getString(13));//jltype

		
		return gl;
																				}
																			 }     );
	}

	public List<SimpleBranch>getAllAccountListSearch_JLApproval_Log(String From_Date,String To_Date,String searchKey,int Bcode)
	{
		//--Set Connection------------------------------------
		int j=Bcode;
		this.template=con.getCon2(j);
		//-----------------------------------------------------

	 //String sql="select Customer_Id,Customer_Name,Account_No,To_Char(Open_Date,'dd/MM/yyyy'),Loan_Amount,Period_Days,Interest_Rate,Account_Status,branch,jltype from JL_Master_view where open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') and Scheme_Code in (Select Scheme_Code from Scheme_Master where Scheme_Category='JL')and (ACCOUNT_NO LIKE '%"+searchKey+"%' or CUSTOMER_ID LIKE '%"+searchKey+"%' or upper(CUSTOMER_NAME) like '%"+searchKey.toUpperCase()+"%') order by Account_No desc";
	 //String sql="select a.*,(select branch_name from branch_master where to_char(branch_code)=a.Branch)as branch2 from(select Customer_Id,Customer_Name,Account_No,To_Char(Open_Date,'dd/MM/yyyy'),Loan_Amount,Period_Days,Interest_Rate,Account_Status,branch,jltype from JL_Master_view where open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') and Scheme_Code in (Select Scheme_Code from Scheme_Master where Scheme_Category='JL')and (ACCOUNT_NO LIKE '%"+searchKey+"%' or CUSTOMER_ID LIKE '%"+searchKey+"%' or upper(CUSTOMER_NAME) like '%"+searchKey.toUpperCase()+"%') order by Account_No desc)a";
	 //String sql="Select Transaction_Id,to_char(Transaction_Date,'dd/MM/yyyy') ,Created_By,Time_Info,Authorized_By,Authorized_Time,Verified_By,Verified_Time,Verified_By_3,Verified_3_Time,Verified_By_4,Verified_4_Time,Verified_By_5 ,Verified_5_Time From Daily_Transaction Where Part_Tran_Id=1 and Transaction_Date Between To_Date('"+From_Date+"','dd/MM/yyyy') And To_Date('"+To_Date+"','dd/MM/yyyy')";
	String sql="select (select Branch_Name from Branch_Master where Branch_Code=bcode) as bname,Account_no,created_by,CREATED_TIME,MODIFIED_BY,MANAGER_TIME,CORP_APPROVED_BY,CORP_TIME,FINAL_APPROVED_BY,FINAL_TIME,bcode,CORP_APPROVED2_BY,CORP2_Time  from jl_approval_status where modified_date Between To_Date('"+From_Date+"','dd/MM/yyyy') And To_Date('"+To_Date+"','dd/MM/yyyy') ORDER BY bcode,modified_date";
	 System.out.println(sql);
		return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																				{  
		
			SimpleBranch gl=new SimpleBranch();
		   	gl.setS31(rs.getString(1));//ttransid
			gl.setS32(rs.getString(2));//date
			gl.setS33(rs.getString(3));//created
			gl.setS34(rs.getString(4));//time
			gl.setS35(rs.getString(5));//jltype
			gl.setS36(rs.getString(6));//jltype
			gl.setS37(rs.getString(7));//jltype
			gl.setS38(rs.getString(8));//jltype
			gl.setS39(rs.getString(9));//jltype
			gl.setS40(rs.getString(10));//jltype
			gl.setS10(rs.getString(12));//jltype
			gl.setS111(rs.getString(13));//jltype
		
		return gl;
																				}
																			 }     );
	}

	
	public List<SimpleBranch>getAccountListSearch_DLApproval_Log(String From_Date,String To_Date,String searchKey,int branch,int Bcode)
	{
		//--Set Connection------------------------------------
		int j=Bcode;
		this.template=con.getCon2(j);
		//-----------------------------------------------------


	String sql="select (select Branch_Name from Branch_Master where Branch_Code=bcode) as bname,Account_no,created_by,Created_Date,MODIFIED_BY,Modify_Date,CORP_APPROVED_BY,Corp_Date,FINAL_APPROVED_BY,Final_Date,bcode  from loan_approval_status where modified_date Between To_Date('"+From_Date+"','dd/MM/yyyy') And To_Date('"+To_Date+"','dd/MM/yyyy') and bcode='"+branch+"' ORDER BY bcode,modified_date";
	 System.out.println(sql);
		return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																				{  
		
			SimpleBranch gl=new SimpleBranch();
		   	gl.setS31(rs.getString(1));//ttransid
			gl.setS32(rs.getString(2));//date
			gl.setS33(rs.getString(3));//created
			gl.setS34(rs.getString(4));//time
			gl.setS35(rs.getString(5));//jltype
			gl.setS36(rs.getString(6));//jltype
			gl.setS37(rs.getString(7));//jltype
			gl.setS38(rs.getString(8));//jltype
			gl.setS39(rs.getString(9));//jltype
			gl.setS40(rs.getString(10));//jltype
			
		
		return gl;
																				}
																			 }     );
	}


	public List<SimpleBranch>getAllAccountListSearch_DLApproval_Log(String From_Date,String To_Date,String searchKey,int Bcode)
	{
		//--Set Connection------------------------------------
		int j=Bcode;
		this.template=con.getCon2(j);
		//-----------------------------------------------------

	
	String sql="select (select Branch_Name from Branch_Master where Branch_Code=bcode) as bname,Account_no,created_by,Created_Date,MODIFIED_BY,Modify_Date,CORP_APPROVED_BY,Corp_Date,FINAL_APPROVED_BY,Final_Date,bcode  from loan_approval_status where modified_date Between To_Date('"+From_Date+"','dd/MM/yyyy') And To_Date('"+To_Date+"','dd/MM/yyyy') ORDER BY bcode,modified_date";
	 System.out.println(sql);
		return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																				{  
		
			SimpleBranch gl=new SimpleBranch();
		   	gl.setS31(rs.getString(1));//ttransid
			gl.setS32(rs.getString(2));//date
			gl.setS33(rs.getString(3));//created
			gl.setS34(rs.getString(4));//time
			gl.setS35(rs.getString(5));//jltype
			gl.setS36(rs.getString(6));//jltype
			gl.setS37(rs.getString(7));//jltype
			gl.setS38(rs.getString(8));//jltype
			gl.setS39(rs.getString(9));//jltype
			gl.setS40(rs.getString(10));//jltype
			
		
		return gl;
																				}
																			 }     );
	}
	

	
	public List<SimpleBranch>getCustomerApproval_Log(String From_Date,String To_Date,String branch_name,int Bcode)
	{
		//--Set Connection------------------------------------
		int j=Bcode;
		this.template=con.getCon2(j);
		//-----------------------------------------------------

	
	String sql="select Branch_Code,'"+branch_name+"',Customer_Id,Customer_Name,Created_By,C_Date,MODIFIED_By,M_Date,V_By,V_Date from Customer where created_date Between To_Date('"+From_Date+"','dd/MM/yyyy') And To_Date('"+To_Date+"','dd/MM/yyyy') and BRANCH_CODE='"+Bcode+"' order by Customer_Id,C_Date,BRANCH_CODE";
	 System.out.println(sql);
		return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																				{  
		
			SimpleBranch gl=new SimpleBranch();
		   	gl.setS31(rs.getString(1));//bcode
			gl.setS32(rs.getString(2));//bname
			gl.setS33(rs.getString(3));//cusid
			gl.setS34(rs.getString(4));//cusname
			gl.setS35(rs.getString(5));//createdby
			gl.setS36(rs.getString(6));//cdate
			gl.setS37(rs.getString(7));//modify by
			gl.setS38(rs.getString(8));//mdate
			gl.setS39(rs.getString(9));//vby
			gl.setS40(rs.getString(10));//vdate
			
		
		return gl;
																				}
																			 }     );
	}


	
	public List<SimpleBranch>getAllCustomerApproval_Log(String From_Date,String To_Date,int Bcode)
	{
		//--Set Connection------------------------------------
		int j=Bcode;
		this.template=con.getCon2(j);
		//-----------------------------------------------------

	
	String sql="select * from CUSTOMER_LOG_VIEW where created_date Between To_Date('"+From_Date+"','dd/MM/yyyy') And To_Date('"+To_Date+"','dd/MM/yyyy') order by Customer_Id,C_Date,BRANCH_CODE";
	 System.out.println(sql);
		return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																				{  
		
			SimpleBranch gl=new SimpleBranch();
		   	gl.setS31(rs.getString(1));//bcode
			gl.setS32(rs.getString(2));//bname
			gl.setS33(rs.getString(3));//cusid
			gl.setS34(rs.getString(4));//cusname
			gl.setS35(rs.getString(5));//createdby
			gl.setS36(rs.getString(6));//cdate
			gl.setS37(rs.getString(7));//modify by
			gl.setS38(rs.getString(8));//mdate
			gl.setS39(rs.getString(9));//vby
			gl.setS40(rs.getString(10));//vdate
			
		
		return gl;
																				}
																			 }     );
	}
	
	//24-07-2021
	public List<SimpleBranch>getAllAccountListSearch_Deleted_Log(String From_Date,String To_Date,String searchKey,int Bcode)
	{
		//--Set Connection------------------------------------
		
		
		int j=Binfo;
		this.template=con.getCon2(j);
		//-----------------------------------------------------

	 String sql="select a.Transaction_Id,a.Transaction_Date,a.Created_By,a.Deleted_By ,a.Deleted_Time,(select Branch_Name from Branch_Master where Branch_Code=a.Branch) as Branch,a.Deleted_Date,a.Account_Desc,a.Transaction_amount from (Select Transaction_Id,Transaction_Date,Created_By,Deleted_By ,Deleted_Time,Branch ,Deleted_Date,Account_Desc,Transaction_amount From Deleted_TRANSACTION_LOG Where Part_Tran_Id=1 and Transaction_Date Between To_Date('"+From_Date+"','dd/MM/yyyy') And To_Date('"+To_Date+"','dd/MM/yyyy'))a";

	 System.out.println(sql);
		return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																				{  
		
			SimpleBranch gl=new SimpleBranch();
		gl.setS31(rs.getString(1));//ttransid
		gl.setS25(rs.getDate(2));//date
		gl.setS33(rs.getString(3));//created
		gl.setS34(rs.getString(4));//time
		gl.setS35(rs.getString(5));//jltype
		gl.setS36(rs.getString(6));//jltype
		gl.setS26(rs.getDate(7));//jltype
		gl.setS32(rs.getString(8)); // account desc
		gl.setS141(rs.getDouble(9)); // transaction amount
			
		
		return gl;
																				}
																			 }     );
	}

	
	public List<SimpleBranch>getAccountListSearch_Deleted_Log(String From_Date,String To_Date,String searchKey,String bname,int Bcode)
	{
		//--Set Connection------------------------------------
		int j=Bcode;
		this.template=con.getCon2(j);
		//-----------------------------------------------------

	 //String sql="select Customer_Id,Customer_Name,Account_No,To_Char(Open_Date,'dd/MM/yyyy'),Loan_Amount,Period_Days,Interest_Rate,Account_Status,branch,jltype from JL_Master_view where open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') and Scheme_Code in (Select Scheme_Code from Scheme_Master where Scheme_Category='JL')and (ACCOUNT_NO LIKE '%"+searchKey+"%' or CUSTOMER_ID LIKE '%"+searchKey+"%' or upper(CUSTOMER_NAME) like '%"+searchKey.toUpperCase()+"%') order by Account_No desc";
	 //String sql="select a.*,(select branch_name from branch_master where to_char(branch_code)=a.Branch)as branch2 from(select Customer_Id,Customer_Name,Account_No,To_Char(Open_Date,'dd/MM/yyyy'),Loan_Amount,Period_Days,Interest_Rate,Account_Status,branch,jltype from JL_Master_view where open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') and Scheme_Code in (Select Scheme_Code from Scheme_Master where Scheme_Category='JL')and (ACCOUNT_NO LIKE '%"+searchKey+"%' or CUSTOMER_ID LIKE '%"+searchKey+"%' or upper(CUSTOMER_NAME) like '%"+searchKey.toUpperCase()+"%') order by Account_No desc)a";
	// String sql="Select Transaction_Id,to_char(Transaction_Date,'dd/MM/yyyy') ,Created_By,Time_Info,Authorized_By,Authorized_Time,Verified_By,Verified_Time,Verified_By_3,Verified_3_Time,Verified_By_4,Verified_4_Time,Verified_By_5 ,Verified_5_Time From Daily_Transaction Where Part_Tran_Id=1 and Transaction_Date Between To_Date('"+From_Date+"','dd/MM/yyyy') And To_Date('"+To_Date+"','dd/MM/yyyy')";
		//String sql="Select Transaction_Id,to_char(Transaction_Date,'dd/MM/yyyy') ,Created_By,Time_Info,Authorized_By,Authorized_Time,Verified_By,Verified_Time,Verified_By_3,Verified_3_Time,Verified_By_4,Verified_4_Time,Verified_By_5 ,Verified_5_Time,'"+bname+"' From Daily_Transaction Where Part_Tran_Id=1 and Transaction_Date Between To_Date('"+From_Date+"','dd/MM/yyyy') And To_Date('"+To_Date+"','dd/MM/yyyy')";

		//24-07-2021 deleted
		String sql="Select Transaction_Id,Transaction_Date ,Created_By,Deleted_By ,Deleted_Time,'"+bname+"',Deleted_Date,Account_Desc,TRansaction_Amount From Deleted_Transaction Where Part_Tran_Id=1 and Transaction_Date Between To_Date('"+From_Date+"','dd/MM/yyyy') And To_Date('"+To_Date+"','dd/MM/yyyy')";
        System.out.println(sql);
		return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																				{  
		
			SimpleBranch gl=new SimpleBranch();
		   	gl.setS31(rs.getString(1));//ttransid
			gl.setS25(rs.getDate(2));//date
			gl.setS33(rs.getString(3));//created
			gl.setS34(rs.getString(4));//time
			gl.setS35(rs.getString(5));//jltype
			gl.setS36(rs.getString(6));//jltype
			gl.setS26(rs.getDate(7));//jltype
			gl.setS32(rs.getString(8)); // account desc
			gl.setS141(rs.getDouble(9)); // transaction amount

					return gl;
																				}
																			 }     );
	}

	public List<SimpleBranch> getStaffAttendanceDetailsList_emp_id(int rno,String Current,int BCode){
		//--Set Connection----------------------------
				int j=201;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				String qry="select main_qry.* from (select rownum as rno,a.*,b.FN_Time,b.type,b.REMARKS from(select EMPID,EMPNAME,DBCODE,STATUS,DESIGNATION from employee_Master where dbcode='"+BCode+"' order by EmpId)a left join (select emp_id,att_date,type,FN_Time,staff_attendance.REMARKS from staff_attendance )b on a.empid=b.emp_id and  b.att_date=to_date('"+Current+"','dd/MM/yyyy'))main_qry where main_qry.rno="+rno+"";
	System.out.println(qry);
		return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
		{  

			SimpleBranch gl=new SimpleBranch();
			gl.setS2(rs.getString(2));       //
			gl.setS3(rs.getString(3));
			gl.setS10(rs.getString(7));
			gl.setS4(rs.getString(8));
			gl.setS5(rs.getString(9));
			gl.setS1(rs.getInt(1));
			
			System.out.println("S10="+rs.getString(1));
			System.out.println("S10="+rs.getString(2));
			System.out.println("S10="+rs.getString(3));
			System.out.println("S10="+rs.getString(4));
			System.out.println("S10="+rs.getString(5));
			System.out.println("S10="+rs.getString(6));
			System.out.println("S10="+rs.getString(7));
			System.out.println("S10="+rs.getString(8));
			System.out.println("S10="+rs.getString(9));
		
		  
		
							
			return gl;
		}
		 }     );
	}

	public int saveStaff_Attendance_AN(String EmpId,String Current,String type,String FN_Time,String AN_Time, int DBCode,String Created_By,String Remarks,String Branch_Approval)
	{
		//--Set Connection----------------------------
		int j=DBCode;
		this.template=con.getCon2(j);
	//-----------------------------------------------------
			
		String sql="insert into Staff_Attendance(EMP_ID,ATT_DATE,AN_TYPE,AN_TIME,BCODE,AN_CREATED_BY,An_branch_status,AN_created_time,AN_Remarks)values('"+EmpId+"',to_date('"+Current+"','dd/MM/yyyy'),'"+type+"','"+AN_Time+"',"+DBCode+",'"+Created_By+"','"+Branch_Approval+"',to_char(sysdate,'DD/MM/YYYY HH:MI:SS'),'"+Remarks+"')";
	System.out.println(sql);
		return template.update(sql);
	}

	public int getAN_Present(String emp_id,String Current,int Bcode) {
		//--Set Connection------------------------------------
		int j=Bcode;
		this.template=con.getCon2(j);
		//-----------------------------------------------------
		int i=1;
		String query = "select Case when AN_Time is null then 0 else 1 end as An_Status from Staff_Attendance where emp_id='"+emp_id+"' and  att_date=to_date('"+Current+"','dd/MM/yyyy')";
		System.out.println("cccccccccccccccccccccccccccccccccccc"+query);
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

	public int getFN_Present(String emp_id,String Current,int Bcode) {
		//--Set Connection------------------------------------
		int j=Bcode;
		this.template=con.getCon2(j);
		//-----------------------------------------------------
		int i=1;
		String query = "select Case when FN_Time is null then 0 else 1 end as Fn_Status from Staff_Attendance where emp_id='"+emp_id+"' and  att_date=to_date('"+Current+"','dd/MM/yyyy')";
		System.out.println("cccccccccccccccccccccccccccccccccccc"+Current);
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
	 
	public int Update_Staff_Attendance_AN(String empid,String Current,String AN_Type, String createTime2,int DBCode,String AN_Created_By,String AN_Remarks,String AN_Branch_Status)
	{
		//--Set Connection----------------------------
		int j=DBCode;
		this.template=con.getCon2(j);
	//-----------------------------------------------------
			String sql="update staff_attendance set AN_branch_status='"+AN_Branch_Status+"',AN_Time='"+createTime2+"',AN_Type='"+AN_Type+"',AN_Created_By='"+AN_Created_By+"',AN_Remarks='"+AN_Remarks+"' where bcode="+DBCode+" and att_date=to_date('"+Current+"','dd/MM/yyyy') and emp_id='"+empid+"'";
		
		return template.update(sql);
	}
	public int Update_Staff_Attendance_FN(String empid,String Current,String AN_Type, String createTime2,int DBCode,String AN_Created_By,String AN_Remarks,String AN_Branch_Status)
	{
		//--Set Connection----------------------------
		int j=DBCode;
		this.template=con.getCon2(j);
	//-----------------------------------------------------
			String sql="update staff_attendance set FN_branch_status='"+AN_Branch_Status+"',FN_Time='"+createTime2+"',Type='"+AN_Type+"',Created_By='"+AN_Created_By+"',Remarks='"+AN_Remarks+"' where bcode="+DBCode+" and att_date=to_date('"+Current+"','dd/MM/yyyy') and emp_id='"+empid+"'";
		System.out.println(sql);
		return template.update(sql);
	}


	public List<SimpleBranch> getStaffAttendanceDetailsList_emp_id_FN(String empid,String Current,int BCode){
		//--Set Connection----------------------------
				int j=201;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				String qry="select main_qry.* from (select rownum as rno,a.*,b.FN_Time,b.type,b.REMARKS from(select EMPID,EMPNAME,DBCODE,STATUS,DESIGNATION from employee_Master where dbcode='"+BCode+"' order by EmpId)a left join (select emp_id,att_date,type,FN_Time,staff_attendance.REMARKS from staff_attendance )b on a.empid=b.emp_id and  b.att_date=to_date('"+Current+"','dd/MM/yyyy'))main_qry where main_qry.empid="+empid+"";
	System.out.println(qry);
		return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
		{  

			SimpleBranch gl=new SimpleBranch();
			gl.setS2(rs.getString(2));       //
			gl.setS3(rs.getString(3));
			gl.setS10(rs.getString(7));
			gl.setS4(rs.getString(8));
			gl.setS5(rs.getString(9));
			gl.setS1(rs.getInt(1));
			
			System.out.println("S10="+rs.getString(1));
			System.out.println("S10="+rs.getString(2));
			System.out.println("S10="+rs.getString(3));
			System.out.println("S10="+rs.getString(4));
			System.out.println("S10="+rs.getString(5));
			System.out.println("S10="+rs.getString(6));
			System.out.println("S10="+rs.getString(7));
			System.out.println("S10="+rs.getString(8));
			System.out.println("S10="+rs.getString(9));
		
		  
		
							
			return gl;
		}
		 }     );
	}

	public List<SimpleBranch> getStaffAttendanceDetailsList_emp_id_AN(String empid,String Current,int BCode){
		//--Set Connection----------------------------
				int j=201;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				String qry="select main_qry.* from (select rownum as rno,a.*,b.AN_Time,b.AN_type,b.AN_REMARKS from(select EMPID,EMPNAME,DBCODE,STATUS,DESIGNATION from employee_Master where dbcode='"+BCode+"' order by EmpId)a left join (select emp_id,att_date,AN_type,AN_Time,AN_REMARKS from staff_attendance )b on a.empid=b.emp_id and  b.att_date=to_date('"+Current+"','dd/MM/yyyy'))main_qry where main_qry.empid="+empid+"";
	System.out.println(qry);
		return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
		{  

			SimpleBranch gl=new SimpleBranch();
			gl.setS2(rs.getString(2));       //
			gl.setS3(rs.getString(3));
			gl.setS10(rs.getString(7));
			gl.setS4(rs.getString(8));
			gl.setS5(rs.getString(9));
			gl.setS1(rs.getInt(1));
			
			System.out.println("S10="+rs.getString(1));
			System.out.println("S10="+rs.getString(2));
			System.out.println("S10="+rs.getString(3));
			System.out.println("S10="+rs.getString(4));
			System.out.println("S10="+rs.getString(5));
			System.out.println("S10="+rs.getString(6));
			System.out.println("S10="+rs.getString(7));
			System.out.println("S10="+rs.getString(8));
			System.out.println("S10="+rs.getString(9));
		
		  
		
							
			return gl;
		}
		 }     );
	}

	public List<SimpleBranch> getEmployeeDetailsList_Branch_FN( String Current,int BCode){
		//--Set Connection----------------------------
				int j=201;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				String qry="select rownum,a.*,b.FN_Time,b.type,b.REMARKS,b.FN_Branch_status,b.att_date from(select EMPID,EMPNAME,DBCODE,STATUS,DESIGNATION from employee_Master where dbcode like'"+BCode+"%' and Attendance_status !='Y' order by EmpId)a left join (select emp_id,to_char(att_date,'dd-MM-yyyy') as att_date,type,FN_Time,Remarks,FN_Branch_status from staff_attendance )b on a.empid=b.emp_id and  b.att_date=to_date('"+Current+"','dd/MM/yyyy')";
		return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
		{  
			SimpleBranch gl=new SimpleBranch();
			gl.setS1(rs.getInt(1));  
			gl.setS2(rs.getString(2));       //
			gl.setS3(rs.getString(3));
			gl.setS10(rs.getString(6));
			gl.setS4(rs.getString(11));
			gl.setS31(rs.getString(7));
			//gl.setS6(rs.getString(8));
			//gl.setS5(rs.getString(9));
			gl.setS32(rs.getString(8));
			gl.setS33(rs.getString(10));
			gl.setS34(rs.getString(9));
			
			
			
		  
							
			return gl;
		}
		 }     );
	}

	public List<SimpleBranch> getEmployeeDetailsList_Branch_AN( String Current,int BCode){
		//--Set Connection----------------------------
				int j=201;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				String qry="select rownum,a.*,b.AN_Time,b.AN_type,b.AN_REMARKS,b.AN_Branch_status ,b.att_date from(select EMPID,EMPNAME,DBCODE,STATUS,DESIGNATION from employee_Master where dbcode like'"+BCode+"%' and Attendance_status !='Y' order by EmpId)a left join (select emp_id,to_char(att_date,'dd-MM-yyyy') as att_date,AN_type,AN_Time,AN_Remarks,AN_Branch_status from staff_attendance )b on a.empid=b.emp_id and  b.att_date=to_date('"+Current+"','dd/MM/yyyy')";
		return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
		{  
			SimpleBranch gl=new SimpleBranch();
			gl.setS1(rs.getInt(1));  
			gl.setS2(rs.getString(2));       //
			gl.setS3(rs.getString(3));
			gl.setS10(rs.getString(6));
			gl.setS4(rs.getString(11));
			gl.setS31(rs.getString(7));
			//gl.setS6(rs.getString(8));
			//gl.setS5(rs.getString(9));
			gl.setS32(rs.getString(8));
			gl.setS33(rs.getString(10));
			gl.setS34(rs.getString(9));
			
			
			
		  
							
			return gl;
		}
		 }     );
	}

	public List<SimpleBranch> getStaffAttendanceDetailsList_emp_id_AN(int rno,String Current,int BCode){
		//--Set Connection----------------------------
				int j=201;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				String qry="select main_qry.* from (select rownum as rno,a.*,b.AN_Time,b.AN_type,b.AN_REMARKS from(select EMPID,EMPNAME,DBCODE,STATUS,DESIGNATION from employee_Master where dbcode='"+BCode+"' order by EmpId)a left join (select emp_id,att_date,AN_type,AN_Time,AN_REMARKS from staff_attendance )b on a.empid=b.emp_id and  b.att_date=to_date('"+Current+"','dd/MM/yyyy'))main_qry where main_qry.rno="+rno+"";
	System.out.println(qry);
		return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
		{  

			SimpleBranch gl=new SimpleBranch();
			gl.setS2(rs.getString(2));       //
			gl.setS3(rs.getString(3));
			gl.setS10(rs.getString(7));
			gl.setS4(rs.getString(8));
			gl.setS5(rs.getString(9));
			gl.setS1(rs.getInt(1));
			
			System.out.println("S10="+rs.getString(1));
			System.out.println("S10="+rs.getString(2));
			System.out.println("S10="+rs.getString(3));
			System.out.println("S10="+rs.getString(4));
			System.out.println("S10="+rs.getString(5));
			System.out.println("S10="+rs.getString(6));
			System.out.println("S10="+rs.getString(7));
			System.out.println("S10="+rs.getString(8));
			System.out.println("S10="+rs.getString(9));
		
		  
		
							
			return gl;
		}
		 }     );
	}



	public int getAttendanceCheck_User_FN(String Current,String user,int Bcode) {
		//--Set Connection------------------------------------
		int j=201;
		this.template=con.getCon2(j);
		//-----------------------------------------------------
		int i=0;
		String query = "select count(*) from staff_attendance where Att_date=to_date('"+Current+"','dd/MM/yyyy') and emp_id in (select emp_id from login_details where username='"+user+"') and FN_branch_status='Y' ";
		System.out.println("cccccccccccccccccccccccccccccccccccc"+query);
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
					  System.out.println("ccc="+i);
				  }
			}
			//i=resultSet.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return i;
	} 

	public int getAttendanceCheck_User_AN(String Current,String user,int Bcode) {
		//--Set Connection------------------------------------
		int j=201;
		this.template=con.getCon2(j);
		//-----------------------------------------------------
		int i=0;
		String query = "select count(*) from staff_attendance where Att_date=to_date('"+Current+"','dd/MM/yyyy') and emp_id in (select emp_id from login_details where username='"+user+"') and AN_branch_status='Y' ";
		System.out.println("cccccccccccccccccccccccccccccccccccc"+query);
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
					  System.out.println("ccc="+i);
				  }
			}
			//i=resultSet.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return i;
	} 


	public String getLogin_FN_Time() {
		//--Set Connection------------------------------------
		int j=201;
		this.template=con.getCon2(j);
		//-----------------------------------------------------
		String i="";
		String query = "Select FN_Time from general_settings";
		System.out.println("cccccccccccccccccccccccccccccccccccc"+query);
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
					  System.out.println("ccc="+i);
				  }
			}
			//i=resultSet.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return i;
	} 

	public String getLogin_AN_Time() {
		//--Set Connection------------------------------------
		int j=201;
		this.template=con.getCon2(j);
		//-----------------------------------------------------
		String i="";
		String query = "Select AN_Time from general_settings";
		System.out.println("cccccccccccccccccccccccccccccccccccc"+query);
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
					  System.out.println("ccc="+i);
				  }
			}
			//i=resultSet.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return i;
	} 
	public int Update_Staff_AttendanceUNLOCK_FN(String empid,String Current, int DBCode,String user,String Status)
	{
		//--Set Connection----------------------------
		int j=201;
		this.template=con.getCon2(j);
	//-----------------------------------------------------
			String sql="update staff_attendance set Type='"+Status+"',FN_branch_status='Y',unlocked_by='"+user+"',unlock_time_info=to_char(sysdate,'DD/MM/YYYY HH:MI:SS') where emp_id='"+empid+"'  and att_date=to_date('"+Current+"','dd/MM/yyyy')";
					return template.update(sql);
	}
	public int Update_Staff_AttendanceUNLOCK_AN(String empid,String Current, int DBCode,String user,String Status)
	{
		//--Set Connection----------------------------
		int j=201;
		this.template=con.getCon2(j);
	//-----------------------------------------------------
			String sql="update staff_attendance set AN_Type='"+Status+"',AN_branch_status='Y',unlocked_by='"+user+"',unlock_time_info=to_char(sysdate,'DD/MM/YYYY HH:MI:SS') where emp_id='"+empid+"' and att_date=to_date('"+Current+"','dd/MM/yyyy')";
					return template.update(sql);
	}
	
	
	public int Update_Staff_AttendanceLOCK_FN(String empid,String Current, int DBCode,String user)
	{
		//--Set Connection----------------------------
		int j=201;
		this.template=con.getCon2(j);
	//-----------------------------------------------------
			String sql="update staff_attendance set FN_branch_status='N',unlocked_by='"+user+"',unlock_time_info=to_char(sysdate,'DD/MM/YYYY HH:MI:SS') where emp_id='"+empid+"' and att_date=to_date('"+Current+"','dd/MM/yyyy')";
					return template.update(sql);
	}
	public int Update_Staff_AttendanceLOCK_AN(String empid,String Current, int DBCode,String user)
	{
		//--Set Connection----------------------------
		int j=201;
		this.template=con.getCon2(j);
	//-----------------------------------------------------
			String sql="update staff_attendance set AN_branch_status='N',unlocked_by='"+user+"',unlock_time_info=to_char(sysdate,'DD/MM/YYYY HH:MI:SS') where emp_id='"+empid+"' and att_date=to_date('"+Current+"','dd/MM/yyyy')";
					return template.update(sql);
	}
	
	
	public int Update_Staff_AttendanceTime_FN(String Current1,String Current2)
	{
		//--Set Connection----------------------------
		int j=201;
		this.template=con.getCon2(j);
	//-----------------------------------------------------
			String sql="update general_settings set FN_Time='"+Current1+"',AN_Time='"+Current2+"'";
					return template.update(sql);
	}
	
	
	
	
	
	public List<SimpleBranch> getEmployeeDetailsList_Branch_FN_UnLock( String Current,String value,int BCode){
		//--Set Connection----------------------------
				int j=201;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				String qry="select rownum,main_qry.*,(select branch_name from branch_master where branch_code=main_qry.DBCODE) as bname from (select a.*,b.FN_Time,b.type,b.REMARKS,b.FN_Branch_status,b.att_date,b.FN_Late from(select EMPID,EMPNAME,DBCODE,STATUS,DESIGNATION from employee_Master where dbcode like'"+BCode+"%' and (empid like '%"+value+"%' or empname like '%"+value+"%') order by EmpId)a left join (select emp_id,to_char(att_date,'dd-MM-yyyy') as att_date,type,FN_Time,Remarks,FN_Branch_status,FN_Late from staff_attendance where  FN_Branch_Status='N')b on b.emp_id=a.empid and  b.att_date=to_date('"+Current+"','dd/MM/yyyy'))main_qry where main_qry.FN_Branch_Status is not null";
				System.out.println(qry);

				return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
		{  
			SimpleBranch gl=new SimpleBranch();
			gl.setS1(rs.getInt(1));  
			gl.setS2(rs.getString(2));       //
			gl.setS3(rs.getString(3));
			gl.setS10(rs.getString(6));
			gl.setS4(rs.getString(11));
			gl.setS31(rs.getString(7));
			//gl.setS6(rs.getString(8));
			//gl.setS5(rs.getString(9));
			gl.setS32(rs.getString(8));
			gl.setS33(rs.getString(10));
			gl.setS34(rs.getString(9));
			
			
			gl.setS35(rs.getString(12));
			
			
			gl.setS35(rs.getString(12));
			
			
			
		  
							
			return gl;
		}
		 }     );
	}
	
	public List<SimpleBranch> getEmployeeDetailsList_Branch_FN_UnLock_Single( String Current,String value,int BCode){
		//--Set Connection----------------------------
				int j=201;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				String qry="";
				if(!value.equalsIgnoreCase(null) && !value.isEmpty())
				{
				qry="select rownum,main_qry.*,(select branch_name from branch_master where branch_code=main_qry.DBCODE) as bname from (select a.*,b.FN_Time,b.type,b.REMARKS,b.FN_Branch_status,b.att_date,b.FN_Late from(select EMPID,EMPNAME,DBCODE,STATUS,DESIGNATION from employee_Master where dbcode like'"+BCode+"%' and (upper(empid) ='"+value.toUpperCase()+"' or upper(empname)= '"+value.toUpperCase()+"') order by EmpId)a left join (select emp_id,to_char(att_date,'dd-MM-yyyy') as att_date,type,FN_Time,Remarks,FN_Branch_status,FN_Late from staff_attendance where  FN_Branch_Status='N')b on b.emp_id=a.empid and  b.att_date=to_date('"+Current+"','dd/MM/yyyy'))main_qry where main_qry.FN_Branch_Status is not null";
				}
				else
					qry="select rownum,main_qry.*,(select branch_name from branch_master where branch_code=main_qry.DBCODE) as bname from (select a.*,b.FN_Time,b.type,b.REMARKS,b.FN_Branch_status,b.att_date,b.FN_Late from(select EMPID,EMPNAME,DBCODE,STATUS,DESIGNATION from employee_Master where dbcode like'"+BCode+"%' and (empid ='"+value+"' or empname= '"+value+"') order by EmpId)a left join (select emp_id,to_char(att_date,'dd-MM-yyyy') as att_date,type,FN_Time,Remarks,FN_Branch_status,FN_Late from staff_attendance where  FN_Branch_Status='N')b on b.emp_id=a.empid and  b.att_date=to_date('"+Current+"','dd/MM/yyyy'))main_qry where main_qry.FN_Branch_Status is not null";

				
				System.out.println(qry);

				return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
		{  
			SimpleBranch gl=new SimpleBranch();
			gl.setS1(rs.getInt(1));  
			gl.setS2(rs.getString(2));       //
			gl.setS3(rs.getString(3));
			gl.setS10(rs.getString(6));
			gl.setS4(rs.getString(11));
			gl.setS31(rs.getString(7));
			//gl.setS6(rs.getString(8));
			//gl.setS5(rs.getString(9));
			gl.setS32(rs.getString(8));
			gl.setS33(rs.getString(10));
			gl.setS34(rs.getString(9));
			
			
			gl.setS35(rs.getString(12));
			
			gl.setS36(rs.getString(13));
			
			
			
		  
							
			return gl;
		}
		 }     );
	}
	
	public List<SimpleBranch> getEmployeeDetailsList_Branch_FN_UnLock_AllBranch( String Current,String value,int BCode){
		//--Set Connection----------------------------
				int j=201;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				String qry="select rownum,main_qry.* from (select a.*,b.FN_Time,b.type,b.REMARKS,b.FN_Branch_status,b.att_date,b.FN_Late from(select EMPID,EMPNAME,DBCODE,STATUS,DESIGNATION from employee_Master where (empid like '%"+value+"%' or empname like '%"+value+"%') and Attendance_status !='Y' order by EmpId)a left join (select emp_id,to_char(att_date,'dd-MM-yyyy') as att_date,type,FN_Time,Remarks,FN_Branch_status,FN_Late from staff_attendance where  FN_Branch_Status='N')b on b.emp_id=a.empid and  b.att_date=to_date('"+Current+"','dd/MM/yyyy'))main_qry where main_qry.FN_Branch_Status is not null";
		return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
		{  
			SimpleBranch gl=new SimpleBranch();
			gl.setS1(rs.getInt(1));  
			gl.setS2(rs.getString(2));       //
			gl.setS3(rs.getString(3));
			gl.setS10(rs.getString(6));
			gl.setS4(rs.getString(11));
			gl.setS31(rs.getString(7));
			//gl.setS6(rs.getString(8));
			//gl.setS5(rs.getString(9));
			gl.setS32(rs.getString(8));
			gl.setS33(rs.getString(10));
			gl.setS34(rs.getString(9));
			
			
			gl.setS35(rs.getString(12));
			
			
			
		  
							
			return gl;
		}
		 }     );
	}

	public List<SimpleBranch> getEmployeeDetailsList_Branch_AN_UnLock( String Current,String value,int BCode){
		//--Set Connection----------------------------
				int j=201;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				String qry="select  rownum,main_qry.*,(select branch_name from branch_master where branch_code=main_qry.DBCODE) as bname from (select a.*,b.AN_Time,b.AN_type,b.AN_REMARKS,b.AN_Branch_status ,b.att_date ,b.AN_Late from(select EMPID,EMPNAME,DBCODE,STATUS,DESIGNATION from employee_Master where dbcode like'"+BCode+"%' and (empid like '%"+value+"%' or empname like '%"+value+"%') order by EmpId)a left join (select emp_id,to_char(att_date,'dd-MM-yyyy') as att_date,AN_type,AN_Time,AN_Remarks,AN_Branch_status ,AN_Late from staff_attendance where AN_Branch_Status='N')b on b.emp_id=a.empid and  b.att_date=to_date('"+Current+"','dd/MM/yyyy'))main_qry where main_qry.AN_Branch_Status is not null";
		System.out.println(qry);
				return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
		{  
			SimpleBranch gl=new SimpleBranch();
			gl.setS1(rs.getInt(1));  
			gl.setS2(rs.getString(2));       //
			gl.setS3(rs.getString(3));
			gl.setS10(rs.getString(6));
			gl.setS4(rs.getString(11));
			gl.setS31(rs.getString(7));
			//gl.setS6(rs.getString(8));
			//gl.setS5(rs.getString(9));
			gl.setS32(rs.getString(8));
			gl.setS33(rs.getString(10));
			gl.setS34(rs.getString(9));
			
			
			gl.setS35(rs.getString(12));
			
			gl.setS35(rs.getString(12));
		  
							
			return gl;
		}
		 }     );
	}
	
	
	public List<SimpleBranch> getEmployeeDetailsList_Branch_AN_UnLock_Single( String Current,String value,int BCode){
		//--Set Connection----------------------------
				int j=201;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				String qry="";
				if(!value.equalsIgnoreCase(null) && !value.isEmpty())
			       qry="select  rownum,main_qry.*,(select branch_name from branch_master where branch_code=main_qry.DBCODE) as bname from (select a.*,b.AN_Time,b.AN_type,b.AN_REMARKS,b.AN_Branch_status ,b.att_date ,b.AN_Late from(select EMPID,EMPNAME,DBCODE,STATUS,DESIGNATION from employee_Master where dbcode like'"+BCode+"%' and (upper(empid)='"+value.toUpperCase()+"' or upper(empname)='"+value.toUpperCase()+"') order by EmpId)a left join (select emp_id,to_char(att_date,'dd-MM-yyyy') as att_date,AN_type,AN_Time,AN_Remarks,AN_Branch_status ,AN_Late from staff_attendance where AN_Branch_Status='N')b on b.emp_id=a.empid and  b.att_date=to_date('"+Current+"','dd/MM/yyyy'))main_qry where main_qry.AN_Branch_Status is not null";
				else
				       qry="select  rownum,main_qry.*,(select branch_name from branch_master where branch_code=main_qry.DBCODE) as bname from (select a.*,b.AN_Time,b.AN_type,b.AN_REMARKS,b.AN_Branch_status ,b.att_date ,b.AN_Late from(select EMPID,EMPNAME,DBCODE,STATUS,DESIGNATION from employee_Master where dbcode like'"+BCode+"%' and (empid='"+value+"' or empname='"+value+"') order by EmpId)a left join (select emp_id,to_char(att_date,'dd-MM-yyyy') as att_date,AN_type,AN_Time,AN_Remarks,AN_Branch_status ,AN_Late from staff_attendance where AN_Branch_Status='N')b on b.emp_id=a.empid and  b.att_date=to_date('"+Current+"','dd/MM/yyyy'))main_qry where main_qry.AN_Branch_Status is not null";

		System.out.println(qry);
				return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
		{  
			SimpleBranch gl=new SimpleBranch();
			gl.setS1(rs.getInt(1));  
			gl.setS2(rs.getString(2));       //
			gl.setS3(rs.getString(3));
			gl.setS10(rs.getString(6));
			gl.setS4(rs.getString(11));
			gl.setS31(rs.getString(7));
			//gl.setS6(rs.getString(8));
			//gl.setS5(rs.getString(9));
			gl.setS32(rs.getString(8));
			gl.setS33(rs.getString(10));
			gl.setS34(rs.getString(9));
			
			
			gl.setS35(rs.getString(12));
			
			gl.setS36(rs.getString(13));
			
			
		  
							
			return gl;
		}
		 }     );
	}

	public List<SimpleBranch> getEmployeeDetailsList_Branch_AN_UnLock_AllBranch( String Current,String value,int BCode){
		//--Set Connection----------------------------
				int j=201;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				String qry="select rownum,main_qry.* from (select a.*,b.AN_Time,b.AN_type,b.AN_REMARKS,b.AN_Branch_status ,b.att_date from(select EMPID,EMPNAME,DBCODE,STATUS,DESIGNATION from employee_Master where (empid like '%"+value+"%' or empname like '%"+value+"%') and Attendance_status !='Y' order by EmpId)a left join (select emp_id,to_char(att_date,'dd-MM-yyyy') as att_date,AN_type,AN_Time,AN_Remarks,AN_Branch_status from staff_attendance where AN_Branch_Status='N')b on b.emp_id=a.empid and  b.att_date=to_date('"+Current+"','dd/MM/yyyy'))main_qry where main_qry.AN_Branch_Status is not null";
		return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
		{  
			SimpleBranch gl=new SimpleBranch();
			gl.setS1(rs.getInt(1));  
			gl.setS2(rs.getString(2));       //
			gl.setS3(rs.getString(3));
			gl.setS10(rs.getString(6));
			gl.setS4(rs.getString(11));
			gl.setS31(rs.getString(7));
			//gl.setS6(rs.getString(8));
			//gl.setS5(rs.getString(9));
			gl.setS32(rs.getString(8));
			gl.setS33(rs.getString(10));
			gl.setS34(rs.getString(9));
			
			
			
		  
							
			return gl;
		}
		 }     );
	}

	
	
	
	public List<SimpleBranch> getEmployeeDetailsList_Branch_FN_Lock( String Current,String value,int BCode){
		//--Set Connection----------------------------
				int j=201;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				String qry="select main_qry.* from (select rownum,a.*,b.FN_Time,b.type,b.REMARKS,b.FN_Branch_status,b.att_date,b.FN_Late from(select EMPID,EMPNAME,DBCODE,STATUS,DESIGNATION from employee_Master where dbcode like'"+BCode+"%' and (empid like '%"+value+"%' or empname like '%"+value+"%') order by EmpId)a left join (select emp_id,to_char(att_date,'dd-MM-yyyy') as att_date,type,FN_Time,Remarks,FN_Branch_status,FN_Late from staff_attendance where  FN_Branch_Status='Y')b on b.emp_id=a.empid and  b.att_date=to_date('"+Current+"','dd/MM/yyyy'))main_qry where main_qry.FN_Branch_Status is not null";
		return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
		{  
			SimpleBranch gl=new SimpleBranch();
			gl.setS1(rs.getInt(1));  
			gl.setS2(rs.getString(2));       //
			gl.setS3(rs.getString(3));
			gl.setS10(rs.getString(6));
			gl.setS4(rs.getString(11));
			gl.setS31(rs.getString(7));
			//gl.setS6(rs.getString(8));
			//gl.setS5(rs.getString(9));
			gl.setS32(rs.getString(8));
			gl.setS33(rs.getString(10));
			gl.setS34(rs.getString(9));
			
			gl.setS35(rs.getString(12));
			
			
			
		  
							
			return gl;
		}
		 }     );
	}
	
	public List<SimpleBranch> getEmployeeDetailsList_Branch_FN_Lock_AllBranch( String Current,String value,int BCode){
		//--Set Connection----------------------------
				int j=201;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				String qry="select main_qry.* from (select rownum,a.*,b.FN_Time,b.type,b.REMARKS,b.FN_Branch_status,b.att_date from(select EMPID,EMPNAME,DBCODE,STATUS,DESIGNATION from employee_Master where (empid like '%"+value+"%' or empname like '%"+value+"%') and Attendance_status !='Y' order by EmpId)a left join (select emp_id,to_char(att_date,'dd-MM-yyyy') as att_date,type,FN_Time,Remarks,FN_Branch_status from staff_attendance where  FN_Branch_Status='Y')b on b.emp_id=a.empid and  b.att_date=to_date('"+Current+"','dd/MM/yyyy'))main_qry where main_qry.FN_Branch_Status is not null";
		return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
		{  
			SimpleBranch gl=new SimpleBranch();
			gl.setS1(rs.getInt(1));  
			gl.setS2(rs.getString(2));       //
			gl.setS3(rs.getString(3));
			gl.setS10(rs.getString(6));
			gl.setS4(rs.getString(11));
			gl.setS31(rs.getString(7));
			//gl.setS6(rs.getString(8));
			//gl.setS5(rs.getString(9));
			gl.setS32(rs.getString(8));
			gl.setS33(rs.getString(10));
			gl.setS34(rs.getString(9));
			
			
			
		  
							
			return gl;
		}
		 }     );
	}

	public List<SimpleBranch> getEmployeeDetailsList_Branch_AN_Lock( String Current,String value,int BCode){
		//--Set Connection----------------------------
				int j=201;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				String qry="select main_qry.* from (select rownum,a.*,b.AN_Time,b.AN_type,b.AN_REMARKS,b.AN_Branch_status ,b.att_date,b.AN_Late from(select EMPID,EMPNAME,DBCODE,STATUS,DESIGNATION from employee_Master where dbcode like'"+BCode+"%' and (empid like '%"+value+"%' or empname like '%"+value+"%') and Attendance_status !='Y' order by EmpId)a left join (select emp_id,to_char(att_date,'dd-MM-yyyy') as att_date,AN_type,AN_Time,AN_Remarks,AN_Branch_status ,AN_Late from staff_attendance where AN_Branch_Status='Y')b on b.emp_id=a.empid and  b.att_date=to_date('"+Current+"','dd/MM/yyyy'))main_qry where main_qry.AN_Branch_Status is not null";
		return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
		{  
			SimpleBranch gl=new SimpleBranch();
			gl.setS1(rs.getInt(1));  
			gl.setS2(rs.getString(2));       //
			gl.setS3(rs.getString(3));
			gl.setS10(rs.getString(6));
			gl.setS4(rs.getString(11));
			gl.setS31(rs.getString(7));
			//gl.setS6(rs.getString(8));
			//gl.setS5(rs.getString(9));
			gl.setS32(rs.getString(8));
			gl.setS33(rs.getString(10));
			gl.setS34(rs.getString(9));
			
			
			gl.setS35(rs.getString(12));
			
			
		  
							
			return gl;
		}
		 }     );
	}

	public List<SimpleBranch> getEmployeeDetailsList_Branch_AN_Lock_AllBranch( String Current,String value,int BCode){
		//--Set Connection----------------------------
				int j=201;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				String qry="select main_qry.* from (select rownum,a.*,b.AN_Time,b.AN_type,b.AN_REMARKS,b.AN_Branch_status ,b.att_date from(select EMPID,EMPNAME,DBCODE,STATUS,DESIGNATION from employee_Master where (empid like '%"+value+"%' or empname like '%"+value+"%') order by EmpId)a left join (select emp_id,to_char(att_date,'dd-MM-yyyy') as att_date,AN_type,AN_Time,AN_Remarks,AN_Branch_status from staff_attendance where AN_Branch_Status='Y')b on b.emp_id=a.empid and  b.att_date=to_date('"+Current+"','dd/MM/yyyy'))main_qry where main_qry.AN_Branch_Status is not null";
		return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
		{  
			SimpleBranch gl=new SimpleBranch();
			gl.setS1(rs.getInt(1));  
			gl.setS2(rs.getString(2));       //
			gl.setS3(rs.getString(3));
			gl.setS10(rs.getString(6));
			gl.setS4(rs.getString(11));
			gl.setS31(rs.getString(7));
			//gl.setS6(rs.getString(8));
			//gl.setS5(rs.getString(9));
			gl.setS32(rs.getString(8));
			gl.setS33(rs.getString(10));
			gl.setS34(rs.getString(9));
			
			
			
		  
							
			return gl;
		}
		 }     );
	}

	
	public int Update_Staff_AttendanceUNLOCK_FN_All(String Current, int DBCode,String user)
	{
		//--Set Connection----------------------------
		int j=201;
		this.template=con.getCon2(j);
	//-----------------------------------------------------
			String sql="update staff_attendance set FN_branch_status='Y',unlocked_by='"+user+"',unlock_time_info=to_char(sysdate,'DD/MM/YYYY HH:MI:SS') where  bcode="+DBCode+" and att_date=to_date('"+Current+"','dd/MM/yyyy')";
					return template.update(sql);
	}
	
	
	public int Update_Staff_AttendanceUNLOCK_AN_All(String Current, int DBCode,String user)
	{
		//--Set Connection----------------------------
		int j=201;
		this.template=con.getCon2(j);
	//-----------------------------------------------------
			String sql="update staff_attendance set AN_branch_status='Y',unlocked_by='"+user+"',unlock_time_info=to_char(sysdate,'DD/MM/YYYY HH:MI:SS') where  bcode="+DBCode+" and att_date=to_date('"+Current+"','dd/MM/yyyy')";
					return template.update(sql);
	}
	
	
	
	public int Update_Staff_AttendanceUNLOCK_FN_All_Branch(String Current, String user)
	{
		//--Set Connection----------------------------
		int j=201;
		this.template=con.getCon2(j);
	//-----------------------------------------------------
			String sql="update staff_attendance set FN_branch_status='Y',unlocked_by='"+user+"',unlock_time_info=to_char(sysdate,'DD/MM/YYYY HH:MI:SS') where  att_date=to_date('"+Current+"','dd/MM/yyyy')";
					return template.update(sql);
	}
	
	
	public int Update_Staff_AttendanceUNLOCK_AN_All_Branch(String Current,String user)
	{
		//--Set Connection----------------------------
		int j=201;
		this.template=con.getCon2(j);
	//-----------------------------------------------------
			String sql="update staff_attendance set AN_branch_status='Y',unlocked_by='"+user+"',unlock_time_info=to_char(sysdate,'DD/MM/YYYY HH:MI:SS') where  att_date=to_date('"+Current+"','dd/MM/yyyy')";
					return template.update(sql);
	}
	
	
	
	
	public List<SimpleBranch> getEmployeeDetailsList_Branch_FN_Attendance( String Current,int Bcode){
		//--Set Connection----------------------------
				int j=201;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				//String qry="select main_qry.* from(select a.*,NVL(b.Noofpresent,0) as noofpresent,NVL(c.NoofLate,0) as nooflate,NVL(d.NoofOnduty,0)as noofonduty,NVL(e.NoofAbsent,0) as noofabsent,NVL(f.NoofLeave,0) as noofleave,NVL(g.NotMarked,0)as noofnotmarked,NVL(h.Total,0)as total from (select branch_code,branch_name,'"+Current+"' as Adate from branch_master)a left join (select bcode,NVL(count(*),0) as Noofpresent  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Present' group by bcode)b on a.branch_code=b.bcode left join (select bcode,NVL(count(*),0) as NoofLate  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Late' group by bcode)c on a.branch_code=c.bcode left join (select bcode,NVL(count(*),0) as NoofOnduty  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='OnDuty' group by bcode)d on a.branch_code=d.bcode left join (select bcode,NVL(count(*),0) as NoofAbsent  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Absent' group by bcode)e on a.branch_code=e.bcode left join (select bcode,NVL(count(*),0) as NoofLeave  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Leave' group by bcode)f on a.branch_code=f.bcode left join (select bcode,NVL(count(*),0) as NotMarked  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type is null group by bcode)g on a.branch_code=g.bcode left join (select bcode,NVL(count(*),0) as Total  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy')  group by bcode)h on a.branch_code=h.bcode)main_qry where main_qry.branch_code like '"+Bcode+"%'";
		//03-12-2021
				//String qry="select main_qry.* from(select a.*,NVL(b.Noofpresent,0) as noofpresent,NVL(c.NoofLate,0) as nooflate,NVL(d.NoofOnduty,0)as noofonduty,NVL(e.NoofAbsent,0) as noofabsent,NVL(f.NoofLeave,0) as noofleave,NVL(g.NotMarked,0)as noofnotmarked,NVL(h.Total,0)as total from (select branch_code,branch_name,'"+Current+"' as Adate from branch_master)a left join (select bcode,NVL(count(*),0) as Noofpresent  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Present' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)b on a.branch_code=b.bcode left join (select bcode,NVL(count(*),0) as NoofLate  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Late' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)c on a.branch_code=c.bcode left join (select bcode,NVL(count(*),0) as NoofOnduty  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='OnDuty' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)d on a.branch_code=d.bcode left join (select bcode,NVL(count(*),0) as NoofAbsent  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Absent'  and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)e on a.branch_code=e.bcode left join (select bcode,NVL(count(*),0) as NoofLeave  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Leave' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)f on a.branch_code=f.bcode left join (select bcode,NVL(count(*),0) as NotMarked  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type is null and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)g on a.branch_code=g.bcode left join (select bcode,NVL(count(*),0) as Total  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy')  group by bcode)h on a.branch_code=h.bcode)main_qry where main_qry.branch_code like '"+Bcode+"%' ";
//16-12-2021
				String qry="select main_qry.* from(select a.*,NVL(b.Noofpresent,0) as noofpresent,NVL(c.NoofLate,0) as nooflate,NVL(d.NoofOnduty,0)as noofonduty,NVL(e.NoofAbsent,0) as noofabsent,NVL(f.NoofLeave,0) as noofleave,NVL(g.NotMarked,0)as noofnotmarked,NVL(i.An_present,0) as anpresent,NVL(j.An_late,0) as anlate,NVL(m.An_onduty,0) as anonduty,NVL(n.An_absent,0) as anabsent,NVL(p.An_leave,0) as anleave,NVL(q.An_not,0) as annot,NVL(h.Total,0)as total from ( select branch_code,branch_name,'"+Current+"' as Adate from branch_master)a left join (select bcode,NVL(count(*),0) as Noofpresent  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Present' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)b on a.branch_code=b.bcode left join (select bcode,NVL(count(*),0) as NoofLate  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Late' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)c on a.branch_code=c.bcode left join (select bcode,NVL(count(*),0) as NoofOnduty  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='OnDuty' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)d on a.branch_code=d.bcode left join (select bcode,NVL(count(*),0) as NoofAbsent  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Absent'  and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)e on a.branch_code=e.bcode left join (select bcode,NVL(count(*),0) as NoofLeave  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Leave' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)f on a.branch_code=f.bcode left join (select bcode,NVL(count(*),0) as NotMarked  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type is null and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)g on a.branch_code=g.bcode left join (select bcode,NVL(count(*),0) as An_present  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and An_type='Present' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)i on a.branch_code=i.bcode left join (select bcode,NVL(count(*),0) as An_late  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and An_type='Late' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)j on a.branch_code=j.bcode left join (select bcode,NVL(count(*),0) as An_onduty  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and An_type='OnDuty' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)m on a.branch_code=m.bcode left join (select bcode,NVL(count(*),0) as An_absent  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and An_type='Absent' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)n on a.branch_code=n.bcode left join (select bcode,NVL(count(*),0) as An_leave  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and An_type='Leave' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)p on a.branch_code=p.bcode left join (select bcode,NVL(count(*),0) as An_not  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and An_type is null and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)q on a.branch_code=q.bcode left join (select bcode,NVL(count(*),0) as Total  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy')  group by bcode)h on a.branch_code=h.bcode)main_qry where main_qry.branch_code like '"+Bcode+"%' order by main_qry.branch_code";

				System.out.println(qry);
				return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
		{  
			SimpleBranch gl=new SimpleBranch();
			gl.setS31(rs.getString(1));
			gl.setS32(rs.getString(2));
			gl.setS33(rs.getString(3));
			gl.setS34(rs.getString(4));
			gl.setS35(rs.getString(5));
			gl.setS36(rs.getString(6));
			gl.setS37(rs.getString(7));
			gl.setS38(rs.getString(8));
			gl.setS39(rs.getString(9));
			gl.setS40(rs.getString(10));
			
			gl.setS41(rs.getInt(4));
			gl.setS42(rs.getInt(5));
			gl.setS43(rs.getInt(6));
			gl.setS44(rs.getInt(7));
			gl.setS45(rs.getInt(8));
			gl.setS46(rs.getInt(9));
			
			gl.setS47(rs.getInt(10));
			gl.setS1(rs.getInt(11));
			gl.setS21(rs.getInt(12));
			gl.setS22(rs.getInt(13));
			gl.setS23(rs.getInt(14));
			gl.setS48(rs.getInt(15));
			
			gl.setS49(rs.getInt(16));
			
			
			
			
			
		  
							
			return gl;
		}
		 }     );
	}
	
	
	public List<SimpleBranch> getEmployeeDetailsList_Branch_AN_Attendance( String Current,int Bcode){
		//--Set Connection----------------------------
				int j=201;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				String qry="select main_qry.* from(select a.*,NVL(b.Noofpresent,0) as noofpresent,NVL(c.NoofLate,0) as nooflate,NVL(d.NoofOnduty,0)as noofonduty,NVL(e.NoofAbsent,0) as noofabsent,NVL(f.NoofLeave,0) as noofleave,NVL(g.NotMarked,0)as noofnotmarked,NVL(h.Total,0)as total from (select branch_code,branch_name,'"+Current+"' as Adate from branch_master)a left join (select bcode,NVL(count(*),0) as Noofpresent  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and AN_type='Present' group by bcode)b on a.branch_code=b.bcode left join (select bcode,NVL(count(*),0) as NoofLate  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and AN_type='Late' group by bcode)c on a.branch_code=c.bcode left join (select bcode,NVL(count(*),0) as NoofOnduty  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and AN_type='OnDuty' group by bcode)d on a.branch_code=d.bcode left join (select bcode,NVL(count(*),0) as NoofAbsent  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and AN_type='Absent' group by bcode)e on a.branch_code=e.bcode left join (select bcode,NVL(count(*),0) as NoofLeave  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and AN_type='Leave' group by bcode)f on a.branch_code=f.bcode left join (select bcode,NVL(count(*),0) as NotMarked  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and AN_type is null group by bcode)g on a.branch_code=g.bcode left join (select bcode,NVL(count(*),0) as Total  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy')  group by bcode)h on a.branch_code=h.bcode)main_qry where main_qry.branch_code like '"+Bcode+"%'  order by main_qry.branch_code";
		return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
		{  
			SimpleBranch gl=new SimpleBranch();
			gl.setS31(rs.getString(1));
			gl.setS32(rs.getString(2));
			gl.setS33(rs.getString(3));
			gl.setS34(rs.getString(4));
			gl.setS35(rs.getString(5));
			gl.setS36(rs.getString(6));
			gl.setS37(rs.getString(7));
			gl.setS38(rs.getString(8));
			gl.setS39(rs.getString(9));
			gl.setS40(rs.getString(10));
			
			gl.setS41(rs.getInt(4));
			gl.setS42(rs.getInt(5));
			gl.setS43(rs.getInt(6));
			gl.setS44(rs.getInt(7));
			gl.setS45(rs.getInt(8));
			gl.setS46(rs.getInt(9));
			gl.setS47(rs.getInt(10));
							
			return gl;
		}
		 }     );
	}
	
	
	
	
	 public List<SimpleBranch> ConsolidatedAttendanceReportDaily(String sql)
	 {

			//--Set Connection----------------------------
						int j=Binfo;
						this.template=con.getCon2(j);
			//-----------------------------------------------------

				System.out.println(sql);
				
				return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException					{  

				SimpleBranch gl=new SimpleBranch();
				SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
				 DecimalFormat df = new DecimalFormat("#.00");   
				
				gl.setS31(rs.getString(1));  //BNAME
				gl.setS41(rs.getInt(4));  //Sc_count
				gl.setS42(rs.getInt(6));  //SB_COUNT
				gl.setS43(rs.getInt(8));  //FD_COUNT
				gl.setS44(rs.getInt(10));  //CFD_COUNT
				//gl.setS45(rs.getInt(12));  //KFD_COUNT
				gl.setS19(rs.getInt(15));  //RD count
				gl.setS21(rs.getInt(19));//DDS_COUNT
				gl.setS11(rs.getInt(21)); //SFD_COUNT
				gl.setS12(rs.getInt(23)); //SCFD_Count
				gl.setS22(rs.getInt(17));//FD_CLOSURE_REQ,
				gl.setS23(rs.getInt(18)); //RD_CLOSURE_REQ,
				gl.setS46(rs.getInt(14)); //MD_COUNT,
				gl.setS47(rs.getInt(27));//SDDS_Count

				
				gl.setS32(df.format(rs.getFloat(5)));  //SC_BALANCE
				gl.setS33(df.format(rs.getFloat(7)));  //SB_BALANCE
				gl.setS34(df.format(rs.getFloat(9)));  //FD_BALANCE
				gl.setS35(df.format(rs.getFloat(11)));  //CFD_BALANCE
				//gl.setS36(df.format(rs.getFloat(13)));  //KFD_BALANCE
				gl.setS5(df.format(rs.getFloat(16)));  //RD_BALANCE
				gl.setS10(df.format(rs.getFloat(20))); //DDS_BALANCE
				gl.setS37(df.format(rs.getFloat(22))); //SFD_BALANCE
				gl.setS38(df.format(rs.getFloat(24)));  //SCFD_BALANCE
				gl.setS39(df.format(rs.getFloat(28))); //SDDS_Blance
				
								
				gl.setS164(rs.getFloat(5));  //SC_BALANCE
				gl.setS143(rs.getFloat(7));  //SB_BALANCE
				gl.setS144(rs.getFloat(9));  //FD_BALANCE
				gl.setS145(rs.getFloat(11));  //CFD_BALANCE
				//gl.setS146(rs.getFloat(13));  //KFD_BALANCE
				gl.setS163(rs.getFloat(16));  //RD_BALANCE
				gl.setS141(rs.getFloat(20));  //DDS_BALANCE
				gl.setS147(rs.getFloat(22));//SFD_BALANCE
				gl.setS148(rs.getFloat(24));//SCFD_BALANCE
				gl.setS149(rs.getFloat(28)); //SDDS_Balance
										
				
				gl.setS23(rs.getInt(25)); //Locker count
				gl.setS167(rs.getFloat(26)); //Locker Balance bal
	
				
				return gl;
			}
			 }     );
		}
	 
	 
	 
	 
	 
	 public List<SimpleBranch> getEmployeeDetailsList_Branch_FN_Search( String Current,String value,int BCode,String type){
			//--Set Connection----------------------------
					int j=201;
					this.template=con.getCon2(j);
					//-----------------------------------------------------
					String qry="select rownum,main_qry.* from (select a.*,b.FN_Time,b.type,b.REMARKS,b.FN_Branch_status,b.att_date from(select EMPID,EMPNAME,DBCODE,STATUS,DESIGNATION from employee_Master where dbcode like'"+BCode+"%' and (upper(empid) like '%"+value.toUpperCase()+"%' or upper(empname) like '%"+value.toUpperCase()+"%' or upper(DESIGNATION) like '%"+value.toUpperCase()+"%') and attendance_status !='Y' order by EmpId)a left join (select emp_id,to_char(att_date,'dd-MM-yyyy') as att_date,type,FN_Time,Remarks,FN_Branch_status from staff_attendance )b on b.emp_id=a.empid and  b.att_date=to_date('"+Current+"','dd/MM/yyyy'))main_qry where main_qry.FN_Branch_Status is not null and "+type+"";
			return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
			{  
				SimpleBranch gl=new SimpleBranch();
				gl.setS1(rs.getInt(1));  
				gl.setS2(rs.getString(2));       //
				gl.setS3(rs.getString(3));
				gl.setS10(rs.getString(6));
				gl.setS4(rs.getString(11));
				gl.setS31(rs.getString(7));
				//gl.setS6(rs.getString(8));
				//gl.setS5(rs.getString(9));
				gl.setS32(rs.getString(8));
				gl.setS33(rs.getString(10));
				gl.setS34(rs.getString(9));
				
				
				
			  
								
				return gl;
			}
			 }     );
		}

	 
	 public List<SimpleBranch> getEmployeeDetailsList_Branch_AN_Search( String Current,String value,int BCode,String type){
			//--Set Connection----------------------------
					int j=201;
					this.template=con.getCon2(j);
					//-----------------------------------------------------
					String qry="select  rownum,main_qry.* from (select a.*,b.AN_Time,b.AN_type,b.AN_REMARKS,b.AN_Branch_status ,b.att_date from(select EMPID,EMPNAME,DBCODE,STATUS,DESIGNATION from employee_Master where dbcode like'"+BCode+"%' and (upper(empid) like '%"+value.toUpperCase()+"%' or upper(empname) like '%"+value.toUpperCase()+"%' or upper(DESIGNATION) like '%"+value.toUpperCase()+"%') and attendance_status !='Y' order by EmpId)a left join (select emp_id,to_char(att_date,'dd-MM-yyyy') as att_date,AN_type,AN_Time,AN_Remarks,AN_Branch_status from staff_attendance )b on b.emp_id=a.empid and  b.att_date=to_date('"+Current+"','dd/MM/yyyy'))main_qry where main_qry.AN_Branch_Status is not null and  "+type+"";
			return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
			{  
				SimpleBranch gl=new SimpleBranch();
				gl.setS1(rs.getInt(1));  
				gl.setS2(rs.getString(2));       //
				gl.setS3(rs.getString(3));
				gl.setS10(rs.getString(6));
				gl.setS4(rs.getString(11));
				gl.setS31(rs.getString(7));
				//gl.setS6(rs.getString(8));
				//gl.setS5(rs.getString(9));
				gl.setS32(rs.getString(8));
				gl.setS33(rs.getString(10));
				gl.setS34(rs.getString(9));
				
				
				
			  
								
				return gl;
			}
			 }     );
		}
	 
	 
	 
	 
	 
	 
	 public int Update_Staff_AttendanceUNLOCK_AN(String An_time,String Current,String empid,String user,String FN_Status)
		{
			//--Set Connection----------------------------
			int j=201;
			this.template=con.getCon2(j);
		//-----------------------------------------------------
				String sql="update staff_attendance set  AN_type='"+FN_Status+"',AN_Late='"+An_time+"',AN_branch_status='Y',unlocked_by='"+user+"',unlock_time_info=to_char(sysdate,'DD/MM/YYYY HH:MI:SS') where  att_date=to_date('"+Current+"','dd/MM/yyyy') and emp_id='"+empid+"'";
				System.out.println(sql);
						return template.update(sql);
		}
		

	 public int Update_Staff_AttendanceUNLOCK_FN(String An_time,String Current,String empid,String user,String FN_Status)
		{
			//--Set Connection----------------------------
			int j=201;
			this.template=con.getCon2(j);
		//-----------------------------------------------------
				String sql="update staff_attendance set type='"+FN_Status+"',FN_Late='"+An_time+"',FN_branch_status='Y',unlocked_by='"+user+"',unlock_time_info=to_char(sysdate,'DD/MM/YYYY HH:MI:SS') where  att_date=to_date('"+Current+"','dd/MM/yyyy') and emp_id='"+empid+"'";
				System.out.println(sql);	
				return template.update(sql);
		}
	 
	 
	 
	 public List<SimpleBranch> getEmployeeDetailsList_Branch_All_Search( String qry){
			//--Set Connection----------------------------
					int j=201;
					this.template=con.getCon2(j);
					//-----------------------------------------------------
				//	String qry="select rownum,main_qry.* from (select a.*,b.FN_Time,b.type,b.REMARKS,b.FN_Branch_status,b.att_date from(select EMPID,EMPNAME,DBCODE,STATUS,DESIGNATION from employee_Master where dbcode like'"+BCode+"%' and (upper(empid) like '%"+value.toUpperCase()+"%' or upper(empname) like '%"+value.toUpperCase()+"%' or upper(DESIGNATION) like '%"+value.toUpperCase()+"%') and attendance_status !='Y' order by EmpId)a left join (select emp_id,to_char(att_date,'dd-MM-yyyy') as att_date,type,FN_Time,Remarks,FN_Branch_status,An_type,An_time,an_remarks from staff_attendance )b on b.emp_id=a.empid and  b.att_date=to_date('"+Current+"','dd/MM/yyyy'))main_qry where (main_qry.FN_Branch_Status is not null or main_qry.AN_Branch_Status is not null) and "+type+"";
					//String qry="select rownum,main_qry.* from (select a.*,b.FN_Time,b.type,b.REMARKS,b.FN_Branch_status,b.att_date,b.an_time,b.an_type,b.an_remarks ,b.an_branch_status from(select EMPID,EMPNAME,DBCODE,STATUS,DESIGNATION from employee_Master where dbcode like '"+BCode+"' and (upper(empid) like '%"+value.toUpperCase()+"%' or upper(empname) like '%"+value.toUpperCase()+"%' or upper(DESIGNATION) like '%"+value.toUpperCase()+"%') and attendance_status !='Y' order by EmpId)a left join (select emp_id,to_char(att_date,'dd-MM-yyyy') as att_date,type,FN_Time,Remarks,FN_Branch_status,An_type,An_time,an_remarks,an_branch_status from staff_attendance )b on b.emp_id=a.empid and  b.att_date=to_date('"+Current+"','dd/MM/yyyy'))main_qry where (main_qry.FN_Branch_Status is not null or main_qry.AN_Branch_Status is not null) and "+type+"";

					System.out.println(qry);
					
					return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
			{  
				SimpleBranch gl=new SimpleBranch();
				gl.setS1(rs.getInt(1));  
				gl.setS2(rs.getString(2));       //
				gl.setS3(rs.getString(3));
				gl.setS10(rs.getString(6));
				gl.setS4(rs.getString(11));
				gl.setS31(rs.getString(7));
				//gl.setS6(rs.getString(8));
				//gl.setS5(rs.getString(9));
				gl.setS32(rs.getString(8));
				gl.setS33(rs.getString(10));
				gl.setS34(rs.getString(9));
				
				gl.setS35(rs.getString(12));
				gl.setS36(rs.getString(13));
				gl.setS37(rs.getString(15));
				gl.setS38(rs.getString(14));
				
				gl.setS39(rs.getString(4));
				
				
				gl.setS5(rs.getString("fn_late"));
				gl.setS6(rs.getString("an_late"));
			  
								
				return gl;
			}
			 }     );
		}
	 
	 
	 
	 
	 
	 public int getAttendanceStatus_User_FN(String Current,String emp) {
			//--Set Connection------------------------------------
			int j=201;
			this.template=con.getCon2(j);
			//-----------------------------------------------------
			int i=0;
			String query = "select count(*) from staff_attendance where Att_date=to_date('"+Current+"','dd/MM/yyyy') and emp_id='"+emp+"' and type='Present' ";
			System.out.println("cccccccccccccccccccccccccccccccccccc"+query);
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
						  System.out.println("ccc="+i);
					  }
				}
				//i=resultSet.getRow();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			return i;
		} 


	 
	 public int getAttendanceStatus_User_AN(String Current,String emp,int Bcode) {
			//--Set Connection------------------------------------
			int j=201;
			this.template=con.getCon2(j);
			//-----------------------------------------------------
			int i=0;
			String query = "select count(*) from staff_attendance where Att_date=to_date('"+Current+"','dd/MM/yyyy') and emp_id='"+emp+"' and an_type='Present' ";
			System.out.println("cccccccccccccccccccccccccccccccccccc"+query);
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
						  System.out.println("ccc="+i);
					  }
				}
				//i=resultSet.getRow();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			return i;
		} 
	 
	 
	 public String getAttendance_Permission(String user) {
			//--Set Connection------------------------------------
			int j=201;
			this.template=con.getCon2(j);
			//-----------------------------------------------------
			String i="";
			String query = "select Attendance_Level from Employee_master where empid=(select emp_id from logindetails where username='"+user+"')";
			System.out.println("cccccccccccccccccccccccccccccccccccc"+query);
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
						  System.out.println("ccc="+i);
					  }
				}
				//i=resultSet.getRow();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			return i;
		} 

	 
	 
	 public String getUserEmp_id(String User) {
			//--Set Connection----------------------------
					int j=Binfo;
					this.template=con.getCon2(j);
					//-----------------------------------------------------
						String i="NA";
		//	String query = "select count(*) from permission_att where username='"+User+"'";
			String query = "select emp_id from logindetails where username='"+User+"'";

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
	 
	 
	 
	 public String getFN_Status(String Date,String User) {
			//--Set Connection----------------------------
					int j=Binfo;
					this.template=con.getCon2(j);
					//-----------------------------------------------------
						String i="NA";
		//	String query = "select count(*) from permission_att where username='"+User+"'";
			String query = "select Type from Staff_attendance where att_date=to_date('"+Date+"','dd/MM/yyyy') and emp_id='"+User+"'";

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

	 public String getAN_Status(String Date,String User) {
			//--Set Connection----------------------------
					int j=Binfo;
					this.template=con.getCon2(j);
					//-----------------------------------------------------
						String i="NA";
		//	String query = "select count(*) from permission_att where username='"+User+"'";
			String query = "select AN_Type from Staff_attendance where att_date=to_date('"+Date+"','dd/MM/yyyy') and emp_id='"+User+"'";

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
	 
	 
	 
	 public List<SimpleBranch> getManager_Attendance_Report( String Current,int Bcode){
			//--Set Connection----------------------------
					int j=201;
					this.template=con.getCon2(j);
					//-----------------------------------------------------
					//String qry="select main_qry.* from(select a.*,NVL(b.Noofpresent,0) as noofpresent,NVL(c.NoofLate,0) as nooflate,NVL(d.NoofOnduty,0)as noofonduty,NVL(e.NoofAbsent,0) as noofabsent,NVL(f.NoofLeave,0) as noofleave,NVL(g.NotMarked,0)as noofnotmarked,NVL(h.Total,0)as total from (select branch_code,branch_name,'"+Current+"' as Adate from branch_master)a left join (select bcode,NVL(count(*),0) as Noofpresent  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Present' group by bcode)b on a.branch_code=b.bcode left join (select bcode,NVL(count(*),0) as NoofLate  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Late' group by bcode)c on a.branch_code=c.bcode left join (select bcode,NVL(count(*),0) as NoofOnduty  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='OnDuty' group by bcode)d on a.branch_code=d.bcode left join (select bcode,NVL(count(*),0) as NoofAbsent  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Absent' group by bcode)e on a.branch_code=e.bcode left join (select bcode,NVL(count(*),0) as NoofLeave  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Leave' group by bcode)f on a.branch_code=f.bcode left join (select bcode,NVL(count(*),0) as NotMarked  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type is null group by bcode)g on a.branch_code=g.bcode left join (select bcode,NVL(count(*),0) as Total  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy')  group by bcode)h on a.branch_code=h.bcode)main_qry where main_qry.branch_code like '"+Bcode+"%'";
			//03-12-2021
					//String qry="select main_qry.* from(select a.*,NVL(b.Noofpresent,0) as noofpresent,NVL(c.NoofLate,0) as nooflate,NVL(d.NoofOnduty,0)as noofonduty,NVL(e.NoofAbsent,0) as noofabsent,NVL(f.NoofLeave,0) as noofleave,NVL(g.NotMarked,0)as noofnotmarked,NVL(h.Total,0)as total from (select branch_code,branch_name,'"+Current+"' as Adate from branch_master)a left join (select bcode,NVL(count(*),0) as Noofpresent  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Present' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)b on a.branch_code=b.bcode left join (select bcode,NVL(count(*),0) as NoofLate  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Late' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)c on a.branch_code=c.bcode left join (select bcode,NVL(count(*),0) as NoofOnduty  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='OnDuty' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)d on a.branch_code=d.bcode left join (select bcode,NVL(count(*),0) as NoofAbsent  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Absent'  and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)e on a.branch_code=e.bcode left join (select bcode,NVL(count(*),0) as NoofLeave  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Leave' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)f on a.branch_code=f.bcode left join (select bcode,NVL(count(*),0) as NotMarked  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type is null and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)g on a.branch_code=g.bcode left join (select bcode,NVL(count(*),0) as Total  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy')  group by bcode)h on a.branch_code=h.bcode)main_qry where main_qry.branch_code like '"+Bcode+"%' ";
	//16-12-2021
					String qry="select (select branch_name from branch_master where branch_code=a.bcode) as branch_name,a.FN,a.AN,a.FN_time,a.AN_time,a.FN_By,a.AN_By,to_char(a.current_date1,'dd/MM/yyyy') from (select * from attendance_lock where current_date1=to_date('"+Current+"','dd/MM/yyyy') order by bcode)a";

					System.out.println(qry);
					return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
			{  
				SimpleBranch gl=new SimpleBranch();
				gl.setS31(rs.getString(1));
				gl.setS32(rs.getString(2));
				gl.setS33(rs.getString(3));
				gl.setS34(rs.getString(4));
				gl.setS35(rs.getString(5));
				gl.setS36(rs.getString(6));
				gl.setS37(rs.getString(7));
				gl.setS38(rs.getString(8));
				
				
				
			  
								
				return gl;
			}
			 }     );
		}

	 
	 
	 
	 public List<SimpleBranch> getEmployeeDetailsList_Branch_All_Searchs2( String qry){
			//--Set Connection----------------------------
					int j=201;
					this.template=con.getCon2(j);
					//-----------------------------------------------------
				//	String qry="select rownum,main_qry.* from (select a.*,b.FN_Time,b.type,b.REMARKS,b.FN_Branch_status,b.att_date from(select EMPID,EMPNAME,DBCODE,STATUS,DESIGNATION from employee_Master where dbcode like'"+BCode+"%' and (upper(empid) like '%"+value.toUpperCase()+"%' or upper(empname) like '%"+value.toUpperCase()+"%' or upper(DESIGNATION) like '%"+value.toUpperCase()+"%') and attendance_status !='Y' order by EmpId)a left join (select emp_id,to_char(att_date,'dd-MM-yyyy') as att_date,type,FN_Time,Remarks,FN_Branch_status,An_type,An_time,an_remarks from staff_attendance )b on b.emp_id=a.empid and  b.att_date=to_date('"+Current+"','dd/MM/yyyy'))main_qry where (main_qry.FN_Branch_Status is not null or main_qry.AN_Branch_Status is not null) and "+type+"";
					//String qry="select rownum,main_qry.* from (select a.*,b.FN_Time,b.type,b.REMARKS,b.FN_Branch_status,b.att_date,b.an_time,b.an_type,b.an_remarks ,b.an_branch_status from(select EMPID,EMPNAME,DBCODE,STATUS,DESIGNATION from employee_Master where dbcode like '"+BCode+"' and (upper(empid) like '%"+value.toUpperCase()+"%' or upper(empname) like '%"+value.toUpperCase()+"%' or upper(DESIGNATION) like '%"+value.toUpperCase()+"%') and attendance_status !='Y' order by EmpId)a left join (select emp_id,to_char(att_date,'dd-MM-yyyy') as att_date,type,FN_Time,Remarks,FN_Branch_status,An_type,An_time,an_remarks,an_branch_status from staff_attendance )b on b.emp_id=a.empid and  b.att_date=to_date('"+Current+"','dd/MM/yyyy'))main_qry where (main_qry.FN_Branch_Status is not null or main_qry.AN_Branch_Status is not null) and "+type+"";

					System.out.println(qry);
					
					return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
			{  
				SimpleBranch gl=new SimpleBranch();
					gl.setS31(rs.getString(7));
				//gl.setS6(rs.getString(8));
				//gl.setS5(rs.getString(9));
				/*gl.setS32(rs.getString(8));
				gl.setS33(rs.getString(10));
				gl.setS34(rs.getString(9));
				
				gl.setS35(rs.getString(12));
				gl.setS36(rs.getString(13));
				gl.setS37(rs.getString(15));
				gl.setS38(rs.getString(14));*/
				
				gl.setS32(rs.getString(1));
				gl.setS33(rs.getString(2));
				gl.setS34(rs.getString(3));
				
				gl.setS35(rs.getString(4));
				gl.setS36(rs.getString(5));
				gl.setS37(rs.getString(6));
				gl.setS38(rs.getString(7));
				
				
				
			  
								
				return gl;
			}
			 }     );
		}
	 

	 
	 public String getLogin_FN_Time_Start() {
			//--Set Connection------------------------------------
			int j=201;
			this.template=con.getCon2(j);
			//-----------------------------------------------------
			String i="";
			String query = "Select FN_Start from general_settings";
			System.out.println("cccccccccccccccccccccccccccccccccccc"+query);
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
						  System.out.println("ccc="+i);
					  }
				}
				//i=resultSet.getRow();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			return i;
		} 

		public String getLogin_AN_Time_Start() {
			//--Set Connection------------------------------------
			int j=201;
			this.template=con.getCon2(j);
			//-----------------------------------------------------
			String i="";
			String query = "Select AN_Start from general_settings";
			System.out.println("cccccccccccccccccccccccccccccccccccc"+query);
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
						  System.out.println("ccc="+i);
					  }
				}
				//i=resultSet.getRow();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			return i;
		} 

	 
		public int Update_Staff_AttendanceTime_Start(String Current1,String Current2)
		{
			//--Set Connection----------------------------
			int j=201;
			this.template=con.getCon2(j);
		//-----------------------------------------------------
				String sql="update general_settings set FN_Start='"+Current1+"',AN_Start='"+Current2+"'";
						return template.update(sql);
		}
		
		
		
		public int Update_UNLOCK_FN_All_Branch(String Current,String bcode, String user)
		{
			//--Set Connection----------------------------
			int j=201;
			this.template=con.getCon2(j);
		//-----------------------------------------------------
				String sql="update Attendance_Lock  set FN='Y' where  current_date1=to_date('"+Current+"','dd/MM/yyyy') and to_char(bcode) like '"+bcode+"%'";
						return template.update(sql);
		}
		
		public int Update_UNLOCK_AN_All_Branch(String Current,String bcode, String user)
		{
			//--Set Connection----------------------------
			int j=201;
			this.template=con.getCon2(j);
		//-----------------------------------------------------
				String sql="update Attendance_Lock  set AN='Y' where  current_date1=to_date('"+Current+"','dd/MM/yyyy') and to_char(bcode) like '"+bcode+"%'";
						return template.update(sql);
		}
		
		
		
		
		 public String getLogin_FN_Screen_EndTime() {
				//--Set Connection------------------------------------
				int j=201;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				String i="";
				String query = "Select FN_Screen_End from general_settings";
				System.out.println("cccccccccccccccccccccccccccccccccccc"+query);
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
							  System.out.println("ccc="+i);
						  }
					}
					//i=resultSet.getRow();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				return i;
			} 

			public String getLogin_AN_Screen_Start_Time() {
				//--Set Connection------------------------------------
				int j=201;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				String i="";
				String query = "Select AN_Screen from general_settings";
				System.out.println("cccccccccccccccccccccccccccccccccccc"+query);
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
							  System.out.println("ccc="+i);
						  }
					}
					//i=resultSet.getRow();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				return i;
			} 

			public int Update_Staff_AttendanceTime_ANStart(String Current1,String Current2)
			{
				//--Set Connection----------------------------
				int j=201;
				this.template=con.getCon2(j);
			//-----------------------------------------------------
					String sql="update general_settings set FN_Screen_End='"+Current1+"',AN_Screen='"+Current2+"'";
							return template.update(sql);
			}
			
			
			
			
			public String getFN_EndTime() {
				//--Set Connection------------------------------------
				int j=201;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				String i="";
				String query = "Select FN_Screen_End from general_settings";
				System.out.println("cccccccccccccccccccccccccccccccccccc"+query);
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
							  System.out.println("ccc="+i);
						  }
					}
					//i=resultSet.getRow();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				return i;
			} 

			public String getAN_Start_Time() {
				//--Set Connection------------------------------------
				int j=201;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
				String i="";
				String query = "Select AN_Screen from general_settings";
				System.out.println("cccccccccccccccccccccccccccccccccccc"+query);
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
							  System.out.println("ccc="+i);
						  }
					}
					//i=resultSet.getRow();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				return i;
			} 

			
			
			
			//insert staff attendance
			//Birdao.Insert_Staff_Attendance(current, DBCode);
			public void Insert_Staff_Attendance(String Current_date,int Bcode) throws SQLException
			{

				//--Set Connection----------------------------
							int j=201;
							this.template=con.getCon2(j);
				//-----------------------------------------------------
				try
				{
					CallableStatement stmt=template.getDataSource().getConnection().prepareCall("{call Insert_Staff_Enroll(?,?)}");
					stmt.setString(1,Current_date);
					stmt.setInt(2,Bcode);

						
					//stmt.setString(2,Password);  
					//register the OUT parameter before calling the stored procedure
					//stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
						
					stmt.executeQuery();
						
					//read the OUT parameter now
					//Current_date = stmt.getString(1);
					//Connection conString=template.getDataSource().getConnection();
					//conString.
					System.out.println("Update_Calendar_Date in dao="+Current_date);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
					
				}

			
			
			
			public List<SimpleBranch> getEmployeeStatus(){
				//--Set Connection----------------------------
						int j=201;
						this.template=con.getCon2(j);
						//-----------------------------------------------------
							//String qry="select (select branch_name from branch_master where to_char(branch_code)=dbcode) as bname,case when status='A' then 'Active' else case when status='R' then 'Resigned' else case when status='S' then 'Suspended' else 'Inactive' end end end as status2 ,count(*) as no1,(Select count(*) from employee_master)as total from employee_master group by dbcode,status order by dbcode,status2";
                              String qry="select (select branch_name from branch_master where to_char(branch_code)=a.dbcode)as bname,nvl(b.active,0),nvl(c.resigned,0),nvl(d.suspended,0),nvl(e.inactive,0),(select count(*) as activeNo from employee_master where status='A') as ano,(select count(*) as rNo from employee_master where status='R') as rno,(select count(*) as sNo from employee_master where status='S') as sno,(select count(*) as cNo from employee_master where status='C') as cno from (select distinct dbcode from employee_master order by dbcode)a left join (select dbcode,count(*) as active from employee_master where status='A' group by dbcode)b on a.dbcode=b.dbcode left join (select dbcode,count(*) as resigned from employee_master where status='R' group by dbcode)c on a.dbcode=c.dbcode left join (select dbcode,count(*) as suspended from employee_master where status='S' group by dbcode)d on a.dbcode=d.dbcode left join (select dbcode,count(*) as inactive from employee_master where status='C' group by dbcode)e on a.dbcode=e.dbcode";
						System.out.println(qry);
						return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
				{  
					SimpleBranch gl=new SimpleBranch();
					gl.setS31(rs.getString(1));
					gl.setS32(rs.getString(2));
					gl.setS33(rs.getString(3));
					gl.setS34(rs.getString(4));
					gl.setS35(rs.getString(5));
					
					gl.setS36(rs.getString(6));
					gl.setS37(rs.getString(7));
					gl.setS38(rs.getString(8));
					gl.setS39(rs.getString(9));
 
									
					return gl;
				}
				 }     );
			}

			
			
			
			public List<SimpleBranch> getEmployeeAttendanceEnrollmentList(String Current){
				//--Set Connection----------------------------
						int j=201;
						this.template=con.getCon2(j);
						//-----------------------------------------------------
							//String qry="select (select branch_name from branch_master where to_char(branch_code)=dbcode) as bname,case when status='A' then 'Active' else case when status='R' then 'Resigned' else case when status='S' then 'Suspended' else 'Inactive' end end end as status2 ,count(*) as no1,(Select count(*) from employee_master)as total from employee_master group by dbcode,status order by dbcode,status2";
                              String qry="select (select branch_name from branch_master where to_char(branch_code)=bcode)as bname,EMP_ID ,to_char(ATT_DATE,'dd/MM/yyyy') ,Created_By from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') order by emp_id";
						System.out.println(qry);
						return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
				{  
					SimpleBranch gl=new SimpleBranch();
					gl.setS31(rs.getString(1));
					gl.setS32(rs.getString(2));
					gl.setS33(rs.getString(3));
					gl.setS34(rs.getString(4));
					 
									
					return gl;
				}
				 }     );
			}

			
			
			public void Insert_Staff_Attendance_Single(String Current_date,int Bcode,String empid) throws SQLException
			{

				//--Set Connection----------------------------
							int j=201;
							this.template=con.getCon2(j);
				//-----------------------------------------------------
				try
				{
					CallableStatement stmt=template.getDataSource().getConnection().prepareCall("{call INSERT_STAFF_ENROLL_SINGLE(?,?,?)}");
					stmt.setString(1,Current_date);
					stmt.setInt(2,Bcode);
					stmt.setString(3,empid);

						
					//stmt.setString(2,Password);  
					//register the OUT parameter before calling the stored procedure
					//stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
						
					stmt.executeQuery();
						
					//read the OUT parameter now
					//Current_date = stmt.getString(1);
					//Connection conString=template.getDataSource().getConnection();
					//conString.
					System.out.println("Update_Calendar_Date in dao="+Current_date);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
					
				}

			
			
			public int Delete_Staff_Attendance_Single(String Current,String empid) throws SQLException
			{
				//--Set Connection----------------------------
				int j=201;
				this.template=con.getCon2(j);
			//-----------------------------------------------------
					String sql="delete from  staff_attendance where emp_id='"+empid+"'  and att_date=to_date('"+Current+"','dd/MM/yyyy')";
							return template.update(sql);
			}
			
			
			
			
			
			 public List<SimpleBranch> getAttendance_Report_Overall( String Current,int Bcode){
					//--Set Connection----------------------------
							int j=201;
							this.template=con.getCon2(j);
							//-----------------------------------------------------
							//String qry="select main_qry.* from(select a.*,NVL(b.Noofpresent,0) as noofpresent,NVL(c.NoofLate,0) as nooflate,NVL(d.NoofOnduty,0)as noofonduty,NVL(e.NoofAbsent,0) as noofabsent,NVL(f.NoofLeave,0) as noofleave,NVL(g.NotMarked,0)as noofnotmarked,NVL(h.Total,0)as total from (select branch_code,branch_name,'"+Current+"' as Adate from branch_master)a left join (select bcode,NVL(count(*),0) as Noofpresent  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Present' group by bcode)b on a.branch_code=b.bcode left join (select bcode,NVL(count(*),0) as NoofLate  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Late' group by bcode)c on a.branch_code=c.bcode left join (select bcode,NVL(count(*),0) as NoofOnduty  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='OnDuty' group by bcode)d on a.branch_code=d.bcode left join (select bcode,NVL(count(*),0) as NoofAbsent  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Absent' group by bcode)e on a.branch_code=e.bcode left join (select bcode,NVL(count(*),0) as NoofLeave  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Leave' group by bcode)f on a.branch_code=f.bcode left join (select bcode,NVL(count(*),0) as NotMarked  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type is null group by bcode)g on a.branch_code=g.bcode left join (select bcode,NVL(count(*),0) as Total  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy')  group by bcode)h on a.branch_code=h.bcode)main_qry where main_qry.branch_code like '"+Bcode+"%'";
					//03-12-2021
							//String qry="select main_qry.* from(select a.*,NVL(b.Noofpresent,0) as noofpresent,NVL(c.NoofLate,0) as nooflate,NVL(d.NoofOnduty,0)as noofonduty,NVL(e.NoofAbsent,0) as noofabsent,NVL(f.NoofLeave,0) as noofleave,NVL(g.NotMarked,0)as noofnotmarked,NVL(h.Total,0)as total from (select branch_code,branch_name,'"+Current+"' as Adate from branch_master)a left join (select bcode,NVL(count(*),0) as Noofpresent  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Present' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)b on a.branch_code=b.bcode left join (select bcode,NVL(count(*),0) as NoofLate  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Late' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)c on a.branch_code=c.bcode left join (select bcode,NVL(count(*),0) as NoofOnduty  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='OnDuty' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)d on a.branch_code=d.bcode left join (select bcode,NVL(count(*),0) as NoofAbsent  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Absent'  and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)e on a.branch_code=e.bcode left join (select bcode,NVL(count(*),0) as NoofLeave  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Leave' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)f on a.branch_code=f.bcode left join (select bcode,NVL(count(*),0) as NotMarked  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type is null and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)g on a.branch_code=g.bcode left join (select bcode,NVL(count(*),0) as Total  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy')  group by bcode)h on a.branch_code=h.bcode)main_qry where main_qry.branch_code like '"+Bcode+"%' ";
			//31/01/2022
							//String qry="select a.emp_id,(select branch_name from branch_master where branch_code=a.bcode) as branch_name,a.morn,a.even ,case when (a.morn='P' and a.even='P') then 'Full' else case when (a.morn='A' and a.even='P') or (a.morn='P' and a.even='A') then 'Half' else 'A' end end as Status from ( select emp_id,bcode,case when type in ('Present','Onduty','Late') then 'P' else 'A' end as Morn,case when an_type in ('Present','Onduty','Late') then 'P' else 'A' end as Even from STAFF_ATTENDANCE where att_date=to_date('"+Current+"','dd/MM/yyyy') order by bcode)a where a.bcode like '"+Bcode+"%'  order by a.bcode,a.emp_id";
							String qry="select b.*,b.morn_present+b.even_present as total  from (select a.emp_id,(select branch_name from branch_master where branch_code=a.bcode) as branch_name,a.morn,a.even ,case when (a.morn='P' and a.even='P') then 'Full' else case when (a.morn='A' and a.even='P') or (a.morn='P' and a.even='A') then 'Half' else 'A' end end as Status, case when a.morn='P' then 1 else 0 end  as morn_present,case when a.even='P' then 1 else 0 end  as even_present,a.bcode from ( select emp_id,bcode,case when type in ('Present','OnDuty','Late') then 'P' else 'A' end as Morn,case when an_type in ('Present','OnDuty','Late') then 'P' else 'A' end as Even from STAFF_ATTENDANCE where att_date=to_date('"+Current+"','dd/MM/yyyy') order by bcode)a)b  where b.bcode like '"+Bcode+"%' and b.morn_present+b.even_present>0 order by b.bcode,b.emp_id";
							System.out.println(qry);
							return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
					{  
						SimpleBranch gl=new SimpleBranch();
						gl.setS31(rs.getString(1));
						gl.setS32(rs.getString(2));
						gl.setS33(rs.getString(3));
						gl.setS34(rs.getString(4));
						gl.setS35(rs.getString(5));
						
						gl.setS1(rs.getInt(6));
						gl.setS11(rs.getInt(7));
						
						if(rs.getInt(9)>0)
						{
							gl.setS12(1);
						}
						else
							gl.setS12(0);
						
						
						
						
					  
										
						return gl;
					}
					 }     );
				}
			 
			 
			 
			 
			 
			 public List<SimpleBranch> getAttendance_Report_Overall_Absent( String Current,int Bcode){
					//--Set Connection----------------------------
							int j=201;
							this.template=con.getCon2(j);
							//-----------------------------------------------------
							//String qry="select main_qry.* from(select a.*,NVL(b.Noofpresent,0) as noofpresent,NVL(c.NoofLate,0) as nooflate,NVL(d.NoofOnduty,0)as noofonduty,NVL(e.NoofAbsent,0) as noofabsent,NVL(f.NoofLeave,0) as noofleave,NVL(g.NotMarked,0)as noofnotmarked,NVL(h.Total,0)as total from (select branch_code,branch_name,'"+Current+"' as Adate from branch_master)a left join (select bcode,NVL(count(*),0) as Noofpresent  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Present' group by bcode)b on a.branch_code=b.bcode left join (select bcode,NVL(count(*),0) as NoofLate  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Late' group by bcode)c on a.branch_code=c.bcode left join (select bcode,NVL(count(*),0) as NoofOnduty  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='OnDuty' group by bcode)d on a.branch_code=d.bcode left join (select bcode,NVL(count(*),0) as NoofAbsent  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Absent' group by bcode)e on a.branch_code=e.bcode left join (select bcode,NVL(count(*),0) as NoofLeave  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Leave' group by bcode)f on a.branch_code=f.bcode left join (select bcode,NVL(count(*),0) as NotMarked  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type is null group by bcode)g on a.branch_code=g.bcode left join (select bcode,NVL(count(*),0) as Total  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy')  group by bcode)h on a.branch_code=h.bcode)main_qry where main_qry.branch_code like '"+Bcode+"%'";
					//03-12-2021
							//String qry="select main_qry.* from(select a.*,NVL(b.Noofpresent,0) as noofpresent,NVL(c.NoofLate,0) as nooflate,NVL(d.NoofOnduty,0)as noofonduty,NVL(e.NoofAbsent,0) as noofabsent,NVL(f.NoofLeave,0) as noofleave,NVL(g.NotMarked,0)as noofnotmarked,NVL(h.Total,0)as total from (select branch_code,branch_name,'"+Current+"' as Adate from branch_master)a left join (select bcode,NVL(count(*),0) as Noofpresent  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Present' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)b on a.branch_code=b.bcode left join (select bcode,NVL(count(*),0) as NoofLate  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Late' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)c on a.branch_code=c.bcode left join (select bcode,NVL(count(*),0) as NoofOnduty  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='OnDuty' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)d on a.branch_code=d.bcode left join (select bcode,NVL(count(*),0) as NoofAbsent  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Absent'  and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)e on a.branch_code=e.bcode left join (select bcode,NVL(count(*),0) as NoofLeave  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type='Leave' and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)f on a.branch_code=f.bcode left join (select bcode,NVL(count(*),0) as NotMarked  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy') and type is null and emp_id  in (select EMPID from employee_Master where Attendance_status!='Y') group by bcode)g on a.branch_code=g.bcode left join (select bcode,NVL(count(*),0) as Total  from staff_attendance where att_date=to_date('"+Current+"','dd/MM/yyyy')  group by bcode)h on a.branch_code=h.bcode)main_qry where main_qry.branch_code like '"+Bcode+"%' ";
			//31/01/2022
							//String qry="select a.emp_id,(select branch_name from branch_master where branch_code=a.bcode) as branch_name,a.morn,a.even ,case when (a.morn='P' and a.even='P') then 'Full' else case when (a.morn='A' and a.even='P') or (a.morn='P' and a.even='A') then 'Half' else 'A' end end as Status from ( select emp_id,bcode,case when type in ('Present','Onduty','Late') then 'P' else 'A' end as Morn,case when an_type in ('Present','Onduty','Late') then 'P' else 'A' end as Even from STAFF_ATTENDANCE where att_date=to_date('"+Current+"','dd/MM/yyyy') order by bcode)a where a.bcode like '"+Bcode+"%'  order by a.bcode,a.emp_id";
							String qry="select b.*,b.morn_present+b.even_present as total  from (select a.emp_id,(select branch_name from branch_master where branch_code=a.bcode) as branch_name,a.morn,a.even ,case when (a.morn='A' and a.even='A') then 'Full' else case when (a.morn='A' and a.even='P') or (a.morn='P' and a.even='A') then 'Half' else 'P' end end as Status, case when a.morn='A' then 1 else 0 end  as morn_present,case when a.even='A' then 1 else 0 end  as even_present,a.bcode from ( select emp_id,bcode,case when type in ('Absent','Leave') then 'A' else 'P' end as Morn,case when an_type in ('Absent','Leave') then 'A' else 'P' end as Even from STAFF_ATTENDANCE where att_date=to_date('"+Current+"','dd/MM/yyyy') order by bcode)a)b  where b.bcode like '"+Bcode+"%'  and b.morn_present+b.even_present>0 order by b.bcode,b.emp_id";
							System.out.println(qry);
							return template.query(qry,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
					{  
						SimpleBranch gl=new SimpleBranch();
						gl.setS31(rs.getString(1));
						gl.setS32(rs.getString(2));
						gl.setS33(rs.getString(3));
						gl.setS34(rs.getString(4));
						gl.setS35(rs.getString(5));
						
						gl.setS1(rs.getInt(6));
						gl.setS11(rs.getInt(7));
						
						if(rs.getInt(9)>0)
						{
							gl.setS12(1);
						}
						else
							gl.setS12(0);
						
						
						
						
					  
										
						return gl;
					}
					 }     );
				}

			//08-02-2023
			 public List<SimpleBranch>All_Report_Log(String From_Date,String To_Date,String Type,int Bcode)
			 				{
			 					//--Set Connection------------------------------------
			 					int j=Binfo;
			 					this.template=con.getCon2(j);
			 					//-----------------------------------------------------
			 				 	//String sql="select TYPE,CREATED_BY,CREATED_DATE,TIME_INFO ,branch from Operational_Log where created_date Between To_Date('"+From_Date+"','dd/MM/yyyy') And To_Date('"+To_Date+"','dd/MM/yyyy') and type='"+Type+"' ORDER BY Created_date";

			 				 	String sql="select TYPE,CREATED_BY,CREATED_DATE,TIME_INFO ,branch from Operational_Log where created_date Between To_Date('"+From_Date+"','dd/MM/yyyy') And To_Date('"+To_Date+"','dd/MM/yyyy') and type like '"+Type+"' and created_by not in ('General','sys') and type not in ('Corporate User Permision','Corporate User Permission Locked','Employee Master','Employee Master','Employee Master Delete','FD Master Update','Member Updation','Trial Balance Report','Trial Balance Report4') ORDER BY Created_date,TO_TIMESTAMP(TIME_INFO, 'dd/MM/yyyy HH:MI:SS AM')";
			 				 System.out.println(sql);
			 					return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
			 																							{  
			 					
			 						SimpleBranch gl=new SimpleBranch();
			 					   	gl.setS31(rs.getString(1));//ttransid
			 						gl.setS32(rs.getString(2));//date
			 						gl.setS33(rs.getString(3));//created
			 						gl.setS34(rs.getString(4));//time
			 						gl.setS35(rs.getString(5));//jltype
			 						gl.setS15(rs.getDate(3)); //Created Date
			 						
			 						
			 					
			 					return gl;
			 																							}
			 																						 }     );
			 				}
			 
			 
			 
			 //06-07-2023
			 public List<SimpleBranch>getAllAccountListSearch_Transaction_Log_Branch(String From_Date,String To_Date,String searchKey,int Bcode)
				{
					//--Set Connection------------------------------------
					
					
					int j=Bcode;
					this.template=con.getCon2(j);
					//-----------------------------------------------------

				 //String sql="select Customer_Id,Customer_Name,Account_No,To_Char(Open_Date,'dd/MM/yyyy'),Loan_Amount,Period_Days,Interest_Rate,Account_Status,branch,jltype from JL_Master_view where open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') and Scheme_Code in (Select Scheme_Code from Scheme_Master where Scheme_Category='JL')and (ACCOUNT_NO LIKE '%"+searchKey+"%' or CUSTOMER_ID LIKE '%"+searchKey+"%' or upper(CUSTOMER_NAME) like '%"+searchKey.toUpperCase()+"%') order by Account_No desc";
				 //String sql="select a.*,(select branch_name from branch_master where to_char(branch_code)=a.Branch)as branch2 from(select Customer_Id,Customer_Name,Account_No,To_Char(Open_Date,'dd/MM/yyyy'),Loan_Amount,Period_Days,Interest_Rate,Account_Status,branch,jltype from JL_Master_view where open_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') and Scheme_Code in (Select Scheme_Code from Scheme_Master where Scheme_Category='JL')and (ACCOUNT_NO LIKE '%"+searchKey+"%' or CUSTOMER_ID LIKE '%"+searchKey+"%' or upper(CUSTOMER_NAME) like '%"+searchKey.toUpperCase()+"%') order by Account_No desc)a";
				 //String sql="select a.Transaction_Id,to_Date(a.Transaction_Date,'dd/MM/yyyy'),a.Created_By,a.Time_Info,a.Authorized_By,a.Authorized_Time,a.Verified_By,a.Verified_Time,a.Verified_By_3,a.Verified_3_Time,a.Verified_By_4,a.Verified_4_Time,a.Verified_By_5 ,a.Verified_5_Time,(select Branch_Name from Branch_Master where Branch_Code=a.Branch) as Branch,a.Account_Desc,a.transaction_Amount from (Select Transaction_Id,to_char(Transaction_Date,'dd/MM/yyyy') as Transaction_Date ,Created_By,Time_Info,Authorized_By,Authorized_Time,Verified_By,Verified_Time,Verified_By_3,Verified_3_Time,Verified_By_4,Verified_4_Time,Verified_By_5 ,Verified_5_Time,Branch,transaction_date as tdate,transaction_particulars,transaction_amount,Account_Desc From DAILY_TRANSACTION_LOG Where Part_Tran_Id=1 and Transaction_Date Between To_Date('"+From_Date+"','dd/MM/yyyy') And To_Date('"+To_Date+"','dd/MM/yyyy'))a";

				 //20/10/2022
				 //String sql="select a.Transaction_Id,to_Date(a.Transaction_Date,'dd/MM/yyyy'),a.Created_By,a.Time_Info,a.Authorized_By,a.Authorized_Time,a.Verified_By,a.Verified_Time,a.Verified_By_3,a.Verified_3_Time,a.Verified_By_4,a.Verified_4_Time,a.Verified_By_5 ,a.Verified_5_Time,(select Branch_Name from Branch_Master where Branch_Code=a.Branch) as Branch,a.Account_Desc,a.transaction_Amount,case when (a.page_source='EOM' or b.voucher_type is null) THEN 'Adjustment' ELSE  case when a.page_source='SBP' then 'Payment' else b.voucher_type end end as voucher_type,case when a.page_source='EOM' THEN 'EOM Transacrion' else case when a.page_source='SBP' then 'SD Int Posting' else Case when b.mode1 is null then a.page_source else b.trfr_acc_type end end end as Mode1,b.trfr_acc_no,b.trfr_acc_type from (Select Transaction_Id,to_char(Transaction_Date,'dd/MM/yyyy') as Transaction_Date ,Created_By,Time_Info,Authorized_By,Authorized_Time,Verified_By,Verified_Time,Verified_By_3,Verified_3_Time,Verified_By_4,Verified_4_Time,Verified_By_5 ,Verified_5_Time,Branch,transaction_date as tdate,transaction_particulars,transaction_amount,Account_Desc,page_source From DAILY_TRANSACTION_LOG Where Part_Tran_Id=1 and Transaction_Date Between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') and to_char(Branch) like '"+Bcode+"%' order by branch,Transaction_Date desc,to_number(substr(to_char(Transaction_Id),-5,5)) desc)a   left join (select transaction_id,transaction_date,voucher_type,mode1,trfr_acc_no,trfr_acc_type from voucher_print_view )b on a.transaction_id=b.transaction_id and a.transaction_date=b.transaction_date ";

					//06-07-2023
					 String sql="select a.Transaction_Id,to_Date(a.Transaction_Date,'dd/MM/yyyy'),a.Created_By,a.Time_Info,a.Authorized_By,a.Authorized_Time,a.Verified_By,a.Verified_Time,a.Verified_By_3,a.Verified_3_Time,a.Verified_By_4,a.Verified_4_Time,a.Verified_By_5 ,a.Verified_5_Time,(select BName from General_Settings ) as Branch,a.Account_Desc,a.transaction_Amount,case when (a.page_source='EOM' or b.voucher_type is null) THEN 'Adjustment' ELSE  case when a.page_source='SBP' then 'Payment' else b.voucher_type end end as voucher_type,case when a.page_source='EOM' THEN 'EOM Transacrion' else case when a.page_source='SBP' then 'SD Int Posting' else Case when b.mode1 is null then a.page_source else b.trfr_acc_type end end end as Mode1,b.trfr_acc_no,b.trfr_acc_type from (Select Transaction_Id,to_char(Transaction_Date,'dd/MM/yyyy') as Transaction_Date ,Created_By,Time_Info,Authorized_By,Authorized_Time,Verified_By,Verified_Time,Verified_By_3,Verified_3_Time,Verified_By_4,Verified_4_Time,Verified_By_5 ,Verified_5_Time,'201' as Branch,transaction_date as tdate,transaction_particulars,transaction_amount,Account_Desc,page_source From DAILY_TRANSACTION Where Part_Tran_Id=1 and Transaction_Date Between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy')  order by Transaction_Date desc,to_number(substr(to_char(Transaction_Id),-5,5)) desc)a   left join (select transaction_id,transaction_date,voucher_type,mode1,trfr_acc_no,trfr_acc_type from voucher_print )b on a.transaction_id=b.transaction_id and a.transaction_date=b.transaction_date";

				 System.out.println(sql);
					return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																							{  
					
						SimpleBranch gl=new SimpleBranch();
					   	gl.setS31(rs.getString(1));//ttransid
					//	gl.setS32(rs.getString(2));//date
						gl.setS33(rs.getString(3));//created
						gl.setS34(rs.getString(4));//time
						gl.setS35(rs.getString(5));//jltype
						gl.setS36(rs.getString(6));//jltype
						gl.setS37(rs.getString(7));//jltype
						gl.setS38(rs.getString(8));//jltype
						gl.setS39(rs.getString(9));//jltype
						gl.setS40(rs.getString(10));//jltype
						
						gl.setS2(rs.getString(11));//ttransid
						gl.setS3(rs.getString(12));//date
						gl.setS4(rs.getString(13));//created
						gl.setS5(rs.getString(14));//time
						gl.setS10(rs.getString(15));//bname
						
						
						//03-03-2022
						gl.setS16(rs.getDate(2));
						gl.setS133(rs.getString(16));//Particulars
						gl.setS141(rs.getDouble(17));//amount 
						
						//17-10-2022
						gl.setS134(rs.getString(18));//Type
						gl.setS135(rs.getString(19));//Mode
					
						
					
					return gl;
																							}
																						 }     );
				}
			 
			 public List<SimpleBranch>getAllAccountListSearch_Narration_Log(String From_Date,String To_Date,String Bcode)
				{
					//--Set Connection------------------------------------
					
					
					int j=Binfo;
					this.template=con.getCon2(j);
					//-----------------------------------------------------

				
				 //20/10/2022
				 String sql="select a.Type,a.created_by,a.created_date,a.Time_info,a.branch,a.file_type,a.transaction_Id,to_date(a.transaction_date,'dd/MM/yyyy') as Tran_date,a.particulars,(select Branch_Name from Branch_Master where Branch_Code=a.Branch) as Bname from (select * from Operational_Log where Created_Date between '"+From_Date+"' and '"+To_Date+"' and Branch like '"+Bcode+"' and Type='Narration Edit')a";

				 System.out.println(sql);
					return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																							{  
					
						SimpleBranch gl=new SimpleBranch();
					   	gl.setS31(rs.getString(1));//Type
					
						gl.setS33(rs.getString(2));//created by
						gl.setS121(rs.getDate(3));//created date
						gl.setS35(rs.getString(4));//Time info
						gl.setS1(rs.getInt(5));//Branch
						gl.setS31(rs.getString(6)); //old particulars
						gl.setS37(rs.getString(10));//Branch name
						gl.setS32(rs.getString(7));//tran id
						gl.setS122(rs.getDate(8));//tran date
						gl.setS34(rs.getString(9));//new particulars
						
					return gl;
																							}
																						 }     );
				}


			 
			 public List<SimpleBranch>getAllAccountListSearch_GL_Log(String From_Date,String To_Date,String Bcode)
				{
					//--Set Connection------------------------------------
					
					
					int j=Binfo;
					this.template=con.getCon2(j);
					//-----------------------------------------------------

				
				 //20/10/2022
				 String sql="select a.Type,a.created_by,a.created_date,a.Time_info,a.branch,a.file_type,a.transaction_Id,to_date(a.transaction_date,'dd/MM/yyyy') as Tran_date,a.particulars,(select Branch_Name from Branch_Master where Branch_Code=a.Branch) as Bname from (select * from Operational_Log where Created_Date between '"+From_Date+"' and '"+To_Date+"' and Branch like '"+Bcode+"' and Type='GL Edit')a";

				 System.out.println(sql);
					return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																							{  
					
						SimpleBranch gl=new SimpleBranch();
					   	gl.setS31(rs.getString(1));//Type
					
						gl.setS33(rs.getString(2));//created by
						gl.setS121(rs.getDate(3));//created date
						gl.setS35(rs.getString(4));//Time info
						gl.setS1(rs.getInt(5));//Branch
						gl.setS31(rs.getString(6)); //old particulars
						gl.setS37(rs.getString(10));//Branch name
						gl.setS32(rs.getString(7));//tran id
						gl.setS122(rs.getDate(8));//tran date
						gl.setS34(rs.getString(9));//new particulars
						
					return gl;
																							}
																						 }     );
				}



			 
			 
			 public List<SimpleBranch>Get_CashDenomination_Details(String From_Date,String To_Date,String searchKey,int branch,int Bcode)
				{
					//--Set Connection------------------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
					//-----------------------------------------------------
					String tname="";
					if(searchKey.equalsIgnoreCase("Cash_Denomination"))
					{
						tname="Cash_Denomination";
					}
					else if(searchKey.equalsIgnoreCase("Platinaum_Denomination"))
					{
						tname="Cash_Denomination_Hub";
					}
					else if(searchKey.equalsIgnoreCase("PlatinaumHub_Denomination"))
					{
						tname="Cash_Denomination_Poorana";
					}
					String sql="select (Select branch_name from branch_Master where branch_code=branch) as bname,TRANSACTION_DATE,RS_2000,RS_1000,RS_500,RS_100,RS_50,RS_20,RS_10,RS_5,ADJUSTMENTS,COINS,CASH_BALANCE,CREATED_BY,CREATED_DATE,MODIFIED_BY,MODIFIED_DATE,RS_200,STATUS,DAYEND from "+tname+"_table where transaction_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') and branch like '%"+branch+"%' order by branch"; 	
					System.out.println(sql);
					return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																							{  
					
						SimpleBranch gl=new SimpleBranch();
					   	gl.setS31(rs.getString(1));//branch_name
					   	gl.setS121(rs.getDate(2));//date
					   	gl.setS41(rs.getInt(3));//2000
						gl.setS42(rs.getInt(4));//1000
						gl.setS43(rs.getInt(5));//500
						gl.setS44(rs.getInt(18));//200
						gl.setS45(rs.getInt(6));//100
						gl.setS46(rs.getInt(7));//50
						gl.setS47(rs.getInt(8));//20
						gl.setS48(rs.getInt(9));//10
						gl.setS49(rs.getInt(10));//5
						gl.setS11(rs.getInt(11));//Adjust
						gl.setS12(rs.getInt(12));//coin
						gl.setS141(rs.getDouble(13));//Total
					 	gl.setS32(rs.getString(14));//Created By
					 	gl.setS33(rs.getString(19));//Approval Status
					 	gl.setS34(rs.getString(20));//Dayend Status
						
					
					return gl;
																							}
																						 }     );
				}
			 
			 public List<SimpleBranch>getAllAccountListBank_Transaction_Report(String From_Date,String To_Date,String searchKey,int Bcode)
				{
					//--Set Connection------------------------------------
					
					
					int j=Binfo;
					this.template=con.getCon2(j);
					//-----------------------------------------------------

					 String sql="select a.Transaction_Id,a.Transaction_Date,a.Created_By,a.Time_Info,a.Authorized_By,a.Authorized_Time,a.Verified_By,a.Verified_Time,a.Verified_By_3,a.Verified_3_Time,a.Verified_By_4,a.Verified_4_Time,a.Verified_By_5 ,a.Verified_5_Time,(select Branch_Name from Branch_Master where Branch_Code=a.Branch) as Branch,a.Account_Desc,a.transaction_Amount,case when (a.page_source='EOM' or b.voucher_type is null) THEN 'Adjustment' ELSE  case when a.page_source='SBP' then 'Payment' else b.voucher_type end end as voucher_type,case when a.page_source='EOM' THEN 'EOM Transacrion' else case when a.page_source='SBP' then 'SD Int Posting' else Case when b.mode1 is null then a.page_source else b.trfr_acc_type end end end as Mode1,b.trfr_acc_no,b.trfr_acc_type ,b.utr,b.utr_bank from (Select Transaction_Id,Transaction_Date,Created_By,Time_Info,Authorized_By,Authorized_Time,Verified_By,Verified_Time,Verified_By_3,Verified_3_Time,Verified_By_4,Verified_4_Time,Verified_By_5 ,Verified_5_Time,Branch,transaction_date as tdate,transaction_particulars,transaction_amount,Account_Desc,page_source From DAILY_TRANSACTION_LOG Where Part_Tran_Id=1 and Transaction_Date Between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') and to_char(Branch) like '"+Bcode+"%' order by branch,Transaction_Date desc,to_number(substr(to_char(Transaction_Id),-5,5)) desc)a   right join (select transaction_id,transaction_date,voucher_type,mode1,trfr_acc_no,trfr_acc_type,utr,utr_bank from voucher_print_view  where utr is not null and Transaction_Date Between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') and to_char(Branch) like '"+Bcode+"%')b on a.transaction_id=b.transaction_id and a.transaction_date=b.transaction_date and b.utr_bank is not null";
	 System.out.println(sql);
					return template.query(sql,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
																							{  
					
						SimpleBranch gl=new SimpleBranch();
					   	gl.setS31(rs.getString(1));//ttransid
					//	gl.setS32(rs.getString(2));//date
						gl.setS33(rs.getString(3));//created
						gl.setS34(rs.getString(4));//time
						gl.setS35(rs.getString(5));//jltype
						gl.setS36(rs.getString(6));//jltype
						gl.setS37(rs.getString(7));//jltype
						gl.setS38(rs.getString(8));//jltype
						gl.setS39(rs.getString(9));//jltype
						gl.setS40(rs.getString(10));//jltype
						
						gl.setS2(rs.getString(11));//ttransid
						gl.setS3(rs.getString(12));//date
						gl.setS4(rs.getString(13));//created
						gl.setS5(rs.getString(14));//time
						gl.setS10(rs.getString(15));//bname
						
						
						//03-03-2022
						gl.setS16(rs.getDate(2));
						gl.setS133(rs.getString(16));//Particulars
						gl.setS141(rs.getDouble(17));//amount 
						
						//17-10-2022
						gl.setS134(rs.getString(18));//Type
						gl.setS135(rs.getString(19));//Mode
					
						gl.setS136(rs.getString(22));//UTR Ref
						gl.setS137(rs.getString(23));//UTR Bank
					
					
					return gl;
																							}
																						 }     );
				}

	}
