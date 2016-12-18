import React from "react";
import { connect } from "react-redux"

import { fetchSingleShow } from "../actions/showsActions.js";
import { fetchReviewsForShow } from "../actions/reviewsActions.js";

@connect((store) => {
  return {
    show: store.shows.shows,
    reviews: store.reviews.reviews,
  };
})

export default class Shows extends React.Component {
  fetchShowAndReviews(id) {
    return dispatch => Promise.all([
      dispatch(fetchSingleShow(id)),
      dispatch(fetchReviewsForShow(id)),
    ]);
  }

  componentDidMount() {
    this.props.dispatch(this.fetchShowAndReviews(this.props.params['id']));
    // this.props.dispatch(fetchReviewsForShow(this.props.params['id']));
  }

  render() {
    const { show, reviews } = this.props;
    console.log(this.props);
    console.log(show);
    console.log(reviews.list);

    var mappedReviews;
    if (typeof reviews.list === 'undefined') {
      mappedReviews = [];
    }
    else {
      mappedReviews = reviews.list.map(review => <li>{review.description}</li>);
    }

    // return <div>123</div>;
    return (
      <div>
        <h3>{show.name}</h3>

        <div>
          <h4>Description</h4>
          {show.description}
        </div>

        <div>
          <h4>Reviews: </h4>
          <ul>{mappedReviews}</ul>
        </div>
      </div>
    );
  }
}
