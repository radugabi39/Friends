import React from "react";
import { IndexLink, Link } from "react-router";

export default class Show extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div>
        <li className="col-md-4 homeRecentShowsLi">
          <div style={{backgroundImage: 'url(' + this.props.avatar + ')'}} className="homeRecentShowsLiContainer">
            <div className="homeRecentShowsLink">
              <div className="grayOverlay">
                <Link to={"show/" + this.props.id}>
                  {this.props.name}
                </Link>
              </div>
            </div>
          </div>
        </li>
      </div>
    );
  }
}
