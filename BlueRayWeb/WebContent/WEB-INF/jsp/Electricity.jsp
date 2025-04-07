<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Electricity Plans</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
    <style>
        .Container1 {
            width: 60%;
            margin: 40px auto;
            padding: 30px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            margin-right: 10%;
            background-color: white;
   
            overflow-y: auto;
        }

        .heading1 {
            text-align: center;
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
            color: red;
        }

        .electricity-list {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }

        .electricity-item {
            background-color: #ffe486;
            color: black;
            padding: 10px 10px;
            margin: 5px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            width: 30%;
            text-align: center;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
  .electricity-item img {
            width: 50px; 
            height: 50px;
            object-fit: contain;
            margin-bottom: 10px;
        }
        .electricity-item:hover {
            background-color: lightpink;
        }

        .electricity-item span {
            display: block;
            margin-top: 5px;
            font-weight: 500;
        }

        .electricity-inputs {
            display: none;
            margin-top: 20px;
            text-align: center;
        }

        /* Enhanced Input Fields and Button Design */
        .input-container {
            margin-top: 20px;
        }

        .input-container label {
            font-size: 18px;
            color: #333;
            margin-bottom: 10px;
            display: block;
        }

        .input-container input[type="text"] {
            width: 80%;
            padding: 12px;
            font-size: 16px;
            border: 2px solid #ccc;
            border-radius: 8px;
            box-sizing: border-box;
            outline: none;
            transition: border-color 0.3s ease;
        }

        .input-container input[type="text"]:focus {
            border-color: #ff6600;
        }

        .input-container button {
            padding: 12px 20px;
            background-color: #ff6600;
            color: white;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            margin-top: 15px;
        }

        .input-container button:hover {
            background-color: #e55b00;
        }

        .back-button {
            margin-top: 10px;
            padding: 10px;
            background-color: #0066cc;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .back-button:hover {
            background-color: #005bb5;
        }
    </style>
    <script>
        function showInputFields(planName, planState) {
            document.getElementById("electricityList").style.display = "none";
            document.getElementById("electricityInputs").style.display = "block";

           
            document.getElementById("selectedPlanName").innerHTML = planName;
            document.getElementById("selectedPlanState").innerHTML = planState;
        }

        function goBack() {
            document.getElementById("electricityList").style.display = "block";
            document.getElementById("electricityInputs").style.display = "none";
            location.reload();
        }
       
    </script>
</head>
<body>
    <jsp:include page="Header.jsp" />

    <div class="Container1">
        <h2 class="heading1">Electricity Plans</h2>
        <td>RRN No : <form:input path="Rrn_No"  value="${Rrn_No}"/></td>
										
										
										<td>AES Token : <form:input path="AesToken"  value="${AesToken}"/></td>
        <div class="electricity-list" id="electricityList">
            <c:forEach var="entry" items="${electricityList}">
                  <div class="electricity-item" 
             onclick="showInputFields('<img src=\'https://customer.uatsbiunipay.sbi:4443/CustomerPortal/${entry.logo}\' />', '${entry.name}', '${entry.state1}')">
            <img src="https://customer.uatsbiunipay.sbi:4443/CustomerPortal/${entry.logo}" />
            <div>${entry.name}</div>
            <span>${entry.state1}</span>
        </div>
            </c:forEach>
        </div>

        <div class="electricity-inputs" id="electricityInputs" style="display: none;">
            <h3>You have selected:</h3>
            <p><span id="selectedPlanName"></span></p>
            <p> <span id="selectedPlanState"></span></p>

      <div class="input-container">
    <label for="accountNumber">Consumer Number:</label><br>
    <input type="text" id="accountNumber" name="consumernumber" required><br><br>
    <button type="button" id="checkButton" onclick="Checker()">Verify</button>
</div>
           <script>
    function Checker() {
        var regId = $("#accountNumber").val(); 
        var url = "${pageContext.servletContext.contextPath}/CheckingId/" + regId"; 
        
        $.ajax({
            url: url,
            type: 'GET',
            data: { id: regId }, // Send the ID in the request
            success: function(response) {
                // Handle the response
                if (response.status === "success") {
                    alert("ID is valid");
                } else {
                    alert("ID not found");
                }
            },
            error: function(xhr, status, error) {
                console.error("API Error: " + error);
                alert("There was an error verifying the ID.");
            }
        });
    }
</script>
            <button class="back-button" onclick="goBack()">Back to List</button>
        </div>
    </div>
</body>
</html>
