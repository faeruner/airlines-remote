<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<tiles:insertAttribute name="params"/>
<html>
<head><title>AirlineDombrovsky: ${entity_name}
</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <link href="${pageContext.request.contextPath}/css/airline.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/moment.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/locale/ru.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/validator.js"></script>
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
                <form action="${action}" method="post" id="entityForm" role="form" data-toggle="validator">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-8">
                                    <h3>
                                        <c:choose>
                                            <c:when test="${empty entity.id}">Insert </c:when>
                                            <c:otherwise>Edit </c:otherwise>
                                        </c:choose>
                                        ${entity_name}
                                    </h3>
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
                                <div class="col-xs-3">
                                    <div class="form-group">
                                        <label for="inputId" class="form-control-label">Id</label>
                                        <input type="text" class="form-control text-right" id="inputId"
                                               value="${entity.id}"
                                               disabled="disabled">
                                    </div>
                                </div>
                            </div>

                            <tiles:insertAttribute name="page-fields"/>
                        </div>
                        <div class="panel-footer panel-footer-custom">
                            <div class="row">
                                <div class="col-xs-10 form-action">
                                    <input type="hidden" name="page_num" value="${requestScope.current_page}"/>
                                    <c:choose>
                                        <c:when test="${empty entity.id}">
                                            <button type="submit" class="btn btn-primary" name="command" value="add">
                                                Insert
                                            </button>
                                        </c:when>
                                        <c:otherwise>
                                            <input type="hidden" name="id" value="${entity.id}"/>
                                            <button type="submit" class="btn btn-primary" name="command" value="upd">
                                                Save
                                            </button>
                                        </c:otherwise>
                                    </c:choose>
                                    <a class="btn btn-default" href="${action}?command=list">Close</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </div>
        </div>
    </div>
</section>
<section>
    <tiles:insertAttribute name="advanced-edit" ignore="true"/>
</section>
<footer id="footer">
    <tiles:insertAttribute name="footer"/>
</footer>
</body>
</html>