<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html xmlns="http://www.w3.org/1999/xhtml">
 
<head>

<script src="<c:url value="/resources/js/jquery-1.8.2.js"/>"></script>
<script src="<c:url value="/resources/js/mfs100-9.0.2.6.js" />"></script>




   <script src="<c:url value="/resources/js/jquery-1.8.2.js" />"></script>
<script src="<c:url value="/resources/js/mfs100-9.0.2.6.js" />"></script>

	<script type="text/javascript" language="javascript"
	src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script>
<script type="text/javascript"
	src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

 
							
    <title>Finger Print Test</title>
    <style type="text/css">
        body {
            font-family: 'Segoe UI';
            background-color: #DDDDDD;
            margin: 0px 5px 5px 5px;
            padding: 0px 5px 5px 5px;
            color: #555;
            font-size: 12px;
        }

        .panel {
            background-color: #FFFFFF;
            -moz-user-select: none;
            background-image: none;
            border: 1px solid transparent;
            border-radius: 4px;
            margin: 12px 12px;
            padding: 6px 12px;
        }

        .btn {
            display: inline-block;
            padding: 6px 12px;
            margin-bottom: 0px;
            font-size: 14px;
            font-weight: 400;
            line-height: 1.42857;
            text-align: center;
            white-space: nowrap;
            vertical-align: middle;
            cursor: pointer;
            -moz-user-select: none;
            background-image: none;
            border: 1px solid transparent;
            border-radius: 4px;
        }
        .btn-50 {
            width: 50px;
        }
        .btn-100 {
            width: 100px;
        }

        .btn-150 {
            width: 150px;
        }

        .btn-200 {
            width: 205px;
        }

        .btn-primary {
            color: #FFF;
            background-color: #428BCA;
            border-color: #357EBD;
        }

            .btn-primary:hover {
                color: #FFF;
                background-color: #357EBD;
                border-color: #428BCA;
            }

        .form-control {
            display: block;
            width: 100%;
            height: 24px;
            padding: 3px 6px;
            font-size: 12px;
            /*line-height: 1.42857;*/
            color: #555;
            background-color: #FFF;
            background-image: none;
            border: 1px solid #bdbdbd;
            border-radius: 4px;
            box-shadow: 0px 1px 1px rgba(0, 0, 0, 0.075) inset;
            transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s;
        }

        textarea.form-control {
            height: auto;
        }

        .text-bold {
            font-weight: bold;
        }

        .img {
            min-width: 125px;
            min-height: 155px;
            width: 125px;
            height: 155px;
            border: 1px solid #CCC;
            border-radius: 4px;
            box-shadow: 0px 1px 1px rgba(0, 0, 0, 0.075) inset;
            background-color: #FFFFFF;
        }
    </style>
   <!--  <script src="jquery-1.8.2.js"></script>
    <script src="mfs100-9.0.2.6.js"></script>-->
    
    <script src="<c:url value="/resources/js/jquery-1.8.2.js" />"></script>
