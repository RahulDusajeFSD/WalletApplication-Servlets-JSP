<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment wallet application</title>
</head>
<body>
<strong> Select one of the following</strong>
<form action="CommonServlet" method="post">


<input type="radio" name="rb" value="createAcc">
<label for="createAcc">Create Account</label><br>

 
<input type="radio" name="rb" value="Login">
<label for="Login">Login</label><br>


<input type="submit" value="SUBMIT">
</form>

</body>
</html>