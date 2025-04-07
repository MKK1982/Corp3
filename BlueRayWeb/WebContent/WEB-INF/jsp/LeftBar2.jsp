<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><table><tr><td>
		<div class="blue demo-container" style="width: 200px;">
		
		<ul class="accordion" id="accordion-3">
					<li><a href="<%=request.getContextPath()%>/RD_Pending_Due">RD pending Dues</a></li>
		<li><a href="<%=request.getContextPath()%>/DL_Arrear">Deposit Loan Arrear</a></li>
			<li  style="align:center;"><a href="<%=request.getContextPath()%>/JL_Arrear">Jewel Loan Arrear</a></li>
			
			<li ><a href="<%=request.getContextPath()%>/ML_Arrear">Mortgage Loan Arrear</a></li>
			<li ><a href="<%=request.getContextPath()%>/SL_Arrear">Secure Loan Arrear</a></li>
						<li ><a href="<%=request.getContextPath()%>/RL_Arrear">Rapid Loan Arrear</a></li>
			<li ><a href="<%=request.getContextPath()%>/JL_Recovery">Recovery Report</a></li>
<%-- <li ><a href="<%=request.getContextPath()%>/Deposit_Consolidted">Deposit Consolidated Report</a></li>--%>

			</li>
			</ul>
	</div>
	</td>
	</tr>
	</table>
</body>
</html>