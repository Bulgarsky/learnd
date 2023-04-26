let a = Number(prompt("Введите A: "));
let b = Number(prompt("Введите B: "));
let c = Number(prompt("Введите C: "));
discriminant(a, b, c);
discriminant(2, 3, 4);
function discriminant (a, b, c) {
    let d = Math.pow(b, 2) - (4 * a * c);
    return alert("discriminant: "+ d);
}