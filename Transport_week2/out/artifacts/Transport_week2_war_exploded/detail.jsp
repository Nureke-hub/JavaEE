<%@ page import="DB.Car" %>
<%@ page import="DB.Truck" %>
<%@ page import="DB.Bus" %>
<%@ page import="Interfaces.Transport" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Detail</title>
        <%@include file="includes/head.jsp"%>
    </head>
    <body>
        <%@include file="includes/navbar.jsp"%>

        <div class="container">
            <div class="mt-5">
                <div class="jumbotron">
                    <%
                        Car car = new Car();
                        Truck truck = new Truck();
                        Bus bus = new Bus();
                        Transport t = (Transport)request.getAttribute("transport");

                    %>
                        <h1 class="display-4"><%=t.getTransportFullName()%></h1>
                        <hr class="my-4">
                    <%
                        if(t instanceof Car){
                            car = (Car)t;
                    %>
                            <p class="lead">Car year: <%=car.getYear()%></p>
                            <p class="lead">Car carcase type: <%=car.getCarcase_type()%></p>
                            <p class="lead">Max speed: <%=car.getMaxSpeed()%> km/h</p>
                            <p class="lead">Engine volume: <%=car.getEngineVolume()%> Liters</p>
                            <p class="lead">Car price: <%=car.getPrice()%> USD</p>
                    <%
                        }else if(t instanceof Bus){
                            bus = (Bus)t;
                    %>
                            <p class="lead">Passenger places: <%=bus.getPassengerPlaces()%></p>
                            <p class="lead">Bus price: <%=bus.getPrice()%> USD</p>
                    <%
                        }else if(t instanceof Truck){
                            truck = (Truck)t;
                    %>
                            <p class="lead">Lifting capacity: <%=truck.getLiftingCapacity()%></p>
                            <p class="lead">Truck price: <%=truck.getPrice()%> USD</p>
                            <p class="lead">Trailer price: <%=truck.getTrailerPrice()%> USD</p>
                            <p class="lead">Sum: <%=truck.getPrice() + truck.getTrailerPrice()%> USD</p>
                    <%
                        }
                    %>
                    <a class="btn btn-lg" href="/index" role="button" style="color: white; background-color: rgb(32, 105,99)">Back</a>
                    <a class="btn btn-lg" href="/delete?id=<%=t.getId()%>" role="button" style="color: white; background-color: rgb(32, 105,99)">Delete</a>
                </div>
            </div>
        </div>
    </body>
</html>

<script type="text/javascript">
    document.getElementById("navbar").style.backgroundColor = "#206963";
</script>
