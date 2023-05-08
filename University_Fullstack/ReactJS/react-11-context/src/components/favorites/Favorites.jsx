import React from 'react';
import axios from "axios";
import {AppContext} from "../../App"
import FavoriteItem from "./favoriteItem";

const Favorites = (props) => {
    console.log("->рендер избранное");

    const context = React.useContext(AppContext);
    const onAddOverlay = (obj) => {
        axios.post('https://64399fea90cd4ba563eae64a.mockapi.io/Cart', obj);
        context.setOverlayItems([...props.overlayItems, obj]);
    }

    const onDeleteFavorite = (id) => {
        axios.delete(`https://64399fea90cd4ba563eae64a.mockapi.io/Favorites/${id}`);
        props.setFavorites((favorites)=> favorites.filter(item => item.id !== id));
    }

    return (
        <div className="card-container">
        <h2>Your Favorites:</h2>
        <div class="card-box" >
            {
                props.favorites.map(obj => {
                    return (
                    <FavoriteItem
                        key={obj.id}
                        id={obj.id}
                        myId={obj.myId}
                        title={obj.title}
                        description={obj.description}
                        price={obj.price}
                        img={obj.img}

                        onDeleteFavorite={(id)=> {onDeleteFavorite(id)}}

                        onBasket={(cartObj) => {onAddOverlay(cartObj)}}
                    />
                )
                })
            }

        </div>
        </div>
    );
};

export default Favorites;