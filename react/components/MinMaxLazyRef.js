import React, {useEffect, useRef} from "react";
import PropTypes from "prop-types";

MinMaxLazyState.prototype = {
    min: PropTypes.number,
    max: PropTypes.number.isRequired,
    current: PropTypes.number.isRequired,
    onChange: PropTypes.func.isRequired
}

function MinMaxLazyState({ min= 1, max, current, onChange }){

    //ссылка на прямой узел ВЩЬ
    let inputRef = useRef();

    const handlerKeyboard = (event) => {
        if(event.key === "Enter"){
            parseCurrentString(event);
        }
    }

    //Если границы двух значные onChange багуется!
    function parseCurrentString(){
        let num = parseInt(inputRef.current.value);
        validateDiapason(isNaN(num) ? min : num);
    }

    function validateDiapason(num){
        let validateNum = Math.max(min, Math.min(max, num));
        inputRef.current.value = validateNum;
        onChange(validateNum);
    }

    let increment = () => validateDiapason(current + 1);
    let decrement = () => validateDiapason(current - 1);

    useEffect(() => {
        inputRef.current.value = current;
    }, [ current ]);

    return (
        <div>
            <button type="button" onClick={ decrement }> - </button>
            <input type="text"
                   ref={ inputRef }
                   defaultValue={ current }
                   onBlur={ parseCurrentString }
                   onKeyPress={ handlerKeyboard }
            />
            <button type="button"
                    onClick={ increment }> + </button>
        </div>
    )
}

export default MinMaxLazyState;


/*

let [current, setCurrent] = useState(1);

let some = useState(0);
let current = some[0];
let setCurrent = some[1];

 */

