interface User {
    firstName: string,
    lastName: string,
    yearOfBirth: number,
    isMarried?: boolean,
    occupation?: string,

    [key: string]: unknown
}

const user1: User = {
    firstName: "John",
    lastName: "Doe",
    yearOfBirth: 1987,
    isMarried: false,
}

user1.isMarried = true;

const user2: User = {
    firstName:"Samuel",
    lastName: "Jackson",
    yearOfBirth: 1946
}

user2.payedTax = true;

export {};