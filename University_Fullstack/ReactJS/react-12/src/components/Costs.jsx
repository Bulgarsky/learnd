import React from 'react';
import CostItem from "./CostItem";
import './Costs.css'

const Costs = (props) => {
    return (
        <div className='costs'>
            <CostItem
                date={props.costs[0].date}
                title={props.costs[0].title}
                amount={props.costs[0].amount}
            />
            <CostItem
                date={props.costs[1].date}
                title={props.costs[1].title}
                amount={props.costs[1].amount}
            />
            <CostItem
                date={props.costs[2].date}
                title={props.costs[2].title}
                amount={props.costs[2].amount}
            />

        </div>
    );
};

export default Costs;