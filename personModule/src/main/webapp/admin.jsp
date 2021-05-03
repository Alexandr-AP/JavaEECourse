<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Admin List</title>
</head>
<body>
<h1> Admin List</h1>

<%= request.getAttribute("test")%> variable here

<table>
<table border ="4">
<tr>
<th>ID</th>
<th>name</th>
<th>age</th>
</tr>

${message}

<c:forEach items="${adminList}" var="Person">
   <tr>
     <td>${Person.id}</td>
     <td>${Person.name}</td>
     <td>${Person.age}</td>
        <td>
            <form action="updatePerson" method="get">
            <input type="hidden" name="updatePersonID" value="${Person.id}">
            <input type="hidden" name="updatePersonName" value="${Person.name}">
            <input type="hidden" name="updatePersonAge" value="${Person.age}">
             <button type="submit">Edit</button>
            </form></td>
      <td>
              <form action="deletePerson" method="post">
              <input type="hidden" name="deletePersonID" value="${Person.id}">
              <button type="submit">Delete</button>
              </form></td>
   </tr>
  </c:forEach>
</table>

<form action ="addPerson" method="get">

<button type="submit"> Add new person </button>
</form>



<div>${word}</div>
</body>
</html>