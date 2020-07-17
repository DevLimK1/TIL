import React, { Component } from "react";

class Agree extends Component {
  render() {
    return (
      <main>
        <h2 clasName="main title">가입동의</h2>

        <div clasName="breadcrumb" style={{marginTop:"-20px"}}>
          <h3 clasName="hidden">경로</h3>
          <img src="../images/member/step1.png" alt="회원가입 1단계" />
        </div>

        <div clasName="margin-top first">
          <div clasName="bg-light-gray border-gray padding" >
            <div clasName="padding font-size-13 text-strong">
              뉴렉쳐의 <span clasName="text-orange">개인정보 수집 및 이용</span>
              에 대한 안내입니다. 불편하신 사항이 없으시도록 꼭 읽어주시기
              바랍니다.
            </div>
            <div clasName="agree-content">
              <textarea style={{width:"100%" , height: "300px"}}>
                [ 이용약관 제1장 - 총칙 ]
              </textarea>
            </div>
          </div>

          <form action="agree" method="post" clasName="margin-top">
            <div>
              <input type="checkbox" name="agree" value="true" /> 약관에
              동의합니다.
            </div>
            <div clasName="margin-top text-align-center">
              <input type="hidden" name="" />
              <input
                id="submit-button"
                className="btn-text btn-default"
                style={{height: "40px" , width: "100px" ,fontSize: "13px"}}
                type="submit"
                value="다음"
              />
            </div>
          </form>
        </div>
      </main>
    );
  }
}
export default Agree;
