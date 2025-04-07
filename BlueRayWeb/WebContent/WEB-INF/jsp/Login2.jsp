<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Corporate Office </title>
<style>
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
        
<script>

function CheckPassword()
{
	var userid=document.getElementById('txtUserName').value;
	if(userid =='')
		location.reload();
	
	}

function madeAjaxCallAccess(){
	document.getElementById('ButtonData').style.display ='table-row';
}



    $(document).ready(function() {
    	
        function disableBack() { window.history.forward() }

        window.onload = disableBack();
        window.onpageshow = function(evt) { if (evt.persisted) disableBack() }
        
        $("#form-id").on("keypress", function (event) { 
            console.log("aaya"); 
            var keyPressed = event.keyCode || event.which; 
            if (keyPressed === 13) { 
                alert("You pressed the Enter key!!"); 
                event.preventDefault(); 
                return false; 
            } 
        }); 
        
    });

    
    

    function OpenPopup4()
    {
    	//ddl_Scheme
    	//alert('Hai');
    	var userid=document.getElementById('txtUserName').value;
    	//var branch=document.getElementById('ddl_Scheme').value;
    	
    		var UserName=userid;
    	//var bcd=branch.substring(0,3);
    	//alert(bcd);
    	if(UserName=="")
    		{
    		alert("Enter User Name");
    		}
    	else{
    	var path="${pageContext.servletContext.contextPath}";
    	var snnl4 = "${pageContext.request.contextPath}";
    	var urlMsg="corp";
    	 //	var url2="http://localhost:8080/sample11/White_Desk.jsp?from="+UserName+"&urlMsg="+urlMsg+"";
    	 	//var url2="http://localhost:8082/sample11/White_Desk.jsp?from="+UserName+"&urlMsg="+urlMsg+"";
    		// var url2="http://192.168.1.55:8082/sample10/White_Desk.jsp?from="+UserName+"&urlMsg="+urlMsg;
    		// var url2="https://uatcredit.snnl.net/White_Desk.jsp?from="+UserName+"&urlMsg="+urlMsg;
    		 var url2="https://fpregister.snnl.net/White_Desk.jsp?from="+UserName+"&urlMsg="+urlMsg;

    	//alert(url2);
        window.open(url2, "List", "left = 100,top=150,directories=no,titlebar=no,toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=500,height=100");
        //  "/snnl4/FD_Interest_List/" + Accno
       // window.resizeTo(300, 700);
    	}
    		
    }
    
    
    function OpenPopup5()
    {
    	//ddl_Scheme
    	//alert('Hai');
    	var userid=document.getElementById('txtUserName').value;
    	//var branch=document.getElementById('ddl_Scheme').value;
    	
    	
    		
    	var UserName=userid;
    	
    	
    	//var bcd=branch.substring(0,3);
    	//alert(bcd);
    	if(UserName=="")
    		{
    		alert("enter User Name");
    		}
    	else{
    	var path="${pageContext.servletContext.contextPath}";
    	var snnl4 = "${pageContext.request.contextPath}";
    	var urlMsg="corp";
    	 	var url2="http://localhost:8080/sample11/Malai_Aruvi.jsp?from="+UserName+"&urlMsg="+urlMsg+"";
    	alert(url2);
        window.open(url2, "List", "left = 500,top=150,directories=no,titlebar=no,toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=100,height=250");
        //  "/snnl4/FD_Interest_List/" + Accno
       // window.resizeTo(500, 200);
    	}
    		
    }


</script>
<body>
 <form:form method="post" action="${pageContext.servletContext.contextPath}/LoginValidate" modelAttribute="loginEntity" commandName="loginEntity" name="loginForm" id="form-id">
    <center>
    <div>
        <table width="95%" border="0">
            <tr>
                <td height="100" style="background-image: url(${pageContext.request.contextPath}/resources/Images/Background.jpg); background-size: cover; box-shadow:1px 0 2px black;">
                
                    <table width="100%">
						<colgroup>
							<col width="20%" />
							<col />
							<col width="30%" />
						</colgroup>
						<tr>
						
							
							<td style="text-align: center;font-family: 'Arial', sans-serif;"><span
								style="font-size: 30px; font-weight: bold; color: White; line-height: 1.4;text-shadow: 1px 1px 1px green, 0 0 25px darkgreen, 0 0 3px darkgreen;">
								BlueRay App</span> <br /> 
							</td>
							
						</tr>
					</table>
                </td>
            </tr>
            <tr>
                <td>
                    <table width="100%" border="1" style="background-color:#F5F8FA; border: thin solid #394B62;">
                        <colgroup>
                            <col width="300px" />
                            <col />
                        </colgroup>
                        <tr>
                            <td>
                                <table width="100%;">
                                    <tr>
                                        <td style="padding-left: 5px;" bgcolor="#FFA824" colspan="2">
                                            <span style="font-family: Cambria; font-weight: bold; color: Black">Login </span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 5px; padding-top: 7px; padding-bottom: 7px">
                                            User Name
                                        </td>
                                        <td style="padding-left: 5px; padding-right: 10px;">
                                           <form:input type="text" path="Username" id="txtUserName" Width="100%" onchange="madeAjaxCallAccess();"/> 
                                      <form:hidden path="flag1" id="flag1"/>
                                        </td>
                                    </tr>
                                    <tr>
                                     <td width="100%"> <form:errors path="Username" cssClass="error" /></td>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 5px; padding-top: 7px; padding-bottom: 7px">
                                            Password
                                        </td>
                                        <td style="padding-left: 5px; padding-right: 10px;">
                                          <form:input type="password" path="Password" id="txtPassword" Width="100%" onchange="CheckPassword();"/> 
                                         </td>
                                         </tr>
                                         <tr> 
                                        
										<td>	<form:errors path="Password" cssClass="error" /></td>
										</tr>

										
                                    <tr align="left" id="ButtonData" style="display:none;">
                                        <td>
                                            &nbsp;
                                        </td>
                                        <td>
                                            <input type="submit" name="normal" value="Submit" /></td>
                                        </td>
                                    </tr>
                                    <tr id="FingerData" style="display:none;">
										<td>
																<a href= "#" onclick="OpenPopup4();" id="EVerifyLink"><font size="2px" color="RED">E-Verify</font></a>
										
										</td>
										<td>
										                    <input type="hidden" id="txtHmac3" class="form-control" value= <%= session.getId() %>/>
										             
                                            <input type="submit" name="ELogin" value="ESubmit" /></td>
                                            
										</td>
										</tr>
                                    <tr>
                                        <td colspan="2" align="center">
                                            <font color="Red">${message}${errorMessage}</font>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td style="background-image: url(${pageContext.servletContext.contextPath}/resources/Images/abtnid.bmp)">
                                <%--<embed src="b.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer"
                                        type="application/x-shockwave-flash" width="100%"></embed>--%>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td>
                </td>
            </tr>
            <%--<tr>
                <td height="200px" align="center" valign="middle">
                    <img src="../Images/logo_coop.gif" alt="" />
                </td>
            </tr>--%>
        </table>
<!--                  <a href="http://www.pisquaresoftware.com" target="_blank"><span style="padding-left: 10px;font-size: 5px;text-shadow: 0px 0px 1px black, 0 0 1px black, 0 0 2px black;color: white; ">Developed By Pi Square Software Solutions. </span></a> -->
        
    </div>
    </center>
    </form:form>
</body>
</html>