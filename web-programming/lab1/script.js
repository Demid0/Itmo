const table = document.getElementById('result_table');
function displayResult(data){
    const row = document.createElement('tr');
    row.innerHTML = `
            <td>${data.x}</td>
            <td>${data.y}</td>
            <td>${data.r}</td>
            <td>${data.currentTime}</td>
            <td>${data.executionTime}</td>
            <td>${data.result}</td>`;
    table.appendChild(row);
}
function validateY() {
    let y = document.querySelector('input[name="y"]').value.replace(',','.');
    return -5 <= y && y <= 5;
}

function validateR() {
    let r = document.querySelector('input[name="r"]').value.replace(',','.');
    return 2 <= r && r <= 5;
}

function validate() {
    let y = validateY().valueOf();
    let r = validateR().valueOf();
    buttonIsActive((y && r));
}

function buttonIsActive(b) {
    document.getElementById("button").disabled = !b;
}

document.addEventListener('DOMContentLoaded', function () {
    let form = document.getElementById('form');
    form.addEventListener('submit', function (event) {
        event.preventDefault();
        let x = document.querySelector('input[name="x"]').value.replace(',', '.');
        let y = document.querySelector('input[name="y"]').value.replace(',', '.');
        let r = document.querySelector('input[name="r"]').value.replace(',', '.');

        fetch(`script.php?x=${x}&y=${y}&r=${r}`, {
            method: 'GET'
        })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else throw new Error(response.statusText);
        })
        .then(data => {
            displayResult(data);
            form.reset();
            buttonIsActive(false);
        })
        .catch(error => {
            console.error('error: ', error);
        });
    });
});