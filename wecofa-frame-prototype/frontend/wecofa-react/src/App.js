import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'
import './App.css';
import {BrowserRouter} from "react-router-dom";

import LoginRouter from "./route/LoginRouter";
import HomeMenu from "./menu/HomeMenu";
import HomeRouter from "./route/HomeRouter";

function App() {
  return (
    <div className="App">
        <BrowserRouter>
            <header>
                <HomeMenu/>
            </header>
            <body>
                <switch>
                    <LoginRouter/>
                    <HomeRouter/>
                </switch>

            </body>
        </BrowserRouter>
    </div>
  );
}
export default App;
