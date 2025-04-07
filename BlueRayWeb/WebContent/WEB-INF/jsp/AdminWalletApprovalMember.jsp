<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Wallet Approval Module</title>
    <style>
        body {
            background-color: #f4f4f4;
        }

    h1 {
    text-align: center;
    font-size: 2.5em;
    margin: 20px 0;
    background: linear-gradient(to right, red, orange, red, green, blue, indigo, yellow); 
    -webkit-background-clip: text; 
    color: transparent; 
    text-transform: uppercase;
    letter-spacing: 2px;
    font-weight: bold; 
    border-bottom: 3px solid red;
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
            padding: 16px 20px;
            text-align: left;
            border: 1px solid #ddd;
        }

        th {
            background-color: #ff5b00;
            color: white;
            border-bottom: 2px solid #f0f0f0;
        }

        tr:nth-child(even) {
            background-color: #ecf0f1;
        }

        tr:hover {
            background-color: #e1e8e8;
        }

        .approve-btn {
            background-color: blue;
            color: white;
            border: none;
            padding: 8px 15px;
            font-size: 14px;
            cursor: pointer;
            border-radius: 20px;
            transition: background-color 0.3s;
        }

        .approve-btn:hover {
            background-color: yellow;
        }

         .more-details-btn {
            background-color: yellow;
            color: black;
            border: none;
            padding: 8px 15px;
            font-size: 14px;
            cursor: pointer;
            border-radius: 20px;
            transition: background-color 0.3s;
        }

        .more-details-btn:hover {
            background-color: red;
        }

        .no-members {
            text-align: center;
            font-size: 18px;
            color: #ff4d4d;
        }

 
          .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.7);
            padding-top: 60px;
            animation: fadeIn 0.5s ease-out;
        }

        .modal-content {
    background-color: #00ffea;
background-image: url("https://www.transparenttextures.com/patterns/batthern.png");
            margin: 5% auto;
            padding: 20px;
            border-radius: 20px;
            box-shadow: 0px 8px 20px rgba(0, 0, 0, 0.1);
            width: 90%;
            max-width: 300px;
            position: relative;
            border: 10px solid #ff9800;
            border-top: 30px solid #ff9800;
            border-bottom: 50px solid #ff9800;
        }

       

        .close {
        background-color: #ff4d4d;
            color: white;
            font-size: 30px;
            font-weight: bold;
            cursor: pointer;
            border-radius: 50%;
            padding: 8px;
        }

        .close:hover, .close:focus {
            background-color: blue;
            color: white;
        }

        .modal-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }

        .modal-table th, .modal-table td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        .modal-table th {
            background-color: #34495e;
            color: white;
        }
 .modal-icons {
            position: absolute;
            bottom: -40px;
            left: 50%;
            transform: translateX(-50%);
            display: flex;
            gap: 20px;
        }

        .modal-icons i {
            font-size: 20px;
            color: #fff;
            cursor: pointer;
        }
        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }

       
        @media (max-width: 768px) {
            .modal-content {
                width: 90%;
                padding: 20px;
            }

            .modal-table th, .modal-table td {
                font-size: 12px;
            }

            .close {
                font-size: 25px;
            }
        }
 .Approved {
            background-color: blue;
            background-image: url("https://www.transparenttextures.com/patterns/3px-tile.png");
            color: white;
            font-weight: bold;
        }

        .NotApproved {
            background-color: #ff0000;
            background-image: url("https://www.transparenttextures.com/patterns/3px-tile.png");
            color: white;
            font-weight: bold;
        }
    </style>
