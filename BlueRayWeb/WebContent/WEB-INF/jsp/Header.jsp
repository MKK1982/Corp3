<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Header and Sidebar</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEJmEQfA8z6vAG5YazQNeXw0rZbYPuQmwPtvQ91shLslK3UjmBOha0npB44yS" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
          background-color: #ffffff;

            overflow-x: hidden;
            transition: all 0.3s ease;
        }

        .sidebar {
            width: 230px;
       
       background-color: #ffffff;

            color: #fff;
            padding-top: 20px;
            position: fixed;
            top: 0;
            left: 0;
            height: 100%;
            box-shadow: 4px 0 10px rgba(0, 0, 0, 0.3);
            background-size: cover;
            transition: transform 0.3s ease;
            z-index: 1;
            overflow-y: auto;
      

    scrollbar-color: #007bff #ffffff; 
        }

        .sidebar .profile {
            text-align: center;
            margin-bottom: 20px;
        }

        .sidebar .profile img {
            width: 98%;
            background-color: #ff000030;
            height: auto;
            border-radius: 50%;
            object-fit: cover;
            max-width: 100%;
            max-height: 200px;
            margin-top: -29px;
        }
.sidebar .profile .icons {
    display: flex;
    justify-content: center;
    gap: 30px; 

 
}

.sidebar .profile .icons i {
    font-size: 24px;
    cursor: pointer;
    transition: color 0.3s ease;
}


.sidebar .profile .icons i:nth-child(1) { 
    color: red;
}

.sidebar .profile .icons i:nth-child(2) { 
    color: green;
}

.sidebar .profile .icons i:nth-child(3) { 
    color: orange;
}

.sidebar .profile .icons i:nth-child(4) {
    color: blue;
}

.sidebar .profile .icons i:hover {
    color: #007bff; 
}

       .sidebar a { 
    color: black; 
    display: block;
    padding: 15px 20px;
    text-decoration: none;
    font-size: 18px;
    font-weight: bold; 
    border-bottom: 1px solid #444;
    transition: all 0.3s;
    position: relative;
    border-radius: 20px;
    letter-spacing: 1px; 
 
}

.sidebar a:hover {
    background: linear-gradient(135deg, pink, red);
    transform: translateX(5px) scale(1.05); 
    color: white; 
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2); 
}


.sidebar a::after {
    content: '';
    position: absolute;
    left: 0;
    bottom: 0;
    width: 100%;
    height: 3px;
    background-color: blue;
    transform: scaleX(0);
    transform-origin: bottom right;
    transition: transform 0.3s ease-out;
}

.sidebar a:hover::after {
    transform: scaleX(1);
    transform-origin: bottom left;
}


.sidebar a::before {
    content: '';
    position: absolute;
    left: -15px; 
    top: 50%;
    transform: translateY(-50%);
    width: 10px;
    height: 10px;
    border-radius: 50%; 
    background-color: #8B4513;
    transition: all 0.3s;
}

.sidebar a:hover::before {
    background-color: #5A2A1B; 
    transform: translateY(-50%) scale(1.2); 
}

        .submenu {
            display: none;
            padding-left: 20px;
            background-color: #f5f5f5;
        }

        .submenu a {
            font-size: 16px;
        }

        .arrow {
            float: right;
            font-size: 14px;
            transform: rotate(0deg);
            transition: transform 0.3s;
        }

        .arrow.rotate {
            transform: rotate(180deg);
        }


      .header {
    position: fixed;
    top: 0;
    left: 230px;
    width: calc(100% - 230px);
    background-color: #970000e6;
    padding: 10px 20px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    z-index: 100;
    display: flex;
    justify-content: space-between;
    align-items: center;
    transition: left 0.3s ease, width 0.3s ease;
}


@media (min-width: 1280px) {
    .sidebar, .sub-header, .sub-header1  {
        display: block;
    }
}


@media (max-width: 1024px) {
   .header, .sub-header, .sub-header1 {
        left: 0;
        width: 100%;
    }
    
    .sidebar {
        display: none;
    }
}

        .Sub-header {
       background-color: #ffffff;
background-image: url("https://www.transparenttextures.com/patterns/bo-play.png");
               position: fixed;
            
            left: 230px;
            width: calc(100% - 230px);
            padding: 10px 20px;  
            width: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 46px;
        }

        .running-text {
        background-color:black;
            white-space: nowrap;
            overflow: hidden;
            display: inline-block;
            color: red;
            font-weight: bold;
            font-size: 20px;
            animation: scroll-left 10s linear infinite;
        }

        @keyframes scroll-left {
            from {
                transform: translateX(100%);
            }
            to {
                transform: translateX(-100%);
            }
        }

     .toggle-btn {
    font-size: 24px;
    cursor: pointer;
    background-color: white;
    color: red;
    padding: 0px 10px;
    border-radius: 25px; 
    border: 2px solid red;
    display: inline-block;
    transition: all 0.3s ease; 
}

