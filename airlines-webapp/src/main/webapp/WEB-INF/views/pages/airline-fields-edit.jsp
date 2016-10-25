<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="entity" scope="request" type="by.pvt.module4.model.Airline"/>
<div class="row">
    <div class="col-xs-12">
        <div class="form-group has-feedback" id="inputNameGroup">
            <label for="inputName" class="control-label">Name</label>
            <input data-remote="${action}/validate" data-equals="foo" data-equals-error="ошибка?" type="text"
                   class="form-control" id="inputName" maxlength="100" name="name" value="${entity.name}"
                   required>
            <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
            <div class="help-block with-errors"></div>
            <div class="text-danger">Error: ${requestScope.msgwrongname} ${entity.name}</div>
        </div>
        <%--
                <script type="text/javascript">
                    $(document).ready(function () {
                        $("#entityForm").validator({
                            custom: {
                                equals: function($el) {
                                    var matchValue = $el.data("equals"); // foo
                                    if ($el.val() !== matchValue){
                                        return "Hey, that's not valid! It's gotta be "+matchValue;
                                    };
                                }
                            },
                            error:{
                                equals: "Hey, that's not valid!"
                            }
                        });
                    });
                </script>
        --%>
    </div>
</div>