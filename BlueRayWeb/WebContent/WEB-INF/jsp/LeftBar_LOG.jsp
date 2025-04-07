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
		<li style="font-color:black;"><a href="<%=request.getContextPath()%>/Customer_Log">Member Approval Log</a></li>	
				
							<li style="font-color:black;"><a href="<%=request.getContextPath()%>/Transaction_Log">Transaction Log</a></li>
			<li style="font-color:black;"><a href="<%=request.getContextPath()%>/JL_Approval_Log">JL Approval Log</a></li>
		<li style="font-color:black;"><a href="<%=request.getContextPath()%>/DL_Approval_Log">DL Approval Log</a></li>
								<li style="font-color:black;"><a href="<%=request.getContextPath()%>/Report_Log">Report Logs</a></li>	
						<li style="font-color:black;"><a href="<%=request.getContextPath()%>/Narration_Log">Narration Log &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
				
				
									<li style="font-color:black;"><a href="<%=request.getContextPath()%>/Scheduler_Log">Scheduler Log &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>	
		    <a href="<%=request.getContextPath()%>/Jewel_Desc"> Jewel Description</a>
		    <a href="<%=request.getContextPath()%>/App_Member_List/"> Dhanam App Report</a>
		<li style="display:none;"><a href="<%=request.getContextPath()%>/GL_Log">GL Log &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
		</ul>
		
	</div>
</body>
</html>