<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">

<head>
    <meta charset="UTF-8">

    <title>Add a Cont </title>
</head>
<body>
<h2>ADD a new Count</h2>

        <form style = "background-color: #BBFFAA" action="addUserCount" method="post">
            </br> <b>Owner </b><input type="text" name="owner" value="User Userovich"/>
             </br>  <b> CardNumber </b><input max="99999999" min="10000000" type="number" name="cardNumber" value=""/> enter 8 digits
              </br> <b>Sum</b>  <input type="number"  name="sum" value="0"/>  no money
              </br> <b> Validity </b> <input type="checkbox" name="validity" value="validity" checked/>validity
            </br>  </br>   <button type="submit"> Save Data</button>
        </form>

</br>

${message}
${message2}

<form action ="user" method="post">
<button  type="submit"> Cancel</button>
</form>


</body>
</html>