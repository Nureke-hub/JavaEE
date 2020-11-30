package Servlets.Friend;

import DB.Classes.User;
import DB.Managers.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/myFriends")
public class MyFriendsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User)request.getSession().getAttribute("user");
        if(u != null){
            request.setAttribute("user", u);

            request.setAttribute("myFriends", DBManager.getMyFriends(u.getId()));
            request.setAttribute("friends_requests", DBManager.getFriendRequests(u.getId()));

            request.getRequestDispatcher("my_friends.jsp").forward(request, response);
        }else {
            response.sendRedirect("/Home");
        }
    }
}
