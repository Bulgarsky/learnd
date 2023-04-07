
import React from 'react';
import CartItem from "./cart/CartItem";
import Slider from "./Slider";

const Home = () => {
    console.log("переход на главную (слайдер)");
    return (
        <div>
           <Slider/>
        </div>
    );
};

export default Home;