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



</strong>

<form action="DepositServlet" method="post">  <!-- Servlets ke naam -->
<input type="text" placeholder="enter amount" name="depositAmount">Enter Amount<br>

<input type="submit" value="LOGIN">

</form>

</body>
</html>