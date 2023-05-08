import React from "react";
import ItemBasket from "./ItemBasket"
import {useForm} from "react-hook-form";
import axios from "axios";


const Basket = (props) => {
    const {register, handleSubmit, watch, formState} = useForm();
        console.log("-> рендер Корзина");

        const onSubmit = (data) => {
            axios.post('https://6458d9b88badff578efca99e.mockapi.io/Orders', data);
        }

    return (
        <div>
            <div class="card-container">
                {props.overlayProps.length >0 ?
                    <div>
                        <form onSubmit={handleSubmit(onSubmit)}>
                        <div className='row'>
                            <div className='col-md-8 offset-md-1'>
                                <h4>Информация о заказе:</h4>
                                <p>Итого: {props.totalPrice}</p>
                                <button type='submit' className='w-30 btn btn-lg btn-primary'>Оформить заказ</button>
                            <hr/>
                                <h3>Корзина:</h3>
                            </div>
                        </div>
                        <div class="card-box">
                            {props.overlayProps.map(obj => {
                                // ВЗЯТЬ ДАННЫЕ КАЖДОГО ТОВАРА И ПЕРЕДАТЬ В ФОРМУ
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

export default Basket;