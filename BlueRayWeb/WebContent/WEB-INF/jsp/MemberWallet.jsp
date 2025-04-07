<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wallet</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
    <style>
    

      

        .Container1 {
            width: 60%;
            margin: 40px auto;
       background-color: #002eff;
background-image: url("https://www.transparenttextures.com/patterns/concrete-wall-2.png");
            padding: 30px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
       margin-top:15%;
            margin-right:10%;
        }

        .form-row1 {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
            gap:05%;
        }

        .form-group1 {
            width: 48%;
        }

        .form-group1 label {
            font-size: 18px;
            color: white;
            margin-bottom: 6px;
            display: block;
            font-weight:bold;
        }

        .form-group1 input,
        .form-group1 select,
        .form-group1 textarea {
            width: 100%;
            padding: 10px;
            font-size: 14px;
            border: 1px solid yellow;
            border-radius: 5px;
            box-sizing: border-box;
            outline: none;
        }

        .form-group1 input:focus,
        .form-group1 select:focus,
        .form-group1 textarea:focus {
            border-color: red;
        }

        .form-group1 textarea {
            resize: vertical;
        }

        .form-group1 select {
            background-color: #f9f9f9;
        }

        .button1 {
            background-color: red;
            color: #fff;
            padding: 12px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
           
        
        }

        .button1:hover {
            background-color: #172240;
        }
.heading1{
text-align:center;
color:white;
background-color:black;

}
     
    </style>
</head>
<body>

    <jsp:include page="Header.jsp" />
<div class="center-content">

    <div class="Container1">
    <h2 class="heading1">WALLET<h2>
        <form:form method="post" action="${pageContext.servletContext.contextPath}/WalletAdd" modelAttribute="MemberEntity">
            <div class="form-row1">
                <div class="form-group1">
                    <label for="bankName">Bank</label>
                    <select name="bankName" id="bank">
                        <option value="">Select Bank</option>
                        <option value="bank1">Bank 1</option>
                        <option value="bank2">Bank 2</option>
                        <option value="bank3">Bank 3</option>
                    </select>
                </div>

                <div class="form-group1">
                    <label for="balance">Balance</label>
                    <input type="text" name="balance" id="balance" placeholder="Enter Balance">
                </div>

                <div class="form-group1">
                    <label for="amount">Amount</label>
                    <input type="number" name="amount" id="amount" placeholder="Enter Amount">
                </div>

                <div class="form-group1">
                    <label for="bank_ref_no">Bank Reference No</label>
                    <input type="text" name="referenceNo" id="bank_ref_no" placeholder="Enter Bank Reference Number">
                </div>
            </div>

            <div class="form-row1">
                <div class="form-group1">
                    <label for="payment_mode">Payment Mode</label>
                    <select name="paymentMode" id="payment_mode">
                        <option value="">Select Payment Mode</option>
                        <option value="online">Online</option>
                        <option value="cheque">Cheque</option>
                        <option value="cash">Cash</option>
                    </select>
                </div>

                <div class="form-group1">
                    <label for="payment_date">Payment Date</label>
                    <input type="date" name="paymentDate" id="payment_date">
                </div>

                <div class="form-group1">
                    <label for="remarks">Remarks</label>
                    <textarea name="remarks" id="remarks" placeholder="Enter any remarks" rows="4"></textarea>
                </div>
            </div>

            <button class="button1" type="submit">proceed</button>
        </form:form>
    </div>
 </div>

</body>
</html>
