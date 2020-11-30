<%@ page import="java.util.ArrayList" %>
<%@ page import="db.classes.Publications" %>
<%@ page import="db.classes.News" %>
<%@ page import="db.classes.Languages" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <%@include file="views/head.jsp"%>
</head>
<body>
<%@include file="views/admin/navbar.jsp"%>
<%ArrayList<Publications> publications = (ArrayList<Publications>) request.getAttribute("publications");%>
<%ArrayList<News> news = (ArrayList<News>) request.getAttribute("news");%>
<%ArrayList<Languages> languages = (ArrayList<Languages>) request.getAttribute("languages");%>
<%String window = (String) request.getAttribute("window");%>


<div class="row">
    <div class="col-sm-3">
        <div class="nav flex-column nav-pills" style="background-color: rgb(248,249, 250)">
            <a class="nav-link" style="color: black">ADMIN PANEL</a>
            <%if (window.equals("publication")){%>
            <a class="nav-link active" style="color: white; background-color: rgb(52,58,64)" href="/index">Publications</a>
            <%}else {%>
                <a class="nav-link" style="color: black" href="/index">Publications</a>
            <%}%>

            <%if (window.equals("language")){%>
            <a class="nav-link active" style="color: white; background-color: rgb(52,58,64)" href="/languages">Languages</a>
            <%}else {%>
            <a class="nav-link" style="color: black" href="/languages">Languages</a>
            <%}%>

            <%if (window.equals("new")){%>
            <a class="nav-link active" style="color: white; background-color: rgb(52,58,64)" href="/news">News</a>
            <%}else {%>
            <a class="nav-link" style="color: black" href="/news">News</a>
            <%}%>
        </div>
    </div>

    <div class="col-sm-9">
        <div class="container">
            <nav>
                <div class="float-left">
                    <%if (window.equals("publication")){%>
                    <h3>Publications</h3>
                    <%}%>

                    <%if (window.equals("new")){%>
                    <h3>News</h3>
                    <%}%>

                    <%if (window.equals("language")){%>
                    <h3>Languages</h3>
                    <%}%>
                </div>
                <div class="float-right">
                    <button class="btn btn-success" data-toggle="modal" data-target="#add">ADD NEW</button>
                </div>
            </nav>

            <%if (window.equals("publication")){%>
            <%@include file="views/admin/modals/publication_modal.jsp"%>

            <%}else if (window.equals("new")){%>
            <%@include file="views/admin/modals/news_modal.jsp"%>

            <%}else if(window.equals("language")){%>
            <%@include file="views/admin/modals/language_modal.jsp"%>
            <%}%>

            <%-- TABLE    --%>
            <%if (window.equals("publication")){%>
            <%@include file="views/admin/tables/publication_table.jsp"%>

            <%}else if(window.equals("new")){%>
            <%@include file="views/admin/tables/news_table.jsp"%>

            <%} else if(window.equals("language")){%>
            <%@include file="views/admin/tables/language_table.jsp"%>
            <%}%>

        </div>

    </div>
</div>


</body>
</html>
