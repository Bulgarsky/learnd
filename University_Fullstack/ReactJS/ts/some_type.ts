//type 
type user = {
    name: string,
    age: number | string,
    avatar?: string
}

let user01: user = {
    name: 'Greg',
    age: 20,
    avatar: ''
}

let user02: user = {
    name: 'Margo',
    age: '22'
}

console.log(user01);
console.log(user02);
