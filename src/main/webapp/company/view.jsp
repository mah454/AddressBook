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
    <li>${company.id}</li>
    <%--TODO : company list--%>
</ul>
<a href="/company.do?edit&id=${company.id}">Edit company</a> | <a href="/contacts.do">Back to contact list</a>
</body>
</html>
