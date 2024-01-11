export class Rectangle{
    constructor(public width: number, public height: number) {
        this.logg();
    }

    //area(): number { return this.width * this.height; }
    //type readonly
    get area(): number {
        return this.width * this.height;
    }
    private logg(): void {
        console.log(`new Rectangle was created at: ${new Date}`);
    }
}

const rec01 = new Rectangle(20, 10);
//rec01.area();
rec01.area;

export class Car {
    constructor(public color: string, private _maxSpeed: number) {
    }

    get maxSpeed(): number{
        return this._maxSpeed;
    }

    set maxSpeed(speed: number){
        if(speed > 50) {
            this._maxSpeed = speed;
        }
    }
}
const car01 = new Car("green", 50);
//car01.maxSpeed(30); //err