let averin = new Employee("Averin", "Anton", 150, 7);
averin.personnelFile();
averin.getSalary();
alert("Отработанных дней: "+averin.workDays);
averin.setWorkRate = 500;
averin.setWorkDays = 10;
averin.personnelFile();
averin.getSalary();

let permsky = new Employee("Пермский", "Василий", 50, 23);
permsky.getSalary();
permsky.setFirstName = "Иванов";
permsky.setLastName = "Васька";
permsky.personnelFile();