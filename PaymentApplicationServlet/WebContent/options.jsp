<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment wallet application</title>
</head>
<body>
<%

if(request.getSession().getAttribute("PINServlet")==null)
{
	response.sendRedirect("index.jsp");
}
else
{

%>


<strong> Select one of the following</strong>
<form action="CommonServlet" method="post">        

<input type="radio"  name="rb" value="deposit">
<label for="deposit">Deposit</label><br>

<input type="radio"  name="rb" value="withdraw">
<label for="withdraw">withdraw</label><br>

<input type="radio"  name="rb" value="transferFund">
<label for="transferFund">transferFund</label><br>

<input type="radio"  name="rb" value="printPassbook">
<label for="printPassbook">printPassbook</label><br>

<input type="radio"  name="rb" value="CheckBalance">
<label for="CheckBalance">Check Balance</label><br>


<input type="radio"  name="rb" value="Logout">
<label for="Logout">Logout</label><br>

<input type="submit" value="SUBMIT">
</form>
<%
}
%>
</body>
</html>