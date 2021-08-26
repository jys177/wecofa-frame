import React from 'react';
import logo from '../logo.svg';

function Home(){
    return(
        <div className='home'>
            <div>HOME</div>
            <div><img src={logo} alt='profile'/></div>
        </div>
        
    );
}
export default Home;