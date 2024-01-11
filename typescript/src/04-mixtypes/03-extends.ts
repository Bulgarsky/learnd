type answer1 = 64 extends number ? true : false;  //true
type answer2 = number extends 64 ? true : false;  //false
type answer3 = string[] extends any ? true : false; //true
type answer4 = string[] extends any[] ? true : false; //true
type answer5 = never extends any? true : false; //true
type answer6 = any extends any ? true : false; //true

//Date here  is Interface
// false
type answer7 = Date extends { new(...args: any[]): any }
    ? true
    : false

//typeof Data - instanceof Date (возьмет экземпляк класса Date)
// true
// {new(able)} structure
type answer8 = typeof Date extends { new(...args: any[]): any }
    ? true
    : false

export {};