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

  <script src="<c:url value="/resources/js/jquery-1.8.2.js" />"></script>
<script src="<c:url value="/resources/js/mfs100-9.0.2.6.js" />"></script>

<html>
<head>
<script>

$(document).ready(function(){
	
	madeAjaxCallAccess();
	
});

function madeAjaxCallAccess(){
	
		$.ajax({
		type: "POST",
		url: "${pageContext.servletContext.contextPath}/getAccessType.htm",
		success: function(response){
				 var temp=response
				// alert(temp[0]);
				// alert(temp[1]);
				// alert(temp[2]);
				// alert(temp[3]);
				// alert(temp[4]);
				// alert(temp[5]);
				var Mode_Value=temp;
				//alert(Mode_Value);
				if (Mode_Value=="N-N")
					{
					document.getElementById('FingerData').style.display = 'none';
					document.getElementById('ButtonData').style.display = 'none';

					//document.getElementById('txt_Mode_of_Receipt2').value = "0";
					}
				else if(Mode_Value=="N-Y")
					{
					document.getElementById('ButtonData').style.display = 'none';
					}
				else if(Mode_Value=="Y-N")
				{
				document.getElementById('FingerData').style.display = 'none';
				}
	
			
		},
		error: function(e){						
			alert('Error while request..'+e);
		}
	});
}


window.location.hash="no-back-button";
window.location.hash="Again-No-back-button";//again because google chrome don't insert first hash into history
window.onhashchange=function(){window.location.hash="no-back-button";}


function HandlePopupResult(result) 
{
    alert("result of popup is: " + result);
}
</script>


<script type="text/javascript"
	src="jquery-ui-1.10.0/tests/jquery-1.9.0.js"></script>
<script src="jquery-ui-1.10.0/ui/jquery-ui.js"></script>
<script type="text/javascript" language="javascript">

function Redirect() {
	 window.location = "${pageContext.servletContext.contextPath}/View_Transactions/"+document.getElementById('page').value;
	// window.location = "https://www.tutorialspoint.com";
 }
function OpenPopup2(Accno,Bcode)
{
	
	var path="${pageContext.servletContext.contextPath}";
	var snnl4 = "${pageContext.request.contextPath}";
	//alert(snnl4);
	///Account_Details/{Account_No_Key}
	var url=path+"/Account_Details/" + Accno+"/"+${Bcode}+"";
	//alert(url);
    window.open(url, "List", "left = 500,top=150,directories=no,titlebar=no,toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=600,height=600");
    //  "/snnl4/FD_Interest_List/" + Accno
    window.resizeTo(500, 600);
}

