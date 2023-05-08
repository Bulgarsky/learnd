import React, {useState} from 'react';
import {AppContext} from "../../App";
import {Badge, Button} from "react-bootstrap";

const FavoriteItem = (props) => {
    //const context = React.useContext(AppContext);
    const [added, setAdded] = useState(false);

    const onClickAdd=()=>{
        setAdded(!added);
        let id = props.id;
        let myId = props.myId;
        let title = props.title;
        let description = props.description;
        let price = props.price;
        let img = props.img;
        props.onBasket({title, description, price, img, id, myId});
    }

    const  onDelete=()=> {
        props.onDeleteFavorite(props.id)
    }

    return (
        <div className="card">
            <div>
                <Button className='addFavorite' variant='warning'
                        onClick={onDelete}>
                    X
                </Button>
                <br/>
                <br/>
                <h5>{props.title} {' '}
                    {/*<Badge bg="dark">*/}
                    {/*    <span className="card-badge-span">Новинка!</span>*/}
                    {/*</Badge>*/}
                </h5>
                <img class="card-img" alt="img card" src={props.img} />
                <p class="card-description">{props.description}</p>
                <p><strong>Цена: </strong> {props.price} {' '}
                    {/*<Badge bg="danger" width={20}>*/}
                    {/*    <span className="card-badge-span">Скидка за комплект!</span>*/}
                    {/*</Badge>*/}
                </p>
                <Button className='addBasket' variant='outline-dark'
                        onClick={onClickAdd}>
                    {added
                        ?
                        <img width={13}
                             src={added ? '/img/icons/checked.png' : ''}
                             alt="" />
                        :
                        'Добавить в корзину'
                    }
                </Button>
            </div>
        </div>
    );
};

export default FavoriteItem;