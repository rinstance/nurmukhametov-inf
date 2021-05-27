<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
<ul class="list-group">
    <li class="list-group-item active"><a href="/profile">Profile</a></li>
    <li class="list-group-item"><a href="/items">Buy Items</a></li>
    <li class="list-group-item"><a href="/orders">My Orders</a></li>
    <li class="list-group-item"><a href="/companies">Look Companies</a></li>
</ul>

<center>

    <form action="/items" method="get">
        <label>
            <input name="size" required class="form-control" type="number" placeholder="Size">
        </label>
        <label>
            <input name="pagesCount" required class="form-control" type="number" placeholder="Page">
        </label>
        <input type="submit" class="btn btn-lg btn-primary" value="OK">
    </form>

    <u> <h1>Items for Sale</h1></u>
    <hr class="col-xs-12">
    <#list itemsPage as item>
        <img src="${item.img}" width="200" height="200">
        <p>Title: ${item.name}</p>
        <p>Company: ${item.company.name}</p>
        <p>Count: ${item.count}</p>
        <form method="get" action="/order/saved">
            <input type="submit" class="btn btn-outline-primary" name="id" value="${item.id}">
        </form>
        <hr class="col-xs-12">
    </#list>
</center>
</body>
</html>