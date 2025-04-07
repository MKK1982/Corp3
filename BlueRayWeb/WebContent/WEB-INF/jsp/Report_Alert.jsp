
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<script type="text/javascript">
function history()
{
    history.call(-2);
}
</script>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>No Access</title>
</head>
<body>
	<form id="form1" runat="server">
		<table
			style="width: 1000px; height: 450px; text-align: center; vertical-align: middle;">
			<tr>
				<td align="center">
					<table style="height: 100%;">
						<tr>
							<td style="padding: 0px 5px 0px 5px"><img
								src="${pageContext.servletContext.contextPath}/resources/Images/Stop.png" border="0" width="100px" height="100px"
								alt="Stop!" /></td>
							<td valign="top">
								<table style="width: 100%; height: 100%">
									<tr>
										<td align="left"><span style="font-size: 26px;font-color:green">
												Month End / Day End  in progress, <br /> Try after some time!
										</span> <br /> <br /> <span style="font-size: 16px;"> <a
												href="<%=request.getContextPath()%>/Home"">Click here</a> to go
												back to Home Page
										</span></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
