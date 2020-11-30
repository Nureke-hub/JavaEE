package Servlets.Authorization;

import DB.Classes.User;
import DB.Managers.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(value = "/regist")
public class RegistrateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("login");
            String password1 = request.getParameter("pass");
            String password2 = request.getParameter("re_pass");
            String full_name = request.getParameter("full_name");
            java.sql.Date date = null;
            if(request.getParameter("birth_date") != ""){
                date = java.sql.Date.valueOf(request.getParameter("birth_date"));
            }

            if(DBManager.getUser(email) == null){
                if(password1.equals(password2)){
                    if(email != "" && password1 != "" && password2 != "" && full_name!="" && date != null){
                        boolean b = DBManager.addUser(new User(email, password1, full_name, date, DBManager.photo));
                        if(b){
                            request.getRequestDispatcher("register.jsp?success").forward(request, response);
                        }else {
                            request.getRequestDispatcher("register.jsp?incorrect_data").forward(request, response);
                        }
                    }else{
                        request.getRequestDispatcher("register.jsp?incorrect_data").forward(request, response);
                    }
                }else{
                    request.getRequestDispatcher("register.jsp?password_incorrect").forward(request, response);
                }
            }else {
                request.getRequestDispatcher("register.jsp?email_exists").forward(request, response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
