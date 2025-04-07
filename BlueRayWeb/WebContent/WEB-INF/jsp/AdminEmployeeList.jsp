<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Approval Module</title>
    <style>
        body {
            background-color: #f4f4f9;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-top: 20px;
        }

        .table-wrapper {
            width: 90%;
            margin: 20px auto;
            padding: 20px;
            background-color: #8eff8e;  
            border-radius: 20px;  
            box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1);  
            border: 10px solid #ffcc00;
        }
    
        table {
            width: 100%;  
            margin: 0 auto;
            border-collapse: separate;
            border-spacing: 0;
            background-color: #ffffff;
            border-radius: 12px;  
            overflow: hidden;  
        }

        th, td {
            padding: 15px;
            text-align: left;
            font-size: 16px;
        }

        th {
            background-color: blue;
            color: white;
            font-weight: bold;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }

        td {
            border: 1px solid #ddd;
        }

        .active {
            background-color: #1100ff;
            background-image: url("https://www.transparenttextures.com/patterns/3px-tile.png");
            color: white;
            font-weight: bold;
        }

        .inactive {
            background-color: #ff0000;
            background-image: url("https://www.transparenttextures.com/patterns/3px-tile.png");
            color: white;
            font-weight: bold;
        }

        .no-members {
            text-align: center;
            color: #999;
            font-style: italic;
        }

        table thead {
            background-color: #4CAF50;
            color: white;
        }

        table {
            background-color: #f9f9f9; 
        }

      
        .edit-btn {
            background-color: #ffcc00;
            color: black;
            padding: 8px 12px;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            font-weight: bold;
        }

        .edit-btn:hover {
            background-color: #45a049;
        }
        
    </style>
</head>
<body>

    <jsp:include page="AdminHeader.jsp" />

    <h1>Employee List</h1>
       
    <div class="table-wrapper">
   
    
    <table>
        <thead>
            <tr>
                <th>Login Pin</th>
                <th>Role</th>
                <th>Name</th>
                <th>Email</th>
                <th>MobileNo</th>
                <th>Address</th>
                <th>Pincode</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${not empty members}">
                <c:forEach var="member" items="${members}">
                    <tr>
                        <td>${member.login_Pin}</td> 
                        <td>${member.role}</td>
                        <td>${member.name}</td>
                        <td>${member.email}</td>
                        <td>${member.mobile}</td>
                        <td>${member.address}</td>
                        <td>${member.pincode}</td>
                        <td class="${member.status == 'Active' ? 'active' : 'inactive'}">${member.status}</td>
                        <td>
                     
                            <a href="AdminEmployeeRegistration?login_Pin=${member.login_Pin}" class="edit-btn">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${empty members}">
                <tr>
                    <td colspan="9" class="no-members">No members available</td>
                </tr>
            </c:if>
        </tbody>
    </table>
    </div>
       
</body>
</html>
