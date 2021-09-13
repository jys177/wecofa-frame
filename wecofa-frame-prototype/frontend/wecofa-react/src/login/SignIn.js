import React, {useState} from 'react'
import {Button, Form} from "react-bootstrap";
import axios from "axios";
import {useHistory} from "react-router-dom";


function SignIn() {

    const history = useHistory();
    const [userId,setUserId] = useState('')
    const [userPw,setUserPw] = useState('')
    const [userPwChk,setUserPwChk] = useState('')
    const [userName,setUserName] = useState('')
    const [birthDate,setBirthDate] = useState('')
    const [sex,setSex] = useState('')
    const [telephone,setTelephone] = useState('')
    const handleUserId = (e)=>{
        setUserId(e.target.value)
    }
    const handleUserPw = (e)=>{
        setUserPw(e.target.value)
    }
    const handleUserPwChk = (e)=>{
        setUserPwChk(e.target.value)
    }
    const handleUserName = (e)=>{
        setUserName(e.target.value)
    }
    const handleBirthDate = (e)=>{
        setBirthDate(e.target.value)
    }
    const handleSex = (e)=>{
        setSex(e.target.value)
    }
    const handleTelephone = (e)=>{
        setTelephone(e.target.value)
    }
    const goBack = () => {
        history.goBack();
    };

    const onClickSignIn=()=>{
        console.log('click login')
        axios.post('/user_inform/signIn',null,{
            params:{
                'userId':userId,
                'userPw':userPw,
                'userName':userName,
                'birthDate':birthDate,
                'sex':sex,
                'telephone':telephone
            }
        }).then(res=>console.log(res))
            .catch()
    }


    return(
        <div>
            <h2>회원가입</h2>
            <Form className="sign-form">
                <div className="d-grid gap-2">
                    <Form.Group className="mb-3" controlId="userId">
                        <Form.Control type="email" placeholder="이메일 주소" value={userId} onChange={handleUserId}/>
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="userPw">
                        <Form.Control type="password" placeholder="비밀번호" value={userPw} onChange={handleUserPw}/>
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="loginPwChk">
                        <Form.Control type="password" placeholder="비밀번호 확인" value={userPwChk} onChange={handleUserPwChk}/>
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="userName">
                        <Form.Control type="text" placeholder="이름" value={userName} onChange={handleUserName}/>
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="birthDate">
                        <Form.Control type="text" placeholder="생년월일" value={birthDate} onChange={handleBirthDate}/>
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="sex">
                        <Form.Control as="select" onChange={handleSex} >
                            <option>성별</option>
                            <option value="M">남자</option>
                            <option value="F">여자</option>
                        </Form.Control>
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="telephone">
                        <Form.Control type="text" placeholder="휴대전화" value={telephone} onChange={handleTelephone}/>
                    </Form.Group>
                    <Button className="mb-1" variant="primary" type="submit" onClick={onClickSignIn}>
                        가입하기
                    </Button>
                    <Button className="mb-1" variant="secondary" type="button" onClick={goBack}>
                        뒤로가기
                    </Button>
                </div>
             </Form>
        </div>
    );
}export default SignIn;