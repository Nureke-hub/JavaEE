package Serverlets;

import DB.DBManager;
import DB.Footballer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/footballer_details")
public class FootballerDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Footballer f = DBManager.getAllFootballers().get(Integer.parseInt(request.getParameter("footballer_index")));
            request.setAttribute("footballer", f);
            int i = Integer.parseInt(request.getParameter("footballer_index"));
            request.setAttribute("footballer_index", i);
            request.getRequestDispatcher("/detail.jsp").forward(request, response);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }
}
