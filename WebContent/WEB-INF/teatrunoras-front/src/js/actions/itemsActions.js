import axios from "axios";

export function fetchItems() {
  return function(dispatch) {
    axios.get("http://localhost:8081/Friends/item/getItems")
      .then((response) => {
        dispatch({type: "FETCH_ITEMS_FULFILLED", payload: response.data})
      })
      .catch((err) => {
        dispatch({type: "FETCH_ITEMS_REJECTED", payload: err})
      })
  }
}

export function buyItem(itemId) {
	return function(dispatch) {
		axios.post("http://localhost:8081/Friends/item/buyItem", itemId,
			{
				headers: {
					"Content-Type": "application/json",
					"Access-Control-Allow-Origin": "*"
				}
			})
			.then(function (response) {
			  dispatch({type: "BUY_ITEM_FULFILLED", payload: itemId});
			})
		  .catch((err) => {
		    dispatch({type: "BUY_ITEM_REJECTED", payload: err})
		  })
	}
}