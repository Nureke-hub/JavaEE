package servlets;

import addition.CookieHandler;
import db.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/news_detail")
public class NewsDetailServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CookieHandler cookie = new CookieHandler(request.getCookies());

            if(cookie.getCookie("lang")!=null){
                request.setAttribute("lang", cookie.getCookie("lang"));
            }else{
                request.setAttribute("lang", Database.getLanguageId("ENG").getId());
            }
            request.setAttribute("newsObject", Database.getNewObject(Long.parseLong(request.getParameter("id"))));
            request.setAttribute("languages", Database.allLanguages());
            request.setAttribute("publications", Database.allPublications());
            request.getRequestDispatcher("news_detail.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
