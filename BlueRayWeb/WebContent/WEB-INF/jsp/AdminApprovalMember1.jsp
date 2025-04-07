<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Approval Module</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
        }
        h2 {
            text-align: center;
            color: red;
        }
        table {
            width: 90%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fbe4eb;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        table, th, td {
            border: 2px solid #e0a3d3;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #ff006b;
            color: black;
        }
        td {
            color: #4e4e4e;
        }
        tr:nth-child(even) {
            background-color: #fafafa;
        }

        .button-container {
            margin-top: 30px;
            text-align: center;
        }

        #updateButton {
            background-color: #ff006b;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
           
            display: none; 
        }

        #updateButton:hover {
            background-color: #e60056;
        }

        #confirmButton {
            background-color: red;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        #confirmButton:hover {
            background-color: #45a049;
        }
    </style>

    <script>
        function confirmApproval() {
            var confirmation = confirm("Please confirm to approval.");
            if (confirmation) {
             
                document.getElementById('updateButton').style.display = 'block';
                
                document.getElementById('confirmButton').style.display = 'none';
                
                alert("Approval Confirmed!");
            }
        }
    </script>
</head>
<body>
    <h2>Member Details</h2>
    <form:form method="post" action="${pageContext.servletContext.contextPath}/updateApprovalMember" modelAttribute="MemberEntity">
        <c:if test="${not empty member}">
            <table>
                <tr>
                    <th><strong>Reg ID</strong></th>
                    <td>${member.regId}</td>
                    <input type="hidden" name="regId" value="${member.regId}" />
                </tr>
                <tr>
                    <th><strong>Member Type</strong></th>
                    <td>${member.memberType}</td>
                </tr>
                <tr>
                    <th><strong>Mobile</strong></th>
                    <td>${member.mobile}</td>
                </tr>
                <tr>
                    <th><strong>Name</strong></th>
                    <td>${member.name}</td>
                </tr>
                <tr>
                    <th><strong>Email</strong></th>
                    <td>${member.email}</td>
                </tr>
                <tr>
                    <th><strong>Shop Name</strong></th>
                    <td>${member.shopName}</td>
                </tr>
                <tr>
                    <th><strong>Shop Address</strong></th>
                    <td>${member.shopAddress}</td>
                </tr>
                <tr>
                    <th><strong>Home Address</strong></th>
                    <td>${member.homeAddress}</td>
                </tr>
                <tr>
                    <th><strong>Pan No</strong></th>
                    <td>${member.panNo}</td>
                </tr>
                <tr>
                    <th><strong>Aadhar No</strong></th>
                    <td>${member.aadharNo}</td>
                </tr>
                <tr>
                    <th><strong>City</strong></th>
                    <td>${member.city}</td>
                </tr>
                <tr>
                    <th><strong>State</strong></th>
                    <td>${member.state}</td>
                </tr>
                <tr>
                    <th><strong>Pincode</strong></th>
                    <td>${member.pincode}</td>
                </tr>
                <tr>
                    <th><strong>Documents</strong></th>
                    <td>
                        <c:if test="${not empty member.documents}">
                            <c:choose>
                                <c:when test="${isImage}">
                                    <img src="${pageContext.request.contextPath}/showDocument?regId=${member.regId}" alt="Document" width="200" height="150"/>
                                </c:when>
                                <c:otherwise>
                                    <a href="${pageContext.request.contextPath}/showDocument?regId=${member.regId}" target="_blank">View PDF</a>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                    </td>
                </tr>
            </table>
        </c:if>

        <!-- Confirm Approval Button -->
        <div class="button-container">
            <button type="button" id="confirmButton" onclick="confirmApproval()">Please Confirm to Approval</button>
             <button type="submit" id="updateButton">Approval</button>
        </div>

       

    </form:form>
</body>
</html>
