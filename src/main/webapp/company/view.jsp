<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mahsom
  Date: 3/24/16
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${company.name}</title>
</head>
<body>
<h1>${company.name}</h1>
<ul>
    <c:forEach var="office" items="${company.offices}">
        <li><a href="${office.url}">${office.name}</a></li>
    </c:forEach>
</ul>
<a href="/company.do?edit&id=${company.id}">Edit company</a> |
<a href="/office.do?add&company_id=${company.id}">Add office</a> |
<a href="/contacts.do">Back to contact list</a>
</body>
</html>
