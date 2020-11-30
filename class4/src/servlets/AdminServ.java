package servlets;
import db.Database;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/admin")
public class AdminServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            if (Database.authentificate(request.getParameter("username"), request.getParameter("password"))){
                response.sendRedirect("/index");
            }else {
                request.setAttribute("operation", "unsuccess");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
