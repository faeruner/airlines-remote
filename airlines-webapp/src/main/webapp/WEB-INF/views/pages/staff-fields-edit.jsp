<jsp:useBean id="entity" scope="request" type="by.pvt.module3.entity.Staff"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row">
    <div class="col-xs-5">
        <div class="form-group has-feedback">
            <label for="entity-name" class="control-label">Name</label>
            <input id="entity-name" type="text" class="form-control" name="name" value="${entity.name}"
                   maxlength="100" required>
            <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
            <div class="help-block with-errors"></div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-xs-5">
        <div class="form-group has-feedback">
            <label for="entity-surname" class="control-label">Surname</label>
            <input id="entity-surname" type="text" class="form-control" name="surname" value="${entity.surname}"
                   maxlength="100" required>

            <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
            <div class="help-block with-errors"></div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-xs-5">
        <div class="form-group">
            <label for="entity-member-type" class="control-label">MemberType</label>
            <select id="entity-member-type" class="c-select form-control" name="member_type_id">
                <c:forEach var="item" items="${requestScope.member_type}">
                    <c:choose>
                        <c:when test="${entity.member.id eq item.id}">
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