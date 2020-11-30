package Servlets;

import DB.DBManager;
import DB.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(value = "/addStudent")
public class addStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String middlename = request.getParameter("middlename");
            Date d = java.sql.Date.valueOf(request.getParameter("birthdate"));
            String iin = request.getParameter("iin");
            boolean is_grant = false;
            if(request.getParameter("is_grant").equals("true")){
                is_grant = true;
            }
            String specialty = request.getParameter("specialty");

            Student s = new Student(name, surname, middlename, d, iin, is_grant, specialty);
            boolean added = DBManager.addStudent(s);
            if(added){
                response.sendRedirect("/addStudent?added");
            }else{
                response.sendRedirect("/addStudent?error");
            }
        }catch (Exception e){
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("add.jsp").forward(request, response);
    }
}
