package servlets;

import addition.CookieHandler;
import db.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;


@WebServlet(value = "/main")
public class MainServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("addlang")!=null){
            Cookie cookie = new Cookie("lang", request.getParameter("language_id"));
            cookie.setMaxAge(3600 * 24 * 30);
            response.addCookie(cookie);
        }

        if (request.getParameter("style")!=null){
            Cookie cookie = new Cookie("style", request.getParameter("style"));
            cookie.setMaxAge(3600 * 24 * 30);
            response.addCookie(cookie);
        }
        response.sendRedirect("/main");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CookieHandler cookie = new CookieHandler(request.getCookies());

            if (cookie.getCookie("style")!=null){
                request.setAttribute("style", cookie.getCookie("style"));
            }else {
                request.setAttribute("style", "1");
            }

            if(cookie.getCookie("lang")!=null){
                request.setAttribute("news", Database.newsByLang(Long.parseLong(cookie.getCookie("lang"))));
                request.setAttribute("lang", cookie.getCookie("lang"));
            }else{
                request.setAttribute("news", Database.newsByLang(Database.getLanguageId("ENG").getId()));
                request.setAttribute("lang", Database.getLanguageId("ENG").getId());
            }

            request.setAttribute("languages", Database.allLanguages());
            request.setAttribute("publications", Database.allPublications());
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("main.jsp").forward(request,response);
    }
}
