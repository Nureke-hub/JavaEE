<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="DB.Footballer" %>
<%@ page import="DB.DBManager" %>
<html>
<head>
    <title>Detail</title>
</head>
<body style="padding-left: 40%; padding-top: 15%">
<%
    Footballer f = (Footballer)request.getAttribute("footballer");
%>
<form action="/deleteServlet", method="get">
    <h3><%=f.getName()%> <%=f.getSurname()%> </h3>
    <label>Club:</label>
    <label><%=f.getClub()%></label><br>
    <label>Annual salary:</label>
    <label><%=f.getSalary()%></label><br>
    <label>Transfer price:</label>
    <label><%=f.getTransferPrice()%></label><br>
    <%
        int i = Integer.parseInt(String.valueOf(request.getAttribute("footballer_index")));
    %>
    <a href="/deleteServlet?footballer_index=<%=i%>">
        Delete
    </a><br>
    <a href="/list">Back</a>
</form>
</body>
</html>

