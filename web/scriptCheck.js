document.getElementById("myFormActor").addEventListener("submit", function (event) {
    var age = document.getElementById('year');
    var errorMessages1 = document.getElementById('error-messages1');
    errorMessages1.innerHTML = '';
    if (parseFloat(age.value) <= 0) {
        event.preventDefault();
        errorMessages1.innerHTML = 'Vui lòng nhập đàng hoàng!';
    }
});