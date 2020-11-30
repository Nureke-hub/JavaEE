<div class="container">
<nav class="navbar navbar-light nav2">
    <div class="col-sm-2">
        <div class="dropdown">
            <%if (lang_id!=null){%>
            <%for (Languages l : languages){%>
            <%if (l.getId().equals(lang_id)){%>
            <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <%=l.getCode()%>
            </a>
            <%}%>
            <%}%>
            <%}%>

            <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                <%for (Languages l : languages){%>
                <form action="/main?addlang=true&language_id=<%=l.getId()%>" method="post">
                    <button type="submit" class="dropdown-item"><%=l.getCode()%></button>
                </form>
                <%}%>
            </div>
        </div>
    </div>
    <div class="col-sm-8" style="text-align: center">
        <p><b>WORLDS NEWS PORTAL</b></p>
    </div>


    <div class="btn-group">
        <button class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Style
        </button>
        <div class="dropdown-menu dropdown-menu-right">
            <form action="/main?style=1" method="post"><button class="dropdown-item" type="submit">Light</button></form>
            <form action="/main?style=2" method="post"><button class="dropdown-item" type="submit">Dark</button></form>
            <form action="/main?style=3" method="post"><button class="dropdown-item" type="submit">Monochrome</button></form>
            <form action="/main?style=4" method="post"><button class="dropdown-item" type="submit">Monochrome Inverse</button></form>
            <form action="/main?style=5" method="post"><button class="dropdown-item" type="submit">Facebook</button></form>
            <form action="/main?style=6" method="post"><button class="dropdown-item" type="submit">Instagram</button></form>
        </div>
    </div>

</nav>
</div>