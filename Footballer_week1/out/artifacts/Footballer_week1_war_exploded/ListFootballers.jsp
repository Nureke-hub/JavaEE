<%@ page import="java.util.ArrayList" %>
<%@ page import="DB.Footballer" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body style="text-align: center">
<h1>List of all footballers</h1>
<form action="/footballer_details" method="get">
    <%
        ArrayList<Footballer> footballers = (ArrayList<Footballer>)request.getAttribute("footballers");
        if(footballers != null){
            for(Footballer f: footballers){
    %>
    <h3 style="color: rgb(55,87,39)">
        <a href="/footballer_details?footballer_index=<%=footballers.indexOf(f)%>">
            <%=f.getSurname()%>
            <%=f.getName()%>
        </a>
    </h3>
    <%
            }
        }
    %>
</form>

<a href="index.jsp" style="border: 3px solid darkblue; font-size: 25px; color: darkblue; text-decoration: none; border-radius: 5px">
    Add new footballer
</a>
</body>
</html>

