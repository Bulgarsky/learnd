import React, {useEffect} from "react";
import somePlugin from "some-plugin";
//Данный хук явл. асинхронным (стал таковым полностью в v.17
//useEffect могут быть более 1го, можно помнетить коментарием
//испоьзуется в касмтомных хуках
//componentDidUpdate

export default function Effect(){


    //через анонимную функцию, подписать что делает
    useEffect(() => {
        const handler = () => {
            //что то делает
        }

        document.addEventListener("click", handler);

        return () => {
            //очистка
            document.removeEventListener("click", handler);
        }

        //если не указывать [dependencies] то размонтирование и очистка будет выполнятка каждый раз
        //если [dependencies] указана, то размонтирование будет выполнятся при изменении зависимости
        // если указан пустой [], то очистка будет выполнена при размонтировании самого приложения
    }, []);

    //исп. функцию, вне эффекта будет не доступна
    //псевдно код
    useEffect(function initPlugin(){
        somePlugin.init();

        return () => {
            //очистка
            somePlugin.destroy();
        }
    }, []);

    return(
        <>

        </>
    )
}