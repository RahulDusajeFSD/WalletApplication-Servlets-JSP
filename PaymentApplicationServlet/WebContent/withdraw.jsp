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


<p>${message }</p>
</strong>

<form action="withdrawServlet" method="post">  <!-- Servlets ke naam -->
<input type="text" placeholder="enter amount" name="withdrawAmount">Enter Amount to Withdraw<br>

<input type="submit" value="SUBMIT">
</form>




</body>
</html>