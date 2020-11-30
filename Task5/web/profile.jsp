<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Profile</title>
        <%@include file="imports/head.jsp"%>
    </head>
    <body>
        <%@include file="imports/autentificate_navbar.jsp"%>
        <div class="container">
            <div class="row">
                <%String not_same = String.valueOf(request.getParameter("not_same"));%>
                <%String old_not_same = String.valueOf(request.getParameter("old_not_same"));%>
                <%String success_pass = String.valueOf(request.getParameter("success_pass"));%>
                <%String success_url = String.valueOf(request.getParameter("success_url"));%>
                <%String wrong_date = String.valueOf(request.getParameter("wrong_date"));%>
                <%String wrong_full_name = String.valueOf(request.getParameter("wrong_full_name"));%>
                <%String success_prof = String.valueOf(request.getParameter("success_prof"));%>


                <%@include file="imports/AccountMenu.jsp"%>
                <div class="col-sm-6 offset-1">
                    <%if (not_same != "null"){%>
                    <div class="alert alert-danger" role="alert">
                        New passwords are not same!
                    </div>
                    <%}%>

                    <%if (old_not_same != "null"){%>
                    <div class="alert alert-danger" role="alert">
                        Old password incorrect!
                    </div>
                    <%}%>

                    <%if (success_pass != "null"){%>
                    <div class="alert alert-success" role="alert">
                        Password changed successfully!
                    </div>
                    <%}%>

                    <%if (success_url != "null"){%>
                    <div class="alert alert-success" role="alert">
                        Photo changed successfully!
                    </div>
                    <%}%>

                    <%if (success_prof != "null"){%>
                    <div class="alert alert-success" role="alert">
                        Profile changed successfully!
                    </div>
                    <%}%>

                    <%if (wrong_date != "null"){%>
                    <div class="alert alert-danger" role="alert">
                        Date incorrect!
                    </div>
                    <%}%>

                    <%if (wrong_full_name != "null"){%>
                    <div class="alert alert-danger" role="alert">
                        Full name is incorrect!
                    </div>
                    <%}%>

                    <form action="/update_profile" method="post">
                        <h3 class="card-title text-center mt-5">Edit Profile</h3>
                        <div class="form-group">
                            <label >Email address</label>
                            <label name="login" type="email" class="form-control" placeholder="email@example.com"><%=user.getEmail()%></label>
                        </div>
                        <div class="form-group">
                            <label>Full name</label>
                            <input name="full_name" type="text" class="form-control" placeholder="Name Surname" value="<%=user.getFull_name()%>">
                        </div>

                        <div class="form-group">
                            <label>Birth date</label>
                            <input name="birth_date" type="date" class="form-control" placeholder="1900-01-01" value="<%=user.getBirth_date()%>">
                        </div>
                        <button type="submit" class="btn" style="background-color: rgb(24,11,122); color: white">Update Profile</button>
                    </form>

                    <form action="/update_url" method="post">
                        <h3 class="card-title text-center mt-5">Update Photo</h3>
                        <div class="form-group">
                            <label >URL: </label>
                            <input name="picture_url" type="text" class="form-control" value="<%=user.getPicture_url()%>">
                        </div>
                        <button type="submit" class="btn" style="background-color: rgb(24,11,122); color: white">Update URL</button>
                    </form>

                    <form action="/update_pass" method="post">
                        <h3 class="card-title text-center mt-5">Update password</h3>
                        <div class="form-group">
                            <label>Type old password</label>
                            <input name = "old_pass" type="password" class="form-control" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <label>Type new password</label>
                            <input name = "new_pass" type="password" class="form-control" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <label>Re-type new Password</label>
                            <input name = "re_new_pass" type="password" class="form-control" placeholder="Re-Password">
                        </div>
                        <button type="submit" class="btn" style="background-color: rgb(24,11,122); color: white">Update password</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
