<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #0000ff;
            background-image: url("https://www.transparenttextures.com/patterns/bo-play.png");
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            max-width: 900px;
            width: 100%;
            background-color: #fff;
            padding: 40px 30px;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            text-align: center;
        
        }
        .logo-light {
            width: 180px;
            margin-bottom: 20px;
        }
        h2 {
            margin-bottom: 30px;
            color: #333;
            font-size: 24px;
        }
        label {
            font-size: bold;
            color: #000000;
            margin-bottom: 8px;
            display: block;
        font-family: fantasy;
            
        }
        select, input, button {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border-radius: 8px;
            border: 1px solid #ddd;
            box-sizing: border-box;
            font-size: 14px;
            transition: all 0.3s ease;
        }
        select, input {
            background-color: lightblue;
        }
        select:focus, input:focus {
            border-color: #4CAF50;
            outline: none;
        }
        button {
            background-color: #000000;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #45a049;
        }
        .hidden {
            display: none;
        }
        .step-container {
            margin-top: 20px;
        }
        table {
            width: 100%;
           
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
          
            text-align: left;
        }
        th {
         background-color: #f2f2f2;
  
        }
        td {
           
        }


        .form-row {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }

        .form-row .form-group {
            flex: 1;
            min-width: 30%;
          
        }
                .hidden {
            display: none;
        }
          .error {
            color: red;
            font-size: 12px;
        }
        
        .password-container {
            position: relative;
            display: inline-block;
        }
        .eye-icon {
            position: absolute;
            right: 10px;
            top: 50%;
            transform: translateY(-50%);
            cursor: pointer;
        }
    </style>
</head>
<body>
	<form:form method="post" action="${pageContext.servletContext.contextPath}/MemberDetails" modelAttribute="MemberEntity" >

<div class="container">
  
    <img class="logo-light" src="${pageContext.servletContext.contextPath}/resources/Images/blueray.png" alt="BlueRay Logo">

    <h2>Registration Details</h2>

    <div id="step1">
        <label for="retailerType">Select Member Type</label>
        <select id="retailerType" name= "memberType">
        <option value="Select">---Select Member Type---</option>
            <option value="Retailer">Retailer</option>
            <option value="Wholesaler">Wholesaler</option>
        </select>
        <button onclick="goToNextStep()">Next</button>
    </div>

    <div id="step2" class="hidden step-container">
        <label for="mobileNumber">Enter Mobile Number</label>
        <input type="text" id="mobileNumber" placeholder="Enter your mobile number" maxlength="10" required>
        <button onclick="submitMobileNumber()">Submit</button>
    </div>

    <div id="step3" class="hidden step-container">
        <label for="otp">Enter OTP</label>
        <input type="text" id="otp" name="otp" placeholder="Enter OTP" maxlength="6">
        <button onclick="verifyOtp()">Verify OTP</button>
    </div>

    <div id="step4" class="hidden step-container">
     
            <table>
                <tr class="form-row">
                    <td class="form-group">
                        <label for="name">Name</label>
                    <input type="text" id="name" name="name" placeholder="Enter your name" required>
                             <label for="email">Email</label>
                <input type="text" id="email" name="email" placeholder="Email" required>
                    </td>
                    <td class="form-group">
                        <label for="shopName">Shop Name</label>
                     <input type="text" id="shopName" name="shopName" placeholder="Shop Name">
                            <label for="shopaddress">Shop Address</label>
               <input type="text" id="shopaddress" name="shopAddress" placeholder="Shop Address">
                    </td>
                    <td class="form-group">
                        <label for="homeaddress">Home Address</label>
                    <input type="text" id="homeaddress" name="homeAddress" placeholder="Home Address">
                         <label for="submittedMobileNumber">Mobile Number</label>
                        <input type="text" id="submittedMobileNumber" name="mobile">
                    </td>
                
                
                     <td class="form-group">
                <label for="pan">PAN Number</label>
                <input type="text" id="pan" name="panNo" placeholder="PAN Number" oninput="validatePAN()">
                <div id="panError" class="error"></div>
                
                <label for="aadhaar">Aadhaar Number</label>
                <input type="text" id="aadhaar" name="aadharNo" placeholder="Aadhaar Number" oninput="validateAadhaar()">
                <div id="aadhaarError" class="error"></div>
            </td>
                    <td class="form-group">
                            <label for="City">City</label>
                      <input type="text" id="city" name="city" placeholder="City">
                        <label for="state">State</label>
                        <select id="state" name="state">
                            <option value="">Select State</option>
                        </select>
                    </td>
               
                   
                      <td class="form-group">
                        <label for="Pincode">Pincode</label>
             <input type="text" id="pincode" name="pincode" placeholder="Pincode">
              
                        <label for="gstno">GST No</label>
              <input type="text" id="gstno" name="gstno" placeholder="GST Number">
                    </td>
                   <td class="form-group">
    <label for="documentUpload">Document Upload</label>
<input type="file" id="documentUpload" name="documents" placeholder="Upload Document">

                    <label for="password">Password</label>

        <input type="password" id="password" name="password" placeholder="Password" oninput="validatePassword()">
        <span id="eyeIcon" class="eye-icon" onclick="togglePasswordVisibility()"></span>

 
    
    
    <label for="cpassword">Confirm Password</label>
    <input type="password" id="cpassword" placeholder="Confirm Password" oninput="validateConfirmPassword()">
    <div id="confirmPasswordError" class="error"></div>
                    </td>
                </tr>
            </table>
            <button type="submit" >Submit</button>
       
    </div>
