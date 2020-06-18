<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<strong>
welcome User:
<%
out.println(request.getSession().getAttribute("NameServlet"));
%>


<p> ${message} </p>
</strong>

<form action="TransferFund" method="post">  <!-- Servlets ke naam -->
<input type="text" placeholder="enter ContactNo" name="transferCNo">Enter Contact Number to transfer<br>
<input type="text" placeholder="enter amount" name="transferAmount">Enter Amount to Transfer <br>
<input type="submit" value="SUBMIT">
</form>

</body>
</html>