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
    }

    return state;
}
