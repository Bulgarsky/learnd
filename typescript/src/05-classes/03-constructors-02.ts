export class Rectangle{
    constructor(public width: number, public height: number) {
        this.logg();
    }

    area(): number {
        return this.width * this.height;
    }

    private logg(): void {
        console.log(`new Rectangle was created at: ${new Date}`);
    }

}

class Square extends Rectangle{
    constructor(public width: number, public color: string) {
        super(width, width);
    }

    paint(newColor: string): void{
        this.color = newColor;
    }
}