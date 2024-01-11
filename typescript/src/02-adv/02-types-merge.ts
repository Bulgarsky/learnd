type Union1 = "a" | "b" | "c" | "d";
type Union2 = "a" | "f" | "c" | "h";
type Union3 = Union1 | Union2;  // all
type Union4 = Union1 & Union2; // только общая часть  a|c

type Union5 = {a: string, b:string, c: number} & {a: string, d:boolean, z: null };
//const u5: Union5 = {} //cклеивание types

type User ={
    readonly email: string,
    readonly login: string,
    password: string
}

type Person = {
    readonly login: string,
    firstName: string,
    lastName: string,
    phone?: string
}

type Employee = {
    contractStart: Date
} & User  & Person

//const user01: Employee = {}

type Developer =  {
    phone: string,
    skills: string[],
    level?: "junior" | "middle" | "senior"
    say(): void,
    code?: (arg: string) => void
} & Employee

export {};