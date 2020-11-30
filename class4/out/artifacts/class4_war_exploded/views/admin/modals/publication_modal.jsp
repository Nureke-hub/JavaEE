<div class="modal fade" id="add" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">ADD NEW PUBLICATION</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <form action="/index?add=true" method="post">
                <div class="container">
                    <div class="form-group">
                        <label>NAME : </label>
                        <input type="text" class="form-control" name="name">
                    </div>

                    <div class="form-group">
                        <label>DESCRIPTION : </label>
                        <textarea class="form-control" rows="3" name="description"></textarea>
                    </div>

                    <div class="form-group">
                        <label>RATING : </label>
                        <input type="number" class="form-control" name="rating">
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-success">ADD</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>