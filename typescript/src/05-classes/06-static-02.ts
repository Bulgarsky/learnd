export class Temperature {
    constructor(public cels:number) {}

    get getFahrenheit(){
        return this.cels *1.8 +32;
    }

    set setFahrenheit(value: number){
        this.cels = (value - 32) / 1.8
    }

    public static fromFahrenheit(value: number): Temperature{
        return new Temperature(Math.round((value - 32) / 1.8));
    }
}

const temp0 = Temperature.fromFahrenheit(500);  //create new instance
const temp1 = new Temperature(65);
temp1.setFahrenheit = 55;