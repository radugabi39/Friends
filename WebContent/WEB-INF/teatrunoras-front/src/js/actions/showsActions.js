import axios from "axios";

export function fetchShows() {
  return function(dispatch) {
    axios.get("http://localhost:8081/Friends/shows/getAllShows")
      .then((response) => {
        dispatch({type: "FETCH_SHOWS_FULFILLED", payload: response.data})
      })
      .catch((err) => {
        dispatch({type: "FETCH_SHOWS_REJECTED", payload: err})
      })
  }
}

export function fetchSingleShow(id) {
	return {
		type: 'FETCH_SHOW',
		payload: id
	};
}