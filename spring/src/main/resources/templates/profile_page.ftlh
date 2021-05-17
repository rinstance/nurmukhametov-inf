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
    <li class="list-group-item"><a href="/items/search">Buy Items</a></li>
    <li class="list-group-item"><a href="/orders">My Orders</a></li>
    <li class="list-group-item"><a href="/companies">Look Companies</a></li>
</ul>

<center>
    <u> <h1>Profile</h1></u>
    <h1>Phone: +${currUser.phone}</h1>
    <h1>Email: ${currUser.email}</h1>
</center>
</body>
</html>