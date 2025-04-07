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
  #example23{
 box-shadow: 5px 5px #888888;
  border-radius: 4px;
  }
   #example24{
 box-shadow: 1px 1px 1px 1px darkgreen;
  border-radius: 2px;
  }
  
   #example25{
 box-shadow: 1px 1px 1px 1px white;
  border-radius: 4px;
  }
  
     #example26{
 box-shadow: 1px 1px 1px 1px white;
  border-radius: 4px;
  }
  
#example2 {
   width: 80%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
   background-color: floralwhite;
 background-repeat: no-repeat;

  }
  
  #userid{
  width: 80%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
   background-color: floralwhite;
 background-repeat: no-repeat;
  }
  #input1{
  width: 60%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  
  box-sizing: border-box;
   background-color: floralwhite;
 background-repeat: no-repeat;
  box-shadow: 1px 1px 1px 1px darkgreen;
  border-radius: 2px;
  }
  
  #input2{
   width: 80%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  background-color: floralwhite;
 background-repeat: no-repeat;
  }

input[type=submit] {
  background-color: cornflowerblue;
  color: white;
  padding: 12px 30px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
   width: 100%;
   
}
input[type=submit]:hover {
  background-color: #45a049;
}


input[type=text]:focus {
  background-color: white;
}
input[type=password]:focus {
  background-color: white;
}


</style>
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
<script type="text/javascript">
        // Retrieve the JSON string from the request attribute
        var jsonResponse = '${billJson}';

        // Parse the JSON string
        var data = JSON.parse(jsonResponse);

        // Extract values from JSON and display them
        document.getElementById("customerName").innerText = data.billerResponse.customerName;
        document.getElementById("billAmount").innerText = data.billerResponse.billAmount;
        document.getElementById("dueDate").innerText = data.billerResponse.dueDate;
        document.getElementById("billPeriod").innerText = data.billerResponse.billPeriod;
        document.getElementById("approvalRefNum").innerText = data.billerResponse.approvalRefNum;
 </script>

<script type="text/javascript">
function my_onkeydown_handler()
{ //alert(event.keyCode);
      switch (event.keyCode)
    {
      case 116 : // 'F5'
      event.returnValue = false;
      event.keyCode = 0;
      window.status = "We have disabled F5";
      break; 
    }
      
      var keyPressed = event.keyCode || event.which; 
    //alert(keyPressed);
    	            if (keyPressed === 13) { 
    	                alert("You pressed the Enter key!!"); 
    	                event.preventDefault(); 
    	                return false; 
    	            } 
     		if (event.ctrlKey) { 
    	                alert('Dont press control key !'); 
    	                 return false; 
    	
    	            } 
                      
    	if (keyPressed  == 18) {
                    alert("Dont press Alt key!!"); 
    	            	
                }

     		     if (event.ctrlKey && event.shiftKey && keyPressed === 13)
    				{
    	            	alert("You pressed the Enter key!!"); 
    	            	event.preventDefault(); 
    	                return false; 
    				}
    	              if (event.altKey || event.ctrlKey)
    	            	{
    	            	alert("Dont press Alt Key !"); 
    	            	event.preventDefault(); 
    	                return false; 
    	            	}

    			if (event.altKey && event.ctrlKey && keyPressed === 13)
    	            	{
    	            	alert("Dont press Altkey");
    	            	event.preventDefault(); 
    	                return false; 
    	            	}
    			if (( event.altKey && event.ctrlKey) && keyPressed == 13)
    	            	{
    	            	alert("Dont press Alt Enter key");
    	            	event.preventDefault(); 
    	                return false; 
    	            	}

}









