import {Navbar} from "react-bootstrap";
import React from "react";

function TopMenu() {
    return(
        <div>
            <Navbar
                bg="dark"
                variant="dark"
                className="mb-4">
                <Navbar.Brand href='/'>HOME</Navbar.Brand>
                <Navbar.Brand href='/main'>MAIN</Navbar.Brand>
                <Navbar.Brand href='/board'>BOARD</Navbar.Brand>
            </Navbar>
        </div>
    );
}export default TopMenu