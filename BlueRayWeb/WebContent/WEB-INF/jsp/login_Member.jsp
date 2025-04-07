<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogIn</title>
<style>
table.comicGreen {
  font-family: "Comic Sans MS", cursive, sans-serif;
  border: 2px solid #4F7849;
  background-color: #EEEEEE;
  width: 100%;
  text-align: center;
  border-collapse: collapse;
}
table.comicGreen td, table.comicGreen th {
  border: 1px solid #4F7849;
  padding: 3px 2px;
}
table.comicGreen tbody td {
  font-size: 19px;
  font-weight: bold;
  color: #4F7849;
}
table.comicGreen tr:nth-child(even) {
  background: #CEE0CC;
}
table.comicGreen td {
  font-size: 21px;
  font-weight: bold;
  color: #FFFFFF;
  background: #4F7849;
  background: -moz-linear-gradient(top, #7b9a76 0%, #60855b 66%, #4F7849 100%);
  background: -webkit-linear-gradient(top, #7b9a76 0%, #60855b 66%, #4F7849 100%);
  background: linear-gradient(to bottom, #7b9a76 0%, #60855b 66%, #4F7849 100%);
  border-top: 1px solid #444444;
}
table.comicGreen tfoot td {
  font-size: 21px;
}
</style>

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
}0

}

function Number_Only(e) {
    if ([e.keyCode || e.which] == 8) //this is to allow backspace
        return true;
    if ([e.keyCode || e.which] == 9) //this is to allow tab
        return true;
    if ([e.keyCode] == 46) //this is to allow Delete
        return true;
    if ([e.keyCode || e.which] == 37) //left arrow .
        return true;
    if ([e.keyCode || e.which] == 39) //right arrow .
        return true;
    if ([e.keyCode || e.which] == 16) //shift .
        return true;

    if ([e.keyCode || e.which] < 48 || [e.keyCode || e.which] > 57)
        e.preventDefault ? e.preventDefault() : e.returnValue = false;
}

function SubmitValidation() 
{
    var Customer_Info = document.getElementById('User_Id').value;
    //Pass_Id
     var y = document.getElementById('Pass_Id').value;
     var z = document.getElementById('CapForm').value;
    if(Customer_Info =="")
    {
    	alert("Please Enter User ID");
    	document.getElementById('CapForm').value="";
    	return false;
    }
    else if(y =="")
    {
    	alert("Please Enter Password");
    	document.getElementById('CapForm').value="";
    	return false;
    }
   /* else if(z =="")
    {
    	alert("Please Enter Capcha");
    	document.getElementById('CapForm').value="";
    	return false;
    }*/
    
    
    return true;
}
function validate()
{
	var OTP = document.getElementById('txt_OTP').value;
	//alert(OTP);
	var OTP1 = document.getElementById('txt_OTP1').value;
	//alert(OTP1);
	
	
	if(OTP == OTP1)
		{
		
		return true;
		}
	
	alert('Your OTP is Incorrect');
	document.getElementById('txt_OTP').value="";
	return false;
	
	}

window.onload = function() 
{
	alert('Onload');
	document.getElementById('OTP').style.display='none';
	document.getElementById('OTP_Button').style.display='none';
	
	if(document.getElementById('Flag').value==2)
	{
	document.getElementById('OTP').style.display='table-row';
	document.getElementById('OTP_Button').style.display='table-row';

	
	}
	
	
	if(document.getElementById('OTPFlag').value==2)
	{
		document.getElementById('OTP').style.display='none';
		document.getElementById('OTP_Button').style.display='none';

	
	}
	
	
}


$(document).ready(function(){
	
	//alert('Onload');
	
});


function otpkk()
{
	//alert('Onload');
	document.getElementById('OTP').style.display='none';
	document.getElementById('OTP_Button').style.display='none';
	
	if(document.getElementById('Flag').value==2)
	{
	document.getElementById('OTP').style.display='table-row';
	document.getElementById('OTP_Button').style.display='table-row';

	
	}
	

	
	
	}

</script>
<SCRIPT >
	window.history.forward();
	function noBack() { window.history.forward(); }
</SCRIPT>

							<script>
							
window.location.hash="no-back-button";
window.location.hash="Again-No-back-button";//again because google chrome don't insert first hash into history
window.onhashchange=function(){window.location.hash="no-back-button";}
</script>
<style>
.error {
	color: green;
	font-weight: bold;
	font-family: 'Droid Sans', sans-serif;;
	font-size: 12px;
}
}
</style>

