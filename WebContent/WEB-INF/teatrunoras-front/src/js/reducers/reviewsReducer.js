var _ = require('lodash');

export default function reducer(state={
    reviews: [],
    fetching: false,
    fetched: false,
    error: null,
  }, action) {

    switch (action.type) {
      case "FETCH_REVIEWS": {
        return {...state, fetching: true};
      }

      case "FETCH_REVIEWS_REJECTED": {
        return {...state, fetching: false, error: action.payload}
      }

      case "FETCH_REVIEWS_FULFILLED": {
        return {
          ...state,
          fetching: false,
          fetched: true,
          reviews: action.payload,
        }
      }

      case "POST_REVIEW_FULFILLED": {
        var obj = JSON.parse(action.payload);

        var newReviews = [...state.reviews.list];
        newReviews.push({
          description: obj.description
        });
        var newState = _.assign({}, state, {reviews: {list: newReviews}});

        return {
          ...newState
        }
      }

      case "POST_RATING_FULFILLED": {
        let obj = JSON.parse(action.payload);

        let newReviews = _.assign({}, state.reviews);
        for(var i=0; i < newReviews.list.length; i++) {
          if (newReviews.list[i].id === obj.reviewId) {
            if (newReviews.list[i].rating === null) {
              newReviews.list[i].rating = 0;
            }
            newReviews.list[i].rating = Math.round((newReviews.list[i].rating * newReviews.list[i].noVotes + obj.rating ) / (newReviews.list[i].noVotes + 1) * 100) / 100;
            newReviews.list[i].noVotes ++;
          }
        }

        let newState = _.assign({}, state);
        newState.reviews = newReviews;

        return {...newState}
      }
    }

    return state;
}
