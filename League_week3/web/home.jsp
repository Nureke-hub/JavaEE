<%@ page import="DB.Classes.League" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>HOME</title>
        <%@include file="includes/head.jsp"%>
    </head>
    <body style="background-color: rgb(47, 102, 117)">
        <div class="container">
            <%@include file="includes/navbar.jsp"%>
            <div class="card mt-3">
                <div class="card-body">
                    Home Page
                </div>
            </div>

            <%
                ArrayList<League> leagues = (ArrayList<League>)request.getAttribute("leagues");
                if(leagues!=null){
                    for(League league: leagues){
            %>
                        <br>
                        <div class="card">
                            <h5 class="card-header"><%=league.getName()%></h5>
                            <div class="card-body">
                                <p class="card-text"><%=league.getDescription()%></p>
                                <a href="/leagueCubs?id=<%=league.getId()%>" class="btn btn-dark">Details</a>
                            </div>
                        </div>
            <%
                    }
                }
            %>
        </div>
    </body>
</html>
