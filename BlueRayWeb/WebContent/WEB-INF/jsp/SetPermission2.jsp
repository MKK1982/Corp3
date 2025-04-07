

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="<c:url value="/resources/CSS/menu/style.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/CSS/menu/iconic.css"/>"
	rel="stylesheet" />
<link href="<c:url value="/resources/CSS/sidemenu/css/dcaccordion.css" />" rel="stylesheet" />
<link href="<c:url value="/resources/CSS/sidemenu/css/skins/blue.css" />" rel="stylesheet" />
<link href="<c:url value="/resources/CSS/tbl_style.css"/>" rel="stylesheet" />
<link href="<c:url value="/resources/CSS/Controls.css"/>" rel="stylesheet" />
<link href="<c:url value="/resources/CSS/image.css" />" rel="stylesheet" />

<link href="<c:url value="/resources/CSS/jsDatePick_rtl.css" />" rel="stylesheet"></link>
<link href="<c:url value="/resources/CSS/jsDatePick_ltr.css" />" rel="stylesheet"></link>
<link href="<c:url value="/resources/CSS/jsDatePick_ltr.min.css" />" rel="stylesheet"></link>
<link href="<c:url value="/resources/CSS/jsDatePick_rtl.min.css" />" rel="stylesheet"></link>

<script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
<script src="<c:url value="/resources/js/main.js" />"></script>
<script src="<c:url value="/resources/CSS/menu/prefix-free.js" />"></script>
<script src="<c:url value="/resources/CSS/sidemenu/jquery.js" />"></script>
<script src="<c:url value="/resources/CSS/sidemenu/js/sidetab.js" />"></script>
<script src="<c:url value="/resources/CSS/sidemenu/js/jquery.dcjqaccordion.2.7.min.js" />"></script>
<script src="<c:url value="/resources/js/jsDatePick.min.1.3.js" />"></script>
<script src="<c:url value="/resources/js/jsDatePick.min.1.3.js" />"></script>

<script src="<c:url value="/resources/js/jquery.1.4.2.js" />"></script>
<script src="<c:url value="/resources/js/jsDatePick.full.1.3.js" />"></script>
<script src="<c:url value="/resources/js/jsDatePick.jquery.full.1.3.js" />"></script>
<script src="<c:url value="/resources/js/jsDatePick.jquery.min.1.3.js" />"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Branch Permission Settings</title>
<script type="text/javascript"
	src="jquery-ui-1.10.0/tests/jquery-1.9.0.js"></script>
<script src="jquery-ui-1.10.0/ui/jquery-ui.js"></script>
<script type="text/javascript" language="javascript">


function OpenPopup()
{
	
	
		var user1=document.getElementById('id_username').value;
		//alert(user1);
		if(user1=="" || user1=="0")
			{
			alert("Please enter User Id");
			return false;
			}
		else
			return true;
	
}

function Target_Id_Check() 
{
	var AccNo = document.getElementById('txt_Target_Id').value;
  // alert(AccNo);
    
    
    if(AccNo == "" )
    {
    	// alert('Inside');
    	AccNo = 1;
    }
   // alert(AccNo);
    
    
    
    
    	var path="${pageContext.servletContext.contextPath}";
    	var snnl4 = "${pageContext.request.contextPath}";
    	//alert(snnl4);
    	var url=path+"/Search_User_Id/" + AccNo+"";
    	//alert(url);
        popupWindow = window.open(url, "List", "left = 500,top=150,directories=no,titlebar=no,toolbar=no,location=no,status=no,menubar=no,width=800,height=600");
        //  "/snnl4/FD_Interest_List/" + Accno
      //  parent_disable();
        
       
   }



$(document).ready(function(){
	
	//alert('Entered');

	if(document.getElementById('SaveFlag').value==2)
	{
	//alert('save-2');
	//document.getElementById('Verify1_Button').disabled=true;
	//document.getElementById('Verify1_Button').style.color='red';
	document.getElementById('Save_Button').style.display='none';
	document.getElementById('Reset_Button').style.display='none';
	}

	if(document.getElementById('UpdateFlag').value==2)
	{
	//alert('update2');
	//document.getElementById('Verify1_Button').disabled=true;
	//document.getElementById('Verify1_Button').style.color='red';
	document.getElementById('Reset_Button').style.display='none';
	document.getElementById('Save_Button').style.display='none';
	}


$('.Person_Data').each(function()
		 {
	      this.checked=false;
		 }
);


});


