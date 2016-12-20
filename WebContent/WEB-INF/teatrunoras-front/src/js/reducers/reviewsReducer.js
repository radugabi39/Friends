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
    }

    return state;
}
