let year: number = 2023;
let age: number = NaN;

//let big: bigint = 1234n;

let firstName: string = "John";
let lastName: string;
lastName = "Doe";

let titleAcronym = Symbol("OXY");

let isShow: boolean = true;

let notAvalaible: undefined = undefined;
let empty: null = null;

//LITERAL
const MEANING = 42;
const HOMEPLANET = "Earth";

let some: any = 1;
some = "shop";
some = [];
some.toUpperCase();

let dunno: unknown = 2;
if (typeof dunno === "string") {
    dunno.toUpperCase();
}
//dunno.toUpperCase(); //err


export {};