.toggle-btn:hover {
    background-color: red;
    color: white;
    transform: scale(1.1); 
}

.toggle-btn.active {
    background-color: red;
    color: white;
    border-color: white;
}

.Sub-header1 {
    background: 
        linear-gradient(135deg, #e50303, blue),
        radial-gradient(circle, rgba(255, 255, 255, 0.3), rgba(0, 0, 0, 0.2)),
     
           url('https://www.transparenttextures.com/patterns/shley-tree-2.png');
    position: fixed;
    top: 80px; 
    left: 230px;
    width: calc(100% - 230px);
    padding: 20px 40px;
    display: flex;
    justify-content: flex-start;
    align-items: center;
    margin-top: 0;
    z-index: 99;
    background-size: 100% 100%, 50% 50%;
    background-blend-mode: overlay;
}


.Sub-header1 .left {
    color: white;
    font-size: 18px;
    font-weight: bold;
    text-align: left;
    flex: 1;
}

.Sub-header1 .font-link {
    color: white;
    text-decoration: underline;
    font-size: 18px;
    font-weight: bold;
}

.dropdown {
    position: relative;
    display: inline-block;
    margin-right: 90%;
}

.dropdown-btn {
    background-color: #970000e6;
    color: white;
    border: 2px solid red;
    text-decoration: underline;
    cursor: pointer;
    font-size: 14px;
    border-radius: 5px;
    
}
.dropdown-content {
    display: none;
    position: absolute;
  background-color: #ff0000;
background-image: url("https://www.transparenttextures.com/patterns/asfalt-dark.png");
    z-index: 1;
    flex-direction: row;
    gap: 10px;
    padding: 0;
    max-height: 300px;  
    overflow-y: auto;   
    overflow-x: auto; 
}

.dropdown-content a {
    color: white;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    font-weight: bold;
    white-space: nowrap;
    flex-shrink: 0; 
  
}


.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown-content a:hover {
    background-color: yellow;
    color: black;
       text-decoration: underline;
}



.icons a{

}
        @media (max-width: 768px) {
            .sidebar {
                width: 200px;
            }
            .content {
                margin-left: 220px;
            }
        }

        @media (max-width: 480px) {
            .sidebar {
                width: 100%;
                position: relative;
                top: 0;
            }
            .content {
                margin-left: 0;
            }
        }
  
	.main-header-right {
    position: absolute;
   
    left: 90%; 
}
	.main-header-right a{
	color:yellow;
	}
.sidebar a i {
    margin-right: 10px; 
    font-size: 20px;
    
}

.sidebar .profile1 {
    display: flex;
    flex-direction: column;
    justify-content: center; 
    align-items: center; 
    
    padding: 15px;
 filter:invert(1);
       font-size: 18px;  
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);  
       
     
    
}


.sidebar .profile1 i {
    font-size: 40px; 
    color: red;  
    background-color:  blue;  
    border-radius: 50%; 
    padding: 15px;
    margin-bottom: 10px; 
}




.sidebar .profile1:hover {
    background-color: red;  
    cursor: pointer;
    transition: background-color 0.3s ease; 
}

.center-content {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 30vh;
}


    </style>
    
</head>
<body>

   <div class="header">
    <span class="toggle-btn">&#9665;</span>

<div class="dropdown">
  <button class="dropdown-btn">&#169; Services</button>
  <div class="dropdown-content">
    <c:if test="${not empty categoryNames}">
      <c:forEach var="category" items="${categoryNames}">
        <a href="${categoryPages[category]}">
          <i class="${categoryIcons[category]}" style="margin-right: 8px;"></i>
          ${category}
        </a>
      </c:forEach>
    </c:if>
  </div>
</div>




 <div class="main-header-right">
<a href="Memberlogin"><i class="fas fa-sign-out-alt"></i> Logout</a>
</div>

</div>



    <div class="Sub-header">
        <div class="running-text">
            Time for filing the bill on the portal is limited till 06.00 pm daily..,!
          
        </div>
    </div>
   <div class="Sub-header1">
    <div class="left">
         <a href="#" class="font-link">Dashboard/ Home/<c:if test="${not empty name}">
    ${memberType} 
