<div class="modal fade bd-example-modal-lg" id="add" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">ADD NEWS</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <form action="/news?add=true" method="post">
                <div class="container">
                    <div class="form-group">
                        <label>TITLE : </label>
                        <input type="text" class="form-control" name="title">
                    </div>

                    <div class="form-group">
                        <label>SHORT CONTENT : </label>
                        <textarea class="form-control" rows="3" name="short_content"></textarea>
                    </div>

                    <div class="form-group">
                        <label>CONTENT : </label>
                        <textarea class="form-control" rows="3" name="content"></textarea>
                    </div>

                    <%-- language --%>
                    <div class="form-group">
                        <label>LANGUAGES : </label>
                        <select class="custom-select" name="language_id">
                            <%for (Languages lang : languages){%>
                                <option value="<%=lang.getId()%>"><%=lang.getCode()%></option>
                            <%}%>
                        </select>
                    </div>

                    <%-- publication --%>
                    <div class="form-group">
                        <label>PUBLICATIONS : </label>
                        <select class="custom-select" name="publication_id">
                            <%for (Publications pub : publications){%>
                            <option value="<%=pub.getId()%>"><%=pub.getName()%></option>
                            <%}%>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>PICTURE URL : </label>
                        <input type="text" class="form-control" name="picture_url">
                    </div>

                    <button type="submit" class="btn btn-success">ADD</button>
                </div>
            </form>
        </div>
    </div>
</div>