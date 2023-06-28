import React, {useState} from "react";

import "bootstrap/dist/css/bootstrap.min.css";

export default function ({ min, max }){
    let [current, setCurrent] = useState(min);
    console.log(current);

    function increment(){
        if (current < max) {
            setCurrent(current + 1);
        }
    }

    function decrement(){
        if (current > min) {
            setCurrent(current - 1);
        }
    }


    return (
        <div>
            <button className="btn btn-danger" type="button" onClick={ decrement }> - </button>
            <span className="m-2">{ current }</span>
            <button className="btn btn-success" type="button" onClick={ increment }> + </button>
        </div>
    )
};




/*

let [current, setCurrent] = useState(1);

let some = useState(0);
let current = some[0];
let setCurrent = some [1];

 */

