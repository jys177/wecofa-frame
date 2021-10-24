import {Navbar} from "react-bootstrap";
import React from "react";

function HomeMenu() {
    return(
        <div>
            <Navbar
                bg="dark"
                variant="dark"
                className="mb-4">
                <Navbar.Brand href='/home/home'>HOME</Navbar.Brand>
                <Navbar.Brand href='/home/main'>MAIN</Navbar.Brand>
                <Navbar.Brand href='/home/board'>BOARD</Navbar.Brand>
            </Navbar>
        </div>
    );
}export default HomeMenu