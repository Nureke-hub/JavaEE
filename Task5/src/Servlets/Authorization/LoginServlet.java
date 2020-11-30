package Servlets.Authorization;

import DB.Classes.User;
import DB.Managers.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("login");
        String password = request.getParameter("pass");

        System.out.println();
        System.out.println(email);
        System.out.println(password);

        String redirect = "/Home?emailError";
        User user = DBManager.getUser(email);
        System.out.println(user);
        System.out.println();
        if(user != null){
            redirect = "/Home?passwordError";
            if(user.getPassword().equals(password)){
                request.getSession().setAttribute("user", user);
                redirect = "/Home?feed";
            }
        }
        response.sendRedirect(redirect);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
