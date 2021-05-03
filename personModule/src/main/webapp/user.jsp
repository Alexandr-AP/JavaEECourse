<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <title>Users List</title>
</head>

<body>

      <%
         out.println("Your IP address is " + request.getRemoteAddr());
      %>

<h2>Chek your payment cards</h2>
</br>
<table  border="6">
    <tr style = "background-color: #EEDDEE">
          <th>Owner</th>
          <th>CardNumber</th>
          <th>Sum</th>
          <th>Validity</th>
      </tr>
<c:forEach items="${countList}" var="count">
    <tr >
        <td>${count.owner}</td>
        <td>${count.cardNumber}</td>
        <td>${count.sum}</td>
        <td>${count.validity}</td>
        <td>
           <form action="updateCount" method="get">
                <input type="hidden" name="updateOwner" value="${count.owner}"/>
                <input pattern="[0-9]{8}" type="hidden" name="updateCartNumber" value="${count.cardNumber}"/>
                 <input type="hidden"  name="updateSum" value="${count.sum}"/>
                 <input type="hidden" name="updateValidity" value="{count.validity}"/>
                  <button type="submit"> Edit </button>
        </form>
        </td>
        <td>
                   <form  action="deleteCount" method="post">
                         <input type="hidden" name="deleteCartNumber" value="${count.cardNumber}"/>
                         <button type="submit"> Delete </button>
                </form>
                </td>

    </tr>
</c:forEach>
</table>

<form action ="addUserCount" method="get">

<button type="submit"> Add a new Count </button>
</form>


${word}






</body>
</html>