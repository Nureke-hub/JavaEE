<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
    <form action="/add_ticket"  method="post" style="padding-top: 15px">
        <div style="padding-left: 40%;">
            <label>From city:</label>
            <input type="text" name="from_city"><br>

            <label>to city:</label>
            <input type="text" name="to_city"><br>

            <label>Price:</label>
            <input type="number" name="ticket_price"><br>

            <label>Duration:</label>
            <input type="number" name="ticket_duration"><br>

            <button>Add</button>
        </div>
    </form>
    </body>
</html>
