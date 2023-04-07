import React from 'react';
import {Badge, Button} from "react-bootstrap";

const ProductCard = () => {
    return (
        <div className='container py-3'>
            <div className='row row-cols-1 justify-content-evenly row-cols-md-3 row-cols-sm-2 text-center'>
                <div className='col px-3 ry-3'>
                    <div className='md-6 rounded'>
                        <div className='card py-3 px-3'>
                            <h5>Полотенца Philippus {' '}
                                <Badge bg="dark">Новинка</Badge>
                            </h5>
                            <img alt="img 2" src="./img/surgut/2.jpg" width="auto"/>

                            <p><strong>Philippus</strong> производит полотенца, халаты, набедренные повязки, группы пике и покрывал с оригинальным подходом к производству.</p>

                            <p><strong>Цена: </strong> 1000 {' '}
                            <Badge bg="danger" width={20}>Скидка за комплект!</Badge>
                            </p>

                            <Button className='addBasket' variant='outline-dark'>
                                Добавить в корзину
                            </Button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default ProductCard;