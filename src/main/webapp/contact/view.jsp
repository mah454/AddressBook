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
    <title>View Contact</title>
</head>
<body>
<h1>${contact.name}</h1>
<ul>
    <c:set var="address" value="${contact.address}"/>
    <li>${address.state}</li>
    <li>${address.city}</li>
    <li>${address.street}</li>
    <li>${address.zip}</li>
</ul>
<a href="/contact.do?edit&id=${contact.id}">Edit Contact</a> | <a href="/contacts.do">Back to contact list</a>
</body>
</html>
