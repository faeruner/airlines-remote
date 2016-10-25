<jsp:useBean id="item" scope="request" type="by.pvt.module4.model.User"/>
<td>${item.id}</td>
<td>${item.name}</td>
<td>${item.surname}</td>
<td>${item.login}</td>
<td>${item.role.name}</td>