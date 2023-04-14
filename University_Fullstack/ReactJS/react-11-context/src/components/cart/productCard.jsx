import React from 'react';
import Item from "./Item";
import axios from 'axios';

const ProductCard = (props) => {
    console.log("JSON -> CardInfo");

    const onAddOverlay = async (obj) => {
        try{
           const findOverlay = props.overalayItems.find(objOver => objOver.myId === obj.myId);
           if(findOverlay) {
               //await ?
               // eslint-disable-next-line no-template-curly-in-string
               await axios.delete('https://64399fea90cd4ba563eae64a.mockapi.io/Cart/${findOverlay.id}');
               props.setOverlayItems((over) => over.filter(o => o.myId !== obj.myId))
           }else{
               const {data} = await axios.post('https://64399fea90cd4ba563eae64a.mockapi.io/Cart', obj);
               props.setOverlayItems([...props.overalayItems, data]);
           }
        }
        catch {
            alert("Произошла ошибка при добавлении в корзину");
        }
    }

    const onAddFavorite = async  (obj) => {
        try{
            const findFavorites = props.favorites.find(objFav => objFav.myId === obj.myId);
            if(findFavorites) {
                //await ?
                // eslint-disable-next-line no-template-curly-in-string
                await axios.delete('https://64399fea90cd4ba563eae64a.mockapi.io/Favorites/${findFavorites.id}');
                props.setFavorites((over) => over.filter(o => o.myId !== obj.myId))
            }else{
                const {data} = await axios.post('https://64399fea90cd4ba563eae64a.mockapi.io/Favorites', obj);
                props.setFavorites([...props.favorites, data]);
            }
        }
        catch {
            alert("Произошла ошибка при добавлении в избранное");
        }
    }

    return (
        <div className='container py-3'>
            {
            props.item.map(obj => {
                return <Item
                    key={obj.id}
                    id={obj.id}
                    myId={obj.myId}
                    title={obj.title}
                    description={obj.description}
                    price={obj.price}
                    img={obj.img}

                    favoriteBtn ={(favObj)=>onAddFavorite(favObj)}

                    onBasket={(cartObj)=>onAddOverlay(cartObj)}
                    />
                })
            }
        </div>
    );
};

export default ProductCard;