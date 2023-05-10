import React from 'react';
import {Button} from "react-bootstrap";

import "../../css/ShopCart.css"

const ShopCartItem = (props) => {

    console.log('карточки Корзины');

    return (
        <div className="basket-card">
            <h5> {props.title}</h5>
                <div className="basket-img-box">
                    <img className="basket-card-img"
                         alt="basket card img"
                         src={props.img}/>
                </div>
                <p className="basket-card-description">{props.description}</p>
                <p>
                    <strong>Цена: </strong> {props.price}
                </p>
            <Button className='addBasket' variant='outline-dark'
                    onClick={()=>props.deleteItems(props.id)}>
                Удалить
            </Button>
        </div>

    );
};

export default ShopCartItem;