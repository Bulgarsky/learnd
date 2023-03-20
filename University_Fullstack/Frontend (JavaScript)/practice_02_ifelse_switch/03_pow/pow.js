// 3) ввод двух переменных. Организовать вывод расчета формулы по условию
let r, t, result;
r = prompt("3) Введите R");
t = prompt("Введите T");
if (0<t<=1) {
    result = Math.pow(r, 2) - Math.sin(Math.pow(r, 2)+t);
}
else if (t<=0) {
    result = 0;
}
else if (t>1) {
    result = Math.pow(t, 2) - Math.sin(Math.pow(r, 2)+t);
}
alert("Результат "+ result);
