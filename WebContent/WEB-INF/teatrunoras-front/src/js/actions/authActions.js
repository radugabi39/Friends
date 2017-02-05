import axios from 'axios';
import setAuthorizationToken from '../utils/setAuthorizationToken';
// import jwtDecode from 'jwt-decode';
import { SET_CURRENT_USER } from './types';
import cookie from 'react-cookie';

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
  return dispatch => {
    var data={"password":"test","username":"testerUsername"}
    var auth={ 'Authorization': 'tokenAxis' } ;
    return axios.post('http://localhost:8081/Friends/authentication/login', data)
    .then(res => {
      const token = res.data;
      // localStorage.setItem('jwtToken', token);
      cookie.save('loginToken', token, { path: '/' });
      setAuthorizationToken(token);
      // dispatch(setCurrentUser(jwtDecode(token)));
    });
  }
}
