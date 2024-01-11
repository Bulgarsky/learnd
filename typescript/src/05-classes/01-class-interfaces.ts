interface ICar{
    //обязатеные свойства без ?
    go(speed: number): void,
    //maxSpeed?: number
}
export class Car implements ICar{

    go(speed: number){
        console.log("car going with ", speed.toFixed());
    }
    stop(){
        console.log("car is stopped");
    }
}

//car instanceof Car
const car = new Car;
car.go(12);
//car.maxSpeed нельзя обратится к необязательному полю без реал в классе
