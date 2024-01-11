import {useEffect, useReducer} from "react";

//хранение в локал значения
function setDefaultValue() {
    const userCount = localStorage.getItem("count");
    return userCount ? +userCount : 0;
}

const countReducer = (state, {type}) => {

    switch (type){
        case"START":
            return {
                ...state,
                isCounting: true
            }
        case "STOP":
            return {
                ...state,
                isCounting: false
            }
        case "RESET":
                return {
                    count: 0,
                    isCounting: false
                }
        case "TICK":
            return {
                ...state,
                count: state.count + 1
            }
        default:
            return state;
    }
}

export default function TimerWithReducer() {
    const [{count, isCounting}, dispatch] = useReducer(countReducer, {count: setDefaultValue(), isCounting: false })



    useEffect(() => {
        //сохранить значение в локал изменении count
        localStorage.setItem("count", count);
    }, [count]);

    useEffect(() => {
        let timerId = null;
        if(isCounting) {
            //start timer
            timerId = setInterval(() =>{
                dispatch({type: "TICK"})
            }, 1000);
        }

        //Если false - удаляем интервал
        return () => {
            console.log("unmount");
            timerId && clearInterval(timerId);
            timerId = null;
        }
    }, [isCounting]);

    return(
        <>
            <h3>Timer: {count}</h3>
            <p>
                {
                    !isCounting
                        ? <button onClick={() => dispatch({type: "START"})}>Start</button>
                        : <button onClick={() => dispatch({type: "STOP"})}>Stop</button>
                }

                <button onClick={() => dispatch({type: "RESET"})}>Reset</button>

            </p>
        </>
    )
}