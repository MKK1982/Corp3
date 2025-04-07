<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head >
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" />




  
    

    <link href="https://cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css" rel="stylesheet" />
    

    <link href="https://cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css" rel="stylesheet" />





 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css" />


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    
    <!-- Bootstrap 5 Bundle (includes Popper.js) -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>

    
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit"
    asyncdefer></script>
<script type="text/javascript">
    var onloadCallback = function () {
        grecaptcha.render('dvCaptcha', {
            'sitekey': '',
            'callback': function (response) {
                $.ajax({
                    type: "POST",
                    url: "Default/VerifyCaptcha",
                    data: "{response: '" + response + "'}",
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    success: function (r) {
                        var captchaResponse = jQuery.parseJSON(r.d);
                        if (captchaResponse.success) {
                            $("[id*=txtCaptcha]").val(captchaResponse.success);
                            $("[id*=rfvCaptcha]").hide();
                        } else {
                            $("[id*=txtCaptcha]").val("");
                            $("[id*=rfvCaptcha]").show();
                            var error = captchaResponse["error-codes"][0];
                            $("[id*=rfvCaptcha]").html("RECaptcha error. " + error);
                        }
                    }
                });
            }
        });
    };
</script>

    
 
    <style>
        #load {
            width: 100%;
            height: 100%;
            position: fixed;
            z-index: 9999;
            background: url("../img/Loading.gif") no-repeat center center rgba(0,0,0,0.25);
        }

        @media only screen and (max-width: 960px) {
            .col-xs-12 {
                display: flex;
                flex-direction: column-reverse;
            }
        }


        * {
            overflow-x: hidden;
        }

        .input-container {
            display: -ms-flexbox; /* IE10 */
            display: flex;
            width: 100%;
            margin-bottom: 15px;
        }

        .icon {
            padding: 10px;
            background: #273896;
            color: white;
            min-width: 50px;
            text-align: center;
        }

        .input-field {
            width: 100%;
            padding: 10px;
            outline: none;
        }

            .input-field:focus {
                border: 2px solid #273896;
            }

        .top-header li {
            margin: 10px 30px 0px;
        }

        .language-select {
            float: right;
            display: flex;
            height: 50px;
            align-items: center;
            font-size: 14px;
            color: #323232;
            font-weight: normal;
        }

            .language-select label {
                margin-right: 10px;
                display: flex;
                align-items: center;
                cursor: pointer;
            }

            .language-select input {
                vertical-align: middle;
                margin: 0 5px;
            }

        .top-header {
            background-color: #031521;
        }

        @media (max-width: 767px) {
            .d {
                display: none;
            }
        }

        @media (min-width: 767px) {
            .f {
                display: none;
            }
        }

        .bg {
            background-color: #F2F2F2;
        }

        .t {
            background-color: #EBEBEB;
            border-radius: 20px;
            box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
            color: black;
        }

            .t:hover {
                transition: 2s;
                background-color: whitesmoke;
                color: red;
                transform: translateX(-10px);
            }
    </style>
    <style>
        .ticker-wrapper {
            width: 100%;
            margin: 0 auto;
            overflow: hidden;
            white-space: nowrap;
            height: 3em;
            position: static;
            background-color: white;
        }

        .ticker-transition {
            display: inline-block;
            animation: marqueehorizontal 50s linear infinite;
        }

            .ticker-transition:hover {
                animation-play-state: paused;
            }



        .tickeritemcont--1 {
            position: relative;
            left: 0%;
            animation: swap 50s linear infinite;
        }

        .ticker-item {
            display: inline-block;
            padding: 0 1rem;
            font-size: 1.5em;
            color: black;
            font-weight: 800;
            font-family: sans-serif;
            color: red
        }

        .ticker-item1 {
            display: inline-block;
            padding: 0 1rem;
            font-size: 1.5em;
            color: black;
            font-weight: 800;
            font-family: sans-serif;
            color: blue;
        }
        /* Transition */
        @keyframes marqueehorizontal {
            0% {
                transform: translateX(0)
            }

            100% {
                transform: translateX(-100%)
            }
        }

        @keyframes swap {
            0%, 50% {
                left: 0%;
            }

            50.01%, 100% {
                left: 100%;
            }
        }
    </style>



    <script>
        function Op() { $('#pdwTPIN').modal('show'); }
    </script>
    <script>
        function myFunction() {
            var x = document.getElementById("passwordfield");
            if (x.type === "password") {
                x.type = "text";
            } else {
                x.type = "password";
            }
        }
    </script>
