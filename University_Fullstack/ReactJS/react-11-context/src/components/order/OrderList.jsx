import React from 'react';
import OrderItem from "./OrderItem";

import "../../css/order.css"

const OrderList = () => {
    return (
        <div>
            <div class="order-container">
                <div class="order-box">
                    <OrderItem/>
                </div>
            </div>
        </div>
    );
};

export default OrderList;