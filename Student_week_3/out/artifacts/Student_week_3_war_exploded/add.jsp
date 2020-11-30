<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add student</title>
    <%@include file="includes/head.jsp"%>
</head>
<body>
    <%@include file="includes/navbar.jsp"%>
    <div class="container">
        <div class="mt-5 offset-3 col-sm-6">
            <%
                String added = request.getParameter("added");
                if(added != null){
            %>
                    <div class="alert alert-success alert-dismissible fade show" role="alert">
                        Student added successful!
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
                Something went wrong!
                <button type="button" class="close" aria-label="Close" data-dismiss = "alert">
                    <span aria-hidden="true"></span>
                </button>
            </div>
            <%
                }
            %>


            <form action="addStudent" method="post">
                <p class="lead">Name: </p>
                <input type="text" class="form-control" name="name" style="margin-bottom: 25px">

                <p class="lead">Surname: </p>
                <input type="text" class="form-control" name="surname" style="margin-bottom: 25px">

                <p class="lead">Middle name: </p>
                <input type="text" class="form-control" name="middlename" style="margin-bottom: 25px">

                <p class="lead">Birthdate: </p>
                <input type="date" class="form-control" name="birthdate" style="margin-bottom: 25px">

                <p class="lead">IIN: </p>
                <input type="number" class="form-control" name="iin" style="margin-bottom: 25px">

                <p class="lead">IS GRANT: </p>
                <select class="custom-select" style="margin-bottom: 25px" name = "is_grant">
                    <option value="true">YES</option>
                    <option value="false">NO</option>
                </select>

                <p class="lead">Specialty: </p>
                <select class="custom-select" style="margin-bottom: 25px" name = "specialty">
                    <option value="CSSE">CSSE</option>
                    <option value="SIS">SIS</option>
                    <option value="CS">CS</option>
                    <option value="IS">IS</option>
                    <option value="MCM">MCM</option>
                </select>

                <div class="col-1">
                    <button class="btn btn-md" type="submit" style="margin-top: 32px; color: white; background-color: rgb(64, 12, 110);">ADD</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
