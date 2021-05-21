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
