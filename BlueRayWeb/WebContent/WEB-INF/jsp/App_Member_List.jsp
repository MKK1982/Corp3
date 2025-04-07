<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogIn</title>
<script type="text/javascript">
function valid()
{
var user=document.login.txt_Usernsme.value;
var user=user.trim();
var pass=document.login.txt_Password.value;
if(user == '')
{
document.getElementById('error').innerHTML="Please Enter Username";
return false;
}
if(pass == '')
{
document.getElementById('error').innerHTML="Please Enter Password";	
return false;
}
}



</script>
<html xmlns="http://www.w3.org/1999/xhtml" >

<style>
	ul {
  text-align: left;
  display: inline;
  margin: 0;
  padding: 10px 4px 17px 0;
  list-style: none;
  -webkit-box-shadow: 0 0 5px rgba(0, 0, 0, 0.15);
  -moz-box-shadow: 0 0 5px rgba(0, 0, 0, 0.15);
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.15);
}
ul li {
  font: bold 12px/18px sans-serif;
  display: inline-block;
  margin-right: -4px;
  position: relative;
  padding: 15px 20px;
  background: #fff;
  cursor: pointer;
  -webkit-transition: all 0.2s;
  -moz-transition: all 0.2s;
  -ms-transition: all 0.2s;
  -o-transition: all 0.2s;
  transition: all 0.2s;
}

ul a
{
 font: bold 12px/18px sans-serif;
 text-decoration:none;
 color:#fff;
}

