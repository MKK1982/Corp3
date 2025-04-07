





package com.Pisquare.Dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.List.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.Pisquare.Beans.Branch_Master;
import com.Pisquare.Beans.Cus;
import com.Pisquare.Beans.GL_Master;
import com.Pisquare.Beans.IdList;
import com.Pisquare.Beans.Jewel_Desc;
import com.Pisquare.Beans.Level_Three;
import com.Pisquare.Beans.Login;
import com.Pisquare.Beans.NEFT_Bank;
import com.Pisquare.Beans.Simple;
import com.Pisquare.Controllers.Configuration_Controller;


public class LevelThreeDao {
	
	@Autowired
	private Configuration_Controller con;

	
JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template)
	{
		this.template=template;
		
	}

	
	
	
	int Binfo=201;

	public List<Simple> getSimpleLevelThree(int Bcode) {

		//--Set Connection----------------------------
					int j=Binfo;
					this.template=con.getCon2(j);
		//-----------------------------------------------------

		return template.query("select rownum as no,username from Permission_3 order by username",new RowMapper<Simple>(){   public Simple mapRow(ResultSet rs, int row) throws SQLException
		{  

			Simple gl=new Simple();
			gl.setS1(rs.getInt(1));
			gl.setS2(rs.getString(2));
			
			return gl;
		}
		 }     );
	}
	
	
	
	
	public int saveLevelThree(Level_Three il,int Bcode){  

		//--Set Connection----------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
		//-----------------------------------------------------

	    String sql="insert into Permission_3 values('"+il.getBank_Desc()+"')";  
	    return template.update(sql);  
	} 
	

	public int deleteLevelThree(String DESC,int Bcode)throws SQLException
	{  

		//--Set Connection----------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
		//-----------------------------------------------------

		int i=0;
		
		
		
		
		 String sql="delete from  Permission_3 where username='"+DESC+"'";  
		    i= template.update(sql);  
	 return i;
	}  
	
	
	public String getEscroMailDao() {
		//--Set Connection----------------------------
				int j=Binfo;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
					String i=null;
		String query = "select EscroMail  from General_Settings";

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
	
	public int UpdateEscroMail(String DESC)throws SQLException
	{  

		//--Set Connection----------------------------
					int j=Binfo;
					this.template=con.getCon2(j);
		//-----------------------------------------------------

		int i=0;
		
		
		
		
		 String sql="Update general_settings set Escromail='"+DESC+"'";  
		    i= template.update(sql);  
	 return i;
	}  
	
	
	
	public List<Simple> getSimpleLevelTwo(int Bcode) {

		//--Set Connection----------------------------
					int j=Binfo;
					this.template=con.getCon2(j);
		//-----------------------------------------------------

		return template.query("select rownum as no,username from Permission_2 order by username",new RowMapper<Simple>(){   public Simple mapRow(ResultSet rs, int row) throws SQLException
		{  

			Simple gl=new Simple();
			gl.setS1(rs.getInt(1));
			gl.setS2(rs.getString(2));
			
			return gl;
		}
		 }     );
	}
	
	
	
	
	public int saveLevelTwo(Level_Three il,int Bcode){  

		//--Set Connection----------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
		//-----------------------------------------------------

	    String sql="insert into Permission_2 values('"+il.getUserName2()+"')";  
	    return template.update(sql);  
	} 
	

	public int deleteLevelTwo(String DESC,int Bcode)throws SQLException
	{  

		//--Set Connection----------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
		//-----------------------------------------------------

		int i=0;
		
		
		
		
		 String sql="delete from  Permission_2 where username='"+DESC+"'";  
		    i= template.update(sql);  
	 return i;
	} 
	
	public int CheckUserLevel(String User) {
		//--Set Connection----------------------------
				int j=Binfo;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
					int i=0;
		String query = "select count(*) from login_details where username='"+User+"' and level1 in ('A','M')";

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

	public int UpdateAuditMail(String DESC)throws SQLException
	{  

		//--Set Connection----------------------------
					int j=Binfo;
					this.template=con.getCon2(j);
		//-----------------------------------------------------

		int i=0;
		
		
		
		
		 String sql="Update general_settings set Escropwd='"+DESC+"'";  
		    i= template.update(sql);  
	 return i;
	}  
	
	public String getAuditMailDao() {
		//--Set Connection----------------------------
				int j=Binfo;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
					String i=null;
		String query = "select Escropwd  from General_Settings";

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
	
	public List<Simple> getSimpleLevelThree_Attendance(int Bcode) {

		//--Set Connection----------------------------
					int j=Binfo;
					this.template=con.getCon2(j);
		//-----------------------------------------------------

		return template.query("select rownum as no,username,level1 from Permission_att order by username",new RowMapper<Simple>(){   public Simple mapRow(ResultSet rs, int row) throws SQLException
		{  

			Simple gl=new Simple();
			gl.setS1(rs.getInt(1));
			gl.setS2(rs.getString(2));
			gl.setS31(rs.getString(3));
			
			return gl;
		}
		 }     );
	}
	
	
	
	
	public int saveLevelThree_Attendance(String username,String level,int Bcode){  

		//--Set Connection----------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
		//-----------------------------------------------------

	    String sql="insert into Permission_att values('"+username+"','"+level+"')";  
	    return template.update(sql);  
	} 
	

	public int deleteLevelThree_Attendance(String DESC,int Bcode)throws SQLException
	{  

		//--Set Connection----------------------------
					int j=Bcode;
					this.template=con.getCon2(j);
		//-----------------------------------------------------

		int i=0;
		
		
		
		
		 String sql="delete from  Permission_att where username='"+DESC+"'";  
		    i= template.update(sql);  
	 return i;
	}  

	
	public int CheckUserCount(String User) {
		//--Set Connection----------------------------
				int j=Binfo;
				this.template=con.getCon2(j);
				//-----------------------------------------------------
					int i=0;
		String query = "select count(*) from permission_att where username='"+User+"'";

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

}//3
