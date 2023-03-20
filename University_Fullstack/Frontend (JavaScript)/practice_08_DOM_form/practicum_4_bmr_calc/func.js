function calcBMR(){
    let weight = document.getElementById("weight");
    let growth = document.getElementById("growth");
    let age = document.getElementById("age");
    let bmr = 0;
    if(document.getElementsByName("gender")[0].checked) {
        bmr = 66 + (13.7*weight.value)+(5*growth.value)-(6.8*age.value); //M
    }else{
        bmr = 655 + (9.6*weight.value)+(1.8*growth.value)-(4.7*age.value); //W
    }

    switch(document.getElementById("activity").value) {
        case "sedentary": bmr *= 1.2;
            break;
        case "minimal": bmr *= 1.375;
            break;
        case "medium": bmr *= 1.55;
            break;
        case "high": bmr *= 1.725;
            break;
        case "maximum": bmr *= 1.9;
            break;
    }
    document.getElementById("result").innerText="Согласно рекомендаицям требуется "+bmr +" ккал в сутки";
}

function showActivityPicture () {
    if (document.getElementsByName("gender")[0].checked) {
        //M
        switch (document.getElementById("activity").value) {
            case "sedentary":
                document.getElementById("activity_picture").src = "img/m1.jpg";
                break;
            case "minimal":
                document.getElementById("activity_picture").src = "img/m2.jpg";
                break;
            case "medium":
                document.getElementById("activity_picture").src = "img/m3.jpg";
                break;
            case "high":
                document.getElementById("activity_picture").src = "img/m4.jpg";
                break;
            case "maximum":
                document.getElementById("activity_picture").src = "img/m5.jpg";
                break;
        }
    } else {
        //W
        switch (document.getElementById("activity").value) {
            case "sedentary":
                document.getElementById("activity_picture").src = "img/w1.jpg";
                break;
            case "minimal":
                document.getElementById("activity_picture").src = "img/w2.jpg";
                break;
            case "medium":
                document.getElementById("activity_picture").src = "img/w3.jpg";
                break;
            case "high":
                document.getElementById("activity_picture").src = "img/w4.jpg";
                break;
            case "maximum":
                document.getElementById("activity_picture").src = "img/w5.jpg";
                break;
        }
    }
}

function showActivityDescription () {
    switch (document.getElementById("activity").value) {
        case "sedentary":
            document.getElementById("activity_description").innerHTML="<p>Нет работы или работа за столом</p>"
            break;
        case "minimal":
            document.getElementById("activity_description").innerHTML="<p>Мало физической работы или занятия спортом 1-3 раза в неделю</p>"
            break;
        case "medium":
            document.getElementById("activity_description").innerHTML="<p>Умеренная физическая работа или занятия спортом 3-5 дней в неделю</p>"
            break;
        case "high":
            document.getElementById("activity_description").innerHTML="<p>Сильная физическая нагрузка или занятия спортом6-7 раза в неделю</p>"
            break;
        case "maximum":
            document.getElementById("activity_description").innerHTML="<p>Сильная еждевная физическая нагрузка или спорт и физическая работа</p>"
            break;
    }
}