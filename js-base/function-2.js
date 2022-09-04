function calculateAge(year){
    return 2022-year;
    }
function logInfoAbout(name,year){
    const age=calculateAge(year);
    if (age>0){
        console.log('Человек по имени '+name+ ' сейчас имеет возраст '+age);
    }else{
        console.log('Not born yet');
    }
}
logInfoAbout('Semen ',1995);
logInfoAbout('arthur ',2010);
logInfoAbout('antons second son', 2025);