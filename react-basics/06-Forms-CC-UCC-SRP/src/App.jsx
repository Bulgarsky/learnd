import {Form} from "./components/Form.jsx";
import {Sub} from "./components/Sub.jsx";
import {FormWithRef} from "./components/FormWithRef.jsx";
import {UncontrolledForm} from "./components/UncontrolledForm.jsx";


//CC/UCC - Управляемые и не управляемые компоненты (controlled / uncontrolled components)
//SRP  - single responsibility principle (принцип единой ответственности)
function App() {

  return (
    <div>
        <h2>React Form</h2>
        {/*<Form />*/}
        {/*<Sub />*/}
        {/*<FormWithRef />*/}
        <UncontrolledForm/>
    </div>
  )
}

export default App;
