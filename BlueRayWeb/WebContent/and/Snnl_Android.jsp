<%@ page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%@page import="org.json.simple.*"%>
<%@page import="java.util.Collections"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.MessagingException"%>
<%@page import="javax.mail.PasswordAuthentication"%>
<%@page import="javax.mail.Session"%>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="java.util.Properties"%>

<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
	String ODriver="oracle.jdbc.driver.OracleDriver";
	String SysName="jdbc:oracle:thin:@192.168.1.64:1521:xe";
	String UserName="dbuser1";
	String PassWord="dbpwd1";

	String MailSender="apksender@shrinarayaninidhi.com";
	String MailPass="Android@2024";
	//String MailReceiver="apkreceiver@shrinarayaninidhi.com";
String MailReceiver="apksender@shrinarayaninidhi.com";
	 String MailHost = "65.0.171.189";
         String SMTP_PORT="587";

String IMAGELOCATION="";
	String OTP_MAIL="";

		Connection conn = null;
		try {
			 Statement statement = null;
				Statement statement2 = null;
				ResultSet rs = null;
				ResultSet rs2 = null;
			Class.forName(ODriver);
			conn = DriverManager.getConnection(	SysName, UserName,	PassWord);
			String QueryString="select IMAGELOCATION,OTP_MAIL,MAILSENDER,MAILRECEIVER,MAILHOST,MAILPORT  from app_details";
			statement = conn.createStatement();
 			rs = statement.executeQuery(QueryString);
			while (rs.next()) 
			{
				MailSender=rs.getString("MAILSENDER");
				MailReceiver=rs.getString("MAILRECEIVER");
				MailHost=rs.getString("MAILHOST");
				SMTP_PORT=rs.getString("MAILPORT");
				IMAGELOCATION=rs.getString("IMAGELOCATION");
				OTP_MAIL=rs.getString("OTP_MAIL");
				
				/*out.println("MailSender:"+MailSender);
				out.println("MailReceiver:"+MailReceiver);
				out.println("MailHost:"+MailHost);
				out.println("SMTP_PORT:"+SMTP_PORT);
				out.println("IMAGELOCATION:"+IMAGELOCATION);
				out.println("OTP_MAIL:"+OTP_MAIL);*/
			}
			conn.close();
				}

		catch (Exception e) {
			out.println("Exception : " + e.getMessage() + "");
		}
	%>
	<%
	int no = Integer.parseInt(request.getParameter("type"));
		if (request.getParameter("type") == null) {
			out.println("Please enter your type.");
		} 

		

		else if (no == 129) {
				//out.println("Hello Ur Action Type is= <b>"
						//+ request.getParameter("type") + "</b>");

				String Be = "";
				String output = "";

				String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
				String mon = request.getParameter("mon");
				String CDate = request.getParameter("Dt");
				String Dt = CDate;//CDate.substring(4,2);
				//out.println("Date is= <b>" + Dt + "</b>");
				
				Connection conn1 = null;
				Statement statement = null;
				Statement statement2 = null;
				ResultSet rs = null;
				ResultSet rs2 = null;
				try {

					Class.forName(ODriver);
					conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
					//out.println("connected....!!");
					statement = conn1.createStatement();
					String QueryString = "Select Branch_Code,Branch_Name from branch_master  order by Branch_Code";
					//out.println(QueryString);

					try{
						
					rs = statement.executeQuery(QueryString);
					
					JSONArray array=new JSONArray();
					while (rs.next()) 
					{
						    JSONObject obj = new JSONObject();
			                obj.put("Branch",rs.getString(1));
			                obj.put("Branch_Name",rs.getString(2));
			               
			              
			                array.add(obj);
					}
					
					

					
					
					
					conn1.close();
					
					out.println(array);
					
					
					}catch(SQLException e){
				        out.print("Exception: "+e);
				    }
					
					
					
				} catch (Exception e) {

				}

				output = Be;

				
				//response.addHeader("AustinAndroidReturn", output);

			}

		else if (no == 556) {
			//out.println("Hello Ur Action Type is= <b>"
					//+ request.getParameter("type") + "</b>");

			String Be = "";
			String output = "";

			String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
			String mon = request.getParameter("mon");
			String CDate = request.getParameter("Dt");
			String Dt = CDate;//CDate.substring(4,2);
			//out.println("Date is= <b>" + Dt + "</b>");
			
			Connection conn1 = null;
			Statement statement = null;
			Statement statement2 = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			try {

				Class.forName(ODriver);
				conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
				//out.println("connected....!!");
				statement = conn1.createStatement();
				String QueryString = "select a.customer_id from (select nvl(customer_id,0) as customer_id from customer_view where mobile_no='"+mon+"' order by branch)a where ROWNUM=1";
				//out.println(QueryString);

//Log------------------------------------
		PreparedStatement p=null;
		
		  String logQuery="insert into APP_OPERATION_LOG(mon,type,no) values('"+mon+"','LoginPage','"+no+"')";
		  p =conn1.prepareStatement(logQuery);
		  try{
			p.execute();
		  }catch(SQLException e){
		        out.print("Exception: "+e);
		    }
//-----------------------------------------------		



				try{
					
				rs = statement.executeQuery(QueryString);
				
				JSONArray array=new JSONArray();
				while (rs.next()) 
				{
					    JSONObject obj = new JSONObject();
		                obj.put("Customer_Id",rs.getString(1));
		               
		               
		              
		                array.add(obj);
				}
				
				

				
				
				
				conn1.close();
				
				out.println(array);
				
				
				}catch(SQLException e){
			        out.print("Exception: "+e);
			    }
				
				
				
			} catch (Exception e) {

			}

			output = Be;

			
			//response.addHeader("AustinAndroidReturn", output);

		}
		
		else if (no == 557) {
			//out.println("Hello Ur Action Type is= <b>"
					//+ request.getParameter("type") + "</b>");

			String Be = "";
			String output = "";

			String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
			String mon = request.getParameter("mon");
			String CDate = request.getParameter("Dt");
			String Dt = CDate;//CDate.substring(4,2);
			//out.println("Date is= <b>" + Dt + "</b>");
			Connection conn1 = null;
			Statement statement = null;
			Statement statement2 = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			try {

				Class.forName(ODriver);
				conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
				//out.println("connected....!!");
				statement = conn1.createStatement();
				statement2 = conn1.createStatement();
				String Query1= "select a.customer_id from (select nvl(customer_id,0) as customer_id from customer_view where mobile_no='"+mon+"' order by branch)a where ROWNUM=1";

				rs2 = statement2.executeQuery(Query1);
				String customer_id="0";
				while (rs2.next()) 
				{
					customer_id=rs2.getString(1);
				}
				

				
				//String QueryString = "select main_qry.Customer_id,main_qry.Customer_Name,main_qry.Last_Login,main_qry.CB from (select Customer_Id,Customer_Name,'00:00:00' as Last_Login,nvl(Closing_Balance,0) as CB from sbca_master where customer_id in (select a.customer_id from (select nvl(customer_id,0) as customer_id from customer_view where mobile_no='"+mon+"' order by branch)a where ROWNUM=1) )main_qry where rownum=1";
//String QueryString = "select main_qry.Customer_id,main_qry.Customer_Name,(select a.time_info from (select customer_id,case when time_info is not null then to_char(substr(time_info,1,17)) end  as time_info  from  log_details where customer_id=main_qry.Customer_id order by id desc)a where rownum=1) as Last_Login,main_qry.CB from (select Customer_Id,Customer_Name,'00:00:00' as Last_Login,nvl(Closing_Balance,0) as CB from sbca_view where customer_id in (select a.customer_id from (select nvl(customer_id,0) as customer_id from customer_view where mobile_no='"+mon+"' order by branch)a where ROWNUM=1) )main_qry where rownum=1";
//String QueryString = "select main_qry.Customer_id,main_qry.Customer_Name,(select a.time_info from (select customer_id,case when time_info is not null then to_char(substr(time_info,1,16)) end  as time_info,Row_Number() OVER (Order by id desc) rno from  log_details where customer_id=main_qry.Customer_id)a where rno=2) as Last_Login,main_qry.CB from (select Customer_Id,Customer_Name,'00:00:00' as Last_Login,nvl(Closing_Balance,0) as CB from sbca_view where customer_id in (select a.customer_id from (select nvl(customer_id,0) as customer_id from customer_view where mobile_no='"+mon+"' order by branch)a where ROWNUM=1) )main_qry where rownum=1";
//04-12-2023
//String QueryString = "select main_qry.Customer_id,main_qry.Customer_Name,case when qry2.Time_Info is null then '00:00:00' else substr(qry2.Time_Info,1,16) end as Last_Login,main_qry.Closing_balance as CB from (select b.* from (select customer_id,time_info,Row_Number() OVER (Order by id desc) rno from log_details ) b where b.Customer_id='"+customer_id+"' and rownum=1)qry2 left join (select a.* from (select to_char(Customer_Id) as customer_id,Customer_Name ,Closing_balance,Row_Number() OVER (Order by Account_No) rno from sbca_view  where To_Char(Customer_Id)='"+customer_id+"' and Account_Status='A' order by branch_code)a where a.rno=1)main_qry on main_qry.customer_id=qry2.Customer_Id";
//05-12-2023
String QueryString = "select qry1.customer_id,qry2.customer_name,case when qry1.TIME_INFO is null then '00:00:00' else substr(qry1.TIME_INFO,1,16) end as Last_Login,qry2.Closing_balance as CB from (select a.* from (select customer_id,log_details.TIME_INFO,log_details.ID,ROW_NUMBER() OVER ( ORDER BY id desc) as row2 from log_details where customer_id='"+customer_id+"' order by id desc)a where row2=2)qry1 left join (select b.* from (select customer_id,customer_name,Closing_balance,ROW_NUMBER() OVER ( ORDER BY customer_id desc) as row1 from sbca_view where customer_id='"+customer_id+"')b where row1=1)qry2 on qry2.customer_id=qry1.customer_id";


				try{
					
				rs = statement.executeQuery(QueryString);
				
				JSONArray array=new JSONArray();
				while (rs.next()) 
				{
					    JSONObject obj = new JSONObject();
		                obj.put("Customer_Id",rs.getString(1));
		                obj.put("Customer_Name",rs.getString(2));
		                obj.put("Last_Login",rs.getString(3));
		                obj.put("CB",rs.getString(4));
		               
		               
		              
		                array.add(obj);
				}
				
				

				
				
				
				conn1.close();
				
				out.println(array);
				
				
				}catch(SQLException e){
			        out.print("Exception: "+e);
			    }
				
				
				
			} catch (Exception e) {

			}

			output = Be;

			
			//response.addHeader("AustinAndroidReturn", output);

		}
//SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.Customer_Name FROM ( Select Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'SD' AS TYPE,Customer_Id,Customer_Name from SBCA_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' union Select Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'FD' AS TYPE,Customer_Id,Customer_Name from FD_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' union Select Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'RD' AS TYPE,Customer_Id,Customer_Name from RD_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' )main_qry  order by main_qry.Account_No,main_qry.SCheme_Code
else if (no == 558) {
			//out.println("Hello Ur Action Type is= <b>"
					//+ request.getParameter("type") + "</b>");

			String Be = "";
			String output = "";

			String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
			String mon = request.getParameter("mon");
			String CDate = request.getParameter("Dt");
			String Dt = CDate;//CDate.substring(4,2);
			//out.println("Date is= <b>" + Dt + "</b>");
			
			Connection conn1 = null;
			Statement statement = null;
			Statement statement2 = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			try {

				Class.forName(ODriver);
				conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
				//out.println("connected....!!");
				statement = conn1.createStatement();
				//String QueryString = "SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.Customer_Name FROM ( Select Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'SD' AS TYPE,Customer_Id,Customer_Name from SBCA_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' union Select Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'FD' AS TYPE,Customer_Id,Customer_Name from FD_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' union Select Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'RD' AS TYPE,Customer_Id,Customer_Name from RD_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' )main_qry  order by main_qry.Account_No,main_qry.SCheme_Code";
				//String QueryString="SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.acNm FROM ( Select Branch as Branch,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'SD' AS TYPE,Customer_Id,Customer_Name as acNm from SBCA_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' union Select to_char(Branch_Code) as Branch ,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'FD' AS TYPE,Customer_Id,Customer_Name as acNm from FD_Master_View where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' union Select  Branch as Branch,Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'RD' AS TYPE,Customer_Id,Customer_Name as acNm from RD_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' )main_qry    order by main_qry.Account_No,main_qry.SCheme_Code,main_qry.Branch";
					//12-12-2023
				//String QueryString="SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.acNm FROM ( Select Branch as Branch,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'SD' AS TYPE,Customer_Id,Customer_Name as acNm from SBCA_MASTER_VIEW_REPORT where (to_char(Customer_Id)='"+devId+"' or to_char(CUSTOMER_ID_2)='"+devId+"' or to_char(CUSTOMER_ID_3)='"+devId+"') and Account_Status like 'A%' union Select to_char(Branch_Code) as Branch ,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'FD' AS TYPE,Customer_Id,Customer_Name as acNm from FD_Master_View where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' union Select  Branch as Branch,Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'RD' AS TYPE,Customer_Id,Customer_Name as acNm from RD_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' )main_qry    order by main_qry.Account_No,main_qry.SCheme_Code,main_qry.Branch";
				  String QueryString="SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.acNm FROM ( Select Branch as Branch,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'SD' AS TYPE,Customer_Id,Customer_Name as acNm from SBCA_MASTER_VIEW_REPORT where (to_char(Customer_Id)='"+devId+"' or to_char(CUSTOMER_ID_2)='"+devId+"' or to_char(CUSTOMER_ID_3)='"+devId+"') and Account_Status !='C' union Select to_char(Branch_Code) as Branch ,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'FD' AS TYPE,Customer_Id,Customer_Name as acNm from FD_Master_View where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' and scheme_code not in (select scheme_code from scheme_master where dep='9') union Select  Branch as Branch,Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'RD' AS TYPE,Customer_Id,Customer_Name as acNm from RD_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' )main_qry    order by main_qry.Account_No,main_qry.SCheme_Code,main_qry.Branch";


//out.println(QueryString);

				try{
					
				rs = statement.executeQuery(QueryString);
				
				JSONArray array=new JSONArray();
				while (rs.next()) 
				{
					    JSONObject obj = new JSONObject();
		                 obj.put("Account_No",rs.getString(2));
		                obj.put("Open_Date",rs.getString(3));
		                obj.put("CB",rs.getString(4));
		                obj.put("Scheme_Code",rs.getString(5));
		                obj.put("acNm",rs.getString(7));
		               
		               
		              
		                array.add(obj);
				}
				
				

				
				
				
				conn1.close();
				
				out.println(array);
				
				
				}catch(SQLException e){
			        out.print("Exception: "+e);
			    }
				
				
				
			} catch (Exception e) {

			}

			output = Be;

			
			//response.addHeader("AustinAndroidReturn", output);

		}
//loan
else if (no == 559) {
	//out.println("Hello Ur Action Type is= <b>"
			//+ request.getParameter("type") + "</b>");

	String Be = "";
	String output = "";

	String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
	String mon = request.getParameter("mon");
	String CDate = request.getParameter("Dt");
	String Dt = CDate;//CDate.substring(4,2);
	//out.println("Date is= <b>" + Dt + "</b>");
	
	Connection conn1 = null;
	Statement statement = null;
	Statement statement2 = null;
	ResultSet rs = null;
	ResultSet rs2 = null;
	try {

		Class.forName(ODriver);
		conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
		//out.println("connected....!!");
		statement = conn1.createStatement();
		//String QueryString = "SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.Customer_Name FROM ( Select Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'SD' AS TYPE,Customer_Id,Customer_Name from SBCA_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' union Select Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'FD' AS TYPE,Customer_Id,Customer_Name from FD_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' union Select Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'RD' AS TYPE,Customer_Id,Customer_Name from RD_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' )main_qry  order by main_qry.Account_No,main_qry.SCheme_Code";
		//String QueryString="SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.Customer_Name FROM (Select Branch as Branch,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'JL' AS TYPE,Customer_Id,Customer_Name from JL_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' union Select Branch as Branch ,Scheme_Code,to_char(Account_No) as Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'OL' AS TYPE,Customer_Id,Customer_Name from OL_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' union Select  Branch as Branch,Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'SL' AS TYPE,Customer_Id,Customer_Name from CC_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' )main_qry  where to_char(main_qry.Branch)='"+mon+"%' order by main_qry.Account_No,main_qry.SCheme_Code,main_qry.Branch";
                 // String QueryString="SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,nvl(main_qry.CB,0) as CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.Customer_Name FROM (select a.* from (Select Branch as Branch,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'JL' AS TYPE,Customer_Id,Customer_Name from JL_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' union Select Branch as Branch ,Scheme_Code,to_char(Account_No) as Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'OL' AS TYPE,Customer_Id,Customer_Name from OL_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' union Select  Branch as Branch,Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'SL' AS TYPE,Customer_Id,Customer_Name from CC_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%')a )main_qry   order by main_qry.Account_No,main_qry.SCheme_Code,main_qry.Branch";
//12-12-2023
 //12-12-2023
                    String QueryString="SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,nvl(main_qry.CB,0) as CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.Customer_Name FROM (select a.* from (Select Branch as Branch,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'JL' AS TYPE,Customer_Id,Customer_Name from JL_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' and Scheme_code not in ('60024','60028','60029') union Select Branch as Branch ,Scheme_Code,to_char(Account_No) as Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'OL' AS TYPE,Customer_Id,Customer_Name from OL_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' and scheme_code not in ('70030') union Select  Branch as Branch,Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'SL' AS TYPE,Customer_Id,Customer_Name from CC_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%')a )main_qry   order by main_qry.Account_No,main_qry.SCheme_Code,main_qry.Branch";

		
//out.println(QueryString);

		try{
			
		rs = statement.executeQuery(QueryString);
		
		JSONArray array=new JSONArray();
		while (rs.next()) 
		{
			    JSONObject obj = new JSONObject();
               /*  obj.put("Scheme_Code",rs.getString(1));
                obj.put("Account_No",rs.getString(2));
                obj.put("Open_Date",rs.getString(3));
                obj.put("CB",rs.getString(4));
                obj.put("Type",rs.getString(5));
                obj.put("Customer_Id",rs.getString(6));
                obj.put("Customer_Name",rs.getString(7));
                */
                obj.put("Account_No",rs.getString(2));
                obj.put("Open_Date",rs.getString(3));
                obj.put("CB",rs.getString(4));
                obj.put("Scheme_Code",rs.getString(5));
                obj.put("acNm",rs.getString(7));
               
               
              
                array.add(obj);
		}
		
		

		
		
		
		conn1.close();
		
		out.println(array);
		
		
		}catch(SQLException e){
	        out.print("Exception: "+e);
	    }
		
		
		
	} catch (Exception e) {

	}

	output = Be;

	
	//response.addHeader("AustinAndroidReturn", output);

}
//SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.Customer_Name FROM (Select Branch as Branch,Scheme_Code,Account_No,to_char(date1,'dd/MM/yyyy') as Open_Date,Share_Amount as CB,Account_Status,'Share' AS TYPE,Customer_Id,Customer_Name from Share_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' )main_qry  where main_qry.Branch='"+mon+"%' order by main_qry.Account_No,main_qry.SCheme_Code,main_qry.Branch
//Share
else if (no == 560) {
	//out.println("Hello Ur Action Type is= <b>"
			//+ request.getParameter("type") + "</b>");

	String Be = "";
	String output = "";

	String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
	String mon = request.getParameter("mon");
	String CDate = request.getParameter("Dt");
	String Dt = CDate;//CDate.substring(4,2);
	//out.println("Date is= <b>" + Dt + "</b>");
	
	Connection conn1 = null;
	Statement statement = null;
	Statement statement2 = null;
	ResultSet rs = null;
	ResultSet rs2 = null;
	try {

		Class.forName(ODriver);
		conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
		//out.println("connected....!!");
		statement = conn1.createStatement();
		//String QueryString = "SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.Customer_Name FROM ( Select Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'SD' AS TYPE,Customer_Id,Customer_Name from SBCA_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' union Select Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'FD' AS TYPE,Customer_Id,Customer_Name from FD_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"' union Select Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'RD' AS TYPE,Customer_Id,Customer_Name from RD_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' )main_qry  order by main_qry.Account_No,main_qry.SCheme_Code";
		String QueryString="SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.Customer_Name FROM (Select Branch as Branch,Scheme_Code,Account_No,to_char(date1,'dd/MM/yyyy') as Open_Date,Share_Amount as CB,Account_Status,'Share' AS TYPE,Customer_Id,Customer_Name from Share_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' )main_qry  order by main_qry.Account_No,main_qry.SCheme_Code,main_qry.Branch";
		//out.println(QueryString);

		try{
			
		rs = statement.executeQuery(QueryString);
		
		JSONArray array=new JSONArray();
		while (rs.next()) 
		{
			    JSONObject obj = new JSONObject();
//                 obj.put("Scheme_Code",rs.getString(1));
//                 obj.put("Account_No",rs.getString(2));
//                 obj.put("Open_Date",rs.getString(3));
//                 obj.put("CB",rs.getString(4));
//                 obj.put("Type",rs.getString(5));
//                 obj.put("Customer_Id",rs.getString(6));
//                 obj.put("Customer_Name",rs.getString(7));
               
                obj.put("Account_No",rs.getString(2));
		                obj.put("Open_Date",rs.getString(3));
		                obj.put("CB",rs.getString(4));
		                obj.put("Scheme_Code",rs.getString(5));
		                obj.put("acNm",rs.getString(7));
		               
		               
              
                array.add(obj);
		}
		
		

		
		
		
		conn1.close();
		
		out.println(array);
		
		
		}catch(SQLException e){
	        out.print("Exception: "+e);
	    }
		
		
		
	} catch (Exception e) {

	}

	output = Be;

	
	//response.addHeader("AustinAndroidReturn", output);

}
//LasteFew
else if (no == 561) {
	//out.println("Hello Ur Action Type is= <b>"
			//+ request.getParameter("type") + "</b>");

	String Be = "";
	String output = "";

	String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
	String mon = request.getParameter("mon");
	String CDate = request.getParameter("Dt");
	String Dt = CDate;//CDate.substring(4,2);
	//out.println("Date is= <b>" + Dt + "</b>");
	
	Connection conn1 = null;
	Statement statement = null;
	Statement statement2 = null;
	ResultSet rs = null;
	ResultSet rs2 = null;
	try {

		Class.forName(ODriver);
		conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
		//out.println("connected....!!");
		statement = conn1.createStatement();
		String QueryString="select main_qry.* from (Select to_char(Transaction_Id) as Transaction_Id,to_char(Part_Tran_Id) as Part_Tran_Id,to_char(Transaction_Date,'dd/MM/yyyy') as Tran_Date,substr(Transaction_Particulars,1,10) as Transaction_Particulars,to_char(Transaction_Amount ||' '||case when Transaction_Type='Credit' then 'Cr' else 'Dr' End) as Tran_Amount from DAILY_TRANSACTION_ACTIVE_TABLE where Account_no='"+devId+"'  order by Transaction_Date desc,to_number(substr(to_char(Transaction_Id),-5,5)) desc)main_qry where rownum<=10";
//out.println(QueryString);

		try{
			
		rs = statement.executeQuery(QueryString);
		
		JSONArray array=new JSONArray();
		while (rs.next()) 
		{
			    JSONObject obj = new JSONObject();
             		     obj.put("Transaction_Id",rs.getString(1));
		                obj.put("Part_Tran_Id",rs.getString(2));
		                obj.put("Tran_Date",rs.getString(3));
		                obj.put("Transaction_Particulars",rs.getString(4));
		                obj.put("Tran_Amount",rs.getString(5));
		               
		               
              
                array.add(obj);
		}
		
		//Collections.reverse(array);

		
		
		
		conn1.close();
		
		out.println(array);
		
		
		}catch(SQLException e){
	        out.print("Exception: "+e);
	    }
		
		
		
	} catch (Exception e) {

	}

	output = Be;

	
	//response.addHeader("AustinAndroidReturn", output);

}
		
else if (no == 562) {
	//out.println("Hello Ur Action Type is= <b>"
			//+ request.getParameter("type") + "</b>");

	String Be = "";
	String output = "";

	String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
	String mon = request.getParameter("mon");
	String CDate = request.getParameter("Dt");
	String Dt = CDate;//CDate.substring(4,2);
	String val1 = request.getParameter("val1");
	String val2 = request.getParameter("val2");
	//out.println("Date is= <b>" + Dt + "</b>");
	
	Connection conn1 = null;
	Statement statement = null;
	Statement statement2 = null;
	ResultSet rs = null;
	ResultSet rs2 = null;
	try {

		Class.forName(ODriver);
		conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
		//out.println("connected....!!");
		statement = conn1.createStatement();
		//String QueryString="SELECT  a.Transaction_Id,a.Part_Tran_Id,a.Tran_Date,a.Transaction_Particulars as Transaction_Particulars,a.Tran_Amount FROM (Select to_char(Transaction_Date,'dd/MM/yyyy') as Tran_Date, to_char(Transaction_Id) as Transaction_Id,to_char(Part_Tran_Id) as Part_Tran_Id,Transaction_Date,substr(Transaction_Particulars,1,10) as Transaction_Particulars,to_char(Transaction_Amount ||' '||case when Transaction_Type='Credit' then 'Cr' else 'Dr' End) as Tran_Amount from DAILY_TRANSACTION_ACTIVE_TABLE where Account_no='"+devId+"' and to_char(branch)='"+mon+"' and Transaction_Date between to_date('"+val1+"','dd/MM/yyyy') and to_date('"+val2+"','dd/MM/yyyy'))a order by a.Transaction_Date desc,to_number(substr(to_char(a.Transaction_Id),-5,5)) desc";
//MM/dd/yyyy		
String QueryString="SELECT  a.Transaction_Id,a.Part_Tran_Id,a.Tran_Date,a.Transaction_Particulars as Transaction_Particulars,a.Tran_Amount FROM (Select to_char(Transaction_Date,'dd/MM/yyyy') as Tran_Date, to_char(Transaction_Id) as Transaction_Id,to_char(Part_Tran_Id) as Part_Tran_Id,Transaction_Date,substr(Transaction_Particulars,1,10) as Transaction_Particulars,to_char(Transaction_Amount ||' '||case when Transaction_Type='Credit' then 'Cr' else 'Dr' End) as Tran_Amount from DAILY_TRANSACTION_ACTIVE_TABLE where Account_no='"+devId+"'  and Transaction_Date between to_date('"+val1+"','MM/dd/yyyy') and to_date('"+val2+"','MM/dd/yyyy'))a order by a.Transaction_Date desc,to_number(substr(to_char(a.Transaction_Id),-5,5)) desc";
//dd/MM/yyyy
//String QueryString="SELECT  a.Transaction_Id,a.Part_Tran_Id,a.Tran_Date,a.Transaction_Particulars as Transaction_Particulars,a.Tran_Amount FROM (Select to_char(Transaction_Date,'dd/MM/yyyy') as Tran_Date, to_char(Transaction_Id) as Transaction_Id,to_char(Part_Tran_Id) as Part_Tran_Id,Transaction_Date,substr(Transaction_Particulars,1,10) as Transaction_Particulars,to_char(Transaction_Amount ||' '||case when Transaction_Type='Credit' then 'Cr' else 'Dr' End) as Tran_Amount from DAILY_TRANSACTION_ACTIVE_TABLE where Account_no='"+devId+"'  and Transaction_Date between to_date('"+val1+"','dd/MM/yyyy') and to_date('"+val2+"','dd/MM/yyyy'))a order by a.Transaction_Date desc,to_number(substr(to_char(a.Transaction_Id),-5,5)) desc";


//out.println(QueryString);

		try{
			
		/*statement2 = conn1.createStatement();
		String QueryString2="insert into test11 values('"+val1+"','"+val2+"')";
		statement2.executeQuery(QueryString2);*/

		rs = statement.executeQuery(QueryString);
		
		JSONArray array=new JSONArray();
		while (rs.next()) 
		{
			    JSONObject obj = new JSONObject();
             		     obj.put("Transaction_Id",rs.getString(1));
		                obj.put("Part_Tran_Id",rs.getString(2));
		                obj.put("Tran_Date",rs.getString(3));
		                obj.put("Transaction_Particulars",rs.getString(4));
		                obj.put("Tran_Amount",rs.getString(5));
		               
		               
              
                array.add(obj);
		}
		
		

		
		
		
		conn1.close();
		
		out.println(array);
		
		
		}catch(SQLException e){
	        out.print("Exception: "+e);
	    }
		
		
		
	} catch (Exception e) {

	}

	output = Be;

	
	//response.addHeader("AustinAndroidReturn", output);

}
//dashboard2 customer list
else if (no == 563) {
	//out.println("Hello Ur Action Type is= <b>"
			//+ request.getParameter("type") + "</b>");

	String Be = "";
	String output = "";

	String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
	String mon = request.getParameter("mon");
	String CDate = request.getParameter("Dt");
	String Dt = CDate;//CDate.substring(4,2);
	//out.println("Date is= <b>" + Dt + "</b>");
	Connection conn1 = null;
	Statement statement = null;
	Statement statement2 = null;
	ResultSet rs = null;
	ResultSet rs2 = null;
	try {

		Class.forName(ODriver);
		conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
		//out.println("connected....!!");
		statement = conn1.createStatement();

//Log------------------------------------
		PreparedStatement p=null;
		
		  String logQuery="insert into APP_OPERATION_LOG(mon,type,no) values('"+mon+"','DashBoard_CusDetailsList','"+no+"')";
		  p =conn1.prepareStatement(logQuery);
		  try{
			p.execute();
		  }catch(SQLException e){
		        out.print("Exception: "+e);
		    }
//-----------------------------------------------		


		

//12-12-2023
String QueryString = "select (select short_name from branch_master where substr(to_char(BRANCH_CUSIDFROM),0,3)=substr(a.customer_id,0,3) ) as bname,a.Customer_id,a.Customer_Name from (select distinct customer_id ,customer_name  from customer_View where mobile_no='"+mon+"')a";
//out.println(QueryString);

		try{
			
		rs = statement.executeQuery(QueryString);
		
		JSONArray array=new JSONArray();
		while (rs.next()) 
		{
			    JSONObject obj = new JSONObject();
			    obj.put("Branch_Code",rs.getString(1));
                obj.put("Customer_Id",rs.getString(2));
                obj.put("Customer_Name",rs.getString(3));
                  array.add(obj);
//out.println(rs.getString(1));

		}
		
		

		
		
		
		conn1.close();
		
		out.println(array);
		
		
		}catch(SQLException e){
	        out.print("Exception: "+e);
	    }
		
		
		
	} catch (Exception e) {

	}

	
}
		//input as customerId for dashboard 
