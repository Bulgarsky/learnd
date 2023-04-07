import React from 'react';
import {Spinner} from "react-bootstrap";

const Footer = () => {
    return (
        <div className="shadow">
            <div
                className="mx-auto py-4 flex-wrap"
                display="flex" width="80%" justifyContent="between" alignItems= "center" >

                <div display="flex" alignItems="center">
                    <a href="https://t.me/cotton_deluxe" rel="noreferrer" target="_blank" className="d-flex align-items-center p-0 text-dark">
                        <img
                            alt="deluxe logo"
                            src="./img/logo.jpg"
                            width="30px"
                        />
                        <span className="ms-4 h5 mb-0 font-weight-bold">Cotton Deluxe (г Сургут)</span>
                    </a>
                    <small className="ms-2">&copy; Cotton Deluxe, 2023. All rights reserved.</small><br/>
                    <small className="ms-2">&copy; Bulgarsky, 2023. All rights reserved.</small><br/>

                    <small className="ms-2">
                        <Spinner animation="border" role="status" size="sm">
                        <span className="visually-hidden">Loading...</span>
                        </Spinner> {' '}
                        Work in progress ...
                     </small>
                </div>
                <div display="flex">
                    <button flat color="dark" className="p-2">
                        <a href="https://github.com/bulgarsky" rel="noreferrer" target="_blank">
                        <img alt="github logo" src="./img/github.svg" width="30px"/>
                        </a>
                    </button>
                    <button flat color="dark" className="mx-3 p-2">
                        <a href="https://linkedin.com" rel="noreferrer" target="_blank">
                        <img alt="linkedin logo" src="./img/linkedin.png" width="30px"/>
                        </a>
                    </button>
                    <button flat color="dark" className="p-2">
                        <a href="https://twitter.com/bulgarsky"rel="noreferrer"  target="_blank">
                        <img alt="twitter logo" src="./img/twitter.png" width="30px"/>
                        </a>
                    </button>
                </div>
            </div>
        </div>
    );
};

export default Footer;