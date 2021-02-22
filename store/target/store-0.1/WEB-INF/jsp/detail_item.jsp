<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Make Order</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script
            src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
            crossorigin="anonymous"></script>
    <script src="js/toastjs.js"> </script>
    <script>
        function setTextInTable(type, div) {
            let innerHtml = '\n' +
                '<form method="post" action="/detail_item">';
            if (type['type'] === 'card') {
                innerHtml += '\n' +
                    '<label for="card_input">Type your card</label>\n' +
                    '<input id="card_input" class="form-control" name="card_input" placeholder="Your card">\n\n' +

                    '<label for="month_input">Month/Year</label>\n' +
                    '<input id="month_input" class="form-control" name="month_input" placeholder="Your month/year">\n\n' +

                    '<label for="code_input">Code</label>\n' +
                    '<input id="code_input" class="form-control" name="code_input" placeholder="Your code">\n\n'
            }
            if (type['type'] === 'nal') {
                innerHtml += '\n' +
                    '<p id="nal_input">Give money to the courier</p>';
            }
            innerHtml += '\n' +
                '    <p>Choose date: <input type="date" name="calendar">\n'

            innerHtml += '<input type="submit" class="btn btn-outline-success" name="order" value="Order"></form>'
            div.html(innerHtml);
        }

        function sendReq(type) {
            let data = {
                "type": type
            };

            $.ajax({
                type: "POST",
                url: "/detail_item",
                data: JSON.stringify(data),
                success: function (response) {
                    setTextInTable(response, $('#how_buy'))
                },
                dataType: "json",
                contentType: "application/json"
            });
        }
    </script>
</head>
<body>

<ul class="nav">
    <li class="list-group-item"><a href="/profile">Profile</a></li>
    <li class="list-group-item"><a href="/items">Buy Items</a></li>
    <li class="list-group-item"><a href="/orders">My Orders</a></li>
    <li class="list-group-item"><a href="/companies">Look Companies</a></li>
</ul>

<center>

    <c:forEach items="${itemBuy}" var="item">

        <img src="${item.img}" width="200" height="200">
        <p>Title: ${item.name}</p>
        <p>Count: ${item.count}</p>

    </c:forEach>

    <select onchange="sendReq(this.value)" class="custom-select" name="type" id="typeId">
        <option selected>Выберите способ оплаты:</option>
        <option value="nal">Наличные</option>
        <option value="card">Карта</option>
    </select>

    <div id="how_buy">

    </div>
</center>
</body>
</html>
