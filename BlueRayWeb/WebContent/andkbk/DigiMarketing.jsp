f<%@ page import="java.sql.*" %>
 <%@page import="java.io.*"%>
<HTML>
<HEAD>
<TITLE>Simple JSP to Oracle connection Example</TITLE>
</HEAD>
<BODY>
<%
    Connection conn = null;
    try
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbsnknl", "dbpwdsnknl");
        out.println("connected....!!");

    }

    catch(Exception e)
    {
        out.println("Exception : " + e.getMessage() + "");
    }
%>
<%
if (request.getParameter("type") == null) {
    out.println("Please enter your type.");
}
else
{
int no = Integer.parseInt(request.getParameter("type"));
  /* if(no == 1){
        out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
        
        //accno
         String devId =request.getParameter("did");//Request.QueryString["did"].ToString();
       //  out.println("devId= <b>"+devId);
          String Uname=null;
  		 	String Pword=null;
      	
       Connection conn1 = null;
       Statement statement = null;
       ResultSet rs = null;
       try
       {
       	
           Class.forName("oracle.jdbc.driver.OracleDriver");
          
		     conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbsnknl", "dbpwdsnknl");
           out.println("connected....!!");
           statement = conn1.createStatement();
           out.println("createStatement....!!");
        // sql query to retrieve values from the secified table.
        String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
        out.println(QueryString);
        rs = statement.executeQuery(QueryString);
        
        out.println("excecute Qry....!!");
        
        while (rs.next()) {
        	 out.println("inside While!!");
       	 Uname=rs.getString(1);
       	 Pword=rs.getString(2);
        }
        conn1.close();
       }
       catch(Exception e)
       {
           out.println("Exception : " + e.getMessage() + "");
       }
       
       Connection conn2 = null;
       Statement statement2 = null;
       ResultSet rs2 = null;
       String output = "";
       try
       {
       	
           Class.forName("oracle.jdbc.driver.OracleDriver");
          conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", Uname, Pword);
           out.println("Particlar DBconnected....!!");
         
           statement2 = conn2.createStatement();
    
		//           String query = "select  * from DS_table where ";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 1 AND 150";
	   
            rs2 = statement2.executeQuery(query);
           
            //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
          int i=0;
           while (rs2.next()) 
           {
		String ShrtName ="";
		//if(i<=205)
		{
        	   out.println(rs2.getString("Name"));
		   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                   
        	   output=output+rs2.getInt("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
		   
	 	   

		}

		i++;
          }
         
           out.println("Output Send ....!!="+output);
       
        conn2.close();
       }
       catch(Exception e)
       {
           out.println("Exception : " + e.getMessage() + "");
       }

        
       String[] separated = output.split(",");
       out.println("Output lst ....!!="+output);


       response.addHeader("AustinAndroidReturn", output);
       out.println("Output 2nd ....!!="+output);
        
        
    }
else if(no == 99){
        out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
        
        //accno
         String devId =request.getParameter("did");//Request.QueryString["did"].ToString();
       //  out.println("devId= <b>"+devId);
          String Uname=null;
  		 	String Pword=null;
      	
       Connection conn1 = null;
       Statement statement = null;
       ResultSet rs = null;
       try
       {
       	
           Class.forName("oracle.jdbc.driver.OracleDriver");
          conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbsnknl", "dbpwdsnknl");
           out.println("connected....!!");
           statement = conn1.createStatement();
           out.println("createStatement....!!");
        // sql query to retrieve values from the secified table.
        String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
        out.println(QueryString);
        rs = statement.executeQuery(QueryString);
        
        out.println("excecute Qry....!!");
        
        while (rs.next()) {
        	 out.println("inside While!!");
       	 Uname=rs.getString(1);
       	 Pword=rs.getString(2);
        }
        conn1.close();
       }
       catch(Exception e)
       {
           out.println("Exception : " + e.getMessage() + "");
       }
       
       Connection conn2 = null;
       Statement statement2 = null;
       ResultSet rs2 = null;
       String output = "";
       try
       {
       	
           Class.forName("oracle.jdbc.driver.OracleDriver");
          conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", Uname, Pword);
           out.println("Particlar DBconnected....!!");
         
           statement2 = conn2.createStatement();
    
           //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 151 AND 300";
            rs2 = statement2.executeQuery(query);
           
            //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
          int i=0;
           while (rs2.next()) 
           {
		String ShrtName ="";
		//if(i<=205)
		{
        	   out.println(rs2.getString("Name"));
		   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                    
        	   output=output+rs2.getInt("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
		  
	 	  
	 	   

		}

		i++;
          }
         
           out.println("Output Send ....!!="+output);
       
        conn2.close();
       }
       catch(Exception e)
       {
           out.println("Exception : " + e.getMessage() + "");
       }

        
       String[] separated = output.split(",");
       out.println("Output lst ....!!="+output);


       response.addHeader("AustinAndroidReturn", output);
       out.println("Output 2nd ....!!="+output);
        
        
    }
else if(no == 98){
        out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
        
        //accno
         String devId =request.getParameter("did");//Request.QueryString["did"].ToString();
       //  out.println("devId= <b>"+devId);
          String Uname=null;
  		 	String Pword=null;
      	
       Connection conn1 = null;
       Statement statement = null;
       ResultSet rs = null;
       try
       {
       	
           Class.forName("oracle.jdbc.driver.OracleDriver");
          conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbsnknl", "dbpwdsnknl");
           out.println("connected....!!");
           statement = conn1.createStatement();
           out.println("createStatement....!!");
        // sql query to retrieve values from the secified table.
        String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
        out.println(QueryString);
        rs = statement.executeQuery(QueryString);
        
        out.println("excecute Qry....!!");
        
        while (rs.next()) {
        	 out.println("inside While!!");
       	 Uname=rs.getString(1);
       	 Pword=rs.getString(2);
        }
        conn1.close();
       }
       catch(Exception e)
       {
           out.println("Exception : " + e.getMessage() + "");
       }
       
       Connection conn2 = null;
       Statement statement2 = null;
       ResultSet rs2 = null;
       String output = "";
       try
       {
       	
           Class.forName("oracle.jdbc.driver.OracleDriver");
          conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", Uname, Pword);
           out.println("Particlar DBconnected....!!");
         
           statement2 = conn2.createStatement();
    
           //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 301 AND 450";
            rs2 = statement2.executeQuery(query);
           
            //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
          int i=0;
           while (rs2.next()) 
           {
		String ShrtName ="";
		//if(i<=205)
		{
        	   out.println(rs2.getString("Name"));
		   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                    
        	   output=output+rs2.getInt("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
		  
	 	  
	 	   

		}

		i++;
          }
         
           out.println("Output Send ....!!="+output);
       
        conn2.close();
       }
       catch(Exception e)
       {
           out.println("Exception : " + e.getMessage() + "");
       }

        
       String[] separated = output.split(",");
       out.println("Output lst ....!!="+output);


       response.addHeader("AustinAndroidReturn", output);
       out.println("Output 2nd ....!!="+output);
        
        
    }

    else*/ if(no == 2){
        out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
 
        
        //accno
         //float ClAmt=Float.parseFloat(request.getParameter("Collected"));
		// int Acc_No=Integer.parseInt(request.getParameter("Accountno"));
      
       // int id = Integer.parseInt(request.getParameter("id"));
        //float collectAmt =ClAmt;//.replace("Rs.", "");// Request.QueryString["Collected"].ToString().Replace("Rs.","");
        
        /* Dg_Cus
       String dgid= request.getParameter("dgid");//Request.QueryString["Dt"].ToString();
      String address=request.getParameter("address");//Request.QueryString["did"].ToString();
      String personal= request.getParameter("personal");//Request.QueryString["uid"].ToString();
      String filename1 = request.getParameter("filename1");//Request.QueryString["Tm"].ToString();
      String filename2 = request.getParameter("filename2");//Request.QueryString["Tm"].ToString();

	String user1= request.getParameter("user1");//Request.QueryString["Tm"].ToString();
	String currentdate= request.getParameter("currentdate");//Request.QueryString["Tm"].ToString();
	String dg_status= request.getParameter("dg_status");//Request.QueryString["Tm"].ToString();
	String ast= request.getParameter("ast");//Request.QueryString["Tm"].ToString();
	  out.println("address....!!"+address);   */
	  
	    //Dg_ROI
      String scheme= request.getParameter("scheme");//Request.QueryString["Dt"].ToString();
     String period=request.getParameter("period");//Request.QueryString["did"].ToString();
     String type= request.getParameter("type");//Request.QueryString["uid"].ToString();
     String roi = request.getParameter("roi");//Request.QueryString["Tm"].ToString();
     String sr_roi = request.getParameter("sr_roi");//Request.QueryString["Tm"].ToString();
     String ssr_roi = request.getParameter("ssr_roi");//Request.QueryString["Tm"].ToString();
	String status= request.getParameter("status");//Request.QueryString["Tm"].ToString();
	 String comp = request.getParameter("comp");//Request.QueryString["Tm"].ToString();
		String scode= request.getParameter("scode");//Request.QueryString["Tm"].ToString();
		
	
	  
	  
	  
	  
    
       
        Connection conn1 = null;
        Connection conn2 = null;
        Statement statement = null;
        ResultSet rs = null;
        try
        {
        	
            Class.forName("oracle.jdbc.driver.OracleDriver");
           conn1 = DriverManager.getConnection("jdbc:oracle:thin:@103.48.180.117:4547:xe", "dbsnknl", "dbpwdsnknl");
            out.println("connected....!!");
            statement = conn1.createStatement();
          //  String query = "insert into Dg_Customer(DG_MEMBER_ID,ADDRESS,PERSONAL,FILE_NAME1,FILE_NAME2,USER1,DG_STATUS,APPROVAL_STATUS,Currentdate) values('"+dgid+"','"+address+"','"+personal+"','"+filename1+"','"+filename2+"','"+user1+"','"+dg_status+"','"+ast+"','"+currentdate+"')";
            String query = "insert into Dg_ROI(SCHEME,PERIOD,TYPE,ROI,SR_ROI,SSR_ROI,STATUS,Compounding,Scheme_code) values('"+scheme+"','"+period+"','"+type+"','"+roi+"','"+sr_roi+"','"+ssr_roi+"','"+status+"','"+comp+"','"+scode+"')";

           // String query = "insert into Dg_Customer(DG_MEMBER_ID) values('"+dgid+"')";
            PreparedStatement ps = conn1.prepareStatement(query);
            ps.executeUpdate();  
            out.println("Inserted....!!");
        
         conn1.close();
        }
        catch(Exception e)
        {
            out.println("Exception : " + e.getMessage() + "");
        }
        
        /*
        try
        {
        	
            Class.forName("oracle.jdbc.driver.OracleDriver");
           conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", Uname, Pword);
            out.println("Particlar DBconnected....!!");
            statement = conn2.createStatement();
     
            String query = "update DS_table set Collected_Amt='" + collectAmt + "',Collected_Date=to_date('" + collectDt + "','yyyyMMdd'),device_id='" + devId + "',UserId='" + userId + "',timeofentry='" + Tm + "' where Account_No=" + accno + "";
            PreparedStatement ps = conn2.prepareStatement(query);
            ps.executeUpdate();  
            out.println("Updated...12.!!");
        //http://103.48.180.117:4545/Snnl_And/Default.jsp?type=2&Accountno=2050200049&Collected=362&Dt=20180330&did=71d711103940606b&uid=testuser&Tm=13:21:16
            
           
           // String query2 = "insert into testtable1 values('s')";
         //  PreparedStatement ps2 = conn2.prepareStatement(query2);
          // ps2.executeUpdate();  
        
            
            
            
         conn2.close();
        }
        catch(Exception e)
        {
            out.println("Exception : " + e.getMessage() + "");
        }*/

    }
    else if(no == 21){
        out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
 
        
        //accno
         //float ClAmt=Float.parseFloat(request.getParameter("Collected"));
		// int Acc_No=Integer.parseInt(request.getParameter("Accountno"));
      
       // int id = Integer.parseInt(request.getParameter("id"));
        //float collectAmt =ClAmt;//.replace("Rs.", "");// Request.QueryString["Collected"].ToString().Replace("Rs.","");
        
        // Dg_Cus
       String dgid= request.getParameter("dgid");//Request.QueryString["Dt"].ToString();
      String address=request.getParameter("address");//Request.QueryString["did"].ToString();
      String personal= request.getParameter("personal");//Request.QueryString["uid"].ToString();
      String filename1 = request.getParameter("filename1");//Request.QueryString["Tm"].ToString();
      String filename2 = request.getParameter("filename2");//Request.QueryString["Tm"].ToString();

	String user1= request.getParameter("user1");//Request.QueryString["Tm"].ToString();
	String currentdate= request.getParameter("currentdate");//Request.QueryString["Tm"].ToString();
	String dg_status= request.getParameter("dg_status");//Request.QueryString["Tm"].ToString();
	String ast= request.getParameter("ast");//Request.QueryString["Tm"].ToString();
	String b= request.getParameter("b");//Request.QueryString["Tm"].ToString();
	
	String Bcode="";
	if(b.equalsIgnoreCase("1"))
	{
		Bcode="201";
	}
	else if(b.equalsIgnoreCase("2"))
	{
		Bcode="202";
	}
	else if(b.equalsIgnoreCase("3"))
	{
		Bcode="203";
	}
	else if(b.equalsIgnoreCase("4"))
	{
		Bcode="204";
	}
	else if(b.equalsIgnoreCase("5"))
	{
		Bcode="205";
	}
	else if(b.equalsIgnoreCase("6"))
	{
		Bcode="207";
	}
	else if(b.equalsIgnoreCase("7"))
	{
		Bcode="208";
	}
	else if(b.equalsIgnoreCase("8"))
	{
		Bcode="209";
	}
	else if(b.equalsIgnoreCase("9"))
	{
		Bcode="210";
	}
	else if(b.equalsIgnoreCase("10"))
	{
		Bcode="211";
	}
else if(b.equalsIgnoreCase("11"))
	{
		Bcode="212";
	}
else if(b.equalsIgnoreCase("12"))
	{
		Bcode="213";
	}
else if(b.equalsIgnoreCase("13"))
{
	Bcode="214";
}
else if(b.equalsIgnoreCase("14"))
{
	Bcode="215";
}
else if(b.equalsIgnoreCase("15"))
{
	Bcode="216";
}

else if(b.equalsIgnoreCase("16"))
{
	Bcode="217";
}


else 	{
		Bcode="216";
	}


	  out.println("address....!!"+address);   
	  
	    /*Dg_ROI
      String scheme= request.getParameter("scheme");//Request.QueryString["Dt"].ToString();
     String period=request.getParameter("period");//Request.QueryString["did"].ToString();
     String type= request.getParameter("type");//Request.QueryString["uid"].ToString();
     String roi = request.getParameter("roi");//Request.QueryString["Tm"].ToString();
     String sr_roi = request.getParameter("sr_roi");//Request.QueryString["Tm"].ToString();
     String ssr_roi = request.getParameter("ssr_roi");//Request.QueryString["Tm"].ToString();
	String status= request.getParameter("status");//Request.QueryString["Tm"].ToString();
	 String comp = request.getParameter("comp");//Request.QueryString["Tm"].ToString();
		String scode= request.getParameter("scode");//Request.QueryString["Tm"].ToString();
		*/
	
	  
	  
	  
	  
    
       
        Connection conn1 = null;
        Connection conn2 = null;
        Statement statement = null;
        ResultSet rs = null;
        try
        {
        	
            Class.forName("oracle.jdbc.driver.OracleDriver");
           conn1 = DriverManager.getConnection("jdbc:oracle:thin:@103.48.180.117:4547:xe", "dbsnknl", "dbpwdsnknl");
            out.println("connected....!!");
            statement = conn1.createStatement();
            String query = "insert into Dg_Customer(DG_MEMBER_ID,ADDRESS,PERSONAL,FILE_NAME1,FILE_NAME2,USER1,DG_STATUS,APPROVAL_STATUS,Currentdate,Bcode) values('"+dgid+"','"+address+"','"+personal+"','"+filename1+"','"+filename2+"','"+user1+"','"+dg_status+"','"+ast+"','"+currentdate+"','"+Bcode+"')";
           // String query = "insert into Dg_ROI(SCHEME,PERIOD,TYPE,ROI,SR_ROI,SSR_ROI,STATUS,Compounding,Scheme_code) values('"+scheme+"','"+period+"','"+type+"','"+roi+"','"+sr_roi+"','"+ssr_roi+"','"+status+"','"+comp+"','"+scode+"')";

           // String query = "insert into Dg_Customer(DG_MEMBER_ID) values('"+dgid+"')";
            PreparedStatement ps = conn1.prepareStatement(query);
            ps.executeUpdate();  
            out.println("Inserted....!!");
        
         conn1.close();
        }
        catch(Exception e)
        {
            out.println("Exception : " + e.getMessage() + "");
        }
        
        /*
        try
        {
        	
            Class.forName("oracle.jdbc.driver.OracleDriver");
           conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", Uname, Pword);
            out.println("Particlar DBconnected....!!");
            statement = conn2.createStatement();
     
            String query = "update DS_table set Collected_Amt='" + collectAmt + "',Collected_Date=to_date('" + collectDt + "','yyyyMMdd'),device_id='" + devId + "',UserId='" + userId + "',timeofentry='" + Tm + "' where Account_No=" + accno + "";
            PreparedStatement ps = conn2.prepareStatement(query);
            ps.executeUpdate();  
            out.println("Updated...12.!!");
        //http://103.48.180.117:4545/Snnl_And/Default.jsp?type=2&Accountno=2050200049&Collected=362&Dt=20180330&did=71d711103940606b&uid=testuser&Tm=13:21:16
            
           
           // String query2 = "insert into testtable1 values('s')";
         //  PreparedStatement ps2 = conn2.prepareStatement(query2);
          // ps2.executeUpdate();  
        
            
            
            
         conn2.close();
        }
        catch(Exception e)
        {
            out.println("Exception : " + e.getMessage() + "");
        }*/

    }
  
    else if(no == 34){
    	
    	
    	
    	
    	 
        String output = "";
        //23.02.16
        String resp =request.getParameter("fullstring");///Request.QueryString["fullstring"].ToString();
        String address =request.getParameter("addr");///Request.QueryString["fullstring"].ToString();
        String personal =request.getParameter("per");///Request.QueryString["fullstring"].ToString();
        String filename1 =request.getParameter("id2");///Request.QueryString["fullstring"].ToString();
        String filename2 =request.getParameter("id1");///Request.QueryString["fullstring"].ToString();
	 
        String devIdt =request.getParameter("did");///Request.QueryString["did"].ToString();
        String user1 =request.getParameter("uid");///Request.QueryString["did"].ToString();
        String Tm = request.getParameter("Tm");///Request.QueryString["Tm"].ToString();
        
        String filename3 =request.getParameter("id3");
        
        String mem_type="E";
        int add=address.length();
 
        if(add>0)
        {
        	 mem_type="N";
        }
       
         
 		String Current=Tm.substring(6, 8)+"/"+Tm.substring(4, 6)+"/"+Tm.substring(0, 4);

		
        out.println("fullString : " +resp);
        

      
         String Uname="dbsnknl";
    	String Pword="dbpwdsnknl";
        
         Connection conn1 = null;
        Connection conn2 = null;
        Statement statement = null;
        ResultSet rs = null;
      
    	out.println("resp="+resp);
        
        	String IndRecord=resp;
        	  out.println("IndRecord="+IndRecord);
        	String[] ds = IndRecord.split("-");
        	out.println("ds.length="+ds.length);
            String dgid= ds[0];
        	String MemName=ds[1];
              	String b= ds[2];
            	
            	 String dg_status = "Y";
     	
     	
     	String Bcode="";
     	if(b.equalsIgnoreCase("1"))
     	{
     		Bcode="201";
     	}
     	else if(b.equalsIgnoreCase("2"))
     	{
     		Bcode="202";
     	}
     	else if(b.equalsIgnoreCase("3"))
     	{
     		Bcode="203";
     	}
     	else if(b.equalsIgnoreCase("4"))
     	{
     		Bcode="204";
     	}
     	else if(b.equalsIgnoreCase("5"))
     	{
     		Bcode="205";
     	}
     	else if(b.equalsIgnoreCase("6"))
     	{
     		Bcode="207";
     	}
     	else if(b.equalsIgnoreCase("7"))
     	{
     		Bcode="208";
     	}
     	else if(b.equalsIgnoreCase("8"))
     	{
     		Bcode="209";
     	}
     	else if(b.equalsIgnoreCase("9"))
     	{
     		Bcode="210";
     	}
else if(b.equalsIgnoreCase("10"))
     	{
     		Bcode="211";
     	}
else if(b.equalsIgnoreCase("11"))
     	{
     		Bcode="212";
     	}

else if(b.equalsIgnoreCase("12"))
     	{
     		Bcode="213";
     	}
else if(b.equalsIgnoreCase("13"))
	{
		Bcode="214";
	}
else if(b.equalsIgnoreCase("14"))
	{
		Bcode="215";
	}
else if(b.equalsIgnoreCase("15"))
	{
		Bcode="216";
	}
else if(b.equalsIgnoreCase("16"))
	{
		Bcode="217";
	}


else {
     		Bcode="213";
     	}



     	
        	
           

            	
            	 try
             {
        	
            Class.forName("oracle.jdbc.driver.OracleDriver");
           conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", Uname, Pword);
            out.println("Particlar DBconnected....!!");
            statement = conn2.createStatement();
            
            
            
            String query = "insert into Dg_Customer(DG_MEMBER_ID,ADDRESS,PERSONAL,FILE_NAME1,FILE_NAME2,USER1,DG_STATUS,APPROVAL_STATUS,Bcode,CUSTOMER_NAME,DATETIMESYN,DEVICE_ID,CUSTTYPE,FILE_NAME3,CURRENTDATE)            									values('"+dgid+"','"+address+"','"+personal+"','"+filename1+"','"+filename2+"','"+user1+"','"+dg_status+"','N','"+Bcode+"','"+MemName+"','"+Tm+"','"+devIdt+"','"+mem_type+"','"+filename3+"',to_date('"+Current+"','dd/MM/yyyy'))";
            out.println("Particlar DBconnected....!!"+query);
             
            PreparedStatement ps = conn2.prepareStatement(query);
          
            ps.executeUpdate();  
        
            out.println("Updated....!!");
        
         conn2.close();
        }
        catch(Exception e)
        {
            out.println("Exception : " + e.getMessage() + "");
        }	
            		

          //  SqlConnection conn = new SqlConnection(connString);
            //accountno, collected_amt, date SqlConnection conn = new SqlConnection(connString);
           // SqlCommand cmd = new SqlCommand(query, conn);
           // conn.Open();
            //-//File.WriteAllText(Server.MapPath("~/dataconn.txt"), connString);
          //  cmd.ExecuteNonQuery();
          //  conn.Close();
            output += dgid + ",";
            
        //}
        response.addHeader("VectorFExp", output);
        

        //http://117.218.250.206:93/default.aspx?type=3&fullstring=2010200094%7C33%7C20150730%7C150730%231-&did=9a6253803c966e2e&uid=testuser&Tm=18:40:47
        //split with , first
        //for i=0 to i<splitarry
        //split with ^
        //you will get accno
        //call update
        //returnn all the receiptnos back 
        //output = receipt1,2,3
        //Response.AddHeader("AustinAndroidReturn", output);

       
    }
    else if(no == 3){
     	
   	 //00//string connString = @"Data Source=WINDOWS-3YYCEIU;Initial Catalog=NTBF;UId=sa;Pwd=pisquare";
       //string connString = @"Data Source=117.218.250.206;Initial Catalog=NTBF;UId=sa;Pwd=pisquare";
       //string connString = @"Data Source=TEST\NEW;Initial Catalog=NTBF;UId=sa;Pwd=pisquare";
       //string connString = @"Data Source=TEST\NEW;Initial Catalog=NTBF;UId=sa;Pwd=pisquare";
       String output = "";
       //23.02.16
       String resp =request.getParameter("fullstring");///Request.QueryString["fullstring"].ToString();
       String devIdt =request.getParameter("did");///Request.QueryString["did"].ToString();
       String userid =request.getParameter("userid");
       
      // http://122.165.236.72:89/default.aspx?type=24&fullstring=memid^shares^ratepershare^amount^mode^bankname^chqno^chqdate&did=android_id&userid=uid
      //http://103.48.180.117:3700/Snnl_And/DigiMarketing2.jsp?type=3&fullstring=102020-2-10-20-bank-CUB-124512-01052018&did=android_id&userid=Pisquare
        
       
       out.println("fullString : " +resp);
           String Uname="dbsnknl";
   	String Pword="dbpwdsnknl";
       
        Connection conn1 = null;
       Connection conn2 = null;
       Statement statement = null;
       ResultSet rs = null;
      /* try
       {
       	
           Class.forName("oracle.jdbc.driver.OracleDriver");
          conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbsnknl", "dbpwdsnknl");
           out.println("connected....!!");
           statement = conn1.createStatement();
    
        // sql query to retrieve values from the secified table.
        String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devIdt+"'";
        rs = statement.executeQuery(QueryString);
        while (rs.next()) {
       	 Uname=rs.getString(1);
       	 Pword=rs.getString(2);
        }
        conn1.close();
       }
       catch(Exception e)
       {
           out.println("Exception : " + e.getMessage() + "");
       }
       */
   	
      
   	//out.println("Uname="+Uname);
   	//out.println("Pword="+Pword);
   	out.println("resp="+resp);
       String[] rcpt = resp.split(",");
      
       out.println("rcpt.length="+rcpt.length);
       out.println("rcpt[0]="+rcpt[0]);
       
       String memid=null;
       int shares=0;
       int ratepershare=0;
       int amount=0;
       String mode=null;
       String bankname=null;
       String chqno=null;
       String chqdate=null;
       for (int i = 0; i < rcpt.length; i++)
       {
       	String IndRecord=rcpt[i];
       	  out.println("IndRecord="+IndRecord);
       String[] ds = IndRecord.split("-");
       	//out.println("ds.length="+ds.length);
       	
       	 memid = ds[0];
       	 shares = Integer.parseInt(ds[1]);
       	 ratepershare = Integer.parseInt(ds[2]);
       	 amount = Integer.parseInt(ds[3]);
       	
       	 mode = ds[4];
       	 bankname = ds[5];
       	 chqno = ds[6];
       	 chqdate = ds[7];
       	 
       	 int c=0;
       	 String b="";
       	 int b2=0;
       	 
       	 try
            {
       	
           Class.forName("oracle.jdbc.driver.OracleDriver");
          conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", Uname, Pword);
           out.println("Particlar DBconnected....!!");
           statement = conn2.createStatement();
           
      
          // String query = "insert into Dg_Share_Master(DG_MEMBER_ID,NO_OF_SHARES,SHARE_VALUE,SHARE_AMOUNT,MODE_OF_OPERATION,BANKNAME,CHEQUENO,CHECK_DATE,USERID,DG_STATUS,APPROVAL_STATUS) values('"+memid+"',"+shares+","+ratepershare+","+amount+",'"+mode+"','"+bankname+"','"+chqno+"','"+chqdate+"' ,"+userid+"','Y','N')";
          // String query = "insert into Dg_Share_Master(DG_MEMBER_ID,NO_OF_SHARES,SHARE_VALUE,SHARE_AMOUNT,MODE_OF_OPERATION) values('"+memid+"',"+shares+","+ratepershare+","+amount+",'"+mode+"')";
           String query = "select count(*) from Dg_Share_Master where DG_MEMBER_ID='"+memid+"'";
           String query2="select BCODE from DG_Customer where DG_MEMBER_ID='"+memid+"'";

          // String query = "insert into Dg_Customer(DG_MEMBER_ID) values('"+dgid+"')";
           PreparedStatement ps = conn2.prepareStatement(query);
           PreparedStatement ps2 = conn2.prepareStatement(query2);
               
           ResultSet resultSet = ps.executeQuery();
           ResultSet resultSet2 = ps2.executeQuery();
           if (resultSet!= null) {
				  while (resultSet.next()) {
					  c=resultSet.getInt(1);
				  }
           }
           out.println("Inserted.2...!!");   
           output=output+memid+",";
         
           
           if (resultSet2!= null) {
				  while (resultSet2.next()) {
					  b=resultSet2.getString(1);
					 // b2=Integer.parseInt(b);
				  }
           }
       
        conn2.close();
       }
       catch(Exception e)
       {
           out.println("Exception : " + e.getMessage() + "");
       }	
       	if(c==0)
       	{
        	 try
            {
       	
           Class.forName("oracle.jdbc.driver.OracleDriver");
          conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", Uname, Pword);
           out.println("Particlar DBconnected....!!");
           statement = conn2.createStatement();
           
       
          // String query = "insert into Dg_Share_Master(DG_MEMBER_ID,NO_OF_SHARES,SHARE_VALUE,SHARE_AMOUNT,MODE_OF_OPERATION,BANKNAME,CHEQUENO,CHECK_DATE,USERID,DG_STATUS,APPROVAL_STATUS) values('"+memid+"',"+shares+","+ratepershare+","+amount+",'"+mode+"','"+bankname+"','"+chqno+"','"+chqdate+"' ,"+userid+"','Y','N')";
          // String query = "insert into Dg_Share_Master(DG_MEMBER_ID,NO_OF_SHARES,SHARE_VALUE,SHARE_AMOUNT,MODE_OF_OPERATION) values('"+memid+"',"+shares+","+ratepershare+","+amount+",'"+mode+"')";
           String query = "insert into Dg_Share_Master(DG_MEMBER_ID,NO_OF_SHARES,SHARE_VALUE,SHARE_AMOUNT,MODE_OF_OPERATION,BANKNAME,CHEQUENO,CHECK_DATE,USERID,DG_STATUS,APPROVAL_STATUS,BCODE) values('"+memid+"',"+shares+","+ratepershare+","+amount+",'"+mode+"','"+bankname+"','"+chqno+"','"+chqdate+"' ,'"+userid+"','Y','N','"+b+"')";

          // String query = "insert into Dg_Customer(DG_MEMBER_ID) values('"+dgid+"')";
           PreparedStatement ps = conn2.prepareStatement(query);
           ps.executeUpdate();  
           out.println("Inserted.2...!!");   
           output=output+memid+",";
        
       
        conn2.close();
       }
       catch(Exception e)
       {
           out.println("Exception : " + e.getMessage() + "");
       }	
       	}
       	else
       	{
       	//-  output=output+memid+",";
       	}

       }   
       
       
       
       response.addHeader("VectorFExp", output);
   	
       
          
           		

         //  SqlConnection conn = new SqlConnection(connString);
           //accountno, collected_amt, date SqlConnection conn = new SqlConnection(connString);
          // SqlCommand cmd = new SqlCommand(query, conn);
          // conn.Open();
           //-//File.WriteAllText(Server.MapPath("~/dataconn.txt"), connString);
         //  cmd.ExecuteNonQuery();
         //  conn.Close();
          
  
      
   }
    else if(no == 5){
        out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
        
       
      //  String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
        String Uname=null;
		 	String Pword=null;
    
     Connection conn1 = null;
     Statement statement = null;
     ResultSet rs = null;
   /*  try
     {
     	
         Class.forName("oracle.jdbc.driver.OracleDriver");
        conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbsnknl", "dbpwdsnknl");
         out.println("connected....!!");
         statement = conn1.createStatement();
  
      // sql query to retrieve values from the secified table.
      String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
      rs = statement.executeQuery(QueryString);
      while (rs.next()) {
     	 Uname=rs.getString(1);
     	 Pword=rs.getString(2);
      }
      conn1.close();
     }
     catch(Exception e)
     {
         out.println("Exception : " + e.getMessage() + "");
     }*/
     
     Connection conn2 = null;
     Statement statement2 = null;
     ResultSet rs2 = null;
     String output = "";
     try
     {
     	
         Class.forName("oracle.jdbc.driver.OracleDriver");
        conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl","dbsnknl", "dbpwdsnknl");
         out.println("Particlar DBconnected....!!");
       //  out.println("Uname....!!"+Uname);
       //  out.println("Pword!"+Pword);
         statement2 = conn2.createStatement();
  
        // String query = "SELECT * FROM Dg_Customer";
         String query = "SELECT * FROM Dg_ROI";
          rs2 = statement2.executeQuery(query);
         
          //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
         int i=1;
         while (rs2.next()) 
         {
        	 out.println("while!");
            // if (rs2.getInt("Account_No") != 2010200242 || rs2.getInt("Account_No") != 2010200261 || rs2.getInt("Account_No") != 2010200270)
		  i++;
      	  // output=output+i+"^"+rs2.getString("DG_MEMBER_ID")+ "^" + rs2.getString("ADDRESS") + "^" + rs2.getString("PERSONAL") + "^" + rs2.getString("FILE_NAME1") + "^" + rs2.getString("FILE_NAME2")+ "^" + rs2.getString("USER1")+ "^" + rs2.getString("CURRENTDATE")+rs2.getString("DG_STATUS")+ "^" +rs2.getString("APPROVAL_STATUS")+",";
	   output=output+i+"^"+rs2.getString("SCHEME") + "^" + rs2.getString("PERIOD") + "^" + rs2.getString("TYPE") + "^" + rs2.getString("ROI")+ "^" + rs2.getString("SR_ROI")+ "^" + rs2.getString("SSR_ROI")+ "^" + rs2.getString("COMPOUNDING")+",";  

        	}
     
         out.println("Output Send ....!!="+output);
     
      conn2.close();
     }
     
     catch(Exception e)
     {
         out.println("Exception : " + e.getMessage() + "");
     }

     /* 
     String[] separated = output.split(",");
     
     for (int j = 0; j < separated.length; j++)
     {
		 out.println("Mini Statement="+separated[j]);
     }*/

     response.addHeader("VectorFExp", output);
      
       
    }
    else if(no == 51){
        out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
        
       
      //  String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
        String Uname=null;
		 	String Pword=null;
    
     Connection conn1 = null;
     Statement statement = null;
     ResultSet rs = null;
   /*  try
     {
     	
         Class.forName("oracle.jdbc.driver.OracleDriver");
        conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbsnknl", "dbpwdsnknl");
         out.println("connected....!!");
         statement = conn1.createStatement();
  
      // sql query to retrieve values from the secified table.
      String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
      rs = statement.executeQuery(QueryString);
      while (rs.next()) {
     	 Uname=rs.getString(1);
     	 Pword=rs.getString(2);
      }
      conn1.close();
     }
     catch(Exception e)
     {
         out.println("Exception : " + e.getMessage() + "");
     }*/
     
     Connection conn2 = null;
     Statement statement2 = null;
     ResultSet rs2 = null;
     String output = "";
     try
     {
     	
         Class.forName("oracle.jdbc.driver.OracleDriver");
        conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl","dbsnknl", "dbpwdsnknl");
         out.println("Particlar DBconnected....!!");
       //  out.println("Uname....!!"+Uname);
       //  out.println("Pword!"+Pword);
         statement2 = conn2.createStatement();
  
         String query = "SELECT * FROM Dg_Customer";
        // String query = "SELECT * FROM Dg_ROI";
          rs2 = statement2.executeQuery(query);
         
          //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
         int i=1;
         while (rs2.next()) 
         {
        	 out.println("while!");
            // if (rs2.getInt("Account_No") != 2010200242 || rs2.getInt("Account_No") != 2010200261 || rs2.getInt("Account_No") != 2010200270)
		  i++;
      	  output=output+i+"^"+rs2.getString("DG_MEMBER_ID")+ "^" + rs2.getString("ADDRESS") + "^" + rs2.getString("PERSONAL") + "^" + rs2.getString("FILE_NAME1") + "^" + rs2.getString("FILE_NAME2")+ "^" + rs2.getString("USER1")+ "^" + rs2.getString("CURRENTDATE")+rs2.getString("DG_STATUS")+ "^" +rs2.getString("APPROVAL_STATUS")+",";
	   //output=output+i+"^"+rs2.getString("SCHEME") + "^" + rs2.getString("PERIOD") + "^" + rs2.getString("TYPE") + "^" + rs2.getString("ROI")+ "^" + rs2.getString("SR_ROI")+ "^" + rs2.getString("SSR_ROI")+ rs2.getString("COMPOUNDING")+",";  

        	}
     
         out.println("Output Send ....!!="+output);
     
      conn2.close();
     }
     
     catch(Exception e)
     {
         out.println("Exception : " + e.getMessage() + "");
     }

     /* 
     String[] separated = output.split(",");
     
     for (int j = 0; j < separated.length; j++)
     {
		 out.println("Mini Statement="+separated[j]);
     }*/

     response.addHeader("VectorFExp", output);
      
       
    }
    else if(no == 5){
        out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
        
       
      //  String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
        String Uname=null;
		 	String Pword=null;
    
     Connection conn1 = null;
     Statement statement = null;
     ResultSet rs = null;
   /*  try
     {
     	
         Class.forName("oracle.jdbc.driver.OracleDriver");
        conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbsnknl", "dbpwdsnknl");
         out.println("connected....!!");
         statement = conn1.createStatement();
  
      // sql query to retrieve values from the secified table.
      String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
      rs = statement.executeQuery(QueryString);
      while (rs.next()) {
     	 Uname=rs.getString(1);
     	 Pword=rs.getString(2);
      }
      conn1.close();
     }
     catch(Exception e)
     {
         out.println("Exception : " + e.getMessage() + "");
     }*/
     
     Connection conn2 = null;
     Statement statement2 = null;
     ResultSet rs2 = null;
     String output = "";
     try
     {
     	
         Class.forName("oracle.jdbc.driver.OracleDriver");
        conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl","dbsnknl", "dbpwdsnknl");
         out.println("Particlar DBconnected....!!");
       //  out.println("Uname....!!"+Uname);
       //  out.println("Pword!"+Pword);
         statement2 = conn2.createStatement();
  
        // String query = "SELECT * FROM Dg_Customer";
         String query = "SELECT * FROM Dg_ROI";
          rs2 = statement2.executeQuery(query);
         
          //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
         int i=1;
         while (rs2.next()) 
         {
        	 out.println("while!");
            // if (rs2.getInt("Account_No") != 2010200242 || rs2.getInt("Account_No") != 2010200261 || rs2.getInt("Account_No") != 2010200270)
		  i++;
      	  // output=output+i+"^"+rs2.getString("DG_MEMBER_ID")+ "^" + rs2.getString("ADDRESS") + "^" + rs2.getString("PERSONAL") + "^" + rs2.getString("FILE_NAME1") + "^" + rs2.getString("FILE_NAME2")+ "^" + rs2.getString("USER1")+ "^" + rs2.getString("CURRENTDATE")+rs2.getString("DG_STATUS")+ "^" +rs2.getString("APPROVAL_STATUS")+",";
	   output=output+i+"^"+rs2.getString("SCHEME") + "^" + rs2.getString("PERIOD") + "^" + rs2.getString("TYPE") + "^" + rs2.getString("ROI")+ "^" + rs2.getString("SR_ROI")+ "^" + rs2.getString("SSR_ROI")+ "^" + rs2.getString("COMPOUNDING")+",";  

        	}
     
         out.println("Output Send ....!!="+output);
     
      conn2.close();
     }
     
     catch(Exception e)
     {
         out.println("Exception : " + e.getMessage() + "");
     }

     /* 
     String[] separated = output.split(",");
     
     for (int j = 0; j < separated.length; j++)
     {
		 out.println("Mini Statement="+separated[j]);
     }*/

     response.addHeader("VectorFExp", output);
      
       
    }
    else if(no == 52){
        out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
        
       
        String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
        String uid =request.getParameter("uid");
        String pwd =request.getParameter("pwd");
        
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
        conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbsnknl", "dbpwdsnknl");
         out.println("connected....!!");
         statement = conn1.createStatement();
  
      // sql query to retrieve values from the secified table.
      String QueryString = "SELECT USERNAME,PASSWORD from DG_Login_details where DEVICEID='"+devId+"' and User_Type='Tablet'";
      rs = statement.executeQuery(QueryString);
      
      if (rs.next() == false)
      {
    	  f=0;
      }
      while (rs.next()) {
     	 Uname=rs.getString(1);
     	 Pword=rs.getString(2);
      }
      if(f!=0)
      {
       if(Uname.equalsIgnoreCase(uid) && Pword.equalsIgnoreCase(pwd))
       {
       	output="Y";
       }
        else
       {
       	output="N";
       }
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
   
     	 out.println("Validation="+output);

    	
     /* 
     String[] separated = output.split(",");
     
     for (int j = 0; j < separated.length; j++)
     {
		 out.println("Mini Statement="+separated[j]);
     }*/

     response.addHeader("VectorFExp", output);
      
       
    }
    else if(no == 53){
        out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
        
       
        String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
        String Uname=null;
		 	String Pword=null;
    
     Connection conn1 = null;
     Statement statement = null;
     ResultSet rs = null;
   /*  try
     {
     	
         Class.forName("oracle.jdbc.driver.OracleDriver");
        conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbsnknl", "dbpwdsnknl");
         out.println("connected....!!");
         statement = conn1.createStatement();
  
      // sql query to retrieve values from the secified table.
      String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
      rs = statement.executeQuery(QueryString);
      while (rs.next()) {
     	 Uname=rs.getString(1);
     	 Pword=rs.getString(2);
      }
      conn1.close();
     }
     catch(Exception e)
     {
         out.println("Exception : " + e.getMessage() + "");
     }*/
     
     Connection conn2 = null;
     Statement statement2 = null;
     ResultSet rs2 = null;
     String output = "";
     try
     {
     	
         Class.forName("oracle.jdbc.driver.OracleDriver");
        conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl","dbsnknl", "dbpwdsnknl");
         out.println("Particlar DBconnected....!!");
       //  out.println("Uname....!!"+Uname);
       //  out.println("Pword!"+Pword);
         statement2 = conn2.createStatement();
  
        // String query = "SELECT * FROM Dg_Customer";
         String query = "SELECT * FROM DG_Login_details where USER_TYPE='Tablet' and DEVICEID='"+devId+"'";
          rs2 = statement2.executeQuery(query);
         
          //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
         int i=1;
         while (rs2.next()) 
         {
        	 out.println("while!");
            // if (rs2.getInt("Account_No") != 2010200242 || rs2.getInt("Account_No") != 2010200261 || rs2.getInt("Account_No") != 2010200270)
		  i++;
      	  // output=output+i+"^"+rs2.getString("DG_MEMBER_ID")+ "^" + rs2.getString("ADDRESS") + "^" + rs2.getString("PERSONAL") + "^" + rs2.getString("FILE_NAME1") + "^" + rs2.getString("FILE_NAME2")+ "^" + rs2.getString("USER1")+ "^" + rs2.getString("CURRENTDATE")+rs2.getString("DG_STATUS")+ "^" +rs2.getString("APPROVAL_STATUS")+",";
	   output=output+i+"^"+rs2.getString("USERNAME") + "^" + rs2.getString("PASSWORD") + "^" + rs2.getString("EMP_NAME")+ "^"+rs2.getString("id")+",";  

        	}
     
         out.println("Output Send ....!!="+output);
     
      conn2.close();
     }
     
     catch(Exception e)
     {
         out.println("Exception : " + e.getMessage() + "");
     }

     /* 
     String[] separated = output.split(",");
     
     for (int j = 0; j < separated.length; j++)
     {
		 out.println("Mini Statement="+separated[j]);
     }*/

     response.addHeader("VectorFExp", output);
      
       
    }
  
    else if(no == 54){
        out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
        
        int from = Integer.parseInt(request.getParameter("from")); 
     // String from = request.getParameter("did");//Request.QueryString["did"].ToString();
        String Uname=null;
		 	String Pword=null;
    
     Connection conn1 = null;
     Statement statement = null;
     ResultSet rs = null;
   /*  try
     {
     	
         Class.forName("oracle.jdbc.driver.OracleDriver");
        conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbsnknl", "dbpwdsnknl");
         out.println("connected....!!");
         statement = conn1.createStatement();
  
      // sql query to retrieve values from the secified table.
      String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
      rs = statement.executeQuery(QueryString);
      while (rs.next()) {
     	 Uname=rs.getString(1);
     	 Pword=rs.getString(2);
      }
      conn1.close();
     }
     catch(Exception e)
     {
         out.println("Exception : " + e.getMessage() + "");
     }*/
     
     int to=from+200;
     Connection conn2 = null;
     Statement statement2 = null;
     ResultSet rs2 = null;
     String output = "";
     try
     {
     	
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl","dbsnknl", "dbpwdsnknl");
         
       /* conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl","dbsnknl", "dbpwdsnknl");*/
       
         out.println("Particlar DBconnected....!!");
       //  out.println("Uname....!!"+Uname);
       //  out.println("Pword!"+Pword);
         statement2 = conn2.createStatement();
  
        // String query = "SELECT * FROM Dg_Customer";
        String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  distinct customer_id,customer_name,mobile_no FROM     Customer_view   ) q  ) WHERE   rn BETWEEN "+from+" AND "+to+"";
 rs2 = statement2.executeQuery(query);
         
          //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
         int i=0;
         while (rs2.next()) 
         {
        	 out.println("while!");
            // if (rs2.getInt("Account_No") != 2010200242 || rs2.getInt("Account_No") != 2010200261 || rs2.getInt("Account_No") != 2010200270)
		  i++;
      	  // output=output+i+"^"+rs2.getString("DG_MEMBER_ID")+ "^" + rs2.getString("ADDRESS") + "^" + rs2.getString("PERSONAL") + "^" + rs2.getString("FILE_NAME1") + "^" + rs2.getString("FILE_NAME2")+ "^" + rs2.getString("USER1")+ "^" + rs2.getString("CURRENTDATE")+rs2.getString("DG_STATUS")+ "^" +rs2.getString("APPROVAL_STATUS")+",";
	   output=output+i+"^"+rs2.getInt("customer_id") + "^" + (rs2.getString("customer_name")).replaceAll(",", "") + "^" + (rs2.getString("mobile_no")).replaceAll(",", "") +",";  

        	}
     
         out.println("Output Send ....!!="+output);
     
      conn2.close();
     }
     
     catch(Exception e)
     {
         out.println("Exception : " + e.getMessage() + "");
     }

     /* 
     String[] separated = output.split(",");
     
     for (int j = 0; j < separated.length; j++)
     {
		 out.println("Mini Statement="+separated[j]);
     }*/

     response.addHeader("VectorFExp", output);
      
       
    }
    else if(no == 55){
        out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
        
       
       // String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
        String Uname=null;
		 	String Pword=null;
    
     Connection conn1 = null;
     Statement statement = null;
     ResultSet rs = null;
   /*  try
     {
     	
         Class.forName("oracle.jdbc.driver.OracleDriver");
        conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbsnknl", "dbpwdsnknl");
         out.println("connected....!!");
         statement = conn1.createStatement();
  
      // sql query to retrieve values from the secified table.
      String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
      rs = statement.executeQuery(QueryString);
      while (rs.next()) {
     	 Uname=rs.getString(1);
     	 Pword=rs.getString(2);
      }
      conn1.close();
     }
     catch(Exception e)
     {
         out.println("Exception : " + e.getMessage() + "");
     }*/
     
     Connection conn2 = null;
     Statement statement2 = null;
     ResultSet rs2 = null;
     String output = "";
     try
     {
     	
         Class.forName("oracle.jdbc.driver.OracleDriver");
        conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl","dbsnknl", "dbpwdsnknl");
         out.println("Particlar DBconnected....!!");
       //  out.println("Uname....!!"+Uname);
       //  out.println("Pword!"+Pword);
         statement2 = conn2.createStatement();
  
        // String query = "SELECT * FROM Dg_Customer";
         String query = "SELECT BRANCH_CODE,BRANCH_NAME,BRANCH_ADDRESS,BRANCH_PINCODE,BRANCH_PHONE FROM Branch_Master";
          rs2 = statement2.executeQuery(query);
         
          //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
         int i=1;
         while (rs2.next()) 
         {
        	 out.println("while!");
            // if (rs2.getInt("Account_No") != 2010200242 || rs2.getInt("Account_No") != 2010200261 || rs2.getInt("Account_No") != 2010200270)
		  i++;
      	  // output=output+i+"^"+rs2.getString("DG_MEMBER_ID")+ "^" + rs2.getString("ADDRESS") + "^" + rs2.getString("PERSONAL") + "^" + rs2.getString("FILE_NAME1") + "^" + rs2.getString("FILE_NAME2")+ "^" + rs2.getString("USER1")+ "^" + rs2.getString("CURRENTDATE")+rs2.getString("DG_STATUS")+ "^" +rs2.getString("APPROVAL_STATUS")+",";
	   output=output+rs2.getString("BRANCH_CODE") + "^" + rs2.getString("BRANCH_NAME") + "^" + rs2.getString("BRANCH_ADDRESS")+ "^"+rs2.getString("BRANCH_PINCODE")+"^"+rs2.getString("BRANCH_PHONE")+",";  

        	}
     
         out.println("Output Send ....!!="+output);
     
      conn2.close();
     }
     
     catch(Exception e)
     {
         out.println("Exception : " + e.getMessage() + "");
     }

     /* 
     String[] separated = output.split(",");
     
     for (int j = 0; j < separated.length; j++)
     {
		 out.println("Mini Statement="+separated[j]);
     }*/

     response.addHeader("VectorFExp", output);
      
       
    }
    else
    {
    	 out.println("Enter Valid Type");
    }
}
%>
</BODY>
</HTML>