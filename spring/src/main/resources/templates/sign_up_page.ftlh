<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
<form action="/signUp" method="post">
    <label>
        <input name="email" class="form-control" type="email" placeholder="EMAIL">
    </label>
    <label>
        <input name="firstName" class="form-control" type="text" placeholder="FIRST NAME">
    </label>
    <label>
        <input name="lastName" class="form-control" type="text" placeholder="LAST NAME">
    </label>
    <label>
        <input name="phone" class="form-control" type="text" placeholder="PHONE">
    </label>
    <label>
        <input name="password" class="form-control" type="password" placeholder="PASSWORD">
    </label>
    <input type="submit" class="btn btn-lg btn-primary" value="SIGN UP">
</form>
</body>
</html>