//1 VARIABLES - переменные
// var name='Minin' - устаревший
//const firstName='Bulgarsky'//string
//const lastName="Alek" //string
// const - константа READONLY !
/// let age=35 nubmer
//const isProgrammer=false //BOOLEAN true or false
//const _private='private'
//const _ ='private'
//const $='private' 
// const if='mkef'  ERROR Reserved IF
//const 5withNum=5 ERROR first symbol NOT a number
// const WithNum5=5  /
//
//2 Мутирование
// const firstName='Bulgarsky'
//const lastName='Alek'
//let age=35
//console.log('Имя Человека '+firstName+' '+lastName+', а возраст человека: ',age) //age.toString
// alert есть в браузере , но нету в JS
//let secondName=prompt('Введите отчество') //ввод через запрос
//alert (firstName+' '+lastName+' '+secondName) */
// 3 Операторы. Числа
// const currentYear=2022
//const birthYear=2020
//const age=currentYear-birthYear
//console.log('возраст = ',age) */
/*
const a=10
const b=5
console.log(a+b)
console.log(a-b)
console.log(a*b)
console.log(a/b) 
*/
/* let currentYear=2022
console.log(currentYear)  2022
console.log(currentYear++)  2022
console.log(currentYear) 2023
console.log(--currentYear) 2022
console.log(currentYear) 2022 
*/
/* let c=32
let a=10
c=c+a
console.log('c=',c)
console.log('c=',c+=a) 
*/
/* 
// 4 базовые типы данных. Примитивы в  языке
// +str = вакатинация (перезагрузка (концепт))
// mdn operator precedence
const isProgrammer=true //boolean true or false
const lastName='Bulgarsky' //string
const age=35 //number
let x //undefined
null //object
console.log(typeof isProgrammer)
console.log(typeof lastName)
console.log(typeof age)
console.log(typeof x)
console.log(typeof null) //BUG JS
//еще есть три примитива, далее */
// 5 Приоритет операторов (<,>,>=,=<)
// mdn operator precedence
/* 
const FullAge=35
const birthAge=1987
const currentYear=2022
const isFullAge=currentYear-birthAge >= FullAge
console.log(isFullAge)
 */
//
// 6 Условные операторы
/* const repairStatus='pending' //ready, fail, pending
if (repairStatus=='ready'){
   console.log('Ремонт закончен');
} else
if (repairStatus==='pending'){
    console.log('Ремонт в процессе')
} else{
    console.log('Ремонту медный таз')
}
 */
/* const num1=42
const num2='42'
console.log('сравнение с приведением к строке значений = ', num1==num2)
console.log('сравнение по типу данных= ',num1===num2)
 */
/* const isReady = false
if (isReady){console.log('Finish')} else{console.log('Not Finish')}
isReady ? console.log('Finished') : console.log('Not a Finished')   //тернарные выражения 
 */
 // 7 булевая логика
// a) && логическое И (возвращает true, если оба операнда true; в противном случае возвращает false)
/* console.log(true && true); //true
console.log(true && false); //false
console.log(false && true); //false
console.log(false && false); //false
//  б) || логическое ИЛИ ( возвращает true, если один из операндов true; если же оба false, то возвращает false))
console.log(true||true); // true
console.log(true||false); // true
console.log(false||true); // true
console.log(false||false); //false
// в) ! логическое НЕ
console.log(true);
console.log(!true); //! НЕ true = false
console.log(!!true); //!! НЕ (НЕ true)  = true */
//
