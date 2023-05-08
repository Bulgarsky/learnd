import React from 'react';
import {Badge, Button} from "react-bootstrap";

const ItemBasket = (props) => {
    return (
        <div class="card card-basket">
            <div>
            <h5>{props.title}</h5>
            <img class="card-img"
                 src={props.img}/>
            <br/>
                <p className="card-description">{props.description}</p>
                <p><strong>Цена: </strong> {props.price}</p>
            <Button className='addBasket' variant='outline-dark'
                    onClick={()=>props.deleteItems(props.id)}>
                Удалить
            </Button>

            </div>
        </div>
    );
};

export default ItemBasket;