<%-- Modal edit--%>
<div class="modal fade" id="add" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">ADD LANGUAGE</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <form action="/languages?add=true" method="post">
                <div class="container">
                    <div class="form-group">
                        <label>NAME : </label>
                        <input type="text" class="form-control" name="name">
                    </div>

                    <div class="form-group">
                        <label>CODE : </label>
                        <input type="text" class="form-control" name="code">
                    </div>

                    <button type="submit" class="btn btn-success">ADD</button>
                </div>
            </form>
        </div>
    </div>
</div>