else if (no == 564) {
	//out.println("Hello Ur Action Type is= <b>"
			//+ request.getParameter("type") + "</b>");

	String Be = "";
	String output = "";

	String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
	String mon = request.getParameter("mon");
	String CDate = request.getParameter("Dt");
	String Dt = CDate;//CDate.substring(4,2);
	//out.println("Date is= <b>" + Dt + "</b>");
	Connection conn1 = null;
	Statement statement = null;
	Statement statement2 = null;
	ResultSet rs = null;
	ResultSet rs2 = null;
	try {

		Class.forName(ODriver);
		conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
		//out.println("connected....!!");
		statement = conn1.createStatement();
		statement2 = conn1.createStatement();
		String customer_id=mon;
		//12-12-2023
       // String QueryString = "select qry1.customer_id,qry2.customer_name,case when qry1.TIME_INFO is null then '00:00:00' else substr(qry1.TIME_INFO,1,16) end as Last_Login,qry2.Closing_balance as CB from (select a.* from (select customer_id,log_details.TIME_INFO,log_details.ID,ROW_NUMBER() OVER ( ORDER BY id desc) as row2 from log_details where customer_id='"+customer_id+"' order by id desc)a where row2=2)qry1 left join (select b.* from (select customer_id,customer_name,Closing_balance,ROW_NUMBER() OVER ( ORDER BY customer_id desc) as row1 from sbca_master_view_report where customer_id='"+customer_id+"' or CUSTOMER_ID_2='"+customer_id+"' or CUSTOMER_ID_3='"+customer_id+"')b where row1=1)qry2 on qry2.customer_id=qry1.customer_id";
int count=0;
		double CB=0;
		String countQuery="select count(*) from (select Closing_balance,ROW_NUMBER() OVER ( ORDER BY customer_id desc) as row1 from sbca_master_view_report where customer_id='"+customer_id+"' or CUSTOMER_ID_2='"+customer_id+"' or CUSTOMER_ID_3='"+customer_id+"')b where row1=1";
		//out.println(countQuery);
		rs2 = statement2.executeQuery(countQuery);
		while (rs2.next()) 
		{
			count=rs2.getInt(1);
		}
	
String Account_No="0";
		if(count !=0)
		{
			//String countQuery2="select b.Closing_balance as CB from (select Closing_balance,ROW_NUMBER() OVER ( ORDER BY customer_id desc) as row1 from sbca_master_view_report where customer_id='"+customer_id+"' or CUSTOMER_ID_2='"+customer_id+"' or CUSTOMER_ID_3='"+customer_id+"')b where row1=1";
			/*rs2 = statement2.executeQuery(countQuery2);
			while (rs2.next()) 
			{
				CB=rs2.getDouble(1);
			}*/
			//04-01-2024
			//String countQuery2="select b.Account_No,b.Closing_balance as CB from (select Closing_balance,ROW_NUMBER() OVER ( ORDER BY customer_id desc) as row1,Account_No from sbca_master_view_report where customer_id='"+customer_id+"' or CUSTOMER_ID_2='"+customer_id+"' or CUSTOMER_ID_3='"+customer_id+"')b where row1=1";
			//17-04-2024
			String countQuery2="select main_qry.* from (select a.Account_no,a.CB from (select Account_No,Closing_balance as CB ,1 as type from sbca_master_view_report where customer_id='"+customer_id+"' union select Account_No,Closing_balance as CB ,2 as type from sbca_master_view_report where CUSTOMER_ID_2='"+customer_id+"' union select Account_No,Closing_balance as CB ,3 as type from sbca_master_view_report where CUSTOMER_ID_3='"+customer_id+"')a order by a.type,a.Account_no)main_qry where rownum=1";
			

//out.println(countQuery2);

			rs2 = statement2.executeQuery(countQuery2);
			while (rs2.next()) 
			{
				CB=rs2.getDouble(2);
				Account_No=rs2.getString(1);
			}
		}

		//Get SDep,SLn------------------------------------------------------------
		double SDep=0,SLn=0;
		double SFD=0,SRD=0;
		double SJL=0,SDL=0;
		double SML=0;
		double SSD=0;

     /*   int Dcount=0;
		int Lcount=0;
		String DepCount="select count(*) from (select main_qry.Account_type,sum(main_qry.CB) as sum1 from (Select Account_No,Account_Type,TR1+TR2+TR3+TR4+TR5 as CB from (Select Account_No,Account_Type,sum(case when Account_Type in ('SD','FD','OD') then case when Transaction_Type='Credit' then TRANSACTION_AMOUNT else -1*TRANSACTION_AMOUNT End else 0 End) as Tr1,sum(case when Account_Type in ('RD','SC') and Flag in ('AC','INT') then case when Transaction_Type='Credit' then TRANSACTION_AMOUNT else -1*TRANSACTION_AMOUNT End else 0 End) as Tr2,sum(case when Account_Type in ('JL') and Flag in ('AC') then case when Transaction_Type='Credit' then -1*TRANSACTION_AMOUNT else TRANSACTION_AMOUNT End else 0 End) as Tr3,sum(case when Account_Type in ('CL','DL','PL') then case when Transaction_Type='Credit' and Flag in ('AC') then -1*TRANSACTION_AMOUNT else case when Transaction_Type='Debit' then TRANSACTION_AMOUNT else 0 End End else 0 End) as Tr4,sum(case when Account_Type in ('CC') then case when Transaction_Type='Credit' then -1*TRANSACTION_AMOUNT else TRANSACTION_AMOUNT End else 0 End) as Tr5 from DAILY_TRANSACTION_ACTIVE_TABLE where Customer_Id="+customer_id+" group by Account_No,Account_Type ) qry)main_qry where main_qry.Account_Type in ('SD','FD','RD') group by main_qry.Account_Type)mainqry";
		String LnCount="select count(*) from (select main_qry.Account_type,sum(main_qry.CB) as sum1 from (Select Account_No,Account_Type,TR1+TR2+TR3+TR4+TR5 as CB from (Select Account_No,Account_Type,sum(case when Account_Type in ('SD','FD','OD') then case when Transaction_Type='Credit' then TRANSACTION_AMOUNT else -1*TRANSACTION_AMOUNT End else 0 End) as Tr1,sum(case when Account_Type in ('RD','SC') and Flag in ('AC','INT') then case when Transaction_Type='Credit' then TRANSACTION_AMOUNT else -1*TRANSACTION_AMOUNT End else 0 End) as Tr2,sum(case when Account_Type in ('JL') and Flag in ('AC') then case when Transaction_Type='Credit' then -1*TRANSACTION_AMOUNT else TRANSACTION_AMOUNT End else 0 End) as Tr3,sum(case when Account_Type in ('CL','DL','PL') then case when Transaction_Type='Credit' and Flag in ('AC') then -1*TRANSACTION_AMOUNT else case when Transaction_Type='Debit' then TRANSACTION_AMOUNT else 0 End End else 0 End) as Tr4,sum(case when Account_Type in ('CC') then case when Transaction_Type='Credit' then -1*TRANSACTION_AMOUNT else TRANSACTION_AMOUNT End else 0 End) as Tr5 from DAILY_TRANSACTION_ACTIVE_TABLE where Customer_Id="+customer_id+" group by Account_No,Account_Type ) qry)main_qry where main_qry.Account_Type in ('JL','DL','ML') group by main_qry.Account_Type)mainqry";
		rs2 = statement2.executeQuery(DepCount);
		while (rs2.next()) 
		{
			Dcount=rs2.getInt(1);
		}
		rs2 = statement2.executeQuery(LnCount);
		while (rs2.next()) 
		{
			Lcount=rs2.getInt(1);
		}
		if(Dcount!=0)
		{
			String DepQry="select main_qry.Account_type,sum(main_qry.CB) as sum1 from (Select Account_No,Account_Type,TR1+TR2+TR3+TR4+TR5 as CB from (Select Account_No,Account_Type,sum(case when Account_Type in ('SD','FD','OD') then case when Transaction_Type='Credit' then TRANSACTION_AMOUNT else -1*TRANSACTION_AMOUNT End else 0 End) as Tr1,sum(case when Account_Type in ('RD','SC') and Flag in ('AC','INT') then case when Transaction_Type='Credit' then TRANSACTION_AMOUNT else -1*TRANSACTION_AMOUNT End else 0 End) as Tr2,sum(case when Account_Type in ('JL') and Flag in ('AC') then case when Transaction_Type='Credit' then -1*TRANSACTION_AMOUNT else TRANSACTION_AMOUNT End else 0 End) as Tr3,sum(case when Account_Type in ('CL','DL','PL') then case when Transaction_Type='Credit' and Flag in ('AC') then -1*TRANSACTION_AMOUNT else case when Transaction_Type='Debit' then TRANSACTION_AMOUNT else 0 End End else 0 End) as Tr4,sum(case when Account_Type in ('CC') then case when Transaction_Type='Credit' then -1*TRANSACTION_AMOUNT else TRANSACTION_AMOUNT End else 0 End) as Tr5 from DAILY_TRANSACTION_ACTIVE_TABLE where Customer_Id="+customer_id+" group by Account_No,Account_Type ) qry)main_qry where main_qry.Account_Type in ('SD','FD','RD') group by main_qry.Account_Type";
			rs2 = statement2.executeQuery(DepQry);
			while (rs2.next()) 
			{
			
				if(rs2.getString(1).equalsIgnoreCase("SD"))
				{
					SSD=rs2.getDouble(2);
				}
				if(rs2.getString(1).equalsIgnoreCase("FD"))
				{
					SFD=rs2.getDouble(2);
				}
				if(rs2.getString(1).equalsIgnoreCase("RD"))
				{
					SRD=rs2.getDouble(2);
				}
			}
			SDep=SSD+SFD+SRD;
		}
		if(Lcount!=0)
		{
			String LnQry="select main_qry.Account_type,sum(main_qry.CB) as sum1 from (Select Account_No,Account_Type,TR1+TR2+TR3+TR4+TR5 as CB from (Select Account_No,Account_Type,sum(case when Account_Type in ('SD','FD','OD') then case when Transaction_Type='Credit' then TRANSACTION_AMOUNT else -1*TRANSACTION_AMOUNT End else 0 End) as Tr1,sum(case when Account_Type in ('RD','SC') and Flag in ('AC','INT') then case when Transaction_Type='Credit' then TRANSACTION_AMOUNT else -1*TRANSACTION_AMOUNT End else 0 End) as Tr2,sum(case when Account_Type in ('JL') and Flag in ('AC') then case when Transaction_Type='Credit' then -1*TRANSACTION_AMOUNT else TRANSACTION_AMOUNT End else 0 End) as Tr3,sum(case when Account_Type in ('CL','DL','PL') then case when Transaction_Type='Credit' and Flag in ('AC') then -1*TRANSACTION_AMOUNT else case when Transaction_Type='Debit' then TRANSACTION_AMOUNT else 0 End End else 0 End) as Tr4,sum(case when Account_Type in ('CC') then case when Transaction_Type='Credit' then -1*TRANSACTION_AMOUNT else TRANSACTION_AMOUNT End else 0 End) as Tr5 from DAILY_TRANSACTION_ACTIVE_TABLE where Customer_Id="+customer_id+" group by Account_No,Account_Type ) qry)main_qry where main_qry.Account_Type in ('JL','DL','ML') group by main_qry.Account_Type";
			rs2 = statement2.executeQuery(LnQry);
			while (rs2.next()) 
			{
			
				if(rs2.getString(1).equalsIgnoreCase("JL"))
				{
					SJL=rs2.getDouble(2);
				}
				if(rs2.getString(1).equalsIgnoreCase("DL"))
				{
					SDL=rs2.getDouble(2);
				}
				if(rs2.getString(1).equalsIgnoreCase("ML"))
				{
					SML=rs2.getDouble(2);
				}
			}
			SLn=SJL+SDL+SML;
		}
*/


		//01-03-2024
		String sumDepLnQry="select GET_CUSTOMER_Deposit('"+customer_id+"') as SDep,GET_CUSTOMER_Loan('"+customer_id+"') as SLn,GET_CUSTOMER_FD('"+customer_id+"') as SFD,GET_CUSTOMER_RD('"+customer_id+"') as SRD,GET_CUSTOMER_JL('"+customer_id+"') as SJL,GET_CUSTOMER_DL('"+customer_id+"') as SDL,GET_CUSTOMER_ML('"+customer_id+"') as SML,GET_CUSTOMER_SD('"+customer_id+"') as SSD  from dual";
		//out.println(sumDepLnQry);
		rs2 = statement2.executeQuery(sumDepLnQry);
		while (rs2.next()) 
		{
			SDep=rs2.getDouble(1);
			SLn=rs2.getDouble(2);
			SFD=rs2.getDouble(3);
			SRD=rs2.getDouble(4);
			SJL=rs2.getDouble(5);
			SDL=rs2.getDouble(6);
			SML=rs2.getDouble(7);
			SSD=rs2.getDouble(8);
	


		}
		//-----------------------------------------------------------------------------------
		
		
		//12-12-2023
       // String QueryString = "select qry1.customer_id,qry2.customer_name,case when qry1.TIME_INFO is null then '00:00:00' else substr(qry1.TIME_INFO,1,16) end as Last_Login,qry2.Closing_balance as CB from (select a.* from (select customer_id,log_details.TIME_INFO,log_details.ID,ROW_NUMBER() OVER ( ORDER BY id desc) as row2 from log_details where customer_id='"+customer_id+"' order by id desc)a where row2=2)qry1 left join (select b.* from (select customer_id,customer_name,Closing_balance,ROW_NUMBER() OVER ( ORDER BY customer_id desc) as row1 from sbca_master_view_report where customer_id='"+customer_id+"' or CUSTOMER_ID_2='"+customer_id+"' or CUSTOMER_ID_3='"+customer_id+"')b where row1=1)qry2 on qry2.customer_id=qry1.customer_id";
       //13-12-2023
       // String QueryString ="select qry1.*,qry2.* from (select Customer_id,Customer_Name from Customer_View where customer_id='"+mon+"' and rownum=1)qry1 cross join (select case when a.TIME_INFO is null then '00:00:00' else to_char(a.TIME_INFO,'dd-MM-yyyy hh:mi:ss ') end as Last_Login from (select id,Customer_id,time_info,ROW_NUMBER() OVER ( ORDER BY id desc) as row2 from log_details where customer_id in (select to_char(customer_id) from customer_view where mobile_no in (select mobile_no from customer_view where customer_id='"+mon+"' and rownum=1 )))a  where a.row2=2)qry2";
     //13-03-2024  
      String QueryString ="select qry1.*,qry2.* from (select Customer_id,Customer_Name from Customer_View where customer_id='"+mon+"' and rownum=1)qry1 cross join (select case when a.TIME_INFO is null then '00:00:00' else to_char(a.TIME_INFO,'dd-MM-yyyy hh:mi:ss AM') end as Last_Login from (select id,Customer_id,time_info,ROW_NUMBER() OVER ( ORDER BY id desc) as row2 from log_details where customer_id in (select to_char(customer_id) from customer_view where mobile_no in ('"+CDate +"')))a  where a.row2=2)qry2";

//out.println(QueryString);
		try{
			
		rs = statement.executeQuery(QueryString);
		
		JSONArray array=new JSONArray();
		while (rs.next()) 
		{
			    JSONObject obj = new JSONObject();
                obj.put("Customer_Id",rs.getString(1));
                obj.put("Customer_Name",rs.getString(2));
                obj.put("Last_Login",rs.getString(3));
                obj.put("CB",CB);
               
                obj.put("Acno",Account_No);

 		obj.put("SDep",SDep);
                obj.put("SLn",SLn);
		
		obj.put("SFD",SFD);
                obj.put("SRD",SRD);
		obj.put("SJL",SJL);
                obj.put("SDL",SDL);
		obj.put("SML",SML);
               obj.put("SSD",SSD);



              
                array.add(obj);
		}
		
		
//Log------------------------------------
		PreparedStatement p=null;
		
		  String logQuery="insert into APP_OPERATION_LOG(mon,type,no,cid) values('"+mon+"','DashBoard_CusDetails','"+no+"','"+mon+"')";
		  p =conn1.prepareStatement(logQuery);
		  try{
			p.execute();
		  }catch(SQLException e){
		        out.print("Exception: "+e);
		    }
//-----------------------------------------------		


		
		
		
		conn1.close();
		
		out.println(array);
		
		
		}catch(SQLException e){
	        out.print("Exception: "+e);
	    }
		
		
		
	} catch (Exception e) {

	}

	output = Be;

	
	//response.addHeader("AustinAndroidReturn", output);

}

else if (no == 5580) {
	//out.println("Hello Ur Action Type is= <b>"
			//+ request.getParameter("type") + "</b>");

	String Be = "";
	String output = "";

	String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
	String mon = request.getParameter("mon");
	String CDate = request.getParameter("Dt");
	String Dt = CDate;//CDate.substring(4,2);
	//out.println("Date is= <b>" + Dt + "</b>");
	
	Connection conn1 = null;
	Statement statement = null;
	Statement statement2 = null;
	ResultSet rs = null;
	ResultSet rs2 = null;
ResultSet rs3 = null;
		Statement statement3 = null;
		
	try {

		Class.forName(ODriver);
		conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
		//out.println("connected....!!");
		statement = conn1.createStatement();
		//String QueryString = "SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.Customer_Name FROM ( Select Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'SD' AS TYPE,Customer_Id,Customer_Name from SBCA_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' union Select Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'FD' AS TYPE,Customer_Id,Customer_Name from FD_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' union Select Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'RD' AS TYPE,Customer_Id,Customer_Name from RD_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' )main_qry  order by main_qry.SCheme_Code,main_qry.Account_No";
		//String QueryString="SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.acNm FROM ( Select Branch as Branch,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'SD' AS TYPE,Customer_Id,Customer_Name as acNm from SBCA_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' union Select to_char(Branch_Code) as Branch ,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'FD' AS TYPE,Customer_Id,Customer_Name as acNm from FD_Master_View where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' union Select  Branch as Branch,Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'RD' AS TYPE,Customer_Id,Customer_Name as acNm from RD_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' )main_qry    order by main_qry.Account_No,main_qry.SCheme_Code,main_qry.Branch";
			//12-12-2023
		//String QueryString="SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.acNm FROM ( Select Branch as Branch,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'SD' AS TYPE,Customer_Id,Customer_Name as acNm from SBCA_MASTER_VIEW_REPORT where (to_char(Customer_Id)='"+devId+"' or to_char(CUSTOMER_ID_2)='"+devId+"' or to_char(CUSTOMER_ID_3)='"+devId+"') and Account_Status like 'A%' union Select to_char(Branch_Code) as Branch ,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'FD' AS TYPE,Customer_Id,Customer_Name as acNm from FD_Master_View where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' union Select  Branch as Branch,Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'RD' AS TYPE,Customer_Id,Customer_Name as acNm from RD_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' )main_qry    order by main_qry.Account_No,main_qry.SCheme_Code,main_qry.Branch";
		//  String QueryString="SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.acNm ,(select short_Name from branch_Master where to_char(branch_code)=substr(main_qry.Account_No,0,3)) as Bname FROM ( Select Branch as Branch,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'SD' AS TYPE,Customer_Id,Customer_Name as acNm from SBCA_MASTER_VIEW_REPORT where (to_char(Customer_Id)='"+devId+"' or to_char(CUSTOMER_ID_2)='"+devId+"' or to_char(CUSTOMER_ID_3)='"+devId+"') and Account_Status !='C' union Select to_char(Branch_Code) as Branch ,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'FD' AS TYPE,Customer_Id,Customer_Name as acNm from FD_Master_View where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' and scheme_code not in (select scheme_code from scheme_master where dep='9') union Select  Branch as Branch,Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'RD' AS TYPE,Customer_Id,Customer_Name as acNm from RD_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' )main_qry    order by main_qry.SCheme_Code, main_qry.Account_No,main_qry.Branch";
		//04-03-2024
		// String QueryString="SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.acNm ,(select short_Name from branch_Master where to_char(branch_code)=substr(main_qry.Account_No,0,3)) as Bname FROM ( Select Branch as Branch,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'SD' AS TYPE,Customer_Id,Customer_Name as acNm from SBCA_MASTER_VIEW_REPORT where (to_char(Customer_Id)='"+devId+"' or to_char(CUSTOMER_ID_2)='"+devId+"' or to_char(CUSTOMER_ID_3)='"+devId+"') and Account_Status !='C' union Select to_char(Branch_Code) as Branch ,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Deposit_Amount as CB,Account_Status,'FD' AS TYPE,Customer_Id,Customer_Name as acNm from FD_Master_View where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' and scheme_code not in (select scheme_code from scheme_master where dep='9') union Select  Branch as Branch,Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,(NO_OF_INST_PAID*Deposit_Amount) as CB,Account_Status,'RD' AS TYPE,Customer_Id,Customer_Name as acNm from RD_MasterView_C2 where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' )main_qry    order by main_qry.SCheme_Code, main_qry.Account_No,main_qry.Branch";

              //06-03-2024 with ERS
		//String QueryString="SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.acNm ,(select short_Name from branch_Master where to_char(branch_code)=substr(main_qry.Account_No,0,3)) as Bname FROM ( Select Branch as Branch,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'SD' AS TYPE,Customer_Id,Customer_Name as acNm from SBCA_MASTER_VIEW_REPORT where (to_char(Customer_Id)='"+devId+"' or to_char(CUSTOMER_ID_2)='"+devId+"' or to_char(CUSTOMER_ID_3)='"+devId+"') and Account_Status !='C' union Select to_char(Branch_Code) as Branch ,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Deposit_Amount as CB,Account_Status,'FD' AS TYPE,Customer_Id,Customer_Name as acNm from FD_Master_View where (to_char(Customer_Id)='"+devId+"' or to_char(CUSTOMER_ID_2)='"+devId+"' or to_char(CUSTOMER_ID_3)='"+devId+"') and Account_Status like 'A%' and scheme_code not in (select scheme_code from scheme_master where dep='9') union Select  Branch as Branch,Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,(NO_OF_INST_PAID*Deposit_Amount) as CB,Account_Status,'RD' AS TYPE,Customer_Id,Customer_Name as acNm from RD_MasterView_C2 where (to_char(Customer_Id)='"+devId+"' or to_char(CUSTOMER_ID_2)='"+devId+"' or to_char(CUSTOMER_ID_3)='"+devId+"')  and Account_Status like 'A%' )main_qry    order by main_qry.SCheme_Code, main_qry.Account_No,main_qry.Branch";

 //07-03-2024 order by
              		String QueryString=" SELECT  main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.acNm ,(select short_Name from branch_Master where to_char(branch_code)=substr(main_qry.Account_No,0,3)) as Bname FROM (     select '1' as groupno, a.* from (Select Branch as Branch,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'SD/SSD' AS TYPE,Customer_Id,Customer_Name as acNm from SBCA_MASTER_VIEW_REPORT where (to_char(Customer_Id)='"+devId+"' or to_char(CUSTOMER_ID_2)='"+devId+"' or to_char(CUSTOMER_ID_3)='"+devId+"') and Account_Status !='C'  order by SBCA_MASTER_VIEW_REPORT.open_date desc)a     union      select '2' as groupno, a.* from (Select to_char(Branch_Code) as Branch ,Scheme_Code,Account_No,to_char(VALUE_DATE,'dd/MM/yyyy') as Open_Date,Deposit_Amount as CB,Account_Status,'FD/CD' AS TYPE,Customer_Id,Customer_Name as acNm from FD_Master_View where (to_char(Customer_Id)='"+devId+"' or to_char(CUSTOMER_ID_2)='"+devId+"' or to_char(CUSTOMER_ID_3)='"+devId+"') and Account_Status like 'A%' and scheme_code not in (select scheme_code from scheme_master where dep='9') order by FD_Master_View.open_date desc)a union     select '3' as groupno,a.* from ( Select  Branch as Branch,Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,(NO_OF_INST_PAID*Deposit_Amount) as CB,Account_Status,'RD' AS TYPE,Customer_Id,Customer_Name as acNm from RD_MasterView_C2 where (to_char(Customer_Id)='"+devId+"' or to_char(CUSTOMER_ID_2)='"+devId+"' or to_char(CUSTOMER_ID_3)='"+devId+"')  and Account_Status like 'A%' order by RD_MasterView_C2.open_date desc)a    )main_qry       ORDER BY main_qry.groupno,to_date(main_qry.open_date,'dd/MM/yyyy')desc ";

//12-03-2024
              		//String QueryString=" SELECT  main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,q.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.acNm ,(select short_Name from branch_Master where to_char(branch_code)=substr(main_qry.Account_No,0,3)) as Bname FROM (  select '1' as groupno, a.* from (Select Branch as Branch,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'SD' AS TYPE,Customer_Id,Customer_Name as acNm ,get_closing_balance_view_approved(Account_no) as CB2 from SBCA_MASTER_VIEW_REPORT where (to_char(Customer_Id)='"+devId+"' or to_char(CUSTOMER_ID_2)='"+devId+"' or to_char(CUSTOMER_ID_3)='"+devId+"') and Account_Status !='C'  order by SBCA_MASTER_VIEW_REPORT.open_date desc)a             union                  select '2' as groupno, a.* from (Select to_char(Branch_Code) as Branch ,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Deposit_Amount as CB,Account_Status,'FD' AS TYPE,Customer_Id,Customer_Name as acNm,get_closing_balance_view_approved(Account_no) as CB2 from FD_Master_View where (to_char(Customer_Id)='"+devId+"' or to_char(CUSTOMER_ID_2)='"+devId+"' or to_char(CUSTOMER_ID_3)='"+devId+"') and Account_Status like 'A%' and scheme_code not in (select scheme_code from scheme_master where dep='9') order by FD_Master_View.open_date desc)a        union                   select '3' as groupno,a.* from ( Select  Branch as Branch,Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,(NO_OF_INST_PAID*Deposit_Amount) as CB,Account_Status,'RD' AS TYPE,Customer_Id,Customer_Name as acNm,get_closing_balance_view_approved(Account_no) as CB2 from RD_MasterView_C2 where (to_char(Customer_Id)='"+devId+"' or to_char(CUSTOMER_ID_2)='"+devId+"' or to_char(CUSTOMER_ID_3)='"+devId+"')  and Account_Status like 'A%' order by RD_MasterView_C2.open_date desc)a                          )main_qry                    left join                   (Select Account_No,Account_Type,TR1+TR2+TR3+TR4+TR5 as CB from (Select Account_No,Account_Type,sum(case when Account_Type in ('SD','FD','OD') then case when Transaction_Type='Credit' then TRANSACTION_AMOUNT else -1*TRANSACTION_AMOUNT End else 0 End) as Tr1,sum(case when Account_Type in ('RD','SC') and Flag in ('AC','INT') then case when Transaction_Type='Credit' then TRANSACTION_AMOUNT else -1*TRANSACTION_AMOUNT End else 0 End) as Tr2,sum(case when Account_Type in ('JL') and Flag in ('AC') then case when Transaction_Type='Credit' then -1*TRANSACTION_AMOUNT else TRANSACTION_AMOUNT End else 0 End) as Tr3,sum(case when Account_Type in ('CL','DL','PL') then case when Transaction_Type='Credit' and Flag in ('AC') then -1*TRANSACTION_AMOUNT else case when Transaction_Type='Debit' then TRANSACTION_AMOUNT else 0 End End else 0 End) as Tr4,sum(case when Account_Type in ('CC') then case when Transaction_Type='Credit' then -1*TRANSACTION_AMOUNT else TRANSACTION_AMOUNT End else 0 End) as Tr5 from DAILY_TRANSACTION_ACTIVE_TABLE where Customer_Id="+devId+" group by Account_No,Account_Type ) qry )q   on                  main_qry.Account_no=q.Account_no     where q.CB !=0            ORDER BY main_qry.groupno,to_date(main_qry.open_date,'dd/MM/yyyy')desc              ";

		//Log------------------------------------
		PreparedStatement p=null;
		
		  String logQuery="insert into APP_OPERATION_LOG(did,cid,type,no) values('"+devId+"','"+devId+"','Deposit List','"+no+"')";
//out.println(logQuery);
		  
p =conn1.prepareStatement(logQuery);
		  try{
			p.execute();
		  }catch(SQLException e){
		        out.print("Exception: "+e);
		    }
//-----------------------------------------------		

		try{
			
		rs = statement.executeQuery(QueryString);
		
		JSONArray array=new JSONArray();
		while (rs.next()) 
		{
			    JSONObject obj = new JSONObject();
                 obj.put("Account_No",rs.getString(2));
                obj.put("Open_Date",rs.getString(3));
                obj.put("CB",rs.getString(4));
                obj.put("Scheme_Code",rs.getString(5));
                obj.put("acNm",rs.getString(7));
                  obj.put("bn",rs.getString(8));
               
              
                array.add(obj);
		}
		
		

		
		
		
		conn1.close();
		
		out.println(array);
		
		
		}catch(SQLException e){
	        out.print("Exception: "+e);
	    }
		
		
		
	} catch (Exception e) {

	}

	output = Be;

	
	//response.addHeader("AustinAndroidReturn", output);

}
//loan
else if (no == 5590) {
//out.println("Hello Ur Action Type is= <b>"
	//+ request.getParameter("type") + "</b>");

String Be = "";
String output = "";

String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
String mon = request.getParameter("mon");
String CDate = request.getParameter("Dt");
String Dt = CDate;//CDate.substring(4,2);
//out.println("Date is= <b>" + Dt + "</b>");

Connection conn1 = null;
Statement statement = null;
Statement statement2 = null;
ResultSet rs = null;
ResultSet rs2 = null;
try {

Class.forName(ODriver);
conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
//out.println("connected....!!");
statement = conn1.createStatement();
//String QueryString = "SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.Customer_Name FROM ( Select Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'SD' AS TYPE,Customer_Id,Customer_Name from SBCA_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' union Select Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'FD' AS TYPE,Customer_Id,Customer_Name from FD_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' union Select Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'RD' AS TYPE,Customer_Id,Customer_Name from RD_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' )main_qry  order by main_qry.Account_No,main_qry.SCheme_Code";
//String QueryString="SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.Customer_Name FROM (Select Branch as Branch,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'JL' AS TYPE,Customer_Id,Customer_Name from JL_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' union Select Branch as Branch ,Scheme_Code,to_char(Account_No) as Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'OL' AS TYPE,Customer_Id,Customer_Name from OL_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' union Select  Branch as Branch,Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'SL' AS TYPE,Customer_Id,Customer_Name from CC_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' )main_qry  where to_char(main_qry.Branch)='"+mon+"%' order by main_qry.Account_No,main_qry.SCheme_Code,main_qry.Branch";
         // String QueryString="SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,nvl(main_qry.CB,0) as CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.Customer_Name FROM (select a.* from (Select Branch as Branch,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'JL' AS TYPE,Customer_Id,Customer_Name from JL_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' union Select Branch as Branch ,Scheme_Code,to_char(Account_No) as Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'OL' AS TYPE,Customer_Id,Customer_Name from OL_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' union Select  Branch as Branch,Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'SL' AS TYPE,Customer_Id,Customer_Name from CC_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%')a )main_qry   order by main_qry.Account_No,main_qry.SCheme_Code,main_qry.Branch";
//12-12-2023
//12-12-2023
          //  String QueryString="SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,nvl(main_qry.CB,0) as CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.Customer_Name,(select short_Name from branch_Master where to_char(branch_code)=substr(main_qry.Account_No,0,3)) as Bname FROM (select a.* from (Select Branch as Branch,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'JL' AS TYPE,Customer_Id,Customer_Name from JL_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' and Scheme_code not in ('60024','60028') union Select Branch as Branch ,Scheme_Code,to_char(Account_No) as Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'OL' AS TYPE,Customer_Id,Customer_Name from OL_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' and scheme_code not in ('70030') union Select  Branch as Branch,Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'SL' AS TYPE,Customer_Id,Customer_Name from CC_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%')a )main_qry where main_qry.CB !=0  order by main_qry.Account_No,main_qry.SCheme_Code,main_qry.Branch";


//07-03-2024 08-03-2024//order by
          //  String QueryString=" SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,nvl(main_qry.CB,0) as CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.Customer_Name,(select short_Name from branch_Master where to_char(branch_code)=substr(main_qry.Account_No,0,3)) as Bname FROM ( select a.* from (Select '1' as groupno,Branch as Branch,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'JL' AS TYPE,Customer_Id,Customer_Name from JL_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' and Scheme_code not in ('60024','60028','60029') order by JL_Master_View_C.open_date desc  union Select '2' as groupno,Branch as Branch ,Scheme_Code,to_char(Account_No) as Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'OL' AS TYPE,Customer_Id,Customer_Name from OL_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' and scheme_code not in ('70030') order by OL_Master_View_C.open_date desc             union Select '3' as groupno, Branch as Branch,Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'SL' AS TYPE,Customer_Id,Customer_Name from CC_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' order by CC_Master_View_C.open_date desc   )a      )main_qry where main_qry.CB !=0  order by main_qry.groupno,main_qry.to_date(open_date,'dd/MM/yyyy') desc";
 String QueryString="SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,nvl(main_qry.CB,0) as CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.Customer_Name,(select short_Name from branch_Master where to_char(branch_code)=substr(main_qry.Account_No,0,3)) as Bname FROM ( select a.* from (select x.* from (Select '1' as groupno,Branch as Branch,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'JL' AS TYPE,Customer_Id,Customer_Name from JL_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' and Scheme_code not in ('60024','60028','60029') order by JL_Master_View_C.open_date desc)x  union select x.* from (Select '2' as groupno,Branch as Branch ,Scheme_Code,to_char(Account_No) as Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status, case when scheme_code !='80001' then'DL' else 'ML' end AS TYPE,Customer_Id,Customer_Name from OL_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' and scheme_code not in ('70030') order by OL_Master_View_C.open_date desc )x union select x.* from (Select '3' as groupno, Branch as Branch,Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'SL' AS TYPE,Customer_Id,Customer_Name from CC_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' order by CC_Master_View_C.open_date desc )x )a      )main_qry where main_qry.CB !=0  order by main_qry.groupno,to_date(main_qry.open_date,'dd/MM/yyyy') desc";

//12-03-2024
//String QueryString=" SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,nvl(q.CB,0) as CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.Customer_Name,(select short_Name from branch_Master where to_char(branch_code)=substr(main_qry.Account_No,0,3)) as Bname FROM ( select a.* from (select x.* from (Select '1' as groupno,Branch as Branch,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'JL' AS TYPE,Customer_Id,Customer_Name from JL_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' and Scheme_code not in ('60024','60028','60029') order by JL_Master_View_C.open_date desc)x  union select x.* from (Select '2' as groupno,Branch as Branch ,Scheme_Code,to_char(Account_No) as Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'OL' AS TYPE,Customer_Id,Customer_Name from OL_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' and scheme_code not in ('70030') order by OL_Master_View_C.open_date desc )x union select x.* from (Select '3' as groupno, Branch as Branch,Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'SL' AS TYPE,Customer_Id,Customer_Name from CC_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' order by CC_Master_View_C.open_date desc )x )a      )main_qry  left join     (Select Account_No,Account_Type,TR1+TR2+TR3+TR4+TR5 as CB from (Select Account_No,Account_Type,sum(case when Account_Type in ('SD','FD','OD') then case when Transaction_Type='Credit' then TRANSACTION_AMOUNT else -1*TRANSACTION_AMOUNT End else 0 End) as Tr1,sum(case when Account_Type in ('RD','SC') and Flag in ('AC','INT') then case when Transaction_Type='Credit' then TRANSACTION_AMOUNT else -1*TRANSACTION_AMOUNT End else 0 End) as Tr2,sum(case when Account_Type in ('JL') and Flag in ('AC') then case when Transaction_Type='Credit' then -1*TRANSACTION_AMOUNT else TRANSACTION_AMOUNT End else 0 End) as Tr3,sum(case when Account_Type in ('CL','DL','PL') then case when Transaction_Type='Credit' and Flag in ('AC') then -1*TRANSACTION_AMOUNT else case when Transaction_Type='Debit' then TRANSACTION_AMOUNT else 0 End End else 0 End) as Tr4,sum(case when Account_Type in ('CC') then case when Transaction_Type='Credit' then -1*TRANSACTION_AMOUNT else TRANSACTION_AMOUNT End else 0 End) as Tr5 from DAILY_TRANSACTION_ACTIVE_TABLE where Customer_Id="+devId+" group by Account_No,Account_Type ) qry )q    on   main_qry.Account_no=q.Account_no     where q.CB !=0    ORDER BY main_qry.groupno,to_date(main_qry.open_date,'dd/MM/yyyy')desc             ";


//Log------------------------------------
		PreparedStatement p=null;
		
		  String logQuery="insert into APP_OPERATION_LOG(did,cid,type,no) values('"+devId+"','"+devId+"','Loan List','"+no+"')";
		  p =conn1.prepareStatement(logQuery);
		  try{
			p.execute();
		  }catch(SQLException e){
		        out.print("Exception: "+e);
		    }
//-----------------------------------------------		


//out.println(QueryString);

try{
	
rs = statement.executeQuery(QueryString);

JSONArray array=new JSONArray();
while (rs.next()) 
{
	    JSONObject obj = new JSONObject();
       /*  obj.put("Scheme_Code",rs.getString(1));
        obj.put("Account_No",rs.getString(2));
        obj.put("Open_Date",rs.getString(3));
        obj.put("CB",rs.getString(4));
        obj.put("Type",rs.getString(5));
        obj.put("Customer_Id",rs.getString(6));
        obj.put("Customer_Name",rs.getString(7));
        */
        obj.put("Account_No",rs.getString(2));
        obj.put("Open_Date",rs.getString(3));
        obj.put("CB",rs.getString(4));
        obj.put("Scheme_Code",rs.getString(5));
        obj.put("acNm",rs.getString(7));
        obj.put("bn",rs.getString(8));
       
       
      
        array.add(obj);
}






conn1.close();

out.println(array);


}catch(SQLException e){
    out.print("Exception: "+e);
}



} catch (Exception e) {

}

output = Be;


//response.addHeader("AustinAndroidReturn", output);

}

		//Update FCM Id
