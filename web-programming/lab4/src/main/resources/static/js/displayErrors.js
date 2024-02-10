export function displayErrors(container, errors) {
    container.length = 0;
    errors.forEach(error => { container.push(error) });
}