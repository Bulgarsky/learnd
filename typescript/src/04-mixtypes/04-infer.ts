//infer - делать вывод

function fromPair(pair: [string, string]) {
    const [key, value] = pair;

    return {
        [key]: value
    }
}
//helper
// хелпер принимает Т, проверка, что Т явл.частным случаем след.структуры (функция) =>
// которая что то вовзращает, у которой обяз. имеется 1 параметр, и возможно есть еще параметры
//определяет значение и кладет в алиас First
type FirstArg<T> = T extends (first: infer First, ...any: any[]) => any ? First : never;

const pair1: FirstArg<typeof fromPair> = ["txt", "file"];

//fromPair(pair1 as [string, string]);
fromPair(pair1);


//class
type ContsructorFirstArg<T> = T extends { new(arg: infer A, ...args: any[]): any } ? A : never;

class Comp {
    constructor(brand: string) {}
}
//typeof экз класса
let brand: ContsructorFirstArg<typeof Comp> = "";

let dateArg: ContsructorFirstArg<typeof Date> = "2000,10,10";

export {};