import React from "react";
import ReactDOM from "react-dom";
import { Router, Route, IndexRoute, hashHistory } from "react-router";
import { Provider } from "react-redux";

import Home from "./pages/Home";
import Layout from "./pages/Layout";
import Profile from "./pages/Profile";
import Shows from "./pages/Shows";

import store from "./store";

const app = document.getElementById('app');

ReactDOM.render(
  <Provider store={store}>
    <Router history={hashHistory}>
      <Route path="/" component={Layout}>
        <IndexRoute component={Home}></IndexRoute>
        <Route path="shows" name="shows" component={Shows}></Route>
        <Route path="profile" name="profile" component={Profile}></Route>
      </Route>
    </Router>
    </Provider>,
app);
