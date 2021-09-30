import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'
import './App.css';
import {BrowserRouter} from "react-router-dom";
import LoginMenu from "./menu/LoginMenu";
import LoginRouter from "./route/LoginRouter";
import TopMenu from "./menu/TopMenu";
import HomeRouter from "./route/HomeRouter";

function App() {
    let isAuthorized = sessionStorage.getItem("isAuthorized");
  return (
    <div className="App">
        <BrowserRouter>
            <header>
                {!isAuthorized?<LoginMenu/>:<TopMenu/>}
            </header>
            <body>
                {!isAuthorized?<LoginRouter/>:<HomeRouter/>}
            </body>
        </BrowserRouter>
    </div>
  );
}
export default App;
