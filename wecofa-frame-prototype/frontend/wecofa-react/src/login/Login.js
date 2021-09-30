import React,{useState,useEffect} from "react";
import {Button, Form} from 'react-bootstrap';
import axios from "axios";
import {useHistory} from "react-router-dom";

function Login(){
    const [inputId,setInputId] = useState('')
    const [inputPw,setInputPw] = useState('')
    const history = useHistory();
    const handleInputId = (e)=>{
        setInputId(e.target.value)
    }
    const handleInputPw = (e)=>{
        setInputPw(e.target.value)
    }
    const onClickLogin=()=>{
        console.log('click login')
        axios.post('/users/login_user',null,{
            headers:{
                "Content-Type": `application/json`
            },
            params:{
                'userId':inputId,
                'userPw':inputPw
            }
        }).then(res=>console.log(res))
            .catch()
    }

    useEffect(()=>{
        axios.get('/users/user')
            .then(res=> console.log(res))
            .catch()
    },[])
    return(
      <div>
          <h2>Login Page</h2>
          <div className="login-form">
              <Form>
                  <div className="d-grid gap-2">
                      <Form.Group className="mb-3" controlId="loginId">
                          <Form.Control type="id" placeholder="이메일 주소" value={inputId} onChange={handleInputId}/>
                      </Form.Group>
                      <Form.Group className="mb-3" controlId="loginPw">
                          <Form.Control type="password" placeholder="비밀번호" value={inputPw} onChange={handleInputPw}/>
                      </Form.Group>
                      <Button className="mb-1" variant="primary" type="submit" onClick={onClickLogin}>
                          로그인
                      </Button>{' '}
                      <Button className="mb-1" variant="secondary" type="button" onClick={() => history.push('/sign')}>
                          회원가입
                      </Button>
                  </div>
              </Form>
          </div>
      </div>
    );
}
export default Login;