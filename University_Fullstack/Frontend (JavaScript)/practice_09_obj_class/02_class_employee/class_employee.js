class Employee{
    #lastName; #firstName; #workRate; #workDays; //#private   //_const
    constructor(lastName, firstName, workRate, workDays) {
        this.#lastName = lastName;
        this.#firstName = firstName;
        this.#workRate = workRate;
        this.#workDays = workDays;
    }
    //getters
    get firstName () {return this.#firstName;}
    get lastName () {return this.#lastName;}
    get workRate () {return this.#workRate;}
    get workDays () {return this.#workDays;}

    //setters
    set setWorkRate(workRate) {this.#workRate = workRate;}
    set setWorkDays(workDays) {this.#workDays = workDays;}
    set setFirstName(firstName) {this.#firstName = firstName;}
    set setLastName(lastName) {this.#lastName = lastName;}
    //methods
    personnelFile(){
        alert("Сотрудник: "+this.firstName+" "+this.lastName+", Отработано: "+this.workDays+" дней, ставка: "+this.workRate);
    }
    getSalary(){
        let result = this.workDays * this.workRate;
        return alert("Зарплата "+this.lastName+" "+this.firstName+": " + result);
    }
}