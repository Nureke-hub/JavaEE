<%@ page import="DB.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="includes/head.jsp"%>
</head>
<body>
    <%@include file="includes/navbar.jsp"%>
    <%
        Student s = (Student)request.getAttribute("student");
    %>
    <div class="container">
        <div class="mt-5 col-sm-6 offset-3">
            <div class="jumbotron">
                <div class="col-md-12 offset-3">
                    <p class="lead">Name: <%=s.getName()%></p>
                    <p class="lead">Surname: <%=s.getSurname()%></p>
                    <p class="lead">Middle name: <%=s.getMiddleName()%></p>
                    <p class="lead">Birthdate: <%=s.getBirthdate()%></p>
                    <p class="lead">IIN: <%=s.getIin()%></p>
                    <%if(s.isGrant()){%>
                    <p class="lead">IS GRANT: YES</p>
                    <%}else{%>
                    <p class="lead">IS GRANT: NO</p>
                    <%}%>
                    <p class="lead">Specialty: <%=s.getSpeciality()%></p>
                </div>
            </div>

            <a class="btn btn-sm" href="/edit?id=<%=s.getId()%>" role="button" style="color: white; background-color: rgb(64, 12, 110)">EDIT</a>

        </div>
    </div>
</body>
</html>
