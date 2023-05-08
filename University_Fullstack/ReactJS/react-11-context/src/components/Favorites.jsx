import React from 'react';
import FavoriteList from "./favorite/FavoriteList";

const Favorites = (props) => {

    console.log('компонент Избранное');

    return (
        <div>
            <FavoriteList
                favorites={props.favorites}
                setFavorites={props.setFavorites}
                item={props.products}
                overlayItems={props.overlayItems}
                setOverlayItems={props.setOverlayItems}
            />
        </div>
    );
};

export default Favorites;