export default function reducer(state={
    shows: [],
    fetching: false,
    fetched: false,
    error: null,
  }, action) {

    switch (action.type) {
      case "FETCH_SHOWS": {
        return {...state, fetching: true};
      }

      case "FETCH_SHOWS_REJECTED": {
        return {...state, fetching: false, error: action.payload}
      }

      case "FETCH_SHOWS_FULFILLED": {
        return {
          ...state,
          fetching: false,
          fetched: true,
          shows: action.payload,
        }
      }

      case "FETCH_SHOW": {
        return {
          shows: state.shows.filter(show => show.id == action.payload)
        };
      }
    }

    return state;
}
