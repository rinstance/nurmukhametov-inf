function getCompanies() {
    $.get("http://localhost:8080/companies-js", function (data) {
        let html = '';

        for (let i = 0; i < data.length; i++) {
            html += '<tr> <th scope="row">' + (i + 1) + '</th>' +
                '<td>' + data[i].name + '</td>' +
                '<td>' + data[i].countSoldItems + '</td>' +
                '</tr>'
        }
        html += "";
        $('#table_header').after(html);
    })
}

function getItems() {
    $.get("http://localhost:8080/items-js", function (data) {
        let html = '';

        // <img src="${item.img}" width="200" height="200">
        for (let i = 0; i < data.length; i++) {
            html += '<tr> <th scope="row">' + (i + 1) + '</th>' +
                '<td> <img src=' + data[i].img + 'width="100" height="100"> </td>' +
                '<td>' + data[i].name + '</td>' +
                '<td>' + data[i].count + '</td>' +
                '</tr>'
        }
        html += "";
        $('#item_header').after(html);
    })
}
