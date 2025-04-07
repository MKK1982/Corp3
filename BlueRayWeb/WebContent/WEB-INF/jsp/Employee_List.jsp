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

 <title>Home</title>
 
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
							<%@include file="/WEB-INF/jsp/LeftBar6.jsp" %>
							</td>

							<td>&nbsp;</td>						
							<td class="All_Round" style="vertical-align: top">
							  
							  <!-- -------------------------------------------------------- ------------------------------>
                
                <table class="tbl_Content" style="background-color:lightgray;">
									
									<tr>
										<th colspan="4">DASHBOARD Employees Details <br />
											
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
											<th colspan="2" style="color:green;bgcolor:orange;">OVERALL Employees [Till Date]<br />
												
											</th>
											</tr>
																		
										</table>
										<hr />
										</td>
										<td>
											<table class="tbl_Content" style="background-color:lightgray;">
											<tr>
											<th colspan="2">${ActiveAll}</th>
											</tr>
											<tr>
											<th colspan="2" style="color:green;bgcolor:orange;">CURRENT ACTIVE Employees<br />
												
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
											<th colspan="2" style="color:green;bgcolor:orange;">BRANCH ACTIVE Employees<br />
												
											</th>
											</tr>
																			
											</table>
											<hr />
										</td>
										
										<td>
											<table class="tbl_Content" style="background-color:lightgreen;">
											<tr>
											<th colspan="2">${Corporate}</th>
											</tr>
											<tr>
											<th colspan="2" style="color:green;bgcolor:orange;">CORP & AUTHORIZE Employees<br />
												
											</th>
											
																	
											</table>
											<hr />
										</td>
										
										</tr>
										</table>
                
                     <table class="tbl_Content">
                <colgroup>
                    <col width="300px" />
                    <col width="180px" />
                    <col width="180px" />
                    <col />
                </colgroup>
                
            
          
          <form:form method="post" action="${pageContext.servletContext.contextPath}/SearchEmployee_List"  modelAttribute="Employee2" commandName="Employee2">
         
          
										
										<tr>
										<td>
										Employee Id
												
										<form:input path="Emp_Id" id="txt_Emp_Id" Class="Tbox_R" Style="width:200px" value="${Emp_Id}"  placeholder="EMP ID / NAME / EMP DESIGNATION" />
										</td>
										
                      <td>
                              Status
                               
                          <form:select path="Current_Status" id="Current_Status" class="ddList" Style="width:100px">
				<form:option value="600">All</form:option>
				<form:option value="Active">ACTIVE</form:option>
													<form:option value="Inactive">INACTIVE</form:option>
													
												</form:select>
                       
                                </td>
                         <td>
                              Category
                              
                          <form:select path="Remarks" id="ddl_Scheme2" class="ddList" Style="width:100px">
				<form:option value="600">All</form:option>
				<form:option value="A">Present</form:option>
													<form:option value="C">Inactive</form:option>
													<form:option value="R">Resigned</form:option>
													<form:option value="S">Suspended</form:option>
													<form:option value="M">Maternity Leave</form:option>
												</form:select>
                       
                                </td>
                     <td>
                     <input type="submit" value="search" name="All" class="btn_Blue"/>
                     </td> 
                   <!--   <td>
                     <input type="submit" value="Inactive" class="btn_Blue" name="Inactive"/>
                     </td>  -->
                     <th style="display:none;"><a href="<%=request.getContextPath()%>/Employee_Master" style="color: green;">+Add</a></th>
                     
										</tr>
										<tr>
										 <td>
                     <font color="red"> ${NoOfRecords} records found </font>
                      <font color="green"> ${message}  </font>
                     
                     </td>
										</tr>
										
										
               
               
                    </table>
					
                     
                    <table border="1" width="90%" align="center" class="mGrid">
                
					<tr>
					 <th><font size="2px" >EMPLOYEE ID</font></th>
					 <th><font size="2px" >EMPLOYEE NAME</font></th>
					 <th><font size="2px" >DESIGNATION</font></th>
					
					 <th><font size="2px" >DOB</font></th>
					  <th><font size="2px" >MOBILE NO</font></th>
					   <th><font size="2px" >STATUS</font></th>
					
			
					<th><font size="2px" >View/Edit</font></th> 
					
					
 					<c:forEach var="jd" items="${list}"> 
  				 <tr>
  				 
  					   <td><font size="2px" ><c:out value="${jd.s3}"/></font></td> 
  					    <td><font size="2px" ><c:out value="${jd.s31}"/></font></td>  
  					     <td><font size="2px" ><c:out value="${jd.s36}"/></font></td>  
  					      <td><font size="2px" ><c:out value="${jd.s40}"/></font></td>  
  					        <td><font size="2px" ><c:out value="${jd.s32}"/></font></td>  
  					          					        <td><font size="2px" ><c:out value="${jd.s35}"/></font></td>  
  					        
  					       
  					       
  					     
  					  <td><font size="2px"><a href="<%=request.getContextPath()%>/editEmployeeMaster/${jd.s3}">View/Edit</a></font></td>  
  					 
  					<td Style="display:none"><font size="2px"><c:out value="${jd.s135}"/></font></td>  
  					 </tr>  
 					  </c:forEach>  
 				</table>

									<table border="0" class="mGrid">

										<tr>
											<th><c:url value="/Employee_List/${page-1}" var="prev">
													
												</c:url> <c:if test="${page > 1}">
													<a id="ListLink" href="<c:out value="${prev}" />" class="pn prev">Prev</a>
												</c:if></th>
											<c:forEach begin="${minPages}" end="${maxPages}" step="1" varStatus="i">
												<c:choose>
													<c:when test="${page == i.index}">
														<span>${i.index}</span>
													</c:when>
													<c:otherwise>
														<c:url value="/Employee_List/${i.index}" var="url">

														</c:url>
														</td>
													<th><a id="ListLink" href='<c:out value="${url}" />'>${i.index}</a></th>
													</c:otherwise>
												</c:choose>
											</c:forEach>
											
										
											<c:url value="/Employee_List/${page+1}" var="nextPage">

											</c:url>
											<c:if test="${page + 1 <= maxPages}">
												<th><a id="ListLink" href='<c:out value="${nextPage}" />' class="pn_next">Next</a></th>
											</c:if>
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













