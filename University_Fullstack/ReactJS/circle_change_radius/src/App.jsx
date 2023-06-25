import './App.css';
import "./Circle.css";
import 'bootstrap/dist/css/bootstrap.min.css';
import React, {useState} from "react";
import Circle from "./Circle";

/*
// деструктуризация объекта Property на ключи
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
        max: 10,
        value: 4
    },
    {
        min: 2,
        max: 5,
        value: 3
    }
    ,
    {
        min: 3,
        max: 8,
        value: 6
    }
]

const App = () => {
    /*
    1
    const [items, setItems] = useState (INITIAL_DATA);
    const itemElements = items.map((item, i) =>
        <Circle
            min={item.min}
            max={item.max}
            value={item.value}
            // не лучшее использование ключа:
            key={i}
        />);
        */


    let [item, setItem] = useState({min:1, max:10, value: 3});

    function setItemValue(newValue) {
//        не реактивно, противоречить имутабельности:
//        item.value= newValue;

        //деструктурируем объект на поля, изменяем поле
        setItem({ ...item , value: newValue});
        console.log(newValue);
    }

  return (
      <div>
          {/* 1 {itemElements}*/}

          <Circle
              min={item.min}
              max={item.max}
              value={item.value}
              changed={setItemValue}
          />
      </div>
  );
}

export default App;
