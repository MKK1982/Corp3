<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<div class="blue demo-container">
		<ul class="accordion" id="accordion-3">
			<li><a href="<%=request.getContextPath()%>/Employee_List">Employee List </a></li>
			<li><a href="<%=request.getContextPath()%>/Employee_Master">Employee Registration </a></li>
			
			
						<li><a href="<%=request.getContextPath()%>/Designation_Master">Designation Master </a></li>
												<li><a href="<%=request.getContextPath()%>/Category_Master">Category Master </a></li>
												<li><a href="<%=request.getContextPath()%>/Employee_Report">Employee Report </a></li>
					<%-- <li ><a href="<%=request.getContextPath()%>/Staff_Attendance_Time" > Attendance Time</a></li>
								<li><a href="<%=request.getContextPath()%>/Staff_Attendance_Unlock">LOCK / UNLOCK  </a></li>
								<li class="vertical menu"><a href="<%=request.getContextPath()%>/Staff_Attendance_View_All">Attendance Report  </a>
								
								</li> --%>
				
						
		</ul>
		
	</div>
</body>
</html>