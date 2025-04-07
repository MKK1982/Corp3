<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Session Member Expired</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    <style>
        body {
            font-family: 'Roboto', sans-serif;
       background-color: #ff6f00;
background-image: url("https://www.transparenttextures.com/patterns/gray-floral.png");
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
        }

        .container {
  background-color: #000000;
background-image: url("https://www.transparenttextures.com/patterns/skulls.png");
            color: white;
            padding: 40px;
            border-radius: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
            width: 300px;
           
        }

       
        .icon {
            font-size: 70px;
            color: red;
            margin-bottom: 20px;
            animation: flash 1s infinite alternate; 
        }

        @keyframes flash {
            0% {
                color: #00f1ff;
            }
            50% {
                color: #f39c12;
            }
            100% {
                color: #3dff00;
            }
        }

        .message {
            font-size: 18px;
            color: orange;
            margin-bottom: 20px;
            font-weight:bold;
            display: list-item;
        }

        .button {
            display: inline-flex;
            justify-content: center;
            align-items: center;
            background-color: #f800ff;
            color: white;
            border: none;
            padding: 12px 25px;
            border-radius: 30px; 
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
            transition: all 0.3s ease;
        }

        .button:hover {
            background-color: yellow;
            color: black;
            transform: scale(1.1);
        }

        .button i {
            margin-right: 8px;
        }
    </style>
</head>

<body>

    <div class="container">
        <div class="icon">
            <i class="fas fa-exclamation-circle"></i>
        </div>
        <div class="message">
            Your session has expired. Please log in again to continue.
        </div>
        <a href="Memberlogin" class="button">
            <i class="fas fa-sign-in-alt"></i> Go to Login
        </a>
    </div>

</body>

</html>
