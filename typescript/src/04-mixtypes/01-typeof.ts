let str = "Hello";
type X = typeof str;

function average(...numbers: number[]): number {
    const sum = numbers.reduce((current, total) => current + total, 0);
    //0 - init value
    return sum / numbers.length;
}
//определить полную сигнатуру
type Fn = typeof average;
const maximum: Fn = (...numbers) => Math.max(...numbers);
maximum(1, 2, 3, 4);


//ReturnType typeof - определить возвращаемый тип
type ReturnFn = ReturnType<typeof average>;

export {};