function setInput() {
    let range = document.getElementById("range").value;
    document.getElementById("cash").value = range*10000;
}
function setRange() {
    let input = document.getElementById("cash").value;
    document.getElementById("cash").value = input / 10000;
}
function result() {
    const rate = Number(document.getElementById("rate").value);
    const cash = Number(document.getElementById("cash").value);
    const days = Number(document.getElementById("days").value);
    let compoundInterest = cash;
    // s(простые проценты) = (P * i * t) / 365 ) / 100
    //s - начисл.проценты, р - сумма, i - ставка по депозиту,  т - срок размещения в днях

    // s(сложные проценты) = ((p * i * j) / 365 ) / 100
    //s - начисл.проценты, р - сумма, i - ставка по депозиту, j - cрок капитализации

    if (document.getElementById("simple").checked) {
        let interest = ((cash * rate * days) / 365)/100;
        const total = cash + interest;
        document.getElementById("injection").innerHTML =
            "Информация:<br> Cтавка по вкладу: "+`${rate}` +"% годовых<br>"+
            "Проценты за "+`${days}`+" дн.: " +
            `${interest.toFixed(2)}`+
            "<br>Депозит: "+`${cash}`+
            "<br>Общая сумма: "+`${total.toFixed(2)}`
        ;
    }
    else if (document.getElementById("compound").checked && document.getElementById("periodMonth").checked){
         //month
         let repeat = Math.trunc((days / 30));
         for (let i=1; i <= repeat; i++) {
         compoundInterest += ((compoundInterest * rate * 30)/365)/100;
         }
         document.getElementById("injection").innerHTML =
             "Информация:<br> Cтавка: "+`${rate}` +"% годовых<br>"+
             "Капитализация: ежемесячная<br>"+
             "Итого за "+`${repeat}`+" мес.: " + `${compoundInterest.toFixed(2)}`+
             "<br>Проценты составили: "+ `${(compoundInterest - cash).toFixed(2)}`
         ;
    }
    else if (document.getElementById("compound").checked && document.getElementById("periodQuarter").checked){
        //quarter
        let repeat = Math.trunc((days / 120));
        for (let i=1; i <= repeat; i++) {
            compoundInterest += ((compoundInterest * rate * 120)/365)/100;
        }
        document.getElementById("injection").innerHTML =
            "Информация:<br> Cтавка: "+`${rate}` +"% годовых<br>"+
            "Капитализация: ежеквартально<br>"+
            "Итого за "+`${repeat}`+" кв.: " + `${compoundInterest.toFixed(2)}`+
            "<br>Проценты составили: "+ `${(compoundInterest - cash).toFixed(2)}`
        ;
    }
    else if (document.getElementById("compound").checked && document.getElementById("periodYear").checked){
        //year
        let repeat = Math.trunc((days / 365));
        for (let i=1; i <= repeat; i++) {
            compoundInterest += ((compoundInterest * rate * 365)/365)/100;
        }
        document.getElementById("injection").innerHTML =
            "Информация:<br> Cтавка: "+`${rate}` +"% годовых <br> "+
            "Капитализация: ежегодно<br>"+
            "Итого за "+`${repeat}`+" г: " + `${compoundInterest.toFixed(2)}`+
            "<br>Проценты составили: "+ `${(compoundInterest - cash).toFixed(2)}`
        ;
    }

}