import React,{useState, useEffect} from "react";
import axios from 'axios';

function Main(){

    let[message,setMessage] = useState('');

    function hookMessage(str){
        setMessage(str);
    }

    useEffect(
        ()=>{
        axios({
            url:'/main/hello.do',
            method:'GET'
        }).then(res=>{
            hookMessage(res.data.message);
        })
    },[]
    );
    return(
        <div>
            메세지 : {message}
        </div>
    );
}

export default Main