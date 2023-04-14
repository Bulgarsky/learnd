import React from "react";
import {Spinner} from "react-bootstrap";


const Basket = () => {
        console.log("-> рендер Корзина");
    return (
        <div style={{margin: "50px", padding: "50px"}}>
            Cart<br/>
            <br/>
            <Spinner animation="border" role="status" size="md" variant="danger" /> Work in progress ...
        </div>
    );
};

export default Basket;