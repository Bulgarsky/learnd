interface IUserNew{
    login: string,
    password: string,
    email: string,
    isOnline: boolean,
    lastVisited: Date
}
//without extend
interface IAdmin{
    login: string,
    password: string,
    email: string,
    isOnline: boolean,
    lastVisited: Date,
    role: string
}

const user001: IUserNew = {
    login: "petrushka",
    password: "perty007",
    email: "petr@a.aa",
    isOnline: false,
    lastVisited: new Date(2023,10,30)
}

const admin001: IAdmin = {
    login: "gosha",
    password: "12345",
    email: "gosha@g.rt",
    isOnline: false,
    lastVisited: new Date(2023,11,20),
    role: "admin"
}

function logIn(user: {login: string, password: string}) {
    if (user.login.length > 0 && user.password.length >0) {
        console.log(`greetings ${user.login}`)
    }
}
logIn(user001);
logIn(admin001);
