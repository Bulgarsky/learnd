import React from 'react';
import ProductCard from "./ProductCard";
import axios from 'axios';

import "../../css/product_card.css"
import {AppContext} from "../../App";

const ProductList = (props) => {
    console.log("JSON -> CardInfo");

    const onAddOverlay = async (obj) => {
        try{
           const findOverlay = props.overalayItems.find(objOver => objOver.myId === obj.myId);
           if(findOverlay) {
               //await ?
               await axios.delete(`https://64399fea90cd4ba563eae64a.mockapi.io/Cart/${findOverlay.id}`);
               props.setOverlayItems((over) => over.filter(o => o.myId !== obj.myId))
           }else{
               const {data} = await axios.post('https://64399fea90cd4ba563eae64a.mockapi.io/Cart', obj);
               props.setOverlayItems([...props.overalayItems, data]);
           }
        }
        catch {
            alert("Произошла ошибка при нажатии кнопки в Корзину");
        }
    }

    console.log('рендер листа Products');

    const onAddFavorite = async  (obj) => {
        try{
            const findFavorites = props.favorites.find(objFav => objFav.myId === obj.myId);
            if(findFavorites) {
                //await ?
                await axios.delete(`https://64399fea90cd4ba563eae64a.mockapi.io/Favorites/${findFavorites.id}`);
                props.setFavorites((over) => over.filter(o => o.myId !== obj.myId));
            }else{
                const {data} = await axios.post('https://64399fea90cd4ba563eae64a.mockapi.io/Favorites', obj);
                props.setFavorites([...props.favorites, data]);
            }
        }
        catch {
            alert("Произошла ошибка при нажатии кнопки Избранное");
        }
    }

    console.log(' -> рендер Продукт лист');

    return (
        <div className="card-container">
            <h3>Our products:</h3>
        <div className="card-box">
            {
            props.item.map(obj => {
                return <ProductCard
                    key={obj.id}
                    id={obj.id}
                    myId={obj.myId}
                    title={obj.title}
                    description={obj.description}
                    price={obj.price}
                    img={obj.img}

                    onAddFavorite ={(favObj)=>onAddFavorite(favObj)}

                    onAddBasket ={(cartObj)=>onAddOverlay(cartObj)}
                    />
                })
            }
        </div>
        </div>
    );
};

export default ProductList;