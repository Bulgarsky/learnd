let clientList = new Array();
let i = 0; //индекс массива
let question = true;
while(question) {
    i++;
    clientList[i] = new Client(); // индекс i: новый обьект класса Клиент
    clientList[i].lastName = prompt("Фамилия: ");
    clientList[i].firstName = prompt("Имя: ");
    clientList[i].middleName = prompt("Отчество: ");
    clientList[i].age = prompt("Возраст: ");
    question = confirm("Добавить еще клиента?");//нажатие ок=true / отмена=false
}
for (let j= 1; j < clientList.length; j++) {
    if (clientList[j].age >=18) {
        document.write(j + ": "+
            clientList[j].lastName + " "+
            clientList[j].firstName[0].toUpperCase() +" "+
            clientList[j].middleName[0].toUpperCase() +", Возраст: "+
            clientList[j].age +"<br>");
    }
}