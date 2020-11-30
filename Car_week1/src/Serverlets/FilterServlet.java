package Serverlets;

import DB.Car;
import DB.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/filter")
public class FilterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = request.getParameter("category");
        String search_text = request.getParameter("search_text");
        ArrayList<Car> cars = new ArrayList<>();
        if(category.compareTo("name") == 0){
            cars = DBManager.getCarsByName(search_text);
        }else if(category.compareTo("model") == 0){
            cars = DBManager.getCarsByModel(search_text);
        }else if(category.compareTo("year") == 0){
            try {
                cars = DBManager.getCarsByYear(Integer.parseInt(search_text));
            }catch (NumberFormatException e){
                cars = DBManager.getAllCars();
            }
        }else if(category.compareTo("price") == 0){
            try {
                cars = DBManager.getCarsByPrice(Integer.parseInt(search_text));
            }catch (NumberFormatException e){
                cars = DBManager.getAllCars();
            }
        }else if (category.compareTo("all") == 0){
            cars = DBManager.getAllCars();
        }

        request.setAttribute("cars", cars);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
