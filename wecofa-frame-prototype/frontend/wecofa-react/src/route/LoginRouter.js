import {Route} from "react-router-dom";
import Login from "../login/Login";
import SignIn from "../login/SignIn";
import Switch from "react-bootstrap/Switch";
import React from "react";

function LoginRouter() {
    return(
        <Switch>
            <Route exact path="/" component={Login} />
            <Route path="/login" component={Login} />
            <Route path="/sign" component={SignIn} />

        </Switch>
    );
}export default LoginRouter