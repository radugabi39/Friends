import axios from 'axios';
import setAuthorizationToken from '../utils/setAuthorizationToken';
import { SET_CURRENT_USER } from './types';
import cookie from 'react-cookie';
import { browserHistory } from 'react-router'

export function setCurrentUser(user) {
  return {
    type: SET_CURRENT_USER,
    user
  };
}

export function logout() {
  return dispatch => {
    localStorage.removeItem('jwtToken');
    setAuthorizationToken(false);
    dispatch(setCurrentUser({}));
  }
}

export function login(data) {
  const username = data.identifier;
  const password = data.password;
  return dispatch => {
    var data={"password": password,"username": username}
    return axios.post('http://localhost:8081/Friends/authentication/login', data)
    .then(res => {
      const token = res.data;
      const expireDate = new Date();
      expireDate.setMinutes(expireDate.getMinutes() + 30);
      setTimeout(function(){alert("Session expired!")}, expireDate);
      cookie.save('loginToken', token, { path: '/', expires: expireDate });
      cookie.save('loginUsername', username, { path: '/', expires: expireDate});
      setAuthorizationToken(token);
      dispatch(setCurrentUser(cookie.load('loginUsername')));
      window.location.href = "http://localhost:8080/";
      // browserHistory.push('/');
    });
  }
}
