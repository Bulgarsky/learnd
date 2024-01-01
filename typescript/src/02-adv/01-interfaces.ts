// interface Window{
//     isAuth?: boolean
// }
// window.isAuth.

interface IUser{
    readonly email: string,
    readonly login: string,
    password: string
}

//расширение
interface IUser{
    isOnline?: boolean
}

interface IPerson {
    readonly login: string,
    firstName: string,
    lastName: string,
    phone?: string
}

interface IEmployee extends IUser, IPerson{
    contractStart: Date,
}

export interface IDeveloper extends IEmployee{
    phone: string,
    skills: string[],
    level?: "junior" | "middle" | "senior"
    say(): void,
    code?: (arg: string) => void
}

export {};

//all properties need
/*
class MyDeveloper implements IDeveloper {

    contractStart: Date;
    readonly email: string;
    firstName: string;
    lastName: string;
    readonly login: string;
    password: string;
    phone: string;
    skills: string[];

    say(): void {
    }

}  */