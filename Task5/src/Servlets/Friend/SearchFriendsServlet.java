package Servlets.Friend;

import DB.Classes.User;
import DB.Managers.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/search_friends")
public class SearchFriendsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        if (user != null){
            String search_text = request.getParameter("search_text");

            ArrayList<User> friends = DBManager.getFilterFriends(user.getId(), search_text);
            ArrayList<User> friends_requests = DBManager.getFilterFriendRequests(user.getId(), search_text);
            ArrayList<User> my_requests = DBManager.getMyRequests(user.getId(), search_text);

            ArrayList<User> allUsers = DBManager.getAllUsers(search_text);

            for(User x: friends){
                for(int i = 0; i < allUsers.size(); i++){
                    if(x.getId().equals(allUsers.get(i).getId())){
                        allUsers.remove(i);
                    }
                }
            }
            for(User x: my_requests){
                for(int i = 0; i < allUsers.size(); i++){
                    if(x.getId().equals(allUsers.get(i).getId())){
                        allUsers.remove(i);
                    }
                }
            }

            for(User x: friends_requests){
                for(int i = 0; i < allUsers.size(); i++){
                    if(x.getId().equals(allUsers.get(i).getId())){
                        allUsers.remove(i);
                    }
                }
            }

            for (int i = 0; i < allUsers.size(); i++){
                if(user.getId().equals(allUsers.get(i).getId())){
                    allUsers.remove(i);
                }
            }

            request.setAttribute("user", user);
            request.setAttribute("search_text", search_text);

            request.setAttribute("myFriends", friends);
            request.setAttribute("friends_requests", friends_requests);
            request.setAttribute("my_requests", my_requests);
            request.setAttribute("other_users", allUsers);

            request.getRequestDispatcher("my_friends.jsp").forward(request, response);
        }else {
            response.sendRedirect("/Home");
        }
    }
}