else if (no == 565) {
//out.println("Hello Ur Action Type is= <b>"
	//+ request.getParameter("type") + "</b>");

String Be = "";
String output = "";

String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
String mon = request.getParameter("mon");
String CDate = request.getParameter("Dt");
String Dt = CDate;//CDate.substring(4,2);
//out.println("Date is= <b>" + Dt + "</b>");

Connection conn1 = null;
Statement statement = null;
Statement statement2 = null;
ResultSet rs = null;
ResultSet rs2 = null;
try {

Class.forName(ODriver);
conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
//out.println("connected....!!");
statement = conn1.createStatement();
        // String QueryString="SELECT Update_FCM_ID('"+mon+"','"+devId+"','"+CDate+"') from dual";

       
         
         CallableStatement cs;
         cs = conn1.prepareCall("{CALL Update_FCM_ID1(?,?,?)}");
         cs.setString(1,mon );
         cs.setString(2, devId);
         cs.setString(3, CDate);
       
        
      

try{
	
 rs2 = cs.executeQuery();
out.println("kk");


conn1.close();




}catch(SQLException e){
    out.print("Exception: "+e);
}



} catch (Exception e) {

}

output = Be;


//response.addHeader("AustinAndroidReturn", output);

}

//input as customerId for Profile
else if (no == 566) {
	//out.println("Hello Ur Action Type is= <b>"
			//+ request.getParameter("type") + "</b>");

	String Be = "";
	String output = "";

	String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
	String mon = request.getParameter("mon");
	String CDate = request.getParameter("Dt");
	String Dt = CDate;//CDate.substring(4,2);
	//out.println("Date is= <b>" + Dt + "</b>");
	Connection conn1 = null;
	Statement statement = null;
	Statement statement2 = null;
	ResultSet rs = null;
	ResultSet rs2 = null;
	try {

		Class.forName(ODriver);
		conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
		//out.println("connected....!!");
		statement = conn1.createStatement();
		statement2 = conn1.createStatement();
		String customer_id=mon;
		//12-12-2023
       // String QueryString = "select qry1.customer_id,qry2.customer_name,case when qry1.TIME_INFO is null then '00:00:00' else substr(qry1.TIME_INFO,1,16) end as Last_Login,qry2.Closing_balance as CB from (select a.* from (select customer_id,log_details.TIME_INFO,log_details.ID,ROW_NUMBER() OVER ( ORDER BY id desc) as row2 from log_details where customer_id='"+customer_id+"' order by id desc)a where row2=2)qry1 left join (select b.* from (select customer_id,customer_name,Closing_balance,ROW_NUMBER() OVER ( ORDER BY customer_id desc) as row1 from sbca_master_view_report where customer_id='"+customer_id+"' or CUSTOMER_ID_2='"+customer_id+"' or CUSTOMER_ID_3='"+customer_id+"')b where row1=1)qry2 on qry2.customer_id=qry1.customer_id";
int count=1;
		double CB=0;
		String Account_No="";
		//04-01-2024
		// String QueryString ="select b.customer_Name,b.Address,to_char('XXXXXX'||substr(b.pan_no,-4))as fpan,to_char('XXXXXXXX'||substr(b.ID_NO,-4))as faadhar from (select a.*,case when a.code=200 then 201 else a.code end as cuscode from (select branch_code,Customer_Name,Address,CASE WHEN length(trim(Pan_No))<10 then 'PPPPPPNPAN' ELSE trim(Pan_No) END AS PAN_NO,CASE WHEN length(trim(id_no))<12 then '000000000000' ELSE trim(id_no) END AS id_no,to_number(to_char(substr("+customer_id+",0,3)))+100 as code,created_date from customer_view  where customer_id='"+customer_id+"')a  order by a.created_date desc)b where b.cuscode=b.branch_code and rownum=1";
		//new select b.customer_Name,b.Address,to_char('XXXXXX'||substr(b.pan_no,-4))as fpan,to_char('XXXXXXXX'||substr(b.ID_NO,-4))as faadhar,b.mail,b.mobile_no from (select a.*,case when a.code=200 then 201 else a.code end as cuscode from (select branch_code,Customer_Name,Address,CASE WHEN length(trim(Pan_No))<10 then 'PPPPPPNPAN' ELSE trim(Pan_No) END AS PAN_NO,CASE WHEN length(trim(id_no))<12 then '000000000000' ELSE trim(id_no) END AS id_no,to_number(to_char(substr(10500012,0,3)))+100 as code,created_date,nvl(mail,'NA') as mail,mobile_No from customer_view  where customer_id='10500012')a  order by a.created_date desc)b where b.cuscode=b.branch_code and rownum=1
		//15-02-2024
		String QueryString ="select b.customer_Name,b.Address,to_char('XXXXXX'||substr(b.pan_no,-4))as fpan,to_char('XXXXXXXX'||substr(b.ID_NO,-4))as faadhar,b.mail,nvl(b.mobile_no,'0'),b.GENDER from (select a.*,case when a.code=200 then 201 else a.code end as cuscode from (select branch_code,Customer_Name,Address,CASE WHEN length(trim(Pan_No))<10 then 'PPPPPPNPAN' ELSE trim(Pan_No) END AS PAN_NO,CASE WHEN length(trim(id_no))<12 then '000000000000' ELSE trim(id_no) END AS id_no,to_number(to_char(substr("+customer_id+",0,3)))+100 as code,created_date,nvl(mail,'NA') as mail,mobile_No,GENDER from customer_view  where customer_id='"+customer_id+"')a  order by a.created_date desc)b where b.cuscode=b.branch_code and rownum=1";		

//out.println(QueryString);
		try{
			

//Log------------------------------------
		PreparedStatement p=null;
		
		  String logQuery="insert into APP_OPERATION_LOG(mon,type,no,cid) values('"+mon+"','Customer_Profile','"+no+"','"+mon+"')";
		  p =conn1.prepareStatement(logQuery);
		  try{
			p.execute();
		  }catch(SQLException e){
		        out.print("Exception: "+e);
		    }
//-----------------------------------------------		



		rs = statement.executeQuery(QueryString);

       String Gender="Male";
		
		JSONArray array=new JSONArray();
		while (rs.next()) 
		{
			    JSONObject obj = new JSONObject();
                 obj.put("Customer_Name",rs.getString(1));
                obj.put("Addss",rs.getString(2));
                obj.put("PNo",rs.getString(3));
                obj.put("ANo",rs.getString(4));
                              //15-02-2024
               obj.put("RMob",rs.getString(6));
                obj.put("RMail",rs.getString(5));
                if(rs.getString(7).equalsIgnoreCase("F"))
                {
                	Gender="Female";
                }
                obj.put("Gen",Gender);
                array.add(obj);
		}
		
		

		
		
		
		conn1.close();
		
		out.println(array);
		
		
		}catch(SQLException e){
	        out.print("Exception: "+e);
	    }
		
		
		
	} catch (Exception e) {

	}

	output = Be;

	
	//response.addHeader("AustinAndroidReturn", output);

}
else if(no==567)
{

	//out.println("Hello Ur Action Type is= <b>"
			//+ request.getParameter("type") + "</b>");

	String Be = "";
	String output = "";

	String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
	String mon = request.getParameter("mon");
	String CDate = request.getParameter("Dt");
	String Dt = CDate;//CDate.substring(4,2);
	//out.println("Date is= <b>" + Dt + "</b>");
	Connection conn1 = null;
	Statement statement = null;
	Statement statement2 = null;
	ResultSet rs = null;
	ResultSet rs2 = null;
	try {

		Class.forName(ODriver);
		conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
		//out.println("connected....!!");
		statement = conn1.createStatement();
		statement2 = conn1.createStatement();
		String Acc=mon;
		int count=0;
		double CB=0;
		String Account_Type="";
		String Scheme_Code="";
		String Customer_Id="";
		String ROI="";
String PenIns="0";
String LienNo="";

		String countQuery="select Account_Type,scheme_code,customer_id from CUST_ACC_LINK_VIEW where Account_no='"+Acc+"'";
		rs2 = statement2.executeQuery(countQuery);
		while (rs2.next()) 
		{
			Account_Type=rs2.getString(1);
			Scheme_Code=rs2.getString(2);
			Customer_Id=rs2.getString(3);
		}
		
		if(Account_Type.equalsIgnoreCase("SD"))
		{
			String roiqry="select case when b.age>=80 then a.SUPER_SR_CTZN else case when b.age>=60 then a.SR_CTZN else a.int1 end end as roi from (select int1,SR_CTZN,SUPER_SR_CTZN from(select (case when interest_rate is null then 0 else interest_rate end) as int1,(case when SR_CTZN is null then 0 else SR_CTZN end) as SR_CTZN,(case when SUPER_SR_CTZN is null then 0 else SUPER_SR_CTZN end) as SUPER_SR_CTZN from INTEREST_RATE_MASTER where SCHEME_CODE='"+Scheme_Code+"' and effect_date<=current_date order by effect_date desc) where rownum=1)a  cross join (select TRUNC(MONTHS_BETWEEN((select open_date from SBCA_MASTER_VIEW_C2 where Account_no='"+Acc+"' and rownum=1), to_date((select DATE_OF_BIRTH from Customer_View where Customer_id='"+Customer_Id+"' and rownum=1),'dd/MM/yyyy'))/12) age  from dual)b";
			rs2 = statement2.executeQuery(roiqry);
			while (rs2.next()) 
			{
				ROI=rs2.getString(1)+" %";
			}
		
		}

		if(Account_Type.equalsIgnoreCase("RD"))
		{
			String penInsqry="select nvl(Pending_Inst,0) as pen from (Select Account_No,RD_MasterView_C2.Value_Date as Value_Date,Instalment_Count,Deposit_Amount,No_of_Inst_Paid,case when current_date>Maturity_Date then (Instalment_Count-No_of_Inst_Paid) else (floor(MONTHS_BETWEEN((trunc((current_date),'month')),trunc(Value_date,'month'))) - No_of_Inst_Paid + 1 + (case when EXTRACT(day FROM Value_Date)>EXTRACT(day FROM current_date) then -1 else 0 End)) End as Pending_Inst,case when current_date>Maturity_Date then (Instalment_Count-No_of_Inst_Paid) * Deposit_Amount else (floor(MONTHS_BETWEEN(current_date,Value_Date)) - No_of_Inst_Paid + 1 + (case when EXTRACT(day FROM Value_Date)>EXTRACT(day FROM current_date) then -1 else 0 End)) * Deposit_Amount End as Inst_amt,0 as Penal_amt,Mobile_No,current_date-RD_MasterView_C2.VALUE_DATE from RD_MasterView_C2 left join Customer on RD_MasterView_C2.Customer_Id=Customer.Customer_Id where Account_Status='A' and Value_Date<=current_date and Instalment_Count>No_of_Inst_Paid and case when current_date>Maturity_Date then (Instalment_Count-No_of_Inst_Paid) else (floor(MONTHS_BETWEEN((trunc((current_date),'month')),trunc(Value_Date,'month'))) - No_of_Inst_Paid + 1 + (case when EXTRACT(day FROM Value_Date)>EXTRACT(day FROM current_date) then -1 else 0 End)) End > 0 order by case when current_date>Maturity_Date then (Instalment_Count-No_of_Inst_Paid) else (floor(MONTHS_BETWEEN(Value_Date,current_date)) - No_of_Inst_Paid + 1 + (case when EXTRACT(day FROM Value_Date)>EXTRACT(day FROM current_date) then -1 else 0 End)) End desc) where Account_no='"+Acc+"'";
			rs2 = statement2.executeQuery(penInsqry);
			while (rs2.next()) 
			{
				PenIns=rs2.getString(1);
			}
		
		}
		if(Account_Type.equalsIgnoreCase("DL"))
		{
			
			String lienqry="select a.deposit_No from (select deposit_no,deposit_type from lien_view where Loan_No='"+Acc+"' and deposit_status='A' and rownum=1)a left join (select Account_no,customer_id,Customer_Name from cust_Acc_link_view)b on a.deposit_no=b.Account_no";
			rs2 = statement2.executeQuery(lienqry);
			while (rs2.next()) 
			{
				LienNo=rs2.getString(1);
			}
		
		}
	//out.println("Account_Type "+Account_Type);

String Account_No="";
String countQuery2="";
        if(Account_Type.equalsIgnoreCase("FD"))
        {
			 countQuery2="Select Account_No as acn,Scheme_Name as snm,Scheme_Category as cat,Customer_Id as cus1,Customer_Name as cnm1, Customer_Name_2 as cnm2,'' as cnm3,MODE_OF_OPERATION as mop,  to_Char(value_Date,'dd/MM/yyyy') as odt,to_char(Period_Months|| ' -  months /' || PERIOD_DAYS|| ' - days' ) as pd, to_char(Interest_Rate || ' %') as roi ,Deposit_Amount as amt, Closing_Balance as cb,to_char(Interest_Repayment||' / '||Interest_Payment_Mode) as ipfreq ,to_Char(Maturity_Date,'dd/MM/yyyy') as ddt,Maturity_Amount as mamt,nvl(Nominee_Name,'NA') as nnm,to_char(value_Date,'dd/MM/yyyy') as edt,case when DEDUCT_TDS in ('Y','Yes','YES') then 'Yes' else 'No' end as tds,nvl(NOMINEE_RELATIONSHIP,'NA') as nnm ,nvl(NOMINEE_Age,'NA') as nge ,'FD' AS type,ACCOUNT_STATUS from FD_Master_View  left join Scheme_Master on FD_Master_View.Scheme_Code=Scheme_Master.Scheme_Code where Account_No like '"+Acc+"'";
			
		}
        else if(Account_Type.equalsIgnoreCase("RD"))
        {
			 countQuery2="Select Account_No,Scheme_Name,Scheme_Category,Customer_Id,Customer_Name, Customer_Name_2,'' as Customer_Name_3,MODE_OF_OPERATION,  to_Char(Open_Date,'dd/MM/yyyy') as Open_Date,to_char(Period_Months|| ' -  months' ) as Period, to_char(Interest_Rate || ' %') as Interest_Rate ,Deposit_Amount as Amount, Closing_Balance,to_char(Interest_Repayment||' / '||Interest_Payment_Mode) as Int_Payment_Freq,to_Char(Maturity_Date,'dd/MM/yyyy') as Due_Date,Maturity_Amount,Nominee_Name,to_char(value_Date,'dd/MM/yyyy') as effect_date,case when DEDUCT_TDS in ('Y','Yes','YES') then 'Yes' else 'No' end as tds,Nominee_Relationship,nominee_age as nge,'RD' AS type,ACCOUNT_STATUS   from RD_MasterView_C2 left join Scheme_Master on RD_MasterView_C2.Scheme_Code=Scheme_Master.Scheme_Code where Account_No like '"+Acc+"'";
			
		}
        else if(Account_Type.equalsIgnoreCase("SD"))
        {
			 countQuery2="Select Account_No , Scheme_Name,Scheme_Category,Customer_Id,Customer_Name, Customer_Name_2,'' as Customer_Name_3,MODE_OF_OPERATION, nvl( to_Char(Open_Date,'dd/MM/yyyy'),'NA') as Open_Date,'-' as Period, to_char(nvl(Interest_Rate,0) || ' %') as Interest_Rate ,Closing_Balance as Amount, Closing_Balance,'NA' as Int_Payment_Freq,'-' as Due_Date,'-' as Maturity_Amount,nvl(Nominee_Name,'NA'),'-' as effect_date,'NA' as TDS,nvl(NOMINEE_RELATIONSHIP,'NA') ,nvl(nominee_age,'NA') as nge,'SD' AS type,ACCOUNT_STATUS from SBCA_MASTER_VIEW_C2 left join Scheme_Master on SBCA_MASTER_VIEW_C2.Scheme_Code=Scheme_Master.Scheme_Code where Account_No like '"+Acc+"'";
			
		}
       else if(Account_Type.equalsIgnoreCase("JL"))
        {
        	countQuery2="Select Account_No , Scheme_Name,Scheme_Category,Customer_Id,Customer_Name, '-' as Customer_Name_2,'-' as Customer_Name_3,MODE_OF_OPERATION,  to_Char(Open_Date,'dd/MM/yyyy') as Open_Date,to_char(Period_Months|| ' months' ) as pd, to_char(Interest_Rate || ' %') as Interest_Rate ,Loan_Amount as Amount, Closing_Balance,'-' as Int_Payment_Freq,to_char(due_date,'dd/MM/yyyy') as Due_Date,'-' as Maturity_Amount,'NA' AS Nominee_Name,'-' as effect_date,'-' as TDS,'NA' AS NOMINEE_RELATIONSHIP ,'NA' as nge,'JL' AS type ,ACCOUNT_STATUS from JL_MASTER_VIEW left join Scheme_Master on JL_MASTER_VIEW.Scheme_Code=Scheme_Master.Scheme_Code where Account_No like '"+Acc+"'";

        }
        else if(Account_Type.equalsIgnoreCase("DL"))
        {
		countQuery2="Select Account_No , Scheme_Name,Scheme_Category,Customer_Id,Customer_Name,Customer_Name_2,'-' as Customer_Name_3,'-' as MODE_OF_OPERATION,  to_Char(Open_Date,'dd/MM/yyyy') as Open_Date,to_char( Period_days|| ' days ' ) as pd, to_char(Interest_Rate || ' %') as Interest_Rate ,Loan_Amount as Amount, Closing_Balance,'-' as Int_Payment_Freq,to_char(due_date,'dd/MM/yyyy') as Due_Date,'-' as Maturity_Amount, nvl(Nominee_Name,'NA'),'-' as effect_date,'-' as TDS, nvl(NOMINEE_RELATIONSHIP,'NA') as nnm ,nvl(NOMINEE_Age,'NA') as nge,'DL' AS type,ACCOUNT_STATUS from OL_MASTER_VIEW3 left join Scheme_Master on OL_MASTER_VIEW3.Scheme_Code=Scheme_Master.Scheme_Code where Account_No ='"+Acc+"' and OL_MASTER_VIEW3.Scheme_Code!='80001'";

        }
        else if(Account_Type.equalsIgnoreCase("ML")|| Account_Type.equalsIgnoreCase("PL"))
        {
        	countQuery2="Select Account_No , Scheme_Name,Scheme_Category,Customer_Id,Customer_Name,  Customer_Name_2,'-' as Customer_Name_3,'-' as MODE_OF_OPERATION,  to_Char(Open_Date,'dd/MM/yyyy') as Open_Date,case when (period_months is null or period_months=0) then to_char( Period_days|| ' days ' ) else case when (period_days is null or period_days=0) then to_char( Period_months|| ' months ' ) else to_char( Period_months|| ' months /'||Period_days|| ' days' ) end end  as pd, to_char(Interest_Rate || ' %') as Interest_Rate ,Loan_Amount as Amount, Closing_Balance,'-' as Int_Payment_Freq,TO_CHAR(due_date,'dd/MM/yyyy') as Due_Date,'-' as Maturity_Amount, nvl(Nominee_Name,'NA'),'-' as effect_date,'-' as TDS,nvl(NOMINEE_RELATIONSHIP,'NA') as nnm ,nvl(NOMINEE_Age,'NA') as nge,'ML' AS type,ACCOUNT_STATUS from OL_MASTER_VIEW3 left join Scheme_Master on OL_MASTER_VIEW3.Scheme_Code=Scheme_Master.Scheme_Code where Account_No ='"+Acc+"' and OL_MASTER_VIEW3.Scheme_Code='80001'";

        }
        else if(Account_Type.equalsIgnoreCase("CC")|| Account_Type.equalsIgnoreCase("SL"))
        {
        	countQuery2="Select Account_No , Scheme_Name,Scheme_Category,Customer_Id,Customer_Name, '-' as Customer_Name_2,'-' as Customer_Name_3,'-' as MODE_OF_OPERATION,  to_Char(Open_Date,'dd/MM/yyyy') as Open_Date, to_char( Period_months|| ' months ' )  as pd, to_char(Interest_Rate || ' %') as Interest_Rate ,Closing_Balance as Amount, Closing_Balance,'-' as Int_Payment_Freq,due_date as Due_Date,'-' as Maturity_Amount, nvl(Nominee_Name,'NA'),'-' as effect_date,'-' as TDS, nvl(NOMINEE_RELATIONSHIP,'NA') ,nvl(NOMINEE_Age,'NA') as nge,'SL' AS type,ACCOUNT_STATUS from CC_MASTER_VIEW_3 left join Scheme_Master on CC_MASTER_VIEW_3.Scheme_Code=Scheme_Master.Scheme_Code where Account_No like '"+Acc+"'" ;

        }
        else if(Account_Type.equalsIgnoreCase("RL"))
        {
        	countQuery2="Select Account_No , Scheme_Name,Scheme_Category,Customer_Id,Customer_Name, '-' as Customer_Name_2,'-' as Customer_Name_3,'-' as MODE_OF_OPERATION,  to_Char(Open_Date,'dd/MM/yyyy') as Open_Date, to_char( Period_days|| ' days ' )  as pd, to_char(Interest_Rate || ' %') as Interest_Rate ,Closing_Balance as Amount, Closing_Balance,'-' as Int_Payment_Freq,due_date as Due_Date,'-' as Maturity_Amount, nvl(Nominee_Name,'NA'),'-' as effect_date,'-' as TDS, nvl(NOMINEE_RELATIONSHIP,'NA') ,nvl(NOMINEE_Age,'NA') as nge,'RL' AS type,ACCOUNT_STATUS from RLL_MASTER_VIEW_C left join Scheme_Master on RLL_MASTER_VIEW_C.Scheme_Code=Scheme_Master.Scheme_Code where Account_No like '"+Acc+"'" ;

        }

      //Log------------------------------------
		PreparedStatement p=null;
		
		  String logQuery="insert into APP_OPERATION_LOG(mon,type,no) values('"+mon+"','Account_Details','"+no+"')";
		  p =conn1.prepareStatement(logQuery);
		  try{
			p.execute();
		  }catch(SQLException e){
		        out.print("Exception: "+e);
		    }
//-----------------------------------------------		



//out.println(countQuery2);
		try{
			
		rs = statement.executeQuery(countQuery2);
		
		JSONArray array=new JSONArray();
		while (rs.next()) 
		{
			    JSONObject obj = new JSONObject();
                obj.put("acn",rs.getString(1));
                obj.put("snm",rs.getString(2));
                /*obj.put("cat",rs.getString(3));
                obj.put("cus1",rs.getString(4));
                obj.put("cnm1",rs.getString(5));
                obj.put("cnm2",rs.getString(6));
                obj.put("cnm3",rs.getString(7));
                obj.put("mop",rs.getString(8));*/
                obj.put("amt",rs.getString(12));
                obj.put("pd",rs.getString(10));
                if(Account_Type.equalsIgnoreCase("SD"))
        		{
                obj.put("roi",ROI);
        		}
                else
                	 obj.put("roi",rs.getString(11));

 	 if(Account_Type.equalsIgnoreCase("RD"))
		obj.put("penIns",PenIns);
	 else
		 obj.put("penIns","NA");
                
                obj.put("tds",rs.getString(19));
                obj.put("odt",rs.getString(9));
                obj.put("ddt",rs.getString(15));
                obj.put("mamt",rs.getString(16));
                /*obj.put("cb",rs.getString(13));
                obj.put("ipfreg",rs.getString(14));
                obj.put("edt",rs.getString(18));*/
               
                obj.put("nnm",rs.getString(17));
                
               
                obj.put("nrp",rs.getString(20));
                obj.put("nge",rs.getString(21));
 obj.put("tpe",rs.getString(22));
 //obj.put("status",rs.getString(23));

 if(rs.getString(23).equalsIgnoreCase("A"))
 obj.put("status","Active");
 else
	 obj.put("status","Inactive");
 
 String mop=rs.getString(8);
 if(!mop.equalsIgnoreCase("-"))
 {
	 if(mop.equalsIgnoreCase("A"))
	 {
		 mop="AorS";
	 }
	else if(mop.equalsIgnoreCase("E"))
	 {
		 mop="EorS";
	 }
	else if(mop.equalsIgnoreCase("F"))
	 {
		 mop="ForS";
	 }
	else if(mop.equalsIgnoreCase("J"))
	 {
		 mop="Joint";
	 }
	else if(mop.equalsIgnoreCase("S"))
	 {
		 mop="Individual";
	 }

	 else
		 mop="Individual";
 }
 obj.put("mop",mop);

//LienNo
       obj.put("lino",LienNo);
       if(Account_Type.equalsIgnoreCase("DL"))
    	   obj.put("lino",LienNo);
   	 else
   		obj.put("lino","NA");
  
       
              
                array.add(obj);
		}
		
		

		
		
		
		conn1.close();
		
		out.println(array);
		
		
		}catch(SQLException e){
	        out.print("Exception: "+e);
	    }
		
		
		
	} catch (Exception e) {

	}

	output = Be;

	
	//response.addHeader("AustinAndroidReturn", output);


}
	//LasteFew with balance
	//LasteFew with balance
		else if (no == 568) {
			//out.println("Hello Ur Action Type is= <b>"
					//+ request.getParameter("type") + "</b>");

			String Be = "";
			String output = "";

			String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
			String mon = request.getParameter("mon");
			String CDate = request.getParameter("Dt");
			String Dt = CDate;//CDate.substring(4,2);
			//out.println("Date is= <b>" + Dt + "</b>");
			
			Connection conn1 = null;
			Statement statement = null;
			Statement statement2 = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			try {

				Class.forName(ODriver);
				conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
				//out.println("connected....!!");
				statement2 = conn1.createStatement();
				String cbqry="select  nvl(GET_CLOSING_BALANCE_VIEW_FUNC('"+devId+"'),'NA^0') as CB from dual";
//out.println(cbqry);

				String msg="";
				double CB=0;
				rs2 = statement2.executeQuery(cbqry);
				while (rs2.next()) 
				{


					msg=rs2.getString(1);


				}
				DecimalFormat df = new DecimalFormat("0.00");
				String Account_Type=msg.substring(0,2);
				CB=Double.parseDouble(msg.substring(3));
				//out.println(msg+",CB="+CB+",type="+Account_Type);
			if(!Account_Type.equalsIgnoreCase("NA"))
			{
				if(Account_Type.equalsIgnoreCase("SD") || Account_Type.equalsIgnoreCase("RD") || Account_Type.equalsIgnoreCase("FD") || Account_Type.equalsIgnoreCase("JL")|| Account_Type.equalsIgnoreCase("RL")|| Account_Type.equalsIgnoreCase("PL")||Account_Type.equalsIgnoreCase("CL") || Account_Type.equalsIgnoreCase("DL") || Account_Type.equalsIgnoreCase("CC"))
				{
					//String QueryString="select main_qry.* from (Select to_char(Transaction_Id) as Transaction_Id,to_char(Part_Tran_Id) as Part_Tran_Id,to_char(Transaction_Date,'dd/MM/yyyy') as Tran_Date,substr(Transaction_Particulars,1,10) as Transaction_Particulars,Transaction_Amount as Tran_Amount,transaction_type,to_char(Transaction_Amount ||' '||case when Transaction_Type='Credit' then 'Cr' else 'Dr' End) as FTran_Amount,flag from DAILY_TRANSACTION_ACTIVE_TABLE where Account_no='"+devId+"'  order by Transaction_Date desc,to_number(substr(to_char(Transaction_Id),-5,5)) desc,Part_Tran_Id desc)main_qry where rownum<=10";
					
					//20-01-2024 transaction particular full
					String QueryString="select main_qry.* from (Select to_char(Transaction_Id) as Transaction_Id,to_char(Part_Tran_Id) as Part_Tran_Id,to_char(Transaction_Date,'dd/MM/yyyy') as Tran_Date, Transaction_Particulars,Transaction_Amount as Tran_Amount,transaction_type,to_char(Transaction_Amount ||' '||case when Transaction_Type='Credit' then 'Cr' else 'Dr' End) as FTran_Amount,flag from DAILY_TRANSACTION_ACTIVE_TABLE where Account_no='"+devId+"'  order by Transaction_Date desc,to_number(substr(to_char(Transaction_Id),-5,5)) desc,Part_Tran_Id desc)main_qry where rownum<=10";
					
//out.println(QueryString);

				try{
				statement = conn1.createStatement();
	//Log------------------------------------
		PreparedStatement p=null;
		
		  String logQuery="insert into APP_OPERATION_LOG(did,mon,type,no) values('"+devId+"','"+devId+"','LastFewTransaction','"+no+"')";
		  p =conn1.prepareStatement(logQuery);
		  try{
			p.execute();
		  }catch(SQLException e){
		        out.print("Exception: "+e);
		    }
//-----------------------------------------------		



			
	


	         		rs = statement.executeQuery(QueryString);
				
				JSONArray array=new JSONArray();
				double cb=CB;
				if(Account_Type.equalsIgnoreCase("SD"))
				{
				while (rs.next()) 
				{
					JSONObject obj = new JSONObject();
					
					obj.put("Balance",df.format(cb));
				     if(rs.getString(6).equalsIgnoreCase("Credit"))
				     {
				    	 double temp=rs.getDouble(5);
				    	  cb=cb-temp;
				     }
				     else if(rs.getString(6).equalsIgnoreCase("Debit"))
				     {
				    	 double temp=rs.getDouble(5);
				    	  	 cb=cb+temp;
				     }
				  	     obj.put("Transaction_Id",rs.getString(1));
				       obj.put("Part_Tran_Id",rs.getString(2));
				       obj.put("Tran_Date",rs.getString(3));
				     obj.put("Transaction_Particulars",rs.getString(4));
				     obj.put("Tran_Amount",rs.getString(7));
				               
				                
				 					               
		              
		                array.add(obj);
				}
				}
				else if(Account_Type.equalsIgnoreCase("FD") || Account_Type.equalsIgnoreCase("RD"))
				{
					
					cb=CB;
				while (rs.next()) 
				{
					JSONObject obj = new JSONObject();
					
					
					obj.put("Balance",df.format(cb));
					 double temp=rs.getDouble(5);
					
				     if(rs.getString(6).equalsIgnoreCase("Credit"))
				      cb=cb - temp;
				      else if(rs.getString(6).equalsIgnoreCase("Debit"))
				      cb=cb+temp;
					
				  	     obj.put("Transaction_Id",rs.getString(1));
				       obj.put("Part_Tran_Id",rs.getString(2));
				       obj.put("Tran_Date",rs.getString(3));
				     obj.put("Transaction_Particulars",rs.getString(4));
				     obj.put("Tran_Amount",rs.getString(7));
				               
				                
				 					               
		              
		                array.add(obj);
				}
				}
				else if( Account_Type.equalsIgnoreCase("RL"))
				{
					
					cb=Math.abs(CB);
				while (rs.next()) 
				{
					JSONObject obj = new JSONObject();
					
					
					obj.put("Balance",df.format(cb));
					 double temp=rs.getDouble(5);
					 if(rs.getString(8).equalsIgnoreCase("AC"))
					 {
				     if(rs.getString(6).equalsIgnoreCase("Credit"))
				      cb=cb - temp;
				      else if(rs.getString(6).equalsIgnoreCase("Debit"))
				      cb=cb+temp;
					 }
				  	     obj.put("Transaction_Id",rs.getString(1));
				       obj.put("Part_Tran_Id",rs.getString(2));
				       obj.put("Tran_Date",rs.getString(3));
				     obj.put("Transaction_Particulars",rs.getString(4));
				     obj.put("Tran_Amount",rs.getString(7));
				               
				                
				 					               
		              
		                array.add(obj);
				}
				}
				else if(Account_Type.equalsIgnoreCase("JL") || Account_Type.equalsIgnoreCase("PL")||Account_Type.equalsIgnoreCase("CL") || Account_Type.equalsIgnoreCase("DL") || Account_Type.equalsIgnoreCase("CC"))
				{
					
					cb=Math.abs(CB);
				while (rs.next()) 
				{
					JSONObject obj = new JSONObject();
					
					
					obj.put("Balance",df.format(cb));
					 double temp=rs.getDouble(5);
					  if(rs.getString(6).equalsIgnoreCase("Credit"))
				      cb=cb + temp;
				      else if(rs.getString(6).equalsIgnoreCase("Debit"))
				      cb=cb-temp;
					 
				  	     obj.put("Transaction_Id",rs.getString(1));
				       obj.put("Part_Tran_Id",rs.getString(2));
				       obj.put("Tran_Date",rs.getString(3));
				     obj.put("Transaction_Particulars",rs.getString(4));
				     obj.put("Tran_Amount",rs.getString(7));
				               
				                
				 					               
		              
		                array.add(obj);
				}
				}
				
				//Collections.reverse(array);

				
				
				
				conn1.close();
				
				out.println(array);
				
				
				}catch(SQLException e){
			        out.print("Exception: "+e);
			    }
			}//Deposit
			}//NA	
				
			} catch (Exception e) {

			}

			output = Be;

			
			//response.addHeader("AustinAndroidReturn", output);

		}
