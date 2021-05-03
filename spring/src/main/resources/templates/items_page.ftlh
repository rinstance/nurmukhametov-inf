<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>count</th>
        </tr>
        <#list itemList as item>
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.count}</td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>