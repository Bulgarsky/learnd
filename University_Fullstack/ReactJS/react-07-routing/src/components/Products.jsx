import React from 'react';
import CartItem from "./cart/CartItem";


const Products = (props) => {
    console.log("переход в продукты");
    return (
        <div>
           <CartItem item={props.item} />
        </div>
    );
};

export default Products;