//Account Statement with Balance
		else if (no == 569) 
		{
			//out.println("Hello Ur Action Type is= <b>"
					//+ request.getParameter("type") + "</b>");

			String Be = "";
			String output = "";

			String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
			String mon = request.getParameter("mon");
			String CDate = request.getParameter("Dt");
			String Dt = CDate;//CDate.substring(4,2);
			String val1 = request.getParameter("val1");
			String val2 = request.getParameter("val2");
			//out.println("Date is= <b>" + Dt + "</b>");
			
			String Branch=devId.substring(0, 3);
			
			Connection conn1 = null;
			Statement statement = null;
			Statement statement2 = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			try {

				Class.forName(ODriver);
				conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
				
				statement2 = conn1.createStatement();
				String cbqry="select  nvl(GET_CLOSING_BALANCE_VIEW_DATEFUNC('"+devId+"',to_char(to_date('"+val2+"','MM/dd/yyyy'),'dd/MM/yyyy')),'NA^0') as CB from dual";
				String msg="";
				double CB=0;
				rs2 = statement2.executeQuery(cbqry);
				while (rs2.next()) 
				{
					msg=rs2.getString(1);
				}
				DecimalFormat df = new DecimalFormat("0.00");
				String Account_Type=msg.substring(0,2);
				CB=Double.parseDouble(msg.substring(3));
				//out.println("connected....!!");
				statement = conn1.createStatement();
				//String QueryString="SELECT  a.Transaction_Id,a.Part_Tran_Id,a.Tran_Date,a.Transaction_Particulars as Transaction_Particulars,a.Tran_Amount FROM (Select to_char(Transaction_Date,'dd/MM/yyyy') as Tran_Date, to_char(Transaction_Id) as Transaction_Id,to_char(Part_Tran_Id) as Part_Tran_Id,Transaction_Date,substr(Transaction_Particulars,1,10) as Transaction_Particulars,to_char(Transaction_Amount ||' '||case when Transaction_Type='Credit' then 'Cr' else 'Dr' End) as Tran_Amount from DAILY_TRANSACTION_ACTIVE_TABLE where Account_no='"+devId+"' and to_char(branch)='"+mon+"' and Transaction_Date between to_date('"+val1+"','dd/MM/yyyy') and to_date('"+val2+"','dd/MM/yyyy'))a order by a.Transaction_Date desc,to_number(substr(to_char(a.Transaction_Id),-5,5)) desc";
		//MM/dd/yyyy		
		//String QueryString="SELECT  a.Transaction_Id,a.Part_Tran_Id,a.Tran_Date,a.Transaction_Particulars as Transaction_Particulars,a.Tran_Amount FROM (Select to_char(Transaction_Date,'dd/MM/yyyy') as Tran_Date, to_char(Transaction_Id) as Transaction_Id,to_char(Part_Tran_Id) as Part_Tran_Id,Transaction_Date,substr(Transaction_Particulars,1,10) as Transaction_Particulars,to_char(Transaction_Amount ||' '||case when Transaction_Type='Credit' then 'Cr' else 'Dr' End) as Tran_Amount from DAILY_TRANSACTION_ACTIVE_TABLE where Account_no='"+devId+"'  and Transaction_Date between to_date('"+val1+"','MM/dd/yyyy') and to_date('"+val2+"','MM/dd/yyyy'))a order by a.Transaction_Date desc,to_number(substr(to_char(a.Transaction_Id),-5,5)) desc";
		
//transaction_type,to_char(Transaction_Amount ||' '||case when Transaction_Type='Credit' then 'Cr' else 'Dr' End) as FTran_Amount,flag
//String QueryString="SELECT  a.Transaction_Id,a.Part_Tran_Id,a.Tran_Date,a.Transaction_Particulars as Transaction_Particulars,a.Tran_Amount,a.transaction_type,a.FTran_Amount,a.flag FROM (Select to_char(Transaction_Date,'dd/MM/yyyy') as Tran_Date, to_char(Transaction_Id) as Transaction_Id,to_char(Part_Tran_Id) as Part_Tran_Id,Transaction_Date,substr(Transaction_Particulars,1,10) as Transaction_Particulars,transaction_type,Transaction_Amount as Tran_Amount, to_char(Transaction_Amount ||' '||case when Transaction_Type='Credit' then 'Cr' else 'Dr' End) as FTran_Amount,flag from DAILY_TRANSACTION_ACTIVE_TABLE where Account_no='"+devId+"'  and Transaction_Date between to_date('"+val1+"','MM/dd/yyyy') and to_date('"+val2+"','MM/dd/yyyy'))a order by a.Transaction_Date desc,to_number(substr(to_char(a.Transaction_Id),-5,5)) desc,a.Part_Tran_Id desc";
			
//20-01-2024 transaction particular full
String QueryString="SELECT  a.Transaction_Id,a.Part_Tran_Id,a.Tran_Date,a.Transaction_Particulars as Transaction_Particulars,a.Tran_Amount,a.transaction_type,a.FTran_Amount,a.flag FROM (Select to_char(Transaction_Date,'dd/MM/yyyy') as Tran_Date, to_char(Transaction_Id) as Transaction_Id,to_char(Part_Tran_Id) as Part_Tran_Id,Transaction_Date, Transaction_Particulars,transaction_type,Transaction_Amount as Tran_Amount, to_char(Transaction_Amount ||' '||case when Transaction_Type='Credit' then 'Cr' else 'Dr' End) as FTran_Amount,flag from DAILY_TRANSACTION_ACTIVE_TABLE where Account_no='"+devId+"'  and Transaction_Date between to_date('"+val1+"','MM/dd/yyyy') and to_date('"+val2+"','MM/dd/yyyy') and branch='"+Branch+"')a order by a.Transaction_Date desc,to_number(substr(to_char(a.Transaction_Id),-5,5)) desc,a.Part_Tran_Id desc";
	
//out.println(QueryString);

	//Log------------------------------------
		PreparedStatement p=null;
		
		  String logQuery="insert into APP_OPERATION_LOG(did,mon,type,no,val1,val2) values('"+devId+"','"+devId+"','Account_Statement','"+no+"','"+val1+"','"+val2+"')";
		  p =conn1.prepareStatement(logQuery);
		  try{
			p.execute();
		  }catch(SQLException e){
		        out.print("Exception: "+e);
		    }
//-----------------------------------------------		



			
				if(!Account_Type.equalsIgnoreCase("NA"))
				{
					


					try{
					statement = conn1.createStatement();
		         		rs = statement.executeQuery(QueryString);
					
					JSONArray array=new JSONArray();
					double cb=CB;
					if(Account_Type.equalsIgnoreCase("SD"))
					{
					while (rs.next()) 
					{
						JSONObject obj = new JSONObject();
						
						obj.put("Balance",df.format(cb));
					     if(rs.getString(6).equalsIgnoreCase("Credit"))
					     {
					    	 double temp=rs.getDouble(5);
					    	  cb=cb-temp;
					     }
					     else if(rs.getString(6).equalsIgnoreCase("Debit"))
					     {
					    	 double temp=rs.getDouble(5);
					    	  	 cb=cb+temp;
					     }
					  	     obj.put("Transaction_Id",rs.getString(1));
					       obj.put("Part_Tran_Id",rs.getString(2));
					       obj.put("Tran_Date",rs.getString(3));
					     obj.put("Transaction_Particulars",rs.getString(4));
					     obj.put("Tran_Amount",rs.getString(7));
					               
					                
					 					               
			              
			                array.add(obj);
					}
					}
					else if(Account_Type.equalsIgnoreCase("FD") || Account_Type.equalsIgnoreCase("RD"))
					{
						
						cb=CB;
					while (rs.next()) 
					{
						JSONObject obj = new JSONObject();
						
						
						obj.put("Balance",df.format(cb));
						 double temp=rs.getDouble(5);
						
					     if(rs.getString(6).equalsIgnoreCase("Credit"))
					      cb=cb - temp;
					      else if(rs.getString(6).equalsIgnoreCase("Debit"))
					      cb=cb+temp;
						
					  	     obj.put("Transaction_Id",rs.getString(1));
					       obj.put("Part_Tran_Id",rs.getString(2));
					       obj.put("Tran_Date",rs.getString(3));
					     obj.put("Transaction_Particulars",rs.getString(4));
					     obj.put("Tran_Amount",rs.getString(7));
					               
					                
					 					               
			              
			                array.add(obj);
					}
					}
					else if( Account_Type.equalsIgnoreCase("RL"))
					{
						
						cb=Math.abs(CB);
					while (rs.next()) 
					{
						JSONObject obj = new JSONObject();
						
						
						obj.put("Balance",df.format(cb));
						 double temp=rs.getDouble(5);
						 if(rs.getString(8).equalsIgnoreCase("AC"))
						 {
					     if(rs.getString(6).equalsIgnoreCase("Credit"))
					      cb=cb - temp;
					      else if(rs.getString(6).equalsIgnoreCase("Debit"))
					      cb=cb+temp;
						 }
					  	     obj.put("Transaction_Id",rs.getString(1));
					       obj.put("Part_Tran_Id",rs.getString(2));
					       obj.put("Tran_Date",rs.getString(3));
					     obj.put("Transaction_Particulars",rs.getString(4));
					     obj.put("Tran_Amount",rs.getString(7));
					               
					                
					 					               
			              
			                array.add(obj);
					}
					}
					else if(Account_Type.equalsIgnoreCase("JL") || Account_Type.equalsIgnoreCase("PL")||Account_Type.equalsIgnoreCase("CL") || Account_Type.equalsIgnoreCase("DL") || Account_Type.equalsIgnoreCase("CC"))
					{
						
						cb=Math.abs(CB);
					while (rs.next()) 
					{
						JSONObject obj = new JSONObject();
						
						
						obj.put("Balance",df.format(cb));
						 double temp=rs.getDouble(5);
						  if(rs.getString(6).equalsIgnoreCase("Credit"))
					      cb=cb + temp;
					      else if(rs.getString(6).equalsIgnoreCase("Debit"))
					      cb=cb-temp;
						 
					  	     obj.put("Transaction_Id",rs.getString(1));
					       obj.put("Part_Tran_Id",rs.getString(2));
					       obj.put("Tran_Date",rs.getString(3));
					     obj.put("Transaction_Particulars",rs.getString(4));
					     obj.put("Tran_Amount",rs.getString(7));
					               
					                
					 					               
			              
			                array.add(obj);
					}
					}
					
					//Collections.reverse(array);

				
				
				
				conn1.close();
				
				out.println(array);
				
				
				}catch(SQLException e){
			        out.print("Exception: "+e);
			    }
				
				}
				
				

			output = Be;
			}catch(SQLException e){
		        out.print("Exception: "+e);
		    }
			
			//response.addHeader("AustinAndroidReturn", output);

		}

