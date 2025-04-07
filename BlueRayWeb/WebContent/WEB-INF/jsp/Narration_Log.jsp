
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<style>
.error {
	color: green;
	font-weight: bold;
	font-family: 'Droid Sans', sans-serif;;
	font-size: 12px;
}
}
</style>
</head>
   <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js">
        </script>
        
        <script type="text/javascript" language="javascript"
	src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script>
<script type="text/javascript"
	src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="<c:url value="/resources/js/jsDatePick.min.1.3.js" />"></script>
        


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

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
<style>
	ul {
  text-align: center;
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

 <title>Naration Log</title>
 
 	<%-- <link href="<c:url value="/resourses/CSS/Style.css" />"	rel="stylesheet" type="text/css"/>
 	<link href="<c:url value="/resourses/CSS/image.css" />"	rel="stylesheet" type="text/css"/>
 	<link href="<c:url value="/resourses/CSS/Controls.css" />"	rel="stylesheet" type="text/css"/>
 	<link href="<c:url value="/resourses/CSS/tbl_style.css" />"	rel="stylesheet" type="text/css"/>
	<link href="<c:url value="/resourses/css/styles.css" />"	rel="stylesheet" type="text/css"/>
 	<link href="<c:url value="/resourses/css/juizDropDownMenu.css" />"	rel="stylesheet" type="text/css"/>
	
   <link href="<c:url value="/resourses/CSS/Style.css" />"	rel="stylesheet" type="text/css"/>
 	<link href="<c:url value="/resourses/CSS/image.css" />"	rel="stylesheet" type="text/css"/>
 	<link href="<c:url value="/resourses/CSS/Controls.css" />"	rel="stylesheet" type="text/css"/>
 	<link href="<c:url value="/resourses/CSS/tbl_style.css" />"	rel="stylesheet" type="text/css"/>
	<link href="<c:url value="/resourses/css/styles.css" />"	rel="stylesheet" type="text/css"/>
 	<link href="<c:url value="/resourses/css/juizDropDownMenu.css" />"	rel="stylesheet" type="text/css"/>
	<link href="<c:url value="/resourses/CSS/Style.css" />"	rel="stylesheet" type="text/css"/>
 	<link href="<c:url value="/resourses/CSS/image.css" />"	rel="stylesheet" type="text/css"/>
 	<link href="<c:url value="/resourses/CSS/Controls.css" />"	rel="stylesheet" type="text/css"/>
 	<link href="<c:url value="/resourses/CSS/tbl_style.css" />"	rel="stylesheet" type="text/css"/>
	<link href="<c:url value="/resourses/css/styles.css" />"	rel="stylesheet" type="text/css"/>
 	<link href="<c:url value="/resourses/css/juizDropDownMenu.css" />"	rel="stylesheet" type="text/css"/>
 	 --%>
 	 
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 

</head>
<style>
#leftbar {
	border-radius: 10px;
	background-color: #0B3B17;
	vertical-align: top;
	margin-right: 10px height: auto;
	font-family: 'Droid Sans', sans-serif;;
}
.m1  {
	padding: 14px 2px 15px 10px;
	font-weight: bold;
	font-family: verdana;
	font-size: 18px;
}
</style>
<script type="text/javascript">
function valid()
{
	alert('I am');
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

function process(date)
{
	   var parts = date.split("/");
	   return new Date(parts[2], parts[1] - 1, parts[0]);
}
function check_date() {
	    var start_date = document.getElementById("demo1");
    var End_date = document.getElementById("demo2");
    
    var date1 = document.login.demo1.value;
    var date2 = document.login.demo2.value;
    /*this dates are results form datepicker*/
    // alert(date1);
    // alert(date2);
     
     if(date1 == '')
     {
     alert('Enter the from date');
     return false;
     }
     if(date2 == '')
     {
         alert('Enter the To date');
     return false;
     }
      var parts = date1.split("/");
     var day = parseInt(parts[0], 10);
     var month = parseInt(parts[1], 10);
     var year = parseInt(parts[2], 10);
     
     var parts2 = date2.split("/");
     var day2 = parseInt(parts2[0], 10);
     var month2 = parseInt(parts2[1], 10);
     var year2 = parseInt(parts2[2], 10);
     
     var monthLength = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];

     // Adjust for leap years
     if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
         monthLength[1] = 29;
     
     // Adjust for leap years
     if(year2 % 400 == 0 || (year2 % 100 != 0 && year2 % 4 == 0))
         monthLength[1] = 29;

     if(year<=1000 || year >= 3000)
	 {
	 //alert(yea);
	 alert('Enter valid Year');
     return false;
	 }
     if(year2<=1000 || year2 >= 3000)
	 {
	 alert(year2);
	 alert('Enter valid Year');
     return false;
	 }

     if(month==0 || month > 12 || month2==0 || month2 > 12)
    	 {
    	 alert(month);
    	 alert('Enter valid month');
         return false;
    	 }
       if(day > monthLength[month - 1] || day2 > monthLength[month - 1])
    	{
    	 alert(day);
    	 alert('Enter valid day');
         return false;
    	
    	} 
 
	 
	 var d1 = process(date1);
	 var d2 = process(date2);
	   
	 var diff = d2.getTime() - d1.getTime(); 
	  
	 var diffDays = diff / (1000 * 60 * 60 * 24);
	 
	 var k=0;
	 if(diffDays>31)
	 {
			
			alert("Date interval should be 31 days");
		k=1;
		return false;
 	 } 
	
	      
       if(+k==1)
    	   return false;
       else 
    	   {
    			document.getElementById("Translog").style.display = "none";
    		
    	   return true;
    	   }
    
   }


