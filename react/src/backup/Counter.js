import React, {useState, useEffect} from "react";
import PropTypes from "prop-types";

import "bootstrap/dist/css/bootstrap.min.css";

function Counter({ min= 1, max }){
    let [current, setCurrent] = useState(min);
    console.log(current);

    function validateDiapason(num){
       let validateNum = Math.max(min, Math.min(max, num));
       setCurrent(validateNum);
    }

    //Если границы двух значные onChange багуется
    function parseCurrentString(event){
        let num = parseInt(event.target.value);
        validateDiapason(isNaN(num) ? min : num);
    }

    let increment = () => validateDiapason(current + 1);
    let decrement = () => validateDiapason(current - 1);

    /*
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
     */

    //если задать пустой массив [] - то сработает раз
    //можно передать параметры на какие хотим смотреть, мульт вотчер
    useEffect(() => {
        console.log('echo useEffect');
        validateDiapason(current);
    }, [min, max]);


    return (
        <div>
            { typeof current }
            <br/>
            <button className="btn btn-danger" type="button" onClick={ decrement }> - </button>
            {/*<span className="m-2">{ current }</span>*/}
            <input className="m-2" type="text" value={ current } onChange={parseCurrentString}/>
            <button className="btn btn-success" type="button" onClick={ increment }> + </button>
        </div>
    )
}

Counter.prototype = {
    min: PropTypes.number,
    max: PropTypes.number.isRequired
}

Counter.defaultProps = {}

export default Counter;


/*

let [current, setCurrent] = useState(1);

let some = useState(0);
let current = some[0];
let setCurrent = some [1];

 */

