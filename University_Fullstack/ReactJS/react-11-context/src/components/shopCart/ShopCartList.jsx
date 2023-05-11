import React from "react";
import ShopCartItem from "./ShopCartItem"
import {useForm} from "react-hook-form";
import axios from "axios";

import "../../css/ShopCart.css";

const ShopCartList = (props) => {
    const {
        register,
        handleSubmit,
        watch,
        formState} = useForm();

    //отправить данные в Orders
    const onSubmit = (data) => {
        axios.post('https://6458d9b88badff578efca99e.mockapi.io/Orders', data);
    }

    //Методы обработки данных ?

    console.log("-> рендер лист Корзины");

    return (
        <div className="basket-card-container">
            <div>
                {props.overlayProps.length >0 ?
                    <div>
                        <form onSubmit={handleSubmit(onSubmit)}>
                        <div className='row'>
                            <div className='col-md-8 offset-md-1'>
                                <h4>Информация о заказе:</h4>
                                <p>Итого: {props.totalPrice}</p>
                                <button type='submit' className='w-30 btn btn-lg btn-primary'>Оформить заказ</button>
                                <br/><br/><hr/>
                                <br/>
                                <h3>Корзина:</h3>
                                <div className="basket-card-box">
                                    {props.overlayProps.map(obj => {
                                        // методы получения данных с каждого элемента ?
                                        return (
                                            <ShopCartItem
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
                        </div>
                        </form>

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

export default ShopCartList;