package Servlets.Friend;

import DB.Classes.User;
import DB.Managers.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/operation_with_friend")
public class OperationsWithFriendServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null){
            Long id = Long.parseLong(request.getParameter("id"));
            if(request.getParameter("delete") == ""){
                DBManager.deleteFriend(user.getId(), id);
            }else if(request.getParameter("confirm") == ""){
                DBManager.confirmFriendRequest(user.getId(), id);
            }else if(request.getParameter("reject") == ""){
                DBManager.rejectFriendRequest(user.getId(), id);
            }else if(request.getParameter("add") ==""){
                DBManager.addToFriend(user.getId(), id);
            }else if(request.getParameter("unsubscribe") == ""){
                DBManager.deleteMyRequest(user.getId(), id);
            }
            response.sendRedirect("/myFriends");
        }else{
            response.sendRedirect("/Home");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
