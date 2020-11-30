<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Friends</title>
    <%@include file="imports/head.jsp"%>
</head>
<body>
    <%ArrayList<User> my_friends = (ArrayList<User>) request.getAttribute("myFriends");%>
    <%ArrayList<User> friends_requests = (ArrayList<User>) request.getAttribute("friends_requests");%>
    <%ArrayList<User> other_users = (ArrayList<User>) request.getAttribute("other_users");%>
    <%ArrayList<User> my_requests = (ArrayList<User>) request.getAttribute("my_requests");%>

    <%String search_text = (String) request.getAttribute("search_text");%>

    <%@include file="imports/autentificate_navbar.jsp"%>
    <div class="container">
        <div class="row">
            <%@include file="imports/AccountMenu.jsp"%>
            <div class="col-sm-6">
                <div class="card mt-3">
                    <div class="card-body">
                        <form method="get" action="/search_friends">
                            <div class="row">
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="search_text" placeholder="Search Friends">
                                </div>
                                <div class="col-sm-3">
                                    <button type="submit" class="btn" style="background-color: rgb(24,11,122); color: white">Search</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

                <%
                    if(search_text != null){
                %>
                        <div class="card mt-3">
                            <div class="card-body">
                                <h5 class="card-title">Search results for: <%=search_text%></h5>
                            </div>
                        </div>
                <%}%>

                <nav class="mt-3">
                    <div class="nav nav-tabs" id="nav-tab" role="tablist">
                        <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">Friends</a>
                        <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">Friends requests</a>
                    </div>
                </nav>
                <div class="tab-content" id="nav-tabContent">
                    <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                        <%for (User u: my_friends) {%>
                            <div class="card mt-3">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <a href="user_profile?id=<%=u.getId()%>&friend">
                                                <img src="<%=u.getPicture_url()%>" width="100px" height="100" style="border-radius: 50%">
                                            </a>
                                        </div>
                                        <div class="col-sm-9">
                                            <h5 class="card-title"><%=u.getFull_name()%></h5>
                                            <p class="card-text"><%=u.getBirth_date()%></p>
                                            <a href="#" class="btn" style="background-color: rgb(24,11,122); color: white" >Send message</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        <%}%>
                    </div>

                    <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                        <%for (User u: friends_requests) {%>
                            <div class="card mt-3">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <a href="user_profile?id=<%=u.getId()%>&n_friend">
                                                <img src="<%=u.getPicture_url()%>" width="100px" height="100" style="border-radius: 50%">
                                            </a>
                                        </div>
                                        <div class="col-sm-9">
                                            <h5 class="card-title"><%=u.getFull_name()%></h5>
                                            <p class="card-text"><%=u.getBirth_date()%></p>
                                            <div class="row">
                                                <form action="/operation_with_friend?id=<%=u.getId()%>&confirm" method="post">
                                                    <button class="btn" style="background-color: rgb(24,11,122); color: white" type="submit">Confirm</button>
                                                </form>
                                                <form action="/operation_with_friend?id=<%=u.getId()%>&reject" method="post">
                                                    <button type="submit" class="btn ml-3" style="background-color: rgb(24,11,122); color: white">Reject</button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        <%}%>
                    </div>

                    <hr>


                    <%
                        if (search_text != null){
                    %>
                            <h3>Other users</h3>
                    <%for (User u: my_requests) {%>
                    <div class="card mt-3">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-3">
                                    <a href="user_profile?id=<%=u.getId()%>&unsubscribe">
                                        <img src="<%=u.getPicture_url()%>" width="100px" height="100" style="border-radius: 50%">
                                    </a>
                                </div>
                                <div class="col-sm-9">
                                    <h5 class="card-title"><%=u.getFull_name()%></h5>
                                    <p class="card-text"><%=u.getBirth_date()%></p>
                                    <form action="/operation_with_friend?id=<%=u.getId()%>&unsubscribe" method="post">
                                        <button type="submit" class="btn ml-3" style="background-color: rgb(24,11,122); color: white">Unsubscribe</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%}%>

                    <%for (User u: other_users) {%>
                    <div class="card mt-3">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-3">
                                    <a href="user_profile?id=<%=u.getId()%>&add">
                                        <img src="<%=u.getPicture_url()%>" width="100px" height="100" style="border-radius: 50%">
                                    </a>
                                </div>
                                <div class="col-sm-9">
                                    <h5 class="card-title"><%=u.getFull_name()%></h5>
                                    <p class="card-text"><%=u.getBirth_date()%></p>
                                    <form action="/operation_with_friend?id=<%=u.getId()%>&add" method="post">
                                        <button type="submit" class="btn ml-3" style="background-color: rgb(24,11,122); color: white">Add to friends</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%}%>

                    <%}%>

                </div>


            </div>

            <div class="col-sm-3 mt-3">
                <%@include file="imports/latest_birthdays.jsp"%>
            </div>

        </div>
    </div>
</body>
</html>
