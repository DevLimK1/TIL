import React from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import logo from "./logo.svg";
import "./App.css";
import Header from "./components/Header";
import Footer from "./components/Footer";
import Root from "./components/Root";
import Customer from "./components/customer/Layout";

function App() {
  return (
    <Router>
      <div className="App">
        <Header />
        <Switch>
          <Route exact path="/" component={Root} />
          <Route exact path="/customer" component={Customer} />
        </Switch>
        <Footer />
      </div>
    </Router>
  );
}

export default App;
