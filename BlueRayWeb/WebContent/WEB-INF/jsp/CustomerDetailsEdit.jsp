
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Verify Member</title>
<script type="text/javascript">
function valid()
{
var user=document.login.txt_Usernsme.value;
var user=user.trim();
var pass=document.login.txt_Password.value;
if(user == '')
{
document.getElementById('error').innerHTML="Please Enter Username";
return false;
}
if(pass == '')
{
document.getElementById('error').innerHTML="Please Enter Password";	
return false;
}
}



</script>
  <script>
    function Proof1(Customer_Id,BCode)
    
    {
    	
    	var path="${pageContext.servletContext.contextPath}";
    	var snnl4 = "${pageContext.request.contextPath}";
    	//alert(snnl4);
    	var url=path+"/ViewProof1/" + Customer_Id+"/"+BCode;
    	//alert(url);
        window.open(url, "List", "left = 500,top=150,directories=no,titlebar=no,toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=600,height=450,scrollbars=no");
        //  "/snnl4/FD_Interest_List/" + Accno
    }
    
function Proof2(Customer_Id,BCode)
    
    {
    	
    	var path="${pageContext.servletContext.contextPath}";
    	var snnl4 = "${pageContext.request.contextPath}";
    	//alert(snnl4);
    	var url=path+"/ViewProof2/" + Customer_Id+"/"+BCode;
    	//alert(url);
        window.open(url, "List", "left = 500,top=150,directories=no,titlebar=no,toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=600,height=450,scrollbars=no");
        //  "/snnl4/FD_Interest_List/" + Accno
    }
    
function Panno(Customer_Id,BCode)

{
	
	var path="${pageContext.servletContext.contextPath}";
	var snnl4 = "${pageContext.request.contextPath}";
	//alert(snnl4);
	var url=path+"/Panno/" + Customer_Id+"/"+BCode;
	//alert(url);
    window.open(url, "List", "left = 500,top=150,directories=no,titlebar=no,toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=600,height=450,scrollbars=no");
    //  "/snnl4/FD_Interest_List/" + Accno
}
    </script>


<script type="text/javascript" language="javascript">
   
  
$(document).ready(function(){
	

	
	

});
</script>

<html xmlns="http://www.w3.org/1999/xhtml" >

<style>
	ul {
  text-align: left;
  display: inline;
  margin: 0;
  padding: 10px 4px 17px 0;
  list-style: none;
  -webkit-box-shadow: 0 0 5px rgba(0, 0, 0, 0.15);
  -moz-box-shadow: 0 0 5px rgba(0, 0, 0, 0.15);
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.15);
}
ul li {
  font: bold 12px/18px sans-serif;
  display: inline-block;
  margin-right: -4px;
  position: relative;
  padding: 15px 20px;
  background: #fff;
  cursor: pointer;
  -webkit-transition: all 0.2s;
  -moz-transition: all 0.2s;
  -ms-transition: all 0.2s;
  -o-transition: all 0.2s;
  transition: all 0.2s;
}

ul a
{
 font: bold 12px/18px sans-serif;
 text-decoration:none;
 color:#fff;
}

