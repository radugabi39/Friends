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

      case "BUY_ITEM_FULFILLED": {
        let itemId = action.payload;
        let newItems = _.assign({}, state.items);
        for(var i=0; i < newItems.list.length; i++) {
          if (itemId === newItems.list[i].id) {
            newItems.list[i].stock--;
          }
        }

        let newState = _.assign({}, state);
        newState.items = newItems;

        return {...newState};
      }
    }

  return state;
}
