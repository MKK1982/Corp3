<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Admin</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <style>
     
        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            width: 100%; 
            padding: 4px;
            background-color: #010099;
            background-image: url("https://www.transparenttextures.com/patterns/twinkle-twinkle.png");
            margin: 0;
            box-sizing: border-box;
        }

        body {
            margin: 0;
            padding: 0;
        }

        .left img {
            height: 40px;
            background-color: white;
            width: auto;
            max-height: 100%;
        }

        .left {
            flex: 1;
        }

        .center {
            flex: 2;
            text-align: center;
             font-size: 28px;
            font-weight: bold;
            color:white;
        }

        .right {
            flex: 1;
            text-align: right;
        }

        .right a {
            text-decoration: none;
            font-size: 18px;
            color: yellow;
              margin-right: 8px; 
        }
        .right a i {
        margin-right: 8px; 
    }
 .menu-container {
            display: flex;
            flex-wrap: wrap;
       background-color: #000000;
background-image: url("https://www.transparenttextures.com/patterns/pool-table.png");
            justify-content: space-evenly;
            padding: 10px 0;
            
        }
.Menu {
    position: relative;
    background-color: #000000;
    background-image: url("https://www.transparenttextures.com/patterns/pool-table.png");
    flex: 0 1 auto;
    margin: 0 10px;
}

.Menu > a {
    color: white;
    padding: 14px 20px;
    display: block;
    text-decoration: none;
    font-size: 18px;
    display: flex;
    align-items: center;
    border-radius: 20px;
    transition: all 0.3s ease;
}

.Menu > a:hover {
    background-color: #ff6f00;
    padding-left: 30px;
    padding-right: 30px;
}

.Menu > a i {
    margin-right: 8px;
}

.submenu {
    display: none;
    position: absolute;
    left: 0;
    top: 100%;
    background-color: black;
    min-width: 200px;
    z-index: 1000;
        text-decoration: underline;
       text-decoration-color: red; 
}

.submenu a {
    padding: 12px 20px;
    color: red;
    text-decoration: none;
    display: block;
    font-weight: bold;
    position: relative;
}

.submenu a:before {
    content: "\2022";
    position: absolute;
    left: -15px; 
    top: 50%;
    transform: translateY(-50%);
    font-size: 14px;
    color: red;
}

.submenu a:hover {
    background-color: white;
    text-decoration: underline;
      text-decoration-color: black;
}

.Menu:hover .submenu {
    display: block;
}


.subsubmenu {
    display: none;
    position: absolute;
    left: -220px;
    top: 0;
    background-color: #333; 
    min-width: 200px;
    padding-left: 20px; 
    z-index: 1001;
}

.subsubmenu a {
    padding: 12px 20px;
    color: yellow; 
    font-weight: bold;
    position: relative;
}

.subsubmenu a:before {
    content: "\2022";
    position: absolute;
    left: -15px; 
    top: 50%;
    transform: translateY(-50%);
    font-size: 14px;
    color: yellow;
}

.subsubmenu a:hover {
    background-color: #ff6f00;
    text-decoration: underline;
  
}

.submenu:hover .subsubmenu {
    display: block;
}

.submenu-icon {
    font-size: 12px;
    margin-left: 10px;
}


        @media (max-width: 768px) {
            .menu-container {
                flex-direction: column;
                align-items: flex-start;
            }

            .Menu {
                width: 100%; 
                margin: 5px 0;
            }
        }
        .subheader {
    font-size: 16px;
    color: white;
    font-weight: bold;
    padding: 14px;
           
            background-color: #010099;
            background-image: url("https://www.transparenttextures.com/patterns/twinkle-twinkle.png");
    text-align: left;
    width: 100%;
    box-sizing: border-box;
    margin-bottom: 10px;
  
}
  .profile-icon {
        display: inline-block;
        background-color: red;
        border-radius: 70%;
        padding: 4px;
    }

    .profile-icon i {
        color: white;
        font-size: 24px;
    }

  
    .role-text {
        color: white;  
        font-size: 16px; 
    }

  
    </style>
</head>
<body>

    <header>
        <div class="left">
            <img src="${pageContext.servletContext.contextPath}/resources/Images/blueray.png" alt="Profile Image">
        </div>
        
        <div class="center">
            BlueRay Fintech Admin Portal
        </div>
        
<div class="right">
    <c:if test="${not empty role}">
        <span class="profile-icon"><i class="fas fa-user-circle"></i></span>
        <span class="role-text">${role}</span> 
    </c:if>
    <c:if test="${empty role}">
        <span class="profile-icon"><i class="fas fa-user-circle"></i></span>
        <span class="role-text">guest!</span> 
    </c:if>
    <a href="AdminLogin"><i class="fas fa-sign-out-alt"></i> Logout</a>
