import React, {useEffect, useState} from "react";
export default function Clicker(){
    //хук вовзращает массив, деструктуризация:
    //[переменная, функция] = useState(начальное состояние / значение по умолчанию);
    const [count, setCount] = useState(0);

    //функция
    function handleClickSub(){
        setCount(count - 1);
    }

    //стрелочная функция
    const multi2 = () => {
        setCount(count * 2)
    }

    let spanStyle;
    spanStyle = {
        display: "inline-block",
        margin: "0 0.5rem"
    }

    //useEffect - отвечает за рабоут с жизненными циклами (componentDidMount, componentDidUpdate, componentWillUnmount)
    //callback функция и [зависимости]
    //При пустых зависимостях - выполнить 1 раз
    //При перечислении зависимостей - обьединит в себе didMount, didUpdate
    useEffect(() => {
        console.log("Clicker: ", count);

        //didUnmount
        return () => console.log("Clicker down")
    }, [count]);

    return (
        <>
            {/*анонимная функция*/}
            <button onClick={handleClickSub}> -1 </button>
            <span style={spanStyle}>{count}</span>
            <button onClick={() => setCount(count+1)}> +1 </button>
            <br />
            <br />
            <button onClick={multi2}> * 2</button>
        </>
    )
}