<script src="<c:url value="/resources/js/mfs100-9.0.2.6.js" />"></script>
    <script language="javascript" type="text/javascript">


        var quality = 60; //(1 to 100) (recommanded minimum 55)
        var timeout = 10; // seconds (minimum=10(recommanded), maximum=60, unlimited=0 )

        function GetInfo() {
        	alert('getInf0---->');
            document.getElementById('tdSerial').innerHTML = "";
            document.getElementById('tdCertification').innerHTML = "";
            document.getElementById('tdMake').innerHTML = "";
            document.getElementById('tdModel').innerHTML = "";
            document.getElementById('tdWidth').innerHTML = "";
            document.getElementById('tdHeight').innerHTML = "";
            document.getElementById('tdLocalMac').innerHTML = "";
            document.getElementById('tdLocalIP').innerHTML = "";
            document.getElementById('tdSystemID').innerHTML = "";
            document.getElementById('tdPublicIP').innerHTML = "";


            var key = document.getElementById('txtKey').value;
alert('key='+key);
            var res;
            if (key.length == 0) {
            	alert('key=1');
                res = GetMFS100Info();
               // alert(res.data.ErrorCode);
            }
            else {
            	//alert('key=2');
                res = GetMFS100KeyInfo(key);
               // alert(res.data.ErrorCode);
            }

            if (res.httpStaus) {
            	alert(res.httpStaus);
            	alert(res.data.ErrorCode);

                document.getElementById('txtStatus').value = "ErrorCode: " + res.data.ErrorCode + " ErrorDescription: " + res.data.ErrorDescription;

                if (res.data.ErrorCode == "0") {
                    document.getElementById('tdSerial').innerHTML = res.data.DeviceInfo.SerialNo;
                    document.getElementById('tdCertification').innerHTML = res.data.DeviceInfo.Certificate;
                    document.getElementById('tdMake').innerHTML = res.data.DeviceInfo.Make;
                    document.getElementById('tdModel').innerHTML = res.data.DeviceInfo.Model;
                    document.getElementById('tdWidth').innerHTML = res.data.DeviceInfo.Width;
                    document.getElementById('tdHeight').innerHTML = res.data.DeviceInfo.Height;
                    document.getElementById('tdLocalMac').innerHTML = res.data.DeviceInfo.LocalMac;
                    document.getElementById('tdLocalIP').innerHTML = res.data.DeviceInfo.LocalIP;
                    document.getElementById('tdSystemID').innerHTML = res.data.DeviceInfo.SystemID;
                    document.getElementById('tdPublicIP').innerHTML = res.data.DeviceInfo.PublicIP;
                }
            }
            else {
                alert(res.err);
            }
            return false;
        }

        function Capture() {
            try {
                document.getElementById('txtStatus').value = "";
                document.getElementById('imgFinger').src = "data:image/bmp;base64,";
                document.getElementById('txtImageInfo').value = "";
                document.getElementById('txtIsoTemplate').value = "";
                document.getElementById('txtAnsiTemplate').value = "";
                document.getElementById('txtIsoImage').value = "";
                document.getElementById('txtRawData').value = "";
                document.getElementById('txtWsqData').value = "";

                var res = CaptureFinger(quality, timeout);
                if (res.httpStaus) {

                    document.getElementById('txtStatus').value = "ErrorCode: " + res.data.ErrorCode + " ErrorDescription: " + res.data.ErrorDescription;

                    if (res.data.ErrorCode == "0") {
                        document.getElementById('imgFinger').src = "data:image/bmp;base64," + res.data.BitmapData;
                        var imageinfo = "Quality: " + res.data.Quality + " Nfiq: " + res.data.Nfiq + " W(in): " + res.data.InWidth + " H(in): " + res.data.InHeight + " area(in): " + res.data.InArea + " Resolution: " + res.data.Resolution + " GrayScale: " + res.data.GrayScale + " Bpp: " + res.data.Bpp + " WSQCompressRatio: " + res.data.WSQCompressRatio + " WSQInfo: " + res.data.WSQInfo;
                        document.getElementById('txtImageInfo').value = imageinfo;
                        document.getElementById('txtIsoTemplate').value = res.data.IsoTemplate;
                        document.getElementById('txtAnsiTemplate').value = res.data.AnsiTemplate;
                        document.getElementById('txtIsoImage').value = res.data.IsoImage;
                        document.getElementById('txtRawData').value = res.data.RawData;
                        document.getElementById('txtWsqData').value = res.data.WsqImage;
                        document.getElementById('AnsiImage').value = res.data.AnsiTemplate;
                        alert(document.getElementById('AnsiImage').value);
                    }
                }
                else {
                    alert(res.err);
                }
            }
            catch (e) {
                alert(e);
            }
            return false;
        }

        function Verify() {
            try {
                var isotemplate = document.getElementById('txtIsoTemplate').value;
                var res = VerifyFinger(isotemplate, isotemplate);

                if (res.httpStaus) {
                    if (res.data.Status) {
                        alert("Finger matched");
                    }
                    else {
                        if (res.data.ErrorCode != "0") {
                            alert(res.data.ErrorDescription);
                        }
                        else {
                            alert("Finger not matched");
                        }
                    }
                }
                else {
                    alert(res.err);
                }
            }
            catch (e) {
                alert(e);
            }
            return false;

        }

        function Match() {
            try {
                var isotemplate = document.getElementById('txtIsoTemplate').value;
                var res = MatchFinger(quality, timeout, isotemplate);

                if (res.httpStaus) {
                    if (res.data.Status) {
                        alert("Finger matched");
                    }
                    else {
                        if (res.data.ErrorCode != "0") {
                            alert(res.data.ErrorDescription);
                        }
                        else {
                            alert("Finger not matched");
                        }
                    }
                }
                else {
                    alert(res.err);
                }
            }
            catch (e) {
                alert(e);
            }
            return false;

        }

        function GetPid() {
            try {
                var isoTemplateFMR = document.getElementById('txtIsoTemplate').value;
                var isoImageFIR = document.getElementById('txtIsoImage').value;

                var Biometrics = Array(); // You can add here multiple FMR value
                Biometrics["0"] = new Biometric("FMR", isoTemplateFMR, "UNKNOWN", "", "");

                var res = GetPidData(Biometrics);
                if (res.httpStaus) {
                    if (res.data.ErrorCode != "0") {
                        alert(res.data.ErrorDescription);
                    }
                    else {
                        document.getElementById('txtPid').value = res.data.PidData.Pid
                        document.getElementById('txtSessionKey').value = res.data.PidData.Sessionkey
                        document.getElementById('txtHmac').value = res.data.PidData.Hmac
                        document.getElementById('txtCi').value = res.data.PidData.Ci
                        document.getElementById('txtPidTs').value = res.data.PidData.PidTs
                    }
                }
                else {
                    alert(res.err);
                }

            }
            catch (e) {
                alert(e);
            }
            return false;
        }
        function GetProtoPid() {
            try {
                var isoTemplateFMR = document.getElementById('txtIsoTemplate').value;
                var isoImageFIR = document.getElementById('txtIsoImage').value;

                var Biometrics = Array(); // You can add here multiple FMR value
                Biometrics["0"] = new Biometric("FMR", isoTemplateFMR, "UNKNOWN", "", "");

                var res = GetProtoPidData(Biometrics);
                if (res.httpStaus) {
                    if (res.data.ErrorCode != "0") {
                        alert(res.data.ErrorDescription);
                    }
                    else {
                        document.getElementById('txtPid').value = res.data.PidData.Pid
                        document.getElementById('txtSessionKey').value = res.data.PidData.Sessionkey
                        document.getElementById('txtHmac').value = res.data.PidData.Hmac
                        document.getElementById('txtCi').value = res.data.PidData.Ci
                        document.getElementById('txtPidTs').value = res.data.PidData.PidTs
                    }
                }
                else {
                    alert(res.err);
                }

            }
            catch (e) {
                alert(e);
            }
            return false;
        }
        function GetRbd() {
            try {
                var isoTemplateFMR = document.getElementById('txtIsoTemplate').value;
                var isoImageFIR = document.getElementById('txtIsoImage').value;

                var Biometrics = Array();
                Biometrics["0"] = new Biometric("FMR", isoTemplateFMR, "LEFT_INDEX", 2, 1);
                Biometrics["1"] = new Biometric("FMR", isoTemplateFMR, "LEFT_MIDDLE", 2, 1);
                // Here you can pass upto 10 different-different biometric object.


                var res = GetRbdData(Biometrics);
                if (res.httpStaus) {
                    if (res.data.ErrorCode != "0") {
                        alert(res.data.ErrorDescription);
                    }
                    else {
                        document.getElementById('txtPid').value = res.data.RbdData.Rbd
                        document.getElementById('txtSessionKey').value = res.data.RbdData.Sessionkey
                        document.getElementById('txtHmac').value = res.data.RbdData.Hmac
                        document.getElementById('txtCi').value = res.data.RbdData.Ci
                        document.getElementById('txtPidTs').value = res.data.RbdData.RbdTs
                    }
                }
                else {
                    alert(res.err);
                }

            }
            catch (e) {
                alert(e);
            }
            return false;
        }

        function GetProtoRbd() {
            try {
                var isoTemplateFMR = document.getElementById('txtIsoTemplate').value;
                var isoImageFIR = document.getElementById('txtIsoImage').value;

                var Biometrics = Array();
                Biometrics["0"] = new Biometric("FMR", isoTemplateFMR, "LEFT_INDEX", 2, 1);
                Biometrics["1"] = new Biometric("FMR", isoTemplateFMR, "LEFT_MIDDLE", 2, 1);
                // Here you can pass upto 10 different-different biometric object.


                var res = GetProtoRbdData(Biometrics);
                if (res.httpStaus) {
                    if (res.data.ErrorCode != "0") {
                        alert(res.data.ErrorDescription);
                    }
                    else {
                        document.getElementById('txtPid').value = res.data.RbdData.Rbd
                        document.getElementById('txtSessionKey').value = res.data.RbdData.Sessionkey
                        document.getElementById('txtHmac').value = res.data.RbdData.Hmac
                        document.getElementById('txtCi').value = res.data.RbdData.Ci
                        document.getElementById('txtPidTs').value = res.data.RbdData.RbdTs
                    }
                }
                else {
                    alert(res.err);
                }

            }
            catch (e) {
                alert(e);
            }
            return false;
        }
        
        
        
        
        function madeAjaxCallMode(){
        	
        	
        	   var res = CaptureFinger(quality, timeout);
               if (res.httpStaus) {

                   document.getElementById('txtStatus').value = "ErrorCode: " + res.data.ErrorCode + " ErrorDescription: " + res.data.ErrorDescription;

                   if (res.data.ErrorCode == "0") {
                       document.getElementById('imgFinger').src = "data:image/bmp;base64," + res.data.BitmapData;
                       var imageinfo = "Quality: " + res.data.Quality + " Nfiq: " + res.data.Nfiq + " W(in): " + res.data.InWidth + " H(in): " + res.data.InHeight + " area(in): " + res.data.InArea + " Resolution: " + res.data.Resolution + " GrayScale: " + res.data.GrayScale + " Bpp: " + res.data.Bpp + " WSQCompressRatio: " + res.data.WSQCompressRatio + " WSQInfo: " + res.data.WSQInfo;
                       document.getElementById('txtImageInfo').value = imageinfo;
                       document.getElementById('txtIsoTemplate').value = res.data.IsoTemplate;
                       document.getElementById('txtAnsiTemplate').value = res.data.AnsiTemplate;
                       document.getElementById('txtIsoImage').value = res.data.IsoImage;
                       document.getElementById('txtRawData').value = res.data.RawData;
                       document.getElementById('txtWsqData').value = res.data.WsqImage;
                       document.getElementById('AnsiImage').value = res.data.AnsiTemplate;
                       alert(document.getElementById('AnsiImage').value);
                   }
               }
               else {
                   alert(res.err);
               }
        	
        	
        	
			var Customer_Id="122213";
			/*var listArray1 = new ListArray();	
			var listArray2 = new ListArray();	

				$.ajax({
    			type: "POST",
    			url: "${pageContext.servletContext.contextPath}/GetImageList.htm",
    			data: 'Customer_Id='+Customer_Id,
    			success: function(response){
    			
    				var temp=response.split(",");
    				
    				 for (var i=0; i < temp.length; i++)
 				    {
    					 String arrSplit2 = arrSplit[i].split("-");
 				    	// var element = {cusId: arrSplit[0], ImgInfo: arrSplit[1]};
 				    	 var element1 = arrSplit[0];
 				    	  var element2 = arrSplit[1];
 				    	// listArray1.push(element1);
 				    	//listArray2.push(element2);
 		 		    }
    					
    				/* var isotemplate = document.getElementById('AnsiImage').value;
		           int flag=1;    
		           var cusInfo="";
    				 for (var i=0; i < listArray1.length; i++)
 				    {
    					 try {
    			                var res = VerifyFinger(listArray1[i], isotemplate);

    			                if (res.httpStaus) {
    			                    if (res.data.Status) {
    			                        flag=2;
    			                        cusInfo=listArray2[i];
    			                        
    			                    }
    			                    else {
    			                        if (res.data.ErrorCode != "0") {
    			                            alert(res.data.ErrorDescription);
    			                        }
    			                        else {
    			                            alert("Finger not matched");
    			                        }
    			                    }
    			                }
    			                else {
    			                    alert(res.err);
    			                }
    			                
    			                
    			                
    			            }
    			            catch (e) {
    			                alert(e);
    			            }
 		 		    }
    				 
    				 if (flag==2) {
	                        alert("Finger matched");
	                    }
	                    else {
	                       
	                            alert("Finger not matched");
	                        }
	                   
    				
    			},
    			error: function(e){						
    				alert('Error while request..'+e);
    			}
    		});*/
    		
    		var isotemplate = document.getElementById('AnsiImage').value;
    		alert("iNPUT:1 "+isotemplate);
			$.ajax({
			    type : "GET",
			    url : "${pageContext.request.contextPath}/check",
			    data : {
			   
			    },
			    success: function(data)
			    {
			    //response from controller
			    	var temp=data.split(",");
			  //  alert(temp);
			  alert("temp.length="+temp.length);
			    var output = "";

				 // Remember when we started
				 var start = new Date().getTime();
			    var flag=1;
			    var count=0;
			    var cusInfo="";
			    for (var i=0; i < temp.length-1; i++)
				    {
			    	count=count+1;
					 var arrSplit = temp[i].split("-");
				    	// var element = {cusId: arrSplit[0], ImgInfo: arrSplit[1]};
				    	// var element1 = arrSplit[0];
				    	 // var element2 = arrSplit[1];
				    	// listArray1.push(element1);
				    	//listArray2.push(element2);
				    	//alert("iNPUT:2 "+arrSplit[1]);
				    	 res = VerifyFinger(isotemplate, arrSplit[1]);
				    		 if (res.httpStaus)
				    		 {
    			                    if (res.data.Status)
    			                    {
    			                        flag=2;
    			                        cusInfo=arrSplit[0];
    			                        
    			                    }
    			                   /* else {
    			                        if (res.data.ErrorCode != "0")
    			                        {
    			                            alert(res.data.ErrorDescription);
    			                        }
    			                    }  */
    			                  
    			                }
    			                else {
    			                    alert(res.err);
    			                }
		 		    }
			

			 for (var i = 1; i <= 1e6; i++) {
			   output += i;
			 }

			 // Remember when we finished
			 var end = new Date().getTime();

			 // Now calculate and output the difference
			 console.log(end - start);
			    
			    if(flag==2)
			    	{
			    	alert(count+":Finger Matched-"+cusInfo);
			    	}
			    else
			    	alert(count+":Finger not Matched");
			    }
			});
    		
    		
    	}
        
        
    </script>
