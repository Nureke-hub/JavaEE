<%@ page import="DB.Classes.Post" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Home</title>
        <%@include file="imports/head.jsp"%>
    </head>
    <body>
        <%String post_added = String.valueOf(request.getParameter("post_added"));%>
        <%String something_wrong = String.valueOf(request.getParameter("something_wrong"));%>
        <%ArrayList<Post> posts = (ArrayList<Post>) request.getAttribute("posts");%>

        <%@include file="imports/autentificate_navbar.jsp"%>
        <div class="container">
            <div class="row">
                <%@include file="imports/AccountMenu.jsp"%>
                <div class="col-sm-6 mt-3">
                    <%if (post_added != "null"){%>
                    <div class="alert alert-success" role="alert">
                        Post added successfully!
                    </div>
                    <%}%>

                    <%if (something_wrong != "null"){%>
                    <div class="alert alert-danger" role="alert">
                        Something_wrong!
                    </div>
                    <%}%>

                    <button class="btn" style="background-color: rgb(24,11,122); color: white" data-toggle="modal" data-target="#add">ADD POST</button>


                    <%for (Post p : posts) {%>
                        <div class="card mt-3">
                            <div class="card-body">
                                <h5 class="card-title"><%=p.getTitle()%></h5>
                                <p class="card-text"><%=p.getShort_content()%></p>
                                <a href="/post_detail?post_id=<%=p.getId()%>" class="btn" style="background-color: rgb(24,11,122); color: white" >More -></a>
                            </div>
                            <div class="card-footer text-muted">
                                Posted on <%=p.getPost_date()%> by <span style="color: darkblue"><%=p.getUser().getFull_name()%></span>
                            </div>
                        </div>
                    <%
                        }
                    %>
                </div>

                <div class="col-sm-3 mt-3">
                    <%@include file="imports/latest_birthdays.jsp"%>
                </div>

            </div>
        </div>
        <%@include file="modals/add_post_modal.jsp"%>
    </body>
</html>
