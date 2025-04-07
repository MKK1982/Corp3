<%@ page import="java.sql.*" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.net.MalformedURLException" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.URLConnection" %>
<%@ page import="java.text.DecimalFormat" %>



<HTML>
<HEAD>
<TITLE>Simple JSP to Oracle connection Example</TITLE>
</HEAD>
<BODY>

<%

	 String newline = System.getProperty("line.separator");



if (request.getParameter("from") == null) {
    out.println("Please enter your type.");
}
else
{
	    //accno
        String mobileNo = request.getParameter("from");//Request.QueryString["did"].ToString();
        String m1=mobileNo;
        String m2="";
   	 out.println("mobileNo== "+mobileNo);
   	 out.println("m1== "+m1);
   	  m2=m1;
       Connection conn1 = null;
       Statement statement,st1,st2,st3 = null;
       ResultSet rs,rs1,rs2,rs3 = null;
       int sdc=0;
       int ddsc=0;
       int rdc=0;
       if (m2.trim().length() >= 10)
       {
     
       try
       {
    	  
           Class.forName("oracle.jdbc.driver.OracleDriver");
           conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dbuser1", "dbpwd1");
           out.println("connected....!!");
            st1 = conn1.createStatement();
            //  statement = conn1.createStatement();
            
               String SDcount_qry="select a.c1,b.c2,c.c3 from (     select count(*) as c1,'SD_Count' as type1,11 as check1 from SBCA_View where customer_id in (select customer_Id from Customer_View where Mobile_No='"+m1+"') AND Account_Status='A' and scheme_Code  in ('20010','20012','20013','20019'))a left join (select count(*) as c2,'DDS_Count' as type1,11 as check1 from SBCA_View where customer_id in (select customer_Id from Customer_View where Mobile_No='"+m1+"') AND Account_Status='A' and scheme_Code not in ('20010','20012','20013','20019'))b on a. check1=b.check1 left join (select count(*) as c3,'RD_Count' as type1,11 as check1 from RD_View where customer_id in(select customer_Id from Customer_View where Mobile_No='"+m1+"') AND Account_Status='A')c on a.check1=c.check1";
           // String SDcount_qry="select count(*) as c1,'SD_Count' as type1 from SBCA_View where customer_id in (select customer_Id from Customer_View where Mobile_No='"+m1+"') AND Account_Status='A' and scheme_Code  in ('20010','20012','20013','20019')";
            String DDScount_qry="select count(*) as c1,'DDS_Count' as type1 from SBCA_View where customer_id in (select customer_Id from Customer_View where Mobile_No='"+m1+"') AND Account_Status='A' and scheme_Code not in ('20010','20012','20013','20019')";
            String RDcount_qry="select count(*) as c1,'RD_Count' as type1 from RD_View where customer_id in(select customer_Id from Customer_View where Mobile_No='"+m1+"') AND Account_Status='A'";
            rs1 = st1.executeQuery(SDcount_qry);
            
            try {
    			if (rs1!= null) {
    				 out.println("connected...sd.!!");
    				  while (rs1.next()) {
    					  out.println("connected..sd2..!!");
    					  sdc=rs1.getInt(1);
    					  ddsc=rs1.getInt(2);
    					  rdc=rs1.getInt(3);
    					  out.println("connected="+sdc);
    				  }
    			}
    			//i=resultSet.getRow();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
           out.println("sdc="+sdc);
            out.println("ddsc="+ddsc);
            out.println("rdc="+rdc);
            
            if(sdc>0 )
            {
            	 String bal = "";
            	String QueryString = "select Account_no, Closing_Balance,Scheme_Code from SBCA_View where customer_id in (select customer_Id from Customer_View where Mobile_No='"+m1+"') and scheme_code in ('20010','20012','20013','20019') AND Account_Status='A'";
     	         rs = st1.executeQuery(QueryString);
              
            	if(sdc==1)
            	{
            		  // int c=0;
                    while (rs.next()) {
                    	
                    	  m2=m1;
                    	//c=c+1;
                    	// out.println("inside  while!");
                    	 String accno = rs.getString(1);
                    	 float cb=rs.getFloat(2);
            			 //New
            			 String Scheme_Code = rs.getString(3);
                    	 //out.println("  accno!"+accno);
                    	DecimalFormat df = new DecimalFormat("0.00");
             			String cbs = df.format(cb);
             			
             			long cbl=(long) cb;
             			
                    	// out.println("inside  accno!"+accno);
                    	     char  answer = accno.charAt(4);
                			 String No=null;
                        	 if(accno != null && accno.length()>=6)
                        	  No=accno.substring(6);
                     		String Append="XXXXXX"+No;
							 bal = "SD Account No:" +Append + " Balance is Rs. "+cbl+".";
                            
                              String  Msg=(bal).replaceAll(" ", "%20");
                         	String Logo="Shri Narayani : Missed Call Alert :";
                         	
                         	String message=Logo+Msg;
                         	message=(message).replaceAll(" ", "%20");
                         	message=(message).replaceAll("\n", "%0A");
                         	 out.println("SD Message="+message);
                        	String Phone_Num=mobileNo;
                     //15-10-2018
                    //https://sms.nettyfish.com/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn=1111111111&sid=SNIDHI&msg=test%20message&fl=0&gwid=2
                  //   old 
  //URL url = new URL("https://sms.nettyfish.com/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn="+m1+"&sid=SNIDHI&msg="+message+"&fl=0&gwid=2");
                  //01-10-2021
  // URL url = new URL("http://45.127.101.185/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn="+m1+"&sid=SNIDHI&msg="+message+"&fl=0&gwid=2");
  
 //05-10-2021
  // URL url = new URL("http://139.99.131.165:6005/api/v2/SendSMS?ApiKey=10f295cf-ac88-4cfc-a245-31713df36a44&ClientId=3c870543-480b-4491-832b-e71a23db1f4a&SenderId=SNIDHI&Message="+message+"&MobileNumbers="+m1+"");

 //28-07-2022
   // URL url = new URL("https://sms.nettyfish.com/api/v2/SendSMS?SenderId=SNIDHI&Message="+message+"&MobileNumbers="+m1+"&PrincipleEntityId=1701159179346008981&TemplateId=1707163093677340714&ApiKey=10f295cf-ac88-4cfc-a245-31713df36a44&ClientId=3c870543-480b-4491-832b-e71a23db1f4a");

 //30-07-2022 1707163093702251444
    URL url = new URL("https://sms.nettyfish.com/api/v2/SendSMS?SenderId=SNIDHI&Message="+message+"&MobileNumbers="+m1+"&PrincipleEntityId=1701159179346008981&TemplateId=1707163093702251444&ApiKey=10f295cf-ac88-4cfc-a245-31713df36a44&ClientId=3c870543-480b-4491-832b-e71a23db1f4a");

    HttpURLConnection uc = (HttpURLConnection)url.openConnection();
                        out.println(uc.getResponseMessage());
                 
                        uc.disconnect();
                      
                    }

            	}
            	else
            	{
            		int c=0;
            		 while (rs.next()) {
            	        	c=c+1;
                   	  m2=m1;
                   	//c=c+1;
                   	// out.println("inside  while!");
                   	 String accno = rs.getString(1);
                   	 float cb=rs.getFloat(2);
           			 //New
           			 String Scheme_Code = rs.getString(3);
                   	// out.println("  accno!"+accno);
                   	DecimalFormat df = new DecimalFormat("0.00");
            			String cbs = df.format(cb);
            			long cbl=(long) cb;
                   	// out.println("inside  accno!"+accno);
                   	 //out.println("SubString =  accno.substring(3,1)!"+accno.substring(3,1)+" accno.substring(3,2)!"+accno.substring(3,2));
                     //  String res = accno.substring(4,1);
                       
                        char  answer = accno.charAt(4);
                     	// out.println("inside  res == 02!");
                       	 String No=null;
                       	 if(accno != null && accno.length()>=6)
                       	  No=accno.substring(6);
                    		
                       	 if(c<=10)
                       	 {
                    		String Append="XXXXXX"+No;
                            if(c==1)
                    		 bal+= "SD Account No:" +Append + " Balance is Rs. "+cbl+".";
                            else
                            	bal+= " SD Account No:" +Append + " Balance is Rs. "+cbl+".";
                       	 }  
                            //File.WriteAllText(Server.MapPath("~/savings.txt"), bal);
                           // out.println("inside  bal == 02!"+bal);
                            bal=(bal).replaceAll("\n", "%0A");
                           
            		 }
            		 String  Msg=(bal).replaceAll(" ", "%20");
            	    	String Logo="Shri Narayani : Missed Call Alert :";
            	    	
            	    	String message=Logo+Msg;
            	    	message=(message).replaceAll(" ", "%20");
            	    	message=(message).replaceAll("\n", "%0A");
            	    	
                        out.println("message ="+message);

            	    	String Phone_Num=mobileNo;
            	  //15-10-2018
            	//https://sms.nettyfish.com/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn=1111111111&sid=SNIDHI&msg=test%20message&fl=0&gwid=2
            	   //URL url = new URL("https://sms.nettyfish.com/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn="+m1+"&sid=SNIDHI&msg="+message+"&fl=0&gwid=2");
                  
		//01/10/2021
            	//  URL url = new URL("http://45.127.101.185/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn="+m1+"&sid=SNIDHI&msg="+message+"&fl=0&gwid=2");

                  
            	//05-10-2021
            	 // URL url = new URL("http://139.99.131.165:6005/api/v2/SendSMS?ApiKey=10f295cf-ac88-4cfc-a245-31713df36a44&ClientId=3c870543-480b-4491-832b-e71a23db1f4a&SenderId=SNIDHI&Message="+message+"&MobileNumbers="+m1+"");
				
            	//28-07-2022                     1707163093677340714
            	   // URL url = new URL("https://sms.nettyfish.com/api/v2/SendSMS?SenderId=SNIDHI&Message="+message+"&MobileNumbers="+m1+"&PrincipleEntityId=1701159179346008981&TemplateId=1707163093677340714&ApiKey=10f295cf-ac88-4cfc-a245-31713df36a44&ClientId=3c870543-480b-4491-832b-e71a23db1f4a");
                
          ////30-07-2022  -----------------------------------------------------------------------------------------------------------------
            	String urlString="";
            	if(c==2)
                   {
            	//28-07-2022                     1707163093677340714
            	   urlString="https://sms.nettyfish.com/api/v2/SendSMS?SenderId=SNIDHI&Message="+message+"&MobileNumbers="+m1+"&PrincipleEntityId=1701159179346008981&TemplateId=1707163093677340714&ApiKey=10f295cf-ac88-4cfc-a245-31713df36a44&ClientId=3c870543-480b-4491-832b-e71a23db1f4a";
                   }
				else if(c==3)
                {
         	     // 1707163187377554227
         	      urlString="https://sms.nettyfish.com/api/v2/SendSMS?SenderId=SNIDHI&Message="+message+"&MobileNumbers="+m1+"&PrincipleEntityId=1701159179346008981&TemplateId=1707163187377554227&ApiKey=10f295cf-ac88-4cfc-a245-31713df36a44&ClientId=3c870543-480b-4491-832b-e71a23db1f4a";
                }
				else if(c==4)
                {
         	     //30-07-2022                     1707163187393818877
         	      urlString="https://sms.nettyfish.com/api/v2/SendSMS?SenderId=SNIDHI&Message="+message+"&MobileNumbers="+m1+"&PrincipleEntityId=1701159179346008981&TemplateId=1707163187393818877&ApiKey=10f295cf-ac88-4cfc-a245-31713df36a44&ClientId=3c870543-480b-4491-832b-e71a23db1f4a";
                }
				else if(c==5)
                {
         	     //30-07-2022                     1707163187417722651
         	      urlString="https://sms.nettyfish.com/api/v2/SendSMS?SenderId=SNIDHI&Message="+message+"&MobileNumbers="+m1+"&PrincipleEntityId=1701159179346008981&TemplateId=1707163187417722651&ApiKey=10f295cf-ac88-4cfc-a245-31713df36a44&ClientId=3c870543-480b-4491-832b-e71a23db1f4a";
                }
				else
				{
					//28-07-2022
            	    urlString="https://sms.nettyfish.com/api/v2/SendSMS?SenderId=SNIDHI&Message="+message+"&MobileNumbers="+m1+"&PrincipleEntityId=1701159179346008981&TemplateId=1707163093677340714&ApiKey=10f295cf-ac88-4cfc-a245-31713df36a44&ClientId=3c870543-480b-4491-832b-e71a23db1f4a";
                
				}
			//----------------------------------------------------------------------------------------------------------------------------------------	
				URL url=new URL(urlString);
		HttpURLConnection uc = (HttpURLConnection)url.openConnection();

            	   System.out.println(uc.getResponseMessage());
            	   uc.disconnect();

            	}
            }
            out.println("sd completed");

           //---------------------------DDS Account----------------------------------------------
            if(ddsc>0 )
            {
            	 String bal2 = "";
            	String QueryString2 = "select Account_no, Closing_Balance,Scheme_Code from SBCA_View where customer_id in (select customer_Id from Customer_View where Mobile_No='"+m1+"') and scheme_code not in ('20010','20012','20013','20019') AND Account_Status='A'";
            	out.println(QueryString2);
            	 st2 = conn1.createStatement();
            	rs2 = st2.executeQuery(QueryString2);
     	     
            	if(ddsc==1)
            	{ //out.println("inside  while!");
            		  // int c=0;
                    while (rs2.next()) {
                    	
                    	  m2=m1;
                    	//c=c+1;
                    	 //out.println("inside  while!");
                    	 String accno = rs2.getString(1);
                    	 float cb=rs2.getFloat(2);
            			 //New
            			 String Scheme_Code = rs2.getString(3);
                    	// out.println("  accno!"+accno);
                    	DecimalFormat df = new DecimalFormat("0.00");
             			String cbs = df.format(cb);
             			long cbl=(long) cb;
                    	 //out.println("inside  accno!"+accno);
                    	     char  answer = accno.charAt(4);
                			 String No=null;
                        	 if(accno != null && accno.length()>=6)
                        	  No=accno.substring(6);
                     		String Append="XXXXXX"+No;
							 bal2 = "DDS Account No:" +Append + " Balance is Rs. "+cbl+".";
                            
                              String  Msg=(bal2).replaceAll(" ", "%20");
                         	String Logo="Shri Narayani : Missed Call Alert :";
                         	
                         	String message2=Logo+Msg;
                         	message2=(message2).replaceAll(" ", "%20");
                         	message2=(message2).replaceAll("\n", "%0A");
                         	 out.println("DDS Message="+message2);
                        	String Phone_Num=mobileNo;
                     //15-10-2018
                    //https://sms.nettyfish.com/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn=1111111111&sid=SNIDHI&msg=test%20message&fl=0&gwid=2
                      // URL url = new URL("https://sms.nettyfish.com/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn="+m1+"&sid=SNIDHI&msg="+message2+"&fl=0&gwid=2");
                  
                   //01/10/2021
            	     //   URL url = new URL("http://45.127.101.185/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn="+m1+"&sid=SNIDHI&msg="+message2+"&fl=0&gwid=2");


            	      //05-10-2021
            	        URL url = new URL("http://139.99.131.165:6005/api/v2/SendSMS?ApiKey=10f295cf-ac88-4cfc-a245-31713df36a44&ClientId=3c870543-480b-4491-832b-e71a23db1f4a&SenderId=SNIDHI&Message="+message2+"&MobileNumbers="+m1+"");


         HttpURLConnection uc = (HttpURLConnection)url.openConnection();
                        System.out.println(uc.getResponseMessage());
                        uc.disconnect();
                      
                    }

            	}
            	else
            	{ out.println("outside  while!");
            	   int c2=0;
            		 while (rs2.next()) {
            			 out.println("inside  while!");
            	        	c2=c2+1;
                   	  m2=m1;
                   	//c=c+1;
                   	 //out.println("inside  while!");
                   	 String accno = rs2.getString(1);
                   	 float cb=rs2.getFloat(2);
           			 //New
           			 String Scheme_Code = rs2.getString(3);
                   	out.println("  accno!"+accno);
                   	DecimalFormat df = new DecimalFormat("0.00");
            			String cbs = df.format(cb);
            			long cbl=(long) cb;
                  // 	 out.println("inside  accno!"+accno);
                   	 //out.println("SubString =  accno.substring(3,1)!"+accno.substring(3,1)+" accno.substring(3,2)!"+accno.substring(3,2));
                     //  String res = accno.substring(4,1);
                       
                        char  answer = accno.charAt(4);
                     	out.println("inside  res == 02!");
                       	 String No=null;
                       	 if(accno != null && accno.length()>=6)
                       	  No=accno.substring(6);
                       	if(c2<=10){
                    		String Append="XXXXXX"+No;
                           if(c2==1)
                    		 bal2 += "DDS Account No:" +Append + " Balance is Rs. "+cbl+".";
                           else
                      		 bal2 += " DDS Account No:" +Append + " Balance is Rs. "+cbl+".";
                       	}
                           
                           
                            //File.WriteAllText(Server.MapPath("~/savings.txt"), bal);
                        out.println("inside  bal == 02!"+bal2);
                            bal2=(bal2).replaceAll("\n", "%0A");
                           
            		 }
            		 String  Msg=(bal2).replaceAll(" ", "%20");
            	    	String Logo="Shri Narayani : Missed Call Alert :";
            	    	
            	    	String message2=Logo+Msg;
            	    	message2=(message2).replaceAll(" ", "%20");
            	    	message2=(message2).replaceAll("\n", "%0A");
            	    	
            	    	 out.println("DDS Message= "+message2);
            	    	String Phone_Num=mobileNo;
            	  //15-10-2018
            	//https://sms.nettyfish.com/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn=1111111111&sid=SNIDHI&msg=test%20message&fl=0&gwid=2
            	  //URL url = new URL("https://sms.nettyfish.com/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn="+m1+"&sid=SNIDHI&msg="+message2+"&fl=0&gwid=2");
		
//01/10/2021
            	//  URL url = new URL("http://45.127.101.185/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn="+m1+"&sid=SNIDHI&msg="+message2+"&fl=0&gwid=2");


            	//05-10-2021
            	  URL url = new URL("http://139.99.131.165:6005/api/v2/SendSMS?ApiKey=10f295cf-ac88-4cfc-a245-31713df36a44&ClientId=3c870543-480b-4491-832b-e71a23db1f4a&SenderId=SNIDHI&Message="+message2+"&MobileNumbers="+m1+"");

			 HttpURLConnection uc = (HttpURLConnection)url.openConnection();
            	    System.out.println(uc.getResponseMessage());
            	    uc.disconnect();

            	}
            }

           
           // DDS closed---------------------------------------------------------------------------
            //----------RD Count---------------------------------------------------------------
             if(rdc>0 )
            {
            	  String bal3 = "";
            	  st3 = conn1.createStatement();
            	String QueryString3 = "select to_char(Account_no), Closing_Balance,Scheme_Code from RD_View where customer_id in(select customer_Id from Customer_View where Mobile_No='"+m1+"') AND Account_Status='A'";
     	         rs3 = st3.executeQuery(QueryString3);
     	      //out.println(QueryString2);
            	
            	
            	if(rdc==1)
            	{
            		  // int c=0;
                    while (rs3.next()) {
                    	
                    	  m2=m1;
                    	//c=c+1;
                    	// out.println("inside  while!");
                    	 String accno = rs3.getString(1);
                    	 float cb=rs3.getFloat(2);
            			 //New
            			 String Scheme_Code = rs3.getString(3);
                    	// out.println("  accno!"+accno);
                    	DecimalFormat df = new DecimalFormat("0.00");
             			String cbs = df.format(cb);
             			long cbl=(long) cb;
                    	 //out.println("inside  accno!"+accno);
                    	     char  answer = accno.charAt(4);
                			 String No=null;
                        	 if(accno != null && accno.length()>=6)
                        	  No=accno.substring(6);
                     		String Append="XXXXXX"+No;
							 bal3 = "RD Account No:" +Append + " Balance is Rs. "+cbl+".";
                            
                              String  Msg=(bal3).replaceAll(" ", "%20");
                         	String Logo="Shri Narayani : Missed Call Alert :";
                         	
                         	String message3=Logo+Msg;
                         	message3=(message3).replaceAll(" ", "%20");
                         	message3=(message3).replaceAll("\n", "%0A");
                         	 out.println("RD Message="+message3);
                        	String Phone_Num=mobileNo;
                     //15-10-2018
                    //https://sms.nettyfish.com/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn=1111111111&sid=SNIDHI&msg=test%20message&fl=0&gwid=2
                       //URL url = new URL("https://sms.nettyfish.com/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn="+m1+"&sid=SNIDHI&msg="+message3+"&fl=0&gwid=2");
                       //01/10/2021
            	     //  URL url = new URL("http://45.127.101.185/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn="+m1+"&sid=SNIDHI&msg="+message3+"&fl=0&gwid=2");


            	     //05-10-2021
            	       URL url = new URL("http://139.99.131.165:6005/api/v2/SendSMS?ApiKey=10f295cf-ac88-4cfc-a245-31713df36a44&ClientId=3c870543-480b-4491-832b-e71a23db1f4a&SenderId=SNIDHI&Message="+message3+"&MobileNumbers="+m1+"");

                        HttpURLConnection uc = (HttpURLConnection)url.openConnection();
                        System.out.println(uc.getResponseMessage());
                        uc.disconnect();
                      
                    }

            	}
            	else
            	{
            		int c3=0;
            		 while (rs3.next()) {
            	        	
                   	  m2=m1;
                   	c3=c3+1;
                   //	 out.println("inside  while!");
                   	 String accno = rs3.getString(1);
                   	 float cb=rs3.getFloat(2);
           			 //New
           			 String Scheme_Code = rs3.getString(3);
                   	 //out.println("  accno!"+accno);
                   	DecimalFormat df = new DecimalFormat("0.00");
            			String cbs = df.format(cb);
            			long cbl=(long) cb;
                   	// out.println("inside  accno!"+accno);
                   	 //out.println("SubString =  accno.substring(3,1)!"+accno.substring(3,1)+" accno.substring(3,2)!"+accno.substring(3,2));
                     //  String res = accno.substring(4,1);
                       
                        char  answer = accno.charAt(4);
                     	// out.println("inside  res == 02!");
                       	 String No=null;
                       	 if(accno != null && accno.length()>=6)
                       	  No=accno.substring(6);
                    		
                    		String Append="XXXXXX"+No;
                    		if(c3<=10){
                    			if(c3==1)
                    		     bal3 += "RD Account No:" +Append + " Balance is Rs. "+cbl+".";
                    			else
                       		     bal3 += " RD Account No:" +Append + " Balance is Rs. "+cbl+".";
		
                    		}
                    			
                            //File.WriteAllText(Server.MapPath("~/savings.txt"), bal);
                           // out.println("inside  bal == 02!"+bal);
                            bal3=(bal3).replaceAll("\n", "%0A");
                           
            		 }
            		 String  Msg=(bal3).replaceAll(" ", "%20");
            	    	String Logo="Shri Narayani : Missed Call Alert :";
            	    	
            	    	String message3=Logo+Msg;
            	    	message3=(message3).replaceAll(" ", "%20");
            	    	message3=(message3).replaceAll("\n", "%0A");
            	    	 out.println("RD Message ="+message3);
                    	
            	    	String Phone_Num=mobileNo;
            	  //15-10-2018
            	//https://sms.nettyfish.com/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn=1111111111&sid=SNIDHI&msg=test%20message&fl=0&gwid=2
            	  // URL url = new URL("https://sms.nettyfish.com/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn="+m1+"&sid=SNIDHI&msg="+message3+"&fl=0&gwid=2");
		//01/10/2021
            	//  URL url = new URL("http://45.127.101.185/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn="+m1+"&sid=SNIDHI&msg="+message3+"&fl=0&gwid=2");

            	//05-10-2021
            	  URL url = new URL("http://139.99.131.165:6005/api/v2/SendSMS?ApiKey=10f295cf-ac88-4cfc-a245-31713df36a44&ClientId=3c870543-480b-4491-832b-e71a23db1f4a&SenderId=SNIDHI&Message="+message3+"&MobileNumbers="+m1+"");


			 HttpURLConnection uc = (HttpURLConnection)url.openConnection();
            	    System.out.println(uc.getResponseMessage());
            	    uc.disconnect();

            	}
            }

            //----RD Closed------------------------------------------------------------------------------
            
            //New 06-03-2020		
		/*String QueryString = "select Account_no, Closing_Balance,Scheme_Code from SBCA_View where customer_id in (select customer_Id from Customer_View where Mobile_No='"+m1+"')union select to_char(Account_no), Closing_Balance,Scheme_Code from RD_View where customer_id in(select customer_Id from Customer_View where Mobile_No='"+m1+"') AND Account_Status='A'";
       
        rs = statement.executeQuery(QueryString);
        // int c=0;
        while (rs.next()) {
        	
        	  m2=m1;
        	//c=c+1;
        	 out.println("inside  while!");
        	 String accno = rs.getString(1);
        	 float cb=rs.getFloat(2);
			 //New
			 String Scheme_Code = rs.getString(3);
        	 out.println("  accno!"+accno);
        	DecimalFormat df = new DecimalFormat("0.00");
 			String cbs = df.format(cb);
 			
        	 out.println("inside  accno!"+accno);
        	     char  answer = accno.charAt(4);
    		     if (Scheme_Code.equalsIgnoreCase("20010") || Scheme_Code.equalsIgnoreCase("20011") || Scheme_Code.equalsIgnoreCase("20012") || Scheme_Code.equalsIgnoreCase("20013"))
 	  		 {
            	 out.println("inside  res == 02!");
            	 String No=null;
            	 if(accno != null && accno.length()>=6)
            	  No=accno.substring(6);
         		
         		String Append="XXXXXX"+No;

         		 bal = "SB Account No:" +Append + " Balance is Rs. "+cbs+".";
                
                  String  Msg=(bal).replaceAll(" ", "%20");
             	String Logo="Shri Narayani : Missed Call Alert :\n";
             	
             	String message=Logo+Msg;
             	message=(message).replaceAll(" ", "%20");
             	message=(message).replaceAll("\n", "%0A");
             	
            	String Phone_Num=mobileNo;
         //15-10-2018
        //https://sms.nettyfish.com/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn=1111111111&sid=SNIDHI&msg=test%20message&fl=0&gwid=2
         //old   URL url = new URL("https://sms.nettyfish.com/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn="+m1+"&sid=SNIDHI&msg="+message+"&fl=0&gwid=2");
        
		//01/10/2021
            	   URL url = new URL("https://45.127.101.185/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn="+m1+"&sid=SNIDHI&msg="+message+"&fl=0&gwid=2");

  
	     HttpURLConnection uc = (HttpURLConnection)url.openConnection();
            System.out.println(uc.getResponseMessage());
            uc.disconnect();
                

             
                
             }
    		     if (Scheme_Code.equalsIgnoreCase("20010") || Scheme_Code.equalsIgnoreCase("20011") || Scheme_Code.equalsIgnoreCase("20012") || Scheme_Code.equalsIgnoreCase("20013"))
     	  		 {
                	 out.println("inside  res == 02!");
                	 String No=null;
                	 if(accno != null && accno.length()>=6)
                	  No=accno.substring(6);
             		
             		String Append="XXXXXX"+No;

             		 bal = "SB Account No:" +Append + " Balance is Rs. "+cbs+".";
                    
                      String  Msg=(bal).replaceAll(" ", "%20");
                 	String Logo="Shri Narayani : Missed Call Alert :\n";
                 	
                 	String message=Logo+Msg;
                 	message=(message).replaceAll(" ", "%20");
                 	message=(message).replaceAll("\n", "%0A");
                 	
                	String Phone_Num=mobileNo;
             //15-10-2018
            //https://sms.nettyfish.com/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn=1111111111&sid=SNIDHI&msg=test%20message&fl=0&gwid=2
                URL url = new URL("https://sms.nettyfish.com/vendorsms/pushsms.aspx?apikey=10f295cf-ac88-4cfc-a245-31713df36a44&clientId=3c870543-480b-4491-832b-e71a23db1f4a&msisdn="+m1+"&sid=SNIDHI&msg="+message+"&fl=0&gwid=2");
                   HttpURLConnection uc = (HttpURLConnection)url.openConnection();
                System.out.println(uc.getResponseMessage());
                uc.disconnect();
                    

                 
                    
                 }

		//if (res.equalsIgnoreCase("06") || res.equalsIgnoreCase("24") || res.equalsIgnoreCase("27") || res.equalsIgnoreCase("35"))
           //Old  if (answer == '6' || answer == '4' || answer == '7' || answer == '5')
			   //New
		    if (Scheme_Code.equalsIgnoreCase("40010") || Scheme_Code.equalsIgnoreCase("40011") || Scheme_Code.equalsIgnoreCase("40012") || Scheme_Code.equalsIgnoreCase("40013"))
	     	 {
            	 out.println("inside  res == 06!");
            	 String No=null;
            	 if(accno != null && accno.length()>=6)
            	  No=accno.substring(6);
         		
         		String Append="XXXXXX"+No;
                 bal += "RD Account No:" +Append + " Balance is Rs. " + cbs+"\n" ;
                // File.WriteAllText(Server.MapPath("~/RD.txt"), bal);
                 bal=(bal).replaceAll("\n", "%0A");
             }
       	
         
        }*/
      conn1.close();
       
        
      }
       catch(Exception e)
       {
           out.println("Exception : " + e.getMessage() + "");
       }
       
       } 
        
        
   }



%>
</BODY>
</HTML>