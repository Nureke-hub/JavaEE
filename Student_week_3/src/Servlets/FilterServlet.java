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

@WebServlet(value = "/filter")
public class FilterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        System.out.println();
        System.out.println("BEFORE: " + name);
        System.out.println("BEFORE: " + request.getParameter("pag_page"));
        if(name.equals("")){
            name = null;
        }
        System.out.println(name);
        String surname = request.getParameter("surname");
        if(surname.equals("")){
            surname = null;
        }
        System.out.println(surname);
        String iin = request.getParameter("iin");
        if(iin.equals("")){
            iin = null;
        }
        System.out.println(iin);
        boolean is_grant = false;
        if(request.getParameter("is_grant").equals("true")){
            is_grant = true;
        }
        System.out.println(is_grant);

        int size = DBManager.sizeOfFilteredStudents(name, surname, iin, is_grant);
        if(size% 5 == 0){
            request.setAttribute("pag_count", size/5);
        }else{
            request.setAttribute("pag_count", (size/5) + 1);
        }

        ArrayList<Student> students;

        if(request.getParameter("pag_page") != null){
            int current_page = Integer.parseInt(request.getParameter("pag_page"));
            students = DBManager.findAllStudentsFilteredPaged(name, surname, iin, is_grant, (current_page -1)*5, 5);
            request.setAttribute("current_page", current_page);
        }else {
            request.setAttribute("current_page", 1);
            students = DBManager.findAllStudentsFilteredPaged(name, surname, iin, is_grant, 0, 5);
        }

        request.setAttribute("name", name);
        request.setAttribute("surname", surname);
        request.setAttribute("iin", iin);
        request.setAttribute("is_grant", is_grant);

        request.setAttribute("students", students);
        request.getRequestDispatcher("filtered.jsp").forward(request, response);
    }
}
