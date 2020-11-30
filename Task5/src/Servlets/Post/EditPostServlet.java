package Servlets.Post;

import DB.Classes.Post;
import DB.Classes.User;
import DB.Managers.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/edit_post")
public class EditPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        if(user != null){
            try {
                String title =  request.getParameter("title");
                String short_content =  request.getParameter("short_content");
                String content =  request.getParameter("content");
                Long id = Long.parseLong(request.getParameter("post_id"));
                if(title != "" && short_content != "" && content !=""){
                    DBManager.editPost(id, title, short_content, content);
                }
                response.sendRedirect("/post_detail?post_id="+id);
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
