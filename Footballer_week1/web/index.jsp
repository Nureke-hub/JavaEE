<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body style="padding-left: 40%; padding-top: 15%">
<a href="/list" style="border: 3px solid darkblue; font-size: 25px; color: darkblue; text-decoration: none; border-radius: 5px">
    List of all footballers
</a><br>
<form action="/add"  method="post" style="padding-top: 15px">
    <label>Name:</label>
    <input type="text" name="footballer_name"><br>

    <label>Surname:</label>
    <input type="text" name="footballer_surname"><br>

    <label>Club:</label>
    <input type="text" name="footballer_club"><br>

    <label>Annual salary:</label>
    <input type="number" name="footballer_salary"><br>

    <label>Transfer price:</label>
    <input type="number" name="footballer_transfer_price">

    <button>Add</button>
</form>
</body>
</html>
