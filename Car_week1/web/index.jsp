<%@ page import="java.util.ArrayList" %>
<%@ page import="DB.Car" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Index</title>
    </head>
    <body>
        <form action="/filter" method="get">
            <h2 style="text-align: center">Main page</h2>
            <div style="padding-left: 40%;">
                <select name="category" style="font-size: large">
                    <option value="all">All cars</option>
                    <option value="name">Name:</option>
                    <option value="model">Model:</option>
                    <option value="year">Year from:</option>
                    <option value="price">Price to:</option>
                </select>

                <input type="text" name="search_text">
                <button style="font-size: medium">Search</button> <br>

                <%
                    ArrayList<Car> cars = (ArrayList<Car>) request.getAttribute("cars");
                    if(cars != null){
                        for(Car car: cars){
                %>
                            <h3 style="color: rgb(55,87,39)">
                                <a href="/car_details?car_id=<%=car.getId()%>">
                                    <%=car.getName()%>
                                    <%=car.getModel()%>
                                </a>
                            </h3>
                <%
                        }
                    }
                %>
                <br>
                <a href="add_car.jsp" style="border: 3px solid darkblue; font-size: 25px; color: darkblue; text-decoration: none; border-radius: 5px">
                    Add new car
                </a>
            </div>
        </form>



    </body>
</html>
