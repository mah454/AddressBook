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
    <title>${office.name}</title>
</head>
<body>
<h1>${offce.name}</h1>
<ul>
    <li>${office.id}</li>
    <%--TODO : company list--%>
</ul>
<a href="/office.do?edit&id=${office.id}">Edit company</a> | <a href="/contacts.do">Back to contact list</a>
</body>
</html>
