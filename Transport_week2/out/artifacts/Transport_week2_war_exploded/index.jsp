<%@ page import="Interfaces.Transport" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <%@include file="includes/head.jsp"%>
</head>
<body>
    <%@include file="includes/navbar.jsp"%>
    <div class="container">
        <div class="mt-4">
            <div>
                <%
                    ArrayList<Transport> transports = (ArrayList<Transport>) request.getAttribute("transports");
                    for(Transport t: transports){
                %>
                <div class="jumbotron" style="background-color: rgb(209, 232, 223)">
                    <h1 class="display-4"><%=t.getTransportFullName()%></h1>
                    <p class="lead"><%=t.getTransportPrice()%> USD</p>
                    <hr class="my-4">
                    <p><%=t.getTransportDescription()%></p>
                    <a class="btn btn-lg" href="/detail?id=<%=t.getId()%>" role="button" style="color: white; background-color: rgb(32, 105,99)">Learn more</a>
                </div>
                <%
                    }
                %>
            </div>
        </div>
    </div>
</body>
</html>

<script type="text/javascript">
    document.getElementById("navbar").style.backgroundColor = "#206963";
</script>