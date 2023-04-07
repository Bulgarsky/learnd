import React from 'react';
import {Spinner} from "react-bootstrap";

const Cart = () => {
    console.log("Переход в корзину");
    return (
        <div>
            Cart<br/>
        <br/>
            <Spinner animation="border" role="status" size="md" variant="danger" /> Work in progress ...
        </div>
    );
};

export default Cart;