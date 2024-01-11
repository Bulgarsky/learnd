//UTILS
// take Union and exclude ones
type Type1 = Exclude<"a" | "b" | "c", "a">;  // "b" | "c"
type Type2 = Exclude<"a" | "b" | "c", "a" | "c" | "d">; // "b"

//take Union string|number| () and exclude function
type Type3 = Exclude<string | number | (() => void), Function>; // string|number

type Status = "succes" | 404 | "clientError" | 500 | "timeout";
//exclude
//take Status and exclude string
type NumStatus = Exclude<Status, string>; //number 404|500
type TextStatus = Exclude<Status, number> //string

//extract
type Type4 = Extract<"a" | "b" | "c", "a"> // "a"
type Type5 = Extract<"a" | "b" | "c", "a" | "c" | "d">; // "a" | "c"

//
interface IPerson{
    lastName: string,
    firstName: string,
    age: number
}

//extract keyof IPerson and union
type PersonNames = Extract<keyof IPerson, "firstName" | "lastName" | "fullName">;

//NONNULLABLE
//throw out nullable types
type TypeNon1 = NonNullable<string | number | undefined>;
type TypeNon2 = NonNullable<string[] | null | undefined>

export {};