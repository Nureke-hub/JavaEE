<%@ page import="db.classes.News" %>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">TITLE</th>
        <th scope="col">LANGUAGE</th>
        <th scope="col">ADDED DATE</th>
        <th scope="col">PUBLICATION</th>
        <th scope="col">ACTION</th>
    </tr>
    </thead>
    <tbody>
    <%for (News n : news){%>
    <tr>
        <th scope="row"><%=n.getId()%></th>
        <td><%=n.getTitle()%></td>
        <td><%=n.getLanguage().getName()%></td>
        <td><%=n.getPost_date()%></td>
        <td><%=n.getPublication().getName()%></td>
        <td>
            <div class="btn-group">
                <a class="btn btn-success"data-toggle="modal" data-target="#detail<%=n.getId()%>">detail</a>
                <a class="btn btn-primary" data-toggle="modal" data-target="#edit<%=n.getId()%>">edit</a>
                <a class="btn btn-danger" data-toggle="modal" data-target="#delete<%=n.getId()%>">delete</a>
            </div>
        </td>
    </tr>

    <%-- Modal detail --%>
    <div class="modal fade bd-example-modal-lg" id="detail<%=n.getId()%>" tabindex="-1" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">DETAIL NEWS</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>

                <div class="container">
                    <div class="form-group">
                        <label>TITLE : </label>
                        <textarea type="text" class="form-control" name="title"><%=n.getTitle()%></textarea>
                    </div>

                    <div>
                        <label>SHORT CONTENT : </label>
                        <textarea class="form-control" name="short_content"><%=n.getShort_content()%></textarea>
                    </div>

                    <div class="form-group">
                        <label>CONTENT : </label>
                        <textarea class="form-control" rows="9" name="content"><%=n.getContent()%></textarea>
                    </div>

                    <%-- language --%>
                    <div class="form-group">
                        <label>LANGUAGE : </label>
                        <label type="text" class="form-control"> <%=n.getLanguage().getName()%> </label>
                    </div>

                    <%-- publication --%>
                    <div class="form-group">
                        <label>PUBLICATION : </label>
                        <label type="text" class="form-control"><%=n.getPublication().getName()%></label>
                    </div>

                    <div class="form-group">
                        <label>PICTURE URL : </label>
                        <label type="text" class="form-control" name="picture_url" ><%=n.getPicture_url()%></label>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>
    </div>


    <%--Modal delete --%>
    <div class="modal fade" id="delete<%=n.getId()%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">ARE YOU SURE TO DELETE</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    News <%=n.getTitle()%>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <form action="/news?delete=true&id=<%=n.getId()%>" method="post">
                        <button type="submit" class="btn btn-danger">DELETE</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <%-- Modal edit--%>
    <div class="modal fade bd-example-modal-lg" id="edit<%=n.getId()%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">EDIT NEWS</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>

                <form action="/news?edit=true&id=<%=n.getId()%>" method="post">
                    <div class="container">
                        <div class="form-group">
                            <label>TITLE : </label>
                            <input type="text" class="form-control" name="title" value="<%=n.getTitle()%>">
                        </div>

                        <div class="form-group">
                            <label>SHORT CONTENT : </label>
                            <textarea class="form-control" rows="3" name="short_content"><%=n.getShort_content()%></textarea>
                        </div>

                        <div class="form-group">
                            <label>CONTENT : </label>
                            <textarea class="form-control" rows="9" name="content"><%=n.getContent()%></textarea>
                        </div>

                        <%-- language --%>
                        <div class="form-group">
                            <label>LANGUAGE : </label>
                            <select class="custom-select" name="language_id">
                                <%for (Languages lang : languages){%>
                                    <%if (lang.getCode().equals(n.getLanguage().getCode())){%>
                                    <option selected value="<%=lang.getId()%>"><%=lang.getCode()%></option>
                                    <%}else{%>
                                    <option value="<%=lang.getId()%>"><%=lang.getCode()%></option>
                                    <%}%>
                                <%}%>
                            </select>
                        </div>

                        <%-- publication --%>
                        <div class="form-group">
                            <label>PUBLICATION : </label>
                            <select class="custom-select" name="publication_id">
                                <%for (Publications pub : publications){%>
                                    <%if (pub.getId() == n.getPublication().getId()){%>
                                    <option selected value="<%=pub.getId()%>"><%=pub.getName()%></option>
                                    <%}else{%>
                                    <option value="<%=pub.getId()%>"><%=pub.getName()%></option>
                                    <%}%>
                                <%}%>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>PICTURE URL : </label>
                            <input type="text" class="form-control" name="picture_url" value="<%=n.getPicture_url()%>">
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