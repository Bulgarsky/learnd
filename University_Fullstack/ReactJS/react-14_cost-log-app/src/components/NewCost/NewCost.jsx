import React, {useState} from 'react';
import "./NewCost.css";
import CostForm from "./CostForm";

const NewCost = (props) => {

    const [isFormVisible, setIsFormVisible] = useState(false);

    //получение данных из дочернего компонента
    const saveCostDataHandler = (inputCostData) => {
        const costData = {
            ...inputCostData,
            id: Math.random().toString()
        }
        console.log(costData);
        props.onAddCost(costData);
        setIsFormVisible(false);
    };

    const inputCostDataHandler = () => {
        setIsFormVisible(true);
    };

    const cancelCostHandler = () => {
        setIsFormVisible(false);
    }

    return (
        <div className="new-cost">
            {!isFormVisible && <button onClick={inputCostDataHandler}>Новая запись в журнал расходов</button>}
            {isFormVisible && <CostForm onSaveCostData={saveCostDataHandler} onCancel={cancelCostHandler}/>}
        </div>
    );
};

export default NewCost;