function SelectAllCheckBox1()
{
	 if(document.getElementById('Select_All').checked==true)
		 {
		 $('.Cus_Data').each(function()
				 {
			      this.checked=true;
				 }
		 
	 );
		 }
	 else
		 {
		 $('.Cus_Data').each(function()
				 {
			      this.checked=false;
				 }
		 );
		 }
		 
}
function SelectAllCheckBox2()
{
	 if(document.getElementById('Select_All_Share').checked==true)
		 {
		 $('.Share_Data').each(function()
				 {
			      this.checked=true;
				 }
		 
	 );
		 }
	 else
		 {
		 $('.Share_Data').each(function()
				 {
			      this.checked=false;
				 }
		 );
		 }
		 
}
function SelectAllCheckBox3()
{
	 if(document.getElementById('Select_All_Save').checked==true)
		 {
		 $('.Save_Data').each(function()
				 {
			      this.checked=true;
				 }
		 
	 );
		 }
	 else
		 {
		 $('.Save_Data').each(function()
				 {
			      this.checked=false;
				 }
		 );
		 }
		 
}
function SelectAllCheckBox4()
{
	 if(document.getElementById('Select_All_FD').checked==true)
		 {
		 $('.FD_Data').each(function()
				 {
			      this.checked=true;
				 }
		 
	 );
		 }
	 else
		 {
		 $('.FD_Data').each(function()
				 {
			      this.checked=false;
				 }
		 );
		 }
		 
}
function SelectAllCheckBox5()
{
	 if(document.getElementById('Select_All_RD').checked==true)
		 {
		 $('.RD_Data').each(function()
				 {
			      this.checked=true;
				 }
		 
	 );
		 }
	 else
		 {
		 $('.RD_Data').each(function()
				 {
			      this.checked=false;
				 }
		 );
		 }
		 
}
function SelectAllCheckBox6()
{
	 if(document.getElementById('Select_All_JL').checked==true)
		 {
		 $('.JL_Data').each(function()
				 {
			      this.checked=true;
				 }
		 
	 );
		 }
	 else
		 {
		 $('.JL_Data').each(function()
				 {
			      this.checked=false;
				 }
		 );
		 }
		 
}
function SelectAllCheckBox7()
{
	 if(document.getElementById('Select_All_OL').checked==true)
		 {
		 $('.OL_Data').each(function()
				 {
			      this.checked=true;
				 }
		 
	 );
		 }
	 else
		 {
		 $('.OL_Data').each(function()
				 {
			      this.checked=false;
				 }
		 );
		 }
		 
}
function SelectAllCheckBox8()
{
	 if(document.getElementById('Select_All_JO').checked==true)
		 {
		 $('.JO_Data').each(function()
				 {
			      this.checked=true;
				 }
		 
	 );
		 }
	 else
		 {
		 $('.JO_Data').each(function()
				 {
			      this.checked=false;
				 }
		 );
		 }
		 
}
function SelectAllCheckBox9()
{
	 if(document.getElementById('Select_All_ST').checked==true)
		 {
		 $('.ST_Data').each(function()
				 {
			      this.checked=true;
				 }
		 
	 );
		 }
	 else
		 {
		 $('.ST_Data').each(function()
				 {
			      this.checked=false;
				 }
		 );
		 }
		 
}
function SelectAllCheckBox10()
{
	 if(document.getElementById('Select_All_TR').checked==true)
		 {
		 $('.TR_Data').each(function()
				 {
			      this.checked=true;
				 }
		 
	 );
		 }
	 else
		 {
		 $('.TR_Data').each(function()
				 {
			      this.checked=false;
				 }
		 );
		 }
		 
}

function SelectAllCheckBox11()
{
	 if(document.getElementById('Select_All_IB').checked==true)
		 {
		 $('.IB_Data').each(function()
				 {
			      this.checked=true;
				 }
		 
	 );
		 }
	 else
		 {
		 $('.IB_Data').each(function()
				 {
			      this.checked=false;
				 }
		 );
		 }
		 
}

function SelectAllCheckBoxBranch()
{
	 if(document.getElementById('Select_All_Branch').checked==true)
		 {
		 $('.Person_Data').each(function()
				 {
			      this.checked=true;
				 }
		 
	 );
		 }
	 else
		 {
		 $('.Person_Data').each(function()
				 {
			      this.checked=false;
				 }
		 );
		 }
		 
}