//Interest Certificate List
		else if (no == 570) 
		{
			//out.println("Hello Ur Action Type is= <b>"
					//+ request.getParameter("type") + "</b>");

			String Be = "";
			String output = "";

			String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
			String Customer_Id = request.getParameter("mon");
			String CDate = request.getParameter("Dt");
			String Dt = CDate;//CDate.substring(4,2);
			String From_Date = request.getParameter("val1");
			String To_Date = request.getParameter("val2");
			//out.println("Date is= <b>" + Dt + "</b>");
			
			Connection conn1 = null;
			Statement statement = null;
			Statement statement2 = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			try {

				Class.forName(ODriver);
				conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
				//statement = conn1.createStatement();
			//String QueryString="select qry.* from (select main_qry.* from (select a.Account_no,b.branch_name,case when a.interest_payment_mode='Reinvest' then 'CD'else 'FD' end as product_Type,a.Deposit_Amount,Interest_Paid.Int_Paid, case when Interest_Paid_31032021.Int_Paid_31032021 is null then 0 else Interest_Paid_31032021.Int_Paid_31032021 end  as interest_on_31_04_2021,  case when Interest_Paid_31032021.Int_Paid_31032021 is null then 0 else Interest_Paid_31032021.Int_Paid_31032021 end+Interest_Paid.Int_Paid as Total_Interest, tds_paid.tds,'"+To_Date+"' as Interest_On from ( select Branch,Account_No,Customer_id,Customer_Name,Deposit_Amount,INTEREST_PROJECTION,interest_payment_mode,Account_Status,case when closed_date !=null  then case when closed_date<=to_date('"+To_Date+"','dd/MM/yyyy') then 'Y' else 'N' end else 'N' end as Closed_Status from fd_master_View where interest_payment_mode !='Reinvest' and Customer_id="+Customer_Id+" AND SCHEME_CODE IN (SELECT SCHEME_CODE FROM SCHEME_MASTER WHERE DEP !='9' AND SCHEME_CATEGORY='FD') order by customer_id)a left join  (Select branch_code,Branch_Name from branch_master)b on a.branch=b.branch_code left join (Select Account_no,sum(transaction_amount) as Int_Paid from DAILY_TRANSACTION_ACTIVE_TABLE where flag='INT' and transaction_Type='Credit' and transaction_date between to_date('"+From_Date+"','dd/MM/yyyy') and add_months (to_date('"+To_Date+"','dd/MM/yyyy'),-1)+2 group by account_no) Interest_Paid on a.account_no=Interest_Paid.Account_no left join (Select Account_no, sum(transaction_amount) as Int_Paid_31032021  from DAILY_TRANSACTION_ACTIVE_TABLE where flag='INT' and transaction_Type='Credit' and transaction_date between add_months(to_date('"+To_Date+"','dd/MM/yyyy'),-1)+1 and to_date('"+To_Date+"','dd/MM/yyyy')+2 group by account_no) Interest_Paid_31032021 on a.account_no=Interest_Paid_31032021.Account_no left join (Select Account_no,sum(transaction_amount) as tds from DAILY_TRANSACTION_ACTIVE_TABLE where flag='TDS' and transaction_Type='Debit' and transaction_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') group by Account_no) tds_paid on a.account_no=tds_paid.Account_no) main_qry  union  select main_qry.* from (select a.Account_no,b.branch_name,case when a.interest_payment_mode='Reinvest' then 'CD'else 'FD' end as product_Type,a.Deposit_Amount,case when a.Closed_status='Y' then Interest_Paid.Int_Paid else 0 end as Int_Paid,case when a.Closed_status='Y' then Interest_Paid_31032021.Int_Paid_31032021 else 0 end  as interest_on_31_04_2021,case when nvl(Interest_Paid_31032021.Int_Paid_31032021,0)=0 then FD_int.fd_int else case when a.Closed_status='Y' then  nvl(Interest_Paid_31032021.Int_Paid_31032021,0)+nvl(Interest_Paid.Int_Paid,0) else 0 end end as Total_Interest,tds_paid.tds,'"+To_Date+"' as Interest_On from ( select Branch,Account_No,Customer_id,Customer_Name,Deposit_Amount,INTEREST_PROJECTION,interest_payment_mode,Account_Status,case when closed_date !=null  then case when closed_date<=to_date('"+To_Date+"','dd/MM/yyyy') then 'Y' else 'N' end else 'N' end as Closed_Status from fd_master_View where interest_payment_mode ='Reinvest' and Customer_id="+Customer_Id+" AND SCHEME_CODE IN (SELECT SCHEME_CODE FROM SCHEME_MASTER WHERE DEP !='9' AND SCHEME_CATEGORY='FD') order by customer_id)a left join  (Select branch_code,Branch_Name from branch_master)b on a.branch=b.branch_code left join (Select Account_no, sum(transaction_amount) as Int_Paid from DAILY_TRANSACTION_ACTIVE_TABLE where  flag='INT' and transaction_Type='Credit' and transaction_date between to_date('"+From_Date+"','dd/MM/yyyy') and add_months (to_date('"+To_Date+"','dd/MM/yyyy'),-1)+2 group by Account_no) Interest_Paid on a.account_no=Interest_Paid.Account_no left join (Select Account_no,sum(transaction_amount) as Int_Paid_31032021 from DAILY_TRANSACTION_ACTIVE_TABLE where flag='INT' and transaction_Type='Credit' and transaction_date between add_months(to_date('"+To_Date+"','dd/MM/yyyy'),-1)+1 and to_date('"+To_Date+"','dd/MM/yyyy')+2 group by account_no) Interest_Paid_31032021 on a.account_no=Interest_Paid_31032021.Account_no left join (Select Account_no,sum(transaction_amount) as tds from DAILY_TRANSACTION_ACTIVE_TABLE where flag='TDS' and transaction_Type='Debit' and transaction_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') group by Account_no) tds_paid on a.account_no=tds_paid.Account_no left join (select Account_no,sum(interest) as fd_int from fd_interest_view where  to_date between  to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') group by Account_no)FD_int on a.account_no=FD_int.Account_no) main_qry )qry where qry.Total_interest is not null order by qry.Account_No";

//----------------------------------------------------------	
//Update Compound Interest 08-04-2024
//String QueryString="select qry.* from (select main_qry.* from (select a.Account_no,b.branch_name,case when a.interest_payment_mode='Reinvest' then 'CD'else 'FD' end as product_Type,a.Deposit_Amount,Interest_Paid.Int_Paid, case when Interest_Paid_31032021.Int_Paid_31032021 is null then 0 else Interest_Paid_31032021.Int_Paid_31032021 end  as interest_on_31_04_2021,  nvl(Interest_Paid_31032021.Int_Paid_31032021,0)+nvl(Interest_Paid.Int_Paid,0) as Total_Interest, tds_paid.tds,'"+To_Date+"' as Interest_On from ( select Branch,Account_No,Customer_id,Customer_Name,Deposit_Amount,INTEREST_PROJECTION,interest_payment_mode,Account_Status,case when closed_date !=null  then case when closed_date<=to_date('"+To_Date+"','dd/MM/yyyy') then 'Y' else 'N' end else 'N' end as Closed_Status from fd_master_View where interest_payment_mode !='Reinvest' and Customer_id="+Customer_Id+" AND SCHEME_CODE IN (SELECT SCHEME_CODE FROM SCHEME_MASTER WHERE DEP !='9' AND SCHEME_CATEGORY='FD') order by customer_id)a left join  (Select branch_code,Branch_Name from branch_master)b on a.branch=b.branch_code left join (Select Account_no,sum(transaction_amount) as Int_Paid from DAILY_TRANSACTION_NOTGL_TABLE where flag='INT' and transaction_Type='Credit' and transaction_date between to_date('"+From_Date+"','dd/MM/yyyy') and add_months (to_date('"+To_Date+"','dd/MM/yyyy'),-1)+2 group by account_no) Interest_Paid on a.account_no=Interest_Paid.Account_no left join (Select Account_no, sum(transaction_amount) as Int_Paid_31032021  from DAILY_TRANSACTION_NOTGL_TABLE where flag='INT' and transaction_Type='Credit' and transaction_date between add_months(to_date('"+To_Date+"','dd/MM/yyyy'),-1)+1 and to_date('"+To_Date+"','dd/MM/yyyy')+2 group by account_no) Interest_Paid_31032021 on a.account_no=Interest_Paid_31032021.Account_no left join (Select Account_no,sum(transaction_amount) as tds from DAILY_TRANSACTION_NOTGL_TABLE where flag='TDS' and transaction_Type='Debit' and transaction_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') group by Account_no) tds_paid on a.account_no=tds_paid.Account_no) main_qry  union  select main_qry.* from (select a.Account_no,b.branch_name,case when a.interest_payment_mode='Reinvest' then 'CD'else 'FD' end as product_Type,a.Deposit_Amount,case when a.Closed_status='Y' then Interest_Paid.Int_Paid else Interest_Paid.Int_Paid end as Int_Paid,  nvl(Interest_Paid_31032021.Int_Paid_31032021,0)  as interest_on_31_04_2021,  nvl(Interest_Paid_31032021.Int_Paid_31032021,0)+nvl(Interest_Paid.Int_Paid,0) as Total_Interest,tds_paid.tds,'"+To_Date+"' as Interest_On from ( select Branch,Account_No,Customer_id,Customer_Name,Deposit_Amount,INTEREST_PROJECTION,interest_payment_mode,Account_Status,case when closed_date !=null  then case when closed_date<=to_date('"+To_Date+"','dd/MM/yyyy') then 'Y' else 'N' end else 'N' end as Closed_Status from fd_master_View where interest_payment_mode ='Reinvest' and Customer_id="+Customer_Id+" AND SCHEME_CODE IN (SELECT SCHEME_CODE FROM SCHEME_MASTER WHERE DEP !='9' AND SCHEME_CATEGORY='FD') order by customer_id)a left join  (Select branch_code,Branch_Name from branch_master)b on a.branch=b.branch_code left join (Select Account_no, sum(transaction_amount) as Int_Paid from DAILY_TRANSACTION_NOTGL_TABLE where  flag='INT' and transaction_Type='Credit' and transaction_date between to_date('"+From_Date+"','dd/MM/yyyy') and add_months (to_date('"+To_Date+"','dd/MM/yyyy'),-1)+2 group by Account_no) Interest_Paid on a.account_no=Interest_Paid.Account_no left join (Select Account_no,sum(transaction_amount) as Int_Paid_31032021 from DAILY_TRANSACTION_NOTGL_TABLE where flag='INT' and transaction_Type='Credit' and transaction_date between add_months(to_date('"+To_Date+"','dd/MM/yyyy'),-1)+1 and to_date('"+To_Date+"','dd/MM/yyyy')+2 group by account_no) Interest_Paid_31032021 on a.account_no=Interest_Paid_31032021.Account_no left join (Select Account_no,sum(transaction_amount) as tds from DAILY_TRANSACTION_NOTGL_TABLE where flag='TDS' and transaction_Type='Debit' and transaction_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') group by Account_no) tds_paid on a.account_no=tds_paid.Account_no left join (select Account_no,sum(interest) as fd_int from fd_interest_view where  to_date between  to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') group by Account_no)FD_int on a.account_no=FD_int.Account_no) main_qry )qry where  qry.Total_interest !=0 order by qry.Account_No";

//CD Last month int added to IntPaid 09-04-2024
// String QueryString=" select qry.* from ( select main_qry.* from (select a.Account_no,b.branch_name,case when a.interest_payment_mode='Reinvest' then 'CD'else 'FD' end as product_Type,a.Deposit_Amount,Interest_Paid.Int_Paid, case when Interest_Paid_31032021.Int_Paid_31032021 is null then 0 else Interest_Paid_31032021.Int_Paid_31032021 end  as interest_on_31_04_2021,  nvl(Interest_Paid_31032021.Int_Paid_31032021,0)+nvl(Interest_Paid.Int_Paid,0) as Total_Interest, tds_paid.tds,'"+To_Date+"' as Interest_On from ( select Branch,Account_No,Customer_id,Customer_Name,Deposit_Amount,INTEREST_PROJECTION,interest_payment_mode,Account_Status,case when closed_date !=null  then case when closed_date<=to_date('"+To_Date+"','dd/MM/yyyy') then 'Y' else 'N' end else 'N' end as Closed_Status from fd_master_View where interest_payment_mode !='Reinvest' and Customer_id="+Customer_Id+" AND SCHEME_CODE IN (SELECT SCHEME_CODE FROM SCHEME_MASTER WHERE DEP !='9' AND SCHEME_CATEGORY='FD') order by customer_id)a left join  (Select branch_code,Branch_Name from branch_master)b on a.branch=b.branch_code left join (Select Account_no,sum(transaction_amount) as Int_Paid from DAILY_TRANSACTION_NOTGL_TABLE where flag='INT' and transaction_Type='Credit' and transaction_date between to_date('"+From_Date+"','dd/MM/yyyy') and add_months (to_date('"+To_Date+"','dd/MM/yyyy'),-1)+2 group by account_no) Interest_Paid on a.account_no=Interest_Paid.Account_no left join (Select Account_no, sum(transaction_amount) as Int_Paid_31032021  from DAILY_TRANSACTION_NOTGL_TABLE where flag='INT' and transaction_Type='Credit' and transaction_date between add_months(to_date('"+To_Date+"','dd/MM/yyyy'),-1)+1 and to_date('"+To_Date+"','dd/MM/yyyy')+2 group by account_no) Interest_Paid_31032021 on a.account_no=Interest_Paid_31032021.Account_no left join (Select Account_no,sum(transaction_amount) as tds from DAILY_TRANSACTION_NOTGL_TABLE where flag='TDS' and transaction_Type='Debit' and transaction_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') group by Account_no) tds_paid on a.account_no=tds_paid.Account_no) main_qry   union   select main_qry.* from (select a.Account_no,b.branch_name,case when a.interest_payment_mode='Reinvest' then 'CD'else 'FD' end as product_Type,a.Deposit_Amount,Interest_Paid.Int_Paid + nvl(Interest_Paid_31032021.Int_Paid_31032021,0)  as Int_Paid, 0  as interest_on_31_04_2021,  nvl(Interest_Paid_31032021.Int_Paid_31032021,0)+nvl(Interest_Paid.Int_Paid,0) as Total_Interest,tds_paid.tds,'"+To_Date+"' as Interest_On from ( select Branch,Account_No,Customer_id,Customer_Name,Deposit_Amount,INTEREST_PROJECTION,interest_payment_mode,Account_Status,case when closed_date !=null  then case when closed_date<=to_date('"+To_Date+"','dd/MM/yyyy') then 'Y' else 'N' end else 'N' end as Closed_Status from fd_master_View where interest_payment_mode ='Reinvest' and Customer_id="+Customer_Id+" AND SCHEME_CODE IN (SELECT SCHEME_CODE FROM SCHEME_MASTER WHERE DEP !='9' AND SCHEME_CATEGORY='FD') order by customer_id)a left join  (Select branch_code,Branch_Name from branch_master)b on a.branch=b.branch_code left join (Select Account_no, sum(transaction_amount) as Int_Paid from DAILY_TRANSACTION_NOTGL_TABLE where  flag='INT' and transaction_Type='Credit' and transaction_date between to_date('"+From_Date+"','dd/MM/yyyy') and add_months (to_date('"+To_Date+"','dd/MM/yyyy'),-1)+2 group by Account_no) Interest_Paid on a.account_no=Interest_Paid.Account_no left join (Select Account_no,sum(transaction_amount) as Int_Paid_31032021 from DAILY_TRANSACTION_NOTGL_TABLE where flag='INT' and transaction_Type='Credit' and transaction_date between add_months(to_date('"+To_Date+"','dd/MM/yyyy'),-1)+1 and to_date('"+To_Date+"','dd/MM/yyyy')+2 group by account_no) Interest_Paid_31032021 on a.account_no=Interest_Paid_31032021.Account_no left join (Select Account_no,sum(transaction_amount) as tds from DAILY_TRANSACTION_NOTGL_TABLE where flag='TDS' and transaction_Type='Debit' and transaction_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') group by Account_no) tds_paid on a.account_no=tds_paid.Account_no left join (select Account_no,sum(interest) as fd_int from fd_interest_view where  to_date between  to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy') group by Account_no)FD_int on a.account_no=FD_int.Account_no) main_qry )qry where  qry.Total_interest !=0 order by qry.Account_No";
//----------------------------------------------------------
 
 //Cd Compound 13-04-2024
          // String QueryString=" select main_qry.* from ( select b.Account_No,b.bname,case when b.interest_payment_mode='Reinvest' then 'CD'else 'FD' end as product_Type,b.Deposit_Amount,b.Interest_Paid,case when b.Interest_paid_31032021 is null then 0 else b.Interest_paid_31032021 end  as interest_on_31_04_2021,case when b.Interest_paid_31032021 is null then 0 else b.Interest_paid_31032021 end+b.Interest_Paid as Total_Interest,b.tds_paid,'31/03/2024' as Interest_On from (select (Select Branch_Name from branch_master where branch_code=a.branch) as bname,a.*,(Select sum(transaction_amount) from daily_transaction_Table where Account_No=a.Account_No and flag='INT' and transaction_Type='Credit' and transaction_date between to_date('"+From_Date+"','dd/MM/yyyy') and add_months (to_date('"+To_Date+"','dd/MM/yyyy'),-1)+2) as Interest_Paid,(Select sum(transaction_amount) from daily_transaction_Table where Account_No=a.Account_No and flag='INT' and transaction_Type='Credit' and transaction_date between add_months(to_date('"+To_Date+"','dd/MM/yyyy'),-1)+1 and to_date('"+To_Date+"','dd/MM/yyyy')+2) as Interest_Paid_31032021,(Select sum(transaction_amount) from daily_transaction_Table where Account_No=a.Account_No and flag='TDS' and transaction_Type='Debit' and transaction_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy')) as tds_paid from (select Branch,Account_No,Customer_id,Customer_Name,Deposit_Amount,INTEREST_PROJECTION,interest_payment_mode,Account_Status,case when closed_date !=null  then case when closed_date<=to_date('"+To_Date+"','dd/MM/yyyy') then 'Y' else 'N' end else 'N' end as Closed_Status from fd_master_View where  interest_payment_mode !='Reinvest' and Customer_id="+Customer_Id+" AND SCHEME_CODE IN (SELECT SCHEME_CODE FROM SCHEME_MASTER WHERE DEP !='9' AND SCHEME_CATEGORY='FD') order by customer_id)a)b  union  select b.Account_No,b.bname,case when b.interest_payment_mode='Reinvest' then 'CD'else 'FD' end as product_Type,b.Deposit_Amount,b.Interest_Paid,case when b.Interest_paid_31032021 is null then 0 else b.Interest_paid_31032021 end  as interest_on_31_04_2021,case when b.Interest_paid_31032021=0 then (select sum(interest) from fd_interest_view where Account_no=b.Account_no and to_date between  to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy')) else (case when b.Interest_paid_31032021 is null then 0 else b.Interest_paid_31032021 end+b.Interest_Paid) end as Total_Interest,b.tds_paid,'"+To_Date+"' as Interest_On from (select (Select Branch_Name from branch_master where branch_code=a.branch) as bname,a.*,case when a.Closed_status='Y' then (Select sum(transaction_amount) from daily_transaction_Table where Account_No=a.Account_No and flag='INT' and transaction_Type='Credit' and transaction_date between to_date('"+From_Date+"','dd/MM/yyyy') and add_months (to_date('"+To_Date+"','dd/MM/yyyy'),-1)+2) else (select sum(interest) from fd_interest_view where Account_no=a.Account_no and to_date between  to_date('"+From_Date+"','dd/MM/yyyy') and  add_months (to_date('"+To_Date+"','dd/MM/yyyy'),-1)+2) end as Interest_Paid,case when a.Closed_status='Y' then (Select sum(transaction_amount) from daily_transaction_Table where Account_No=a.Account_No and flag='INT' and transaction_Type='Credit' and transaction_date between add_months(to_date('"+To_Date+"','dd/MM/yyyy'),-1)+1 and to_date('"+To_Date+"','dd/MM/yyyy')+2) else (Select sum(transaction_amount) from daily_transaction_Table where Account_No=a.Account_No and flag='INT' and transaction_Type='Credit' and transaction_date between add_months(to_date('"+To_Date+"','dd/MM/yyyy'),-1)+1 and to_date('"+To_Date+"','dd/MM/yyyy')+2) end  as Interest_Paid_31032021,(Select sum(transaction_amount) from daily_transaction_Table where Account_No=a.Account_No and flag='TDS' and transaction_Type='Debit' and transaction_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy')) as tds_paid from (select Branch,Account_No,Customer_id,Customer_Name,Deposit_Amount,INTEREST_PROJECTION,interest_payment_mode,Account_Status,case when closed_date !=null  then case when closed_date<=to_date('"+To_Date+"','dd/MM/yyyy') then 'Y' else 'N' end else 'N' end as Closed_Status from fd_master_View where interest_payment_mode ='Reinvest' and Customer_id="+Customer_Id+" AND SCHEME_CODE IN (SELECT SCHEME_CODE FROM SCHEME_MASTER WHERE DEP !='9' AND SCHEME_CATEGORY='FD') order by customer_id)a)b)main_qry  where main_qry.Total_interest is not null order by main_qry.Account_No";

//New Logic 13-04-2024
           //String QueryString="select main_qry.* from (  select b.Account_No,b.bname,case when b.interest_payment_mode='Reinvest' then 'CD'else 'FD' end as product_Type,b.Deposit_Amount,b.Interest_Paid,0  as interest_on_31_04_2021,b.Interest_Paid as Total_Interest,b.tds_paid,'31/03/2024' as Interest_On from (select (Select Branch_Name from branch_master where branch_code=a.branch) as bname,a.*,  (select sum(interest) from fd_interest_view where Account_no=a.Account_no and to_date between  to_date('"+From_Date+"','dd/MM/yyyy') and  case when a.closed_date < to_date('"+To_Date+"','dd/MM/yyyy') then a.closed_date else to_date('"+To_Date+"','dd/MM/yyyy') end) as Interest_Paid, 0 as Interest_Paid_31032021, (Select sum(transaction_amount) from daily_transaction_Table where Account_No=a.Account_No and flag='TDS' and transaction_Type='Debit' and transaction_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy')) as tds_paid from  ( select Branch,Account_No,Customer_id,Customer_Name,Deposit_Amount,INTEREST_PROJECTION,interest_payment_mode,Account_Status,case when closed_date !=null  then case when closed_date<=to_date('"+To_Date+"','dd/MM/yyyy') then 'Y' else 'N' end else 'N' end as Closed_Status,nvl(closed_date,maturity_date) as closed_date,maturity_date from fd_master_View  where  Customer_id="+Customer_Id+" AND SCHEME_CODE IN (SELECT SCHEME_CODE FROM SCHEME_MASTER WHERE DEP !='9' AND SCHEME_CATEGORY='FD') order by customer_id)a)b  )main_qry  where main_qry.Total_interest is not null order by main_qry.Account_No";
          
  //New Login updated with OS 15-04-2024
           String QueryString="select newm.*,nvl(c.Credit,0)-nvl(d.Debit,0) as Interest_On from (select main_qry.* from (  select b.Account_No,b.bname,case when b.interest_payment_mode='Reinvest' then 'CD'else 'FD' end as product_Type,b.Deposit_Amount,b.Interest_Paid,0  as interest_on_31_04_2021,b.Interest_Paid as Total_Interest,b.tds_paid from (select (Select Branch_Name from branch_master where branch_code=a.branch) as bname,a.*,  (select sum(interest) from fd_interest_view where Account_no=a.Account_no and to_date between  to_date('"+From_Date+"','dd/MM/yyyy') and  case when a.closed_date < to_date('"+To_Date+"','dd/MM/yyyy') then a.closed_date else to_date('"+To_Date+"','dd/MM/yyyy') end) as Interest_Paid, 0 as Interest_Paid_31032021, (Select sum(transaction_amount) from daily_transaction_Table where Account_No=a.Account_No and flag='TDS' and transaction_Type='Debit' and transaction_date between to_date('"+From_Date+"','dd/MM/yyyy') and to_date('"+To_Date+"','dd/MM/yyyy')) as tds_paid from  ( select Branch,Account_No,Customer_id,Customer_Name,Deposit_Amount,INTEREST_PROJECTION,interest_payment_mode,Account_Status,case when closed_date !=null  then case when closed_date<=to_date('"+To_Date+"','dd/MM/yyyy') then 'Y' else 'N' end else 'N' end as Closed_Status,nvl(closed_date,maturity_date) as closed_date,maturity_date from fd_master_View  where  Customer_id="+Customer_Id+" AND SCHEME_CODE IN (SELECT SCHEME_CODE FROM SCHEME_MASTER WHERE DEP !='9' AND SCHEME_CATEGORY='FD') order by customer_id)a)b  )main_qry  where main_qry.Total_interest is not null order by main_qry.Account_No)newm left join (Select Account_No,nvl(sum(Transaction_Amount),0) as Credit from Daily_Transaction_NOTGL_TABLE 	where Transaction_Date<=to_date('"+To_Date+"','dd/MM/yyyy') and Transaction_Type='Credit'  group by Account_No) c 	on newm.Account_No=c.Account_No left join 	(Select Account_No, nvl(sum(Transaction_Amount),0) as Debit from Daily_Transaction_NOTGL_TABLE 	where Transaction_Date<=to_date('"+To_Date+"','dd/MM/yyyy') and Transaction_Type='Debit'  group by Account_No) d 	on newm.Account_No=d.Account_No" ;

//out.println(QueryString);

			//Log------------------------------------
		PreparedStatement p=null;
		
		  String logQuery="insert into APP_OPERATION_LOG(mon,type,no,cid) values('"+Customer_Id+"','InterestCertificate_AccDetails','"+no+"','"+Customer_Id+"')";
		  p =conn1.prepareStatement(logQuery);
		  try{
			p.execute();
		  }catch(SQLException e){
		        out.print("Exception: "+e);
		    }
//-----------------------------------------------		


				

					try{
					statement = conn1.createStatement();
		         		rs = statement.executeQuery(QueryString);
					
					JSONArray array=new JSONArray();
					
					while (rs.next()) 
					{
						JSONObject obj = new JSONObject();
						 	         obj.put("acn",rs.getString(1));
					       obj.put("bnm",rs.getString(2));
					       obj.put("ptype",rs.getString(3));
					     obj.put("damt",rs.getDouble(4));
					     obj.put("ipaid",rs.getDouble(5));
					     obj.put("i31_03",rs.getDouble(6));
					       obj.put("toti",rs.getDouble(7));
					       obj.put("tds",rs.getDouble(8));
					     obj.put("idte",rs.getString(9));
					                  
					                					 					               
			              
			                array.add(obj);
					}
					
					
					
					
					

				
				
				
				conn1.close();
				
				out.println(array);
				
				
				}catch(SQLException e){
			        out.print("Exception: "+e);
			    }
				
				
				
				

			output = Be;
			}catch(SQLException e){
		        out.print("Exception: "+e);
		    }
			
			//response.addHeader("AustinAndroidReturn", output);

		}
//Int Certificate Customer Details
else if (no == 571) 
		{
			//out.println("Hello Ur Action Type is= <b>"
					//+ request.getParameter("type") + "</b>");

			String Be = "";
			String output = "";

			String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
			String Customer_Id = request.getParameter("mon");
			String CDate = request.getParameter("Dt");
			String Dt = CDate;//CDate.substring(4,2);
			//out.println("Date is= <b>" + Dt + "</b>");
			 String cusid=Customer_Id.substring(1, 3);
			 String Branch="201";
//out.println("cusid="+cusid);

			 if (cusid.equalsIgnoreCase("00"))
	 	    	  {
	 	    		 Branch="201";
	 	    	  }
	 	    	  else
	 	    	  {
	 	    		  Branch="2"+cusid;
	 	    	  }
	 	    	  //out.println("Branch="+Branch);
	 	    	 int BCode=Integer.parseInt(Branch);
			Connection conn1 = null;
			Statement statement = null;
			Statement statement2 = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			try {

				Class.forName(ODriver);
				conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
				//statement = conn1.createStatement();
			String QueryString="select a.* from (select customer_name,Address,nvl(Mobile_No,'0'),nvl(Pan_No,'NA') from Customer_View where branch='"+BCode+"' and Customer_id="+Customer_Id+")a where rownum=1";
	
//out.println(QueryString);

//Log------------------------------------
		PreparedStatement p=null;
		
		  String logQuery="insert into APP_OPERATION_LOG(mon,type,no,cid) values('"+Customer_Id+"','InterestCertificate_CusDetails','"+no+"','"+Customer_Id+"')";
		  p =conn1.prepareStatement(logQuery);
		  try{
			p.execute();
		  }catch(SQLException e){
		        out.print("Exception: "+e);
		    }
//-----------------------------------------------		

				

					try{
					statement = conn1.createStatement();
		         		rs = statement.executeQuery(QueryString);
					
					JSONArray array=new JSONArray();
					
					while (rs.next()) 
					{
						JSONObject obj = new JSONObject();
						 	     obj.put("cid",Customer_Id);
					       obj.put("cnm",rs.getString(1));
					       obj.put("addss",rs.getString(2));
					     obj.put("pno",rs.getString(4));
					     obj.put("mno",rs.getString(3));
					          
					                
					 					               
			              
			                array.add(obj);
					}
					
					
					
					
					

				
				
				
				conn1.close();
				
				out.println(array);
				
				
				}catch(SQLException e){
			        out.print("Exception: "+e);
			    }
				
				
				
				

			output = Be;
			}catch(SQLException e){
		        out.print("Exception: "+e);
		    }
			
			//response.addHeader("AustinAndroidReturn", output);

		}


//Int Slab Dep short
		else if (no == 572) 
		{
			//out.println("Hello Ur Action Type is= <b>"
					//+ request.getParameter("type") + "</b>");

			String Be = "";
			String output = "";

			String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
			String Customer_Id = request.getParameter("mon");
			String CDate = request.getParameter("Dt");
			String Dt = CDate;//CDate.substring(4,2);
			
			Connection conn1 = null;
			Statement statement = null;
			Statement statement2 = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			try {

				Class.forName(ODriver);
				conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
				//statement = conn1.createStatement();
			String QueryString="select scheme_Name,Period,General,Senior,Super_Senior,Remarks from App_Interest_Slab where Type='Deposit' and flag='1' order by to_number(nvl(substr(nvl(General,'0'),1,length(nvl(General,'0'))-1),'0')) ";
	
//out.println(QueryString);

			//Log------------------------------------
		PreparedStatement p=null;
		
		  String logQuery="insert into APP_OPERATION_LOG(mon,type,no,cid) values('"+Customer_Id+"','Int_Slab_Dep short','"+no+"','"+Customer_Id+"')";
		  p =conn1.prepareStatement(logQuery);
		  try{
			p.execute();
		  }catch(SQLException e){
		        out.print("Exception: "+e);
		    }
//-----------------------------------------------		


			
				

					try{
					statement = conn1.createStatement();
		         		rs = statement.executeQuery(QueryString);
					
					JSONArray array=new JSONArray();
					
					while (rs.next()) 
					{
						JSONObject obj = new JSONObject();
						 	     obj.put("Scheme_Name",rs.getString(1));
					       obj.put("Period",rs.getString(2));
					       obj.put("General",rs.getString(3));
					     obj.put("Senior",rs.getString(4));
					    
					          
					                
					 					               
			              
			                array.add(obj);
					}
					
					
					
					
					

				
				
				
				conn1.close();
				
				out.println(array);
				
				
				}catch(SQLException e){
			        out.print("Exception: "+e);
			    }
				
				
				
				

			output = Be;
			}catch(SQLException e){
		        out.print("Exception: "+e);
		    }
			
			//response.addHeader("AustinAndroidReturn", output);

		}

		//Int Slab Loan short
				else if (no == 573) 
				{
					//out.println("Hello Ur Action Type is= <b>"
							//+ request.getParameter("type") + "</b>");

					String Be = "";
					String output = "";

					String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
					String Customer_Id = request.getParameter("mon");
					String CDate = request.getParameter("Dt");
					String Dt = CDate;//CDate.substring(4,2);
					
					Connection conn1 = null;
					Statement statement = null;
					Statement statement2 = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					try {

						Class.forName(ODriver);
						conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
						//statement = conn1.createStatement();
					//String QueryString="select scheme_Name,Period,General,Senior,Super_Senior,Remarks from App_Interest_Slab where Type='Loan'";
					String QueryString="select scheme_Name,Period,General,Senior,Super_Senior,Remarks from App_Interest_Slab where Type='Loan' and flag='1' order by to_number(nvl(substr(nvl(General,'0'),1,length(nvl(General,'0'))-1),'0'))";

			
		//out.println(QueryString);

						//Log------------------------------------
		PreparedStatement p=null;
		
		  String logQuery="insert into APP_OPERATION_LOG(mon,type,no,cid) values('"+Customer_Id+"','Int_Slab_Loan','"+no+"','"+Customer_Id+"')";
		  p =conn1.prepareStatement(logQuery);
		  try{
			p.execute();
		  }catch(SQLException e){
		        out.print("Exception: "+e);
		    }
//-----------------------------------------------		


						

							try{
							statement = conn1.createStatement();
				         		rs = statement.executeQuery(QueryString);
							
							JSONArray array=new JSONArray();
							
							while (rs.next()) 
							{
								JSONObject obj = new JSONObject();
								 	     obj.put("Scheme_Name",rs.getString(1));
							       obj.put("Period",rs.getString(2));
							       obj.put("General",rs.getString(3));
							     obj.put("Senior",rs.getString(4));
							    
							          
							                
							 					               
					              
					                array.add(obj);
							}
							
							
							
							
							

						
						
						
						conn1.close();
						
						out.println(array);
						
						
						}catch(SQLException e){
					        out.print("Exception: "+e);
					    }
						
						
						
						

					output = Be;
					}catch(SQLException e){
				        out.print("Exception: "+e);
				    }
					
					//response.addHeader("AustinAndroidReturn", output);

				}

//Acc Statement Summary Details
				else if (no == 574) 
				{
					//out.println("Hello Ur Action Type is= <b>"
							//+ request.getParameter("type") + "</b>");

					String Be = "";
					String output = "";

					String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
					String Acc = request.getParameter("mon");
					String CDate = request.getParameter("Dt");
					String Dt = CDate;//CDate.substring(4,2);
					
					Connection conn1 = null;
					Statement statement = null;
					Statement statement2 = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					String Account_Type="";
					try {

						Class.forName(ODriver);
						conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
						statement2 = conn1.createStatement();
					//String QueryString="select scheme_Name,Period,General,Senior,Super_Senior,Remarks from App_Interest_Slab where Type='Loan'";
					String countQuery="select Account_Type  from CUST_ACC_LINK_VIEW where Account_no='"+Acc+"'";
					rs2 = statement2.executeQuery(countQuery);
					while (rs2.next()) 
					{
						Account_Type=rs2.getString(1);
					}
//out.println(countQuery);

			String countQuery2="SBCA_Master";
					if(Account_Type.equalsIgnoreCase("FD"))
			        {
						 countQuery2="Select Account_No as acn,Scheme_Name as snm,Scheme_Category as cat,Customer_Id as cus1,Customer_Name as cnm1, Customer_Name_2 as cnm2,'' as cnm3,MODE_OF_OPERATION as mop,  to_Char(Open_Date,'dd/MM/yyyy') as odt,to_char(Period_Months|| ' -  months /' || PERIOD_DAYS|| ' - days' ) as pd, to_char(Interest_Rate || ' %') as roi ,Deposit_Amount as amt, Closing_Balance as cb,to_char(Interest_Repayment||' / '||Interest_Payment_Mode) as ipfreq ,to_Char(Maturity_Date,'dd/MM/yyyy') as ddt,Maturity_Amount as mamt,nvl(Nominee_Name,'NA') as nnm,to_char(value_Date,'dd/MM/yyyy') as edt,case when DEDUCT_TDS in ('Y','Yes','YES') then 'Yes' else 'No' end as tds,nvl(NOMINEE_RELATIONSHIP,'NA') as nnm ,nvl(NOMINEE_Age,'NA') as nge ,'FD' AS type from FD_Master_View  left join Scheme_Master on FD_Master_View.Scheme_Code=Scheme_Master.Scheme_Code where Account_No like '"+Acc+"'";
						
					}
			        else if(Account_Type.equalsIgnoreCase("RD"))
			        {
						 countQuery2="Select Account_No,Scheme_Name,Scheme_Category,Customer_Id,Customer_Name, Customer_Name_2,'' as Customer_Name_3,MODE_OF_OPERATION,  to_Char(Open_Date,'dd/MM/yyyy') as Open_Date,to_char(Period_Months|| ' -  months' ) as Period, to_char(Interest_Rate || ' %') as Interest_Rate ,Deposit_Amount as Amount, Closing_Balance,to_char(Interest_Repayment||' / '||Interest_Payment_Mode) as Int_Payment_Freq,to_Char(Maturity_Date,'dd/MM/yyyy') as Due_Date,Maturity_Amount,Nominee_Name,to_char(value_Date,'dd/MM/yyyy') as effect_date,case when DEDUCT_TDS in ('Y','Yes','YES') then 'Yes' else 'No' end as tds,Nominee_Relationship,nominee_age as nge,'RD' AS type   from RD_MasterView_C2 left join Scheme_Master on RD_MasterView_C2.Scheme_Code=Scheme_Master.Scheme_Code where Account_No like '"+Acc+"'";
						
					}
			        else if(Account_Type.equalsIgnoreCase("SD"))
			        {
						 countQuery2="Select Account_No , Scheme_Name,Scheme_Category,Customer_Id,Customer_Name, Customer_Name_2,'' as Customer_Name_3,MODE_OF_OPERATION, nvl( to_Char(Open_Date,'dd/MM/yyyy'),'NA') as Open_Date,'-' as Period, to_char(Interest_Rate || ' %') as Interest_Rate ,Closing_Balance as Amount, Closing_Balance,'NA' as Int_Payment_Freq,'-' as Due_Date,'-' as Maturity_Amount,nvl(Nominee_Name,'NA'),'-' as effect_date,'NA' as TDS,nvl(NOMINEE_RELATIONSHIP,'NA') ,nvl(nominee_age,'NA') as nge,'SD' AS type from SBCA_MASTER_VIEW_C2 left join Scheme_Master on SBCA_MASTER_VIEW_C2.Scheme_Code=Scheme_Master.Scheme_Code where Account_No like '"+Acc+"'";
						
					}
			       else if(Account_Type.equalsIgnoreCase("JL"))
			        {
			        	countQuery2="Select Account_No , Scheme_Name,Scheme_Category,Customer_Id,Customer_Name, '-' as Customer_Name_2,'-' as Customer_Name_3,MODE_OF_OPERATION,  to_Char(Open_Date,'dd/MM/yyyy') as Open_Date,to_char(Period_Months|| ' months' ) as pd, to_char(Interest_Rate || ' %') as Interest_Rate ,Closing_Balance as Amount, Closing_Balance,'-' as Int_Payment_Freq,due_date as Due_Date,'-' as Maturity_Amount,nvl(Nominee_Name,'NA'),'-' as effect_date,'-' as TDS,nvl(NOMINEE_RELATIONSHIP,'NA') ,nvl(nominee_age,'NA') as nge,'JL' AS type from JL_MASTER_VIEW left join Scheme_Master on JL_MASTER_VIEW.Scheme_Code=Scheme_Master.Scheme_Code where Account_No like '"+Acc+"'";

			        }
			        else if(Account_Type.equalsIgnoreCase("DL"))
			        {
					countQuery2="Select Account_No , Scheme_Name,Scheme_Category,Customer_Id,Customer_Name,Customer_Name_2,'-' as Customer_Name_3,'-' as MODE_OF_OPERATION,  to_Char(Open_Date,'dd/MM/yyyy') as Open_Date,to_char( Period_days|| ' days ' ) as pd, to_char(Interest_Rate || ' %') as Interest_Rate ,Loan_Amount as Amount, Closing_Balance,'-' as Int_Payment_Freq,to_char(due_date,'dd/MM/yyyy') as Due_Date,'-' as Maturity_Amount, nvl(Nominee_Name,'NA'),'-' as effect_date,'-' as TDS, nvl(NOMINEE_RELATIONSHIP,'NA') as nnm ,nvl(NOMINEE_Age,'NA') as nge,'DL' AS type from OL_MASTER_VIEW3 left join Scheme_Master on OL_MASTER_VIEW3.Scheme_Code=Scheme_Master.Scheme_Code where Account_No ='"+Acc+"' and OL_MASTER_VIEW3.Scheme_Code!='80001'";

			        }
			        else if(Account_Type.equalsIgnoreCase("ML")|| Account_Type.equalsIgnoreCase("PL"))
			        {
			        	countQuery2="Select Account_No , Scheme_Name,Scheme_Category,Customer_Id,Customer_Name,  Customer_Name_2,'-' as Customer_Name_3,'-' as MODE_OF_OPERATION,  to_Char(Open_Date,'dd/MM/yyyy') as Open_Date,case when (period_months is null or period_months=0) then to_char( Period_days|| ' days ' ) else case when (period_days is null or period_days=0) then to_char( Period_months|| ' months ' ) else to_char( Period_months|| ' months /'||Period_days|| ' days' ) end end  as pd, to_char(Interest_Rate || ' %') as Interest_Rate ,Loan_Amount as Amount, Closing_Balance,'-' as Int_Payment_Freq,TO_CHAR(due_date,'dd/MM/yyyy') as Due_Date,'-' as Maturity_Amount, nvl(Nominee_Name,'NA'),'-' as effect_date,'-' as TDS,nvl(NOMINEE_RELATIONSHIP,'NA') as nnm ,nvl(NOMINEE_Age,'NA') as nge,'ML' AS type from OL_MASTER_VIEW3 left join Scheme_Master on OL_MASTER_VIEW3.Scheme_Code=Scheme_Master.Scheme_Code where Account_No ='"+Acc+"' and OL_MASTER_VIEW3.Scheme_Code='80001'";

			        }
			        else if(Account_Type.equalsIgnoreCase("CC")|| Account_Type.equalsIgnoreCase("SL"))
			        {
			        	countQuery2="Select Account_No , Scheme_Name,Scheme_Category,Customer_Id,Customer_Name, '-' as Customer_Name_2,'-' as Customer_Name_3,'-' as MODE_OF_OPERATION,  to_Char(Open_Date,'dd/MM/yyyy') as Open_Date, to_char( Period_months|| ' months ' )  as pd, to_char(Interest_Rate || ' %') as Interest_Rate ,Closing_Balance as Amount, Closing_Balance,'-' as Int_Payment_Freq,due_date as Due_Date,'-' as Maturity_Amount, nvl(Nominee_Name,'NA'),'-' as effect_date,'-' as TDS, nvl(NOMINEE_RELATIONSHIP,'NA') ,nvl(NOMINEE_Age,'NA') as nge,'SL' AS type from CC_MASTER_VIEW_3 left join Scheme_Master on CC_MASTER_VIEW_3.Scheme_Code=Scheme_Master.Scheme_Code where Account_No like '"+Acc+"'" ;

			        }
			        else if(Account_Type.equalsIgnoreCase("RL"))
			        {
			        	countQuery2="Select Account_No , Scheme_Name,Scheme_Category,Customer_Id,Customer_Name, '-' as Customer_Name_2,'-' as Customer_Name_3,'-' as MODE_OF_OPERATION,  to_Char(Open_Date,'dd/MM/yyyy') as Open_Date, to_char( Period_days|| ' days ' )  as pd, to_char(Interest_Rate || ' %') as Interest_Rate ,Closing_Balance as Amount, Closing_Balance,'-' as Int_Payment_Freq,due_date as Due_Date,'-' as Maturity_Amount, nvl(Nominee_Name,'NA'),'-' as effect_date,'-' as TDS, nvl(NOMINEE_RELATIONSHIP,'NA') ,nvl(NOMINEE_Age,'NA') as nge,'RL' AS type from RLL_MASTER_VIEW_C left join Scheme_Master on RLL_MASTER_VIEW_C.Scheme_Code=Scheme_Master.Scheme_Code where Account_No like '"+Acc+"'" ;

			        }
				//out.println(countQuery2);
	
					JSONArray array=new JSONArray();

					try{
						statement = conn1.createStatement();
						rs = statement.executeQuery(countQuery2);
						String snm="";
						String cnm1="";
						String odt="";
						String cus1="";
						
						while (rs.next()) 
						{
							   
				               snm=rs.getString(2);
				               cus1=rs.getString(4);
				                cnm1=rs.getString(5);
				                odt=rs.getString(9);
				                
				                  
						}
						
						String bnm="";
						String badd="";
						String bcity="";
						String bphne="";
						String bpin="";
						
					String countQuery3="Select BRANCH_NAME,	BRANCH_ADDRESS,BRANCH_CITY,	BRANCH_PINCODE,	BRANCH_PHONE from branch_master where to_char(Branch_code)=substr('"+Acc+"',0,3)";
					rs = statement.executeQuery(countQuery3);
					while (rs.next()) 
					{
						   
						    bnm=rs.getString(1);
						    badd=rs.getString(2);
						    bcity=rs.getString(3);
						    bphne=rs.getString(5);
			                bpin=rs.getString(4);
			                
			                  
					}
					 String countQuery4 ="select b.customer_Name,b.Address,to_char('XXXXXX'||substr(b.pan_no,-4))as fpan,to_char('XXXXXXXX'||substr(b.ID_NO,-4))as faadhar from (select a.*,case when a.code=200 then 201 else a.code end as cuscode from (select branch_code,Customer_Name,Address,CASE WHEN length(trim(Pan_No))<10 then 'PPPPPPNPAN' ELSE trim(Pan_No) END AS PAN_NO,CASE WHEN length(trim(id_no))<12 then '000000000000' ELSE trim(id_no) END AS id_no,to_number(to_char(substr('"+cus1+"',0,3)))+100 as code,created_date from customer_view  where customer_id='"+cus1+"')a  order by a.created_date desc)b where b.cuscode=b.branch_code and rownum=1";
					 rs = statement.executeQuery(countQuery4);
//out.println(countQuery4);
					 String Addss="";
					 while (rs.next()) 
						{
						 Addss=rs.getString(2);
						}
					
					
					
						conn1.close();
						
						
								                
						
						 JSONObject obj = new JSONObject();
					     obj.put("snm",snm);
					       obj.put("cid",cus1);
					       obj.put("cnm",cnm1);
					     obj.put("odt",odt);
					     obj.put("bnm",bnm);
					       obj.put("badd",badd);
					       obj.put("bcity",bcity);
					     obj.put("bphne",bphne);
					     obj.put("bpin",bpin);
					       obj.put("Addss",Addss);
					       array.add(obj);
					       
					       
						}catch(SQLException e){
					        out.print("Exception: "+e);
					    }

					out.println(array);
							
							
					
						
						

					output = Be;
					}catch(SQLException e){
				        out.print("Exception: "+e);
				    }
					
					//response.addHeader("AustinAndroidReturn", output);

				}

