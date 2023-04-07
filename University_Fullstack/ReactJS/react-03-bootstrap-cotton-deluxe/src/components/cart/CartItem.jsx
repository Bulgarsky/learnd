import React from 'react';
import Item from "./Item";

const CartItem = (props) => {
    return (
        <div>
            {
            props.item.map(obj => {
                return <Item
                    key={obj.id}
                    id={obj.id}
                    myid={obj.myid}
                    title={obj.title}
                    description={obj.description}
                    img={obj.img}
                    />
                })
        }
        </div>
    );
};

export default CartItem;