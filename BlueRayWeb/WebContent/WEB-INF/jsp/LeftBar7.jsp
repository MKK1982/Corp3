<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<script type="text/javascript">


function madeAjaxCall_Mgr(){
	
	//alert('hi');
	
	//alert('start');
	$.ajax({
		type: "POST",
		url: "${pageContext.servletContext.contextPath}/getMgrStatus.htm",
		success: function(response){
		//alert(response);	
			 var temp=response;
			 if(response !="R")
				 {
				//alert('MM='+response);
					document.getElementById("cash_balance").style.display='block';
					document.getElementById("from15GH").style.display='block';
					

				 }
			
			 
					},
		error: function(e){						
			alert('Error while request..'+e);
		}
	});
	
}

window.onload = function() {
	//alert('1');
	madeAjaxCall_Mgr();
}
</script>

</head>
<body>
	<div class="blue demo-container">
		<ul class="accordion" id="accordion-3">
			<li><a href="<%=request.getContextPath()%>/TrialBalance">TrialBalance  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;</a></li>
			<li><a href="<%=request.getContextPath()%>/ProfitLoss">Profit and Loss  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;</a></li>
			<li><a href="<%=request.getContextPath()%>/Balance_Sheet">Balance Sheet  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;</a></li>
			<li><a href="<%=request.getContextPath()%>/TDS_Report">    TDS Report &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </a></li>
			<li id="cash_balance" style="display:none;"><a href="<%=request.getContextPath()%>/Cash_Balance_Report">Cash Balance Report</a></li>
			
			<%-- <li id="from15GH" style="display:none;"><a href="<%=request.getContextPath()%>/Form15gh_Report">Form 15 GH Report</a></li> --%>
			<li id="from15GH" style="display:none;"><a href="<%=request.getContextPath()%>/15GH_QTR_Report">Form 15 GH Report</a></li>
			<%-- <li><a href="<%=request.getContextPath()%>/15GH_QTR_Report">15GH QTR Report</a></li> --%>
				<li><a href="<%=request.getContextPath()%>/GST_Ledger">GST Report  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
																				<li><a href="<%=request.getContextPath()%>/NDH3_Report">NDH3 Report&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
																						<li><a href="<%=request.getContextPath()%>/GL_Report">GL Report &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
																				
<%-- 														<li><a href="<%=request.getContextPath()%>/GL_Transaction_Report">GL Transaction Report</a></li> --%>
												
																										<li ><a href="<%=request.getContextPath()%>/Value_Report">Net Value Report&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>						
												
<%-- 														<li ><a href="<%=request.getContextPath()%>/Expenses_Report">Expenses Report&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li> --%>
														
																				
		</ul>
		
	</div>
</body>
</html>