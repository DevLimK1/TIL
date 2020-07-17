import React from "react";
import { Switch, Route } from "react-router-dom";
import Login from "./member/Login";
import Join from "./member/Join";
import Agree from "./member/Agree";

const Customer = () => {
  return (
    <div>
      <div id="visual">
        <div className="content-container"></div>
      </div>
      {/* <!-- --------------------------- <body> --------------------------------------- --> */}
      <div id="body">
        <div className="content-container clearfix">
          {/* <!-- --------------------------- aside --------------------------------------- --> */}
          {/* <!-- aside 부분 --> */}

          <aside className="aside">
            <h1>회원가입</h1>

            <nav className="menu text-menu first margin-top">
              <h1>회원메뉴</h1>
              <ul>
                <li>
                  <a href="/member/login.html">로그인</a>
                </li>
                <li>
                  <a href="/member/join.html">회원가입</a>
                </li>
                <li>
                  <a href="/member/">아이디찾기</a>
                </li>
                <li>
                  <a href="/member/t">비밀번호 재발급</a>
                </li>
              </ul>
            </nav>

            <nav className="menu">
              <h1>협력업체</h1>
              <ul>
                <li>
                  <a target="_blank" href="http://www.notepubs.com">
                    <img src="../images/notepubs.png" alt="노트펍스" />
                  </a>
                </li>
                <li>
                  <a target="_blank" href="http://www.namoolab.com">
                    <img src="../images/namoolab.png" alt="나무랩연구소" />
                  </a>
                </li>
              </ul>
            </nav>
          </aside>

          {/* main 영역 */}
          <Switch>
            <Route exact path="/joinus/member/login" component={Login} />
            <Route exact path="/joinus/member/join" component={Join} />
            <Route exact path="/joinus/member/agree" component={Agree} />
          </Switch>
        </div>
      </div>
    </div>
  );
};

export default Customer;
