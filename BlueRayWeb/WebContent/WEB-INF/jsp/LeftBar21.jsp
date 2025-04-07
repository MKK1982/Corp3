<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
				<div class="blue demo-container" style="width: 200px;" >

					<ul class="accordion"  style="background-color:#4EE2EC;">
					<li><a href="<%=request.getContextPath()%>/Branch_Budgeting">Branch Budgeting</a></li>
		<li ><a href="<%=request.getContextPath()%>/Share_Certificate">	Share Certificate </a></li>
		<li style="align:right;"><a href="<%=request.getContextPath()%>/FD_List">	Fixed Deposit Certificate </a></li>
										<li><a href="<%=request.getContextPath()%>/WelcomeLetter_List">Welcome Letter</a></li>
													<li><a href="<%=request.getContextPath()%>/Customer_Reports">Interest Certificate</a></li>
																						<li  ><a href="<%=request.getContextPath()%>/Cash_Denomination_Report">Cash Denomination Report</a></li>
<%-- 													<li  ><a href="<%=request.getContextPath()%>/Deposit_Period">Deposit Period Master</a></li>
 --%>													<%-- <li  ><a href="<%=request.getContextPath()%>/Customer_KYC_Report">Member KYC Report</a></li> --%>
																						<li ><a href="<%=request.getContextPath()%>/Expenses_Report">Expenses Report</a></li>																		
													
										
				
		</ul>
	</div>
</body>
</html>