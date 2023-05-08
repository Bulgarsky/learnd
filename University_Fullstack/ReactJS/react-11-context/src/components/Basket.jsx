import React from 'react';
import BasketList from "./basket/BasketList";

const Basket = (props) => {
    console.log('Компонент Корзина');
    return (
        <div>
            <BasketList
                totalPrice={props.totalPrice}
                overlayProps={props.overlayProps}
                deleteItems={props.deleteItems}
            />
        </div>
    );
};

export default Basket;