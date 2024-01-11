//cant create instances
import {logIn} from "../01-base/04-func-with-object-example";

abstract class Vehicle{
    //абстр поле
    abstract color: string;

    //описание сигнатуры абстр метода, класс обязан реализовать
    abstract drive(speed: number): void;

    public stop(){
        console.log("stopped");
    }
}

export class Car extends Vehicle{
    constructor(public color: string) {
        super();
    }
    drive(speed: number) {
        console.log("speed: ", speed.toFixed());
    }
}

//нельзя создать экземпляр абстрактного класса
//const veh01 = new Vehicle();

