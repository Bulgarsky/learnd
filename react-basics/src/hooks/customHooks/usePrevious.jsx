import {useRef, useEffect, useState} from "react";



//функц. принимает значение
export function usePrevious(value){
    const ref = useRef(); //может хранить объект {current: null}

    //2)вызывает эффект
    useEffect(() => {
        //новое значение сохранится в эффекте для переиспользования в след раз
        ref.current = value;
    });

    //1) возвращает предыдущee значение
    return ref.current;
}

export default function SimpleClick(){
    const [count, setCount] = useState(0);

    //0) иниц. prevCount = вызв функцию(передать значение)
    const prevCount = usePrevious(count);

    return(
        <div className="simple-click">
            <button onClick={() => setCount(count +1)}> Update </button>
            <h2>Current: {count}</h2>
            <h2>Previous: {prevCount}</h2>
        </div>
    );
}

