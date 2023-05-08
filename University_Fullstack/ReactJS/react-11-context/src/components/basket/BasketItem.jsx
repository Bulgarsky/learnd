import React from 'react';
import {Button} from "react-bootstrap";

import "../../css/basket.css"

const BasketItem = (props) => {

    console.log('карточки Корзины');

    return (
        <div class="basket-card">
            <h5> {props.title}</h5>
                <div class="basket-img-box">
                    <img class="basket-card-img"
                         alt="basket card img"
                         src={props.img}/>
                </div>
                <p class="basket-card-description">{props.description}</p>
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

export default BasketItem;