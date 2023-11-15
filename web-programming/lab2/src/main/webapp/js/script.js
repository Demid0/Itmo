/* ------------- CONST variables ----------------- */

//const table = document.getElementById('result_table');
const form = document.getElementById('form');
const error_strings = document.querySelectorAll('.error_string p');
const checkboxes_for_x = document.querySelectorAll('input[name="x"]');
const buttons_for_r = document.querySelectorAll('input[name="r"]');

/* -------------- Event Listeners ------------------- */

form.addEventListener('submit', function (event) {
    event.preventDefault();

    let resultsOfValidate = validate();
    if (!resultsOfValidate[0]) {
        let message = resultsOfValidate[1].split(" ");
        showError(message, 100);
    }
    else {
        let timezone = new Date().getTimezoneOffset();
        timezone = (timezone === 0 ? 0 : -timezone);
        let x = parseFloat(document.querySelector('input[name="x"]:checked').value);
        let y = parseFloat(document.querySelector('input[name="y"]').value);
        let r = null;
        buttons_for_r.forEach(button => {
            if (button.style.background === 'green') r = button.value;
        });
        r = parseFloat(r);
        /*
        let data =
            "x=" + encodeURIComponent(x) +
            "&y=" + encodeURIComponent(y) +
            "&r=" + encodeURIComponent(r) +
            "&timezone=" + encodeURIComponent(timezone.toString());

         */

        /*
        let xhr = new XMLHttpRequest();
        xhr.open('POST', `/lab2/controller`);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.onreadystatechange = () => {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {

                } else {
                    console.log(xhr.response);
                }
            }
        }
        xhr.send(data);

        */
        $.ajax ({
            type: 'POST',
            url: '/lab2/controller',
            contentType: 'application/json',
            data: `x:${x}, y:${y}, r:${r}, timezone:${timezone}`,
            success: (data) => {
                console.log(data);
            }
        });
    }
});

/* --------------- Table and results manipulations ---------------- */



/* ----------------------- validating --------------------- */
function validate() {
    let xAns = validateX();
    let yAns = validateY();
    let rAns = validateR();
    if (xAns[0] && yAns[0] && rAns[0]) return [true, "OK"];
    else {
        let report = xAns[1] + " " + yAns[1] + " " + rAns[1];
        return [false, report];
    }
}

/* ------------------------ X -------------------- */
function validateX() {
    let count = 0;
    checkboxes_for_x.forEach(checkbox => {
        if (checkbox.checked) {
            count++;
        }
    });
    if (count === 1) return [true, "OK"];
    else if (count === 0) return [false, "NOT_CHECKED"];
    else return [false, "TOO_MANY"];
}

/* ------------------------ Y -------------------- */
function validateY() {
    let y = document.querySelector('input[name="y"]').value;
    if (isNaN(y)) return [false, "NOT_CHECKED"];
    y = parseFloat(y);
    if (-3 <= y && y <= 5) {
        return [true, "OK"];
    }
    else {
        return [false, "OUT_OF_BOUNDS"];
    }
}

/* ------------------------ R -------------------- */
function validateR() {
    let count = 0;
    buttons_for_r.forEach(button => {
        if (button.style.background === 'green') {
            count++;
        }
    });
    if (count === 1) return [true, "OK"];
    else if (count === 0) return [false, "NOT_CHECKED"];
    else return [false, "TOO_MANY"];
}


/*  ------------- print message in error_string div and remove it after s seconds -----------------*/
function showError(message, s) {
    for (let i = 0; i < 3; i++) {
        if (message[i] !== undefined && message[i] !== "OK") error_strings[i].innerHTML = message[i];
    }
    setTimeout(hideError, s * 1000);
}
function hideError() {
    for (let i = 0; i < 3; i++) {
        error_strings[i].innerHTML = '';
    }
}

function changeColor(element) {
    let defaultColor = 'white';
    let newColor = 'green';
    if (element.style.background !== newColor) defaultColor = newColor;
    element.style.background = defaultColor;
}