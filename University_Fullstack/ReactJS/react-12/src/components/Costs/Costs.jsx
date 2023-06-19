import React, {useState} from 'react';

import CostItem from "./CostItem";
import Card from "../UI/Card";
import CostFilter from "./CostFilter";

import './Costs.css'

const Costs = (props) => {

    const[selectedYear, setSelectedYear] = useState('2021');
    const yearChangeHandler = (year) => {
        console.log('cost component: ' + year);
        setSelectedYear(year);
    };

    return (
        <div>

            <Card className="costs">
                {/*двухсторонее связывание - передача года*/}
                {/*контролируемый компонент*/}
                <CostFilter
                    year={selectedYear}
                    onChangeYear={yearChangeHandler}
                />

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

            </Card>
        </div>
    );
};

export default Costs;