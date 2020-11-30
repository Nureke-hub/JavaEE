package Servlets.Profile;

import DB.Classes.User;
import DB.Managers.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/update_profile")
public class UpdateProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        if(user != null){
            String email = request.getParameter("login");
            System.out.println("HEERE");
            System.out.println(email);
            System.out.println();
            String full_name = request.getParameter("full_name");
            java.sql.Date date = null;
            if(request.getParameter("birth_date") != ""){
                try{
                    date = java.sql.Date.valueOf(request.getParameter("birth_date"));
                }catch (Exception e){
                    response.sendRedirect("/Home?wrong_date");
                    e.printStackTrace();
                }
            }else{
                response.sendRedirect("/Home?wrong_date");
            }

            if(email !="" && full_name != "" && date != null){
                user.setBirth_date(date);
                user.setFull_name(full_name);
                DBManager.updateProfile(user.getEmail(), full_name, date, user.getId());
                request.getSession().setAttribute("user", user);
            }else{
                response.sendRedirect("/Home?wrong_full_name");
            }
            response.sendRedirect("/Home?success_prof");
        }else{
            response.sendRedirect("/Home");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
