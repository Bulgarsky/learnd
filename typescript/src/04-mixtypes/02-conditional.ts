//Условный тип
const x = 1503;
const isNegative: "no" | "yes" =  x>= 0 ? "no" : "yes";

interface IStringRecord{
    [key: string]: string
}
interface IDateRecord{
    [key: string]: Date  //instanceof Date //экземпляр Даты
}
// значение которое проверяем extends допустимый набор значений
type MyRecord<T> = T extends string ? IStringRecord : IDateRecord;

type Object1 = MyRecord<string>;
const obj1: Object1 = {
    r: "100"
}

type Object2 = MyRecord<Date>;
const obj2: Object2 = {
    d: new Date(2000,1,1)
}

export {};