<%@ page import="java.util.ArrayList" %>
<%@ page import="db.classes.Languages" %>
<%@ page import="db.classes.Publications" %>
<%@ page import="db.classes.News" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Main</title>
    <%@include file="views/head.jsp"%>
    <%String style = (String) request.getAttribute("style");%>
    <style>
        <%if(style.equals("2")){%>
        <%@include file="views/css/style2.css"%>
        <%}else if(style.equals("3")){%>
        <%@include file="views/css/style3.css"%>
        <%}else if(style.equals("4")){%>
        <%@include file="views/css/style4.css"%>
        <%}else if(style.equals("5")){%>
        <%@include file="views/css/style5.css"%>
        <%}else if(style.equals("6")){%>
        <%@include file="views/css/style6.css"%>
        <%}else{%>
        <%@include file="views/css/style1.css"%>
        <%}%>
    </style>
</head>
<body>
    <div class="brshka">
        <%ArrayList<Languages> languages = (ArrayList<Languages>) request.getAttribute("languages");%>
        <%ArrayList<Publications> publications = (ArrayList<Publications>) request.getAttribute("publications");%>
        <%ArrayList<News> news = (ArrayList<News>) request.getAttribute("news");%>
        <%Long lang_id = Long.parseLong(String.valueOf(request.getAttribute("lang")));%>


        <%@include file="views/main/navbar.jsp"%>
        <%@include file="views/main/nav.jsp"%>

        <div class="container">
            <div class="jumbotron jumbotron-fluid">
                <div class="container">
                    <h1 class="display-4">All World News</h1>
                    <p class="lead">This is a modified jumbotron that occupies the entire horizontal space of its parent.</p>
                </div>
            </div>


            <div class="card-group">
                <%for (News n : news){%>
                <div class="card col-sm-4"  style="min-width: 500px; margin-left: 30px;">
                    <img class="card-img-top" src="<%=n.getPicture_url()%>" style="max-width: 400px; max-height: 360px;" alt="Card image cap">
                    <div class="card-body">
                        <small><a><%=n.getPublication().getName()%></a></small>
                        <h5 class="card-title"><%=n.getTitle()%></h5>
                        <small><%=n.getPost_date()%></small>

                        <p class="card-text"><%=n.getShort_content()%></p>
                        <a href="/news_detail?id=<%=n.getId()%>" class="btn btn-primary">Read more</a>
                    </div>
                </div>
                <%}%>
            </div>
        </div>
        <br><br>
    </div>
</body>
</html>
