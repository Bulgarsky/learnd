import React from 'react';
import DiagramBar from "./DiagramBar";
import "./Diagram.css"


const Diagram = (props) => {
    const dataSetsValues = props.dataSets.map(dataSet => dataSet.value);
    const maxMonthCost = Math.max(...dataSetsValues);

    return (
        <div className="diagram">
            {props.dataSets.map(element =>
                    <DiagramBar
                        key={element.label}
                        value={element.value}
                        maxValue={maxMonthCost}
                        label={element.label}
                    />
            )}
        </div>
    );
};

export default Diagram;