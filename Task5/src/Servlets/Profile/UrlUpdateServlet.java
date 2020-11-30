package Servlets.Profile;

import DB.Classes.User;
import DB.Managers.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/update_url")
public class UrlUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        if(user != null){
            String url = request.getParameter("picture_url");
            try{
                if(url.equals("")){
                    url = DBManager.photo;
                    user.setPicture_url(url);
                    DBManager.updateUrl(url, user.getId());
                }else{
                    user = (User)request.getSession().getAttribute("user");
                    user.setPicture_url(url);
                    DBManager.updateUrl(url, user.getId());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            response.sendRedirect("Home?success_url");
        }else{
            response.sendRedirect("/Home");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
