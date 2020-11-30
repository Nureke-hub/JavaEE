package Servlets.Post;

import DB.Classes.Post;
import DB.Classes.User;
import DB.Managers.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@WebServlet(value = "/add_post")
public class AddPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        if(user != null){
            try {
                boolean b = false;
                String title =  request.getParameter("title");
                String short_content =  request.getParameter("short_content");
                String content =  request.getParameter("content");
                if(title != "" && short_content != "" && content !=""){
                    b = DBManager.addPost(new Post(title, short_content, content, user));
                }

                if (b){
                    response.sendRedirect("Home?post_added");
                }else{
                    response.sendRedirect("Home?something_wrong");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            response.sendRedirect("/Home");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
