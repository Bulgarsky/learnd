//пришел из Redux

//func Reducer принимает текущее состояние и действие, в зависимости от которого предполагается , что функция вернет НОВОЕ состояние
//reducer(currentState, Action) { return newState}}
//используется когда много сущеностей

import React, { useReducer } from "react";
import "./styles.css";

//вспомогательная функц, ограничивающая границы слева справа, и наращивает с шагом 50
const limitRGB = (num) => (num < 0 ? 0 : num > 255 ? 255 : num);
const step = 50;

//reducer - принимает (стейт и action)
//reducer (state, action)
//action = {type, payload}
const reducer = (state, { type, payload = step }) => {
//payload - полезные данные

    switch (type) {
        //если тип
        case "INCREMENT_R":
            return {
                //вернуть весь стейт и заменить один ключ r
                ...state,
                r: limitRGB(state.r + payload)
            };
        case "DECREMENT_R":
            return {
                ...state,
                r: limitRGB(state.r - payload)
            };
        case "INCREMENT_G":
            return {
                ...state,
                g: limitRGB(state.g + payload)
            };
        case "DECREMENT_G":
            return {
                ...state,
                g: limitRGB(state.g - payload)
            };
        case "INCREMENT_B":
            return {
                ...state,
                b: limitRGB(state.b + payload)
            };
        case "DECREMENT_B":
            return {
                ...state,
                b: limitRGB(state.b - payload)
            };

        default: //если не придет значение, вернуть стейт без изменений
            return state;
    }
};

export default function App() {

    //useReducer - принял функц reducer и initialState,  возвр нач.значения, возвр функц  dispatch для создания события
    const [{ r, g, b }, dispatch] = useReducer(reducer, { r: 0, g: 150, b: 200 });

    return (
        <div className="App">
            <h1
                style={{
                    color: `rgb(${r}, ${g}, ${b})`
                }}
            >
                Hello CodeSandbox
            </h1>
            <div>
                <span>r </span>
                <button onClick={() => dispatch({ type: "INCREMENT_R", payload: 100 })}>
                    +
                </button>
                <button onClick={() => dispatch({ type: "DECREMENT_R" })}>-</button>
            </div>
            <div>
                <span>g </span>
                <button onClick={() => dispatch({ type: "INCREMENT_G" })}>+</button>
                <button onClick={() => dispatch({ type: "DECREMENT_G" })}>-</button>
            </div>
            <div>
                <span>b </span>
                <button onClick={() => dispatch({ type: "INCREMENT_B" })}>+</button>
                <button onClick={() => dispatch({ type: "DECREMENT_B" })}>-</button>
            </div>
        </div>
    );
}