</div>
             
        
    </header>

    
      <div class="menu-container">
        <div class="Menu">
            <a href="AdminDashboard" Style="background-color: #ff6f00;"><i class="fas fa-tachometer-alt"></i> Dashboard</a>
        </div>
        <div class="Menu">
            <a href="#"><i class="fas fa-users"></i> Manage Members <i class="fas fa-chevron-down submenu-icon"></i></a>
            <div class="submenu">
                <a href="AdminApprovalMember">Approval Member</a>
                          <a href="AdminWalletApprovalMember">Wallet Approval</a>
                <a href="AdminEmployeeRegistration">Staff Register</a>
                            <a href="AdminEmployeeList">Staff List</a>
            </div>
        </div>
        <div class="Menu">
            <a href="#"><i class="fas fa-cogs"></i> Offline Services <i class="fas fa-chevron-down submenu-icon"></i></a>
            <div class="submenu">
                <a href="#">Submenu 1</a>
                <a href="#">Submenu 2</a>
            </div>
        </div>
        <div class="Menu">
            <a href="#"><i class="fas fa-cogs"></i> Manage Category <i class="fas fa-chevron-down submenu-icon"></i></a>
            <div class="submenu">
                <a href="#">Submenu 1</a>
                <a href="#">Submenu 2</a>
            </div>
        </div>
        <div class="Menu">
            <a href="#"><i class="fas fa-box"></i> Manage Products <i class="fas fa-chevron-down submenu-icon"></i></a>
            <div class="submenu">
                <a href="#">Submenu 1</a>
                <a href="#">Submenu 2</a>
            </div>
        </div>
        <div class="Menu">
            <a href="#"><i class="fas fa-chart-line"></i> All Reports <i class="fas fa-chevron-down submenu-icon"></i></a>
            <div class="submenu">
                <a href="#">Submenu 1</a>
                <a href="#">Submenu 2</a>
            </div>
        </div>
        <div class="Menu">
            <a href="#"><i class="fas fa-wallet"></i> Wallet Reports <i class="fas fa-chevron-down submenu-icon"></i></a>
            <div class="submenu">
                <a href="#">Submenu 1</a>
                <a href="#">Submenu 2</a>
            </div>
        </div>
        <div class="Menu">
            <a href="#"><i class="fas fa-history"></i> History <i class="fas fa-chevron-down submenu-icon"></i></a>
            <div class="submenu">
                <a href="#">Submenu 1</a>
                <a href="#">Submenu 2</a>
            </div>
        </div>
        <div class="Menu">
            <a href="#"><i class="fas fa-percent"></i> Set Commission <i class="fas fa-chevron-down submenu-icon"></i></a>
            <div class="submenu">
                <a href="#">Submenu 1</a>
                <a href="#">Submenu 2</a>
            </div>
        </div>
      
        <div class="Menu">
            <a href="#"><i class="fas fa-shield-alt"></i> Security <i class="fas fa-chevron-down submenu-icon"></i></a>
            <div class="submenu">
                <a href="#">Submenu 1</a>
                <a href="#">Submenu 2</a>
            </div>
        </div>
        <div class="Menu">
    <a href="#"><i class="fas fa-cogs"></i> Setting <i class="fas fa-chevron-down submenu-icon"></i></a>
    <div class="submenu">
<a href="#"><i class="fas fa-arrow-alt-circle-right"></i> SMS Setting</a>

        <div class="subsubmenu">
            <a href="#">SMS Template</a>
            <a href="#">SMS Integration</a>
            <a href="#">SMS Category</a>
        </div>
        <a href="#">Submenu 2</a>
    </div>
</div>
        <div class="Menu">
            <a href="#"><i class="fas fa-file-alt"></i> Legal Documents <i class="fas fa-chevron-down submenu-icon"></i></a>
            <div class="submenu">
                <a href="#">Submenu 1</a>
                <a href="#">Submenu 2</a>
            </div>
        </div>
        <div class="Menu">
            <a href="#"><i class="fas fa-cogs"></i> Recharge Setting <i class="fas fa-chevron-down submenu-icon"></i></a>
            <div class="submenu">
                <a href="#">Submenu 1</a>
                <a href="#">Submenu 2</a>
            </div>
        </div>
     

     
    </div>
   <div class="subheader">
        <c:if test="${not empty role}">
            Hi,${loginPin} ${name} welcome back!
        </c:if>
        <c:if test="${empty role}">
            Hi, guest! Welcome back!
        </c:if>
    </div>

</body>
</html>
