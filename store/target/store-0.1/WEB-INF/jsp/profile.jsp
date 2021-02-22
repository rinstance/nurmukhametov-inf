<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Account</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<ul class="list-group">
    <li class="list-group-item active"><a href="/profile">Profile</a></li>
    <li class="list-group-item"><a href="/items">Buy Items</a></li>
    <li class="list-group-item"><a href="/orders">My Orders</a></li>
    <li class="list-group-item"><a href="/companies">Look Companies</a></li>
</ul>

<center>
    <u> <h1>Profile</h1></u>
    <c:forEach items="${userProfile}" var="user">

        <p>Login: ${user.login}</p>
        <p>First Name: ${user.firstName}</p>
        <p>Last Name: ${user.lastName}</p>

    </c:forEach>

    <form method="post" action="/profile">
        <input type="submit" class="btn btn-danger" name="logout" value="Logout">
    </form>
</center>
</body>
</html>
