import React from "react";
import ReactDOM from "react-dom";
import { Router, Route, IndexRoute, hashHistory } from "react-router";
import { Provider } from "react-redux";
import cookie from 'react-cookie';
import setAuthorizationToken from './utils/setAuthorizationToken';

import Home from "./pages/Home";
import Layout from "./pages/Layout";
import Profile from "./pages/Profile";
import Shows from "./pages/Shows";
import Show from "./pages/Show.jsx";

import store from "./store";

import "../../node_modules/react-image-gallery/styles/css/image-gallery.css";

const app = document.getElementById('app');

if (cookie.load('loginToken')) {
  setAuthorizationToken(cookie.load('loginToken'));
}

ReactDOM.render(
  <Provider store={store}>
    <Router history={hashHistory}>
      <Route path="/" component={Layout}>
        <IndexRoute component={Home}></IndexRoute>
        <Route path="shows" name="shows" component={Shows}></Route>
        <Route path="show/:id" name="show" component={Show}></Route>
        <Route path="profile" name="profile" component={Profile}></Route>
      </Route>
    </Router>
  </Provider>,
app);
