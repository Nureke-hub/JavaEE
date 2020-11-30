package Serverlets;

import DB.Car;
import DB.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/add_car")
public class AddCarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String name = request.getParameter("car_name");
            String model = request.getParameter("car_model");
            int year = Integer.parseInt(String.valueOf(request.getParameter("car_year")));
            int price = Integer.parseInt(String.valueOf(request.getParameter("car_price")));
            Car car = new Car(name, model, year, price);
            DBManager.addCar(car);
        }catch (NumberFormatException e){
            request.getRequestDispatcher("/add_car.jsp").forward(request, response);
        }catch (NullPointerException e){
            request.getRequestDispatcher("/add_car.jsp").forward(request, response);
        }
        response.sendRedirect("/mainPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
