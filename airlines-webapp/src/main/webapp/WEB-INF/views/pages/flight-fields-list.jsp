<jsp:useBean id="item" scope="request" type="by.pvt.module3.entity.Flight"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<td>${item.id}</td>
<td>${item.code}</td>
<td><fmt:formatDate value="${item.depDate}" pattern="dd.MM.yyyy"/></td>
<td><fmt:formatDate value="${item.returnDate}" pattern="dd.MM.yyyy"/></td>
<td><fmt:formatDate value="${item.createDate}" pattern="dd.MM.yyyy"/></td>
<td>${item.arrival.name}</td>
<td>${item.departure.name}</td>
<td>${item.airline.name}</td>
<td>${item.crew.id}</td>
<td>${item.user.name} ${item.user.surname}</td>