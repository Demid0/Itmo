const xCheckboxes = document.querySelectorAll('input[name="x"]');
const y = document.querySelector('input[name="y"]');
const rButtons = document.querySelectorAll('input[name="r_possible_values"]');
const rVal = document.querySelector('input[name="r"]');
const sendButton = document.getElementById("send");
const goToTableButton = document.getElementById("go_to_table");
const currentTime = document.querySelector('input[name="currentTime"]');
const imagePlace = document.querySelector("svg");
y.addEventListener('change', () => {
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

        try {
            document.querySelectorAll("circle").forEach(circle => {
                circle.style.visibility = 'hidden';
            });
        } catch (e) {
            console.log("there are no circles");
        }
        let numero;
        if (button.value.indexOf(",") === -1 && button.value.indexOf(".")) numero = button.value + ".0";
        else numero = button.value;
        let selector = "circle[class=\'" + numero + "\']";
        console.log(parseFloat(button.value));
        let circles = document.querySelectorAll(selector);
        try {
            circles.forEach(circle => {
                circle.style.visibility = 'visible';
            });
        } catch (e) {
            console.log("there are no circles with this R");
        }

        validate();
    });
});


function validate() {
    buttonIsActive(validateY().valueOf() && validateX().valueOf() && validateR().valueOf());
}

function buttonIsActive(bool) {
    sendButton.disabled = !bool;
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

goToTableButton.addEventListener('click', () => {
    window.location.replace('/lab2-1.0-SNAPSHOT/table.jsp');
});

imagePlace.addEventListener('click', function (e) {
    if (validateR()) {
        let target = this.getBoundingClientRect();
        let px = e.clientX - target.left;
        let py = e.clientY - target.top;
        let x = (px - 300) * rVal.value / 200;
        let y = -(py - 300) * rVal.value / 200;
        $.ajax({
            type: "POST",
            url: "controller",
            data: {
                r: rVal.value,
                y: y,
                x: x,
                currentTime: currentTime.value
            },
            success: function () {
                window.location.replace("/lab2-1.0-SNAPSHOT/table.jsp");
            }
        });
    } else { alert("Please, choose the R"); }
});