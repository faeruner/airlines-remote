<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="entity_name" value="Flight" scope="request"/>
<c:set var="table_head"
       value="<th class='col-xs-1'>ID</th><th>Code</th><th>Departure</th><th>Return</th><th>Create</th><th>Arrival</th><th>Departure</th><th>Airline</th><th>CrewId</th><th>User</th>"
       scope="request"/>
<c:set var="action" value="/controller/flight" scope="request"/>