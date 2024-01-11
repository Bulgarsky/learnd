// func head(value: T) {}
function head(value: string): string;
function head(value: string[][]): string[];
function head(value: number[]): number;
function head(value: boolean[]): boolean;
function head(value: Date[]): Date;
//or any types
function head(value: any): any {
    return value[0];
}

//
interface  IModel{
    title: string,
    value: string, // number, [], boolean
}


export {};