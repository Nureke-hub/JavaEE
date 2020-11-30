package Serverlets;

import DB.Car;
import DB.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/car_details")
public class DetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Car car = DBManager.getCar(Long.parseLong(request.getParameter("car_id")));
            request.setAttribute("car", car);
            request.getRequestDispatcher("/detail.jsp").forward(request, response);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }

    }
}