ul li:hover {
  background: #555;
  color: #fff;
}
ul li ul {
  padding: 0;
  position: absolute;
  top: 48px;
  left: 0;
  width: 150px;
  -webkit-box-shadow: none;
  -moz-box-shadow: none;
  box-shadow: none;
  display: none;
  opacity: 0;
  visibility: hidden;
  -webkit-transiton: opacity 0.2s;
  -moz-transition: opacity 0.2s;
  -ms-transition: opacity 0.2s;
  -o-transition: opacity 0.2s;
  -transition: opacity 0.2s;
}
ul li ul li { 
  background: #555; 
  display: block; 
  color: #fff;
  text-shadow: 0 -1px 0 #000;
}
ul li ul li:hover { background: #666; }
ul li:hover ul {
  display: block;
  opacity: 1;
  visibility: visible;
}
</style>
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
<script src="<c:url value="/resources/js/jsDatePick.min.1.3.js" />"></script>


 
 	<%-- <link href="<c:url value="/resourses/CSS/Style.css" />"	rel="stylesheet" type="text/css"/>
 	<link href="<c:url value="/resourses/CSS/image.css" />"	rel="stylesheet" type="text/css"/>
 	<link href="<c:url value="/resourses/CSS/Controls.css" />"	rel="stylesheet" type="text/css"/>
 	<link href="<c:url value="/resourses/CSS/tbl_style.css" />"	rel="stylesheet" type="text/css"/>
	<link href="<c:url value="/resourses/css/styles.css" />"	rel="stylesheet" type="text/css"/>
 	<link href="<c:url value="/resourses/css/juizDropDownMenu.css" />"	rel="stylesheet" type="text/css"/>
	 --%>
	 
    <script type="text/javascript">
         function Number_Only(e) {
             if ([e.keyCode || e.which] == 8) //this is to allow backspace
                 return true;
             if ([e.keyCode || e.which] == 9) //this is to allow tab
                 return true;
             if ([e.keyCode] == 46) //this is to allow Delete
                 return true;
             if ([e.keyCode || e.which] == 37) //left arrow .
                 return true;
             if ([e.keyCode || e.which] == 39) //right arrow .
                 return true;
             if ([e.keyCode || e.which] == 16) //shift .
                 return true;

             
         }
         
            function Copy_Address() {
			
			//document.getElementById('txt_Permanent_Address').value = document.getElementById('txt_Address').value;
			document.getElementById('txt_Permanent_Door_No').value = document.getElementById('txt_Door_No').value;
			document.getElementById('txt_Permanent_Premises').value = document.getElementById('txt_Premises').value;
			document.getElementById('txt_Permanent_Street_Name').value = document.getElementById('txt_Street_Name').value;
			document.getElementById('txt_Permanent_Area').value = document.getElementById('txt_Area').value;
			document.getElementById('txt_Permanent_City').value = document.getElementById('txt_City').value;
			document.getElementById('txt_Permanent_State').value = document.getElementById('txt_State').value;
			document.getElementById('txt_Permanent_Pincode').value = document.getElementById('txt_Pincode').value;
			
			
         }
            
 window.onload = function() {
            	
            	document.getElementById('Others').style.display = 'none';

                var val=document.getElementById('txt_Nationality').value;

			if (val==1) 
			{
				
				document.getElementById('Others').style.display = 'none';
			}
			else 
			{
				
				document.getElementById('Others').style.display = 'table-cell';
			}	
			

			if(document.getElementById('Verify1Flag').value==2)
			{
			//document.getElementById('Verify1_Button').disabled=true;
			//document.getElementById('Verify1_Button').style.color='red';
			document.getElementById('Verify1_Button').style.display='none';
			}
            }
         
    </script>

</head>

<body >
	<%@include file="/WEB-INF/jsp/Header.jsp"%>       



  <!-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------ -->                                                 
                                                    
                  
                  
                  
                        <table width="100%" style="height: 450px" cellpadding="0"
						cellspacing="0">
						<colgroup>
							<col width="210px" />
							<col width="2px" />
							<col />
						</colgroup>
						<tr>
							

							<td class="All_Round" style="vertical-align: top"><form:form
									method="post"
									action="${pageContext.servletContext.contextPath}/editsaveCustomer_Master">



									<table class="tbl_Content">
										<colgroup>
											<col width="140px" />
											<col width="350px" />
											<col />
										</colgroup>
										<tr>
											<th colspan="2">Member Master</th><th><form:input path="Branch_Code" value="${BCode}" readonly="true"/></th>

										</tr>
										<tr>
											<td colspan="3">
												<hr
													style="border-style: dashed; color: #ddddcf; width: 98%; height: 1px" />
											</td>
										</tr>
										<tr>
										
											<td>Member Id *</td>
											<td><form:input path="Customer_Id" value="${Customer_Id}"/></td>
											<td  rowspan="4" align="top"><img src="<%=request.getContextPath()%>/Cust_imageController/${Customer_Id}/${BCode}" width='200' height='250' alt="Customer_Photo"/></td>
											<td></td><td></td><td></td><td></td>
										</tr>	
										<tr>
											<td>Member Name *</td>
											<td><form:input path="Customer_Name"  title="Enter Characters b/w 1-30"/></td>
																						
											</tr>
											<tr>
											<td colspan="2" align="right"><img src="<%=request.getContextPath()%>/Sign_imageController/${Customer_Id}/${BCode}" width='200' height='80' alt="Signature_Photo"/></td>
											<td></td>
										</tr>
										<th>Address</th>
										<tr>
											<td>
												<div>
													<table>
														<tr>
															<td align="left"><b> Communication Address</b></td>
														</tr>
														 <td>
                        <form:textarea path="Address" id="txt_Address"/>
                    </td>
														</tr>

														<tr>
															<td>Flat/Door/Block No: *</td>
															<td><form:input path="Door_No" id="txt_Door_No" /></td>
														</tr>


														<tr>
															<td>Road/Street/Lane *</td>
															<td><form:input path="Street_Name"
																	id="txt_Street_Name"  /></td>
														</tr>
														<tr>
															<td>Name Of The Premises: </td>
															<td><form:input path="Premises" id="txt_Premises" />
															</td>
														</tr>
														<tr>
															<td>Area / Locality</td>
															<td><form:input path="Area" id="txt_Area" /></td>
														</tr>
														<tr>
															<td>City /Town/ Dist *</td>
															<td><form:input path="City" id="txt_City" /></td>
														</tr>

														<tr>
															<td>State *</td>
															<td><form:input path="State" id="txt_State" /></td>
														</tr>

														<tr>
															<td>Pincode*</td>
															<td><form:input path="Pincode" id="txt_Pincode"  pattern="[0-9]{6}" title="Enter Six digit Number"/></td>
														</tr>


													</table>
												</div>
											</td>



											<td>
												<div>
													<table>

														<tr>
															<td align="right"><b> Permanent Address <span
																	style="font-size: 10px"> (Share) </span> *
															</b></td>

															<td colspan="2">
                        <form:textarea path="Permanent_Address" id="txt_Permanent_Address"/>
                        
                    </td>
															<td><input type="CheckBox" id="chk_Copy_Address"
																onchange="Copy_Address();" /> Copy Address</td>
														<tr></tr>
														
														
														
														<tr>
															<td>Flat/Door/Block No: *</td>
															<td><form:input path="Permanent_Door_No"
																	id="txt_Permanent_Door_No" /></td>
														</tr>


														<tr>
															<td>Road/Street/Lane *</td>
															<td><form:input path="Permanent_Street_Name"
																	id="txt_Permanent_Street_Name" /></td>
														</tr>
														<tr>
															<td>Name Of The Premises: </td>
															<td><form:input path="Permanent_Premises"
																	id="txt_Permanent_Premises" /></td>
														</tr>
														<tr>
															<td>Area / Locality</td>
															<td><form:input path="Permanent_Area"
																	id="txt_Permanent_Area" /></td>
														</tr>
														<tr>
															<td>City /Town/ Dist *</td>
															<td><form:input path="Permanent_City"
																	id="txt_Permanent_City" /></td>
														</tr>

														<tr>
															<td>State *</td>
															<td><form:input path="Permanent_State"
																	id="txt_Permanent_State"  /></td>
														</tr>

														<tr>
															<td>Pincode</td>
															<td><form:input path="Permanent_Pincode"
																	id="txt_Permanent_Pincode"  pattern="[0-9]{6}" title="Enter Six digit Number"/></td>
														</tr>
													</table>
												</div>
											</td>
										<tr>
											<td>Photo</td>
											<td align="right">Signature</td>
										</tr>
										<tr>
											<td><img src="Customer.jpg"><a
												href="<%=request.getContextPath()%>/UploadCustomerPhoto">Upload Photo</a></td>
											<td align="right"><img src="Signature.jpg"><a
												href="<%=request.getContextPath()%>/UploadCustomerSignaturePhoto">Upload Signature</a></td>
										</tr>
									</table>
									<hr
										style="border-style: dashed; color: #d0d0cf; width: 95%; height: 1px" />
									<table class="tbl_Content">
										<colgroup>
											<col width="140px" />
											<col width="200px" />
											<col width="130px" />
											<col />
										</colgroup>
										<tr>
											<td>Father/Spouse</td>
											<td><form:input path="Father_Name" /></td>
											<td>Marital Status</td>
											<td><form:select path="Marital_Status">
													<form:option value="M">M-Married</form:option>
													<form:option value="S">S-Single</form:option>
													<form:option value="U">U-Unknown</form:option>
												</form:select></td>
										</tr>
										<tr>
											<td>Gender</td>
											<td><form:select path="Gender">
													<form:option value="M">M-Male</form:option>
													<form:option value="F">F-Female</form:option>
													<form:option value="U">U-Unknown</form:option>
												</form:select></td>
											<td>Date of Birth *</td>
											<td><form:input path="Date_of_Birth" /></td>
										</tr>
										<tr>
											<td>Customer Type</td>
											<td><form:select path="Customer_Type">
													<form:option value="Individual">Individual</form:option>
													<form:option value="Staff">Staff</form:option>
													<form:option value="Business">Business</form:option>
													<form:option value="Others">Others</form:option>
												</form:select></td>
											<td>Occupation</td>
											



											
											<td><form:input path="Occupation" /></td>
											 <td><img src="E:/${fileName}"/>${pageContext.request.contextPath}${fileName}</td>
										<img src="${pageContext.request.contextPath}/resources/images2/cal.gif"/> 
											
										</tr>
										<tr>
											<td>Telephone</td>
											<td><form:input path="Std" size="4" />--</td>
											<td width="100px"><form:input path="Phone_No" /></td>
											<td>Mobile *</td>
											<td><form:input path="Mobile_No"  pattern="[0-9]{10}" title="Enter 10 Digit Number Only"/></td>
										</tr>
										<tr>
											<td>Email</td>
											<td><form:input path="Mail" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Enter the mail address[xxx@xx.xx]"/></td>
											<td>Anniversary Date</td>
											<td><form:input path="Anniversary_Date" /></td>
										</tr>

									</table>
									<hr
										style="border-style: dashed; color: #d0d0cf; width: 95%; height: 1px" />
									<table class="tbl_Content">
										<colgroup>
											<col width="140px" />
											<col width="200px" />
											<col width="130px" />
											<col />
										</colgroup>
										<tr>
											<td>1. Id Proof Type</td>
											<td><form:input path="Id_Type" /></td>
											<td>Id Proof No. *</td>
											<td><form:input path="Id_No" />
										<!-- <a  onclick=Proof1(${Customer_Id});>View</a></font>/--><a style="${idProof_1downloadDisplay}" href="<%=request.getContextPath()%>/downloadIdProof1/${Customer_Id}/${BCode}" ><font color="green"><b>${fileName1}</b></font></a>
											
											</td>
										</tr>
										<tr>
											<td>2. Id Proof Type</td>
											<td><form:input path="Id_Type_2" /></td>
											<td>Id Proof No.</td>
											<td><form:input path="Id_No_2" />
										<!-- <font size="3" color="Blue">	<a  onclick="Proof2(${Customer_Id});">View</a></font>/--><a style="${idProof_2downloadDisplay}" href="<%=request.getContextPath()%>/downloadIdProof2/${Customer_Id}/${BCode}" ><font color="green"><b>${fileName2}</b></font></a>
											</td>
										</tr>
										<tr>
											<td>PAN No.</td>
											<td><form:input path="PAN_No"  pattern="[A-Za-z0-9]{10}" title="Must Enter 10 Characters "/>
											<!--<font size="3" color="Blue"> <a  onclick="Panno(${Customer_Id});">View</a></font>/--><a style="${PandownloadDisplay}" href="<%=request.getContextPath()%>/downloadPan/${Customer_Id}/${BCode}" ><font color="green"><b>${fileName3}</b></font></a>
											</td>
										</tr>
										<tr>
										
												<td>Nationality</td>
													<td width="10%"><form:select path="Nationality" id="txt_Nationality"  onchange="Other_Nation();">
													<form:option value="1">India</form:option>
													<form:option value="2">Others</form:option>
													</form:select></td>	<td id="Others" width="25%"><form:input path="Nationality_Others" /></td>
													
										</tr>
										<tr style="display: none">
											<td>Issue Date</td>
											<td><form:input path="Issue_Date" /></td>
											<td>Issue Place</td>
											<td><form:input path="Issue_Place" /></td>
										</tr>
										<tr>
											<td>Introducer Id</td>
											<td><form:input path="Introducer_Id" /></td>
											<td>Introducer Name</td>
											<td><form:input path="Introducer_Name" /></td>
										</tr>
										<tr>
											<td>Nominee Name *</td>
											<td><form:input path="Nominee_Name"  title="Enter Characters b/w 1-30"/></td>
											<td>Relationship *</td>
											<td><form:select path="Nominee_Relationship" >
													<form:option value="Father">Father</form:option>
													<form:option value="Mother">Mother</form:option>
													<form:option value="Son">Son</form:option>
													<form:option value="Daughter">Daughter</form:option>
													<form:option value="Wife">Wife</form:option>
													<form:option value="Husband">Husband</form:option>
													<form:option value="Brother">Brother</form:option>
													<form:option value="Sister">Sister</form:option>
												</form:select></td>
										</tr>
										<tr>
											<td>Nominee Age *</td>
											<td><form:input path="Nominee_Age"  pattern="[0-9]{1-3}"/></td>
											<td>Nominee DOB *</td>
											<td><form:input path="Nominee_DOB"  id="inputField3"/>
											<img src="<%=request.getContextPath()%>/resources/images2/cal.gif" onclick="javascript:NewCssCal('inputField3','ddMMyyyy')"  style="cursor:pointer"/>
											</td>
										</tr>
										<tr>
											<td>Remarks</td>
											<td><form:input path="Remarks" /></td>
											<td>Status</td>
											<td><form:select path="Customer_Status">
													<form:option value="Individual">A-Active</form:option>
													<form:option value="Staff">B-Blocked</form:option>

												</form:select></td>
										</tr>
										<tr>
											<td>SMS Feature</td>
											<td>SMS_Feature <form:select path="SMS_Feature">
													<form:option value="Y">Enabled</form:option>
													<form:option value="N">Disabled</form:option>
												</form:select>
											</td>
										</tr>

	<form:hidden path="Verify1Flag" value="${Verify1Flag}" id="Verify1Flag" />
						
									</table>
									<div class="Btn_Row">
										<input type="Submit" name="EditSave" value="Verify" id="Verify1_Button"
											class="btn_Blue">  <input type="Submit" value="Close" class="btn_Blue" name="Close" formnovalidate>
									</div>

								</form:form> <font color="Blue">${message}</font></td>
						</tr>
					</table>                 
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
  <!-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->       


 <!-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->                                                  
   <%@include file="/WEB-INF/jsp/Footer.jsp"%>







