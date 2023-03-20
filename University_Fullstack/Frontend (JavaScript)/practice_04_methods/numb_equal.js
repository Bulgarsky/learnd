let a = Number(prompt("Введите А: "));
let b = Number(prompt("Введите B: "));
max(a, b);
max(1, 50);
max(10, 2);
function max (a, b) {
    if (a == b) {
        alert("Числа равны");
    } else {
        if (a > b) {
            alert("число "+a + " больше чем "+b);
        } else {
            alert("число "+b + " больше чем "+a);
        }
    }
}