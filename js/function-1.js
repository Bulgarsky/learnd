function calculateAge(year){
    return 2022-year
    }
const myAge=calculateAge(1992); 
console.log('возраст ='+myAge);
console.log(calculateAge(1981));

function logInfoAbout(name,year){
    const age=calculateAge(year)
    console.log('человек по имени '+name+' сейчас имеет возраст', age);
}
logInfoAbout('semen',1995)
logInfoAbout('arthur',1998)