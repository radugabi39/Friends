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
      selectValues: [],
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

  postRatingForReview(reviewId, rating) {
    return this.props.dispatch(postRating(reviewId, rating)); 
  }

  render() {
    const { show, reviews } = this.props;

    var mappedReviews;
    if (typeof reviews.list === 'undefined' || reviews.list[0] === null) {
      mappedReviews = [];
    }
    else {
      mappedReviews = reviews.list.map(review => 
        <li key={review.id}>
          <div>
            <div>
              {review.description}
            </div>

            <div className="ratingBarWrapper">
              <div className="ratingBar">
                <div className="ratingBarClickable">
                  <span className="glyphicon glyphicon-star" onClick={(reviewId, rating) => this.postRatingForReview(review.id, 5)}></span>
                  <span className="glyphicon glyphicon-star" onClick={(reviewId, rating) => this.postRatingForReview(review.id, 4)}></span>
                  <span className="glyphicon glyphicon-star" onClick={(reviewId, rating) => this.postRatingForReview(review.id, 3)}></span>
                  <span className="glyphicon glyphicon-star" onClick={(reviewId, rating) => this.postRatingForReview(review.id, 2)}></span>
                  <span className="glyphicon glyphicon-star" onClick={(reviewId, rating) => this.postRatingForReview(review.id, 1)}></span>
                </div>
                <div className="ratingBarOverlay" style={{width: (review.rating / 5 * 100).toString() + '%'}}>
                  <div className="ratingBarOverlayInner">
                    <span className="glyphicon glyphicon-star"></span>
                    <span className="glyphicon glyphicon-star"></span>
                    <span className="glyphicon glyphicon-star"></span>
                    <span className="glyphicon glyphicon-star"></span>
                    <span className="glyphicon glyphicon-star"></span>
                  </div>
                </div>
              </div> 
              
              <div className="noVotes">
                {review.noVotes + ' voturi'} 
              </div>
            </div>
          </div>
        </li>  
      );
    }

    return (
      <div className="single-show-container">
        
        <div className="page-header">
          <h1>{show.name}</h1>
        </div>

        <div className="well">
          {show.description}
        </div>

        <div>
          <h2>Reviews</h2>
          <ul className="reviews">{mappedReviews}</ul>
        </div>

        <form onSubmit={this.handleSubmit} className="add-review-form well">
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