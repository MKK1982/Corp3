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
<title>Transaction List</title>
<script type="text/javascript"
	src="jquery-ui-1.10.0/tests/jquery-1.9.0.js"></script>
<script src="jquery-ui-1.10.0/ui/jquery-ui.js"></script>
<script type="text/javascript" language="javascript">
   
  

        function getValue() {
           alert("Close");
           
           window.close();
        }
        </script>

</head>
<body>



	<table width="100%" style="height: 450px" cellpadding="0"
		cellspacing="0" align="center">
		<colgroup>
			<col width="210px" />
			<col width="2px" />
			<col />
		</colgroup>
		<tr>


			<td>&nbsp;</td>
			<td class="All_Round" style="vertical-align: top">


				<table class="tbl_Content">
					<colgroup>
						<col width="150px" />
						<col width="180px" />
						<col width="130px" />
						<col />
					</colgroup>
					<tr>
						<th style="padding-left: 10px">Ledger Posting</th>


					</tr>
					<tr>
						<td colspan="4">
							<hr
								style="border-style: dashed; color: #ddddcf; width: 98%; height: 1px" />
						</td>
					</tr>
				</table>

				<table border="1" class="mGrid">


					</tr>
					<tr>
						<th>Id</th>
						<th>AccountNo</th>
						<th>Type</th>
						<th>Amount</th>
						<th>Description</th>
						<th>GL/AC</th>
					</tr>
					<c:forEach var="jd" items="${list1}">
						<tr>
							<td><c:out value="${jd.s1}" /></td>
							<td><c:out value="${jd.s6}" /></td>

							<td><c:out value="${jd.s2}" /></td>
							<td><c:out value="${jd.s13}" /></td>
							<td><c:out value="${jd.s4}" /></td>
							<td><c:out value="${jd.s5}" /></td>





						</tr>
					</c:forEach>
				</table>



				<table class="tbl_Content">
					<colgroup>
						<col width="150px" />
						<col width="180px" />
						<col width="130px" />
						<col />
					</colgroup>
					<tr>
						<th style="padding-left: 10px">General Ledger Posting</th>


					</tr>
					<tr>
						<td colspan="4">
							<hr
								style="border-style: dashed; color: #ddddcf; width: 98%; height: 1px" />
						</td>
					</tr>
				</table>

				<table border="1" class="mGrid">


					</tr>
					<tr>
						<th>Id</th>
						<th>AccountNo</th>
						<th>Type</th>
						<th>Amount</th>
						<th>Description</th>
						<th>GL/AC</th>
					</tr>
					<c:forEach var="jd" items="${list2}">
						<tr>
							<td><c:out value="${jd.s1}" /></td>
							<td><c:out value="${jd.s6}" /></td>

							<td><c:out value="${jd.s2}" /></td>
							<td><c:out value="${jd.s13}" /></td>
							<td><c:out value="${jd.s4}" /></td>
							<td><c:out value="${jd.s5}" /></td>





						</tr>
					</c:forEach>
				</table> <a href="<%=request.getContextPath()%>/hai" onclick="getValue();">Close</a> <a
				href="<%=request.getContextPath()%>/deleteDailyTransactionsList//${jd.s1}/${jd.s2}"
				OnClick="return confirm('Are you sure want to delete?');">Delete</a>
			</td>








		</tr>
	</table>


</body>
</html>