</c:if></a>
    </div>
    
</div>

    
</div>


    <div class="sidebar">
    <div class="profile">
        <img src="${pageContext.servletContext.contextPath}/resources/Images/blueray.png" alt="Profile Image">
       
    </div>
     <div class="profile1">
    <i class="fas fa-user"></i></br>
<c:if test="${not empty name}">
    ${name}  (${regId})
</c:if>
 </div>
 <div class="profile">
  <div class="icons">
            <i class="fas fa-wallet" onclick="window.location.href='MemberWallet';"></i>
            <i class="fas fa-envelope"></i>
            <i class="fas fa-bell"></i>
            <i class="fas fa-inbox"></i>
        </div>    </div>
    <a href="MemberDashboard" style="background: linear-gradient(135deg, red, violet);">
        <i class="fas fa-tachometer-alt"></i> Dashboard 
    </a>
    <a href="#">
        <i class="fas fa-sync-alt"></i> Recharge
    </a>
    <a href="javascript:void(0);" class="menu-item">
        <i class="fas fa-mobile-alt"></i> Phone <span class="arrow">&#9660;</span>
    </a>
    <div class="submenu">
        <a href="#">Submenu 1</a>
        <a href="#">Submenu 2</a>
    </div>
    <a href="javascript:void(0);" class="menu-item">
        <i class="fas fa-plug"></i> Electricity <span class="arrow">&#9660;</span>
    </a>
    <div class="submenu">
        <a href="#">Submenu 1</a>
        <a href="#">Submenu 2</a>
    </div>
    <a href="#">
        <i class="fas fa-tasks"></i> BBPS
    </a>
    <a href="#">
        <i class="fas fa-fire"></i> Gas
    </a>
    <a href="#">
        <i class="fas fa-credit-card"></i> Upi
    </a>
    <a href="#">
        <i class="fas fa-users"></i> Member3
    </a>
</div>
<div class="center-content">
   
</div>

<script>

window.addEventListener('resize', function() {
    let zoomLevel = window.devicePixelRatio;
    let sidebar = document.querySelector('.sidebar');
    let header = document.querySelector('.header');
    let Subheader = document.querySelector('.Sub-header');
    let Subheader1 = document.querySelector('.Sub-header1');
    
    if (zoomLevel > 1.4) {  
    
        sidebar.style.display = 'none';
        Subheader.style.display = 'none';
        Subheader1.style.display = 'none';
    } else {
 
        sidebar.style.display = 'block';
        Subheader.style.display = 'block';
        Subheader1.style.display = 'block';
    }

   
    header.style.display = 'flex';
  
});

</script>
  

    <script>
        const toggleBtn = document.querySelector('.toggle-btn');
        const sidebar = document.querySelector('.sidebar');
        const header = document.querySelector('.header');
        const header1 = document.querySelector('.Sub-header1');
        const header2 = document.querySelector('.Sub-header');
        const content = document.querySelector('.content');
        
        toggleBtn.addEventListener('click', function() {
            if (sidebar.style.transform === 'translateX(-230px)') {
                sidebar.style.transform = 'translateX(0)';
                header.style.left = '230px';
                header.style.width = 'calc(100% - 230px)';
                header1.style.left = '230px';
                header1.style.width = 'calc(100% - 230px)';
                header2.style.left = '230px';
                header2.style.width = 'calc(100% - 230px)';
                content.classList.remove('adjust');
            } else {
                sidebar.style.transform = 'translateX(-230px)';
                header.style.left = '0';
                header.style.width = '100%';
                header1.style.left = '0';
                header1.style.width = '100%';
                header2.style.left = '0';
                header2.style.width = '100%';
                content.classList.add('adjust');
            }
        });

        document.querySelectorAll('.menu-item').forEach(item => {
            item.addEventListener('click', function() {
                const submenu = this.nextElementSibling;
                const arrow = this.querySelector('.arrow');
                submenu.style.display = (submenu.style.display === 'block') ? 'none' : 'block';
                arrow.classList.toggle('rotate');
            });
        });
        document.querySelector(".toggle-btn").addEventListener("click", function() {
            this.classList.toggle("active");
            if (this.classList.contains("active")) {
                this.innerHTML = "&#9655;";
            } else {
                this.innerHTML = "&#9665;"; 
            }
        });

    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pzjw8f+ua7Kw1TIq0v8fGTrt9D6rW9A9zX9yz8y2wWwRk5rzm76m09L+mFw1xXft" crossorigin="anonymous"></script>
</body>
</html>
