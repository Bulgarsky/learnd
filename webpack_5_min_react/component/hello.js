import React from "react";
import "./hello.css";

export default function ({name = 'user'}){

    return <div className="box">
            <h2 className="alert">Hello, {name}</h2>
            <p>Webpack react</p>
        </div>;

};