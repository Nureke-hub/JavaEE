<div class="modal fade bd-example-modal-lg" id="edit_post" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">EDIT POST</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <form action="/edit_post?post_id=<%=p.getId()%>" method="post">
                <div class="container">
                    <div class="form-group">
                        <label>TITLE : </label>
                        <input type="text" class="form-control" name="title" value="<%=p.getTitle()%>">
                    </div>

                    <div class="form-group">
                        <label>SHORT CONTENT : </label>
                        <textarea class="form-control" rows="3" name="short_content"><%=p.getShort_content()%></textarea>
                    </div>

                    <div class="form-group">
                        <label>CONTENT : </label>
                        <textarea class="form-control" rows="3" name="content"><%=p.getContent()%></textarea>
                    </div>
                    <button type="submit" class="btn" style="background-color: rgb(24,11,122); color: white" data-toggle="modal" data-target="#add">Edit</button>
                </div>
            </form>
        </div>
    </div>
</div>