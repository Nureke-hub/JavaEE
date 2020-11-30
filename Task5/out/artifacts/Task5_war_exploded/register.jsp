<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Registration</title>
        <%@include file="imports/head.jsp"%>
    </head>
    <body>
        <%@include file="imports/login_navbar.jsp"%>

        <%String noData = String.valueOf(request.getParameter("incorrect_data"));%>
        <%String success = String.valueOf(request.getParameter("success"));%>
        <%String exists = String.valueOf(request.getParameter("email_exists"));%>
        <%String password_incorrect = String.valueOf(request.getParameter("password_incorrect"));%>

        <div class="container col-sm-4 offset-4">
            <%if (noData != "null"){%>
                <div class="alert alert-danger" role="alert">
                    Data is not filled in correctly!
                </div>
            <%}%>

            <%if (success != "null"){%>
            <div class="alert alert-success" role="alert">
                User added successfully!
            </div>
            <%}%>

            <%if (exists != "null"){%>
            <div class="alert alert-danger" role="alert">
                User with this email already exists!
            </div>
            <%}%>

            <%if (password_incorrect != "null"){%>
            <div class="alert alert-danger" role="alert">
                Passwords are not same!
            </div>
            <%}%>

            <h3 class="card-title text-center mt-5">Create new Account</h3>
            <form class="p-4" action="/regist" method="post">
                <div class="form-group">
                    <label >Email address</label>
                    <input name="login" type="email" class="form-control" placeholder="email@example.com">
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input name = "pass" type="password" class="form-control" placeholder="Password">
                </div>
                <div class="form-group">
                    <label>Re-Password</label>
                    <input name = "re_pass" type="password" class="form-control" placeholder="Re-Password">
                </div>

                <div class="form-group">
                    <label>Full name</label>
                    <input name="full_name" type="text" class="form-control" placeholder="Name Surname">
                </div>

                <div class="form-group">
                    <label>Birth date</label>
                    <input name="birth_date" type="date" class="form-control" placeholder="1900-01-01">
                </div>

                <button type="submit" class="btn" style="background-color: rgb(24,11,122); color: white">Sign up</button>
            </form>
        </div>
    </body>
    </html>
