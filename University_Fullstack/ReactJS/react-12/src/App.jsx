//root component
import CostItem from "./components/CostItem";
import Costs from "./components/Costs";
function App() {
    //императив, пошаговые инструкции дл js
    // const p = document.createElement('p');
    // p.textContent='Hey there';
    // document.getElementById('root').append(p);

    const costs = [
        {
            date: new Date(2023, 6, 16),
            title: "Mac Studio MAX",
            amount: 1850.50
        },
        {
            date: new Date(2023, 5, 1),
            title: "Холодильник",
            amount: 450
        },
        {
            date: new Date(2023, 3, 15),
            title: "Телефон",
            amount: 250
        }

    ];

  return (
    <div>
        <h1>Cost Log react app</h1>
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

        <Costs
            costs={costs}
        />

    </div>
  );
}

export default App;
