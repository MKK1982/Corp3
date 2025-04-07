<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<title>Session Null</title>
</head>
<body>
	<form id="form1" runat="server">
		<table
			style="width: 1000px; height: 450px; text-align: center; vertical-align: middle;">
			<%--<tr>
            <td style="font-size: 32px; font-weight: bold;">
                <span style="color: #3B5ED1;">T </span><span style="color: #02890F;">N </span><span style="color: #FFB20D;">S </span><span style="color: #E42232;">C </span><span style="color: #3B5ED1;">
                    B </span><span style="color: #FFB20D;">- </span><span style="color: #3B5ED1;">M </span><span style="color: #02890F;">I </span><span style="color: #E42232;">S </span><span style="color: #3B5ED1;">
                </span>
            </td>
        </tr>--%>
			<tr>
				<td align="center">
					<table style="height: 100%;">
						<tr>
							<td style="padding: 0px 5px 0px 5px"><img
								src="${pageContext.servletContext.contextPath}/resources/images/sand-clock.png" border="0" width="120px"
								height="120px" alt="Logout?" /></td>
							<td valign="top">
								<table style="width: 100%; height: 100%">
									<tr>
										<td align="left"><span
											style="font-size: 26px; font-weight: bold; color: #E42232;">
												Null Values! </span> <span
											style="font-size: 24px; font-weight: bold; color: #000071;">Accessing field on null object. <br /> You must login again. <br /> <br />
										</span> <span
											style="font-size: 20px; font-weight: bold; color: #000071;">
												<a href="<%=request.getContextPath()%>/logout">Click here</a> to
												login.
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