<%@ page import="db.classes.Languages" %>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">NAME</th>
        <th scope="col">CODE</th>
        <th scope="col">ACTION</th>
    </tr>
    </thead>
    <tbody>
    <%for (Languages l : languages){%>
    <tr style="text-align: center;">
        <th><%=l.getId()%></th>
        <td><%=l.getName()%></td>
        <td><%=l.getCode()%></td>
        <td>
            <div class="btn-group">
                <a class="btn btn-primary" data-toggle="modal" data-target="#edit<%=l.getId()%>">edit</a>
                <a class="btn btn-danger" data-toggle="modal" data-target="#delete<%=l.getId()%>">delete</a>
            </div>
        </td>
    </tr>

    <!-- Modal delete -->
    <div class="modal fade" id="delete<%=l.getId()%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">ARE YOU SURE TO DELETE</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Language <%=l.getName()%>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <form action="/languages?delete=true&id=<%=l.getId()%>" method="post">
                        <button type="submit" class="btn btn-danger">DELETE</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <%-- Modal edit--%>
    <div class="modal fade" id="edit<%=l.getId()%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">EDIT LANGUAGE</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>

                <form action="/languages?edit=true&id=<%=l.getId()%>" method="post">
                    <div class="container">
                        <div class="form-group">
                            <label>NAME : </label>
                            <input type="text" class="form-control" name="name" value="<%=l.getName()%>">
                        </div>

                        <div class="form-group">
                            <label>CODE : </label>
                            <input type="text" class="form-control" name="code" value="<%=l.getCode()%>">
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-success">EDIT</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <%}%>
    </tbody>
</table>