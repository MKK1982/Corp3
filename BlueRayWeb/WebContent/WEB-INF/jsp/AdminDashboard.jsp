<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Admin Dashboard</title>
    <style>
        body {
            background-color: white;
        }

        h1 {
            text-align: center;
            color: black;
         
            font-weight: bold;
            padding: 20px;
            margin: 0;
        }

        .content {
            display: grid;
            grid-template-columns: 1fr 1fr 1fr;
            gap: 20px;
            padding: 20px;
        }

        .content-box {
           background-color: #ff00e1;
background-image: url("https://www.transparenttextures.com/patterns/brick-wall-dark.png");
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgb(235 0 0);
            text-align: center;
            font-size: 20px;
            font-weight: bold;
            color: white;
        }

        .content-box:hover {
            background-color: red;
            color: white;
            cursor: pointer;
            transition: all 0.3s ease;
            box-shadow: 0 4px 8px blue;
        }
    </style>
</head>
<body>

    <jsp:include page="AdminHeader.jsp" />

    <h1>Welcome To Admin Dashboard</h1>
      
    <div class="content">
   <c:forEach var="entry" items="${roleCounts}">
    <div class="content-box">
         <div>${entry.key}</div>
                <span>${entry.value} Persons</span>
    </div>
</c:forEach>

    </div>

</body>
</html>
