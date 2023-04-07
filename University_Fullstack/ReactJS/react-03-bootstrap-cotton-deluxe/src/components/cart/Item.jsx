import React from 'react';
import {Badge, Button} from "react-bootstrap";

const Item = (props) => {
    return (
        <div className='container py-3'>
            <main>
                <div className='row row-cols-1 justify-content-evenly row-cols-md-3 row-cols-sm-2 text-center'>
                    <div className='col px-3 ry-3'>
                        <div className='md-6 rounded'>
                            <div className='card py-3 px-3'>
                                <h3>
                                    Philippus (Turkey) <Badge bg="warning">New</Badge>
                                </h3>
                                <img alt="img 1" className='card-img' src="./img/surgut/1.jpg" width={80}/>
                                <p>Philippus производит полотенца, халаты, набедренные повязки, группы пике и покрывал с оригинальным подходом к производству.</p>
                                <p>Цена: 800</p>
                                <Button className='addBasket' variant='warning'>
                                    Добавить в корзину
                                </Button>
                            </div>

                        </div>
                    </div>
                </div>
            </main>

        </div>
    );
};

export default Item;