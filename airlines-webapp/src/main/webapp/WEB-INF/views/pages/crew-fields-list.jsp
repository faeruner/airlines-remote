<jsp:useBean id="item" scope="request" type="by.pvt.module3.entity.Crew"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<td>
    <p>id: ${item.id}</p>
    <p>date: <fmt:formatDate value="${item.createDate}" pattern="dd.MM.yyyy"/></p>
    <p>user: ${item.user.name} ${item.user.surname}</p>
    <p>ready:
        <c:choose>
            <c:when test="${item.ready eq 0}">no</c:when>
            <c:otherwise>yes</c:otherwise>
        </c:choose>
    </p>
</td>
<td>
    <c:forEach var="item" items="${item.members}">
        <p>${item.member.name}: ${item.name} ${item.surname}</p>
    </c:forEach>
</td>