</script>


<script>
/* function process(date)
{
	   var parts = date.split("/");
	   return new Date(parts[2], parts[1] - 1, parts[0]);
}
function check_date() {
	//alert("check date");

	var user=document.login.demo1.value;
	// alert(user);
    // start_date and End_date now point straight at the correct boxes.
    var start_date = document.getElementById("demo1");
    var End_date = document.getElementById("demo2");
    
    var date1 = document.login.demo1.value;
    var date2 = document.login.demo2.value;
    
     
     if(date1 == '')
     {
     alert('Enter the from date');
     return false;
     }
     if(date2 == '')
     {
         alert('Enter the To date');
     return false;
     }
      var parts = date1.split("/");
     var day = parseInt(parts[0], 10);
     var month = parseInt(parts[1], 10);
     var year = parseInt(parts[2], 10);
     
     var parts2 = date2.split("/");
     var day2 = parseInt(parts2[0], 10);
     var month2 = parseInt(parts2[1], 10);
     var year2 = parseInt(parts2[2], 10);
     
     var monthLength = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];

     // Adjust for leap years
     if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
         monthLength[1] = 29;
     
     // Adjust for leap years
     if(year2 % 400 == 0 || (year2 % 100 != 0 && year2 % 4 == 0))
         monthLength[1] = 29;

     if(year<=1000 || year >= 3000)
	 {
	 //alert(yea);
	 alert('Enter valid Year');
     return false;
	 }
     if(year2<=1000 || year2 >= 3000)
	 {
	 alert(year2);
	 alert('Enter valid Year');
     return false;
	 }

     if(month==0 || month > 12 || month2==0 || month2 > 12)
    	 {
    	 alert(month);
    	 alert('Enter valid month');
         return false;
    	 }
       if(day > monthLength[month - 1] || day2 > monthLength[month - 1])
    	{
    	 alert(day);
    	 alert('Enter valid day');
         return false;
    	
    	} 
	if(process(date2) < process(date1))
    {
      // alert(date2 + 'is later than ' + date1);
       alert("You entered an invalid date. Please repeat again");
       return false;
   }
   
       
       return true;
   

} */