//Account Statement pdf Summary data 2
			else if (no == 575) 
		{
			//out.println("Hello Ur Action Type is= <b>"
					//+ request.getParameter("type") + "</b>");

			String Be = "";
			String output = "";

			String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
			String mon = request.getParameter("mon");
			String CDate = request.getParameter("Dt");
			String Dt = CDate;//CDate.substring(4,2);
			String val1 = request.getParameter("val1");
			String val2 = request.getParameter("val2");
			//out.println("Date is= <b>" + Dt + "</b>");
			
			Connection conn1 = null;
			Statement statement = null;
			Statement statement2 = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			try {

				Class.forName(ODriver);
				conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
				
				statement2 = conn1.createStatement();
				String cbqry="select  nvl(GET_CLOSING_BALANCE_VIEW_DATEFUNC('"+devId+"',to_char(to_date('"+val2+"','MM/dd/yyyy'),'dd/MM/yyyy')),'NA^0') as CB from dual";
				String msg="";
				double CB=0;
				rs2 = statement2.executeQuery(cbqry);
				while (rs2.next()) 
				{
					msg=rs2.getString(1);
				}
				DecimalFormat df = new DecimalFormat("0.00");
				String Account_Type=msg.substring(0,2);
				CB=Double.parseDouble(msg.substring(3));
				//out.println("connected....!!");
				statement = conn1.createStatement();
							
//05-02-2024
 String QueryString="select nvl(GET_CLOSING_BALANCE_VIEW_AMT('"+devId+"',to_char(to_date('"+val1+"','MM/dd/yyyy')-1,'dd/MM/yyyy')),0) as OB,sum(a.c1) as c1,sum(a.d1) as d1,sum(a.Credit) as Credit,sum(debit) as Debit,nvl(GET_CLOSING_BALANCE_VIEW_AMT('"+devId+"',to_char(to_date('"+val2+"','MM/dd/yyyy'),'dd/MM/yyyy')),0) as CB from (SELECT transaction_type,Transaction_Amount as Tran_Amount, case when Transaction_Type='Credit' then Transaction_Amount else 0 End as Credit,case when Transaction_Type='Credit' then 1 else 0 End as c1,case when Transaction_Type='Debit' then Transaction_Amount else 0 End as Debit,case when Transaction_Type='Debit' then 1 else 0 End as d1 from DAILY_TRANSACTION_ACTIVE_TABLE where Account_no='"+devId+"'  and Transaction_Date between to_date('"+val1+"','MM/dd/yyyy') and to_date('"+val2+"','MM/dd/yyyy'))a";
	
//out.println(QueryString);

	//Log------------------------------------
		PreparedStatement p=null;
		
		  String logQuery="insert into APP_OPERATION_LOG(did,mon,type,no,val1,val2) values('"+devId+"','"+devId+"','Account_Statement PDF Summary Data2','"+no+"','"+val1+"','"+val2+"')";
		  p =conn1.prepareStatement(logQuery);
		  try{
			p.execute();
		  }catch(SQLException e){
		        out.print("Exception: "+e);
		    }
//-----------------------------------------------		

					statement = conn1.createStatement();
		         		rs = statement.executeQuery(QueryString);
					JSONArray array=new JSONArray();
					double cb=CB;
					while (rs.next()) 
					{
						JSONObject obj = new JSONObject();
						
						double OB=Double.parseDouble(rs.getString(1));
						String OB1=df.format(OB);
						obj.put("OB",OB1);
						
						obj.put("CRC",rs.getString(2));
						obj.put("DRC",rs.getString(3));
						
						double CR=Double.parseDouble(rs.getString(4));
						String CR1=df.format(CR);
						obj.put("CR",CR1);
						double DR=Double.parseDouble(rs.getString(5));
						String DR1=df.format(DR);
						obj.put("DR",DR1);
						
						 CB=Double.parseDouble(rs.getString(6));
						String CB1=df.format(CB);
						obj.put("CB",CB1);
                                                 
						obj.put("Atype",Account_Type);
							         
					 					               
			              
			                array.add(obj);
					}
					
			
				
				
				
				conn1.close();
				
				out.println(array);
				
				
				}catch(SQLException e){
			        out.print("Exception: "+e);
			    }
				
				}

//Service List
			else if (no == 576) 
			{
				//out.println("Hello Ur Action Type is= <b>"
						//+ request.getParameter("type") + "</b>");

				String Be = "";
				String output = "";

				String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
				String Customer_Id = request.getParameter("mon");
				String CDate = request.getParameter("Dt");
				String Dt = CDate;//CDate.substring(4,2);
				
				Connection conn1 = null;
				Statement statement = null;
				Statement statement2 = null;
				ResultSet rs = null;
				ResultSet rs2 = null;
				try {

					Class.forName(ODriver);
					conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
					//statement = conn1.createStatement();
				String QueryString="select Service_Name,Id from Apk_Services where Status='Y'";
		
	//out.println(QueryString);

				//Log------------------------------------
			PreparedStatement p=null;
			
			  String logQuery="insert into APP_OPERATION_LOG(mon,type,no,cid) values('"+Customer_Id+"','Service List','"+no+"','"+Customer_Id+"')";
			  p =conn1.prepareStatement(logQuery);
			  try{
				p.execute();
			  }catch(SQLException e){
			        out.print("Exception: "+e);
			    }
	//-----------------------------------------------		


				
					

						try{
						statement = conn1.createStatement();
			         		rs = statement.executeQuery(QueryString);
						
						JSONArray array=new JSONArray();
						
						while (rs.next()) 
						{
							JSONObject obj = new JSONObject();
							 	     obj.put("Serv_Name",rs.getString(1));
						       //obj.put("Serv_Id",rs.getString(2));
						      
						          
						                
						 					               
				              
				                array.add(obj);
						}
						
						
						
						
						

					
					
					
					conn1.close();
					
					out.println(array);
					
					
					}catch(SQLException e){
				        out.print("Exception: "+e);
				    }
					
					
					
					

				output = Be;
				}catch(SQLException e){
			        out.print("Exception: "+e);
			    }
				
				//response.addHeader("AustinAndroidReturn", output);

			}

//SAVE Service List
else if (no == 577) 
			{
				//out.println("Hello Ur Action Type is= <b>"
						//+ request.getParameter("type") + "</b>");

				String Be = "";
				String output = "";

				String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
				String Customer_Id = request.getParameter("mon");
				String snm = request.getParameter("snm");
				String CDate = request.getParameter("Dt");
				String Dt = CDate;//CDate.substring(4,2);

				String msg2 = request.getParameter("msg");
				String parent_bcode="";
				String parent_bname="";
				String Customer_Name="";
				String Mobile_No="";
				
				Connection conn1 = null;
				Statement statement = null;
				Statement statement2 = null;
				ResultSet rs = null;
				ResultSet rs2 = null;
				try {

					Class.forName(ODriver);
					conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
					statement2 = conn1.createStatement();
					
					String kucqry="select Branch_Code,Branch_Name,BRANCH_ADDRESS,BRANCH_CITY,BRANCH_PINCODE,BRANCH_PHONE,Receiver_mail from branch_master where substr(BRANCH_CUSIDFROM,0,3)=substr('"+Customer_Id+"',0,3)";				
					String msg="";
					double CB=0;
					rs2 = statement2.executeQuery(kucqry);
					while (rs2.next()) 
					{
						parent_bcode=rs2.getString(1);
						parent_bname=rs2.getString(2);
					}
					
					String cusInfo="select Customer_Name,Mobile_No from Customer_View where Customer_id='"+Customer_Id+"' and rownum=1";				
					
					rs2 = statement2.executeQuery(cusInfo);
					while (rs2.next()) 
					{
						Customer_Name=rs2.getString(1);
						Mobile_No=rs2.getString(2);
					}
		
	//out.println(QueryString);

				//Log------------------------------------
			PreparedStatement p=null;
			
			  String logQuery="insert into APP_OPERATION_LOG(mon,type,no,cid) values('"+Customer_Id+"','Save Service','"+no+"','"+Customer_Id+" ')";
			  p =conn1.prepareStatement(logQuery);
			  try{
				p.execute();
			  }catch(SQLException e){
			        out.print("Exception: "+e);
			    }
	//-----------------------------------------------	
	//CUSTOMER_ID,CUSTOMER_NAME,MOBILE_NO,BRANCH_CODE,BRANCH_NAME

   String qry1="select to_char('"+Customer_Id+"'||lpad(nvl((select count(*) from app_service_details),0)+1,5,'0')) as service_id from dual";
				String serviceId="1000000100001";
				rs2 = statement2.executeQuery(qry1);
					while (rs2.next()) 
					{
						serviceId=rs2.getString(1);
						
					}

		
	//out.println(serviceId);
			  String insertQuery="insert into APP_Service_Details(SERVICE_NAME,type,cid,status,CUSTOMER_ID,CUSTOMER_NAME,MOBILE_NO,BRANCH_CODE,BRANCH_NAME,remarks,service_id) values('"+snm+"','General','"+Customer_Id+"','N','"+Customer_Id+"','"+Customer_Name+"',nvl('"+Mobile_No+"','0'),'"+parent_bcode+"','"+parent_bname+"','"+msg2+"','"+serviceId+"')";
			  p =conn1.prepareStatement(insertQuery);
			  try{
				p.execute();
			  }catch(SQLException e){
			        out.print("Exception: "+e);
			    }

				
					

					
					

				output = Be;
				}catch(SQLException e){
			        out.print("Exception: "+e);
			    }
				
				//response.addHeader("AustinAndroidReturn", output);

//----Mail Details---------------------------------------------------------------------	
						String sub="Member Service Request";
							sub=sub+"-"+Customer_Id+ " " +snm;
						String msg1="\n 1. Member Id      : "+Customer_Id;
					       String msg22="2. Member Name    : "+Customer_Name;
						String msg3="3. Mobile No      : "+Mobile_No;
						String msg4="4. Parent Branch  : "+parent_bname;
						//String msg5="5. Member Rating  : "+rid;
						String msg5="5. Service Request: "+msg2;
									final String username =MailSender;
								      final String password = MailPass;
								      String from=MailSender;
								    // String to="snnl.otpgenerator@shrinarayaninidhi.com";
						              String to=MailReceiver;
								    //  String host = "webmail.snnl.net";
								      String host =MailHost;
								    Properties props = new Properties();
								    props.put("mail.smtp.auth", "true");
								    props.put("mail.smtp.starttls.enable", "true");
								    props.put("mail.smtp.host", host);
								    props.put("mail.smtp.port", SMTP_PORT);
								   Session ses = Session.getInstance(props,
								            new javax.mail.Authenticator() {
								                protected PasswordAuthentication getPasswordAuthentication() {
								                   return new PasswordAuthentication(username, password);
								                }
								           });
								   
								    try {
								    	// System.out.println("from="+from+";pwd="+pass);
								        Message message = new MimeMessage(ses);
								        message.setFrom(new InternetAddress(from));
								        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
								        message.setSubject(sub);
								        message.setText(msg1+" \n "+msg22+" \n "+msg3+" \n "+msg4+" \n "+msg5);
								        Transport transport = ses.getTransport("smtp");
								        transport.connect(host, username, password);
								        //transport.sendMessage(message, message.getAllRecipients());
								       // transport.close();
								          transport.send(message);

								        System.out.println("Mail sent succesfully!");

								    } catch (MessagingException e) {
								        throw new RuntimeException(e);
								    }
                 // end Mail send----------------------------------------------------------------------------------------


			}

else if (no == 578) {
				//out.println("Hello Ur Action Type is= <b>"
						//+ request.getParameter("type") + "</b>");

				String Be = "";
				String output = "";

				String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
				String mon = request.getParameter("mon");
				String CDate = request.getParameter("Dt");
				String Dt = CDate;//CDate.substring(4,2);
				//out.println("Date is= <b>" + Dt + "</b>");
				Connection conn1 = null;
				Statement statement = null;
				Statement statement2 = null;
				ResultSet rs = null;
				ResultSet rs2 = null;
				try {

					Class.forName(ODriver);
					conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
					//out.println("connected....!!");
					statement = conn1.createStatement();
					statement2 = conn1.createStatement();
					String customer_id=mon;
					//12-12-2023
			       // String QueryString = "select qry1.customer_id,qry2.customer_name,case when qry1.TIME_INFO is null then '00:00:00' else substr(qry1.TIME_INFO,1,16) end as Last_Login,qry2.Closing_balance as CB from (select a.* from (select customer_id,log_details.TIME_INFO,log_details.ID,ROW_NUMBER() OVER ( ORDER BY id desc) as row2 from log_details where customer_id='"+customer_id+"' order by id desc)a where row2=2)qry1 left join (select b.* from (select customer_id,customer_name,Closing_balance,ROW_NUMBER() OVER ( ORDER BY customer_id desc) as row1 from sbca_master_view_report where customer_id='"+customer_id+"' or CUSTOMER_ID_2='"+customer_id+"' or CUSTOMER_ID_3='"+customer_id+"')b where row1=1)qry2 on qry2.customer_id=qry1.customer_id";
			int count=1;
					double CB=0;
					String Account_No="";
					//07-02-2024
										String kucqry="select Branch_Code,Branch_Name,BRANCH_ADDRESS,BRANCH_CITY,BRANCH_PINCODE,BRANCH_PHONE,Receiver_mail from branch_master where substr(BRANCH_CUSIDFROM,0,3)=substr('"+customer_id+"',0,3)";				
					
			//out.println(QueryString);
					try{
						

			//Log------------------------------------
					PreparedStatement p=null;
					
					  String logQuery="insert into APP_OPERATION_LOG(mon,type,no,cid) values('"+mon+"','Know your Branch','"+no+"','"+mon+"')";
					  p =conn1.prepareStatement(logQuery);
					  try{
						p.execute();
					  }catch(SQLException e){
					        out.print("Exception: "+e);
					    }
			//-----------------------------------------------		



					rs = statement.executeQuery(kucqry);
					
					JSONArray array=new JSONArray();
					while (rs.next()) 
					{
						    JSONObject obj = new JSONObject();
			                 obj.put("bcode",rs.getString(1));
			                obj.put("bnm",rs.getString(2));
			                obj.put("badds",rs.getString(3));
			                obj.put("bcity",rs.getString(4));
			                obj.put("bpin",rs.getString(5));
			                obj.put("bphne",rs.getString(6));
			                obj.put("bmail",rs.getString(7));
			                              
			              
			                array.add(obj);
					}
					
					

					
					
					
					conn1.close();
					
					out.println(array);
					
					
					}catch(SQLException e){
				        out.print("Exception: "+e);
				    }
					
					
					
				} catch (Exception e) {

				}

				output = Be;

				
				//response.addHeader("AustinAndroidReturn", output);

			}

//SAVE FeedBack Info
		else if (no == 579) 
					{
						

						String Be = "";
						String output = "";

						String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
						String Customer_Id = request.getParameter("mon");
						String rid = request.getParameter("rid");
						String CDate = request.getParameter("Dt");
						String Dt = CDate;//CDate.substring(4,2);
    						 float rating=0;
   						  rating=Float.parseFloat(rid);
     
					String msg2 = request.getParameter("msg");
						
						Connection conn1 = null;
						Statement statement = null;
						Statement statement2 = null;
						ResultSet rs = null;
						ResultSet rs2 = null;
							String parent_bcode="";
							String parent_bname="";
							String Customer_Name="";
							String Mobile_No="";
						try {

							Class.forName(ODriver);
							conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
							statement2 = conn1.createStatement();
							String kucqry="select Branch_Code,Branch_Name,BRANCH_ADDRESS,BRANCH_CITY,BRANCH_PINCODE,BRANCH_PHONE,Receiver_mail from branch_master where substr(BRANCH_CUSIDFROM,0,3)=substr('"+Customer_Id+"',0,3)";				
							
							String msg="";
							double CB=0;
							rs2 = statement2.executeQuery(kucqry);
							while (rs2.next()) 
							{
								parent_bcode=rs2.getString(1);
								parent_bname=rs2.getString(2);
							}
							
							String cusInfo="select Customer_Name,Mobile_No from Customer_View where Customer_id='"+Customer_Id+"' and rownum=1";				
							
							rs2 = statement2.executeQuery(cusInfo);
							while (rs2.next()) 
							{
								Customer_Name=rs2.getString(1);
								Mobile_No=rs2.getString(2);
							}
				
			//out.println(cusInfo);

						//Log------------------------------------
					PreparedStatement p=null;
					
					  String logQuery="insert into APP_OPERATION_LOG(mon,type,no,cid) values('"+Customer_Id+"','Save FeedBack','"+no+"','"+Customer_Id+" ')";
					  p =conn1.prepareStatement(logQuery);
					  try{
						p.execute();
					  }catch(SQLException e){
					        out.print("Exception: "+e);
					    }
			//-----------------------------------------------	
			//CUSTOMER_ID,CUSTOMER_NAME,MOBILE_NO,BRANCH_CODE,BRANCH_NAME
					  String insertQuery="insert into APP_FEEDBACK_DETAILS(RATING,type,status,CUSTOMER_ID,CUSTOMER_NAME,MOBILE_NO,BRANCH_CODE,BRANCH_NAME,remarks) values("+rating+",'FeedBack','N','"+Customer_Id+"','"+Customer_Name+"',nvl('"+Mobile_No+"','0'),'"+parent_bcode+"','"+parent_bname+"','"+msg2+"')";
					  p =conn1.prepareStatement(insertQuery);
					  try{
						p.execute();
					  }catch(SQLException e){
					        out.print("Exception: "+e);
					    }

					output = Be;
						}catch(SQLException e){
					        out.print("Exception: "+e);
					    }
						
						//response.addHeader("AustinAndroidReturn", output);

//----Mail Details---------------------------------------------------------------------	
						String sub="Member APK Feedback";
						sub=sub+"-"+Customer_Id+ " " +Customer_Name;

						String msg1="\n 1. Member Id      : "+Customer_Id;
					       String msg22="2. Member Name    : "+Customer_Name;
						String msg3="3. Mobile No      : "+Mobile_No;
						String msg4="4. Parent Branch  : "+parent_bname;
						String msg5="5. Member Rating  : "+rid;
						String msg6="6. Member Comments: "+msg2;
									final String username =MailSender;
								      final String password = MailPass;
								      String from=MailSender;
								    // String to="snnl.otpgenerator@shrinarayaninidhi.com";
						              String to=MailReceiver;
								    //  String host = "webmail.snnl.net";
								      String host =MailHost;
								    Properties props = new Properties();
								    props.put("mail.smtp.auth", "true");
								    props.put("mail.smtp.starttls.enable", "true");
								    props.put("mail.smtp.host", host);
								    props.put("mail.smtp.port", SMTP_PORT);
								   Session ses = Session.getInstance(props,
								            new javax.mail.Authenticator() {
								                protected PasswordAuthentication getPasswordAuthentication() {
								                   return new PasswordAuthentication(username, password);
								                }
								           });
								   
								    try {
								        Message message = new MimeMessage(ses);
								        message.setFrom(new InternetAddress(from));
								        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
								        message.setSubject(sub);
								        message.setText(msg1+" \n "+msg22+" \n "+msg3+" \n "+msg4+" \n "+msg5+" \n "+msg6);
								        Transport transport = ses.getTransport("smtp");
								        transport.connect(host, username, password);
								        //transport.sendMessage(message, message.getAllRecipients());
								       // transport.close();
								          transport.send(message);

								       //out.println("Mail sent succesfully!");

								    } catch (MessagingException e) {
								        throw new RuntimeException(e);
								    }
                 // end Mail send----------------------------------------------------------------------------------------


					}


