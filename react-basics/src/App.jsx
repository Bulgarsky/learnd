import {ContextComponent} from "./hooks/ContextComponent.jsx";
import Books from "./components/Books.jsx"

import SimpleClick from "./hooks/customHooks/usePrevious.jsx";
import {usePrevious} from "./hooks/customHooks/usePrevious.jsx";
import useLocalStorage from "./hooks/customHooks/useLocalStorage.jsx";
import TimerWithReducer from "./components/TimerWithReducer.jsx";

export default function App() {
    //для примера с useLocalStorage
    const [count, setCount] = useLocalStorage(0, "key");
    const prevCount = usePrevious(count);

  return (
      //обернуть в компонент Context из ContextComponent
    <ContextComponent>
        {/* дочерние компоненты(children) смогут использовать ContextComponent */}
        <Books />
    </ContextComponent>

    //  <SimpleClick />

      //useLocalStorage
      // <div className="useLocalStorage">
      //     <button onClick={() => setCount(count + 1)}> Update </button>
      //     <h2>Current: {count}</h2>
      //     <h2>Previous: {prevCount}</h2>
      // </div>
      // <TimerWithReducer />
  )
}