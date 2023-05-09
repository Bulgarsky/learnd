import React from 'react';
import ShopCartList from "./shopCart/ShopCartList";

const ShoppingCart = (props) => {
    console.log('Компонент Корзина');
    return (
        <div>
            <ShopCartList
                totalPrice={props.totalPrice}
                overlayProps={props.overlayProps}
                deleteItems={props.deleteItems}
            />
        </div>
    );
};

export default ShoppingCart;