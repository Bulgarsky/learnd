import React from 'react';

import "bootstrap/dist/css/bootstrap.min.css";

import UserCard from "../components/UserCard";



const App = () => {

    return (
        <div className="m-3 p-2">
            <h2>React App</h2>
            <UserCard name="John Doe" text="Hello friend!"/>
            <UserCard name="Roman Pierce" text="wassup dawg"/>
        </div>
    );
};

export default App;

