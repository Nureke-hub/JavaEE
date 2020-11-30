package Servlets;

import DB.DBManager;
import DB.Ticket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/add_ticket")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String from = request.getParameter("from_city");
            String to = request.getParameter("to_city");
            int price = Integer.parseInt(String.valueOf(request.getParameter("ticket_price")));
            int duration = Integer.parseInt(String.valueOf(request.getParameter("ticket_duration")));
            Ticket ticket = new Ticket(from, to, price, duration);
            DBManager.addTicket(ticket);
        }catch (NumberFormatException e){
            request.getRequestDispatcher("/add_ticket.jsp").forward(request, response);
        }catch (NullPointerException e){
            request.getRequestDispatcher("/add_ticket.jsp").forward(request, response);
        }
        response.sendRedirect("/home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