//Brach_Permission_Data
function SelectAllCheckBoxBranch2()
{
	 if(document.getElementById('Select_All_Branch2').checked==true)
		 {
		 $('.Brach_Permission_Data').each(function()
				 {
			      this.checked=true;
				 }
		 
	 );
		 }
	 else
		 {
		 $('.Brach_Permission_Data').each(function()
				 {
			      this.checked=false;
				 }
		 );
		 }
		 
}
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
    
    <script type="text/javascript">
    
    function ValidateSpecialChar() {
        //Regex for Valid Characters i.e. Alphabets, Numbers and Space.
       // alert('validate');
        var regex = /^[A-Za-z0-9 ]+$/;
        
        var str=document.getElementById("txt_Emp_Id").value;
        //Validate TextBox value against the Regex.
        var isValid = regex.test(str);
        if (!isValid) {
            alert("Contains Special Characters.");
            document.getElementById("txt_Emp_Id").value=str.replace(/[^a-zA-Z0-9 ]/g, "");
        } /* else {
            alert("Does not contain Special Characters.");
        } */
 
        return isValid;
    }
    function process(date)
    {
    	   var parts = date.split("/");
    	   return new Date(parts[2], parts[1] - 1, parts[0]);
    }
    function Check_Date_Suspendedto() {
    	   var start_date = document.getElementById("date5");
        var End_date = document.getElementById("date6");
        
        var date1 = document.login.date5.value;
        var date2 = document.login.date6.value;
            	if(process(date2) < process(date1))
        {
          // alert(date2 + 'is later than ' + date1);
           alert("You entered an invalid date. Please repeat again");
           document.getElementById("date6").value="";
           return false;
       }
            	else
         
           return true;
       

    }

    
    function Select_Date(){
    	 var val2=document.getElementById('ddl_Status').value;
//alert("2="+val2);
if(val2=="R")
	{
	document.getElementById('ResignData').style.display='table-row';

	}
if(val2=="S")
{
document.getElementById('SusData').style.display='table-row';

}
 		if (val2!="R") 
 		{
 			
 			document.getElementById('ResignData').style.display = 'none';
 		}
 		
 		if (val2!="S") 
 		{
 			
 			document.getElementById('SusData').style.display = 'none';
 		}
    }
    
    function Check_Date() {
    	//alert("check date");

    	 var start_date = document.getElementById("demo1");
          var date1 = document.login.demo1.value;
         
         if(date1 == '')
         {
         alert('Enter the DOB');
         return false;
         }
         
          var parts = date1.split("/");
         var day = parseInt(parts[0], 10);
         //alert(day);
         var month = parseInt(parts[1], 10);
         var year = parseInt(parts[2], 10);
         
         
         var monthLength = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];

         // Adjust for leap years
         if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
             monthLength[1] = 29;
         
        
         if(year<=1000 || year >= 3000)
    	 {
    	 //alert(yea);
    	 alert('Enter valid Year');
    	 document.getElementById("demo1").value="";
         return false;
    	 }
         

         if(month==0 || month > 12 )
        	 {
        	 alert(month);
        	 alert('Enter valid month');
        	 document.getElementById("demo1").value="";
             return false;
        	 }
           if(day > monthLength[month - 1] )
        	{
        	 alert(day);
        	 alert('Enter valid day');
        	 document.getElementById("demo1").value="";
             return false;
        	
        	} 
    	
       
           //alert ("Will Proceed");
           return true;
       

    }

    function Check_Date2() {
    	//alert("check date");

    	 var start_date = document.getElementById("date3");
          var date1 = document.login.date3.value;
         
         if(date1 == '')
         {
         alert('Enter the Joining Date');
         return false;
         }
         
          var parts = date1.split("/");
         var day = parseInt(parts[0], 10);
         //alert(day);
         var month = parseInt(parts[1], 10);
         var year = parseInt(parts[2], 10);
         
         
         var monthLength = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];

         // Adjust for leap years
         if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
             monthLength[1] = 29;
         
        
         if(year<=1000 || year >= 3000)
    	 {
    	 //alert(yea);
    	 alert('Enter valid Year');
    	 document.getElementById("date3").value="";
         return false;
    	 }
         

         if(month==0 || month > 12 )
        	 {
        	 alert(month);
        	 alert('Enter valid month');
        	 document.getElementById("date3").value="";
             return false;
        	 }
           if(day > monthLength[month - 1] )
        	{
        	 alert(day);
        	 alert('Enter valid day');
        	 document.getElementById("date3").value="";
             return false;
        	
        	} 
    	
       
           //alert ("Will Proceed");
           return true;
       

    }

    function Check_Date3() {
    	//alert("check date");

    	 var start_date = document.getElementById("date4");
          var date1 = document.login.date4.value;
         
         if(date1 == '')
         {
         alert('Enter the Resigned Date');
         return false;
         }
         
          var parts = date1.split("/");
         var day = parseInt(parts[0], 10);
         //alert(day);
         var month = parseInt(parts[1], 10);
         var year = parseInt(parts[2], 10);
         
         
         var monthLength = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];

         // Adjust for leap years
         if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
             monthLength[1] = 29;
         
        
         if(year<=1000 || year >= 3000)
    	 {
    	 //alert(yea);
    	 alert('Enter valid Year');
    	 document.getElementById("date4").value="";
         return false;
    	 }
         

         if(month==0 || month > 12 )
        	 {
        	 alert(month);
        	 alert('Enter valid month');
        	 document.getElementById("date4").value="";
             return false;
        	 }
           if(day > monthLength[month - 1] )
        	{
        	 alert(day);
        	 alert('Enter valid day');
        	 document.getElementById("date4").value="";
             return false;
        	
        	} 
    	
       
           //alert ("Will Proceed");
           return true;
       

    }

    function Check_Date4() {
    	//alert("check date");

    	 var start_date = document.getElementById("date5");
          var date1 = document.login.date5.value;
          var date2 = document.login.date6.value;
         
         if(date1 == '')
         {
         alert('Enter the Suspened Date from');
         return false;
         }
         
          var parts = date1.split("/");
         var day = parseInt(parts[0], 10);
         //alert(day);
         var month = parseInt(parts[1], 10);
         var year = parseInt(parts[2], 10);
         
         
         var monthLength = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];

         // Adjust for leap years
         if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
             monthLength[1] = 29;
         
        
         if(year<=1000 || year >= 3000)
    	 {
    	 //alert(yea);
    	 alert('Enter valid Year');
    	 document.getElementById("date5").value="";
         return false;
    	 }
         

         if(month==0 || month > 12 )
        	 {
        	 alert(month);
        	 alert('Enter valid month');
        	 document.getElementById("date5").value="";
             return false;
        	 }
           if(day > monthLength[month - 1] )
        	{
        	 alert(day);
        	 alert('Enter valid day');
        	 document.getElementById("date5").value="";
             return false;
        	
        	} 
    	
           if(date1 !='' && date2 !='')
   		{
   		Check_Date_Suspendedto();
   		}
           //alert ("Will Proceed");
           return true;
       

    }

    function Check_Date5() {
    	//alert("check date");

    	 var start_date = document.getElementById("date6");
          var date1 = document.login.date6.value;
          var date2 = document.login.date5.value;
         
         if(date1 == '')
         {
         alert('Enter the Suspened Date to');
         return false;
         }
         
          var parts = date1.split("/");
         var day = parseInt(parts[0], 10);
         //alert(day);
         var month = parseInt(parts[1], 10);
         var year = parseInt(parts[2], 10);
         
         
         var monthLength = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];

         // Adjust for leap years
         if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
             monthLength[1] = 29;
         
        
         if(year<=1000 || year >= 3000)
    	 {
    	 //alert(yea);
    	 alert('Enter valid Year');
    	 document.getElementById("date6").value="";
         return false;
    	 }
         

         if(month==0 || month > 12 )
        	 {
        	 alert(month);
        	 alert('Enter valid month');
        	 document.getElementById("date6").value="";
             return false;
        	 }
           if(day > monthLength[month - 1] )
        	{
        	 alert(day);
        	 alert('Enter valid day');
        	 document.getElementById("date6").value="";
             return false;
        	
        	} 
    	if(date1 !='' && date2 !='')
    		{
    		Check_Date_Suspendedto();
    		}
       
           //alert ("Will Proceed");
           return true;
       

    }
  
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
    	

    	Select_Date();
    	

    });
    </script>

    <script type="text/javascript">
    function decimal_Values(e) {
        var srcElement = (e.srcElement) ? e.srcElement : e.target;
        if (document.getElementById(srcElement.id).value.indexOf(".") != -1 && (String.fromCharCode(e.keyCode) == "." || String.fromCharCode(e.which) == ".")) {
            return false;
        }
        if (document.getElementById(srcElement.id).value == ".") {
            document.getElementById(srcElement.id).value = "0.";
        }
        if ([e.keyCode || e.which] == 8) //this is to allow backspace
            return true;
        if ([e.keyCode || e.which] == 46) //this is to allow Delete
            return true;
        if ([e.keyCode || e.which] == 9) //this is to allow tab
            return true;
        if (String.fromCharCode(e.keyCode) == "." || String.fromCharCode(e.which) == ".") //this is to allow .
            return true;
        if ([e.keyCode || e.which] == 37) //left arrow .
            return true;
        if ([e.keyCode || e.which] == 39) //right arrow .
            return true;
        if ([e.keyCode || e.which] == 16) //shift .
            return true;

            }
    
    function Check()
    {
    	//alert("1");
    	
    	  var br_string=document.getElementById('demo1').value;
    	 // alert(br_string);
    	  var datePat=/^(\d{1,2})\/(\d{1,2})\/(\d{4})$/;
    	  var matchArray = br_string.match(datePat);
    	 // alert(matchArray);
    	  month = matchArray[2];
    	//  alert(month);
    	  if (month < 1 || month > 12) { // check month range
    		  alert("Month must be between 1 and 12");
    		  document.getElementById('demo1').value="";
    		  return false;
    		 }
    	  else
    		  return true;
    	
    }
   


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
	 //alert('onload works');
	 Select_Date();
	   /* var val2=document.getElementById('ddl_Status').value;
	   alert(val2);
	    if(val2=="R")
		{
		document.getElementById('ResignData').style.display='table-row';

		}
	if(val2=="S")
	{
	document.getElementById('SusData').style.display='table-row';

	}
		if (val!="R") 
		{
			
			document.getElementById('ResignData').style.display = 'none';
		}
		
		if (val!="S") 
		{
			
			document.getElementById('SusData').style.display = 'none';
		}
		*/	

            	
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
 
 function Confirm_Details()
 {
	 var Gender,Marital,Login_Type,Access_Level,Status,User_Level,Subakalyan,
	 Transaction_Edit,Designation,Password,Mobile_No;
	 
	  var Gender=document.getElementById('ddl_Gender').value;  
	  var Marital=document.getElementById('ddl_Marital_Status').value;
	  var Login_Type=document.getElementById('ddl_Login_type').value;
	  var Access_Level=document.getElementById('ddl_Access_Level').value;
	  var Status=document.getElementById('ddl_Status').value;
	  var User_Level=document.getElementById('ddl_User_Level').value;
	  var Subakalyan=document.getElementById('ddl_Subakalyan').value;
	  var Transaction_Edit=document.getElementById('ddl_Transaction_Edit').value;
	  var Designation=document.getElementById('txt_Designation').value;
	  var Password=document.getElementById('txt_Password').value;
	  var Mobile_No=document.getElementById('txt_Mobile_number').value;
	  
	  if(Gender=="Select")
		{
			  alert ("Select Gender");
			  return false;
		}
	  if(Marital=="Select")
		{
			  alert ("Select Marital status");
			  return false;
		}
	  if(Login_Type=="Select")
		{
			  alert ("Select Login Type");
			  return false;
		}
	  if(Access_Level=="Select")
		{
			  alert ("Select Access_Level");
			  return false;
		}
	  if(Status=="Select")
		{
			  alert ("Select Status");
			  return false;
		}
	  if(User_Level=="Select")
		{
			  alert ("Select User Level");
			  return false;
		}

	  if(Subakalyan=="Select")
		{
			  alert ("Select Subakalyan");
			  return false;
		}
	  if(Transaction_Edit=="Select")
		{
			  alert ("Select Transaction Edit");
			  return false;
		}
	  if(Designation=="")
		{
			  alert ("Enter Designation");
			  return false;
		}
	  if(Password=="")
		{
			  alert ("Enter Password");
			  return false;
		}
	  if(Mobile_No=="")
		{
			  alert ("Enter Mobile No");
			  return false;
		}

		
		return true;
	  
	  
 }
 
 function OpenPopup6()
 {
 	
 	var path="${pageContext.servletContext.contextPath}";
 	var snnl4 = "${pageContext.request.contextPath}";
 	//alert(snnl4);
 	///Account_Details/{Account_No_Key}
 	var url=path+"/SetPermission/";
 	window.location=url;
 }

 function OpenPopup7()
 {
 	
 	var path="${pageContext.servletContext.contextPath}";
 	var snnl4 = "${pageContext.request.contextPath}";
 	//alert(snnl4);
 	///Account_Details/{Account_No_Key}
 	var url=path+"/Permission_Sett/";
 	window.location=url;
 }
 
 function getUser_Name(){
	 
		//alert("1");
			
			var user_name=document.getElementById('txt_User_name').value;
			// alert("user-"+user_name);
			$.ajax({
				type: "POST",
				url: "${pageContext.servletContext.contextPath}/find_username.htm",
				data: 'User_name='+user_name,
				success: function(response){
					$('#result').html(response);
					//alert(response);
					 var temp=response.split("-");
					
					 $("#txt_Interest_Rate").val(temp[0]);
					//alert(temp[0]);
				
					    if(temp[0] == 1)
						{
					    	alert("User Name already exist");
					    	document.getElementById('txt_User_name').value="";
					    	return false;
						}
				}
				
			});
			}

 
 function getEmpId(){
	 
		//alert("1");
			
			var cat=document.getElementById('txt_Category').value;
			// alert("user-"+user_name);
			$.ajax({
				type: "POST",
				url: "${pageContext.servletContext.contextPath}/find_EmpId.htm",
				data: 'cat='+cat,
				success: function(response){
					$('#result').html(response);
					//alert(response);
					 var temp=response;
					
					 $("#txt_Emp_Id").val(temp);
					
				}
				
			});
			}
         
    </script>
