import React, { Component } from "react";
import { Route, Redirect } from "react-router-dom";
import ctx from "./SecurityContext";

class AuthorizedRoute extends Component {
  render() {
    let { component, ...rest } = this.props;

    return (
      <Route {...rest}
        render={props => {
          if (ctx.userName != null) return <Component {...props}/>;
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
