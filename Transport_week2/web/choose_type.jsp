<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add transport</title>
        <%@include file="includes/head.jsp"%>
    </head>
    <body>
        <%@include file="includes/navbar.jsp"%>
        <div class="container">
            <div class="mt-5" style="margin-left: 35%">
                <div class="col-sm-5">
                    <p class="lead">Choose transport type:</p>
                    <form action="/add" method="get">
                        <select name="type" class="custom-select">
                            <option value="car">CAR</option>
                            <option value="bus">BUS</option>
                            <option value="truck">TRUCK</option>
                        </select>
                        <button type="submit" class="btn mt-3" style="background-color: rgb(32, 105, 99); color: white">NEXT ></button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

<script type="text/javascript">
    document.getElementById("navbar").style.backgroundColor = "#206963";
</script>