<script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  $( function() {
	    $( "#datepicker2" ).datepicker();
	  } );
  </script>
  
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
  
</head>

<body >
	<div id="page-wrap">
		<center>
		<table width="95%">
			<tr>
				<td><%@include file="/WEB-INF/jsp/Header.jsp" %>
				</td>
			</tr>
			<tr>
				<td>

					<table width="100%" style="height: 550px;width:1100px;" cellpadding="0"
						cellspacing="0">
						<colgroup>
							<col width="210px" />
							<col width="2px" />
							<col />
						</colgroup>
						<tr>
						<td id="leftbar">
							<%@include file="/WEB-INF/jsp/LeftBar4.jsp" %>
							</td>

							<td>&nbsp;</td>			
			<td class="All_Round" style="vertical-align: top"><form:form
					action="${pageContext.servletContext.contextPath}/SavePermissionBranch" modelAttribute="Permission"
					commandName="Permission">
					
					<table class="tbl_Content">
						
					
					<tr>
							<th colspan="2">Branch User Permissions</th>
							
						</tr>
					</table>

					<table class="tbl_Content">
						<colgroup>
							<col width="100px" />
							
							<col />
						</colgroup>
						
						<td>User Details
										</td>
										<td>
										<form:input path="User_name" id="txt_User_name" Style="width:200px" Class="Tbox_R" value="${User_name}" required="true" onchange="getUser_Name();" title="Enter User name" readonly="true"/>
										</td>

