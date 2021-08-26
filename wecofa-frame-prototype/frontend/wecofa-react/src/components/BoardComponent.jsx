import React, {useState} from "react";


function Board(){
    
    //title : state 변수, changeTitle : title setter method
    // state는 직접 수정할 수 없다.
    let [title,changeTitle] =useState(['남자 코트 추천','강남 우동 맛집','국힙 노래 추천']);
    let [like, changeLike] = useState(0); 

    //let blogTitle = 'Blog';
    //let navContentStyle={color:'white', fontSize:'30px'};

    // 기본적으로 state 와 같은 기본 자료형은 call by reference Type이다. 따라서 값을 copy 할 때는 새로운 주소로 카피해야한다.
    // var newArray = title; 이는 주소 값이 같아지므로 결국 state를 고치는 문법이 된다. 
    // deep copy : state에 담긴 값을 새로운 Array 배열에 담는다.
    // react 대원칙 : immutable Data
    // ... : 중괄호 대괄호를 없앤다. [] 중괄호를 없앤 후 다시 괄호에 넣기 위함이다.
    function hookTitle(){
        var newArray = [...title]; 
        newArray[0] = '여자 코트 추천';
        changeTitle(newArray);
    }

    return(
        <div className='board'>
            <div> Board List</div>
            <button onClick={()=>{hookTitle()}} >제목 변경</button>

            <div className="list">
                <h3>{title[0]} <span onClick={()=>{changeLike(like+1)}}>👍</span> {like} </h3>
                <p>2월 17일 발행</p>
                <hr/>
                <h3>{title[1]}</h3>
                <p>2월 18일 발행</p>
                <hr/>
                <h3>{title[2]}</h3>
                <p>2월 19일 발행</p>
                <hr/>

            </div>
            <Model/>
        </div>
    )    
    
}

//Component 만들기 
// 1. 함수 만들고 이름을 짓는다. 이름의 첫 문자는 대문자로 만든다.
// 2. 축약을 원하는 HTML 넣고
// 3. 원하는 곳에서 <함수명/>
// 장점 : 관리가 편하다.
function Model(){
    //return 안에는 하나의 html 태그만 들어올 수 있다.
  return (
      <div className="model">
        <h2>제목</h2>
        <p>날짜</p>
        <p>상세내용</p>
      </div>  
  )
}

export default Board;