<style>
.btn_Blue {
	background: #25A6E1;
	background: -moz-linear-gradient(top, #25A6E1 0%, #188BC0 100%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #25A6E1),
		color-stop(100%, #188BC0));
	background: -webkit-linear-gradient(top, #25A6E1 0%, #188BC0 100%);
	background: -o-linear-gradient(top, #25A6E1 0%, #188BC0 100%);
	background: -ms-linear-gradient(top, #25A6E1 0%, #188BC0 100%);
	background: linear-gradient(top, #25A6E1 0%, #188BC0 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#25A6E1',
		endColorstr='#188BC0', GradientType=0);
	padding: 3px 5px;
	color: #fff;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 14px;
	border-radius: 4px;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
	border: 1px solid #1A87B9
}

</style>
</head>


	<!-- color: #ff0000; -->
<body onload="otpkk();" 
	onpageshow="if (event.persisted) noBack();" onunload="">
	
	  <!-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------ -->                                                 
                     <table width="100%" style="height: 100px" cellpadding="0"
						cellspacing="0">
						
						<tr>
							 
                           <td colspan="2" style="width:100%; border-radius: 10px; background-image: -moz-linear-gradient(bottom,#014D1E 0%, #215E21 100%); background-color:#08a64c;
								height: 80px">
								<div style="float: left; padding-left: 50px">
									<img src="${pageContext.servletContext.contextPath}/resources/images/Ntbflogo_New.png" width="83px" height="84px" alt="Logo" />
								</div>
								<div style="float: left; padding-top:10px;padding-left: 100px;">
									<span style="font-size: 14px; color: White; padding: 30px 0px 20px 0px; font-family: Georgia">
										<span style="font-size: 45px; font-family: Arial; color: #ffffff; padding-left: 30px;text-shadow: 1px 1px 2px black, 0 0 25px darkgreen, 0 0 3px darkgreen;">
											Shri Narayani (Kumbakonam) Nidhi Limited., </span> <br>
											<span style="padding-left: 50px;text-shadow: 1px 1px 1px green, 0 0 25px green, 0 0 3px green;font-family: Arial; ">
													Declared as "Nidhi" by The Government of India
													</span>
											<span style="padding-left: 50px;text-shadow: 1px 1px 1px green, 0 0 25px green, 0 0 3px green;color: YELLOW; font-family: Arial;">
													YOUR FINANCIAL FRIEND
													</span>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											
											<span style="padding-left: 10px;text-shadow: 1px 1px 1px green, 0 0 25px green, 0 0 3px green;color: #ffffff; font-family: Arial;">
													CIN: U74999TN2017PLC120244
													</span>
									</span>
								</div>
								
							</td>
                     
							</tr>
	
	<form:form method="post" action="${pageContext.servletContext.contextPath}/LoginValidate"
		modelAttribute="loginEntity" commandName="loginEntity"
		name="loginForm">

		<table width="100%" cellpadding="0" cellspacing="0" style="background-color: #ffff"><!-- #2960c9 #81A8F2-->
		
			
			<tr>
				<td style="padding: 10px 0px 50px 0px;">
					<center>
					
						<table width="480px"  style="background-color: #00BFFF;" >
							<colgroup>
								<col style="background-color: white;">
								<%--<col style="background-color: #f4f4f4">--%>
							</colgroup>
							
								<tr>
				<td
					style="padding: 10px 10px 10px 10px; font-size: 36px; color: White; ">
					<center><div style="display:none;float: center; padding-left: 10px ">
						<img src="${pageContext.servletContext.contextPath}/resources/images/Ntbflogo_old.PNG" alt="Logo" height="76px"
							width="86px" />
					</div></center>
					<div style="float: center">
						<span
							style="font-size: 20px; color: Green; padding: 30px 0px 20px 20px; font-family: Segoe UI">
							Welcome to Shri Narayani (Kum) Nidhi Ltd.,</span>
					</div>
				</td>
			</tr>
			<tr	>
								<td
									style="vertical-align: bottom; padding: 5px 0px 15px 0px; background-image: url(resources/images/mlogin1.png); background-repeat: no-repeat; background-position: center center; height: 180px;">
									<center></center>

								</td>
<!-- login2.png login5.jpg  login4.png lo-->
							</tr>
							<tr>
								<td>
									<table width="100%"
										style="background-image: -moz-linear-gradient(bottom, #00BFFF 0%, #87CEEB 100%);"
										cellspacing="2px" >
										<colgroup>
											<col width="180px" />
											<col width="170px" />
											<col />
										</colgroup>
										<tr>
											<td style="padding-left: 10px">User ID</td>
											<td>Password</td>
											
											<td></td>
										</tr>
										<tr>
											<td style="padding-left: 10px"><form:input type="text"
													 htmlEscape="true" path="Username" placeholder="User ID" value="${user}" id="User_Id" maxlength="8" pattern="[0-9]+"  onKeypress="javascript: return Number_Only(event)"/></td>
											<td><form:input type="password"  htmlEscape="true" path="Password"  placeholder="Password" value="${pswd}" id="Pass_Id" maxlength="20"/></td>
											<td><input type="submit" value="Submit" name="Submit_Login" onclick="return SubmitValidation();" class="btn_Blue"/></td>
											
										</tr>
										<tr><td colspan="3">${errorMessage}</td>
										</tr>
										
										<tr>
										<td colspan="3">
										<table class="comicGreen">

<tr style="display:none;">
<td><form:input  htmlEscape="true" path="captcha" placeholder="Enter Capcha"  id="CapForm"/></td>						

<td style="display:none;">
						<div>
							<img id="captcha_id2" name="imgCaptcha" src="captcha.jpg">
						</div>
					</td>
<td style="display:none;" align="left"><a href="javascript:;"
						title="change captcha text"
						onclick="document.getElementById('captcha_id').src = 'captcha.jpg?' + Math.random();  return false">
							<img src="${pageContext.servletContext.contextPath}/resources/images/refresh.png" />
					</a></td>
					<td>
				
					<img id="captcha_id" name="imgCaptcha2" src="simpleCaptcha.jpg">
					</td>
	<td align="left"><a href="javascript:;"
						title="change captcha text"
						onclick="document.getElementById('captcha_id').src = 'simpleCaptcha.jpg?' + Math.random();  return false">
							<img src="${pageContext.servletContext.contextPath}/resources/images/refresh.png" />
					</a></td>
					
					
						<td style="display:none;">
				
					<img id="captcha_id3" name="imgCaptcha3" src="simpleCaptcha2.jpg">
					</td>
	<td style="display:none;" align="left"><a href="javascript:;"
						title="change captcha text"
						onclick="document.getElementById('captcha_id3').src = 'simpleCaptcha2.jpg?' + Math.random();  return false">
							<img src="${pageContext.servletContext.contextPath}/resources/images/refresh.png" />
					</a></td>
</tr>



</table>
										</td>
										<tr>
										<td colspan="2"><form:errors  htmlEscape="true" path="captcha" cssClass="error" placeholder="Enter Capcha"/></td></tr>
										</tr>
				
											<tr id="OTP">
										<td>OTP</td>
										</tr>
										<tr id="OTP_Button">
										<td><form:input type="password"
													 htmlEscape="true" path="OTP" placeholder="OTP" id="txt_OTP"/></td><td>
													
										<input type="submit" value="GO" name="Otp" onclick="return validate();" class="btn_Blue"/>
										<form:hidden 
													 htmlEscape="true" path="OTP1" value="${otp}"  id="txt_OTP1"/></td>
													<form:hidden 
													 htmlEscape="true" path="csrfToken" value="${sessionScope.csrfToken}"  id="tocken"/>
										</tr>
										<tr>

											<td colspan="4" style="padding-left: 10px"></td>
										</tr>
										
										<form:hidden  htmlEscape="true" path="Flag"   value="${Flag}"/>
										
										<tr>
											<td><form:errors  htmlEscape="true" path="Username" cssClass="error" /></td>
											<td><form:errors  htmlEscape="true" path="Password" cssClass="error" /></td>
										</tr>

										<tr>
											<td colspan="5"><h4>
													<font color="Blue">${message}</font></h3></td>
													
										</tr>
										

									</table>
								
										
										
								</td>
							</tr>
						</table>
						</div>
					</center>
				</td>
			</tr>
		</table>
		<%-- <div id="title_bar">
        <span style="font-size: 32px; color: White; padding: 20px 0px 20px 20px; font-family: Georgia"> Pi-Fi </span>
        <span style="font-size: 36px; font-family: Monotype Corsiva; color: #E2E2E2; padding-left: 30px"> Trichy Rockcity Benefit Fund </span>
    </div>
    <div id="main_div">
        <div id="leftbar">
            <center>
                <table>
                    <tr>
                        <td>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <img src="images/lock.png" height="400" width="400" alt="Image is not available">
                        </td>
                    </tr>
                </table>
            </center>
        </div>
        <div id="rightbar" style="padding-top:100px;">
            
            <center>
                <fieldset id="login">
                    <h3>
                        Login</h3>
                    <hr />
                    <table cellpadding="10px">
                        <tr>
                            <td>
                                UserName:
                            </td>
                            <td>
                                <asp:TextBox ID="txt_Username" runat="server" required="required"></asp:TextBox>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Password:
                            </td>
                            <td>
                                <asp:TextBox ID="txt_Password" runat="server" required="required" TextMode="Password"></asp:TextBox>
                            </td>
                        </tr>
                        <tr>
                            <td>
                            </td>
                            <td>
                                <asp:Button ID="btn_Login" runat="server" Text="Login" value="Login" 
                                    CssClass="awesome" onclick="btn_Login_Click"/>
                            </td>
                        </tr>
                    </table>
                    <div id="errormsg" style="color: red">
                        <asp:Label ID="lbl_Status" CssClass="LblStatus" runat="server" Text=""></asp:Label>        
                    </div>
                </fieldset>
            </center>
        </div>
    </div>--%>
	</form:form>
	
</body>
</html>