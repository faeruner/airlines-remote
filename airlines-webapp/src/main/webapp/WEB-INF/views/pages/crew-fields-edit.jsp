<jsp:useBean id="entity" scope="request" type="by.pvt.module4.model.Crew"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row">
    <div class="col-xs-1">
        <div class="form-group">
            <label class="control-label">Ready?</label>
            <div class="radio">
                <label><input type="radio" name="ready" id="readyNo" value="0" ${requestScope.readyNo} />No</label>
            </div>
            <div class="radio">
                <label><input type="radio" name="ready" id="readyYes" value="1" ${requestScope.readyYes} />Yes</label>
            </div>
        </div>
    </div>
    <div class="col-xs-2">
        <div class="form-group">
            <label for="entity-create-date" class="control-label">CreateDate</label>
            <div class="input-group input-append date" id="inputCreateDate">
                <fmt:formatDate value="${entity.createDate}" pattern="dd.MM.yyyy" var="createDate"/>
                <input id="entity-create-date" type='text' class="form-control" name="create_date"
                       value="${createDate}"/>
                <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
            </div>
            <script type="text/javascript">
                $(function () {
                    $('#inputCreateDate').datetimepicker({
                        format: 'DD.MM.YYYY'
                    });
                });
            </script>
        </div>
    </div>
    <div class="col-xs-4">
        <div class="form-group">
            <label for="entity-user" class="control-label">User</label>
            <input id="entity-user" type="text" class="form-control" name="user"
                   value="${entity.user.name} ${entity.user.surname}" disabled="disabled"/>
        </div>
    </div>
</div>