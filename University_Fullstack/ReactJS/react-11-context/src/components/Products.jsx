import React from 'react';
import ProductCard from "./cart/productCard";



const Products = (props) => {
    console.log("-> рендер продукты");
    return (
        <div >
           <ProductCard
               item={props.item}
               overalayItems={props.overlayItems}
               setOverlayItems={props.setOverlayItems}
               favorites={props.favorites}
               setFavorites={props.setFavorites}
           />
        </div>
    );
};

export default Products;