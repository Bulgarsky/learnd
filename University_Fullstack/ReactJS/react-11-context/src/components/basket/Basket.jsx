import React from "react";
import {Spinner} from "react-bootstrap";
import ItemBasket from "./ItemBasket"


const Basket = (props) => {
        console.log("-> рендер Корзина");
    return (
        <div>
            <div class="card-container">
                {props.overlayProps.length >0 ?
                    <div>
                        <div className='row'>
                            <div className='col-md-8 offset-md-1'>
                                <h4>Информация о заказе:</h4>
                                <p>Итого: {props.totalPrice}</p>
                                <button type='button' className='w-30 btn btn-lg btn-primary'>Оформить заказ</button>
                            <hr/>
                                <h3>Корзина:</h3>
                            </div>
                        </div>
                        <div class="card-box">
                            {props.overlayProps.map(obj => {
                                 return (
                                    <ItemBasket
                                        key={obj.id}
                                        id={obj.id}
                                        myId={obj.myId}
                                        title={obj.title}
                                        description={obj.description}
                                        price={obj.price}
                                        img={obj.img}
                                        deleteItems={props.deleteItems}
                                    />
                                )
                            })
                            }
                        </div>
                    </div>
                    :
                    <div className='row'>
                        <div className='col-md-8 offset-md-2'>
                            <h3>Ваша крозина пуста!</h3>
                        </div>
                    </div>
                }

            </div>
        </div>
    );
};

export default Basket;