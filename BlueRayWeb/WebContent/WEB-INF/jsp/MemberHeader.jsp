<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Member Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
    <style>
        :root {
            --primary-gradient: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            --secondary-gradient: linear-gradient(135deg, #ff6b6b 0%, #ff8e53 100%);
            --sidebar-width: 280px;
        }

        body {
            font-family: 'Poppins', sans-serif;
            background: #f8fafc;
        }

        /* Enhanced Sidebar */
        .sidebar {
            position: fixed;
            top: 0;
            left: 0;
            bottom: 0;
            width: var(--sidebar-width);
            background: var(--primary-gradient);
            color: white;
            padding: 20px;
            z-index: 1000;
            transition: 0.4s cubic-bezier(0.4, 0, 0.2, 1);
            box-shadow: 4px 0 15px rgba(0,0,0,0.1);
        }

        .sidebar.hide {
            width: 80px;
            padding: 20px 10px;
        }

        .sidebar-header {
            display: flex;
            align-items: center;
            margin-bottom: 40px;
        }

        .brand-logo {
            width: 40px;
            margin-right: 15px;
        }

     .menu-item {
    position: relative;
    padding: 15px;
    margin: 12px 0; /* Increased spacing between menu items */
    cursor: pointer;
    display: flex;
    align-items: center;
    background: rgba(255,255,255,0.1);
    border-radius: 12px;
    transition: all 0.3s ease;
}

        .menu-item:hover {
            background: rgba(255,255,255,0.2);
            transform: translateX(5px);
        }

        .menu-item.active {
            background: var(--secondary-gradient);
            box-shadow: 0 4px 15px rgba(255,107,107,0.4);
        }

        .menu-item i {
            font-size: 1.4rem;
            min-width: 40px;
            transition: 0.3s;
        }

        .menu-item span {
            transition: 0.3s;
        }
   .submenu {
    position: absolute;
    top: calc(100% + 10px); /* Added space between menu and submenu */
    left: 0;
    width: 100%;
    background: rgba(0, 0, 0, 0.2);
    border-radius: 12px;
    max-height: 0;
    overflow: hidden;
    transition: max-height 0.3s ease-out;
    padding: 0;
    box-shadow: 0 4px 15px rgba(0,0,0,0.1);
    margin-top: 5px; /* Additional spacing */
}

       .submenu-item {
    padding: 12px 20px;
    color: rgba(255,255,255,0.9);
    transition: all 0.2s ease;
    cursor: pointer;
    display: block;
    margin: 5px 0; /* Space between submenu items */
}

        .submenu-item:hover {
            background: rgba(255,255,255,0.1);
            padding-left: 25px;
        }
        .menu-item.expanded .submenu {
    max-height: 500px;
    padding: 10px 0;
}
        .submenu-item {
            padding: 12px 0;
            color: rgba(255,255,255,0.8);
            transition: 0.2s ease;
            cursor: pointer;
        }

        .submenu-item:hover {
            color: white;
            transform: translateX(5px);
        }

        .menu-item .bi-chevron-down {
            transition: transform 0.3s ease;
            position: absolute;
            right: 15px;
        }

        .menu-item.expanded .bi-chevron-down {
            transform: rotate(180deg);
        }

        /* Header Styles */
        .header {
            position: fixed;
            top: 0;
            left: var(--sidebar-width);
            right: 0;
            height: 60px;
            background: white;
            box-shadow: 0 4px 20px rgba(0,0,0,0.05);
            z-index: 999;
            display: flex;
            align-items: center;
            padding: 0 25px;
            transition: 0.4s cubic-bezier(0.4, 0, 0.2, 1);
        }

        .header.shrink {
            left: 80px;
        }

        /* Main Content */
        .main-content {
            margin-left: var(--sidebar-width);
            padding: 30px;
            margin-top: 80px;
            transition: 0.4s cubic-bezier(0.4, 0, 0.2, 1);
        }

        .dashboard-card {
            background: white;
            border-radius: 20px;
            padding: 25px;
            box-shadow: 0 5px 25px rgba(0,0,0,0.05);
            transition: 0.3s ease;
        }

        .dashboard-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 15px 30px rgba(0,0,0,0.1);
        }

        /* Toggle Button */
        .toggle-btn {
            position: absolute;
            top: 25px;
            right: -20px;
            background: white;
            color: #667eea;
            border: none;
            padding: 10px;
            border-radius: 12px;
            cursor: pointer;
            transition: 0.3s ease;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        }

        .toggle-btn:hover {
            background: #667eea;
            color: white;
        }

        /* Collapsed Sidebar Styles */
        .sidebar.hide .menu-item span {
            display: none;
        }
