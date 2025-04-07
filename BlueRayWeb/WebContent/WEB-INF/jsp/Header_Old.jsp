<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js">
        </script>
</head>
<body>
<center>
             <table border="0" cellpadding="0" cellspacing="0" id="tblParent" width="95%" style="text-align: left;background-color: White;">
                    <tr>
                        <td valign="top">
                            <table id="tblTab" cellpadding="0" cellspacing="0" width="100%">
                                <%-- <tr>
                                    <td style="background-color:#01819C; font-size:30px;color:#FBF6FC; padding-left:10px;font-family:Baskerville Old Face;padding-bottom:2px;padding-top:5px;">
                                        ABFL - Administrative Office Module
                                    </td>
                                    <td align="right" style="background-color:#01819C; padding-left:10px;padding-bottom:2px;padding-top:5px;">
                                        <a href="Home">
                                            <img src="../Images/home.png" title="Home" border="0" alt="Home" width="32px" height="32px"/>
                                        </a>
                                        <a href="Change_Password">
                                            <img src="../Images/pwd.png" title="Change Password" alt="Change Pwd" border="0"  width="32px" height="32px"/>
                                        </a><a href="Logout">
                                            <img src="../Images/logout_1.png" title="Logout" alt="Logout" border="0" width="32px" height="32px"/>
                                        </a>
                                    </td>
                                </tr> 
                                <tr>
                                    <td width="700px" align="left" style="background-color: #01819C; padding-right: 5px" height="30px;">
                                        <asp:Label ID="Label3" runat="server" ForeColor="White" Font-Bold="True"></asp:Label>
                                    </td>
                                    <td align="right" style="background-color: #01819C; padding-right: 5px" height="30px;">
                                        <asp:Label ID="Label2" runat="server" Text="Welcome" Font-Bold="True" ForeColor="White"></asp:Label>
                                    </td>
                                </tr> --%>
                                
                                <tr>
									<td style="border-radius: 10px; background-image: -moz-linear-gradient(bottom,#014D1E 0%, #215E21 100%); background: -webkit-gradient(linear, left top, left bottom, from(#014D1E), to(#215E21));
										background: linear-gradient(bottom, #014D1E 0%, #215E21; background: -ms-linear-gradient(bottom, RGB(0,114,198) 0%, RGB(0,114,198) 100%);
										height: 80px">
										<div style="float: left; padding-left: 10px">
											<img src="${pageContext.servletContext.contextPath}/resources/Images/logo.png" width="73px" height="84px" alt="Logo" />
										</div>
										<div style="float: left; padding-top:10px">
											<span style="font-size: 12px; color: White; padding: 30px 0px 20px 0px; font-family: Georgia">
												<span style="font-size: 30px; font-family: sans-serif; color: #ffffff; padding-left: 30px;text-shadow: 1px 1px 2px black, 0 0 25px darkgreen, 0 0 3px darkgreen;">
													Shri Narayani Nidhi Ltd., </span> <br>
													<span style="padding-left: 30px;text-shadow: 1px 1px 2px black, 0 0 25px green, 0 0 3px green; ">
													(Declared as "Nidhi" by The Government of India)
													</span>
											</span>
										</div>
										<div style="width: 140px; float: right; color: #ffffff; font-size: 12px; padding-top:10px;text-shadow: 1px 1px 2px black, 0 0 25px darkgreen, 0 0 3px darkgreen;">
											<a href="<%=request.getContextPath()%>/Home">
                                            <img src="${pageContext.servletContext.contextPath}/resources/Images/home.png" title="Home" border="0" alt="Home" width="32px" height="32px"/>
											</a>
											<a href="<%=request.getContextPath()%>/Change_Password">
												<img src="${pageContext.servletContext.contextPath}/resources/Images/pwd.png" title="Change Password" alt="Change Pwd" border="0"  width="32px" height="32px"/>
											</a><a href="<%=request.getContextPath()%>/logout">
												<img src="${pageContext.servletContext.contextPath}/resources/Images/logout_1.png" title="Logout" alt="Logout" border="0" width="32px" height="32px"/>
											</a>
											<asp:Label ID="Label3" runat="server" ForeColor="White" Font-Bold="True"></asp:Label>
											<asp:Label ID="Label2" runat="server" Text="Welcome" Font-Bold="True" ForeColor="White"></asp:Label>
											${user}-${Current}
										</div>
										
									</td>
								</tr>
            
            
                                <tr>
                                    <td width="100%" align="left" height="30px;" colspan="2">
										<ul><li> Master 
											<ul>
												    <%--<li><a href="Branch_Master">Branch Master</a></li>--%>
													<li><a href="<%=request.getContextPath()%>/New_User">New User</a></li>
													<li><a href="<%=request.getContextPath()%>/Change_Password">Change Password</a></li>
													<li><a href="<%=request.getContextPath()%>/Permission_Settings">Permission Settings</a></li>
													<li><a href="<%=request.getContextPath()%>/Customer_List">Member List</a></li>
													<li><a href="<%=request.getContextPath()%>/FingerRegistration">FingerPrint Registration</a></li>
													
													<%--<li><a href="Schedule_Master">Schedule Master</a></li>
													<li><a href="Account_Master">Account Master</a></li>
													<li><a href="Opening_Balance">Opening Balance</a></li>--%>
											</ul>
											</li>
										  
										<!--   
										<li>
											Customer List
											<ul>
												<li><a href="<%=request.getContextPath()%>/Customer_List">Member List</a></li>
												<li><a href="<%=request.getContextPath()%>/Customer_KYC_Report">Member KYC Report</a></li>
												<%--<li><a href="Submission_History">Submission History</a></li>--%>
											</ul>
										  </li>
										  <li>
											View Transaction
											<ul>
												<li><a href="<%=request.getContextPath()%>/View_Transactions">View Transaction</a></li>
												<%--<li><a href="Submission_History">Submission History</a></li>--%>
											</ul>
										  </li>
										  -->
										  <li> 
												Certificates
												<ul>
													<li><a href="<%=request.getContextPath()%>/Share_Certificate">Share Certificate</a></li>
													<li><a href="<%=request.getContextPath()%>/FD_List">Fixed Deposit</a></li>
													
												</ul>
										  </li>
										  <!--  <li> 
												Loan Approval
												<ul>
													<li><a href="<%=request.getContextPath()%>/JL_List">Jewel Loan</a></li>
													<li><a href="<%=request.getContextPath()%>/DL_List">Deposit Loan</a></li>
												
												</ul>
										  </li>
										  
										   <li> 
												Approval List
												<ul>
													<li><a href="<%=request.getContextPath()%>/DayEndProcess">Cash Denomination</a></li>	
												<li><a href="<%=request.getContextPath()%>/PreClosureDocList">Preclosure Documents</a></li>	
												
												</ul>
										  </li>-->
										  
										   <li Style="display:none"> 
												Loan Appraisal s/w
												<ul>
												
												  
													<li><a href="<%=request.getContextPath()%>/CreditAppraisal">Loan Appraisal</a></li>
													
												</ul>
										  </li>
										     
										   <li> 
												TDS Report
												<ul>
												
												  
													<li><a href="<%=request.getContextPath()%>/TDS_Report">TDS Report</a></li>
													
												</ul>
										  </li>
										  
										  <li> 
										 Audit Report
												<ul>
												
												  
													<li><a href="<%=request.getContextPath()%>/ProfitLoss">Profit & Loss</a></li>
													<li><a href="<%=request.getContextPath()%>/Balance_Sheet">Balance Sheet</a></li>
													<li><a href="<%=request.getContextPath()%>/TrialBalance">TrialBalance</a></li>
													
													
												</ul>
										   </li>
										   
										   <li>
   												Permission Settings
											<ul>
												<li><a href="<%=request.getContextPath()%>/Permission_Sett">Permission Settings</a></li>
											</ul>	
  										  </li>
  										  <li>
  										  Employee
  										  <ul>
  										  <li>
  										  <a href="<%=request.getContextPath()%>/Employee_List">Employee List</a>
  										  </li>
  										  </ul>
  										  </li>
										  
										</ul>    
                                     </td>
                                </tr>
                                
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td valign="top" width="90%">
                           <!--  <table id="tblContent" border="0" cellpadding="0" cellspacing="0" style="width:100%">
                                <tr>
                                    <td valign="top">
                                        <table border="3" cellpadding="0" cellspacing="0" id="tblParent1" width="90%">
                                            <tr>
                                                <td valign="top" style="height:450px" width="90%">-->
                                                    
                          
</body>
</html>