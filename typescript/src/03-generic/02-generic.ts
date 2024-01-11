// полиморфзим, необх использовать разные типы для одного похожего функционала
//базовое использование
export function append<T>(element: T, list: T[]): T[] {
    return list.concat(element);
}

append(1, [2, 5, 6]);
//append("1", [3, 5, 6]); //не соотвествтие типов
