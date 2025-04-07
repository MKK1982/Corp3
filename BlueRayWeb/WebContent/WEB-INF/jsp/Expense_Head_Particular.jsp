<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="<c:url value="/resources/CSS/menu/style.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/CSS/menu/iconic.css"/>"
	rel="stylesheet" />
<link
	href="<c:url value="/resources/CSS/sidemenu/css/dcaccordion.css" />"
	rel="stylesheet" />
<link
	href="<c:url value="/resources/CSS/sidemenu/css/skins/blue.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/CSS/tbl_style.css"/>"
	rel="stylesheet" />
<link href="<c:url value="/resources/CSS/Controls.css"/>"
	rel="stylesheet" />
<link href="<c:url value="/resources/CSS/image.css" />" rel="stylesheet" />

<link href="<c:url value="/resources/CSS/jsDatePick_rtl.css" />"
	rel="stylesheet"></link>
<link href="<c:url value="/resources/CSS/jsDatePick_ltr.css" />"
	rel="stylesheet"></link>
<link href="<c:url value="/resources/CSS/jsDatePick_ltr.min.css" />"
	rel="stylesheet"></link>
<link href="<c:url value="/resources/CSS/jsDatePick_rtl.min.css" />"
	rel="stylesheet"></link>

<script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
<script src="<c:url value="/resources/js/main.js" />"></script>
<script src="<c:url value="/resources/CSS/menu/prefix-free.js" />"></script>
<script src="<c:url value="/resources/CSS/sidemenu/jquery.js" />"></script>
<script src="<c:url value="/resources/CSS/sidemenu/js/sidetab.js" />"></script>
<script
	src="<c:url value="/resources/CSS/sidemenu/js/jquery.dcjqaccordion.2.7.min.js" />"></script>
<script src="<c:url value="/resources/js/jsDatePick.min.1.3.js" />"></script>
<script src="<c:url value="/resources/js/jsDatePick.min.1.3.js" />"></script>

<script src="<c:url value="/resources/js/jquery.1.4.2.js" />"></script>
<script src="<c:url value="/resources/js/jsDatePick.full.1.3.js" />"></script>
<script
	src="<c:url value="/resources/js/jsDatePick.jquery.full.1.3.js" />"></script>
<script
	src="<c:url value="/resources/js/jsDatePick.jquery.min.1.3.js" />"></script>


<html>
<head>
<title>Expense Head</title>
<script type="text/javascript"
	src="jquery-ui-1.10.0/tests/jquery-1.9.0.js"></script>
<script src="jquery-ui-1.10.0/ui/jquery-ui.js"></script>
<script type="text/javascript" language="javascript">


function Get_Expense_Account()
{
	var schemeType=$("#ddl_Branch1").val();
	$("#id_GL_Name").empty();
	$.ajax({
		type: "POST",
		url: "${pageContext.servletContext.contextPath}/GetExpenseCode.htm",
		data:'Scheme_Type='+ schemeType,
		success: function(response){
			//$('#result').html(response);
			
			
			
			var temp=response.split(",");
			var select = document.getElementById('id_GL_Name');
			
			
		    
			for( var i = 0; i < temp.length; i++ ) {
				var opt = document.createElement('option');
				//alert("kkn2:"+temp[i]);
				opt.value = temp[i];
			    opt.innerHTML = temp[i];
			    select.appendChild(opt);
			}
			
			
			
		},
		error: function(e){						
			alert('Error while request in Get_Compounding..'+e);
		}
	});
}



$(document).ready(function(){
	
		
	if(document.getElementById('SaveFlag').value==2)
	{
	//alert(2);
	//document.getElementById('Verify1_Button').disabled=true;
	//document.getElementById('Verify1_Button').style.color='red';
	document.getElementById('Save_Button').style.display='none';
	}



});

        </script>

</head>
<body>
	<div id="page-wrap">
		<center>
		<table width="70%" align="left" >
			
			<tr>
				<td>

					<table align="left" width="100%" style="height: 350px" cellpadding="0" cellspacing="0">
						
						<tr>
							
							<td class="All_Round" style="vertical-align: top"><form:form
									method="post" action="${pageContext.servletContext.contextPath}/saveExpense_Head"
									modelAttribute="Expense_Head"
									commandName="Expense_Head">
									<table class="tbl_Content">
										
										<tr>
											<th colspan="5">Expense Head Individual<br />
												
											</th>
										</tr>
										
										<tr>
								<td>										

								<table align="left"  border="2" width="100%" cellpadding="2" class="mGrid">
								
									<tr>
									
										<th><font size="2px" >GL Code</font></th>
										<th align="left"><font align="left" size="2px" >GL Name</font></th>
										<th><font size="2px" >Amount</font></th>
										<th><font size="2px">Month </font></th>
										
										<th Style="${DeleteLinkDisplay}"><font size="2px" >Delete</font></th>
									</tr>
									<c:forEach var="jd" items="${SimpleList}">
										<tr>
										
										
											<td style="width:5%"><font size="2px" color="black"><c:out value="${jd.s32}" /></font></td>
											
											<td style="width:17%" align="left"><font size="2px" color="black"><c:out value="${jd.s33}" /></font></td>
											<td style="width:10%" align="left"><font size="2px" color="black"><c:out value="${jd.s36}" /></font></td>
											
											
											<td style="width:5%" align="left"><font size="2px" color="black"><c:out value="${jd.s37}" /></font></td>

											<td style="width:10%" align="center" Style="${DeleteLinkDisplay}"> <font size="2px" color="black">
											<a href="<%=request.getContextPath()%>/deleteExpense_Head_New/${jd.s31}/${jd.s32}/${jd.s34}/${jd.s35}">Delete</a></font></td>
										</tr>
									</c:forEach>
								</table> 
								
			&nbsp;&nbsp;
								<table>
								</form:form>
								
								<br /><!--  <a href="<%=request.getContextPath()%>/search1Branch_Master">SEARCH</a>--></td>
						</tr>

						</div>
</body>
</html>
