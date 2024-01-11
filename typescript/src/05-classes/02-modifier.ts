//модификаторы доступа не действуют в RUNTIME сборке
//для RUNTIME надо использовать #
// this.#log
//#log(){}

export class Vehicle {
    public drive(speed: number): void {
        console.log("speed: ", speed.toFixed());
        this.logg(speed);
    }
    public stop(){
        console.log("Stopped");
    }
    //только для класса Vehicle
    private logg(speed: number){
        console.log("speed changed to ", speed)
    }
    //могут использовать методы дочерних классов
    protected logging(text: string){
        console.log(text.toUpperCase());
    }
}

class Car extends Vehicle{
    changesSpeed(speed: number){
        this.drive(speed);
        this.logging("speed was changed");
    }
}

const car01 = new Car();
car01.drive(100);
//car01.logg(11); /CANT USE
car01.stop();
car01.changesSpeed(150);