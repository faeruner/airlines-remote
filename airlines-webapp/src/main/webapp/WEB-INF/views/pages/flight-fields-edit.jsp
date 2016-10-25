<jsp:useBean id="entity" scope="request" type="by.pvt.module4.model.Flight"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="row">
    <div class="col-xs-3">
        <div class="form-group has-feedback">
            <label for="entity-code" class="control-label">Code</label>
            <input id="entity-code" type="text" class="form-control" name="code" value="${entity.code}"
                   maxlength="45" required>
            <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
            <div class="help-block with-errors"></div>
        </div>
    </div>
    <div class="col-xs-3">
        <div class="form-group">
            <label for="entity-crew" class="control-label">CrewId</label>
            <select id="entity-crew" class="c-select form-control" name="crew_id">
                <c:forEach var="item" items="${requestScope.crew}">
                    <c:choose>
                        <c:when test="${entity.crew.id eq item.id}">
                            <option selected value="${item.id}">${item.id}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${item.id}">${item.id}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-xs-6">
        <div class="form-group">
            <label for="entity-airline" class="control-label">Airline</label>
            <select id="entity-airline" class="c-select form-control" name="airline_id">
                <c:forEach var="item" items="${requestScope.airline}">
                    <c:choose>
                        <c:when test="${entity.airline.id eq item.id}">
                            <option selected value="${item.id}">${item.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${item.id}">${item.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-xs-2">
        <div class="form-group">
            <label for="entity-dep-date" class="control-label">DepDate</label>
            <div class="input-group input-append date" id="inputDepDate">
                <fmt:formatDate value="${entity.depDate}" pattern="dd.MM.yyyy" var="depDate"/>
                <input id="entity-dep-date" type='text' class="form-control" name="departure" value="${depDate}"/>
                <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
            </div>
            <script type="text/javascript">
                $(function () {
                    $('#inputDepDate').datetimepicker({
                        format: 'DD.MM.YYYY'
                    });
                });
            </script>
        </div>
    </div>
    <div class="col-xs-4">
        <div class="form-group">
            <label for="entity-departure" class="control-label">Departure</label>
            <select id="entity-departure" class="c-select form-control" name="airport_dep_id">
                <c:forEach var="item" items="${requestScope.departure}">
                    <c:choose>
                        <c:when test="${entity.departure.id eq item.id}">
                            <option selected value="${item.id}">${item.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${item.id}">${item.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-xs-2">
        <div class="form-group">
            <label for="inputReturnDate" class="control-label">ReturnDate</label>
            <div class="input-group input-append date" id="inputReturnDate">
                <fmt:formatDate value="${entity.returnDate}" pattern="dd.MM.yyyy" var="retDate"/>
                <input type='text' class="form-control" name="return_date" value="${retDate}"/>
                <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
            </div>
            <script type="text/javascript">
                $(function () {
                    $('#inputReturnDate').datetimepicker({
                        format: 'DD.MM.YYYY'
                    });
                });
            </script>
        </div>
    </div>
    <div class="col-xs-4">
        <div class="form-group">
            <label for="entity-arrival" class="control-label">Arrival</label>
            <select id="entity-arrival" class="c-select form-control" name="airport_arv_id">
                <c:forEach var="item" items="${requestScope.arrival}">
                    <c:choose>
                        <c:when test="${entity.arrival.id eq item.id}">
                            <option selected value="${item.id}">${item.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${item.id}">${item.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-xs-2">
        <div class="form-group">
            <label for="entity-cre-date" class="control-label">CreateDate</label>
            <div class="input-group input-append date" id="inputCreateDate">
                <fmt:formatDate value="${entity.createDate}" pattern="dd.MM.yyyy" var="creDate"/>
                <input id="entity-cre-date" type='text' class="form-control" name="create_date" value="${creDate}"/>
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
<div class="row">
</div>
<div class="row">
</div>
<div class="row">
</div>