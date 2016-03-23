<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Contact Page</title>
</head>
<body>
<h1>Add Contact :</h1>

<form action="<c:url value="/contact.do"/>" method="post">
    <input type="hidden" name="edit">
    <input type="hidden" name="id" value="${contact.id}">
    <ul>
        <c:set var="address" value="${contact.address}"/>
        <li>Name : <input type="text" name= "name" value="${contact.name}"></li>
        <li>State : <input type="text" name="state" value="${address.state}"></li>
        <li>City : <input type="text" name="city" value="${address.city}"></li>
        <li>street : <input type="text" name="street" value="${address.street}"></li>
        <li>zip : <input type="text" name="zip" value="${address.zip}"></li>
    </ul>
    <input type="submit" value="edit">
</form>
<form action="/contact.do" method="post">
    <input type="hidden" name="delete">
    <input type="hidden" name="id" value="${contact.id}">
    <input type="submit" value="delete">
</form>
<a href="contacts.do">Back to contact list</a>
</body>
</html>
