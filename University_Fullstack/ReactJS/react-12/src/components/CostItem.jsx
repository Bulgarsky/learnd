import './CostItem.css';
import React from 'react';
import CostDate from "./CostDate";

const CostItem = (props) => {
    // const costDate = new Date(2023, 6, 16);
    // const costTitle = 'Mac Studio Max';
    // const costAmount = 1850.50;

    // const month = props.date.toLocaleString("ru-RU", {month: "long"});
    // const year = props.date.getFullYear();
    // const day = props.date.toLocaleString("ru-RU", {day: "2-digit"});

    return (
        <div className="cost-item">
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
                <h2>{props.title}</h2>
                <div className="cost-item__price">$ {props.amount}</div>
            </div>
        </div>
    );
};

export default CostItem;