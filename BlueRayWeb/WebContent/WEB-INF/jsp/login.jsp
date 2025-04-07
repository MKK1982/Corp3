<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogIn</title>
   <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js">
        </script>

<script>

    $(document).ready(function() {
        function disableBack() { window.history.forward() }

        window.onload = disableBack();
        window.onpageshow = function(evt) { if (evt.persisted) disableBack() }
    });

</script>
<script type="text/javascript">


function OpenPopup4()
{
	//ddl_Scheme
	//alert('Hai');
	var userid=document.getElementById('userid').value;
	var branch=document.getElementById('ddl_Scheme').value;
	
	
		
	var UserName=userid;
	var bcd=branch.substring(0,3);
	//alert(bcd);
	if(UserName=="")
		{
		alert("enter User Name");
		}
	else{
	var path="${pageContext.servletContext.contextPath}";
	var snnl4 = "${pageContext.request.contextPath}";
	//var urlMsg="12810007/12-05-2021/201";
	 	var url2="http://localhost:8080/sample11/Malai_Aruvi.jsp?from="+UserName+"&urlMsg="+bcd+"";
	//alert(url);
    window.open(url2, "List", "left = 500,top=150,directories=no,titlebar=no,toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=600,height=250");
    //  "/snnl4/FD_Interest_List/" + Accno
    window.resizeTo(500, 200);
	}
		
}



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
<body>

	<!-- color: #ff0000; -->
<body style="background-color: #f8f8f8;">
	<form:form method="post" action="${pageContext.servletContext.contextPath}/LoginValidate"
		modelAttribute="loginEntity" commandName="loginEntity"
		name="loginForm">

		<table width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td
					style="padding: 10px 10px 10px 10px; font-size: 36px; color: White; background-color: #999999">
					<div style="float: left; padding-left: 10px">
						<img src="${pageContext.servletContext.contextPath}/resources/images/Ntbflogo_old.PNG" alt="Logo" height="76px"
							width="86px" />
					</div>
					<div style="float: left">
						<span
							style="font-size: 42px; color: White; padding: 30px 0px 20px 20px; font-family: Segoe UI">
							BlueRay App </span>
					</div>
				</td>
			</tr>
			<tr>
				<td style="background-color: #474747">
					<hr
						style="border-style: dashed; border-color: #474747; color: #ffffff; width: 100%; height: 2px" />
				</td>
			</tr>
			<tr>
				<td style="padding: 100px 0px 50px 0px;">
					<center>
						<table width="480px" style="background-color: #00BFFF">
							<colgroup>
								<col style="background-color: White;">
								<%--<col style="background-color: #f4f4f4">--%>
							</colgroup>
							<tr>
								<td style="font-size: 20px; padding: 10px 0px 10px 10px">
									Welcome to Shri Narayani Nidhi Ltd.</td>
							</tr>
							<tr>
								<td
									style="vertical-align: bottom; padding: 5px 0px 15px 0px; background-image: url(resources/images/Login.jpg); background-repeat: no-repeat; background-position: center center; height: 180px;">
									<center></center>

								</td>

							</tr>

							<tr>
								<td>
									<table width="100%"
										style="background-image: -moz-linear-gradient(bottom, #00BFFF 0%, #87CEEB 100%);"
										cellspacing="2px">
										<colgroup>
											<col width="180px" />
											<col width="170px" />
											<col />
										</colgroup>
										<tr>
											<td style="padding-left: 10px">Username</td>
											<td>Password</td>
											</td>
										</tr>
										<tr>
											<td style="padding-left: 10px"><form:input type="text"
													path="Username" /></td>
											<td><form:input type="password" path="Password" /></td>
											<td><input type="submit" value="Submit" /></td>${errorMessage}
										</tr>
										<tr>
										<td>
																<a href= "#" onclick="OpenPopup4();" id="EVerifyLink"><font size="2px" color="RED">E-Verify1</font></a>
										
										</td>
										</tr>
										
										<tr>

											<td colspan="4" style="padding-left: 10px"></td>
										</tr>
										<tr>
											<td><form:errors path="Username" cssClass="error" /></td>
											<td><form:errors path="Password" cssClass="error" /></td>
										</tr>

										<tr>
											<td><h3>
													<font color="Blue">${message}</font></td>
										</tr>

									</table>
								</td>
							</tr>
						</table>
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