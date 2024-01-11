import React, {useState, useEffect, useLayoutEffect} from "react";

export default function BlinkRender(){
    const [value, setValue] = useState(0);

    //функция установки значения 0
    function setValueZero(){
        setValue(0);
    }

    //Если иcп. useEffect, то произойдет два рендера, после вып.функции setValueZero, и
    //после проверки и повторной установке нового значения через формулу
    //будет мигание
    /*
    useEffect(() => {
        if (value === 0) {
            setValue(10 + Math.random() * 200);
        }
        //зависимость от value
    }, [value]);

     */

    //Если использовать useLayoutEffect - то произойдет 1 рендер после полного выполнения тела эффекта, но не первичном изменении зависимости
    //useLayoutEffect  - синхронный
    useLayoutEffect(() => {
        if (value === 0) {
            setValue(10 + Math.random() * 200);
        }
        //зависимость от value
    }, [value]);

    console.log("render ", value);

    return(
        // при клике = установить значение 0
        <button onClick={setValueZero}>value: {value} </button>
    )
}