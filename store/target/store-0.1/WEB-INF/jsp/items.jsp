<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buy Items</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<ul class="list-group">
    <li class="list-group-item"><a href="/profile">Profile</a></li>
    <li class="list-group-item active"><a href="/items">Buy Items</a></li>
    <li class="list-group-item"><a href="/orders">My Orders</a></li>
    <li class="list-group-item"><a href="/companies">Look Companies</a></li>
</ul>

<center>
    <u> <h1>Buy Items</h1></u>

    <c:forEach items="${itemsBuy}" var="item">

        <img src="${item.img}" width="200" height="200">
        <p>Title: ${item.name}</p>
        <p>Count: ${item.count}</p>
        <form method="post" action="/items">
            <input type="submit" class="btn btn-outline-primary" name="${item.id}" value="Buy ${item.name}">
        </form>
        <hr class="col-xs-12">
    </c:forEach>
</center>
</body>
</html>
