<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add <%=request.getAttribute("type")%></title>
        <%@include file="includes/head.jsp"%>
    </head>
    <body>
        <%@include file="includes/navbar.jsp"%>
        <form action="/add?type=<%=request.getAttribute("type")%>" method="post">
            <div class="container" style="max-width: 60%;">
                <div class="mt-3">
                    <h3 style="text-align: center"> ADD <%=request.getAttribute("type").toString().toUpperCase()%></h3>
                    <%
                        if(request.getAttribute("type").equals("car")){
                    %>
                            <p class="lead">CAR NAME: </p>
                            <input type="text" class="form-control" placeholder="Insert car name" name="car_name" style="margin-bottom: 25px">

                            <p class="lead">CAR MODEL: </p>
                            <input type="text" class="form-control" placeholder="Insert car model" name="car_model" style="margin-bottom: 25px">

                            <p class="lead">CAR CARCASE TYPE: </p>
                            <select name="car_carcase" class="custom-select" style="margin-bottom: 25px">
                                <option value="sedan">SEDAN</option>
                                <option value="touring">TOURING (UNIVERSAL)</option>
                                <option value="hatchback">HATCHBACK</option>
                                <option value="coupe">COUPE</option>
                                <option value="cabriolet">CABRIOLET</option>
                            </select>

                            <p class="lead">CAR MAX SPEED: </p>
                            <input type="number" class="form-control" name="car_max_speed" style="margin-bottom: 25px">

                            <p class="lead">CAR ENGINE VOLUME (liters): </p>
                            <input type="text" class="form-control" name="car_engine_volume" style="margin-bottom: 25px">

                            <p class="lead">CAR PRICE: </p>
                            <input type="number" class="form-control" name="car_price" style="margin-bottom: 25px">

                            <p class="lead">CAR YEAR: </p>
                            <input type="number" class="form-control" name="car_year" style="margin-bottom: 25px">
                    <%
                        }else if(request.getAttribute("type").equals("bus")){
                    %>
                            <p class="lead">BUS NAME: </p>
                            <input type="text" class="form-control" placeholder="Insert bus name" name="bus_name" style="margin-bottom: 25px">

                            <p class="lead">BUS MODEL: </p>
                            <input type="text" class="form-control" placeholder="Insert bus model" name="bus_model" style="margin-bottom: 25px">

                            <p class="lead">BUS PASSENGER PLACE: </p>
                            <input type="number" class="form-control" name="bus_passenger_place" style="margin-bottom: 25px">

                            <p class="lead">BUS PRICE: </p>
                            <input type="number" class="form-control" name="bus_price" style="margin-bottom: 25px">
                    <%
                        }else if(request.getAttribute("type").equals("truck")){
                    %>
                            <p class="lead">TRUCK NAME: </p>
                            <input type="text" class="form-control" placeholder="Insert truck name" name="truck_name" style="margin-bottom: 25px">

                            <p class="lead">TRUCK MODEL: </p>
                            <input type="text" class="form-control" placeholder="Insert bus model" name="truck_model" style="margin-bottom: 25px">

                            <p class="lead">LIFTING CAPACITY: </p>
                            <input type="number" class="form-control" name="truck_lifting_capacity" style="margin-bottom: 25px">

                            <p class="lead">TRUCK PRICE: </p>
                            <input type="number" class="form-control" name="truck_price" style="margin-bottom: 25px">

                            <p class="lead">TRAILER PRICE: </p>
                            <input type="number" class="form-control" name="trailer_price" style="margin-bottom: 25px">
                    <%
                        }
                    %>
                    <button type="submit" class="btn mt-3" style="background-color: rgb(32, 105, 99); color: white">+ ADD <%=request.getAttribute("type").toString().toUpperCase()%></button>
                </div>
            </div>
        </form>
    <script type="text/javascript">
        <%
            if (request.getAttribute("type").equals("car")){
        %>
            document.getElementById("navbar").style.backgroundColor = "#6b5e1a";
        <%
            }else if(request.getAttribute("type").equals("bus")){
        %>
            document.getElementById("navbar").style.backgroundColor = "#6e2d3d";
        <%
            }else if(request.getAttribute("type").equals("truck")){
        %>
            document.getElementById("navbar").style.backgroundColor = "#196484";
        <%
            }
        %>

    </script>

    </body>
</html>


