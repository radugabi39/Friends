import axios from "axios";

export function fetchReviewsForShow(id) {
  return function(dispatch) {
    axios.get("http://localhost:8081/Friends/review/getReviewByShowId/" + id)
      .then((response) => {
        dispatch({type: "FETCH_REVIEWS_FULFILLED", payload: response.data})
      })
      .catch((err) => {
        dispatch({type: "FETCH_REVIEWS_REJECTED", payload: err})
      })
  }
}