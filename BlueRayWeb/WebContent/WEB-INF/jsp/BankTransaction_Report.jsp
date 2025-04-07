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
<title>Bank Transaction Report</title>
<script type="text/javascript">
$(document).ready(function() {
	//alert('jj');
    function disableBack() { window.history.forward() }


    //Bind keypress event to document
               $(document).keypress(function(event){
                   var keycode = (event.keyCode ? event.keyCode : event.which);
                   if(keycode == '13'){
                    alert("You pressed the Enter key : Please click the button!"); 
   return false; 
     
                   }
               });

  
    $("#form-idunlock").on("keypress", function (event) { 
        //console.log("aaya"); 
        var keyPressed = event.keyCode || event.which; 
        if (keyPressed == 13) { 
            alert("You pressed the Enter key : Please click the button!!"); 
            event.preventDefault(); 
            return false; 
        } 
    }); 
    


   

});


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

 <title>Bank Transaction Report</title>
 
 	<%-- <link href="<c:url value="/resourses/CSS/Style.css" />"	rel="stylesheet" type="text/css"/>
 	<link href="<c:url value="/resourses/CSS/image.css" />"	rel="stylesheet" type="text/css"/>
 	<link href="<c:url value="/resourses/CSS/Controls.css" />"	rel="stylesheet" type="text/css"/>
 	<link href="<c:url value="/resourses/CSS/tbl_style.css" />"	rel="stylesheet" type="text/css"/>
	<link href="<c:url value="/resourses/css/styles.css" />"	rel="stylesheet" type="text/css"/>
 	<link href="<c:url value="/resourses/css/juizDropDownMenu.css" />"	rel="stylesheet" type="text/css"/>
	 --%>
   

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

<body >
		<%@include file="/WEB-INF/jsp/Header.jsp"%>                                 
   <!-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------ -->                                                 
                   <center>    
                    <table width="100%" style="height: 450px" cellpadding="0"
						cellspacing="0">
						<colgroup>
							<col width="210px" />
							<col width="2px" />
							<col />
						</colgroup>
						<tr>
						
							<td class="All_Round" style="vertical-align: top">
                           <!-- ---------------------------------------------------------------------------------------- -->
                          
							<table class="tbl_Content">
					
							
							<tr>
										<th >Bank Transaction Report</th>
									</tr>
							
							<tr>
							<form:form method="post" action="${pageContext.servletContext.contextPath}/BankTransaction_Report" modelAttribute="kk" commandName="kk" name="login">
								<td>
								
								<form:select path="Branch_Type" id="ddl_Scheme" class="ddList" style="width:25%">
												<form:option value="00">All</form:option>
													<form:options items="${BranchCodeList}"></form:options>
												</form:select>
								
										 From Date :<form:input path="From_Date"  title="Date Format dd/mm/yyyy" id="demo1" required="true" onclick="javascript:NewCssCal('demo1','ddMMyyyy','arrow')"/>  
										
										
								    	To Date :<form:input path="To_Date" title="Date Format dd/mm/yyyy" id="demo2" required="true" onclick="javascript:NewCssCal('demo2','ddMMyyyy','arrow')"/>
								    	
									
								    	
                               			
                                    <input type="submit" value="Report" name="BankTransaction_Report" class="btn_Blue" onclick="return check_date();" id="Translog"/>
                                
                                   </td>
                               			
								</form:form>
							</tr>
							
       
</body>
</html>