<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EOM List Current Month</title>
</head>
<body>

</body>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
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
<style>
ol, ul {
	list-style: none;
}

.clearfix {
	clear: both;
}

.wrap {
	font-family: 'Droid Sans', sans-serif;;
	width: 100%;
	margin-top: -5px;
	margin-bottom: 3px;
}

nav {
	background: -webkit-gradient(linear, center top, center bottom, from(#fff),
		to(#ccc));
	background-image: linear-gradient(#fff, #ccc);
	border-radius: 6px;
	box-shadow: 0px 0px 4px 2px rgba(0, 0, 0, 0.4);
	position: relative;
}

.menu li {
	float: left;
	position: relative;
}

.menu li a {
	color: #444;
	display: block;
	font-size: 12px;
	line-height: 20px;
	padding: 1px 4px;
	margin: 8px 8px;
	vertical-align: middle;
	text-decoration: none;
}

.menu li a:hover {
	background: -webkit-gradient(linear, center top, center bottom, from(#ededed),
		to(#fff));
	background-image: linear-gradient(#ededed, #fff);
	border-radius: 12px;
	box-shadow: inset 0px 0px 1px 1px rgba(0, 0, 0, 0.1);
	color: #222;
}

.menu ul {
	position: absolute;
	left: -9999px;
	list-style: none;
	opacity: 0;
	transition: opacity 1s ease;
}

.menu ul li {
	float: none;
}

.menu ul a {
	white-space: nowrap;
}

/* Displays the dropdown on hover and moves back into position */
.menu li:hover ul {
	background: rgba(255, 255, 255, 0.7);
	border-radius: 0 0 6px 6px;
	box-shadow: inset 0px 2px 4px rgba(0, 0, 0, 0.4);
	left: 5px;
	opacity: 1;
}

/* Persistant Hover State */
.menu li:hover a {
	background: -webkit-gradient(linear, center top, center bottom, from(#ccc),
		to(#ededed));
	background-image: linear-gradient(#ccc, #ededed);
	border-radius: 12px;
	box-shadow: inset 0px 0px 1px 1px rgba(0, 0, 0, 0.1);
	color: #222;
}

.menu li:hover ul a {
	background: none;
	border-radius: 0;
	box-shadow: none;
}

.menu li:hover ul li a:hover {
	background: -webkit-gradient(linear, center top, center bottom, from(#eee),
		to(#fff));
	background-image: linear-gradient(#ededed, #fff);
	border-radius: 12px;
	box-shadow: inset 0px 0px 4px 2px rgba(0, 0, 0, 0.3);
}
</style>

<style>
.tbl_Content {
	padding: 4px 2px 2px 2px;
	width: 100%;
	font-family: Tahoma;
}

.tbl_Content td {
	vertical-align: top;
	padding: 5px 2px 5px 10px;
	font-size: 14px;
}

.tbl_Content th {
	padding: 4px 2px 4px 5px;
	font-size: 16px;
	text-align: left;
}

.Left_Round {
	-moz-border-radius-topleft: 10px;
	-webkit-border-top-left-radius: 10px;
	border: 1px solid;
	/*border-color:Orange;*/
}

.All_Round {
	height: 100px;
	-moz-border-radius: 10px;
	-webkit-border-radius: 10px;
	border-radius: 10px;
	border: 1px solid #2999D6;
}

#leftbar {
	border-radius: 10px;
	background-color: #0B3B17;
	vertical-align: top;
	margin-right: 10px height: auto;
}

.roundcont {
	width: 250px;
	background-color: #f90;
	color: #fff;
}

.roundcont p {
	margin: 0 10px;
}

.roundtop {
	background: url(tr.gif) no-repeat top right;
}

.roundbottom {
	background: url(br.gif) no-repeat top right;
}

img.corner {
	width: 15px;
	height: 15px;
	border: none;
	display: block !important;
}

.PopupBody {
	float: left;
	background-color: #fafafa;
	height: 400px;
	overflow: scroll;
}

.PopupHeader {
	background-color: #fafafa;
	width: 100%;
	padding: 5px 0px 5px 0px;
	text-align: right;
	font-size: 12px;
}

.Side_Menu {
	width: 100%;
}

.Side_Menu td {
	vertical-align: top;
	padding: 5px 0px 5px 15px;
	color: White;
}

.Side_Menu li {
	vertical-align: top;
	padding: 5px 0px 5px 15px;
	color: White;
	float: left;
	position: relative;
	line-height: 1.5em;
	width: 10em;
}

.Side_Menu li a {
	display: block;sha
	/*border-right:1px solid #fff;
	background:#E0F574;*/
	color: #FFFFFF;
	text-decoration: none;
}

.Side_Menu li a:hover {
	background-color: #5798B4;
	color: #F8FBF4;
}

#page-wrap {
	width: 100%;
	margin: 0 auto;
}

.Btn_Row {
	width: 100%;
	/*background-color:Fuchsia;*/
	text-align: center;
	padding: 10px 0px 10px 0px;
}

.sidemenu {
	width: 150px;
	border: none;
}


.sidemenu li a {
	height: 18px;
	text-decoration: none;
}
/*Top sidemenu Item (Header and rounded corners)*/
.sidemenu li.top a:link, .sidemenu li.top a:visited {
	color: #828282;
	display: block;
	background: url(images/menuTop.png);
	background-repeat: no-repeat;
	padding: 1px 0 1px 0;
	font-size: 1em;
	font-weight: bold;
	text-align: center;
}

/* Uncomment this if you want the header to be an interactive link
.sidemenu li.top a:hover {
  color: #828282;
  background: url(images/menuTop.png) 0 -22px;
}
.sidemenu li.top a:active {
  color: #26370A;
  background: url(images/menuTop.png) 0 -44px;
}*/

/*sidemenu Item Middle*/
.sidemenu li a:link, .sidemenu li a:visited {
	color: #5E7830;
	display: block;
	background: url(images/menuMiddle.png);
	background-repeat: no-repeat;
	padding: 1px 0 1px 20px;
	font-size: 0.8em;
}

.sidemenu li a:hover {
	color: #FFFFFF;
	background: url(images/menuMiddle.png) 0 -22px;
}

.sidemenu li a:active {
	color: #FFFFFF;
	background: url(images/menuMiddle.png) 0 -44px;
}

/*Bottom sidemenu Item (rounded corners)*/
.sidemenu li.bottom a:link, .sidemenu li.bottom a:visited {
	color: #5E7830;
	display: block;
	background: url(images/menuBottom.png);
	background-repeat: no-repeat;
	padding: 1px 0 1px 20px;
	font-size: 0.8em;
}

.sidemenu li.bottom a:hover {
	color: #FFFFFF;
	background: url(images/menuBottom.png) 0 -22px;
}

.sidemenu li.bottom a:active {
	color: #FFFFFF;
	background: url(images/menuBottom.png) 0 -44px;
}

.menu1 {
	width: 100%;
	height: 150px;
	background: white;
}

.menu2 {
	width: 100%;
	height: 150px;
	background: white;
}

.menu3 {
	width: 100%;
	height: 150px;
	background: white;
}

.icons {
	width: 170px;
	height: 125px;
	margin-left: 50px;
	margin-top: 12px;
	float: left;
	font-size: 12px;
	border-radius: 1px 15px 1px 15px;
	color: White;
	padding: 0px 10px 10px 10px
}

.icons a {
	text-decoration: none;
	color: White;
}
/*#menu ul {
	list-style:none;
	padding:0;
	margin:0;
}
#menu li {
	float:left;
	position:relative;
	line-height: 2.5em;
	width: 10em;
}

#menu a {
	display:block;
	border-right:1px solid #fff;
	background:#E0F574;
	color:#3B3B3B;
	text-decoration:none;
	padding:0 10px;
}
#menu a:hover {
	background-color:#5798B4;
	color:#fff;
}
#menu ul {
	border-top:1px solid #fff;
}
#menu ul a {
	border-right:none;
	border-right:1px solid #fff;
	border-bottom:1px solid #fff;
	border-left:1px solid #fff;
	background:#AEC245;
}

#menu ul {
	position:absolute;
	margin-top:-1em;
	margin-left:.5em;
	display:none;
}
#menu li ul {
	margin-top:-3em;
	margin-left:7em;
}*/
</style>







<!--  <script>
  
window.location.hash="no-back-button";
window.location.hash="Again-No-back-button";//again because google chrome don't insert first hash into history
window.onhashchange=function(){window.location.hash="no-back-button";}
</script>-->
<style>
#leftbar {
	border-radius: 10px;
	background-color: #0B3B17;
	vertical-align: top;
	margin-right: 10px height: auto;
	font-family: 'Droid Sans', sans-serif;;
}

.error {
	color: green;
	font-weight: bold;
	font-family: 'Droid Sans', sans-serif;;
	font-size: 12px;
}
</style>

<script type="text/javascript">
         function decimal_Values(e)
         {
            var srcElement = (e.srcElement)?e.srcElement:e.target;
            if (document.getElementById(srcElement.id).value.indexOf(".") != -1 && (String.fromCharCode(e.keyCode)=="." || String.fromCharCode(e.which)==".")){
                return false;
            }
            if (document.getElementById(srcElement.id).value == ".")
            {
                document.getElementById(srcElement.id).value = "0.";
            }
            if ([e.keyCode||e.which]==8) //this is to allow backspace
                return true;
            if ([e.keyCode||e.which]==46) //this is to allow Delete
                return true;    
            if ([e.keyCode||e.which]==9) //this is to allow tab
                return true;
            if (String.fromCharCode(e.keyCode)=="." || String.fromCharCode(e.which)==".") //this is to allow .
                return true;
            if ([e.keyCode||e.which]==37) //left arrow .
                return true;
            if ([e.keyCode||e.which]==39) //right arrow .
                return true;
            if ([e.keyCode||e.which]==16) //shift .
                return true;
           
         }

         function Number_Only(e)
         {
            if ([e.keyCode||e.which]==8) //this is to allow backspace
                return true;
            if ([e.keyCode||e.which]==9) //this is to allow tab
                return true;
            if ([e.keyCode] == 46) //this is to allow Delete
                return true;    
            if ([e.keyCode||e.which]==37) //left arrow .
                return true;
            if ([e.keyCode||e.which]==39) //right arrow .
                return true;
            if ([e.keyCode||e.which]==16) //shift .
                return true;

         }
         
         function Alpha_Only(e)
         {
            if ([e.keyCode||e.which]==8) //this is to allow backspace
                return true;
            if ([e.keyCode||e.which]==9) //this is to allow tab
                return true;
            if ([e.keyCode||e.which]==37) //left arrow .
                return true;
            if ([e.keyCode||e.which]==39) //right arrow .
                return true;
            if ([e.keyCode||e.which]==16) //shift .
                return true;

            if ([e.keyCode||e.which] < 64 || [e.keyCode||e.which] > 122 || ([e.keyCode||e.which] > 90 && [e.keyCode||e.which] < 97))
                e.preventDefault? e.preventDefault() : e.returnValue = false;
        }
    </script>
<script type="text/javascript" language="javascript">

        function getValue() {
           
           
           window.close();
        }
        
        function OpenPopup2()
        {

        	window.close();
        }  
        
        
        
        
        
        </script>



</head>
<body>
	<div id="page-wrap">
		<table width="100%">
			
			<tr>
				<td>

					<table width="100%" style="height: 450px" cellpadding="0"
						cellspacing="0">
						
						<tr>
							
							<td class="All_Round" style="vertical-align: top">

								<table>
									
									<tr>
										<th colspan="2">EOM List Current Month<br />
											<hr />
										</th>
									</tr>


								



									<table border="2" width="100%" cellpadding="2" class="mGrid">
										
										<tr>
											<th><font size="2px">Branch Name</font></th>
											<th><font size="2px">Trans Date</font></th>
											<th><font size="2px">Particulars</font></th>
											<th><font size="2px">Amount</font></th>
											
											
										</tr>
										<c:forEach var="jd" items="${list}">
											<tr>
												<td><font size="2px" color="green"><c:out value="${jd.s2}" /></font></td>
												<td><font size="2px" color="green"><c:out value="${jd.s31}" /></font></td>
												<td><font size="2px" color="green"><c:out value="${jd.s33}" /></font></td>
												<td><font size="2px" color="green"><c:out value="${jd.s34}" /></font></td>
												
												
          <!--  <td style="${jd.s33}"><a onclick="OpenPopup2(${jd.s1});" href="#">Close</a></td>-->
				

											</tr>
										</c:forEach>
									</table>
									<br />
									</td>








									</tr>
									
									<tr>
										<td><font size="3px" color="Green">${message}</font></td>
																	  <td ><a onclick="OpenPopup2();" href="#"><font size="3px" color="Blue">Close</font></a></td>		
										
									</tr>
								</table>

							</td>
						</tr>

						</div>
</body>
</html>