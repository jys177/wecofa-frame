import {Route} from "react-router-dom";
import Home from "../components/HomeComponent";
import Main from "../components/MainComponent";
import Board from "../components/BoardComponent";
import React from "react";

function HomeRouter() {
    return(
        <div>
            <Route exact path='/home' component={Home}></Route>
            <Route path='/home/home' component={Home}></Route>
            <Route path='/home/main' component={Main}></Route>
            <Route path='/home/board' component={Board}></Route>
        </div>
    );
}export default HomeRouter