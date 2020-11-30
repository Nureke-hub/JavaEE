package servlets;

import db.Database;
import db.classes.Languages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/languages")
public class LanguagesServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            if (request.getParameter("delete")!=null){
                        Database.deleteLanguages(Long.parseLong(request.getParameter("id")));
            }
            else if(request.getParameter("edit")!=null){
                Database.updateLanguage(Long.parseLong(request.getParameter("id")), new Languages(
                        request.getParameter("name"),
                        request.getParameter("code")));
            }
            else if(request.getParameter("add")!=null){
                Database.addLanguage(new Languages(
                        request.getParameter("name"),
                        request.getParameter("code")));
            }

            response.sendRedirect("/languages");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            request.setAttribute("languages", Database.allLanguages());
            request.setAttribute("window", "language");
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
