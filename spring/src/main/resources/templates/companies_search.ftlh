<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Companies</title>
    <script
            src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
            crossorigin="anonymous"></script>

</head>
<body>

<script type="text/javascript">

    function setTextInTable(response, table) {
        let innerHtml = '<p>\n' + '</p>';

        for (let i = 0; i < response.length; i++) {
            innerHtml += '<tr>';
            innerHtml += '  <td>' + response[i]['id'] + '</td>';
            innerHtml += '  <td>' + response[i]['name'] + '</td>';
            innerHtml += '  <td>' + response[i]['countSoldItems'] + '</td>';
            innerHtml += '</tr>';
        }
        table.html(innerHtml);
    }

    function doAjaxPost(name) {
        $.ajax({
            type: "GET",
            url: "/companies_search/" + name,
            data: "name:" + name,
            success: function (response) {
                setTextInTable(response, $('#table'))
            },
            dataType: "json",
            contentType: "application/json"
        });
    }
</script>

<div>

    <label>Search</label>
    <form name="searchForm" method="get">
        <input type="text" id="searchName" name="searchName" oninput="doAjaxPost($('#searchName').val())"
               autocomplete="off">
    </form>

</div>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Sold items</th>
    </tr>

</table>

<table id="table">
</table>

<#--<table>-->
<#--    <tr>-->
<#--        <th>Id</th>-->
<#--        <th>Name</th>-->
<#--        <th>Sold items</th>-->
<#--    </tr>-->
<#--    <#list persons as company>-->
<#--        <tr>-->
<#--            <td>${company.id}</td>-->
<#--            <td>${company.name}</td>-->
<#--            <td>${company.countSoldItems}</td>-->
<#--        </tr>-->
<#--    </#list>-->
<#--</table>-->

</body>
</html>