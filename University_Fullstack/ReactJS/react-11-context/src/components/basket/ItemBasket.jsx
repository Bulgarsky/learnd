import React from 'react';
import {Badge, Button} from "react-bootstrap";

const ItemBasket = (props) => {
    return (
        <div>
            <div className='container py-3'>
                <div className='row row-cols-1 justify-content-evenly row-cols-md-3 row-cols-sm-2 text-center'>
                    <div className='col px-3 ry-3'>
                        <div className='md-6 rounded'>
                            <div className='card py-3 px-3'>
                                <h5>{props.title}</h5>
                                <img className='rounded' width={'100%'}
                                       src={props.img}/><br/>
                            <br/>
                                <h6>Описание: {props.description}</h6>
                                <h5>
                                    <span>цена: {props.price}</span>
                                </h5>
                                <Button className='addBasket' variant='outline-dark'
                                        onClick={()=>props.deleteItems(props.id)}>
                                    X
                                </Button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default ItemBasket;