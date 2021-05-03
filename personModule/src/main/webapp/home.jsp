<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>


</head>
<body>
<div>${word}</div>
<%= request.getAttribute("word") %>
<b>
<h1 id="myZagolovokOne">Helllo Guuuuys</h1></b>



<form action="home" method="post">
    Input your Login and password <br>
    <p><strong>Login:</strong> <input type="text" name="login" value="admin"/>
    <p><strong>Password:</strong> <input type="password" name="password" value="admin"/><br>
      <button>Authorization</button></form>


<br>


</body>
</html>