<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Approval Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #1100ff;
background-image: url("https://www.transparenttextures.com/patterns/argyle.png");
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            filter:invert(1);
        }
        .success-container {
            text-align: center;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }
        .tick-icon {
            width: 80px;
            height: 80px;
            margin-bottom: 20px;
        }
        .message {
            font-size: 18px;
            color: #4CAF50;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="success-container">
        <img src="https://upload.wikimedia.org/wikipedia/commons/b/bc/Caduceo_approved.png" alt="Success Tick" class="tick-icon"/>
        <p class="message">Successfully Approved</p>
    </div>
</body>
</html>
