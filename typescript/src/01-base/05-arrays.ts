//const numbers: (string | boolean | number) = [1, 4, true, "word", 8, 3];
const numbers: number[] = [1, 4, 5, 7, 8, 3];
const str1: string[] = [];
const str2: Array<string> = [];
str1.push("wrr");

interface ICar{
    brand: string,
    isNew: boolean
}
//массив не примитивных типов
const cars: ICar[] = [];
cars.push({brand: "bmw", isNew: true});

const arrOfArray: string[][] = [];
arrOfArray.push(["word"]);

export function printArray (arr: unknown[]): void {
    arr.forEach((element, index) => {
        console.log(index, element);
    });
}


export {};