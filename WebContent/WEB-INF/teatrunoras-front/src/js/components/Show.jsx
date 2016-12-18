import React from "react";
import { IndexLink, Link } from "react-router";

export default class Show extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      id: '',
      name: '',
      description: ''
    };
  }

  render() {
    return (
      <div>
        <Link to={"show/" + this.props.id}>
          <h3>{this.props.name}</h3>
        </Link>

        <div>{this.props.description}</div>
      </div>
    );
  }
}