<td align="right"><input type="Submit" value="Update" class="btn_Blue" name="Save_Individual" id="Save_Button" onclick="return OpenPopup();"></td>
		
						<TD ALIGN="CENTER" COLSPAN="2">
						<font color="Red">${message}</font></TD>
						<tr>
										<td colspan="4">
												<hr
													style="background-color:green;border: 0; height: 1px; background: #333; background-image: linear-gradient(to right, #ccc, #333, #ccc); " />
											</td>
										</tr>
										
										<td>
									Permission Level 
										</td>
										<td>
										<form:select path="PermissionLevel" id="ddl_PermissionLevel" Style="width:200px">
										<form:option value="C">Custom</form:option>
										<form:option value="B">Basic</form:option>
										<form:option value="M">Manager</form:option>
										<form:option value="A">Admin</form:option>
													
												</form:select>
										</td>
										</tr>
										
									
<tr>
							<td>Branch Permission </td>
							<td><input type="Checkbox" name="SelectAll_Branch2"
														id="Select_All_Branch2"  onclick="SelectAllCheckBoxBranch2();"/>ALL-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:checkboxes class="Brach_Permission_Data" items="${BranchList}"
									path="Branch_Operation_Types" /> 
									
						            </td>
						</tr>



<tr>
										<th colspan="5">Page Pemission<br />
											<hr />
										</th>
						<tr>
							<td>Page</td>
							<td>Operation Types</td>
						
						</tr>


						<tr>
							<td>Customer </td>
							<td width="60%"><input type="Checkbox" name="SelectAll_Cus"
														id="Select_All" onclick="SelectAllCheckBox1();" />ALL-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:checkboxes class="Cus_Data" items="${OperationTypes}"
									path="CT_Operation_Types" /> <!-- 
                     View<form:checkbox path="CT_Operation_Types" value="View"/>
                     Save<form:checkbox path="CT_Operation_Types" value="Save"/>
                     Update<form:checkbox path="CT_Operation_Types" value="Update"/>
                    Delete <form:checkbox path="CT_Operation_Types" value="Delete"/>
                     Verify1<form:checkbox path="CT_Operation_Types" value="Verify1"/>
                      Verify2<form:checkbox path="ST_Operation_Types" value="Verify2"/>
                    Reports <form:checkbox path="CT_Operation_Types" value="Reports"/>
                     
                     -->
						</tr>


						<tr>
							<td>Share Master </td>
							<td><input type="Checkbox" name="SelectAll_Share" id="Select_All_Share" onclick="SelectAllCheckBox2();" />ALL-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:checkboxes class="Share_Data" items="${OperationTypes}" path="SM_Operation_Types" />
							
							
							 <!-- 
                     
                        View<form:checkbox path="SM_Operation_Types" value="View"/>
                     Save<form:checkbox path="SM_Operation_Types" value="Save"/>
                     Update<form:checkbox path="SM_Operation_Types" value="Update"/>
                    Delete <form:checkbox path="SM_Operation_Types" value="Delete"/>
                    Verify1<form:checkbox path="CT_Operation_Types" value="Verify1"/>
                      Verify2<form:checkbox path="ST_Operation_Types" value="Verify2"/>
                    Reports <form:checkbox path="SM_Operation_Types" value="Reports"/>
                    -->
                    
                    
                    </td>
						</tr>
						<tr>
							<td>Savings Deposit </td>
							<td><input type="Checkbox" name="SelectAll_Save"
														id="Select_All_Save" onclick="SelectAllCheckBox3();" />ALL-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:checkboxes class="Save_Data" items="${OperationTypes}"
									path="SD_Operation_Types" /> 
									
									<!-- 
                         View<form:checkbox path="SD_Operation_Types" value="View"/>
                     Save<form:checkbox path="SD_Operation_Types" value="Save"/>
                     Update<form:checkbox path="SD_Operation_Types" value="Update"/>
                    Delete <form:checkbox path="SD_Operation_Types" value="Delete"/>
                    Verify1<form:checkbox path="CT_Operation_Types" value="Verify1"/>
                      Verify2<form:checkbox path="ST_Operation_Types" value="Verify2"/>
                    Reports <form:checkbox path="SD_Operation_Types" value="Reports"/>
                    -->
                    
                    </td>
						</tr>
						<tr>
							<td>Fixed Deposit </td>
							<td><input type="Checkbox" name="SelectAll_FD"
														id="Select_All_FD" onclick="SelectAllCheckBox4();" />ALL-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:checkboxes class="FD_Data" items="${OperationTypes}"
									path="FD_Operation_Types" /> 
									
									<!-- 
                         View<form:checkbox path="FD_Operation_Types" value="View"/>
                     Save<form:checkbox path="FD_Operation_Types" value="Save"/>
                     Update<form:checkbox path="FD_Operation_Types" value="Update"/>
                    Delete <form:checkbox path="FD_Operation_Types" value="Delete"/>
                     Verify1<form:checkbox path="CT_Operation_Types" value="Verify1"/>
                      Verify2<form:checkbox path="ST_Operation_Types" value="Verify2"/>
                    Reports <form:checkbox path="FD_Operation_Types" value="Reports"/>
                    -->
                    
                    </td>
						</tr>
						<tr>
							<td>Recurring Deposit </td>
							<td><input type="Checkbox" name="SelectAll_RD"
														id="Select_All_RD" onclick="SelectAllCheckBox5();" />ALL-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:checkboxes class="RD_Data" items="${OperationTypes}"
									path="RD_Operation_Types" /> 
									
									<!-- 
                         View<form:checkbox path="RD_Operation_Types" value="View"/>
                     Save<form:checkbox path="RD_Operation_Types" value="Save"/>
                     Update<form:checkbox path="RD_Operation_Types" value="Update"/>
                    Delete <form:checkbox path="RD_Operation_Types" value="Delete"/>
                     Verify1<form:checkbox path="CT_Operation_Types" value="Verify1"/>
                      Verify2<form:checkbox path="ST_Operation_Types" value="Verify2"/>
                    Reports <form:checkbox path="RD_Operation_Types" value="Reports"/>
                    -->
                    </td>
						</tr>
						<tr>
							<td>Jewel Loan </td>
							<td><input type="Checkbox" name="SelectAll_JL"
														id="Select_All_JL" onclick="SelectAllCheckBox6();" />ALL-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:checkboxes  class="JL_Data" items="${OperationTypes}" path="JL_Operation_Types" />
														
														 <!-- 
                         View<form:checkbox path="JL_Operation_Types" value="View"/>
                     Save<form:checkbox path="JL_Operation_Types" value="Save"/>
                     Update<form:checkbox path="JL_Operation_Types" value="Update"/>
                    Delete <form:checkbox path="JL_Operation_Types" value="Delete"/>
                     Verify1<form:checkbox path="CT_Operation_Types" value="Verify1"/>
                      Verify2<form:checkbox path="ST_Operation_Types" value="Verify2"/>
                    Reports <form:checkbox path="JL_Operation_Types" value="Reports"/>
                    -->
                    </td>
						</tr>
						<tr>
							<td>Other Loans </td>
							<td><input type="Checkbox" name="SelectAll_OL"
														id="Select_All_OL" onclick="SelectAllCheckBox7();" />ALL-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:checkboxes class="OL_Data" items="${OperationTypes}"
									path="OL_Operation_Types" />
									
									 <!-- 
                    	                         View<form:checkbox path="OL_Operation_Types" value="View"/>
                     Save<form:checkbox path="OL_Operation_Types" value="Save"/>
                     Update<form:checkbox path="OL_Operation_Types" value="Update"/>
                    Delete <form:checkbox path="OL_Operation_Types" value="Delete"/>
                     Verify1<form:checkbox path="CT_Operation_Types" value="Verify1"/>
                      Verify2<form:checkbox path="ST_Operation_Types" value="Verify2"/>
                    Reports <form:checkbox path="OL_Operation_Types" value="Reports"/>
                    -->
                    </td>
						</tr>
						<tr>
							<td>Journal </td>
							<td><input type="Checkbox" name="SelectAll_JO"
														id="Select_All_JO" onclick="SelectAllCheckBox8();" />ALL-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:checkboxes class="JO_Data" items="${OperationTypes}" path="JO_Operation_Types" /> 
							
							<!-- 
                        View<form:checkbox path="JO_Operation_Types" value="View"/>
                     Save<form:checkbox path="JO_Operation_Types" value="Save"/>
                     Update<form:checkbox path="JO_Operation_Types" value="Update"/>
                    Delete <form:checkbox path="JO_Operation_Types" value="Delete"/>
                    Verify1<form:checkbox path="CT_Operation_Types" value="Verify1"/>
                      Verify2<form:checkbox path="ST_Operation_Types" value="Verify2"/>
                    Reports <form:checkbox path="JO_Operation_Types" value="Reports"/>
                    -->
                    </td>
						</tr>
						<tr>
							<td>Settings </td>
							<td><input type="Checkbox" name="SelectAll_ST" id="Select_All_ST" onclick="SelectAllCheckBox9();" />ALL-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:checkboxes class="ST_Data" items="${OperationTypes}"
									path="ST_Operation_Types" /> 
									<!-- 
                        View<form:checkbox path="ST_Operation_Types" value="View"/>
                     Save<form:checkbox path="ST_Operation_Types" value="Save"/>
                     Update<form:checkbox path="ST_Operation_Types" value="Update"/>
                    Delete <form:checkbox path="ST_Operation_Types" value="Delete"/>
                    Verify1<form:checkbox path="CT_Operation_Types" value="Verify1"/>
                      Verify2<form:checkbox path="ST_Operation_Types" value="Verify2"/>
                    Reports <form:checkbox path="ST_Operation_Types" value="Reports"/>
                    -->
                    </td>
						</tr>
						<tr>
							<td>Transactions </td>
							<td><input type="Checkbox" name="SelectAll_TR"
														id="Select_All_TR" onclick="SelectAllCheckBox10();" />ALL-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:checkboxes class="TR_Data" items="${OperationTypes}" path="TR_Operation_Types" /> 
							
							<!-- 
                        View<form:checkbox path="TR_Operation_Types" value="View"/>
                     Save<form:checkbox path="TR_Operation_Types" value="Save"/>
                     Update<form:checkbox path="TR_Operation_Types" value="Update"/>
                    Delete <form:checkbox path="TR_Operation_Types" value="Delete"/>
                    Verify1<form:checkbox path="CT_Operation_Types" value="Verify1"/>
                      Verify2<form:checkbox path="ST_Operation_Types" value="Verify2"/>
                    Reports <form:checkbox path="TR_Operation_Types" value="Reports"/>
                    -->
                    
                    </td>
						</tr>
						<tr>
							<td>Inter Branch </td>
							<td><input type="Checkbox" name="SelectAll_IB"
														id="Select_All_IB" onclick="SelectAllCheckBox11();" />ALL-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:checkboxes class="IB_Data" items="${OperationTypes}"
									path="IB_Operation_Types" /> 
									
						            </td>
						</tr>

					<tr>
							<td>300 UP </td>
							<td><input type="Checkbox" name="SelectAll_300UP"
														id="Select_All_300UP" onclick="SelectAllCheckBox12();" />ALL-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:checkboxes class="UP300_Data" items="${OperationTypes}"
									path="UP300_Operation_Types" /> 
									
						            </td>
						</tr>
						
						

						
					</table>
				</form:form></td>
				
				
	                                                  
                                                    
                                                    
                                                    
                                                    
  <!-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->       


 <!-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->                                                  
   <%@include file="/WEB-INF/jsp/Footer.jsp"%>


