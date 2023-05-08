import React from 'react';
import ProductList from "./product/ProductList";

const Products = (props) => {

    console.log("компонент Products");

    return (
        <div >
           <ProductList
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