else if (no == 5790) 
					{
						//out.println("Hello Ur Action Type is= <b>"
								//+ request.getParameter("type") + "</b>");

						String Be = "";
						String output = "";

						String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
						String Customer_Id = request.getParameter("mon");
						String rid = request.getParameter("rid");
						String CDate = request.getParameter("Dt");
						String Dt = CDate;//CDate.substring(4,2);
     float rating=0;
     rating=Float.parseFloat(rid);
     
		String msg2 = request.getParameter("msg");
						
						Connection conn1 = null;
						Statement statement = null;
						Statement statement2 = null;
						ResultSet rs = null;
						ResultSet rs2 = null;
						try {

							Class.forName(ODriver);
							conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
							statement2 = conn1.createStatement();
							String parent_bcode="";
							String parent_bname="";
							String kucqry="select Branch_Code,Branch_Name,BRANCH_ADDRESS,BRANCH_CITY,BRANCH_PINCODE,BRANCH_PHONE,Receiver_mail from branch_master where substr(BRANCH_CUSIDFROM,0,3)=substr('"+Customer_Id+"',0,3)";				
							String msg="";
							double CB=0;
							rs2 = statement2.executeQuery(kucqry);
							while (rs2.next()) 
							{
								parent_bcode=rs2.getString(1);
								parent_bname=rs2.getString(2);
							}
							
							String cusInfo="select Customer_Name,nvl(Mobile_No,0) from Customer_View where Customer_id='"+Customer_Id+"' and rownum=1";				
							String Customer_Name="";
							String Mobile_No="";
							rs2 = statement2.executeQuery(cusInfo);
							while (rs2.next()) 
							{
								Customer_Name=rs2.getString(1);
								Mobile_No=rs2.getString(2);
							}
				
			//out.println(QueryString);

						//Log------------------------------------
					PreparedStatement p=null;
					
					  String logQuery="insert into APP_OPERATION_LOG(mon,type,no,cid) values('"+Customer_Id+"','Save FeedBack get info','"+no+"','"+Customer_Id+" ')";
					  p =conn1.prepareStatement(logQuery);
					  try{
						p.execute();
					  }catch(SQLException e){
					        out.print("Exception: "+e);
					    }
			//-----------------------------------------------	
			//CUSTOMER_ID,CUSTOMER_NAME,MOBILE_NO,BRANCH_CODE,BRANCH_NAME
					
JSONArray array=new JSONArray();
				   JSONObject obj = new JSONObject();
		                 obj.put("cnm",Customer_Name);
		                obj.put("mob",Mobile_No);
		                obj.put("bnm",parent_bname);
		                obj.put("msg",rid);
		               
		              
		                array.add(obj);
				out.println(array);

							
							

						output = Be;
						}catch(SQLException e){
					        out.print("Exception: "+e);
					    }
						
						//response.addHeader("AustinAndroidReturn", output);

					}



	else if (no == 580) {
			//out.println("Hello Ur Action Type is= <b>"
					//+ request.getParameter("type") + "</b>");

			String Be = "";
			String output = "";

			String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
			String mon = request.getParameter("mon");
			String CDate = request.getParameter("Dt");
			String Dt = CDate;//CDate.substring(4,2);
			//out.println("Date is= <b>" + Dt + "</b>");
			Connection conn1 = null;
			Statement statement = null;
			Statement statement2 = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			try {

				Class.forName(ODriver);
				conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
				//out.println("connected....!!");
				statement = conn1.createStatement();
				statement2 = conn1.createStatement();
				String bid=mon;
				//12-12-2023
		       // String QueryString = "select qry1.customer_id,qry2.customer_name,case when qry1.TIME_INFO is null then '00:00:00' else substr(qry1.TIME_INFO,1,16) end as Last_Login,qry2.Closing_balance as CB from (select a.* from (select customer_id,log_details.TIME_INFO,log_details.ID,ROW_NUMBER() OVER ( ORDER BY id desc) as row2 from log_details where customer_id='"+customer_id+"' order by id desc)a where row2=2)qry1 left join (select b.* from (select customer_id,customer_name,Closing_balance,ROW_NUMBER() OVER ( ORDER BY customer_id desc) as row1 from sbca_master_view_report where customer_id='"+customer_id+"' or CUSTOMER_ID_2='"+customer_id+"' or CUSTOMER_ID_3='"+customer_id+"')b where row1=1)qry2 on qry2.customer_id=qry1.customer_id";
		int count=1;
				double CB=0;
				String Account_No="";
				//07-02-2024
									String kucqry="select Branch_Code,Branch_Name,BRANCH_ADDRESS,BRANCH_CITY,BRANCH_PINCODE,BRANCH_PHONE,Receiver_mail from branch_master where to_char(Branch_Code)='"+bid+"'";				
				
		//out.println(QueryString);
				try{
					

		//Log------------------------------------
				PreparedStatement p=null;
				
				  String logQuery="insert into APP_OPERATION_LOG(mon,type,no,cid) values('"+mon+"','Branch from Bcode','"+no+"','"+mon+"')";
				  p =conn1.prepareStatement(logQuery);
				  try{
					p.execute();
				  }catch(SQLException e){
				        out.print("Exception: "+e);
				    }
		//-----------------------------------------------		



				rs = statement.executeQuery(kucqry);
				
				JSONArray array=new JSONArray();
				while (rs.next()) 
				{
					    JSONObject obj = new JSONObject();
		                 obj.put("bcode",rs.getString(1));
		                obj.put("bnm",rs.getString(2));
		                obj.put("badds",rs.getString(3));
		                obj.put("bcity",rs.getString(4));
		                obj.put("bpin",rs.getString(5));
		                obj.put("bphne",rs.getString(6));
		                obj.put("bmail",rs.getString(7));
		                              
		              
		                array.add(obj);
				}
				
				

				
				
				
				conn1.close();
				
				out.println(array);
				
				
				}catch(SQLException e){
			        out.print("Exception: "+e);
			    }
				
				
				
			} catch (Exception e) {

			}

			output = Be;

			
			//response.addHeader("AustinAndroidReturn", output);

		}

				
		
		//Update App Registration
		else if (no == 581) {
		//out.println("Hello Ur Action Type is= <b>"
			//+ request.getParameter("type") + "</b>");
		
		String Be = "";
		String output = "";
		
		String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
		String mon = request.getParameter("mon");
		String CDate = request.getParameter("Dt");
		String Dt = CDate;//CDate.substring(4,2);
		//out.println("Date is= <b>" + Dt + "</b>");
		
		Connection conn1 = null;
		Statement statement = null;
		Statement statement2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		try {
		
		Class.forName(ODriver);
		conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
		//out.println("connected....!!");
		statement = conn1.createStatement();
		        // String QueryString="SELECT Update_FCM_ID('"+mon+"','"+devId+"','"+CDate+"') from dual";
		
		       
		         
		         CallableStatement cs;
		         cs = conn1.prepareCall("{CALL Update_App_Registration(?,?,?)}");
		         cs.setString(1,mon );
		         cs.setString(2, devId);
		         cs.setString(3, CDate);
		       
		        
		      
		
		try{
			
		 rs2 = cs.executeQuery();
		out.println("kk");
		
		
		//Log------------------------------------
		PreparedStatement p=null;
		
		  String logQuery="insert into APP_OPERATION_LOG(mon,type,no,cid) values('"+mon+"','App Registration','"+no+"','"+mon+"')";
		  p =conn1.prepareStatement(logQuery);
		  try{
			p.execute();
		  }catch(SQLException e){
		        out.print("Exception: "+e);
		    }
out.println("kk2");
		

//-----------------------------------------------		


		conn1.close();
		
		
		
		
		}catch(SQLException e){
		    out.print("Exception: "+e);
		}
		
		
		
		} catch (Exception e) {
		
		}
		
		output = Be;
		
		
		//response.addHeader("AustinAndroidReturn", output);
		
		}
		

 //Check mobile and device id
		else if (no == 582) {
			//out.println("Hello Ur Action Type is= <b>"
					//+ request.getParameter("type") + "</b>");

			String Be = "";
			String output = "";

			String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
			String mon = request.getParameter("mon");
			String CDate = request.getParameter("Dt");
			String Dt = CDate;//CDate.substring(4,2);
			//out.println("Date is= <b>" + Dt + "</b>");
			
			Connection conn1 = null;
			Statement statement = null;
			Statement statement2 = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			try {

				Class.forName(ODriver);
				conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
				//out.println("connected....!!");
				statement = conn1.createStatement();
				//String QueryString = "select nvl(count(*),0) from APP_REGISTRATION  where mobile_no='"+mon+"' and DEVICE_ID='"+devId+"' and Status='Y'";
				String QueryString = "select nvl(count(*),0) from APP_REGISTRATION  where mobile_no='"+mon+"' and Status='Y'";
				
//out.println(QueryString);

//Log------------------------------------
		PreparedStatement p=null;
		
		  String logQuery="insert into APP_OPERATION_LOG(mon,type,no) values('"+mon+"','LoginPage Check Mobile','"+no+"')";
		  p =conn1.prepareStatement(logQuery);
		  try{
			p.execute();
		  }catch(SQLException e){
		        out.print("Exception: "+e);
		    }
//-----------------------------------------------		



				try{
					
				rs = statement.executeQuery(QueryString);
				
				JSONArray array=new JSONArray();
				while (rs.next()) 
				{
					    JSONObject obj = new JSONObject();
		                obj.put("cnt",rs.getString(1));
		               
		               
		              
		                array.add(obj);
				}
				
				

				
				
				
				conn1.close();
				
				out.println(array);
				
				
				}catch(SQLException e){
			        out.print("Exception: "+e);
			    }
				
				
				
			} catch (Exception e) {

			}

			output = Be;

			
			//response.addHeader("AustinAndroidReturn", output);

		}

//Get MobilePass and dob
				else if (no == 583) {
					//out.println("Hello Ur Action Type is= <b>"
							//+ request.getParameter("type") + "</b>");

					String Be = "";
					String output = "";

					String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
					String mon = request.getParameter("mon");
					String CDate = request.getParameter("Dt");
					String Dt = CDate;//CDate.substring(4,2);
					//out.println("Date is= <b>" + Dt + "</b>");
					
					Connection conn1 = null;
					Statement statement = null;
					Statement statement2 = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					try {

						Class.forName(ODriver);
						conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
						//out.println("connected....!!");
						statement = conn1.createStatement();
						String QueryString = "select to_char(substr(nvl(a.mobile_no,'0000000000'),-4) ||substr(nvl(a.date_of_birth,'01/01/1900'),-4)) as pass,substr(nvl(a.mobile_no,'0000000000'),-4) as fmob,substr(nvl(a.date_of_birth,'01/01/1900'),-4) as fdob from (select mobile_no,date_of_birth,customer_id,(select branch_code from branch_master where substr(BRANCH_CUSIDFROM,0,3)=substr('"+mon+"',0,3)) as PBranch,branch_code from customer_view where to_char(customer_id)='"+mon+"')a where a.pbranch=a.branch_code and rownum=1";

		//out.println(QueryString);

		//Log------------------------------------
				PreparedStatement p=null;
				
				  String logQuery="insert into APP_OPERATION_LOG(mon,type,no) values('"+mon+"','Get MobilePassword','"+no+"')";
				  p =conn1.prepareStatement(logQuery);
				  try{
					p.execute();
				  }catch(SQLException e){
				        out.print("Exception: "+e);
				    }
		//-----------------------------------------------		



						try{
							
						rs = statement.executeQuery(QueryString);
						
						JSONArray array=new JSONArray();
						while (rs.next()) 
						{
							    JSONObject obj = new JSONObject();
				                obj.put("pass",rs.getString(1));
				              //  obj.put("mob",rs.getString(2));
				              //  obj.put("dob",rs.getString(3));
				               
				               
				              
				                array.add(obj);
						}
						
						

						
						
						
						conn1.close();
						
						out.println(array);
						
						
						}catch(SQLException e){
					        out.print("Exception: "+e);
					    }
						
						
						
					} catch (Exception e) {

					}

					output = Be;

					
					//response.addHeader("AustinAndroidReturn", output);

				}

//Account Statement  Normal Order
				else if (no == 584) 
				{
					//out.println("Hello Ur Action Type is= <b>"
							//+ request.getParameter("type") + "</b>");

					String Be = "";
					String output = "";

					String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
					String mon = request.getParameter("mon");
					String CDate = request.getParameter("Dt");
					String Dt = CDate;//CDate.substring(4,2);
					String val1 = request.getParameter("val1");
					String val2 = request.getParameter("val2");
					//out.println("Date is= <b>" + Dt + "</b>");
					
					Connection conn1 = null;
					Statement statement = null;
					Statement statement2 = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					try {

						Class.forName(ODriver);
						conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
						
						statement2 = conn1.createStatement();
						String cbqry="select  nvl(GET_CLOSING_BALANCE_VIEW_DATEFUNC('"+devId+"',to_char(to_date('"+val2+"','MM/dd/yyyy'),'dd/MM/yyyy')),'NA^0') as CB from dual";
						String msg="";
						double CB=0;
						rs2 = statement2.executeQuery(cbqry);
						while (rs2.next()) 
						{
							msg=rs2.getString(1);
						}
						DecimalFormat df = new DecimalFormat("0.00");
						String Account_Type=msg.substring(0,2);
						CB=Double.parseDouble(msg.substring(3));
						//out.println("connected....!!");
						statement = conn1.createStatement();
						//String QueryString="SELECT  a.Transaction_Id,a.Part_Tran_Id,a.Tran_Date,a.Transaction_Particulars as Transaction_Particulars,a.Tran_Amount FROM (Select to_char(Transaction_Date,'dd/MM/yyyy') as Tran_Date, to_char(Transaction_Id) as Transaction_Id,to_char(Part_Tran_Id) as Part_Tran_Id,Transaction_Date,substr(Transaction_Particulars,1,10) as Transaction_Particulars,to_char(Transaction_Amount ||' '||case when Transaction_Type='Credit' then 'Cr' else 'Dr' End) as Tran_Amount from DAILY_TRANSACTION_ACTIVE_TABLE where Account_no='"+devId+"' and to_char(branch)='"+mon+"' and Transaction_Date between to_date('"+val1+"','dd/MM/yyyy') and to_date('"+val2+"','dd/MM/yyyy'))a order by a.Transaction_Date desc,to_number(substr(to_char(a.Transaction_Id),-5,5)) desc";
				//MM/dd/yyyy		
				//String QueryString="SELECT  a.Transaction_Id,a.Part_Tran_Id,a.Tran_Date,a.Transaction_Particulars as Transaction_Particulars,a.Tran_Amount FROM (Select to_char(Transaction_Date,'dd/MM/yyyy') as Tran_Date, to_char(Transaction_Id) as Transaction_Id,to_char(Part_Tran_Id) as Part_Tran_Id,Transaction_Date,substr(Transaction_Particulars,1,10) as Transaction_Particulars,to_char(Transaction_Amount ||' '||case when Transaction_Type='Credit' then 'Cr' else 'Dr' End) as Tran_Amount from DAILY_TRANSACTION_ACTIVE_TABLE where Account_no='"+devId+"'  and Transaction_Date between to_date('"+val1+"','MM/dd/yyyy') and to_date('"+val2+"','MM/dd/yyyy'))a order by a.Transaction_Date desc,to_number(substr(to_char(a.Transaction_Id),-5,5)) desc";
				
		//transaction_type,to_char(Transaction_Amount ||' '||case when Transaction_Type='Credit' then 'Cr' else 'Dr' End) as FTran_Amount,flag
		//String QueryString="SELECT  a.Transaction_Id,a.Part_Tran_Id,a.Tran_Date,a.Transaction_Particulars as Transaction_Particulars,a.Tran_Amount,a.transaction_type,a.FTran_Amount,a.flag FROM (Select to_char(Transaction_Date,'dd/MM/yyyy') as Tran_Date, to_char(Transaction_Id) as Transaction_Id,to_char(Part_Tran_Id) as Part_Tran_Id,Transaction_Date,substr(Transaction_Particulars,1,10) as Transaction_Particulars,transaction_type,Transaction_Amount as Tran_Amount, to_char(Transaction_Amount ||' '||case when Transaction_Type='Credit' then 'Cr' else 'Dr' End) as FTran_Amount,flag from DAILY_TRANSACTION_ACTIVE_TABLE where Account_no='"+devId+"'  and Transaction_Date between to_date('"+val1+"','MM/dd/yyyy') and to_date('"+val2+"','MM/dd/yyyy'))a order by a.Transaction_Date desc,to_number(substr(to_char(a.Transaction_Id),-5,5)) desc,a.Part_Tran_Id desc";
					
		//20-01-2024 transaction particular full
		String QueryString="SELECT  a.Transaction_Id,a.Part_Tran_Id,a.Tran_Date,a.Transaction_Particulars as Transaction_Particulars,a.Tran_Amount,a.transaction_type,a.FTran_Amount,a.flag FROM (Select to_char(Transaction_Date,'dd/MM/yyyy') as Tran_Date, to_char(Transaction_Id) as Transaction_Id,to_char(Part_Tran_Id) as Part_Tran_Id,Transaction_Date, Transaction_Particulars,transaction_type,Transaction_Amount as Tran_Amount, to_char(Transaction_Amount ||' '||case when Transaction_Type='Credit' then 'Cr' else 'Dr' End) as FTran_Amount,flag from DAILY_TRANSACTION_ACTIVE_TABLE where Account_no='"+devId+"'  and Transaction_Date between to_date('"+val1+"','MM/dd/yyyy') and to_date('"+val2+"','MM/dd/yyyy'))a order by a.Transaction_Date desc,to_number(substr(to_char(a.Transaction_Id),-5,5)) desc,a.Part_Tran_Id desc";
			
		//out.println(QueryString);

			//Log------------------------------------
				PreparedStatement p=null;
				
				  String logQuery="insert into APP_OPERATION_LOG(did,mon,type,no,val1,val2) values('"+devId+"','"+devId+"','Account_Statement Normal','"+no+"','"+val1+"','"+val2+"')";
				  p =conn1.prepareStatement(logQuery);
				  try{
					p.execute();
				  }catch(SQLException e){
				        out.print("Exception: "+e);
				    }
		//-----------------------------------------------		



					
						if(!Account_Type.equalsIgnoreCase("NA"))
						{
							


							try{
							statement = conn1.createStatement();
				         		rs = statement.executeQuery(QueryString);
							
							JSONArray array=new JSONArray();
							double cb=CB;
							if(Account_Type.equalsIgnoreCase("SD"))
							{
							while (rs.next()) 
							{
								JSONObject obj = new JSONObject();
								
								obj.put("Balance",df.format(cb));
							     if(rs.getString(6).equalsIgnoreCase("Credit"))
							     {
							    	 double temp=rs.getDouble(5);
							    	  cb=cb-temp;
							     }
							     else if(rs.getString(6).equalsIgnoreCase("Debit"))
							     {
							    	 double temp=rs.getDouble(5);
							    	  	 cb=cb+temp;
							     }
							  	     obj.put("Transaction_Id",rs.getString(1));
							       obj.put("Part_Tran_Id",rs.getString(2));
							       obj.put("Tran_Date",rs.getString(3));
							     obj.put("Transaction_Particulars",rs.getString(4));
							     obj.put("Tran_Amount",rs.getString(7));
							               
							                
							 					               
					              
					                array.add(obj);
							}
							}
							else if(Account_Type.equalsIgnoreCase("FD") || Account_Type.equalsIgnoreCase("RD"))
							{
								
								cb=CB;
							while (rs.next()) 
							{
								JSONObject obj = new JSONObject();
								
								
								obj.put("Balance",df.format(cb));
								 double temp=rs.getDouble(5);
								
							     if(rs.getString(6).equalsIgnoreCase("Credit"))
							      cb=cb - temp;
							      else if(rs.getString(6).equalsIgnoreCase("Debit"))
							      cb=cb+temp;
								
							  	     obj.put("Transaction_Id",rs.getString(1));
							       obj.put("Part_Tran_Id",rs.getString(2));
							       obj.put("Tran_Date",rs.getString(3));
							     obj.put("Transaction_Particulars",rs.getString(4));
							     obj.put("Tran_Amount",rs.getString(7));
							               
							                
							 					               
					              
					                array.add(obj);
							}
							}
							else if( Account_Type.equalsIgnoreCase("RL"))
							{
								
								cb=Math.abs(CB);
							while (rs.next()) 
							{
								JSONObject obj = new JSONObject();
								
								
								obj.put("Balance",df.format(cb));
								 double temp=rs.getDouble(5);
								 if(rs.getString(8).equalsIgnoreCase("AC"))
								 {
							     if(rs.getString(6).equalsIgnoreCase("Credit"))
							      cb=cb - temp;
							      else if(rs.getString(6).equalsIgnoreCase("Debit"))
							      cb=cb+temp;
								 }
							  	     obj.put("Transaction_Id",rs.getString(1));
							       obj.put("Part_Tran_Id",rs.getString(2));
							       obj.put("Tran_Date",rs.getString(3));
							     obj.put("Transaction_Particulars",rs.getString(4));
							     obj.put("Tran_Amount",rs.getString(7));
							               
							                
							 					               
					              
					                array.add(obj);
							}
							}
							else if(Account_Type.equalsIgnoreCase("JL") || Account_Type.equalsIgnoreCase("PL")||Account_Type.equalsIgnoreCase("CL") || Account_Type.equalsIgnoreCase("DL") || Account_Type.equalsIgnoreCase("CC"))
							{
								
								cb=Math.abs(CB);
							while (rs.next()) 
							{
								JSONObject obj = new JSONObject();
								
								
								obj.put("Balance",df.format(cb));
								 double temp=rs.getDouble(5);
								  if(rs.getString(6).equalsIgnoreCase("Credit"))
							      cb=cb + temp;
							      else if(rs.getString(6).equalsIgnoreCase("Debit"))
							      cb=cb-temp;
								 
							  	     obj.put("Transaction_Id",rs.getString(1));
							       obj.put("Part_Tran_Id",rs.getString(2));
							       obj.put("Tran_Date",rs.getString(3));
							     obj.put("Transaction_Particulars",rs.getString(4));
							     obj.put("Tran_Amount",rs.getString(7));
							               
							                
							 					               
					              
					                array.add(obj);
							}
							}
							
							Collections.reverse(array);

						
						
						
						conn1.close();
						
						out.println(array);
						
						
						}catch(SQLException e){
					        out.print("Exception: "+e);
					    }
						
						}
						
						

					output = Be;
					}catch(SQLException e){
				        out.print("Exception: "+e);
				    }
					
					//response.addHeader("AustinAndroidReturn", output);

				}

//Get Image Location
				else if (no == 585) 
				{
					//out.println("Hello Ur Action Type is= <b>"
							//+ request.getParameter("type") + "</b>");

					String Be = "";
					String output = "";

					String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
					String Customer_Id = request.getParameter("aid");
					//String CDate = request.getParameter("Dt");
					//String Dt = CDate;//CDate.substring(4,2);
					
					Connection conn1 = null;
					Statement statement = null;
					Statement statement2 = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					try {

						Class.forName(ODriver);
						conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
						//statement = conn1.createStatement();
					String QueryString="select IMAGELOCATION from app_details";
			
		//out.println(QueryString);

					//Log------------------------------------
				PreparedStatement p=null;
				
				  String logQuery="insert into APP_OPERATION_LOG(mon,type,no,cid) values('"+Customer_Id+"','Get Image','"+no+"','"+Customer_Id+"')";
				  p =conn1.prepareStatement(logQuery);
				  try{
					p.execute();
				  }catch(SQLException e){
				        out.print("Exception: "+e);
				    }
		//-----------------------------------------------		


					
						

							try{
							statement = conn1.createStatement();
				         		rs = statement.executeQuery(QueryString);
							
							JSONArray array=new JSONArray();
							
							while (rs.next()) 
							{
								JSONObject obj = new JSONObject();
								 	     obj.put("i1",rs.getString(1)+"/image1.jpg");
							        obj.put("i2",rs.getString(1)+"/image2.jpg");
							        obj.put("i3",rs.getString(1)+"/image3.jpg");
								obj.put("i4",rs.getString(1)+"/BalanceSheet.pdf");
							        obj.put("i5",rs.getString(1)+"/image5.jpg");

							           
							                
							 					               
					              
					                array.add(obj);
							}
							
							
							
							
							

						
						
						
						conn1.close();
						
						out.println(array);
						
						
						}catch(SQLException e){
					        out.print("Exception: "+e);
					    }
						
						
						
						

					output = Be;
					}catch(SQLException e){
				        out.print("Exception: "+e);
				    }
					
					//response.addHeader("AustinAndroidReturn", output);

				}

//Get MOP/ERS Data
				else if (no == 586) 
				{
					//out.println("Hello Ur Action Type is= <b>"
							//+ request.getParameter("type") + "</b>");

					String Be = "";
					String output = "";

					String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
					String mon = request.getParameter("mon");
					String CDate = request.getParameter("Dt");
					String Dt = CDate;//CDate.substring(4,2);
					//out.println("Date is= <b>" + Dt + "</b>");
					
					Connection conn1 = null;
					Statement statement = null;
					Statement statement2 = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					try {

						Class.forName(ODriver);
						conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
						//out.println("connected....!!");
						statement = conn1.createStatement();
						statement2 = conn1.createStatement();
						String Acc=mon;
						int count=0;
						double CB=0;
						String Account_Type="";
						String Scheme_Code="";
						String Customer_Id="";
						String cid1="";
						String cnm1="";
						String cid2="";
						String cnm2="";
						String cid3="";
						String cnm3="";
						JSONArray array=new JSONArray();
						String countQuery="select Account_Type,scheme_code,customer_id from CUST_ACC_LINK_VIEW where Account_no='"+Acc+"'";
						rs2 = statement2.executeQuery(countQuery);
						while (rs2.next()) 
						{
							Account_Type=rs2.getString(1);
							Scheme_Code=rs2.getString(2);
							Customer_Id=rs2.getString(3);
						}
		//out.println(QueryString);

		//Log------------------------------------
				PreparedStatement p=null;
				
				  String logQuery="insert into APP_OPERATION_LOG(mon,type,no) values('"+mon+"','Get MOP Details','"+no+"')";
				  p =conn1.prepareStatement(logQuery);
				  try{
					p.execute();
				  }catch(SQLException e){
				        out.print("Exception: "+e);
				    }
		//-----------------------------------------------		
if(Account_Type.equalsIgnoreCase("SD") || Account_Type.equalsIgnoreCase("FD") || Account_Type.equalsIgnoreCase("RD"))
		{
					String qrytable="";
					if(Account_Type.equalsIgnoreCase("SD"))
					{
						qrytable="SBCA_MASTER_VIEW_C2";
					}
					else if(Account_Type.equalsIgnoreCase("FD"))
					{
						qrytable="FD_Master_View";
					}
					else
						qrytable="RD_MasterView_C2";
	
		
			String ersInfo="select to_char(Customer_id),Customer_Name,to_char(Customer_id_2),Customer_Name_2,nvl(to_char(CUSTOMER_ID_3),'NA'),case when CUSTOMER_NAME_3='null' then 'NA' else nvl(to_char(CUSTOMER_NAME_3),'NA')end from "+qrytable+" where Account_No='"+Acc+"'";
					//out.println(ersInfo);

			rs2 = statement2.executeQuery(ersInfo);
			while (rs2.next()) 
			{
				cid1=rs2.getString(1);
				cnm1=rs2.getString(2);
				cid2=rs2.getString(3);
				cnm2=rs2.getString(4);

				cid3=rs2.getString(5);
				cnm3=rs2.getString(6);
			}
		
		}
		JSONObject obj = new JSONObject();
		obj.put("cid1",cid1);	
		obj.put("cnm1",cnm1);

		obj.put("cid2",cid2);	
		obj.put("cnm2",cnm2);
		obj.put("cid3",cid3);
		obj.put("cnm3",cnm3);
		   array.add(obj);
												
									conn1.close();
									out.println(array);
						
					} catch (Exception e) {

					}

					output = Be;

					
					//response.addHeader("AustinAndroidReturn", output);

				}

//Get JL Rate per Gram
				else if (no == 587) 
				{
					//out.println("Hello Ur Action Type is= <b>"
							//+ request.getParameter("type") + "</b>");

					String Be = "";
					String output = "";

					String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
					String mon = request.getParameter("mon");
					String CDate = request.getParameter("Dt");
					String Dt = CDate;//CDate.substring(4,2);
					//out.println("Date is= <b>" + Dt + "</b>");
					
					Connection conn1 = null;
					Statement statement = null;
					Statement statement2 = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					try {

						Class.forName(ODriver);
						conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
						//out.println("connected....!!");
						statement = conn1.createStatement();
						statement2 = conn1.createStatement();
						String Acc=mon;
						int count=0;
						double CB=0;
						String Scheme_Code="";
						String Scheme_Name="";
						String Gram_20="";
						String Gram_21="";
						String Gram_22="";
						String Gram_19="";
						String Gram_18="";

						
						JSONArray array=new JSONArray();
						

		//Log------------------------------------
				PreparedStatement p=null;
				
				  String logQuery="insert into APP_OPERATION_LOG(mon,type,no) values('"+mon+"','Get JL Rate Per Gram','"+no+"')";
				  p =conn1.prepareStatement(logQuery);
				  try{
					p.execute();
				  }catch(SQLException e){
				        out.print("Exception: "+e);
				    }
		//-----------------------------------------------		

		
			String ersInfo="select Scheme_Code,Scheme_Name,Gram_20,Gram_21,Gram_22,Gram_19,Gram_18 from App_Interest_Slab where Category='JL'";
					//out.println(ersInfo);

			rs2 = statement2.executeQuery(ersInfo);
			while (rs2.next()) 
			{
				Scheme_Code=rs2.getString(1);
				Scheme_Name=rs2.getString(2);
				Gram_20=rs2.getString(3);
				Gram_21=rs2.getString(4);

				Gram_22=rs2.getString(5);
				Gram_19=rs2.getString(6);
				Gram_18=rs2.getString(7);

							
				JSONObject obj = new JSONObject();
				obj.put("sc",Scheme_Code);	
				obj.put("snm",Scheme_Name);

					
				
				obj.put("g22",Gram_22);
				obj.put("g21",Gram_21);
				obj.put("g20",Gram_20);
				obj.put("g19",Gram_19);
				obj.put("g18",Gram_18);

				
				   array.add(obj);
			}
		
		
		
												
									conn1.close();
									out.println(array);
						
					} catch (Exception e) {

					}

					output = Be;

					
					//response.addHeader("AustinAndroidReturn", output);

				}


//Int Slab Dep all
		else if (no == 588) 
		{
			//out.println("Hello Ur Action Type is= <b>"
					//+ request.getParameter("type") + "</b>");

			String Be = "";
			String output = "";

			String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
			String Customer_Id = request.getParameter("mon");
			String CDate = request.getParameter("Dt");
			String Dt = CDate;//CDate.substring(4,2);
			
			Connection conn1 = null;
			Statement statement = null;
			Statement statement2 = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			try {

				Class.forName(ODriver);
				conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
				//statement = conn1.createStatement();
			String QueryString="select scheme_Name,Period,General,Senior,Super_Senior,Remarks from App_Interest_Slab where Type='Deposit'  order by group1,to_number(nvl(substr(nvl(General,'0'),1,length(nvl(General,'0'))-1),'0')) ";
	
//out.println(QueryString);

			//Log------------------------------------
		PreparedStatement p=null;
		
		  String logQuery="insert into APP_OPERATION_LOG(mon,type,no,cid) values('"+Customer_Id+"','Int_Slab_Dep All','"+no+"','"+Customer_Id+"')";
		  p =conn1.prepareStatement(logQuery);
		  try{
			p.execute();
		  }catch(SQLException e){
		        out.print("Exception: "+e);
		    }
//-----------------------------------------------		


			
				

					try{
					statement = conn1.createStatement();
		         		rs = statement.executeQuery(QueryString);
					
					JSONArray array=new JSONArray();
					
					while (rs.next()) 
					{
						JSONObject obj = new JSONObject();
						 	     obj.put("Scheme_Name",rs.getString(1));
					       obj.put("Period",rs.getString(2));
					       obj.put("General",rs.getString(3));
					     obj.put("Senior",rs.getString(4));
					    
					          
					                
					 					               
			              
			                array.add(obj);
					}
					
					
					
					
					

				
				
				
				conn1.close();
				
				out.println(array);
				
				
				}catch(SQLException e){
			        out.print("Exception: "+e);
			    }
				
				
				
				

			output = Be;
			}catch(SQLException e){
		        out.print("Exception: "+e);
		    }
			
			//response.addHeader("AustinAndroidReturn", output);

		}

		//Int Slab Loan all
				else if (no == 589) 
				{
					//out.println("Hello Ur Action Type is= <b>"
							//+ request.getParameter("type") + "</b>");

					String Be = "";
					String output = "";

					String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
					String Customer_Id = request.getParameter("mon");
					String CDate = request.getParameter("Dt");
					String Dt = CDate;//CDate.substring(4,2);
					
					Connection conn1 = null;
					Statement statement = null;
					Statement statement2 = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					try {

						Class.forName(ODriver);
						conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
						//statement = conn1.createStatement();
					//String QueryString="select scheme_Name,Period,General,Senior,Super_Senior,Remarks from App_Interest_Slab where Type='Loan'";
					String QueryString="select scheme_Name,Period,General,Senior,Super_Senior,Remarks from App_Interest_Slab where Type='Loan' order by group1,to_number(nvl(substr(nvl(General,'0'),1,length(nvl(General,'0'))-1),'0'))";

			
		//out.println(QueryString);

						//Log------------------------------------
		PreparedStatement p=null;
		
		  String logQuery="insert into APP_OPERATION_LOG(mon,type,no,cid) values('"+Customer_Id+"','Int_Slab_Loan all','"+no+"','"+Customer_Id+"')";
		  p =conn1.prepareStatement(logQuery);
		  try{
			p.execute();
		  }catch(SQLException e){
		        out.print("Exception: "+e);
		    }
//-----------------------------------------------		


						

							try{
							statement = conn1.createStatement();
				         		rs = statement.executeQuery(QueryString);
							
							JSONArray array=new JSONArray();
							
							while (rs.next()) 
							{
								JSONObject obj = new JSONObject();
								 	     obj.put("Scheme_Name",rs.getString(1));
							       obj.put("Period",rs.getString(2));
							       obj.put("General",rs.getString(3));
							     obj.put("Senior",rs.getString(4));
							    
							          
							                
							 					               
					              
					                array.add(obj);
							}
							
							
							
							
							

						
						
						
						conn1.close();
						
						out.println(array);
						
						
						}catch(SQLException e){
					        out.print("Exception: "+e);
					    }
						
						
						
						

					output = Be;
					}catch(SQLException e){
				        out.print("Exception: "+e);
				    }
					
					//response.addHeader("AustinAndroidReturn", output);

				}

