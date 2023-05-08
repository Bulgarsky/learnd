import React, {useState} from 'react';
import {Button} from "react-bootstrap";

import "../../css/card.css"
import {AppContext} from "../../App";

const FavoriteItem = (props) => {

    const context = React.useContext(AppContext);
    const [added, setAdded] = useState(false);

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

    const  onDelete=()=> {
        props.onDeleteFavorite(props.id)
    }
    console.log('карточки Избранное');

    return (
        <div className="card">
            <div>
                <Button className='addFavorite' variant='warning'
                        onClick={onDelete}>
                    X
                </Button>
                <br/>
                <br/>
                <h5>{props.title} {' '}</h5>
                <div class="card-img-box">
                    <img class="card-img"
                         alt="fav img card"
                         src={props.img}/>
                </div>
                <p class="card-description">
                    {props.description}
                </p>
                <p>
                    <strong>Цена: </strong> {props.price} {' '}
                </p>
                <Button className='addBasket' variant='outline-dark'
                        onClick={onClickAdd}>
                    {added
                        ?
                        <img width={13}
                             src={added ? '/img/icons/checked.png' : ''}
                             alt="fav img" />
                        :
                        'Добавить в корзину'
                    }
                </Button>
            </div>
        </div>
    );
};

export default FavoriteItem;