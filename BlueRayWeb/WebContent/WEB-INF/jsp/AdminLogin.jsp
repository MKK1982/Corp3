<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Admin Login</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <style>
        body {
            margin: 0;
            height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
         
            background: linear-gradient(45deg, white 50%, #00ffc4 50%);
            background-size: 100% 100%;
        }

        .login-box {
            padding: 30px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            background: linear-gradient(45deg, #00ffc4 55%, white 45%);
            background-size: 100% 100%;
            border-radius: 12px;
            box-shadow: 0px 8px 30px rgba(0, 0, 0, 0.1);
            width: 350px;
            text-align: center;
            transition: transform 0.3s ease;
        }

        .login-box:hover {
            transform: scale(1.05);
        }

        .login-box img {
            height: 60px;
            margin-bottom: 20px;
        }
 h1 {
    font-size: 36px;
    margin-bottom: 20px;
}

.blueray {

    font-weight: bold;
    color: white;
}

.fintech {

    font-weight: bold;
    color: white;
}

        h2 {
            font-size: 24px;
            margin-bottom: 20px;
            font-weight: 600;
            color: #333;
        }

        label {
            font-size: 16px;
            margin-bottom: 8px;
            font-weight: 600;
            color: #333;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 12px;
            margin-bottom: 20px;
            border-radius: 8px;
            border: 1px solid #ccc;
            font-size: 16px;
            transition: border-color 0.3s ease;
               background: linear-gradient(45deg, white  60%,  #00ffc4 40%);
        }
 
        input[type="text"]:focus,
        input[type="password"]:focus {
            border-color: #00ffc4;
            outline: none;
        }

.button-box {
  display: flex;
  align-items: center;
  justify-content: center;

}
.button-86 {
  all: unset;
  width: 100px;
  height: 30px;
  font-size: 16px;
  background: transparent;
  border: none;
  position: relative;
  color: black;
  cursor: pointer;
  z-index: 1;
  padding: 10px 20px;
  display: flex;
  align-items: center;
  justify-content: center;
  white-space: nowrap;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  font-weight:bold;
}

.button-86::after,
.button-86::before {
  content: '';
  position: absolute;
  bottom: 0;
  right: 0;
  z-index: -99999;
  transition: all .4s;
}

.button-86::before {
  transform: translate(0%, 0%);
  width: 100%;
  height: 100%;
  background: white;
  border-radius: 10px;
}

.button-86::after {
  transform: translate(10px, 10px);
  width: 35px;
  height: 35px;
  background: #ff000082;
  backdrop-filter: blur(5px);
  -webkit-backdrop-filter: blur(5px);
  border-radius: 50px;

}

.button-86:hover::before {
  transform: translate(5%, 20%);
  width: 110%;
  height: 110%;
}

.button-86:hover::after {
  border-radius: 10px;
  transform: translate(0, 0);
  width: 100%;
  height: 100%;
}

.button-86:active::after {
  transition: 0s;
  transform: translate(0, 5%);
}
    </style>
      <script>
      
 
           
            <c:if test="${not empty success}">
                alert("${success}");
            </c:if>

            <c:if test="${not empty error}">
                alert("${error}");
            </c:if>
      
    </script>
</head>
<body>
      <h1><span class="blueray">BlueRay</span> <span class="fintech">Fintech</span></h1>

    <div class="login-box">
       <img src="${pageContext.servletContext.contextPath}/resources/Images/blueray.png" alt="logo">
        <h2>Admin Login</h2>
     <form:form method="post" action="${pageContext.servletContext.contextPath}/AdminLogin" modelAttribute="memberDetails">

  
             
        
          <label for="loginPin">Login Pin</label>
            <input type="text" id="loginPin" name="Login_Pin" required><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>
            <div class="button-box">
<button id="btnLogin" class="button-86" type="submit">Login</button>
          </div> 
        </form:form>
    </div>
</body>
</html>
