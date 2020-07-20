import React, { Component } from "react";
import ctx from "../../security/SecurityContext";

class Login extends Component {
    constructor(props) {
        super(props);
        
        this.state={
            uid:"",
            pwd:""
        }
    }
    
  
    loginButtonClick(e) {
    e.preventDefault();
    
    // let ctx=new SecurityContext();
    // ctx.userName="newlec"; //getter 함수가 호출된거임 
    console.log(ctx.userName);

    //아이디와 비번이 일치하는지를 알아보는 서비스가 있어야하고
    fetch(`http://localhost:8080/api/member/validate?uid=${this.state.uid}&pwd=${this.state.pwd}`)
    .then((response) => {
      return response.json();
    })
    .then((json) => {
      if(!json.result)
        alert('아이디 또는 비번이 일치하지 않습니다.');
      else
        ctx.userName=this.state.uid; 

      let returnURL=this.props.location.state.from;
      console.log(returnURL);
      if(returnURL)
        this.props.history.push(returnURL); //admin/notice/list
      else
        this.props.history.push("/index");
      
    });
    //다른 곳으로 가려다가 걸려서 여기로 온 경우
    // this.props.history.push(returnURL);

    // 그 결과가 참이면
    // this.props.history.push("/index");
    //그 결과가 참이 아니면
    // alert("머야 틀렸자나");
    //window.location.href="";
  }

  render() {
    return (
      <main>
        <h2 clasName="main title">로그인</h2>

        <div clasName="breadcrumb">
          <h3 clasName="hidden">breadlet</h3>
          <ul>
            <li>home</li>
            <li>회원</li>
            <li>로그인</li>
          </ul>
        </div>

        <div clasName="margin-top first">
          <h3 clasName="hidden">로그인 정보 입력</h3>
          <form clasName="login-form" method="post">
            <fieldset>
              <legend clasName="hidden">로그인 폼</legend>
              <h4>
                <img src="../images/member/txt-title.png" />
              </h4>
              <ul clasName="login-box">
                <li>
                  <label for="uid">아이디</label>
                  <input type="text" name="username" placeholder="아이디" value={this.state.uid} onInput={e=>this.setState({uid:e.target.value})}/>
                </li>
                <li>
                  <label for="pwd">비밀번호</label>
                  <input
                    type="password"
                    name="password"
                    placeholder="비밀번호" value={this.state.pwd}onInput={e=>this.setState({pwd:e.target.value})}
                  />
                </li>
              </ul>

              <div clasName="login-btn-box">
                <input
                style={{width:"50px"}}
                  type="submit"
                  clasName="btn login-btn"
                  onClick={this.loginButtonClick.bind(this)}
                />
              </div>
              <ul clasName="login-option">
                <li>
                  <span>아이디 또는 비밀번호를 분실하셨나요?</span>
                  <a href="find-id">
                    <img
                      alt="ID/PWD 찾기"
                      src="../images/member/btn-find.png"
                    />
                  </a>
                </li>
                <li clasName="margin-top">
                  <span>아이디가 없으신 분은 회원가입을 해주세요.</span>
                  <a href="agree">
                    <img alt="회원가입" src="../images/member/btn-join.png" />
                  </a>
                </li>
              </ul>
            </fieldset>
          </form>
        </div>
      </main>
    );
  }
}

export default Login;
