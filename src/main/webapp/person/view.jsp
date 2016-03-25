<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mahsom
  Date: 3/22/16
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${person.name}</title>
</head>
<body>
<h1>${person.name}</h1>
<ul>
    <c:set var="address" value="${person.address}"/>
    <li>${address.id}</li>
    <li>${address.state}</li>
    <li>${address.city}</li>
    <li>${address.street}</li>
    <li>${address.zip}</li>
</ul>
<a href="${person.url}&edit">Edit Person</a> | <a href="/contacts.do">Back to contact list</a>
</body>
</html>
