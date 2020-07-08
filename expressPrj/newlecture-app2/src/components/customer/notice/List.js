import React from 'react';

const List=()=>{
    return(
    <main className="main">
         <h2 className="main title">공지사항</h2>
         
         <div className="breadcrumb">
             <h3 className="hidden">경로</h3>
             <ul>
                 <li>home</li>
                 <li>고객센터</li>
                 <li>공지사항</li>
             </ul>
         </div>
         
         <div className="search-form margin-top first align-right">
             <h3 className="hidden">공지사항 검색폼</h3>
             <form className="table-form">
                 <fieldset>
                     <legend className="hidden">공지사항 검색 필드</legend>
                     <label className="hidden">검색분류</label>
                     <select name="f">
                         <option  value="title">제목</option>
                         <option  value="writerId">작성자</option>
                     </select> 
                     <label className="hidden">검색어</label>
                     <input type="text" name="q" value=""/>
                     <input className="btn btn-search" type="submit" value="검색" />
                 </fieldset>
             </form>
         </div>
         
         <div className="notice margin-top">
             <h3 className="hidden">공지사항 목록</h3>
             <table className="table">
                 <thead>
                     <tr>
                         <th className="w60">번호</th>
                         <th className="expand">제목</th>
                         <th className="w100">작성자</th>
                         <th className="w100">작성일</th>
                         <th className="w60">조회수</th>
                     </tr>
                 </thead>
                 <tbody>
                         
                 <tr>
                     <td>8</td>
                     <td className="title indent text-align-left"><a href="detail.html">스프링 8강까지의 예제 코드</a></td>
                     <td>newlec</td>
                     <td>
                         2019-08-18		
                     </td>
                     <td>146</td>
                 </tr>
                         
                 <tr>
                     <td>7</td>
                     <td className="title indent text-align-left"><a href="detail.html">스프링 DI 예제 코드</a></td>
                     <td>newlec</td>
                     <td>
                         2019-08-15		
                     </td>
                     <td>131</td>
                 </tr>
                         
                 <tr>
                     <td>6</td>
                     <td className="title indent text-align-left"><a href="detail.html">뉴렉쌤 9월 초 국기과정 모집 안내</a></td>
                     <td>newlec</td>
                     <td>
                         2019-06-11		
                     </td>
                     <td>517</td>
                 </tr>
                         
                 <tr>
                     <td>5</td>
                     <td className="title indent text-align-left"><a href="detail.html">뉴렉처 강의 수강 방식 안내</a></td>
                     <td>newlec</td>
                     <td>
                         2019-05-24		
                     </td>
                     <td>448</td>
                 </tr>
                         
                 <tr>
                     <td>4</td>
                     <td className="title indent text-align-left"><a href="detail.html">자바 구조적인 프로그래밍 강의 예제 파일</a></td>
                     <td>newlec</td>
                     <td>
                         2019-04-24		
                     </td>
                     <td>520</td>
                 </tr>
                 
                 
                 </tbody>
             </table>
         </div>
         
         <div className="indexer margin-top align-right">
             <h3 className="hidden">현재 페이지</h3>
             <div><span className="text-orange text-strong">1</span> / 1 pages</div>
         </div>

         <div className="margin-top align-center pager">	
     
 <div>
     
     
     <span className="btn btn-prev" >이전</span>
     
 </div>
 <ul className="-list- center">
     <li><a className="-text- orange bold" href="?p=1&t=&q=" >1</a></li>
             
 </ul>
 <div>
     
     
         <span className="btn btn-next" >다음</span>
     
 </div>
 
         </div>
     </main>
     );
};

export default List;