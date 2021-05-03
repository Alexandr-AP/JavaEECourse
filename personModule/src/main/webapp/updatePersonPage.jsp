<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Person Page</title>
</head>
<body>
<h1> UPDATE </h1>

<form action="updatePerson" method="post">
    <input type="number" name="personID" value="${updatePersonID}"/>
    <input type="text" name="personName" value="${updatePersonName}"/>
 <input type="number" name="personAge" value="${updatePersonAge}"/>
    <button type="submit"> Save Data</button>
</form>>

<form action="admin" method="post">

    <button type="submit"> Cancel</button>
</form>>


</body>
</html>