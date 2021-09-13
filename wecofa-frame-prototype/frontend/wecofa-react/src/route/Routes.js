import React from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import {Navbar} from 'react-bootstrap';


import TopMenuComponent from "../components/TopMenuComponent";
import Login from "../login/Login";
import SignIn from "../login/SignIn";
function Routes (){
    let isAuthorized = sessionStorage.getItem("isAuthorized");

    return (
        <div>
            {/*{!isAuthorized ? <Redirect to="/login"/> : <Redirect to="/"/>}*/}
            {!isAuthorized ? <Navbar
                bg="dark"
                variant="dark"
                className="mb-4">
                <Navbar.Brand href='/login'>Login</Navbar.Brand>
            </Navbar>:  <TopMenuComponent/>}
            <Switch>
                <Router>
                    {/*<Route exact path="/">
                        {!isAuthorized ?  <Login /> :<Home/>}
                    </Route>*/}
                    <Route exact path="/login">
                        <Login />
                    </Route>
                    <Route path="/sign">
                        <SignIn />
                    </Route>
                </Router>
            </Switch>
        </div>
    );
}
export default Routes;