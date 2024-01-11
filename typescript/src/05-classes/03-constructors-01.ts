export class Vehicle {
    constructor(protected createdAt: Date) {
    }
    public drive(speed: number): void {
        console.log("speed: ", speed.toFixed());
        this.logg(speed);
    }
    public stop(){
        console.log("Stopped");
    }
    private logg(speed: number){
        console.log("speed changed to ", speed, "date: ", this.createdAt);
    }
    protected logging(text: string){
        console.log(text.toUpperCase());
    }
}

export  class Car extends Vehicle{
    //public protected private
    // color: string;
    // maxSpeed: number;

    constructor(public readonly color: string, public maxSpeed: number) {
        super(new Date);
        // this.color = color;
        // this.maxSpeed = maxSpeed;
    }
    getInfo(){
        console.log(
          this.color,
          this.maxSpeed,
          this.createdAt //if parrent private cant use
        );
    }
}
const car02 = new Car("red", 200);
//car02.color("black"); //err
