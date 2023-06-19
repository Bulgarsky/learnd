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

    const filteredCosts = props.costs.filter(
        cost => {
            return cost.date.getFullYear().toString() === selectedYear;
        }
    );

    let constContent = <p>В выбранном году нет насходов</p>;

    if (filteredCosts.length !== 0) {
        constContent = filteredCosts.map((element) => (
            <CostItem
                // всегда добавлять кей при отображении списка с элементами
                key={element.id}
                date={element.date}
                title={element.title}
                amount={element.amount}
            />
        ))
    }

    return (
        <div>
            <Card className="costs">

                {/*двухсторонее связывание - передача года*/}
                {/*контролируемый компонент*/}
                <CostFilter
                    year={selectedYear}
                    onChangeYear={yearChangeHandler}
                    />
                {constContent}

                {/*{filteredCosts.length === 0 && <p>В выбранном году нет насходов</p>*/}
                {/*{filteredCosts.length !== 0 &&*/}
                {/*    filteredCosts.map((element) => (*/}
                {/*        <CostItem*/}
                {/*            // всегда добавлять кей при отображении списка с элементами*/}
                {/*            key={element.id}*/}
                {/*            date={element.date}*/}
                {/*            title={element.title}*/}
                {/*            amount={element.amount}*/}
                {/*        />))}*/}


            </Card>
        </div>
    );
};

export default Costs;