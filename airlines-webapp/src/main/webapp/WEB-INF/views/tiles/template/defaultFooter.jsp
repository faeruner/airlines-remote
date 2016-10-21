<div class="text-info">
    <hr/>
    <p style="text-align: left;">
        Debug info: session = ${sessionScope}
    </p>
</div>
<div>
    <div class="modal fade" id="errorModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header alert alert-danger">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Error Message</h4>
                </div>
                <div class="modal-body">
                    <p>${requestScope.text_error}</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>
</div>