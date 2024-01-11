//имитация работы локал

import {useEffect, useState} from "react";

//принимает нач.значение и ключ
function useLocalStorage(initialState, key){
    const get = () => {
        const storage = localStorage.getItem(key);

        //если значение по ключу найдено, то оно будет возвращено через +преобразование, если нет, то вернет значение по умолчанию
        return storage ? +storage : initialState;
    };

    const [value, setValue] = useState(get);


    //при изменении значения, новое значение будет автоматически записано в локал
    useEffect(() => {
        localStorage.setItem(key, value);
    }, [value]);

    //возвращает значение и функцию для измения значения наружу
    return [value, setValue];
}

export default useLocalStorage;