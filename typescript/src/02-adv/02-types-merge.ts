type Union1 = "a" | "b" | "c" | "d";
type Union2 = "a" | "f" | "c" | "h";
type Union3 = Union1 | Union2;  // all
type Union4 = Union1 & Union2; // только общая часть  a|c

type Union5 = {a: string, b:string, c: number} & {a: string, d:boolean, z: null };
//const u5: Union5 = {} //cклеивание types

type IUser ={
    readonly email: string,
        readonly login: string,
        password: string
}

type IPerson = {
    readonly login: string,
    firstName: string,
    lastName: string,
    phone?: string
}

type IEmployee = {
    contractStart: Date
} & IUser  & IPerson

//const user01: IEmployee = {}

type IDeveloper =  {
    phone: string,
    skills: string[],
    level?: "junior" | "middle" | "senior"
    say(): void,
    code?: (arg: string) => void
} & IEmployee

export {};