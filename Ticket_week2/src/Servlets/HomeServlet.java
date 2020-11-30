package Servlets;

import DB.DBManager;
import DB.Ticket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Ticket> tickets = DBManager.getTicketsFromRange(0);
        int pag_count = DBManager.getPagination();
        request.setAttribute("pag_count", pag_count);

        String str = request.getParameter("pag_page");
        if(str != null){
            int pag_num = (Integer.parseInt(str)-1)*3;
            tickets = DBManager.getTicketsFromRange(pag_num);
        }
        request.setAttribute("tickets", tickets);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
//1-0,1,2
//2-3,4,5
//3-6,7,8
