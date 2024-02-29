const clearResultsButton = document.getElementById("clear_results");
const goToFormButton = document.getElementById("go_to_form");

clearResultsButton.addEventListener( 'click', () => {
    $('#result_table').html(`
        <tr>
            <th>X</th>
            <th>Y</th>
            <th>R</th>
            <th>Когда выполнялся</th>
            <th>Время выполнения, ms</th>
            <th>Результат</th>
        </tr>`);

    $.ajax({
        type: "POST",
        url: "controller",
        data: {
            query: "/clearTable"
        },
        success: function () {
            window.location.reload();
        }
    });
});

goToFormButton.addEventListener('click', () => {
    window.location.replace('/lab2-1.0-SNAPSHOT/');
});