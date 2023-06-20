import React from 'react';
import CostItem from "./CostItem";
import "./CostList.css";
const CostList = (props) => {

    if (props.costs.length === 0) {
        return (
            <h3 className="cost-list__fallback">В выбранном году нет расходов</h3>
        );
    }

    return (
    <ul className="cost-list">
        {props.costs.map((element) => (
            <CostItem
                // всегда добавлять кей при отображении списка с элементами
                key={element.id}
                date={element.date}
                title={element.title}
                amount={element.amount}
            />
        ))}
    </ul>
    );
}

export default CostList;