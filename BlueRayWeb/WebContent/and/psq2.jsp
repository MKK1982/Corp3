<%@ page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%@page import="org.json.simple.*"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "dbuser1",
					"dbpwd1");
			//out.println("connected....!!");

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

					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dbuser1", "dbpwd1");
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

				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dbuser1", "dbpwd1");
				//out.println("connected....!!");
				statement = conn1.createStatement();
				String QueryString = "select a.customer_id from (select nvl(customer_id,0) as customer_id from customer_view where mobile_no='"+mon+"' order by branch)a where ROWNUM=1";
				//out.println(QueryString);

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

				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dbuser1", "dbpwd1");
				//out.println("connected....!!");
				statement = conn1.createStatement();
				String QueryString = "select main_qry.Customer_id,main_qry.Customer_Name,main_qry.Last_Login,main_qry.CB from (select Customer_Id,Customer_Name,'00:00:00' as Last_Login,nvl(Closing_Balance,0) as CB from sbca_master where customer_id in (select a.customer_id from (select nvl(customer_id,0) as customer_id from customer_view where mobile_no='"+mon+"' order by branch)a where ROWNUM=1) )main_qry where rownum=1";
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

				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dbuser1", "dbpwd1");
				//out.println("connected....!!");
				statement = conn1.createStatement();
				//String QueryString = "SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.Customer_Name FROM ( Select Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'SD' AS TYPE,Customer_Id,Customer_Name from SBCA_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' union Select Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'FD' AS TYPE,Customer_Id,Customer_Name from FD_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' union Select Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'RD' AS TYPE,Customer_Id,Customer_Name from RD_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' )main_qry  order by main_qry.Account_No,main_qry.SCheme_Code";
				String QueryString="SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.acNm FROM ( Select Branch as Branch,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'SD' AS TYPE,Customer_Id,Customer_Name as acNm from SBCA_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' union Select to_char(Branch_Code) as Branch ,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'FD' AS TYPE,Customer_Id,Customer_Name as acNm from FD_Master_View where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' union Select  Branch as Branch,Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'RD' AS TYPE,Customer_Id,Customer_Name as acNm from RD_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' )main_qry  where main_qry.Branch='"+mon+"'  order by main_qry.Account_No,main_qry.SCheme_Code,main_qry.Branch";
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

		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dbuser1", "dbpwd1");
		//out.println("connected....!!");
		statement = conn1.createStatement();
		//String QueryString = "SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.Customer_Name FROM ( Select Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'SD' AS TYPE,Customer_Id,Customer_Name from SBCA_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' union Select Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'FD' AS TYPE,Customer_Id,Customer_Name from FD_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' union Select Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'RD' AS TYPE,Customer_Id,Customer_Name from RD_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' )main_qry  order by main_qry.Account_No,main_qry.SCheme_Code";
		//String QueryString="SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.Customer_Name FROM (Select Branch as Branch,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'JL' AS TYPE,Customer_Id,Customer_Name from JL_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' union Select Branch as Branch ,Scheme_Code,to_char(Account_No) as Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'OL' AS TYPE,Customer_Id,Customer_Name from OL_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' union Select  Branch as Branch,Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'SL' AS TYPE,Customer_Id,Customer_Name from CC_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' )main_qry  where to_char(main_qry.Branch)='"+mon+"%' order by main_qry.Account_No,main_qry.SCheme_Code,main_qry.Branch";
                  String QueryString="SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,nvl(main_qry.CB,0) as CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.Customer_Name FROM (select a.* from (Select Branch as Branch,Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'JL' AS TYPE,Customer_Id,Customer_Name from JL_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' union Select Branch as Branch ,Scheme_Code,to_char(Account_No) as Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'OL' AS TYPE,Customer_Id,Customer_Name from OL_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' union Select  Branch as Branch,Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,-Closing_Balance as CB,Account_Status,'SL' AS TYPE,Customer_Id,Customer_Name from CC_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%')a where to_char(a.Branch)='"+mon+"' )main_qry   order by main_qry.Account_No,main_qry.SCheme_Code,main_qry.Branch";

		
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

		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dbuser1", "dbpwd1");
		//out.println("connected....!!");
		statement = conn1.createStatement();
		//String QueryString = "SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.Customer_Name FROM ( Select Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'SD' AS TYPE,Customer_Id,Customer_Name from SBCA_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' union Select Scheme_Code,Account_No,to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'FD' AS TYPE,Customer_Id,Customer_Name from FD_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"' union Select Scheme_Code,to_char(Account_No),to_char(open_date,'dd/MM/yyyy') as Open_Date,Closing_Balance as CB,Account_Status,'RD' AS TYPE,Customer_Id,Customer_Name from RD_Master where to_char(Customer_Id)='"+devId+"' and Account_Status like '"+mon+"%' )main_qry  order by main_qry.Account_No,main_qry.SCheme_Code";
		String QueryString="SELECT main_qry.Scheme_Code,main_qry.Account_No,main_qry.Open_Date,main_qry.CB,main_qry.TYPE as Type,main_qry.Customer_Id,main_qry.Customer_Name FROM (Select Branch as Branch,Scheme_Code,Account_No,to_char(date1,'dd/MM/yyyy') as Open_Date,Share_Amount as CB,Account_Status,'Share' AS TYPE,Customer_Id,Customer_Name from Share_Master_View_C where to_char(Customer_Id)='"+devId+"' and Account_Status like 'A%' )main_qry  where main_qry.Branch='"+mon+"' order by main_qry.Account_No,main_qry.SCheme_Code,main_qry.Branch";
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

		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dbuser1", "dbpwd1");
		//out.println("connected....!!");
		statement = conn1.createStatement();
		String QueryString="select main_qry.* from (Select to_char(Transaction_Id) as Transaction_Id,to_char(Part_Tran_Id) as Part_Tran_Id,to_char(Transaction_Date,'dd/MM/yyyy') as Tran_Date,substr(Transaction_Particulars,1,10) as Transaction_Particulars,to_char(Transaction_Amount ||' '||case when Transaction_Type='Credit' then 'Cr' else 'Dr' End) as Tran_Amount from Daily_Transaction_table where Account_no='"+devId+"' and to_char(branch)='"+mon+"' order by Transaction_Date desc,to_number(substr(to_char(Transaction_Id),-5,5)) desc)main_qry where rownum<=10";
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

		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dbuser1", "dbpwd1");
		//out.println("connected....!!");
		statement = conn1.createStatement();
		//String QueryString="SELECT  a.Transaction_Id,a.Part_Tran_Id,a.Tran_Date,a.Transaction_Particulars as Transaction_Particulars,a.Tran_Amount FROM (Select to_char(Transaction_Date,'dd/MM/yyyy') as Tran_Date, to_char(Transaction_Id) as Transaction_Id,to_char(Part_Tran_Id) as Part_Tran_Id,Transaction_Date,substr(Transaction_Particulars,1,10) as Transaction_Particulars,to_char(Transaction_Amount ||' '||case when Transaction_Type='Credit' then 'Cr' else 'Dr' End) as Tran_Amount from Daily_Transaction_table where Account_no='"+devId+"' and to_char(branch)='"+mon+"' and Transaction_Date between to_date('"+val1+"','dd/MM/yyyy') and to_date('"+val2+"','dd/MM/yyyy'))a order by a.Transaction_Date desc,to_number(substr(to_char(a.Transaction_Id),-5,5)) desc";
		String QueryString="SELECT  a.Transaction_Id,a.Part_Tran_Id,a.Tran_Date,a.Transaction_Particulars as Transaction_Particulars,a.Tran_Amount FROM (Select to_char(Transaction_Date,'dd/MM/yyyy') as Tran_Date, to_char(Transaction_Id) as Transaction_Id,to_char(Part_Tran_Id) as Part_Tran_Id,Transaction_Date,substr(Transaction_Particulars,1,10) as Transaction_Particulars,to_char(Transaction_Amount ||' '||case when Transaction_Type='Credit' then 'Cr' else 'Dr' End) as Tran_Amount from Daily_Transaction_table where Account_no='"+devId+"' and to_char(branch)='"+mon+"' and Transaction_Date between to_date('"+val1+"','MM/dd/yyyy') and to_date('"+val2+"','MM/dd/yyyy'))a order by a.Transaction_Date desc,to_number(substr(to_char(a.Transaction_Id),-5,5)) desc";
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

					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn1 = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:xe",
							"dbuser1", "dbpwd1");
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
			     	
			         Class.forName("oracle.jdbc.driver.OracleDriver");
			        conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dbuser1", "dbpwd1");
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
			     	
			         Class.forName("oracle.jdbc.driver.OracleDriver");
			        conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dbuser1", "dbpwd1");
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

