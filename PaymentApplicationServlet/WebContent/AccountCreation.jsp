<%@page import="com.ibm.paywallet.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p> ${message}</p>
<form action="CreateAccountServlet" method="post">

 <input type="text" name="name">Name<br>
  <input type="text" name="age">Age<br>
   <input type="text" name="contactNo">ContactNo<br>
    <input type="text" name="PIN">PIN<br>
     <input type="text" name="Address">Address
     
     
     <input type="submit" value="SUMBIT">
     

</form>



</body>
</html>