<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>

    <form:form method="post" action="${pageContext.servletContext.contextPath}/Messageotpsend" modelAttribute="memberDetails">
        <label for="jsonformat">Json Input</label>
        <input type="text" id="Mobileno" name="Mobile" required><br>

        <button id="Send" class="button-86" type="submit">Send</button>
    </form:form>

    <!-- Display response message here -->
    <c:if test="${not empty response}">
        <p>Response: ${response}</p>
    </c:if>

</body>
</html>
