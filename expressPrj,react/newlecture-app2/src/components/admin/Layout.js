import React from "react";
import {Switch,Route}  from 'react-router-dom';
import NoticeList from './notice/List';
import NoticeDetail from './notice/Detail';
import EventList from './event/List';

// component 는
// 클래스 - status, props
// 함수로 만들 수 있다.

const Customer = () => {
  return (
    <div>
      {/* // <!----------------------------- <visual> -----------------------------------------> */}
      {/* // <!-- visual 부분 --> */}

      <div id="visual">
        <div className="content-container"></div>
      </div>
      {/* // <!-- --------------------------- <body> --------------------------------------- --> */}
      <div id="body">
        <div className="content-container clearfix">
          {/* <!-- --------------------------- aside --------------------------------------- -->
                <!-- aside 부분 --> */}

         
			<aside class="aside">
				<h1>ADMIN PAGE</h1>

				<nav class="menu text-menu first margin-top">
					<h1>마이페이지</h1>
					<ul>
						<li><a href="/admin/index.html">관리자홈</a></li>
						<li><a href="/teacher/index.html">선생님페이지</a></li>
						<li><a href="/student/index.html">수강생페이지</a></li>
					</ul>
				</nav>

				<nav class="menu text-menu">
					<h1>알림관리</h1>
					<ul>
						<li><a href="/admin/board/notice/list.html">공지사항</a></li>
					</ul>
				</nav>

			</aside>

          {/* ----------------main ------------- */}
          <Switch>
            <Route exact path="/admin/notice/list" component={NoticeList}/>
            <Route exact path="/admin/notice/:id" component={NoticeDetail}/>
            <Route exact path="/admin/event/list" component={EventList}/>
          </Switch>
              
        </div>
      </div>
    </div>
  );
};

export default Customer;
