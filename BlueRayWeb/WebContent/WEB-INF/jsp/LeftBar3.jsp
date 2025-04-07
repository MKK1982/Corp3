<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<div class="blue demo-container" style="width: 200px;">
		<ul class="accordion" id="accordion-3">
			<li style="align:right;"><a href="<%=request.getContextPath()%>/TrialBalance">	Audit Report </a></li>
<li style="align:right;"><a href="<%=request.getContextPath()%>/TDS_Report">	TDS  Report </a></li>

			<%-- <li><a href="Release_Login.jsp"> Release Login </a></li> --%>
		</ul>
	</div>
</body>
</html>