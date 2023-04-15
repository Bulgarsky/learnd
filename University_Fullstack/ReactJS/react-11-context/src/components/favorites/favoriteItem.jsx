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
        <div>
            <div className='container py-3'>
                <div className='row row-cols-1 justify-content-evenly row-cols-md-3 row-cols-sm-2 text-center'>
                    <div className='col px-3 ry-3'>
                        <div className='md-6 rounded'>
                            <div className='card py-3 px-3'>

                                        <Button className='addFavorite' variant='warning'
                                                onClick={onDelete}>
                                            X
                                        </Button>


                                <h5>{props.title} {' '}
                                    <Badge bg="dark">Новинка</Badge>
                                </h5>
                                <img alt="img 2" src={props.img} width={'100%'}/>

                                <p>{props.description}</p>

                                <p><strong>Цена: </strong> {props.price} {' '}
                                    <Badge bg="danger" width={20}>Скидка за комплект!</Badge>
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
                    </div>
                </div>
            </div>
        </div>
    );
};

export default FavoriteItem;