package com.Pisquare.Dao;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

import com.Pisquare.Beans.Change_Password;
import com.Pisquare.Beans.Cus;
import com.Pisquare.Beans.Customer;
import com.Pisquare.Beans.GL_Master;
import com.Pisquare.Beans.Login;
import com.Pisquare.Beans.Branch_Master;
import com.Pisquare.Beans.Simple;
import com.Pisquare.Beans.SimpleBranch;
import com.Pisquare.Beans.UserDetails;
import com.Pisquare.Controllers.Configuration_Controller;


public class Permission_Dao {
	
	int Binfo=201;
	
	@Autowired
	private Configuration_Controller con;
	JdbcTemplate template;
	
	@Autowired
	private UserDetailsDao dao;
	
	@Autowired
	private ApprovalDao dao20;
	
	public void setTemplate(JdbcTemplate template)
	{
		this.template=template;
		
	}
	
	public static String newline = System.getProperty("line.separator");
	
	
		
		//1. Check_Already_User
		
		//-------------------------------------------------NO OF RECORDS - SBCA_MASTER---------------------------------------------------------------------
				


	public int DeletePermissionDetails(String username) {
		dao20.UpdateDATA("insert into Operational_Log(TYPE,CREATED_BY,CREATED_DATE,TIME_INFO,BRANCH,FILE_TYPE) values ('DeletePermissionDetails','General',TO_DATE(to_char(sysdate,'dd/MM/yyyy'),'dd/MM/yyyy'),to_char(SYSDATE,'dd/mm/yyyy HH12:MI:SS AM'),201,'Deleted User :"+username+"')", 201);

		// --Set Connection----------------------------
		int j = Binfo;
		this.template = con.getCon2(j);
		// -----------------------------------------------------
		int i = 0;
		try {
		 
			String sql = "delete from Corp_Permission where user_name='"
					+ username + "'";

			i = template.update(sql);
		} catch (Exception e) {
			dao.saveException_Info("" + Binfo, "", e.toString(),
					"" + e.getCause(),
					"" + e.getStackTrace()[0].getLineNumber(),
					"DeletePermissionDetails", "", "SNNL Corp");
			System.out.println(e);
		}
		return i;
	}
	
	public int savePermissionDetails(String username, String page, String view,
			String save, String update, String delete, String verify2,
			String verify3, String verify4, String verify5, String reports,
			String Button, String Finger_Print) {
	 	//dao20.UpdateDATA("insert into Operational_Log(TYPE,CREATED_BY,CREATED_DATE,TIME_INFO,BRANCH,FILE_TYPE) values ('SavePermissionDetails','General',TO_DATE(to_char(sysdate,'dd/MM/yyyy'),'dd/MM/yyyy'),to_char(SYSDATE,'dd/mm/yyyy HH12:MI:SS AM'),201,'Save Permission User :"+username+"')", 201);

		// --Set Connection----------------------------
		int j = Binfo;
		this.template = con.getCon2(j);
		// -----------------------------------------------------

		int i = 0;
		try {
			String sql = "insert into Corp_Permission values('" + username
					+ "','" + page + "','" + view + "','" + save + "','"
					+ update + "','" + delete + "','" + verify2 + "','"
					+ verify3 + "','" + verify4 + "','" + verify5 + "','"
					+ reports + "','" + Button + "','" + Finger_Print + "')";

			i = template.update(sql);
		} catch (Exception e) {
			dao.saveException_Info("" + Binfo, "", e.toString(),
					"" + e.getCause(),
					"" + e.getStackTrace()[0].getLineNumber(),
					"DeletePermissionDetails", "", "SNNL Corp");
			System.out.println(e);
		}
		return i;
	}	
	
