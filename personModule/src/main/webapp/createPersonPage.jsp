<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">

<head>

    <title>
        Create Person
    </title>

</head>
<body>
<h2>  Create new Person </h2>
<form action="personListPage">
    <label> name. </label>
    <input type="text" name="personNameInput" value="Dima" placeholder="please, enter name here"/>
    </br>
    <label> "age "</label>
    <input type="number" name="personAgeInput" value="99"/>
    <br/>
    <br/>
    <button type="submit"> create </button>
</form>
<form action="personListPage">
    <button type="submit"> cancel </button>
</form>
</body>

</html>

