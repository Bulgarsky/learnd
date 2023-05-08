import React from 'react';
import OrderList from "./order/OrderList";

const Orders = () => {

    console.log('Компонент Orders');

    return (
        <div>
            <h2>
                Компонент Orders
            </h2>
            <div>
                <OrderList/>
            </div>
        </div>
    );
};

export default Orders;