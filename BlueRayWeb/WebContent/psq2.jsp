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
					"jdbc:oracle:thin:@localhost:1521:xe", "dbuser1","dbpwd1");
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
					conn1 = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.60:1521:xe","dbuseruat", "Fin2525#");
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



			else {
				out.println("Enter Valid Type");
			}
		response.setContentType("application/json"); 
	%>

