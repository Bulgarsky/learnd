import CostDate from "./CostDate";
import Card from "../UI/Card";
import './CostItem.css';

import React, {useState} from 'react';


const CostItem = (props) => {
    // const costDate = new Date(2023, 6, 16);
    // const costTitle = 'Mac Studio Max';
    // const costAmount = 1850.50;

    // const month = props.date.toLocaleString("ru-RU", {month: "long"});
    // const year = props.date.getFullYear();
    // const day = props.date.toLocaleString("ru-RU", {day: "2-digit"});

    //hook возвращает массив ( значение и функцию )
    //значение 1 - переменная состояния
    //значение 2 -  функция для обновления
    const [title, setTitle] = useState(props.title);
    //useState регистрирует изменения для конкретного экземпляра компонента
    //let title = props.title;

    const changeTitleHandler = () =>{
        //title = "new item title";
        setTitle('New item title');
        //render CostItem
    }

    return (
        //императив
        //document.getElementById('root').addEventListener(

        <Card className="cost-item">
            {/*<div>{props.date.toISOString()}</div>*/}
            {/*<div>*/}
            {/*    /!*<div>{props.date.toLocaleString("ru-RU", {month: "long"})}</div>*!/*/}
            {/*    <div>{month}</div>*/}
            {/*    <div>{year}</div>*/}
            {/*    <div>{day}</div>*/}
            {/*</div>*/}

            <CostDate
                date={props.date}
            />

            <div className="cost-item__description">
                <h2>{title}</h2>
                <div className="cost-item__price">$ {props.amount}</div>
            </div>
            {/*<button onClick={() => console.log("Click!")}>Анон.событие</button>*/}
            <button onClick={changeTitleHandler}>change title</button>
        </Card>
    );
};

export default CostItem;