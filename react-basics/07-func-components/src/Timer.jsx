import {useEffect, useState, useRef} from "react";

//хранение в локал значения
function setDefaultValue() {
    const userCount = localStorage.getItem("count");
    return userCount ? +userCount : 0;
}

export default function Timer() {
    const [count, setCount] = useState(setDefaultValue());
    const [isCounting, setIsCounting] = useState(false);
    const timerIdRef = useRef(null);

    function handleStart(){
       setIsCounting(true);
    }

    function handleStop(){
        setIsCounting(false);
    }

    function handleReset(){
        setCount(0);
        setIsCounting(false);
    }


    useEffect(() => {
        //соранить значение в локал
        localStorage.setItem("count", count);
        console.log("update");
    }, [count]);

    useEffect(() => {
        //if true
        if(isCounting) {
            //start timer nad update interval
            timerIdRef.current = setInterval(() =>{
                setCount((prevState) => prevState + 1);
            }, 1000);
        }

        //Если false - удаляем интервал
        return () => {
            console.log("unmount");

            timerIdRef.current && clearInterval(timerIdRef.current);
            timerIdRef.current = null;

        }
    }, [isCounting]);

    return(
        <>
            <h3>Timer: {count}</h3>
            <p>
                {
                    isCounting
                        ? <button onClick={handleStop}>Stop</button>
                        : <button onClick={handleStart}>Start</button>
                }

                <button onClick={handleReset}>Reset</button>

            </p>
        </>
    )
}