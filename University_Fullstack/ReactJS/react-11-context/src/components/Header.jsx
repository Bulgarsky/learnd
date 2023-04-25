import React from 'react';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

import Button from 'react-bootstrap/Button';
import OverlayTrigger from 'react-bootstrap/OverlayTrigger';
import Popover from "react-bootstrap/Popover";
import {Spinner} from "react-bootstrap";
import {Link} from 'react-router-dom';

//rsc
const Header= () => {
    console.log("-> рендер HEADER");
    return (
        <div>
            <Navbar bg="dark" variant="dark">
                <Container>
                    <Navbar.Brand>
                        <Link to={'/'}>COTTON DELUXE</Link>
                    </Navbar.Brand>

                    <Nav className="me-auto">

                        <Nav.Link>
                            <Link to={'/feedback'}>Feedback us!</Link>  {' '}
                            <Spinner animation="grow" role="status" variant='warning' size="sm"/>
                        </Nav.Link>

                        <Nav.Link>
                            <Link to={'/products'}>Products</Link>
                        </Nav.Link>

                        <Nav.Link>
                            <Link to={'/favorites'}>Favorites</Link>
                        </Nav.Link>

                        <Nav.Link>
                            <Link to={'/cart'}>Cart</Link>
                        </Nav.Link>

                        <Nav.Link>
                            <Link to={'/desc'}>Description</Link>
                        </Nav.Link>
                    </Nav>

                    <Nav>
                        <OverlayTrigger trigger="click" placement="bottom" overlay={popup}>
                            <Button className='enter' variant={"outline-primary"} >
                            Sign in
                            </Button>
                        </OverlayTrigger>
                        {'  '}
                        <div>
                        <Button className='reg' variant={"outline-secondary"} >
                            Registration
                        </Button>
                        </div>
                    </Nav>
                </Container>
            </Navbar>
        </div>
    )
}
const popup = (
    <Popover id="popover-basic">
        <Popover.Header as="h3">
            <Spinner animation="border" role="status" variant='danger' size="sm"/> {'  '}
            Personal account</Popover.Header>
        <Popover.Body>
            This <strong>functionality</strong> has not yet been implemented.
        </Popover.Body>
    </Popover>
);
export default Header;