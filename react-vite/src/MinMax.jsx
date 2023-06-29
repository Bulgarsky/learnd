
import PropTypes from "prop-types";

import { Button, Input } from "semantic-ui-react";



// eslint-disable-next-line react/prop-types
const MinMax = ( { min= 1, max, current, onChange }) => {

    console.log(current);

    function validateDiapason(num){
        let validateNum = Math.max(min, Math.min(max, num));
        onChange(validateNum);

        //console.log('upd.');
    }

    //Если границы двух значные onChange багуется!
    function parseCurrentString(event){
        let num = parseInt(event.target.value);
        validateDiapason(isNaN(num) ? min : num);
    }

    let increment = () => validateDiapason(current + 1);
    let decrement = () => validateDiapason(current - 1);


    /*
    //если задать пустой массив [] - то сработает 1 раз
    //можно передать параметры на какие хотим смотреть, мульти вотчер
    useEffect(() => {
        console.log('echo useEffect');
        validateDiapason(current);
    }, [min, max]);
     */


    return (
        <div>
            <Button basic color='red' type="button" onClick={ decrement }> - </Button>
            <Input focus type="text"
                   value={ current }
                   onChange={ parseCurrentString }/>
            <Button basic color='green' type="button"
                    onClick={ increment }> + </Button>
        </div>
    )
}


export default MinMax;

MinMax.prototype = {
    min: PropTypes.number,
    max: PropTypes.number.isRequired,
    current: PropTypes.number.isRequired,
    onChange: PropTypes.func.isRequired
}

/*

let [current, setCurrent] = useState(1);

let some = useState(0);
let current = some[0];
let setCurrent = some [1];

 */

