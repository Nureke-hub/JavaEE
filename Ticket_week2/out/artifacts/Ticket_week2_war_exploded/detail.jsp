<%@ page import="DB.Ticket" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <body style="padding-left: 40%; padding-top: 15%">
    <%
        Ticket ticket = (Ticket)request.getAttribute("ticket");
    %>
        <form action="/deleteServlet", method="get">
            <h3>From: <%=ticket.getFromCity()%></h3>
            <h3>To: <%=ticket.getToCity()%> </h3>
            <label>ID:</label>
            <label><%=ticket.getId()%></label><br>
            <label>price:</label>
            <label><%=ticket.getPrice()%></label><br>
            <label>Duration:</label>
            <label><%=ticket.getDuration()%></label><br>

            <a href="/deleteServlet?ticket_id=<%=ticket.getId()%>">
                Delete
            </a><br>
            <a href="/home">Back</a>
        </form>
    </body>
</html>