//Locker List
				else if (no == 5900) {
					//out.println("Hello Ur Action Type is= <b>"
							//+ request.getParameter("type") + "</b>");

					String Be = "";
					String output = "";

					String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
					String mon = request.getParameter("mon");
					String CDate = request.getParameter("Dt");
					String Dt = CDate;//CDate.substring(4,2);
					//out.println("Date is= <b>" + Dt + "</b>");
					
					Connection conn1 = null;
					Statement statement = null;
					Statement statement2 = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
				ResultSet rs3 = null;
						Statement statement3 = null;
						
					try {

						Class.forName(ODriver);
						conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
						//out.println("connected....!!");
						statement = conn1.createStatement();
										 //14-03-2024
				              		String QueryString=" select (select short_Name from branch_Master where to_char(branch_code)=locker_Accounts_view.Bcode) as Bname,Account_no,to_char(Customer_id) as Customer_id ,Customer_name,customer_id_2,customer_name_2,LOCKER_NO,CABINET_No,(select locker_size from locker_master_view where locker_no=locker_Accounts_view.LOCKER_NO and CABINET_ID=locker_Accounts_view.CABINET_No and locker_master_view.BCODE = locker_Accounts_view.BCODE and rownum=1) as locker_size,to_char(open_date,'dd/MM/yyyy') as Open_Date,renewal_date,locker_rent+nvl(GST_AMT,0) as rent_paid,NOMINEE_NAME,NOMINEE_RELATIONSHIP,NOMINEE_AGE ,mode_of_operation from locker_Accounts_view where Account_status='A' and ( to_char(Customer_id)='"+devId+"' or to_char(CUSTOMER_ID_2)='"+devId+"' ) order by open_date desc";
					//out.println(QueryString);

						//Log------------------------------------
						PreparedStatement p=null;
						
						  String logQuery="insert into APP_OPERATION_LOG(did,cid,type,no) values('"+devId+"','"+devId+"','Locker List','"+no+"')";
				//out.println(logQuery);
						  
				p =conn1.prepareStatement(logQuery);
						  try{
							p.execute();
						  }catch(SQLException e){
						        out.print("Exception: "+e);
						    }
				//-----------------------------------------------		

						try{
							
						rs = statement.executeQuery(QueryString);
						
						JSONArray array=new JSONArray();
						while (rs.next()) 
						{
							    JSONObject obj = new JSONObject();
				                 obj.put("Account_No",rs.getString("Account_No"));
				                obj.put("Open_Date",rs.getString("Open_Date"));
				                obj.put("CB",rs.getString("Rent_Paid"));
				                obj.put("Scheme_Code",rs.getString("Locker_Size"));
				                obj.put("acNm",rs.getString("Customer_Name"));
				                  obj.put("bn",rs.getString("BNAME"));
				               
				              
				                array.add(obj);
						}
						
						

						
						
						
						conn1.close();
						
						out.println(array);
						
						
						}catch(SQLException e){
					        out.print("Exception: "+e);
					    }
						
						
						
					} catch (Exception e) {

					}

					output = Be;

					
					//response.addHeader("AustinAndroidReturn", output);

				}

//Locker Details
				else if(no==591)
				{

					//out.println("Hello Ur Action Type is= <b>"
							//+ request.getParameter("type") + "</b>");

					String Be = "";
					String output = "";

					String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
					String mon = request.getParameter("mon");
					String CDate = request.getParameter("Dt");
					String Dt = CDate;//CDate.substring(4,2);
					//out.println("Date is= <b>" + Dt + "</b>");
					Connection conn1 = null;
					Statement statement = null;
					Statement statement2 = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					try {

						Class.forName(ODriver);
						conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
						//out.println("connected....!!");
						statement = conn1.createStatement();
						statement2 = conn1.createStatement();
						String Acc=mon;
						int count=0;
						double CB=0;
						String Account_Type="";
						String Scheme_Code="";
						String Customer_Id="";
						String ROI="";
				String PenIns="0";
				String LienNo="";

						String countQuery="select Account_Type,scheme_code,customer_id from CUST_ACC_LINK_VIEW where Account_no='"+Acc+"'";
						rs2 = statement2.executeQuery(countQuery);
						while (rs2.next()) 
						{
							Account_Type=rs2.getString(1);
							Scheme_Code=rs2.getString(2);
							Customer_Id=rs2.getString(3);
						}
						
	              		String countQuery2=" select (select short_Name from branch_Master where to_char(branch_code)=locker_Accounts_view.BCODE) as Bname,Account_no,to_char(Customer_id) as Customer_id ,Customer_name,customer_id_2,nvl(customer_name_2,'na') as customer_name_2,LOCKER_NO,CABINET_No,(select locker_size from locker_master_view where locker_no=locker_Accounts_view.LOCKER_NO and CABINET_ID=locker_Accounts_view.CABINET_No and locker_master_view.BCODE = locker_Accounts_view.BCODE and rownum=1) as locker_size,to_char(open_date,'dd/MM/yyyy') as Open_Date,to_char(renewal_date,'dd/MM/yyyy') as renewal_date,locker_rent+nvl(GST_AMT,0) as rent_paid,NOMINEE_NAME,NOMINEE_RELATIONSHIP,NOMINEE_AGE ,mode_of_operation,Customer_Id_2 from locker_Accounts_view where Account_status='A' and Account_No='"+devId+"'";

				        

				      //Log------------------------------------
						PreparedStatement p=null;
						
						  String logQuery="insert into APP_OPERATION_LOG(mon,type,no) values('"+mon+"','Locker Account_Details','"+no+"')";
						  p =conn1.prepareStatement(logQuery);
						  try{
							p.execute();
						  }catch(SQLException e){
						        out.print("Exception: "+e);
						    }
				//-----------------------------------------------		



				//out.println(countQuery2);
						try{
							
						rs = statement.executeQuery(countQuery2);
						
						JSONArray array=new JSONArray();
						while (rs.next()) 
						{
							    JSONObject obj = new JSONObject();
				                obj.put("acn",rs.getString("Account_No"));
				                obj.put("cat",rs.getString("Locker_Size"));
				                obj.put("cus1",rs.getString("Customer_Id"));
						 obj.put("cus2",rs.getString("Customer_Id_2"));

				                obj.put("cnm1",rs.getString("Customer_Name"));
				                obj.put("cnm2",rs.getString("Customer_Name_2"));
				                obj.put("mop",rs.getString("Mode_of_Operation"));
				                obj.put("amt",rs.getString("Rent_Paid"));
				                obj.put("odt",rs.getString("Open_Date"));
				                obj.put("ddt",rs.getString("Renewal_Date"));
				                  obj.put("lino",rs.getString("Locker_No"));
				                			               
				                obj.put("nnm",rs.getString("Nominee_Name"));
				                
				               
				                obj.put("nrp",rs.getString("Nominee_Relationship"));
				                obj.put("nge",rs.getString("Nominee_Age"));
				
				
				 
				 String mop=rs.getString("Mode_of_Operation");
				 	 if(mop.equalsIgnoreCase("A"))
					 {
						 mop="AorS";
					 }
					else if(mop.equalsIgnoreCase("E"))
					 {
						 mop="EorS";
					 }
					else if(mop.equalsIgnoreCase("F"))
					 {
						 mop="ForS";
					 }
					else if(mop.equalsIgnoreCase("J"))
					 {
						 mop="Joint";
					 }
					else if(mop.equalsIgnoreCase("S"))
					 {
						 mop="Individual";
					 }

					 else
						 mop="Individual";
				 
				 obj.put("mop",mop);

							       
				              
				                array.add(obj);
						}
						
						

						
						
						
						conn1.close();
						
						out.println(array);
						
						
						}catch(SQLException e){
					        out.print("Exception: "+e);
					    }
						
						
						
					} catch (Exception e) {

					}

					output = Be;

					
					//response.addHeader("AustinAndroidReturn", output);


				}

//Add Timestamp
				else if(no==592)
				{

				
					String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
					
					//out.println("Date is= <b>" + Dt + "</b>");
					Connection conn1 = null;
					Statement statement = null;
					Statement statement2 = null;
					ResultSet rs = null;
				
					try {

						Class.forName(ODriver);
						conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
						//out.println("connected....!!");
						statement = conn1.createStatement();
						
						
						  //Log------------------------------------
						PreparedStatement p=null;
						
						String logQuery="insert into APP_Session(did,aid,type) values('"+devId+"','AAAAAA','Mobile')";
						  p =conn1.prepareStatement(logQuery);
						  try{
							p.execute();
						  }catch(SQLException e){
						        out.print("Exception: "+e);
						    }
				//-----------------------------------------------	
				conn1.close();
						
				}catch(SQLException e){
			        out.print("Exception: "+e);
			    }
			}
	//Check Timestamp
				else if(no==593)
				{

					
					String Be = "";
					String output = "";

					String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
					JSONArray array=new JSONArray();
					Connection conn1 = null;
					Statement statement = null;
					Statement statement2 = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					try {

						Class.forName(ODriver);
						conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
						//out.println("connected....!!");
						statement = conn1.createStatement();
						statement2 = conn1.createStatement();
					
						String Account_Type="N";
						
		
						String countQuery="select case when CURRENT_TIMESTAMP<a.EXPIRED_TIME_INFO then 'Y' else 'N' end as status from (select * from app_session where did='"+devId+"' order by id desc)a where rownum=1";		
						rs2 = statement2.executeQuery(countQuery);
						int f=1;
						JSONObject obj = new JSONObject();
						while (rs2.next()) 
						{
								f=2;
							Account_Type=rs2.getString(1);
							if(!Account_Type.equalsIgnoreCase(null) && !Account_Type.isEmpty())
							obj.put("Customer_Id",Account_Type);
						    array.add(obj);
						}
						 if(f==1)
							{
							obj.put("Customer_Id","N");	
							 array.add(obj);
		      				}
						 conn1.close();	
					}catch(SQLException e){
					        out.print("Exception: "+e);
					        conn1.close();	
					    }
			
				out.println(array);
						

						
				}	


//Get Secure Image Location
				else if (no == 594) 
				{
					//out.println("Hello Ur Action Type is= <b>"
							//+ request.getParameter("type") + "</b>");

					String Be = "";
					String output = "";

					String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
					String Customer_Id = request.getParameter("aid");
					//String CDate = request.getParameter("Dt");
					//String Dt = CDate;//CDate.substring(4,2);
					
					Connection conn1 = null;
					Statement statement = null;
					Statement statement2 = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					try {

						Class.forName(ODriver);
						conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
						//statement = conn1.createStatement();
					String QueryString="select SECIMAGELOCATION from app_details";
			
		//out.println(QueryString);

					//Log------------------------------------
				PreparedStatement p=null;
				
				  String logQuery="insert into APP_OPERATION_LOG(mon,type,no,cid) values('"+Customer_Id+"','Get Secure Image','"+no+"','"+Customer_Id+"')";
				  p =conn1.prepareStatement(logQuery);
				  try{
					p.execute();
				  }catch(SQLException e){
				        out.print("Exception: "+e);
				    }
		//-----------------------------------------------		


					
						

							try{
							statement = conn1.createStatement();
				         		rs = statement.executeQuery(QueryString);
							
							JSONArray array=new JSONArray();
							
							while (rs.next()) 
							{
								JSONObject obj = new JSONObject();
								 	     obj.put("i1",rs.getString(1)+"/image1.jpg");
							        obj.put("i2",rs.getString(1)+"/image2.jpg");
							        obj.put("i3",rs.getString(1)+"/image3.jpg");
								obj.put("i4",rs.getString(1)+"/BalanceSheet.pdf");
							        obj.put("i5",rs.getString(1)+"/image5.jpg");

							           
							                
							 					               
					              
					                array.add(obj);
							}
							
							
							
							
							

						
						
						
						conn1.close();
						
						out.println(array);
						
						
						}catch(SQLException e){
					        out.print("Exception: "+e);
					    }
						
						
						
						

					output = Be;
					}catch(SQLException e){
				        out.print("Exception: "+e);
				    }
					
					//response.addHeader("AustinAndroidReturn", output);

				}

//Insert Log Check
				else if (no == 595) 
				{
					//out.println("Hello Ur Action Type is= <b>"
							//+ request.getParameter("type") + "</b>");

					String Be = "";
					String output = "";

					String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
					String Customer_Id = request.getParameter("aid");
						String mon = request.getParameter("mon");
					
					Connection conn1 = null;
					Statement statement = null;
					Statement statement2 = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					try {

						Class.forName(ODriver);
						conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
						//statement = conn1.createStatement();
					String QueryString="select SECIMAGELOCATION from app_details";
			
					//out.println(QueryString);

					//Log------------------------------------
				PreparedStatement p=null;
				
				  String logQuery="insert into APP_OPERATION_LOG(mon,type,no,cid) values('"+devId+"','"+mon+"','"+no+"','"+Customer_Id+"')";
				  p =conn1.prepareStatement(logQuery);
				  try{
					p.execute();
				  }catch(SQLException e){
				        out.print("Exception: "+e);
				    }
		//-----------------------------------------------		
			
						conn1.close();
						
						}catch(SQLException e){
					        out.print("Exception: "+e);
					    }
						
					
				}

//Get Member Name
				else if (no == 596) 
				{
					//out.println("Hello Ur Action Type is= <b>"
							//+ request.getParameter("type") + "</b>");

					String Be = "";
					String output = "";

					String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
					String Customer_Id = request.getParameter("aid");
					String mon = request.getParameter("mon");
					//String Dt = CDate;//CDate.substring(4,2);
					
					Connection conn1 = null;
					Statement statement = null;
					Statement statement2 = null;
					ResultSet rs = null;
					ResultSet rs2 = null;
					try {

						Class.forName(ODriver);
						conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
						//statement = conn1.createStatement();
					String QueryString="select customer_name from customer_view where customer_id='"+mon+"' and rownum=1";
			
		//out.println(QueryString);

					//Log------------------------------------
				PreparedStatement p=null;
				
				  String logQuery="insert into APP_OPERATION_LOG(mon,type,no,cid) values('"+mon+"','Get Member Name','"+no+"','"+Customer_Id+"')";
				  p =conn1.prepareStatement(logQuery);
				  try{
					p.execute();
				  }catch(SQLException e){
				        out.print("Exception: "+e);
				    }
		//-----------------------------------------------		
				try{
							statement = conn1.createStatement();
				         		rs = statement.executeQuery(QueryString);
							
							JSONArray array=new JSONArray();
							
							while (rs.next()) 
							{
								    JSONObject obj = new JSONObject();
					                obj.put("Customer_Id",rs.getString(1));
					               
					               
					              
					                array.add(obj);
							}
							
						
						conn1.close();
						
						out.println(array);
						
						
						}catch(SQLException e){
					        out.print("Exception: "+e);
					    }
						
						
						
						

					output = Be;
					}catch(SQLException e){
				        out.print("Exception: "+e);
				    }
					
					//response.addHeader("AustinAndroidReturn", output);

				}

//Branch List
else if (no == 597) {
				//out.println("Hello Ur Action Type is= <b>"
						//+ request.getParameter("type") + "</b>");

				String Be = "";
				String output = "";

				String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
				String mon = request.getParameter("mon");
				String CDate = request.getParameter("Dt");
				String Dt = CDate;//CDate.substring(4,2);
				//out.println("Date is= <b>" + Dt + "</b>");
				Connection conn1 = null;
				Statement statement = null;
				Statement statement2 = null;
				ResultSet rs = null;
				ResultSet rs2 = null;
				try {

					Class.forName(ODriver);
					conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
					//out.println("connected....!!");
					statement = conn1.createStatement();
					statement2 = conn1.createStatement();
					String customer_id=mon;
					//12-12-2023
			       // String QueryString = "select qry1.customer_id,qry2.customer_name,case when qry1.TIME_INFO is null then '00:00:00' else substr(qry1.TIME_INFO,1,16) end as Last_Login,qry2.Closing_balance as CB from (select a.* from (select customer_id,log_details.TIME_INFO,log_details.ID,ROW_NUMBER() OVER ( ORDER BY id desc) as row2 from log_details where customer_id='"+customer_id+"' order by id desc)a where row2=2)qry1 left join (select b.* from (select customer_id,customer_name,Closing_balance,ROW_NUMBER() OVER ( ORDER BY customer_id desc) as row1 from sbca_master_view_report where customer_id='"+customer_id+"' or CUSTOMER_ID_2='"+customer_id+"' or CUSTOMER_ID_3='"+customer_id+"')b where row1=1)qry2 on qry2.customer_id=qry1.customer_id";
			int count=1;
					double CB=0;
					String Account_No="";
					//06-06-2024
String kucqry="select SHORT_NAME,to_char(BRANCH_ADDRESS||','||BRANCH_CITY||','||BRANCH_PINCODE) as BRANCH_ADDRESS,nvl(BRANCH_PHONE,'000-0000000') as BRANCH_PHONE,RECEIVER_MAIL from Branch_Master order by branch_code";					
			//out.println(QueryString);
					try{
						

			//Log------------------------------------
					PreparedStatement p=null;
					
					  String logQuery="insert into APP_OPERATION_LOG(mon,type,no,cid) values('"+mon+"','Branch List','"+no+"','"+mon+"')";
					  p =conn1.prepareStatement(logQuery);
					  try{
						p.execute();
					  }catch(SQLException e){
					        out.print("Exception: "+e);
					    }
			//-----------------------------------------------		



					rs = statement.executeQuery(kucqry);
					
					JSONArray array=new JSONArray();
					while (rs.next()) 
					{
						    JSONObject obj = new JSONObject();
			                
			                obj.put("bnm",rs.getString(1));
			                obj.put("badds",rs.getString(2));
			                 obj.put("bphne",rs.getString(3));
			                obj.put("bmail",rs.getString(4));
			                              
			              
			                array.add(obj);
					}
					
					

					
					
					
					conn1.close();
					
					out.println(array);
					
					
					}catch(SQLException e){
				        out.print("Exception: "+e);
				    }
					
					
					
				} catch (Exception e) {

				}

				output = Be;

				
				//response.addHeader("AustinAndroidReturn", output);

			}

	//Branch List Tamil
		else if (no == 598) {
						//out.println("Hello Ur Action Type is= <b>"
								//+ request.getParameter("type") + "</b>");

						String Be = "";
						String output = "";

						String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
						String mon = request.getParameter("mon");
						String CDate = request.getParameter("Dt");
						String Dt = CDate;//CDate.substring(4,2);
						//out.println("Date is= <b>" + Dt + "</b>");
						Connection conn1 = null;
						Statement statement = null;
						Statement statement2 = null;
						ResultSet rs = null;
						ResultSet rs2 = null;
						try {

							Class.forName(ODriver);
							conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
							//out.println("connected....!!");
							statement = conn1.createStatement();
							statement2 = conn1.createStatement();
							String customer_id=mon;
							//12-12-2023
					       // String QueryString = "select qry1.customer_id,qry2.customer_name,case when qry1.TIME_INFO is null then '00:00:00' else substr(qry1.TIME_INFO,1,16) end as Last_Login,qry2.Closing_balance as CB from (select a.* from (select customer_id,log_details.TIME_INFO,log_details.ID,ROW_NUMBER() OVER ( ORDER BY id desc) as row2 from log_details where customer_id='"+customer_id+"' order by id desc)a where row2=2)qry1 left join (select b.* from (select customer_id,customer_name,Closing_balance,ROW_NUMBER() OVER ( ORDER BY customer_id desc) as row1 from sbca_master_view_report where customer_id='"+customer_id+"' or CUSTOMER_ID_2='"+customer_id+"' or CUSTOMER_ID_3='"+customer_id+"')b where row1=1)qry2 on qry2.customer_id=qry1.customer_id";
					int count=1;
							double CB=0;
							String Account_No="";
							//06-06-2024
		//String kucqry="select Branch_Tamil,to_char(BRANCH_ADDRESS||','||BRANCH_CITY||','||BRANCH_PINCODE) as BRANCH_ADDRESS,nvl(BRANCH_PHONE,'000-0000000') as BRANCH_PHONE,RECEIVER_MAIL from Branch_Master order by branch_code";					

//to_char(BRANCH_ADDRESS_TAMIL||','||BRANCH_PINCODE) as BRANCH_ADDRESS  15-06-2024					
		String kucqry="select Branch_Tamil,to_char(BRANCH_ADDRESS_TAMIL||','||BRANCH_PINCODE) as BRANCH_ADDRESS,nvl(BRANCH_PHONE,'000-0000000') as BRANCH_PHONE,RECEIVER_MAIL from Branch_Master order by branch_code";					

//out.println(QueryString);
							try{
								

					//Log------------------------------------
							PreparedStatement p=null;
							
							  String logQuery="insert into APP_OPERATION_LOG(mon,type,no,cid) values('"+mon+"','Branch List Tamil','"+no+"','"+mon+"')";
							  p =conn1.prepareStatement(logQuery);
							  try{
								p.execute();
							  }catch(SQLException e){
							        out.print("Exception: "+e);
							    }
					//-----------------------------------------------		



							rs = statement.executeQuery(kucqry);
							
							JSONArray array=new JSONArray();
							while (rs.next()) 
							{
								    JSONObject obj = new JSONObject();
					                
					                obj.put("bnm",rs.getString(1));
					                obj.put("badds",rs.getString(2));
					                 obj.put("bphne",rs.getString(3));
					                obj.put("bmail",rs.getString(4));
					                              
					              
					                array.add(obj);
							}
							
							

							
							
							
							conn1.close();
							
							out.println(array);
							
							
							}catch(SQLException e){
						        out.print("Exception: "+e);
						    }
							
							
							
						} catch (Exception e) {

						}

						output = Be;

						
						//response.addHeader("AustinAndroidReturn", output);

					}
	else if (no == 555) {
			//out.println("Hello Ur Action Type is= <b>"
					//+ request.getParameter("type") + "</b>");

			String Be = "";
			String output = "";

			String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
			String mon = request.getParameter("mon");
			String CDate = request.getParameter("Dt");
			String Dt = CDate;//CDate.substring(4,2);
			//out.println("Date is= <b>" + Dt + "</b>");

String sub=request.getParameter("sub");
String msg1=request.getParameter("msg1");
String msg2=request.getParameter("msg2");
String msg3=request.getParameter("msg3");
String msg4=request.getParameter("msg4");
String msg5=request.getParameter("msg5");

			
			Connection conn1 = null;
			Statement statement = null;
			Statement statement2 = null;
			ResultSet rs = null;
			ResultSet rs2 = null;
			try {

				Class.forName(ODriver);
				conn1 = DriverManager.getConnection(SysName,UserName, PassWord);
				//out.println("connected....!!");
				statement = conn1.createStatement();
				String QueryString = "insert into log_details(CUSTOMER_ID,LOG_DATE,TIME_INFO) values ('"+mon+"',to_date(to_char(sysdate,'dd/MM/yyyy'),'dd/MM/yyyy'),to_char(current_timestamp,'dd/MM/yyyy hh:mi:ss AM'))";

				try{
					
				rs = statement.executeQuery(QueryString);
				
						
				
				
				conn1.close();
				
				
				
				
				}catch(SQLException e){
			        out.print("Exception: "+e);
			    }
				
				
				
			} catch (Exception e) {

			}

			output = Be;

			/* final String username ="snnl.otpgenerator@shrinarayaninidhi.com";
		      final String password = "$toneL0ck1";
		      
		      String from="snnl.otpgenerator@shrinarayaninidhi.com";
		    // String to="snnl.otpgenerator@shrinarayaninidhi.com";
 String to="am_it@shrinarayaninidhi.com";
		      
		    //  String host = "webmail.snnl.net";
		      String host = "65.0.171.189";

		    Properties props = new Properties();
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.starttls.enable", "true");
		    props.put("mail.smtp.host", host);
		    props.put("mail.smtp.port", "587");
		   
		    
		    
		    Session ses = Session.getInstance(props,
		            new javax.mail.Authenticator() {
		                protected PasswordAuthentication getPasswordAuthentication() {
		                   return new PasswordAuthentication(username, password);
		                }
		           });
		    
		   // Session session = Session.getDefaultInstance(props);
		   // MimeMessage message = new MimeMessage(session);

		    try {
		    	// System.out.println("from="+from+";pwd="+pass);
		        Message message = new MimeMessage(ses);
		        message.setFrom(new InternetAddress(from));
		        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
		        message.setSubject(sub);
		        message.setText(msg1+" \n "+msg2+" \n "+msg3+" \n "+msg4+" \n "+msg5);
		        Transport transport = ses.getTransport("smtp");
		        transport.connect(host, username, password);
		        //transport.sendMessage(message, message.getAllRecipients());
		       // transport.close();
		          
		        
		        transport.send(message);

		        System.out.println("Mail sent succesfully!");

		    } catch (MessagingException e) {
		        throw new RuntimeException(e);
		    }
 */
			
			//response.addHeader("AustinAndroidReturn", output);

		}


			else if (no == 128) {
				//out.println("Hello Ur Action Type is= <b>"
						//+ request.getParameter("type") + "</b>");

				String Be = "";
				String output = "";

				String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
				String CDate = request.getParameter("Dt");
				String Dt = CDate;//CDate.substring(4,2);
				//out.println("Date is= <b>" + Dt + "</b>");
				
				Connection conn1 = null;
				Statement statement = null;
				Statement statement2 = null;
				ResultSet rs = null;
				ResultSet rs2 = null;
				try {

					Class.forName(ODriver);
					conn1 = DriverManager.getConnection(
							SysName,
							UserName, PassWord);
					//out.println("connected....!!");
					statement = conn1.createStatement();
				//String QueryString = "select a.*,SUBSTR(a.col_two, 1, INSTR(a.col_two, '.')-1) AS time1,SUBSTR(a.col_two, INSTR(a.col_two, ' ')+1) AS ampm from (SELECT SUBSTR(daily_cb.Created_date, 1, INSTR(daily_cb.Created_date, ' ')-1) AS col_one, SUBSTR(daily_cb.Created_date, INSTR(daily_cb.Created_date, ' ')+1) AS col_two FROM daily_cb where CB_Date='"+Dt+"' and branch_code='201')a";
				//13-06-2023
				//String QueryString="select b.time1,b.ampm,SUBSTR( b.time1, 1, INSTR(b.time1, ':',1,2)-1) as withoutsec from (select a.*,SUBSTR(a.col_two, 1, INSTR(a.col_two, '.')-1) AS time1,SUBSTR(a.col_two, INSTR(a.col_two, ' ')+1) AS ampm from (SELECT SUBSTR(daily_cb.Created_date, 1, INSTR(daily_cb.Created_date, ' ')-1) AS col_one, SUBSTR(daily_cb.Created_date, INSTR(daily_cb.Created_date, ' ')+1) AS col_two FROM daily_cb where CB_Date='"+Dt+"' and branch_code='201')a)b";
				
				String QueryString="select to_char(created_date,'HH:mi'),to_char(created_date,'AM') FROM daily_cb where CB_Date='"+Dt+"' and branch_code='201'";
					//out.println(QueryString);

					rs = statement.executeQuery(QueryString);
					while (rs.next())
					{
						//Be +=rs.getString(3)+"^"+rs.getString(2)+"^TIME";
						Be +=rs.getString(1)+"^"+rs.getString(2)+"^TIME";
					}
					//conn1.close();
					
				
					conn1.close();
					
					
				} catch (Exception e) {

				}

				output = Be;

				out.println("<b>" + output + "</b>");
				
				response.addHeader("AustinAndroidReturn", output);

			}			
			else if (no == 70200) {
				out.println("Hello Ur Action Type is= <b>"
						+ request.getParameter("type") + "</b>");

				String output = "202";

				response.addHeader("AustinAndroidReturn", output);

			}
			 else if(no == 52){
			       
			        String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
			        String uid =request.getParameter("uid");
			        String pwd =request.getParameter("pwd");
			        String ss =request.getParameter("app");



			        
			        String Uname=null;
					 	String Pword=null;
					 	String output=null;
					 	int f=1;
			    
			     Connection conn1 = null;
			     Statement statement = null;
			     ResultSet rs = null;
			     try
			     {
			     	
			         Class.forName(ODriver);
			        conn1 = DriverManager.getConnection(SysName, UserName, PassWord);
			       //  out.println("connected....!!");
			         statement = conn1.createStatement();
			  
			      // sql query to retrieve values from the secified table.
			      String QueryString = "SELECT USERNAME,PASSWORD from DG_Login_details where DEVICEID='"+devId+"' and User_Type='Tablet'";
			     //out.println(QueryString); 
 rs = statement.executeQuery(QueryString);
			      //out.println("rs.next()="+rs.next());
			      /*if (rs.next() == false)
			      {
			    	  f=0;

			      }*/
			      while (rs.next()) {

			     	 Uname=rs.getString(1);
			     	 Pword=rs.getString(2);
			      }
			     if(f!=0)
			      {
//out.println(uid +" " +Uname);
//out.println(pwd +" "+Pword);



	if(Uname.equalsIgnoreCase(uid)&& Pword.equalsIgnoreCase(pwd))
			             	output="Y";
			        else
			        	output="N";
			      
			      }
			      else
			      {
			      	output="D";
			      }
			      conn1.close();
			     }
			     catch(Exception e)
			     {
			    	 output="D";
			         out.println("Exception : " + e.getMessage() + "");
			     }
			   
			     	out.println("AX^="+output+"ER,");

			   
			     response.addHeader("VectorFExp", "AX^="+output+"ER,");
			      
			       
			    }
			    else if(no == 53){
			        out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
			        
			       
			        String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
			        String Uname=null;
					 	String Pword=null;
			    
			     Connection conn1 = null;
			     Statement statement = null;
			     ResultSet rs = null;
			  
			     Connection conn2 = null;
			     Statement statement2 = null;
			     ResultSet rs2 = null;
			     String output = "";
			     try
			     {
			     	
			         Class.forName(ODriver);
			        conn2 = DriverManager.getConnection(SysName,UserName, PassWord);
			         out.println("Particlar DBconnected....!!");
			       //  out.println("Uname....!!"+Uname);
			       //  out.println("Pword!"+Pword);
			         statement2 = conn2.createStatement();
			  
			        // String query = "SELECT * FROM Dg_Customer";
			         String query = "SELECT * FROM DG_Login_details where USER_TYPE='Tablet' and DEVICEID='"+devId+"'";
			          rs2 = statement2.executeQuery(query);
			         int i=1;
			         while (rs2.next()) 
			         {
			        	 out.println("while!");
			          i++;
			      	   output=output+i+"^"+rs2.getString("USERNAME") + "^" + rs2.getString("PASSWORD") + "^" + rs2.getString("EMP_NAME")+ "^"+rs2.getString("id")+",";  

			        	}
			     
			         out.println("Output Send ....!!="+output);
			     
			      conn2.close();
			     }
			     
			     catch(Exception e)
			     {
			         out.println("Exception : " + e.getMessage() + "");
			     }

			  
			     response.addHeader("VectorFExp", output);
			      
			       
			    }



			else {
				out.println("Enter Valid Type");
			}
		response.setContentType("application/json"); 
	%>

