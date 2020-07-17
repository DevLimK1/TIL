import React from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import logo from "./logo.svg";
import "./App.css";
import Header from "./components/Header";
import Footer from "./components/Footer";
import Root from "./components/Root";
import Customer from "./components/customer/Layout";
import Admin from "./components/admin/Layout";
import Joinus from "./components/joinus/Layout";
import AuthorizedRoute from "./components/security/AuthorizedRoute";


function App() {
  return (
    <Router>
      <div className="App">
        <Header />
        <Switch>
          <Route exact path="/" component={Root} />
          <Route path="/customer" component={Customer} />
          <AuthorizedRoute path="/admin" component={Admin} />
          <Route path="/joinus" component={Joinus} />
        </Switch>
        <Footer />
      </div>
    </Router>
  );
}

export default App;
