package Servlets;

import DB.Classes.Club;
import DB.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/leagueCubs")
public class leagueCubsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Club> clubs = DBManager.getLeagueClubs(Long.parseLong(request.getParameter("id")));
        for (Club c: clubs) {
            System.out.println(c.getId() + " " + c.getName() + " " + c.getFoundedYear() + " " + c.getCity().getName());
        }
    }
}
