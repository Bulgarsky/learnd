//tuple - кортеж/пара
//замыкание
export function tuplePairCreator<T>(first: T){
    return function<U> (second: U): [T, U]{
        return [first, second];
    }
}
//передаст значение на первую позицию, и будет ждать исполнения второй фукнции
const toTupleWithFirstPosition = tuplePairCreator("txt");
//передача второго значения
const pair = toTupleWithFirstPosition(8);


//classic map
export function createMap<T>(list: T[]){
    return function<U> (callback: (n: T) => U): U[] {
        const result = [];

        for (let element of list) {
            result.push(callback(element));
        }

        return result;
    }
}

const mapNumbers = createMap([2, 4, 5]);
const result = mapNumbers((number) => number + 2);