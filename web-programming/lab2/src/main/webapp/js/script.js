const xCheckboxes = document.querySelectorAll('input[name="x"]');
const y = document.querySelector('input[name="y"]');
const rButtons = document.querySelectorAll('input[name="r_possible_values"]');
const rVal = document.querySelector('input[name="r"]');
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

        document.querySelectorAll("circle").forEach(circle => {
            circle.style.visibility = 'hidden';
        });

        let circles;
        switch (button.value) {
            case "1": {circles = document.querySelectorAll("circle[class='1.0']"); break;}
            case "2": {circles = document.querySelectorAll("circle[class='2.0']"); break;}
            case "3": {circles = document.querySelectorAll("circle[class='3.0']"); break;}
            case "4": {circles = document.querySelectorAll("circle[class='4.0']"); break;}
            case "5": {circles = document.querySelectorAll("circle[class='5.0']"); break;}
        }
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
document.querySelector("svg").addEventListener('click', function (e) {
    if (validateR()) {
        let target = this.getBoundingClientRect();
        let px = e.clientX - target.left;
        let py = e.clientY - target.top;
        let x = (px - 300) * rVal.value / 200;
        let y = -(py - 300) * rVal.value / 200;
        $.ajax({
            type: "POST",
            url: "controller",
            async: true,
            data: {
                r: rVal.value,
                y: y,
                x: x
            },
            success: function () {
                window.location.reload();
            }
        });
    } else { alert("Please, choose the R"); }
});