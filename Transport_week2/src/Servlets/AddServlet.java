package Servlets;

import DB.Bus;
import DB.Car;
import DB.DBManager;
import DB.Truck;

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
            if (request.getParameter("type").equals("car")){
                String name = request.getParameter("car_name");
                String model = request.getParameter("car_model");
                String carcase = request.getParameter("car_carcase");
                int maxSpeed = Integer.parseInt(request.getParameter("car_max_speed"));
                double engineVolume = Double.parseDouble(request.getParameter("car_engine_volume"));
                int price = Integer.parseInt(request.getParameter("car_price"));
                int year = Integer.parseInt(request.getParameter("car_year"));
                Car car = new Car(name, model, carcase, maxSpeed, engineVolume, price, year);
                DBManager.addTransport(car);
            }else if(request.getParameter("type").equals("bus")){
                String name = request.getParameter("bus_name");
                String model = request.getParameter("bus_model");
                int passengerPlace = Integer.parseInt(request.getParameter("bus_passenger_place"));
                int year = Integer.parseInt(request.getParameter("bus_price"));
                Bus bus = new Bus(name, model, passengerPlace, year);
                DBManager.addTransport(bus);
            }else if(request.getParameter("type").equals("truck")){
                String name = request.getParameter("truck_name");
                String model = request.getParameter("truck_model");
                double liftingCapacity = Double.parseDouble(request.getParameter("truck_lifting_capacity"));
                int truckPrice = Integer.parseInt(request.getParameter("truck_price"));
                int trailerPrice = Integer.parseInt(request.getParameter("trailer_price"));
                Truck truck = new Truck(name, model, liftingCapacity, truckPrice, trailerPrice);
                DBManager.addTransport(truck);
            }
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        response.sendRedirect("/index");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("type");
        request.setAttribute("type", str);
        request.getRequestDispatcher("add_transport.jsp").forward(request, response);
    }
}
