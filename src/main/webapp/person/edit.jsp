<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Contact Page</title>
</head>
<body>
<h1>Edit Contact :</h1>

<form action="<c:url value="/person.do"/>" method="post">
    <input type="hidden" name="edit">
    <input type="hidden" name="id" value="${person.id}">
    <ul>
        <c:set var="address" value="${person.address}"/>
        <li>Name : <input type="text" name="name" value="${person.name}"></li>
        <li>State : <input type="text" name="state" value="${address.state}"></li>
        <li>City : <input type="text" name="city" value="${address.city}"></li>
        <li>street : <input type="text" name="street" value="${address.street}"></li>
        <li>zip : <input type="text" name="zip" value="${address.zip}"></li>
        <li>manager :
            <select name="manager_id">
                <option value="0">(None)</option>
                <c:forEach var="manager" items="${managers}">
                    <c:choose>
                        <c:when test="${manager == person.manager}">
                            <option value="${manager.id}" selected>${manager.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${manager.id}">${manager.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </li>

        <li>employer :
            <select name="employer_id">
                <option value="0">(None)</option>
                <c:forEach var="employer" items="${employers}">
                    <c:choose>
                        <c:when test="${employer == person.employer}">
                            <option value="${employer.id}" selected>${employer.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${employer.id}">${employer.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </li>

    </ul>
    <input type="submit" value="Edit">
</form>
<form action="/person.do" method="post">
    <input type="hidden" name="delete">
    <input type="hidden" name="id" value="${person.id}">
    <input type="submit" value="Delete">
</form>
<a href="contacts.do">Back to contact list</a>
</body>
</html>
