import React, {useContext} from "react";
import {AppContext} from "../hooks/ContextComponent.jsx";

export default function Book( {id, isbnCode, title} ){
    const {
        removeBook = Function.prototype,
    } = useContext(AppContext);


    return(
        <div className="book">
            <p>
                <span>
                    {id}. {title} {" (isbnCode: " + isbnCode + ") "}</span>
                <button
                    onClick={() => removeBook(id)}>
                    X
                </button>
            </p>

        </div>
    )
}