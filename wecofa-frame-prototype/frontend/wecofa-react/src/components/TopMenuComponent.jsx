import React,{Component} from 'react';
import {Navbar} from 'react-bootstrap';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';

import Home from './HomeComponent';
import Board from './BoardComponent';
import Main from './MainComponent';

class TopMenuComponent extends Component{
    render(){
        return(
            <Router>
                
                <Navbar 
                bg="dark"
                variant="dark"
                className="mb-4">
                    <Navbar.Brand href='/'>HOME</Navbar.Brand>
                    <Navbar.Brand href='/main'>MAIN</Navbar.Brand>
                    <Navbar.Brand href='/board'>BOARD</Navbar.Brand>
                </Navbar>
                <Switch>
                    <Route exact path='/' component={Home}></Route>
                    <Route path='/main' component={Main}></Route>
                    <Route path='/board' component={Board}></Route>
                </Switch>
            </Router>

        )
    }
}
export default TopMenuComponent;