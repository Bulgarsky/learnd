import React from 'react';
import {Spinner} from "react-bootstrap";

const Favorites = () => {
    console.log("->рендер избранное");
    return (
        <div  style={{margin: "50px", padding: "50px"}}>
            Favorites<br/>
            <br/>
            <Spinner animation="border" role="status" size="md" variant="danger" /> Work in progress ...
        </div>
    );
};

export default Favorites;