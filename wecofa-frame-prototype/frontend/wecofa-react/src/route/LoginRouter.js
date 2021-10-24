import {Route} from "react-router-dom";
import Login from "../login/Login";
import SignIn from "../login/SignIn";
import React from "react";

function LoginRouter() {
    return(
        <div>
            <Route exact path="/" component={Login} />
            <Route path="/login" component={Login} />
            <Route path="/sign" component={SignIn} />
        </div>
    );
}export default LoginRouter