	public List<Simple> getUserLogin() {
		// --Set Connection----------------------------
		int j = 201;
		this.template = con.getCon2(j);
		// -----------------------------------------------------
	 	dao20.UpdateDATA("insert into Operational_Log(TYPE,CREATED_BY,CREATED_DATE,TIME_INFO,BRANCH,FILE_TYPE) values ('getUserLogin','General',TO_DATE(to_char(sysdate,'dd/MM/yyyy'),'dd/MM/yyyy'),to_char(SYSDATE,'dd/mm/yyyy HH12:MI:SS AM'),201,'Get User Login :')", 201);

		return template
				.query("select * from LOGINDETAILS where mtype in ('X','A') and username !='200001'",
						new RowMapper<Simple>() {
							public Simple mapRow(ResultSet rs, int row)
									throws SQLException {

								Simple gl = new Simple();
								gl.setS2(rs.getString(1));

								return gl;
							}
						});
	}
	
	public List<SimpleBranch> getPermission(String username,String page){
		
	 	//dao20.UpdateDATA("insert into Operational_Log(TYPE,CREATED_BY,CREATED_DATE,TIME_INFO,BRANCH,FILE_TYPE) values ('getPermission','General',TO_DATE(to_char(sysdate,'dd/MM/yyyy'),'dd/MM/yyyy'),to_char(SYSDATE,'dd/mm/yyyy HH12:MI:SS AM'),201,'Get Page Permission')", 201);

		//--Set Connection----------------------------
		int j=Binfo;
		this.template=con.getCon2(j);
//-----------------------------------------------------
		System.out.println("Inside dao-----------------------------");
		String query="select * from PERMISSION Where USER_NAME='"+username+"' and PAGE='"+page+"'";
		System.out.println("query"+query);
		return template.query("select * from CORP_PERMISSION Where USER_NAME='"+username+"' and PAGE='"+page+"'",new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException
		{  
			System.out.println("Inside -----------------------------");
           
			SimpleBranch gl=new SimpleBranch();
			gl.setS31(rs.getString(3));   //TO_VIEW
			System.out.println("rs.getString(3)-"+rs.getString(3));
		    gl.setS32(rs.getString(4));   //TO_SAVE;
		    System.out.println("rs.getString(4)-"+rs.getString(4));
		    gl.setS33(rs.getString(5));  //TO_UPDATE
		    System.out.println("rs.getString(5)-"+rs.getString(5));
			gl.setS34(rs.getString(6));   //TO_DELETE
			System.out.println("rs.getString(6)-"+rs.getString(6));
			gl.setS35(rs.getString(7));   //T0_VERIFY2
			System.out.println("rs.getString(7)-"+rs.getString(7));
			gl.setS36(rs.getString(8));     //TO_VERIFY_3
			System.out.println("rs.getString(8)-"+rs.getString(8));
			gl.setS37(rs.getString(9)); //TO_VERIFY_4
			System.out.println("rs.getString(9)-"+rs.getString(9));
			gl.setS38(rs.getString(10));//TO_VERIFY_5
			System.out.println("rs.getString(10)-"+rs.getString(10));
		    gl.setS39(rs.getString(11));    //REPORTS
		    System.out.println("rs.getString(11)-"+rs.getString(11));
		    gl.setS40(rs.getString(12));// button
		    gl.setS134(rs.getString(13));//Finger_Print
		return gl;
			
			
							
		}
		 }     );
	}

	
	public String[] GetPermission(String user,String path) throws SQLException
	{
	 	//dao20.UpdateDATA("insert into Operational_Log(TYPE,CREATED_BY,CREATED_DATE,TIME_INFO,BRANCH,FILE_TYPE) values ('GetPermissionArray','General',TO_DATE(to_char(sysdate,'dd/MM/yyyy'),'dd/MM/yyyy'),to_char(SYSDATE,'dd/mm/yyyy HH12:MI:SS AM'),201,'Get Page Permission Array')", 201);

		//--Set Connection----------------------------
		int j=201;
		this.template=con.getCon2(j);
		//-----------------------------------------------------
	System.out.println("Inside get permission-----------------");
		
		String[] permission=new String[11];
		try{
			CallableStatement stmt=template.getDataSource().getConnection().prepareCall("{call GET_CORP_PERMISSION_SET(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			stmt.setString(1,user);
			stmt.setString(2,path);
			System.out.println("get permission-----------------");
			//register the OUT parameter before calling the stored procedure
			stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(5, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(6, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(7, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(8, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(9, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(10, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(11, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(12, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(13, java.sql.Types.VARCHAR);
			
			stmt.executeQuery();
		
			System.out.println("get-----------------");
			     permission[0]=stmt.getString(3);
			     permission[1]=stmt.getString(4);
			     permission[2]=stmt.getString(5);
			     permission[3]=stmt.getString(6);
			     permission[4]=stmt.getString(7);
			     permission[5]=stmt.getString(8);
			     permission[6]=stmt.getString(9);
			     permission[7]=stmt.getString(10);
			     permission[8]=stmt.getString(11);
			     permission[9]=stmt.getString(12);
			     permission[10]=stmt.getString(13);
			     System.out.println("66666 get permission-----------------");
			   
			     stmt.getConnection().commit();
				 stmt.getConnection().close();
				
		
		}catch (Exception e) {
			dao.saveException_Info("" + Binfo, "", e.toString(),
					"" + e.getCause(),
					"" + e.getStackTrace()[0].getLineNumber(),
					"GetPermission", "", "SNNL Corp");
			System.out.println(e);
		}
		return permission;
	
	}
	
	
	
	public int getPermission_Count(String User_name, String Page)
	{
	 	//dao20.UpdateDATA("insert into Operational_Log(TYPE,CREATED_BY,CREATED_DATE,TIME_INFO,BRANCH,FILE_TYPE) values ('getPermission_Count','General',TO_DATE(to_char(sysdate,'dd/MM/yyyy'),'dd/MM/yyyy'),to_char(SYSDATE,'dd/mm/yyyy HH12:MI:SS AM'),201,'getPermission_Count for :"+User_name+"')", 201);

		//--Set Connection------------------------------------
		int j=Binfo;
		this.template=con.getCon2(j);
		//-----------------------------------------------------

	
		int i=0;
		String query = "select Count(*) from Corp_Permission where User_name='"+User_name+"' and Page='"+Page+"'";
		PreparedStatement pstmt = null;
		try {
			pstmt = template.getDataSource().getConnection().prepareStatement(query);
		} catch (Exception e) {
			dao.saveException_Info("" + Binfo, "", e.toString(),
					"" + e.getCause(),
					"" + e.getStackTrace()[0].getLineNumber(),
					"getPermission_Count", "", "SNNL Corp");
			e.printStackTrace();
		}
		ResultSet resultSet = null;
		try {
			resultSet = pstmt.executeQuery();
			
			
		} catch (Exception e) {
			dao.saveException_Info("" + Binfo, "", e.toString(),
					"" + e.getCause(),
					"" + e.getStackTrace()[0].getLineNumber(),
					"getPermission_Count", "", "SNNL Corp");
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
		} catch (Exception e) {
			dao.saveException_Info("" + Binfo, "", e.toString(),
					"" + e.getCause(),
					"" + e.getStackTrace()[0].getLineNumber(),
					"getPermission_Count", "", "SNNL Corp");
			e.printStackTrace();
		}
			
		return i;
	}

	
	public int updatePermissionDetails(String username, String page,
			String view, String save, String update, String delete,
			String verify2, String verify3, String verify4, String verify5,
			String reports) {
	 	dao20.UpdateDATA("insert into Operational_Log(TYPE,CREATED_BY,CREATED_DATE,TIME_INFO,BRANCH,FILE_TYPE) values ('updatePermissionDetails','General',TO_DATE(to_char(sysdate,'dd/MM/yyyy'),'dd/MM/yyyy'),to_char(SYSDATE,'dd/mm/yyyy HH12:MI:SS AM'),201,'updatePermissionDetails for :"+username+"')", 201);

		// --Set Connection----------------------------
		int j = Binfo;
		this.template = con.getCon2(j);
		// -----------------------------------------------------
		int i = 0;
		try {
			String sql = "update Corp_Permission set View_Page='" + view
					+ "',Save_Page='" + save + "',Update_Page='" + update
					+ "',Delete_Page='" + delete + "',Verify2='" + verify2
					+ "',Verify3='" + verify3 + "',Verify4='" + verify4
					+ "',Verify5='" + verify5 + "',Report='" + reports
					+ "' where User_Name='" + username + "' and Page='" + page
					+ "'";

			System.out.println("sql------------" + sql);
			i = template.update(sql);
		} catch (Exception e) {
			dao.saveException_Info("" + Binfo, "", e.toString(),
					"" + e.getCause(),
					"" + e.getStackTrace()[0].getLineNumber(),
					"updatePermissionDetails", "", "SNNL Corp");
			// e.printStackTrace();
		}
		return i;
	}

	public int DeletePermissionDetails(String username, String Page) {
		
	 	dao20.UpdateDATA("insert into Operational_Log(TYPE,CREATED_BY,CREATED_DATE,TIME_INFO,BRANCH,FILE_TYPE) values ('DeletePermissionDetails','General',TO_DATE(to_char(sysdate,'dd/MM/yyyy'),'dd/MM/yyyy'),to_char(SYSDATE,'dd/mm/yyyy HH12:MI:SS AM'),201,'DeletePermissionDetails for :"+username+"')", 201);

		// --Set Connection----------------------------
		int j = Binfo;
		this.template = con.getCon2(j);
		// -----------------------------------------------------
		int i = 0;
		try {
			String sql = "delete from Corp_Permission where user_name='"
					+ username + "'and Page='" + Page + "'";

			i = template.update(sql);
		} catch (Exception e) {
			dao.saveException_Info("" + Binfo, "", e.toString(),
					"" + e.getCause(),
					"" + e.getStackTrace()[0].getLineNumber(),
					"DeletePermissionDetails", "", "SNNL Corp");
			// e.printStackTrace();
		}

		return i;
	}
	
	
	
	//-------------------------------------------------Get Permission--------------------------------------------------------------------
	public String Get_Button_Permission_Corp(String page,String userName)
	{
	 	//dao20.UpdateDATA("insert into Operational_Log(TYPE,CREATED_BY,CREATED_DATE,TIME_INFO,BRANCH,FILE_TYPE) values ('Get_Button_Permission_Corp','General',TO_DATE(to_char(sysdate,'dd/MM/yyyy'),'dd/MM/yyyy'),to_char(SYSDATE,'dd/mm/yyyy HH12:MI:SS AM'),201,'Get_Button_Permission_Corp for :"+userName+"')", 201);

		//--Set Connection----------------------------
		int j=Binfo;
		this.template=con.getCon2(j);
		//-----------------------------------------------------
		

		String i="No";
		String query = "Select button from corp_permission where username='"+userName+"' and page='"+page+"'";
		PreparedStatement pstmt = null;
		try {
			pstmt = template.getDataSource().getConnection().prepareStatement(query);
		} catch (Exception e) {
			dao.saveException_Info("" + Binfo, "", e.toString(),
					"" + e.getCause(),
					"" + e.getStackTrace()[0].getLineNumber(),
					"Get_Button_Permission_Corp", "", "SNNL Corp");
			e.printStackTrace();
		}
		ResultSet resultSet = null;
		try {
			resultSet = pstmt.executeQuery();
			//resultSet.next();
		} catch (Exception e) {
			dao.saveException_Info("" + Binfo, "", e.toString(),
					"" + e.getCause(),
					"" + e.getStackTrace()[0].getLineNumber(),
					"Get_Button_Permission_Corp", "", "SNNL Corp");
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
		} catch (Exception e) {
			dao.saveException_Info("" + Binfo, "", e.toString(),
					"" + e.getCause(),
					"" + e.getStackTrace()[0].getLineNumber(),
					"Get_Button_Permission_Corp", "", "SNNL Corp");
			e.printStackTrace();
		}
		
		return i;
	}

	//-------------------------------------------------Get Permission--------------------------------------------------------------------
		public String Get_Finger_Permission_Corp(String userName)
		{
		 	//dao20.UpdateDATA("insert into Operational_Log(TYPE,CREATED_BY,CREATED_DATE,TIME_INFO,BRANCH,FILE_TYPE) values ('Get_Finger_Permission_Corp','General',TO_DATE(to_char(sysdate,'dd/MM/yyyy'),'dd/MM/yyyy'),to_char(SYSDATE,'dd/mm/yyyy HH12:MI:SS AM'),201,'Get_Finger_Permission_Corp for :"+userName+"')", 201);

			//--Set Connection----------------------------
			int j=Binfo;
			this.template=con.getCon2(j);
			//-----------------------------------------------------
			

			String i="N-N";
			String query = "Select button||'-'||finger_print as access1 from corp_permission where user_name='"+userName+"' and page='MS'";
			PreparedStatement pstmt = null;
			try {
				pstmt = template.getDataSource().getConnection().prepareStatement(query);
			} catch (Exception e) {
				dao.saveException_Info("" + Binfo, "", e.toString(),
						"" + e.getCause(),
						"" + e.getStackTrace()[0].getLineNumber(),
						"Get_Finger_Permission_Corp", "", "SNNL Corp");
				e.printStackTrace();
			}
			ResultSet resultSet = null;
			try {
				resultSet = pstmt.executeQuery();
				//resultSet.next();
			} catch (Exception e) {
				dao.saveException_Info("" + Binfo, "", e.toString(),
						"" + e.getCause(),
						"" + e.getStackTrace()[0].getLineNumber(),
						"Get_Finger_Permission_Corp", "", "SNNL Corp");
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
			} catch (Exception e) {
				dao.saveException_Info("" + Binfo, "", e.toString(),
						"" + e.getCause(),
						"" + e.getStackTrace()[0].getLineNumber(),
						"Get_Finger_Permission_Corp", "", "SNNL Corp");
				e.printStackTrace();
			}
			
			return i;
		}
		//-------------------------------------------------Get Permission--------------------------------------------------------------------
		public String Get_Finger_Permission_Corp2(String userName)
		{
		 	//dao20.UpdateDATA("insert into Operational_Log(TYPE,CREATED_BY,CREATED_DATE,TIME_INFO,BRANCH,FILE_TYPE) values ('Get_Finger_Permission_Corp2','General',TO_DATE(to_char(sysdate,'dd/MM/yyyy'),'dd/MM/yyyy'),to_char(SYSDATE,'dd/mm/yyyy HH12:MI:SS AM'),201,'Get_Finger_Permission_Corp 2 for :"+userName+"')", 201);

			//--Set Connection----------------------------
			int j=Binfo;
			this.template=con.getCon2(j);
			//-----------------------------------------------------
			

			String i="N-N";
			String query = "Select button||'-'||finger_print as access1 from corp_permission where user_name='"+userName+"' and page='Admin'";
			System.out.println(query);
			
			System.out.println("Get_Finger_Permission_Corp2---");
			
			
			PreparedStatement pstmt = null;	
			try {
				pstmt = template.getDataSource().getConnection().prepareStatement(query);
			} catch (Exception e) {
				dao.saveException_Info("" + Binfo, "", e.toString(),
						"" + e.getCause(),
						"" + e.getStackTrace()[0].getLineNumber(),
						"Get_Finger_Permission_Corp2", "", "SNNL Corp");
				e.printStackTrace();
			}
			ResultSet resultSet = null;
			try {
				resultSet = pstmt.executeQuery();
				//resultSet.next();
			} catch (Exception e) {
				dao.saveException_Info("" + Binfo, "", e.toString(),
						"" + e.getCause(),
						"" + e.getStackTrace()[0].getLineNumber(),
						"Get_Finger_Permission_Corp2", "", "SNNL Corp");
				e.printStackTrace();
			}
			
			try {
				if (resultSet!= null) {
					  while (resultSet.next()) {
						  i=resultSet.getString(1);
						  System.out.println(i);
					  }
				}
				
				
				//i=resultSet.getInt(1);
				
				//i=resultSet.getRow();
			} catch (Exception e) {
				dao.saveException_Info("" + Binfo, "", e.toString(),
						"" + e.getCause(),
						"" + e.getStackTrace()[0].getLineNumber(),
						"Get_Finger_Permission_Corp2", "", "SNNL Corp");
				e.printStackTrace();
			}
			
			return i;
		}
		
		public int SAVE_Operation_Status(String FUN_NAME,String FUNCTION_STATUS,String CHANGED_BY,String BRANCH_CODE,String PAGE_SOURCE,String LIMIT)
		{
		 	//dao20.UpdateDATA("insert into Operational_Log(TYPE,CREATED_BY,CREATED_DATE,TIME_INFO,BRANCH,FILE_TYPE) values ('SAVE_Operation_Status','General',TO_DATE(to_char(sysdate,'dd/MM/yyyy'),'dd/MM/yyyy'),to_char(SYSDATE,'dd/mm/yyyy HH12:MI:SS AM'),201,'SAVE_Operation_Status for :"+CHANGED_BY+"')", 201);

			// --Set Connection----------------------------
			//int j = 333;
			int j = Binfo;
			this.template = con.getCon2(j);
			// -----------------------------------------------------

			int flag = 0;
			try {

				CallableStatement stmt = template.getDataSource().getConnection()
						.prepareCall("{call SAVE_Operation_Status(?,?,?,?,?,?)}");
				stmt.setString(1, FUN_NAME);
				stmt.setString(2, FUNCTION_STATUS);
				stmt.setString(3, CHANGED_BY);
				stmt.setString(4, BRANCH_CODE);
				stmt.setString(5, PAGE_SOURCE);
				stmt.setString(6, LIMIT);

				stmt.executeQuery();
				flag = 1;
			} catch (Exception e) {
				dao.saveException_Info(""+Binfo,"",e.toString(),""+e.getCause(),""+e.getStackTrace()[0].getLineNumber(),"SAVE_Operation_Status","","SNNL Corp");
				System.out.println(e);
			}
			return flag;
		}
		
		

	/*	public List<SimpleBranch> get_OTPSettings(String Branch) {
		 //	dao20.UpdateDATA("insert into Operational_Log(TYPE,CREATED_BY,CREATED_DATE,TIME_INFO,BRANCH,FILE_TYPE) values ('get_OTPSettings','General',TO_DATE(to_char(sysdate,'dd/MM/yyyy'),'dd/MM/yyyy'),to_char(SYSDATE,'dd/mm/yyyy HH12:MI:SS AM'),201,'View Operation Settings')", 201);

			// --Set Connection----------------------------
			int j = Binfo;
			this.template = con.getCon2(j);
			// -----------------------------------------------------

			SimpleBranch gl = new SimpleBranch();
			
			try{
			System.out.println("Inside dao-----------------------------");
			String query = "select PAGE_SOURCE,FUNCTION_STATUS,LIMIT from Operation_Status Where PAGE_SOURCE is not null and Branch_Code='"	+ Branch + "'";
			System.out.println("query" + query);
			return template.query(query, new RowMapper<SimpleBranch>() {
				public SimpleBranch mapRow(ResultSet rs, int row)
						throws SQLException {
					System.out.println("Inside -----------------------------");

					gl.setS31(rs.getString(1)); // PAGE_SOURCE
					System.out.println(rs.getString(1));
					gl.setS32(rs.getString(2)); // FUNCTION_STATUS;
					gl.setS33(rs.getString(3)); // LIMIT

					return gl;

				}
			});
			
			} catch (Exception e) {
				dao.saveException_Info(""+Binfo,"",e.toString(),""+e.getCause(),""+e.getStackTrace()[0].getLineNumber(),"SAVE_Operation_Status","","SNNL Corp");
				System.out.println(e);
				return (List<SimpleBranch>) gl;
			}
		}*/
		

		
		public List<SimpleBranch> get_OTPSettings(String Branch) {
			//--Set Connection----------------------------
						int j=Binfo;
						this.template=con.getCon2(j);
			//-----------------------------------------------------
						String query = "select PAGE_SOURCE,FUNCTION_STATUS,LIMIT from Operation_Status Where PAGE_SOURCE is not null and Branch_Code='"	+ Branch + "'";

			return template.query(query,new RowMapper<SimpleBranch>(){   public SimpleBranch mapRow(ResultSet rs, int row) throws SQLException{  
				
				SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
				
				SimpleBranch gl=new SimpleBranch();
			
				gl.setS31(rs.getString(1)); // branch
				gl.setS32(rs.getString(2)); // branch
				gl.setS33(rs.getString(3)); // branch
					
				
			 	
				return gl;
			}
						 }     );
					}
		
		
}
