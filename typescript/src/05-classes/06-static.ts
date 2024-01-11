export class Circle{
    protected static pi: number = 3.14;

    public static calculateArea(radius: number){
        return this.pi * radius * radius;
    }

    constructor(public radius: number) {}

    get area(){
        return Circle.pi * this.radius * this.radius;
    }
}
//к статик нельзя обратится для экземпляра класса
//const circle = new Circle();
//только через класс
Circle.calculateArea(10);


class Ellipse extends Circle{
    constructor(public radius: number) {
        super(radius);

    }
}

const ellipse = new Ellipse(10);
//ellipse.radius