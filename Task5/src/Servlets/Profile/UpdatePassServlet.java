package Servlets.Profile;

import DB.Classes.User;
import DB.Managers.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/update_pass")
public class UpdatePassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        if(user != null){
            String old_pass = request.getParameter("old_pass");
            String new_pass = request.getParameter("new_pass");
            String re_new_pass = request.getParameter("re_new_pass");
            try {
                if(old_pass.equals(user.getPassword())){
                    if(new_pass.equals(re_new_pass)){
                        user.setPassword(new_pass);
                        DBManager.updatePassword(new_pass, user.getId());
                        request.getSession().setAttribute("user", user);
                    }else{
                        response.sendRedirect("Home?not_same");
                    }
                }else{
                    response.sendRedirect("Home?old_not_same");
                }
                response.sendRedirect("Home?success_pass");
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
