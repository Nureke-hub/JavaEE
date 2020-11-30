package Servlets.Post;

import DB.Classes.User;
import DB.Managers.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(value = "/post_detail")
public class PostDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User)request.getSession().getAttribute("user");
        if(u != null){
            try{
                Long id = Long.parseLong(request.getParameter("post_id"));
                request.setAttribute("post", DBManager.getPost(id));
                request.setAttribute("user", u);
                request.getRequestDispatcher("post_detail.jsp").forward(request, response);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            response.sendRedirect("/Home");
        }
    }
}
