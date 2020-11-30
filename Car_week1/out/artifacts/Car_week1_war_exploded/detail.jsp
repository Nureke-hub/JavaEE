<%@ page import="DB.Car" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Detail</title>
    </head>
    <body style="padding-left: 40%; padding-top: 15%">
    <%
        Car car = (Car)request.getAttribute("car");
    %>
    <form action="/deleteServlet", method="get">
        <h3><%=car.getName()%> <%=car.getModel()%> </h3>
        <label>price:</label>
        <label><%=car.getPrice()%></label><br>
        <label>year:</label>
        <label><%=car.getYear()%></label><br>

        <a href="/deleteServlet?car_id=<%=car.getId()%>">
            Delete
        </a><br>
        <a href="/mainPageServlet">Back</a>
    </form>
    </body>
</html>
