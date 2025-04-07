<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.sql.*" %>
 <%@page import="java.io.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File DownLoad</title>
</head>
<body>
<%
String File_Path2="/image/";
   File file ;
   int maxFileSize = 5000 * 1024;
   int maxMemSize = 5000 * 1024;
   String filePath = "/image/";
 
   String contentType = request.getContentType();
   
   //contentType;
  
   if ((contentType.indexOf("multipart/form-data") >= 0)) {
	  
	   //MultipartFile multipartFile=request.getParameter("UploadFiles1");
	   
	   Part filePart = request.getPart("uploadfiles1");
	    InputStream filecontent = filePart.getInputStream();

	  
	 /*  InputStream inputStream = null;
		FileOutputStream outputStream = null;
		//if (request.getContentLength() > 0) {
			inputStream = request.getInputStream();
			System.out.println("inputStream===ddd======="+inputStream);
			// File realUpload = new File("C:/");
			outputStream = new FileOutputStream(filePath+ "zz.jpg");
			
	
			int readBytes = 0;
			byte[] buffer = new byte[8192];
			while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
			System.out.println("===ddd=======");
			outputStream.write(buffer, 0, readBytes);
			
			}
			outputStream.close();*/
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
           String query = "insert into temp values ('2')";

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
  // }
   }
%>
<%
//MCRServletJob job=null;
//HttpServletRequest req = job.getRequest();
Collection<Part> parts = request.getParts();
File uploadDir = new File(File_Path2); 
if (!uploadDir.exists()) uploadDir.mkdirs();
byte[] buffer = new byte[8 * 1024];
for (Part part : parts) {
//File uploadedFile = new File(uploadDir,reques);

InputStream input = part.getInputStream();
try {
 // OutputStream output = new FileOutputStream(uploadedFile);
  try {
    int bytesRead;
    while ((bytesRead = input.read(buffer)) != -1) {
      //output.write(buffer, 0, bytesRead);
    }
  } finally {
    //output.close();
  }
} finally {
  input.close();
}
}
%>
</body>
</html>