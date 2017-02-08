export default function reducer(state={
    items: [],
    fetching: false,
    fetched: false,
    error: null,
  }, action) {

    switch (action.type) {
      case "FETCH_ITEMS_REJECTED": {
        return {...state, fetching: false, error: action.payload}
      }

      case "FETCH_ITEMS_FULFILLED": {
        return {
          ...state,
          fetching: false,
          fetched: true,
          items: action.payload,
        }
      }
    }

  return state;
}
