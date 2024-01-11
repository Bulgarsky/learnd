//Array<string>
//string[]
//Promise<number>

// принимает <динамику> вовзр выводимый тип
//  <T> - параметр, Т - использование параметра
type TypeFactory<T> = T;
type XType1 = TypeFactory<string>;
type XType2 = TypeFactory<number>;
type XType3 = TypeFactory<boolean>;
function toArray<T> (...args: T[]): T[] {
    return args;
}
toArray(1, 5, 6);
toArray("abc", "dfg");
toArray<string>("a1", "b2", "c3");


//
function head(value: string): string;
function head(value: []): undefined;
function head<T>(value: readonly T[]):T;
function head(value: any): any {
    return value[0];
}
const headArrow = <T>(value: T[]): T => value[0];
head([1, 2, 4, 6]);


//
interface IModelData<T>{
    title: string,
    value: T,
}
const modelData: IModelData<number> = {
    title: "model 01",
    value: 100
};
//modelData.value = "111"; //error type
const modelData2:IModelData<Array<number>> = {
    title: "model 200",
    value: [1, 2, 3]
}

export {};