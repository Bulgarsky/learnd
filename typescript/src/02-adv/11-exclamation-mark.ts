// ! - позволяет сказать что в null | undefined есть значение и с ним можно работать
let word: string | null = null;
const num = 10;
if (num > 5 ) {
    word = "abc";
}
console.log(word!.toLowerCase());


function printName(name?: string){
    const fullName: string = name!;
}


interface IPerson{
    name: string,
    age: number,
    sex: "female" | "male"
}
function printPersonName(person?: IPerson) {
    console.log(person!.name);
}

const somePeople: IPerson[] = [
    {
        name: "Grandpa",
        age: 75,
        sex: "male"
    },
    {
        name: "Mom",
        age: 45,
        sex: "female"
    },
    {
        name: "Dad",
        age: 47,
        sex: "male"
    }
];

const women1: IPerson | undefined = somePeople.find(person => person.sex === "female");
const women = somePeople.find(person => person.sex === "female")!; //IPerson