<jsp:useBean id="entity" scope="request" type="by.pvt.module4.model.User"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">
    <div class="col-xs-5">
        <div class="form-group has-feedback">
            <label for="inputName" class="control-label">Name</label>
            <input type="text" class="form-control" id="inputName" maxlength="100" name="name" value="${entity.name}"
                   required>
            <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
            <div class="help-block with-errors"></div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-xs-5">
        <div class="form-group has-feedback">
            <label for="inputSurname" class="control-label">Surname</label>
            <input type="text" class="form-control" id="inputSurname" maxlength="100" name="surname"
                   value="${entity.surname}" required>
            <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
            <div class="help-block with-errors"></div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-xs-5">
        <div class="form-group has-feedback">
            <label for="inputLogin" class="control-label">Login</label>
            <input type="text" class="form-control" id="inputLogin" maxlength="16"
                   name="login" value="${entity.login}" required>
            <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
            <div class="help-block with-errors"></div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-xs-5">
        <div class="form-group has-feedback">
            <label for="inputPassword" class="control-label">Password</label>
            <input type="text" class="form-control" id="inputPassword" maxlength="16"
                   name="password" value="${entity.password}" required>
            <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
            <div class="help-block with-errors"></div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-xs-3">
        <div class="form-group">
            <label for="inputRole" class="control-label">Role</label>
            <select id="inputRole" class="c-select form-control" name="user_role_id">
                <c:forEach var="item" items="${requestScope.user_roles}">
                    <c:choose>
                        <c:when test="${entity.role.id eq item.id}">
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