import React, {useEffect, useState} from "react";
const State = () => {
    // массив [значение, функция для изменения значения] = useState(initialValue)
    //const [value, setValue] = useState(0);

    //инициализация через анон.функцию
    /*
    const [value, setValue] = useState(() =>{
        //иниц. и получение значения по ключу count из Local
        const userCount = localStorage.getItem("count");
        //Плюс - преобразование, если NaN(Not a Number), то 0
        return +userCount || 0;
    });

    //гарантированное изменение стейта через функцию и предыдущее значение
    //функция принимает значение из пары []
    setValue((prevValue) => {
        return prevValue + 1;
    })

     */

    //объявление стейтов через объект (как в класс.компонентах)
    const [state, setState] = useState({
        count: 0,
        isCounting: false
    });

    const handleCount = () => {
        //При изменении одного ключа, второй будет затёрт
        //setState({ count: state.count + 1});

        setState({
            // ... - взять из объекта все поля и скопировать
            ...state,
            //потом изменить необходимое поле
            count: state.count + 1}
        );
    };

    const handleStatus = () => {
        setState({
            //развернуть объект и скопировать все поля
            ...state,
            //изменить необходимое поле
            isCounting: !state.isCounting
        });
    };

    useEffect(() => {
        console.log(state);
    }, [state]);

    return(
        <>
            <h3>useState()</h3>
            <button onClick={handleCount}>Click Count</button>
            <button onClick={handleStatus}> Click Status</button>
        </>
    )
}

export default State;