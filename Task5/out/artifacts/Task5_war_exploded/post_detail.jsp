<%@ page import="DB.Classes.Post" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post detail</title>
    <%@include file="imports/head.jsp"%>
</head>
<body>
    <%@include file="imports/autentificate_navbar.jsp"%>
    <%
        Post p = (Post)request.getAttribute("post");
    %>

    <div class="container">
        <div class="row">
            <%@include file="imports/AccountMenu.jsp"%>
            <div class="col-sm-6 mt-3">
                <div class="jumbotron">
                    <h1 class="display-8"><%=p.getTitle()%></h1>
                    <p class="lead"><%=p.getShort_content()%></p>
                    <hr class="my-4">
                    <p><%=p.getContent()%></p>
                    <hr class="my-4">
                    <p>Posted on <%=p.getPost_date()%></p>

                    <%
                        if(p.getUser().getId() == user.getId()){
                    %>
                        <p class="lead">
                            <button class="btn" style="background-color: rgb(24,11,122); color: white" data-toggle="modal" data-target="#edit_post">Edit</button>
                            <a href="/post_delete?post_id=<%=p.getId()%>" class="btn btn-danger" style="color: white" >Delete</a>
                        </p>
                    <%
                        }
                    %>

                </div>
            </div>
            
            <div class="col-sm-3 mt-3">
                <%@include file="imports/latest_birthdays.jsp"%>
            </div>
        </div>
    </div>
    <%@include file="modals/edit_post_modal.jsp"%>
</body>
</html>
