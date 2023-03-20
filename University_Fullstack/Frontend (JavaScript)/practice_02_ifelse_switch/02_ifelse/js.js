// 2)Дано двухзначное число. Определить какая цифра больше, сравнить , вывести сообщение
let userNumber2, secondPosition, firstPosition;
userNumber2 = prompt("2) Сравнение цифр. Введите двух значное число:");
secondPosition = userNumber2 % 10;
firstPosition = (userNumber2 - (userNumber2 % 10)) / 10;

if (firstPosition > secondPosition) {
    alert("Первая цифра "+firstPosition+" > Второй цифры "+secondPosition);
}
else if (secondPosition > firstPosition) {
    alert("Первая цифра "+firstPosition+" < Второй цифры "+secondPosition);
}
else {
    alert("Первая цифра "+firstPosition+" = Второй цифры "+secondPosition);
}