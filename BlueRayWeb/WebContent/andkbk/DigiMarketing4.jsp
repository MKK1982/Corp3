<%@ page import="java.sql.*" %>
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
           conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbsnknl", "dbpwdsnknl");
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
    else if(no == 3){
    	
    	
    	
    	
    	 //00//string connString = @"Data Source=WINDOWS-3YYCEIU;Initial Catalog=NTBF;UId=sa;Pwd=pisquare";
        //string connString = @"Data Source=117.218.250.206;Initial Catalog=NTBF;UId=sa;Pwd=pisquare";
        //string connString = @"Data Source=TEST\NEW;Initial Catalog=NTBF;UId=sa;Pwd=pisquare";
        //string connString = @"Data Source=TEST\NEW;Initial Catalog=NTBF;UId=sa;Pwd=pisquare";
        String output = "";
        //23.02.16
        String resp =request.getParameter("fullstring");///Request.QueryString["fullstring"].ToString();
        String devIdt =request.getParameter("did");///Request.QueryString["did"].ToString();
        String userid =request.getParameter("uid");
        String Tm = request.getParameter("Tm");///Request.QueryString["Tm"].ToString();
        
        int Branch = Integer.parseInt(request.getParameter("br"));
        
       
       

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
        String scheme=null;
        int dept_amt=0;
        String open_date=null;
        String period=null;
        String int_rate=null;
        String chqdate=null;
        String mo=null;
        String rd_account_no=null;
        String mat_date=null;
        int mat_amt=0;
        String Mode=null;
        String Bank_Name=null;
        String Cheque_No=null;
        String Cheque_Date= null;
        
        
        String mo_Acc="";
        String c2="";
        String c3="";
        int cus_id2=0;
        int cus_id3=0;
        String Mode_Of_Account=""; 
        		
        for (int i = 0; i < rcpt.length; i++)
        {
        	String IndRecord=rcpt[i];
        	  out.println("IndRecord="+IndRecord);
        String[] ds = IndRecord.split("-");
        	//out.println("ds.length="+ds.length);
        	
        	 memid = ds[0];
        	 
        	 
        	 scheme ="3";
        	 //scheme = ds[1];
        	 open_date = ds[2];
        	 period = ds[3];
        	 dept_amt = Integer.parseInt(ds[4]);
        	 int_rate = ds[5];
        	 mat_date = ds[6];
        	 mat_amt = Integer.parseInt(ds[7]);

 		String effect=open_date.substring(0,2)+"/"+open_date.substring(2,4)+"/"+open_date.substring(4,8);
        	 String Mat=mat_date.substring(0,2)+"/"+mat_date.substring(2,4)+"/"+mat_date.substring(4,8);


        	 Mode = ds[8];
        	  Bank_Name=ds[9];
              Cheque_No=ds[10];
              Cheque_Date= ds[11];
        	 
        	 int c=0;	
        	 String b="";
        	 int b2=0;
        	 
        		 
        	//Mo_Acc,Cusid2,cusid3
       	  mo_Acc=ds[12];

             c2=ds[13];
             c3=ds[14];
        	 
             if(mo_Acc.equalsIgnoreCase("1"))
             {
           	  Mode_Of_Account="S";
out.println("Particlar ....!!");

             }
             else if(mo_Acc.equalsIgnoreCase("4"))
             {
           	             	  
           		  cus_id3=Integer.parseInt(c3);
                  cus_id2=Integer.parseInt(c2);
           	  
           	  Mode_Of_Account="A";
             }
             else
             {
           	  if(!c2.equalsIgnoreCase("0"))
                 {
           		  cus_id2=Integer.parseInt(c2);
                 }
           	  else
           		  cus_id2=0;
           	 
           	  if(mo_Acc.equalsIgnoreCase("2"))
                 {
               	  Mode_Of_Account="E";
                 }
           	  else
           		  if(mo_Acc.equalsIgnoreCase("3"))
                     {
                   	  Mode_Of_Account="F";
                     }
           		  else
           	  		Mode_Of_Account="J";
             }
    	 
         String mType="E";
        	 
        	 
        	 if(Branch==0)
        	 {
        		 mType="N";	 
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
        	 }
        	 else if(Branch==1)
        	 {
        		 c=1;
        		 b="201";
        	 }
        	 else if(Branch==2)
        	 {
        		 c=1;
        		 b="202";
        	 }
        	 else if(Branch==3)
        	 {
        		 c=1;
        		 b="203";
        	 }
        	 else if(Branch==4)
        	 {
        		 c=1;
        		 b="204";
        	 }
        	 else if(Branch==5)
        	 {
        		 c=1;
        		 b="205";
        	 }
        	 else if(Branch==6)
        	 {
        		 c=1;
        		 b="207";
        	 }
        	 else if(Branch==7)
        	 {
        		 c=1;
        		 b="208";
        	 }
        	 else if(Branch==8)
        	 {
        		 c=1;
        		 b="209";
        	 }
        	 else if(Branch==9)
        	 {
        		 c=1;
        		 b="210";
        	 }
		 else if(Branch==10)
        	 {
        		 c=1;
        		 b="211";
        	 }
        	 else if(Branch==11)
        	 {
        		 c=1;
        		 b="212";
        	 }
        	 else if(Branch==13)
        	 {
        		 c=1;
        		 b="214";
        	 }
		 else if(Branch==14)
        	 {
        		 c=1;
        		 b="215";
        	 }

        	 	 else 
        	 {
        		 c=1;
        		 b="213";
        	 }
        	 
        	if(c==1)
        	{
         	 try
             {
        	
            Class.forName("oracle.jdbc.driver.OracleDriver");
           conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", Uname, Pword);
            out.println("Particlar DBconnected....!!");
            statement = conn2.createStatement();
            
        
           // String query = "insert into Dg_Share_Master(DG_MEMBER_ID,NO_OF_SHARES,SHARE_VALUE,SHARE_AMOUNT,MODE_OF_OPERATION,BANKNAME,CHEQUENO,CHECK_DATE,USERID,DG_STATUS,APPROVAL_STATUS) values('"+memid+"',"+shares+","+ratepershare+","+amount+",'"+mode+"','"+bankname+"','"+chqno+"','"+chqdate+"' ,"+userid+"','Y','N')";
           // String query = "insert into Dg_Share_Master(DG_MEMBER_ID,NO_OF_SHARES,SHARE_VALUE,SHARE_AMOUNT,MODE_OF_OPERATION) values('"+memid+"',"+shares+","+ratepershare+","+amount+",'"+mode+"')";
           // String query = "insert into Dg_RD_Master(RD_ACCOUNT_NO,DG_MEMBER_ID,SCHEME_TYPE,OPEN_DATE,PERIOD,INTEREST_RATE,DEPOSIT_AMOUNT,MATURITY_DATE,MATURITY_AMOUNT,BCODE) values('"+rd_account_no+"','"+memid+"',"+scheme+",'"+effect+"','"+period+"','"+int_rate+"',"+dept_amt+" ,'"+Mat+"',"+mat_amt+",'"+b+"')";
           String query = "insert into Dg_RD_Master(DG_MEMBER_ID,SCHEME_TYPE,OPEN_DATE,PERIOD,INTEREST_RATE,DEPOSIT_AMOUNT,MATURITY_DATE,MATURITY_AMOUNT,BCODE,USER_ID,MEMBER_ID_TYPE,MO_ACC,CUSTOMER_ID_2,CUSTOMER_ID_3,MOP,BANK_NAME,CHEQUE_NO,CHECK_DATE,APPROVAL_STATUS) values('"+memid+"','"+scheme+"','"+effect+"','"+period+"','"+int_rate+"',"+dept_amt+",'"+Mat+"',"+mat_amt+",'"+b+"','"+userid+"','"+mType+"','"+Mode_Of_Account+"',"+cus_id2+","+cus_id3+",'"+Mode+"','"+Bank_Name+"','"+Cheque_No+"','"+chqdate+"','N')";
             out.println("query ="+query);

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
    else if(no == 22){
        out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
 
        
        //accno
         //float ClAmt=Float.parseFloat(request.getParameter("Collected"));
		// int Acc_No=Integer.parseInt(request.getParameter("Accountno"));
      
       // int id = Integer.parseInt(request.getParameter("id"));
        //float collectAmt =ClAmt;//.replace("Rs.", "");// Request.QueryString["Collected"].ToString().Replace("Rs.","");
        
       
	  
	    //Dg_ROI
      String FD_ACCOUNT_NO= request.getParameter("fdac");//Request.QueryString["Dt"].ToString();
     String DG_MEMBER_ID=request.getParameter("dgid");//Request.QueryString["did"].ToString();
     String SCHEME_TYPE= request.getParameter("scheme");//Request.QueryString["uid"].ToString();
     String OPEN_DATE1 = request.getParameter("odate");//Request.QueryString["Tm"].ToString();
    //String OPEN_DATE1="01/01/2018";
     String PERIOD = request.getParameter("period");//Request.QueryString["Tm"].ToString();
     String INTEREST_RATE = request.getParameter("roi");//Request.QueryString["Tm"].ToString();
	String DEPOSIT_AMOUNT= request.getParameter("damt");//Request.QueryString["Tm"].ToString();
	String INT_PAYMENT_FREQ = request.getParameter("ipfreq");//Request.QueryString["Tm"].ToString();
	String MATURITY_DATE1= request.getParameter("mdate");//Request.QueryString["Tm"].ToString();
	//String MATURITY_DATE1="31/12/2018";
	String MATURITY_AMOUNT= request.getParameter("mamt");//Request.QueryString["Tm"].ToString();
		
	
	  //http://103.48.180.117:3700/Snnl_And/DigiMarketing2.jsp?type=22&fdac=RD&dgid=12months&scheme=ers&odate=12&period=12&roi=13&damt=y&ipfreq=N&mdate=30010&mamt=10000 
	  
	  
	  
    
       
        Connection conn1 = null;
        Connection conn2 = null;
        Statement statement = null;
        ResultSet rs = null;
        try
        {
        	
            Class.forName("oracle.jdbc.driver.OracleDriver");
           conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbsnknl", "dbpwdsnknl");
            out.println("connected....!!");
            statement = conn1.createStatement();
            String query = "insert into Dg_FD_Master(FD_ACCOUNT_NO,DG_MEMBER_ID,SCHEME_TYPE,OPEN_DATE,PERIOD,INTEREST_RATE,DEPOSIT_AMOUNT,INT_PAYMENT_FREQ,MATURITY_DATE,MATURITY_AMOUNT) values('"+FD_ACCOUNT_NO+"','"+DG_MEMBER_ID+"','"+SCHEME_TYPE+"',to_date('"+OPEN_DATE1+"','ddMMyyyy'),'"+PERIOD+"','"+INTEREST_RATE+"','"+DEPOSIT_AMOUNT+"','"+INT_PAYMENT_FREQ+"',to_date('"+MATURITY_DATE1+"','ddMMyyyy'),'"+MATURITY_AMOUNT+"')";

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
         String query = "SELECT FD_ACCOUNT_NO,DG_MEMBER_ID,SCHEME_TYPE,to_char(OPEN_DATE,'dd/MM/yyyy'),PERIOD,INTEREST_RATE,DEPOSIT_AMOUNT,INT_PAYMENT_FREQ,to_char(MATURITY_DATE,'dd/MM/yyyy'),MATURITY_AMOUNT FROM Dg_FD_Master";
          rs2 = statement2.executeQuery(query);
         
          //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
         int i=1;
         while (rs2.next()) 
         {
        	 out.println("while!");
            // if (rs2.getInt("Account_No") != 2010200242 || rs2.getInt("Account_No") != 2010200261 || rs2.getInt("Account_No") != 2010200270)
		  i++;
      	  // output=output+i+"^"+rs2.getString("DG_MEMBER_ID")+ "^" + rs2.getString("ADDRESS") + "^" + rs2.getString("PERSONAL") + "^" + rs2.getString("FILE_NAME1") + "^" + rs2.getString("FILE_NAME2")+ "^" + rs2.getString("USER1")+ "^" + rs2.getString("CURRENTDATE")+rs2.getString("DG_STATUS")+ "^" +rs2.getString("APPROVAL_STATUS")+",";
	  // output=output+i+"^"+rs2.getString("FD_ACCOUNT_NO") + "^" + rs2.getString("DG_MEMBER_ID") + "^" + rs2.getString("SCHEME_TYPE") + "^" + rs2.getString("OPEN_DATE")+ "^" + rs2.getString("PERIOD")+ "^" + rs2.getString("INTEREST_RATE")+ "^" + rs2.getString("DEPOSIT_AMOUNT")+ "^" + rs2.getString("INT_PAYMENT_FREQ") + "^" + rs2.getString("MATURITY_DATE")+ "^" + rs2.getString("MATURITY_AMOUNT")+",";  
	   output=output+i+"^"+rs2.getString(1) + "^" + rs2.getString(2) + "^" + rs2.getString(3) + "^" + rs2.getString(4)+ "^" + rs2.getString(5)+ "^" + rs2.getString(6)+ "^" + rs2.getString(7)+ "^" + rs2.getString(8) + "^" + rs2.getString(9)+ "^" + rs2.getString(10)+",";  

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
   else if(no == 23){
       out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");

       
       //accno
        //float ClAmt=Float.parseFloat(request.getParameter("Collected"));
		// int Acc_No=Integer.parseInt(request.getParameter("Accountno"));
     
      // int id = Integer.parseInt(request.getParameter("id"));
       //float collectAmt =ClAmt;//.replace("Rs.", "");// Request.QueryString["Collected"].ToString().Replace("Rs.","");
       
      
	  
	    //Dg_ROI
     String RD_ACCOUNT_NO= request.getParameter("rdac");//Request.QueryString["Dt"].ToString();
    String DG_MEMBER_ID=request.getParameter("dgid");//Request.QueryString["did"].ToString();
    String SCHEME_TYPE= request.getParameter("scheme");//Request.QueryString["uid"].ToString();
    String OPEN_DATE1 = request.getParameter("odate");//Request.QueryString["Tm"].ToString();
   //String OPEN_DATE1="01/01/2018";
    String PERIOD = request.getParameter("period");//Request.QueryString["Tm"].ToString();
    String INTEREST_RATE = request.getParameter("roi");//Request.QueryString["Tm"].ToString();
	String DEPOSIT_AMOUNT= request.getParameter("damt");//Request.QueryString["Tm"].ToString();
	//String INT_PAYMENT_FREQ = request.getParameter("ipfreq");//Request.QueryString["Tm"].ToString();
	String MATURITY_DATE1= request.getParameter("mdate");//Request.QueryString["Tm"].ToString();
	//String MATURITY_DATE1="31/12/2018";
	String MATURITY_AMOUNT= request.getParameter("mamt");//Request.QueryString["Tm"].ToString();
		
	
	  //http://103.48.180.117:3700/Snnl_And/DigiMarketing2.jsp?type=22&fdac=RD&dgid=12months&scheme=ers&odate=12&period=12&roi=13&damt=y&ipfreq=N&mdate=30010&mamt=10000 
	  
	  
	  
   
      
       Connection conn1 = null;
       Connection conn2 = null;
       Statement statement = null;
       ResultSet rs = null;
       try
       {
       	
           Class.forName("oracle.jdbc.driver.OracleDriver");
          conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbsnknl", "dbpwdsnknl");
           out.println("connected....!!");
           statement = conn1.createStatement();
           String query = "insert into Dg_RD_Master(RD_ACCOUNT_NO,DG_MEMBER_ID,SCHEME_TYPE,OPEN_DATE,PERIOD,INTEREST_RATE,DEPOSIT_AMOUNT,MATURITY_DATE,MATURITY_AMOUNT) values('"+RD_ACCOUNT_NO+"','"+DG_MEMBER_ID+"','"+SCHEME_TYPE+"',to_date('"+OPEN_DATE1+"','ddMMyyyy'),'"+PERIOD+"','"+INTEREST_RATE+"','"+DEPOSIT_AMOUNT+"',to_date('"+MATURITY_DATE1+"','ddMMyyyy'),'"+MATURITY_AMOUNT+"')";

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
   else if(no == 24){
       out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");

       
       //accno
        //float ClAmt=Float.parseFloat(request.getParameter("Collected"));
		// int Acc_No=Integer.parseInt(request.getParameter("Accountno"));
     
      // int id = Integer.parseInt(request.getParameter("id"));
       //float collectAmt =ClAmt;//.replace("Rs.", "");// Request.QueryString["Collected"].ToString().Replace("Rs.","");
       
      
	  
	    //Dg_ROI
    String DG_MEMBER_ID=request.getParameter("dgid");//Request.QueryString["did"].ToString();
    String NO_OF_SHARES= request.getParameter("nos");//Request.QueryString["uid"].ToString();
    String SHARE_AMOUNT = request.getParameter("samt");//Request.QueryString["Tm"].ToString();
   //String OPEN_DATE1="01/01/2018";
    String SHARE_VALUE = request.getParameter("sv");//Request.QueryString["Tm"].ToString();
    String MODE_OF_OPERATION = request.getParameter("mo");//Request.QueryString["Tm"].ToString();
	String BANKNAME= request.getParameter("bn");//Request.QueryString["Tm"].ToString();
	String CHEQUENO = request.getParameter("cno");//Request.QueryString["Tm"].ToString();
	String CHECK_DATE= request.getParameter("cdate");//Request.QueryString["Tm"].ToString();
	//String MATURITY_DATE1="31/12/2018";
	String TRANSACTION_DATE= request.getParameter("tdate");//Request.QueryString["Tm"].ToString();
	String USERID= request.getParameter("uid");//Request.QueryString["Tm"].ToString();
	String DG_STATUS= request.getParameter("ds");//Request.QueryString["Tm"].ToString();
	
	
	  //http://103.48.180.117:3700/Snnl_And/DigiMarketing2.jsp?type=22&fdac=RD&dgid=12months&scheme=ers&odate=12&period=12&roi=13&damt=y&ipfreq=N&mdate=30010&mamt=10000 
	  
int nos=Integer.parseInt(NO_OF_SHARES);
int sv=Integer.parseInt(SHARE_VALUE);
int samt=Integer.parseInt(SHARE_AMOUNT);
	  
   
      
       Connection conn1 = null;
       Connection conn2 = null;
       Statement statement = null;
       ResultSet rs = null;
       try
       {
       	
           Class.forName("oracle.jdbc.driver.OracleDriver");
          conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbsnknl", "dbpwdsnknl");
           out.println("connected....!!");
           statement = conn1.createStatement();
           String query = "insert into Dg_Share_Master(DG_MEMBER_ID,NO_OF_SHARES,SHARE_VALUE,SHARE_AMOUNT,MODE_OF_OPERATION,BANKNAME,CHEQUENO,CHECK_DATE,TRANSACTION_DATE,USERID,DG_STATUS,APPROVAL_STATUS) values('"+DG_MEMBER_ID+"',"+nos+","+sv+","+samt+",'"+MODE_OF_OPERATION+"','"+BANKNAME+"','"+CHEQUENO+"','"+CHECK_DATE+"' ,to_date('"+TRANSACTION_DATE+"','ddMMyyyy'),'"+USERID+"','"+DG_STATUS+"','N')";

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
  else if(no == 53){//RD
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
        String query = "SELECT RD_ACCOUNT_NO,DG_MEMBER_ID,SCHEME_TYPE,to_char(OPEN_DATE,'dd/MM/yyyy'),PERIOD,INTEREST_RATE,DEPOSIT_AMOUNT,to_char(MATURITY_DATE,'dd/MM/yyyy'),MATURITY_AMOUNT FROM Dg_RD_Master";
         rs2 = statement2.executeQuery(query);
        
         //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
        int i=1;
        while (rs2.next()) 
        {
       	 out.println("while!");
           // if (rs2.getInt("Account_No") != 2010200242 || rs2.getInt("Account_No") != 2010200261 || rs2.getInt("Account_No") != 2010200270)
		  i++;
     	  // output=output+i+"^"+rs2.getString("DG_MEMBER_ID")+ "^" + rs2.getString("ADDRESS") + "^" + rs2.getString("PERSONAL") + "^" + rs2.getString("FILE_NAME1") + "^" + rs2.getString("FILE_NAME2")+ "^" + rs2.getString("USER1")+ "^" + rs2.getString("CURRENTDATE")+rs2.getString("DG_STATUS")+ "^" +rs2.getString("APPROVAL_STATUS")+",";
	  // output=output+i+"^"+rs2.getString("RD_ACCOUNT_NO") + "^" + rs2.getString("DG_MEMBER_ID") + "^" + rs2.getString("SCHEME_TYPE") + "^" + rs2.getString("OPEN_DATE")+ "^" + rs2.getString("PERIOD")+ "^" + rs2.getString("INTEREST_RATE")+ "^" + rs2.getString("DEPOSIT_AMOUNT")+ "^"  + rs2.getString("MATURITY_DATE")+ "^" + rs2.getString("MATURITY_AMOUNT")+",";  
	   output=output+i+"^"+rs2.getString(1) + "^" + rs2.getString(2) + "^" + rs2.getString(3) + "^" + rs2.getString(4)+ "^" + rs2.getString(5)+ "^" + rs2.getString(6)+ "^" + rs2.getString(7)+ "^"  + rs2.getString(8)+ "^" + rs2.getString(9)+",";  

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
       String query = "SELECT RD_ACCOUNT_NO,DG_MEMBER_ID,SCHEME_TYPE,to_char(OPEN_DATE,'dd/MM/yyyy'),PERIOD,INTEREST_RATE,DEPOSIT_AMOUNT,to_char(MATURITY_DATE,'dd/MM/yyyy'),MATURITY_AMOUNT FROM Dg_RD_Master";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
       int i=1;
       while (rs2.next()) 
       {
      	 out.println("while!");
          // if (rs2.getInt("Account_No") != 2010200242 || rs2.getInt("Account_No") != 2010200261 || rs2.getInt("Account_No") != 2010200270)
		  i++;
    	  // output=output+i+"^"+rs2.getString("DG_MEMBER_ID")+ "^" + rs2.getString("ADDRESS") + "^" + rs2.getString("PERSONAL") + "^" + rs2.getString("FILE_NAME1") + "^" + rs2.getString("FILE_NAME2")+ "^" + rs2.getString("USER1")+ "^" + rs2.getString("CURRENTDATE")+rs2.getString("DG_STATUS")+ "^" +rs2.getString("APPROVAL_STATUS")+",";
	  // output=output+i+"^"+rs2.getString("RD_ACCOUNT_NO") + "^" + rs2.getString("DG_MEMBER_ID") + "^" + rs2.getString("SCHEME_TYPE") + "^" + rs2.getString("OPEN_DATE")+ "^" + rs2.getString("PERIOD")+ "^" + rs2.getString("INTEREST_RATE")+ "^" + rs2.getString("DEPOSIT_AMOUNT")+ "^"  + rs2.getString("MATURITY_DATE")+ "^" + rs2.getString("MATURITY_AMOUNT")+",";  
	   output=output+i+"^"+rs2.getString(1) + "^" + rs2.getString(2) + "^" + rs2.getString(3) + "^" + rs2.getString(4)+ "^" + rs2.getString(5)+ "^" + rs2.getString(6)+ "^" + rs2.getString(7)+ "^"  + rs2.getString(8)+ "^" + rs2.getString(9)+",";  

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