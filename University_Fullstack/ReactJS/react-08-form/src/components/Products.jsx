import React from 'react';
import ProductCard from "./cart/productCard";


const Products = (props) => {
    console.log("-> рендер продукты");
    return (
        <div >
           <ProductCard item={props.item} />
        </div>
    );
};

export default Products;