ul li:hover {
  background: #555;
  color: #fff;
}
ul li ul {
  padding: 0;
  position: absolute;
  top: 48px;
  left: 0;
  width: 150px;
  -webkit-box-shadow: none;
  -moz-box-shadow: none;
  box-shadow: none;
  display: none;
  opacity: 0;
  visibility: hidden;
  -webkit-transiton: opacity 0.2s;
  -moz-transition: opacity 0.2s;
  -ms-transition: opacity 0.2s;
  -o-transition: opacity 0.2s;
  -transition: opacity 0.2s;
}
ul li ul li { 
  background: #555; 
  display: block; 
  color: #fff;
  text-shadow: 0 -1px 0 #000;
}
ul li ul li:hover { background: #666; }
ul li:hover ul {
  display: block;
  opacity: 1;
  visibility: visible;
}
</style>
<link href="<c:url value="/resources/CSS/menu/style.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/CSS/menu/iconic.css"/>"
	rel="stylesheet" />
<link
	href="<c:url value="/resources/CSS/sidemenu/css/dcaccordion.css" />"
	rel="stylesheet" />
<link
	href="<c:url value="/resources/CSS/sidemenu/css/skins/blue.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/CSS/tbl_style.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/resources/CSS/Controls.css"/>"
	rel="stylesheet" />
<link href="<c:url value="/resources/CSS/image.css" />" rel="stylesheet" />

<link href="<c:url value="/resources/CSS/jsDatePick_rtl.css" />"
	rel="stylesheet"></link>
<link href="<c:url value="/resources/CSS/jsDatePick_ltr.css" />"
	rel="stylesheet"></link>
<link href="<c:url value="/resources/CSS/jsDatePick_ltr.min.css" />"
	rel="stylesheet"></link>
<link href="<c:url value="/resources/CSS/jsDatePick_rtl.min.css" />"
	rel="stylesheet"></link>

<script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
<script src="<c:url value="/resources/js/main.js" />"></script>
<script src="<c:url value="/resources/CSS/menu/prefix-free.js" />"></script>
<script src="<c:url value="/resources/CSS/sidemenu/jquery.js" />"></script>
<script src="<c:url value="/resources/CSS/sidemenu/js/sidetab.js" />"></script>
<script
	src="<c:url value="/resources/CSS/sidemenu/js/jquery.dcjqaccordion.2.7.min.js" />"></script>
<script src="<c:url value="/resources/js/jsDatePick.min.1.3.js" />"></script>
<script src="<c:url value="/resources/js/jsDatePick.min.1.3.js" />"></script>

<script src="<c:url value="/resources/js/jquery.1.4.2.js" />"></script>
<script src="<c:url value="/resources/js/jsDatePick.full.1.3.js" />"></script>
<script
	src="<c:url value="/resources/js/jsDatePick.jquery.full.1.3.js" />"></script>
<script
	src="<c:url value="/resources/js/jsDatePick.jquery.min.1.3.js" />"></script>
<script src="<c:url value="/resources/js/jsDatePick.min.1.3.js" />"></script>

 <title>App Members List</title>
 
 	<%-- <link href="<c:url value="/resourses/CSS/Style.css" />"	rel="stylesheet" type="text/css"/>
 	<link href="<c:url value="/resourses/CSS/image.css" />"	rel="stylesheet" type="text/css"/>
 	<link href="<c:url value="/resourses/CSS/Controls.css" />"	rel="stylesheet" type="text/css"/>
 	<link href="<c:url value="/resourses/CSS/tbl_style.css" />"	rel="stylesheet" type="text/css"/>
	<link href="<c:url value="/resourses/css/styles.css" />"	rel="stylesheet" type="text/css"/>
 	<link href="<c:url value="/resourses/css/juizDropDownMenu.css" />"	rel="stylesheet" type="text/css"/>
	 --%>
   

</head>

<body >
	<div id="page-wrap">
		<center>
		<table width="95%">
			<tr>
				<td><%@include file="/WEB-INF/jsp/Header.jsp" %>
				</td>
			</tr>
			<tr>
				<td>

					<table width="100%" style="height: 550px;width:1100px;" cellpadding="0"
						cellspacing="0">
						<colgroup>
							<col width="210px" />
							<col width="2px" />
							<col />
						</colgroup>
						<tr>
						<td id="leftbar">
							<%@include file="/WEB-INF/jsp/LeftBar_LOG.jsp" %>
							</td>

							<td>&nbsp;</td>						
							<td class="All_Round" style="vertical-align: top">
							  
							  <!-- -------------------------------------------------------- ------------------------------>
                
                <table class="tbl_Content" style="background-color:lightgray;">
									
									<tr>
										<th colspan="4">APP Registration Details <br />
											
										</th>
									</tr>
									<tr>
										<hr/>
									</tr>
								</table>
									
									<table class="tbl_Content" >
									
									<tr>
										<td>
										<table class="tbl_Content"  style="background-color:orange;">
											<tr>
											<th colspan="2">${OverAll}</th>
											</tr>
											<tr>
											<th colspan="2" style="color:green;bgcolor:orange;">OVERALL Members<br />
												
											</th>
											</tr>
																		
										</table>
										<hr />
										</td>
										
										<td>
											<table class="tbl_Content" style="background-color:skyblue;">
											<tr>
											<th colspan="2">${Active}</th>
											</tr>
											<tr>
											<th colspan="2" style="color:green;bgcolor:orange;">Registered Members<br />
												
											</th>
											</tr>
																			
											</table>
											<hr />
										</td>
										
										
										
										</tr>
										</table>
                
                     <table class="tbl_Content">
                <colgroup>
                    <col width="150px" />
                    <col width="380px" />
                    <col width="130px" />
                    <col />
                </colgroup>
                
            
          
          <form:form method="post" action="${pageContext.servletContext.contextPath}/getApp_Member_Report"  modelAttribute="Employee2" commandName="Employee2">
         
          
										
										<tr>
										
                    
										</tr>
										<tr>
										 <td>
                     <font color="red">Today registered count :  ${NoOfRecords}  </font>
                      <font color="green"> ${message}  </font>
                     
                     </td>
										</tr>
										
										
               
               
                    </table>
					
                     <table>
                     
                      <tr>
 				   <th>
 				  
 				  Branch
 				  </th>
 				    <td>
                               
                          <form:select path="Branch_Type" id="ddl_Scheme" class="ddList" Style="width:180px">
				<form:option value="300">All</form:option>
													<form:options items="${BranchCodeList}"></form:options>
												</form:select>
                       
                                </td>
                                <%--  <th>
                              Type
                               </th>
                               <td>
                          <form:select path="Remarks" id="ddl_Scheme2" class="ddList" Style="width:100px">
				<form:option value="600">All</form:option>
													<form:option value="A">Registered</form:option>
													<form:option value="C">Not Registered</form:option>
														</form:select>
                       
                                </td> --%>
                               
			       <th>
                                    File Type
                                </th>
                                <td>
                               <form:select path="File_Type">
                      				  <form:option value="1">PDF</form:option>
                      				  <form:option value="2">Excel</form:option>
                      				  <form:option value="3">Word</form:option>
                      			 </form:select>
                                </td>
                       
                                
 				 	 <td>
                                   <input type="submit" value="Report" Class="btn_Blue" style="${ReportFlag}" name="Btn_App_Member_Report" formtarget="_blank">
                                   
                                </td>
 				 	</tr>			
				  
 				  <tr>
 				 
 				  </tr>
                     </table>
                   

									
 				   </form:form>

								 <br /> 

							<!-- -----------------------------------------------------------------------------------  -->
  
                                                    
                                             

									</td>


									</tr>
								</table>            
                                                         
                                                    
                                                    
  <!-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->                                                  
   <%@include file="/WEB-INF/jsp/Footer.jsp"%>













