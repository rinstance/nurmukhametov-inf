<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>

<form method="post" action="/admin">
    <label for="item_title">Title item</label>
    <input id="item_title" class="form-control" name="item_title" placeholder="Title">

    <label for="item_count">Count item</label>
    <input id="item_count" class="form-control" name="item_count" placeholder="Count">

    <label for="item_image">Image url item</label>
    <input id="item_image" class="form-control" name="item_image" placeholder="Image url">

    <label for="company_id">Image url item</label>
    <input id="company_id" class="form-control" name="company_id" placeholder="Company id">

    <input type="submit" class="btn btn-lg btn-primary" name="add" value="Add item">

    <!--https://i2.wp.com/scepra.ru/wp-content/uploads/2016/01/pesnya-antipesnya.jpg-->
</form>

<u><h1>Companies</h1></u>

<c:forEach items="${Companies}" var="item">

    <p>Name: ${item.name}</p>
    <p>Id: ${item.id}</p>

    <hr class="col-xs-12">

</c:forEach>

</body>
</html>
