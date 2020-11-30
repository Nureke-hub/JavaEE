package Servlets;

import DB.Classes.User;
import DB.Managers.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/Home")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User)request.getSession().getAttribute("user");
        if(u != null){
            if(request.getParameter("old_not_same") != null || request.getParameter("not_same") != null || request.getParameter("success_pass") != null || request.getParameter("success_url") != null || request.getParameter("success_prof") != null || request.getParameter("wrong_full_name") != null || request.getParameter("wrong_date") != null){
                request.setAttribute("user", u);
                request.getRequestDispatcher("profile.jsp").forward(request, response);
            }
            request.setAttribute("user", u);
            if(request.getParameter("feed")!= null){
                request.setAttribute("posts", DBManager.getAllPosts());
            }else{
                request.setAttribute("posts", DBManager.getMyPosts(u.getId()));
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else{
            response.sendRedirect("/login");
        }
    }
}
