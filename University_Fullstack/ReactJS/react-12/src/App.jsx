
import React from "react";
//root component
import Costs from "./components/Costs/Costs";
import NewCost from "./components/NewCost/NewCost";


const App = () => {
    //императив, пошаговые инструкции дл js
    // const p = document.createElement('p');
    // p.textContent='Hey there';
    // document.getElementById('root').append(p);

    const costs = [
        {
            id:'c1',
            date: new Date(2023, 6, 16),
            title: "Mac Studio MAX",
            amount: 1850.50
        },
        {
            id:'c2',
            date: new Date(2023, 5, 1),
            title: "Холодильник",
            amount: 450
        },
        {
            id:'c3',
            date: new Date(2023, 3, 15),
            title: "Телефон",
            amount: 250
        },
    ];

    const addCostHandler = (cost) => {
        console.log(cost);
        console.log('app component');
    }

  return (
  <div>
      <h1>Cost Log react app</h1>

      {/*hard code*/}
        {/*<CostItem*/}
        {/*    date={costs[0].date}*/}
        {/*    title={costs[0].title}*/}
        {/*    amount={costs[0].amount}*/}
        {/*/>*/}
        {/*<CostItem*/}
        {/*    date={costs[1].date}*/}
        {/*    title={costs[1].title}*/}
        {/*    amount={costs[1].amount}*/}
        {/*/>*/}
        {/*<CostItem*/}
        {/*    date={costs[2].date}*/}
        {/*    title={costs[2].title}*/}
        {/*    amount={costs[2].amount}*/}
        {/*/>*/}
        <NewCost onAddCost={addCostHandler}/>
        <Costs
            costs={costs}
        />
    </div>
  );

    // old обращение к методам реакт
  //return React.createElement('div', {}, React.createElement('h1', {}, "Заголовок"), React.createElement(Costs, {costs: costs}, ));

}

export default App;
