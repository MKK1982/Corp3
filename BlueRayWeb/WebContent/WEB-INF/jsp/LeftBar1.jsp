<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table width="95%"><tr>
	<td id="leftbar">
			<div class="blue demo-container" style="width: 200px;" >
			<ul class="accordion" id="accordion-3"  style="background-color:#4EE2EC;">
				<li><a href="<%=request.getContextPath()%>/Performance_Report">Performance Report</a></li>
				<li><a href="<%=request.getContextPath()%>/FD_Consolidated">FD Consolidated Report</a></li>
				<li><a href="<%=request.getContextPath()%>/RD_Consolidated">RD Consolidated Report</a></li>
				<li><a href="<%=request.getContextPath()%>/SDDS_Report">DDS Report &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;</a></li>
				<li><a href="<%=request.getContextPath()%>/LAD_Consolidated">LAD Consolidated Report</a></li>	
				
				<li><a href="<%=request.getContextPath()%>/JL_Consolidated">JL Consolidated Report</a></li>
				<li><a href="<%=request.getContextPath()%>/JL_StockConsolidated">JL Stock Report</a></li>
				<li><a href="<%=request.getContextPath()%>/JL_OS_Consolidated">JL Outstanding Report</a></li>
				
				<li><a href="<%=request.getContextPath()%>/Target_Report">Target Report</a></li>
					<li ><a href="<%=request.getContextPath()%>/Tareget_Consolidated_Report">Target Consolidated Report&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;</a></li>					
					<li><a href="<%=request.getContextPath()%>/Incentive_Report">Incentive  Report</a></li>
																																				
								<li ><a href="<%=request.getContextPath()%>/Deposit_Consolidted">Maturity Report</a></li>
			<li ><a href="<%=request.getContextPath()%>/Share_Consolidted">Share Consolidated Report</a></li>						
						<li ><a href="<%=request.getContextPath()%>/FD_EOM_Report">FD EOM Report</a></li>		
	
												
			</ul>
		</div>
	</td>
	</tr>
	</table>
</body>
</html>