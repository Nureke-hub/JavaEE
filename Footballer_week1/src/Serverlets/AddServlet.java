package Serverlets;

import DB.DBManager;
import DB.Footballer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/add")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("footballer_name");
            String surname = request.getParameter("footballer_surname");
            String club = request.getParameter("footballer_club");
            int salary = Integer.parseInt(request.getParameter("footballer_salary"));
            int transfer_price = Integer.parseInt(request.getParameter("footballer_transfer_price"));

            DBManager.addFootballer(new Footballer(name, surname, salary, club, transfer_price));
        }catch (NumberFormatException e){
            System.out.println(e.fillInStackTrace());
        }

        response.sendRedirect("/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
