<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<ul class="list-group">
    <li class="list-group-item"><a href="/profile">Profile</a></li>
    <li class="list-group-item"><a href="/items">Buy Items</a></li>
    <li class="list-group-item"><a href="/orders">My Orders</a></li>
    <li class="list-group-item active"><a href="/companies">Look Companies</a></li>
</ul>

<center>
    <u><h1>Companies</h1></u>

    <c:forEach items="${companiesLook}" var="company">
        <p></p>
        <p>Company name: ${company.key.name}</p>
        <p>Count sold items: ${company.key.countSoldItems}</p>

        <c:forEach items="${company.value}" var="val">

            <p>Name: ${val.name} Count: ${val.count}</p>

        </c:forEach>

        <hr class="col-xs-12">

    </c:forEach>
</center>
</body>
</html>
