function  func1(arg: {a: number; b: string} ){
    return arg.a + arg.b;
}

type Type1 = ReturnType<typeof func1> //string

type Type2 = Parameters<typeof func1>; // tuple

type Type3 = ConstructorParameters<ErrorConstructor>;

class Car{
    constructor(brand: string, model: string) {}
}

type TypeCar01 = ConstructorParameters<typeof Car>; // tuple [string, string]


export {};