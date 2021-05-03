<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Count</title>
</head>
<body>

<form style = "background-color: #AABBCC" action="updateCount" method="post">
     </br> <b>Owner </b> <input type="text" name="owner" value="${updateOwner}"/>
     </br>  <b> CardNumber </b> <input type="number" name="cartNumber" value="${updateCartNumber}"/>
      </br> <b>Sum</b>  <input type="number" name="sum" value="${updateSum}"/>
       </br> <b> Validity </b>  <input type="checkbox" name="validity" value="validity" />
     </br> <button type="submit"> Save Data</button>
</form>

 </br>
 ${message}
${message2}

<form action="user" method="post">
    <button type="submit">Cancel</button>
</form>

</body>
</html>