<%@ page import="DB.Ticket" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        <h2 style="text-align: center">Main page</h2>
        <div style="padding-left: 40%;">
            <%
                ArrayList<Ticket> tickets = (ArrayList<Ticket>) request.getAttribute("tickets");
                if(tickets != null){
                    for(Ticket ticket: tickets){
            %>
            <h3 style="color: rgb(55,87,39)">
                <a href="/ticket_details?ticket_id=<%=ticket.getId()%>">
                    <%=ticket.getId()%>)
                    <%=ticket.getFromCity()%> -
                    <%=ticket.getToCity()%>
                </a
            </h3>
            <%
                    }
                }
            %>
            <br>
            <a href="add_ticket.jsp" style="border: 3px solid darkblue; font-size: 25px; color: darkblue; text-decoration: none; border-radius: 5px">
                Add new ticket
            </a>
            <br>
            <%
                int pag_count = (int)request.getAttribute("pag_count");
                for(int i = 1; i <= pag_count; i++){
            %>
                <a href="/home?pag_page=<%=i%>"><%=i%></a>
            <%
                }
            %>
        </div>
    </body>
</html>