.sidebar.hide .submenu {
            display: none;
        }

        .sidebar.hide .menu-item.expanded {
            border-radius: 12px;
        }
        .sidebar.hide .menu-item:hover span {
            display: block;
            position: absolute;
            left: 100%;
            top: 50%;
            transform: translateY(-50%);
            background: var(--primary-gradient);
            color: white;
            padding: 8px 15px;
            border-radius: 8px;
            white-space: nowrap;
            margin-left: 15px;
            box-shadow: 2px 2px 10px rgba(0,0,0,0.1);
            z-index: 1000;
            animation: slideIn 0.3s ease;
        }

        @keyframes slideIn {
            from { opacity: 0; margin-left: 10px; }
            to { opacity: 1; margin-left: 15px; }
        }
    </style>
</head>
<body>

<!-- Sidebar -->
<div class="sidebar" id="sidebar">
    <div class="sidebar-header">
       
        <h4 class="mb-0 font-weight-bold">Blueray Fintech</h4>
    </div>

    <div class="menu-list">
        <div class="menu-item active">
            <i class="bi bi-speedometer2"></i>
            <span>Dashboard</span>
            
        </div>

        <div class="menu-item">
            <i class="bi bi-arrow-repeat"></i>
            <span>Transactions</span>
            <i class="bi bi-chevron-down"></i>
            <div class="submenu">
                <div class="submenu-item">Recent</div>
                <div class="submenu-item">History</div>
                <div class="submenu-item">Statistics</div>
            </div>
        </div>

        <div class="menu-item">
            <i class="bi bi-bar-chart-line"></i>
            <span>Analytics</span>
            <i class="bi bi-chevron-down"></i>
            <div class="submenu">
                <div class="submenu-item">Sales</div>
                <div class="submenu-item">Users</div>
                <div class="submenu-item">Performance</div>
            </div>
        </div>

        <div class="menu-item">
            <i class="bi bi-file-earmark-text"></i>
            <span>Reports</span>
        </div>

        <div class="menu-item">
            <i class="bi bi-gear"></i>
            <span>Settings</span>
            <i class="bi bi-chevron-down"></i>
            <div class="submenu">
                <div class="submenu-item">Profile</div>
                <div class="submenu-item">Security</div>
                <div class="submenu-item">Notifications</div>
            </div>
        </div>
    </div>

    <button class="toggle-btn" onclick="toggleSidebar()">
        <i class="bi bi-chevron-double-left"></i>
    </button>
</div>

<!-- Header -->
<nav class="header" id="header">
    <div class="d-flex justify-content-between w-100">
        <h4 class="mb-0 font-weight-bold text-primary">Member Portal</h4>
        <div class="d-flex align-items-center">
            <button class="btn btn-light mr-3"><i class="bi bi-bell"></i></button>
            <div class="user-profile">
                <img src="https://via.placeholder.com/40" alt="User" class="rounded-circle">
            </div>
        </div>
    </div>
</nav>

<!-- Main Content -->


    <div class="chart-container mt-4">
        <h5 class="mb-3">Revenue Overview</h5>
        <div style="height: 400px; background: #f8fafc; border-radius: 15px;"></div>
    </div>
</div>

<script>
    function toggleSidebar() {
        const sidebar = document.getElementById('sidebar');
        const header = document.getElementById('header');
        const mainContent = document.getElementById('main-content');
        const toggleIcon = document.querySelector('.toggle-btn i');

        sidebar.classList.toggle('hide');
        header.classList.toggle('shrink');
        mainContent.classList.toggle('shrink');

        if(sidebar.classList.contains('hide')) {
            toggleIcon.classList.replace('bi-chevron-double-left', 'bi-chevron-double-right');
        } else {
            toggleIcon.classList.replace('bi-chevron-double-right', 'bi-chevron-double-left');
        }
    }

    // Submenu Handling
  document.querySelectorAll('.menu-item').forEach(item => {
    item.addEventListener('click', function(e) {
        const hasSubmenu = this.querySelector('.submenu');
        const isExpanded = this.classList.contains('expanded');

        // Close all other menus
        document.querySelectorAll('.menu-item').forEach(i => {
            if(i !== this) {
                i.classList.remove('expanded', 'active');
            }
        });

        if(hasSubmenu) {
            this.classList.toggle('expanded');
            e.preventDefault();
            e.stopPropagation();
        } else {
            this.classList.add('active');
        }
    })
});
        // Close menus when clicking outside
       document.addEventListener('click', function(e) {
    if(!e.target.closest('.menu-item') && !e.target.closest('.submenu')) {
        document.querySelectorAll('.menu-item').forEach(item => {
            item.classList.remove('expanded');
        });
    }
});

    // Active menu item management
  document.querySelectorAll('.submenu-item').forEach(item => {
    item.addEventListener('click', function(e) {
        e.stopPropagation();
        document.querySelectorAll('.submenu-item').forEach(i => i.classList.remove('active'));
        this.classList.add('active');
    })
});
</script>

</body>
</html>