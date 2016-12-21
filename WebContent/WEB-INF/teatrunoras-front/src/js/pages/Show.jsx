import React from "react";
import { connect } from "react-redux"

import { fetchSingleShow } from "../actions/showsActions.js";
import { fetchReviewsForShow } from "../actions/reviewsActions.js";
import { postReview } from "../actions/reviewsActions.js";
import { postRating } from "../actions/reviewsActions.js";

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
      value: '',
      selectValue: 1
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleSelectChange = this.handleSelectChange.bind(this);
    this.handleSelectSubmit = this.handleSelectSubmit.bind(this);
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

  handleSelectChange(event) {
    this.setState({selectValue: event.target.value});
  }

  handleSelectSubmit(event) {
    event.preventDefault();
    this.props.dispatch(postRating(54, 1));
    this.setState({value: ''});
  }

  render() {
    const { show, reviews } = this.props;

    var mappedReviews;
    if (typeof reviews.list === 'undefined') {
      mappedReviews = [];
    }
    else {
      mappedReviews = reviews.list.map(review => 
        <li>
          <div>
            <h5>Review with rating: {review.rating}</h5>

            <form id={'form-review' + review.id} onSubmit={this.handleSelectSubmit}>
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
              {review.description}
            </div>
          </div>
        </li>);
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