function OpenPopup3(tdate,level)
{
	var UserName=$("#UserName").val();
	var tid=$("#trid").val();
	var tdt=$("#trdt").val();
	var bcd=$("#bcd").val();
	
	var path="${pageContext.servletContext.contextPath}";
	var snnl4 = "${pageContext.request.contextPath}";
	//var urlMsg="12810007/12-05-2021/201";
	var urlMsg=tid+"/"+tdate+"/"+bcd+"/"+level;
	//alert(urlMsg);
	///Account_Details/{Account_No_Key}
//	var url=path+"/Pending_Details/";
	var url2="http://localhost:8082/sample10/Select_Marker.jsp?from="+UserName+"&urlMsg="+urlMsg;
	// var url2="http://192.168.1.55:8082/sample10/Select_Marker.jsp?from="+UserName+"&urlMsg="+urlMsg;
	// var url2="https://uatcredit.snnl.net/sample11/Select_Marker.jsp?from="+UserName+"&urlMsg="+urlMsg;


	//alert(url);
    window.open(url2, "List", "left = 500,top=150,directories=no,titlebar=no,toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=500,height=200");
    //  "/snnl4/FD_Interest_List/" + Accno
    //window.resizeTo(200, 200);
}




  
$(document).ready(function(){
	

	
	if(document.getElementById('Verify1Flag').value==2)
	{
	//document.getElementById('Verify1_Button').disabled=true;
	//document.getElementById('Verify1_Button').style.color='red';
	document.getElementById('Verify1_Button').style.display='none';
	
	}
	if(document.getElementById('Verify2Flag').value==2)
	{
	//document.getElementById('Verify2_Button').disabled=true;
	//document.getElementById('Verify2_Button').style.color='red';
	document.getElementById('Verify2_Button').style.display='none';
	//FingerLink2
	document.getElementById('FingerLink2').style.display='none';

	}

	if(document.getElementById('Verify3Flag').value==2)
	{
	//document.getElementById('Verify3_Button').disabled=true;
	//document.getElementById('Verify3_Button').style.color='red';
	document.getElementById('Verify3_Button').style.display='none';
	
	//FingerLink3
	document.getElementById('FingerLink3').style.display='none';

	}
	if(document.getElementById('Verify4Flag').value==2)
	{
	//document.getElementById('Verify4_Button').disabled=true;
	//document.getElementById('Verify4_Button').style.color='red';
	document.getElementById('Verify4_Button').style.display='none';
	
	//FingerLink4
	document.getElementById('FingerLink4').style.display='none';

	}
	
	if(document.getElementById('Verify5Flag').value==2)
	{
	//document.getElementById('Verify5_Button').disabled=true;
	//document.getElementById('Verify5_Button').style.color='red';
	document.getElementById('Verify5_Button').style.display='none';
	
	//FingerLink5
	document.getElementById('FingerLink5').style.display='none';

	}
	
	
	
	if(document.getElementById('DeleteFlag').value==2)
	{
	//document.getElementById('Delete_Button').disabled=true;
	//document.getElementById('Delete_Button').style.color='red';
	document.getElementById('Delete_Button').style.display='none';
	}


	
	if(document.getElementById('Verify1Flag').value==2)
	{
	//document.getElementById('Verify1_Button').disabled=true;
	//document.getElementById('Verify1_Button').style.color='red';
	document.getElementById('FVerify1_Button').style.display='none';
	}
	if(document.getElementById('Verify2Flag').value==2)
	{
	//document.getElementById('Verify2_Button').disabled=true;
	//document.getElementById('Verify2_Button').style.color='red';
	document.getElementById('FVerify2_Button').style.display='none';
	}

	if(document.getElementById('Verify3Flag').value==2)
	{
	//document.getElementById('Verify3_Button').disabled=true;
	//document.getElementById('Verify3_Button').style.color='red';
	document.getElementById('FVerify3_Button').style.display='none';
	}
	if(document.getElementById('Verify4Flag').value==2)
	{
	//document.getElementById('Verify4_Button').disabled=true;
	//document.getElementById('Verify4_Button').style.color='red';
	document.getElementById('FVerify4_Button').style.display='none';
	}
	
	if(document.getElementById('Verify5Flag').value==2)
	{
	//document.getElementById('Verify5_Button').disabled=true;
	//document.getElementById('Verify5_Button').style.color='red';
	document.getElementById('FVerify5_Button').style.display='none';
	}
	
	

});





        function getValue() {
           //alert("Close");
           
           window.close();
        }
        </script>
        
        
         <script language="javascript" type="text/javascript">
        function madeAjaxCallMode(verifyLevel){
        	  var quality = 60; //(1 to 100) (recommanded minimum 55)
              var timeout = 10; // seconds (minimum=10(recommanded), maximum=60, unlimited=0 )
	
        	var isotemplate;
        	alert('Plce ur finger');
     	   var res = CaptureFinger(quality, timeout);
     	  // alert(res.data.ErrorCode);
     	  // alert('Captured');
            if (res.httpStaus) {

               // document.getElementById('txtStatus').value = "ErrorCode: " + res.data.ErrorCode + " ErrorDescription: " + res.data.ErrorDescription;

                if (res.data.ErrorCode == "0") {
                   // document.getElementById('imgFinger').src = "data:image/bmp;base64," + res.data.BitmapData;
                  //  var imageinfo = "Quality: " + res.data.Quality + " Nfiq: " + res.data.Nfiq + " W(in): " + res.data.InWidth + " H(in): " + res.data.InHeight + " area(in): " + res.data.InArea + " Resolution: " + res.data.Resolution + " GrayScale: " + res.data.GrayScale + " Bpp: " + res.data.Bpp + " WSQCompressRatio: " + res.data.WSQCompressRatio + " WSQInfo: " + res.data.WSQInfo;
                    isotemplate = res.data.AnsiTemplate;
                   // alert(isotemplate);
                }
            }
            else {
                alert(res.err);
            }
     	
            var userName=document.getElementById('UserName').value;
     
			$.ajax({
			    type : "GET",
			    url : "${pageContext.request.contextPath}/checkIndividual",
			    data : 'UserName='+userName,
			    success: function(data)
			    {
			    //response from controller
			    	var temp=data.split(",");
			  //  alert(temp);
			//  alert("temp.length="+temp.length);
			  

				 
			    var flag=1;
			    var count=0;
			    var cusInfo="";
			    for (var i=0; i < temp.length-1; i++)
				    {
			    	count=count+1;
					 var arrSplit = temp[i].split("-");
				    	 res = VerifyFinger(isotemplate, arrSplit[1]);
				    		 if (res.httpStaus)
				    		 {
 			                    if (res.data.Status)
 			                    {
 			                        flag=2;
 			                        cusInfo=arrSplit[0];
 			                        
 			                    }
 			                 
 			                  
 			                }
 			                else {
 			                    alert(res.err);
 			                }
		 		    }
			

			    
			    if(flag==2)
			    	{
			    	//alert(count+":Finger Checked-"+cusInfo);
			    	if(verifyLevel=="1")
			    		{
			    		madeAjaxCall_Verify1();
			    		}
			    	else if(verifyLevel=="2")
			    		{
			    		madeAjaxCall_Verify2();
			    		}
			    	else if(verifyLevel=="3")
		    		{
		    		madeAjaxCall_Verify();
		    		}
			    	else if(verifyLevel=="4")
		    		{
		    		madeAjaxCall_Verify4();
		    		}
			    	else
			    		{
			    		if(verifyLevel=="5")
			    		madeAjaxCall_Verify5();
			    		}
			    	
			    	}
			    else
			    	alert(count+":Finger not Matched :You are not authorized");
			    }
			});
 		
 		
 	}
        
        function madeAjaxCall_Verify1(){
        	
        	var UserName=$("#UserName").val();
        	var Transaction_Id=$("#Transaction_Id").val();
        	var Transaction_Date=$("#Transaction_Date").val();
        	var Bcode=$("#Bcode").val();
        	//alert(Scheme_Type);


        	$.ajax({
        		type: "POST",
        		url: "${pageContext.servletContext.contextPath}/Verify1.htm",
        		data: 'UserName='+UserName+ "&Transaction_Id=" + Transaction_Id+ "&Transaction_Date=" + Transaction_Date+ "&Bcode=" + Bcode,
        		success: function(response){
        			$('#txt_Acc_From').html(response);
        			

        			 var temp=response;
        			 if(response=="1")
        				 {
        				 alert('Verified');
        				Redirect();
        				
        				 }
        			 else
        				 alert('Not Verified');
        				// alert(temp[0]);
        				
        		},
        		error: function(e){						
        			alert('Error while request..'+e);
        		}
        	});
        }
        
  function madeAjaxCall_Verify2(){
        	
        	var UserName=$("#UserName").val();
        	var Transaction_Id=$("#Transaction_Id").val();
        	var Transaction_Date=$("#Transaction_Date").val();
        	var Bcode=$("#Bcode").val();
        	//alert(Scheme_Type);


        	$.ajax({
        		type: "POST",
        		url: "${pageContext.servletContext.contextPath}/Verify2.htm",
        		data: 'UserName='+UserName+ "&Transaction_Id=" + Transaction_Id+ "&Transaction_Date=" + Transaction_Date+ "&Bcode=" + Bcode,
        		success: function(response){
        			$('#txt_Acc_From').html(response);
        			

        			 var temp=response;
        			 if(response=="1")
        				 {
        				 alert('Verified');
        				Redirect();
        				
        				 }
        			 else if(response=="2")
          				 alert('Already Verified By Other Person');
          			 else if (response=="3")
          				alert('Transaction is Already Created/Verified by User'); 
          			 else
        				 alert('Not Verified');
        				
        		},
        		error: function(e){						
        			alert('Error while request..'+e);
        		}
        	});
        }
  
  function madeAjaxCall_Verify(){
  	
  	var UserName=$("#UserName").val();
  	var Transaction_Id=$("#Transaction_Id").val();
  	var Transaction_Date=$("#Transaction_Date").val();
  	var Bcode=$("#Bcode").val();
  	//alert(Scheme_Type);


  	$.ajax({
  		type: "POST",
  		url: "${pageContext.servletContext.contextPath}/Verify3.htm",
  		data: 'UserName='+UserName+ "&Transaction_Id=" + Transaction_Id+ "&Transaction_Date=" + Transaction_Date+ "&Bcode=" + Bcode,
  		success: function(response){
  			$('#txt_Acc_From').html(response);
  			

  			 var temp=response;
  			 if(response=="1")
  				 {
  				 alert('Verified');
  				Redirect();
  				
  				 }
  			 else if(response=="2")
  				 alert('Already Verified By Other Person');
  			 else if (response=="3")
  				alert('Transaction is Already Created/Verified by User'); 
  			 else
				 alert('Not Verified');
  			 
  				
  		},
  		error: function(e){						
  			alert('Error while request..'+e);
  		}
  	});
  }
  
  function madeAjaxCall_Verify4(){
  	
  	var UserName=$("#UserName").val();
  	var Transaction_Id=$("#Transaction_Id").val();
  	var Transaction_Date=$("#Transaction_Date").val();
  	var Bcode=$("#Bcode").val();
  	//alert(Scheme_Type);


  	$.ajax({
  		type: "POST",
  		url: "${pageContext.servletContext.contextPath}/Verify4.htm",
  		data: 'UserName='+UserName+ "&Transaction_Id=" + Transaction_Id+ "&Transaction_Date=" + Transaction_Date+ "&Bcode=" + Bcode,
  		success: function(response){
  			$('#txt_Acc_From').html(response);
  			

  			 var temp=response;
  			 if(response=="1")
  				 {
  				 alert('Verified');
  				Redirect();
  				
  				 }
  			 else if(response=="2")
  				 alert('Already Verified By Other Person');
  			 else if (response=="3")
  				alert('Transaction is Already Created/Verified by User'); 
  			 else
				 alert('Not Verified');
  				
  		},
  		error: function(e){						
  			alert('Error while request..'+e);
  		}
  	});
  }
  
  function madeAjaxCall_Verify5(){
  	
  	var UserName=$("#UserName").val();
  	var Transaction_Id=$("#Transaction_Id").val();
  	var Transaction_Date=$("#Transaction_Date").val();
  	var Bcode=$("#Bcode").val();
  	//alert(Scheme_Type);


  	$.ajax({
  		type: "POST",
  		url: "${pageContext.servletContext.contextPath}/Verify5.htm",
  		data: 'UserName='+UserName+ "&Transaction_Id=" + Transaction_Id+ "&Transaction_Date=" + Transaction_Date+ "&Bcode=" + Bcode,
  		success: function(response){
  			$('#txt_Acc_From').html(response);
  			

  			 var temp=response;
  			 if(response=="1")
  				 {
  				 alert('Verified');
  				Redirect();
  				
  				 }
  			 else if(response=="2")
  				 alert('Already Verified By Other Person');
  			 else if (response=="3")
  				alert('Transaction is Already Created/Verified by User'); 
  			 else
				 alert('Not Verified');
  				
  		},
  		error: function(e){						
  			alert('Error while request..'+e);
  		}
  	});
  }
     
        </script>
        
        
        <style>
        .btn_Wood {
	background: #25A6E1;
	background: -moz-linear-gradient(top, #6F4242 0%, #856363 100%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #6F4242),
		color-stop(100%, #856363));
	background: -webkit-linear-gradient(top, #6F4242 0%, #856363 100%);
	background: -o-linear-gradient(top, #6F4242 0%, #856363 100%);
	background: -ms-linear-gradient(top, #6F4242 0%, #856363 100%);
	background: linear-gradient(top, #6F4242 0%, #856363 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#6F4242',
		endColorstr='#856363', GradientType=0);
	padding: 3px 5px;
	color: #fff;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 14px;
	border-radius: 4px;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
	border: 1px solid #8E8E38
}
        </style>

</head>
<body>



	<table width="90%" style="height: 450px" cellpadding="0"
		cellspacing="0" align="center">
		<colgroup>
			<col width="210px" />
			<col width="2px" />
			<col />
		</colgroup>
		<tr>


		
			<td class="All_Round" style="vertical-align: top">
<form:form method="post" action="${pageContext.servletContext.contextPath}/Verify_Transaction"
									modelAttribute="Verify_Transaction" commandName="Verify_Transaction">
								<table class="tbl_Content">
                  <input type="submit" value="Back" name="Close" class="btn_Blue" id="Close">  
				


				
				<table class="tbl_Content">
					<colgroup>
						<col width="150px" />
						<col width="180px" />
						<col width="130px" />
						<col />
					</colgroup>
					<tr>
						<th style="padding-left: 10px">General Ledger Postings</th>


					</tr>
					<tr>
						<td colspan="4">
							<hr
								style="border-style: dashed; color: #ddddcf; width: 98%; height: 1px" />
						</td>
					</tr>
				</table>

				<table border="1" class="mGrid" >


					
					<tr><font size="2px" color="black">
							<th>Tran. Id</th>
						<th>Tran. Date</th>
						<th>Particulars</th>
						<th>Acc. No</th>
						
						<th>Acc. Name</th>
						<th>Amount</th>
						
						<th>Dr./Cr.</th>
						</font>
					</tr>
					<c:forEach var="jd" items="${list2}">
						<tr>
							<td><font size="2px" color="black"><c:out value="${jd.s1}" /></font></td>
							<td><font size="2px" color="black"><c:out value="${jd.s72}" /></font></td>
							<td><font size="2px" color="black"><c:out value="${jd.s4}" /></font></td>
							
							
							<td><font size="2px" color="black"><c:out value="${jd.s6}" /></font></td>
							<td><font size="2px" color="black"><c:out value="${jd.s40}" /></font></td>
							
							<td align="right"><font size="2px" color="black"><c:out value="${jd.s71}" /></font></td>
							<td align="center"><font size="2px" color="black"><c:out value="${jd.s2}" /></font></td>




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
						<th style="padding-left: 10px">Ledger Postings</th>


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
						<th>Tran. Id</th>
						<th>Tran. Date</th>
						<th>Particulars</th>
						<th>Acc. No</th>
						
						<th>Acc. Name</th>
						<th>Amount</th>
						
						<th>Dr./Cr.</th>
	</tr>
	<c:forEach var="jd" items="${list1}">
						<tr>
							<td><font size="2px" color="black"><c:out value="${jd.s1}" /></font></td>
								<td><font size="2px" color="black"><c:out value="${jd.s72}" /></font></td>
														<td><font size="2px" color="black"><c:out value="${jd.s4}" /></font></td>
							<td><a href= "#" onclick="OpenPopup2(${jd.s6},${Bcode});"><font size="2px" color="green"><c:out value="${jd.s6}" /></font></a></td>
							
							
							<td><font size="2px" color="black"><c:out value="${jd.s40}" /></font></td>
							
							
							<td align="right"><font size="2px" color="black"><c:out value="${jd.s71}" /></font></td>
							<td align="center"><font size="2px" color="black"><c:out value="${jd.s2}" /></font></td>




						</tr>
					</c:forEach>
				</table>
			
						
					
				
				
			<!-- 	<a href="<%=request.getContextPath()%>/returnView_Transactions/${txnDate}/${txnDate}/${Bcode}" onclick="getValue();">Close</a>-->



						
							
				<form:hidden path="Transaction_Id" value="${Transaction_Id}"  id="trid"/>
						<form:hidden path="Transaction_Date" value="${Transaction_Date}" id="trdt"/>
						<form:hidden path="Bcode" value="${Bcode}" id="bcd"/>
					
						<form:hidden path="Verify1Flag" value="${Verify1Flag}" id="Verify1Flag" />
						<form:hidden  path="Verify2Flag" value="${Verify2Flag}" id="Verify2Flag" />
						<form:hidden   path="DeleteFlag" value="${DeleteFlag}" id="DeleteFlag" />
						
						
						
						<form:hidden path="Verify3Flag" value="${Verify3Flag}" id="Verify3Flag" />
						<form:hidden  path="Verify4Flag" value="${Verify4Flag}" id="Verify4Flag" />
						<form:hidden  path="Verify5Flag" value="${Verify5Flag}" id="Verify5Flag" />
						
						<form:hidden  path="page" value="${page}" id="page" />

									<div class="Btn_Row" id="ButtonData">
										<!-- <input  type="submit" value="Verify1" name="Verify1" class="btn_Blue" id="Verify1_Button"> &nbsp;-->
										<input  type="submit" value="Verify2" name="Verify2" class="btn_Blue" id="Verify2_Button"> &nbsp;
										<input type="submit" value="Verify3" name="Verify3" class="btn_Blue" id="Verify3_Button" > &nbsp;
										<input type="submit" value="Verify4" name="Verify4" class="btn_Blue" id="Verify4_Button"> &nbsp;
										<input  type="submit" value="Verify5" name="Verify5" class="btn_Blue" id="Verify5_Button"> &nbsp;
								    </div>
									
									
						
						<div id="FingerData">
						<a  href= "#" onclick="OpenPopup3('${txnDate}','2');"><font size="2px" color="RED" id="FingerLink2">E-Verify2</font></a>
						<
						<a  href= "#" onclick="OpenPopup3('${txnDate}','3');"><font size="2px" color="RED" id="FingerLink3">E-Verify3</font></a>
						<
						<a  href= "#" onclick="OpenPopup3('${txnDate}','4');"><font size="2px" color="RED" id="FingerLink4">E-Verify4</font></a>
						<
						<a 	 href= "#" onclick="OpenPopup3('${txnDate}','5');"><font size="2px" color="RED" id="FingerLink5">E-Verify5</font></a>
											<input type="submit" value="Close" name="Close" class="btn_Blue" id="Close"> &nbsp;
						</div>
						
						</tr>	
										
									<!-- 	<input type="submit" value="Delete" name="Delete" class="btn_Blue" id="Delete_Button" OnClick="return confirm('Are you sure want to delete?');">-->
																				<input style="display:none;" type="submit" value="Close" name="Close" class="btn_Blue" id="Close"> &nbsp;
										
									</div>
									
									
						<tr>			
						<td>
									<div class="Btn_Row2" style="display:none;">
										<!-- <input type="button" value="Finger Verify1" name="FVerify1" class="btn_Wood" id="FVerify1_Button" onclick="return madeAjaxCallMode('1');"> &nbsp;-->
										<input type="button" value="Finger Verify2" name="FVerify2" class="btn_Wood" id="FVerify2_Button" onclick="return madeAjaxCallMode('2');"> &nbsp;> &nbsp;
										<input type="button" value="Finger Verify3" name="FVerify3" class="btn_Wood" id="FVerify3_Button" onclick="return madeAjaxCallMode('3');"> &nbsp;
										<input type="button" value="Finger Verify4" name="FVerify4" class="btn_Wood" id="FVerify4_Button" onclick="return madeAjaxCallMode('4');"> &nbsp;> &nbsp;
										<input type="button" value="Finger Verify5" name="FVerify5" class="btn_Wood" id="FVerify5_Button" onclick="return madeAjaxCallMode('5');"> &nbsp;> &nbsp;
										
										
										
									<form:hidden  path="UserName"  id="UserName" />
									
										
										
									<!-- 	<input type="submit" value="Delete" name="Delete" class="btn_Blue" id="Delete_Button" OnClick="return confirm('Are you sure want to delete?');">-->
																				<input type="submit" value="Close" name="Close" class="btn_Blue" id="Close"> &nbsp;
										
									</div>
									</td>
									</tr>	
								
							<tr>
							<form:hidden path="FingerVerify1Flag1" value="${FingerVerify1Flag1}" id="FingerVerify1Flag1" />
							<form:hidden path="FingerVerify1Flag2" value="${FingerVerify1Flag2}" id="FingerVerify1Flag2" />
							<form:hidden path="FingerVerify1Flag3" value="${FingerVerify1Flag3}" id="FingerVerify1Flag3" />
							<form:hidden path="FingerVerify1Flag4" value="${FingerVerify1Flag4}" id="FingerVerify1Flag4" />
							<form:hidden path="FingerVerify1Flag5" value="${FingerVerify1Flag5}" id="FingerVerify1Flag5" />
								
							</tr>				
										
  					
                   </table>
                   </form:form>




			</td>
			





		</tr>
	</table>
	 <% response.setHeader("Access-Control-Allow-Origin", "*");  %>
	<% response.setHeader("Access-Control-Allow-Origin", "http://localhost:8082");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type");
            response.setHeader("Access-Control-Max-Age", "86400"); %>

</body>
</html>
				