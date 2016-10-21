<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<tiles:insertAttribute name="params"/>
<html>
<head><title>AirlineDombrovsky: ${entity_name}
</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <link href="${pageContext.request.contextPath}/css/airline.css" rel="stylesheet" type="text/css"/>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#errorModal").modal({
                show: ${requestScope.show_error}
            });
        });
    </script>
</head>
<body>
<header>
    <tiles:importAttribute name="title" toName="apptitle" scope="request"/>
    <tiles:importAttribute name="subtitle" scope="request"/>
    <tiles:insertAttribute name="header"/>
</header>
<section id="main_list">
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-8">
                                <c:choose>
                                    <c:when test="${empty user}">
                                        <h3>${entity_name} List</h3>
                                    </c:when>
                                    <c:otherwise>
                                        <h3>${entity_name} List. Welcome, ${user.role.name}</h3>
                                        <p>${user.name}, hello!</p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="col-xs-4">
                                <p style="text-align: right;">
                                    <a class="btn btn-link btn-default" href="/logout">Logout</a>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <form class="form-inline col-xs-1" method="post" action="${action}">
                                <input type="hidden" name="id" value="0"/>
                                <input type="hidden" name="page_num" value="${requestScope.insertPageNum}"/>
                                <button type="submit" class="btn btn-primary" name="command"
                                        value="edit">Insert
                                </button>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                            <div class="col-xs-10">
                                <security:authorize access="hasRole('ROLE_ADMINISTRATOR')">
                                    <a class="btn btn-default" href="/controller/flight">Flights</a>
                                    <a class="btn btn-default" href="/controller/airport">Airports</a>
                                    <a class="btn btn-default" href="/controller/airline">Airlines</a>
                                    <a class="btn btn-default" href="/controller/user">Users</a>
                                </security:authorize>
                                <security:authorize access="hasRole('ROLE_DISPATCHER')">
                                    <a class="btn btn-default" href="/controller/crew">Crew</a>
                                    <a class="btn btn-default" href="/controller/staff">Staff</a>
                                </security:authorize>
                            </div>
                        </div>
                    </div>
                    <table class="table table-hover table-sm table-inverse">
                        <thead class="thead-default thead-inverse">
                        <tr bgcolor="#f5f5f5">
                            <th style="width: 100px">Actions</th>
                            ${table_head}
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${requestScope.entities}">
                            <tr>
                                <td>
                                    <form method="post" action="${action}">
                                        <input type="hidden" name="id" value="${item.id}">
                                        <input type="hidden" name="page_num" value="${requestScope.current_page}"/>
                                        <button type="submit" name="command" value="edit"
                                                class="btn btn-default btn-xs">edit
                                        </button>
                                        <button type="submit" name="command" value="del"
                                                class="btn btn-default btn-xs">delete
                                        </button>
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    </form>
                                </td>
                                <c:set var="item" value="${item}" scope="request"/>
                                <tiles:insertAttribute name="page-fields"/>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="panel-footer panel-footer-custom">
                        <div class="row">
                            <div class="col-xs-1">
                                Page: ${requestScope.current_page}/${requestScope.numPages.size()}
                            </div>
                            <form class="form-inline col-xs-11" action="${action}" method="post">
                                <input type="hidden" name="command" value="list">
                                <div class="btn-group" role="group" aria-label="...">
                                    <c:forEach var="numPage" items="${requestScope.numPages}">
                                        <c:choose>
                                            <c:when test="${numPage eq requestScope.current_page}">
                                                <button type="submit" name="page_num" value="${numPage}"
                                                        class="btn btn-primary btn-xs">${numPage}</button>
                                            </c:when>
                                            <c:otherwise>
                                                <button type="submit" name="page_num" value="${numPage}"
                                                        class="btn btn-default btn-xs">${numPage}</button>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </div>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<footer id="footer">
    <tiles:insertAttribute name="footer"/>
</footer>
</body>
</html>