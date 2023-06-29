import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";

function UserCard ({ name, text }) {
    //let {name, text} = props;

    return (
        <>
            <div className="card bg-info mb-3 p-2 col-lg-4">
                <h4 className="text-center text-light">User Card info</h4>
                <hr/>
                <p>UserCard functional component </p>
                <div>{name} {text}</div>
            </div>
        </>
    );
}

export default UserCard;

//React.createElement(UserCard, {name:"John Doe", text: "Hello friend"}, []);

/*

let some = { fn(){} };
//запустится в контексте объекта some
some.fn();

let { fn } = some;
//запустится в контексте window, к some не будет иметь доступа
fn();

 */