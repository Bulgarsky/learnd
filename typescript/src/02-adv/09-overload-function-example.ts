function head(value: string): string;
function head(value: number[]): number;
function head(value: boolean[]): boolean;
function head(value: any): any {
    return value[0];
}
const x = head("ssd");
const y = head([1, 4, 7]);
const z = head([true, false, true]);

export {};