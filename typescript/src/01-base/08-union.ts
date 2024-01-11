//объединение / cоединение
type Status =  "ok" | "loading" | "error";  //Literal
const currentStatus: Status = "ok";

function printId(id: number | string): void {
    //сужение типов:
    if(typeof id === "string"){
        console.log(id.toUpperCase());
    } else {
        console.log(id);
    }
}

function welcome(person: [string, string] | string): number | string {
    if (Array.isArray(person)){
        console.log("hello", person.join(" "));
        return 42;
    } else {
        console.log("Hello ", person);
        return person;
    }
}

const arr: (number | string)[] = [];

export {};