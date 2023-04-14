import Carousel from 'react-bootstrap/Carousel';
import React from 'react';
import {Badge} from "react-bootstrap";

function Slider() {
    console.log("-> рендер слайдера");
    return (
        <div>
        <Carousel>
            <Carousel.Item interval={1000}>
                <img
                    className="d-block w-100"
                    src="./img/surgut/1.jpg"
                    alt="First slide"
                />
                <Carousel.Caption>
                    <h3>Полотенца Philippus <Badge bg="dark" text="light">New</Badge>
                    </h3>
                    <p>Даже самый взыскательный покупатель будет приятно удивлен мягкостью и долговечностью данных полотенец.

                    </p>
                </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item interval={5000}>
                <img  height={800}
                    className="d-block w-100"
                    src="./img/surgut/2.jpg"
                    alt="Second slide"
                />
                <Carousel.Caption>
                    <h3>Полотенца Philippus <Badge bg="light" text='dark'>New</Badge></h3>
                    <p>Решили перейти на штучный формат, вместо большой упаковки, так как он более востребован. .</p>
                </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item interval={5000}>
                <img height={800}
                    className="d-block w-100"
                    src="./img/surgut/3.jpg"
                    alt="Third slide"
                />
                <Carousel.Caption>
                    <h3>Полотенца для кухни Green Black <Badge bg="danger" text='light'>New</Badge> </h3>
                    <p>
                        В мае ожидаем поступление нового ассортимента.
                    </p>
                </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item interval={5000}>
                <img height={800}
                    className="d-block w-100"
                    src="./img/surgut/4.jpg"
                    alt="Four slide"
                />
                <Carousel.Caption>
                    <h3>Philippus Lux Cotton <Badge bg="primary" text='light'>New</Badge></h3>
                    <p>
                        Philippus производит полотенца, халаты, набедренные повязки, группы пике и покрывал с оригинальным подходом к производству.
                    </p>
                </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item interval={5000}>
                <img height={800}
                     className="d-block w-100"
                     src="./img/surgut/5.jpg"
                     alt="Four slide"
                />
                <Carousel.Caption>
                    <h3>Качество упаковки <Badge bg="light" text='dark'>package</Badge></h3>
                    <p>
                        На фото полотенца Cestepe 70x140 упакованы в качественные ZIP пакеты, которые сохраняют форму и не мнутся. Имеют воздушный клапан, пакет герметичен, туда не попадает влага а полотенца дышат.
                    </p>
                </Carousel.Caption>
            </Carousel.Item>
        </Carousel>
        </div>
    );
}

export default Slider;