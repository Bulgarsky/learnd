const person={
    //keys
    firstName:'Arthur',
    lastName:'Smerpinator',
    year:2002,
    languages:['RU','EN','TT'], //массив
    hasWife: false, //булеан
    gender:'Transvestit',
    greet:function(){  //метод
        console.log('message: greet from person')
    }
}
console.log(person);
console.log(person.firstName);
console.log(person.lastName);
person.greet();
const languagesKey='languages';
console.log(person[languagesKey]);
const yearKey='year';
console.log(person[yearKey]);
person.hasWife=true;
console.log(person);
person.isProgrammer=true
console.log(person.isProgrammer);