</head>
<body>
<c:if test="${not empty errorMessage}">
    <div class="alert alert-danger">
        <strong>Error:</strong> ${errorMessage}
    </div>
</c:if>

  	<form:form method="post" action="${pageContext.servletContext.contextPath}/Login" modelAttribute="MemberEntity">
  
             
        <div>
            <div id="load" style="visibility: hidden;"></div>
        
                    <div class="top-header">
                        <div class="row mt-2">
                            <div class="col-md-5  col-12 d-flex">
                                <div class="col-md-4">
                                    <img src="${pageContext.servletContext.contextPath}/resources/Images/blueray.png" style="height: 50px;" alt="logo">
                                </div>
                                <div class="col-md-4">
                                    <button type="button" class="btn text-white" style="background-color: #D2AE56;">JOIN US</button>
                                </div>
                                <div class="col-md-4">
                                    <a href=''>
                                        <i class="bi bi-facebook" style="font-size: xx-large; color: #026CDF;"></i></a>
                                    &nbsp; &nbsp; &nbsp;
                                    <a href=''>
                                        <i class="bi bi-youtube" style="font-size: xx-large; color: #F70000;"></i></a>
                                </div>
                            </div>
                            <div class="col-md-3 col-3 text-center mt-3 d text-white">
                                <i class="bi bi-envelope-fill" style="color:#D2AE56"></i>&nbsp; <b>Support@bluerayfintech.com</b>
                            </div>
                            <div class="col-md-2 col-3 text-center mt-3 d text-white">
                                <i class="bi bi-telephone-fill" style="color:#D2AE56"></i>&nbsp;<b>+919944923322</b>
                            </div>
                            <div class="col-md-2 col-3 mt-3 d text-center pe-4 text-white">
                                <input type="radio" name="language" id="1" /><b>&nbsp;English</b>
                                <input type="radio" name="language" id="2" /><b>&nbsp;Hindi</b>
                            </div>
                        </div>
                    </div>
                    <div class="row f">
                        <div class="col-md-12 text-end pe-4">
                            <input type="radio" name="language" id="1" /><b>&nbsp;English</b>
                            <input type="radio" name="language" id="2" /><b>&nbsp;Hindi</b>
                        </div>
                    </div>
                    <section class="mt-4">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="">
                                    <div class="ticker-wrapper">
                                        <div class="ticker-transition">
                                            <span class="tickeritemcont--1">
                                              
                                                        <span class="ticker-item" style="font-size: 22px"><b>Time for filing the bill on the portal is limited till 06.00 pm daily,</b></span>
                                                   
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row col-xs-12">
                                <div class="col-md-8 col-xs-12">
                                    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
                                        <div class="carousel-indicators">
                                            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                                            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                                            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                                        </div>
                                        <div class="carousel-inner">
                                          
                                                    <div class=''>
                                                        <img class="d-block w-100 img-fluid" style="max-height: 520px" src="${pageContext.servletContext.contextPath}/resources/CSS/siteadmin/images/Banner5.jpg" alt="First slide">
                                                    </div>
                                             
                                        </div>
                                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                            <span class="visually-hidden">Previous</span>
                                        </button>
                                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                            <span class="visually-hidden">Next</span>
                                        </button>
                                    </div>
                                </div>
                   <div class="col-md-4 col-12">
                                    <div class="container">
                                        <div class="row text-center">
                                            <a href="#" style="color: #273896; font-size: larger; text-decoration: none;">Login to Continue</a>
                                        </div>

                                                <div class="row text-center mt-4">
                                                    <div class="input-container">
                                                        <i class="bi bi-person-fill icon"></i>
                       <input type="text" class="input-field" id="regid" name="regId" path="regId" placeholder="Enter your Agent ID">
                                                    </div>
                                                </div>
                                                <div class="row text-center mt-4">
                                                    <div class="input-container">
                                                        <i class="bi bi-key-fill icon"></i>
                                 <input type="password" class="input-field" id="passwordfield" name="password" path="password" placeholder="Enter Your Password">
                                                        <i class="bi bi-eye-slash fw-bold mt-2" onclick="myFunction()" style="margin-left: -30px; cursor: pointer; margin-right: 17px;"
                                                            id="togglePassword"></i>
                                                    </div>
                                             
                                                </div>
                                                <div class="row mt-4">
                                                    <div class="input-container">
                                                <input type="checkbox" id="chkterms" />
        <label for="chkterms">
            &nbsp; I agree to usage | &nbsp;<a data-target="#TermsCondition" style="cursor: pointer;" data-toggle="modal" style="color: #273896;">Terms & conditions</a>
        </label>
                                                    </div>
                                                </div>
