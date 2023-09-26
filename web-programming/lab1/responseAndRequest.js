const table = document.getElementById('result_table');
function displayResult(data){
    const row = document.createElement('tr');
    row.innerHTML = `
                        <td>${data.X}</td>
                        <td>${data.Y}</td>
                        <td>${data.R}</td>
                        <td>${data.currentTime}</td>
                        <td>${data.executionTime}</td>
                        <td>${data.result}</td>`;
    table.appendChild(row);
}
function validateY() {
    let y = document.querySelector('input[name="Y"]').value.replace(',','.');
    return -5 <= y && y <= 5
}

function validateR() {
    let r = document.querySelector('input[name="R"]').value.replace(',','.');
    return 2 <= r && r <= 5
}

function validate() {
    let y = validateY().valueOf()
    let r = validateR().valueOf()
    document.getElementById("button").disabled = !(y && r);
}

document.addEventListener('DOMContentLoaded', function () {
    let form = document.getElementById('form')
    form.addEventListener('submit', function (event) {
        event.preventDefault()
        let x = document.querySelector('input[name="X"]').value.replace(',', '.');
        let y = document.querySelector('input[name="Y"]').value.replace(',', '.');
        let r = document.querySelector('input[name="R"]').value.replace(',', '.');

        fetch(`script.php?X=${x}&Y=${y}&R=${r}`, {
            method: 'GET'
        })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else throw new Error(response.status.toString());
        })
        .then(data => {
            displayResult(data);
            form.reset();
        })
        .catch(error => {
            console.error('error: ', error);
        })
    })
})