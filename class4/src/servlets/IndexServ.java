package servlets;

import db.Database;
import db.classes.Languages;
import db.classes.Publications;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/index")
public class IndexServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            if (request.getParameter("delete")!=null){
                Database.deletePublication(Long.parseLong(request.getParameter("id")));
            }
            else if(request.getParameter("edit")!=null){
                Database.updatePublication(Long.parseLong(request.getParameter("id")), new Publications(
                        request.getParameter("name"),
                        request.getParameter("description"),
                        Double.parseDouble(request.getParameter("rating"))));
            }
            else if(request.getParameter("add")!=null){
                Database.addPublication(new Publications(
                        request.getParameter("name"),
                        request.getParameter("description"),
                        Double.parseDouble(request.getParameter("rating"))));
            }

            response.sendRedirect("/index");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            request.setAttribute("publications", Database.allPublications());
            request.setAttribute("window", "publication");
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
