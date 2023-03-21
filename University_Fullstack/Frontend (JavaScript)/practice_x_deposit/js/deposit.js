function result() {
    const rate = Number(document.getElementById("rate").value);
    const cash = Number(document.getElementById("cash").value);
    const days = Number(document.getElementById("days").value);

    if (document.getElementById("simple").checked) {
        injectVisual();
        getSimpleInterest(rate, days, cash);

    } else {
        injectVisual();
        getCompoundInterest(rate, days, cash);
    }
}
function injectVisual() {
    document.getElementById("inject-visual").innerHTML =
        "<table id='visual'><tr><th>Было:</th><th></th><th>Стало:</th></tr><tr>"+
        "<th id='cash-start'></th><th></th>"+
        "<th id='cash-finish'></th></tr><tr><th></th><th></th><th></th></tr>"+
        "<td><div style='background: red; width:40px; height:100px'></div></td><td></td>"+
        "<td><div style='background: green; width:40px; height:0' id='height-finish'></div></td></table>";
}

function getSimpleInterest(rate, days, cash) {
    const typePeriod = "дн.";
    const typeCapital = "на момент снятия";
    const repeat = days;
    let interest = ((cash * rate * days) / 365)/100;
    const total = cash + interest;
    injectInfo(rate, typeCapital, repeat, typePeriod, total, cash);

    document.getElementById('height-finish').style.height = total.toFixed(0) / cash * 100 + 'px';
    document.getElementById('cash-start').innerHTML = cash;
    document.getElementById('cash-finish').innerHTML = total.toFixed(2);
}

function  getCompoundInterest(rate, days, cash) {
    let total = cash;

    if (document.getElementById("compound").checked && document.getElementById("periodMonth").checked){
        //month
        const typePeriod = "мес.";
        const typeCapital ="ежемесячная";
        let repeat = Math.trunc((days / 30));
        for (let i=1; i <= repeat; i++) {
            total += ((total * rate * 30)/365)/100;
        }
        injectInfo(rate, typeCapital, repeat, typePeriod, total, cash);
    }
    else if (document.getElementById("compound").checked && document.getElementById("periodQuarter").checked){
        //quarter
        const typePeriod = "кв.";
        const typeCapital = "ежеквартально";
        let repeat = Math.trunc((days / 120));
        for (let i=1; i <= repeat; i++) {
            total += ((total * rate * 120)/365)/100;
        }
        injectInfo(rate, typeCapital, repeat, typePeriod, total, cash);
    }
    else if (document.getElementById("compound").checked && document.getElementById("periodYear").checked){
        //year
        const typePeriod = "г.";
        const typeCapital = "ежегодно";
        let repeat = Math.trunc((days / 365));
        for (let i=1; i <= repeat; i++) {
            total += ((total * rate * 365)/365)/100;
        }
        injectInfo(rate, typeCapital, repeat, typePeriod, total, cash);
    }
    document.getElementById('height-finish').style.height = total.toFixed(0) / cash * 100 + 'px';
    document.getElementById('cash-start').innerHTML = cash;
    document.getElementById('cash-finish').innerHTML = total.toFixed(2);
}

function injectInfo(rate, typeCapital, repeat, typePeriod, total, cash) {
    document.getElementById("injection").innerHTML =
        "Информация:<br> Cтавка: "+`${rate}` +" % годовых <br> "+
        "Капитализация: "+ `${typeCapital}` +"<br>"+
        "Итого за "+`${repeat}`+" "+`${typePeriod}`+": "+ `${total.toFixed(2)}`+
        "<br>Проценты составили: "+`${(total - cash).toFixed(2)}`;
}