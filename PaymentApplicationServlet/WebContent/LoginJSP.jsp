<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login using JSP</title>
</head>
<body>

<strong> Login </strong>
<form action="LoginServlet" method="post">  <!-- Servlets ke naam -->
<input type="text" placeholder="enter your Name" name="NameServlet"><br>
<input type="text" placeholder="enter 4 digit PIN" name="PINServlet"><br>

<input type="submit" value="LOGIN">


</form>
</body>
</html>