</head>
<body>
<form:form action="${pageContext.servletContext.contextPath}/saveFinger_Print" modelAttribute="Finger_Print" commandName="Finger_Print">
    <table width="100%" style="padding-top:0px;">
        <tr>
            <td colspan="3" align="center" style="color: #428BCA; font-size: 20px; font-weight:bold;">
               Pisquare Fingerprint Verification
            </td>
        </tr>

        <tr style="display:none;">
            <td colspan="3" align="center" style="color: red; font-size: 14px;">
                Please check that your bowser is asking for enable script or not. If yes then enable it.
                <!--<br />-->
                If you are using Internet Explorer then it will ask for "Allow Blocked Content".
                <br />
                First call may take some time, so wait after click any button
            </td>
        </tr>

        <tr>
            <td width="200px;">
                <table align="left" border="0" width="100%">
                    <tr>
                        <td>
                            <input type="submit" name="GetFinger" id="btnInfo" value="Get Info" class="btn btn-primary btn-100" onclick="return GetInfo()" />
                        </td>
                        <td>
                            <input type="submit" name="SaveFinger" id="btnCapture" value="Capture" class="btn btn-primary btn-100" onclick="return Capture()" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" id="btnCaptureAndMatch" value="Capture and Match" class="btn btn-primary btn-200" onclick="return Match()" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" id="btnMatch" value="Match" class="btn btn-primary btn-200" onclick="return Verify()" />
                        </td>
                    </tr>
                    <tr style="display:none;">
                        <td>
                            <input type="submit" id="btnGetPid" value="Get PID (X)" class="btn btn-primary btn-100" onclick="return GetPid()" />
                        </td>
                        <td>
                            <input type="submit" id="btnProtoGetPid" value="Get PID (P)" class="btn btn-primary btn-100" onclick="return GetProtoPid()" />
                        </td>
                    </tr>
                    <tr style="display:none;">
                        <td>
                            <input type="submit" id="btnGetRbd" value="Get RBD (X)" class="btn btn-primary btn-100" onclick="return GetRbd()" />
                        </td>
                        <td>
                            <input type="submit" id="btnProtoGetRbd" value="Get RBD (P)" class="btn btn-primary btn-100" onclick="return GetProtoRbd()" />
                        </td>
                    </tr>
                </table>
            </td>
            <td width="150px" height="190px" align="center" class="img">
                <img id="imgFinger" width="145px" height="188px" alt="Finger Image" />
            </td>
            <td>
                <table align="left" border="0" style="display:none;width:100%; padding-right:20px;">
                    <tr>
                        <td style="width: 100px;">Key:</td>
                        <td colspan="3">
                            <input type="text" value="" id="txtKey" class="form-control" />
                        </td>
                    </tr>
                    <tr>
                        <td align="left" style="width: 100px;">Serial No:</td>
                        <td align="left" style="width: 150px;" id="tdSerial"></td>
                        <td align="left" style="width: 100px;">Certification:</td>
                        <td align="left" id="tdCertification"></td>
                    </tr>
                    <tr>
                        <td align="left">Make:</td>
                        <td align="left" id="tdMake"></td>
                        <td align="left">Model:</td>
                        <td align="left" id="tdModel"></td>
                    </tr>
                    <tr>
                        <td align="left">Width:</td>
                        <td align="left" id="tdWidth"></td>
                        <td align="left">Height:</td>
                        <td align="left" id="tdHeight"></td>
                    </tr>
                    <tr>
                        <td align="left">Local IP</td>
                        <td align="left" id="tdLocalIP"></td>
                        <td align="left">Local MAC:</td>
                        <td align="left" id="tdLocalMac"></td>
                    </tr>
                    <tr>
                        <td align="left">Public IP</td>
                        <td align="left" id="tdPublicIP"></td>
                        <td align="left">System ID</td>
                        <td align="left" id="tdSystemID"></td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <div class="panel">
        <table width="100%">
            <tr>
                <td width="220px">
                    Status:
                </td>
                <td>
                    <input type="text" value="" id="txtStatus" class="form-control" />
                </td>
            </tr>
            <tr style="display:none;">
                <td>
                    Quality:
                </td>
                <td>
                    <input type="text" value="" id="txtImageInfo" class="form-control" />
                </td>
            </tr>
            <!--<tr>
                <td>
                    NFIQ:
                </td>
                <td>
                    <input type="text" value="" id="txtNFIQ" class="form-control" />
                </td>
            </tr>-->
            <tr style="display:none;">
                <td>
                    Base64Encoded ISO Template
                </td>
                <td>
                    <textarea id="txtIsoTemplate" style="width: 100%; height:50px;" class="form-control"> </textarea>
                </td>
            </tr>
            <tr>
                <td>
                    Base64Encoded ANSI Template
                </td>
                <td>
                    <textarea id="txtAnsiTemplate" style="width: 100%; height:50px;" class="form-control" path="AnsiTemplate"> </textarea>
                </td>
            </tr>
            <tr style="display:none;">
                <td>
                    Base64Encoded ISO Image
                </td>
                <td>
                    <textarea id="txtIsoImage" style="width: 100%; height:50px;" class="form-control"> </textarea>
                </td>
            </tr>
            <tr style="display:none;">
                <td>
                    Base64Encoded Raw Data
                </td>
                <td>
                    <textarea id="txtRawData" style="width: 100%; height:50px;" class="form-control"> </textarea>
                </td>
            </tr>
            <tr style="display:none;">
                <td>
                    Base64Encoded Wsq Image Data
                </td>
                <td>
                    <textarea id="txtWsqData" style="width: 100%; height:50px;" class="form-control"> </textarea>
                </td>
            </tr>
            <tr style="display:none;">
                <td>
                    Encrypted Base64Encoded Pid/Rbd
                </td>
                <td>
                    <textarea id="txtPid" style="width: 100%; height:50px;" class="form-control"> </textarea>
                </td>
            </tr>
            <tr style="display:none;">
                <td>
                    Encrypted Base64Encoded Session Key
                </td>
                <td>
                    <textarea id="txtSessionKey" style="width: 100%; height:50px;" class="form-control"> </textarea>
                </td>
            </tr>
            <tr style="display:none;">
                <td>
                    Encrypted Base64Encoded Hmac
                </td>
                <td>
                    <input type="text" value="" id="txtHmac" class="form-control" />

                </td>
            </tr>
            <tr style="display:none;">
                <td>
                    Ci
                </td>
                <td>
                    <input type="text" value="" id="txtCi" class="form-control" />
                </td>
            </tr>
            <tr style="display:none;">
                <td>
                    Pid/Rbd Ts
                </td>
                <td>
                    <input type="text" value="" id="txtPidTs" class="form-control" />
                </td>
            </tr>
        </table>
    </div>
    </form:form>
    <form:form action="${pageContext.servletContext.contextPath}/saveFinger_Print2" modelAttribute="Finger_Print2" commandName="Finger_Print2">
    <table width="100%" style="padding-top:0px;">
     <tr>
      			<td>
                    <form:hidden path="AnsiImage"  id="AnsiImage" class="form-control" />
                </td>
                     <td>
                            <input type="submit" name="GetFinger2" id="btnInfo2" value="Get Info2" class="btn btn-primary btn-100" onclick="return GetInfo()" />
                        </td>
                        <td>
                            <input type="submit" name="SaveFinger2" id="btnCapture2" value="Capture2" class="btn btn-primary btn-100" onclick="Capture()" />
                        </td>
                        
                        <td>
                            <input type="button" name="VerifyFinger2" id="btnCapture2" value="Verify" class="btn btn-primary btn-100" onclick="return madeAjaxCallMode();" />
                        </td>
                    </tr>
  </table>
  </form:form>
    
</body>
</html>
