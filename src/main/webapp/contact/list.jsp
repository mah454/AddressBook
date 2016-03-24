<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mahsom
  Date: 3/21/16
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Contacts</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    <c:forEach var="contact" items="${contacts}">
        <tr>
            <th><c:out value="${contact.id}"/></th>
            <th><a href="/person.do?id=${contact.id}"><c:out value="${contact.name}"/></a></th><%--FIXME : url problem --%>
        </tr>
    </c:forEach>
</table>
<a href="/person.do?add">Add new person</a> | <a href="/company.do?add">Add new company</a>
</body>
</html>
