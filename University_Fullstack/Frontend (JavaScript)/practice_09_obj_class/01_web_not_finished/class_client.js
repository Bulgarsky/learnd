class Client {
    lastName; firstName; middleName; age;
    constructor(lastName, firstName, middleName, age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.age = age;
    }
    personnelFile() { //+
        document.getElementById("clientList").innerHTML =
            "<p><h4>Список сотрудников:</h4><br>" +
            `${clientList.lastName.value}` + " " +
            `${clientList.firstName.value}` + " " +
            `${clientList.middleName.value}` + ", Возраст: " +
            `${clientList.age.value}` +
            "</p>"
    }
}