function add(a: number, b: number) : number;
function add(a: string, b: string): string;
function add(a: any, b: any):any {
    return a + b;
}

add(1, 2);
add("a", "b");

type AsyncCB = (res: number) => number;

function asyncSum(a: number, b: number): Promise<number>;
function asyncSum(a: number, b: number, cb: AsyncCB): number;
function asyncSum(a: number, b: number, cb?: AsyncCB): any {
    const result = a + b;
    if (cb) {
        return cb(result);
    }
    return Promise.resolve(result);
}

asyncSum(2, 4);

export {};