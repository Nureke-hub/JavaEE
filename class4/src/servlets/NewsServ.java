package servlets;

import db.Database;
import db.classes.Languages;
import db.classes.News;
import db.classes.Publications;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/news")
public class NewsServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            if (request.getParameter("delete")!=null){
                Database.deleteNew(Long.parseLong(request.getParameter("id")));
            }
            else if(request.getParameter("edit")!=null){
                Database.updateNew(Long.parseLong(request.getParameter("id")), new News(
                        request.getParameter("title"),
                        request.getParameter("short_content"),
                        request.getParameter("content"),
                        request.getParameter("picture_url"),
                        new Languages(Long.parseLong(request.getParameter("language_id"))),
                        new Publications(Long.parseLong(request.getParameter("publication_id")))));
            }
            else if(request.getParameter("add")!=null){
                Database.addNew(new News(
                        request.getParameter("title"),
                        request.getParameter("short_content"),
                        request.getParameter("content"),
                        request.getParameter("picture_url"),
                        new Languages(Long.parseLong(request.getParameter("language_id"))),
                        new Publications(Long.parseLong(request.getParameter("publication_id")))));
            }

            response.sendRedirect("/news");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            request.setAttribute("news", Database.allNews());
            request.setAttribute("languages", Database.allLanguages());
            request.setAttribute("publications", Database.allPublications());
            request.setAttribute("window", "new");
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
