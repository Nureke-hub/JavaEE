<%@ page import="DB.Managers.DBManager"%>
<%
    User new_user = (User)request.getSession().getAttribute("user");
    ArrayList<User> latest_birthday_users = DBManager.getUsersByBirthDate(new_user.getId());
%>

<div class="card border-primary mb-3" style="max-width: 18rem;">
    <div class="card-header">Latest birthdays</div>
    <div class="card-body text-primary">
        <%for (int i = 0; i < 4; i++) {%>
            <p><%=latest_birthday_users.get(i).getFull_name()%> ,<%=latest_birthday_users.get(i).getBirth_date()%></p>
        <%}%>
    </div>
</div>



<div class="card border-primary mb-3" style="max-width: 18rem;">
    <div class="card-header">GAMES</div>
    <div class="card-body text-primary">
        <p>FOOTBALL ONLINE</p>
        <p>PING PONG ONLINE</p>
        <p>CHESS MASTERS</p>
        <p>RACES ONLINE</p>
        <p>TENNIS ONLINE</p>
    </div>
</div>

