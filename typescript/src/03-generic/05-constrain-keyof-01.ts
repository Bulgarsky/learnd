//constrain with keyof
function getProp<T, C extends keyof T>(key: C , obj: T): T[C]{
    return obj[key];
}

function getProp2<T>(key: keyof T , obj: T): T[keyof T]{
    return obj[key];
}

const obj1 = {a: 1, b: 2, c: 5};
getProp("a", obj1);

//error, только литералы union "a" | "b" | "c"
//getProp("d", obj1);

export {};
/*
interface ILaptop {
    brand: string
}

type L = ILaptop["brand"];
*/