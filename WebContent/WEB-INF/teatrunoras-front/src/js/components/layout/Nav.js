import React from "react";
import { IndexLink, Link } from "react-router";
import { connect } from "react-redux"
import cookie from 'react-cookie';
import { setCurrentUser } from '../../actions/authActions';

@connect((store) => {
  return {
    user: store.auth.user,
    userAuthenticated: store.auth.isAuthenticated
  };
})

export default class Nav extends React.Component {
  constructor() {
    super()
    this.state = {
      collapsed: true,
    };

    this.handleLogout = this.handleLogout.bind(this);
  }

  toggleCollapse() {
    const collapsed = !this.state.collapsed;
    this.setState({collapsed});
  }

  handleLogout(event) {
    event.preventDefault();
    cookie.remove('loginToken', []);
    cookie.remove('loginUsername', []);
    this.props.dispatch(setCurrentUser(''));
    window.location.href = "http://localhost:8080/";
  }

  render() {
    const { location } = this.props;
    const { collapsed } = this.state;
    const navClass = collapsed ? "collapse" : "";
    var loginLi = (
      <li activeClassName="active">
        <Link to="profile" onClick={this.toggleCollapse.bind(this)}>Login</Link>
      </li>
    );
    if (cookie.load('loginUsername')) {
      loginLi = (
        <li>
          <Link to="/" onClick={this.handleLogout}>Logout</Link>
        </li>)
      ;
    }

    return (
      <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" onClick={this.toggleCollapse.bind(this)} >
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
          </div>
          <div class={"navbar-collapse " + navClass} id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
              <li activeClassName="active" onlyActiveOnIndex={true}>
                <IndexLink to="/" onClick={this.toggleCollapse.bind(this)}>Home</IndexLink>
              </li>
              <li activeClassName="active">
                <Link to="shows" onClick={this.toggleCollapse.bind(this)}>Shows</Link>
              </li>
              {loginLi}
            </ul>
          </div>
        </div>
      </nav>
    );
  }
}

