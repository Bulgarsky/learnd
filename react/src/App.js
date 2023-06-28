import React from 'react';

import "bootstrap/dist/css/bootstrap.min.css";

import UserCard from "../components/UserCard";
import Counter from "./Counter";


const App = () => {

    return (
        <div className="m-3 p-2">
            <h2>React App</h2>
            <hr />
            <h3> min 1 max 10 </h3>
            <Counter max={10} min={1} />
            <hr />
            <h3> min 1 </h3>
            <Counter min={1}/>
            <hr />
            <UserCard name="John Doe" text="Hello friend!"/>
            <UserCard name="Roman Pierce" text="wassup dawg"/>
        </div>
    );
};

export default App;