function f()
{
	alert('kk');
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
	
	
	function Check()
	{
		var OTP = document.getElementById('txt_OTP').value;
		
		var Otp_Length=OTP.length;
		
		
		if(+Otp_Length ==0)
			{
			return true;
			}
		else
			{
			alert('Click the Send Button');
			return false;
			}
		
	}

$(document).ready(function() {

$(document).keypress(
  function(event){
    if (event.which == '13') {
      event.preventDefault();
    }
});
	    	
	        function disableBack() { window.history.forward() }

	        window.onload = disableBack();
	        window.onpageshow = function(evt) { if (evt.persisted) disableBack() }
	        
	        $("#form-id").on("onkeydown", function (event) { 
	            console.log("aaya"); 
	            var keyPressed = event.keyCode || event.which; 
//alert(keyPressed);
	            if (keyPressed === 13) { 
	                alert("You pressed the Enter key!!"); 
	                event.preventDefault(); 
	                return false; 
	            } 
 		if (event.ctrlKey) { 
	                alert('Dont press control key !'); 
	                 return false; 
	
	            } 
                  
	if (keyPressed  == 18) {
                alert("Dont press Alt key!!"); 
	            	
            }

 		     if (event.ctrlKey && event.shiftKey && keyPressed === 13)
				{
	            	alert("You pressed the Enter key!!"); 
	            	event.preventDefault(); 
	                return false; 
				}
	              if (event.altKey || event.ctrlKey)
	            	{
	            	alert("Dont press Alt Key !"); 
	            	event.preventDefault(); 
	                return false; 
	            	}

			if (event.altKey && event.ctrlKey && keyPressed === 13)
	            	{
	            	alert("Dont press Altkey");
	            	event.preventDefault(); 
	                return false; 
	            	}
			if (( event.altKey && event.ctrlKey) && keyPressed == 13)
	            	{
	            	alert("Dont press Alt Enter key");
	            	event.preventDefault(); 
	                return false; 
	            	}

	        }); 
	        
	    });

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
<body >

	<!-- color: #ff0000; -->
<body style="background-color: #f8f8f8;">
	<form:form method="post" action="${pageContext.servletContext.contextPath}/LoginValidate"
		modelAttribute="loginEntity" commandName="loginEntity"
		name="loginForm" id="form-id">

		<table width="100%" cellpadding="0" cellspacing="0" >
			 <tr>
			 
            <td style="padding: 10px 10px 10px 10px; font-size: 36px; color: White; background-color: #0B3B17;background-image: url(${pageContext.request.contextPath}/resources/images/greenbg.jpg); height: 80px; width: 1200px;">
                <div style="float: left; padding-left: 10px;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 5px 3px 0px rgba(0, 0, 0, 0.19);">
				</div>
               
           
            <div style="width: 140px; float: right; color: #ffffff; font-size: 12px; padding-top:10px;text-shadow: 1px 1px 2px black, 0 0 25px darkgreen, 0 0 3px darkgreen;">
											<a href="<%=request.getContextPath()%>/logout_E">
												<img src="${pageContext.servletContext.contextPath}/resources/images/logout_1.png" title="Logout" alt="Logout" border="0" width="32px" height="32px"/>
											</a>
								</div>
            
            </td>
        </tr>
        <tr >
								<td style=" padding: 40px 0px 10px 10px" colspan="2" align="center">
									                       										<span style="font-size: 20px; font-family: Optima; color: cornflowerblue; padding-left: 30px;text-shadow: 0px 1px  1px black;">
									
									BlueRay MODULE</span></td>
							</tr>
			
			<tr id="example24">
				<td style="padding: 20px 0px 120px 0px;">
					<center>
						<table width="600px" style="background-color: white;" id="example24" >
							
							
							<tr>
								<!-- <td colspan="2" 
									style="vertical-align: bottom; 	 background-image: url(resources/images/Login.jpg); background-repeat: no-repeat; background-position: center center; height: 180px;">
									<center></center>

								</td>-->
								 <td align="center"  bgcolor="cornflowerblue"	 colspan="3">
                                            <span style="font-family: Cambria; font-weight: bold; color: white;font-size:22px;text-shadow: 1px 1px 2px black;" >APP SERVICES </span>
                                        </td>

							</tr>
							
							

							<tr>
								<td>
									<table width="80%"
										style="background-color: milkwhite;"
										cellspacing="2px" border="0" align="center">
										<colgroup>
											<col width="180px" />
											
											<col />
										</colgroup>
										  
										
										<form:hidden path="flag1" id="flag1"/>
										
						
										</tr>
										
										
										<tr>
										<td>RRN No : <form:input path="Rrn_No"  value="${Rrn_No}"/></td>
										
										
										<td>AES Token : <form:input path="AesToken"  value="${AesToken}"/></td>
										
										</tr>
										
										<tr>
										<td>Request Id : <form:input path="requestId"  value="${requestId}"/></td>
										
										
										<td>Ref Id : <form:input path="refId"  value="${refId}"/></td>
										
										<td>Msg Id : <form:input path="msgId"  value="${msgId}"/></td>
										
										</tr>
										<tr>
										<td>Category : <form:input path="Username"  /></td>
										
										
										<td>State : <form:input path="Password"  /></td>
										
										</tr>
										<tr>
										<td>Biller Id : <form:input path="AgentId"  /></td>
										
										</tr>
										<tr>
										<td>Name : <form:input path="ParamName1"  /></td>
										<td>Value : <form:input path="ParamValue1"  /></td>
										
										</tr>
										
										<tr>
										<td>Name2 : <form:input path="ParamName2"  /></td>
										<td>Value2 : <form:input path="ParamValue2"  /></td>
										
										</tr>
										
										<tr>
										<td>Agent Id : <form:input path="Agent_Id"  /></td>
										<td>Amount : <form:input path="Amount"  /></td>
										
										</tr>
										<tr>
										<td><input type="submit" value="Get CategoryList" name="CategoryListView"  /></td>
										<td> <input type="submit" value="Get StateList" name="StateListView"  /></td>
										</tr>
										<tr>
										<td><input type="submit" value="Get BillerList Token" name="BillerListView"  /></td>
										<td><input type="submit" value="Get BillerDetails" name="BillerDetailsView"  /></td>
										<td> <input type="submit" value="Get BillerFetch" name="BillerFetchView"  /></td>
										<td> <input type="submit" value="Get BillerValidate" name="BillerValidateView"  /></td>
										
										<td> <input type="submit" value="Get BillerPay" name="BillerPayView"  /></td>
										
										</tr>
										<tr>
										<td align="center" style="padding: 20px 0px 0px 0px;" colspan="2">
							<form:textarea colspan="2" path="OTP" id="input1" style="Width:500px;height:200px;word-wrap: break-word;" value="${signatureReqStr1}"/>
							
							</td>
										
										</tr>
										
										
                 
										</td>
										
										
										</tr>
										<TR id="FingerData"  style="display:none">
										
										<td width="50px" align="center">
																<a href= "#" onclick="OpenPopup4();" id="EVerifyLink">									<img src="${pageContext.servletContext.contextPath}/resources/images/finger53.png" width="73px" height="84px" placeholder="Finger" alt="finger" /></a>
										
										
										                    <input  id="txtHmac3" class="form-control" value= <%= session.getId() %>/>
										     </td><td width="100px">        
                                            <input type="submit" name="ELogin" value="ESubmit" height="100px"/></td>
                                            
											
										
										</TR>
										<tr>

											<td colspan="4" style="padding-left: 10px"></td>
										</tr>
										

										
										

									</table>
									
									
					
						
								
									
								</td>
								
								<!-- Side -->
								
								<td>
									<table width="80%"
										style="background-color: milkwhite;"
										cellspacing="2px" border="0" align="center">
										<colgroup>
											<col width="180px" />
											
											<col />
										</colgroup>
										  
										
										
										
										
										<tr>
										<td> <h1>Bill Details for Customer</h1></td>
										
										</tr>
										<tr>
										<td colspan="2">
										
										 <div id="billDetails">
        <!-- Display the parsed JSON data -->
        <p><strong>Customer Name:</strong> <span id="customerName"></span></p>
        <p><strong>Bill Amount:</strong> <span id="billAmount"></span></p>
        <p><strong>Due Date:</strong> <span id="dueDate"></span></p>
        <p><strong>Bill Period:</strong> <span id="billPeriod"></span></p>
        <p><strong>Approval Reference Number:</strong> <span id="approvalRefNum"></span></p>
 		   </div>
										
										
										
										</td>
										
										
										
										
										</tr>
										
										<tr>

											<td colspan="4" style="padding-left: 10px"></td>
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
    
  <!--   <a href="<%=request.getContextPath()%>/PieChart">pi</a>--<a href="<%=request.getContextPath()%>/BarChart">Bar</a>--<a href="<%=request.getContextPath()%>/LineChart">Line</a>-->
	</form:form>
</body>
</html>