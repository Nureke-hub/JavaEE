<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">NAME</th>
        <th scope="col">DESCRIPTION</th>
        <th scope="col">RATING</th>
        <th scope="col">ACTION</th>
    </tr>
    </thead>
    <tbody>
        <%for (Publications p : publications){%>
        <tr>
            <th scope="row"><%=p.getId()%></th>
            <td><%=p.getName()%></td>
            <td><%=p.getDescription()%></td>
            <td><%=p.getRating()%></td>
            <td>
                <div class="btn-group">
                    <a class="btn btn-primary"  role="button" data-toggle="modal" data-target="#edit<%=p.getId()%>">edit</a>
                    <a class="btn btn-danger" role="button" data-toggle="modal" data-target="#delete<%=p.getId()%>">delete</a>
                </div>
            </td>
        </tr>

        <!-- Modal delete -->
        <div class="modal fade" id="delete<%=p.getId()%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">ARE YOU SURE TO DELETE</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Publication <%=p.getName()%>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <form action="/index?delete=true&id=<%=p.getId()%>" method="post">
                        <button type="submit" class="btn btn-danger">DELETE</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

        <%-- Modal edit--%>
        <div class="modal fade" id="edit<%=p.getId()%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">EDIT PUBLICATION</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <form action="/index?edit=true&id=<%=p.getId()%>" method="post">
                        <div class="container">
                            <div class="form-group">
                                <label>NAME : </label>
                                <input type="text" class="form-control" name="name" value="<%=p.getName()%>">
                            </div>

                            <div class="form-group">
                                <label>DESCRIPTION : </label>
                                <textarea class="form-control" rows="3" name="description"><%=p.getDescription()%></textarea>
                            </div>

                            <div class="form-group">
                                <label>RATING : </label>
                                <input type="number" class="form-control" name="rating" value="<%=p.getRating()%>">
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