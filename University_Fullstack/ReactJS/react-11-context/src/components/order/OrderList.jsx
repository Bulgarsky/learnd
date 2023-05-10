import React from 'react';
import OrderItem from "./OrderItem";

import "../../css/order.css"

const OrderList = () => {
    return (
        <div>
            <div className="order-container">
                <div className="order-box">
                    <OrderItem/>
                </div>
            </div>
        </div>
    );
};

export default OrderList;