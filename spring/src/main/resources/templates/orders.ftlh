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
    <hr class="col-xs-12">
    <#list orders as order>
        <p>Item: ${order.item}</p>
        <p>Order time: ${order.orderTime}</p>
        <p>Get time: ${order.getDate}</p>
        <hr class="col-xs-12">
    </#list>
</center>
</body>
</html>
