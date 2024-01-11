function getName(firstName: string, lastName: string): void {
    console.log(firstName, ", ", lastName);
}

function getTotal(price:number, quantity: number): number {
    return price * quantity;
}
//стрелка
const total = (price: number, quantity: number): number => price * quantity;
//функц.выражение
const totalPrice = function (price: number, quantity: number): number {
    return price * quantity;
}

function crash():never{
    throw new Error("app crashed")
}

// ? - optional param
function logging(userName: string, userID?: string): void {
    console.warn("Hello ", userName, ", ID: ", userID || "anonymous");
}

function average(...numbers: number[]): number {
    const sum = numbers.reduce((current, total) => current + total, 0);  //0 - init value

    return sum / numbers.length;
}

export {};