const xCheckboxes = document.querySelectorAll('input[name="x"]');
const y = document.querySelector('input[name="y"]');
const rButtons = document.querySelectorAll('input[name="r_possible_values"]');
const rVal = document.querySelector('input[name="r"]');
y.addEventListener('change', () => {
    console.log(y.value);
    validate();
});

xCheckboxes.forEach(checkbox => {
    checkbox.addEventListener('change', () => {
        xCheckboxes.forEach(x => {
            if (x !== checkbox) {
                x.checked = false;
            }
        });
        validate();
    });
});

rButtons.forEach( button => {
    button.addEventListener('click', () => {
        rButtons.forEach( r => {
            if (r !== button) {
                r.style.background = 'white';
            }
        });
        button.style.background = 'green';
        rVal.value = button.value;
        validate();
    });
});


function validate() {
    buttonIsActive(validateY().valueOf() && validateX().valueOf() && validateR().valueOf());
}

function buttonIsActive(bool) {
    document.getElementById("send").disabled = !bool;
}

function validateY() {
    let yVal = y.value;
    if (isNaN(yVal)) return false;
    yVal = parseFloat(yVal);
    return -3 <= yVal && yVal <= 5;
}

function validateX() {
    let bool = false;
    xCheckboxes.forEach( checkbox => {
        if (checkbox.checked === true) bool = true;
    });
    return bool;
}

function validateR() {
    let bool = false;
    rButtons.forEach( button => {
        if (button.style.background === 'green') bool = true;
    });
    return bool;
}

document.getElementById("go_to_table").addEventListener('click', () => {
    window.location.replace('/lab2-1.0-SNAPSHOT/table.jsp');
});