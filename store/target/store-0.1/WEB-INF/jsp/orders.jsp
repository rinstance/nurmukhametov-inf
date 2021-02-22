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
    <li class="list-group-item active"><a href="/orders">My Orders</a></li>
    <li class="list-group-item"><a href="/companies">Look Companies</a></li>
</ul>

<center>
    <u><h1>My Orders</h1></u>

    <c:forEach items="${ordersLook}" var="val">

        <c:forEach items="${val}" var="order">
            <p>Item: ${order.key.itemName}</p>
            <p>Order time: ${order.key.order_time}</p>
            <p>Get date: ${order.key.getDate}</p>
            <c:if test="${order.value == 'nal'}">
                <p>Type: Cash</p>
            </c:if>

            <c:if test="${order.value == 'card'}">
                <p>Type: Credit card</p>
            </c:if>
            <hr class="col-xs-12">
        </c:forEach>

    </c:forEach>
</center>
</body>
</html>
