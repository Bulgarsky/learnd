import React, {useState, useCallback} from "react";

//useCallback - возвращает мемоизированую функцию (не выпоняя эту функцию внутри самого хука
//useMemo - возвращаем мемоизированные значения (массив, объект, и тд)

//при использовании useState
//3) при ререндере компонента DoubleCounter, произойдет ДВА рендера этого компонента:
function CountButton({onClick, count}){
    console.log("render ", count);
    return <button onClick={onClick}>{count}</button>
}

//2) При нажатии на любой из кнопок - произодет ререндер этого компонета
function DoubleCounter(){
    const [count1, setCount1] = useState(0);
    const increment1 = () => setCount1(count1 => count1 +1);

    const [count2, setCount2] = useState(0);
    const increment2 = () => setCount1(count2 => count2 +1)


    return(
        <>
            {/*1) нажимаем на любую кнопку*/}
            <CountButton count={count1} onClick={increment1}/>
            <CountButton count={count2} onClick={increment2}/>
        </>
    )
}

//useCallback + memo

//3) при нажатии на любую из кнопок - произойдет ререндер ОДНОГО из компонета и измененным значением
//memo предотвращает  ререндер если пришли теже самые пропсы
const CountButton2 = React.memo(({onClick, count}) => {
    console.log("render ", count);
    return <button onClick={onClick}>{count}</button>
});

//2) При нажатии на любой из кнопок - произодет ререндер этого компонета
function DoubleCounter2(){
    const [count1, setCount1] = useState(0);

    //запоминаем функцию и не обновляет её
    //useCallback - возвращает запомненную функцию
    const increment1 = useCallback(() => setCount1(count1 => count1 +1), []);

    const [count2, setCount2] = useState(0);
    const increment2 = useCallback(() => setCount1(count2 => count2 +1), []);


    return(
        <>
            {/*1) нажимаем на любую кнопку*/}
            <CountButton2 count={count1} onClick={increment1}/>
            <CountButton2 count={count2} onClick={increment2}/>
        </>
    )
}