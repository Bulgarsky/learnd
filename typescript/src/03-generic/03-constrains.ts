//constrain - ограничение
//Т содержит обьект с ключом length
function getLength<T extends {length: number}> (arg: T): number {
    return arg.length;
}

getLength("word");
getLength(["word"]);
getLength( { length: 12 } );
//исключая:
// getLength(100);
// getLength(true);
//getLength({a: 1});

getLength({a: 1, length: 50});

export {};

//<T extends object>