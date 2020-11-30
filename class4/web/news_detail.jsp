<%@ page import="db.classes.Languages" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="db.classes.Publications" %>
<%@ page import="db.classes.News" %><%--
  Created by IntelliJ IDEA.
  User: aggressiveghostsgmail.com
  Date: 9/28/20
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>News page</title>
    <%@include file="views/head.jsp"%>
</head>
<body>
<%ArrayList<Languages> languages = (ArrayList<Languages>) request.getAttribute("languages");%>
<%ArrayList<Publications> publications = (ArrayList<Publications>) request.getAttribute("publications");%>
<%ArrayList<News> news = (ArrayList<News>) request.getAttribute("news");%>
<%Long lang_id = Long.parseLong(String.valueOf(request.getAttribute("lang")));%>
<%News newObject = (News) request.getAttribute("newsObject");%>

<%@include file="views/main/navbar.jsp"%>
<%@include file="views/main/nav.jsp"%>

<div class="container">
<div class="row">
    <div class="col-sm-9">
        <div class="d-flex justify-content-center">
            <div class="card">
                <h3><%=newObject.getTitle()%></h3>
                <small><%=newObject.getPost_date()%> by <a><%=newObject.getPublication().getName()%></a></small>
                <img src="<%=newObject.getPicture_url()%>" class="card-img-top" alt="...">
                <div class="card-body">
                    <p class="card-text"><b><%=newObject.getShort_content()%></b></p>
                    <p>
                        <%=newObject.getContent()%>
                    </p>
                </div>
            </div>
        </div>
    </div>

    <div class="col-sm-3">
        <div class="container">

        <div class="card text-white bg-primary mb-3" style="max-width: 18rem;">
            <div class="card-header"><%=newObject.getPublication().getName()%></div>
            <div class="card-body">
                <p class="card-text"><%=newObject.getPublication().getDescription()%></p>
                <small><%=newObject.getPublication().getRating()%></small>
            </div>
        </div>

        <div class="btn-group-vertical">
            <a href="#">September 2020</a>
            <a href="#">October 2020</a>
            <a href="#">November 2020</a>
            <a href="#">December 2020</a>
            <a href="#">January 2021</a>
            <a href="#">February 2021</a>
        </div>
    </div>
    </div>
</div>
</div>
<br><br>
</body>
</html>
