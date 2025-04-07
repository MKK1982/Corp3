<%@ page import="java.sql.*" %>
<%@page import="java.io.*"%>
<%@page import="org.json.simple.*"%>

<%
    Connection conn = null;
    try
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
        //00//out.println("connected....!!");

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
   if(no == 1){
        //00////00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
        
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
           conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
           //00////00//out.println("connected....!!");
           statement = conn1.createStatement();
           //00////00//out.println("createStatement....!!");
        // sql query to retrieve values from the secified table.
        String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
        //00////00//out.println(QueryString);
        rs = statement.executeQuery(QueryString);
        
        //00////00//out.println("excecute Qry....!!");
        
        while (rs.next()) {
        	 //00//out.println("inside While!!");
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
           //00////00//out.println("Particlar DBconnected....!!");
         
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
        	   //00//out.println(rs2.getString("Name"));
		   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                   
        	   output=output+rs2.getInt("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
		   
	 	   

		}

		i++;
          }
         
           out.println(output);
       
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
        //00////00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
        
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
           conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
           //00////00//out.println("connected....!!");
           statement = conn1.createStatement();
           //00////00//out.println("createStatement....!!");
        // sql query to retrieve values from the secified table.
        String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
        //00////00//out.println(QueryString);
        rs = statement.executeQuery(QueryString);
        
       //00// //00//out.println("excecute Qry....!!");
        
        while (rs.next()) {
        	 //00////00//out.println("inside While!!");
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
           //00////00//out.println("Particlar DBconnected....!!");
         
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
        	   //00//out.println(rs2.getString("Name"));
		   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                    
        	   output=output+rs2.getInt("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
		  
	 	  
	 	   

		}

		i++;
          }
         
          out.println(output);
       
        conn2.close();
       }
       catch(Exception e)
       {
           out.println("Exception : " + e.getMessage() + "");
       }

        
       String[] separated = output.split(",");
       //00//out.println("Output lst ....!!="+output);


       response.addHeader("AustinAndroidReturn", output);
      //00//  //00//out.println("Output 2nd ....!!="+output);
        
        
    }
else if(no == 98){
        //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
        
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
           conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
           //00//out.println("connected....!!");
           statement = conn1.createStatement();
           //00//out.println("createStatement....!!");
        // sql query to retrieve values from the secified table.
        String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
        //00//out.println(QueryString);
        rs = statement.executeQuery(QueryString);
        
        //00//out.println("excecute Qry....!!");
        
        while (rs.next()) {
        	 //00//out.println("inside While!!");
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
           //00//out.println("Particlar DBconnected....!!");
         
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
        	   //00//out.println(rs2.getString("Name"));
		   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                    
        	   output=output+rs2.getInt("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
		  
	 	  
	 	   

		}

		i++;
          }
         
           out.println(output);
       
        conn2.close();
       }
       catch(Exception e)
       {
           out.println("Exception : " + e.getMessage() + "");
       }

        
       String[] separated = output.split(",");
       //00//out.println("Output lst ....!!="+output);


       response.addHeader("AustinAndroidReturn", output);
      //00//  //00//out.println("Output 2nd ....!!="+output);
        
        
    }

