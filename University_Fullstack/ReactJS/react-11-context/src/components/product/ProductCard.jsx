import React, {useState} from 'react';
import {Button} from "react-bootstrap";
import {AppContext} from '../../App';

import "../../css/product_card.css"

const ProductCard = (props) => {
    const context = React.useContext(AppContext);

    const [added, setAdded] = useState(context.isAdded);
    const [favorites, setFavorites] = useState(false);

    const onClickFavorite=()=>{
        setFavorites(!favorites);
        let id = props.id;
        let myId = props.myId;
        let title = props.title;
        let description = props.description;
        let price = props.price;
        let img = props.img;
        props.onAddFavorite({title, description, price, img, id, myId});
    }

    const onClickAdd=()=>{
        setAdded(!added);
        let id = props.id;
        let myId = props.myId;
        let title = props.title;
        let description = props.description;
        let price = props.price;
        let img = props.img;
        props.onAddBasket({title, description, price, img, id, myId});
    }

    console.log('карточки Product');

    return (

    <div class="card">
        {
            context.isFavorite(props.myId) === true ?
                <Button className='addFavorite' variant='warning'
                        onClick={onClickFavorite}>
                    Уже в избранном
                </Button>
                :
                <Button className='addFavorite' variant='warning'
                        onClick={onClickFavorite}>
                    Добавить в избранное
                </Button>
        }
        <br/>
        <h5>{props.title} {' '}</h5>
            <div class="card-img-box">
                <img className="card-img" alt="img card" src={props.img}/>
            </div>

        <p class="card-description">{props.description}</p>
        <p><strong>Цена: </strong> {props.price} {' '}
        </p>

        <Button className='addBasket' variant='outline-dark'
                onClick={onClickAdd}>
            {context.isAdded(props.myId)
                ?
                <img width={13}
                     src={context.isAdded(props.myId) ? '/img/icons/checked.png' : ''}
                     alt="" />
                :
                'Добавить в корзину'
            }
        </Button>

    </div>


    );
};

export default ProductCard;