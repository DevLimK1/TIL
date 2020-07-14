import React, { Component } from "react";

class Pager extends Component {
  constructor(props) {
    super(props);
    // constructor에서 state를 설정해줘야 setState를 사용할 수 있다.

    let { page, count, onPageClick } = props;

    this.state = {
      nums: [1, 2, 3, 4, 5],
      count, //enhanced object literal
      page,
      onPageClick,
    };

    console.log(this.state);
  }
  pageClick(e) {
    e.preventDefault(); //이벤트 기본 행위들 막는다. 링크 이동등등
    console.log(e.target);
    let n=e.target.innerText;
    console.log(n);
    this.props.onPageClick({ num: n }); //위임 , a태그를 누르면 실행됨
  }


  render() {
    let pages = this.state.nums.map((n) => (
      <li>
        <a
          className={11}
          href="?p={n}&f=&q="
          onClick={this.pageClick.bind(this)}
        >
          {n}
        </a>
      </li>
    ));

    return (
      <div className="margin-top align-center pager">
        <div>
          <span className="btn btn-prev">이전</span>
        </div>
        <ul className="-list- center">
          {/* react에서 사용하는 건 다 객체다. */}
          {pages}
        </ul>
        <div>
          <span className="btn btn-next">다음</span>
        </div>
      </div>
    );
  }
}

export default Pager;
