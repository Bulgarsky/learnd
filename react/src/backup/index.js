import React from "react";
import ReactDom from "react-dom";

import App from "/src/App.js";


ReactDom.render(
    <App />,
    document.querySelector(".app")
);




//jsx parse that code to:
//React.createElement("div", {}, ["Hello"]);

//react events - подписки на события



//example html code:

/*
<div class="some" onClick="">
    <h2>world</h2>
    <hr>
    <div>text</div>
</div>
 */

//DOM class=className

//jsx parse to some that

/*
React.createElement("div", {className:'some', onClick: ""}, [
    React.createElement("h2", {}, ["world"]),
    React.createElement("hr"),
    React.createElement("div", {}, ["text"])
]);
 */