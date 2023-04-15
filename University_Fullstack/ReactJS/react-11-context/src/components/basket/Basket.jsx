import React from "react";
import {Spinner} from "react-bootstrap";
import ItemBasket from "./ItemBasket"


const Basket = (props) => {
        console.log("-> рендер Корзина");
    return (
        <div style={{margin: "50px", padding: "50px"}}>
            <div>
                {props.overlayProps.length >0 ?
                    <div>
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
                    : <h1>Корзина пустая</h1>
                }
                <div className='row'>
                    <div className='col-md-8 offset-md-2'>
                        <p>Итого:</p>
                        <p>{props.totalPrice}</p>
                        <button type='button' className='w-30 btn btn-lg btn-primary'>Заказать</button>

                    </div>
                </div>
            </div>
        </div>
    );
};

export default Basket;