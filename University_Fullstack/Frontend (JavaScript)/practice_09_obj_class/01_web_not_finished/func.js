let clientList = new Array();
//methods
function injectButton() { //инъекция кода с кнопкой/кнопками
    document.getElementById("injection").innerHTML =
        "<p><h3>Отправить данные?</h3><br>" +
        "<button type='button' class='btn-small' id='add' onclick='question();'>Отправить ?</button>" +
        //"<button type='button' class='btn-small' id='print' >Напечатать ?</button>" +
        "<br>" +
        "</p>";
}
function question() { //вопрос на продолжение
    let status = confirm("Продолжить добавление?");
    if (status) {
        clientAdd();
        resetFrom();
        status = true;
    } else {
        clientAdd();
        clientList.personnelFile();
        resetFrom();
        status = false;
    }
    return status;
    //
}
function  clientAdd() { //добавление клиента
    let lastName = document.getElementById("lastName");
    let firstName = document.getElementById("firstName");
    let middleName = document.getElementById("middleName");
    let age = document.getElementById("age");
    clientList = new Client(lastName, firstName, middleName, age);
}

function resetFrom() {
    document.form.reset();
}