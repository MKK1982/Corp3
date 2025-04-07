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
          
            background-color: #f4f4f4;
          
        }
        
        h1 {
            text-align: center;
            font-size: 2.5em;
            margin: 20px 0;
            color: #333;
            text-transform: uppercase;
            letter-spacing: 2px;
            font-weight: bold;
            border-bottom: 3px solid #ccc;
            padding-bottom: 10px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            margin-top: 20px;
        }
        th, td {
            padding: 12px 20px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #2c3e50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: lightblue;
        }
        .no-members {
            text-align: center;
            font-size: 1.2em;
            color: #555;
            padding: 20px;
        }
        .view-btn {
            background: linear-gradient(145deg, red, yellow); 
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            text-decoration: none;
            border-radius: 30px; 
            font-size: 16px; 
            font-weight: bold;
            box-shadow: 4px 4px 10px rgba(0, 0, 0, 0.1); 
            transition: all 0.3s ease;
        }
        .view-btn:hover {
            background: linear-gradient(145deg, #6a11cb, #2575fc); 
            color: red;
            transform: translateY(-4px);
            box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.2);
        }
.pagination {
    text-align: center;
    margin-top: 20px;
    filter:invert(1);
}

.pagination a {
    display: inline-block;
    margin: 0 5px;
    padding: 8px 16px;
    background-color: #f1f1f1;
    color: #333;
    text-decoration: none;
    border-radius: 4px;
}

.pagination a:hover {
    background-color: #ddd;
}

.pagination a.active {
    background-color: #4CAF50;
    color: white;
}

    </style>
    <script>
        function openDetailsPopup(regId) {
            var url = 'AdminApprovalMember1?regId=' + regId;
            window.open(url, 'DetailsPopup', 'width=800,height=600,resizable=yes');
        }
    </script>
</head>
<body>

    <jsp:include page="AdminHeader.jsp" />


    <h1>Approval Module</h1>

    <form:form method="post" action="${pageContext.servletContext.contextPath}/GetApprovalMeber" modelAttribute="MemberEntity">
        <table>
            <thead>
                <tr>
                    <th>S.No</th>                    
                    <th>Reg ID</th>
                    <th>Member Type</th>
                    <th>Mobile</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${not empty members}">
                    <c:forEach var="member" items="${members}" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${member.regId}</td>
                            <td>${member.memberType}</td>
                            <td>${member.mobile}</td>
                            <td>${member.name}</td>
                            <td>${member.email}</td>
                            <td>
                                <button type="button" class="view-btn" 
                                        onclick="openDetailsPopup('${member.regId}')">
                                    View Full Details
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${empty members}">
                    <tr>
                        <td colspan="7" class="no-members">No members available</td> <!-- Adjusted colspan to match the new column -->
                    </tr>
                </c:if>
            </tbody>
        </table>
    <!-- Pagination Controls -->
<div class="pagination">
    <c:if test="${currentPage > 1}">
        <a href="${pageContext.servletContext.contextPath}/AdminApprovalMember?page=${currentPage - 1}">Previous</a>
    </c:if>

    <c:forEach var="i" begin="1" end="${totalPages}" varStatus="status">
        <a href="${pageContext.servletContext.contextPath}/AdminApprovalMember?page=${i}" class="<c:if test='${i == currentPage}'>active</c:if>">${i}</a>
    </c:forEach>

    <c:if test="${currentPage < totalPages}">
        <a href="${pageContext.servletContext.contextPath}/AdminApprovalMember?page=${currentPage + 1}">Next</a>
    </c:if>
</div>

    </form:form>

</body>
</html>
