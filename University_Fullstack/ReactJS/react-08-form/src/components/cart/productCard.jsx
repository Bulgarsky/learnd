import React from 'react';
import Item from "./Item";

const ProductCard = (props) => {
    console.log("JSON -> CardInfo");
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
                    />
                })
            }
        </div>
    );
};

export default ProductCard;