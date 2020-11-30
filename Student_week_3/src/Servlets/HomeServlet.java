package Servlets;

import DB.DBManager;
import DB.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> students;

        System.out.println("HEEEEEY");
        System.out.println(DBManager.sizeOfTable());

        int size = DBManager.sizeOfTable();

        if(size % 5 == 0){
            request.setAttribute("pag_count", size/5);
        }else{
            request.setAttribute("pag_count", (size/5) + 1);
        }

        if(request.getParameter("pag_page") != null){
            int current_page = Integer.parseInt(request.getParameter("pag_page"));
            students = DBManager.getAllStudents((current_page -1)*5, 5);
            request.setAttribute("current_page", current_page);
        }else{
            students = DBManager.getAllStudents(0, 5);
            request.setAttribute("current_page", 1);
        }
        request.setAttribute("students", students);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
