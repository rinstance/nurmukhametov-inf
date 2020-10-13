<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>login</th>
        <th>password</th>
    </tr>

    <c:forEach items="${usersForJsp}" var="user">
        <tr>
            <td>${user.login}</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>