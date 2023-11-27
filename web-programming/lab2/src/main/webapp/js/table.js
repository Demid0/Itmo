document.getElementById("clear_results").addEventListener( 'click', () => {
    $('#result_table').html(`
        <tr>
            <th>X</th>
            <th>Y</th>
            <th>R</th>
            <th>Когда выполнялся</th>
            <th>Время выполнения, sec</th>
            <th>Результат</th>
        </tr>`);

    $.ajax({
        type: "POST",
        url: "clearTable",
        async: false,
        success: function () {
            window.location.reload();
        }
    });
});

document.getElementById("go_to_form").addEventListener('click', () => {
    window.location.replace('/lab2-1.0-SNAPSHOT/');
});