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
    let interest = ((cash * rate * days) / 365)/100;
    const total = cash + interest;
    document.getElementById("injection").innerHTML =
        "Информация:<br> Cтавка по вкладу: "+`${rate}` +"% годовых<br>"+
        "Проценты за "+`${days}`+" дн.: " +
        `${interest.toFixed(2)}`+
        "<br>Депозит: "+`${cash}`+
        "<br>Общая сумма: "+`${total.toFixed(2)}`;

    document.getElementById('height-finish').style.height = total.toFixed(0) / cash * 100 + 'px';
    document.getElementById('cash-start').innerHTML = cash;
    document.getElementById('cash-finish').innerHTML = total.toFixed(2);
}

function  getCompoundInterest(rate, days, cash) {
    let total = cash;

    if (document.getElementById("compound").checked && document.getElementById("periodMonth").checked){
        //month
        let repeat = Math.trunc((days / 30));
        for (let i=1; i <= repeat; i++) {
            total += ((total * rate * 30)/365)/100;
        }
        document.getElementById("injection").innerHTML =
            "Информация:<br> Cтавка: "+`${rate}` +"% годовых<br>"+
            "Капитализация: ежемесячная<br>"+
            "Итого за "+`${repeat}`+" мес.: " + `${total.toFixed(2)}`+
            "<br>Проценты составили: "+ `${(total - cash).toFixed(2)}`;
    }
    else if (document.getElementById("compound").checked && document.getElementById("periodQuarter").checked){
        //quarter
        let repeat = Math.trunc((days / 120));
        for (let i=1; i <= repeat; i++) {
            total += ((total * rate * 120)/365)/100;
        }
        document.getElementById("injection").innerHTML =
            "Информация:<br> Cтавка: "+`${rate}` +"% годовых<br>"+
            "Капитализация: ежеквартально<br>"+
            "Итого за "+`${repeat}`+" кв.: " + `${total.toFixed(2)}`+
            "<br>Проценты составили: "+ `${(total - cash).toFixed(2)}`;
    }
    else if (document.getElementById("compound").checked && document.getElementById("periodYear").checked){
        //year
        let repeat = Math.trunc((days / 365));
        for (let i=1; i <= repeat; i++) {
            total += ((total * rate * 365)/365)/100;
        }
        document.getElementById("injection").innerHTML =
            "Информация:<br> Cтавка: "+`${rate}` +"% годовых <br> "+
            "Капитализация: ежегодно<br>"+
            "Итого за "+`${repeat}`+" г: " + `${total.toFixed(2)}`+
            "<br>Проценты составили: "+ `${(total - cash).toFixed(2)}`;
    }
    document.getElementById('height-finish').style.height = total.toFixed(0) / cash * 100 + 'px';
    document.getElementById('cash-start').innerHTML = cash;
    document.getElementById('cash-finish').innerHTML = total.toFixed(2);
}
