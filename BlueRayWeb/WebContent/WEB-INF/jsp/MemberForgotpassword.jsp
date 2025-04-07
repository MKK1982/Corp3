<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Forgot Password</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
    function Checker() {
        var regId = $("#regId").val(); 
        
        $.ajax({
            url: "${pageContext.servletContext.contextPath}/CheckingRegid/" + regId,  
            type: 'GET',
            success: function(response) {
                alert(response);
                if (response == "true") {
                    alert("Your Reg_Id or Email is verified.");
                    $("#passwordFields").show();
                } else {
                    alert("Please register.");
                    window.location.href = "${pageContext.servletContext.contextPath}/register";
                }
            },
            error: function(xhr, status, error) {
                console.error("Error Details:", status, error);
                alert("Error checking Reg_Id or Email. Please try again.");
            }
        });
    }
   
    function validatePasswords() {
        var password = $("#password").val();
        var confirmPassword = $("#confirmPassword").val();
        
        if (password !== confirmPassword) {
            $("#updateButton").hide();
            $("#passwordMismatchMessage").show();
        } else {
            $("#updateButton").show();
            $("#passwordMismatchMessage").hide();
        }
    }
    
    $(document).ready(function() {
        $("#password, #confirmPassword").on("input", validatePasswords);
        var successMessage = '${successMessage}';
        if (successMessage) {
            alert(successMessage); // Show the alert
        }
    });
    </script>
    <style>
        body {
            font-family: 'Arial', sans-serif;
 background-color: #001029;
background-image: url("https://www.transparenttextures.com/patterns/wall-4-light.png");
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

.form-container {
    background: rgba(255, 255, 255, 0.8); 
    padding: 40px;
    border-radius: 20px;
    box-shadow: 0 6px 16px rgba(0, 0, 0, 0.2);
    width: 480px;
    text-align: center;
    backdrop-filter: blur(10px);
}

      h1 {
    color: red;
    margin-bottom: 25px;
    font-size: 28px;
    font-weight: bold;
    letter-spacing: 1px;
    text-decoration: underline; 
    text-decoration-color: #007bff;  
    text-decoration-thickness: 3px; 
}


        label {
            font-size: 16px;
            font-weight: bold;
            color: #333;
            margin-bottom: 8px;
            display: block;
        }

        .input-container {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
        }

        .input-container input,
        .input-container button {
            width: 48%;
            padding: 15px;
            font-size: 16px;
            border-radius: 12px;
            border: 1px solid #ddd;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            margin: 10px 0;
            padding: 18px;
            border-radius: 10px;
            border: 1px solid red;
            font-size: 16px;
            box-sizing: border-box;
            background-color: #000000;
            color:white
        }

        button {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 12px;
            font-size: 18px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            width: 100%;
            padding: 18px;
        }

        button:hover {
            background-color: #0056b3;
        }

        #passwordMismatchMessage {
            color: red;
            font-size: 14px;
            margin-top: 10px;
        }

        .hidden {
            display: none;
        }

        .container-left,
        .container-right {
            width: 48%;
        }

        .container-left {
            text-align: left;
        }

        .container-right {
            text-align: right;
        }

        .container-right button {
            background-color: red;
            margin-top: 15%;
            
        }
        
        .container-right button:hover {
            background-color: #218838;
        }

        .container-left input,
        .container-right input {
            border-radius: 10px;
        }
        
        .password-container {
            margin-top: 20px;
        }

    </style>
</head>
<body>
    <div class="form-container">
        <h1>Forgot Password</h1>
        <form:form method="post" action="${pageContext.servletContext.contextPath}/updatePassword" modelAttribute="MemberEntity">
            <div class="input-container">
                <div class="container-left">
                    <label for="regId">Enter Your Email Or Reg_Id:</label>
                    <input type="text" id="regId" name="regId" placeholder="Email or Reg_Id">
                </div>
                <div class="container-right">
                    <button type="button" id="checkButton" onclick="Checker()">Check</button>
                </div>
            </div>
            
            <div id="passwordFields" class="hidden password-container">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" placeholder="Password">
                
                <label for="confirmPassword">Confirm Password:</label>
                <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password">
                
                <div id="passwordMismatchMessage" class="hidden">
                    <p>Passwords do not match!</p>
                </div>
                
                <button type="submit" id="updateButton" class="hidden">Update Password</button>
            </div>
        </form:form>
    </div>
</body>
</html>
