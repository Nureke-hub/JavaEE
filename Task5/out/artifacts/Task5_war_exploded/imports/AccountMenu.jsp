<%@ page import="DB.Classes.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%User user = (User)request.getAttribute("user");%>
<div class="col-sm-3 mt-3">
    <img src="<%=user.getPicture_url()%>" style="width: 250px; border-radius: 10px;">
    <div class="list-group mt-3" style="border-style: solid; border-width: 3px; border-color: rgb(235,235,235); width: 250px;">
        <%
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = dateFormat.parse(user.getBirth_date().toString());
            String str = dateFormat.format(new Date());
            Date date2 = dateFormat.parse(str);
            long milliseconds = date2.getTime() - date1.getTime();
            int days = (int)(milliseconds / (24 * 60 * 60 * 1000));
            int years = (days /30)/12;
        %>
        <label style="text-align: center;font-weight: bold;"><%=user.getFull_name()%>, <%=years%> years</label>
        <%
            User user1 = (User)request.getSession().getAttribute("user");
            if(user.getId() == user1.getId()){
        %>
                <a href="#" class="list-group-item list-group-item-action" style="font-size: large; color: rgb(0,123,255)">My profile</a>
                <a href="/profile" class="list-group-item list-group-item-action" style="font-size: large; color: rgb(0,123,255)">Settings</a>
        <%}else{
            if(request.getAttribute("friend") != null){%>
                <form action="/operation_with_friend?id=<%=user.getId()%>&delete" method="post">
                    <button class="list-group-item list-group-item-action" type="submit" style="font-size: large; color: rgb(0,123,255)">Remove from friends</button>
                </form>
                <a href="#" class="list-group-item list-group-item-action" style="font-size: large; color: rgb(0,123,255)">Send message</a>
            <%}else if(request.getAttribute("not_friend")!= null){%>
                <form action="/operation_with_friend?id=<%=user.getId()%>&confirm" method="post">
                    <button class="list-group-item list-group-item-action" type="submit" style="font-size: large; color: rgb(0,123,255)">Confirm</button>
                </form>
                <form action="/operation_with_friend?id=<%=user.getId()%>&reject" method="post">
                    <button type="submit" class="list-group-item list-group-item-action" style="font-size: large; color: rgb(0,123,255)">Reject</button>
                </form>
                <a href="#" class="list-group-item list-group-item-action" style="font-size: large; color: rgb(0,123,255)">Send message</a>
            <%}else if(request.getAttribute("add")!= null){%>
                <form action="/operation_with_friend?id=<%=user.getId()%>&add" method="post">
                    <button class="list-group-item list-group-item-action" type="submit" style="font-size: large; color: rgb(0,123,255)">Add to friend</button>
                </form>
                <a href="#" class="list-group-item list-group-item-action" style="font-size: large; color: rgb(0,123,255)">Send message</a>
            <%}else if(request.getAttribute("unsubscribe")!= null){%>
                <form action="/operation_with_friend?id=<%=user.getId()%>&unsubscribe" method="post">
                    <button class="list-group-item list-group-item-action" type="submit" style="font-size: large; color: rgb(0,123,255)">Unsubscribe</button>
                </form>
                <a href="#" class="list-group-item list-group-item-action" style="font-size: large; color: rgb(0,123,255)">Send message</a>
            <%}%>
        <%}%>

        <a href="/logout" class="list-group-item list-group-item-action" style="font-size: large; color: rgb(143,40,57)">Logout</a>
    </div>
</div>