<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login</title>
        <%@include file="imports/head.jsp"%>
    </head>
    <body>
        <%@include file="imports/login_navbar.jsp"%>

        <%String email = String.valueOf(request.getParameter("emailError"));%>
        <%String password = String.valueOf(request.getParameter("passwordError"));%>

        <div class="container col-sm-4 offset-4">
            <%if (email != "null"){%>
                    <div class="alert alert-danger" role="alert">
                        Incorrect email
                    </div>
            <%}%>

            <%if (password != "null"){%>
                <div class="alert alert-danger" role="alert">
                    Incorrect password
                </div>
            <%}%>

            <h3 class="card-title text-center mt-5">Sign in</h3>
            <form class="p-4" action="/login" method="post">
                <div class="form-group">
                    <label for="exampleDropdownFormEmail2">Email address</label>
                    <input name="login" type="email" class="form-control" id="exampleDropdownFormEmail2" placeholder="email@example.com">
                </div>
                <div class="form-group">
                    <label for="exampleDropdownFormPassword2">Password</label>
                    <input name = "pass" type="password" class="form-control" id="exampleDropdownFormPassword2" placeholder="Password">
                </div>
                <div class="form-check mb-2">
                    <input type="checkbox" class="form-check-input" id="dropdownCheck2">
                    <label class="form-check-label" for="dropdownCheck2">
                        Remember me
                    </label>
                </div>
                <button type="submit" class="btn" style="background-color: rgb(24,11,122); color: white">Sign in</button>
            </form>
        </div>
    </body>
</html>
