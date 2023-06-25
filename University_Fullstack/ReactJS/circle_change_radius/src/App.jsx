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

    //1
    const [items, setItems] = useState (INITIAL_DATA);

    function setItemValue(i, newValue) {
//        не реактивно, противоречить имутабельности:
//        item.value= newValue;

        //деструктурируем объект на поля, изменяем поле
        //setItem({ ...item , value: newValue});

        //новый массив, скопированный поэлементно
        let newItems = [ ...items ];

        console.log(newItems[i]);
        //кладем новое значение в ячейку по новому адресу
        newItems[i] = { ...items[i], value: newValue };
        //передаем новый массив в сеттер
        setItems(newItems);
    }

    const itemElements = items.map((item, i) =>
        <Circle
            //1) передача i при испорльзовании в цикле
            // i={i}
            min={item.min}
            max={item.max}
            value={item.value}
            //1
            //changed={setItemValue}
            //2) создается ссылка на каждый элемент
            changed={newVal => setItemValue(i, newVal)}
            // не лучшее использование ключа:
            key={i}
        />);


    //2
    //let [item, setItem] = useState({min:1, max:10, value: 3});


  return (
      <div>
          {/* 1 */}
          {itemElements}

          {/*2*/}
          {/*<Circle*/}
          {/*    min={item.min}*/}
          {/*    max={item.max}*/}
          {/*    value={item.value}*/}
          {/*    changed={setItemValue}*/}
          {/*/>*/}
      </div>
  );
}

export default App;
