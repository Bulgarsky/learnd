
import React from 'react';
import ProductCard from "./cart/productCard";
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