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

    <form:form method="post" action="${pageContext.servletContext.contextPath}/Automaticupdation" modelAttribute="memberDetails">
        <label for="jsonformat">Json Input</label>
        <input type="text" id="jsonformat" name="jsonformat" required><br>

        <button id="btnUpdate" class="button-86" type="submit">Submit</button>
    </form:form>

    <!-- Display response message here -->
    <c:if test="${not empty response}">
        <p>Response: ${response}</p>
    </c:if>

</body>
</html>
