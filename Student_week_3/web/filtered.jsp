<%@ page import="DB.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filtered</title>
    <%@include file="includes/head.jsp"%>
</head>
<body>
    <%@include file="includes/navbar.jsp"%>

    <div class="container">
        <div class="mt-4">
            <%
                String deleted = request.getParameter("deleted");
                if(deleted != null){
            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                Student deleted successfully!
                <button type="button" class="close" aria-label="Close" data-dismiss = "alert">
                    <span aria-hidden="true"></span>
                </button>
            </div>
            <%
                }
            %>

            <%
                String error = request.getParameter("error");
                if(error != null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                The student has not been deleted!
                <button type="button" class="close" aria-label="Close" data-dismiss = "alert">
                    <span aria-hidden="true"></span>
                </button>
            </div>
            <%
                }
            %>



            <form action="/filter" method="get">
                <div class="form-row">
                    <div class="col-3">
                        <label>Name : </label>
                        <input type="text" class="form-control" placeholder="Enter name to search" name="name">
                    </div>
                    <div class="col-3">
                        <label>Surname : </label>
                        <input type="text" class="form-control" placeholder="Enter surname to search" name="surname">
                    </div>
                    <div class="col-3">
                        <label>IIN : </label>
                        <input type="number" class="form-control" placeholder="Enter IIN to search" name="iin">
                    </div>

                    <div class="col-2">
                        <label>Grant : </label>
                        <select class="custom-select" name="is_grant">
                            <option selected value="true">YES</option>
                            <option value="false">NO</option>
                        </select>
                    </div>

                    <div class="col-1">
                        <button class="btn btn-md" style="margin-top: 32px; color: white; background-color: rgb(64, 12, 110);">FILTER</button>
                    </div>
                </div>
            </form>

            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">NAME</th>
                    <th scope="col">SURNAME</th>
                    <th scope="col">IIN</th>
                    <th scope="col">BIRTHDATE</th>
                    <th scope="col">IS GRANT</th>
                    <th scope="col">ACTION</th>
                </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<Student> students = (ArrayList<Student>)request.getAttribute("students");
                    if (students != null){
                        for (Student s: students) {
                %>
                <tr style="text-align: center;">
                    <td><%=s.getId()%></td>
                    <td><%=s.getName()%></td>
                    <td><%=s.getSurname()%></td>
                    <td><%=s.getIin()%></td>
                    <td><%=s.getBirthdate()%></td>
                    <% if(s.isGrant()){%>
                    <td>YES</td>
                    <%}else{%>
                    <td>NO</td>
                    <%}%>
                    <td>
                        <a class="btn btn-sm" href="/details?id=<%=s.getId()%>" role="button" style="color: white; background-color: rgb(64, 12, 110)">Details</a>
                        <a class="btn btn-sm" href="/delete?id=<%=s.getId()%>" role="button" style="color: white; background-color: rgb(220, 53, 69)">Delete</a>
                    </td>
                </tr>
                <%
                        }
                    }
                    String name = String.valueOf(request.getAttribute("name"));
                    if (name.equals("null")){
                        System.out.println("HERE");
                        name = "";
                    }
                    System.out.println("FILTERED.JSP: " + name);
                    String surname = String.valueOf(request.getAttribute("surname"));
                    if (surname.equals("null")){
                        System.out.println("HERE");
                        surname = "";
                    }
                    System.out.println("FILTERED.JSP: " + surname);
                    String iin = String.valueOf(request.getAttribute("iin"));
                    if (iin.equals("null")){
                        System.out.println("HERE");
                        iin = "";
                    }
                    System.out.println("FILTERED.JSP: " + iin);
                    String is_grant = String.valueOf(request.getAttribute("is_grant"));
                    if (is_grant.equals("null")){
                        System.out.println("HERE");
                        is_grant = "";
                    }
                    System.out.println("FILTERED.JSP: " + is_grant);
                    int current_page = (int)request.getAttribute("current_page");
                    int pag_count = (int)request.getAttribute("pag_count");
                %>
                </tbody>
            </table>

            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                    <%if((int)request.getAttribute("current_page")-1 == 0){%>
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1">Previous</a>
                    </li>
                    <%}else{%>
                    <li class="page-item">
                        <a class="page-link" href="/filter?pag_page=<%=current_page-1%>&name=<%=name%>&surname=<%=surname%>&iin=<%=iin%>&is_grant=<%=is_grant%>" tabindex="-1">Previous</a>
                    </li>
                    <%
                        }
                    %>

                    <%
                        for(int i = 1; i <= pag_count; i++){
                            if((int)request.getAttribute("current_page") == i){%>
                                    <li class="page-item disabled"><a class="page-link" href="#"><%=i%></a></li>
                            <%}else{%>
                                <li class="page-item">
                                    <a class="page-link" href="/filter?pag_page=<%=i%>&name=<%=name%>&surname=<%=surname%>&iin=<%=iin%>&is_grant=<%=is_grant%>" tabindex="-1"><%=i%></a>
                                </li>
                                <%
                            }
                        }
                    %>

                    <%if((int)request.getAttribute("current_page")+1 > pag_count){%>
                    <li class="page-item disabled">
                        <a class="page-link" href="#">Next</a>
                    </li>
                    <%}else{%>
                    <li class="page-item">
                        <a class="page-link" href="/filter?pag_page=<%=current_page+1%>&name=<%=name%>&surname=<%=surname%>&iin=<%=iin%>&is_grant=<%=is_grant%>" tabindex="-1">Next</a>
                    </li>
                    <%
                        }
                    %>


                </ul>
            </nav>

        </div>
    </div>

</body>
</html>
