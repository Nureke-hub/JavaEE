package Servlets.Friend;

import DB.Classes.User;
import DB.Managers.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/user_profile")
public class FriendProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User) request.getSession().getAttribute("user");
        if(u != null){
            try {
                Long id = Long.parseLong(request.getParameter("id"));
                String friend=request.getParameter("friend");
                String not_friend=request.getParameter("n_friend");
                String add=request.getParameter("add");
                String unsubscribe=request.getParameter("unsubscribe");

                request.setAttribute("user", DBManager.getUser(id));
                request.setAttribute("posts", DBManager.getMyPosts(id));

                if(friend == ""){
                    request.setAttribute("friend", "true");
                }else if(not_friend == ""){
                    request.setAttribute("not_friend", "true");
                }else if(add == ""){
                    request.setAttribute("add", "true");
                }else if(unsubscribe == ""){
                    request.setAttribute("unsubscribe", "true");
                }
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            response.sendRedirect("/Home");
        }
    }
}
