import './App.css';
import "./Circle.css";
import 'bootstrap/dist/css/bootstrap.min.css';
import React, {useState} from "react";
import Circle from "./Circle";

/*
// деструктуризация объекта Propertys на ключи
const SomeApp = ({min, max}) => {
       //деструктуризация пропс = этим выражениям:
    let {min, max} = props;
    let min = props.min;
    let max = props.max;
    return ();
}
 */
const INITIAL_DATA = [
    {
        min: 1,
        max: 10
    },
    {
        min: 2,
        max: 5
    }
    ,
    {
        min: 3,
        max: 8
    }
]

const App = () => {
    const [items, setItems] = useState (INITIAL_DATA);

    const itemElements = items.map((item, i) =>
        <Circle
            min={item.min}
            max={item.max}
            // не лучшее использование ключа:
            key={i}
        />);

  return (
      <div>
          {itemElements}
      </div>
  );
}

export default App;