<div class="row mt-4">
                <div class="input-container">
                    <label style="font-weight: bold; color: red;">
                        <c:if test="${not empty errorMessage}">${errorMessage}</c:if>
                    </label>
                </div>
            </div>
                                                <div class="row mt-4">
                                                    <div class="input-container">

                                                        <Label  ID="lblMessage" Style="font-weight: bold; color: red"></Label>
                                                        <Label  ID="lblName" Style="font-weight: bold;"></Label>
                                                               <button id="btnLogin" class="btn btn-primary w-100" style="background-color: #273896;">Login</button>
                                                    </div>
                                                </div>
                                            </View>


                                            
                               
                                        <div class="row mt-1">
                                            <div class="input-container">
                                                <a href="register" style="color: #273896;">Sign Up?</a>&nbsp; | &nbsp;<a href="MemberForgotpassword" data-target="#pwdModal" data-toggle="modal" style="color: #273896;">Forget Password?</a>
                                            </div>
                                        </div>
                                        <div class="t mb-2 text-center">
                                            <div class="row text-center m-2">
                                                <p><b>Download BlueRay Fintech App</b></p>
                                            </div>
                                            <center>
                                                   <a href='' class="btn btn-primary mb-4" style="background-color: #273896;" >Download Now

                                                   </a>
                                                    </center>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </section>
                  
        </div>
        <div id="pdwTPIN" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="text-center">2 Step Authentication</h1>
                    </div>
                    <div class="modal-body">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="text-center">
                                   

                                                <p>Your account login in other device.</p>
                                                <div class="panel-body">
                                                    <fieldset>
                                                        <div class="form-group">
                                                            <TextBox ID="txtTpin" MaxLength="4" TextMode="Password" ForeColor="Red" CssClass="form-control" placeholder="Enter tpin"></TextBox>
                                                        </div>

                                                        <div class="form-group">
                                                     </div>
                                                    </fieldset>
                                                </div>

                                   
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="col-md-12">
                            <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br />

        <footer class="bg mt-4">
            <div class="container">
                <div class="row text-center mt-2">
                    <div class="col-md-6 col-12"><i class="bi bi-envelope-fill"></i>&nbsp; <b>Support@bluerayfintech.com</b></div>
                    <div class="col-md-6 col-12"><i class="bi bi-telephone-fill"></i>&nbsp;<b>9944923322</b></div>
                    <div class="col-md-12">
                        <p>© Copyright 2017 BlueRay Fintech. All right reserved. | About BlueRay Fintech</p>
                    </div>

                </div>
            </div>
        </footer>

        <div id="TermsCondition" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="text-center">TermsCondition</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>

                    </div>
                    <div class="modal-body">
                        <div class="col-md-12">
            

                                            <!--team-1-->
                                            <div class="col-lg-12">



                                                <div class="team-back">
                                                    <span>
                                                       
                                                    </span>
                                                </div>


                                            </div>

                        </div>

                    </div>
                    <div class="modal-footer">
                        <div class="col-md-12">
                            <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="pwdModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h1 class="text-center">What's My Password?</h1>
                    </div>
                    <div class="modal-body">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="text-center">
                                      
                                        

                                                <p>If you have forgotten your password you can reset it here.</p>
                                                <div class="panel-body">
                                                    <fieldset>
                                                        <div class="form-group">
                                                            <TextBox ID="txtMobile" ForeColor="Red" CssClass="form-control" placeholder="Enter LoginID"></TextBox>
                                                        </div>
                                                        <div class="form-group">
                                                            <TextBox  ForeColor="Red" ID="txtOTPVerify" Visible="false" CssClass="form-control input-lg" placeholder="Enter OTP"></TextBox>
                                                        </div>
                                                        <div class="form-group">
                                                            <TextBox  ForeColor="Red" ID="txtNewPassword" Visible="false" CssClass="form-control input-lg" placeholder="Enter New Password"></TextBox>
                                                        </div>
                                                        <div class="form-group">
                                                            <Button ID="btnForgetPassword" Text="Verify" CssClass="btn btn-primary" Style="background-color: #273896;" ></Button>
                                                        </div>
                                                    </fieldset>
                                                </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="col-md-12">
                            <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

      
</form:form>

</body>
</html>
