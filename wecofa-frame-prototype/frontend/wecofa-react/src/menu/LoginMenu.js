import React from 'react';
import {Navbar} from 'react-bootstrap';

function LoginMenu (){

    return (
        <div>
            <Navbar
                bg="dark"
                variant="dark"
                className="mb-4">
                <Navbar.Brand href='/login'>Login</Navbar.Brand>
                <Navbar.Brand href='/sign'>Sign In</Navbar.Brand>
            </Navbar>
        </div>
    );
}
export default LoginMenu;