</form:form>
<div id="myModal" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <h3 id="successMessage"></h3>
        <button class="button1" onclick="redirectToHome()">OK</button>
    </div>
</div>
<style>
 .modal {
            display: none; 
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.4);
            overflow: auto;
            padding-top: 60px;
        }

        .modal-content {
            background-color: #fefefe;
            margin: 5% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
            max-width: 500px;
            text-align: center;
        }

        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }

        .button1 {
            background-color: #000000;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        .button1:hover {
            background-color: #45a049;
        }
</style>
<script>
   
    function togglePasswordVisibility() {
        const passwordField = document.getElementById('password');
        const confirmPasswordField = document.getElementById('cpassword');
        const eyeIcon = document.getElementById('eyeIcon');
        
        if (passwordField.type === "password" && confirmPasswordField.type === "password") {
            passwordField.type = "text";
            confirmPasswordField.type = "text";
            eyeIcon.textContent = ""; 
        } else {
            passwordField.type = "password";
            confirmPasswordField.type = "password";
            eyeIcon.textContent = ""; 
        }
    }

    function validatePassword() {
        const password = document.getElementById('password').value;
        const passwordError = document.getElementById('passwordError');
        const passwordPattern = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/; 

        if (!passwordPattern.test(password)) {
            passwordError.textContent = 'Password must be at least 8 characters, containing at least one letter and one number.';
        } else {
            passwordError.textContent = '';  
        }
    }

   
    function validateConfirmPassword() {
        const password = document.getElementById('password').value;
        const confirmPassword = document.getElementById('cpassword').value;
        const confirmPasswordError = document.getElementById('confirmPasswordError');
        
        if (confirmPassword !== password) {
            confirmPasswordError.textContent = 'Passwords do not match.';
        } else {
            confirmPasswordError.textContent = ''; 
        }
    }
</script>
<script>
   
    function validatePAN() {
        const pan = document.getElementById('pan').value;
        const panError = document.getElementById('panError');
        const panPattern = /^[A-Z]{5}[0-9]{4}[A-Z]{1}$/; // PAN regex pattern
        
        if (!panPattern.test(pan)) {
            panError.textContent = 'Invalid PAN number. Format should be XXXXX1234X';
        } else {
            panError.textContent = ''; 
        }
    }

 
    function validateAadhaar() {
        const aadhaar = document.getElementById('aadhaar').value;
        const aadhaarError = document.getElementById('aadhaarError');
        const aadhaarPattern = /^[2-9]{1}[0-9]{11}$/; // Aadhaar regex pattern
        
        if (!aadhaarPattern.test(aadhaar)) {
            aadhaarError.textContent = 'Invalid Aadhaar number. Format should be 12 digits.';
        } else {
            aadhaarError.textContent = ''; 
        }
    }
</script>
<script>
    const modal = document.getElementById('myModal');
    const successMessageElement = document.getElementById('successMessage');
    const closeButton = document.querySelector('.close');

   
    function showSuccessMessage(message) {
        successMessageElement.textContent = message;
        modal.style.display = "block";
    }

    // Close the modal when the user clicks on <span> (x)
    closeButton.onclick = function() {
        modal.style.display = "none";
    }

   
    function redirectToHome() {
        modal.style.display = "none";
        window.location.href = "/BlueRayApp/Memberlogin"; 
    }

 
    function showRegistrationSuccess() {
        showSuccessMessage("Registration Successful!");
    }

   
    const successMessage = '${successMessage}'; 

    if (successMessage) {
        showSuccessMessage(successMessage);
    }
</script>
<script>
    let generatedOtp = "";

    function goToNextStep() {
        document.getElementById('step1').classList.add('hidden');
        document.getElementById('step2').classList.remove('hidden');
    }

    function submitMobileNumber() {
        const mobileNumber = document.getElementById('mobileNumber').value;
        if (mobileNumber.length === 10 && !isNaN(mobileNumber)) {
            generatedOtp = Math.floor(100000 + Math.random() * 900000).toString();
            alert("OTP sent: " + generatedOtp);
            document.getElementById('step2').classList.add('hidden');
            document.getElementById('step3').classList.remove('hidden');
        } else {
            alert("Please enter a valid 10-digit mobile number.");
        }
    }

    function verifyOtp() {
        const enteredOtp = document.getElementById('otp').value;
        if (enteredOtp === generatedOtp) {
            alert("OTP verified successfully!");
            document.getElementById('step3').classList.add('hidden');
            document.getElementById('step4').classList.remove('hidden');
            document.getElementById('submittedMobileNumber').value = document.getElementById('mobileNumber').value;
        } else {
            alert("Invalid OTP. Please try again.");
        }
    }
    </script>
<script>
    const states = [
        "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", 
        "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand", "Karnataka", "Kerala", 
        "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", 
        "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", 
        "Uttar Pradesh", "Uttarakhand", "West Bengal", "Andaman and Nicobar Islands", 
        "Chandigarh", "Dadra and Nagar Haveli and Daman and Diu", "Lakshadweep", "Delhi", 
        "Puducherry"
    ];

    const stateSelect = document.getElementById('state');
    
     states.forEach(state => {
        const option = document.createElement('option');
        option.value = state;
        option.textContent = state;
        stateSelect.appendChild(option);
    });
</script>

</body>
</html>
