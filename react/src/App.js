import React, {useState} from 'react';

import "bootstrap/dist/css/bootstrap.min.css";

import UserCard from "../components/UserCard";
import Counter from "./Counter";


const App = () => {
    let [ maxNew, setMaxNew ] = useState(10);
    let setMaxNew5 = () => setMaxNew(5);

    return (
        <div className="m-3 p-2">
            <h2>React App</h2>
            <hr />
            <h3> min 1 max 10 </h3>
            <Counter max={8} />
            <hr />
            <h3> max 7 </h3>
            <Counter max={7}/>
            <h3>useEffect</h3>
            <Counter max={ maxNew }/>
            <hr />
            <button type="button" onClick={ setMaxNew5 }>set current 5</button>
            <hr />
            <UserCard name="John Doe" text="Hello friend!"/>
            <UserCard name="Roman Pierce" text="wassup dawg"/>
        </div>
    );
};

export default App;

/*
    "крючки цепляемые к компонентам"
    useState    - созд. состояния
    useEffect   - действие в произвольный момент действия
    useCallback - кеширование функции (чтобы не пересоздавалась заного)
    useMemo     - кеширует вычисления которые тяжело расщитываются
    useReducer  - создание сложного стейта в Redux стиле
    useContext  - проброс данных сквозь уровни
    useRef      - возможность дотянутся до конкретного тега с помощью создания прямой ссылки на конкретнгный узел дом
 */