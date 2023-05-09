import React from 'react';
import OrderList from "./order/OrderList";

const Orders = () => {

    console.log('Компонент Orders');

    return (
        <div>
            <div>
                <OrderList/>
            </div>
        </div>
    );
};

export default Orders;