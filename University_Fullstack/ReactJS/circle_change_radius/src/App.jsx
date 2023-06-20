import './App.css';
import "./Circle.css";
import 'bootstrap/dist/css/bootstrap.min.css';
import React, {useState} from "react";

const App = () => {
    let [value, setValue] = useState(5);
    let radius = value * 20 +"px";
    let circleStyles = {width: radius, height: radius};
    let canDecrease = value > 1;
    let canIncrease = value < 10;

    const decreaseRadius = () => {
        if (canDecrease) {
            setValue(value - 1);
        }
    }

    const increaseRadius = () => {
        if (canIncrease) {
            setValue(value + 1);
        }
    }

  return (
    <div className="container my-2">
        <div>
            <button className="btn btn-danger app-decrease"
                    onClick={decreaseRadius}>
                Убавить
            </button>
            <span className="app-value mx-2">{value}</span>
            <button className="btn btn-success app-decrease"
                    onClick={increaseRadius}>
                Прибавить
            </button>
        </div>
        <div className="app-circle my-3" style={circleStyles}>
            {/*круг*/}
        </div>
        <div>
            <span className="text-primary">Текущий радуис {value}</span>
        </div>
        {
            (!canDecrease || !canIncrease) &&
            <div className="alert alert-danger mt-3 text-center col-md-3">
                {!canDecrease && <span>Минимальный радиус</span>}
                {!canIncrease && <span>Максимальный радиус</span>}
            </div>
        }
    </div>

    /*
    v-dom
      return React.createElement(
        'div',
          {
              className:'container my-2',
              title: 'hello'
          },
          [
              'Hello dawg ',
              React.createElement(
                  'button',
                  {
                      className:"btn btn-primary"
                  },
                  ['Кнопка']
              )
          ]
      );
     */

      /*
      let div = document.createElement('div');
      div.disabled = true;
      div.className = "container";
       */

  );
}

export default App;
