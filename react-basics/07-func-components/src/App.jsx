import React, {useState} from "react";

import Clicker from "./Clicker.jsx";
import Timer from "./Timer.jsx";
import WithRef from "./Ref.jsx";


function App() {
  const [isClicker, setClicker] = useState(false);

  function handleToggle(){
    setClicker(!isClicker);
  }



  return (
    <>
      <h2>React. Functional Components</h2>
      <h3>Lifecycle</h3>
      <button onClick={handleToggle}>Toggle!</button>
      {/*<button onClick={() => setClicker(!isClicker)}>Toggle!</button>*/}
      <br />
      <br />
      {/*{isClicker && <Clicker />}*/}
      <br />
      <br />
      {/*<WithRef />*/}
      {isClicker && <Timer />}
    </>
  )
}

export default App;
