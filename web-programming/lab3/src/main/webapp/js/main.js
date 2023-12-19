let xCheckboxes = document.querySelectorAll(".xValueOption");
let xValue = document.getElementById("xValue");

xCheckboxes.forEach(checkbox => {
    checkbox.addEventListener('click', () => {
        xCheckboxes.forEach( element => {
            element.checked = false;
        });
        checkbox.checked = true;
        xValue.value = checkbox.id.substring(1);
    });
});

window.onload = () => {
    xCheckboxes.item(0).checked = true;
}