else if(no == 97){
        //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
        
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
           conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
           //00//out.println("connected....!!");
           statement = conn1.createStatement();
           //00//out.println("createStatement....!!");
        // sql query to retrieve values from the secified table.
        String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
        //00//out.println(QueryString);
        rs = statement.executeQuery(QueryString);
        
        //00//out.println("excecute Qry....!!");
        
        while (rs.next()) {
        	 //00//out.println("inside While!!");
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
           //00//out.println("Particlar DBconnected....!!");
         
           statement2 = conn2.createStatement();
    
           //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 451 AND 600";
            rs2 = statement2.executeQuery(query);
           
            //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
          int i=0;
           while (rs2.next()) 
           {
		String ShrtName ="";
		//if(i<=205)
		{
        	   //00//out.println(rs2.getString("Name"));
		   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                    
        	   output=output+rs2.getInt("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
		  
	 	  
	 	   

		}

		i++;
          }
         
           out.println(output);
       
        conn2.close();
       }
       catch(Exception e)
       {
           out.println("Exception : " + e.getMessage() + "");
       }

        
       String[] separated = output.split(",");
       //00//out.println("Output lst ....!!="+output);


       response.addHeader("AustinAndroidReturn", output);
      //00//  //00//out.println("Output 2nd ....!!="+output);
        
        
    }
else if(no == 96){
        //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
        
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
          conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
           //00//out.println("connected....!!");
           statement = conn1.createStatement();
           //00//out.println("createStatement....!!");
        // sql query to retrieve values from the secified table.
        String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
        //00//out.println(QueryString);
        rs = statement.executeQuery(QueryString);
        
        //00//out.println("excecute Qry....!!");
        
        while (rs.next()) {
        	 //00//out.println("inside While!!");
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
           //00//out.println("Particlar DBconnected....!!");
         
           statement2 = conn2.createStatement();
    
           //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 601 AND 750";
            rs2 = statement2.executeQuery(query);
           
            //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
          int i=0;
           while (rs2.next()) 
           {
		String ShrtName ="";
		//if(i<=205)
		{
        	   //00//out.println(rs2.getString("Name"));
		   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                    
        	   output=output+rs2.getInt("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
		  
	 	  
	 	   

		}

		i++;
          }
         
           out.println(output);
       
        conn2.close();
       }
       catch(Exception e)
       {
           out.println("Exception : " + e.getMessage() + "");
       }

        
       String[] separated = output.split(",");
       //00//out.println("Output lst ....!!="+output);


       response.addHeader("AustinAndroidReturn", output);
      //00//  //00//out.println("Output 2nd ....!!="+output);
        
        
    }
else if(no == 95){
    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 751 AND 900";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getInt("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    
}
else if(no == 94){
    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 901 AND 1050";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getInt("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    
}

else if(no == 93){
        //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
        
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
        conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");

           //00//out.println("connected....!!");
           statement = conn1.createStatement();
           //00//out.println("createStatement....!!");
        // sql query to retrieve values from the secified table.
        String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
        //00//out.println(QueryString);
        rs = statement.executeQuery(QueryString);
        
        //00//out.println("excecute Qry....!!");
        
        while (rs.next()) {
        	 //00//out.println("inside While!!");
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
           //00//out.println("Particlar DBconnected....!!");
         
           statement2 = conn2.createStatement();
    
           //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 1051 AND 1200";
            rs2 = statement2.executeQuery(query);
           
            //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
          int i=0;
           while (rs2.next()) 
           {
		String ShrtName ="";
		//if(i<=205)
		{
        	   //00//out.println(rs2.getString("Name"));
		   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                    
        	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
		  
	 	  
	 	   

		}

		i++;
          }
         
           out.println(output);
       
        conn2.close();
       }
       catch(Exception e)
       {
           out.println("Exception : " + e.getMessage() + "");
       }

        
       String[] separated = output.split(",");
       //00//out.println("Output lst ....!!="+output);


       response.addHeader("AustinAndroidReturn", output);
      //00//  //00//out.println("Output 2nd ....!!="+output);
        
        
    }

else if(no == 92){
        //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
        
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
   conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");

           //00//out.println("connected....!!");
           statement = conn1.createStatement();
           //00//out.println("createStatement....!!");
        // sql query to retrieve values from the secified table.
        String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
        //00//out.println(QueryString);
        rs = statement.executeQuery(QueryString);
        
        //00//out.println("excecute Qry....!!");
        
        while (rs.next()) {
        	 //00//out.println("inside While!!");
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
           //00//out.println("Particlar DBconnected....!!");
         
           statement2 = conn2.createStatement();
    
           //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 1201 AND 1350";
            rs2 = statement2.executeQuery(query);
           
            //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
          int i=0;
           while (rs2.next()) 
           {
		String ShrtName ="";
		//if(i<=205)
		{
        	   //00//out.println(rs2.getString("Name"));
		   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                    
        	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
		  
	 	  
	 	   

		}

		i++;
          }
         
           out.println(output);
       
        conn2.close();
       }
       catch(Exception e)
       {
           out.println("Exception : " + e.getMessage() + "");
       }

        
       String[] separated = output.split(",");
       //00//out.println("Output lst ....!!="+output);


       response.addHeader("AustinAndroidReturn", output);
      //00//  //00//out.println("Output 2nd ....!!="+output);
        
        
    }

else if(no == 91){
        //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
        
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
         conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");

           //00//out.println("connected....!!");
           statement = conn1.createStatement();
           //00//out.println("createStatement....!!");
        // sql query to retrieve values from the secified table.
        String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
        //00//out.println(QueryString);
        rs = statement.executeQuery(QueryString);
        
        //00//out.println("excecute Qry....!!");
        
        while (rs.next()) {
        	 //00//out.println("inside While!!");
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
           //00//out.println("Particlar DBconnected....!!");
         
           statement2 = conn2.createStatement();
    
           //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 1351 AND 1500";
            rs2 = statement2.executeQuery(query);
           
            //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
          int i=0;
           while (rs2.next()) 
           {
		String ShrtName ="";
		//if(i<=205)
		{
        	   //00//out.println(rs2.getString("Name"));
		   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                    
        	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
		  
	 	  
	 	   

		}

		i++;
          }
         
           out.println(output);
       
        conn2.close();
       }
       catch(Exception e)
       {
           out.println("Exception : " + e.getMessage() + "");
       }

        
       String[] separated = output.split(",");
       //00//out.println("Output lst ....!!="+output);


       response.addHeader("AustinAndroidReturn", output);
      //00//  //00//out.println("Output 2nd ....!!="+output);
        
        
    }
else if(no == 90){
        //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
        
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
          conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");

           //00//out.println("connected....!!");
           statement = conn1.createStatement();
           //00//out.println("createStatement....!!");
        // sql query to retrieve values from the secified table.
        String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
        //00//out.println(QueryString);
        rs = statement.executeQuery(QueryString);
        
        //00//out.println("excecute Qry....!!");
        
        while (rs.next()) {
        	 //00//out.println("inside While!!");
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
           //00//out.println("Particlar DBconnected....!!");
         
           statement2 = conn2.createStatement();
    
           //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 1501 AND 1650";
            rs2 = statement2.executeQuery(query);
           
            //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
          int i=0;
           while (rs2.next()) 
           {
		String ShrtName ="";
		//if(i<=205)
		{
        	   //00//out.println(rs2.getString("Name"));
		   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                    
        	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
		  
	 	  
	 	   

		}

		i++;
          }
         
           out.println(output);
       
        conn2.close();
       }
       catch(Exception e)
       {
           out.println("Exception : " + e.getMessage() + "");
       }

        
       String[] separated = output.split(",");
       //00//out.println("Output lst ....!!="+output);


       response.addHeader("AustinAndroidReturn", output);
      //00//  //00//out.println("Output 2nd ....!!="+output);
        
        
    }

else if(no == 89){
        //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
        
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
         conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");

           //00//out.println("connected....!!");
           statement = conn1.createStatement();
           //00//out.println("createStatement....!!");
        // sql query to retrieve values from the secified table.
        String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
        //00//out.println(QueryString);
        rs = statement.executeQuery(QueryString);
        
        //00//out.println("excecute Qry....!!");
        
        while (rs.next()) {
        	 //00//out.println("inside While!!");
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
           //00//out.println("Particlar DBconnected....!!");
         
           statement2 = conn2.createStatement();
    
           //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 1651 AND 1800";
            rs2 = statement2.executeQuery(query);
           
            //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
          int i=0;
           while (rs2.next()) 
           {
		String ShrtName ="";
		//if(i<=205)
		{
        	   //00//out.println(rs2.getString("Name"));
		   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                    
        	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
		  
	 	  
	 	   

		}

		i++;
          }
         
           out.println(output);
       
        conn2.close();
       }
       catch(Exception e)
       {
           out.println("Exception : " + e.getMessage() + "");
       }

        
       String[] separated = output.split(",");
       //00//out.println("Output lst ....!!="+output);


       response.addHeader("AustinAndroidReturn", output);
      //00//  //00//out.println("Output 2nd ....!!="+output);
        
        
    }

else if(no == 88){
        //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
        
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
         conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");

           //00//out.println("connected....!!");
           statement = conn1.createStatement();
           //00//out.println("createStatement....!!");
        // sql query to retrieve values from the secified table.
        String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
        //00//out.println(QueryString);
        rs = statement.executeQuery(QueryString);
        
        //00//out.println("excecute Qry....!!");
        
        while (rs.next()) {
        	 //00//out.println("inside While!!");
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
           //00//out.println("Particlar DBconnected....!!");
         
           statement2 = conn2.createStatement();
    
           //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 1801 AND 1850";
            rs2 = statement2.executeQuery(query);
           
            //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
          int i=0;
           while (rs2.next()) 
           {
		String ShrtName ="";
		//if(i<=205)
		{
        	   //00//out.println(rs2.getString("Name"));
		   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                    
        	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
		  
	 	  
	 	   

		}

		i++;
          }
         
           out.println(output);
       
        conn2.close();
       }
       catch(Exception e)
       {
           out.println("Exception : " + e.getMessage() + "");
       }

        
       String[] separated = output.split(",");
       //00//out.println("Output lst ....!!="+output);


       response.addHeader("AustinAndroidReturn", output);
      //00//  //00//out.println("Output 2nd ....!!="+output);
        
        
    }

else if(no == 87){
        //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
        
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
          conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");

           //00//out.println("connected....!!");
           statement = conn1.createStatement();
           //00//out.println("createStatement....!!");
        // sql query to retrieve values from the secified table.
        String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
        //00//out.println(QueryString);
        rs = statement.executeQuery(QueryString);
        
        //00//out.println("excecute Qry....!!");
        
        while (rs.next()) {
        	 //00//out.println("inside While!!");
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
           //00//out.println("Particlar DBconnected....!!");
         
           statement2 = conn2.createStatement();
    
           //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 1951 AND 2100";
            rs2 = statement2.executeQuery(query);
           
            //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
          int i=0;
           while (rs2.next()) 
           {
		String ShrtName ="";
		//if(i<=205)
		{
        	   //00//out.println(rs2.getString("Name"));
		   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                    
        	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
		  
	 	  
	 	   

		}

		i++;
          }
         
           out.println(output);
       
        conn2.close();
       }
       catch(Exception e)
       {
           out.println("Exception : " + e.getMessage() + "");
       }

        
       String[] separated = output.split(",");
       //00//out.println("Output lst ....!!="+output);


       response.addHeader("AustinAndroidReturn", output);
      //00//  //00//out.println("Output 2nd ....!!="+output);
        
        
    }
	
	else if(no == 86)
{

    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 2101 AND 2250";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}
   
else if(no == 85)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 2251 AND 2400";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}
else if(no == 84)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 2401 AND 2550";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}
   
else if(no == 83)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 2551 AND 2700";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}

else if(no == 82)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 2701 AND 2850";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}
   
else if(no == 81)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 2851 AND 3000";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}
   
else if(no == 80)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 3001 AND 3150";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}


else if(no == 79)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 3151 AND 3300";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}


else if(no == 78)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 3301 AND 3450";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}

else if(no == 77)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 3451 AND 3600";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}



else if(no == 76)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 3601 AND 3750";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}


else if(no == 75)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 3751 AND 3900";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}


else if(no == 74)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 3901 AND 4050";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}


else if(no == 73)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 4051 AND 4200";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}


else if(no == 72)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 4201 AND 4350";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}


else if(no == 71)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 4351 AND 4500";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}


else if(no == 70)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 4501 AND 4650";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}


else if(no == 69)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 4651 AND 4800";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}


else if(no == 68)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 4801 AND 4950";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}


else if(no == 67)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 4951 AND 5100";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}


else if(no == 66)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 5101 AND 5250";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}


else if(no == 65)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 5251 AND 5400";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}


else if(no == 64)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 5401 AND 5550";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}


else if(no == 63)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 5551 AND 5700";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}


else if(no == 62)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 5701 AND 5850";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}


else if(no == 61)
{


    //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
    
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
      conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
       //00//out.println("connected....!!");
       statement = conn1.createStatement();
       //00//out.println("createStatement....!!");
    // sql query to retrieve values from the secified table.
    String QueryString = "SELECT uname,pword from HH where DEVICEID='"+devId+"'";
    //00//out.println(QueryString);
    rs = statement.executeQuery(QueryString);
    
    //00//out.println("excecute Qry....!!");
    
    while (rs.next()) {
    	 //00//out.println("inside While!!");
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
       //00//out.println("Particlar DBconnected....!!");
     
       statement2 = conn2.createStatement();

       //String query = "select * from DS_table";
String query = "SELECT  * FROM    ( SELECT  q.*, rownum rn FROM    ( SELECT  * FROM     DS_table ORDER BY Account_No  ) q  ) WHERE   rn BETWEEN 5851 AND 6000";
        rs2 = statement2.executeQuery(query);
       
        //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
      int i=0;
       while (rs2.next()) 
       {
	String ShrtName ="";
	//if(i<=205)
	{
    	   //00//out.println(rs2.getString("Name"));
	   ShrtName = rs2.getString("Name").replace(',', ' ').replace('^', ' '); 
                
    	   output=output+rs2.getLong("Account_No") + "^" + ShrtName  + "^" + "-" + "^" + rs2.getFloat("Current_Balance") + ",";
	  
 	  
 	   

	}

	i++;
      }
     
       out.println(output);
   
    conn2.close();
   }
   catch(Exception e)
   {
       out.println("Exception : " + e.getMessage() + "");
   }

    
   String[] separated = output.split(",");
   //00//out.println("Output lst ....!!="+output);


   response.addHeader("AustinAndroidReturn", output);
  //00////00//  //00//out.println("Output 2nd ....!!="+output);
    
    

}



    else if(no == 2){
        //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
 
        
        //accno
         float ClAmt=Float.parseFloat(request.getParameter("Collected"));
		 int Acc_No=Integer.parseInt(request.getParameter("Accountno"));
         int accno =Acc_No;
        float collectAmt =ClAmt;//.replace("Rs.", "");// Request.QueryString["Collected"].ToString().Replace("Rs.","");
        String collectDt = request.getParameter("Dt");//Request.QueryString["Dt"].ToString();
        String devId =request.getParameter("did");//Request.QueryString["did"].ToString();
        String userId = request.getParameter("uid");//Request.QueryString["uid"].ToString();
        String Tm = request.getParameter("Tm");//Request.QueryString["Tm"].ToString();
        
        String s=Acc_No+"-"+collectAmt+"-"+collectDt;

        String Uname=null;
    	String Pword=null;
        //Tm

        //'Rs.706.0'

       
        Connection conn1 = null;
        Connection conn2 = null;
        Statement statement = null;
        ResultSet rs = null;
        try
        {
        	
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
            //00//out.println("connected....!!");
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
        }
        
        
        try
        {
        	
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", Uname, Pword);
            //00//out.println("Particlar DBconnected....!!");
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
        }

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
       
        
       
         
         
        
        out.println("fullString : " +resp);
        //String dbn = getDBName(devIdt);
        //File.WriteAllText(Server.MapPath("~/err3.txt"), "dbn");

       // connString = @"Data Source=WINDOWS-3YYCEIU;Initial Catalog=" + dbn + ";UId=sa;Pwd=pisquare";
        //string resp = "2010200096^SRINIVASAN G^OLD NO 1 24C NEWNO 1-208 VISHNUTHOPPU KALANI^338.00,2010200098^ALAGU SUNDARAM P^NO 19 APPAR STREET THIRUVARUR^373.00,2010200100^MEENAKSHI SUNDARAM M^NO 89/1 DHARMA KOIL STREET BACK SIDE^336.00,2010200101^DEVI PRIYA S^NO 16 ERUTHIKARA STREET THIRUVARUR^287.00,2010200107^A.PASUPATHI^106 95/1 PUTHU STREET THIRUVARUR 610002^295.00,2010200103^RAMESH C^74 METTU PALAYAM STREET VIJAYAPURAM^600.00,2010200104^JAYARAMAN P K & KOUSALYA S K^No 16 Mahamaham Tank South^11931.00,2010200105^JAYAKUMAR D^1 50 NEW 74 THIRUKARAVASAL 610202^385.00,2010200106^THILAGAM V^OLD NO 8 NEW NO 61 I P KOVIL SOUTH STREET^867.00,2010200109^SIVA SUBRAMANIYAN M^METTU PALAYAM THIRUVARUR 610001^369.00,2010800001^PRASANTH S^S 9 6 Re Quarters ^151107.00,2010200110^RAMESH V^717 NA MELA VADAMPOKKI THERU^466.00,2010200111^ASHOK KUMAR S^28 1 Sambathamoorthy Pillaiyar Kovil Street^500.00,2010200233^VENKATESAN S^2 27 Main Road Kattur Po^460.00,2010200261^VENKATESAN S^2 27 Main Road Kattur Po^850.00,2010200112^LENIN A^KAKKALANI & KAKKALAN PO KILVELUR TK^289.00,2010200113^BHARANIDHARAN M^No 18 Yaga Salai Street^819.00,2010200121^VIJAY ANAND R^730 KAMARAJ NAGAR 7TH CROSS 6TH STREET^6104.00,2010200131^BASKAR K K^Old No:13 New No:9 Sourastra Nadu Street^16304.00,2010200241^ARJUNAN D^NO 20 V O C STREET THIRUVARUR^22500.00,2010200132^SAGAYAMARY J^NO 22 5 ALIVALAM STREET THIRUVARUR^744.00,2010200133^JAISANKAR R^KARUNANIDHI NAGAR VILAMAL^311.00,2010200134^KUMAR T^NO 535 KAMARAJ STREET PULIVALAM^313.00,2010200136^UBAYADULLA M^4/659 MELACHETTY ST ADIYAKAMANGALAM^289.00,2010200139^SANJEEVI T^249/B KAVERINAGAR NETHAJI COLLEGE RD^289.00,2010200140^RAJALINGAM K^NO 189 MOGANUR PO KEEVALUR TK^289.00,2010200141^MURUGESAN C^NO 24 VANMEEGAPURAM KAMARAJ STREET^778.00,2010200142^RENGARAJAN V^NO 6 1G NORTH STREET PULIVALAM^1914.00,2010200146^VEERA SUNDHARI D^VELANKUDI MARIYAMMAN KOIL ST KILAPADUGA POST^930.00,2010200148^VEERAMANI K^NO 50F THIRUMANJANA VEETHI^476.00,2010200149^BALU T^No 4 G Kambar Street Thiruvarur^6500.00,2010200150^SARAVANAN N K^NO 80F 4B NEDHAJI COLONY THUVARANGURUCHY^338.00,2010200151^VEERASANKAR M^NO II598 KODIYALATHUR THIRUKKUVALAI^732.00,2010200181^SINGARAVELAN R^A S J PALAMUTHIR CHOLAI PAVITHRAMANICKAM^2236.00,2010200172^SELVAKUMAR N^NO 4 34A ADITHIRAVIDAR COLONY KEELAPUTHANOOR 609702^716.00,2010200152^KARTHIKEYAN S M^METTU STREET THIRUVARUR^5179.00,2010200153^RAMALINGAM R^NO 226F BABY TALKIES RAOD THIRUVARUR]^373.00,2010200155^RAVICHANDRAN T^NO 5 APPAR STREET THIRUVARUR^316.00,2010200157^SATHISHKUMAR V^9-34 NORTH KOTHA ST TIRUVARUR^289.00,2010200159^SHANMUGAPANDIYAN K^NO 139 DURGALAYA ROAD THIRUVARUR^289.00,2010200160^SRIDHAR S^11/A New4-11 Anna Nagar Tiruvarur^19100.00,2010200161^THIYAGARAJAN V^No 46-A North Street Thiruvarur^13106.00,2010200162^MUTHUKUMARASAMY D^No 4/1B Madavadiyar Street Thiruvarur^44175.00,2010200163^VANAJA R^NO 717 MELA VADAM POKKI THERU THIRUVARUR^285.00,2010200164^SIVASINGARAVELAN S^NO 2/86 MAIN ROAD PAVITHRAMANICKAM^3300.00,2010200167^SUMATHI J^No 29 Kamalalayam Vadakarai^336.00,2010200168^RAJASEKAR S^NO 21 NEW STREET KODAVASAL (TK)^324.00,2010200169^KANNAN R^NO 44/2 DHARMAKOIL STREET THIRUVARUR^698.00,2010200170^MURUGAVEL S^NO 1-154 VALAIYALKARA STREET VALIVALAM^289.00,2010200171^VINOTH KUMAR S^DKR CABLE TV NETWORK 4311A2AD ROAD^289.00,2010200174^SHAJAHAN G S F^NO 33/C2 THANJAI SALAI THIRUVARUR^3258.00,2010200175^CHELLAPPAN U^NO 225 NEW STREET THIRUVARUR 6100001^337.00,2010200178^RAMACHANDRAN.P^95-74 AYYANAR KOIL STREET TIRUVARUR 610001^310.00,2010200179^DAVID SELVAKUMAR G^5-JASMINE GARDEN RAMCO ROAD TIRUVARUR-610001^289.00,2010200180^PADMA K^2/359 VALLAL SABAPATHI NAGAR THIYANAPURAM^3392.00,2010200183^THIYAGARAJAN M^NO 98 B/2 SGS COMPLEX NEW STREET^289.00,2010200184^SHANKAR.P^3/G PANAGAL ROAD SIVAMNAGAR TIRUVARUR-610001^1064.00,2010200187^RAMESH KUMAR K^NO 1/64 EAST STREET KOODUR^241.00,2010200188^VENKATESAN A^NO 4 THIYAGI SATHYAMOORTHY ST THIRUVARUR 610001^3156.00,2010200189^KALAIVANI T^NO 2/124 THIRU.V.KA NAGAR 3RD STREET^289.00,2010200191^THAMIL SELVI M^OLD NO22B NEW NO7 KAMARAJ STREET THANJAI SALAI^289.00,2010200192^MALLIGA V^NO 63 THANJAVUR ROAD THIRUVARUR^379.00,2010200193^BALRAJ K^NO 2-18D SEMBIYANATHUR AUTHUR SERUNALLUR^660.00,2010200194^KANNAN T EORS MANGALAM^NO 22 NORTH STREET KEEVALOOR^289.00,2010200389^KANNAN T EORS MANGALAM^NO 22 NORTH STREET KEEVALOOR^264.00,2010200195^CHANDRAKUMAR H^NO 6/18 NORTH STREET PULIVALAM^289.00,2010200196^KARTHIK V^NO 93 VADAKKUVEDHI THIRUVARUR 610002^461.00,2010200197^PARAMASIVAM T^NO 230A/5 NETHAJI ROAD THIRUVARUR 610001^315.00,2010200198^VIJAYALAKSHMI N^NO 67 NORTH STREET THIRUVARUR 610001^857.00,2010200585^VIJAYALAKSHMI N^NO 67 NORTH STREET THIRUVARUR 610001^100.00,2010200199^GOPALAKRISHNAN R^KEELAVEETHY THIRUVARUR^289.00,2010200200^DHAKSHINAMOORTHI J^NO 27 KATTUKARA STREET MADAPURAM^289.00,2010200201^KALAIYARASI K^NO 109 THENPULIYUR KULIKARAI 613704^1579.00,2010200002^RAMPRASAD S^16 Mahamagam Tank South Bank^1188.00,2010200003^SUBHA S^No 16 Mahamagam Tank South Bank^400.00,2010200004^SANGARI R^16 Mahamagam Tank South Bank^856.00,2010200005^KRITHIKA R^16 Mahamagam Tank South Bank^300.00,2010200006^INDUMATHI M^3/343 Periyar Nagar Vilamal^300.00,2010200007^MURUGAN T R^7 South New Street ^260.00,2010200009^KARTHIKEYAN S^D Block A1-1C L.B.S Road  Royal Apartment^851.00,2010200010^ANUPRIYA S^East Street Thippirajapuram.^270.00,2010200051^KRISHNAMURTHY V^28 - A Kamalalayam North Bank ^1610.00,2010200012^RAVICHANDRAN G^2 161 KALIYAMMAN KOVIL ST MELA KAPISTHALAM^534.00,2010200015^PICHUMANI N^2 24 SANNATHI ST SRIVANICHIYAM^485.00,2010200016^PREMANAND D^NO 20 MELA VADAMPOKI STREET THIRUVARUR^478.00,2010200019^GANESH G^No 5 Arasavangula Street Thiruvarur^5936.00,2010200020^KAMALA R^NO 6/3/5 KATTALAI THOPPU^7254.00,2010200021^SARALA L^NO 3/54 KATTALAI THOPPU STREET^2178.00,2010200022^SAMINATHAN S^31 A WEST STREET KILVELUR^300.00,2010200023^NARAYANAMOORTHI G^Main Road Kachanan Salai^349.00,2010200029^CHITRA D^28 A Kamalalayam Vadakarai Tvr^746.00,2010200050^DHANASEELAN M^1A 25 A Gandhi Salai Arasu Auto Opposit^250.00,2010200091^VISWANATHAN M & CHANDRA V^Door No 541 Public Office Road Gandhi Naga^3516.00,2010200030^CHANDRASEKARN S^28 A Kamalalayam Vadagarai^35388.00,2010200145^VINOTHKUMAR T^30 BAWA GOPALSAMY STREET THIRUVARUR^405.00,2010200034^NETHAJI N^29 F ANR COMPLEX SOUTH MAIN STREET^619.00,2010200032^RAMASAMY A L^DOOR NO 3 19 KRISHNAN KOVIL STREET^299.00,2010200941^Srinivasan K^No 1 Perumal Kovil Mela Veethi Madapuram Thiruvarur^9492.00,2010200033^VASANTHI C^NO 28A KAMALALAYAM NORTH BANK^1001.00,2010200156^RAJENDRAN V K^125 13 NEW STREET P R M COLONY^374.00,2010200035^BHARATHAN M^No 24 Shiyama Street Thiruvarur^2650.00,2010200036^SYEED ABDHULKATHAR E^DOOR NO 2 157 KELATH STREET^299.00,2010200038^THIYAGARAJAN S^NORTH THANDALAI ADIDRAVIDAR THANDALAI THIRUVARUR^397.00,2010200190^THIYAGARAJAN S^NORTH THANDALAI ADIDRAVIDAR THANDALAI THIRUVARUR^324.00,2010200274^THIYAGARAJAN S^NORTH THANDALAI ADIDRAVIDAR THANDALAI THIRUVARUR^3804.00,2010200040^KAVIYARASAN R^DOOR NO 6 3 5 KATTALAI THOPPU TIRUVARUR^2058.00,2010200825^Santhi R^65A Mainroad Sorutaiyan Vaikal Kalyanapuram 2Nd Chethi^520.00,2010200041^NATARAJAN R^36 SIVASAKTHI NAGAR VANDAMPALAI^55.00,2010200042^SARABOJI S^1 99 KARANCHERRY KATTUR^528.00,2010200043^MARIYAPPAN K^31 MARUTHI NAGAR KAMBAR STREET LAST TIRUVARUR^4807.00,2010200045^BALU M^2/55 PAZHAVANGUDI TIRUVARUR TK^299.00,2010200046^BHUVANESWARI JK^S 9/6 Re Quarters Metturdam^13305.00,2010200336^MAHADEVAN R^449 Mainroad Kudithangi Cherry Post^1062.00,2010200047^VISWANATHAN S^27B Durgalaya Road Tiruvarur^7149.00,2010200049^MOHANDOSS S^1/112 VANIA STREET SEMBIAN MAHADEVI^299.00,2010200052^MANIKANDAN R^NESAVALAR COLONY AMMAIYAPPAN^299.00,2010200256^MANIKANDAN R^NESAVALAR COLONY AMMAIYAPPAN^397.00,2010200054^BALAJI T^NO 68 SAPAPATHI STREET THIRUVARUR^310.00,2010200057^GANESAN V^NO 38 BALAJI NAGAR THIRUVARUR^2356.00,2010200058^IYAPPAN M^NO 70 E DHURGALAYA ROAD THIRUVARUR^583.00,2010200060^RAMESHKUMAR T^NEW RAYMAND TAILOR NORTH STREET^385.00,2010200059^AMMANULLA A^NO 27/30 INDIRA NAGAR STREET KORADACHERI(TP)^1573.00,2010200061^MUTHUKUMAR T^NO 26 AMMA THOPPU DURGALAYA ROAD^4125.00,2010200062^MANIKANDAN M^VELLARI THOPPU PERALAM P^54.00,2010200281^MANIKANDAN M^VELLARI THOPPU PERALAM P^635.00,2010200063^SIVAKUMAR R^49 BOWNDU STREET THIRUKKANAMANGAI^420.00,2010300004^THIYAGARAJAN R^DOOR NO 11/6A KULUNTHAKULAM KEELKARAI^700.00,2010200069^KALIMUTHU S^NO 42 NEIVILAKKU THOUPU THIRUVARUR^475.00,2010200070^RENGANAYAGI S&GOPALAKRISHNAN^NO 23/23 NALLAPPAR NAGAR THIRUVARUR-610001^297.00,2010200076^JAYAVEERAPATHY B^OLD NO:1-9 1/202 AADHIDRAVIDAR ELAVANGARKUDI^491.00,2010200079^SENTHILKUMAR P^29/3 KEELAVEETHI THIRUVARUR^358.00,2010200080^DURGADEVI D K^1094 WEST NEW STREET NATCHIYAR KOIL 612602^325.00,2010200081^JAYABAL R^2/21 NEW NO 216 MAIN ROAD KEELAPADUGAL^297.00,2010200083^SUBRAMANIYAN S^4 68 SOUTH STREET VALUVUR PO^297.00,2010200082^N SARAVANAN^Old No 72 New No 74 North Street^754.00,2010201012^VAIDYANATHAN V T^Old No.51  New No.29 Samanthamoorthi P Co Street ^2400.00,2010200086^VIJAYAKUMAR G^126 DURGALAYA ROAD THIRUVARUR^296.00,2010200296^MURUGANANTHAM D^206 A PAJANAIMADA STREET ALIVALAM^698.00,2010200087^PALANI M^10 A VERUPATCHI NADAPU STREET^354.00,2010200088^AKILANDESWARIR EORS KARTHIKEYA^1/185 NORTH STREET VADAPATHYMANGALAM^297.00,2010200089^SIVAKUMAR V^1/86 New No 2/499 Samathuvapuram^662.00,2010200092^KUMARESAN D^3/7 PAZHAVANAKUDI PAZHAVANAKUDI(PO)^323.00,2010200090^KUMARAVELAN P^OLD NO 18 B1 NEW NO 60 KUDAVASAL ROAD^296.00,2010200093^KANNAN V^63 THANJAVUR ROAD THIRUVARUR^397.00,2010200094^MAMALLAN N^44D METTU PALAYAM STREET VIJAYAPURAM PO^1534.00,2010200095^SATHISHKUMAR S^271 A NORTH STREET VALIVALAM VILLAGE PO^296.00,2010200319^BALAMURUGAN K^NO 15-C KAKITHAKKARA STREET THIRUVARUR 2^20711.00,2010200292^SAROJA B & BAKKIRISAMY S^OLD NO 59 NEW NO 18 KAMBAR STREET^363.00,2010200957^Thangamani G^No 12H Mananthaiyar Street ^30297.00,2010200294^MUTHUKUMARAN S^NO 115 DURGALAYA ROAD THIRUVARUR^300.00,2010200295^NATARAJAN K^NO 8 ERUTHIKKARA STREET THIRUVRUR 610002^412.00,2010200297^NAVEEN SHARMA D^NO 3/634 AASARI STREET MARUTHAPPATINAM^170.00,2010200299^ARUL PRAKASAM R V^PLOT NO 10 ARUMUGAM NAGAR KUMARAN STREET^559.00,2010200301^THIRUMARAN R^NO 12C/1 S M PILLAIYAR KOIL ST THIRUVARUR^344.00,2010200303^MANIKANDAN S^No 25 Kamalalayam North Bank Thiruvarur^553.00,2010200305^VASU C^NO 9 NEW NO 23 EAST STREET THIRUVARUR 610001^390.00,2010200306^BABU N^No 28 Kambar Street Thiruvarur^3200.00,2010200307^GANESHAN K^NO 13 A MARIYAMMAN KOIL STREET THIRUVARUR 631561^339.00,2010200308^SAKTHIVEL N^No 31 Durgalaya Road Thiruvarur 610001^1595.00,2010200311^VIJAYAKUMAR A^NO 7B/2 DURGALAYA ROAD THIRUVARUR 610002^443.00,2010200313^NATHAR S^NO 22G KAPPAKARA COLONY MELA KOTHA STREET^306.00,2010200314^MOORTHY K^NO 130 LINGAVASAL STREET PANANGUDI PO^333.00,2010200316^CHANDRA SHEKAR S^1 72 MUDALIYAR STREET ELUPPUR^345.00,2010200318^BALASUBRAMANIYAN L^NO 8A KAMATCHI AMMAN KOIL ST THIRUVARUR 610001^442.00,2010200321^KALANDAR BADUSHA A^No 15H Jinna Street Thiruvarur^25000.00,2010201044^Kalandar Badusha A^No 15H Jinna Street Thiruvarur^31000.00,2010200323^THIYAGARAJAN B^NO 3-C VRN BUILDING THIRUVARUR 610002^823.00,2010200445^SELVAM S^6-222 KALLADI THOPU STREET  PULIVALAM ^4100.00,2010200326^CHANDRASEKARAN M^OLD NO 2-55A NEW NO 2-156 DIYANAPURM KUDIYANA STREET^347.00,2010200327^KIRUTHIKA G^NO 82 EAST STREET SEMANGUDI PO^343.00,2010200328^DAKSHINAMOORTHI G^NO 1B MADAVADIYAR STREET THIRUVARUR^674.00,2010200459^SATHAM HUSSAIN A^NO 17/1 SOUTH STREET KODIKAL PALAYAM^257.00,2010200329^AROKIYADOSS E^NO 2/8 PAVITHIRAMANIKAM ELAVANGARKUDI PO^4326.00,2010200562^VALLI S^NO 29C/29C KAMALALAYAM NORTH BANK^100.00,2010200331^SUMATHI P EORS PALANIVEL P^No 8 Perumal Kovil Street Madapuram^6135.00,2010200332^MARIYAPPAN J^NO 19 VANDIKARA STREET THIRUVARUR 610002^1531.00,2010200333^SARAVANASANKAR S^NO 29A AYYANAR KOVIL STREET PULIVALAM^921.00,2010300034^SARAVANASANKAR S^NO 29A AYYANAR KOVIL STREET PULIVALAM^6400.00,2010200334^BALAMURUGAN T^NO 3/210 BAJANAMADA STREET ALIVALAM^269.00,2010200335^KAMALAVENI D^No 5E Ayyanar Kovil Street Thiruvarur 610001^354.00,2010200337^SHEELA DEVI K^2/90 MAIN ROAD THIPPANAMPETTAI^270.00,2010200338^KALAISELVI R^NO 63B INDHIRA COLONY SBT OPP NATHAM COLONY^324.00,2010200339^Manikandan S^No 7 First Main Road Moogambigai Nagar^759.00,2010200340^RENGACHARY T N^No 53 Gothanda Ramasami Kovil Street^323.00,2010200342^ANBZHILAI R^NO 312 EAST STREET KEEZHAPADUGAI^108.00,2010200343^THIYAGARAJAN R^NO 8A SWAMY MADATHERU THIRUVARUR 610001^282.00,2010200344^NAGARAJAN S^No 1.217A Mudaliyar Street Kattur^268.00,2010200345^RAJOO M J^No 7 Vasam Nagar East Sannathi Street^3011.00,2010200346^RAVI CHANDRAN S^NO 8 APPAR STREET THIRUVARUR 610001^270.00,2010200347^SUNDARARAJU S^NO 20 I.P.KOVIL SOUTH STREET THIRUVARUR 610001^268.00,2010200348^KARTHIGA D^NO 18 MUDUKKU STREET THIRUVARUR 610001^268.00,2010200349^THILAGAVATHI H^NO 17/3 MUDUKKU STREET THIRUVARUR 610001^268.00,2010200350^REVATHI S^NO 6/3 JAITHUN COLONY PIDARI KOIL STREET^268.00";
        //accno = "Accno1^Amt^Date^ReceiptNo,Accno2^Amt^Date^ReceiptNo,";
         String Uname=null;
    	String Pword=null;
        
         Connection conn1 = null;
        Connection conn2 = null;
        Statement statement = null;
        ResultSet rs = null;
        try
        {
        	
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
            //00//out.println("connected....!!");
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
        
    	
       
    	//out.println("Uname="+Uname);
    	//out.println("Pword="+Pword);
    	out.println("resp="+resp);
        String[] rcpt = resp.split("-");
       
        out.println("rcpt.length="+rcpt.length);
        out.println("rcpt[0]="+rcpt[0]);
        
        
        for (int i = 0; i < rcpt.length; i++)
        {
        	String IndRecord=rcpt[i];
        	  out.println("IndRecord="+IndRecord);
        	String[] ds = IndRecord.split("\\|");
        	out.println("ds.length="+ds.length);
        	out.println("ds[0]="+ds[0]);
        	out.println("ds[1]="+ds[1]);
        	out.println("ds[2]="+ds[2]);
        	out.println("ds[3]="+ds[3]);
        	
        	
        	String accno = ds[0];
        	String collectAmt = ds[1];
        	String collectDt = ds[2];
        	String devId = request.getParameter("did");///Request.QueryString["did"].ToString();
        	String userId = request.getParameter("uid");///Request.QueryString["uid"].ToString();
           
        	String receipt_no = ds[3];
        	String Tm = request.getParameter("Tm");///Request.QueryString["Tm"].ToString();
        	String Status = "Y";
        	out.println("accno="+accno);
        	out.println("collectAmt="+collectAmt);
        	out.println("collectDt="+collectDt);
        	out.println("devId="+devId);
        	out.println("userId="+userId);
        	out.println("receipt_no="+receipt_no);
            //'Rs.706.0'

           // String query = "update DS_table set Collected_Amt='" + collectAmt + "',Collected_Date='" + collectDt + "',device_id='" + devId + "',UserId='" + userId + "',Collection_Status='" + Status + "',timeofentry='" + Tm + "'  where Account_No='" + accno + "'";
           //-//File.WriteAllText(Server.MapPath("~/data.txt"), query);
            //now done?s

            	
            	 try
             {
        	
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", Uname, Pword);
            //00//out.println("Particlar DBconnected....!!");
            statement = conn2.createStatement();
            
            
            
           String query = "update DS_table set Collected_Amt='" + collectAmt + "',Collected_Date=to_date('" + collectDt + "','yyyyMMdd'),device_id='" + devId + "',UserId='" + userId + "',Collection_Status='" + Status + "',timeofentry='" + Tm + "'  where Account_No='" + accno + "'";
         //  String query2 = "insert into testtable1 values('"+accno+"')";
             
             
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
            output += receipt_no + ",";
            
        }
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
    else if(no == 5){
        //00//out.println("Hello Ur Action Type is= <b>"+request. getParameter("type")+"</b>");
        
       
        String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
        String Uname=null;
		 	String Pword=null;
    
     Connection conn1 = null;
     Statement statement = null;
     ResultSet rs = null;
     try
     {
     	
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
         //00//out.println("connected....!!");
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
     }
     
     Connection conn2 = null;
     Statement statement2 = null;
     ResultSet rs2 = null;
     String output = "";
     try
     {
     	
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", Uname, Pword);
         //00//out.println("Particlar DBconnected....!!");
       //  out.println("Uname....!!"+Uname);
       //  out.println("Pword!"+Pword);
         statement2 = conn2.createStatement();
  
         String query = "SELECT rs.account_no,rs.Transaction_date,TDate,Transaction_amount,Transaction_type FROM (SELECT account_no,to_char(transaction_date,'dd/MM/yyyy') as Transaction_date,Transaction_date as TDate,Transaction_amount,case when  Transaction_type='Credit' then 'Cr' else 'Dr' End as Transaction_type,Rank() over (Partition BY account_no ORDER BY Transaction_Date DESC,Transaction_Id DESC) AS Rank FROM daily_transaction where (Flag <> 'GL') and Page_source in('SBI','SBC','SBT','SBP')) rs WHERE Rank <= 10 UNION select Account_No,to_char(Last_Transaction_Date,'dd/MM/yyyy') as Transaction_date,Last_Transaction_Date as TDate,Closing_Balance as Transaction_amount,'OS' AS Transaction_type from SBCA_Master order by account_no,TDate,Transaction_type asc";
          rs2 = statement2.executeQuery(query);
         
          //dt.Rows[i]["Account_No"].ToString() + "^" + dt.Rows[i]["Name"].ToString().Replace(',', ' ').Replace('^', ' ') + "^" + "-" + "^" + dt.Rows[i]["Current_Balance"].ToString() + ",";
         
         while (rs2.next()) 
         {
        	 out.println("while!");
            // if (rs2.getInt("Account_No") != 2010200242 || rs2.getInt("Account_No") != 2010200261 || rs2.getInt("Account_No") != 2010200270)

      	   output=output+rs2.getInt("Account_No")+ "^" + rs2.getString("Transaction_date") + "^" + rs2.getFloat("Transaction_amount") + "^" + rs2.getString("Transaction_type") + ",";  
        	}
       
         out.println(output);
     
      conn2.close();
     }
     catch(Exception e)
     {
         out.println("Exception : " + e.getMessage() + "");
     }

      
     String[] separated = output.split(",");
     
     for (int j = 0; j < separated.length; j++)
     {
		 out.println("Mini Statement="+separated[j]);
     }

     response.addHeader("AustinAndroidReturn", output);
      
      
        
        
       

        
    }


else if (no == 124) {
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
				        conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");					
					//out.println("connected....!!");
					statement = conn1.createStatement();

					String QueryString = "Select Branch_Name,Customer_Name,to_char(Due_Date,'dd/MM/yyyy') as Due_Date,Pending_Days,Os+Interest as Os from JL_OD_LIST_MOB where OS_DATE='"+ Dt + "' order by Branch_Code";
					//out.println(QueryString);

					try{
						
					rs = statement.executeQuery(QueryString);
					//out.println("<b>start</b>");
					JSONArray array=new JSONArray();
					while (rs.next()) {
						    JSONObject obj = new JSONObject();
			                obj.put("Branch",rs.getString(1));
			                obj.put("Name",rs.getString(2));
			                obj.put("Due_Date",rs.getString(3));
			                obj.put("Pending_Days",rs.getString(4));
			                obj.put("Os",rs.getString(5));
			               // array.add(obj);
			                array.add(obj);
					}
					
					statement2 = conn1.createStatement();
					String QueryString2 ="Select 'TOTAL' as Branch_Name,'' as Customer_Name,'' as Due_Date,NULL as Pending_Days,sum(Os+Interest) as Os from JL_OD_LIST_MOB where OS_DATE='"+ Dt + "'";

					rs2 = statement2.executeQuery(QueryString2);
					while (rs2.next()) {
						JSONObject obj = new JSONObject();
						obj.put("Branch",rs2.getString(1));
		                obj.put("Name",rs2.getString(2));
		                obj.put("Due_Date",rs2.getString(3));
		                obj.put("Pending_Days",rs2.getString(4));
		                obj.put("Os",rs2.getString(5));
		               // array.add(obj);
		                array.add(obj);

					}

					
					conn1.close();
					
					out.println(array);
					
					
					}catch(SQLException e){
				        out.print("Exception: "+e);
				    }
					/*
					
					*/
					
					
				} catch (Exception e) {

				}

				output = Be;

				out.println("<b>" + output + "</b>");
				
				response.addHeader("AustinAndroidReturn", output);

			}

			else if (no == 125) {
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
					conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");	
					//out.println("connected....!!");
					
					//-------------------------------------------------------------------------------------
				 statement2 = conn1.createStatement();
				int count1=0;
				String countqry = "select count(*) from DG_Login_Details where DEVICEID='"+devId+"' and user_type='Tablet' ";
				//out.println(countqry);
				rs2 = statement2.executeQuery(countqry);
					while (rs2.next())
					count1=rs2.getInt(1);
				if(count1 !=0)
				{
					statement = conn1.createStatement();

					String QueryString = "Select Branch_Code,Branch_Name,count(*) as cnt,sum(Os+Interest) as Os from JL_OD_LIST_MOB where OS_DATE='"+ Dt + "' group by Branch_Code,Branch_Name order by Branch_Code";
					//out.println(QueryString);

					try{
						
					rs = statement.executeQuery(QueryString);
					//out.println("<b>start</b>");
					JSONArray array=new JSONArray();
					while (rs.next()) {
						    JSONObject obj = new JSONObject();
			                obj.put("Branch",rs.getString(2));
			                obj.put("Count",rs.getString(3));
			                obj.put("Os",rs.getString(4));
			               // array.add(obj);
			                array.add(obj);
					}
					
					statement2 = conn1.createStatement();
					String QueryString2 ="Select 'Total' as Branch_Name,count(*) as cnt,sum(Os+Interest) as Os from JL_OD_LIST_MOB where OS_DATE='"+ Dt + "'";

					rs2 = statement2.executeQuery(QueryString2);
					while (rs2.next()) {
						JSONObject obj = new JSONObject();
						obj.put("Branch",rs2.getString(1));
						obj.put("Count",rs2.getString(2));
		                obj.put("Os",rs2.getString(3));
		               // array.add(obj);
		                array.add(obj);

					}

					
					conn1.close();
					
					out.println(array);
					
					
					}catch(SQLException e){
				        out.print("Exception: "+e);
				    }
				}//check_count
					/*
					
					*/
					
					
				} catch (Exception e) {

				}

				output = Be;

				out.println("<b>" + output + "</b>");
				
				response.addHeader("AustinAndroidReturn", output);

			}

else if (no == 127) {
				
				String Be = "";
				String output = "";

				String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
				String CDate = request.getParameter("Dt");
				String Dt = CDate;//CDate.substring(4,2);
				//out.println("Date is= <b>" + Dt + "</b>");
				
				Connection conn1 = null;
				Connection conn2 = null;

				Statement statement = null;
				Statement statement2 = null;
				ResultSet rs = null;
				ResultSet rs2 = null;
				try {

					Class.forName("oracle.jdbc.driver.OracleDriver");
         				conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
				         //00//out.println("connected....!!");
						 
//-------------------------------------------------------------------------------------
				

                                conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dbuser1","dbpwd1");
 				statement2 = conn2.createStatement();
				int count1=0;
				String countqry = "select count(*) from DG_Login_Details where DEVICEID='"+devId+"' and user_type='Tablet' ";
				//out.println(countqry);
				rs2 = statement2.executeQuery(countqry);
					while (rs2.next())
					count1=rs2.getInt(1);
				conn2.close();

				if(count1 !=0)
				{
				         statement = conn1.createStatement();

					// sql query to retrieve values from the secified table.
				//	String QueryString = "Select Branch_Name||','||Abs(GET_GL_CB2_VIEW(Branch_Code,29000,'"+ Dt + "'))||','||Abs(GET_GL_CB2_VIEW(Branch_Code,29006,'"+ Dt + "'))||',0' as Cash from Branch_Master order by Branch_Code";
					//05-06-2023
					//String QueryString = " Select Branch_Name||','||Abs(GET_GL_CB2_VIEW(Branch_Code,29000,'"+ Dt + "'))||','||Abs(GET_GL_CB2_VIEW(Branch_Code,29006,'"+ Dt + "'))||',' ||Abs(GET_GL_CB2_VIEW(Branch_Code,(select gl_code from cash_hub_detail where bcode=Branch_Code),'"+ Dt + "')) as Cash from Branch_Master order by Branch_Code";
					//String QueryString = "Select Branch_Name||','||Abs(GET_GL_CB2_VIEW(Branch_Code,29000,'"+ Dt + "'))||','||Abs(GET_GL_CB2_VIEW(Branch_Code,29006,'"+ Dt + "'))||',' ||nvl(Abs(GET_GL_CB2_VIEW(Branch_Code,gl.gl_code,'"+ Dt + "')),0) as Cash from Branch_Master left join (select gl_code,bcode from cash_hub_detail where gl_code !=0)gl on Branch_Code=gl.bcode order by Branch_Code";
					String QueryString = "Select Branch_Name||','||CASH||','||SK_CASH||',' ||CASH_HUB from Daily_CB where CB_Date='"+ Dt + "' order by Branch_Code";

					//out.println(QueryString);

					rs = statement.executeQuery(QueryString);
					while (rs.next()) {
						Be += rs.getString(1)+"^";

					}
					//conn1.close();
					
					
					statement2 = conn1.createStatement();
					//String QueryString2 = "Select 'Total'||','||Abs(GET_GL_CB2_VIEW('%',29000,'"+ Dt + "'))||','||Abs(GET_GL_CB2_VIEW('%',29006,'"+ Dt + "'))||',0' as Cash from dual";
					//05-06-2023
					//String QueryString2 =" Select 'Total'||','||Abs(GET_GL_CB2_VIEW('%',29000,'"+ Dt + "'))||','||Abs(GET_GL_CB2_VIEW('%',29006,'"+ Dt + "'))||','|| (select sum(Abs(GET_GL_CB2_VIEW(bcode, gl_code,'"+ Dt + "'))) from cash_hub_detail WHERE gl_code!=0 )as CASH FROM DUAL";
					String QueryString2 ="Select 'Total'||','||sum(CASH)||','||sum(SK_CASH)||',' ||sum(CASH_HUB) from Daily_CB where CB_Date='"+ Dt + "'";

					
					rs2 = statement2.executeQuery(QueryString2);
					while (rs2.next()) {
						Be += rs2.getString(1);

					}
					conn1.close();
				}//Count Check
					
					
				} catch (Exception e) {

				}

				output = Be;

				out.println("<b>" + output + "</b>");
				
				response.addHeader("AustinAndroidReturn", output);

			}

			else if (no == 126) 
			{
				//out.println("Hello Ur Action Type is= <b>"
						//+ request.getParameter("type") + "</b>");

				String Be = "";
				String output = "";

				String devId = request.getParameter("did");//Request.QueryString["did"].ToString();
				//String CDate = request.getParameter("Dt");
				//String Dt = CDate;//CDate.substring(4,2);
				//out.println("Date is= <b>" + Dt + "</b>");
				
				Connection conn1 = null;
Connection conn2 = null;

				Statement statement = null;
				Statement statement2 = null;
				ResultSet rs = null;
				ResultSet rs2 = null;
				try {

					Class.forName("oracle.jdbc.driver.OracleDriver");
				        conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:snknl", "dbuser1","dbpwd1");
					//out.println("connected....!!");
					//-------------------------------------------------------------------------------------
				 conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dbuser1","dbpwd1");
 				statement2 = conn2.createStatement();
				int count1=0;
				String countqry = "select count(*) from DG_Login_Details where DEVICEID='"+devId+"' and user_type='Tablet' ";
				//out.println(countqry);
				rs2 = statement2.executeQuery(countqry);
					while (rs2.next())
					count1=rs2.getInt(1);

				conn2.close();
				if(count1 !=0)
				{
					statement = conn1.createStatement();

					String QueryString = "Select Branch_Name,count(*) as Count,to_char(Round(sum(Gross_Weight),3),'9999999999.999') as Gross_Weight,sum(-1*Closing_Balance) as Os from JL_Master_View a left join Branch_Master b on a.Branch_Code=b.Branch_Code where Account_Status='A' group by a.Branch_Code,Branch_Name order by a.Branch_Code";
					//out.println(QueryString);

					try{
						
					rs = statement.executeQuery(QueryString);
					//out.println("<b>start</b>");
					JSONArray array=new JSONArray();
					while (rs.next()) {
						    JSONObject obj = new JSONObject();
			                obj.put("Branch",rs.getString(1));
			                obj.put("Count",rs.getString(2));
			                obj.put("Gr_Wt",rs.getString(3));
			                obj.put("Os",rs.getString(4));
			               // array.add(obj);
			                array.add(obj);
					}
					
					statement2 = conn1.createStatement();
					String QueryString2 ="Select 'Total' as Branch_Name,count(*) as Count,to_char(Round(sum(Gross_Weight),3),'9999999999.999') as Gross_Weight,sum(-1*Closing_Balance) as Os from JL_Master_View where Account_Status='A'";

					rs2 = statement2.executeQuery(QueryString2);
					while (rs2.next()) {
						JSONObject obj = new JSONObject();
						obj.put("Branch",rs2.getString(1));
		                obj.put("Count",rs2.getString(2));
		                obj.put("Gr_Wt",rs2.getString(3));
		                obj.put("Os",rs2.getString(4));
		               // array.add(obj);
		                array.add(obj);

					}

					
					conn1.close();
					
					out.println(array);
					
					
					}catch(SQLException e){
				        out.print("Exception: "+e);
				    }
				}//Check_Count
					/*
					
					*/
					
					
				} catch (Exception e) {

				}

				output = Be;

				out.println("<b>" + output + "</b>");
				
				response.addHeader("AustinAndroidReturn", output);

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
				Connection conn2 = null;

				Statement statement = null;
				Statement statement2 = null;
				ResultSet rs = null;
				ResultSet rs2 = null;
				try {

					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn1 = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:snknl",
							"dbuser1", "dbpwd1");
					//out.println("connected....!!");
					statement = conn1.createStatement();
//-------------------------------------------------------------------------------------
				  conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dbuser1","dbpwd1");
 				statement2 = conn2.createStatement();
				int count1=0;
				String countqry = "select count(*) from DG_Login_Details where DEVICEID='"+devId+"' and user_type='Tablet' ";
				//out.println(countqry);
				rs2 = statement2.executeQuery(countqry);
					while (rs2.next())
					count1=rs2.getInt(1);
				conn2.close();

				if(count1 !=0)
				{
					String QueryString = "Select Branch_Code,Branch_Name,count(*) as cnt,sum(Os+Interest) as Os from JL_OD_LIST_MOB where OS_DATE='"+ Dt + "' and NVL(case when Period_Months=180 then 6 else case when Period_Months=90 then 3 else Period_Months End End,0) like '"+mon+"%' group by Branch_Code,Branch_Name order by Branch_Code";
					//out.println(QueryString);

					try{
						
					rs = statement.executeQuery(QueryString);
					//out.println("<b>start</b>");
					JSONArray array=new JSONArray();
					while (rs.next()) {
						    JSONObject obj = new JSONObject();
			                obj.put("Branch",rs.getString(2));
			                obj.put("Count",rs.getString(3));
			                obj.put("Os",rs.getString(4));
			               // array.add(obj);
			                array.add(obj);
					}
					
					statement2 = conn1.createStatement();
					String QueryString2 ="Select 'Total' as Branch_Name,count(*) as cnt,NVL(sum(Os+Interest),-1) as Os from JL_OD_LIST_MOB where OS_DATE='"+ Dt + "'  and NVL(case when Period_Months=180 then 6 else case when Period_Months=90 then 3 else Period_Months End End,0) like '"+mon+"%'";

					rs2 = statement2.executeQuery(QueryString2);
					while (rs2.next()) {
						JSONObject obj = new JSONObject();
						obj.put("Branch",rs2.getString(1));
						obj.put("Count",rs2.getString(2));
		                obj.put("Os",rs2.getString(3));
		               // array.add(obj);
		                array.add(obj);

					}

					
					conn1.close();
					
					out.println(array);
					
					
					}catch(SQLException e){
				        out.print("Exception: "+e);
				    }
					/*
					
					*/
				}//Count_Check
					
				} catch (Exception e) {

				}

				output = Be;

				out.println("<b>" + output + "</b>");
				
				response.addHeader("AustinAndroidReturn", output);

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
	Connection conn2 = null;

	Statement statement = null;
	Statement statement2 = null;
	ResultSet rs = null;
	ResultSet rs2 = null;
	try {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn1 = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:snknl",
				"dbuser1", "dbpwd1");
		//out.println("connected....!!");
		statement = conn1.createStatement();
		
//-------------------------------------------------------------------------------------
   			    conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dbuser1","dbpwd1");
 				statement2 = conn2.createStatement();
				int count1=0;
				String countqry = "select count(*) from DG_Login_Details where DEVICEID='"+devId+"' and user_type='Tablet' ";
				//out.println(countqry);
				rs2 = statement2.executeQuery(countqry);
					while (rs2.next())
					count1=rs2.getInt(1);
				conn2.close();
				if(count1 !=0)
				{
	//String QueryString = "select a.*,SUBSTR(a.col_two, 1, INSTR(a.col_two, '.')-1) AS time1,SUBSTR(a.col_two, INSTR(a.col_two, ' ')+1) AS ampm from (SELECT SUBSTR(daily_cb.Created_date, 1, INSTR(daily_cb.Created_date, ' ')-1) AS col_one, SUBSTR(daily_cb.Created_date, INSTR(daily_cb.Created_date, ' ')+1) AS col_two FROM daily_cb where CB_Date='"+Dt+"' and branch_code='201')a";
	//13-06-2023
	String QueryString="select b.time1,b.ampm,SUBSTR( b.time1, 1, INSTR(b.time1, ':',1,2)-1) as withoutsec from (select a.*,SUBSTR(a.col_two, 1, INSTR(a.col_two, '.')-1) AS time1,SUBSTR(a.col_two, INSTR(a.col_two, ' ')+1) AS ampm from (SELECT SUBSTR(daily_cb.Created_date, 1, INSTR(daily_cb.Created_date, ' ')-1) AS col_one, SUBSTR(daily_cb.Created_date, INSTR(daily_cb.Created_date, ' ')+1) AS col_two FROM daily_cb where CB_Date='"+Dt+"' and branch_code='201')a)b";
	
	
	//	out.println(QueryString);

		rs = statement.executeQuery(QueryString);
		while (rs.next()) {
			Be +=rs.getString(3)+"^"+rs.getString(2)+"^TIME";

		}
		//conn1.close();
		
	
		conn1.close();
				}//Count Check
		
	} catch (Exception e) {

	}

	output = Be;

	out.println("<b>" + output + "</b>");
	
	response.addHeader("AustinAndroidReturn", output);

}

else if (no == 130) {
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
						conn1 = DriverManager.getConnection(
								"jdbc:oracle:thin:@localhost:1521:snknl",
								"dbuser1", "dbpwd1");
						//out.println("connected....!!");
						statement = conn1.createStatement();
						statement2 = conn1.createStatement();
	                          //-------------------------------------------------------------------------------------
					int count1=0;
					String countqry = "select count(*) from DG_Login_Details where DEVICEID='"+devId+"' and user_type='Tablet' ";
					//out.println(countqry);
					rs2 = statement2.executeQuery(countqry);
						while (rs2.next())
						count1=rs2.getInt(1);
					//if(count1 !=0)
					//{


						//String QueryString = "select rownum as Sno, three.Branch,three.Customer_Name,three.Transaction_Amount,three.Bank_Name,three.Verified_By_3 from (select k.* from (select two.Branch,two.Customer_Name,two.Transaction_Amount,two.Bank_Name,two.Verified_By_3, 2 as type1,two.Branch_Code from (select main_qry.Transaction_Date,main_qry.Branch_Code,main_qry.Branch,main_qry.Transaction_Id,Attach.Customer_Name,Attach.Mobile_No,main_qry.Account_Desc,main_qry.Transaction_Amount,main_qry.UTR_Bank,main_qry.UTR,main_qry.Verified_By_3 ,Attach.BANK_ACC_NO,Attach.BANK_ACC_NAME,Attach.BANK_IFSC_CODE,Attach.BANK_NAME,Attach.PURPOSE,Attach.ACCOUNT_CODE,Attach.Customer_Id from (select a.Transaction_Id,a.Transaction_Date,a.Created_By,a.Time_Info,a.Authorized_By,a.Authorized_Time,a.Verified_By,a.Verified_Time,a.Verified_By_3,a.Verified_3_Time,a.Verified_By_4,a.Verified_4_Time,a.Verified_By_5 ,a.Verified_5_Time,(select Branch_Name from Branch_Master where Branch_Code=a.Branch) as Branch,a.Account_Desc,a.transaction_Amount,case when (a.page_source='EOM' or b.voucher_type is null) THEN 'Adjustment' ELSE  case when a.page_source='SBP' then 'Payment' else b.voucher_type end end as voucher_type,case when a.page_source='EOM' THEN 'EOM Transacrion' else case when a.page_source='SBP' then 'SD Int Posting' else Case when b.mode1 is null then a.page_source else b.trfr_acc_type end end end as Mode1,b.trfr_acc_no,b.trfr_acc_type ,b.utr,b.utr_bank,a.Branch as Branch_Code from (Select Transaction_Id,Transaction_Date,Created_By,Time_Info,Authorized_By,Authorized_Time,Verified_By,Verified_Time,Verified_By_3,Verified_3_Time,Verified_By_4,Verified_4_Time,Verified_By_5 ,Verified_5_Time,Branch,transaction_date as tdate,transaction_particulars,transaction_amount,Account_Desc,page_source From DAILY_TRANSACTION_LOG Where Part_Tran_Id=1 and Transaction_Date = to_date('"+ Dt + "','dd/MM/yyyy')  and to_char(Branch) like '2%' order by branch,Transaction_Date desc,to_number(substr(to_char(Transaction_Id),-5,5)) desc)a   left join (select branch, transaction_id,transaction_date,voucher_type,mode1,trfr_acc_no,trfr_acc_type,utr,utr_bank from voucher_print_view  where utr is not null and Transaction_Date = to_date('"+ Dt + "','dd/MM/yyyy')  and to_char(Branch) like '2%' )b on a.transaction_id=b.transaction_id  and a.branch=b.branch and a.transaction_date=b.transaction_date and b.utr_bank is not null )main_qry right join (select a.*,cus.Customer_Name,cus.Mobile_No from (select Transaction_id,Transaction_Date,branch,BANK_ACC_NO,BANK_ACC_NAME,BANK_IFSC_CODE,BANK_NAME,PURPOSE,ACCOUNT_CODE,Customer_id from Savings_Attachments where Transaction_Date = to_date('"+ Dt + "','dd/MM/yyyy')  and to_char(Branch) like '2%' and type='B' )a left join (select customer_id,Customer_Name,Mobile_no from Customer_view where Mig_Flag in ('N','No'))cus on a.Customer_Id=cus.Customer_Id )Attach on main_qry.Transaction_id=Attach.Transaction_id and main_qry.Transaction_Date=Attach.Transaction_Date and main_qry.Branch_Code=Attach.Branch order by main_qry.Branch_Code )two where two.Branch is not null order by two.Branch_Code)k  union select 'Total ' as Branch,'' as Customer_Name,sum(Transaction_Amount) as Transaction_Amount,'' as Bank_Name,'' as Verified_By_3,1 as type1,200 as bRanch_Code from (select  main_qry.Transaction_Date,main_qry.Branch_Code,main_qry.Branch,main_qry.Transaction_Id,Attach.Customer_Name,Attach.Mobile_No,main_qry.Account_Desc,main_qry.Transaction_Amount,main_qry.UTR_Bank,main_qry.UTR,main_qry.Verified_By_3 ,Attach.BANK_ACC_NO,Attach.BANK_ACC_NAME,Attach.BANK_IFSC_CODE,Attach.BANK_NAME,Attach.PURPOSE,Attach.ACCOUNT_CODE,Attach.Customer_Id from (select a.Transaction_Id,a.Transaction_Date,a.Created_By,a.Time_Info,a.Authorized_By,a.Authorized_Time,a.Verified_By,a.Verified_Time,a.Verified_By_3,a.Verified_3_Time,a.Verified_By_4,a.Verified_4_Time,a.Verified_By_5 ,a.Verified_5_Time,(select Branch_Name from Branch_Master where Branch_Code=a.Branch) as Branch,a.Account_Desc,a.transaction_Amount,case when (a.page_source='EOM' or b.voucher_type is null) THEN 'Adjustment' ELSE  case when a.page_source='SBP' then 'Payment' else b.voucher_type end end as voucher_type,case when a.page_source='EOM' THEN 'EOM Transacrion' else case when a.page_source='SBP' then 'SD Int Posting' else Case when b.mode1 is null then a.page_source else b.trfr_acc_type end end end as Mode1,b.trfr_acc_no,b.trfr_acc_type ,b.utr,b.utr_bank,a.Branch as Branch_Code from (Select Transaction_Id,Transaction_Date,Created_By,Time_Info,Authorized_By,Authorized_Time,Verified_By,Verified_Time,Verified_By_3,Verified_3_Time,Verified_By_4,Verified_4_Time,Verified_By_5 ,Verified_5_Time,Branch,transaction_date as tdate,transaction_particulars,transaction_amount,Account_Desc,page_source From DAILY_TRANSACTION_LOG Where Part_Tran_Id=1 and Transaction_Date = to_date('"+ Dt + "','dd/MM/yyyy')  and to_char(Branch) like '2%' order by branch,Transaction_Date desc,to_number(substr(to_char(Transaction_Id),-5,5)) desc)a   left join (select branch, transaction_id,transaction_date,voucher_type,mode1,trfr_acc_no,trfr_acc_type,utr,utr_bank from voucher_print_view  where utr is not null and Transaction_Date = to_date('"+ Dt + "','dd/MM/yyyy')  and to_char(Branch) like '2%' )b on a.transaction_id=b.transaction_id  and a.branch=b.branch and a.transaction_date=b.transaction_date and b.utr_bank is not null )main_qry right join (select a.*,cus.Customer_Name,cus.Mobile_No from (select Transaction_id,Transaction_Date,branch,BANK_ACC_NO,BANK_ACC_NAME,BANK_IFSC_CODE,BANK_NAME,PURPOSE,ACCOUNT_CODE,Customer_id from Savings_Attachments where Transaction_Date = to_date('"+ Dt + "','dd/MM/yyyy')  and to_char(Branch) like '2%' and type='B' )a left join (select customer_id,Customer_Name,Mobile_no from Customer_view where Mig_Flag in ('N','No'))cus on a.Customer_Id=cus.Customer_Id )Attach on main_qry.Transaction_id=Attach.Transaction_id and main_qry.Transaction_Date=Attach.Transaction_Date and main_qry.Branch_Code=Attach.Branch order by main_qry.Branch_Code )two where two.Branch is not null )three order by three.Branch_Code desc ";
						String QueryString = "select rownum as SNo,a.* from(select three.Branch,three.Customer_Name,three.Transaction_Amount,three.Purpose,three.Bank_Name from (select k.* from (select two.Branch,two.Customer_Name,two.Transaction_Amount,two.Bank_Name,two.Purpose, 2 as type1,two.Branch_Code from (select main_qry.Transaction_Date,main_qry.Branch_Code,main_qry.Branch,main_qry.Transaction_Id,Attach.Customer_Name,Attach.Mobile_No,main_qry.Account_Desc,main_qry.Transaction_Amount,main_qry.UTR_Bank,main_qry.UTR,main_qry.Verified_By_3 ,Attach.BANK_ACC_NO,Attach.BANK_ACC_NAME,Attach.BANK_IFSC_CODE,Attach.BANK_NAME,Attach.PURPOSE,Attach.ACCOUNT_CODE,Attach.Customer_Id from (select a.Transaction_Id,a.Transaction_Date,a.Created_By,a.Time_Info,a.Authorized_By,a.Authorized_Time,a.Verified_By,a.Verified_Time,a.Verified_By_3,a.Verified_3_Time,a.Verified_By_4,a.Verified_4_Time,a.Verified_By_5 ,a.Verified_5_Time,(select Branch_Name from Branch_Master where Branch_Code=a.Branch) as Branch,a.Account_Desc,a.transaction_Amount,case when (a.page_source='EOM' or b.voucher_type is null) THEN 'Adjustment' ELSE  case when a.page_source='SBP' then 'Payment' else b.voucher_type end end as voucher_type,case when a.page_source='EOM' THEN 'EOM Transacrion' else case when a.page_source='SBP' then 'SD Int Posting' else Case when b.mode1 is null then a.page_source else b.trfr_acc_type end end end as Mode1,b.trfr_acc_no,b.trfr_acc_type ,b.utr,b.utr_bank,a.Branch as Branch_Code from (Select Transaction_Id,Transaction_Date,Created_By,Time_Info,Authorized_By,Authorized_Time,Verified_By,Verified_Time,Verified_By_3,Verified_3_Time,Verified_By_4,Verified_4_Time,Verified_By_5 ,Verified_5_Time,Branch,transaction_date as tdate,transaction_particulars,transaction_amount,Account_Desc,page_source From DAILY_TRANSACTION_LOG Where Part_Tran_Id=1 and Transaction_Date = to_date('"+Dt+"','dd/MM/yyyy')  and to_char(Branch) like '2%' order by branch,Transaction_Date desc,to_number(substr(to_char(Transaction_Id),-5,5)) desc)a   left join (select branch, transaction_id,transaction_date,voucher_type,mode1,trfr_acc_no,trfr_acc_type,utr,utr_bank from voucher_print_view  where utr is not null and Transaction_Date = to_date('"+Dt+"','dd/MM/yyyy')  and to_char(Branch) like '2%' )b on a.transaction_id=b.transaction_id  and a.branch=b.branch and a.transaction_date=b.transaction_date and b.utr_bank is not null )main_qry right join (select a.*,cus.Customer_Name,cus.Mobile_No from (select Transaction_id,Transaction_Date,branch,BANK_ACC_NO,BANK_ACC_NAME,BANK_IFSC_CODE,BANK_NAME,PURPOSE,ACCOUNT_CODE,Customer_id from Savings_Attachments where Transaction_Date = to_date('"+Dt+"','dd/MM/yyyy')  and to_char(Branch) like '2%' and type='B' )a left join (select customer_id,Customer_Name,Mobile_no from Customer_view where Mig_Flag in ('N','No'))cus on a.Customer_Id=cus.Customer_Id )Attach on main_qry.Transaction_id=Attach.Transaction_id and main_qry.Transaction_Date=Attach.Transaction_Date and main_qry.Branch_Code=Attach.Branch order by main_qry.Branch_Code )two where two.Branch is not null order by two.Branch_Code)k  union select '' as Branch,'' as Customer_Name,sum(Transaction_Amount) as Transaction_Amount,'' as Bank_Name,'Total' as Verified_By_3,1 as type1,200 as bRanch_Code from (select  main_qry.Transaction_Date,main_qry.Branch_Code,main_qry.Branch,main_qry.Transaction_Id,Attach.Customer_Name,Attach.Mobile_No,main_qry.Account_Desc,main_qry.Transaction_Amount,main_qry.UTR_Bank,main_qry.UTR,main_qry.Verified_By_3 ,Attach.BANK_ACC_NO,Attach.BANK_ACC_NAME,Attach.BANK_IFSC_CODE,Attach.BANK_NAME,Attach.PURPOSE,Attach.ACCOUNT_CODE,Attach.Customer_Id from (select a.Transaction_Id,a.Transaction_Date,a.Created_By,a.Time_Info,a.Authorized_By,a.Authorized_Time,a.Verified_By,a.Verified_Time,a.Verified_By_3,a.Verified_3_Time,a.Verified_By_4,a.Verified_4_Time,a.Verified_By_5 ,a.Verified_5_Time,(select Branch_Name from Branch_Master where Branch_Code=a.Branch) as Branch,a.Account_Desc,a.transaction_Amount,case when (a.page_source='EOM' or b.voucher_type is null) THEN 'Adjustment' ELSE  case when a.page_source='SBP' then 'Payment' else b.voucher_type end end as voucher_type,case when a.page_source='EOM' THEN 'EOM Transacrion' else case when a.page_source='SBP' then 'SD Int Posting' else Case when b.mode1 is null then a.page_source else b.trfr_acc_type end end end as Mode1,b.trfr_acc_no,b.trfr_acc_type ,b.utr,b.utr_bank,a.Branch as Branch_Code from (Select Transaction_Id,Transaction_Date,Created_By,Time_Info,Authorized_By,Authorized_Time,Verified_By,Verified_Time,Verified_By_3,Verified_3_Time,Verified_By_4,Verified_4_Time,Verified_By_5 ,Verified_5_Time,Branch,transaction_date as tdate,transaction_particulars,transaction_amount,Account_Desc,page_source From DAILY_TRANSACTION_LOG Where Part_Tran_Id=1 and Transaction_Date = to_date('"+Dt+"','dd/MM/yyyy')  and to_char(Branch) like '2%' order by branch,Transaction_Date desc,to_number(substr(to_char(Transaction_Id),-5,5)) desc)a   left join (select branch, transaction_id,transaction_date,voucher_type,mode1,trfr_acc_no,trfr_acc_type,utr,utr_bank from voucher_print_view  where utr is not null and Transaction_Date = to_date('"+Dt+"','dd/MM/yyyy')  and to_char(Branch) like '2%' )b on a.transaction_id=b.transaction_id  and a.branch=b.branch and a.transaction_date=b.transaction_date and b.utr_bank is not null )main_qry right join (select a.*,cus.Customer_Name,cus.Mobile_No from (select Transaction_id,Transaction_Date,branch,BANK_ACC_NO,BANK_ACC_NAME,BANK_IFSC_CODE,BANK_NAME,PURPOSE,ACCOUNT_CODE,Customer_id from Savings_Attachments where Transaction_Date = to_date('"+Dt+"','dd/MM/yyyy')  and to_char(Branch) like '2%' and type='B' )a left join (select customer_id,Customer_Name,Mobile_no from Customer_view where Mig_Flag in ('N','No'))cus on a.Customer_Id=cus.Customer_Id )Attach on main_qry.Transaction_id=Attach.Transaction_id and main_qry.Transaction_Date=Attach.Transaction_Date and main_qry.Branch_Code=Attach.Branch order by main_qry.Branch_Code )two where two.Branch is not null )three order by three.Branch_Code)a ";

						//out.println(QueryString);

						try{
							
						rs = statement.executeQuery(QueryString);
						//out.println("<b>start</b>");
						JSONArray array=new JSONArray();
						while (rs.next()) {
							    JSONObject obj = new JSONObject();
 					  obj.put("Sno",rs.getString(1));

				                obj.put("Branch",rs.getString(2));
				                obj.put("Member Name",rs.getString(3));
				                obj.put("Amount",rs.getString(4));
 obj.put("Purpose",rs.getString(5));
				                obj.put("Bank",rs.getString(6));
				               
				               // array.add(obj);
				                array.add(obj);
						}
						
						

						
						conn1.close();
						
						out.println(array);
						
						
						}catch(SQLException e){
					        out.print("Exception: "+e);
					    }

					//}//Count Check
						/*
						
						*/
						
						
					} catch (Exception e) {

					}

					output = Be;

					out.println("<b>" + output + "</b>");
					
					response.addHeader("AustinAndroidReturn", output);

				}


    else
    {
    	 out.println("Enter Valid Type");
    }
}
%>
