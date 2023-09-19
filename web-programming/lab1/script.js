function validateY () {
    let y = document.getElementById("Y").value
    return -5 <= y && y <= 5
}

function validateR() {
    let r = document.getElementById("R").value
    return 2 <= r && r <= 5
}

function validate() {
    let y = validateY().valueOf()
    let r = validateR().valueOf()
    document.getElementById("button").disabled = !(y && r);
}
