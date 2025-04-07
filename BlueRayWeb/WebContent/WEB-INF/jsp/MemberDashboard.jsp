<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Member Dashboard</title>
    <style>
        
        header {
            position: fixed;
            top: 0;
            width: 100%;
            z-index: 1000;
            background-color: #fff;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .content-container {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            text-align: center;
            padding: 20px;
            background-color: white;
            padding-top: 100px;
            width: 100%;
        }

        .row {
            display: flex;
            justify-content: center;
            width: 100%;
            margin-top: 40px;
            flex-wrap: wrap;
        }

        .col-md-3 {
            margin: 15px;
            display: flex;
            justify-content: center;
        }

        .dashboard-card {
            background: linear-gradient(145deg, #1600ff, #ff00b1); 
            box-shadow: 0 15px 30px rgba(0, 0, 0, 0.2);
            padding: 30px;
            text-align: center;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            width: 240px;
            height: 160px;
            position: relative;
            cursor: pointer;
            color: white;
            left:30%
        }

        .dashboard-card:hover {
            transform: translateY(-12px); 
            box-shadow: 0 25px 50px rgba(0, 0, 0, 0.3);
        }

        .dashboard-card h6 {
            font-size: 16px;
            color: white;
            margin-bottom: 10px;
            font-weight: 600;
        }

        .dashboard-card h3 {
            font-size: 28px;
            font-weight: bold;
            color: white;
            margin-bottom: 10px;
        }

        .badge {
            font-size: 14px;
            padding: 8px 16px;
            border-radius: 12px;
            font-weight: 500;
            position: absolute;
            bottom: 10px;
            left: 50%;
            transform: translateX(-50%);
        }

        .bg-success {
            background-color: #28a745;
            color: white;
        }

        .bg-danger {
            background-color: #dc3545;
            color: white;
        }

        .bg-warning {
            background-color: #ffc107;
            color: white;
        }

        /* Responsive Design */
        @media screen and (max-width: 768px) {
            .row {
                flex-direction: column;
                align-items: center;
            }

            .col-md-3 {
                margin: 15px 0;
            }

            .dashboard-card {
                width: 80%; 
                height: auto; 
            }
        }
    </style>
</head>

<body>

<%@ include file="Header.jsp" %>
<div class="center-content">
<div class="content-container">
    <div class="row">
        <div class="col-md-3 mb-4">
            <div class="dashboard-card">
                <h6>Total Revenue</h6>
                <h3 class="text-primary">$45,234</h3>
                <span class="badge bg-success">+12.5%</span>
            </div>
        </div>
        <div class="col-md-3 mb-4">
            <div class="dashboard-card">
                <h6>Active Users</h6>
                <h3 class="text-info">2,342</h3>
                <span class="badge bg-danger">-3.2%</span>
            </div>
        </div>
        <div class="col-md-3 mb-4">
            <div class="dashboard-card">
                <h6>Transactions</h6>
                <h3 class="text-warning">4,212</h3>
                <span class="badge bg-success">+8.7%</span>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
