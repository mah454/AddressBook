<%--
  Created by IntelliJ IDEA.
  User: mahsom
  Date: 3/24/16
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${company.name}</title>
</head>
<body>
<h1>${company.name}</h1>

<form action="/company.do" method="post">
    <input type="hidden" name="add">
    <input type="text" name="name">
    <input type="submit" value="Add">
</form>
<a href="/contacts.do">Back to contact list</a>
</body>
</html>
