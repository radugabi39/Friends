import React from "react";

import { postRating } from "../actions/reviewsActions.js";

export default class Review extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      selectValue: 1
    };


    this.handleSelectChange = this.handleSelectChange.bind(this);
    this.handleSelectSubmit = this.handleSelectSubmit.bind(this);
  }

  handleSelectChange(event) {
    this.setState({selectValue: event.target.value});
  }

  handleSelectSubmit(event) {
    this.props.onSubmit(this.state.selectValue); 
    event.preventDefault();
  }

  render() {
    return (
      <li>
        <div>
          <h5>Review with RATING ({this.props.rating}) and ID ({this.props.id})</h5>

          <form id={'form-review' + this.props.id} onSubmit={this.handleSelectSubmit}>
            <label>
              Pick rating:
              <select className="form-control" value={this.state.selectValue} onChange={this.handleSelectChange}>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
              </select>
            </label>
            <input className="btn btn-primary" type="submit" value="Vote" />
          </form>

          <div>
            {this.props.description}
          </div>
        </div>
      </li>
    );
  }
}