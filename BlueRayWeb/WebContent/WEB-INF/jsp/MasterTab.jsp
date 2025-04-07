
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Date"%>
<!DOCTYPE  PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> 

  

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
	
	<link href="<c:url value="/resources/CSS/bootstrap.min.css" />"
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

<!-- 
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery-1.12.0.min.js" />"></script>-->





							<style>
ol, ul {
	list-style: none;
}

.clearfix {
	clear: both;
}
B {
    font-family: Tahoma,Arial,sans-serif;
    color: black;
    background-color: white;
}
.wrap {
    font-family: 'Droid Sans', sans-serif;
    width: 100%;
    margin-top: -24px;
    margin-left:-120px;
    margin-bottom: 0px;
    padding: 0px 0px 0px 80px;
}

nav {
	background: -webkit-gradient(linear, center top, center bottom, from(#fff),
		to(#ccc));
	
    background-image: linear-gradient(#fff, #ccc);
	border-radius: 6px;
	box-shadow: 0px 0px 4px 2px rgba(0, 0, 0, 0.4);
	position: relative;
	width: auto;
}




.menu li {
	float: left;
	position: relative;
	width: 8.4%;
	display: block;
	box-sizing: content-box;
	}

.menu li a {
	color: #444;
	display: block;
	font-size: 12px;
	line-height: 20px;
	padding: 1px 4px;
	margin: 8px 8px;
	vertical-align: middle;
	text-decoration: none;
	width: 8.548%
}

.menu li img:hover {
	background: -webkit-gradient(linear, center top, center bottom, from(#ededed),
		to(#fff));
	background-image: linear-gradient(#ededed, #fff);
	border-radius: 12px;
	box-shadow: inset 0px 0px 1px 1px rgba(0, 0, 0, 0.1);
	color: #222;
}

.menu ul {
	position: absolute;
	left: -9999px;
	list-style: none;
	opacity: 0;
	transition: opacity 1s ease;
}

.menu ul li {
	float: none;
}

.menu ul a {
	white-space: nowrap;
}

/* Displays the dropdown on hover and moves back into position */
/*
.menu li:hover ul {
	background: rgba(255, 255, 255, 0.7);
	border-radius: 0 0 6px 6px;
	box-shadow: inset 0px 2px 4px rgba(0, 0, 0, 0.4);
	left: 5px;
	opacity: 1;
}
*/

/* Persistant Hover State */
/*
.menu li:hover a {
	background: -webkit-gradient(linear, center top, center bottom, from(#ccc),
		to(#ededed));
	background-image: linear-gradient(#ccc, #ededed);
	border-radius: 12px;
	box-shadow: inset 0px 0px 1px 1px rgba(0, 0, 0, 0.1);
	color: #222;
}

.menu li:hover ul a {
	background: none;
	border-radius: 0;
	box-shadow: none;
}

.menu li:hover ul li a:hover {
	background: -webkit-gradient(linear, center top, center bottom, from(#eee),
		to(#fff));
	background-image: linear-gradient(#ededed, #fff);
	border-radius: 12px;
	box-shadow: inset 0px 0px 4px 2px rgba(0, 0, 0, 0.3);
}
*/
</style>


<style>
.tbl_Content {
	padding: 4px 2px 2px 2px;
	width: 100%;
	font-family: Tahoma;
}

.tbl_Content td {
	vertical-align: top;
	padding: 5px 2px 5px 10px;
	font-size: 14px;
}

.tbl_Content th {
	padding: 4px 2px 4px 5px;
	font-size: 16px;
	text-align: left;
}

.Left_Round {
	-moz-border-radius-topleft: 10px;
	-webkit-border-top-left-radius: 10px;
	border: 1px solid;
	/*border-color:Orange;*/
}

.All_Round {
	height: 100px;
	-moz-border-radius: 1x;
	-webkit-border-radius: 10px;
	border-radius: 0px;
	border: 1px solid #2999D6;
}

#leftbar {
	border-radius: 0px;
	background-color:green;
	vertical-align: top;
	margin-right: 10px height: auto;
}

.roundcont {
	width: 250px;
	background-color: #f90;
	color: #fff;
}

.roundcont p {
	margin: 0 10px;
}

.roundtop {
	background: url(tr.gif) no-repeat top right;
}

.roundbottom {
	background: url(br.gif) no-repeat top right;
}

img.corner {
	width: 15px;
	height: 15px;
	border: none;
	display: block !important;
}

.PopupBody {
	float: left;
	background-color: #fafafa;
	height: 400px;
	overflow: scroll;
}

.PopupHeader {
	background-color: #fafafa;
	width: 100%;
	padding: 5px 0px 5px 0px;
	text-align: right;
	font-size: 12px;
}

.Side_Menu {
	width: 100%;
}

.Side_Menu td {
	vertical-align: top;
	padding: 5px 0px 5px 15px;
	color: White;
}

.Side_Menu li {
	vertical-align: top;
	padding: 5px 0px 5px 15px;
	color: White;
	float: left;
	position: relative;
	line-height: 1.5em;
	width: 10em;
}

.Side_Menu li a {
	display: block;sha
	/*border-right:1px solid #fff;
	background:#E0F574;*/
	color: #FFFFFF;
	text-decoration: none;
}

.Side_Menu li a:hover {
	background-color: #5798B4;
	color: #F8FBF4;
}

#page-wrap {
	width: 100%;
	margin: 0 auto;
}

.Btn_Row {
	width: 100%;
	/*background-color:Fuchsia;*/
	text-align: center;
	padding: 10px 0px 10px 0px;
}

.sidemenu {
	width: 150px;
	border: none;
}


.sidemenu li a {
	height: 18px;
	text-decoration: none;
}
/*Top sidemenu Item (Header and rounded corners)*/
.sidemenu li.top a:link, .sidemenu li.top a:visited {
	color: #828282;
	display: block;
	background: url(images/menuTop.png);
	background-repeat: no-repeat;
	padding: 1px 0 1px 0;
	font-size: 1em;
	font-weight: bold;
	text-align: center;
}

/* Uncomment this if you want the header to be an interactive link
.sidemenu li.top a:hover {
  color: #828282;
  background: url(images/menuTop.png) 0 -22px;
}
.sidemenu li.top a:active {
  color: #26370A;
  background: url(images/menuTop.png) 0 -44px;
}*/

/*sidemenu Item Middle*/
.sidemenu li a:link, .sidemenu li a:visited {
	color: #5E7830;
	display: block;
	background: url(images/menuMiddle.png);
	background-repeat: no-repeat;
	padding: 1px 0 1px 20px;
	font-size: 0.8em;
}

.sidemenu li a:hover {
	color: #FFFFFF;
	background: url(images/menuMiddle.png) 0 -22px;
}

.sidemenu li a:active {
	color: #FFFFFF;
	background: url(images/menuMiddle.png) 0 -44px;
}

/*Bottom sidemenu Item (rounded corners)*/
.sidemenu li.bottom a:link, .sidemenu li.bottom a:visited {
	color: #5E7830;
	display: block;
	background: url(images/menuBottom.png);
	background-repeat: no-repeat;
	padding: 1px 0 1px 20px;
	font-size: 0.8em;
}

.sidemenu li.bottom a:hover {
	color: #FFFFFF;
	background: url(images/menuBottom.png) 0 -22px;
}

.sidemenu li.bottom a:active {
	color: #FFFFFF;
	background: url(images/menuBottom.png) 0 -44px;
}

.menu1 {
	width: 100%;
	height: 150px;
	background: white;
}

.menu2 {
	width: 100%;
	height: 150px;
	background: white;
}

.menu3 {
	width: 100%;
	height: 150px;
	background: white;
}

.icons {
	width: 170px;
	height: 125px;
	margin-left: 50px;
	margin-top: 12px;
	float: left;
	font-size: 12px;
	border-radius: 1px 15px 1px 15px;
	color: White;
	padding: 0px 10px 10px 10px
}

.icons a {
	text-decoration: none;
	color: White;
}
/*#menu ul {
	list-style:none;
	padding:0;
	margin:0;
}
#menu li {
	float:left;
	position:relative;
	line-height: 2.5em;
	width: 10em;
}

#menu a {
	display:block;
	border-right:1px solid #fff;
	background:#E0F574;
	color:#3B3B3B;
	text-decoration:none;
	padding:0 10px;
}
#menu a:hover {
	background-color:#5798B4;
	color:#fff;
}
#menu ul {
	border-top:1px solid #fff;
}
#menu ul a {
	border-right:none;
	border-right:1px solid #fff;
	border-bottom:1px solid #fff;
	border-left:1px solid #fff;
	background:#AEC245;
}

#menu ul {
	position:absolute;
	margin-top:-1em;
	margin-left:.5em;
	display:none;
}
#menu li ul {
	margin-top:-3em;
	margin-left:7em;
}*/
</style>







<!--  <script>
  
window.location.hash="no-back-button";
window.location.hash="Again-No-back-button";//again because google chrome don't insert first hash into history
window.onhashchange=function(){window.location.hash="no-back-button";}
</script>-->
<style>
html, body {
    margin: 0;
    height: 100%;
    width:100%;
}

.blue .accordion {
	border-top: 1px solid #fff;
	border-right: 1px solid #013d6c;
	border-left: 1px solid #013d6c;
	border-radius: 2px;
	
}

.blue .accordion, .blue .accordion li {
	margin: 0;
	padding: 0;
	border: none;
	border-radius: 0px;
	
}

.blue .accordion a {
	
	padding: 10px 10px 10px 15px;
	
	background-color: green;
	display: block;
	
	border-bottom: 1px solid #fff;
	border-top: 1px solid #FFF;
 
	text-align: left;
  	font: 12px 'Lato', sans-serif;
  	text-decoration: none;
  
   	text-transform: normal;  
  	color: white;

  	background-size: 4px 4px;
}

.blue .accordion ul a {
	padding: 10px 10px 10px 25px;
	
}

.blue .accordion a.dcjq-parent, .blue .accordion a.dcjq-parent:hover {
	padding: 10px 10px 10px 15px;
	
}



.blue .accordion a:hover {
	background: #FFC30B;
	color: green;
	font: bold 13px 'Arial',sans-serif;

}
.blue .accordion a.dcjq-parent.active {
	background: #599ED2 url(images/checkers.png) repeat 0 0;
}


.blue .accordion a:active {
	
}
</style>

<script type="text/javascript" language="javascript">

$(document).ready(function(){
	 
	if(document.getElementById('current').value!="")

	{
	 Check_SoftMsg();
	Check_IB(); 
	}

      
 
	});
	


function Redirect() {
    window.location = "https://online.snnl.net/Session2";
    //window.location.href = '../Session2'; //one level up
 }

	
	

function Soft_Mesaage()
{
	$("#myModal3").modal("show");
}
	
	function Check_SoftMsg()
	{
	//	alert('Software Message');
		$.ajax({
			type: "POST",
			url: "${pageContext.servletContext.contextPath}/FindSoftwareCount.htm",
			success: function(response){
				

				 var temp=response.split("$$");
					
					 
						var Mode_Value=temp[0];
						var Mode_Value1=temp[1];
					//	alert(Mode_Value1);

					 if (Mode_Value !="0")
						 {
						// alert(Mode_Value);
						
						 document.getElementById('Soft_Msg').style.display='table -row';
						 document.getElementById('myInput3').value=Mode_Value1;
						
						 }
					 else
						 {
						 document.getElementById('Soft_Msg').style.display='none';
						 
						 }
					 
				
			},
			error: function(e){						
				//alert('Error while request..'+e);
			}
		});
		
				
	}


function Check_IB()

{
//alert('Check Ib');
	
	

	$.ajax({
		type: "POST",
		url: "${pageContext.servletContext.contextPath}/IB_Count.htm",
		success: function(response){
			

			 var temp=response.split("$$");
				
				 
					var Mode_Value=temp[0];

				 if (Mode_Value !="0")
					 {
					// alert(Mode_Value);
					 IB_Ajax();
					 
					 }
				 
			
		},
		error: function(e){						
			//alert('Error while request..'+e);
		}
	});

}

	
	
function IB_Ajax() 
{

   // alert(AccNo);
    

    	var path="${pageContext.servletContext.contextPath}";
    	var snnl4 = "${pageContext.request.contextPath}";
    	//alert(snnl4);
    	var url=path+"/Pop_UpIBTran";
    	//alert(url);
        popupWindow = window.open(url, "List", "left = 500,top=150,directories=no,titlebar=no,toolbar=no,location=no,status=no,menubar=no,width=800,height=600");
        //  "/snnl4/FD_Interest_List/" + Accno
      //  parent_disable();
        
       
   }




function myFunction() {
    var txt;
    var person = prompt("Enter the Customer ID");
    if (isNaN(person))
	   {
	   alert('Enter a Valid Customer Id');
	   return false;
	   }
    if (person == null || person == "") {
        alert('Enter a Valid Customer Id');
    } else {
      //  txt = "Hello " + person + "! How are you today?";
        var path="${pageContext.servletContext.contextPath}";
        var snnl4 = "${pageContext.request.contextPath}";
    	//alert(snnl4);
    	var url=path+"/Customer_Enq/" + person+"";
    	//alert(url);
        window.open(url, "List", "left = 500,top=150,directories=no,titlebar=no,toolbar=no,location=no,status=no,menubar=no,resizable=no,width=600,height=450,scrollbars=yes");
        //  "/snnl4/FD_Interest_List/" + Accno
    }
    document.getElementById("demo").innerHTML = txt;
}


function GetCustomerCount()

{
//alert('Check Ib');
	
	

	$.ajax({
		type: "POST",
		url: "${pageContext.servletContext.contextPath}/Cus_Count.htm",
		success: function(response){
			

			 var temp=response;
				
				 
					var Mode_Value=temp;

					 document.getElementById("demo").innerHTML = Mode_Value;
				 
			
		},
		error: function(e){						
			//alert('Error while request..'+e);
		}
	});

}

</script>

<style>
#loader {
  border: 16px solid #f3f3f3;
  border-radius: 75%;
  border-top: 16px solid #3498db;
  width: 120px;
  height: 120px;
  -webkit-animation: spin 4s linear infinite; /* Safari */
  animation: spin 2s linear infinite;
}

/* Safari */
@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  50% { transform: rotate(360deg); }
}
</style>
<script>

$(window).ready(function() {
    $('#loader').hide();
});


</script>

</head>






<%

String Msg="Pisquare";
int msg_cnt=2;
int lable1=0;
int lable2=0;



String userId="";
Date loginDate=new Date();
int status=1;



//Fetch the values from URL query parameters


 String sanitizeduserId = "";

 if (userId != null)
{
//Sanitize the value assigned to uname 


sanitizeduserId = userId;
 } 

String sanitizedloginDate = ""; 

if (loginDate != null)
{ 

//Sanitize the value assigned to target query param 

sanitizedloginDate = loginDate.toString();


}
String  realPath = request.getRealPath("/resources/images/");
out.println(sanitizeduserId);




%>
<script>
function Account_Details() {
    var txt;
    var AccNo = prompt("Enter the Account Number:");
    if (AccNo == null || AccNo == "") {
        txt = "User cancelled the prompt.";
    } else {
    	var path="${pageContext.servletContext.contextPath}";
    	var snnl4 = "${pageContext.request.contextPath}";
    	//alert(snnl4);
    	var url=path+"/Account_Details/" + AccNo+"";
    	//alert(url);
        window.open(url, "List", "left = 500,top=150,directories=no,titlebar=no,toolbar=no,location=no,status=no,menubar=no,width=600,height=800");
        //  "/snnl4/FD_Interest_List/" + Accno
    	
    }
    document.getElementById("demo").innerHTML = txt;
}
</script>

<body>
	<div id="enquiry_div"
		style="font-size: 14px; background-image: url('resources/images/book.jpg'); position: fixed; z-index: 9999; margin-top: 10%; margin-right: 0px; right: -150px; width: 140px; height: 106px; padding: 10px 10px; border: 1px solid silver;">
		<table cellpadding="5px">
			<tr>
				<td style="padding-left: 35px">Customer No:</td>
			</tr>
			<tr>
				<td style="padding-left: 35px"><input type="text"
					name="txt_Cus_Id" style="width: 90px" value=""></td>
				<td style="padding-left: 35px"><input type="text"
					name="txt_count" style="width: 90px" value=""></td>
			</tr>
			<tr>
				<td style="padding-left: 35px"><input type="button" name="view"
					value="View Details" onclick="OpenPopup();" class="btn_Wood"></input>
				</td>
			</tr>
		</table>
		<br />
		<br />

	</div>

	<img src="${pageContext.request.contextPath}/resources/images/enq.png" height="128px" id="enquiry_div_btn"
		style="cursor: pointer; position: fixed; margin-top: 10%; z-index: 9999; right: 0px; background: #f1f1f1;" onclick="myFunction();">

	<div id="acc_enquiry_div"
		style="font-size: 14px; background-image: url('images/book.jpg'); position: fixed; z-index: 9999; margin-top: 22%; margin-right: 0px; right: -300px; width: 140px; height: 106px; padding: 10px 10px; border: 1px solid silver;" >
		<table cellpadding="5px">
			<tr>
				<td style="padding-left: 35px">Account No:</td>
			</tr>
			<tr>
				<td style="padding-left: 35px"><input type="text"
					name="txt_Acc_No" Id="txt_Acc_No" Class="Tbox1" style="width: 90px" />
				</td>
			</tr>
			<tr>
				<td style="padding-left: 35px"><input type="button"
					name="acc_view" value="View Details" onclick="Acc_Popup();"
					Class="btn_Wood"></td>
			</tr>
		</table>
		<br />
		<br />
	</div>

	<img src="${pageContext.request.contextPath}/resources/images/account.png" height="128px"
		id="acc_enquiry_div_btn"
		style="cursor: pointer; position: fixed; margin-top: 22%; z-index: 9999; right: 0px; background: #f1f1f1;" onclick="Account_Details();">

	<div id="page-wrap" style="box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 5px 3px 0px rgba(0, 0, 0, 0.19);">
				<table width="100%">
	<tr><!-- 46A2EA -->
						<td style="background-image: url(${pageContext.request.contextPath}/resources/images/greenbg.jpg); height: 80px; width: 1200px;box-shadow:1px 0 2px black;">

					<div style="float: left; padding-left: 10px; padding-top: 5px">
						<img src="${pageContext.request.contextPath}/resources/images/Ntbflogo_old.PNG" width="75px" height="75px"
							alt="Logo" />
					</div>

					<div style="float: left; padding-top: 10px; padding-bottom: 10px">
						<span
							style="font-size: 12px; color: White; padding: 30px 0px 20px 0px; font-family: Georgia">
							<span
							style="font-size: 38px; font-family: Arial; color: #ffffff; padding-left: 30px;text-shadow: 1px 1px 2px black, 0 0 25px blue, 0 0 5px darkblue; ">
								Shri Narayani Nidhi Ltd.,</span> 
								
						</span>
						<span style="text-align: right; font-size: 15px; font-style: bold;text-shadow: 1px 1px 2px black, 0 0 25px blue, 0 0 5px white;">
							${BranchName}	
							</span>
							<span style="text-align: right; font-size: 15px; font-style: bold;text-shadow: 1px 1px 2px black, 0 0 25px blue, 0 0 5px white;">
							${Ccount}	
							</span>
							
								<br>
                        <span style="padding-left: 30px; font-size: 16px;color: #ffffff;text-shadow: 1px 1px 2px black, 0 0 25px darkgreen, 0 0 5px darkgreen;">(Declared as "Nidhi" by The Government
                            of India) </span>
					</div>
<input type="hidden" id="current" value="${Current}">
					<div
						style="width: 170px; float: left; color: #ffffff; font-size: 12px; padding-top: 10px; >
						<div style="vertical-align: top; text-align: right;">

							<font style="vertical-align: top;">(${Msg_Count})</font> <a
								href="<%=request.getContextPath()%>/Message_View" alt="msg"> <img
								src="${pageContext.request.contextPath}/resources/images/message.png" width="32px" height="32px"
								alt="msg" />
							</a>
						</div>
						<div>
							<span style="text-align: right; font-size: 16px; font-style: bold;">
								
							</span>
						</div>
					</div>
					<div
						style="width: 140px; float: right; color: #ffffff; font-size: 12px; padding-top: 10px;">
						<div style="padding: 0px 0px 7px 0px"></div>
						<div style="text-shadow: 1px 1px 2px black, 0 0 25px blue, 0 0 3px darkgreen;">
							User Id :${user} <br> Date :${Current}      
						</div>

						<div style="padding: 7px 0px 0px 10px; text-align: left;text-shadow: 1px 1px 2px black, 0 0 25px blue, 0 0 3px darkgreen;font-size: 15px; font-style: bold;">
							<a href="<%=request.getContextPath()%>/logout" style="color: white">Logout</a>
						</div>
					</div>
				</td>
					</tr>
					
					
					<tr style="background-image: url(${pageContext.request.contextPath}/resources/images/bc3.jpg);">
						<td  align="center" style="box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 5px 3px 0px rgba(0, 0, 0, 0.19);padding-top: 15px;">
							<div class="wrap" width="100%" >
								<!-- style="box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 5px 3px 0px rgba(0, 0, 0, 0.19);" -->
								<ul class="menu" width="100%" align="center">
									<li style="padding-left: 0px;"><a href="<%=request.getContextPath()%>/Settings_Home"> <img
											src="${pageContext.request.contextPath}/resources/images15/settings.png" alt="Settings" /></a></li>
									<li ><a href="<%=request.getContextPath()%>/Customer_Home"> <img
											src="${pageContext.request.contextPath}/resources/images15/member.png" alt="Member" width="80px" height="26px"/>
									</a></li>
									<li ><a href="<%=request.getContextPath()%>/Share_Home"> <img
											src="${pageContext.request.contextPath}/resources/images15/share.png" alt="Share" />
									</a></li>
									<li ><a href="<%=request.getContextPath()%>/Savings_Home"> <img
											src="${pageContext.request.contextPath}/resources/images15/savings.png" alt="Savings" />
											
									</a></li>
									<li style="padding-right: 30px;"><a href="<%=request.getContextPath()%>/DDS_List/1"> <img
											src="${pageContext.request.contextPath}/resources/images15/dailydeposit.png" alt="DDS" width="110px" height="26px" />
											</a>
									<li style="padding-right: 20px;"><a href="<%=request.getContextPath()%>/Term_Deposit_Home"> <img
											src="${pageContext.request.contextPath}/resources/images15/term-deposit.png"
											alt="Term Deposit" />
									</a></li>
									<li ><a href="<%=request.getContextPath()%>/JL_List"> <img
											src="${pageContext.request.contextPath}/resources/images15/Loan.png" alt="Loan" />
									</a></li>
									<li ><a href="<%=request.getContextPath()%>/Voucher_Receipt"> <img
											src="${pageContext.request.contextPath}/resources/images15/vouchers.png" alt="Vouchers" />
									</a></li>
									<li style="padding-right: 15px;"><a href="<%=request.getContextPath()%>/ViewSB_TransactionList">
									<img src="${pageContext.request.contextPath}/resources/images15/administrator.png" alt="Admin" width="105px" height="26px"/></a></li>
									
									<li style="padding-right: 15px;"><a href="<%=request.getContextPath()%>/CC_List/1"> <img
											src="${pageContext.request.contextPath}/resources/images15/secloan.png" alt="Secure_Loan" width="105px" height="30px"/></a></li>
											<li width="35px"><a href="<%=request.getContextPath()%>/Master1" width="35px"> <img
											src="${pageContext.request.contextPath}/resources/images15/dash_board2.png" alt="Dash" width="35px"/></a></li>
											<li width="35px"><a href="<%=request.getContextPath()%>/Documents/4" width="35px"><img src="${pageContext.request.contextPath}/resources/images13/Doc9.png" alt="Doc" width="100px" height="35px"/></a></li>

											
						<button type="button"  class="btn btn-primary" onclick="Soft_Mesaage()" id="Soft_Msg">Message From Software</button>
															
									<%--	<li><a href="#"><span class="iconic document"></span> Reports</a>
						</li>--%>
								</ul>
							
								</div>
								
						
							

						</td>
					</tr>
					<!-- <tr>
						<td style="border-radius: 10px; background-color: #FFFFFF"><marquee>
							<font style="font-size: 12px;" direction="left"><%=Msg%></font> </marquee></td>
					</tr>-->
	
	<!-- Modal content-->
									<div class="modal fade" id="myModal3" role="dialog">  
     <div class="modal-dialog modal-lg">
      
      <!-- Modal content-->  
      <div class="modal-content">  
        <div class="modal-header">  
          <button type="button" class="close" data-dismiss="modal">×</button>  
        </div>  
        <div class="modal-body edit-content">  
       <fieldset disabled="disabled">
        <textarea class="form-control" rows="5" id="myInput3"></textarea>
        </fieldset>
        </div>  
        <div class="modal-footer">  
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>  
        </div>  
      </div> 
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
        
    </div>  
  </div> 
  
	
</body>
</html>
