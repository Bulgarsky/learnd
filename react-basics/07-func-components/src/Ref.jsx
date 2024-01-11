import React, {useEffect, useRef, useState} from "react";
const WithRef = () => {

    //формируется объект с ключем единственным Current
    // const inputElement = useRef(null);
    // console.log(inputElement);
    const numberRef = useRef(0);
    const [count, setCount] = useState(0);

    function handleClick(){
        //ререндер не произойдет. useRef - не уведомляет об изменениях
        // numberRef.current = 1;


        //не пртведет к изменению 3 раза:
        /*
        setCount(count + 1);
        setCount(count + 1);
        setCount(count + 1);
         */

        setCount((prevCount) => prevCount + 1);
    }

    useEffect(() => {
        console.log(numberRef.current);
    });

    return(
        <>
            {/*<input placeholder="name" ref={inputElement}/>*/}
            <button onClick={handleClick}>{count} </button>
        </>
    )
}

export default WithRef;