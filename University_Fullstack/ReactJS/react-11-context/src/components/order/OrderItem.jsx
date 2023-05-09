import React from 'react';

import "../../css/order.css"

const OrderItem = () => {

    console.log("карточки Order")

    return (
            <div className="order-list">
                <h3>История заказов:</h3>
                <p>Дописать вывод заказов для компонента</p>
                <hr/>
                <br/>
                <div id="order-box-shadow">
                    <div className="order-product-list-column">

                        <div className="order-product-box-column">
                            <div className="order-product-box-row" id="order-no">
                                <h5>Заказ от: день месяц год</h5>
                                <h7>номер заказа (ссылка)</h7>
                            </div>
                            <div className="order-product-box-row" id="order-body">
                                {/*маппинг*/}
                                <hr/>
                                <div className="order-product">
                                    <div className="order-product-box-row">
                                        <div className="order-product-card">
                                            <div  className="order-product-card-item">
                                                <div className="order-product-card-img-box">
                                                    <img className="order-product-card-img"
                                                         alt="order product img"
                                                         src=""
                                                    />
                                                </div>
                                            </div>
                                            <div className="order-product-card-item">
                                                <p>Наименование товара</p>
                                            </div>
                                            <div className="order-product-card-item">
                                                <p>Описание товара</p>
                                            </div>
                                            <div  className="order-product-card-item">
                                                <p>Кол-во </p>
                                            </div>
                                            <div  className="order-product-card-item">
                                                <p>Цена </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                {/*удалить тестовый блок ниже*/}
                                <hr/>
                                <div className="order-product">
                                    <div className="order-product-box-row">
                                        <div className="order-product-card">
                                            <div  className="order-product-card-item">
                                                <div className="order-product-card-img-box">
                                                    <img className="order-product-card-img"
                                                         alt="order product img"
                                                         src=""
                                                    />
                                                </div>
                                            </div>
                                            <div className="order-product-card-item">
                                                <p>Наименование товара</p>
                                            </div>
                                            <div className="order-product-card-item">
                                                <p>Описание товара</p>
                                            </div>
                                            <div  className="order-product-card-item">
                                                <p>Кол-во </p>
                                            </div>
                                            <div  className="order-product-card-item">
                                                <p>Цена </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>
            </div>

    );
};

export default OrderItem;