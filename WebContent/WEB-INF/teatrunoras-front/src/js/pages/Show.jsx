import React from "react";
import { connect } from "react-redux"

import { fetchSingleShow } from "../actions/showsActions.js";
import { fetchReviewsForShow } from "../actions/reviewsActions.js";
import { postReview } from "../actions/reviewsActions.js";

@connect((store) => {
  return {
    show: store.shows.shows,
    reviews: store.reviews.reviews,
  };
})

export default class Shows extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      value: ''
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  fetchShowAndReviews(id) {
    return dispatch => Promise.all([
      dispatch(fetchSingleShow(id)),
      dispatch(fetchReviewsForShow(id)),
    ]);
  }

  componentDidMount() {
    this.props.dispatch(this.fetchShowAndReviews(this.props.params['id']));
  }

  handleChange(event) {
    this.setState({value: event.target.value});
  }

  handleSubmit(event) {
    event.preventDefault();
    this.props.dispatch(postReview(this.props.params['id'], this.state.value));
    this.setState({value: ''});
  }

  render() {
    const { show, reviews } = this.props;

    var mappedReviews;
    if (typeof reviews.list === 'undefined') {
      mappedReviews = [];
    }
    else {
      mappedReviews = reviews.list.map(review => <li>{review.description}</li>);
    }

    return (
      <div className="single-show-container">
        <h3>{show.name}</h3>

        <div>
          <h4>Description</h4>
          {show.description}
        </div>

        <div>
          <h4>Reviews: </h4>
          <ul>{mappedReviews}</ul>
        </div>

        <form onSubmit={this.handleSubmit} className="add-review-form">
          <label>
            <p>Add Review:</p>
            <textarea className="form-control" value={this.state.value} onChange={this.handleChange} />
          </label>
          <input className="btn btn-primary" type="submit" value="Submit Review" />
        </form>
      </div>
    );
  }
}