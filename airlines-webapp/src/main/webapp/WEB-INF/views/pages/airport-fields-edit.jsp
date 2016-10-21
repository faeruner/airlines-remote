<jsp:useBean id="entity" scope="request" type="by.pvt.module3.entity.Airport"/>
<div class="row">
    <div class="col-xs-12">
        <div class="form-group has-feedback">
            <label for="inputName" class="control-label">Name</label>
            <input type="text" class="form-control" id="inputName" maxlength="100" name="name" value="${entity.name}"
                   required>
            <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
            <div class="help-block with-errors"></div>
        </div>
    </div>
</div>