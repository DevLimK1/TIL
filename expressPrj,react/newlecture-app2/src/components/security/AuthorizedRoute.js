import React, { Component } from "react";
import { Route, Redirect } from "react-router-dom";
import ctx from "./SecurityContext";

class AuthorizedRoute extends Component {
  render() {
  // component 를 새로운 변수명 Component로 쓰고싶다
    let { component:Component, ...rest } = this.props;
 
    return (
      <Route {...rest}
        render={props => {
          if (ctx.userName != null) return <Component {...props}/>; //위에 새로운 변수명을 지정했으니 component가 아닌 Component로 쓸 수 있겠다.
          else return <Redirect to={{
              pathname:"/joinus/member/login",
              state:{
                  from:props.location // /admin/notice/list
              }
          }}/>;
        }}
      />
      // <Route path={path} component={component}/>
      // <Route path={path} render={()=><h1>하하하하</h1>}/>
      //   <Redirect to="/joinus/member/login" />
    );
  }
}

export default AuthorizedRoute;
