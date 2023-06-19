
import React, {useState} from "react";
//root component
import Costs from "./components/Costs/Costs";
import NewCost from "./components/NewCost/NewCost";


const INITIAL_COSTS = [
    {
        id:'c1',
        date: new Date(2023, 5, 30),
        title: "Mac Studio MAX",
        amount: 1850.50
    },
    {
        id:'c2',
        date: new Date(2022, 5, 1),
        title: "Холодильник",
        amount: 450
    },
    {
        id:'c3',
        date: new Date(2021, 3, 15),
        title: "Телефон",
        amount: 250
    },
];


const App = () => {
    //императив, пошаговые инструкции  js
    // const p = document.createElement('p');
    // p.textContent='Hey there';
    // document.getElementById('root').append(p);

    const [costs, setCosts]= useState(INITIAL_COSTS);

    const addCostHandler = (cost) => {
        setCosts(prevCost =>{
            return [cost, ...prevCost]
        });
    };

  return (
  <div>
      <h1>Cost Log react app</h1>

        <NewCost
            onAddCost={addCostHandler}
        />
        <Costs
            costs={costs}
        />

    </div>
  );

    // old обращение к методам реакт
  //return React.createElement('div', {}, React.createElement('h1', {}, "Заголовок"), React.createElement(Costs, {costs: costs}, ));

}

export default App;
