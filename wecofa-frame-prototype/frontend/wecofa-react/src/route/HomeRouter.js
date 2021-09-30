import {Route, Switch} from "react-router-dom";
import Home from "../components/HomeComponent";
import Main from "../components/MainComponent";
import Board from "../components/BoardComponent";
import React from "react";

function HomeRouter() {
    return(
        <Switch>
            <Route exact path='/' component={Home}></Route>
            <Route path='/home' component={Home}></Route>
            <Route path='/main' component={Main}></Route>
            <Route path='/board' component={Board}></Route>
        </Switch>
    );
}export default HomeRouter