function OpenPopup9()
{
	
	var path="${pageContext.servletContext.contextPath}";
	var snnl4 = "${pageContext.request.contextPath}";
	//alert(snnl4);
	///Account_Details/{Account_No_Key}
	var url=path+"/CumulativeDeposit_PaymentModeCount/";
	//alert(url);
    window.open(url, "List", "directories=no,titlebar=yes,toolbar=no,location=no,status=no,menubar=no,scrollbars=yes");
    //  "/snnl4/FD_Interest_List/" + Accno
    //window.resizeTo(1000, 600);
}
function OpenPopup6()
{
	
	var path="${pageContext.servletContext.contextPath}";
	var snnl4 = "${pageContext.request.contextPath}";
	//alert(snnl4);
	///Account_Details/{Account_No_Key}
	var url=path+"/FixedDeposit_PaymentModeCount/";
	//alert(url);
    window.open(url, "List", "directories=no,titlebar=yes,toolbar=no,location=no,status=no,menubar=no,scrollbars=yes");
    //  "/snnl4/FD_Interest_List/" + Accno
    //window.resizeTo(1000, 600);
}

function OpenPopup7()
{
	
	var path="${pageContext.servletContext.contextPath}";
	var snnl4 = "${pageContext.request.contextPath}";
	//alert(snnl4);
	///Account_Details/{Account_No_Key}
	var url=path+"/FixedDeposit_StandingCount/";
	//alert(url);
    window.open(url, "List", "directories=no,titlebar=yes,toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,width=600,height=600");
    //  "/snnl4/FD_Interest_List/" + Accno
    //window.resizeTo(1000, 600);
}

function OpenPopup8()
{
	
	var path="${pageContext.servletContext.contextPath}";
	var snnl4 = "${pageContext.request.contextPath}";
	//alert(snnl4);
	///Account_Details/{Account_No_Key}
	var url=path+"/EOM_Count_Current/";
	//alert(url);
    window.open(url, "List", "directories=no,titlebar=yes,toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,width=600,height=600");
    //  "/snnl4/FD_Interest_List/" + Accno
    //window.resizeTo(1000, 600);
}


</script>
<script>
$(document).ready(function() {
	  $("#demo1").datepicker(
			  {
					 
				  dateFormat: 'dd/mm/yy'
	            });
	  $('.fa-calendar').click(function() {
	    $("#demo1").focus();
	  });
	});

</script>
<script>
$(document).ready(function() {
	  $("#demo2").datepicker(
			  {
					 
				  dateFormat: 'dd/mm/yy'
	            });
	  $('.fa-calendar').click(function() {
	    $("#demo2").focus();
	  });
	});

</script>
</script>

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
							<table class="tbl_Content"  width="80%" >
							
							<tr>
										<th >Narration Log</th>
									</tr>
							
							<tr>
							<form:form method="post" action="${pageContext.servletContext.contextPath}/ViewNarration_Log" modelAttribute="kk" commandName="kk" name="login">
								<td>
								
								<form:select path="Branch_Type" id="ddl_Scheme" class="ddList" style="width:25%">
												<form:option value="00">All</form:option>
													<form:options items="${BranchCodeList}"></form:options>
												</form:select>
								
										 From Date :<form:input path="From_Date"  title="Date Format dd/mm/yyyy" id="demo1" required="true"/>  
										
										
								    	To Date :<form:input path="To_Date" title="Date Format dd/mm/yyyy" id="demo2" required="true"/>
								    	
									
								    	
                               			
                                    <input type="submit" value="Report" name="Narration_Log" class="btn_Blue"  id="Translog"/>
                                                                  
                                   </td>
                               			
								</form:form>
							</tr>
							
        </table>
							</td>
							</tr>
							</table>
							</td>
							</tr>
							</table>
							</center>
							</div>     
</body>
</html>