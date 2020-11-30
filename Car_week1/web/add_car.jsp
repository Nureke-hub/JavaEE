<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add car</title>
    </head>
    <body>
    <form action="/add_car"  method="post" style="padding-top: 15px">
        <div style="padding-left: 40%;">
            <label>Name:</label>
            <input type="text" name="car_name"><br>

            <label>Model:</label>
            <input type="text" name="car_model"><br>

            <label>Year:</label>
            <input type="number" name="car_year"><br>

            <label>Price:</label>
            <input type="number" name="car_price"><br>

            <button>Add</button>
        </div>
    </form>
    </body>
</html>
