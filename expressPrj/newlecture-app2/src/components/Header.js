import React from 'react';
import {Link} from 'react-router-dom';

const Header=()=>{
    return (
        <header id="header">
        
        <div className="content-container">
            {/* <!-- ---------------------------<header>--------------------------------------- --> */}

            <h1 id="logo">
                <a href="/index.html">
                    <img src="/images/logo.png" alt="뉴렉처 온라인" />

                </a>
            </h1>

            <section>
                <h1 className="hidden">헤더</h1>

                <nav id="main-menu">
                    <h1>메인메뉴</h1>
                    <ul>
                        <li><a href="/guide">학습가이드</a></li>

                        <li><a href="/course">강좌선택</a></li>
                        <li><a href="/answeris/index">AnswerIs</a></li>
                    </ul>
                </nav>

                <div className="sub-menu">

                    <section id="search-form">
                        <h1>강좌검색 폼</h1>
                        <form action="/course">
                            <fieldset>
                                <legend>과정검색필드</legend>
                                <label>과정검색</label>
                                <input type="text" name="q"  />
                                <input type="submit" value="검색" />
                            </fieldset>
                        </form>
                    </section>

                    <nav id="acount-menu">
                        <h1 className="hidden">회원메뉴</h1>
                        <ul>
                            <li><Link to="/">HOME</Link></li>
                            <li><a href="/member/login.html">로그인</a></li>
                            <li><a href="/member/agree.html">회원가입</a></li>
                        </ul>
                    </nav>

                    <nav id="member-menu" className="linear-layout">
                        <h1 className="hidden">고객메뉴</h1>
                        <ul className="linear-layout">
                            <li><a href="/member/home"><img src="/images/txt-mypage.png" alt="마이페이지" /></a></li>
                            <li><Link to="/customer"><img src="/images/txt-customer.png" alt="고객센터" /></Link></li>
                        </ul>
                    </nav>

                </div>
            </section>

        </div>
        
    </header>

    );
}

export default Header;