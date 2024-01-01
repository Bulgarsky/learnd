//сужение типов / уточнение
function example (x?: number | string): void {
    switch (typeof x){
        case "string":
            x.toLowerCase();
            break;
        case "number":
            x.toFixed();
            break
        case "undefined":
            console.log("no value");
            break;
        default:
            console.log("x never")
    }
}

function example2 (str: string | string[] | null) {
    if (Array.isArray(str)){}

    if (str && typeof str === "object"){
        str.concat([]);
    } else if (typeof str === "string"){
        str.toLowerCase();
    }

}

function example3(x:number[] | Date) {

    if (x instanceof Date){
        x.getMonth();
    } else {
        x.concat([]);
    }

}

type Fish = {
    swim: () => void;
}
type Bird = {
    fly: () => void;
}

function move(animal: Fish | Bird): void {
    if ("swim" in animal){
        return animal.swim();
    }
    return animal.fly();

}

export {};