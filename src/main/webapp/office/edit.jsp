<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Office Page</title>
</head>
<body>
<h1>Edit Office :</h1>

<form action="<c:url value="/office.do"/>" method="post">
    <input type="hidden" name="edit">
    <input type="hidden" name="id" value="${office.id}">
    <ul>
        <c:set var="address" value="${office.address}"/>
        <li>Name : <input type="text" name= "name" value="${office.name}"></li>
        <li>State : <input type="text" name="state" value="${office.address.state}"></li>
        <li>City : <input type="text" name="city" value="${office.address.city}"></li>
        <li>street : <input type="text" name="street" value="${office.address.street}"></li>
        <li>zip : <input type="text" name="zip" value="${office.address.zip}"></li>
    </ul>
    <input type="submit" value="Edit">
</form>
<form action="/office.do" method="post">
    <input type="hidden" name="delete">
    <input type="hidden" name="id" value="${office.id}">
    <input type="submit" value="Delete">
</form>
<a href="${office.company.url}">Back to ${office.company.name}</a>
</body>
</html>
