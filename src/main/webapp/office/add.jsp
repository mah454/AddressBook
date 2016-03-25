<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Office Page</title>
</head>
<body>
<h1>Add Office :</h1>

<form action="<c:url value="/office.do"/>" method="post">
    <input type="hidden" name="add">
    <input type="hidden" name="company_id" value="${company.id}">
    <ul>
        <li>Name : <input type="text" name="name"></li>
        <li>State : <input type="text" name="state"></li>
        <li>City : <input type="text" name="city"></li>
        <li>street : <input type="text" name="street"></li>
        <li>zip : <input type="text" name="zip"></li>
    </ul>
    <input type="submit" value="add">
</form>
<a href="${company.url}">Back to ${company.name}</a>
</body>
</html>
