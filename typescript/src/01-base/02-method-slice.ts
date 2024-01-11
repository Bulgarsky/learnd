function slice(str: string, start: number, end?: number): string {
    let newStr: string = "";
    let lastIndex: number;

    if (end) {
        lastIndex = end > str.length ? str.length : end;
    } else {
        lastIndex = str.length;
    }

    for (let i:number = start; i < lastIndex; i++){
        newStr += str[i];
    }

    return newStr;
}


console.log(slice("happy new 2023 year", 3, 8));


export {};