</head>
<body>

    <jsp:include page="AdminHeader.jsp" />

    <div class="container">
        <h1>Wallet Approval Module</h1>
        <table>
            <thead>
                <tr>
                    <th>S.No</th>
                    <th>RegId</th>
                    <th>Name</th>
                    <th>Mobile</th>
                    <th>BankName</th>
                    <th>Amount</th>
                    <th>Payment Mode</th>
                    <th>Payment Date</th>
                    <th>Remarks</th>
                    <th>Status</th>
                    <th>View</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${not empty members}">
                <c:forEach var="member" items="${members}" varStatus="status">
    <tr>
        <td>${status.index + 1}</td>
        <td>${member.regId}</td>
        <td>${member.name}</td>
        <td>${member.mobile}</td>
        <td>${member.bankName}</td>
        <td>${member.amount}</td>
        <td>${member.paymentMode}</td>
        <td>${member.paymentDate}</td>
        <td>${member.remarks}</td>
        <td class="${member.status == 'Approved' ? 'Approved' : 'NotApproved'}">${member.status1}</td>
        <td>
            <button class="more-details-btn" onclick="showMoreDetails('${member.shopAddress}', '${member.bankName}', '${member.balance}', '${member.amount}', '${member.referenceNo}', '${member.paymentMode}', '${member.paymentDate}', '${member.pin}')">More Details</button>
        </td>
        
       <td>
    <form action="${pageContext.servletContext.contextPath}/AdminUpdateWalletApproved" method="post">
        <input type="hidden" name="pin" value="${member.pin}" />
        <input type="hidden" name="bankName" value="${member.bankName}" />
        <input type="hidden" name="balance" value="${member.balance}" />
        <input type="hidden" name="amount" value="${member.amount}" />
        <input type="hidden" name="referenceNo" value="${member.referenceNo}" />
        <input type="hidden" name="paymentMode" value="${member.paymentMode}" />
        <input type="hidden" name="paymentDate" value="${member.paymentDate}" />
         <input type="hidden" name="remarks" value="${member.remarks}" />
        <button class="approve-btn" type="submit">Approve</button>
    </form>
</td>


       
    </tr>
</c:forEach>

                </c:if>
                <c:if test="${empty members}">
                    <tr>
                        <td colspan="12" class="no-members">No members available</td>
                    </tr>
                </c:if>
            </tbody>
        </table>
    </div>

   
    <div id="myModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal()">&times;</span>
            <h2 style="text-align: center; color: #34495e;">Member Details</h2>
            <table class="modal-table">
             
                <tr>
                
                   
                    <th>Shop Address</th>
                    <td id="shopAddress"> </td>
                    
                </tr>
                <tr>
                    <th>Bank Name</th>
                    <td id="bankName"></td>
                </tr>
                <tr>
                    <th>Balance</th>
                    <td id="balance"></td>
                </tr>
                <tr>
                    <th>Amount</th>
                    <td id="amount"></td>
                </tr>
                <tr>
                    <th>Reference No</th>
                    <td id="refNo"></td>
                </tr>
                <tr>
                    <th>Payment Mode</th>
                    <td id="paymentMode"></td>
                </tr>
                <tr>
                    <th>Payment Date</th>
                    <td id="paymentDate"></td>
                </tr>
                <tr>
                    <th>Pin</th>
                    <td id="pin"></td>
                </tr>
            </table>
             <div class="modal-icons">
                <i class="fas fa-home"></i>
                <i class="fas fa-user"></i>
                <i class="fas fa-cog"></i>
            </div>
        </div>
    </div>

    <script>
        function showMoreDetails( shopAddress, bankName, balance, amount, refNo, paymentMode, paymentDate, pin) {
        	
        	document.getElementById("shopAddress").innerText = shopAddress;
            document.getElementById("bankName").innerText = bankName;
            document.getElementById("balance").innerText = balance;
            document.getElementById("amount").innerText = amount;
            document.getElementById("refNo").innerText = refNo;
            document.getElementById("paymentMode").innerText = paymentMode;
            document.getElementById("paymentDate").innerText = paymentDate;
            document.getElementById("pin").innerText = pin;
            document.getElementById("myModal").style.display = "block";
        }

        function closeModal() {
            document.getElementById("myModal").style.display = "none";
        }
    </script>

</body>
</html>
