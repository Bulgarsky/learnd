import React from 'react';
import {Spinner} from "react-bootstrap";

const Favorites = () => {
    console.log("переход в избранное");
    return (
        <div>
            Favorites<br/>
            <br/>
            <Spinner animation="border" role="status" size="md" variant="danger" /> Work in progress ...
        </div>
    );
};

export default Favorites;