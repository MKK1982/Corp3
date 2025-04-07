<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Registration</title>


<style>
    body {
 
        background-color: #f4f4f4;
      
    }

    header {
        background-color: #4CAF50;
        color: white;
        padding: 15px;

    }

    h1 {
        text-align: center;
        color: #333;
    }

    form {
        background-color: #cfffc6;
        margin: 30px auto;
        padding: 20px;
        width: 50%;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    table {
        width: 100%;
        margin: 10px 0;
    }

    td {
        padding: 8px;
        text-align: left;
    }

 input, select, textarea {
        width: 100%;
        padding: 12px;
        margin: 5px 0 10px 0;
        border: 2px solid #ccc;
        border-radius: 12px;
        font-size: 16px;
        box-sizing: border-box;
        background-color: #f9f9f9;
        transition: border-color 0.3s ease;
    }

   


button {
  align-items: center;
  appearance: none;
  background-color: #3EB2FD;
  background-image: linear-gradient(1deg, #4F58FD, #149BF3 99%);
  background-size: calc(100% + 20px) calc(100% + 20px);
  border-radius: 100px;
  border-width: 0;
  box-shadow: none;
  box-sizing: border-box;
  color: #FFFFFF;
  cursor: pointer;
  display: inline-flex;
  font-family: CircularStd,sans-serif;
  font-size: 1rem;
  height: auto;

  line-height: 1.5;
  padding: 6px 20px;


  text-decoration: none;
  transition: background-color .2s,background-position .2s;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  vertical-align: top;
  white-space: nowrap;
}

button:active,
button:focus {
  outline: none;
}

button:hover {
  background-position: -20px -20px;
}

button:focus:not(:active) {
  box-shadow: rgba(40, 170, 255, 0.25) 0 0 0 .125em;
}

    .update-button{
  align-items: center;
  appearance: none;
  background-color: red;
  background-image: linear-gradient(1deg, red, yellow 99%);
  background-size: calc(100% + 20px) calc(100% + 20px);
  border-radius: 100px;
  border-width: 0;
  box-shadow: none;
  box-sizing: border-box;
  color: blue;
  cursor: pointer;
  display: inline-flex;
  font-family: CircularStd,sans-serif;
  font-size: 1rem;
  height: auto;

  line-height: 1.5;
  padding: 6px 20px;


  text-decoration: none;
  transition: background-color .2s,background-position .2s;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  vertical-align: top;
  white-space: nowrap;
}

.update-button:active,
.update-button:focus {
  outline: none;
}

.update-button:hover {
  background-position: -20px -20px;
}

.update-button:focus:not(:active) {
  box-shadow: rgba(40, 170, 255, 0.25) 0 0 0 .125em;
}
    
    

    .form-row label {
        font-weight: bold;
        color: #333;
    }

    .form-row input[type="checkbox"] {
        width: auto;
        display: inline-block;
    }


    @media (max-width: 768px) {
        form {
            width: 90%;
        }
    }
</style>

<script type="text/javascript">
    function validateForm() {
        var age = document.forms["empForm"]["age"].value;
        var email = document.forms["empForm"]["email"].value;
        var mobile = document.forms["empForm"]["mobile"].value;
        var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
        var mobilePattern = /^[0-9]{10}$/;

        if (age == "" || isNaN(age)) {
            alert("Please enter a valid age.");
            return false;
        }
        if (!emailPattern.test(email)) {
            alert("Please enter a valid email address.");
            return false;
        }
        if (!mobilePattern.test(mobile)) {
            alert("Please enter a valid mobile number.");
            return false;
        }
        return true;
    }
</script>
</head>
<body>
<jsp:include page="AdminHeader.jsp" />

<h1>Employee Registration</h1>
<form:form name="empForm" method="post" action="${pageContext.servletContext.contextPath}/EmployeeRegistration" modelAttribute="MemberEntity" onsubmit="return validateForm();">
<input name="login_Pin" id="login_Pin" type="text" value="${member.login_Pin}" readonly="true" style="display: none;" />

<div class="form-row">
        <label for="role">Role:</label>
        <select name="role" id="role">
            <option value="Master Distributor" ${member.role == 'Master Distributor' ? 'selected' : ''}>Master Distributor</option>
            <option value="Distributor" ${member.role == 'Distributor' ? 'selected' : ''}>Distributor</option>
            <option value="Retailer" ${member.role == 'Retailer' ? 'selected' : ''}>Retailer</option>
            <option value="Support" ${member.role == 'Support' ? 'selected' : ''}>Support</option>
            <option value="ATM" ${member.role == 'ATM' ? 'selected' : ''}>ATM</option>
            <option value="Admin" ${member.role == 'Admin' ? 'selected' : ''}>Admin</option>
            <option value="Marketing Manager" ${member.role == 'Marketing Manager' ? 'selected' : ''}>Marketing Manager</option>
            <option value="White Label" ${member.role == 'White Label' ? 'selected' : ''}>White Label</option>
            <option value="System Admin" ${member.role == 'System Admin' ? 'selected' : ''}>System Admin</option>
        </select>
    </div>

    <div class="form-row">
        <label for="name">Name:</label>
        <input name="name" id="name" type="text" value="${member.name}" required="true" />


    </div>

 
    <div class="form-row">
        <label for="age">Age:</label>
        <input name="age" id="age" type="number" min="18" value="${member.age}" required="true" />
    </div>

    
    <div class="form-row">
        <label for="email">Email:</label>
        <input name="email" id="email" type="email" value="${member.email}" required="true" />
    </div>


    <div class="form-row">
        <label for="mobile">Mobile No.:</label>
        <input name="mobile" id="mobile" type="tel" maxlength="10" value="${member.mobile}" required="true" />
    </div>


    <div class="form-row">
        <label for="address">Address:</label>
        <textarea name="address" id="address" required="true">${member.address}</textarea>
    </div>


    <div class="form-row">
        <label for="pincode">Pincode:</label>
        <input name="pincode" id="pincode" type="text" maxlength="6" value="${member.pincode}" required="true" />
    </div>
  <div class="form-row">
        <label for="Password">Password:</label>
        <input name="password" id="password" type="text"  value="${member.password}" required="true" />
    </div>
    <div class="form-row">
        <label for="active">Active:</label>
        <input type="checkbox" name="active" id="active" ${member.active ? 'checked' : ''} />
    </div>


    <div class="form-row">
       <c:choose>
    <c:when test="${not empty member.login_Pin}">
        <button type="submit" class="update-button" name="updateButton">Update</button>
    </c:when>
    <c:otherwise>
        <button type="submit">Save</button>
    </c:otherwise>
</c:choose>

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
        window.location.href = "/BlueRayApp/AdminEmployeeRegistration"; 
    }

 
    function showRegistrationSuccess() {
        showSuccessMessage("Employee Registration Successful!");
    }

   
    const successMessage = '${successMessage}'; 

    if (successMessage) {
        showSuccessMessage(successMessage);
    }
</script>
</body>
</html>
