import React from 'react';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

import Button from 'react-bootstrap/Button';
import OverlayTrigger from 'react-bootstrap/OverlayTrigger';
import Popover from "react-bootstrap/Popover";
import {NavDropdown, Spinner} from "react-bootstrap";

//rsc

const Header= () => {
    return (
        <div>
            <Navbar bg="dark" variant="dark">
                <Container>
                    <Navbar.Brand href="#home">COTTON DELUXE</Navbar.Brand>
                    <Nav className="me-auto">
                        <Nav.Link href="#Activities">Activity</Nav.Link>
                        <Nav.Link href="#products">Products</Nav.Link>
                        <NavDropdown
                            id="nav-dropdown-dark-example"
                            title="Documents"
                            menuVariant="dark"
                        >
                            <NavDropdown.Item href="#Prices">Prices</NavDropdown.Item>
                            <NavDropdown.Item href="#Media">Media about us</NavDropdown.Item>
                            <NavDropdown.Item href="#Presentations">Presentations</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item href="#Documents">Founding documents</NavDropdown.Item>
                        </NavDropdown>
                        <Nav.Link href="#Contact">Contact us {' '}
                            <Spinner animation="grow" role="status" variant='warning' size="sm"/>
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