function calcBMI() {
    let weight = document.getElementById("weight");
    let growth = document.getElementById("growth");
    let bmi = 0;
    bmi = weight.value / Math.pow((growth.value / 100), 2);
    document.getElementById("result").innerText = "Индекс массы вашего тела: " + bmi.toFixed(2);
    document.getElementById("range").value = bmi;

    if  (bmi <= 18.49 ) {
        document.getElementById("description").innerText = "Не достаточный вес";
    }
    else if (bmi >= 18.5 && bmi <= 24.99) {
        document.getElementById("description").innerText = "Здоровый вес";
    }
    else if (bmi >= 25 && bmi <= 29.99) {
        document.getElementById("description").innerText = "Избыточный вес";
    }
    else if (bmi >= 30) {
        document.getElementById("description").innerText = "Ожирение";
    }
}