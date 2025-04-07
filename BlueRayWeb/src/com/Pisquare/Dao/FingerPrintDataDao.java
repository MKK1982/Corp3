package com.Pisquare.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Pisquare.Beans.FingerPrint_Master;
import com.Pisquare.Beans.SimpleBranch;
import com.Pisquare.Controllers.Configuration_Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;



public class FingerPrintDataDao {
	
	int Binfo=201;

	public FingerPrintDataDao() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private Configuration_Controller con;
	
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) throws SQLException
	{
		
		this.template=template;
	
	}
	
	public int RegisterFingerData(FingerPrint_Master fpm,String user,String sysDate,int ImageId,int DBCode) throws SQLException{  

		int i=ImageId;
					
					
			            
						
				          Connection   con = template.getDataSource().getConnection();
				             con.setAutoCommit(false);
				          //  PreparedStatement ps = con.prepareStatement("update Customer set Photo=?,SIGNATURE=? where Customer_Id=?");
				             PreparedStatement ps = con.prepareStatement("insert into FingerPrint_Master(IMAGE_INFO,STATUS,CREATED_DATE,CREATED_BY,SERIALNO,LOCALMAC,LOCALIP,SYSTEMID,PUBLICIP,USERNAME,DESCRIPTION,customer_id) values (?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?)");
				             // size must be converted to int otherwise it results in error
				             //ps.setBinaryStream(1, proof1.getInputStream(), (int)  proof1.getSize());
				         
				          ps.setString(1, fpm.getAnsiImage());
				          ps.setString(2, "A");
				          
				          ps.setString(3, sysDate);
				          ps.setString(4, user);
				          ps.setString(5, fpm.getSerialNo());
				          ps.setString(6, fpm.getLocalMac());
				          ps.setString(7, fpm.getLocalIP());
				          ps.setString(8, fpm.getSystemID());
				          ps.setString(9, fpm.getPublicIP());
				        			        
				          ps.setString(10, fpm.getUsername());
				          ps.setString(11, fpm.getFingerInfo());
				          ps.setString(12, ""+i);
				          
				      System.out.println("Before Save.................fpm.getSerialNo()...."+fpm.getSerialNo());
				      System.out.println("Before Save..................fpm.getLocalMac()="+fpm.getLocalMac());
				      System.out.println("Before Save.......................fpm.getLocalIP()=....."+fpm.getLocalIP());
				      System.out.println("Before Save............................fpm.getSystemID()="+fpm.getSystemID());
				      System.out.println("Before Save............................ fpm.getPublicIP()="+ fpm.getPublicIP());
				      System.out.println("Before Save............................fpm.getUsername()="+fpm.getUsername());
				              ps.executeUpdate();
				             
				             con.commit();
				             con.close();
				             i= 2;
				      
					return i; 
					}
		

	public List<FingerPrint_Master>getFinger_PrintData(int Bcode)
	{

		//--Set Connection------------------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
		//-----------------------------------------------------
		return template.query("select Customer_Id,Image_Info from FingerPrint_Master where status='A'",new RowMapper<FingerPrint_Master>(){   public FingerPrint_Master mapRow(ResultSet rs, int row) throws SQLException
																				{  
		
			FingerPrint_Master c=new FingerPrint_Master();
																					c.setCustomer_Id(rs.getString(1));
																					c.setAnsiImage(rs.getString(2));
																					return c;
																				}
	 																		 }     );
	}
		
	
	public List<FingerPrint_Master>getFinger_PrintData_Individual(String UserName,int Bcode)
	{

		//--Set Connection------------------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
		//-----------------------------------------------------
		return template.query("select Customer_Id,Image_Info from FingerPrint_Master where status='A' and UserName=?",new RowMapper<FingerPrint_Master>(){   public FingerPrint_Master mapRow(ResultSet rs, int row) throws SQLException
																				{  
		
			FingerPrint_Master c=new FingerPrint_Master();
																					c.setCustomer_Id(rs.getString(1));
																					c.setAnsiImage(rs.getString(2));
																					return c;
																				}
	 																		 }     );
	}
		
	
	public List<SimpleBranch>getFinger_Details(String UserName,int Bcode)
	{

		//--Set Connection------------------------------------
		int j=Bcode;
		this.template=con.getCon2(j);
//-----------------------------------------------------
	
	 List<SimpleBranch> gl= new ArrayList<>();	
		PreparedStatement pstmt = null;
		 	
		try {
			pstmt = template.getDataSource().getConnection().prepareStatement("select CUSTOMER_ID,IMAGE_INFO,STATUS,to_char(CREATED_DATE,'dd/MM/yyyy'),CREATED_BY,USERNAME,DESCRIPTION from FingerPrint_Master where status='A' and USERNAME=?");
			pstmt.setString(1, UserName);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		
	
		try {
			rs = pstmt.executeQuery();
		while(rs.next())
		{
			SimpleBranch c=new SimpleBranch();
			c.setS31(rs.getString(1));
			c.setS32(rs.getString(6));
			c.setS33(rs.getString(3));
			c.setS34(rs.getString(4));
			c.setS35(rs.getString(7));
			c.setS36(rs.getString(5));
			
			
System.out.println("rs.getString(2)="+rs.getString(1)+",rs.getString(6)="+rs.getString(6));
			gl.add(c);
			
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return gl;
	}
	
	
	public int deleteFingerPrint(String id,String UserName,int Bcode){  
		//--Set Connection----------------------------
				int j=Bcode;
				this.template=con.getCon2(j);
				//-----------------------------------------------------

	  /*  String sql="delete from SHARE_MASTER where ACCOUNT_NO='"+bcode+"'";  
	    String cuslinkDelete="delete from CUST_ACC_LINK where ACCOUNT_NO='"+bcode+"'";
	    template.update(cuslinkDelete);
	    return template.update(sql); */
				
				try
				  {

			       Connection   con = template.getDataSource().getConnection();
				     PreparedStatement ps = con.prepareStatement("delete from FingerPrint_Master where username=? and to_char(Customer_id)=?");
				    ps.setString(1,UserName);
				    ps.setString(2,id);
				  
				    ps.executeUpdate();
				    ps.close();
				    
			       }
		                 catch (SQLException ex)
		                {
		                	 ex.getMessage();
		                }
				
			
				
				return 1;
	    
	    
	}
	
	
	public int getFinger_Count(String UserName,int Bcode) {
		//--Set Connection----------------------------
		int j=Bcode;
		this.template=con.getCon2(j);
		//-----------------------------------------------------
		
		int i=0;
		String query = "select count(*)  from FingerPrint_MASTER where UserName=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = template.getDataSource().getConnection().prepareStatement(query);
			pstmt.setString(1,UserName);
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
	
		System.out.println("AccNoFrom db="+i);
		return i;
	} 
	
	
	public List<SimpleBranch>getFinger_Details_Check(String UserName,int Bcode)
	{

		//--Set Connection------------------------------------
		int j=Bcode;
		this.template=con.getCon2(j);
//-----------------------------------------------------
	
	 List<SimpleBranch> gl= new ArrayList<>();	
		PreparedStatement pstmt = null;
		 	
		try {
			pstmt = template.getDataSource().getConnection().prepareStatement("select CUSTOMER_ID,IMAGE_INFO,STATUS,to_char(CREATED_DATE,'dd/MM/yyyy'),CREATED_BY,USERNAME,DESCRIPTION from FingerPrint_Master where status='A' and USERNAME=?");
			pstmt.setString(1, UserName);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		
	
		try {
			rs = pstmt.executeQuery();
		while(rs.next())
		{
			SimpleBranch c=new SimpleBranch();
			c.setS31(rs.getString(6));
			c.setS32(rs.getString(2));
			c.setS33(rs.getString(4));
			c.setS34(rs.getString(5));
			c.setS35(rs.getString(7));
			
			
System.out.println("rs.getString(2)="+rs.getString(1)+",rs.getString(6)="+rs.getString(6));
			gl.add(c);
			
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return gl;
	}
		
	
	
	
	public int Check_Already_User_Finger(String User_Id,String Siid)
	{

		//--Set Connection----------------------------
		int j=Binfo;
		this.template=con.getCon2(j);
		//-----------------------------------------------------


		int i=0;
		String query = "Select count(*) from FINGER_CORPLOGIN where Username='"+User_Id+"' and sessionid='"+Siid+"' and status='Y'";
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
	
	
	public int saveFingerLogin(String username,String siid){

		//--Set Connection----------------------------
		int j=Binfo;
		this.template=con.getCon2(j);
		//-----------------------------------------------------
		int i=0;
	    String sql="insert into FINGER_CORPLOGIN(username,sessionid,status) values('"+username+"','"+siid+"','Y')";
	    
	    
	   i=template.update(sql); 
	    
	    return i; 
	} 
	
	
	
	public int UpdateFingerLogin(String username,String siid){

		//--Set Connection----------------------------
		int j=Binfo;
		this.template=con.getCon2(j);
		//-----------------------------------------------------
		int i=0;
	    String sql="Update FINGER_CORPLOGIN set Status='Y' where username='"+username+"' and sessionid='"+siid+"'";
	    
	    
	   i=template.update(sql); 
	    
	    return i; 
	} 
	public int UpdateFingerLoginNo(String username,String siid){

		//--Set Connection----------------------------
		int j=Binfo;
		this.template=con.getCon2(j);
		//-----------------------------------------------------
		int i=0;
	    String sql="Update FINGER_CORPLOGIN set Status='N' where username='"+username+"'";
	    
	    
	   i=template.update(sql); 
	    
	    return i; 
	} 
	
	
	
	public int Check_Already_User_Finger_CCount(String User_Id,String Siid)
	{

		//--Set Connection----------------------------
		int j=Binfo;
		this.template=con.getCon2(j);
		//-----------------------------------------------------


		int i=0;
		String query = "Select count(*) from FINGER_CCount where Username='"+User_Id+"' and sessionid='"+Siid+"'";
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

	public int saveFingerCCount(String username,String siid){

		//--Set Connection----------------------------
		int j=Binfo;
		this.template=con.getCon2(j);
		//-----------------------------------------------------
		int i=0;
	    String sql="insert into FINGER_CCount(username,sessionid) values('"+username+"','"+siid+"')";
	    
	    
	   i=template.update(sql); 
	    
	    return i; 
	} 
	
	
	public int Check_Already_User_Session(String Siid)
	{

		//--Set Connection----------------------------
		int j=Binfo;
		this.template=con.getCon2(j);
		//-----------------------------------------------------


		int i=0;
		String query = "Select count(*) from FINGER_CORPLOGIN where sessionid='"+Siid+"'and status='Y' ";
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

}
