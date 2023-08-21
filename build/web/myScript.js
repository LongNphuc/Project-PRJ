document.getElementById("myForm").addEventListener("submit", function (event) {
    var markInput = document.getElementById('rating');
    var numInput = document.getElementById('rating-input');
    var year = document.getElementById('year');
    var duration = document.getElementById('duration');
    var view = document.getElementById('view');
    var errorMessages1 = document.getElementById('error-messages1');
    var errorMessages2 = document.getElementById('error-messages2');
    var errorMessages3 = document.getElementById('error-messages3');
    var errorMessages4 = document.getElementById('error-messages4');
    var errorMessages5 = document.getElementById('error-messages5');
    errorMessages1.innerHTML = '';
    errorMessages2.innerHTML = '';
    errorMessages3.innerHTML = '';
    errorMessages4.innerHTML = '';
    errorMessages5.innerHTML = '';
    if (parseFloat(markInput.value) < 1 || parseFloat(markInput.value) > 10) {
        event.preventDefault(); // Ngăn chặn gửi form
        errorMessages1.innerHTML = ' 1 <= Vui lòng nhập một số <= 10';
    }
    if (parseFloat(numInput.value) < 0) {
        event.preventDefault(); // Ngăn chặn gửi form
        errorMessages2.innerHTML = 'Vui lòng nhập một số >= 0';
    }
    if (parseFloat(year.value) < 2000) {
        event.preventDefault();
        errorMessages3.innerHTML = 'Vui lòng nhập year một cách chân thành!(>=2000)';
    }
    if (parseFloat(duration.value) <= 0) {
        event.preventDefault();
        errorMessages4.innerHTML = 'Vui lòng nhập thời lượng một cách chân thành! (T.T)';
    }
    if (parseFloat(view.value) < 0) {
        event.preventDefault();
        errorMessages5.innerHTML = 'Vui lòng nhập lượt xem một cách chân thành! (T.T)';
    }

});


