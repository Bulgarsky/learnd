// import "https://unpkg.com/react@18/umd/react.development.js";
// import "https://unpkg.com/react-dom@18/umd/react-dom.development.js";
import React from "react";

const App = () => {
    return React.createElement("h1", {id: 'hello', className: 'class1'}, 'Hello in header');
}


ReactDOM.render(React.createElement(App), document.getElementById('root'));