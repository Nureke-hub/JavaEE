package Servlets;

import DB.Bus;
import DB.Car;
import DB.DBManager;
import DB.Truck;
import Interfaces.Transport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/detail")
public class DetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Transport t = DBManager.getTransport(Long.parseLong(request.getParameter("id")));
        request.setAttribute("transport", t);
        request.getRequestDispatcher("detail.jsp").forward(request, response);
    }
}
