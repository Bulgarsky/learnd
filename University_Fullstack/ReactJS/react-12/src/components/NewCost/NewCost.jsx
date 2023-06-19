import React from 'react';
import "./NewCost.css";
import CostForm from "./CostForm";

const NewCost = (props) => {

    //получение данных из дочернего компонента
    const saveCostDataHandler = (inputCostData) => {
        const costData = {
            ...inputCostData,
            id: Math.random().toString()
        }
        //console.log(costData);
        props.onAddCost(costData);
    };

    return (
        <div className="new-cost">
            <CostForm
                onSaveCostData={saveCostDataHandler}
            />
        </div>
    );
};

export default NewCost;